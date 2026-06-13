package kr.switcher.switcherm.ui.main.presenters;

import kr.switcher.device.IODevice;
import kr.switcher.device.checker.Checker;
import kr.switcher.switcherm.preference.CheckerSurveillancePreference;
import kr.switcher.switcherm.ui.main.MainActivity;
import kr.switcher.switcherm.ui.main.interactors.GetCheckerIsOpenInteractor;
import kr.switcher.switcherm.ui.main.views.MainConnectedCheckerView;

/* JADX INFO: loaded from: classes2.dex */
public class MainConnectedCheckerPresenter {
    private GetCheckerIsOpenInteractor interactor;
    private MainConnectedCheckerView view;

    public MainConnectedCheckerPresenter(MainConnectedCheckerView mainConnectedCheckerView, GetCheckerIsOpenInteractor getCheckerIsOpenInteractor) {
        this.view = mainConnectedCheckerView;
        this.interactor = getCheckerIsOpenInteractor;
    }

    public void onResume(Checker checker) {
        this.view.onMainData(checker.getMacAddress(), IODevice.ProductId.CHECKER, checker.getName(), "배터리 " + checker.getBatteryLevel(), checker.getProductId().equals(IODevice.ProductId.CHECKER) ? MainActivity.MainBackgroundState.CONNECTED_CHECKER : MainActivity.MainBackgroundState.DISCONNECTED);
        this.interactor.getCheckerIsOpen(checker);
        checkShowSurveillanceBadge();
    }

    private void checkShowSurveillanceBadge() {
        if (new CheckerSurveillancePreference().getSurveillanceBadge()) {
            this.view.showSurveillanceBadge();
        } else {
            this.view.hideSurveillanceBadge();
        }
    }

    public void onGetCheckerIsOpen(String str) {
        if (str.equals("true")) {
            this.view.setOpen();
        } else {
            this.view.setClose();
        }
    }

    public void onSurveillanceButtonClicked() {
        if (new CheckerSurveillancePreference().getSurveillanceBadge()) {
            new CheckerSurveillancePreference().setSurveillanceBadge(false);
        }
    }
}
