package kr.switcher.switcherm.preference;

/* JADX INFO: loaded from: classes2.dex */
public class AirconWidgetBadgePreference extends PreferenceHelper {
    private static final String FILE_NAME = "AIRCON_WIDGET_BADGE";
    private String KEY_WIDEGET_BADGE = "WIDGET_BADGE";
    private boolean isFirst = true;

    @Override // kr.switcher.switcherm.preference.PreferenceHelper
    public String getFileName() {
        return FILE_NAME;
    }

    public void setWidgetBadge(boolean z) {
        if (context != null) {
            setBoolean(this.KEY_WIDEGET_BADGE, z);
        }
        this.isFirst = z;
    }

    public boolean getWidgetBadge() {
        Boolean boolValueOf;
        if (context != null) {
            boolValueOf = Boolean.valueOf(getBoolean(this.KEY_WIDEGET_BADGE, true));
        } else {
            boolValueOf = Boolean.valueOf(this.isFirst);
        }
        return boolValueOf.booleanValue();
    }
}
