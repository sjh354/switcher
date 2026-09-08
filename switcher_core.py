import sys
import time
import binascii
import logging
from typing import Any
from bleak.backends.device import BLEDevice
import asyncio
from bleak import BleakScanner, BleakClient

_LOGGER = logging.getLogger(__name__)

DEFAULT_RETRY_COUNT = 5
DEFAULT_RETRY_TIMEOUT = 2.0
DEFAULT_SCAN_TIMEOUT = 15.0
DEFAULT_CONNECT_TIMEOUT = 30.0

SERVICE_UUID = "0000150b-0000-1000-8000-00805f9b34fb"
# 손가락 길이(stroke level) 전용 characteristic. 동작(15ba)과 같은 서비스 안에 따로 있다.
STROKE_CHAR_UUID = "000015bb-0000-1000-8000-00805f9b34fb"
STROKE_SHORT, STROKE_MEDIUM, STROKE_LONG = 0, 1, 2
STROKE_NAMES = {0: "짧게", 1: "중간(공장 기본)", 2: "길게"}
ON_KEY1 = binascii.a2b_hex("00")
OFF_KEY1 = binascii.a2b_hex("01")
ON_KEY2 = binascii.a2b_hex("05")
OFF_KEY2 = binascii.a2b_hex("03")


def stroke_byte(level: int, test: bool = False) -> bytes:
    """앱 SwitcherBLEService.writeStrokeLevel()과 동일한 1바이트 인코딩.

    상위 니블 = 길이 레벨(0/1/2), 하위 니블 = 1이면 저장 없이 그 길이로 1회 동작만.
    """
    if level not in STROKE_NAMES:
        raise ValueError(f"level은 0/1/2 (받은 값: {level})")
    return bytes([(level << 4) | (1 if test else 0)])

class IOSwitcher:
    def __init__(self, mac, device: BLEDevice = None, name: str = None,
                 type=1, char_uuid=None, **kwargs) -> None:
        self._mac = mac.lower() if mac else None
        self._name = name
        self._device = device
        self._client: BleakClient | None = None
        self._char_uuid = char_uuid
        self._retry_count = DEFAULT_RETRY_COUNT
        self._on_key = ON_KEY2 if type == 2 else ON_KEY1
        self._off_key = OFF_KEY2 if type == 2 else OFF_KEY1

    def _find_characteristic_uuid(self, services) -> str | None:
        target_service = next((s for s in services if s.uuid == SERVICE_UUID), None)
        if not target_service: return None
        for char in target_service.characteristics:
            if "write" in char.properties or "write-without-response" in char.properties:
                return char.uuid
        return target_service.characteristics[0].uuid if target_service.characteristics else None

    async def _connect(self) -> None:
        if self._client and self._client.is_connected: return

        if not self._device:
            # 1순위: MAC 주소로 직접 연결 시도
            if self._mac:
                _LOGGER.info(f"MAC({self._mac})으로 기기 검색 중...")
                self._device = await BleakScanner.find_device_by_address(
                    self._mac, timeout=DEFAULT_SCAN_TIMEOUT)

            # 2순위: MAC 실패 시 이름으로 검색
            if not self._device and self._name:
                _LOGGER.info(f"MAC 검색 실패, 이름({self._name})으로 검색 중...")
                devices = await BleakScanner.discover(timeout=DEFAULT_SCAN_TIMEOUT)
                for d in devices:
                    if d.name and d.name.upper() == self._name.upper():
                        self._device = d
                        self._mac = d.address.lower()
                        _LOGGER.info(f"이름으로 발견: {d.address}")
                        break

        if not self._device and not self._mac:
            raise Exception(f"장치를 찾을 수 없습니다. (mac={self._mac}, name={self._name})")

        await asyncio.sleep(0.3)

        # 3순위: 스캔에 안 잡혀도 MAC이 있으면 직접 연결한다. 기기가 이미 다른 쪽에
        # 연결돼 있어 광고를 멈춘 상태거나 이름이 안 실려 오는 경우에도, BlueZ가 들고
        # 있는 캐시로 붙는다. 앱도 스캔보다 시스템 연결 목록을 먼저 본다 (README §4.6).
        if not self._device:
            _LOGGER.info(f"스캔 실패, MAC({self._mac})으로 직접 연결 시도...")

        self._client = BleakClient(self._device or self._mac,
                                   timeout=DEFAULT_CONNECT_TIMEOUT)
        await self._client.connect()
        
        if not self._char_uuid:
            try:
                services = self._client.services
            except:
                try:
                    services = await self._client.get_services()
                except:
                    raise Exception("서비스 목록을 가져올 수 없습니다.")
            self._char_uuid = self._find_characteristic_uuid(services)
        
        if not self._char_uuid:
            raise Exception("Characteristic UUID를 찾을 수 없습니다.")

    async def _disconnect(self) -> None:
        if self._client:
            try:
                await self._client.disconnect()
            except:
                pass
            self._client = None

    async def turn_on(self) -> bool:
        return await self._sendcommand(self._on_key, self._retry_count)

    async def turn_off(self) -> bool:
        return await self._sendcommand(self._off_key, self._retry_count)

    async def read_stroke_level(self) -> int:
        """현재 저장된 손가락 길이(0=짧게, 1=중간, 2=길게)."""
        try:
            await self._connect()
            raw = await self._client.read_gatt_char(STROKE_CHAR_UUID)
            _LOGGER.info(f"stroke level = {raw[0]} ({STROKE_NAMES.get(raw[0], '?')})")
            return raw[0]
        finally:
            await self._disconnect()

    async def set_stroke_level(self, level: int, test: bool = False) -> bool:
        """손가락 길이 저장. test=True면 저장하지 않고 그 길이로 한 번 동작만 해본다."""
        return await self._sendcommand(stroke_byte(level, test), self._retry_count,
                                       STROKE_CHAR_UUID)

    async def _sendcommand(self, key, retry, char_uuid=None) -> bool:
        try:
            await self._connect()
            await self._client.write_gatt_char(char_uuid or self._char_uuid, key)
            _LOGGER.info("명령 전송 성공")
            return True
        except Exception as e:
            _LOGGER.warning(f"시도 실패: {e}")
            if retry > 0:
                await self._disconnect()
                await asyncio.sleep(DEFAULT_RETRY_TIMEOUT)
                return await self._sendcommand(key, retry - 1, char_uuid)
            return False
        finally:
            await self._disconnect()

if __name__ == "__main__":
    logging.basicConfig(level=logging.INFO)
    switcher = IOSwitcher("D4:AD:8B:C9:60:7C")
    asyncio.run(switcher.turn_off())
