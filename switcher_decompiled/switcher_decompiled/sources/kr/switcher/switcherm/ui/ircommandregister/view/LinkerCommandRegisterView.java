package kr.switcher.switcherm.ui.ircommandregister.view;

/* JADX INFO: loaded from: classes2.dex */
public interface LinkerCommandRegisterView {
    void activeRegisterButton();

    boolean checkIsOverlapCommand(String str);

    void finish();

    void hideProgressbar();

    void inactiveRegisterButton();

    void moveIRBrandActivity();

    void moveInsertCommandScreen();

    void onBackPressed();

    void showErrorMessage(String str);

    void showOverlapCommandNameComment();

    void showProgressbar(int i);

    void showWarningToastForRegister();
}
