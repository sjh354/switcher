package kr.switcher.switcherm.ui.setting.helper;

import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.device.IODeviceHandler;
import kr.switcher.switcherm.user.UserStateManager;

/* JADX INFO: loaded from: classes2.dex */
public class SettingListUtil {
    public static boolean checkIsValidData(String str) {
        if (!IOUtil.checkIsIODeviceKey(str)) {
            IOUtil.showToast(IOUtil.getStringResource(R.string.not_found_connected_macaddress));
            return false;
        }
        if (UserStateManager.getInstance().getCurrentUserFromDB() == null) {
            IOUtil.showToast(IOUtil.getStringResource(R.string.not_found_user));
            return false;
        }
        if (IODeviceHandler.getInstance().getDevice(str) != null) {
            return true;
        }
        IOUtil.showToast(IOUtil.getStringResource(R.string.not_found_connected_macaddress));
        return false;
    }

    public static boolean isMainSwitcher(String str, String str2) {
        if (IOUtil.checkIsIODeviceKey(str2)) {
            return str2.equalsIgnoreCase(str);
        }
        return false;
    }

    public static boolean isEqualSwitcherOwnerAndHost(String str, String str2) {
        return str.equals(str2);
    }
}
