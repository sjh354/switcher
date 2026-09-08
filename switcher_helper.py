#!/usr/bin/env python3
"""Find and control a Switcher BLE device by Name or MAC."""

from __future__ import annotations

import argparse
import asyncio
from dataclasses import dataclass
from typing import Any

from bleak import BleakScanner
from bleak.backends.device import BLEDevice

from switcher_core import IOSwitcher, STROKE_NAMES


@dataclass
class MatchResult:
    score: int
    reasons: list[str]
    device: BLEDevice
    adv: Any


class SwitcherHelper:
    def __init__(self, scan_timeout: float = 8.0) -> None:
        self.scan_timeout = scan_timeout

    async def discover(self) -> dict[str, tuple[BLEDevice, Any]]:
        return await BleakScanner.discover(return_adv=True, timeout=self.scan_timeout)

    def find_by_name(
        self, name: str, discovered: dict[str, tuple[BLEDevice, Any]]
    ) -> list[MatchResult]:
        target = name.strip().upper()
        results: list[MatchResult] = []
        for device, adv in discovered.values():
            device_name = (device.name or "").upper()
            local_name = (getattr(adv, "local_name", None) or "").upper()
            
            if target == device_name or target == local_name:
                results.append(MatchResult(score=100, reasons=["name_match"], device=device, adv=adv))
        return results

    def match_serial(
        self, serial: str, discovered: dict[str, tuple[BLEDevice, Any]]
    ) -> list[MatchResult]:
        variants = self._serial_variants(serial)
        if not variants:
            return []
        results: list[MatchResult] = []
        for device, adv in discovered.values():
            matched = self._match_device(variants, device, adv)
            if matched.score > 0:
                results.append(matched)
        results.sort(key=lambda x: x.score, reverse=True)
        return results

    @staticmethod
    def find_by_mac(
        discovered: dict[str, tuple[BLEDevice, Any]], mac: str
    ) -> tuple[BLEDevice, Any] | None:
        target = mac.strip().upper()
        for device, adv in discovered.values():
            if (device.address or "").upper() == target:
                return device, adv
        return None

    @staticmethod
    async def control(
        device: BLEDevice | None, mac: str, switch_type: int, action: str,
        name: str = None, level: int = None,
    ) -> bool:
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
            if level is None:
                raise ValueError(f"{action}에는 --level 0|1|2 이 필요합니다")
            return await sw.set_stroke_level(level, test=(action == "stroke-test"))
        raise ValueError(f"Unknown action: {action}")

    def _match_device(self, variants: set[str], device: BLEDevice, adv: Any) -> MatchResult:
        reasons: list[str] = []
        score = 0
        for key, value in self._collect_tokens(device, adv):
            value_up = value.upper()
            value_hex = self._normalize_hex(value_up)
            for serial in variants:
                if value_up == serial or value_hex == serial:
                    score += 100
                    reasons.append(f"{key}=exact({serial})")
                    continue
                if serial in value_up or serial in value_hex:
                    score += 50
                    reasons.append(f"{key}=contains({serial})")
                    continue
                if value_up.endswith(serial) or value_hex.endswith(serial):
                    score += 25
                    reasons.append(f"{key}=endswith({serial})")
        return MatchResult(score=score, reasons=reasons, device=device, adv=adv)

    @staticmethod
    def _collect_tokens(device: BLEDevice, adv: Any) -> list[tuple[str, str]]:
        tokens: list[tuple[str, str]] = []
        if device.name:
            tokens.append(("device.name", device.name))
        if device.address:
            tokens.append(("device.address", device.address))
        local_name = getattr(adv, "local_name", None)
        if local_name:
            tokens.append(("adv.local_name", local_name))
        service_uuids = getattr(adv, "service_uuids", None) or []
        for uuid in service_uuids:
            tokens.append(("adv.service_uuid", str(uuid)))
        manufacturer_data = getattr(adv, "manufacturer_data", None) or {}
        for company_id, payload in manufacturer_data.items():
            tokens.append((f"adv.manu[{company_id}]_hex", SwitcherHelper._hex_dump(payload)))
        service_data = getattr(adv, "service_data", None) or {}
        for uuid, payload in service_data.items():
            tokens.append((f"adv.service_data[{uuid}]_hex", SwitcherHelper._hex_dump(payload)))
        return tokens

    @staticmethod
    def _normalize_hex(value: str) -> str:
        return "".join(ch for ch in value.upper() if ch in "0123456789ABCDEF")

    @staticmethod
    def _serial_variants(serial: str) -> set[str]:
        base = SwitcherHelper._normalize_hex(serial)
        variants = {base}
        if len(base) % 2 == 0 and base:
            bytes_list = [base[i : i + 2] for i in range(0, len(base), 2)]
            variants.add("".join(reversed(bytes_list)))
        return {v for v in variants if v}

    @staticmethod
    def _hex_dump(data: bytes | bytearray) -> str:
        return data.hex().upper()


def _build_parser() -> argparse.ArgumentParser:
    parser = argparse.ArgumentParser(
        description="Find Switcher by serial-like value and optionally send ON/OFF.",
    )
    parser.add_argument("--serial", help="Known serial-like value. e.g. 9EF02EE6")
    parser.add_argument("--mac", help="Direct BLE address")
    parser.add_argument("--name", help="Device name to search for (e.g. SWITCHER_M)")
    parser.add_argument("--scan-timeout", type=float, default=8.0, help="BLE scan seconds")
    parser.add_argument(
        "--dump-all",
        action="store_true",
        help="Print all discovered BLE devices",
    )
    parser.add_argument("--type", type=int, choices=[1, 2], default=1, help="Switcher gang type")
    parser.add_argument(
        "--action",
        choices=["none", "on", "off", "stroke-read", "stroke-set", "stroke-test"], # toggle 삭제
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
    return parser


def _print_candidates(candidates: list[MatchResult]) -> None:
    for i, item in enumerate(candidates, start=1):
        device = item.device
        adv = item.adv
        local_name = getattr(adv, "local_name", None) or "-"
        print(f"[{i}] score={item.score} mac={device.address} name={device.name or '-'}")
        print(f"    local_name={local_name}")
        print(f"    reasons={', '.join(item.reasons)}")


def _print_all_devices(discovered: dict[str, tuple[BLEDevice, Any]]) -> None:
    for i, (device, adv) in enumerate(discovered.values(), start=1):
        local_name = getattr(adv, "local_name", None) or "-"
        rssi = getattr(adv, "rssi", None)
        print(f"[{i}] mac={device.address} name={device.name or '-'} local_name={local_name} rssi={rssi}")


async def _main() -> int:
    parser = _build_parser()
    args = parser.parse_args()
    if not args.serial and not args.mac and not args.name and not args.dump_all:
        parser.error("Provide --serial, --mac, --name, or --dump-all")

    helper = SwitcherHelper(scan_timeout=args.scan_timeout)

    # 1. Direct MAC address control (MAC 우선, 실패 시 이름 폴백)
    if args.mac and args.action != "none":
        try:
            ok = await helper.control(None, args.mac, args.type, args.action,
                                      name=args.name, level=args.level)
            return 0 if ok else 1
        except Exception as exc:
            print(f"Control failed: {exc}")
            return 1

    # 2. Scanning based control
    print(f"Scanning for {args.scan_timeout:.1f}s...")
    discovered = await helper.discover()
    
    if args.dump_all:
        _print_all_devices(discovered)

    candidates = []
    if args.name:
        candidates = helper.find_by_name(args.name, discovered)
    elif args.serial:
        candidates = helper.match_serial(args.serial, discovered)
    elif args.mac:
        match = helper.find_by_mac(discovered, args.mac)
        if match:
            candidates = [MatchResult(100, ["mac_match"], match[0], match[1])]

    if not candidates:
        if not args.dump_all:
            print("No matching candidates found.")
        return 2

    if args.action == "none":
        print(f"Found {len(candidates)} candidate(s):")
        _print_candidates(candidates)
        return 0

    chosen = candidates[args.index - 1]
    print(f"Using {chosen.device.name} ({chosen.device.address})")

    try:
        ok = await helper.control(chosen.device, chosen.device.address, args.type,
                                  args.action, level=args.level)
        return 0 if ok else 1
    except Exception as exc:
        print(f"Control failed: {exc}")
        return 1


if __name__ == "__main__":
    raise SystemExit(asyncio.run(_main()))
