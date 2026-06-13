package kr.switcher.switcherm.ui.dialog.signal.presenter;

import kr.switcher.switcherm.ui.dialog.signal.view.AlarmSignalUsecaseSuggestionView;

/* JADX INFO: loaded from: classes2.dex */
public class AlarmSignalUsecaseSuggestionImpl implements AlarmSignalUsecaseSuggestionPresenter {
    private AlarmSignalUsecaseSuggestionView view;

    public AlarmSignalUsecaseSuggestionImpl(AlarmSignalUsecaseSuggestionView alarmSignalUsecaseSuggestionView) {
        this.view = alarmSignalUsecaseSuggestionView;
    }

    @Override // kr.switcher.switcherm.ui.dialog.signal.presenter.AlarmSignalUsecaseSuggestionPresenter
    public void initialize() {
        this.view.setDialog();
        this.view.trackForGA();
    }

    @Override // kr.switcher.switcherm.ui.dialog.signal.presenter.AlarmSignalUsecaseSuggestionPresenter
    public void onCancelButtonClicked() {
        this.view.dismissDialog(false);
        this.view.denyEventForGA();
    }

    @Override // kr.switcher.switcherm.ui.dialog.signal.presenter.AlarmSignalUsecaseSuggestionPresenter
    public void onTestButtonClicked() {
        this.view.dismissDialog(true);
        this.view.acceptEventForGA();
    }
}
