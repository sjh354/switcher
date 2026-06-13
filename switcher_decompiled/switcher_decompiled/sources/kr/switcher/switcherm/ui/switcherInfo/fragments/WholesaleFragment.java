package kr.switcher.switcherm.ui.switcherInfo.fragments;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import kr.switcher.device.IODevice;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.device.IODeviceHandler;
import kr.switcher.switcherm.ui.dialog.IODialogController;
import kr.switcher.switcherm.ui.main.MainActivity;
import kr.switcher.switcherm.ui.switcherInfo.interactors.FindSwitcherInfoInteractor;
import kr.switcher.switcherm.ui.switcherInfo.presenters.WholesalePresenter;
import kr.switcher.switcherm.ui.switcherInfo.views.WholesaleView;
import kr.switcher.switcherm.user.UserStateManager;

/* JADX INFO: loaded from: classes2.dex */
public class WholesaleFragment extends Fragment implements WholesaleView {

    @BindView(R.id.btn_initialize)
    TextView btn_initialize;
    private IODevice ioDevice;

    @BindView(R.id.iv_switcher_icon)
    ImageView iv_switcher_icon;

    @BindView(R.id.lin_owner_menu)
    LinearLayout lin_owner_menu;

    @BindView(R.id.pb_initialize)
    ProgressBar pb_initialize;
    private WholesalePresenter presenter;

    @BindView(R.id.tv_owner)
    TextView tv_owner;

    @BindView(R.id.tv_room_name)
    TextView tv_room_name;

    @BindView(R.id.tv_serial_number)
    TextView tv_serial_number;

    @BindView(R.id.tv_share_code)
    TextView tv_share_code;

    @BindView(R.id.tv_switcher_type)
    TextView tv_switcher_type;

    @BindView(R.id.tv_warranty_date)
    TextView tv_warranty_date;

    public static WholesaleFragment newInstance(String str) {
        WholesaleFragment wholesaleFragment = new WholesaleFragment();
        Bundle bundle = new Bundle();
        bundle.putString("CONNECTED_MAC_ADDRESS", str);
        wholesaleFragment.setArguments(bundle);
        return wholesaleFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_wholesale, viewGroup, false);
        ButterKnife.bind(this, viewInflate);
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString("CONNECTED_MAC_ADDRESS") : "";
        if (!IOUtil.checkIsIODeviceKey(string)) {
            return null;
        }
        IODevice device = IODeviceHandler.getInstance().getDevice(string);
        this.ioDevice = device;
        if (device == null) {
            IOUtil.showToast(IOUtil.getStringResource(R.string.not_found_device));
            getActivity().finish();
            return null;
        }
        WholesalePresenter wholesalePresenter = new WholesalePresenter(this, new FindSwitcherInfoInteractor(getContext(), this.ioDevice));
        this.presenter = wholesalePresenter;
        wholesalePresenter.initialize(this.ioDevice);
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.presenter.setSwitcherInfo();
    }

    @Override // kr.switcher.switcherm.ui.switcherInfo.views.WholesaleView
    public void finish() {
        getActivity().finish();
    }

    @Override // kr.switcher.switcherm.ui.switcherInfo.views.WholesaleView
    public void trackWholesaleForGA() {
        IOLog.activity(IOUtil.getStringResource(R.string.screen_title_5_0_5));
    }

    @Override // kr.switcher.switcherm.ui.switcherInfo.views.WholesaleView
    public void trackGuestUsingForGA() {
        IOLog.activity(IOUtil.getStringResource(R.string.screen_title_5_1_1));
    }

    @Override // kr.switcher.switcherm.ui.switcherInfo.views.WholesaleView
    public void trackWarningForGA() {
        IOLog.activity(IOUtil.getStringResource(R.string.screen_title_5_0_5_0));
    }

    @Override // kr.switcher.switcherm.ui.switcherInfo.views.WholesaleView
    public void showErrorMessage(String str) {
        IOUtil.showToast(str);
    }

    @Override // kr.switcher.switcherm.ui.switcherInfo.views.WholesaleView
    public void hideProgressbar() {
        this.pb_initialize.setVisibility(8);
    }

    @Override // kr.switcher.switcherm.ui.switcherInfo.views.WholesaleView
    public void showProgressbar() {
        this.pb_initialize.setVisibility(0);
    }

    @Override // kr.switcher.switcherm.ui.switcherInfo.views.WholesaleView
    public void terminateMainSwitcher() {
        UserStateManager.getInstance().setMainSwitcher("");
    }

    @Override // kr.switcher.switcherm.ui.switcherInfo.views.WholesaleView
    public void showWarningForInitializeDialog() {
        IODialogController.showWarningForInitializeDialog(getContext(), this.presenter);
    }

    @Override // kr.switcher.switcherm.ui.switcherInfo.views.WholesaleView
    public void showWarningForProductInitializeDialog() {
        IODialogController.showWarningForProducInitializeDialog(getContext(), this.presenter);
    }

    @Override // kr.switcher.switcherm.ui.switcherInfo.views.WholesaleView
    public void showOwnerMenu() {
        this.lin_owner_menu.setVisibility(0);
    }

    @Override // kr.switcher.switcherm.ui.switcherInfo.views.WholesaleView
    public void hideOwnerMenu() {
        this.lin_owner_menu.setVisibility(4);
    }

    @Override // kr.switcher.switcherm.ui.switcherInfo.views.WholesaleView
    public void setInitButton(IODevice iODevice) {
        this.presenter.setInitButton(iODevice);
    }

    @Override // kr.switcher.switcherm.ui.switcherInfo.views.WholesaleView
    public void hideInitButton() {
        this.btn_initialize.setVisibility(8);
    }

    @Override // kr.switcher.switcherm.ui.switcherInfo.views.WholesaleView
    public void showInitButton() {
        this.btn_initialize.setVisibility(0);
    }

    @Override // kr.switcher.switcherm.ui.switcherInfo.views.WholesaleView
    public void setSwitcherImage(Drawable drawable) {
        this.iv_switcher_icon.setImageDrawable(drawable);
    }

    @Override // kr.switcher.switcherm.ui.switcherInfo.views.WholesaleView
    public void setSwitcherType(String str) {
        this.tv_switcher_type.setText(str);
    }

    @Override // kr.switcher.switcherm.ui.switcherInfo.views.WholesaleView
    public void setRoomName(String str) {
        this.tv_room_name.setText(str);
    }

    @Override // kr.switcher.switcherm.ui.switcherInfo.views.WholesaleView
    public void setOwnerName(String str) {
        this.tv_owner.setText(str);
    }

    @Override // kr.switcher.switcherm.ui.switcherInfo.views.WholesaleView
    public void setPKey(String str) {
        this.tv_serial_number.setText(str);
    }

    @Override // kr.switcher.switcherm.ui.switcherInfo.views.WholesaleView
    public void setShareCode(String str) {
        this.tv_share_code.setText(str);
    }

    @Override // kr.switcher.switcherm.ui.switcherInfo.views.WholesaleView
    public void setWarrantyDate(String str) {
        this.tv_warranty_date.setText(str);
    }

    @Override // kr.switcher.switcherm.ui.switcherInfo.views.WholesaleView
    public void moveSwitcherListScreen() {
        getActivity().setResult(104, new Intent(getActivity(), (Class<?>) MainActivity.class));
        finish();
    }

    @OnClick({R.id.btn_initialize})
    public void onInitializeButtonClicked() {
        this.presenter.onInitializeButtonClicked(this.ioDevice);
    }
}
