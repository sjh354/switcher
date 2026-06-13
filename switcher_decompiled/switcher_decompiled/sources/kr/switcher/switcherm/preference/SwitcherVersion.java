package kr.switcher.switcherm.preference;

import kr.switcher.switcherm.ui.switcherList.SwitcherListActivity;

/* JADX INFO: loaded from: classes2.dex */
public class SwitcherVersion extends PreferenceHelper {
    private static final String FILE_NAME = "SWITCHER_VERSION";
    private String KEY_MAC_ADDRESS = SwitcherListActivity.INTENT_PARM_MAC_ADDRESS;
    private String KEY_LINK = "LINK";

    @Override // kr.switcher.switcherm.preference.PreferenceHelper
    public String getFileName() {
        return FILE_NAME;
    }

    public void setLastVersion(String str) {
        setString(this.KEY_MAC_ADDRESS, str);
    }

    public String getLastVersion() {
        return getString(this.KEY_MAC_ADDRESS, "");
    }

    public void setLink(String str) {
        setString(this.KEY_LINK, str);
    }

    public String getLink() {
        return getString(this.KEY_LINK, "");
    }
}
