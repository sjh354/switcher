package kr.switcher.switcherm.ui.ircommandtest.presenter;

import kr.switcher.switcherm.ui.ircommandtest.interactor.CreateIRCommandInteractor;
import kr.switcher.switcherm.ui.ircommandtest.view.InsertFragmentView;

/* JADX INFO: loaded from: classes2.dex */
public class LinkerInsertIrCommandPresenter {
    private CreateIRCommandInteractor interactor;
    private InsertFragmentView view;

    public LinkerInsertIrCommandPresenter(InsertFragmentView insertFragmentView, CreateIRCommandInteractor createIRCommandInteractor) {
        this.view = insertFragmentView;
        this.interactor = createIRCommandInteractor;
    }

    public void onCreateView() {
        this.view.activeRegisterButton();
    }

    public void onCommandInsertButtonClicked(String str) {
        if (str == null) {
            return;
        }
        this.interactor.createIRCommand(str);
        this.view.countdown();
        this.view.inactiveRegisterButton();
    }

    public void onError() {
        this.view.showErrorMessage("서버 통신이 실패하였습니다. 다시 시도해주세요");
        this.view.activeRegisterButton();
    }
}
