package kr.switcher.switcherm.ui.wifi.presenter;

import androidx.fragment.app.FragmentManager;
import kr.switcher.device.IODevice;
import kr.switcher.switcherm.network.wifi.WifiData;
import kr.switcher.switcherm.ui.wifi.fragments.WifiListFragment;
import kr.switcher.switcherm.ui.wifi.fragments.WifiPasswordFragment;
import kr.switcher.switcherm.ui.wifi.interactor.SendWifiDataInteractor;
import kr.switcher.switcherm.ui.wifi.view.WifiView;

/* JADX INFO: loaded from: classes2.dex */
public class WifiPresenter {
    private SendWifiDataInteractor interactor;
    private WifiView view;

    public WifiPresenter(WifiView wifiView, SendWifiDataInteractor sendWifiDataInteractor) {
        this.view = wifiView;
        this.interactor = sendWifiDataInteractor;
        wifiView.moveWifiListFragment();
        wifiView.setMenuTitleName(getTitleName("WifiListFragment"));
    }

    private String getTitleName(String str) {
        return str.equals("WifiListFragment") ? "Wi-Fi 리스트" : str.equals("WifiPasswordFragment") ? "Wi-Fi 비밀번호 입력" : "";
    }

    public void onBackPressed(FragmentManager fragmentManager) {
        WifiListFragment wifiListFragment = (WifiListFragment) fragmentManager.findFragmentByTag("WifiListFragment");
        WifiPasswordFragment wifiPasswordFragment = (WifiPasswordFragment) fragmentManager.findFragmentByTag("WifiPasswordFragment");
        if (wifiListFragment != null) {
            this.view.finish();
        } else if (wifiPasswordFragment != null) {
            this.view.setMenuTitleName(getTitleName("WifiListFragment"));
            this.view.moveWifiListFragment();
        } else {
            this.view.setMenuTitleName(getTitleName("WifiListFragment"));
            this.view.moveWifiListFragment();
        }
    }

    public void onWifiDataResult(WifiData wifiData, IODevice iODevice) {
        if (wifiData.getSsid().length() > 0 && !wifiData.getSsid().equals("")) {
            if (!wifiData.getOauth().equals("NONE")) {
                this.view.moveWifiPasswordFragment();
                return;
            } else {
                sendWifiData(wifiData, iODevice);
                return;
            }
        }
        this.view.showEmptySSIDmessage();
    }

    public void OnPasswordResult(WifiData wifiData, IODevice iODevice) {
        this.view.showProgressbar();
        sendWifiData(wifiData, iODevice);
    }

    private void sendWifiData(WifiData wifiData, IODevice iODevice) {
        this.interactor.sendWifiData(wifiData, iODevice);
    }
}
