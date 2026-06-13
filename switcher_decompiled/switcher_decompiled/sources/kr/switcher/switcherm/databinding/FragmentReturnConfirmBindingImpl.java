package kr.switcher.switcherm.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.viewmodel.ReturnConfirmFragmentViewModel;

/* JADX INFO: loaded from: classes2.dex */
public class FragmentReturnConfirmBindingImpl extends FragmentReturnConfirmBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final TextView mboundView2;
    private final TextView mboundView3;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.iv_calendar, 4);
        sparseIntArray.put(R.id.tv_return_confirm_message1, 5);
        sparseIntArray.put(R.id.rl_middle_message, 6);
        sparseIntArray.put(R.id.tv_return_confirm_message2, 7);
        sparseIntArray.put(R.id.tv_return_confirm_message3, 8);
        sparseIntArray.put(R.id.tv_return_confirm_message4, 9);
        sparseIntArray.put(R.id.tv_return_confirm_message5, 10);
    }

    public FragmentReturnConfirmBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 11, sIncludes, sViewsWithIds));
    }

    private FragmentReturnConfirmBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (ImageView) objArr[4], (ProgressBar) objArr[1], (RelativeLayout) objArr[6], (RelativeLayout) objArr[0], (TextView) objArr[5], (TextView) objArr[7], (TextView) objArr[8], (TextView) objArr[9], (TextView) objArr[10]);
        this.mDirtyFlags = -1L;
        TextView textView = (TextView) objArr[2];
        this.mboundView2 = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[3];
        this.mboundView3 = textView2;
        textView2.setTag(null);
        this.pbSearching.setTag(null);
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
        setViewModel((ReturnConfirmFragmentViewModel) obj);
        return true;
    }

    @Override // kr.switcher.switcherm.databinding.FragmentReturnConfirmBinding
    public void setViewModel(ReturnConfirmFragmentViewModel returnConfirmFragmentViewModel) {
        updateRegistration(0, returnConfirmFragmentViewModel);
        this.mViewModel = returnConfirmFragmentViewModel;
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
        return onChangeViewModel((ReturnConfirmFragmentViewModel) obj, i2);
    }

    private boolean onChangeViewModel(ReturnConfirmFragmentViewModel returnConfirmFragmentViewModel, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        }
        if (i == 46) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        }
        if (i == 28) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        }
        if (i != 11) {
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
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        int visibilityOfProgressbar = 0;
        ReturnConfirmFragmentViewModel returnConfirmFragmentViewModel = this.mViewModel;
        String invoiceNumber = null;
        if ((31 & j) != 0) {
            if ((j & 19) != 0 && returnConfirmFragmentViewModel != null) {
                visibilityOfProgressbar = returnConfirmFragmentViewModel.getVisibilityOfProgressbar();
            }
            String reservationReturnDate = ((j & 21) == 0 || returnConfirmFragmentViewModel == null) ? null : returnConfirmFragmentViewModel.getReservationReturnDate();
            if ((j & 25) != 0 && returnConfirmFragmentViewModel != null) {
                invoiceNumber = returnConfirmFragmentViewModel.getInvoiceNumber();
            }
            str = invoiceNumber;
            invoiceNumber = reservationReturnDate;
        } else {
            str = null;
        }
        if ((21 & j) != 0) {
            TextViewBindingAdapter.setText(this.mboundView2, invoiceNumber);
        }
        if ((j & 25) != 0) {
            TextViewBindingAdapter.setText(this.mboundView3, str);
        }
        if ((j & 19) != 0) {
            this.pbSearching.setVisibility(visibilityOfProgressbar);
        }
    }
}
