package kr.switcher.switcherm.ui.main.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import kr.switcher.device.IODevice;
import kr.switcher.device.common.ScannedBLEDevice;
import kr.switcher.device.switcher.ble.ScannedBLESwitcher;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.ga.GALogger;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.device.switcher.handler.SwitcherDBProvider;
import kr.switcher.switcherm.device.switcher.handler.SwitcherHandler;
import kr.switcher.switcherm.ui.dialog.ConfirmCallback;
import kr.switcher.switcherm.ui.dialog.IODialogController;
import kr.switcher.switcherm.ui.main.MainActivity;
import kr.switcher.switcherm.ui.main.helper.MainScreenController;
import kr.switcher.switcherm.ui.main.interactors.FindSharedSwitcherInfoInteractor;
import kr.switcher.switcherm.ui.main.presenters.MainShareCodePresenter;
import kr.switcher.switcherm.ui.main.views.MainShareCodeView;

/* JADX INFO: loaded from: classes2.dex */
public class MainShareCodeFragment extends Fragment implements MainShareCodeView, TextView.OnEditorActionListener {
    private static final String TAG = "MainShareCodeFragment";
    private static MainScreenController.OnMainDataResultCallback callback;

    @BindView(R.id.btn_input_share_code)
    RelativeLayout btn_input_share_code;

    @BindView(R.id.btn_request_share_code)
    TextView btn_request_share_code;

    @BindView(R.id.et_share_code)
    EditText et_share_code;

    @BindView(R.id.lin_refresh)
    LinearLayout lin_refresh;

    @BindView(R.id.lin_request)
    LinearLayout lin_request;

    @BindView(R.id.lin_request_1)
    LinearLayout lin_request_1;

    @BindView(R.id.lin_request_2)
    LinearLayout lin_request_2;

    @BindView(R.id.lin_request_3)
    LinearLayout lin_request_3;

    @BindView(R.id.lin_share_code_input)
    LinearLayout lin_share_code_input;
    private String owner;

    @BindView(R.id.pb_comparing)
    ProgressBar pb_comparing;
    private MainShareCodePresenter presenter;

    @BindView(R.id.rl_product_image)
    RelativeLayout rl_product_image;
    private ScannedBLESwitcher scannedBLESwitcher;

    public static MainShareCodeFragment newInstance(ScannedBLEDevice scannedBLEDevice, MainScreenController.OnMainDataResultCallback onMainDataResultCallback) {
        callback = onMainDataResultCallback;
        MainShareCodeFragment mainShareCodeFragment = new MainShareCodeFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(MainScreenController.INTENT_PARM_SCANNED_DEVICE_TO_CONNECT, scannedBLEDevice);
        mainShareCodeFragment.setArguments(bundle);
        return mainShareCodeFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_main_share_code, viewGroup, false);
        ButterKnife.bind(this, viewInflate);
        Bundle arguments = getArguments();
        if (arguments == null) {
            return viewInflate;
        }
        ScannedBLESwitcher scannedBLESwitcher = (ScannedBLESwitcher) arguments.getParcelable(MainScreenController.INTENT_PARM_SCANNED_DEVICE_TO_CONNECT);
        this.scannedBLESwitcher = scannedBLESwitcher;
        if (!checkIsValidScannedSwitcher(scannedBLESwitcher)) {
            return null;
        }
        MainShareCodePresenter mainShareCodePresenter = new MainShareCodePresenter(this, new FindSharedSwitcherInfoInteractor(this.scannedBLESwitcher.getDevice().getAddress()));
        this.presenter = mainShareCodePresenter;
        mainShareCodePresenter.checkInternet();
        this.et_share_code.setOnEditorActionListener(this);
        return viewInflate;
    }

    private boolean checkIsValidScannedSwitcher(ScannedBLESwitcher scannedBLESwitcher) {
        return (scannedBLESwitcher == null || scannedBLESwitcher.getDevice() == null || scannedBLESwitcher.getDevice().getAddress() == null || scannedBLESwitcher.getAdvertisementPacket() == null || scannedBLESwitcher.getAdvertisementPacket().getSwitcherType() == 0) ? false : true;
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainShareCodeView
    public void initialize() {
        this.presenter.initialize(this.scannedBLESwitcher);
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainShareCodeView
    public void clearLinearLayout() {
        this.lin_request_1.removeAllViews();
        this.lin_request_2.removeAllViews();
        this.lin_request_3.removeAllViews();
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainShareCodeView
    public void showDefaultView() {
        IOUtil.appendTextView(this.lin_request_1, IOUtil.getStringResource(R.string.share_manual1) + "\n", IOUtil.getColorResource(R.color.cool_grey_two), 13);
        IOUtil.appendTextView(this.lin_request_2, IOUtil.getStringResource(R.string.share_manual2), IOUtil.getColorResource(R.color.periwinkle), 13);
        IOUtil.appendTextView(this.lin_request_2, "", IOUtil.getColorResource(R.color.periwinkle), 13);
        IOUtil.appendTextView(this.lin_request_2, IOUtil.getStringResource(R.string.share_manual3) + "\n", IOUtil.getColorResource(R.color.cool_grey_two), 13);
        IOUtil.appendTextView(this.lin_request_3, IOUtil.getStringResource(R.string.share_manual4) + "\n", IOUtil.getColorResource(R.color.cool_grey_two), 13);
        this.lin_request.setVisibility(8);
        this.lin_refresh.setVisibility(8);
        this.btn_request_share_code.setText(IOUtil.getStringResource(R.string.request_share_code));
        this.et_share_code.setHint(IOUtil.getStringResource(R.string.edit_share_code));
        this.et_share_code.setEnabled(false);
        this.rl_product_image.setVisibility(0);
        this.btn_request_share_code.setVisibility(4);
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainShareCodeView
    public void showCodeView(String str) {
        this.owner = str;
        IOUtil.appendTextView(this.lin_request_1, IOUtil.getStringResource(R.string.share_manual1) + "\n", IOUtil.getColorResource(R.color.cool_grey_two), 13);
        IOUtil.appendTextView(this.lin_request_2, IOUtil.getStringResource(R.string.share_manual2), IOUtil.getColorResource(R.color.periwinkle), 13);
        IOUtil.appendTextView(this.lin_request_2, str, IOUtil.getColorResource(R.color.periwinkle), 13);
        IOUtil.appendTextView(this.lin_request_2, IOUtil.getStringResource(R.string.share_manual3) + "\n", IOUtil.getColorResource(R.color.cool_grey_two), 13);
        IOUtil.appendTextView(this.lin_request_3, IOUtil.getStringResource(R.string.share_manual4) + "\n", IOUtil.getColorResource(R.color.cool_grey_two), 13);
        this.lin_request.setVisibility(0);
        this.lin_refresh.setVisibility(8);
        this.btn_request_share_code.setText(IOUtil.getStringResource(R.string.request_share_code));
        this.et_share_code.setHint(IOUtil.getStringResource(R.string.edit_share_code));
        this.et_share_code.setEnabled(true);
        this.rl_product_image.setVisibility(0);
        this.btn_request_share_code.setVisibility(0);
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainShareCodeView
    public void showRequestedView() {
        IOUtil.appendTextView(this.lin_request_1, IOUtil.getStringResource(R.string.share_manual2), IOUtil.getColorResource(R.color.periwinkle), 13);
        IOUtil.appendTextView(this.lin_request_1, this.owner + " ", IOUtil.getColorResource(R.color.periwinkle), 13);
        IOUtil.appendTextView(this.lin_request_1, IOUtil.getStringResource(R.string.share_manual5) + "\n", IOUtil.getColorResource(R.color.cool_grey_two), 13);
        IOUtil.appendTextView(this.lin_request_2, IOUtil.getStringResource(R.string.share_manual6) + "\n", IOUtil.getColorResource(R.color.cool_grey_two), 13);
        IOUtil.appendTextView(this.lin_request_3, IOUtil.getStringResource(R.string.share_manual7) + "\n", IOUtil.getColorResource(R.color.cool_grey_two), 13);
        this.lin_request.setVisibility(0);
        this.lin_refresh.setVisibility(8);
        this.btn_request_share_code.setText(IOUtil.getStringResource(R.string.re_request_share_code));
        this.et_share_code.setHint(IOUtil.getStringResource(R.string.edit_share_code));
        this.et_share_code.setEnabled(true);
        this.rl_product_image.setVisibility(0);
        this.btn_request_share_code.setVisibility(0);
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainShareCodeView
    public void showNoInternetView() {
        IOUtil.appendTextView(this.lin_request_1, IOUtil.getStringResource(R.string.share_manual8) + "\n", IOUtil.getColorResource(R.color.cool_grey_two), 13);
        IOUtil.appendTextView(this.lin_request_2, IOUtil.getStringResource(R.string.share_manual9) + "\n", IOUtil.getColorResource(R.color.cool_grey_two), 13);
        this.lin_request.setVisibility(8);
        this.lin_refresh.setVisibility(8);
        this.et_share_code.setHint(IOUtil.getStringResource(R.string.disconnected_internet));
        this.et_share_code.setEnabled(false);
        this.rl_product_image.setVisibility(4);
        this.btn_request_share_code.setVisibility(4);
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainShareCodeView
    public void showUnknownView() {
        IOUtil.appendTextView(this.lin_request_1, IOUtil.getStringResource(R.string.not_registered_device) + "\n", IOUtil.getColorResource(R.color.cool_grey_two), 13);
        this.lin_request.setVisibility(8);
        this.lin_refresh.setVisibility(8);
        this.et_share_code.setHint("");
        this.et_share_code.setEnabled(false);
        this.rl_product_image.setVisibility(4);
        this.btn_request_share_code.setVisibility(4);
        this.lin_share_code_input.setVisibility(4);
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainShareCodeView
    public void showSuccessDialog() {
        IODialogController.showConfirmDialog(getContext(), IOUtil.getStringResource(R.string.successfully_request_share_code_sms), new ConfirmCallback() { // from class: kr.switcher.switcherm.ui.main.fragment.MainShareCodeFragment.1
            @Override // kr.switcher.switcherm.ui.dialog.ConfirmCallback
            public void onConfirmResult(boolean z) {
                MainShareCodeFragment.this.presenter.dismissSuccessDialog();
            }
        });
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainShareCodeView
    public void showFailureDialog() {
        IODialogController.showConfirmDialog(getContext(), IOUtil.getStringResource(R.string.failed_request_share_code_sms), null);
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainShareCodeView
    public void showNoInternetDialog() {
        IODialogController.showConfirmDialog(getContext(), IOUtil.getStringResource(R.string.share_manual8) + " " + IOUtil.getStringResource(R.string.share_manual9), null);
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainShareCodeView
    public void showProgressbar() {
        this.pb_comparing.setVisibility(0);
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainShareCodeView
    public void hideProgressbar() {
        this.pb_comparing.setVisibility(8);
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainShareCodeView
    public void finishJob(String str) {
        hideProgressbar();
        IOUtil.hideKeyBoard(this.et_share_code);
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainShareCodeView
    public void trackCodeForGA() {
        IOLog.activity(IOUtil.getStringResource(R.string.screen_title_2_2_2_0));
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainShareCodeView
    public void trackSuccessForGA() {
        IOLog.activity(IOUtil.getStringResource(R.string.screen_title_2_2_2_0_0));
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainShareCodeView
    public void trackRequestedForGA() {
        IOLog.activity(IOUtil.getStringResource(R.string.screen_title_2_2_2_0_1));
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainShareCodeView
    public void trackNoWifiForGA() {
        IOLog.activity(IOUtil.getStringResource(R.string.screen_title_2_2_2_1));
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainShareCodeView
    public void trackFailForGA() {
        IOLog.activity(IOUtil.getStringResource(R.string.screen_title_2_2_2_0_2));
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainShareCodeView
    public void requestShareCodeEventForGA() {
        IOLog.event(GALogger.CATEGORY_SECURITY, GALogger.ACTION_REQUEST_SHARE_CODE_TO_MASTER_FROM_GUEST);
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainShareCodeView
    public void sendMainData(String str, IODevice.ProductId productId, String str2, String str3, MainActivity.MainBackgroundState mainBackgroundState) {
        callback.onMainData(str, productId, str2, str3, mainBackgroundState);
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainShareCodeView
    public void showErrorMessage(String str) {
        IOUtil.showToast(str);
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainShareCodeView
    public void saveShareCodeToDB(String str) {
        if (new SwitcherDBProvider().updateShareCodeToDB(SwitcherHandler.getInstance().getSwitcher(this.scannedBLESwitcher.getDevice().getAddress()), str) != 1) {
            IOUtil.showToast("공유코드를 저장하는데 실패했습니다");
        }
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainShareCodeView
    public void moveConnectingScreen() {
        Intent intent = new Intent();
        intent.putExtra(MainScreenController.INTENT_PARM_SCANNED_DEVICE_TO_CONNECT, this.scannedBLESwitcher);
        intent.putExtra(MainScreenController.INTENT_PARM_MAC_ADDRESS_TO_CONNECT, this.scannedBLESwitcher.getDevice().getAddress());
        MainScreenController.moveMainScreen(MainScreenController.MainScreen.CONNECTING, intent);
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        this.presenter.onEditorAction(i, this.scannedBLESwitcher.getDevice().getAddress(), this.et_share_code.getText().toString());
        return true;
    }

    @OnClick({R.id.btn_input_share_code})
    public void onInputShareCodeButtonClicked() {
        this.presenter.onInputShareCodeButtonClicked(this.scannedBLESwitcher.getDevice().getAddress(), this.et_share_code.getText().toString());
    }

    @OnClick({R.id.btn_request_share_code})
    public void onRequestShareCodeButtonClicked() {
        this.presenter.onRequestShareCodeButtonClicked(this.scannedBLESwitcher.getDevice().getAddress());
    }

    @OnClick({R.id.btn_refresh})
    public void onRefreshInternetStatusButtonClicked() {
        this.presenter.onRefreshInternetStatusButtonClicked();
    }
}
