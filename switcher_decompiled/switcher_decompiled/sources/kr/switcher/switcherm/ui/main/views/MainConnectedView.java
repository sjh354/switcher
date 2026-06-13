package kr.switcher.switcherm.ui.main.views;

import android.graphics.Bitmap;
import kr.switcher.device.IODevice;
import kr.switcher.switcherm.ui.main.MainActivity;

/* JADX INFO: loaded from: classes2.dex */
public interface MainConnectedView {
    void hideOneSetView();

    void hideProgressbar();

    void hideStrokeSettingMenu();

    void hideTimerSettingMenu();

    void hideTwoSetView();

    void onOneSetOff();

    void onOneSetOn();

    void onTwoSetOneOff();

    void onTwoSetOneOn();

    void onTwoSetTwoOff();

    void onTwoSetTwoOn();

    Bitmap rotateImage(Bitmap bitmap, float f);

    void sendMainData(String str, IODevice.ProductId productId, String str2, String str3, MainActivity.MainBackgroundState mainBackgroundState);

    void setBluetoothIcon();

    void setGatewayIcon();

    void showChangedOneButtonImage();

    void showChangedTwoButtonImage();

    void showErrorMessage(String str);

    void showLowBatteryDialogView(int i);

    void showNormalOneButtonImage();

    void showNormalTwoButtonImage();

    void showOneSetOffSwitchDefault();

    void showOneSetOffSwitchPressed();

    void showOneSetOffSwitchSpring();

    void showOneSetOnSwitchDefault();

    void showOneSetOnSwitchPressed();

    void showOneSetOnSwitchSpring();

    void showOneSetView();

    void showProgressbar();

    void showTwoSetBottomOffSwitchDefault();

    void showTwoSetBottomOffSwitchPressed();

    void showTwoSetBottomOffSwitchSpring();

    void showTwoSetBottomOnSwitchDefault();

    void showTwoSetBottomOnSwitchPressed();

    void showTwoSetBottomOnSwitchSpring();

    void showTwoSetTopOffSwitchDefault();

    void showTwoSetTopOffSwitchPressed();

    void showTwoSetTopOffSwitchSpring();

    void showTwoSetTopOnSwitchDefault();

    void showTwoSetTopOnSwitchPressed();

    void showTwoSetTopOnSwitchSpring();

    void showTwoSetView();

    void trackConnectedForGA();

    void trackConnectingTimeForGA();

    void trackLightingOneSetOff();

    void trackLightingOneSetOn();

    void trackLightingTwoSetOneOff();

    void trackLightingTwoSetOneOn();

    void trackLightingTwoSetTwoOff();

    void trackLightingTwoSetTwoOn();
}
