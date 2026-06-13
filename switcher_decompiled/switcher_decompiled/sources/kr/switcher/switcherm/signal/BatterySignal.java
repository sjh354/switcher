package kr.switcher.switcherm.signal;

import kr.switcher.switcherm.preference.BatterySignalPreference;

/* JADX INFO: loaded from: classes2.dex */
public class BatterySignal {
    private static BatterySignalPreference preference;

    public static void initialize() {
        if (preference == null) {
            preference = new BatterySignalPreference();
        }
    }

    public static void clear(String str) {
        BatterySignalPreference batterySignalPreference = preference;
        if (batterySignalPreference == null) {
            return;
        }
        batterySignalPreference.clear(str);
    }

    public static boolean battery(String str, int i) {
        if (preference == null) {
            return false;
        }
        if (i >= 0 && i < BatterySignalPreference.SIGNAL_LOW_BATTERY) {
            preference.setLowBattery(str);
            return true;
        }
        clear(str);
        return false;
    }

    public static void clearForTest() {
        BatterySignalPreference batterySignalPreference = preference;
        if (batterySignalPreference == null) {
            return;
        }
        batterySignalPreference.clearForTest();
    }
}
