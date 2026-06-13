package kr.switcher.switcherm.ui.ircommandregister.presenter;

import java.util.Iterator;
import java.util.List;
import kr.switcher.device.remocon.IRCommand;
import kr.switcher.device.remocon.Remocon;
import kr.switcher.switcherm.ui.ircommandregister.view.LinkerCommandRegisterView;
import kr.switcher.switcherm.ui.main.interactors.FindAirconIRCommandInteractor;

/* JADX INFO: loaded from: classes2.dex */
public class LinkerCommandRegisterPresenter {
    private FindAirconIRCommandInteractor interactor;
    private LinkerCommandRegisterView view;

    public LinkerCommandRegisterPresenter(LinkerCommandRegisterView linkerCommandRegisterView, FindAirconIRCommandInteractor findAirconIRCommandInteractor) {
        this.view = linkerCommandRegisterView;
        this.interactor = findAirconIRCommandInteractor;
    }

    public void onCreate(Remocon remocon) {
        this.view.hideProgressbar();
        this.view.inactiveRegisterButton();
        this.interactor.findAirconIRCommand(remocon);
    }

    public void onPreviousButtonClicked() {
        this.view.finish();
    }

    public void onCommandRegisterButtonClicked(String str) {
        if (!checkIsValidData(str)) {
            warning();
        } else if (this.view.checkIsOverlapCommand(str)) {
            this.view.showOverlapCommandNameComment();
        } else {
            this.view.showProgressbar(10000);
            this.view.moveInsertCommandScreen();
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

    public void onBackPressed() {
        this.view.onBackPressed();
    }

    public Boolean checkIsOverlapCommand(String str, List<IRCommand> list) {
        Iterator<IRCommand> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().getName().equals(str)) {
                return true;
            }
        }
        return false;
    }
}
