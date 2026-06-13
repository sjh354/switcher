package kr.switcher.switcherm.preference;

/* JADX INFO: loaded from: classes2.dex */
public class MirrorSwitchButtonPreference extends PreferenceHelper {
    private static final String FILE_NAME = "MIRROR_SWITCH_BUTTON_BADGE";
    private String KEY_FCM_TOKEN = "MIRROR";
    private boolean isChecked = false;

    @Override // kr.switcher.switcherm.preference.PreferenceHelper
    public String getFileName() {
        return FILE_NAME;
    }

    public void setMirrorSwitchButtonPreference(boolean z) {
        if (context != null) {
            setBoolean(this.KEY_FCM_TOKEN, z);
        }
        this.isChecked = z;
    }

    public boolean getMirrorSwitchButtonChecked() {
        if (context != null) {
            return getBoolean(this.KEY_FCM_TOKEN, false);
        }
        return this.isChecked;
    }
}
