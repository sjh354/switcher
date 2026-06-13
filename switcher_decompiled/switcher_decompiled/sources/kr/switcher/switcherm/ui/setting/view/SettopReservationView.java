package kr.switcher.switcherm.ui.setting.view;

import kr.switcher.device.remocon.Remocon;

/* JADX INFO: loaded from: classes2.dex */
public interface SettopReservationView {
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

    void setActiveChannelField();

    void setBackgroundTimerOffWhenIsOff();

    void setBackgroundTimerOffWhenIsOn();

    void setBackgroundTimerOnWhenIsOff();

    void setBackgroundTimerOnWhenIsOn();

    void setCannelNumber(String str);

    void setColorTimerOffTextWhenIsOff();

    void setColorTimerOffTextWhenIsOn();

    void setColorTimerOnTextWhenIsOff();

    void setColorTimerOnTextWhenIsOn();

    void setInactiveChannelField();

    void setRemoconReservationData(Remocon.RemoconReservation remoconReservation);

    void setRepeater();

    void setTimerInfo(Remocon.RemoconReservation remoconReservation);

    void setTitle(String str);

    void showProgressbar();

    void showRemoveButton();

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
