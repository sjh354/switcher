package kr.switcher.switcherm.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.viewmodel.AuthPhoneNumberFragmentViewModel;

/* JADX INFO: loaded from: classes2.dex */
public abstract class FragmentAuthPhoneNumberBinding extends ViewDataBinding {
    public final EditText etPhoneNumber;
    public final LinearLayout llPhoneNumber;

    @Bindable
    protected AuthPhoneNumberFragmentViewModel mViewModel;
    public final RelativeLayout rlInfo;
    public final TextView tvInfo1;
    public final TextView tvInfo2;
    public final TextView tvInfo3;

    public abstract void setViewModel(AuthPhoneNumberFragmentViewModel authPhoneNumberFragmentViewModel);

    protected FragmentAuthPhoneNumberBinding(Object obj, View view, int i, EditText editText, LinearLayout linearLayout, RelativeLayout relativeLayout, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.etPhoneNumber = editText;
        this.llPhoneNumber = linearLayout;
        this.rlInfo = relativeLayout;
        this.tvInfo1 = textView;
        this.tvInfo2 = textView2;
        this.tvInfo3 = textView3;
    }

    public AuthPhoneNumberFragmentViewModel getViewModel() {
        return this.mViewModel;
    }

    public static FragmentAuthPhoneNumberBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentAuthPhoneNumberBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentAuthPhoneNumberBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_auth_phone_number, viewGroup, z, obj);
    }

    public static FragmentAuthPhoneNumberBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentAuthPhoneNumberBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentAuthPhoneNumberBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_auth_phone_number, null, false, obj);
    }

    public static FragmentAuthPhoneNumberBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentAuthPhoneNumberBinding bind(View view, Object obj) {
        return (FragmentAuthPhoneNumberBinding) bind(obj, view, R.layout.fragment_auth_phone_number);
    }
}
