package kr.switcher.switcherm.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.viewmodel.SwitcherInfoActivityViewModel;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ActivitySwitcherInfoBinding extends ViewDataBinding {
    public final RelativeLayout container;

    @Bindable
    protected SwitcherInfoActivityViewModel mViewModel;
    public final RelativeLayout rlRoot;

    public abstract void setViewModel(SwitcherInfoActivityViewModel switcherInfoActivityViewModel);

    protected ActivitySwitcherInfoBinding(Object obj, View view, int i, RelativeLayout relativeLayout, RelativeLayout relativeLayout2) {
        super(obj, view, i);
        this.container = relativeLayout;
        this.rlRoot = relativeLayout2;
    }

    public SwitcherInfoActivityViewModel getViewModel() {
        return this.mViewModel;
    }

    public static ActivitySwitcherInfoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivitySwitcherInfoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivitySwitcherInfoBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_switcher_info, viewGroup, z, obj);
    }

    public static ActivitySwitcherInfoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivitySwitcherInfoBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivitySwitcherInfoBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_switcher_info, null, false, obj);
    }

    public static ActivitySwitcherInfoBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivitySwitcherInfoBinding bind(View view, Object obj) {
        return (ActivitySwitcherInfoBinding) bind(obj, view, R.layout.activity_switcher_info);
    }
}
