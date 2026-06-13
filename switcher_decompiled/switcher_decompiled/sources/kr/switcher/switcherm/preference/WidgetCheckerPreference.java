package kr.switcher.switcherm.preference;

/* JADX INFO: loaded from: classes2.dex */
public class WidgetCheckerPreference extends PreferenceHelper {
    private static final String FILE_NAME = "WIDGET_CHECKER_INFO";
    private String KEY_WIDGET_ID = "WIDGET_ID";
    private String KEY_WIDGET_CHECKER_SURVEILLANCE_LEVEL = "WIDGET_CHECKER_SURVEILLANCE_LEVEL";
    private String KEY_WIDGET_CHECKER_SURVEILLANCE_IS_ACTIVE = "WIDGET_CHECKER_SURVEILLANCE_IS_ACTIVE";
    private String KEY_WIDGET_LAST_HISTORY_IS_OPENED = "WIDGET_CHECKER_LAST_HISTORY_IS_OPENED";
    private String KEY_WIDGET_LAST_HISTORY_TIME = "WIDGET_CHECKER_LAST_HISTORY_TIME";
    private String KEY_WIDGET_LAST_HISTORY_DATE = "WIDGET_CHECKER_LAST_HISTORY_DATE";
    private String KEY_WIDGET_CHECKER_BATTERY = "WIDGET_CHECKER_BATTERY";
    private String KEY_WIDGET_REFRESH_FINISHED = "WIDGET_REFRESH_FINISHED";
    private String KEY_WIDGET_SURVEILLANCE_INFO_IS_FOUNDED = "WIDGET_SURVEILLANCE_INFO";
    private String KEY_WIDGET_HISTORY_INFO_IS_FOUNDED = "WIDGET_HISTORY_INFO_IS_FOUNDED";
    private String KEY_WIDGET_INFO_IS_FOUNDED = "WIDGET_INFO_IS_FOUNDED";

    @Override // kr.switcher.switcherm.preference.PreferenceHelper
    public String getFileName() {
        return FILE_NAME;
    }

    public void setWidgetCheckerSurveillanceLevel(int i, int i2) {
        setInt(this.KEY_WIDGET_ID + "." + i + "." + this.KEY_WIDGET_CHECKER_SURVEILLANCE_LEVEL, i2);
    }

    public int getWidgetCheckerSurveillanceLevel(int i) {
        return getInt(this.KEY_WIDGET_ID + "." + i + "." + this.KEY_WIDGET_CHECKER_SURVEILLANCE_LEVEL, -1);
    }

    public void setWidgetCheckerSurveillanceIsActive(int i, String str) {
        setString(this.KEY_WIDGET_ID + "." + i + "." + this.KEY_WIDGET_CHECKER_SURVEILLANCE_IS_ACTIVE, str);
    }

    public String getWidgetCheckerSurveillanceIsActive(int i) {
        return getString(this.KEY_WIDGET_ID + "." + i + "." + this.KEY_WIDGET_CHECKER_SURVEILLANCE_IS_ACTIVE, "");
    }

    public void setWidgetCheckerLastHistoryIsOpened(int i, String str) {
        setString(this.KEY_WIDGET_ID + "." + i + "." + this.KEY_WIDGET_LAST_HISTORY_IS_OPENED, str);
    }

    public String getWidgetCheckerLastHistoryIsOpened(int i) {
        return getString(this.KEY_WIDGET_ID + "." + i + "." + this.KEY_WIDGET_LAST_HISTORY_IS_OPENED, "");
    }

    public void setWidgetCheckerLastHistoryTime(int i, String str) {
        setString(this.KEY_WIDGET_ID + "." + i + "." + this.KEY_WIDGET_LAST_HISTORY_TIME, str);
    }

    public String getWidgetCheckerLastHistoryTime(int i) {
        return getString(this.KEY_WIDGET_ID + "." + i + "." + this.KEY_WIDGET_LAST_HISTORY_TIME, "");
    }

    public void setWidgetCheckerBattery(int i, String str) {
        setString(this.KEY_WIDGET_ID + "." + i + "." + this.KEY_WIDGET_CHECKER_BATTERY, str);
    }

    public String getWidgetCheckerBattery(int i) {
        return getString(this.KEY_WIDGET_ID + "." + i + "." + this.KEY_WIDGET_CHECKER_BATTERY, "");
    }

    public void setWidgetCheckerLastHistoryDate(int i, String str) {
        setString(this.KEY_WIDGET_ID + "." + i + "." + this.KEY_WIDGET_LAST_HISTORY_DATE, str);
    }

    public String getWidgetCheckerLastHistoryDate(int i) {
        return getString(this.KEY_WIDGET_ID + "." + i + "." + this.KEY_WIDGET_LAST_HISTORY_DATE, "");
    }

    public void setWidgetCheckerRefreshFinished(int i, String str) {
        setString(this.KEY_WIDGET_ID + "." + i + "." + this.KEY_WIDGET_REFRESH_FINISHED, str);
    }

    public String getWidgetCheckerRefreshFinished(int i) {
        return getString(this.KEY_WIDGET_ID + "." + i + "." + this.KEY_WIDGET_REFRESH_FINISHED, "true");
    }

    public void setWidgetSurveillanceIsFound(int i, String str) {
        setString(this.KEY_WIDGET_ID + "." + i + "." + this.KEY_WIDGET_SURVEILLANCE_INFO_IS_FOUNDED, str);
    }

    public String getWidgetSurveillanceIsFound(int i) {
        return getString(this.KEY_WIDGET_ID + "." + i + "." + this.KEY_WIDGET_SURVEILLANCE_INFO_IS_FOUNDED, "false");
    }

    public void setWidgetHistoryIsFound(int i, String str) {
        setString(this.KEY_WIDGET_ID + "." + i + "." + this.KEY_WIDGET_HISTORY_INFO_IS_FOUNDED, str);
    }

    public String getWidgetHistoryIsFound(int i) {
        return getString(this.KEY_WIDGET_ID + "." + i + "." + this.KEY_WIDGET_HISTORY_INFO_IS_FOUNDED, "false");
    }

    public void setWidgetInfoIsFound(int i, String str) {
        setString(this.KEY_WIDGET_ID + "." + i + "." + this.KEY_WIDGET_INFO_IS_FOUNDED, str);
    }

    public String getWidgetInfoIsFound(int i) {
        return getString(this.KEY_WIDGET_ID + "." + i + "." + this.KEY_WIDGET_INFO_IS_FOUNDED, "false");
    }
}
