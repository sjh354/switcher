# Switcher BLE 제어

지원 종료된 스위처(주식회사 스위처, 안드로이드 앱 패키지 `kr.switcher.switcherm`) 블루투스
스위치를 공식 앱 없이 직접 제어하기 위한 저장소. 프로토콜은 전부 앱 APK(v3.28.3)를
디컴파일해서 역추적한 것이며, 이 문서의 모든 항목에 **출처 파일:라인**을 붙여두었다.

| 경로 | 내용 |
|---|---|
| `switcher_protocol.py` | 순수 인코딩/파싱 (stroke·예약·시계·광고 패킷). **stdlib만 쓰므로 bleak 없이 import된다** |
| `switcher_core.py` | `IOSwitcher` — BLE 연결/재시도 + 모든 읽기/쓰기 명령 |
| `switcher_helper.py` | CLI. 스캔·이름/시리얼/MAC 매칭 후 명령 전송 |
| `test_protocol.py` | 예약/시계/펌웨어/광고 패킷 인코딩 검증 (기기 없이 실행) |
| `test_stroke.py` | stroke level 인코딩 검증 (기기 없이 실행) |
| `Switcher/` | iOS(SwiftUI) 앱. ON/OFF만 구현 |
| `switcher_decompiled/I_O_3.28.3_APKPure.apk` | 원본 APK |
| `switcher_decompiled/switcher_decompiled/` | JADX 디컴파일 결과 (`sources/`, `resources/`) |
| `switcher_decompiled/ble_switcher_scan.py` | 초기에 만든 0x00~0xFF 브루트포스 스캐너. **이제 불필요** (프로토콜을 다 알아냈고, 길이는 애초에 다른 characteristic이라 15BA를 두드려선 안 나온다) |

의존성: `pip install bleak`

## 문서 내 경로 규약

디컴파일 소스 경로는 아래를 기준으로 한 상대경로로 적는다.

```
switcher_decompiled/switcher_decompiled/sources/
```

즉 `kr/switcher/ioble/protocol/SwitcherBLEProtocol.java:13`은 실제로
`switcher_decompiled/switcher_decompiled/sources/kr/switcher/ioble/protocol/SwitcherBLEProtocol.java`
의 13번째 줄이다. 리소스(문자열)는 `switcher_decompiled/switcher_decompiled/resources/`
아래이며 `resources/res/values/strings.xml`처럼 적는다.

앱 소스의 큰 구조:

| 패키지 | 역할 |
|---|---|
| `kr/switcher/ioble/` | 순수 BLE 계층 (UUID 정의, GATT 연결, characteristic 읽기/쓰기, 스캐너) |
| `kr/switcher/device/` | 기기 도메인 모델 (`Switcher`, 예약 데이터, 버전 비교, 클라우드 어댑터) |
| `kr/switcher/switcherm/` | 안드로이드 UI/서비스/위젯/DB/REST (프로토콜과 무관한 껍데기가 대부분) |

스위치 제어에 필요한 진실은 거의 전부 앞의 두 패키지에 있다. `switcherm/`은 "앱이 이 값을
어떤 상황에서 쓰는가"를 확인할 때만 본다.

---

# 1. 현재 구현 상태

| 기능 | 구현 | 실기기 검증 |
|---|---|---|
| 기기 스캔 (이름/MAC/시리얼) | O | O (동작 확인됨) |
| 1구 ON/OFF | O | O |
| 2구 ON/OFF | O (단 명령값 이슈, §3.1) | 부분 |
| 손가락 길이 읽기/시험/저장 | O | **X — 미검증** |
| 배터리 잔량 읽기 | O | **X — 미검증** |
| 펌웨어 버전 읽기 | O | **X — 미검증** |
| 예약(타이머) 읽기/추가/삭제 | O | **X — 미검증** |
| 기기 시계 읽기/설정 | O | **X — 미검증** |
| 광고 패킷 파싱(타입/시리얼 자동 판별) | O | **X — 미검증** (오프셋 검증은 §2-1) |

인코딩/파싱은 `test_protocol.py` + `test_stroke.py`로 기기 없이 검증돼 있다(§11).
"실기기 검증 X"는 BLE 왕복과 기기의 실제 반응이 확인되지 않았다는 뜻이다.

---

# 2. 실기기 도착하면 바로 할 일 (검증 체크리스트)

이 저장소를 넘겨받은 에이전트는 **이 순서대로** 확인하면 된다. 각 항목의 근거는 §3~§6.

### 2-0. 사전 확인

- 스위처 본체 하단의 **빨간색 전원 스위치를 왼쪽으로** 옮겨 전원이 켜져 있어야 한다.
  켜지면 LED가 반짝인다. (`resources/res/values/strings.xml` → `troubleshooting_info1_2/1_3`)
- 리눅스/맥 어디서든 `bleak`이 BLE 어댑터를 잡을 수 있어야 한다.

### 2-1. 스캔해서 MAC 확보 + 광고 패킷 원본 확보 ★

```bash
python switcher_helper.py --dump-all
```

이름이 `SWITCHER`로 시작하는 기기를 찾는다 (`Switcher.SWITCHER_NAME = "SWITCHER"`,
`kr/switcher/device/switcher/Switcher.java:33`).

**그리고 manufacturer_data 원본 hex를 반드시 기록해 둘 것.** §4.4의 광고 패킷 레이아웃
(바이트 14 = 1구/2구 타입, 바이트 6~13 = 시리얼)이 bleak 기준으로 오프셋이 맞는지 확인하려면
실제 페이로드가 필요하다. 확인용 스니펫:

```python
import asyncio
from bleak import BleakScanner

async def dump():
    for d, adv in (await BleakScanner.discover(return_adv=True, timeout=8.0)).values():
        if not (d.name or "").upper().startswith("SWITCHER"):
            continue
        for cid, payload in (adv.manufacturer_data or {}).items():
            full = cid.to_bytes(2, "little") + payload   # 앱이 보던 바이트열 복원
            print(d.address, d.name, "len", len(full), full.hex())
            print("  mac   :", full[0:6].hex())
            print("  serial:", "".join(f"{b & 0x0F:X}" for b in full[6:14]))
            print("  type  :", full[14] if len(full) > 14 else "?")  # 1=1구, 2=2구
            print("  timerV:", full[15:].hex())
asyncio.run(dump())
```

기대: `mac`이 실제 MAC과 일치, `type`이 1 또는 2, `serial`이 8자리 hex.
**어긋나면 §4.4의 오프셋 해석이 틀린 것이므로 그 사실을 이 README에 반영할 것.**

### 2-2. 서비스가 8개인지 확인 ★

```python
import asyncio
from bleak import BleakClient

async def dump(mac):
    async with BleakClient(mac, timeout=30.0) as c:
        for s in c.services:
            print(s.uuid)
            for ch in s.characteristics:
                print("   ", ch.uuid, ch.properties)
asyncio.run(dump("AA:BB:CC:DD:EE:FF"))
```

앱은 서비스 개수가 **정확히 8개**가 아니면 GATT 캐시가 깨진 것으로 보고 복구 절차를 탄다
(`kr/switcher/ioble/protocol/CharacteristicStorage.java:8` `SERVICE_NUM = 8`,
`kr/switcher/ioble/switcher/connector/BLEGattConnector.java:63-70`). 8개가 아니면 캐시 문제일
수 있으니 재연결/재부팅 후 다시 볼 것. 이 덤프로 §4.1 표의 UUID가 실제로 존재하는지,
`15ba`/`15bb`의 properties(write 여부)도 같이 확인된다.

### 2-3. 손가락 길이 읽기 (최우선 미검증 항목) ★★

```bash
python switcher_helper.py --mac <MAC> --action stroke-read
```

기대: `stroke level = 0|1|2`. 앱이 기기 등록 시 항상 1(중간)로 초기화하므로
(`kr/switcher/switcherm/ui/register/interactor/SwitcherRegisterInteractor.java:104`)
한 번도 안 바꿨다면 1이 나올 가능성이 높다.

읽기가 실패하면 §6의 펌웨어 버전을 먼저 확인 — 길이 기능은 펌웨어 feature 6(=`0.6.x`) 이상
(`kr/switcher/device/switcher/SwitcherVersions.java:8` `FEATURE_STROKE = 6`).

### 2-4. 손가락 길이 시험 → 저장 ★★

```bash
python switcher_helper.py --mac <MAC> --action stroke-test --level 0   # 짧게 시험
python switcher_helper.py --mac <MAC> --action stroke-test --level 2   # 길게 시험
python switcher_helper.py --mac <MAC> --action stroke-set  --level 2   # 마음에 들면 저장
python switcher_helper.py --mac <MAC> --action stroke-read             # 저장됐는지 재확인
```

`stroke-test`는 저장하지 않고 그 길이로 **한 번 눌러보기만** 한다. 앱의 원래 UX가
"시험 → 확인 → 저장"이었고, 앱은 시험 후 2.5초 동안 UI를 잠근다
(`kr/switcher/switcherm/ui/setting/presenter/StrokeLevelPresenter.java:15` `DISABLE_TIME = 2500`).
연속 시험은 최소 2.5초 간격을 둘 것.

**2구라면 여기서 핵심 질문을 확인한다: 좌/우 발이 같이 움직이는가, 한쪽만 움직이는가.**
프로토콜상 길이 값은 기기당 1바이트 단일 값이라 채널 지정이 불가능하므로(§7) 둘 다 같은
레벨이 되는 것이 예상 동작이다. 만약 한쪽만 움직인다면 하위 니블에 채널 의미가 숨어 있을
가능성이 있으니 §8의 실험 항목으로 넘어갈 것.

### 2-5. 2구 ON 명령값 확인 ★★

현재 파이썬 코드는 2구 ON에 `0x05`를 쓰는데, **앱은 `0x02`를 쓴다** (§3.1). 어느 쪽이
맞는지, 혹은 둘 다 되는지 확인:

```python
import asyncio
from bleak import BleakClient
OP = "000015ba-0000-1000-8000-00805f9b34fb"

async def t(mac, byte):
    async with BleakClient(mac, timeout=30.0) as c:
        await c.write_gatt_char(OP, bytes([byte]), response=True)
asyncio.run(t("AA:BB:CC:DD:EE:FF", 0x02))   # 앱 기준 2구 ON
```

`0x00 / 0x01 / 0x02 / 0x03 / 0x05` 각각을 눌러보고 **어떤 발이 어느 방향으로 움직이는지
표로 기록**할 것. 결과에 따라 `switcher_core.py`의 `ON_KEY2`를 고칠지 결정한다.
지금은 동작 중인 코드라 임의로 바꾸지 않았다.

### 2-6. 배터리 / 펌웨어 버전 읽기

```bash
python switcher_helper.py --mac <MAC> --action battery
python switcher_helper.py --mac <MAC> --action firmware
```

기대: 배터리 0~100 (앱은 표시할 때 3을 뺀다, §5.2 — 코드는 원시값을 그대로 보여준다),
펌웨어 `0.x.y` (최신은 `0.8.8`). 길이 기능은 `0.6.x` 이상에서만 동작한다.

### 2-7. (선택) 예약/시계

구현은 끝났으니 검증만 남았다. 슬롯이 10개뿐이고 앱이 남긴 예약이 이미 들어있을 수 있으니,
**먼저 읽어서 현재 상태를 백업**한 뒤 건드릴 것.

```bash
python switcher_helper.py --mac <MAC> --action timer-read          # 백업 먼저
python switcher_helper.py --mac <MAC> --action clock-set           # 예약 전에 시계부터 (§3.4)
python switcher_helper.py --mac <MAC> --action clock-read
python switcher_helper.py --mac <MAC> --action timer-add --slot 0 --at 07:30 --days weekday
python switcher_helper.py --mac <MAC> --action timer-read          # 들어갔는지 확인
python switcher_helper.py --mac <MAC> --action timer-del --slot 0 --last
```

기대: `timer-read`가 방금 넣은 예약을 슬롯 0에서 돌려준다. 기기 시계가 안 맞으면 예약이
엉뚱한 시각에 뜨므로 `clock-set`이 선행이다. 마지막 예약을 지울 때만 `--last`
(그때만 timerVersion이 `FFFFFF`, §6.1).

---

# 3. BLE 프로토콜 — 쓰기 (앱이 기기에 쓰는 것 전부)

`kr/switcher/ioble/protocol/SwitcherBLEService.java`의 `writeService()` 호출을 전수조사한
결과 **앱이 쓰는 대상은 아래 4개뿐**이다. 힘/토크/속도/모터출력에 해당하는 쓰기 경로는
소스 전체에 존재하지 않는다.

| 대상 | characteristic | 크기 | 정의 위치 |
|---|---|---|---|
| ON/OFF 동작 | `000015ba` | 1B | `SwitcherBLEService.java:70` |
| 손가락 길이 | `000015bb` | 1B | `SwitcherBLEService.java:74` |
| 예약 추가 | `000015ca` | 10B | `SwitcherBLEService.java:78` |
| 예약 삭제 | `000015ca` | 10B | `SwitcherBLEService.java:86` |
| 기기 시계 | `000045ea` | 3B | `SwitcherBLEService.java:95` |

예약 패킷 크기를 이 문서가 한동안 9B로 잘못 적어뒀는데 **실제로는 10B**다.
추가는 `"00"`(1B) + 예약데이터 12자(6B) + timerVersion 6자(3B) = 20 hex = 10B이고,
삭제도 `"01"` + id 2자 + `"0000000000"`(5B) + timerVersion 6자 = 10B다. 즉 둘 다
`[op 1B][예약레코드 6B][timerVersion 3B]` 한 틀이고, 삭제는 레코드의 뒤 5바이트를 0으로 민다.

쓰기 방식은 두 종류다 (`SwitcherBLEService.java:32-44`):

- `writeService(String)` — hex 문자열을 `BLEUtil.hexStringToByteArray()`로 바이트 배열화 (예약/시계)
- `writeService(int)` — `setValue(i, FORMAT_UINT8=17, offset 0)`, 즉 1바이트 (동작/길이)

둘 다 `setWriteType(WRITE_TYPE_DEFAULT=2)` → **응답 있는 쓰기**. bleak에서는
`write_gatt_char(..., response=True)`.

## 3.1 ON/OFF 동작 (`000015ba`, 1바이트) ⚠️

`kr/switcher/device/switcher/Switcher.java:23-26`:

| 상수 | 값 |
|---|---|
| `ON_1WAY` | 0 |
| `OFF_1WAY` | 1 |
| `ON_2WAY` | **2** |
| `OFF_2WAY` | 3 |

이 값이 `controlSwitch(i)` → `writeSwitch(i)` → 1바이트로 그대로 전달된다
(`kr/switcher/device/switcher/ble/SwitcherBLE.java:183-192`).

실제로 UI가 넘기는 값도 0/1/2/3뿐이다:

- `kr/switcher/switcherm/ui/main/event/SwitcherOnOffController.java:16-37`
  — `onOneSetOn`→0, `onOneSetOff`→1, `onTwoSetOneOn`→0, `onTwoSetOneOff`→1,
  `onTwoSetTwoOn`→**2**, `onTwoSetTwoOff`→3
- 위젯도 동일: `kr/switcher/switcherm/ui/widget/presenter/TwoButtonWidgetPresenter.java:97-103`

**`0x05`는 앱 소스 어디에도 없다.** `switcher_core.py`의 `ON_KEY2 = "05"`는 참고했던
PySwitcherIO에서 온 값이다. OFF(`0x03`)는 앱과 일치한다. §2-5에서 검증할 항목.

## 3.2 손가락 길이 (`000015bb`, 1바이트)

앱 원본 (`kr/switcher/ioble/protocol/SwitcherBLEService.java:74`):

```java
public void writeStrokeLevel(int i, boolean z, ...) {
    writeService(Integer.parseInt(i + (z ? "1" : "0"), 16), strokeLevelChar, ...);
}
```

레벨 문자와 플래그 문자를 이어붙여 16진수로 파싱하므로 결국
**1바이트 = `(level << 4) | (test ? 1 : 0)`**.

> 디컴파일 결과에는 `"0"` 자리에 `Switcher.SwitcherReservation.SWITCH_1WAY_FIRMWARE`가
> 찍혀 있다. 이는 JADX가 같은 값(`"0"`)을 가진 상수로 치환한 흔적이며, 원본은 그냥
> 리터럴 `"0"`이다. 그 상수의 진짜 용도는 예약의 대상 구 지정(§6)이다.

| 레벨 | 이름 | 시험 (`test=True`) | 저장 (`test=False`) |
|---|---|---|---|
| 0 | 짧게 | `0x01` | `0x00` |
| 1 | 중간 (공장 기본) | `0x11` | `0x10` |
| 2 | 길게 | `0x21` | `0x20` |

관련 출처:

| 파일 | 내용 |
|---|---|
| `kr/switcher/ioble/protocol/SwitcherBLEProtocol.java:13` | `UUID_FOR_SWITCH_STROKE_LEVEL_CHARACTERISTIC = 000015BB-…` |
| `kr/switcher/device/switcher/Switcher.java:30-32` | `STROKE_LONG_LEVEL=2 / MEDIUM=1 / SHORT=0`, `INVALID_STROKE_LEVEL=-1`(`:22`) |
| `kr/switcher/device/switcher/ble/SwitcherBLE.java:257-268` | `updateStrokeLevel(level, test, cb)` |
| `kr/switcher/switcherm/ui/setting/fragment/StrokeLevelFragment.java:368` | `testStrokeLevel` → `updateStrokeLevel(i, true, null)` = 저장 안 함 |
| `kr/switcher/switcherm/ui/setting/fragment/StrokeLevelFragment.java:373` | `saveStrokeLevel` → `updateStrokeLevel(i, false, presenter)` = 저장 |
| `kr/switcher/switcherm/ui/setting/presenter/StrokeLevelPresenter.java:57-73` | 레벨 0/1/2 ↔ 짧게/중간/길게 UI 매핑 (`DISABLE_TIME=2500`은 `:15`) |
| `kr/switcher/switcherm/ui/setting/helper/PageViewer.java:14-39` | 레벨별 안내 문구/아이콘 |
| `kr/switcher/switcherm/ui/register/interactor/SwitcherRegisterInteractor.java:104` | 기기 등록 시 `updateStrokeLevel(1, false)` → 공장 기본 = 중간 |
| `kr/switcher/device/switcher/SwitcherVersions.java:8` | `FEATURE_STROKE = 6` (펌웨어 feature 6 이상 필요, 다른 곳에서 참조되진 않는 상수) |

### 어느 길이를 쓸지 — 앱 안내문 그대로

`resources/res/values/strings.xml`:

| 문자열 키 | 내용 |
|---|---|
| `stroke_level_menu` | "스위처 손가락 길이" |
| `stroke_level_small` / `_middle` / `_long` | "짧은 길이" / "중간 길이" / "긴 길이" |
| `stroke_level_medium_propose_message` | "기본 설정인 중간 길이입니다." |
| `stroke_level_long_situation` | **"작동하는 소리가 나지만 불이 안 켜져요."** → 긴 길이로 |
| `stroke_level_short_situation` | **"작동할 때마다 본체가 떨어지거나 덜컹거려요."** → 짧은 길이로 |
| `short_propose` / `long_propose` | "현재 최대로 짧은/긴 길이로 저장되어있습니다." |

## 3.3 예약 추가/삭제 (`000015ca`, 10바이트)

§6 참조.

## 3.4 기기 시계 (`000045ea`, 3바이트)

`kr/switcher/ioble/protocol/SwitcherBLEService.java:95-98` — `[요일, 시(24h), 분]`을 각
1바이트 hex로. **요일은 월=0, 화=1, …, 일=6** (`kr/switcher/ioble/common/BLEUtil.java:19`
`getDayOfWeekNumberForSwitcher()` — 자바 `Calendar.DAY_OF_WEEK`(일=1) 기준으로 `-2`,
음수면 6). 예약 기능을 쓰려면 이걸 먼저 맞춰야 한다.

이 요일 규약은 파이썬 `datetime.weekday()`와 정확히 같으므로 자바의 `-2` 보정을 옮길
필요가 없다. 구현은 `switcher_protocol.clock_bytes()` / `parse_clock()`,
`IOSwitcher.set_clock()` / `read_clock()`. 앱은 연결 직후 자동으로 시계를 써주는데
(`SwitcherProcessor.java:71` `saveRealTime()`) 우리 쪽은 `clock-set`을 명시할 때만 쓴다.

---

# 4. BLE 프로토콜 — 읽기 · 광고 · 연결

## 4.1 서비스 / characteristic 전체 (`kr/switcher/ioble/protocol/SwitcherBLEProtocol.java`)

| UUID (앞 8자리) | 이름 | 라인 | 앱 사용 |
|---|---|---|---|
| `0000150a` | 배터리 서비스 | 9 | - |
| `000015aa` | 배터리 잔량 | 10 | 읽기 |
| `0000150b` | 스위치 서비스 | 11 | - |
| `000015ba` | 동작(ON/OFF) | 12 | **쓰기** |
| `000015bb` | 손가락 길이 | 13 | **읽기+쓰기** |
| `0000150c` | 타이머 서비스 | 14 | - |
| `000015ca` | 예약 명령 | 15 | **쓰기** |
| `000025ca` | 예약 데이터(50B) | 16 | 읽기 |
| `000035ca` | timerUDRev | 17 | 저장만, **미사용** |
| `0000150d` | 권한 서비스 | 18 | - |
| `000025da` | 권한 상태 | 19 | 읽기 |
| `0000150e` | 기기정보 서비스 | 20 | - |
| `000015ea` | MAC 주소 | 21 | **미사용** |
| `000025ea` | 펌웨어 버전 | 22 | 읽기 |
| `000035ea` | 시리얼 번호 | 23 | 저장만, **미사용** (시리얼은 광고 패킷에서 얻는다) |
| `000045ea` | 실시간 시계 | 24 | 읽기+**쓰기** |

전체 UUID는 `xxxxxxxx-0000-1000-8000-00805f9b34fb` 형태 (`BASE_UUID_STRING`, `:7`).
서비스→characteristic 매핑 실체는 `kr/switcher/ioble/protocol/CharacteristicStorage.java:21-31`
(생성자에서 10개를 한 번에 잡아둔다. 여기서 `15ea`는 아예 빠져 있다).

## 4.2 읽기 값 파싱 (`kr/switcher/ioble/switcher/connector/CharacteristicReadParser.java`)

| 대상 | 라인 | 파싱 |
|---|---|---|
| 배터리 | 36 | 1바이트 → 그대로 퍼센트 |
| 권한 상태 | 40 | 1바이트 정수 |
| 예약 | 44 | **50바이트**를 hex 문자열로 |
| 펌웨어 버전 | 52 | 3바이트 → `"%d.%d.%d"` |
| 실시간 시계 | 56 | 3바이트 hex |
| 손가락 길이 | 64 | 1바이트 → `"%02x"` |
| 그 외 | 29-32 | 앞 4바이트를 십진수로 이어붙임 |

주의: 길이 읽기는 파서가 `"%02x"`(hex 문자열)로 만든 뒤
`kr/switcher/device/switcher/SwitcherProcessor.java:194-215`가 `Integer.parseInt(str)`로
**10진수 파싱**한다. 0/1/2에서는 hex와 10진수가 같아 문제가 없지만, 만약 기기가 `0x10`처럼
돌려주면 앱은 10으로 읽는다. 파이썬 구현은 원시 바이트를 그대로 쓰므로 이 함정이 없다.
(같은 함수의 `if (i == -1 && i > 2)`는 절대 참이 될 수 없는 앱 버그다.)

## 4.3 권한(authority) — 클라이언트 측 게이트

`kr/switcher/device/switcher/Switcher.java:17-20`:
`AUTHORITY_UNLOCK=0`, `AUTHORITY_LOCK=1`, `AUTHORITY_NOT_MATCH=2`, `AUTHORITY_UNKNOWN=-1`.

`kr/switcher/device/switcher/SwitcherProcessor.java:38-60`에서 값이 0이 아니면 앱이 **스스로**
연결 상태를 IDLE로 돌리고 화면을 이탈한다. 기기가 쓰기를 거부한다는 증거는 소스에 없다.
즉 **BLE로 직접 쓸 때 별도 인증/페어링 절차는 필요 없다.**
`changeShareCode`는 BLE(`ble/SwitcherBLE.java:35`)와 클라우드(`linker/SwitcherLinker.java:27`)
양쪽 다 **빈 스텁** — 공유코드는 서버 기능이었다.

## 4.4 광고(advertisement) 패킷 — 여기서 1구/2구와 시리얼을 알 수 있다

`kr/switcher/ioble/switcher/SwitcherAdvertisementPacket.java:33-45`. AD 타입 `0xFF`
(manufacturer-specific)을 찾아 `getData()`를 hex 문자열로 만든 뒤 자른다:

| hex 문자 구간 | = 바이트 | 내용 |
|---|---|---|
| `[0:12]` | 0-5 | MAC 주소 |
| `[13:14],[15:16],…,[27:28]` | 6-13 | 시리얼 8자리 — **각 바이트의 하위 니블만** 골라 이어붙인다 |
| `[28:30]` | 14 | **switcherType** (`Integer.parseInt`로 10진 파싱 → 1=1구, 2=2구) |
| `[30:]` | 15+ | timerVersion |

타입 상수는 `kr/switcher/device/switcher/Switcher.java:28-29`
(`SCANNED_SWITCHER_TYPE_ONE=1`, `..._TWO=2`). 패킷 생성은
`kr/switcher/device/switcher/ble/ScannedSwitcherMaker.java:8-14` (파싱 실패 시 null → 무시).

**bleak과의 오프셋 차이 (중요):** 번들된 neovisionaries 파서는
`com/neovisionaries/bluetooth/ble/advertising/ADPayloadParser.java:100`에서
`copyOfRange(bArr, i+2, i+len+1)` — 즉 length/type **다음 전체**를 데이터로 넘긴다.
manufacturer-specific의 앞 2바이트는 원래 company ID 자리이므로, 앱이 보던 바이트열에는
그 2바이트가 **포함**되어 있다(이 제조사는 company ID를 쓰지 않고 MAC부터 밀어넣었다).
반면 bleak의 `manufacturer_data`는 `{company_id: payload}`로 앞 2바이트를 키로 떼어낸다.
따라서 앱 기준 바이트열을 복원해야 한다:

```python
full = company_id.to_bytes(2, "little") + payload
mac    = full[0:6].hex()
serial = "".join(f"{b & 0x0F:X}" for b in full[6:14])   # 8자리 hex
gang   = full[14]        # 1 = 1구, 2 = 2구
timerv = full[15:].hex()
```

구현: `switcher_protocol.parse_adv()` → `Adv(mac, serial, gang, timer_version)`,
`switcher_helper.adv_info()`가 `manufacturer_data`를 훑어 첫 파싱 성공분을 쓴다.
이걸 넣으면서 기존 퍼지 시리얼 매칭(`match_serial` / `_serial_variants` /
`_match_device` / `_collect_tokens`, score 100/50/25) 약 60줄을 지웠고, `--serial`은
파싱된 시리얼과 정확 비교, `--type`은 광고의 `gang`으로 자동 판별한다.

**단 이 오프셋은 여전히 실기기 미검증이다(§2-1).** 어긋나면 `--type 1|2`를 수동으로
지정해 우회할 수 있게 남겨뒀고(명시하면 자동 판별을 이긴다), 되돌려야 하면 지운
60줄은 git 이력에 있다. `--mac`으로 스캔을 건너뛸 때는 광고를 못 보므로 `--type`
미지정 시 1구로 간주한다.

## 4.5 연결 시퀀스와 타임아웃

`kr/switcher/ioble/switcher/connector/BLEGattConnector.java`:

1. `connectGatt(context, false, ...)` — autoConnect=false (`:30-32`)
2. 연결 성공 후 **600ms 지연** 뒤 `discoverServices()` (`:41-48`)
3. 발견된 서비스가 **정확히 8개**면 준비 완료, 아니면 `repairAndOnDisconnect()` (`:61-70`)
   → disconnect → 1s 후 `createBond()` → 3s 후 `removeBond()` → 강제 재연결 유도 (`:72-84`)
4. 연결 해제 시 `BLEUtil.refreshCache()` + `gatt.close()` (`:34-38`)

`kr/switcher/device/switcher/SwitcherProcessor.java`의 준비 순서:
`onConnected()`(`:22`) → 배터리 읽기 → `onReadBattery()`(`:26`) → 권한 읽기 →
`onReadAuthority()`(`:38`) → 0이면 사용 가능. **직접 제어할 때 이 순서를 따를 필요는 없다.**

타임아웃 상수 (`kr/switcher/device/IODeviceConfig.java`):

| 상수 | 값 |
|---|---|
| `CONNECTION_TIME_OUT` | 10000 ms |
| `READ_TIME_OUT` | 8000 ms |
| `SCAN_TIME_OUT` | 10000 ms |
| `AFTER_CONNECTION_INTERVAL` | 1000 ms |
| `MAX_TIMER_NUM` | 10 |
| `INVALID_TIMER_DATA` | `"FFFFFFFFFF"` |
| `STATE_ON` / `STATE_OFF` | 0 / 1 |

권장 연결 거리는 개방 공간 30m (`strings.xml` → `troubleshooting_info2_1`).

## 4.6 앱은 언제 스캔하고, 연결은 언제까지 유지하나 (HA 연동 시 참고)

"HA에서 기기가 검색되지 않는다"를 추적하려면 앱이 실제로 어떻게 찾는지가 기준이 된다.
결론부터: **상시 스캔이 아니라 최대 10초짜리 버스트 스캔이고, 한 번 붙은 연결은 화면이
꺼질 때까지 유지한다.**

### 스캔 경로

```
SwitcherListPresenter:77 / SwitcherConnector:57 / IOService:124
  → kr/switcher/device/switcher/ble/BLEScanner.scanSwitcher(mac, cb)   :63
    → kr/switcher/ioble/scanner/BLEScanner.getScanner()   (싱글턴 :20)
      → BLENewScanner.startScan()   :31
        → nordic BluetoothLeScannerCompat.startScan(filters, settings, cb)
```

`kr/switcher/ioble/scanner/BLENewScanner.java:31-41`의 스캔 설정:

| 항목 | 값 | 의미 |
|---|---|---|
| `filters` | 빈 리스트 (`:14`, 채우는 코드 없음) | **하드웨어 필터 미사용 — 주변 BLE를 전부 받는다** |
| `setFilters(String)` (`:18`) | MAC 문자열만 저장 | 필터링은 소프트웨어로 `BLENewScanResult.java:36` |
| `setReportDelay(1000)` | 1초 배치 | 결과는 `onBatchScanResults`로만 옴 (`BLENewScanResult.java:32`) |
| `setUseHardwareBatchingIfSupported(false)` | 소프트웨어 배치 | |
| `setScanMode(2)` | SCAN_MODE_LOW_LATENCY | **액티브 스캔** (scan request를 보냄) |

매칭 기준 (`kr/switcher/device/switcher/ble/BLEScanResult.java:37-47`, 재확인
`kr/switcher/device/switcher/ble/BLEScanner.java:155-160`):

```java
name = bLEScanInfo.bluetoothDevice.getName();   // 광고 payload가 아니라 GATT 이름
if (name.contains("SWITCHER")) ...              // 302=이름 null, 303=SWITCHER 아님
```

이름이 맞으면 그때 제조사데이터(AD type 0xFF)를 파싱해 MAC/시리얼/타입을 뽑는다
(`kr/switcher/ioble/switcher/SwitcherAdvertisementPacket.java:33-44`, 레이아웃은 §4.4).

### 스캔은 상시가 아니다 — 최대 10초

- 하위: `ScanTimeTask.java:7,27` → 10초 뒤 `onTimeoutScan()` → `stopScan()` (`BLENewScanner:56`)
- 상위: `kr/switcher/device/switcher/ble/BLEScanner.java:78-80`에도 같은 10초 타임아웃
- 특정 MAC을 노린 연결이면 **첫 매칭 즉시 콜백 → 스캔 종료**
  (`BLEScanner.java:102-110`, `SwitcherConnector.java:137-144`의 `scanner.stopScan()`)
- 기기 목록 화면은 진입 시 1회 스캔(`SwitcherListPresenter:77`)이고, 2초 타이머
  (`ScanSwitcherInteractor:35,72`)는 스캔이 아니라 **이미 모인 결과로 UI만 갱신**한다
- `BLEScanner.SCAN_DURATION = 5000` (`ioble/scanner/BLEScanner.java:9`)은 아무도 안 쓰는 죽은 상수

### 연결 수명 — 붙으면 유지, 화면 꺼지면 끊음

`connectGatt(context, false, ...)` — **autoConnect=false**
(`kr/switcher/ioble/switcher/connector/BLEGattConnector.java:31`). 끊기면 자동 복구가 없고
**다시 스캔부터** 시작한다 (`SwitcherConnector.java:49-52`). 이후 시퀀스는 §4.5.

명령을 보낸 뒤 자동으로 끊지 않는다. 끊는 시점은 딱 셋:

| 시점 | 위치 |
|---|---|
| 화면 꺼짐 | `WidgetServicePresenter.java:193-202` → `WidgetService.java:235-238` `disconnectAll()` |
| 다른 스위처로 전환 | `MainPresenter.java:148-156` |
| 액티비티 종료 | `MainPresenter.java:161-163` |

그리고 중요한 지점 — **연결 전에 스캔보다 시스템 연결 목록을 먼저 본다**
(`kr/switcher/device/common/DeviceUtil.java:57-67`):

```java
BluetoothDevice d = getConnectedBluetoothDevice(mac, switcher);
if (d != null) { switcher.attachToDevice(new ScannedBLESwitcher(d, null)); return 1; }  // 스캔 생략
if (switcher.getAttachedDevice() == null) return 202;   // 202일 때만 스캔 시작
```

`getConnectedDeviceAddress()`는 `bluetoothManager.getConnectedDevices(GATT=7)`을 쓴다
(`DeviceUtil.java:93-108`). 즉 **앱 자체가 "연결 중이면 광고가 안 보인다"를 전제로 짜여 있다.**

### HA에서 검색이 안 될 때 — 유력한 순서

1. **누군가 이미 GATT를 물고 있다.** BLE 기기는 연결되면 대개 광고를 멈춘다. 폰 앱이
   백그라운드로 붙어 있거나(화면이 켜져 있으면 안 끊는다) BlueZ가 죽은 연결을 잡고 있으면
   HA 스캔에 안 뜬다. → 폰 앱 강제 종료 + 폰 블루투스 OFF, HA에서
   `bluetoothctl` → `disconnect <MAC>` / `remove <MAC>` 후 재시도.
2. **이름이 스캔 응답(scan response)에만 실려 있을 가능성.** 앱은 LOW_LATENCY = 액티브
   스캔이라 이름을 받지만, HA 호스트 BlueZ가 패시브 스캔이면 `name`이 비어 `SWITCHER`
   이름 매칭이 실패한다. → 이름 대신 **MAC 또는 manufacturer data로 매칭**할 것. 광고
   payload 앞 6바이트가 MAC이므로(§4.4) 이름 없이도 식별된다.
3. **스캔 시간이 짧다.** `switcher_helper.py`는 8초 기본. 앱은 10초 + LOW_LATENCY.
4. **스캔 없이 붙는 길이 있다.** 앱이 시스템 연결 목록으로 스캔을 건너뛰듯, bleak도
   `BleakClient("AA:BB:...")`로 MAC 직결이 된다(BlueZ 캐시가 있을 때).
   → `switcher_core.py::_connect()`에 3순위 fallback으로 넣어두었다. **미검증.**

---

# 5. 부가 정보

## 5.1 기기 하드웨어

번들된 `no/nordicsemi/android/dfu` (Nordic DFU 라이브러리)와
`kr/switcher/switcherm/ui/setting/fragment/DFUFragment.java`로 볼 때 **Nordic nRF 계열 MCU**를
쓰고 표준 Nordic DFU로 펌웨어를 올린다.

## 5.2 배터리

`000015aa` 1바이트 = 퍼센트. 단 앱은 표시할 때 보정한다:

- `kr/switcher/switcherm/ui/main/helper/BatteryInvalidInspector.java:16-17` — **3을 뺀다**
  (`value >= 3 ? value - 3 : value`)
- `kr/switcher/switcherm/ui/main/helper/BatteryLabelMaker.java:13-18` — 20% 이상 "배터리 충분함",
  그 아래는 "배터리 충전필요"
- `strings.xml` → `low_battery_noti_title` "배터리 부족" / `low_battery_noti_content`
  "스위처를 충전해 주세요!"

즉 하드웨어 판독값을 앱이 후보정하고 있었다. 잔량이 애매하면 이 -3을 감안할 것.

## 5.3 펌웨어 버전과 DFU

`kr/switcher/device/switcher/SwitcherVersions.java`:

| 항목 | 값 | 라인 |
|---|---|---|
| 최신 펌웨어 | `0.8.8` | 12 |
| 길이 기능 최소 feature | 6 (=`0.6.x`) | 8 |
| 1구 펌웨어 zip | `https://docs.google.com/uc?export=download&id=1dknxnxFlXvnYJZwGIRNpJ_0gTw70ckKx` | 9 |
| 2구 펌웨어 zip | `https://docs.google.com/uc?export=download&id=1dFic2_AgQmClqOqS1p7OR6MbsRqudej3` | 10 |

버전 문자열은 `앱.feature.hotfix` 3조각으로 비교한다(`:14-16`, `getVersionPieces`).
제품별 링크 선택은 `kr/switcher/switcherm/ui/setting/interactor/FindSettingInfoInteractor.java:65-74`
(`SWITCHER_TYPE_ONE`→1_SET, `SWITCHER_TYPE_TWO`→2_SET). 제품 종류 열거는
`kr/switcher/device/IODevice.java:21-27` (`SWITCHER_TYPE_ONE, SWITCHER_TYPE_TWO, LINKER, REMOCON, CHECKER`).

이 링크들은 **죽은 API 서버를 거치지 않고 소스에 상수로 박혀 있어** 아직 살아있을 가능성이 있다.
다만 **DFU 실패 시 기기가 벽돌이 되고 A/S가 없다.** 잘 동작하는 기기라면 손대지 말 것.
(펌웨어 링크 조회 API `requestGetFirmwareLink`도 있지만
`kr/switcher/switcherm/network/http/RestSwitcherAPIStore.java:394` — 서버가 죽어 무의미.)

## 5.4 클라우드 API (모두 무의미)

`kr/switcher/switcherm/network/http/RestSwitcher.java:8-11`:
`https://io-switcher-prod.switcher.kr/v3/mobile/` (dev: `io-switcher-dev...`).
OAuth 토큰이 필요하고 서비스가 종료됐다. 원격 제어는 별도 하드웨어인 **Linker**(와이파이 허브)를
통한 방식이었고(`kr/switcher/device/switcher/linker/`), 허브+서버가 없으면 재현 불가.
`kr/switcher/switcherm/signal/`(배터리/예약 푸시 알림)도 서버 기능.

## 5.5 다른 제품군 (이 저장소와 무관)

`Checker`(문열림 감지), `Linker`(와이파이 허브), `Remocon`(IR 리모컨 — 에어컨/셋톱박스)이
같은 앱에 들어있다. 각각 `kr/switcher/ioble/checker/`, `kr/switcher/ioble/linker/`,
`kr/switcher/device/remocon/`. 스위치 프로토콜과 겹치지 않으므로 무시해도 된다.

---

# 6. 예약(타이머) 프로토콜

구현: `switcher_protocol.py`의 `Reservation` / `reservation_record()` /
`timer_version()` / `add_timer_packet()` / `remove_timer_packet()` /
`parse_reservations()`, `switcher_core.py`의 `IOSwitcher.read_reservations()` /
`add_reservation()` / `remove_reservation()`. 인코딩은 `test_protocol.py`로 검증됨,
실기기 왕복은 미검증(§2-7).

`Reservation`은 앱의 am/pm 필드를 버리고 24시간제만 쓴다 (am/pm은 앱 12시간제 UI 때문에
있던 것이고, 기기에 나가는 바이트는 어차피 24시간제다). 요일은 `0=월 … 6=일` 집합으로
받는다 — 기기 요일 규약과 같다(§3.4).

## 6.1 추가 (`000015ca`에 10바이트)

`kr/switcher/ioble/protocol/SwitcherBLEService.java:78-84` — 쓰는 hex는
`"00"` + 예약데이터(12자) + timerVersion(6자).

예약데이터 6바이트는 `kr/switcher/device/switcher/Switcher.java:267-292`
(`SwitcherReservation.getResrvDataForBLE`):

| 바이트 | 내용 | 근거 라인 |
|---|---|---|
| 0 | 슬롯 id (0~9) | 269 |
| 1 | 비트7=월, 6=화, 5=수, 4=목, 3=금, 2=토, 1=일, **비트0=enable**<br>(요일/enable을 8자리 2진 문자열로 만들어 `parseInt(…, 2)`) | 270 |
| 2 | 시 (24시간제. am 12시→0, pm은 +12, pm 12시는 그대로) | 271-279 |
| 3 | 분 | 280 |
| 4 | 대상 구: `0`=1구/첫번째, `1`=2구 두번째 | 281 |
| 5 | `0`=켜기, `1`=끄기 (`light ? 0 : 1`) | 283 |

`timerVersion`은 `kr/switcher/device/switcher/Switcher.java:294-303`
(`makeTimerVersion(boolean)`): 인자가 true면 현재 **시/분/초**를 각 1바이트 hex로
(예: 14시32분07초 → `0e2007`), false면 `"FFFFFF"`(예약을 전부 비울 때).

대상 구 값의 정체는 `Switcher.java:193-194`의
`SWITCH_1WAY_FIRMWARE = "0"` / `SWITCH_2WAY_FIRMWARE = "1"`이고, 기본값 세팅은
`kr/switcher/switcherm/ui/setting/helper/SwitcherReservationCreator.java:20`.
**이 상수의 용도가 예약 대상 지정임이 확인되므로, `writeStrokeLevel`에 같은 상수가 보였던 것은
디컴파일러의 리터럴 치환일 뿐이다** (§3.2 주석).

추가/수정 진입점: `kr/switcher/device/switcher/ble/SwitcherBLE.java:194-217`
(`addReservation` → 10개 초과면 에러코드 106, `updateReservation` → 중복이면 112).

## 6.2 삭제 (`000015ca`에 10바이트)

`SwitcherBLEService.java:86-93` — `"01"` + id(2자) + `"0000000000"` + timerVersion(6자).

id 변환에 `BLEUtil.hexToHexString()`(`kr/switcher/ioble/common/BLEUtil.java:38-47`)을 쓰는데,
이 함수는 문자열의 각 문자를 십진수로 읽어 `%02x`로 이어붙이는 괴상한 변환이다.
`"3"` → `"03"`은 맞지만 `"10"` → `"0100"`(4자)이 되어 길이 검사(`!= 2`)에 걸려
**슬롯 id 10 삭제가 조용히 실패하는 앱 버그**가 있다. 슬롯은 0~9만 쓰면 안전하다.
`remove_timer_packet()`은 0~9를 벗어난 슬롯을 `ValueError`로 거부한다 — 조용히 실패하는
대신 터지게 해둔 것.

`timerVersion`은 `SwitcherBLE.java:227`이 `makeTimerVersion(sResrvs.size() > 1)`을 쓴다.
즉 **지우고 나면 남는 예약이 없을 때만** `FFFFFF`다 → `remove_reservation(slot, last=True)`
/ CLI `--last`.

## 6.3 읽기 (`000025ca`, 50바이트)

`kr/switcher/device/switcher/SwitcherProcessor.java:123-163`.
**10슬롯 × 5바이트** = 50바이트. 쓰기와 달리 **id 바이트가 없고 슬롯 위치가 곧 id**다:

| 바이트 | 내용 |
|---|---|
| 0 | 요일 비트마스크 + enable (쓰기 바이트1과 동일, `BLEUtil.hexToBinary`로 8자리 2진 변환) |
| 1 | 시 (24h. 앱은 0→12am, 12 미만→am, 12~23→pm으로 변환) |
| 2 | 분 |
| 3 | 대상 구 |
| 4 | `0`=켜기 |

빈 슬롯은 `FFFFFFFFFF` (`IODeviceConfig.INVALID_TIMER_DATA`). 시가 24 이상이면 앱은
"Invalid time format" 로그를 남기고 파싱을 중단한다(`:155-158`).

---

# 7. 할 수 없는 것 (확정)

- **누르는 힘/토크/속도 조절 불가.** 디컴파일 소스 전체에서 force/torque/power/pwm/speed/
  strength에 해당하는 쓰기 경로가 0건이고, §3의 쓰기 대상 4개가 전부다. 펌웨어 고정값이며
  공식 앱에도 그런 메뉴가 없었다. 눌리는 깊이를 바꾸는 손가락 길이가 사실상 유일한 수단이다.
- **2구 좌/우 개별 길이 설정 불가.** `000015bb`는 기기당 1바이트 단일 값이고 상위 니블(레벨)과
  하위 니블(시험 플래그)이 이미 다 쓰여 채널 인덱스를 넣을 자리가 없다. 예약(`15ca`)에는
  대상 구 바이트가 있는데 길이에는 없다는 점이 이를 뒷받침한다.
  → 두 발의 높이·힘 차이는 설정이 아니라 기구 편차/설치 문제로 봐야 한다(§9).
- **원격(인터넷) 제어 불가.** Linker 허브 + 죽은 API 서버가 필요(§5.4).
- `000015ea`(MAC), `000035ea`(시리얼), `000035ca`(timerUDRev)는 앱이 읽지 않는다. 존재하는지도
  §2-2 덤프로 확인해볼 가치는 있다.

---

# 8. 미검증 실험 아이디어 (필요할 때만)

앱이 쓰지 않는 영역이라 **동작 보장이 없고 최악의 경우 기기가 이상해질 수 있다.**
정말 3단계보다 세밀한 제어가 필요할 때만, 그리고 §2 검증이 다 끝난 뒤에 시도할 것.

- `000015bb`에 레벨 `3` 이상(`0x30`, `0x40`, …) — 중간 단계가 더 있는지. `stroke_byte()`가
  0/1/2만 허용하므로 우회해서 직접 써야 한다.
- 하위 니블에 `2` 이상 — 시험/저장 외의 의미(예: 채널 지정)가 숨어 있는지.
  §2-4에서 2구의 한쪽만 움직이는 현상이 관찰됐다면 여기를 파볼 근거가 된다.
- `000015ba`에 `4`~`0xFF` — `0x05`가 실제로 뭘 하는지 포함해서 (§2-5).
  `switcher_decompiled/ble_switcher_scan.py`가 이 용도의 브루트포스 스캐너였다.

---

# 9. 하드웨어 · 설치 (제조사 공식 안내)

`resources/res/values/strings.xml`:

- `troubleshooting_info5` — **"스위처는 스위치 버튼을 기준으로 11자로 정중앙에 위치하여 있어야
  정상적인 작동이 됩니다."** 설치 후에도 불을 못 켜면 고객센터 문의 안내.
- `troubleshooting_info4` — "혹시 너무 빠르게 누르셨거나, 너무 살살 누르셨나요? 잘 눌리지 않는
  경우가 많다면 스위처 속 소프트웨어적인 결함일 수 있습니다."
- `troubleshooting_info1_2` — 전원: 제품 하단 **빨간색 스위치를 왼쪽으로**. 켜지면 LED 반짝임.
- `troubleshooting_info2_1` — 권장 연결거리 개방 공간 30m, 장애물 있으면 감소.

즉 발 높이·힘의 좌우 차이는 제조사도 **설정이 아니라 정렬/설치 문제**로 안내했다.
소프트웨어로는 양쪽을 같은 레벨로만 움직일 수 있으므로, 안 눌리는 쪽은 본체 위치 조정이나
얇은 심(테이프 등)으로 잡는 것이 정석이다.

---

# 10. 사용법

```bash
# 주변 기기 전체 스캔
python switcher_helper.py --dump-all

# 현재 저장된 손가락 길이 확인
python switcher_helper.py --mac D4:AD:8B:C9:60:7C --action stroke-read

# 길게(2)로 저장 없이 시험 동작
python switcher_helper.py --mac D4:AD:8B:C9:60:7C --action stroke-test --level 2

# 길게(2)로 저장
python switcher_helper.py --mac D4:AD:8B:C9:60:7C --action stroke-set --level 2

# ON/OFF (2구는 --type 2 → 현재 ON에 0x05를 쓴다. §2-5 확인 필요)
python switcher_helper.py --mac D4:AD:8B:C9:60:7C --action on --type 2

# 배터리 / 펌웨어 / 기기 시계
python switcher_helper.py --mac D4:AD:8B:C9:60:7C --action battery
python switcher_helper.py --mac D4:AD:8B:C9:60:7C --action firmware
python switcher_helper.py --mac D4:AD:8B:C9:60:7C --action clock-read
python switcher_helper.py --mac D4:AD:8B:C9:60:7C --action clock-set    # 지금 시각으로

# 예약 — 읽기 → 추가 → 삭제
python switcher_helper.py --mac D4:AD:8B:C9:60:7C --action timer-read
python switcher_helper.py --mac D4:AD:8B:C9:60:7C --action timer-add \
    --slot 0 --at 07:30 --days weekday               # 평일 7시30분 켜기
python switcher_helper.py --mac D4:AD:8B:C9:60:7C --action timer-add \
    --slot 1 --at 23:00 --days mon,wed,fri --off --target 1   # 2구 두번째 발 끄기
python switcher_helper.py --mac D4:AD:8B:C9:60:7C --action timer-del --slot 0
```

`--mac` 대신 `--name SWITCHER_M` 또는 `--serial 9EF02EE6`으로도 찾을 수 있고, 후보가 여러 개면
`--index N`으로 고른다. `--days`는 `mon,tue,...` 나열 또는 `all` / `weekday` / `weekend`.
`--slot`은 0~9(기기 슬롯이 10개), 같은 슬롯에 쓰면 덮어쓴다. 마지막 예약을 지울 때만
`--action timer-del --slot N --last`.

`--type`은 생략하면 광고 패킷에서 1구/2구를 자동 판별한다(§4.4, 미검증이므로 어긋나면 수동 지정).

파이썬에서 직접:

```python
import asyncio
from switcher_core import IOSwitcher

sw = IOSwitcher("D4:AD:8B:C9:60:7C", type=2)
print(asyncio.run(sw.read_stroke_level()))            # 0 / 1 / 2
asyncio.run(sw.set_stroke_level(2, test=True))        # 시험 동작 (저장 안 함)
asyncio.run(sw.set_stroke_level(2))                   # 저장
asyncio.run(sw.turn_on())
```

```python
from datetime import datetime
from switcher_core import IOSwitcher
from switcher_protocol import Reservation

sw = IOSwitcher("D4:AD:8B:C9:60:7C", type=2)
print(asyncio.run(sw.read_battery()))                 # 0~100 (원시값)
print(asyncio.run(sw.read_firmware()))                # "0.8.8"
print(asyncio.run(sw.read_clock()))                   # (요일 0=월, 시, 분)
asyncio.run(sw.set_clock())                           # 지금 시각으로 (예약 전에 선행)
print(asyncio.run(sw.read_reservations()))            # [Reservation, ...]
asyncio.run(sw.add_reservation(
    Reservation(slot=0, hour=7, minute=30, days={0, 1, 2, 3, 4})))
asyncio.run(sw.remove_reservation(0, last=True))      # 마지막 예약일 때만 last=True
```

구현 위치: 인코딩/파싱은 전부 `switcher_protocol.py`(bleak 비의존)에 있고
`switcher_core.py`가 re-export하므로 `switcher_core.stroke_byte()`처럼 써도 된다.
BLE 왕복은 `IOSwitcher._sendcommand()`(쓰기)와 `_read()`(읽기) 둘뿐이고, 양쪽 다
`char_uuid` 인자로 같은 연결/재시도 로직을 모든 characteristic에 재사용한다.

## 알려진 코드 주의사항

- **write characteristic 자동 선택.** `switcher_core.py::_find_characteristic_uuid()`와
  iOS `Switcher/Switcher/BLE/BLEManager.swift:237`은 서비스 `150b`에서 *첫 번째 쓰기 가능
  characteristic*을 고른다. 그 서비스에는 `15ba`(동작)와 `15bb`(길이)가 함께 있으므로,
  ON/OFF가 길이만 바꾸는 증상이 나오면
  `IOSwitcher(char_uuid="000015ba-0000-1000-8000-00805f9b34fb")`로 못 박을 것.
  길이 관련 메서드는 `000015bb`를 명시적으로 지정하므로 영향받지 않는다.
- `read_stroke_level()`도 `_connect()`를 거치므로 위 자동 선택이 실패하면 같이 실패한다.
- iOS 앱(`Switcher/`)에는 길이 조절이 없다. ON/OFF만 보낸다.
- **스캔 실패 시 MAC 직결 fallback (미검증).** `switcher_core.py::_connect()`는 MAC 검색 →
  이름 검색 → 그래도 없으면 `BleakClient(mac)`으로 바로 연결을 시도한다. 기기가 이미 다른
  쪽에 연결돼 광고를 멈춘 경우를 노린 것으로, 근거와 한계는 §4.6. BlueZ 캐시가 없으면
  여기서도 실패하므로 "검색 안 됨"의 만능 해결책은 아니다.

---

# 11. 테스트

```bash
python test_protocol.py
# OK: 예약 10B 추가/삭제, 50B 읽기 왕복, 시계 요일, 펌웨어, 광고 패킷

python test_stroke.py
# OK: 0x00/0x01, 0x10/0x11, 0x20/0x21
```

둘 다 기기 없이 도는 인코딩/파싱 검증이고, 앱 원본식을 파이썬에서 다시 계산해 대조하는
방식이다. `test_protocol.py`는 `switcher_protocol.py`만 import하므로 **bleak 없이도
돌아간다**; `test_stroke.py`는 `switcher_core`를 거치므로 bleak이 필요하다.

- `test_stroke.py` — 앱 원본식 `Integer.parseInt(str(level) + flag, 16)` 대조, 기기 등록
  기본값 `0x10`, 잘못된 레벨(3) 거부
- `test_protocol.py` — 예약 레코드 6B를 앱 `getResrvDataForBLE()`의 문자열 연산까지 그대로
  재현해 대조, 추가/삭제 패킷이 10B인지, 50B 읽기 왕복, 빈 슬롯(`FFFFFFFFFF`) 건너뛰기,
  시가 24 이상이면 파싱 중단, 슬롯 10 거부, `timerVersion` FFFFFF/시각, 요일 7개를 자바
  `Calendar.DAY_OF_WEEK - 2` 공식과 대조, 펌웨어 문자열, 광고 패킷의 하위 니블 시리얼

BLE 왕복은 어느 쪽도 검증하지 않는다 — 실기기 검증은 §2 체크리스트로.

---

# 12. 다음에 할 만한 작업

우선순위 순.

기능 구현은 §1 표의 항목이 전부 끝났다. **남은 건 실기기 검증뿐이고, 그게 지금 유일한 병목이다.**

1. **§2 체크리스트 수행** — 특히 2-3/2-4(길이 실동작)와 2-5(2구 `0x02` vs `0x05`).
   결과를 이 README에 반영할 것.
2. **§2-1로 광고 패킷 오프셋 확인** — `--type` 자동 판별과 `--serial` 정확 매칭이 여기에
   전부 걸려 있다. 어긋나면 §4.4를 고치고 `parse_adv()`의 오프셋을 맞출 것.
3. **§2-7로 예약/시계 검증** — 기기 시계(`clock-set`) → 예약 추가 → `timer-read`로 왕복 확인.
   기존 예약을 먼저 백업할 것.
4. 검증이 끝나면 그때 결정할 것들:
   - `ON_KEY2`를 `0x05` → `0x02`로 고칠지 (§2-5 결과에 따라)
   - `_find_characteristic_uuid()` 자동 선택을 `000015ba` 고정으로 바꿀지 (§10 주의사항)
   - iOS 앱(`Switcher/`)에 길이/예약을 옮길지 — 지금은 ON/OFF만 있다
