package kr.switcher.switcherm.preference;

/* JADX INFO: loaded from: classes2.dex */
public class AirconReservationBadgePreference extends PreferenceHelper {
    private static final String FILE_NAME = "AIRCON_RESERVATION_BADGE";
    private String KEY_RESERVATION_BADGE = "RESERVATION_BADGE";
    private boolean isFirst = true;

    @Override // kr.switcher.switcherm.preference.PreferenceHelper
    public String getFileName() {
        return FILE_NAME;
    }

    public void setReservationBadge(boolean z) {
        if (context != null) {
            setBoolean(this.KEY_RESERVATION_BADGE, z);
        }
        this.isFirst = z;
    }

    public boolean getReservationBadge() {
        Boolean boolValueOf;
        if (context != null) {
            boolValueOf = Boolean.valueOf(getBoolean(this.KEY_RESERVATION_BADGE, true));
        } else {
            boolValueOf = Boolean.valueOf(this.isFirst);
        }
        return boolValueOf.booleanValue();
    }
}
