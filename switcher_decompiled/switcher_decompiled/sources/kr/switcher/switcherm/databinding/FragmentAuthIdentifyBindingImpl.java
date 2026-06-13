package kr.switcher.switcherm.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.viewmodel.AuthIdentifyFragmentViewModel;

/* JADX INFO: loaded from: classes2.dex */
public class FragmentAuthIdentifyBindingImpl extends FragmentAuthIdentifyBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final FrameLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.ll_phone_number, 1);
        sparseIntArray.put(R.id.et_auth_number, 2);
        sparseIntArray.put(R.id.rl_info, 3);
        sparseIntArray.put(R.id.rl_info1, 4);
        sparseIntArray.put(R.id.tv_info_phone_number, 5);
        sparseIntArray.put(R.id.rl_info2, 6);
        sparseIntArray.put(R.id.tv_second, 7);
    }

    public FragmentAuthIdentifyBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 8, sIncludes, sViewsWithIds));
    }

    private FragmentAuthIdentifyBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (EditText) objArr[2], (LinearLayout) objArr[1], (RelativeLayout) objArr[3], (LinearLayout) objArr[4], (LinearLayout) objArr[6], (TextView) objArr[5], (TextView) objArr[7]);
        this.mDirtyFlags = -1L;
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.mboundView0 = frameLayout;
        frameLayout.setTag(null);
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
        setViewModel((AuthIdentifyFragmentViewModel) obj);
        return true;
    }

    @Override // kr.switcher.switcherm.databinding.FragmentAuthIdentifyBinding
    public void setViewModel(AuthIdentifyFragmentViewModel authIdentifyFragmentViewModel) {
        this.mViewModel = authIdentifyFragmentViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return onChangeViewModel((AuthIdentifyFragmentViewModel) obj, i2);
    }

    private boolean onChangeViewModel(AuthIdentifyFragmentViewModel authIdentifyFragmentViewModel, int i) {
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
