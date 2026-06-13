package kr.switcher.switcherm.ui.main.interactors;

import kr.switcher.device.IODevice;
import kr.switcher.device.common.DeviceUtil;
import kr.switcher.device.linker.Linker;
import kr.switcher.device.linker.ScannedBLELinker;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.device.IODeviceHandler;
import kr.switcher.switcherm.device.linker.LinkerHandler;
import kr.switcher.switcherm.ui.main.interactors.FindSwitcherToConnectInteractor;

/* JADX INFO: loaded from: classes2.dex */
public class FindLinkerToConnectInteractor {
    private static final String TAG = "FindLinkerToConnectInteractor";
    private FindSwitcherToConnectInteractor.OnFindSwitcherToConnectListener listener;

    public void setOnFindSwitcherToConnectListener(FindSwitcherToConnectInteractor.OnFindSwitcherToConnectListener onFindSwitcherToConnectListener) {
        this.listener = onFindSwitcherToConnectListener;
    }

    public void createLinker(final ScannedBLELinker scannedBLELinker) {
        final String strMakeLocalMacAddressFormat = IOUtil.makeLocalMacAddressFormat(scannedBLELinker.getAdvertisementPacket().getMacAddress());
        if (!DeviceUtil.checkIsBluetoothAddress(strMakeLocalMacAddressFormat) && LinkerHandler.getInstance().getMainLinker() != null) {
            strMakeLocalMacAddressFormat = LinkerHandler.getInstance().getMainLinker().getMacAddress();
        }
        Linker linker = (Linker) IODeviceHandler.getInstance().getDevice(strMakeLocalMacAddressFormat);
        if (linker != null) {
            linker.attachToDevice(scannedBLELinker);
            this.listener.onCreateResult(linker != null, strMakeLocalMacAddressFormat);
        } else {
            IODeviceHandler.getInstance().createDeviceByMacAddress(strMakeLocalMacAddressFormat, false, new IODeviceHandler.OnCreateIODeviceListener() { // from class: kr.switcher.switcherm.ui.main.interactors.FindLinkerToConnectInteractor.1
                @Override // kr.switcher.switcherm.device.IODeviceHandler.OnCreateIODeviceListener
                public void onFailure(String str, String str2) {
                }

                @Override // kr.switcher.switcherm.device.IODeviceHandler.OnCreateIODeviceListener
                public void onSuccess(IODevice iODevice) {
                    try {
                        iODevice.attachToDevice(scannedBLELinker);
                        IODeviceHandler.getInstance().addDevice(iODevice);
                        FindLinkerToConnectInteractor.this.listener.onCreateResult(iODevice != null, strMakeLocalMacAddressFormat);
                    } catch (ClassCastException unused) {
                    }
                }
            });
        }
        IOLog.i(TAG, "createLinkedDevices switcher (mac address:" + strMakeLocalMacAddressFormat + ")");
    }
}
