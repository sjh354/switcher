"""switcher_protocol.py 검증 — 앱 원본 식을 파이썬으로 다시 계산해 대조한다.
실행: python test_protocol.py   (bleak/기기/블루투스 전부 불필요)
"""
from datetime import datetime

from switcher_protocol import (
    EMPTY_SLOT, Reservation, add_timer_packet, clock_bytes, parse_adv,
    parse_clock, parse_firmware, parse_reservations, remove_timer_packet,
    reservation_record, timer_version,
)

NOW = datetime(2026, 9, 8, 14, 32, 7)   # 화요일 14시32분07초


# --- 예약 레코드 6B — Switcher.java:267-292 --------------------------------
def java_record(slot, days, hour, minute, target, on, enable):
    """앱 getResrvDataForBLE()를 문자열 연산까지 그대로 재현."""
    bits = "".join("1" if d in days else "0" for d in range(7)) + ("1" if enable else "0")
    hexstr = (f"{slot:02x}" + f"{int(bits, 2):02x}" + f"{hour:02x}"
              + f"{minute:02x}" + f"{target:02x}" + f"{0 if on else 1:02x}")
    return bytes.fromhex(hexstr)


CASES = [
    (0, {0, 1, 2, 3, 4}, 7, 30, 0, True, True),     # 평일 아침 켜기
    (9, {6}, 23, 5, 1, False, True),                # 일요일 밤 2구 끄기
    (3, set(), 0, 0, 0, True, False),               # 요일 없음 + 비활성
    (5, {0, 1, 2, 3, 4, 5, 6}, 12, 59, 1, True, True),
]

for args in CASES:
    slot, days, hour, minute, target, on, enable = args
    r = Reservation(slot=slot, hour=hour, minute=minute, days=days,
                    target=target, on=on, enable=enable)
    assert reservation_record(r) == java_record(*args), args
    assert len(reservation_record(r)) == 6, args

# 비트 배치 확인: 비트7=월 … 비트1=일, 비트0=enable
assert reservation_record(Reservation(0, 0, 0, days={0}, enable=False))[1] == 0x80
assert reservation_record(Reservation(0, 0, 0, days={6}, enable=False))[1] == 0x02
assert reservation_record(Reservation(0, 0, 0, days=set(), enable=True))[1] == 0x01

# 입력 검증
for bad in (dict(slot=10, hour=0, minute=0), dict(slot=0, hour=24, minute=0),
            dict(slot=0, hour=0, minute=60), dict(slot=0, hour=0, minute=0, target=2),
            dict(slot=0, hour=0, minute=0, days={7})):
    try:
        Reservation(**bad)
    except ValueError:
        pass
    else:
        raise AssertionError(f"거부해야 함: {bad}")


# --- timerVersion 3B — Switcher.java:294-303 ------------------------------
assert timer_version(None) == b"\xff\xff\xff"
assert timer_version(NOW).hex() == "0e2007"          # README §6.1 예시 14:32:07


# --- 추가/삭제 패킷 10B — SwitcherBLEService.java:78-93 --------------------
# "00" + 예약데이터 12자 + timerVersion 6자 = 20 hex = 10바이트 (README §3의 9B는 오기)
r = Reservation(slot=0, hour=7, minute=30, days={0, 1, 2, 3, 4})
add = add_timer_packet(r, NOW)
assert len(add) == 10, add.hex()
assert add == b"\x00" + reservation_record(r) + timer_version(NOW)
assert add.hex() == "0000f9071e00000e2007", add.hex()   # 20 hex = 10B

rm = remove_timer_packet(3, NOW)
assert len(rm) == 10, rm.hex()
assert rm.hex() == "0103" + "0000000000" + "0e2007", rm.hex()
assert remove_timer_packet(3).hex().endswith("ffffff")   # 마지막 예약 삭제

# 슬롯 10은 앱이 조용히 실패하는 자리다 (§6.2) — 여기선 거부한다
for bad_slot in (10, -1):
    try:
        remove_timer_packet(bad_slot)
    except ValueError:
        pass
    else:
        raise AssertionError(f"slot {bad_slot}은 거부해야 함")


# --- 예약 읽기 50B — SwitcherProcessor.java:123-163 ------------------------
# 쓰기와 달리 id 바이트가 없고 슬롯 위치가 곧 id다 → 레코드의 뒤 5바이트만 들어간다
def make_50b(reservations):
    slots = [EMPTY_SLOT] * 10
    for r in reservations:
        slots[r.slot] = reservation_record(r)[1:]
    return b"".join(slots)


originals = sorted(
    (Reservation(slot=s, hour=h, minute=m, days=d, target=t, on=o, enable=e)
     for s, d, h, m, t, o, e in CASES),
    key=lambda r: r.slot,                 # 읽기는 슬롯 순서대로 돌아온다
)
assert parse_reservations(make_50b(originals)) == originals

# 빈 슬롯은 건너뛴다
assert parse_reservations(EMPTY_SLOT * 10) == []
one = Reservation(slot=7, hour=6, minute=15, days={5, 6})
assert parse_reservations(make_50b([one])) == [one]

# 시가 24 이상이면 앱과 동일하게 거기서 멈춘다
broken = bytearray(make_50b(originals))
broken[1 * 5 + 1] = 24          # 슬롯 1의 시 (슬롯 0은 살아남아야 함)
assert [r.slot for r in parse_reservations(bytes(broken))] == [0]

try:
    parse_reservations(b"\x00" * 49)
except ValueError:
    pass
else:
    raise AssertionError("50바이트 미만은 거부해야 함")


# --- 기기 시계 3B — BLEUtil.java:19 ---------------------------------------
# 자바: Calendar.DAY_OF_WEEK(일=1 … 토=7)에서 2를 빼고 음수면 6
def java_dow(calendar_day_of_week):
    return calendar_day_of_week - 2 if calendar_day_of_week - 2 >= 0 else 6


for day in range(1, 8):                      # 2026-09-06(일) ~ 2026-09-12(토)
    d = datetime(2026, 9, 5 + day, 9, 5)     # 9/6=일 … 9/12=토
    assert clock_bytes(d)[0] == java_dow(day), (day, clock_bytes(d)[0])

assert clock_bytes(NOW) == bytes([1, 14, 32])        # 화요일 = 1
assert parse_clock(bytes([1, 14, 32])) == (1, 14, 32)


# --- 펌웨어 3B — CharacteristicReadParser.java:52-54 -----------------------
assert parse_firmware(b"\x00\x08\x08") == "0.8.8"
assert parse_firmware(b"\x00\x06\x00") == "0.6.0"


# --- 광고 패킷 — SwitcherAdvertisementPacket.java:33-45 --------------------
# 앱이 보던 바이트열: [MAC 6B][시리얼 8B(하위 니블만)][타입 1B][timerVersion...]
full = (bytes.fromhex("d4ad8bc9607c")
        + bytes([0xA9, 0xBE, 0xCF, 0x00, 0x12, 0xE3, 0xF4, 0x56])   # 하위 니블 → 9EF02346
        + bytes([2])
        + bytes.fromhex("0e2007"))
company_id = int.from_bytes(full[:2], "little")
info = parse_adv(company_id, full[2:])
assert info.mac == "d4ad8bc9607c", info.mac
assert info.serial == "9EF02346", info.serial
assert info.gang == 2
assert info.timer_version == "0e2007"

# 앱의 substring 방식과 대조 (hex 문자 13,15,…,27 = 각 바이트의 하위 니블)
hexstr = full.hex().upper()
assert info.mac.upper() == hexstr[0:12]
assert info.serial == "".join(hexstr[i] for i in range(13, 28, 2))
assert info.gang == int(hexstr[28:30])
assert info.timer_version.upper() == hexstr[30:]

assert parse_adv(0x1234, b"\x00" * 5) is None        # 너무 짧으면 None

print("OK: 예약 10B 추가/삭제, 50B 읽기 왕복, 시계 요일, 펌웨어, 광고 패킷")
