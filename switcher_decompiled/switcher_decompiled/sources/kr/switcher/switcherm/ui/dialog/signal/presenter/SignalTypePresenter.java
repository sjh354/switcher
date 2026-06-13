package kr.switcher.switcherm.ui.dialog.signal.presenter;

import kr.switcher.switcherm.signal.SignalData;
import kr.switcher.switcherm.ui.dialog.signal.interactor.SendStatusForSignalInteractor;
import kr.switcher.switcherm.ui.dialog.signal.view.SignalTypeView;

/* JADX INFO: loaded from: classes2.dex */
public class SignalTypePresenter implements SendStatusForSignalInteractor.OnSendResultListener {
    private SendStatusForSignalInteractor interactor;
    private SignalTypeView view;

    public SignalTypePresenter(SignalTypeView signalTypeView, SendStatusForSignalInteractor sendStatusForSignalInteractor) {
        this.view = signalTypeView;
        this.interactor = sendStatusForSignalInteractor;
        sendStatusForSignalInteractor.setOnSendResultListener(this);
    }

    public void onCreateView(SignalData signalData) {
        this.view.trackFingerForGA();
        this.view.setDialog();
        this.view.setSuggestionText(signalData.getContentText());
        this.view.setButtonText(signalData.getTitleText());
    }

    public void onAcceptButtonClicked(String str, SignalData signalData) {
        this.view.dismissDialog();
        this.interactor.sendStatus(str, signalData, SignalData.SIGNAL_STATUS_ACCEPTED);
        int type = signalData.getType();
        if (type == 1) {
            this.view.moveSettingStrokeMenu(str);
            return;
        }
        if (type == 2) {
            this.view.moveSettingReservationMenu(str);
            return;
        }
        if (type == 3) {
            this.view.moveWidgetSetting(signalData.getUrl());
        } else if (type == 98) {
            this.view.moveCardInfoScreen(signalData.getParam());
        } else {
            if (type != 99) {
                return;
            }
            this.view.moveTroubleShootingMenu();
        }
    }

    public void onDenyButtonClicked(String str, SignalData signalData) {
        this.interactor.sendStatus(str, signalData, SignalData.SIGNAL_STATUS_DENIED);
        this.view.dismissDialog();
    }

    public void onCancel() {
        this.view.finishActivity();
    }

    @Override // kr.switcher.switcherm.ui.dialog.signal.interactor.SendStatusForSignalInteractor.OnSendResultListener
    public void onResult(boolean z) {
        this.view.finish();
    }
}
