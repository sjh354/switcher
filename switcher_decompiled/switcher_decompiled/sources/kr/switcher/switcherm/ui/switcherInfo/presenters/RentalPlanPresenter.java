package kr.switcher.switcherm.ui.switcherInfo.presenters;

import kr.switcher.device.IODevice;
import kr.switcher.switcherm.ui.switcherInfo.helper.ConverterPricingModelDBToPlanItem;
import kr.switcher.switcherm.ui.switcherInfo.views.RentalPlanView;

/* JADX INFO: loaded from: classes2.dex */
public class RentalPlanPresenter {
    private RentalPlanView view;

    public RentalPlanPresenter(RentalPlanView rentalPlanView) {
        this.view = rentalPlanView;
    }

    public void onResume(int i, IODevice.ProductId productId) {
        this.view.trackRentalPlanForGA();
        this.view.setPurchasePrice(getPaymentPrice(productId));
        this.view.setPlanListView(new ConverterPricingModelDBToPlanItem().setMainPlanCode(i).getPlanItems());
    }

    public void onConfirmResult(boolean z) {
        if (z) {
            this.view.showMessage("좀만 기다려주세요!");
        }
    }

    public void onBuyNowButtonClicked(IODevice.ProductId productId) {
        this.view.showConfirmDialog(getDevicePrice(productId) + "원", "?", "?", getPaymentPrice(productId));
    }

    private String getDevicePrice(IODevice.ProductId productId) {
        return productId == IODevice.ProductId.SWITCHER_TYPE_ONE ? "57,000" : "62,000";
    }

    private String getPaymentPrice(IODevice.ProductId productId) {
        return getDevicePrice(productId) + "원 - ";
    }
}
