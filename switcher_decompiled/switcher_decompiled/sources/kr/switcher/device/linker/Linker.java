package kr.switcher.device.linker;

import android.util.Log;
import java.util.List;
import java.util.UUID;
import kr.switcher.device.IODevice;
import kr.switcher.device.common.DeviceUtil;
import kr.switcher.device.switcher.interfaces.IODeviceCallbacks;
import kr.switcher.ioble.linker.connector.LinkerBLEConnectionInfo;
import kr.switcher.ioble.linker.connector.LinkerBLEGattConnector;
import kr.switcher.ioble.linker.protocol.LinkerBLEService;
import kr.switcher.ioble.switcher.connector.CharacteristicParser;

/* JADX INFO: loaded from: classes2.dex */
public class Linker extends IODevice implements LinkerBLEGattConnector.LinkerBLEConnectionStatusListener {
    public static final int IR_PRODUCT_AIRCON = 1;
    public static final int IR_PRODUCT_CUSTOM = 3;
    public static final int IR_PRODUCT_SETTOP = 2;
    public static final int IR_PRODUCT_TV = 0;
    public static final String LINKER_NAME = "LINKER";
    public static final String TAG = "Linker";
    private LinkerBLEConnectionInfo connectionInfo;
    private LinkerBLEGattConnector connector;

    public interface OnCreateLinkedDeviceListener {
        void onFailure(String str, String str2);

        void onSuccess(List<String> list);
    }

    public interface OnWifiSSIDSendListener {
        void onWifiSSIDSendResult(boolean z);
    }

    public Linker(String str) {
        initialize(str);
    }

    public Linker(String str, ScannedBLELinker scannedBLELinker) {
        super(str, scannedBLELinker);
        initialize(str);
    }

    private void initialize(String str) {
        this.macAddress = str;
        this.connector = new LinkerBLEGattConnector(new LinkerBLEService(), this);
        this.productId = IODevice.ProductId.LINKER;
    }

    @Override // kr.switcher.device.IODevice
    public ScannedBLELinker getAttachedDevice() {
        return (ScannedBLELinker) this.scannedBLEDevice;
    }

    @Override // kr.switcher.device.IODevice
    public int connect(IODeviceCallbacks.OnDeviceConnectListener onDeviceConnectListener) {
        super.connect(onDeviceConnectListener);
        this.listener = onDeviceConnectListener;
        if (this.scannedBLEDevice != null && this.scannedBLEDevice.getDevice() != null) {
            this.connector.connectBLEDevice(DeviceUtil.getContext(), this.scannedBLEDevice.getDevice());
            return 1;
        }
        onDeviceConnectListener.onDisconnected(this.macAddress, 202);
        return 1;
    }

    @Override // kr.switcher.device.IODevice
    public void disconnect() {
        LinkerBLEConnectionInfo linkerBLEConnectionInfo = this.connectionInfo;
        if (linkerBLEConnectionInfo == null) {
            return;
        }
        this.connector.disconnectBLEDevice(linkerBLEConnectionInfo.getBluetoothGatt());
        reset();
        if (this.listener != null) {
            this.listener.onDisconnected(this.macAddress, 1);
        }
    }

    private void reset() {
        this.scannedBLEDevice = null;
        this.connectionInfo = null;
    }

    @Override // kr.switcher.ioble.linker.connector.LinkerBLEGattConnector.LinkerBLEConnectionStatusListener
    public void onConnected(LinkerBLEConnectionInfo linkerBLEConnectionInfo) {
        Log.i(TAG, "linker ble connected (mac address:" + linkerBLEConnectionInfo.getMacAddress() + ")");
        this.connectionInfo = linkerBLEConnectionInfo;
        this.listener.onConnected(this);
    }

    @Override // kr.switcher.ioble.linker.connector.LinkerBLEGattConnector.LinkerBLEConnectionStatusListener
    public void onDisconnected(String str, int i) {
        this.listener.onDisconnected(str, i);
    }

    private boolean checkIsConnectionInfo() {
        if (this.connectionInfo != null) {
            return true;
        }
        if (this.listener != null) {
            this.listener.onDisconnected(this.macAddress, 0);
        }
        return false;
    }

    public void sendWifiInfo(String str, final String str2, final OnWifiSSIDSendListener onWifiSSIDSendListener) {
        if (checkIsConnectionInfo()) {
            this.connectionInfo.getBLEService().writeWifiSSID(str, new CharacteristicParser.WriteServiceListener() { // from class: kr.switcher.device.linker.Linker.1
                @Override // kr.switcher.ioble.switcher.connector.CharacteristicParser.WriteServiceListener
                public void onWriteServiceResult(boolean z, UUID uuid) {
                    if (z) {
                        Linker.this.connectionInfo.getBLEService().writeWifiPassword(str2, new CharacteristicParser.WriteServiceListener() { // from class: kr.switcher.device.linker.Linker.1.1
                            @Override // kr.switcher.ioble.switcher.connector.CharacteristicParser.WriteServiceListener
                            public void onWriteServiceResult(boolean z2, UUID uuid2) {
                                onWifiSSIDSendListener.onWifiSSIDSendResult(true);
                            }
                        });
                    } else {
                        onWifiSSIDSendListener.onWifiSSIDSendResult(false);
                    }
                }
            });
        }
    }
}
