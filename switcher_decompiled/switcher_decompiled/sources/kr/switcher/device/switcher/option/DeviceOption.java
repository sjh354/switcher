package kr.switcher.device.switcher.option;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceOption {
    protected String warrantyDate;
    protected ShippingInfo shipping = new ShippingInfo(0);
    protected PaymentInfo payment = new PaymentInfo("unknown");

    public PaymentInfo getPaymentInfo() {
        return this.payment;
    }

    public ShippingInfo getShipping() {
        return this.shipping;
    }

    public void setShippingStatus(int i) {
        this.shipping.setStatus(i);
    }

    public void setContractStatus(String str) {
        this.payment.setStatus(str);
    }

    public void setBuyingType(String str) {
        this.payment.setType(str);
    }

    public void setBuyingId(int i) {
        this.payment.setBuyingId(i);
    }

    public void setNextPayDateTime(String str) {
        this.payment.setNextPayAt(str);
    }

    public String getWarrantyDate() {
        return this.warrantyDate;
    }

    public void setWarrantyDate(String str) {
        this.warrantyDate = str;
    }

    public void setPaymentMethod(int i, String str) {
        this.payment.setPaymentMethod(i);
        if (str != null) {
            this.payment.setNextPayAt(str.substring(0, 10));
        }
    }

    public void setPaymentCardInfo(int i, String str, String str2, String str3) {
        this.payment.setCardId(i);
        this.payment.setCardName(str);
        this.payment.setCardNumber(str2);
        this.payment.setExpirationDate(str3);
    }
}
