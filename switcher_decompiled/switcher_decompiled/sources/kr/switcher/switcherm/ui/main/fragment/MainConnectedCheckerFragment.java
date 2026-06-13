package kr.switcher.switcherm.ui.main.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import kr.switcher.device.IODevice;
import kr.switcher.device.checker.Checker;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.activity.ActivityController;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.device.IODeviceHandler;
import kr.switcher.switcherm.ui.main.MainActivity;
import kr.switcher.switcherm.ui.main.helper.MainScreenController;
import kr.switcher.switcherm.ui.main.interactors.GetCheckerIsOpenInteractor;
import kr.switcher.switcherm.ui.main.presenters.MainConnectedCheckerPresenter;
import kr.switcher.switcherm.ui.main.views.MainConnectedCheckerView;

/* JADX INFO: loaded from: classes2.dex */
public class MainConnectedCheckerFragment extends Fragment implements MainConnectedCheckerView, GetCheckerIsOpenInteractor.OnGetCheckerIsOpenListener {
    private static final String PARM_CONNECTED_MAC_ADDRESS = "CONNECTED_ID";
    private static final String TAG = "MainConnectedCheckerFragment";
    private static MainScreenController.OnMainDataResultCallback callback;

    @BindView(R.id.btn_surveillance)
    ImageView btn_surveillance;
    private Checker connectedChecker;

    @BindView(R.id.iv_checker)
    ImageView iv_checker;
    private MainConnectedCheckerPresenter presenter;

    @BindView(R.id.rl_history)
    RelativeLayout rl_history;

    @BindView(R.id.rl_setting)
    RelativeLayout rl_setting;

    @BindView(R.id.rl_surveillance)
    RelativeLayout rl_surbeillance;

    @BindView(R.id.tv_checker_name)
    TextView tv_checker_name;

    @BindView(R.id.tv_is_opened)
    TextView tv_is_opened;

    public static MainConnectedCheckerFragment newInstance(String str, MainScreenController.OnMainDataResultCallback onMainDataResultCallback) {
        callback = onMainDataResultCallback;
        MainConnectedCheckerFragment mainConnectedCheckerFragment = new MainConnectedCheckerFragment();
        Bundle bundle = new Bundle();
        bundle.putString(PARM_CONNECTED_MAC_ADDRESS, str);
        mainConnectedCheckerFragment.setArguments(bundle);
        return mainConnectedCheckerFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_checker_main_connected, viewGroup, false);
        ButterKnife.bind(this, viewInflate);
        Bundle arguments = getArguments();
        Checker checker = (Checker) IODeviceHandler.getInstance().getDevice(arguments != null ? arguments.getString(PARM_CONNECTED_MAC_ADDRESS) : "");
        this.connectedChecker = checker;
        if (checker == null) {
            return null;
        }
        this.presenter = new MainConnectedCheckerPresenter(this, new GetCheckerIsOpenInteractor(this));
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.presenter.onResume(this.connectedChecker);
    }

    @OnClick({R.id.btn_history})
    public void onMoveHistoryMenuButtonClicked() {
        ActivityController.moveCheckerHistoryMenuActivity(getActivity(), this.connectedChecker.getMacAddress());
    }

    @OnClick({R.id.btn_setting})
    public void onMoveSettingMenuButtonClicked() {
        ActivityController.moveSettingMenuActivity(getActivity(), this.connectedChecker.getMacAddress());
    }

    @OnClick({R.id.btn_surveillance})
    public void onMoveSurveillanceMenuButtonClicked() {
        this.presenter.onSurveillanceButtonClicked();
        ActivityController.moveSurveillanceMenuActivity(getActivity(), this.connectedChecker.getMacAddress());
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainConnectedCheckerView
    public void onMainData(String str, IODevice.ProductId productId, String str2, String str3, MainActivity.MainBackgroundState mainBackgroundState) {
        callback.onMainData(str, productId, str2, str3, mainBackgroundState);
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainConnectedCheckerView
    public void setOpen() {
        this.iv_checker.setImageDrawable(IOUtil.getDrawable(R.drawable.ic_checker_main_opened));
        this.tv_is_opened.setText(R.string.checker_is_open);
        setName();
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainConnectedCheckerView
    public void setClose() {
        this.iv_checker.setImageDrawable(IOUtil.getDrawable(R.drawable.ic_checker_main_closed));
        this.tv_is_opened.setText(R.string.checker_is_close);
        setName();
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainConnectedCheckerView
    public void initScreen() {
        this.iv_checker.setVisibility(8);
        this.tv_is_opened.setVisibility(8);
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainConnectedCheckerView
    public void setName() {
        this.tv_checker_name.setText(this.connectedChecker.getName());
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainConnectedCheckerView
    public void showSurveillanceBadge() {
        this.btn_surveillance.setImageDrawable(IOUtil.getDrawable(R.drawable.selector_checker_surveillance_with_badge));
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainConnectedCheckerView
    public void hideSurveillanceBadge() {
        this.btn_surveillance.setImageDrawable(IOUtil.getDrawable(R.drawable.selector_checker_surveillance));
    }

    @Override // kr.switcher.switcherm.ui.main.interactors.GetCheckerIsOpenInteractor.OnGetCheckerIsOpenListener
    public void onGetCheckerIsOpen(String str) {
        this.presenter.onGetCheckerIsOpen(str);
    }
}
