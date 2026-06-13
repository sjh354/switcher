package kr.switcher.switcherm.preference;

import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.common.util.IOUtil;

/* JADX INFO: loaded from: classes2.dex */
public class WidgetPreference extends PreferenceHelper {
    private static final String FILE_NAME = "WIDGET_SWITCHER_ADDRESS";
    private String KEY_WIDGET_ID = "WIDGET_ID";
    private String KEY_MAC_ADDRESS = "WIDGET_MAC_ADDRESS";
    private String KEY_AIRCON_LINKER = "AIRCON_LINKER";
    private String KEY_WIDGET_LINKER_TEMPERATURE = "LINKER_TEMPERATURE";
    private Boolean KEY_WIDGET_REFRESH_FINISHED = true;

    @Override // kr.switcher.switcherm.preference.PreferenceHelper
    public String getFileName() {
        return FILE_NAME;
    }

    public void setWidgetAliveLinker(String str) {
        setString(this.KEY_AIRCON_LINKER, IOUtil.makeBackendMacAddressFormat(str));
        IOLog.i("WidgetPreference", "setAliveLinkerMacAddress : " + str);
    }

    public String getWidgetAliveLinker() {
        return getString(this.KEY_AIRCON_LINKER, "");
    }

    public void setWidgetSwitcherAddress(int i, String str) {
        setString(this.KEY_WIDGET_ID + "." + i + "." + this.KEY_MAC_ADDRESS, str);
        setInt(this.KEY_MAC_ADDRESS + "." + str + "." + this.KEY_WIDGET_ID, i);
    }

    public String getWidgetSwitcherAddress(int i) {
        return getString(this.KEY_WIDGET_ID + "." + i + "." + this.KEY_MAC_ADDRESS, "");
    }

    public void setWidgetCheckerAddress(int i, String str) {
        setString(this.KEY_WIDGET_ID + "." + i + "." + this.KEY_MAC_ADDRESS, str);
        setInt(this.KEY_MAC_ADDRESS + "." + str + "." + this.KEY_WIDGET_ID, i);
    }

    public String getWidgetCheckerAddress(int i) {
        return getString(this.KEY_WIDGET_ID + "." + i + "." + this.KEY_MAC_ADDRESS, "");
    }

    public int getWidgetId(String str) {
        return getInt(this.KEY_MAC_ADDRESS + "." + str + "." + this.KEY_WIDGET_ID, -1);
    }

    public void setWidgetLinkerTemperature(int i, String str) {
        setString(this.KEY_WIDGET_ID + "." + i + "." + this.KEY_WIDGET_LINKER_TEMPERATURE, str);
    }

    public String getWidgetLinkerTemperature(int i) {
        return getString(this.KEY_WIDGET_ID + "." + i + "." + this.KEY_WIDGET_LINKER_TEMPERATURE, "");
    }

    public void setAirconWidgetRefreshFinished(int i, Boolean bool) {
        setBoolean(this.KEY_WIDGET_ID + "." + i + "." + this.KEY_WIDGET_REFRESH_FINISHED, bool.booleanValue());
    }

    public Boolean getAirconWidgetRefreshFinished(int i) {
        return Boolean.valueOf(getBoolean(this.KEY_WIDGET_ID + "." + i + "." + this.KEY_WIDGET_REFRESH_FINISHED, true));
    }
}
