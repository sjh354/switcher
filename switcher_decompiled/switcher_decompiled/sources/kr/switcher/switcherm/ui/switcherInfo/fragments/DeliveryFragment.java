package kr.switcher.switcherm.ui.switcherInfo.fragments;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import kr.switcher.device.IODevice;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.IOUri;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.device.IODeviceHandler;
import kr.switcher.switcherm.ui.switcherInfo.presenters.DeliveryPresenter;
import kr.switcher.switcherm.ui.switcherInfo.views.DeliveryView;
import kr.switcher.switcherm.user.User;
import kr.switcher.switcherm.user.UserStateManager;

/* JADX INFO: loaded from: classes2.dex */
public class DeliveryFragment extends Fragment implements DeliveryView {
    private static final String TAG = "DeliveryFragment";

    @BindView(R.id.iv_switcher_icon)
    ImageView iv_switcher_icon;
    private DeliveryPresenter presenter;

    @BindView(R.id.tv_owner)
    TextView tv_owner;

    @BindView(R.id.tv_phone_number)
    TextView tv_phone_number;

    @BindView(R.id.tv_serial_number)
    TextView tv_serial_number;

    @BindView(R.id.tv_shipping_address1)
    TextView tv_shipping_address1;

    @BindView(R.id.tv_shipping_address2)
    TextView tv_shipping_address2;

    @BindView(R.id.tv_switcher_name)
    TextView tv_switcher_name;

    public static DeliveryFragment newInstance(String str) {
        DeliveryFragment deliveryFragment = new DeliveryFragment();
        Bundle bundle = new Bundle();
        bundle.putString("CONNECTED_MAC_ADDRESS", str);
        deliveryFragment.setArguments(bundle);
        return deliveryFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_delivery, viewGroup, false);
        ButterKnife.bind(this, viewInflate);
        Bundle arguments = getArguments();
        IODevice device = IODeviceHandler.getInstance().getDevice(arguments != null ? arguments.getString("CONNECTED_MAC_ADDRESS") : "");
        if (device == null) {
            IOUtil.showToast(IOUtil.getStringResource(R.string.not_found_switcher));
            getActivity().finish();
            return null;
        }
        User currentUserFromDB = UserStateManager.getInstance().getCurrentUserFromDB();
        if (currentUserFromDB == null) {
            IOUtil.showToast(IOUtil.getStringResource(R.string.not_found_user));
            getActivity().finish();
            return null;
        }
        DeliveryPresenter deliveryPresenter = new DeliveryPresenter(this);
        this.presenter = deliveryPresenter;
        deliveryPresenter.initialize(device, currentUserFromDB);
        return viewInflate;
    }

    @Override // kr.switcher.switcherm.ui.switcherInfo.views.DeliveryView
    public void trackDeliveryForGA() {
        IOLog.activity(IOUtil.getStringResource(R.string.screen_title_5_0_1));
    }

    @Override // kr.switcher.switcherm.ui.switcherInfo.views.DeliveryView
    public void setSwitcherImage(Drawable drawable) {
        this.iv_switcher_icon.setImageDrawable(drawable);
    }

    @Override // kr.switcher.switcherm.ui.switcherInfo.views.DeliveryView
    public void setName(String str) {
        this.tv_owner.setText(str);
    }

    @Override // kr.switcher.switcherm.ui.switcherInfo.views.DeliveryView
    public void setSwitcherName(String str) {
        this.tv_switcher_name.setText(str);
    }

    @Override // kr.switcher.switcherm.ui.switcherInfo.views.DeliveryView
    public void setPKey(String str) {
        this.tv_serial_number.setText(str);
    }

    @Override // kr.switcher.switcherm.ui.switcherInfo.views.DeliveryView
    public void setPhoneNumber(String str) {
        this.tv_phone_number.setText(str);
    }

    @Override // kr.switcher.switcherm.ui.switcherInfo.views.DeliveryView
    public void setAddress1(String str) {
        this.tv_shipping_address1.setText(str);
    }

    @Override // kr.switcher.switcherm.ui.switcherInfo.views.DeliveryView
    public void setAddress2(String str) {
        this.tv_shipping_address2.setText(str);
    }

    @OnClick({R.id.btn_answer_kakaotalk})
    public void onAnswerKakaotalkButtonClicked() {
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(IOUri.URI_KAKAO_YELLOID)));
    }
}
