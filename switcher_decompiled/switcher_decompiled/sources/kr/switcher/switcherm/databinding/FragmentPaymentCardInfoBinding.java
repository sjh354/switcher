package kr.switcher.switcherm.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.viewmodel.PaymentCardInfoFragmentViewModel;

/* JADX INFO: loaded from: classes2.dex */
public abstract class FragmentPaymentCardInfoBinding extends ViewDataBinding {
    public final LinearLayout linRoot;

    @Bindable
    protected PaymentCardInfoFragmentViewModel mViewModel;
    public final TextView tvCardDiscountInfo;
    public final TextView tvCardNumber1;
    public final TextView tvCardNumber2;
    public final TextView tvCardNumber3;
    public final TextView tvCardNumber4;
    public final TextView tvCardUsingInfo;

    public abstract void setViewModel(PaymentCardInfoFragmentViewModel paymentCardInfoFragmentViewModel);

    protected FragmentPaymentCardInfoBinding(Object obj, View view, int i, LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6) {
        super(obj, view, i);
        this.linRoot = linearLayout;
        this.tvCardDiscountInfo = textView;
        this.tvCardNumber1 = textView2;
        this.tvCardNumber2 = textView3;
        this.tvCardNumber3 = textView4;
        this.tvCardNumber4 = textView5;
        this.tvCardUsingInfo = textView6;
    }

    public PaymentCardInfoFragmentViewModel getViewModel() {
        return this.mViewModel;
    }

    public static FragmentPaymentCardInfoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentPaymentCardInfoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentPaymentCardInfoBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_payment_card_info, viewGroup, z, obj);
    }

    public static FragmentPaymentCardInfoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentPaymentCardInfoBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentPaymentCardInfoBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_payment_card_info, null, false, obj);
    }

    public static FragmentPaymentCardInfoBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentPaymentCardInfoBinding bind(View view, Object obj) {
        return (FragmentPaymentCardInfoBinding) bind(obj, view, R.layout.fragment_payment_card_info);
    }
}
