package kr.switcher.device.switcher.option;

/* JADX INFO: loaded from: classes2.dex */
public class ShippingInfo {
    public static final int PAYMENT_FAIL = 9;
    public static final int PREPARING_PRODUCT = 0;
    public static final int RETURN_COMPLETED = 8;
    public static final int RETURN_ING = 6;
    public static final int USING = 4;
    int status;

    public ShippingInfo(int i) {
        this.status = i;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int i) {
        this.status = i;
    }
}
