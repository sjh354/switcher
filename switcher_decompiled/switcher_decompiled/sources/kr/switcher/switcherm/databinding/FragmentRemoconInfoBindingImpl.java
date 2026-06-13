package kr.switcher.switcherm.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import kr.switcher.switcherm.R;

/* JADX INFO: loaded from: classes2.dex */
public class FragmentRemoconInfoBindingImpl extends FragmentRemoconInfoBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.iv_remocon_icon, 1);
        sparseIntArray.put(R.id.tv_remocon_name, 2);
        sparseIntArray.put(R.id.tv_remocon_type, 3);
        sparseIntArray.put(R.id.using, 4);
        sparseIntArray.put(R.id.btn_delete_remocon, 5);
    }

    public FragmentRemoconInfoBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 6, sIncludes, sViewsWithIds));
    }

    private FragmentRemoconInfoBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[5], (ImageView) objArr[1], (LinearLayout) objArr[0], (TextView) objArr[2], (TextView) objArr[3], (TextView) objArr[4]);
        this.mDirtyFlags = -1L;
        this.linRoot.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 1L;
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
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}
