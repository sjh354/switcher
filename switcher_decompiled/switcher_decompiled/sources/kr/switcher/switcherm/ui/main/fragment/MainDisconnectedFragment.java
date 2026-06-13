package kr.switcher.switcherm.ui.main.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import kr.switcher.device.IODevice;
import kr.switcher.device.switcher.Switcher;
import kr.switcher.device.switcher.ble.SwitcherBLE;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.device.switcher.handler.SwitcherHandler;
import kr.switcher.switcherm.ui.main.MainActivity;
import kr.switcher.switcherm.ui.main.helper.MainScreenController;
import kr.switcher.switcherm.ui.main.presenters.MainDisconnectedPresenter;
import kr.switcher.switcherm.ui.main.views.MainDisconnectedView;
import kr.switcher.switcherm.ui.troubleshooting.TroubleshootingActivity;

/* JADX INFO: loaded from: classes2.dex */
public class MainDisconnectedFragment extends Fragment implements MainDisconnectedView {
    private static final String TAG = "MainDisconnectedFragment";
    private static MainScreenController.OnMainDataResultCallback callback;
    private static int reconnectCount;
    private final int RECONNECT_NUM = 2;
    private String disconnectedMacAddress;
    private Switcher disconnectedSwitcher;

    @BindView(R.id.lin_manual2)
    LinearLayout lin_manual2;

    @BindView(R.id.pb_reconnecting)
    ProgressBar pb_reconnecting;
    private MainDisconnectedPresenter presenter;

    @BindView(R.id.tv_manual1)
    TextView tv_manual1;

    @BindView(R.id.tv_manual2_1)
    TextView tv_manual2_1;

    @BindView(R.id.tv_manual2_2)
    TextView tv_manual2_2;

    public static MainDisconnectedFragment newInstance(String str, int i, MainScreenController.OnMainDataResultCallback onMainDataResultCallback) {
        callback = onMainDataResultCallback;
        MainDisconnectedFragment mainDisconnectedFragment = new MainDisconnectedFragment();
        Bundle bundle = new Bundle();
        bundle.putString(MainScreenController.INTENT_PARM_DISCONNECTED_MAC_ADDRESS, str);
        bundle.putInt(MainScreenController.INTENT_PARM_ERROR_STATUS, i);
        mainDisconnectedFragment.setArguments(bundle);
        return mainDisconnectedFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        IOLog.activity(IOUtil.getStringResource(R.string.screen_title_2_3_3));
        if (reconnectCount >= 2) {
            if (this.disconnectedSwitcher.getClass().equals(SwitcherBLE.class)) {
                this.tv_manual2_1.setText("계속 연결에 실패할 경우\n폰을 한번 껐다 켜는 것을 제안해 드립니다");
                this.tv_manual2_2.setText("");
            } else {
                this.tv_manual2_1.setText("링커 주변에 '" + this.disconnectedSwitcher.getSerialNumber() + "' 스위처가 있는지 확인해주세요");
                this.tv_manual2_2.setText("");
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_main_disconnected, viewGroup, false);
        ButterKnife.bind(this, viewInflate);
        Bundle arguments = getArguments();
        if (arguments == null) {
            return viewInflate;
        }
        String string = arguments.getString(MainScreenController.INTENT_PARM_DISCONNECTED_MAC_ADDRESS);
        this.disconnectedMacAddress = string;
        if (!IOUtil.checkIsIODeviceKey(string)) {
            return viewInflate;
        }
        int i = arguments.getInt(MainScreenController.INTENT_PARM_ERROR_STATUS);
        Switcher switcher = SwitcherHandler.getInstance().getSwitcher(this.disconnectedMacAddress);
        this.disconnectedSwitcher = switcher;
        if (switcher == null) {
            return viewInflate;
        }
        MainDisconnectedPresenter mainDisconnectedPresenter = new MainDisconnectedPresenter(this);
        this.presenter = mainDisconnectedPresenter;
        mainDisconnectedPresenter.onCreateView(this.disconnectedSwitcher, i);
        return viewInflate;
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainDisconnectedView
    public void showProgressbar() {
        this.pb_reconnecting.setVisibility(0);
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainDisconnectedView
    public void hideProgressbar() {
        this.pb_reconnecting.setVisibility(8);
    }

    @OnClick({R.id.btn_reconnect})
    public void onReconnectButtonClicked() {
        this.presenter.reconnect(this.disconnectedMacAddress);
        reconnectCount++;
    }

    @OnClick({R.id.btn_troubleshooting})
    public void onTroubleshootingButtonClicked() {
        startActivity(new Intent(getContext(), (Class<?>) TroubleshootingActivity.class));
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.presenter.onPause();
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainDisconnectedView
    public void sendMainData(String str, IODevice.ProductId productId, String str2, String str3, MainActivity.MainBackgroundState mainBackgroundState) {
        callback.onMainData(str, productId, str2, str3, mainBackgroundState);
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainDisconnectedView
    public void moveConnectingScreen(String str) {
        Intent intent = new Intent();
        intent.putExtra(MainScreenController.INTENT_PARM_MAC_ADDRESS_TO_CONNECT, str);
        intent.putExtra(MainScreenController.INTENT_PARM_SCANNED_DEVICE_TO_CONNECT, str);
        MainScreenController.moveMainScreen(MainScreenController.MainScreen.CONNECTING, intent);
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainDisconnectedView
    public void showMessage(String str) {
        IOUtil.showToast(str);
    }
}
