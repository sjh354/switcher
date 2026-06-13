package kr.switcher.switcherm.ui.main.views;

import kr.switcher.device.IODevice;
import kr.switcher.switcherm.ui.main.MainActivity;

/* JADX INFO: loaded from: classes2.dex */
public interface MainDisconnectedView {
    void hideProgressbar();

    void moveConnectingScreen(String str);

    void sendMainData(String str, IODevice.ProductId productId, String str2, String str3, MainActivity.MainBackgroundState mainBackgroundState);

    void showMessage(String str);

    void showProgressbar();
}
