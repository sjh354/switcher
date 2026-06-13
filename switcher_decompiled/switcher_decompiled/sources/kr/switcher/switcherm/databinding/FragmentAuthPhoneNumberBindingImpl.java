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
import kr.switcher.switcherm.viewmodel.AuthPhoneNumberFragmentViewModel;

/* JADX INFO: loaded from: classes2.dex */
public class FragmentAuthPhoneNumberBindingImpl extends FragmentAuthPhoneNumberBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final FrameLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.ll_phone_number, 1);
        sparseIntArray.put(R.id.et_phone_number, 2);
        sparseIntArray.put(R.id.rl_info, 3);
        sparseIntArray.put(R.id.tv_info1, 4);
        sparseIntArray.put(R.id.tv_info2, 5);
        sparseIntArray.put(R.id.tv_info3, 6);
    }

    public FragmentAuthPhoneNumberBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 7, sIncludes, sViewsWithIds));
    }

    private FragmentAuthPhoneNumberBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (EditText) objArr[2], (LinearLayout) objArr[1], (RelativeLayout) objArr[3], (TextView) objArr[4], (TextView) objArr[5], (TextView) objArr[6]);
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
        setViewModel((AuthPhoneNumberFragmentViewModel) obj);
        return true;
    }

    @Override // kr.switcher.switcherm.databinding.FragmentAuthPhoneNumberBinding
    public void setViewModel(AuthPhoneNumberFragmentViewModel authPhoneNumberFragmentViewModel) {
        this.mViewModel = authPhoneNumberFragmentViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return onChangeViewModel((AuthPhoneNumberFragmentViewModel) obj, i2);
    }

    private boolean onChangeViewModel(AuthPhoneNumberFragmentViewModel authPhoneNumberFragmentViewModel, int i) {
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
