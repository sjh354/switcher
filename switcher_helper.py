#!/usr/bin/env python3
"""Find and control a Switcher BLE device by Name, MAC or serial."""

from __future__ import annotations

import argparse
import asyncio
from dataclasses import dataclass
from typing import Any

from bleak import BleakScanner
from bleak.backends.device import BLEDevice

from switcher_core import IOSwitcher
from switcher_protocol import (
    Adv, DAY_NAMES, MAX_SLOT, STROKE_NAMES, Reservation, parse_adv,
)

SWITCHER_NAME = "SWITCHER"  # Switcher.java:33 — 앱도 name.contains("SWITCHER")로 거른다

DAY_GROUPS = {
    "all": set(range(7)),
    "weekday": {0, 1, 2, 3, 4},
    "weekend": {5, 6},
}


@dataclass
class Candidate:
    device: BLEDevice
    adv: Any
    info: Adv | None


def adv_info(adv: Any) -> Adv | None:
    """광고의 manufacturer data에서 MAC/시리얼/구 수를 뽑는다 (§4.4). 없으면 None."""
    for company_id, payload in (getattr(adv, "manufacturer_data", None) or {}).items():
        info = parse_adv(company_id, payload)
        if info:
            return info
    return None


def is_switcher(device: BLEDevice, adv: Any) -> bool:
    names = ((device.name or ""), (getattr(adv, "local_name", None) or ""))
    return any(SWITCHER_NAME in n.upper() for n in names)


class SwitcherHelper:
    def __init__(self, scan_timeout: float = 8.0) -> None:
        self.scan_timeout = scan_timeout

    async def discover(self) -> dict[str, tuple[BLEDevice, Any]]:
        return await BleakScanner.discover(return_adv=True, timeout=self.scan_timeout)

    @staticmethod
    def switchers(discovered: dict[str, tuple[BLEDevice, Any]]) -> list[Candidate]:
        return [Candidate(d, adv, adv_info(adv))
                for d, adv in discovered.values() if is_switcher(d, adv)]

    def find_by_name(
        self, name: str, discovered: dict[str, tuple[BLEDevice, Any]]
    ) -> list[Candidate]:
        target = name.strip().upper()
        results: list[Candidate] = []
        for device, adv in discovered.values():
            names = ((device.name or "").upper(), (getattr(adv, "local_name", None) or "").upper())
            if any(target in n for n in names):
                results.append(Candidate(device, adv, adv_info(adv)))
        return results

    def match_serial(
        self, serial: str, discovered: dict[str, tuple[BLEDevice, Any]]
    ) -> list[Candidate]:
        """광고 패킷에서 파싱한 시리얼과 정확 비교 (§4.4)."""
        target = serial.strip().upper()
        return [c for c in self.switchers(discovered)
                if c.info and c.info.serial == target]

    @staticmethod
    def find_by_mac(
        discovered: dict[str, tuple[BLEDevice, Any]], mac: str
    ) -> Candidate | None:
        target = mac.strip().upper()
        for device, adv in discovered.values():
            if (device.address or "").upper() == target:
                return Candidate(device, adv, adv_info(adv))
        return None

    @staticmethod
    async def control(
        device: BLEDevice | None, mac: str, switch_type: int, args: argparse.Namespace,
        name: str = None,
    ) -> bool:
        action = args.action
        sw = IOSwitcher(mac=mac, device=device, name=name, type=switch_type)
        if action == "on":
            return await sw.turn_on()
        if action == "off":
            return await sw.turn_off()
        if action == "stroke-read":
            value = await sw.read_stroke_level()
            print(f"stroke level = {value} ({STROKE_NAMES.get(value, '?')})")
            return True
        if action in ("stroke-set", "stroke-test"):
            if args.level is None:
                raise ValueError(f"{action}에는 --level 0|1|2 이 필요합니다")
            return await sw.set_stroke_level(args.level, test=(action == "stroke-test"))
        if action == "battery":
            print(f"battery = {await sw.read_battery()}% (앱은 표시할 때 3을 뺀다, §5.2)")
            return True
        if action == "firmware":
            print(f"firmware = {await sw.read_firmware()}")
            return True
        if action == "clock-read":
            day, hour, minute = await sw.read_clock()
            print(f"device clock = {DAY_NAMES[day] if day < 7 else day} {hour:02d}:{minute:02d}")
            return True
        if action == "clock-set":
            return await sw.set_clock()
        if action == "timer-read":
            reservations = await sw.read_reservations()
            if not reservations:
                print("등록된 예약 없음")
            for r in reservations:
                print(r)
            return True
        if action == "timer-add":
            return await sw.add_reservation(_reservation_from_args(args))
        if action == "timer-del":
            if args.slot is None:
                raise ValueError("timer-del에는 --slot 0~9 가 필요합니다")
            return await sw.remove_reservation(args.slot, last=args.last)
        raise ValueError(f"Unknown action: {action}")


def _parse_days(spec: str) -> set[int]:
    spec = spec.strip().lower()
    if spec in DAY_GROUPS:
        return DAY_GROUPS[spec]
    days = set()
    for token in spec.split(","):
        token = token.strip()
        if token not in DAY_NAMES:
            raise ValueError(f"--days는 {'/'.join(DAY_NAMES)} 또는 {'/'.join(DAY_GROUPS)} "
                             f"(받은 값: {token})")
        days.add(DAY_NAMES.index(token))
    return days


def _reservation_from_args(args: argparse.Namespace) -> Reservation:
    if args.slot is None or args.at is None:
        raise ValueError("timer-add에는 --slot 0~9 와 --at HH:MM 이 필요합니다")
    hour, _, minute = args.at.partition(":")
    return Reservation(
        slot=args.slot,
        hour=int(hour),
        minute=int(minute),
        days=_parse_days(args.days),
        target=args.target,
        on=not args.off,
    )


def _build_parser() -> argparse.ArgumentParser:
    parser = argparse.ArgumentParser(
        description="Find a Switcher and send a command.",
    )
    parser.add_argument("--serial", help="Serial from the advertisement. e.g. 9EF02EE6")
    parser.add_argument("--mac", help="Direct BLE address")
    parser.add_argument("--name", help="Device name to search for (e.g. SWITCHER_M)")
    parser.add_argument("--scan-timeout", type=float, default=8.0, help="BLE scan seconds")
    parser.add_argument(
        "--dump-all",
        action="store_true",
        help="Print all discovered BLE devices",
    )
    parser.add_argument(
        "--type", type=int, choices=[1, 2], default=None,
        help="Switcher gang type. 생략하면 광고 패킷에서 자동 판별 (§4.4)",
    )
    parser.add_argument(
        "--action",
        choices=["none", "on", "off", "stroke-read", "stroke-set", "stroke-test",
                 "battery", "firmware", "clock-read", "clock-set",
                 "timer-read", "timer-add", "timer-del"],
        default="none",
        help="Run a control command after selecting a candidate",
    )
    parser.add_argument(
        "--level",
        type=int,
        choices=[0, 1, 2],
        help="손가락 길이 (0=짧게, 1=중간, 2=길게). stroke-set/stroke-test 에 사용",
    )
    parser.add_argument(
        "--index",
        type=int,
        default=1,
        help="Candidate index to use",
    )
    parser.add_argument("--slot", type=int, choices=range(MAX_SLOT + 1),
                        help="예약 슬롯 0~9. timer-add/timer-del 에 사용")
    parser.add_argument("--at", help="예약 시각 HH:MM (24시간제). timer-add 에 사용")
    parser.add_argument("--days", default="all",
                        help="예약 요일. mon,tue,... 또는 all/weekday/weekend")
    parser.add_argument("--target", type=int, choices=[0, 1], default=0,
                        help="예약 대상 구 (0=1구/첫번째, 1=2구 두번째)")
    parser.add_argument("--off", action="store_true",
                        help="예약을 끄기 동작으로 (기본은 켜기)")
    parser.add_argument("--last", action="store_true",
                        help="timer-del: 이게 마지막 예약이면 지정 (timerVersion=FFFFFF)")
    return parser


def _describe(candidate: Candidate) -> str:
    info = candidate.info
    if not info:
        return "    (광고 패킷 없음 — manufacturer data 미수신)"
    return (f"    serial={info.serial} gang={info.gang} "
            f"adv_mac={info.mac} timer_ver={info.timer_version}")


def _print_candidates(candidates: list[Candidate]) -> None:
    for i, item in enumerate(candidates, start=1):
        print(f"[{i}] mac={item.device.address} name={item.device.name or '-'}")
        print(_describe(item))


def _print_all_devices(discovered: dict[str, tuple[BLEDevice, Any]]) -> None:
    for i, (device, adv) in enumerate(discovered.values(), start=1):
        local_name = getattr(adv, "local_name", None) or "-"
        rssi = getattr(adv, "rssi", None)
        print(f"[{i}] mac={device.address} name={device.name or '-'} "
              f"local_name={local_name} rssi={rssi}")
        for company_id, payload in (getattr(adv, "manufacturer_data", None) or {}).items():
            # 앱이 보던 바이트열 복원 — §2-1에서 오프셋 검증에 쓸 원본 hex
            full = company_id.to_bytes(2, "little") + bytes(payload)
            print(f"    manu[{company_id}] len={len(full)} {full.hex()}")
        if is_switcher(device, adv):
            print(_describe(Candidate(device, adv, adv_info(adv))))


def _resolve_type(args: argparse.Namespace, candidate: Candidate | None) -> int:
    if args.type is not None:
        return args.type
    if candidate and candidate.info and candidate.info.gang in (1, 2):
        return candidate.info.gang
    return 1


async def _main() -> int:
    parser = _build_parser()
    args = parser.parse_args()
    if not args.serial and not args.mac and not args.name and not args.dump_all:
        parser.error("Provide --serial, --mac, --name, or --dump-all")

    helper = SwitcherHelper(scan_timeout=args.scan_timeout)

    # 1. Direct MAC address control (MAC 우선, 실패 시 이름 폴백)
    #    스캔을 건너뛰므로 광고 기반 자동 판별은 못 한다 → --type 미지정이면 1구로 본다
    if args.mac and args.action != "none":
        try:
            ok = await helper.control(None, args.mac, _resolve_type(args, None),
                                      args, name=args.name)
            return 0 if ok else 1
        except Exception as exc:
            print(f"Control failed: {exc}")
            return 1

    # 2. Scanning based control
    print(f"Scanning for {args.scan_timeout:.1f}s...")
    discovered = await helper.discover()
    
    if args.dump_all:
        _print_all_devices(discovered)

    candidates: list[Candidate] = []
    if args.name:
        candidates = helper.find_by_name(args.name, discovered)
    elif args.serial:
        candidates = helper.match_serial(args.serial, discovered)
    elif args.mac:
        match = helper.find_by_mac(discovered, args.mac)
        if match:
            candidates = [match]

    if not candidates:
        if not args.dump_all:
            print("No matching candidates found.")
        return 2

    if args.action == "none":
        print(f"Found {len(candidates)} candidate(s):")
        _print_candidates(candidates)
        return 0

    if not 1 <= args.index <= len(candidates):
        print(f"--index는 1~{len(candidates)} (받은 값: {args.index})")
        return 2
    chosen = candidates[args.index - 1]
    print(f"Using {chosen.device.name} ({chosen.device.address})")

    try:
        ok = await helper.control(chosen.device, chosen.device.address,
                                  _resolve_type(args, chosen), args)
        return 0 if ok else 1
    except Exception as exc:
        print(f"Control failed: {exc}")
        return 1


if __name__ == "__main__":
    raise SystemExit(asyncio.run(_main()))
