package kr.switcher.switcherm.signal;

import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.preference.TimerSignalPreference;

/* JADX INFO: loaded from: classes2.dex */
public class ReservationSignal {
    public static final int SIGNAL1_DELAY = 15000;
    public static final int SIGNAL2_DELAY = 200;
    public static final int SIGNAL_STATUS_ED = 2;
    public static final int SIGNAL_STATUS_ING = 1;
    public static final int SIGNAL_STATUS_NONE = 0;
    public static final int SIGNAL_TYPE_TIMER = 0;
    private static final String TAG = "ReservationSignal";
    private static OnOccurredTimerSignalListener timerListener;
    private static TimerSignalPreference timerSignal;

    public interface OnOccurredTimerSignalListener {
        void onOccurredSignal();
    }

    public static void initialize() {
        if (timerSignal == null) {
            timerSignal = new TimerSignalPreference();
        }
    }

    public static void initialize(int i) {
        timerSignal = new TimerSignalPreference();
        setTimerSize(i);
    }

    public static void destroy() {
        if (timerSignal == null) {
            return;
        }
        timerSignal = null;
    }

    public static void setTimerSize(int i) {
        TimerSignalPreference timerSignalPreference = timerSignal;
        if (timerSignalPreference != null && i > 0) {
            timerSignalPreference.signal(2);
        }
    }

    public static void setOnOccurredSignalListener(OnOccurredTimerSignalListener onOccurredTimerSignalListener) {
        timerListener = onOccurredTimerSignalListener;
    }

    private static void notifyTimerSignal() {
        TimerSignalPreference timerSignalPreference = timerSignal;
        if (timerSignalPreference == null || timerSignalPreference.getSignalStatus() == 2) {
            return;
        }
        int onCount = timerSignal.getOnCount();
        int offCount = timerSignal.getOffCount();
        int screenCount = timerSignal.getScreenCount();
        IOLog.i(TAG, "notifyTimerSignal() | status:" + getTimerSignalStatus() + ", screen:" + screenCount + ", on:" + onCount + ", off:" + offCount);
        if (screenCount > 0) {
            OnOccurredTimerSignalListener onOccurredTimerSignalListener = timerListener;
            if (onOccurredTimerSignalListener != null) {
                onOccurredTimerSignalListener.onOccurredSignal();
            }
            timerSignal.signal(1);
        }
    }

    public static void screen() {
        TimerSignalPreference timerSignalPreference = timerSignal;
        if (timerSignalPreference == null) {
            return;
        }
        timerSignalPreference.screen();
        notifyTimerSignal();
    }

    public static int getTimerSignalStatus() {
        TimerSignalPreference timerSignalPreference = timerSignal;
        if (timerSignalPreference == null) {
            return 0;
        }
        return timerSignalPreference.getSignalStatus();
    }

    public static void abort() {
        TimerSignalPreference timerSignalPreference = timerSignal;
        if (timerSignalPreference == null) {
            return;
        }
        timerSignalPreference.signal(2);
    }
}
