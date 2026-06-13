package kr.switcher.switcherm.ui.switcherInfo.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import java.util.List;
import kr.switcher.device.switcher.Switcher;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.IOUri;
import kr.switcher.switcherm.common.ga.GALogger;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.device.switcher.handler.SwitcherHandler;
import kr.switcher.switcherm.ui.dialog.ConfirmCallback;
import kr.switcher.switcherm.ui.dialog.IODialogController;
import kr.switcher.switcherm.ui.switcherInfo.adapter.PlanItem;
import kr.switcher.switcherm.ui.switcherInfo.presenters.RentalPlanPresenter;
import kr.switcher.switcherm.ui.switcherInfo.views.RentalPlanView;

/* JADX INFO: loaded from: classes2.dex */
public class RentalPlanFragment extends Fragment implements RentalPlanView, ConfirmCallback {
    private static final String TAG = "RentalPlanFragment";
    private RentalPlanPresenter presenter;
    private Switcher switcher;

    @BindView(R.id.tv_description1)
    TextView tv_description1;

    @BindView(R.id.tv_description2)
    TextView tv_description2;

    @BindView(R.id.tv_description3)
    TextView tv_description3;

    @BindView(R.id.tv_description4)
    TextView tv_description4;

    @BindView(R.id.tv_mine1)
    TextView tv_mine1;

    @BindView(R.id.tv_mine2)
    TextView tv_mine2;

    @BindView(R.id.tv_mine3)
    TextView tv_mine3;

    @BindView(R.id.tv_mine4)
    TextView tv_mine4;

    @BindView(R.id.tv_price1)
    TextView tv_price1;

    @BindView(R.id.tv_price2)
    TextView tv_price2;

    @BindView(R.id.tv_price3)
    TextView tv_price3;

    @BindView(R.id.tv_price4)
    TextView tv_price4;

    @BindView(R.id.tv_purchase_price)
    TextView tv_purchase_price;

    @BindView(R.id.tv_title1)
    TextView tv_title1;

    @BindView(R.id.tv_title2)
    TextView tv_title2;

    @BindView(R.id.tv_title3)
    TextView tv_title3;

    @BindView(R.id.tv_title4)
    TextView tv_title4;

    public static RentalPlanFragment newInstance(String str) {
        RentalPlanFragment rentalPlanFragment = new RentalPlanFragment();
        Bundle bundle = new Bundle();
        bundle.putString("CONNECTED_MAC_ADDRESS", str);
        rentalPlanFragment.setArguments(bundle);
        return rentalPlanFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_rental_plan, viewGroup, false);
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
        this.presenter = new RentalPlanPresenter(this);
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.presenter.onResume(this.switcher.getDeviceOption().getPaymentInfo().getPaymentMethod(), this.switcher.getProductId());
    }

    @Override // kr.switcher.switcherm.ui.switcherInfo.views.RentalPlanView
    public void trackRentalPlanForGA() {
        IOLog.activity(IOUtil.getStringResource(R.string.screen_title_5_0_2_1_0));
    }

    @Override // kr.switcher.switcherm.ui.switcherInfo.views.RentalPlanView
    public void setPlanListView(List<PlanItem> list) {
        this.tv_title1.setText("매월 플랜");
        this.tv_title2.setText("1년 플랜");
        this.tv_title3.setText("2년 플랜");
        this.tv_title4.setText("3년 플랜");
        this.tv_mine1.setVisibility(list.get(0).isMain() ? 0 : 4);
        this.tv_mine2.setVisibility(list.get(1).isMain() ? 0 : 4);
        this.tv_mine3.setVisibility(list.get(2).isMain() ? 0 : 4);
        this.tv_mine4.setVisibility(list.get(3).isMain() ? 0 : 4);
        this.tv_price1.setText("매달 1,800원 결제");
        this.tv_price2.setText("1년 마다 17,000원 결제");
        this.tv_price3.setText("2년 마다 28,000원 결제");
        this.tv_price4.setText("3년 마다 35,500원 결제");
        this.tv_description1.setText("1,800원/월");
        this.tv_description2.setText("1,430원/월");
        this.tv_description3.setText("1,170원/월");
        this.tv_description4.setText("990원/월");
    }

    @Override // kr.switcher.switcherm.ui.switcherInfo.views.RentalPlanView
    public void setPurchasePrice(String str) {
        this.tv_purchase_price.setText(str);
    }

    @Override // kr.switcher.switcherm.ui.switcherInfo.views.RentalPlanView
    public void showMessage(String str) {
        IOUtil.showToast(str);
    }

    @Override // kr.switcher.switcherm.ui.switcherInfo.views.RentalPlanView
    public void showConfirmDialog(String str, String str2, String str3, String str4) {
        IODialogController.showPayDetailConfirmDialog(getContext(), str, str2, str3, str4, this);
    }

    @OnClick({R.id.btn_move_kakao})
    public void onMoveKakaotalkButtonClicked() {
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(IOUri.URI_KAKAO_YELLOID)));
        IOLog.event(GALogger.CATEGORY_SALES, GALogger.ACTION_MOVE_KAKAO_FOR_PAYMENT_PLAN_CHANGE);
    }

    @OnClick({R.id.btn_buy_now})
    public void onBuyNowButtonClicked() {
        this.presenter.onBuyNowButtonClicked(this.switcher.getProductId());
    }

    @Override // kr.switcher.switcherm.ui.dialog.ConfirmCallback
    public void onConfirmResult(boolean z) {
        this.presenter.onConfirmResult(z);
    }
}
