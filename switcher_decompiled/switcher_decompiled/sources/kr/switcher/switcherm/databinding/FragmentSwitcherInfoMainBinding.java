package kr.switcher.switcherm.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.viewmodel.SwitcherInfoMainFragmentViewModel;

/* JADX INFO: loaded from: classes2.dex */
public abstract class FragmentSwitcherInfoMainBinding extends ViewDataBinding {
    public final ImageButton ibPaymentCard;
    public final ImageView ibPlan;
    public final ImageView ivSwitcherIcon;
    public final LinearLayout linRoot;

    @Bindable
    protected SwitcherInfoMainFragmentViewModel mViewModel;
    public final TextView tvFreeTrial;
    public final TextView tvPricingModel;
    public final TextView tvSwitcherName;
    public final TextView tvSwitcherType;

    public abstract void setViewModel(SwitcherInfoMainFragmentViewModel switcherInfoMainFragmentViewModel);

    protected FragmentSwitcherInfoMainBinding(Object obj, View view, int i, ImageButton imageButton, ImageView imageView, ImageView imageView2, LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        super(obj, view, i);
        this.ibPaymentCard = imageButton;
        this.ibPlan = imageView;
        this.ivSwitcherIcon = imageView2;
        this.linRoot = linearLayout;
        this.tvFreeTrial = textView;
        this.tvPricingModel = textView2;
        this.tvSwitcherName = textView3;
        this.tvSwitcherType = textView4;
    }

    public SwitcherInfoMainFragmentViewModel getViewModel() {
        return this.mViewModel;
    }

    public static FragmentSwitcherInfoMainBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentSwitcherInfoMainBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentSwitcherInfoMainBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_switcher_info_main, viewGroup, z, obj);
    }

    public static FragmentSwitcherInfoMainBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentSwitcherInfoMainBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentSwitcherInfoMainBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_switcher_info_main, null, false, obj);
    }

    public static FragmentSwitcherInfoMainBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentSwitcherInfoMainBinding bind(View view, Object obj) {
        return (FragmentSwitcherInfoMainBinding) bind(obj, view, R.layout.fragment_switcher_info_main);
    }
}
