package kr.switcher.switcherm.ui.main.views;

import kr.switcher.device.IODevice;
import kr.switcher.switcherm.ui.main.MainActivity;

/* JADX INFO: loaded from: classes2.dex */
public interface MainShareCodeView {
    void clearLinearLayout();

    void finishJob(String str);

    void hideProgressbar();

    void initialize();

    void moveConnectingScreen();

    void requestShareCodeEventForGA();

    void saveShareCodeToDB(String str);

    void sendMainData(String str, IODevice.ProductId productId, String str2, String str3, MainActivity.MainBackgroundState mainBackgroundState);

    void showCodeView(String str);

    void showDefaultView();

    void showErrorMessage(String str);

    void showFailureDialog();

    void showNoInternetDialog();

    void showNoInternetView();

    void showProgressbar();

    void showRequestedView();

    void showSuccessDialog();

    void showUnknownView();

    void trackCodeForGA();

    void trackFailForGA();

    void trackNoWifiForGA();

    void trackRequestedForGA();

    void trackSuccessForGA();
}
