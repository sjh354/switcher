package kr.switcher.switcherm.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.viewmodel.PaymentCardChangeFragmentViewModel;

/* JADX INFO: loaded from: classes2.dex */
public abstract class FragmentPaymentCardChangeBinding extends ViewDataBinding {
    public final EditText etCardNumber1;
    public final EditText etCardNumber2;
    public final EditText etCardNumber3;
    public final EditText etCardNumber4;

    @Bindable
    protected PaymentCardChangeFragmentViewModel mViewModel;
    public final RelativeLayout rlRoot;
    public final Spinner spCompanies;
    public final Spinner spValidityMonth;
    public final Spinner spValidityYear;
    public final TextView tvAgreeText1;
    public final TextView tvAgreeText2;

    public abstract void setViewModel(PaymentCardChangeFragmentViewModel paymentCardChangeFragmentViewModel);

    protected FragmentPaymentCardChangeBinding(Object obj, View view, int i, EditText editText, EditText editText2, EditText editText3, EditText editText4, RelativeLayout relativeLayout, Spinner spinner, Spinner spinner2, Spinner spinner3, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.etCardNumber1 = editText;
        this.etCardNumber2 = editText2;
        this.etCardNumber3 = editText3;
        this.etCardNumber4 = editText4;
        this.rlRoot = relativeLayout;
        this.spCompanies = spinner;
        this.spValidityMonth = spinner2;
        this.spValidityYear = spinner3;
        this.tvAgreeText1 = textView;
        this.tvAgreeText2 = textView2;
    }

    public PaymentCardChangeFragmentViewModel getViewModel() {
        return this.mViewModel;
    }

    public static FragmentPaymentCardChangeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentPaymentCardChangeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentPaymentCardChangeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_payment_card_change, viewGroup, z, obj);
    }

    public static FragmentPaymentCardChangeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentPaymentCardChangeBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentPaymentCardChangeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_payment_card_change, null, false, obj);
    }

    public static FragmentPaymentCardChangeBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentPaymentCardChangeBinding bind(View view, Object obj) {
        return (FragmentPaymentCardChangeBinding) bind(obj, view, R.layout.fragment_payment_card_change);
    }
}
