package kr.switcher.switcherm.preference;

/* JADX INFO: loaded from: classes2.dex */
public class CheckerSurveillancePreference extends PreferenceHelper {
    private static final String FILE_NAME = "CHECKER_SURVEILLANCE_BADGE";
    private String KEY_SURVEILLANCE_BADGE = "SURVEILLANCE_BADGE";
    private boolean isFirst = true;

    @Override // kr.switcher.switcherm.preference.PreferenceHelper
    public String getFileName() {
        return FILE_NAME;
    }

    public void setSurveillanceBadge(boolean z) {
        if (context != null) {
            setBoolean(this.KEY_SURVEILLANCE_BADGE, z);
        }
        this.isFirst = z;
    }

    public boolean getSurveillanceBadge() {
        Boolean boolValueOf;
        if (context != null) {
            boolValueOf = Boolean.valueOf(getBoolean(this.KEY_SURVEILLANCE_BADGE, true));
        } else {
            boolValueOf = Boolean.valueOf(this.isFirst);
        }
        return boolValueOf.booleanValue();
    }
}
