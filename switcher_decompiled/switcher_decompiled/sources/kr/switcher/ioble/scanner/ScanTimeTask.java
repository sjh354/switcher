package kr.switcher.ioble.scanner;

import android.os.Handler;

/* JADX INFO: loaded from: classes2.dex */
public class ScanTimeTask {
    private final int SCAN_TIME_OUT_INTERVAL = 10000;
    private Handler timeoutHandler = new Handler();
    private Runnable timeoutRunnable;

    public interface ScanningTimeoutListener {
        void onTimeoutScan();
    }

    private Runnable getTimeoutRunnable(final ScanningTimeoutListener scanningTimeoutListener) {
        return new Runnable() { // from class: kr.switcher.ioble.scanner.ScanTimeTask.1
            @Override // java.lang.Runnable
            public void run() {
                scanningTimeoutListener.onTimeoutScan();
            }
        };
    }

    public void start(ScanningTimeoutListener scanningTimeoutListener) {
        Runnable timeoutRunnable = getTimeoutRunnable(scanningTimeoutListener);
        this.timeoutRunnable = timeoutRunnable;
        this.timeoutHandler.postDelayed(timeoutRunnable, 10000L);
    }

    public void cancel() {
        this.timeoutHandler.removeCallbacks(this.timeoutRunnable);
    }
}
