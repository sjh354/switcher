package kr.switcher.switcherm.ui.dialog.lowbattery.view;

/* JADX INFO: loaded from: classes2.dex */
public interface LowBatteryView {
    void dismissDialog();

    void setCurrentBattery(int i);

    void setDialog();

    void trackLowBatteryForGA();
}
