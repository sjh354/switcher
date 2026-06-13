package kr.switcher.switcherm.ui.irremoconregister.presenter;

import kr.switcher.device.remocon.Remocon;
import kr.switcher.switcherm.ui.irremoconregister.interactor.LinkerRemoconRegisterInteractor;
import kr.switcher.switcherm.ui.irremoconregister.view.IrRemoconRegisterView;

/* JADX INFO: loaded from: classes2.dex */
public class LinkerRemoconRegisterPresenter {
    private LinkerRemoconRegisterInteractor interactor;
    private IrRemoconRegisterView view;

    public LinkerRemoconRegisterPresenter(IrRemoconRegisterView irRemoconRegisterView, LinkerRemoconRegisterInteractor linkerRemoconRegisterInteractor) {
        this.view = irRemoconRegisterView;
        this.interactor = linkerRemoconRegisterInteractor;
    }

    public void onCreate() {
        this.view.hideProgressbar();
        this.view.inactiveRegisterButton();
        this.view.hideProgressbar();
    }

    public void onCancelButtonClicked() {
        this.view.finish();
    }

    public void onRemoconRegisterButtonClicked(String str) {
        if (!checkIsValidData(str)) {
            warning();
        } else {
            this.view.showProgressbar(10000);
            this.interactor.createRemocon(str);
        }
    }

    private void warning() {
        this.view.showWarningToastForRegister();
    }

    public void onTextChanged(String str) {
        if (!checkIsValidData(str)) {
            this.view.inactiveRegisterButton();
        } else {
            this.view.activeRegisterButton();
        }
    }

    private boolean checkIsValidData(String str) {
        return str != null && str.length() >= 1;
    }

    public void onCreateRemocon(Remocon remocon) {
        this.view.hideProgressbar();
        this.view.moveIRCommandRegisterScreen(remocon);
    }

    public void onError(String str) {
        this.view.hideProgressbar();
        this.view.showErrorMessage(str);
    }
}
