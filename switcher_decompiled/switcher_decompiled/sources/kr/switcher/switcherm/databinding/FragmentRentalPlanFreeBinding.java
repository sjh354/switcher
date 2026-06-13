package kr.switcher.switcherm.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.viewmodel.PlanFreeFragmentViewModel;

/* JADX INFO: loaded from: classes2.dex */
public abstract class FragmentRentalPlanFreeBinding extends ViewDataBinding {
    public final CheckBox cbPlan1;
    public final CheckBox cbPlan2;
    public final CheckBox cbPlan3;
    public final CheckBox cbPlan4;
    public final LinearLayout linRoot;

    @Bindable
    protected PlanFreeFragmentViewModel mViewModel;
    public final TextView tvTitle1;

    public abstract void setViewModel(PlanFreeFragmentViewModel planFreeFragmentViewModel);

    protected FragmentRentalPlanFreeBinding(Object obj, View view, int i, CheckBox checkBox, CheckBox checkBox2, CheckBox checkBox3, CheckBox checkBox4, LinearLayout linearLayout, TextView textView) {
        super(obj, view, i);
        this.cbPlan1 = checkBox;
        this.cbPlan2 = checkBox2;
        this.cbPlan3 = checkBox3;
        this.cbPlan4 = checkBox4;
        this.linRoot = linearLayout;
        this.tvTitle1 = textView;
    }

    public PlanFreeFragmentViewModel getViewModel() {
        return this.mViewModel;
    }

    public static FragmentRentalPlanFreeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentRentalPlanFreeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentRentalPlanFreeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_rental_plan_free, viewGroup, z, obj);
    }

    public static FragmentRentalPlanFreeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentRentalPlanFreeBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentRentalPlanFreeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_rental_plan_free, null, false, obj);
    }

    public static FragmentRentalPlanFreeBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentRentalPlanFreeBinding bind(View view, Object obj) {
        return (FragmentRentalPlanFreeBinding) bind(obj, view, R.layout.fragment_rental_plan_free);
    }
}
