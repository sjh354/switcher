package kr.switcher.switcherm.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.viewmodel.SettingActivityViewModel;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ActivitySettingBinding extends ViewDataBinding {
    public final RelativeLayout container;

    @Bindable
    protected SettingActivityViewModel mViewModel;
    public final RelativeLayout rlRoot;

    public abstract void setViewModel(SettingActivityViewModel settingActivityViewModel);

    protected ActivitySettingBinding(Object obj, View view, int i, RelativeLayout relativeLayout, RelativeLayout relativeLayout2) {
        super(obj, view, i);
        this.container = relativeLayout;
        this.rlRoot = relativeLayout2;
    }

    public SettingActivityViewModel getViewModel() {
        return this.mViewModel;
    }

    public static ActivitySettingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivitySettingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivitySettingBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_setting, viewGroup, z, obj);
    }

    public static ActivitySettingBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivitySettingBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivitySettingBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_setting, null, false, obj);
    }

    public static ActivitySettingBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivitySettingBinding bind(View view, Object obj) {
        return (ActivitySettingBinding) bind(obj, view, R.layout.activity_setting);
    }
}
