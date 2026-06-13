package kr.switcher.switcherm.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.viewmodel.PaymentCardInfoFragmentViewModel;

/* JADX INFO: loaded from: classes2.dex */
public class FragmentPaymentCardInfoBindingImpl extends FragmentPaymentCardInfoBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final TextView mboundView1;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.tv_card_using_info, 6);
        sparseIntArray.put(R.id.tv_card_discount_info, 7);
    }

    public FragmentPaymentCardInfoBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 8, sIncludes, sViewsWithIds));
    }

    private FragmentPaymentCardInfoBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (LinearLayout) objArr[0], (TextView) objArr[7], (TextView) objArr[2], (TextView) objArr[3], (TextView) objArr[4], (TextView) objArr[5], (TextView) objArr[6]);
        this.mDirtyFlags = -1L;
        this.linRoot.setTag(null);
        TextView textView = (TextView) objArr[1];
        this.mboundView1 = textView;
        textView.setTag(null);
        this.tvCardNumber1.setTag(null);
        this.tvCardNumber2.setTag(null);
        this.tvCardNumber3.setTag(null);
        this.tvCardNumber4.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 8L;
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
        setViewModel((PaymentCardInfoFragmentViewModel) obj);
        return true;
    }

    @Override // kr.switcher.switcherm.databinding.FragmentPaymentCardInfoBinding
    public void setViewModel(PaymentCardInfoFragmentViewModel paymentCardInfoFragmentViewModel) {
        updateRegistration(0, paymentCardInfoFragmentViewModel);
        this.mViewModel = paymentCardInfoFragmentViewModel;
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
        return onChangeViewModel((PaymentCardInfoFragmentViewModel) obj, i2);
    }

    private boolean onChangeViewModel(PaymentCardInfoFragmentViewModel paymentCardInfoFragmentViewModel, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        }
        if (i == 2) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        }
        if (i != 7) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0045  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void executeBindings() {
        /*
            r17 = this;
            r1 = r17
            monitor-enter(r17)
            long r2 = r1.mDirtyFlags     // Catch: java.lang.Throwable -> L7e
            r4 = 0
            r1.mDirtyFlags = r4     // Catch: java.lang.Throwable -> L7e
            monitor-exit(r17)     // Catch: java.lang.Throwable -> L7e
            kr.switcher.switcherm.viewmodel.PaymentCardInfoFragmentViewModel r0 = r1.mViewModel
            r6 = 15
            long r6 = r6 & r2
            int r6 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            r7 = 13
            r9 = 11
            r11 = 0
            if (r6 == 0) goto L56
            long r12 = r2 & r7
            int r6 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r6 == 0) goto L45
            if (r0 == 0) goto L25
            java.util.List r6 = r0.getCardNumbers()
            goto L26
        L25:
            r6 = r11
        L26:
            if (r6 == 0) goto L45
            r12 = 3
            java.lang.Object r12 = getFromList(r6, r12)
            java.lang.String r12 = (java.lang.String) r12
            r13 = 1
            java.lang.Object r13 = getFromList(r6, r13)
            java.lang.String r13 = (java.lang.String) r13
            r14 = 2
            java.lang.Object r14 = getFromList(r6, r14)
            java.lang.String r14 = (java.lang.String) r14
            r15 = 0
            java.lang.Object r6 = getFromList(r6, r15)
            java.lang.String r6 = (java.lang.String) r6
            goto L49
        L45:
            r6 = r11
            r12 = r6
            r13 = r12
            r14 = r13
        L49:
            long r15 = r2 & r9
            int r15 = (r15 > r4 ? 1 : (r15 == r4 ? 0 : -1))
            if (r15 == 0) goto L5a
            if (r0 == 0) goto L5a
            java.lang.String r11 = r0.getCardCompany()
            goto L5a
        L56:
            r6 = r11
            r12 = r6
            r13 = r12
            r14 = r13
        L5a:
            long r9 = r9 & r2
            int r0 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r0 == 0) goto L64
            android.widget.TextView r0 = r1.mboundView1
            androidx.databinding.adapters.TextViewBindingAdapter.setText(r0, r11)
        L64:
            long r2 = r2 & r7
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L7d
            android.widget.TextView r0 = r1.tvCardNumber1
            androidx.databinding.adapters.TextViewBindingAdapter.setText(r0, r6)
            android.widget.TextView r0 = r1.tvCardNumber2
            androidx.databinding.adapters.TextViewBindingAdapter.setText(r0, r13)
            android.widget.TextView r0 = r1.tvCardNumber3
            androidx.databinding.adapters.TextViewBindingAdapter.setText(r0, r14)
            android.widget.TextView r0 = r1.tvCardNumber4
            androidx.databinding.adapters.TextViewBindingAdapter.setText(r0, r12)
        L7d:
            return
        L7e:
            r0 = move-exception
            monitor-exit(r17)     // Catch: java.lang.Throwable -> L7e
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kr.switcher.switcherm.databinding.FragmentPaymentCardInfoBindingImpl.executeBindings():void");
    }
}
