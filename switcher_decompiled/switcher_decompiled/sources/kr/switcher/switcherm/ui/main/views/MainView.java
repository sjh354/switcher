package kr.switcher.switcherm.ui.main.views;

import android.content.Intent;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes2.dex */
public interface MainView {
    void callSwitcherListActivity();

    void changeCheckerInfoIC();

    void changeLinkerInfoIC();

    void disconnectAllSwitcher();

    void disconnectSwitcher();

    void finish();

    void hideCurrentTemperature();

    void hideProgressbar();

    void moveMainBLEPermissionReqScreen();

    void moveMainConnectingScreen(Intent intent);

    void moveMainDefaultScreen();

    void moveMainDisconnectScreen(Intent intent);

    void moveSettingScreen(String str);

    void resetTransition();

    void reverseTransition();

    void sendBroadcastToAirconWidget();

    void sendBroadcastToOneButtonWidget();

    void sendBroadcastToTwoButtonWidget();

    void setInfo(String str);

    void setInfoIcon(Drawable drawable);

    void setLowBatteryTransitionView();

    void setNormalComponentRatio();

    void setNormalTransitionView();

    void setRemoconComponentRatio();

    void setSwitcherIcon(Drawable drawable);

    void setSwitcherMacAddress(String str);

    void setSwitcherName(String str);

    void setTimerSizeForSignal();

    void setTitle(String str);

    void showCurrentTemperature();

    void showMenuForAirconRemoconConnectionScreen();

    void showMenuForConnectScreen();

    void showMenuForDefaultScreen();

    void showMenuForLinkerThingConnectionScreen();

    void showMenuForManualCheckerConnectionScreen();

    void showMenuForManualRemoconConnectionScreen();

    void showMenuForPermissionScreen();

    void showMenuForTVRemoconConnectionScreen();

    void showProgressbar();
}
