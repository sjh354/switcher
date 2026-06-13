package kr.switcher.switcherm.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.viewmodel.AuthActivityViewModel;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ActivityAuthBinding extends ViewDataBinding {
    public final RelativeLayout container;

    @Bindable
    protected AuthActivityViewModel mViewModel;
    public final ProgressBar pbSearching;
    public final RelativeLayout rlRoot;
    public final TextView tvStartText;

    public abstract void setViewModel(AuthActivityViewModel authActivityViewModel);

    protected ActivityAuthBinding(Object obj, View view, int i, RelativeLayout relativeLayout, ProgressBar progressBar, RelativeLayout relativeLayout2, TextView textView) {
        super(obj, view, i);
        this.container = relativeLayout;
        this.pbSearching = progressBar;
        this.rlRoot = relativeLayout2;
        this.tvStartText = textView;
    }

    public AuthActivityViewModel getViewModel() {
        return this.mViewModel;
    }

    public static ActivityAuthBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityAuthBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityAuthBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_auth, viewGroup, z, obj);
    }

    public static ActivityAuthBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityAuthBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityAuthBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_auth, null, false, obj);
    }

    public static ActivityAuthBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityAuthBinding bind(View view, Object obj) {
        return (ActivityAuthBinding) bind(obj, view, R.layout.activity_auth);
    }
}
