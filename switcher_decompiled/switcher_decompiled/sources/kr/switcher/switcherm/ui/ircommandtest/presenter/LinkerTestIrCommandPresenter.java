package kr.switcher.switcherm.ui.ircommandtest.presenter;

import kr.switcher.device.remocon.IRCommand;
import kr.switcher.device.remocon.Remocon;
import kr.switcher.switcherm.ui.ircommandtest.interactor.TestIRCommandInteractor;
import kr.switcher.switcherm.ui.ircommandtest.view.TestFragmentView;

/* JADX INFO: loaded from: classes2.dex */
public class LinkerTestIrCommandPresenter {
    private TestIRCommandInteractor interactor;
    private TestFragmentView view;

    public void onError(String str) {
    }

    public LinkerTestIrCommandPresenter(TestFragmentView testFragmentView, TestIRCommandInteractor testIRCommandInteractor) {
        this.view = testFragmentView;
        this.interactor = testIRCommandInteractor;
    }

    public void onCreateView() {
        this.view.activeTestButton();
        this.view.hideProgressBar();
    }

    public void onTestBtnClicked(String str) {
        this.interactor.testIRCommand(str);
        this.view.inactiveTestButton();
        this.view.showProgressBar(2000);
        this.view.showTestDialog();
    }

    public void onMatchingCommand(Remocon remocon, IRCommand iRCommand) {
        this.interactor.matchingIRCommand(remocon, iRCommand);
    }

    public void onConfirmIRCommand(IRCommand iRCommand) {
        this.interactor.onConfirmIRCommand(iRCommand.getId());
    }

    public void onDeleteIRCommand(IRCommand iRCommand) {
        this.interactor.onDeleteIRCommand(iRCommand);
    }
}
