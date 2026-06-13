package kr.switcher.switcherm.ui.setting.view;

import kr.switcher.device.remocon.Remocon;

/* JADX INFO: loaded from: classes2.dex */
public interface AirconMaintainingTemperatureView {
    void backButtonClicked();

    void hideProgressbar();

    void hideRemoveButton();

    void initWheel();

    void selectDaily();

    void selectFri();

    void selectMon();

    void selectSat();

    void selectSun();

    void selectThu();

    void selectTue();

    void selectWed();

    void selectWeekday();

    void selectWeekend();

    void setMaintenanceInfo(Remocon.RemoconMaintenanceTemperature remoconMaintenanceTemperature);

    void setRemoconMaintenanceData(Remocon.RemoconMaintenanceTemperature remoconMaintenanceTemperature);

    void setRepeater();

    void setTemperature(int i);

    void setTitle(String str);

    void showDefaultTemperature();

    void showLogicalOrderError();

    void showProgressbar();

    void showRemoveButton();

    void showSameTimeSettingError();

    void showTestDialog();

    void unSelectDaily();

    void unSelectFri();

    void unSelectMon();

    void unSelectSat();

    void unSelectSun();

    void unSelectThu();

    void unSelectTue();

    void unSelectWed();

    void unSelectWeekday();

    void unSelectWeekend();
}
