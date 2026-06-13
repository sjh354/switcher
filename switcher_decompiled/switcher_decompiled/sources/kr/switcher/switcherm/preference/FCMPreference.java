package kr.switcher.switcherm.preference;

import com.google.firebase.messaging.FirebaseMessaging;

/* JADX INFO: loaded from: classes2.dex */
public class FCMPreference extends PreferenceHelper {
    private static final String FILE_NAME = "FCM_BADGE";
    private String KEY_FCM_TOKEN = FirebaseMessaging.INSTANCE_ID_SCOPE;
    private String token = null;

    @Override // kr.switcher.switcherm.preference.PreferenceHelper
    public String getFileName() {
        return FILE_NAME;
    }

    public void setFCMPreference(String str) {
        if (context != null) {
            setString(this.KEY_FCM_TOKEN, str);
        }
        this.token = str;
    }

    public String getFCMToken() {
        if (context != null) {
            return getString(this.KEY_FCM_TOKEN, "");
        }
        return this.token;
    }
}
