package kr.switcher.switcherm.ui.switcherInfo.fragments;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import kr.switcher.device.IODevice;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.device.IODeviceHandler;
import kr.switcher.switcherm.ui.main.MainActivity;
import kr.switcher.switcherm.ui.switcherInfo.interactors.FindSwitcherInfoInteractor;
import kr.switcher.switcherm.ui.switcherInfo.presenters.FreeTrialPresent;
import kr.switcher.switcherm.ui.switcherInfo.views.LeaseFreeView;

/* JADX INFO: loaded from: classes2.dex */
public class FreeTrialFragment extends Fragment implements LeaseFreeView {
    private String connectedMacAddress;

    @BindView(R.id.iv_switcher_icon)
    ImageView iv_switcher_icon;
    private FreeTrialPresent presenter;

    @BindView(R.id.tv_first_payment_at)
    TextView tv_first_payment_at;

    @BindView(R.id.tv_owner)
    TextView tv_owner;

    @BindView(R.id.tv_payment_card)
    TextView tv_payment_card;

    @BindView(R.id.tv_payment_type)
    TextView tv_payment_type;

    @BindView(R.id.tv_room_name)
    TextView tv_room_name;

    @BindView(R.id.tv_serial_number)
    TextView tv_serial_number;

    @BindView(R.id.tv_share_code)
    TextView tv_share_code;

    @BindView(R.id.tv_switcher_type)
    TextView tv_switcher_type;

    @Override // kr.switcher.switcherm.ui.switcherInfo.views.LeaseFreeView
    public void trackLeaseFreeForGA() {
    }

    public static FreeTrialFragment newInstance(String str) {
        FreeTrialFragment freeTrialFragment = new FreeTrialFragment();
        Bundle bundle = new Bundle();
        bundle.putString("CONNECTED_MAC_ADDRESS", str);
        freeTrialFragment.setArguments(bundle);
        return freeTrialFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_free_trial, viewGroup, false);
        ButterKnife.bind(this, viewInflate);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.connectedMacAddress = arguments.getString("CONNECTED_MAC_ADDRESS");
        }
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        IODevice device = IODeviceHandler.getInstance().getDevice(this.connectedMacAddress);
        if (device == null) {
            IOUtil.showToast(IOUtil.getStringResource(R.string.not_found_switcher));
            getActivity().finish();
        } else {
            FreeTrialPresent freeTrialPresent = new FreeTrialPresent(this, new FindSwitcherInfoInteractor(getContext(), device));
            this.presenter = freeTrialPresent;
            freeTrialPresent.onResume(device);
        }
    }

    @Override // kr.switcher.switcherm.ui.switcherInfo.views.LeaseFreeView
    public void finish() {
        getActivity().finish();
    }

    @Override // kr.switcher.switcherm.ui.switcherInfo.views.LeaseFreeView
    public void showMessage(String str) {
        IOUtil.showToast(str);
    }

    @Override // kr.switcher.switcherm.ui.switcherInfo.views.LeaseFreeView
    public void setPaymentType(String str) {
        this.tv_payment_type.setText(str);
    }

    @Override // kr.switcher.switcherm.ui.switcherInfo.views.LeaseFreeView
    public void setSwitcherImage(Drawable drawable) {
        this.iv_switcher_icon.setImageDrawable(drawable);
    }

    @Override // kr.switcher.switcherm.ui.switcherInfo.views.LeaseFreeView
    public void setSwitcherType(String str) {
        this.tv_switcher_type.setText(str);
    }

    @Override // kr.switcher.switcherm.ui.switcherInfo.views.LeaseFreeView
    public void setRoomName(String str) {
        this.tv_room_name.setText(str);
    }

    @Override // kr.switcher.switcherm.ui.switcherInfo.views.LeaseFreeView
    public void setOwnerName(String str) {
        this.tv_owner.setText(str);
    }

    @Override // kr.switcher.switcherm.ui.switcherInfo.views.LeaseFreeView
    public void setPKey(String str) {
        this.tv_serial_number.setText(str);
    }

    @Override // kr.switcher.switcherm.ui.switcherInfo.views.LeaseFreeView
    public void setShareCode(String str) {
        this.tv_share_code.setText(str);
    }

    @Override // kr.switcher.switcherm.ui.switcherInfo.views.LeaseFreeView
    public void setPaymentCard(String str) {
        this.tv_payment_card.setText(str);
    }

    @Override // kr.switcher.switcherm.ui.switcherInfo.views.LeaseFreeView
    public void setFirstPaymentAt(String str) {
        this.tv_first_payment_at.setText(str);
    }

    @Override // kr.switcher.switcherm.ui.switcherInfo.views.LeaseFreeView
    public void moveSwitcherListScreen() {
        getActivity().setResult(104, new Intent(getActivity(), (Class<?>) MainActivity.class));
        finish();
    }
}
