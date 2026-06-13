package kr.switcher.switcherm.viewmodel;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.common.util.IOUtil;

/* JADX INFO: loaded from: classes2.dex */
public class ReturnConfirmFragmentViewModel extends BaseObservable {
    private String invoiceNumber;
    private String reservationReturnDate;
    private int visibilityOfProgressbar;

    public ReturnConfirmFragmentViewModel(String str, String str2) {
        setReservationReturnDate(str);
        setInvoiceNumber(str2);
        hideProgressbar();
        IOLog.activity(IOUtil.getStringResource(R.string.screen_title_5_0_2_2_4));
    }

    public void showProgressbar() {
        setVisibilityOfProgressbar(0);
    }

    public void hideProgressbar() {
        setVisibilityOfProgressbar(4);
    }

    @Bindable
    public int getVisibilityOfProgressbar() {
        return this.visibilityOfProgressbar;
    }

    public void setVisibilityOfProgressbar(int i) {
        this.visibilityOfProgressbar = i;
        notifyPropertyChanged(46);
    }

    @Bindable
    public String getReservationReturnDate() {
        return this.reservationReturnDate;
    }

    public void setReservationReturnDate(String str) {
        this.reservationReturnDate = str;
        notifyPropertyChanged(28);
    }

    @Bindable
    public String getInvoiceNumber() {
        return this.invoiceNumber;
    }

    public void setInvoiceNumber(String str) {
        this.invoiceNumber = str;
        notifyPropertyChanged(11);
    }
}
