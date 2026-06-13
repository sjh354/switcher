package kr.switcher.switcherm.ui.wifi;

import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import kr.switcher.device.IODevice;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.activity.IOActivity;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.device.IODeviceHandler;
import kr.switcher.switcherm.network.wifi.WifiData;
import kr.switcher.switcherm.preference.OAuthToken;
import kr.switcher.switcherm.ui.wifi.fragments.WifiListFragment;
import kr.switcher.switcherm.ui.wifi.fragments.WifiPasswordFragment;
import kr.switcher.switcherm.ui.wifi.interactor.SendWifiDataInteractor;
import kr.switcher.switcherm.ui.wifi.presenter.WifiPresenter;
import kr.switcher.switcherm.ui.wifi.view.WifiView;

/* JADX INFO: loaded from: classes2.dex */
public class WifiActivity extends IOActivity implements WifiView, WifiListFragment.OnWifiDataResultCallback, WifiPasswordFragment.OnPasswordResultCallback, SendWifiDataInteractor.OnSendWifiDataListener {
    public static final String INTENT_PARM_CONNECTED_MAC_ADDRESS = "INTENT_PARM_CONNECTED_MAC_ADDRESS";
    private static final String TAG = "WifiActivity";
    private IODevice ioDevice;

    @BindView(R.id.pb_sending)
    ProgressBar pb_sending;
    private WifiPresenter presenter;

    @BindView(R.id.tv_menu_name)
    TextView tv_menu_name;
    private WifiData wifiData;
    private WifiListFragment wifiListFragment;
    private WifiPasswordFragment wifiPasswordFragment;

    @Override // kr.switcher.switcherm.common.activity.IOActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_wifi);
        ButterKnife.bind(this);
        String stringExtra = getIntent().getStringExtra(INTENT_PARM_CONNECTED_MAC_ADDRESS);
        if (!IOUtil.checkIsIODeviceKey(stringExtra)) {
            IOUtil.showToast("잘못된 접근입니다");
            finish();
        }
        IODevice device = IODeviceHandler.getInstance().getDevice(stringExtra);
        this.ioDevice = device;
        if (device == null) {
            IOUtil.showToast("잘못된 접근입니다");
            finish();
        }
        hideProgressbar();
        this.wifiListFragment = WifiListFragment.newInstance(this);
        this.presenter = new WifiPresenter(this, new SendWifiDataInteractor(this));
    }

    private void moveFragment(Fragment fragment, String str) {
        FragmentTransaction fragmentTransactionBeginTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransactionBeginTransaction.replace(R.id.container, fragment, str);
        try {
            fragmentTransactionBeginTransaction.commit();
        } catch (Exception e) {
            IOLog.error(TAG, new OAuthToken().getOAuthToken(), "moveWifiConnectFragment", e);
        }
    }

    @Override // kr.switcher.switcherm.ui.wifi.view.WifiView
    public void setMenuTitleName(String str) {
        this.tv_menu_name.setText(str);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        IODevice iODevice = this.ioDevice;
        if (iODevice != null) {
            iODevice.disconnect();
        }
        finish();
    }

    @Override // kr.switcher.switcherm.ui.wifi.view.WifiView
    public void showProgressbar() {
        IOUtil.showProgressbarDialog(this, this.pb_sending, 60000);
    }

    @Override // kr.switcher.switcherm.ui.wifi.view.WifiView
    public void hideProgressbar() {
        IOUtil.hideProgressbarDialog(this, this.pb_sending);
    }

    @Override // kr.switcher.switcherm.ui.wifi.view.WifiView
    public void moveWifiListFragment() {
        moveFragment(this.wifiListFragment, "WifiListFragment");
    }

    @Override // kr.switcher.switcherm.ui.wifi.view.WifiView
    public void moveWifiPasswordFragment() {
        WifiPasswordFragment wifiPasswordFragmentNewInstance = WifiPasswordFragment.newInstance(this, this.wifiData);
        this.wifiPasswordFragment = wifiPasswordFragmentNewInstance;
        moveFragment(wifiPasswordFragmentNewInstance, "WifiPasswordFragment");
    }

    @Override // kr.switcher.switcherm.ui.wifi.view.WifiView
    public void showEmptySSIDmessage() {
        IOUtil.showToast(R.string.ssid_empty_message);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        this.presenter.onBackPressed(getSupportFragmentManager());
    }

    @OnClick({R.id.btn_left_arrow})
    public void onLeftButtonClicked() {
        onBackPressed();
    }

    @Override // kr.switcher.switcherm.ui.wifi.fragments.WifiListFragment.OnWifiDataResultCallback
    public void onWifiDataResult(WifiData wifiData) {
        this.wifiData = wifiData;
        this.presenter.onWifiDataResult(wifiData, this.ioDevice);
    }

    @Override // kr.switcher.switcherm.ui.wifi.fragments.WifiPasswordFragment.OnPasswordResultCallback
    public void OnPasswordResult(String str) {
        this.wifiData.setPassword(str);
        this.presenter.OnPasswordResult(this.wifiData, this.ioDevice);
    }

    @Override // kr.switcher.switcherm.ui.wifi.interactor.SendWifiDataInteractor.OnSendWifiDataListener
    public void onSend(String str) {
        IOUtil.showToast(str);
    }

    @Override // kr.switcher.switcherm.ui.wifi.interactor.SendWifiDataInteractor.OnSendWifiDataListener
    public void onFinish() {
        finish();
    }

    @Override // kr.switcher.switcherm.ui.wifi.interactor.SendWifiDataInteractor.OnSendWifiDataListener
    public void onFail(String str) {
        hideProgressbar();
        IOUtil.showToast(str);
    }
}
