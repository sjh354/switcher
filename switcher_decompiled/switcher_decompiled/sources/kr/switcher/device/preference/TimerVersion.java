package kr.switcher.device.preference;

import android.util.Log;
import kr.switcher.switcherm.ui.switcherList.SwitcherListActivity;

/* JADX INFO: loaded from: classes2.dex */
public class TimerVersion extends PreferenceHelper {
    private static final String FILE_NAME = "TIMER_VERSION";
    private String KEY_MAC_ADDRESS = SwitcherListActivity.INTENT_PARM_MAC_ADDRESS;

    @Override // kr.switcher.device.preference.PreferenceHelper
    public String getFileName() {
        return FILE_NAME;
    }

    public void setTimerVersion(String str) {
        Log.d("switcher", "tried to set Timer version");
        setString(this.KEY_MAC_ADDRESS, str);
    }

    public String getTimerVersion() {
        return getString(this.KEY_MAC_ADDRESS, "");
    }
}
