package kr.switcher.switcherm.ui.dialog.lowbattery.presenter;

import android.os.Handler;
import kr.switcher.switcherm.ui.dialog.lowbattery.view.LowBatteryView;
import no.nordicsemi.android.dfu.internal.scanner.BootloaderScanner;

/* JADX INFO: loaded from: classes2.dex */
public class LowBatteryPresenter {
    private static final int LOW_BATTERY_TIMEOUT = 5000;
    private LowBatteryView view;

    public LowBatteryPresenter(LowBatteryView lowBatteryView) {
        this.view = lowBatteryView;
    }

    public void onCreateView(int i) {
        this.view.setDialog();
        this.view.trackLowBatteryForGA();
        this.view.setCurrentBattery(i);
        new Handler().postDelayed(new Runnable() { // from class: kr.switcher.switcherm.ui.dialog.lowbattery.presenter.LowBatteryPresenter.1
            @Override // java.lang.Runnable
            public void run() {
                LowBatteryPresenter.this.dismissDialog();
            }
        }, BootloaderScanner.TIMEOUT);
    }

    public void dismissDialog() {
        this.view.dismissDialog();
    }
}
