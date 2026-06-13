package kr.switcher.switcherm.databinding;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.databinding.adapters.ViewBindingAdapter;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.viewmodel.SwitcherInfoMainFragmentViewModel;
import okhttp3.internal.http2.Http2Stream;
import okhttp3.internal.ws.RealWebSocket;

/* JADX INFO: loaded from: classes2.dex */
public class FragmentSwitcherInfoMainBindingImpl extends FragmentSwitcherInfoMainBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final TextView mboundView10;
    private final RelativeLayout mboundView13;
    private final TextView mboundView14;
    private final LinearLayout mboundView15;
    private final LinearLayout mboundView16;
    private final TextView mboundView17;
    private final TextView mboundView18;
    private final LinearLayout mboundView19;
    private final TextView mboundView20;
    private final TextView mboundView4;
    private final TextView mboundView5;
    private final RelativeLayout mboundView6;
    private final TextView mboundView7;
    private final RelativeLayout mboundView8;
    private final LinearLayout mboundView9;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.ib_payment_card, 21);
        sparseIntArray.put(R.id.tv_free_trial, 22);
    }

    public FragmentSwitcherInfoMainBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 23, sIncludes, sViewsWithIds));
    }

    private FragmentSwitcherInfoMainBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (ImageButton) objArr[21], (ImageView) objArr[11], (ImageView) objArr[1], (LinearLayout) objArr[0], (TextView) objArr[22], (TextView) objArr[12], (TextView) objArr[2], (TextView) objArr[3]);
        this.mDirtyFlags = -1L;
        this.ibPlan.setTag(null);
        this.ivSwitcherIcon.setTag(null);
        this.linRoot.setTag(null);
        TextView textView = (TextView) objArr[10];
        this.mboundView10 = textView;
        textView.setTag(null);
        RelativeLayout relativeLayout = (RelativeLayout) objArr[13];
        this.mboundView13 = relativeLayout;
        relativeLayout.setTag(null);
        TextView textView2 = (TextView) objArr[14];
        this.mboundView14 = textView2;
        textView2.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[15];
        this.mboundView15 = linearLayout;
        linearLayout.setTag(null);
        LinearLayout linearLayout2 = (LinearLayout) objArr[16];
        this.mboundView16 = linearLayout2;
        linearLayout2.setTag(null);
        TextView textView3 = (TextView) objArr[17];
        this.mboundView17 = textView3;
        textView3.setTag(null);
        TextView textView4 = (TextView) objArr[18];
        this.mboundView18 = textView4;
        textView4.setTag(null);
        LinearLayout linearLayout3 = (LinearLayout) objArr[19];
        this.mboundView19 = linearLayout3;
        linearLayout3.setTag(null);
        TextView textView5 = (TextView) objArr[20];
        this.mboundView20 = textView5;
        textView5.setTag(null);
        TextView textView6 = (TextView) objArr[4];
        this.mboundView4 = textView6;
        textView6.setTag(null);
        TextView textView7 = (TextView) objArr[5];
        this.mboundView5 = textView7;
        textView7.setTag(null);
        RelativeLayout relativeLayout2 = (RelativeLayout) objArr[6];
        this.mboundView6 = relativeLayout2;
        relativeLayout2.setTag(null);
        TextView textView8 = (TextView) objArr[7];
        this.mboundView7 = textView8;
        textView8.setTag(null);
        RelativeLayout relativeLayout3 = (RelativeLayout) objArr[8];
        this.mboundView8 = relativeLayout3;
        relativeLayout3.setTag(null);
        LinearLayout linearLayout4 = (LinearLayout) objArr[9];
        this.mboundView9 = linearLayout4;
        linearLayout4.setTag(null);
        this.tvPricingModel.setTag(null);
        this.tvSwitcherName.setTag(null);
        this.tvSwitcherType.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 524288L;
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
        setViewModel((SwitcherInfoMainFragmentViewModel) obj);
        return true;
    }

    @Override // kr.switcher.switcherm.databinding.FragmentSwitcherInfoMainBinding
    public void setViewModel(SwitcherInfoMainFragmentViewModel switcherInfoMainFragmentViewModel) {
        updateRegistration(0, switcherInfoMainFragmentViewModel);
        this.mViewModel = switcherInfoMainFragmentViewModel;
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
        return onChangeViewModel((SwitcherInfoMainFragmentViewModel) obj, i2);
    }

    private boolean onChangeViewModel(SwitcherInfoMainFragmentViewModel switcherInfoMainFragmentViewModel, int i) {
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
        if (i == 36) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        }
        if (i == 29) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        }
        if (i == 21) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        }
        if (i == 32) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        }
        if (i == 43) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        }
        if (i == 33) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
            }
            return true;
        }
        if (i == 53) {
            synchronized (this) {
                this.mDirtyFlags |= 256;
            }
            return true;
        }
        if (i == 8) {
            synchronized (this) {
                this.mDirtyFlags |= 512;
            }
            return true;
        }
        if (i == 45) {
            synchronized (this) {
                this.mDirtyFlags |= RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE;
            }
            return true;
        }
        if (i == 24) {
            synchronized (this) {
                this.mDirtyFlags |= 2048;
            }
            return true;
        }
        if (i == 44) {
            synchronized (this) {
                this.mDirtyFlags |= 4096;
            }
            return true;
        }
        if (i == 22) {
            synchronized (this) {
                this.mDirtyFlags |= 8192;
            }
            return true;
        }
        if (i == 48) {
            synchronized (this) {
                this.mDirtyFlags |= Http2Stream.EMIT_BUFFER_SIZE;
            }
            return true;
        }
        if (i == 47) {
            synchronized (this) {
                this.mDirtyFlags |= 32768;
            }
            return true;
        }
        if (i == 27) {
            synchronized (this) {
                this.mDirtyFlags |= 65536;
            }
            return true;
        }
        if (i == 11) {
            synchronized (this) {
                this.mDirtyFlags |= 131072;
            }
            return true;
        }
        if (i != 49) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 262144;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        String str;
        String str2;
        String str3;
        String str4;
        Drawable drawable;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        SwitcherInfoMainFragmentViewModel switcherInfoMainFragmentViewModel = this.mViewModel;
        int visibilityOfReturnComplete = 0;
        String paymentDay = null;
        if ((1048575 & j) != 0) {
            String reservationDateReturn = ((j & 589825) == 0 || switcherInfoMainFragmentViewModel == null) ? null : switcherInfoMainFragmentViewModel.getReservationDateReturn();
            String serialNumber = ((j & 524321) == 0 || switcherInfoMainFragmentViewModel == null) ? null : switcherInfoMainFragmentViewModel.getSerialNumber();
            int visibilityOfReturnButton = ((j & 540673) == 0 || switcherInfoMainFragmentViewModel == null) ? 0 : switcherInfoMainFragmentViewModel.getVisibilityOfReturnButton();
            String owner = ((j & 524305) == 0 || switcherInfoMainFragmentViewModel == null) ? null : switcherInfoMainFragmentViewModel.getOwner();
            int visibilityOfPlanButton = ((j & 525313) == 0 || switcherInfoMainFragmentViewModel == null) ? 0 : switcherInfoMainFragmentViewModel.getVisibilityOfPlanButton();
            String creditCard = ((j & 524801) == 0 || switcherInfoMainFragmentViewModel == null) ? null : switcherInfoMainFragmentViewModel.getCreditCard();
            int visibilityOfReturn = ((j & 557057) == 0 || switcherInfoMainFragmentViewModel == null) ? 0 : switcherInfoMainFragmentViewModel.getVisibilityOfReturn();
            String invoiceNumber = ((j & 655361) == 0 || switcherInfoMainFragmentViewModel == null) ? null : switcherInfoMainFragmentViewModel.getInvoiceNumber();
            String shareCode = ((j & 524417) == 0 || switcherInfoMainFragmentViewModel == null) ? null : switcherInfoMainFragmentViewModel.getShareCode();
            int visibilityOfUsing = ((j & 524545) == 0 || switcherInfoMainFragmentViewModel == null) ? 0 : switcherInfoMainFragmentViewModel.getVisibilityOfUsing();
            String pricingModel = ((j & 526337) == 0 || switcherInfoMainFragmentViewModel == null) ? null : switcherInfoMainFragmentViewModel.getPricingModel();
            String switcherType = ((j & 524293) == 0 || switcherInfoMainFragmentViewModel == null) ? null : switcherInfoMainFragmentViewModel.getSwitcherType();
            Drawable switcherIcon = ((j & 524291) == 0 || switcherInfoMainFragmentViewModel == null) ? null : switcherInfoMainFragmentViewModel.getSwitcherIcon();
            int visibilityOfOwnerMenu = ((j & 524353) == 0 || switcherInfoMainFragmentViewModel == null) ? 0 : switcherInfoMainFragmentViewModel.getVisibilityOfOwnerMenu();
            int visibilityOfPaymentDay = ((j & 528385) == 0 || switcherInfoMainFragmentViewModel == null) ? 0 : switcherInfoMainFragmentViewModel.getVisibilityOfPaymentDay();
            if ((j & 786433) != 0 && switcherInfoMainFragmentViewModel != null) {
                visibilityOfReturnComplete = switcherInfoMainFragmentViewModel.getVisibilityOfReturnComplete();
            }
            String returnState = ((j & 524297) == 0 || switcherInfoMainFragmentViewModel == null) ? null : switcherInfoMainFragmentViewModel.getReturnState();
            if ((j & 532481) != 0 && switcherInfoMainFragmentViewModel != null) {
                paymentDay = switcherInfoMainFragmentViewModel.getPaymentDay();
            }
            str2 = reservationDateReturn;
            i5 = visibilityOfReturnComplete;
            str = paymentDay;
            str6 = serialNumber;
            i3 = visibilityOfReturnButton;
            str3 = owner;
            i = visibilityOfPlanButton;
            str5 = creditCard;
            i4 = visibilityOfReturn;
            str4 = invoiceNumber;
            str7 = shareCode;
            i6 = visibilityOfUsing;
            str8 = pricingModel;
            str9 = switcherType;
            drawable = switcherIcon;
            i7 = visibilityOfOwnerMenu;
            i2 = visibilityOfPaymentDay;
            str10 = returnState;
        } else {
            i = 0;
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            i6 = 0;
            i7 = 0;
            str = null;
            str2 = null;
            str3 = null;
            str4 = null;
            drawable = null;
            str5 = null;
            str6 = null;
            str7 = null;
            str8 = null;
            str9 = null;
            str10 = null;
        }
        if ((j & 525313) != 0) {
            this.ibPlan.setVisibility(i);
        }
        if ((j & 524291) != 0) {
            ViewBindingAdapter.setBackground(this.ivSwitcherIcon, drawable);
        }
        if ((j & 524801) != 0) {
            TextViewBindingAdapter.setText(this.mboundView10, str5);
        }
        if ((j & 528385) != 0) {
            this.mboundView13.setVisibility(i2);
        }
        if ((j & 532481) != 0) {
            TextViewBindingAdapter.setText(this.mboundView14, str);
        }
        if ((j & 540673) != 0) {
            this.mboundView15.setVisibility(i3);
        }
        if ((j & 557057) != 0) {
            this.mboundView16.setVisibility(i4);
        }
        if ((j & 589825) != 0) {
            TextViewBindingAdapter.setText(this.mboundView17, str2);
            TextViewBindingAdapter.setText(this.mboundView20, str2);
        }
        if ((j & 655361) != 0) {
            TextViewBindingAdapter.setText(this.mboundView18, str4);
        }
        if ((j & 786433) != 0) {
            this.mboundView19.setVisibility(i5);
        }
        if ((j & 524305) != 0) {
            TextViewBindingAdapter.setText(this.mboundView4, str3);
        }
        if ((j & 524321) != 0) {
            TextViewBindingAdapter.setText(this.mboundView5, str6);
        }
        if ((524353 & j) != 0) {
            int i8 = i7;
            this.mboundView6.setVisibility(i8);
            this.mboundView8.setVisibility(i8);
        }
        if ((j & 524417) != 0) {
            TextViewBindingAdapter.setText(this.mboundView7, str7);
        }
        if ((524545 & j) != 0) {
            this.mboundView9.setVisibility(i6);
        }
        if ((526337 & j) != 0) {
            TextViewBindingAdapter.setText(this.tvPricingModel, str8);
        }
        if ((524293 & j) != 0) {
            TextViewBindingAdapter.setText(this.tvSwitcherName, str9);
        }
        if ((j & 524297) != 0) {
            TextViewBindingAdapter.setText(this.tvSwitcherType, str10);
        }
    }
}
