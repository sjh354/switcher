package kr.switcher.switcherm.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.viewmodel.HelpFragmentViewModel;

/* JADX INFO: loaded from: classes2.dex */
public class FragmentHelpBindingImpl extends FragmentHelpBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.rl_menu_name1, 1);
        sparseIntArray.put(R.id.et_room_name, 2);
        sparseIntArray.put(R.id.rl_menu_name2, 3);
        sparseIntArray.put(R.id.rl_menu_name3, 4);
        sparseIntArray.put(R.id.rl_menu_name4, 5);
        sparseIntArray.put(R.id.rl_menu_name5, 6);
        sparseIntArray.put(R.id.rl_menu_name6, 7);
    }

    public FragmentHelpBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 8, sIncludes, sViewsWithIds));
    }

    private FragmentHelpBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (TextView) objArr[2], (RelativeLayout) objArr[1], (RelativeLayout) objArr[3], (RelativeLayout) objArr[4], (RelativeLayout) objArr[5], (RelativeLayout) objArr[6], (RelativeLayout) objArr[7], (RelativeLayout) objArr[0]);
        this.mDirtyFlags = -1L;
        this.rlRoot.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 2L;
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
        setViewModel((HelpFragmentViewModel) obj);
        return true;
    }

    @Override // kr.switcher.switcherm.databinding.FragmentHelpBinding
    public void setViewModel(HelpFragmentViewModel helpFragmentViewModel) {
        this.mViewModel = helpFragmentViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return onChangeViewModel((HelpFragmentViewModel) obj, i2);
    }

    private boolean onChangeViewModel(HelpFragmentViewModel helpFragmentViewModel, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}
