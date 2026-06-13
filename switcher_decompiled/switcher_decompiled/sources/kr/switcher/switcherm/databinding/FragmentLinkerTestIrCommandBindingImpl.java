package kr.switcher.switcherm.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.wang.avi.AVLoadingIndicatorView;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.viewmodel.DFUFragmentViewModel;

/* JADX INFO: loaded from: classes2.dex */
public class FragmentLinkerTestIrCommandBindingImpl extends FragmentLinkerTestIrCommandBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.btn_test_command, 1);
        sparseIntArray.put(R.id.pb_registering, 2);
    }

    public FragmentLinkerTestIrCommandBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 3, sIncludes, sViewsWithIds));
    }

    private FragmentLinkerTestIrCommandBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (Button) objArr[1], (AVLoadingIndicatorView) objArr[2], (LinearLayout) objArr[0]);
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
        setViewModel((DFUFragmentViewModel) obj);
        return true;
    }

    @Override // kr.switcher.switcherm.databinding.FragmentLinkerTestIrCommandBinding
    public void setViewModel(DFUFragmentViewModel dFUFragmentViewModel) {
        this.mViewModel = dFUFragmentViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return onChangeViewModel((DFUFragmentViewModel) obj, i2);
    }

    private boolean onChangeViewModel(DFUFragmentViewModel dFUFragmentViewModel, int i) {
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
