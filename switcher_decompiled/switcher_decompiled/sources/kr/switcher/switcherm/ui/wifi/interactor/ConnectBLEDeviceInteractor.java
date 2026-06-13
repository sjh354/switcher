package kr.switcher.switcherm.ui.wifi.interactor;

import android.os.Handler;
import android.os.Looper;
import kr.switcher.device.IODevice;
import kr.switcher.device.checker.ScannedBLEChecker;
import kr.switcher.device.common.DeviceUtil;
import kr.switcher.device.common.ScannedBLEDevice;
import kr.switcher.device.linker.Linker;
import kr.switcher.device.linker.ScannedBLELinker;
import kr.switcher.device.switcher.interfaces.IODeviceCallbacks;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.device.checker.CheckerHandler;
import kr.switcher.switcherm.device.linker.LinkerHandler;
import kr.switcher.switcherm.device.switcher.handler.SwitcherHandler;

/* JADX INFO: loaded from: classes2.dex */
public class ConnectBLEDeviceInteractor {
    private OnBLEConnectDeviceListener listener;
    private ScannedBLEDevice scannedBLEDevice;

    public interface OnBLEConnectDeviceListener {
        void onConnect(IODevice iODevice);

        void onConnecting();

        void onFail();
    }

    public ConnectBLEDeviceInteractor(ScannedBLEDevice scannedBLEDevice, OnBLEConnectDeviceListener onBLEConnectDeviceListener) {
        this.scannedBLEDevice = scannedBLEDevice;
        this.listener = onBLEConnectDeviceListener;
    }

    public void connectDevice() {
        SwitcherHandler.getInstance().disconnectAll();
        if (this.scannedBLEDevice.getClass().equals(ScannedBLELinker.class)) {
            connectLinker((ScannedBLELinker) this.scannedBLEDevice);
        } else if (this.scannedBLEDevice.getClass().equals(ScannedBLEChecker.class)) {
            connectChecker((ScannedBLEChecker) this.scannedBLEDevice);
        }
    }

    private void connectLinker(ScannedBLELinker scannedBLELinker) {
        String strMakeLocalMacAddressFormat = IOUtil.makeLocalMacAddressFormat(scannedBLELinker.getAdvertisementPacket().getMacAddress());
        if (!DeviceUtil.checkIsBluetoothAddress(strMakeLocalMacAddressFormat) && LinkerHandler.getInstance().getMainLinker() != null) {
            strMakeLocalMacAddressFormat = LinkerHandler.getInstance().getMainLinker().getMacAddress();
        }
        Linker linker = LinkerHandler.getInstance().getLinker(strMakeLocalMacAddressFormat);
        linker.attachToDevice(scannedBLELinker);
        linker.connect(new IODeviceCallbacks.OnDeviceConnectListener() { // from class: kr.switcher.switcherm.ui.wifi.interactor.ConnectBLEDeviceInteractor.1
            @Override // kr.switcher.device.switcher.interfaces.IODeviceCallbacks.OnDeviceConnectListener
            public void onConnected(final IODevice iODevice) {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: kr.switcher.switcherm.ui.wifi.interactor.ConnectBLEDeviceInteractor.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ConnectBLEDeviceInteractor.this.listener.onConnect(iODevice);
                    }
                });
            }

            @Override // kr.switcher.device.switcher.interfaces.IODeviceCallbacks.OnDeviceConnectListener
            public void onDisconnected(String str, int i) {
                ConnectBLEDeviceInteractor.this.listener.onFail();
            }
        });
        this.listener.onConnecting();
    }

    private void connectChecker(ScannedBLEChecker scannedBLEChecker) {
        String strMakeLocalMacAddressFormat = IOUtil.makeLocalMacAddressFormat(scannedBLEChecker.getAdvertisementPacket().getMacAddress());
        if (!DeviceUtil.checkIsBluetoothAddress(strMakeLocalMacAddressFormat)) {
            this.listener.onFail();
        } else {
            CheckerHandler.getInstance().getChecker(strMakeLocalMacAddressFormat).connect(new IODeviceCallbacks.OnDeviceConnectListener() { // from class: kr.switcher.switcherm.ui.wifi.interactor.ConnectBLEDeviceInteractor.2
                @Override // kr.switcher.device.switcher.interfaces.IODeviceCallbacks.OnDeviceConnectListener
                public void onConnected(IODevice iODevice) {
                    ConnectBLEDeviceInteractor.this.listener.onConnect(iODevice);
                }

                @Override // kr.switcher.device.switcher.interfaces.IODeviceCallbacks.OnDeviceConnectListener
                public void onDisconnected(String str, int i) {
                    ConnectBLEDeviceInteractor.this.listener.onFail();
                }
            });
        }
    }
}
