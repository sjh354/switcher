package kr.switcher.switcherm.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.viewmodel.PaymentCardChangeFragmentViewModel;

/* JADX INFO: loaded from: classes2.dex */
public class FragmentPaymentCardChangeBindingImpl extends FragmentPaymentCardChangeBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.sp_companies, 5);
        sparseIntArray.put(R.id.sp_validity_month, 6);
        sparseIntArray.put(R.id.sp_validity_year, 7);
        sparseIntArray.put(R.id.tv_agree_text_1, 8);
        sparseIntArray.put(R.id.tv_agree_text_2, 9);
    }

    public FragmentPaymentCardChangeBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 10, sIncludes, sViewsWithIds));
    }

    private FragmentPaymentCardChangeBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (EditText) objArr[1], (EditText) objArr[2], (EditText) objArr[3], (EditText) objArr[4], (RelativeLayout) objArr[0], (Spinner) objArr[5], (Spinner) objArr[6], (Spinner) objArr[7], (TextView) objArr[8], (TextView) objArr[9]);
        this.mDirtyFlags = -1L;
        this.etCardNumber1.setTag(null);
        this.etCardNumber2.setTag(null);
        this.etCardNumber3.setTag(null);
        this.etCardNumber4.setTag(null);
        this.rlRoot.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 32L;
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
        setViewModel((PaymentCardChangeFragmentViewModel) obj);
        return true;
    }

    @Override // kr.switcher.switcherm.databinding.FragmentPaymentCardChangeBinding
    public void setViewModel(PaymentCardChangeFragmentViewModel paymentCardChangeFragmentViewModel) {
        updateRegistration(0, paymentCardChangeFragmentViewModel);
        this.mViewModel = paymentCardChangeFragmentViewModel;
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
        return onChangeViewModel((PaymentCardChangeFragmentViewModel) obj, i2);
    }

    private boolean onChangeViewModel(PaymentCardChangeFragmentViewModel paymentCardChangeFragmentViewModel, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        }
        if (i == 3) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        }
        if (i == 4) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        }
        if (i == 5) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        }
        if (i != 6) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        String cardNumber2;
        String str2;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        PaymentCardChangeFragmentViewModel paymentCardChangeFragmentViewModel = this.mViewModel;
        String cardNumber1 = null;
        if ((63 & j) != 0) {
            cardNumber2 = ((j & 37) == 0 || paymentCardChangeFragmentViewModel == null) ? null : paymentCardChangeFragmentViewModel.getCardNumber2();
            String cardNumber3 = ((j & 41) == 0 || paymentCardChangeFragmentViewModel == null) ? null : paymentCardChangeFragmentViewModel.getCardNumber3();
            String cardNumber4 = ((j & 49) == 0 || paymentCardChangeFragmentViewModel == null) ? null : paymentCardChangeFragmentViewModel.getCardNumber4();
            if ((j & 35) != 0 && paymentCardChangeFragmentViewModel != null) {
                cardNumber1 = paymentCardChangeFragmentViewModel.getCardNumber1();
            }
            str = cardNumber3;
            str2 = cardNumber4;
        } else {
            str = null;
            cardNumber2 = null;
            str2 = null;
        }
        if ((35 & j) != 0) {
            TextViewBindingAdapter.setText(this.etCardNumber1, cardNumber1);
        }
        if ((37 & j) != 0) {
            TextViewBindingAdapter.setText(this.etCardNumber2, cardNumber2);
        }
        if ((41 & j) != 0) {
            TextViewBindingAdapter.setText(this.etCardNumber3, str);
        }
        if ((j & 49) != 0) {
            TextViewBindingAdapter.setText(this.etCardNumber4, str2);
        }
    }
}
