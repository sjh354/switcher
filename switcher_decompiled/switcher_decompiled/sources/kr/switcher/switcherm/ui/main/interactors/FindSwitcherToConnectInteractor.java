package kr.switcher.switcherm.ui.main.interactors;

import kr.switcher.device.IODevice;
import kr.switcher.device.switcher.Switcher;
import kr.switcher.device.switcher.SwitcherConnector;
import kr.switcher.device.switcher.ble.BLEScanner;
import kr.switcher.device.switcher.ble.ScannedBLESwitcher;
import kr.switcher.device.switcher.interfaces.IODeviceCallbacks;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.device.IODeviceHandler;
import kr.switcher.switcherm.device.switcher.handler.SwitcherHandler;

/* JADX INFO: loaded from: classes2.dex */
public class FindSwitcherToConnectInteractor implements IODeviceCallbacks.SwitcherConnectionResultCallback {
    private static final String TAG = "FindSwitcherToConnectInteractor";
    private OnFindSwitcherToConnectListener listener;

    public interface OnFindSwitcherToConnectListener {
        void onConnectResult(int i, Switcher switcher);

        void onConnectionStateResult(Switcher switcher, int i);

        void onCreateResult(boolean z, String str);
    }

    public void setOnFindSwitcherToConnectListener(OnFindSwitcherToConnectListener onFindSwitcherToConnectListener) {
        this.listener = onFindSwitcherToConnectListener;
    }

    public void connectSwitcher(ScannedBLESwitcher scannedBLESwitcher, String str, String str2) {
        connectSwitcher(scannedBLESwitcher, str);
    }

    public void connectSwitcher(final ScannedBLESwitcher scannedBLESwitcher, final String str) {
        Switcher switcherInitSwitcher = initSwitcher(str);
        if (switcherInitSwitcher == null) {
            IODeviceHandler.getInstance().createDeviceByMacAddress(str, false, new IODeviceHandler.OnCreateIODeviceListener() { // from class: kr.switcher.switcherm.ui.main.interactors.FindSwitcherToConnectInteractor.1
                @Override // kr.switcher.switcherm.device.IODeviceHandler.OnCreateIODeviceListener
                public void onFailure(String str2, String str3) {
                }

                @Override // kr.switcher.switcherm.device.IODeviceHandler.OnCreateIODeviceListener
                public void onSuccess(IODevice iODevice) {
                    FindSwitcherToConnectInteractor.this.connectSwitcher(scannedBLESwitcher, str);
                }
            });
            return;
        }
        if (scannedBLESwitcher != null) {
            switcherInitSwitcher.attachToDevice(scannedBLESwitcher);
        }
        this.listener.onConnectResult(new SwitcherConnector(switcherInitSwitcher, new BLEScanner(), this).connectSwitcher(), switcherInitSwitcher);
    }

    public void createSwitcher(final String str, final ScannedBLESwitcher scannedBLESwitcher) {
        Switcher switcher = (Switcher) IODeviceHandler.getInstance().getDevice(str);
        if (switcher != null) {
            switcher.attachToDevice(scannedBLESwitcher);
        } else {
            IODeviceHandler.getInstance().createDeviceByMacAddress(str, false, new IODeviceHandler.OnCreateIODeviceListener() { // from class: kr.switcher.switcherm.ui.main.interactors.FindSwitcherToConnectInteractor.2
                @Override // kr.switcher.switcherm.device.IODeviceHandler.OnCreateIODeviceListener
                public void onFailure(String str2, String str3) {
                }

                @Override // kr.switcher.switcherm.device.IODeviceHandler.OnCreateIODeviceListener
                public void onSuccess(IODevice iODevice) {
                    try {
                        ((Switcher) iODevice).attachToDevice(scannedBLESwitcher);
                        IODeviceHandler.getInstance().addDevice(iODevice);
                        FindSwitcherToConnectInteractor.this.listener.onCreateResult(iODevice != null, str);
                    } catch (ClassCastException unused) {
                    }
                }
            });
        }
        IOLog.i(TAG, "createLinkedDevices switcher (mac address:" + str + ")");
    }

    public Switcher initSwitcher(String str) {
        Switcher switcher = SwitcherHandler.getInstance().getSwitcher(str);
        if (switcher == null) {
            return null;
        }
        switcher.setConnectionState(Switcher.ConnectionState.IDLE);
        return switcher;
    }

    @Override // kr.switcher.device.switcher.interfaces.IODeviceCallbacks.SwitcherConnectionResultCallback
    public void onConnectionStateResult(Switcher switcher, int i) {
        this.listener.onConnectionStateResult(switcher, i);
        SwitcherHandler.getInstance().update(switcher);
        if (i != 0) {
            IOLog.deviceLog(switcher.getMacAddress(), IOLog.DEVICE_LOG_TYPE_CONNECT, String.valueOf(i));
        }
    }
}
