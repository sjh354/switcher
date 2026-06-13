package kr.switcher.switcherm.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.viewmodel.HelpFragmentViewModel;

/* JADX INFO: loaded from: classes2.dex */
public abstract class FragmentHelpBinding extends ViewDataBinding {
    public final TextView etRoomName;

    @Bindable
    protected HelpFragmentViewModel mViewModel;
    public final RelativeLayout rlMenuName1;
    public final RelativeLayout rlMenuName2;
    public final RelativeLayout rlMenuName3;
    public final RelativeLayout rlMenuName4;
    public final RelativeLayout rlMenuName5;
    public final RelativeLayout rlMenuName6;
    public final RelativeLayout rlRoot;

    public abstract void setViewModel(HelpFragmentViewModel helpFragmentViewModel);

    protected FragmentHelpBinding(Object obj, View view, int i, TextView textView, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4, RelativeLayout relativeLayout5, RelativeLayout relativeLayout6, RelativeLayout relativeLayout7) {
        super(obj, view, i);
        this.etRoomName = textView;
        this.rlMenuName1 = relativeLayout;
        this.rlMenuName2 = relativeLayout2;
        this.rlMenuName3 = relativeLayout3;
        this.rlMenuName4 = relativeLayout4;
        this.rlMenuName5 = relativeLayout5;
        this.rlMenuName6 = relativeLayout6;
        this.rlRoot = relativeLayout7;
    }

    public HelpFragmentViewModel getViewModel() {
        return this.mViewModel;
    }

    public static FragmentHelpBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentHelpBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentHelpBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_help, viewGroup, z, obj);
    }

    public static FragmentHelpBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentHelpBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentHelpBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_help, null, false, obj);
    }

    public static FragmentHelpBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentHelpBinding bind(View view, Object obj) {
        return (FragmentHelpBinding) bind(obj, view, R.layout.fragment_help);
    }
}
