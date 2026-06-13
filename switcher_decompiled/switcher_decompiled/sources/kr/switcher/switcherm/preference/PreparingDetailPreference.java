package kr.switcher.switcherm.preference;

import kr.switcher.switcherm.common.util.IOLog;

/* JADX INFO: loaded from: classes2.dex */
public class PreparingDetailPreference extends PreferenceHelper {
    private static final String FILE_NAME = "REQUEST";
    private static final String TAG = "PreparingDetailPreference";
    private String KEY_REQUEST_LIST = "REQUEST_LIST";

    @Override // kr.switcher.switcherm.preference.PreferenceHelper
    public String getFileName() {
        return FILE_NAME;
    }

    public void setRequestListJson(String str, String str2) {
        IOLog.d(TAG, "tried to set Request List Json : " + str2);
        setString(str + "." + this.KEY_REQUEST_LIST, str2);
    }

    public String getRequestListJson(String str) {
        return getString(str + "." + this.KEY_REQUEST_LIST, "");
    }
}
