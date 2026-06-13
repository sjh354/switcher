package kr.switcher.switcherm.preference;

/* JADX INFO: loaded from: classes2.dex */
public class BatterySignalPreference extends PreferenceHelper {
    private static final String FILE_NAME = "BATTERY_SIGNAL";
    public static int SIGNAL_BATTERY_100 = 100;
    public static int SIGNAL_LOW_BATTERY = 5;
    private String KEY_BATTERY_SIGNAL = FILE_NAME;
    private int signalBattery = SIGNAL_BATTERY_100;

    @Override // kr.switcher.switcherm.preference.PreferenceHelper
    public String getFileName() {
        return FILE_NAME;
    }

    public void clear(String str) {
        int i = SIGNAL_BATTERY_100;
        if (context != null) {
            setInt(str + "." + this.KEY_BATTERY_SIGNAL, SIGNAL_BATTERY_100);
        }
        this.signalBattery = i;
    }

    public void clearForTest() {
        this.signalBattery = SIGNAL_BATTERY_100;
    }

    public void setLowBattery(String str) {
        int i = SIGNAL_LOW_BATTERY;
        if (context != null) {
            setInt(str + "." + this.KEY_BATTERY_SIGNAL, i);
        }
        this.signalBattery = i;
    }

    public int getOccuredSignalBattery(String str) {
        if (context != null) {
            return getInt(str + "." + this.KEY_BATTERY_SIGNAL, 0);
        }
        return this.signalBattery;
    }
}
