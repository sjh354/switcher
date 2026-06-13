package kr.switcher.switcherm.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.viewmodel.ReturnInfoFragmentViewModel;

/* JADX INFO: loaded from: classes2.dex */
public abstract class FragmentReturnInfoBinding extends ViewDataBinding {
    public final LinearLayout linRoot;

    @Bindable
    protected ReturnInfoFragmentViewModel mViewModel;
    public final RelativeLayout rlBoxInfo;
    public final TextView tvReturnBoxInfo1;
    public final TextView tvReturnBoxInfo2;
    public final TextView tvReturnBoxInfo3;

    public abstract void setViewModel(ReturnInfoFragmentViewModel returnInfoFragmentViewModel);

    protected FragmentReturnInfoBinding(Object obj, View view, int i, LinearLayout linearLayout, RelativeLayout relativeLayout, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.linRoot = linearLayout;
        this.rlBoxInfo = relativeLayout;
        this.tvReturnBoxInfo1 = textView;
        this.tvReturnBoxInfo2 = textView2;
        this.tvReturnBoxInfo3 = textView3;
    }

    public ReturnInfoFragmentViewModel getViewModel() {
        return this.mViewModel;
    }

    public static FragmentReturnInfoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentReturnInfoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentReturnInfoBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_return_info, viewGroup, z, obj);
    }

    public static FragmentReturnInfoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentReturnInfoBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentReturnInfoBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_return_info, null, false, obj);
    }

    public static FragmentReturnInfoBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentReturnInfoBinding bind(View view, Object obj) {
        return (FragmentReturnInfoBinding) bind(obj, view, R.layout.fragment_return_info);
    }
}
