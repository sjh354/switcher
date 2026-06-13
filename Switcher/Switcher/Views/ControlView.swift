import SwiftUI

struct ControlView: View {
    let device: SwitcherDevice
    @ObservedObject var ble: BLEManager

    private var isBusy: Bool { ble.status == .connecting }

    var body: some View {
        VStack(spacing: 32) {
            statusBanner

            Divider()

            VStack(spacing: 16) {
                Text("버튼 1")
                    .font(.title2).bold()
                HStack(spacing: 20) {
                    commandButton("켜기", color: .green)  { await ble.send(.button1On,  to: device) }
                    commandButton("끄기", color: .red)    { await ble.send(.button1Off, to: device) }
                }
            }

            VStack(spacing: 16) {
                Text("버튼 2")
                    .font(.title2).bold()
                HStack(spacing: 20) {
                    commandButton("켜기", color: .green)  { await ble.send(.button2On,  to: device) }
                    commandButton("끄기", color: .red)    { await ble.send(.button2Off, to: device) }
                }
            }

            Spacer()
        }
        .padding(24)
        .navigationTitle(device.name)
        .navigationBarTitleDisplayMode(.inline)
        .onDisappear {
            // 목록 화면 돌아가면 상태 초기화
            if ble.status != .connecting { ble.status = .idle }
        }
    }

    // MARK: - Status Banner

    @ViewBuilder
    private var statusBanner: some View {
        switch ble.status {
        case .idle:
            EmptyView()
        case .connecting:
            Label("연결 중…", systemImage: "antenna.radiowaves.left.and.right")
                .foregroundStyle(.orange)
                .font(.subheadline)
        case .success:
            Label("명령 전송 성공", systemImage: "checkmark.circle.fill")
                .foregroundStyle(.green)
                .font(.subheadline)
        case .failure(let msg):
            Label(msg, systemImage: "exclamationmark.triangle.fill")
                .foregroundStyle(.red)
                .font(.subheadline)
                .multilineTextAlignment(.center)
        }
    }

    // MARK: - Button Helper

    private func commandButton(_ label: String, color: Color, action: @escaping () async -> Void) -> some View {
        Button {
            Task { await action() }
        } label: {
            Text(label)
                .font(.title3).bold()
                .frame(width: 100, height: 50)
        }
        .buttonStyle(.borderedProminent)
        .tint(color)
        .disabled(isBusy)
    }
}
