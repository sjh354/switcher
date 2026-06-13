package kr.switcher.switcherm.preference;

import kr.switcher.switcherm.common.util.IOLog;

/* JADX INFO: loaded from: classes2.dex */
public class TimerSignalPreference extends PreferenceHelper {
    private static final String FILE_NAME = "TIMER_SIGNAL";
    private String KEY_SIGNAL_STATUS = "SIGNAL_STATUS";
    private String KEY_ON_BUTTON = "ON_BUTTON";
    private String KEY_OFF_BUTTON = "ON_BUTTON";
    private String KEY_TIMER_SCREEN = "TIMER_SCREEN";
    private int signalStatus = 0;
    private int onCount = 0;
    private int offCount = 0;
    private int screenCount = 0;

    @Override // kr.switcher.switcherm.preference.PreferenceHelper
    public String getFileName() {
        return FILE_NAME;
    }

    public void signal(int i) {
        if (context != null) {
            setInt(this.KEY_SIGNAL_STATUS, i);
        }
        this.signalStatus = i;
        IOLog.i("TimerSignalPreference", "battery status : " + this.signalStatus);
    }

    public int getSignalStatus() {
        if (context != null) {
            return getInt(this.KEY_SIGNAL_STATUS, 0);
        }
        return this.signalStatus;
    }

    public void on() {
        if (context != null) {
            setInt(this.KEY_ON_BUTTON, getOnCount() + 1);
        }
        this.onCount++;
    }

    public int getOnCount() {
        if (context != null) {
            return getInt(this.KEY_ON_BUTTON, 0);
        }
        return this.onCount;
    }

    public void off() {
        if (context != null) {
            setInt(this.KEY_OFF_BUTTON, getOffCount() + 1);
        }
        this.offCount++;
    }

    public int getOffCount() {
        if (context != null) {
            return getInt(this.KEY_OFF_BUTTON, 0);
        }
        return this.offCount;
    }

    public void screen() {
        if (context != null) {
            setInt(this.KEY_TIMER_SCREEN, getScreenCount() + 1);
        }
        this.screenCount++;
    }

    public int getScreenCount() {
        if (context != null) {
            return getInt(this.KEY_TIMER_SCREEN, 0);
        }
        return this.screenCount;
    }
}
