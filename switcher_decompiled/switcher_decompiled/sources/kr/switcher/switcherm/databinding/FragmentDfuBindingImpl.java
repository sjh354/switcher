package kr.switcher.switcherm.databinding;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.databinding.adapters.ViewBindingAdapter;
import com.github.lzyzsd.circleprogress.DonutProgress;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.viewmodel.DFUFragmentViewModel;

/* JADX INFO: loaded from: classes2.dex */
public class FragmentDfuBindingImpl extends FragmentDfuBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ImageView mboundView1;
    private final TextView mboundView2;
    private final RelativeLayout mboundView3;
    private final TextView mboundView4;
    private final RelativeLayout mboundView5;
    private final TextView mboundView6;
    private final RelativeLayout mboundView7;
    private final TextView mboundView8;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.dp_progress, 9);
        sparseIntArray.put(R.id.btn_input_share_code, 10);
    }

    public FragmentDfuBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 11, sIncludes, sViewsWithIds));
    }

    private FragmentDfuBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (TextView) objArr[10], (DonutProgress) objArr[9], (LinearLayout) objArr[0]);
        this.mDirtyFlags = -1L;
        ImageView imageView = (ImageView) objArr[1];
        this.mboundView1 = imageView;
        imageView.setTag(null);
        TextView textView = (TextView) objArr[2];
        this.mboundView2 = textView;
        textView.setTag(null);
        RelativeLayout relativeLayout = (RelativeLayout) objArr[3];
        this.mboundView3 = relativeLayout;
        relativeLayout.setTag(null);
        TextView textView2 = (TextView) objArr[4];
        this.mboundView4 = textView2;
        textView2.setTag(null);
        RelativeLayout relativeLayout2 = (RelativeLayout) objArr[5];
        this.mboundView5 = relativeLayout2;
        relativeLayout2.setTag(null);
        TextView textView3 = (TextView) objArr[6];
        this.mboundView6 = textView3;
        textView3.setTag(null);
        RelativeLayout relativeLayout3 = (RelativeLayout) objArr[7];
        this.mboundView7 = relativeLayout3;
        relativeLayout3.setTag(null);
        TextView textView4 = (TextView) objArr[8];
        this.mboundView8 = textView4;
        textView4.setTag(null);
        this.rlRoot.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 256L;
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

    @Override // kr.switcher.switcherm.databinding.FragmentDfuBinding
    public void setViewModel(DFUFragmentViewModel dFUFragmentViewModel) {
        updateRegistration(0, dFUFragmentViewModel);
        this.mViewModel = dFUFragmentViewModel;
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
        return onChangeViewModel((DFUFragmentViewModel) obj, i2);
    }

    private boolean onChangeViewModel(DFUFragmentViewModel dFUFragmentViewModel, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        }
        if (i == 35) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        }
        if (i == 34) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        }
        if (i == 40) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        }
        if (i == 25) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        }
        if (i == 52) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        }
        if (i == 38) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        }
        if (i != 42) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 128;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        int i;
        int i2;
        int i3;
        Drawable drawable;
        String str;
        String str2;
        String str3;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        DFUFragmentViewModel dFUFragmentViewModel = this.mViewModel;
        int visibilityOfLastVersion = 0;
        Drawable switcherIcon = null;
        if ((511 & j) != 0) {
            String progress = ((j & 273) == 0 || dFUFragmentViewModel == null) ? null : dFUFragmentViewModel.getProgress();
            String version = ((j & 321) == 0 || dFUFragmentViewModel == null) ? null : dFUFragmentViewModel.getVersion();
            int visibilityOfDFUUpdating = ((j & 265) == 0 || dFUFragmentViewModel == null) ? 0 : dFUFragmentViewModel.getVisibilityOfDFUUpdating();
            String siwtcherName = ((j & 261) == 0 || dFUFragmentViewModel == null) ? null : dFUFragmentViewModel.getSiwtcherName();
            int visibilityOfUpdate = ((j & 289) == 0 || dFUFragmentViewModel == null) ? 0 : dFUFragmentViewModel.getVisibilityOfUpdate();
            if ((j & 259) != 0 && dFUFragmentViewModel != null) {
                switcherIcon = dFUFragmentViewModel.getSwitcherIcon();
            }
            if ((j & 385) != 0 && dFUFragmentViewModel != null) {
                visibilityOfLastVersion = dFUFragmentViewModel.getVisibilityOfLastVersion();
            }
            str2 = progress;
            i3 = visibilityOfLastVersion;
            drawable = switcherIcon;
            str3 = version;
            i = visibilityOfDFUUpdating;
            str = siwtcherName;
            i2 = visibilityOfUpdate;
        } else {
            i = 0;
            i2 = 0;
            i3 = 0;
            drawable = null;
            str = null;
            str2 = null;
            str3 = null;
        }
        if ((j & 259) != 0) {
            ViewBindingAdapter.setBackground(this.mboundView1, drawable);
        }
        if ((j & 261) != 0) {
            TextViewBindingAdapter.setText(this.mboundView2, str);
        }
        if ((j & 265) != 0) {
            this.mboundView3.setVisibility(i);
        }
        if ((j & 273) != 0) {
            TextViewBindingAdapter.setText(this.mboundView4, str2);
        }
        if ((289 & j) != 0) {
            this.mboundView5.setVisibility(i2);
        }
        if ((321 & j) != 0) {
            TextViewBindingAdapter.setText(this.mboundView6, str3);
            TextViewBindingAdapter.setText(this.mboundView8, str3);
        }
        if ((j & 385) != 0) {
            this.mboundView7.setVisibility(i3);
        }
    }
}
