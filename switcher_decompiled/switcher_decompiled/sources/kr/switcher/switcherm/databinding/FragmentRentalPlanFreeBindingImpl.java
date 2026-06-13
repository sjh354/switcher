package kr.switcher.switcherm.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import kr.switcher.switcherm.viewmodel.PlanFreeFragmentViewModel;

/* JADX INFO: loaded from: classes2.dex */
public class FragmentRentalPlanFreeBindingImpl extends FragmentRentalPlanFreeBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;
    private final TextView mboundView10;
    private final TextView mboundView11;
    private final TextView mboundView12;
    private final TextView mboundView14;
    private final TextView mboundView15;
    private final TextView mboundView16;
    private final TextView mboundView17;
    private final TextView mboundView18;
    private final TextView mboundView2;
    private final TextView mboundView20;
    private final TextView mboundView21;
    private final TextView mboundView22;
    private final TextView mboundView23;
    private final TextView mboundView24;
    private final TextView mboundView4;
    private final TextView mboundView5;
    private final TextView mboundView6;
    private final TextView mboundView8;
    private final TextView mboundView9;

    public FragmentRentalPlanFreeBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 25, sIncludes, sViewsWithIds));
    }

    private FragmentRentalPlanFreeBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (CheckBox) objArr[1], (CheckBox) objArr[7], (CheckBox) objArr[13], (CheckBox) objArr[19], (LinearLayout) objArr[0], (TextView) objArr[3]);
        this.mDirtyFlags = -1L;
        this.cbPlan1.setTag(null);
        this.cbPlan2.setTag(null);
        this.cbPlan3.setTag(null);
        this.cbPlan4.setTag(null);
        this.linRoot.setTag(null);
        TextView textView = (TextView) objArr[10];
        this.mboundView10 = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[11];
        this.mboundView11 = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) objArr[12];
        this.mboundView12 = textView3;
        textView3.setTag(null);
        TextView textView4 = (TextView) objArr[14];
        this.mboundView14 = textView4;
        textView4.setTag(null);
        TextView textView5 = (TextView) objArr[15];
        this.mboundView15 = textView5;
        textView5.setTag(null);
        TextView textView6 = (TextView) objArr[16];
        this.mboundView16 = textView6;
        textView6.setTag(null);
        TextView textView7 = (TextView) objArr[17];
        this.mboundView17 = textView7;
        textView7.setTag(null);
        TextView textView8 = (TextView) objArr[18];
        this.mboundView18 = textView8;
        textView8.setTag(null);
        TextView textView9 = (TextView) objArr[2];
        this.mboundView2 = textView9;
        textView9.setTag(null);
        TextView textView10 = (TextView) objArr[20];
        this.mboundView20 = textView10;
        textView10.setTag(null);
        TextView textView11 = (TextView) objArr[21];
        this.mboundView21 = textView11;
        textView11.setTag(null);
        TextView textView12 = (TextView) objArr[22];
        this.mboundView22 = textView12;
        textView12.setTag(null);
        TextView textView13 = (TextView) objArr[23];
        this.mboundView23 = textView13;
        textView13.setTag(null);
        TextView textView14 = (TextView) objArr[24];
        this.mboundView24 = textView14;
        textView14.setTag(null);
        TextView textView15 = (TextView) objArr[4];
        this.mboundView4 = textView15;
        textView15.setTag(null);
        TextView textView16 = (TextView) objArr[5];
        this.mboundView5 = textView16;
        textView16.setTag(null);
        TextView textView17 = (TextView) objArr[6];
        this.mboundView6 = textView17;
        textView17.setTag(null);
        TextView textView18 = (TextView) objArr[8];
        this.mboundView8 = textView18;
        textView18.setTag(null);
        TextView textView19 = (TextView) objArr[9];
        this.mboundView9 = textView19;
        textView19.setTag(null);
        this.tvTitle1.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 128L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.mDirtyFlags != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (39 != i) {
            return false;
        }
        setViewModel((PlanFreeFragmentViewModel) obj);
        return true;
    }

    @Override // kr.switcher.switcherm.databinding.FragmentRentalPlanFreeBinding
    public void setViewModel(PlanFreeFragmentViewModel planFreeFragmentViewModel) {
        updateRegistration(0, planFreeFragmentViewModel);
        this.mViewModel = planFreeFragmentViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(39);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return onChangeViewModel((PlanFreeFragmentViewModel) obj, i2);
    }

    private boolean onChangeViewModel(PlanFreeFragmentViewModel planFreeFragmentViewModel, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        }
        if (i == 12) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        }
        if (i == 13) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        }
        if (i == 37) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        }
        if (i == 10) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        }
        if (i == 23) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        }
        if (i != 9) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x019d  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 694
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kr.switcher.switcherm.databinding.FragmentRentalPlanFreeBindingImpl.executeBindings():void");
    }
}
