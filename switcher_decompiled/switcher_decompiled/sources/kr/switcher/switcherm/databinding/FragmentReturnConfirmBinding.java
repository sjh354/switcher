package kr.switcher.switcherm.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.viewmodel.ReturnConfirmFragmentViewModel;

/* JADX INFO: loaded from: classes2.dex */
public abstract class FragmentReturnConfirmBinding extends ViewDataBinding {
    public final ImageView ivCalendar;

    @Bindable
    protected ReturnConfirmFragmentViewModel mViewModel;
    public final ProgressBar pbSearching;
    public final RelativeLayout rlMiddleMessage;
    public final RelativeLayout rlRoot;
    public final TextView tvReturnConfirmMessage1;
    public final TextView tvReturnConfirmMessage2;
    public final TextView tvReturnConfirmMessage3;
    public final TextView tvReturnConfirmMessage4;
    public final TextView tvReturnConfirmMessage5;

    public abstract void setViewModel(ReturnConfirmFragmentViewModel returnConfirmFragmentViewModel);

    protected FragmentReturnConfirmBinding(Object obj, View view, int i, ImageView imageView, ProgressBar progressBar, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        super(obj, view, i);
        this.ivCalendar = imageView;
        this.pbSearching = progressBar;
        this.rlMiddleMessage = relativeLayout;
        this.rlRoot = relativeLayout2;
        this.tvReturnConfirmMessage1 = textView;
        this.tvReturnConfirmMessage2 = textView2;
        this.tvReturnConfirmMessage3 = textView3;
        this.tvReturnConfirmMessage4 = textView4;
        this.tvReturnConfirmMessage5 = textView5;
    }

    public ReturnConfirmFragmentViewModel getViewModel() {
        return this.mViewModel;
    }

    public static FragmentReturnConfirmBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentReturnConfirmBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentReturnConfirmBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_return_confirm, viewGroup, z, obj);
    }

    public static FragmentReturnConfirmBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentReturnConfirmBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentReturnConfirmBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_return_confirm, null, false, obj);
    }

    public static FragmentReturnConfirmBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentReturnConfirmBinding bind(View view, Object obj) {
        return (FragmentReturnConfirmBinding) bind(obj, view, R.layout.fragment_return_confirm);
    }
}
