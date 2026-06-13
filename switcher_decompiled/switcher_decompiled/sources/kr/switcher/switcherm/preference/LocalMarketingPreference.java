package kr.switcher.switcherm.preference;

/* JADX INFO: loaded from: classes2.dex */
public class LocalMarketingPreference extends PreferenceHelper {
    private static final String FILE_NAME = "LOCAL_MARKETING";
    private String KEY_MARKETING_LINKER = "MARKETING_LINKER";
    private String KEY_MARKETING_WIDGET_BANNER = "MARKETING_WIDGET_BANNER";
    private boolean isFirst = true;

    @Override // kr.switcher.switcherm.preference.PreferenceHelper
    public String getFileName() {
        return FILE_NAME;
    }

    public void setLocalMarketingLinker(boolean z) {
        if (context != null) {
            setBoolean(this.KEY_MARKETING_LINKER, z);
        }
        this.isFirst = z;
    }

    public boolean getLocalMarketingLinker() {
        Boolean boolValueOf;
        if (context != null) {
            boolValueOf = Boolean.valueOf(getBoolean(this.KEY_MARKETING_LINKER, true));
        } else {
            boolValueOf = Boolean.valueOf(this.isFirst);
        }
        return boolValueOf.booleanValue();
    }

    public void setMarketingWidgetBanner(boolean z) {
        if (context != null) {
            setBoolean(this.KEY_MARKETING_WIDGET_BANNER, z);
        }
        this.isFirst = z;
    }

    public boolean getMarketingWidgetBanner() {
        Boolean boolValueOf;
        if (context != null) {
            boolValueOf = Boolean.valueOf(getBoolean(this.KEY_MARKETING_WIDGET_BANNER, true));
        } else {
            boolValueOf = Boolean.valueOf(this.isFirst);
        }
        return boolValueOf.booleanValue();
    }
}
