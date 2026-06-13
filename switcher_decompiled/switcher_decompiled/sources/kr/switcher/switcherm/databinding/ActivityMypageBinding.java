package kr.switcher.switcherm.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.viewmodel.MypageActivityViewModel;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ActivityMypageBinding extends ViewDataBinding {
    public final RelativeLayout container;

    @Bindable
    protected MypageActivityViewModel mViewModel;
    public final RelativeLayout rlRoot;

    public abstract void setViewModel(MypageActivityViewModel mypageActivityViewModel);

    protected ActivityMypageBinding(Object obj, View view, int i, RelativeLayout relativeLayout, RelativeLayout relativeLayout2) {
        super(obj, view, i);
        this.container = relativeLayout;
        this.rlRoot = relativeLayout2;
    }

    public MypageActivityViewModel getViewModel() {
        return this.mViewModel;
    }

    public static ActivityMypageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityMypageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityMypageBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_mypage, viewGroup, z, obj);
    }

    public static ActivityMypageBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityMypageBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityMypageBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_mypage, null, false, obj);
    }

    public static ActivityMypageBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityMypageBinding bind(View view, Object obj) {
        return (ActivityMypageBinding) bind(obj, view, R.layout.activity_mypage);
    }
}
