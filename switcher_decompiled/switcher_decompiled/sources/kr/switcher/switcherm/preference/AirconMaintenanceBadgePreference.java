package kr.switcher.switcherm.preference;

/* JADX INFO: loaded from: classes2.dex */
public class AirconMaintenanceBadgePreference extends PreferenceHelper {
    private static final String FILE_NAME = "AIRCON_MAINTENANCE_BADGE";
    private String KEY_MAINTENANCE_BADGE = "MAINTENANCE_BADGE";
    private boolean isFirst = true;

    @Override // kr.switcher.switcherm.preference.PreferenceHelper
    public String getFileName() {
        return FILE_NAME;
    }

    public void setMaintenanceBadge(boolean z) {
        if (context != null) {
            setBoolean(this.KEY_MAINTENANCE_BADGE, z);
        }
        this.isFirst = z;
    }

    public boolean getMaintenanceBadge() {
        Boolean boolValueOf;
        if (context != null) {
            boolValueOf = Boolean.valueOf(getBoolean(this.KEY_MAINTENANCE_BADGE, true));
        } else {
            boolValueOf = Boolean.valueOf(this.isFirst);
        }
        return boolValueOf.booleanValue();
    }
}
