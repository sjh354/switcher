package kr.switcher.switcherm.ui.wifi.view;

/* JADX INFO: loaded from: classes2.dex */
public interface WifiView {
    void finish();

    void hideProgressbar();

    void moveWifiListFragment();

    void moveWifiPasswordFragment();

    void setMenuTitleName(String str);

    void showEmptySSIDmessage();

    void showProgressbar();
}
