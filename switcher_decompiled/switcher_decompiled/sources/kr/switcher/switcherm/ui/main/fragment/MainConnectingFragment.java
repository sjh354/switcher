package kr.switcher.switcherm.ui.main.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import kr.switcher.device.IODevice;
import kr.switcher.device.common.ScannedBLEDevice;
import kr.switcher.device.switcher.ble.ScannedBLESwitcher;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.ui.main.MainActivity;
import kr.switcher.switcherm.ui.main.helper.FutureAction;
import kr.switcher.switcherm.ui.main.helper.MainScreenController;
import kr.switcher.switcherm.ui.main.interactors.FindCheckerToConnectInteractor;
import kr.switcher.switcherm.ui.main.interactors.FindLinkerToConnectInteractor;
import kr.switcher.switcherm.ui.main.interactors.FindSwitcherToConnectInteractor;
import kr.switcher.switcherm.ui.main.presenters.MainConnectingPresenter;
import kr.switcher.switcherm.ui.main.views.MainConnectingView;
import kr.switcher.switcherm.ui.switcherList.SwitcherListActivity;
import kr.switcher.switcherm.ui.wifi.WifiActivity;
import kr.switcher.switcherm.ui.wifi.interactor.ConnectBLEDeviceInteractor;

/* JADX INFO: loaded from: classes2.dex */
public class MainConnectingFragment extends Fragment implements MainConnectingView, ConnectBLEDeviceInteractor.OnBLEConnectDeviceListener {
    private static final String TAG = "MainConnectingFragment";
    private static MainScreenController.OnMainDataResultCallback callback;

    @BindView(R.id.lin_1set)
    LinearLayout lin_1set;

    @BindView(R.id.lin_2set)
    LinearLayout lin_2set;
    private MainConnectingPresenter presenter;

    @Override // kr.switcher.switcherm.ui.wifi.interactor.ConnectBLEDeviceInteractor.OnBLEConnectDeviceListener
    public void onConnecting() {
    }

    @Override // kr.switcher.switcherm.ui.wifi.interactor.ConnectBLEDeviceInteractor.OnBLEConnectDeviceListener
    public void onFail() {
    }

    public static MainConnectingFragment newInstance(ScannedBLEDevice scannedBLEDevice, String str, MainScreenController.OnMainDataResultCallback onMainDataResultCallback) {
        callback = onMainDataResultCallback;
        MainConnectingFragment mainConnectingFragment = new MainConnectingFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(SwitcherListActivity.INTENT_PARM_SWITCHER_TO_CONNECT, scannedBLEDevice);
        bundle.putString(SwitcherListActivity.INTENT_PARM_MAC_ADDRESS, str);
        mainConnectingFragment.setArguments(bundle);
        return mainConnectingFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_main_connecting, viewGroup, false);
        ButterKnife.bind(this, viewInflate);
        Bundle arguments = getArguments();
        if (arguments == null) {
            return viewInflate;
        }
        ScannedBLEDevice scannedBLEDevice = (ScannedBLEDevice) arguments.getParcelable(SwitcherListActivity.INTENT_PARM_SWITCHER_TO_CONNECT);
        String string = arguments.getString(SwitcherListActivity.INTENT_PARM_MAC_ADDRESS);
        if (!IOUtil.checkIsIODeviceKey(string)) {
            return viewInflate;
        }
        MainConnectingPresenter mainConnectingPresenter = new MainConnectingPresenter(this, new FindSwitcherToConnectInteractor(), new FindLinkerToConnectInteractor(), new FindCheckerToConnectInteractor(), new ConnectBLEDeviceInteractor(scannedBLEDevice, this), new FutureAction());
        this.presenter = mainConnectingPresenter;
        mainConnectingPresenter.initialize(scannedBLEDevice, string);
        return viewInflate;
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainConnectingView
    public void trackScanningForGA() {
        IOLog.activity(IOUtil.getStringResource(R.string.screen_title_2_1));
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainConnectingView
    public void trackConnectingForGA() {
        IOLog.activity(IOUtil.getStringResource(R.string.screen_title_2_2));
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainConnectingView
    public void showOneSetView() {
        this.lin_1set.setVisibility(0);
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainConnectingView
    public void hideOneSetView() {
        this.lin_1set.setVisibility(8);
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainConnectingView
    public void showTwoSetView() {
        this.lin_2set.setVisibility(0);
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainConnectingView
    public void hideTwoSetView() {
        this.lin_2set.setVisibility(8);
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainConnectingView
    public void showErrorMessage(String str) {
        IOUtil.showToast(str);
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainConnectingView
    public void sendMainData(String str, IODevice.ProductId productId, String str2, String str3, MainActivity.MainBackgroundState mainBackgroundState) {
        callback.onMainData(str, productId, str2, str3, mainBackgroundState);
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainConnectingView
    public void moveMainShareCodeScreen(ScannedBLESwitcher scannedBLESwitcher) {
        Intent intent = new Intent();
        intent.putExtra(MainScreenController.INTENT_PARM_SCANNED_DEVICE_TO_CONNECT, scannedBLESwitcher);
        MainScreenController.moveMainScreen(MainScreenController.MainScreen.SHARE_CODE, intent);
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainConnectingView
    public void moveMainPaymentScreen(String str) {
        Intent intent = new Intent();
        intent.putExtra(MainScreenController.INTENT_PARM_MAC_ADDRESS_TO_PAY, str);
        MainScreenController.moveMainScreen(MainScreenController.MainScreen.SHARE_CODE, intent);
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainConnectingView
    public void moveMainConnectedScreen(String str) {
        Intent intent = new Intent();
        intent.putExtra("CONNECTED_MAC_ADDRESS", str);
        MainScreenController.moveMainScreen(MainScreenController.MainScreen.CONNECTED, intent);
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainConnectingView
    public void moveMainDisconnectedScreen(String str, int i) {
        Intent intent = new Intent();
        intent.putExtra(MainScreenController.INTENT_PARM_DISCONNECTED_MAC_ADDRESS, str);
        intent.putExtra(MainScreenController.INTENT_PARM_ERROR_STATUS, i);
        MainScreenController.moveMainScreen(MainScreenController.MainScreen.DISCONNECTED, intent);
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainConnectingView
    public void moveRegisterScreen(String str) {
        Intent intent = new Intent();
        intent.putExtra("CONNECTED_MAC_ADDRESS", str);
        MainScreenController.moveMainScreen(MainScreenController.MainScreen.REGISTER, intent);
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainConnectingView
    public void moveMainConnectedRemoconScreen(String str) {
        Intent intent = new Intent();
        intent.putExtra("CONNECTED_MAC_ADDRESS", str);
        MainScreenController.moveMainScreen(MainScreenController.MainScreen.CONNECTED_REMOCON, intent);
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainConnectingView
    public void moveMainConnectedCheckerScreen(String str) {
        Intent intent = new Intent();
        intent.putExtra("CONNECTED_MAC_ADDRESS", str);
        MainScreenController.moveMainScreen(MainScreenController.MainScreen.CONNECTED_CHECKER, intent);
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainConnectingView
    public void moveConnectedAirconRemoconScreen(String str) {
        Intent intent = new Intent();
        intent.putExtra("CONNECTED_MAC_ADDRESS", str);
        MainScreenController.moveMainScreen(MainScreenController.MainScreen.CONNECTED_REMOCON_AIRCON, intent);
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainConnectingView
    public void moveConnectedSettopRemoconScreen(String str) {
        Intent intent = new Intent();
        intent.putExtra("CONNECTED_MAC_ADDRESS", str);
        MainScreenController.moveMainScreen(MainScreenController.MainScreen.CONNECTED_REMOCON_SETTOP, intent);
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainConnectingView
    public void moveWifiSettingScreen(IODevice iODevice) {
        Intent intent = new Intent(getContext(), (Class<?>) WifiActivity.class);
        intent.putExtra(WifiActivity.INTENT_PARM_CONNECTED_MAC_ADDRESS, iODevice.getMacAddress());
        startActivity(intent);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.presenter.onDestroyView();
    }

    @Override // kr.switcher.switcherm.ui.wifi.interactor.ConnectBLEDeviceInteractor.OnBLEConnectDeviceListener
    public void onConnect(IODevice iODevice) {
        this.presenter.onConnect(iODevice);
    }
}
