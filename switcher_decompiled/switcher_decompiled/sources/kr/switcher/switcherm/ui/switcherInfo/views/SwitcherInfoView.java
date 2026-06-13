package kr.switcher.switcherm.ui.switcherInfo.views;

/* JADX INFO: loaded from: classes2.dex */
public interface SwitcherInfoView {
    void finish();

    void finishActivity();

    boolean isDiscount();

    void moveBuyingTypeChangeFragment();

    void moveContractView();

    void moveFreeTrialView();

    void movePaymentCardInfoFragment();

    void movePlanFragment();

    void movePlanFreeFragment();

    void moveRemoconInfoView();

    void moveRentalCompletedView();

    void moveRentalDeliveryCompletedView();

    void moveRentalPreSaleView();

    void moveRentalReturningView();

    void moveRentalUsingView();

    void moveReturnBookingFragment();

    void moveReturnInfoFragment();

    void moveWholeSaleView();

    void show();

    void showMessage(String str);
}
