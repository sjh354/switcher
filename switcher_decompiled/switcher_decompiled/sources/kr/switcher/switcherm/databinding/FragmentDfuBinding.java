package kr.switcher.switcherm.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.github.lzyzsd.circleprogress.DonutProgress;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.viewmodel.DFUFragmentViewModel;

/* JADX INFO: loaded from: classes2.dex */
public abstract class FragmentDfuBinding extends ViewDataBinding {
    public final TextView btnInputShareCode;
    public final DonutProgress dpProgress;

    @Bindable
    protected DFUFragmentViewModel mViewModel;
    public final LinearLayout rlRoot;

    public abstract void setViewModel(DFUFragmentViewModel dFUFragmentViewModel);

    protected FragmentDfuBinding(Object obj, View view, int i, TextView textView, DonutProgress donutProgress, LinearLayout linearLayout) {
        super(obj, view, i);
        this.btnInputShareCode = textView;
        this.dpProgress = donutProgress;
        this.rlRoot = linearLayout;
    }

    public DFUFragmentViewModel getViewModel() {
        return this.mViewModel;
    }

    public static FragmentDfuBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentDfuBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentDfuBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_dfu, viewGroup, z, obj);
    }

    public static FragmentDfuBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentDfuBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentDfuBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_dfu, null, false, obj);
    }

    public static FragmentDfuBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentDfuBinding bind(View view, Object obj) {
        return (FragmentDfuBinding) bind(obj, view, R.layout.fragment_dfu);
    }
}
