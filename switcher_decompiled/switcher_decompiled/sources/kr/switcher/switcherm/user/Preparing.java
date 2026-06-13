package kr.switcher.switcherm.user;

import kr.switcher.device.IODevice;

/* JADX INFO: loaded from: classes2.dex */
public class Preparing {
    int freeTrialId;
    IODevice.ProductId productId;

    public Preparing(int i, IODevice.ProductId productId) {
        this.freeTrialId = i;
        this.productId = productId;
    }

    public int getFreeTrialId() {
        return this.freeTrialId;
    }

    public IODevice.ProductId getProductId() {
        return this.productId;
    }
}
