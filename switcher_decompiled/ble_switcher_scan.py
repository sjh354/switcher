"""
IO Switcher BLE Command Scanner
- BLE 기기에 연결하여 0x00~0xFF 바이트를 순차적으로 전송
- 각 명령에 대한 기기 반응을 직접 관찰하여 손가락 길이(각도) 조절 명령을 찾는 용도
- PySwitcherIO (https://github.com/damob-byun/PySwitcherIO) 기반

사용법:
  1. nRF Connect 등으로 기기 MAC 주소 확인
  2. python ble_switcher_scan.py --mac AA:BB:CC:DD:EE:FF
  3. 각 바이트 전송 시 기기 반응을 직접 관찰하고 Enter
"""

import asyncio
import argparse
from bleak import BleakClient, BleakScanner

SERVICE_UUID = "0000150b-0000-1000-8000-00805f9b34fb"
CHAR_UUID = "000015ba-0000-1000-8000-00805f9b34fb"

KNOWN_COMMANDS = {
    0x00: "1구 ON",
    0x01: "1구 OFF",
    0x03: "2구 OFF",
    0x05: "2구 ON",
}


async def scan_devices():
    """주변 BLE 기기를 스캔하여 IO Switcher 찾기"""
    print("BLE 기기 스캔 중... (5초)")
    found = []
    def callback(device, adv_data):
        found.append((device, adv_data))

    scanner = BleakScanner(detection_callback=callback)
    await scanner.start()
    await asyncio.sleep(5.0)
    await scanner.stop()

    if not found:
        print("기기를 찾지 못했습니다.")
        return

    # 중복 제거 (마지막 발견 기준)
    seen = {}
    for device, adv in found:
        seen[device.address] = (device, adv)

    items = sorted(seen.values(), key=lambda x: x[1].rssi or -999, reverse=True)

    print(f"\n{'='*60}")
    print(f"{'MAC 주소':<20} {'RSSI':>6}  {'이름'}")
    print(f"{'='*60}")
    for device, adv in items:
        name = device.name or adv.local_name or "(알 수 없음)"
        rssi = adv.rssi if adv.rssi is not None else "N/A"
        print(f"{device.address:<20} {str(rssi):>4} dBm  {name}")
    print()


async def enumerate_services(mac: str):
    """기기의 모든 BLE 서비스와 특성을 열거하고 읽기 가능한 값 표시"""
    print(f"[{mac}] 연결 중...")
    async with BleakClient(mac) as client:
        print(f"[{mac}] 연결 성공\n")
        for service in client.services:
            print(f"서비스: {service.uuid}  ({service.description})")
            for char in service.characteristics:
                props = ", ".join(char.properties)
                print(f"  특성: {char.uuid}  [{props}]  ({char.description})")
                if "read" in char.properties:
                    try:
                        value = await client.read_gatt_char(char.uuid)
                        hex_str = " ".join(f"{b:02X}" for b in value)
                        print(f"    → 값: [{hex_str}] (bytes: {list(value)})")
                    except Exception as e:
                        print(f"    → 읽기 실패: {e}")
                for desc in char.descriptors:
                    print(f"    디스크립터: {desc.uuid}  ({desc.description})")
            print()


async def send_byte(mac: str, value: int, char_uuid: str = CHAR_UUID):
    """단일 바이트를 기기에 전송"""
    async with BleakClient(mac) as client:
        await client.write_gatt_char(char_uuid, bytes([value]))


async def scan_all_commands(mac: str, start: int = 0x00, end: int = 0xFF,
                            char_uuid: str = CHAR_UUID):
    """0x00~0xFF 바이트를 순차 전송하며 반응 관찰"""
    print(f"\n기기 [{mac}]에 0x{start:02X}~0x{end:02X} 명령 스캔 시작")
    print("각 명령 전송 후 기기 반응을 관찰하세요.")
    print("  Enter = 반응 없음 (다음으로)")
    print("  반응 설명 입력 = 기록 후 다음으로")
    print("  q = 중단\n")

    results = []

    for value in range(start, end + 1):
        known = KNOWN_COMMANDS.get(value, "")
        label = f"  ← {known}" if known else ""

        try:
            await send_byte(mac, value, char_uuid)
            status = "OK"
        except Exception as e:
            status = f"실패: {e}"

        prompt = f"[0x{value:02X} / {value:>3}] {status}{label}  반응: "
        response = input(prompt).strip()

        if response.lower() == "q":
            print("스캔 중단.")
            break

        if response:
            results.append((value, response))

    if results:
        print(f"\n{'='*60}")
        print("반응이 있었던 명령 목록:")
        print(f"{'='*60}")
        for value, desc in results:
            known = KNOWN_COMMANDS.get(value, "")
            tag = f" (기존: {known})" if known else ""
            print(f"  0x{value:02X} ({value:>3}): {desc}{tag}")
        print()


async def test_range(mac: str, start: int, end: int, step: int = 1,
                     delay: float = 1.0, char_uuid: str = CHAR_UUID):
    """특정 범위의 바이트를 자동으로 연속 전송 (각도 탐색용)"""
    print(f"\n자동 전송: 0x{start:02X}~0x{end:02X} (step={step}, delay={delay}s)")
    print("기기 반응을 관찰하세요. Ctrl+C로 중단.\n")

    try:
        for value in range(start, end + 1, step):
            try:
                await send_byte(mac, value, char_uuid)
                print(f"  0x{value:02X} ({value:>3}) 전송 완료")
            except Exception as e:
                print(f"  0x{value:02X} ({value:>3}) 실패: {e}")
            await asyncio.sleep(delay)
    except KeyboardInterrupt:
        print("\n중단됨.")


def main():
    parser = argparse.ArgumentParser(description="IO Switcher BLE Command Scanner")
    sub = parser.add_subparsers(dest="command")

    # 스캔
    sub.add_parser("scan", help="주변 BLE 기기 스캔")

    # 서비스 열거
    p_enum = sub.add_parser("enum", help="기기의 BLE 서비스/특성 열거")
    p_enum.add_argument("--mac", required=True, help="기기 MAC 주소")

    # 전체 명령 스캔
    p_all = sub.add_parser("test", help="0x00~0xFF 명령 스캔 (수동 관찰)")
    p_all.add_argument("--mac", required=True, help="기기 MAC 주소")
    p_all.add_argument("--start", type=lambda x: int(x, 0), default=0x00)
    p_all.add_argument("--end", type=lambda x: int(x, 0), default=0xFF)
    p_all.add_argument("--char", default=CHAR_UUID, help="특성 UUID")

    # 범위 자동 전송
    p_range = sub.add_parser("range", help="범위 자동 연속 전송 (각도 탐색)")
    p_range.add_argument("--mac", required=True, help="기기 MAC 주소")
    p_range.add_argument("--start", type=lambda x: int(x, 0), default=0x00)
    p_range.add_argument("--end", type=lambda x: int(x, 0), default=0xFF)
    p_range.add_argument("--step", type=int, default=1)
    p_range.add_argument("--delay", type=float, default=1.0, help="전송 간격 (초)")
    p_range.add_argument("--char", default=CHAR_UUID, help="특성 UUID")

    # 단일 명령 전송
    p_send = sub.add_parser("send", help="단일 바이트 전송")
    p_send.add_argument("--mac", required=True, help="기기 MAC 주소")
    p_send.add_argument("--value", required=True, type=lambda x: int(x, 0),
                        help="전송할 바이트 값 (예: 0x0A 또는 10)")
    p_send.add_argument("--char", default=CHAR_UUID, help="특성 UUID")

    # 다중 바이트 쓰기
    p_write = sub.add_parser("write", help="다중 바이트 쓰기 (예: 05 00 20)")
    p_write.add_argument("--mac", required=True, help="기기 MAC 주소")
    p_write.add_argument("--char", required=True, help="특성 UUID")
    p_write.add_argument("--data", required=True, nargs="+",
                         help="전송할 바이트들 (예: 05 00 40 또는 0x05 0x00 0x40)")

    # 특정 특성 읽기
    p_read = sub.add_parser("read", help="특성 값 읽기")
    p_read.add_argument("--mac", required=True, help="기기 MAC 주소")
    p_read.add_argument("--char", required=True, help="특성 UUID")

    # 손가락 길이 설정 (한 연결에서 설정 + ON/OFF)
    p_stroke = sub.add_parser("stroke", help="손가락 길이 설정 (0=짧게, 1=중간, 2=길게)")
    p_stroke.add_argument("--mac", required=True, help="기기 MAC 주소")
    p_stroke.add_argument("--level", required=True, type=int, choices=[0, 1, 2],
                          help="0=짧게, 1=중간, 2=길게")
    p_stroke.add_argument("--gang", type=int, default=1, choices=[1, 2],
                          help="1구 또는 2구 (기본: 1)")

    args = parser.parse_args()

    if args.command == "scan":
        asyncio.run(scan_devices())
    elif args.command == "enum":
        asyncio.run(enumerate_services(args.mac))
    elif args.command == "test":
        asyncio.run(scan_all_commands(args.mac, args.start, args.end, args.char))
    elif args.command == "range":
        asyncio.run(test_range(args.mac, args.start, args.end, args.step,
                               args.delay, args.char))
    elif args.command == "send":
        asyncio.run(send_byte(args.mac, args.value, args.char))
        print(f"0x{args.value:02X} 전송 완료")
    elif args.command == "write":
        data = bytes([int(b, 16) for b in args.data])
        async def do_write():
            async with BleakClient(args.mac) as client:
                await client.write_gatt_char(args.char, data)
                hex_str = " ".join(f"{b:02X}" for b in data)
                print(f"[{hex_str}] → {args.char} 쓰기 완료")
                # 쓴 후 다시 읽어서 확인
                try:
                    val = await client.read_gatt_char(args.char)
                    hex_r = " ".join(f"{b:02X}" for b in val)
                    print(f"확인 읽기: [{hex_r}]")
                except Exception:
                    pass
        asyncio.run(do_write())
    elif args.command == "read":
        async def do_read():
            async with BleakClient(args.mac) as client:
                val = await client.read_gatt_char(args.char)
                hex_str = " ".join(f"{b:02X}" for b in val)
                print(f"[{hex_str}] (bytes: {list(val)})")
        asyncio.run(do_read())
    elif args.command == "stroke":
        STROKE_CHAR = "000015bb-0000-1000-8000-00805f9b34fb"
        SWITCH_CHAR = "000015ba-0000-1000-8000-00805f9b34fb"
        level = args.level
        gang_suffix = "1" if args.gang == 2 else "0"
        stroke_value = int(f"{level}{gang_suffix}", 16)
        on_cmd = 0x00 if args.gang == 1 else 0x02
        off_cmd = 0x01 if args.gang == 1 else 0x03
        level_names = {0: "짧게", 1: "중간", 2: "길게"}
        async def do_stroke():
            async with BleakClient(args.mac) as client:
                # 현재 stroke level 읽기
                cur = await client.read_gatt_char(STROKE_CHAR)
                print(f"현재 stroke level: [{' '.join(f'{b:02X}' for b in cur)}]")

                # stroke level 쓰기
                print(f"\n{args.gang}구 손가락 길이 → {level_names[level]} "
                      f"(0x{stroke_value:02X}) 설정 중...")
                await client.write_gatt_char(STROKE_CHAR, bytes([stroke_value]))
                await asyncio.sleep(0.5)

                # 설정 후 읽기 확인
                after = await client.read_gatt_char(STROKE_CHAR)
                print(f"설정 후 stroke level: [{' '.join(f'{b:02X}' for b in after)}]")

                # ON 테스트
                await asyncio.sleep(0.5)
                print(f"\n{args.gang}구 ON (0x{on_cmd:02X}) 전송...")
                await client.write_gatt_char(SWITCH_CHAR, bytes([on_cmd]))
                await asyncio.sleep(2.0)

                # OFF 테스트
                print(f"{args.gang}구 OFF (0x{off_cmd:02X}) 전송...")
                await client.write_gatt_char(SWITCH_CHAR, bytes([off_cmd]))
                print("\n완료! 팔 움직임 범위가 달라졌는지 확인하세요.")
        asyncio.run(do_stroke())
    else:
        parser.print_help()


if __name__ == "__main__":
    main()
