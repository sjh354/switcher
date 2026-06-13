package kr.switcher.switcherm.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.CompoundButtonBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.rey.material.widget.RadioButton;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.viewmodel.ReturnBooking2FragmentViewModel;
import okhttp3.internal.ws.RealWebSocket;

/* JADX INFO: loaded from: classes2.dex */
public class FragmentReturnBooking2BindingImpl extends FragmentReturnBooking2Binding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.iv_calendar, 12);
        sparseIntArray.put(R.id.tv_return_message1, 13);
        sparseIntArray.put(R.id.tv_return_message2, 14);
        sparseIntArray.put(R.id.tv_return_message3, 15);
        sparseIntArray.put(R.id.tv_return_message4, 16);
    }

    public FragmentReturnBooking2BindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 17, sIncludes, sViewsWithIds));
    }

    private FragmentReturnBooking2BindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (ImageView) objArr[12], (ProgressBar) objArr[11], (RadioButton) objArr[2], (RadioButton) objArr[4], (RadioButton) objArr[6], (RadioButton) objArr[8], (RadioButton) objArr[10], (RelativeLayout) objArr[0], (TextView) objArr[13], (TextView) objArr[14], (TextView) objArr[15], (TextView) objArr[16], (TextView) objArr[1], (TextView) objArr[3], (TextView) objArr[5], (TextView) objArr[7], (TextView) objArr[9]);
        this.mDirtyFlags = -1L;
        this.pbSearching.setTag(null);
        this.rbVisitDay1.setTag(null);
        this.rbVisitDay2.setTag(null);
        this.rbVisitDay3.setTag(null);
        this.rbVisitDay4.setTag(null);
        this.rbVisitDay5.setTag(null);
        this.rlRoot.setTag(null);
        this.tvVisitDay1.setTag(null);
        this.tvVisitDay2.setTag(null);
        this.tvVisitDay3.setTag(null);
        this.tvVisitDay4.setTag(null);
        this.tvVisitDay5.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 4096L;
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
        setViewModel((ReturnBooking2FragmentViewModel) obj);
        return true;
    }

    @Override // kr.switcher.switcherm.databinding.FragmentReturnBooking2Binding
    public void setViewModel(ReturnBooking2FragmentViewModel returnBooking2FragmentViewModel) {
        updateRegistration(0, returnBooking2FragmentViewModel);
        this.mViewModel = returnBooking2FragmentViewModel;
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
        return onChangeViewModel((ReturnBooking2FragmentViewModel) obj, i2);
    }

    private boolean onChangeViewModel(ReturnBooking2FragmentViewModel returnBooking2FragmentViewModel, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        }
        if (i == 54) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        }
        if (i == 14) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        }
        if (i == 55) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        }
        if (i == 15) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        }
        if (i == 56) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        }
        if (i == 16) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        }
        if (i == 57) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
            }
            return true;
        }
        if (i == 17) {
            synchronized (this) {
                this.mDirtyFlags |= 256;
            }
            return true;
        }
        if (i == 58) {
            synchronized (this) {
                this.mDirtyFlags |= 512;
            }
            return true;
        }
        if (i == 18) {
            synchronized (this) {
                this.mDirtyFlags |= RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE;
            }
            return true;
        }
        if (i != 46) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2048;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        String visitDay1;
        String str2;
        String str3;
        String str4;
        int i;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        ReturnBooking2FragmentViewModel returnBooking2FragmentViewModel = this.mViewModel;
        String visitDay3 = null;
        boolean isVisitDay5 = false;
        if ((8191 & j) != 0) {
            visitDay1 = ((j & 4099) == 0 || returnBooking2FragmentViewModel == null) ? null : returnBooking2FragmentViewModel.getVisitDay1();
            String visitDay4 = ((j & 4225) == 0 || returnBooking2FragmentViewModel == null) ? null : returnBooking2FragmentViewModel.getVisitDay4();
            String visitDay5 = ((j & 4609) == 0 || returnBooking2FragmentViewModel == null) ? null : returnBooking2FragmentViewModel.getVisitDay5();
            String visitDay2 = ((j & 4105) == 0 || returnBooking2FragmentViewModel == null) ? null : returnBooking2FragmentViewModel.getVisitDay2();
            int visibilityOfProgressbar = ((j & 6145) == 0 || returnBooking2FragmentViewModel == null) ? 0 : returnBooking2FragmentViewModel.getVisibilityOfProgressbar();
            if ((j & 4129) != 0 && returnBooking2FragmentViewModel != null) {
                visitDay3 = returnBooking2FragmentViewModel.getVisitDay3();
            }
            boolean isVisitDay2 = ((j & 4113) == 0 || returnBooking2FragmentViewModel == null) ? false : returnBooking2FragmentViewModel.getIsVisitDay2();
            boolean isVisitDay3 = ((j & 4161) == 0 || returnBooking2FragmentViewModel == null) ? false : returnBooking2FragmentViewModel.getIsVisitDay3();
            boolean isVisitDay1 = ((j & 4101) == 0 || returnBooking2FragmentViewModel == null) ? false : returnBooking2FragmentViewModel.getIsVisitDay1();
            boolean isVisitDay4 = ((j & 4353) == 0 || returnBooking2FragmentViewModel == null) ? false : returnBooking2FragmentViewModel.getIsVisitDay4();
            if ((j & 5121) != 0 && returnBooking2FragmentViewModel != null) {
                isVisitDay5 = returnBooking2FragmentViewModel.getIsVisitDay5();
            }
            str2 = visitDay3;
            z3 = isVisitDay5;
            str3 = visitDay4;
            str4 = visitDay5;
            str = visitDay2;
            i = visibilityOfProgressbar;
            z4 = isVisitDay2;
            z5 = isVisitDay3;
            z = isVisitDay1;
            z2 = isVisitDay4;
        } else {
            str = null;
            visitDay1 = null;
            str2 = null;
            str3 = null;
            str4 = null;
            i = 0;
            z = false;
            z2 = false;
            z3 = false;
            z4 = false;
            z5 = false;
        }
        if ((j & 6145) != 0) {
            this.pbSearching.setVisibility(i);
        }
        if ((j & 4101) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.rbVisitDay1, z);
        }
        if ((j & 4113) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.rbVisitDay2, z4);
        }
        if ((j & 4161) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.rbVisitDay3, z5);
        }
        if ((4353 & j) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.rbVisitDay4, z2);
        }
        if ((5121 & j) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.rbVisitDay5, z3);
        }
        if ((j & 4099) != 0) {
            TextViewBindingAdapter.setText(this.tvVisitDay1, visitDay1);
        }
        if ((4105 & j) != 0) {
            TextViewBindingAdapter.setText(this.tvVisitDay2, str);
        }
        if ((4129 & j) != 0) {
            TextViewBindingAdapter.setText(this.tvVisitDay3, str2);
        }
        if ((j & 4225) != 0) {
            TextViewBindingAdapter.setText(this.tvVisitDay4, str3);
        }
        if ((j & 4609) != 0) {
            TextViewBindingAdapter.setText(this.tvVisitDay5, str4);
        }
    }
}
