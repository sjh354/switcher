package kr.switcher.switcherm.ui.main.helper;

import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.preference.BatterySignalPreference;

/* JADX INFO: loaded from: classes2.dex */
public class BatteryLabelMaker {
    public static final String BATTERY_ENOUGH = "배터리 충분함";
    public static final String BATTERY_HIGH = "배터리 충분함";
    public static final String BATTERY_LOW = "배터리 충전필요";

    public String makeBatteryLabel(int i) {
        return getBatteryLabelName(i);
    }

    private String getBatteryLabelName(int i) {
        return i >= 20 ? "배터리 충분함" : (20 <= i || i < 5) ? BatterySignalPreference.SIGNAL_LOW_BATTERY > i ? BATTERY_LOW : IOUtil.getStringResource(R.string.battery_null) : "배터리 충분함";
    }
}
