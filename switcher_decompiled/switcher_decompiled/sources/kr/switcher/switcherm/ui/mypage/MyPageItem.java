package kr.switcher.switcherm.ui.mypage;

import kr.switcher.device.IODevice;

/* JADX INFO: loaded from: classes2.dex */
public class MyPageItem {
    private int freeTrialId;
    private String ioCash;
    private String macAddress;
    private String name;
    private IODevice.ProductId productId;
    private String serialNumber;

    public MyPageItem() {
    }

    public MyPageItem(IODevice.ProductId productId, int i) {
        this.productId = productId;
        this.freeTrialId = i;
    }

    public MyPageItem(IODevice.ProductId productId, String str, String str2, String str3) {
        this.name = str3;
        this.productId = productId;
        this.serialNumber = str2;
        this.macAddress = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public IODevice.ProductId getProductId() {
        return this.productId;
    }

    public void setProductId(IODevice.ProductId productId) {
        this.productId = productId;
    }

    public String getSerialNumber() {
        return this.serialNumber;
    }

    public void setSerialNumber(String str) {
        this.serialNumber = str;
    }

    public String getMacAddress() {
        return this.macAddress;
    }

    public void setMacAddress(String str) {
        this.macAddress = str;
    }

    public int getFreeTrialId() {
        return this.freeTrialId;
    }

    public void setFreeTrialId(int i) {
        this.freeTrialId = i;
    }

    public void setIoCash(String str) {
        this.ioCash = str;
    }

    public String getIoCash() {
        return this.ioCash + "원";
    }
}
