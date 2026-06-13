package kr.switcher.switcherm.ui.main.helper;

import java.util.List;
import kr.switcher.device.IODevice;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.device.IODeviceHandler;
import kr.switcher.switcherm.device.switcher.handler.SwitcherUtil;
import kr.switcher.switcherm.user.UserStateManager;

/* JADX INFO: loaded from: classes2.dex */
public class BLEConnectionManager {
    private static final String TAG = "BLEConnectionManager";

    public static String getSwitcherToAutoConnect() {
        String connectedMySwitcherAddress = getConnectedMySwitcherAddress();
        return (IOUtil.checkIsIODeviceKey(connectedMySwitcherAddress) || UserStateManager.getInstance().getCurrentUserFromDB() == null) ? connectedMySwitcherAddress : UserStateManager.getInstance().getCurrentUserFromDB().getMainSwitcherCode();
    }

    private static String getConnectedMySwitcherAddress() {
        List<IODevice> deviceAll = IODeviceHandler.getInstance().getDeviceAll();
        for (String str : SwitcherUtil.getConnectedDeviceAddress()) {
            for (IODevice iODevice : deviceAll) {
                if (str.equals(iODevice.getMacAddress())) {
                    return iODevice.getMacAddress();
                }
            }
        }
        return "not_connected";
    }
}
