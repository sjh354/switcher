import SwiftUI
import CoreBluetooth

struct DeviceListView: View {
    @StateObject private var ble = BLEManager()

    var body: some View {
        List(ble.discovered) { device in
            NavigationLink(value: device) {
                HStack {
                    VStack(alignment: .leading, spacing: 2) {
                        Text(device.name)
                            .font(.headline)
                        Text(device.peripheral.identifier.uuidString)
                            .font(.caption2)
                            .foregroundStyle(.secondary)
                            .lineLimit(1)
                    }
                    Spacer()
                    Text("\(device.rssi) dBm")
                        .font(.caption)
                        .foregroundStyle(.secondary)
                }
                .padding(.vertical, 4)
            }
        }
        .navigationTitle("Switcher 장치")
        .navigationDestination(for: SwitcherDevice.self) { device in
            ControlView(device: device, ble: ble)
        }
        .toolbar {
            ToolbarItem(placement: .navigationBarTrailing) {
                Button(ble.isScanning ? "스캔 중지" : "스캔") {
                    ble.isScanning ? ble.stopScan() : ble.startScan()
                }
            }
        }
        .overlay {
            if ble.discovered.isEmpty {
                ContentUnavailableView(
                    ble.isScanning ? "스캔 중…" : "장치 없음",
                    systemImage: ble.isScanning ? "antenna.radiowaves.left.and.right" : "bluetooth",
                    description: Text(ble.isScanning ? "주변 SWITCHER 장치를 검색하고 있습니다" : "스캔 버튼을 눌러 장치를 검색하세요")
                )
            }
        }
        .onAppear { ble.startScan() }
        .onDisappear { ble.stopScan() }
    }
}
