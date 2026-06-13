package kr.switcher.switcherm.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.viewmodel.AuthActivityViewModel;

/* JADX INFO: loaded from: classes2.dex */
public class ActivityAuthBindingImpl extends ActivityAuthBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.tv_start_text, 2);
        sparseIntArray.put(R.id.container, 3);
    }

    public ActivityAuthBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 4, sIncludes, sViewsWithIds));
    }

    private ActivityAuthBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (RelativeLayout) objArr[3], (ProgressBar) objArr[1], (RelativeLayout) objArr[0], (TextView) objArr[2]);
        this.mDirtyFlags = -1L;
        this.pbSearching.setTag(null);
        this.rlRoot.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 4L;
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
        setViewModel((AuthActivityViewModel) obj);
        return true;
    }

    @Override // kr.switcher.switcherm.databinding.ActivityAuthBinding
    public void setViewModel(AuthActivityViewModel authActivityViewModel) {
        updateRegistration(0, authActivityViewModel);
        this.mViewModel = authActivityViewModel;
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
        return onChangeViewModel((AuthActivityViewModel) obj, i2);
    }

    private boolean onChangeViewModel(AuthActivityViewModel authActivityViewModel, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        }
        if (i != 46) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        int visibilityOfProgressbar = 0;
        AuthActivityViewModel authActivityViewModel = this.mViewModel;
        long j2 = j & 7;
        if (j2 != 0 && authActivityViewModel != null) {
            visibilityOfProgressbar = authActivityViewModel.getVisibilityOfProgressbar();
        }
        if (j2 != 0) {
            this.pbSearching.setVisibility(visibilityOfProgressbar);
        }
    }
}
