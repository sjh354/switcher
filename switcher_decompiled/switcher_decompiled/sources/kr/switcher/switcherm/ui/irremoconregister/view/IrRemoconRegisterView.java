package kr.switcher.switcherm.ui.irremoconregister.view;

import kr.switcher.device.remocon.Remocon;

/* JADX INFO: loaded from: classes2.dex */
public interface IrRemoconRegisterView {
    void activeRegisterButton();

    void finish();

    void hideProgressbar();

    void inactiveRegisterButton();

    void moveIRCommandRegisterScreen(Remocon remocon);

    void showErrorMessage(String str);

    void showProgressbar(int i);

    void showWarningToastForRegister();
}
