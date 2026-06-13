package kr.switcher.switcherm.ui.register.view;

import kr.switcher.device.IODevice;

/* JADX INFO: loaded from: classes2.dex */
public interface RegisterView {
    void activeRegisterButton();

    void editableOwnerName();

    void finish();

    void hideProgressbar();

    void inactiveRegisterButton();

    void initializeHashingCode(String str);

    void moveMainConnectedScreen(String str);

    void moveSwitcherListScreen();

    void moveWifiSettingScreen(IODevice iODevice);

    void setCheckerType();

    void setLinkerType();

    void setOwnerName(String str);

    void setProductionNumber(String str);

    void setSwitcherTypeOneSet();

    void setSwitcherTypeTwoSet();

    void showErrorMessage(String str);

    void showProgressbar(int i);

    void showWarningDialog();

    void trackRegisterForGA();

    void trackWarningForGA();

    void uneditableOwnerName();

    void updateSwitcherName();
}
