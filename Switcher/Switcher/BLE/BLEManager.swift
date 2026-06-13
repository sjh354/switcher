import CoreBluetooth
import Combine

// MARK: - Command

enum Command: UInt8 {
    case button1On  = 0x00
    case button1Off = 0x01
    case button2On  = 0x05
    case button2Off = 0x03
}

// MARK: - SendStatus

enum SendStatus: Equatable {
    case idle
    case connecting
    case success
    case failure(String)
}

// MARK: - BLEManager

@MainActor
final class BLEManager: NSObject, ObservableObject {

    // MARK: Published

    @Published var discovered: [SwitcherDevice] = []
    @Published var isScanning: Bool = false
    @Published var status: SendStatus = .idle

    // MARK: Constants

    private let serviceUUID      = CBUUID(string: "0000150b-0000-1000-8000-00805f9b34fb")
    private let nameFilter       = "SWITCHER"
    private let maxRetries       = 5
    private let retryDelay: TimeInterval  = 2.0
    private let connectTimeout: TimeInterval = 10.0   // per-attempt

    // MARK: Private state

    private var central: CBCentralManager!
    private var isBusy = false

    private var activePeripheral: CBPeripheral?
    private var pendingCommand: UInt8 = 0x00
    private var continuation: CheckedContinuation<Void, Error>?
    private var timeoutTask: Task<Void, Never>?

    private enum State { case idle, connecting, discoveringServices, discoveringChars, writing }
    private var state: State = .idle

    override init() {
        super.init()
        central = CBCentralManager(delegate: self, queue: .main)
    }

    // MARK: Scan

    func startScan() {
        guard central.state == .poweredOn else { return }
        discovered.removeAll()
        isScanning = true
        central.scanForPeripherals(withServices: nil)
    }

    func stopScan() {
        central.stopScan()
        isScanning = false
    }

    // MARK: Send

    func send(_ command: Command, to device: SwitcherDevice) async {
        guard !isBusy else { return }
        isBusy = true
        status = .connecting

        var lastError: Error = BLEError.unknown
        for attempt in 0..<maxRetries {
            if attempt > 0 {
                try? await Task.sleep(nanoseconds: UInt64(retryDelay * 1_000_000_000))
            }
            do {
                try await attemptSend(command: command.rawValue, peripheral: device.peripheral)
                status = .success
                isBusy = false
                return
            } catch {
                lastError = error
            }
        }

        status = .failure(lastError.localizedDescription)
        isBusy = false
    }

    // MARK: - Single attempt

    private func attemptSend(command: UInt8, peripheral: CBPeripheral) async throws {
        stopScan()
        try await withCheckedThrowingContinuation { (cont: CheckedContinuation<Void, Error>) in
            self.pendingCommand = command
            self.activePeripheral = peripheral
            self.continuation = cont
            self.state = .connecting
            peripheral.delegate = self
            self.central.connect(peripheral, options: nil)
            self.scheduleTimeout()
        }
    }

    // MARK: - Timeout

    private func scheduleTimeout() {
        timeoutTask?.cancel()
        // @MainActor context에서 생성 → Task body도 @MainActor에서 실행
        timeoutTask = Task { [weak self] in
            guard let self else { return }
            try? await Task.sleep(nanoseconds: UInt64(self.connectTimeout * 1_000_000_000))
            guard !Task.isCancelled else { return }
            self.fail(with: BLEError.timeout)
        }
    }

    private func cancelTimeout() {
        timeoutTask?.cancel()
        timeoutTask = nil
    }

    // MARK: - Helpers

    private func fail(with error: Error) {
        cancelTimeout()
        state = .idle
        if let p = activePeripheral {
            central.cancelPeripheralConnection(p)
        }
        activePeripheral = nil
        guard let cont = continuation else { return }
        continuation = nil
        cont.resume(throwing: error)
    }

    private func succeed() {
        cancelTimeout()
        state = .idle
        guard let cont = continuation else { return }
        continuation = nil
        cont.resume()
        if let p = activePeripheral {
            central.cancelPeripheralConnection(p)
        }
        activePeripheral = nil
    }
}

// MARK: - CBCentralManagerDelegate

extension BLEManager: CBCentralManagerDelegate {

    func centralManagerDidUpdateState(_ central: CBCentralManager) {
        if central.state == .poweredOn {
            startScan()
        } else {
            isScanning = false
            if continuation != nil { fail(with: BLEError.bluetoothUnavailable) }
        }
    }

    func centralManager(_ central: CBCentralManager,
                        didDiscover peripheral: CBPeripheral,
                        advertisementData: [String: Any],
                        rssi RSSI: NSNumber) {
        let name = peripheral.name ?? ""
        guard name.uppercased().contains(nameFilter) else { return }

        let device = SwitcherDevice(peripheral: peripheral, rssi: RSSI.intValue)
        if let idx = discovered.firstIndex(where: { $0.id == device.id }) {
            discovered[idx] = device
        } else {
            discovered.append(device)
        }
    }

    func centralManager(_ central: CBCentralManager, didConnect peripheral: CBPeripheral) {
        guard state == .connecting, peripheral === activePeripheral else { return }
        state = .discoveringServices
        peripheral.discoverServices([serviceUUID])
    }

    func centralManager(_ central: CBCentralManager,
                        didFailToConnect peripheral: CBPeripheral,
                        error: Error?) {
        guard peripheral === activePeripheral else { return }
        fail(with: error ?? BLEError.connectFailed)
    }

    func centralManager(_ central: CBCentralManager,
                        didDisconnectPeripheral peripheral: CBPeripheral,
                        error: Error?) {
        guard peripheral === activePeripheral else { return }
        // 정상 종료(succeed 후)엔 continuation이 이미 nil → 아무것도 안 함
        // 예기치 못한 끊김엔 hang 방지용 에러 종료
        if continuation != nil {
            fail(with: error ?? BLEError.disconnected)
        }
    }
}

// MARK: - CBPeripheralDelegate

extension BLEManager: CBPeripheralDelegate {

    func peripheral(_ peripheral: CBPeripheral, didDiscoverServices error: Error?) {
        guard state == .discoveringServices, peripheral === activePeripheral else { return }
        if let error { fail(with: error); return }

        guard let service = peripheral.services?.first(where: { $0.uuid == serviceUUID }) else {
            fail(with: BLEError.serviceNotFound); return
        }
        state = .discoveringChars
        peripheral.discoverCharacteristics(nil, for: service)
    }

    func peripheral(_ peripheral: CBPeripheral,
                    didDiscoverCharacteristicsFor service: CBService,
                    error: Error?) {
        guard state == .discoveringChars, peripheral === activePeripheral else { return }
        if let error { fail(with: error); return }

        guard let chars = service.characteristics, !chars.isEmpty else {
            fail(with: BLEError.charNotFound); return
        }

        // write 가능 characteristic 선택: .write 우선, 없으면 .writeWithoutResponse, 둘 다 없으면 첫 번째
        let char: CBCharacteristic
        if let c = chars.first(where: { $0.properties.contains(.write) }) {
            char = c
        } else if let c = chars.first(where: { $0.properties.contains(.writeWithoutResponse) }) {
            char = c
        } else {
            char = chars[0]
        }

        state = .writing
        let data = Data([pendingCommand])

        if char.properties.contains(.write) {
            // withResponse: didWriteValueFor 콜백에서 성공 확정
            peripheral.writeValue(data, for: char, type: .withResponse)
        } else {
            // withoutResponse: 콜백 없음 → writeValue 반환 직후 성공
            peripheral.writeValue(data, for: char, type: .withoutResponse)
            succeed()
        }
    }

    func peripheral(_ peripheral: CBPeripheral,
                    didWriteValueFor characteristic: CBCharacteristic,
                    error: Error?) {
        guard state == .writing, peripheral === activePeripheral else { return }
        if let error { fail(with: error); return }
        succeed()
    }
}

// MARK: - BLEError

enum BLEError: LocalizedError {
    case bluetoothUnavailable
    case connectFailed
    case disconnected
    case serviceNotFound
    case charNotFound
    case timeout
    case unknown

    var errorDescription: String? {
        switch self {
        case .bluetoothUnavailable: return "블루투스를 사용할 수 없습니다"
        case .connectFailed:        return "장치 연결에 실패했습니다"
        case .disconnected:         return "연결이 끊겼습니다"
        case .serviceNotFound:      return "서비스를 찾을 수 없습니다"
        case .charNotFound:         return "Characteristic을 찾을 수 없습니다"
        case .timeout:              return "연결 시간이 초과되었습니다"
        case .unknown:              return "알 수 없는 오류가 발생했습니다"
        }
    }
}
