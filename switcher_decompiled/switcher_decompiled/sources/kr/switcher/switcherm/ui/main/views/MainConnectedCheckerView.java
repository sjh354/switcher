package kr.switcher.switcherm.ui.main.views;

import kr.switcher.device.IODevice;
import kr.switcher.switcherm.ui.main.MainActivity;

/* JADX INFO: loaded from: classes2.dex */
public interface MainConnectedCheckerView {
    void hideSurveillanceBadge();

    void initScreen();

    void onMainData(String str, IODevice.ProductId productId, String str2, String str3, MainActivity.MainBackgroundState mainBackgroundState);

    void setClose();

    void setName();

    void setOpen();

    void showSurveillanceBadge();
}
