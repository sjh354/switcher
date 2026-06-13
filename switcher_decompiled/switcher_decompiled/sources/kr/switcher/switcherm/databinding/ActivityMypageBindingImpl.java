package kr.switcher.switcherm.databinding;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.databinding.adapters.ViewBindingAdapter;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.viewmodel.MypageActivityViewModel;

/* JADX INFO: loaded from: classes2.dex */
public class ActivityMypageBindingImpl extends ActivityMypageBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ImageView mboundView1;
    private final TextView mboundView2;
    private final ImageView mboundView3;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.container, 4);
    }

    public ActivityMypageBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 5, sIncludes, sViewsWithIds));
    }

    private ActivityMypageBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (RelativeLayout) objArr[4], (RelativeLayout) objArr[0]);
        this.mDirtyFlags = -1L;
        ImageView imageView = (ImageView) objArr[1];
        this.mboundView1 = imageView;
        imageView.setTag(null);
        TextView textView = (TextView) objArr[2];
        this.mboundView2 = textView;
        textView.setTag(null);
        ImageView imageView2 = (ImageView) objArr[3];
        this.mboundView3 = imageView2;
        imageView2.setTag(null);
        this.rlRoot.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 16L;
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
        setViewModel((MypageActivityViewModel) obj);
        return true;
    }

    @Override // kr.switcher.switcherm.databinding.ActivityMypageBinding
    public void setViewModel(MypageActivityViewModel mypageActivityViewModel) {
        updateRegistration(0, mypageActivityViewModel);
        this.mViewModel = mypageActivityViewModel;
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
        return onChangeViewModel((MypageActivityViewModel) obj, i2);
    }

    private boolean onChangeViewModel(MypageActivityViewModel mypageActivityViewModel, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        }
        if (i == 19) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        }
        if (i == 20) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        }
        if (i != 30) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        Drawable rightButton;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        MypageActivityViewModel mypageActivityViewModel = this.mViewModel;
        Drawable drawable = null;
        menuName = null;
        String menuName = null;
        if ((31 & j) != 0) {
            rightButton = ((j & 25) == 0 || mypageActivityViewModel == null) ? null : mypageActivityViewModel.getRightButton();
            Drawable leftButton = ((j & 19) == 0 || mypageActivityViewModel == null) ? null : mypageActivityViewModel.getLeftButton();
            if ((j & 21) != 0 && mypageActivityViewModel != null) {
                menuName = mypageActivityViewModel.getMenuName();
            }
            str = menuName;
            drawable = leftButton;
        } else {
            str = null;
            rightButton = null;
        }
        if ((19 & j) != 0) {
            ViewBindingAdapter.setBackground(this.mboundView1, drawable);
        }
        if ((21 & j) != 0) {
            TextViewBindingAdapter.setText(this.mboundView2, str);
        }
        if ((j & 25) != 0) {
            ViewBindingAdapter.setBackground(this.mboundView3, rightButton);
        }
    }
}
