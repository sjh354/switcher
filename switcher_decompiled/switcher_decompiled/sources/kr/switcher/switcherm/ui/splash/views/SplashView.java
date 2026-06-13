package kr.switcher.switcherm.ui.splash.views;

/* JADX INFO: loaded from: classes2.dex */
public interface SplashView {
    boolean checkPermission();

    void moveMainActivity();

    void moveSettingReservationMenu(String str);

    void moveSettingStrokeMenu(String str);

    void moveStartActivity();

    void showMessage(String str);

    void showWebsite(String str);

    void updateFCMToken();
}
