package kr.switcher.switcherm.ui.setting.view;

import kr.switcher.device.switcher.Switcher;
import kr.switcher.device.switcher.interfaces.IODeviceCallbacks;

/* JADX INFO: loaded from: classes2.dex */
public interface ReservationView {
    void addReservation(Switcher.SwitcherReservation switcherReservation, IODeviceCallbacks.ReservationUpdateResultCallback reservationUpdateResultCallback);

    void finish();

    void hideLeftArrowButton();

    void hideProgressbar();

    void hideRemoveButton();

    void hideRightArrowButton();

    void hideViewPager();

    void initViewPager(int i);

    void initWheel();

    void pageSelected(int i);

    void removeReservation(int i, IODeviceCallbacks.ReservationUpdateResultCallback reservationUpdateResultCallback);

    void removeReservationToDB(int i);

    void select(boolean z);

    void selectDaily();

    void selectFri();

    void selectItem(int i);

    void selectLeftItem();

    void selectMon();

    void selectRightItem(int i);

    void selectSat();

    void selectSun();

    void selectThu();

    void selectTimerOff();

    void selectTimerOn();

    void selectTue();

    void selectWed();

    void selectWeekday();

    void selectWeekend();

    void setBackgroundTimerOffWhenIsOff();

    void setBackgroundTimerOffWhenIsOn();

    void setBackgroundTimerOnWhenIsOff();

    void setBackgroundTimerOnWhenIsOn();

    void setColorTimerOffTextWhenIsOff();

    void setColorTimerOffTextWhenIsOn();

    void setColorTimerOnTextWhenIsOff();

    void setColorTimerOnTextWhenIsOn();

    void setRepeater();

    void setTimerInfo(Switcher.SwitcherReservation switcherReservation);

    void setTitle(String str);

    void showErrorMessage(String str);

    void showLeftArrowButton();

    void showProgressbar();

    void showRemoveButton();

    void showRightArrowButton();

    void showViewPager();

    void trackCreateAlarmForGA(boolean z);

    void trackDeleteAlarmForGA(boolean z);

    void trackEditAlarmForGA(boolean z);

    void trackReservationForGA();

    void unSelectDaily();

    void unSelectFri();

    void unSelectMon();

    void unSelectSat();

    void unSelectSun();

    void unSelectThu();

    void unSelectTimerOff();

    void unSelectTimerOn();

    void unSelectTue();

    void unSelectWed();

    void unSelectWeekday();

    void unSelectWeekend();

    void updateReservation(Switcher.SwitcherReservation switcherReservation, IODeviceCallbacks.ReservationUpdateResultCallback reservationUpdateResultCallback);

    void updateReservationToDB(Switcher.SwitcherReservation switcherReservation);
}
