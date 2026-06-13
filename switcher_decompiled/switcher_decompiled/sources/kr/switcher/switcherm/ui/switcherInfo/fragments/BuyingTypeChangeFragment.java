package kr.switcher.switcherm.ui.switcherInfo.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import kr.switcher.device.switcher.Switcher;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.IOUri;
import kr.switcher.switcherm.common.ga.GALogger;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.device.switcher.handler.SwitcherHandler;
import kr.switcher.switcherm.ui.switcherInfo.presenters.BuyingTypeChangePresenter;
import kr.switcher.switcherm.ui.switcherInfo.views.BuyingTypeChangeView;

/* JADX INFO: loaded from: classes2.dex */
public class BuyingTypeChangeFragment extends Fragment implements BuyingTypeChangeView {

    @BindView(R.id.cb_buying_type_lease)
    CheckBox cb_buying_type_lease;

    @BindView(R.id.cb_buying_type_wholesale)
    CheckBox cb_buying_type_wholesale;
    private BuyingTypeChangePresenter presenter;
    private Switcher switcher;

    @BindView(R.id.tv_my_buying_type_lease)
    TextView tv_my_buying_type_lease;

    @BindView(R.id.tv_my_buying_type_wholesale)
    TextView tv_my_buying_type_wholesale;

    @Override // kr.switcher.switcherm.ui.switcherInfo.views.BuyingTypeChangeView
    public void trackPlanChangeForGA() {
    }

    public static BuyingTypeChangeFragment newInstance(String str) {
        BuyingTypeChangeFragment buyingTypeChangeFragment = new BuyingTypeChangeFragment();
        Bundle bundle = new Bundle();
        bundle.putString("CONNECTED_MAC_ADDRESS", str);
        buyingTypeChangeFragment.setArguments(bundle);
        return buyingTypeChangeFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_buying_type_change, viewGroup, false);
        ButterKnife.bind(this, viewInflate);
        Bundle arguments = getArguments();
        if (arguments != null) {
            Switcher switcher = SwitcherHandler.getInstance().getSwitcher(arguments.getString("CONNECTED_MAC_ADDRESS"));
            this.switcher = switcher;
            if (switcher == null) {
                IOUtil.showToast(IOUtil.getStringResource(R.string.etc_error));
                getActivity().finish();
                return null;
            }
        }
        BuyingTypeChangePresenter buyingTypeChangePresenter = new BuyingTypeChangePresenter(this);
        this.presenter = buyingTypeChangePresenter;
        buyingTypeChangePresenter.onCreateView(this.switcher.getDeviceOption().getPaymentInfo().getPaymentMethod());
        return viewInflate;
    }

    @Override // kr.switcher.switcherm.ui.switcherInfo.views.BuyingTypeChangeView
    public void checkLease() {
        this.cb_buying_type_lease.setChecked(true);
    }

    @Override // kr.switcher.switcherm.ui.switcherInfo.views.BuyingTypeChangeView
    public void unCheckLease() {
        this.cb_buying_type_lease.setChecked(false);
    }

    @Override // kr.switcher.switcherm.ui.switcherInfo.views.BuyingTypeChangeView
    public void checkWholesale() {
        this.cb_buying_type_wholesale.setChecked(true);
    }

    @Override // kr.switcher.switcherm.ui.switcherInfo.views.BuyingTypeChangeView
    public void unCheckWholesale() {
        this.cb_buying_type_wholesale.setChecked(false);
    }

    @OnClick({R.id.cb_buying_type_lease})
    public void leaseCheckboxChecked() {
        this.presenter.leaseCheckboxChecked();
    }

    @OnClick({R.id.cb_buying_type_wholesale})
    public void wolesaleCheckboxChecked() {
        this.presenter.wholesaleCheckboxChecked();
    }

    @Override // kr.switcher.switcherm.ui.switcherInfo.views.BuyingTypeChangeView
    public void showMessage(String str) {
        IOUtil.showToast(str);
    }

    @OnClick({R.id.btn_move_kakao})
    public void onMoveKakaotalkButtonClicked() {
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(IOUri.URI_KAKAO_YELLOID)));
        IOLog.event(GALogger.CATEGORY_SALES, GALogger.ACTION_MOVE_KAKAO_FOR_PAYMENT_PLAN_CHANGE);
    }
}
