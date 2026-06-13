package kr.switcher.switcherm.ui.switcherInfo.presenters;

import kr.switcher.switcherm.ui.switcherInfo.views.ReturnBookingView;

/* JADX INFO: loaded from: classes2.dex */
public class ReturnBookingPresenter {
    private ReturnBookingView view;

    public ReturnBookingPresenter(ReturnBookingView returnBookingView) {
        this.view = returnBookingView;
    }

    public void initialize(String str, String str2, String str3, String str4, String str5) {
        this.view.setReturnInfo(str, str2, str3, str4, str5);
        this.view.trackAddressForGA();
    }

    public void updatePostNumber(String str) {
        this.view.setPostNumber(str);
    }

    public void updateAddress1(String str) {
        this.view.setAddress1(str);
        this.view.clearAndFocusAddress2();
    }
}
