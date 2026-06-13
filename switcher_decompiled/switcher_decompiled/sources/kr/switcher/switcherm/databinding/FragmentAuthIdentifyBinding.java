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
import kr.switcher.switcherm.viewmodel.AuthIdentifyFragmentViewModel;

/* JADX INFO: loaded from: classes2.dex */
public abstract class FragmentAuthIdentifyBinding extends ViewDataBinding {
    public final EditText etAuthNumber;
    public final LinearLayout llPhoneNumber;

    @Bindable
    protected AuthIdentifyFragmentViewModel mViewModel;
    public final RelativeLayout rlInfo;
    public final LinearLayout rlInfo1;
    public final LinearLayout rlInfo2;
    public final TextView tvInfoPhoneNumber;
    public final TextView tvSecond;

    public abstract void setViewModel(AuthIdentifyFragmentViewModel authIdentifyFragmentViewModel);

    protected FragmentAuthIdentifyBinding(Object obj, View view, int i, EditText editText, LinearLayout linearLayout, RelativeLayout relativeLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.etAuthNumber = editText;
        this.llPhoneNumber = linearLayout;
        this.rlInfo = relativeLayout;
        this.rlInfo1 = linearLayout2;
        this.rlInfo2 = linearLayout3;
        this.tvInfoPhoneNumber = textView;
        this.tvSecond = textView2;
    }

    public AuthIdentifyFragmentViewModel getViewModel() {
        return this.mViewModel;
    }

    public static FragmentAuthIdentifyBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentAuthIdentifyBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentAuthIdentifyBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_auth_identify, viewGroup, z, obj);
    }

    public static FragmentAuthIdentifyBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentAuthIdentifyBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentAuthIdentifyBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_auth_identify, null, false, obj);
    }

    public static FragmentAuthIdentifyBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentAuthIdentifyBinding bind(View view, Object obj) {
        return (FragmentAuthIdentifyBinding) bind(obj, view, R.layout.fragment_auth_identify);
    }
}
