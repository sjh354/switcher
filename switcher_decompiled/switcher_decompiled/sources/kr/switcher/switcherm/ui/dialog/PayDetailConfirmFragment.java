package kr.switcher.switcherm.ui.dialog;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.ui.switcherInfo.ChangeWarningRentalToBuyingActivity;

/* JADX INFO: loaded from: classes2.dex */
public class PayDetailConfirmFragment extends DialogFragment {
    private static final String ARG_DEVICE_PRICE = "DEVICE_PRICE";
    private static final String ARG_EXCHANGING_NUMBER = "EXCHANGING_NUMBER";
    private static final String ARG_PAYMENT_PRICE = "PAYMENT_PRICE";
    private static final String ARG_SALE_PRICE = "SALE_PRICE";
    private static ConfirmCallback callback;

    @BindView(R.id.btn_notice)
    TextView btn_notice;

    @BindView(R.id.tv_device_price)
    TextView tv_device_price;

    @BindView(R.id.tv_exchanging_number)
    TextView tv_exchanging_number;

    @BindView(R.id.tv_payment_price)
    TextView tv_payment_price;

    @BindView(R.id.tv_sale_price)
    TextView tv_sale_price;

    public void trackChangeConfirmForGA() {
    }

    public static PayDetailConfirmFragment newInstance(String str, String str2, String str3, String str4, ConfirmCallback confirmCallback) {
        PayDetailConfirmFragment payDetailConfirmFragment = new PayDetailConfirmFragment();
        callback = confirmCallback;
        Bundle bundle = new Bundle();
        bundle.putString(ARG_DEVICE_PRICE, str);
        bundle.putString(ARG_SALE_PRICE, str2);
        bundle.putString(ARG_EXCHANGING_NUMBER, str3);
        bundle.putString(ARG_PAYMENT_PRICE, str4);
        payDetailConfirmFragment.setArguments(bundle);
        return payDetailConfirmFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreate(bundle);
        getDialog().getWindow().requestFeature(1);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        View viewInflate = layoutInflater.inflate(R.layout.fragment_dialog_pay_detail_confirm, viewGroup, false);
        ButterKnife.bind(this, viewInflate);
        this.btn_notice.setText(Html.fromHtml("<u>> 전환 시 유의사항 및 할인금액 계산법</u> "));
        if (getArguments() != null) {
            viewData(getArguments().getString(ARG_DEVICE_PRICE), getArguments().getString(ARG_SALE_PRICE), getArguments().getString(ARG_EXCHANGING_NUMBER), getArguments().getString(ARG_PAYMENT_PRICE));
        }
        trackChangeConfirmForGA();
        return viewInflate;
    }

    private void viewData(String str, String str2, String str3, String str4) {
        IOUtil.underlineTextView(this.tv_device_price, str);
        IOUtil.underlineTextView(this.tv_sale_price, str2);
        IOUtil.underlineTextView(this.tv_exchanging_number, str3);
        this.tv_payment_price.setText(str4);
    }

    @OnClick({R.id.btn_change})
    public void onChangeButtonClicked() {
        ConfirmCallback confirmCallback = callback;
        if (confirmCallback != null) {
            confirmCallback.onConfirmResult(true);
        }
    }

    @OnClick({R.id.btn_cancel})
    public void onCancelButtonClicked() {
        dismiss();
    }

    @OnClick({R.id.btn_notice})
    public void onNoticeButtonClicked() {
        startActivity(new Intent(getContext(), (Class<?>) ChangeWarningRentalToBuyingActivity.class));
    }

    @OnClick({R.id.tv_device_price})
    public void onDevicePriceTextClicked() {
        Intent intent = new Intent(getContext(), (Class<?>) ChangeWarningRentalToBuyingActivity.class);
        intent.putExtra(ChangeWarningRentalToBuyingActivity.PARM_PAGE, 1);
        startActivity(intent);
    }

    @OnClick({R.id.tv_sale_price})
    public void onSalePriceTextClicked() {
        Intent intent = new Intent(getContext(), (Class<?>) ChangeWarningRentalToBuyingActivity.class);
        intent.putExtra(ChangeWarningRentalToBuyingActivity.PARM_PAGE, 2);
        startActivity(intent);
    }

    @OnClick({R.id.tv_exchanging_number})
    public void onExchangingNumberTextClicked() {
        Intent intent = new Intent(getContext(), (Class<?>) ChangeWarningRentalToBuyingActivity.class);
        intent.putExtra(ChangeWarningRentalToBuyingActivity.PARM_PAGE, 3);
        startActivity(intent);
    }
}
