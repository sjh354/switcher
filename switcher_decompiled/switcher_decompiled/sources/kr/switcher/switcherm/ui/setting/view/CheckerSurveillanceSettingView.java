package kr.switcher.switcherm.ui.setting.view;

import kr.switcher.device.checker.Checker;

/* JADX INFO: loaded from: classes2.dex */
public interface CheckerSurveillanceSettingView {
    void backButtonClicked();

    void hideLeftArrowButton();

    void hideProgressbar();

    void hideRemoveButton();

    void hideRightArrowButton();

    void initViewPager(int i);

    void initWheel();

    void onClickLeftArrowButtonClicked();

    void onClickRightArrowButtonClicked(int i);

    void refreshViewPage();

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

    void setLevelImage();

    void setPagerListener(int i);

    void setProposeCurrentItem(int i);

    void setRepeater();

    void setSurveillanceInfo(Checker.Surveillance surveillance);

    void setTitle(String str);

    void showLeftArrowButton();

    void showLogicalOrderError();

    void showProgressbar();

    void showRemoveButton();

    void showRightArrowButton();

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
