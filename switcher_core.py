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
ON_KEY1 = binascii.a2b_hex("00")
OFF_KEY1 = binascii.a2b_hex("01")
ON_KEY2 = binascii.a2b_hex("05")
OFF_KEY2 = binascii.a2b_hex("03")

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

        if not self._device:
            raise Exception(f"장치를 찾을 수 없습니다. (mac={self._mac}, name={self._name})")

        await asyncio.sleep(0.3)

        self._client = BleakClient(self._device, timeout=DEFAULT_CONNECT_TIMEOUT)
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

    async def _sendcommand(self, key, retry) -> bool:
        try:
            await self._connect()
            await self._client.write_gatt_char(self._char_uuid, key)
            _LOGGER.info("명령 전송 성공")
            return True
        except Exception as e:
            _LOGGER.warning(f"시도 실패: {e}")
            if retry > 0:
                await self._disconnect()
                await asyncio.sleep(DEFAULT_RETRY_TIMEOUT)
                return await self._sendcommand(key, retry - 1)
            return False
        finally:
            await self._disconnect()

if __name__ == "__main__":
    logging.basicConfig(level=logging.INFO)
    switcher = IOSwitcher("D4:AD:8B:C9:60:7C")
    asyncio.run(switcher.turn_off())
