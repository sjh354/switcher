package kr.switcher.switcherm.preference;

/* JADX INFO: loaded from: classes2.dex */
public class AutoBluetoothPreference extends PreferenceHelper {
    private static final String FILE_NAME = "AUTO_BLUETOOTH_SETTING";
    private String KEY_AUTO_BLUETOOTH = "AUTO_BLUETOOTH";

    @Override // kr.switcher.switcherm.preference.PreferenceHelper
    public String getFileName() {
        return FILE_NAME;
    }

    public void setAutoBluetooth(Boolean bool) {
        setBoolean(this.KEY_AUTO_BLUETOOTH, bool.booleanValue());
    }

    public Boolean getAutoBluetooth() {
        return Boolean.valueOf(getBoolean(this.KEY_AUTO_BLUETOOTH, true));
    }
}
