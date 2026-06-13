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
import kr.switcher.switcherm.viewmodel.SettingActivityViewModel;

/* JADX INFO: loaded from: classes2.dex */
public class ActivitySettingBindingImpl extends ActivitySettingBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ImageView mboundView1;
    private final TextView mboundView2;
    private final ImageView mboundView3;
    private final TextView mboundView4;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.container, 5);
    }

    public ActivitySettingBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 6, sIncludes, sViewsWithIds));
    }

    private ActivitySettingBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (RelativeLayout) objArr[5], (RelativeLayout) objArr[0]);
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
        TextView textView2 = (TextView) objArr[4];
        this.mboundView4 = textView2;
        textView2.setTag(null);
        this.rlRoot.setTag(null);
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
        setViewModel((SettingActivityViewModel) obj);
        return true;
    }

    @Override // kr.switcher.switcherm.databinding.ActivitySettingBinding
    public void setViewModel(SettingActivityViewModel settingActivityViewModel) {
        updateRegistration(0, settingActivityViewModel);
        this.mViewModel = settingActivityViewModel;
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
        return onChangeViewModel((SettingActivityViewModel) obj, i2);
    }

    private boolean onChangeViewModel(SettingActivityViewModel settingActivityViewModel, int i) {
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
        if (i == 30) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        }
        if (i == 50) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        }
        if (i == 31) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        }
        if (i != 51) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        int i;
        int i2;
        Drawable drawable;
        String str;
        Drawable drawable2;
        String str2;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        SettingActivityViewModel settingActivityViewModel = this.mViewModel;
        int visibilityOfRightTextButton = 0;
        String menuName = null;
        if ((255 & j) != 0) {
            Drawable rightButton = ((j & 137) == 0 || settingActivityViewModel == null) ? null : settingActivityViewModel.getRightButton();
            Drawable leftButton = ((j & 131) == 0 || settingActivityViewModel == null) ? null : settingActivityViewModel.getLeftButton();
            int visibilityOfRightImageButton = ((j & 145) == 0 || settingActivityViewModel == null) ? 0 : settingActivityViewModel.getVisibilityOfRightImageButton();
            String rightButtonText = ((j & 161) == 0 || settingActivityViewModel == null) ? null : settingActivityViewModel.getRightButtonText();
            if ((j & 193) != 0 && settingActivityViewModel != null) {
                visibilityOfRightTextButton = settingActivityViewModel.getVisibilityOfRightTextButton();
            }
            if ((j & 133) != 0 && settingActivityViewModel != null) {
                menuName = settingActivityViewModel.getMenuName();
            }
            drawable2 = rightButton;
            i2 = visibilityOfRightTextButton;
            str = menuName;
            drawable = leftButton;
            i = visibilityOfRightImageButton;
            str2 = rightButtonText;
        } else {
            i = 0;
            i2 = 0;
            drawable = null;
            str = null;
            drawable2 = null;
            str2 = null;
        }
        if ((j & 131) != 0) {
            ViewBindingAdapter.setBackground(this.mboundView1, drawable);
        }
        if ((j & 133) != 0) {
            TextViewBindingAdapter.setText(this.mboundView2, str);
        }
        if ((j & 137) != 0) {
            ViewBindingAdapter.setBackground(this.mboundView3, drawable2);
        }
        if ((145 & j) != 0) {
            this.mboundView3.setVisibility(i);
        }
        if ((161 & j) != 0) {
            TextViewBindingAdapter.setText(this.mboundView4, str2);
        }
        if ((j & 193) != 0) {
            this.mboundView4.setVisibility(i2);
        }
    }
}
