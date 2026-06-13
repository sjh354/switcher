package kr.switcher.switcherm.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.viewmodel.ReturnInfoFragmentViewModel;

/* JADX INFO: loaded from: classes2.dex */
public class FragmentReturnInfoBindingImpl extends FragmentReturnInfoBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.rl_box_info, 1);
        sparseIntArray.put(R.id.tv_return_box_info1, 2);
        sparseIntArray.put(R.id.tv_return_box_info2, 3);
        sparseIntArray.put(R.id.tv_return_box_info3, 4);
    }

    public FragmentReturnInfoBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 5, sIncludes, sViewsWithIds));
    }

    private FragmentReturnInfoBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (LinearLayout) objArr[0], (RelativeLayout) objArr[1], (TextView) objArr[2], (TextView) objArr[3], (TextView) objArr[4]);
        this.mDirtyFlags = -1L;
        this.linRoot.setTag(null);
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
        setViewModel((ReturnInfoFragmentViewModel) obj);
        return true;
    }

    @Override // kr.switcher.switcherm.databinding.FragmentReturnInfoBinding
    public void setViewModel(ReturnInfoFragmentViewModel returnInfoFragmentViewModel) {
        this.mViewModel = returnInfoFragmentViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return onChangeViewModel((ReturnInfoFragmentViewModel) obj, i2);
    }

    private boolean onChangeViewModel(ReturnInfoFragmentViewModel returnInfoFragmentViewModel, int i) {
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
