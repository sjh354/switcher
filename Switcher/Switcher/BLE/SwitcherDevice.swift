import CoreBluetooth

struct SwitcherDevice: Identifiable, Hashable {
    let id: UUID
    let name: String
    let rssi: Int
    let peripheral: CBPeripheral

    init(peripheral: CBPeripheral, rssi: Int) {
        self.id = peripheral.identifier
        self.name = peripheral.name ?? "Unknown"
        self.rssi = rssi
        self.peripheral = peripheral
    }

    static func == (lhs: SwitcherDevice, rhs: SwitcherDevice) -> Bool { lhs.id == rhs.id }
    func hash(into hasher: inout Hasher) { hasher.combine(id) }
}
