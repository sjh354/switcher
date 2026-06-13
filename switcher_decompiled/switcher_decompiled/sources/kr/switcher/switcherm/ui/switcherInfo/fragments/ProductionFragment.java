package kr.switcher.switcherm.ui.switcherInfo.fragments;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.google.gson.Gson;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.IOUri;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.ui.dialog.IODialogController;
import kr.switcher.switcherm.ui.switcherInfo.interactors.ChangeModelTypeInteractor;
import kr.switcher.switcherm.ui.switcherInfo.interactors.FindRequestInteractor;
import kr.switcher.switcherm.ui.switcherInfo.presenters.ProductionPresenter;
import kr.switcher.switcherm.ui.switcherInfo.views.ProductionView;
import kr.switcher.switcherm.user.Preparing;
import kr.switcher.switcherm.user.User;
import kr.switcher.switcherm.user.UserStateManager;

/* JADX INFO: loaded from: classes2.dex */
public class ProductionFragment extends Fragment implements ProductionView {
    private static final String PARM_PREPARING = "PREPARING";
    private static final String TAG = "ProductionFragment";

    @BindView(R.id.iv_switcher_icon)
    ImageView iv_switcher_icon;

    @BindView(R.id.pb_changing)
    ProgressBar pb_changing;
    private ProductionPresenter presenter;

    @BindView(R.id.tv_owner)
    TextView tv_owner;

    @BindView(R.id.tv_phone_number)
    TextView tv_phone_number;

    @BindView(R.id.tv_shipping_address1)
    TextView tv_shipping_address1;

    @BindView(R.id.tv_shipping_address2)
    TextView tv_shipping_address2;

    @BindView(R.id.tv_shipping_date)
    TextView tv_shipping_date;

    @BindView(R.id.tv_switcher_name)
    TextView tv_switcher_name;

    @BindView(R.id.tv_switcher_type)
    TextView tv_switcher_type;

    public static ProductionFragment newInstance(Preparing preparing) {
        ProductionFragment productionFragment = new ProductionFragment();
        Bundle bundle = new Bundle();
        bundle.putString(PARM_PREPARING, new Gson().toJson(preparing));
        productionFragment.setArguments(bundle);
        return productionFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_production, viewGroup, false);
        ButterKnife.bind(this, viewInflate);
        Bundle arguments = getArguments();
        Preparing preparing = arguments != null ? (Preparing) new Gson().fromJson(arguments.getString(PARM_PREPARING), Preparing.class) : null;
        User currentUserFromDB = UserStateManager.getInstance().getCurrentUserFromDB();
        if (currentUserFromDB == null || preparing == null) {
            IOUtil.showToast(IOUtil.getStringResource(R.string.not_found_user));
            getActivity().finish();
            return null;
        }
        ProductionPresenter productionPresenter = new ProductionPresenter(this, currentUserFromDB, new FindRequestInteractor(), new ChangeModelTypeInteractor());
        this.presenter = productionPresenter;
        productionPresenter.onCreateView(preparing);
        return viewInflate;
    }

    @Override // kr.switcher.switcherm.ui.switcherInfo.views.ProductionView
    public void trackProductionForGA() {
        IOLog.activity(IOUtil.getStringResource(R.string.screen_title_5_0_0));
    }

    @Override // kr.switcher.switcherm.ui.switcherInfo.views.ProductionView
    public void trackDisableForGA() {
        IOLog.activity(IOUtil.getStringResource(R.string.screen_title_5_0_0_1));
    }

    @Override // kr.switcher.switcherm.ui.switcherInfo.views.ProductionView
    public void setChangeButtonName(String str) {
        this.tv_switcher_type.setText(str);
    }

    @Override // kr.switcher.switcherm.ui.switcherInfo.views.ProductionView
    public void enableChangeButton() {
        this.tv_switcher_type.setTextColor(IOUtil.getColorResource(R.color.periwinkle));
        this.tv_switcher_type.setBackground(IOUtil.makeDrawable(R.drawable.shape_periwinkle));
    }

    @Override // kr.switcher.switcherm.ui.switcherInfo.views.ProductionView
    public void disableChangeButton() {
        this.tv_switcher_type.setTextColor(IOUtil.getColorResource(R.color.cool_grey));
        this.tv_switcher_type.setBackground(IOUtil.makeDrawable(R.drawable.shape_cool_grey));
    }

    @Override // kr.switcher.switcherm.ui.switcherInfo.views.ProductionView
    public void setSwitcherImage(Drawable drawable) {
        this.iv_switcher_icon.setImageDrawable(drawable);
    }

    @Override // kr.switcher.switcherm.ui.switcherInfo.views.ProductionView
    public void setSwitcherType(String str) {
        this.tv_switcher_name.setText(str);
    }

    @Override // kr.switcher.switcherm.ui.switcherInfo.views.ProductionView
    public void showChangeDialog(String str) {
        IODialogController.showChangeDialog(getContext(), str, this.presenter);
    }

    @Override // kr.switcher.switcherm.ui.switcherInfo.views.ProductionView
    public void showProgressbar() {
        this.pb_changing.setVisibility(0);
    }

    @Override // kr.switcher.switcherm.ui.switcherInfo.views.ProductionView
    public void hideProgressbar() {
        this.pb_changing.setVisibility(8);
    }

    @Override // kr.switcher.switcherm.ui.switcherInfo.views.ProductionView
    public void showErrorMessage(String str) {
        IOUtil.showToast(str);
    }

    @Override // kr.switcher.switcherm.ui.switcherInfo.views.ProductionView
    public void setName(String str) {
        this.tv_owner.setText(str);
    }

    @Override // kr.switcher.switcherm.ui.switcherInfo.views.ProductionView
    public void setPhoneNumber(String str) {
        this.tv_phone_number.setText(str);
    }

    @Override // kr.switcher.switcherm.ui.switcherInfo.views.ProductionView
    public void setAddress1(String str) {
        this.tv_shipping_address1.setText(str);
    }

    @Override // kr.switcher.switcherm.ui.switcherInfo.views.ProductionView
    public void setAddress2(String str) {
        this.tv_shipping_address2.setText(str);
    }

    @Override // kr.switcher.switcherm.ui.switcherInfo.views.ProductionView
    public void setDeliveryAt(String str) {
        this.tv_shipping_date.setText(str);
    }

    @OnClick({R.id.tv_switcher_type})
    public void onChangeButtonClicked() {
        this.presenter.change();
    }

    @OnClick({R.id.btn_answer_kakaotalk})
    public void onAnswerKakaotalkButtonClicked() {
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(IOUri.URI_KAKAO_YELLOID)));
    }
}
