package kr.switcher.switcherm.ui.dialog.signal.view;

/* JADX INFO: loaded from: classes2.dex */
public interface SignalTypeView {
    void dismissDialog();

    void finish();

    void finishActivity();

    void moveCardInfoScreen(String str);

    void moveSettingReservationMenu(String str);

    void moveSettingStrokeMenu(String str);

    void moveTroubleShootingMenu();

    void moveWidgetSetting(String str);

    void setButtonText(String str);

    void setDialog();

    void setSuggestionText(String str);

    void trackFingerForGA();
}
