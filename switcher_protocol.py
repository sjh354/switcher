"""Switcher BLE 프로토콜 — 순수 인코딩/파싱. stdlib만 쓴다.

bleak(=블루투스 스택)에 의존하지 않으므로 기기 없이 그대로 import·검증할 수 있다.
BLE 왕복은 switcher_core.py가 담당한다. 근거는 전부 README와 디컴파일 소스
(`switcher_decompiled/switcher_decompiled/sources/` 기준 상대경로)에 있다.
"""

from __future__ import annotations

from dataclasses import dataclass, field
from datetime import datetime

# kr/switcher/ioble/protocol/SwitcherBLEProtocol.java:7-24
_BASE = "-0000-1000-8000-00805f9b34fb"
UUID_SWITCH_SERVICE = "0000150b" + _BASE
UUID_OPERATION = "000015ba" + _BASE      # ON/OFF, 1B
UUID_STROKE = "000015bb" + _BASE         # 손가락 길이, 1B
UUID_BATTERY = "000015aa" + _BASE        # 배터리 잔량, 1B
UUID_TIMER_OP = "000015ca" + _BASE       # 예약 추가/삭제, 10B
UUID_TIMER_DATA = "000025ca" + _BASE     # 예약 데이터, 50B
UUID_FIRMWARE = "000025ea" + _BASE       # 펌웨어 버전, 3B
UUID_CLOCK = "000045ea" + _BASE          # 실시간 시계, 3B

STROKE_SHORT, STROKE_MEDIUM, STROKE_LONG = 0, 1, 2
STROKE_NAMES = {0: "짧게", 1: "중간(공장 기본)", 2: "길게"}

MAX_SLOT = 9              # IODeviceConfig.MAX_TIMER_NUM = 10, 슬롯 id는 0~9
EMPTY_SLOT = b"\xff" * 5  # IODeviceConfig.INVALID_TIMER_DATA = "FFFFFFFFFF"
DAY_NAMES = ("mon", "tue", "wed", "thu", "fri", "sat", "sun")


def stroke_byte(level: int, test: bool = False) -> bytes:
    """앱 SwitcherBLEService.writeStrokeLevel()과 동일한 1바이트 인코딩.

    상위 니블 = 길이 레벨(0/1/2), 하위 니블 = 1이면 저장 없이 그 길이로 1회 동작만.
    """
    if level not in STROKE_NAMES:
        raise ValueError(f"level은 0/1/2 (받은 값: {level})")
    return bytes([(level << 4) | (1 if test else 0)])


def parse_firmware(raw: bytes) -> str:
    """3바이트 → "x.y.z" (CharacteristicReadParser.java:52-54)."""
    if len(raw) < 3:
        raise ValueError(f"펌웨어 버전은 3바이트 (받은 길이: {len(raw)})")
    return f"{raw[0]}.{raw[1]}.{raw[2]}"


# --- 기기 시계 (000045ea, 3B) — SwitcherBLEService.java:95-98 ---------------
# 요일은 월=0 … 일=6. 자바는 Calendar.DAY_OF_WEEK(일=1)에서 2를 빼 만들지만
# (BLEUtil.java:19) 그 결과가 파이썬 datetime.weekday()와 정확히 같아 보정이 필요 없다.

def clock_bytes(now: datetime | None = None) -> bytes:
    now = now or datetime.now()
    return bytes([now.weekday(), now.hour, now.minute])


def parse_clock(raw: bytes) -> tuple[int, int, int]:
    """3바이트 → (요일 0=월, 시 24h, 분)."""
    if len(raw) < 3:
        raise ValueError(f"시계는 3바이트 (받은 길이: {len(raw)})")
    return raw[0], raw[1], raw[2]


# --- 예약 (000015ca 쓰기 10B / 000025ca 읽기 50B) — README §6 ---------------

@dataclass
class Reservation:
    """예약 하나. 앱의 am/pm 필드는 12시간제 UI 때문이라 여기선 24시간제로만 다룬다."""

    slot: int                                  # 0~9. 읽을 때는 슬롯 위치가 곧 id
    hour: int                                  # 0~23
    minute: int                                # 0~59
    days: frozenset[int] = field(default_factory=frozenset)  # 0=월 … 6=일
    target: int = 0                            # 0=1구/첫번째, 1=2구 두번째
    on: bool = True                            # True=켜기 (앱의 light)
    enable: bool = True

    def __post_init__(self) -> None:
        self.days = frozenset(self.days)
        if not 0 <= self.slot <= MAX_SLOT:
            raise ValueError(f"slot은 0~{MAX_SLOT} (받은 값: {self.slot})")
        if not 0 <= self.hour <= 23:
            raise ValueError(f"hour는 0~23 (받은 값: {self.hour})")
        if not 0 <= self.minute <= 59:
            raise ValueError(f"minute은 0~59 (받은 값: {self.minute})")
        if self.target not in (0, 1):
            raise ValueError(f"target은 0 또는 1 (받은 값: {self.target})")
        if not self.days <= frozenset(range(7)):
            raise ValueError(f"days는 0~6 (받은 값: {sorted(self.days)})")

    def __str__(self) -> str:
        days = ",".join(DAY_NAMES[d] for d in sorted(self.days)) or "-"
        return (f"[{self.slot}] {self.hour:02d}:{self.minute:02d} {days} "
                f"{'켜기' if self.on else '끄기'} 대상={self.target} "
                f"{'활성' if self.enable else '비활성'}")


def reservation_record(r: Reservation) -> bytes:
    """예약 6바이트 (Switcher.java:267-292 getResrvDataForBLE).

    바이트1은 비트7=월 … 비트1=일, 비트0=enable. 앱은 8자리 2진 문자열을 만들어
    parseInt(.., 2)로 접는데 결과는 같은 비트마스크다.
    """
    days = sum(0x80 >> d for d in r.days) | (1 if r.enable else 0)
    return bytes([r.slot, days, r.hour, r.minute, r.target, 0 if r.on else 1])


def timer_version(now: datetime | None = None) -> bytes:
    """3바이트 timerVersion (Switcher.java:294-303 makeTimerVersion).

    now가 있으면 현재 시/분/초, None이면 FFFFFF(예약을 전부 비울 때).
    """
    if now is None:
        return b"\xff\xff\xff"
    return bytes([now.hour, now.minute, now.second])


def add_timer_packet(r: Reservation, now: datetime | None = None) -> bytes:
    """예약 추가 10바이트 (SwitcherBLEService.java:78-84).

    "00" + 예약데이터 12자 + timerVersion 6자 = 20 hex = 10바이트.
    """
    return b"\x00" + reservation_record(r) + timer_version(now or datetime.now())


def remove_timer_packet(slot: int, now: datetime | None = None) -> bytes:
    """예약 삭제 10바이트 (SwitcherBLEService.java:86-93).

    "01" + id 2자 + "0000000000" + timerVersion 6자. 추가와 같은
    [op][예약레코드 6B][timerVersion 3B] 틀에서 레코드의 뒤 5바이트만 0으로 민다.
    now=None이면 timerVersion이 FFFFFF — 마지막 예약을 지울 때만 그렇게 쓴다.
    """
    if not 0 <= slot <= MAX_SLOT:
        # 앱은 BLEUtil.hexToHexString("10")이 4자가 되어 조용히 실패한다 (README §6.2).
        raise ValueError(f"slot은 0~{MAX_SLOT} (받은 값: {slot})")
    return b"\x01" + bytes([slot]) + b"\x00" * 5 + timer_version(now)


def parse_reservations(raw: bytes) -> list[Reservation]:
    """50바이트(10슬롯 × 5B) → 예약 목록 (SwitcherProcessor.java:123-163).

    쓰기와 달리 id 바이트가 없고 슬롯 위치가 곧 id다. 빈 슬롯(FFFFFFFFFF)은 건너뛰고,
    시가 24 이상이면 앱과 동일하게 거기서 파싱을 멈춘다.
    """
    if len(raw) < 50:
        raise ValueError(f"예약 데이터는 50바이트 (받은 길이: {len(raw)})")
    out: list[Reservation] = []
    for slot in range(10):
        rec = raw[slot * 5:slot * 5 + 5]
        if rec == EMPTY_SLOT:
            continue
        days, hour, minute, target, light = rec
        if hour >= 24:
            break
        out.append(Reservation(
            slot=slot,
            hour=hour,
            minute=minute,
            days=frozenset(d for d in range(7) if days & (0x80 >> d)),
            target=target,
            on=light == 0,
            enable=bool(days & 1),
        ))
    return out


# --- 광고 패킷 (§4.4) — SwitcherAdvertisementPacket.java:33-45 --------------

@dataclass
class Adv:
    mac: str            # "d4ad8bc9607c"
    serial: str         # 8자리 hex
    gang: int           # 1 = 1구, 2 = 2구
    timer_version: str


def parse_adv(company_id: int, payload: bytes) -> Adv | None:
    """bleak의 manufacturer_data 한 항목 → Adv. 형태가 안 맞으면 None.

    이 제조사는 company ID 자리를 쓰지 않고 MAC부터 밀어넣었다. bleak은 앞 2바이트를
    키로 떼어내므로 앱이 보던 바이트열을 먼저 복원해야 한다.
    """
    full = company_id.to_bytes(2, "little") + bytes(payload)
    if len(full) < 15:
        return None
    return Adv(
        mac=full[0:6].hex(),
        # 시리얼 8자리 = 바이트 6~13의 하위 니블만 골라 이어붙인 것
        serial="".join(f"{b & 0x0F:X}" for b in full[6:14]),
        # 앱은 이 바이트의 hex 표기를 10진 파싱한다(1구/2구에서는 원시값과 동일)
        gang=full[14],
        timer_version=full[15:].hex(),
    )
