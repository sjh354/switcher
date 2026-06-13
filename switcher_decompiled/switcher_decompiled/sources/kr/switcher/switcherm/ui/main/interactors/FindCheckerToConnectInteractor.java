package kr.switcher.switcherm.ui.main.interactors;

import kr.switcher.device.IODevice;
import kr.switcher.device.checker.Checker;
import kr.switcher.device.checker.ScannedBLEChecker;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.device.IODeviceHandler;
import kr.switcher.switcherm.ui.main.interactors.FindSwitcherToConnectInteractor;

/* JADX INFO: loaded from: classes2.dex */
public class FindCheckerToConnectInteractor {
    private static final String TAG = "FindCheckerToConnectInteractor";
    private FindSwitcherToConnectInteractor.OnFindSwitcherToConnectListener listener;

    public void setOnFindSwitcherToConnectListener(FindSwitcherToConnectInteractor.OnFindSwitcherToConnectListener onFindSwitcherToConnectListener) {
        this.listener = onFindSwitcherToConnectListener;
    }

    public void createChecker(final ScannedBLEChecker scannedBLEChecker) {
        final String strMakeLocalMacAddressFormat = IOUtil.makeLocalMacAddressFormat(scannedBLEChecker.getAdvertisementPacket().getMacAddress());
        Checker checker = (Checker) IODeviceHandler.getInstance().getDevice(strMakeLocalMacAddressFormat);
        if (checker != null) {
            checker.attachToDevice(scannedBLEChecker);
            this.listener.onCreateResult(checker != null, strMakeLocalMacAddressFormat);
        } else {
            IODeviceHandler.getInstance().createDeviceByMacAddress(strMakeLocalMacAddressFormat, false, new IODeviceHandler.OnCreateIODeviceListener() { // from class: kr.switcher.switcherm.ui.main.interactors.FindCheckerToConnectInteractor.1
                @Override // kr.switcher.switcherm.device.IODeviceHandler.OnCreateIODeviceListener
                public void onFailure(String str, String str2) {
                }

                @Override // kr.switcher.switcherm.device.IODeviceHandler.OnCreateIODeviceListener
                public void onSuccess(IODevice iODevice) {
                    try {
                        iODevice.attachToDevice(scannedBLEChecker);
                        IODeviceHandler.getInstance().addDevice(iODevice);
                        FindCheckerToConnectInteractor.this.listener.onCreateResult(iODevice != null, strMakeLocalMacAddressFormat);
                    } catch (ClassCastException unused) {
                    }
                }
            });
        }
        IOLog.i(TAG, "createLinkedDevices switcher (mac address:" + strMakeLocalMacAddressFormat + ")");
    }
}
