package kr.switcher.switcherm.ui.main.views;

import kr.switcher.device.IODevice;
import kr.switcher.device.switcher.ble.ScannedBLESwitcher;
import kr.switcher.switcherm.ui.main.MainActivity;

/* JADX INFO: loaded from: classes2.dex */
public interface MainConnectingView {
    void hideOneSetView();

    void hideTwoSetView();

    void moveConnectedAirconRemoconScreen(String str);

    void moveConnectedSettopRemoconScreen(String str);

    void moveMainConnectedCheckerScreen(String str);

    void moveMainConnectedRemoconScreen(String str);

    void moveMainConnectedScreen(String str);

    void moveMainDisconnectedScreen(String str, int i);

    void moveMainPaymentScreen(String str);

    void moveMainShareCodeScreen(ScannedBLESwitcher scannedBLESwitcher);

    void moveRegisterScreen(String str);

    void moveWifiSettingScreen(IODevice iODevice);

    void sendMainData(String str, IODevice.ProductId productId, String str2, String str3, MainActivity.MainBackgroundState mainBackgroundState);

    void showErrorMessage(String str);

    void showOneSetView();

    void showTwoSetView();

    void trackConnectingForGA();

    void trackScanningForGA();
}
