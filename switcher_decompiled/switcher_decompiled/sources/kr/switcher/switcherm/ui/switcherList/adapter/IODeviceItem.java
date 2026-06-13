package kr.switcher.switcherm.ui.switcherList.adapter;

import kr.switcher.device.IODevice;
import kr.switcher.device.common.DeviceUtil;
import kr.switcher.device.switcher.interfaces.Convertible;

/* JADX INFO: loaded from: classes2.dex */
public class IODeviceItem implements Convertible {
    private String addr1;
    private String addr2;
    private String deliveryAt;
    private int freeTrialId;
    private boolean isConnected;
    private boolean isLinked;
    private boolean isScanned;
    private String macAddress;
    private int modelChangeCount;
    private String name;
    private int payPlanCode;
    private String phoneNumber;
    private IODevice.ProductId productId;
    private String serialNumber;
    private int status;
    private String switcherName;

    @Override // kr.switcher.device.switcher.interfaces.Convertible
    public Convertible convert(boolean z) {
        return this;
    }

    public IODeviceItem(IODevice.ProductId productId, String str, String str2, String str3, boolean z) {
        this.freeTrialId = 0;
        this.productId = productId;
        this.switcherName = str;
        this.macAddress = str2;
        this.serialNumber = str3;
        this.isConnected = z;
    }

    public IODeviceItem(IODevice.ProductId productId, String str, String str2, String str3, boolean z, boolean z2) {
        this.freeTrialId = 0;
        this.productId = productId;
        this.switcherName = str;
        this.macAddress = str2;
        this.serialNumber = str3;
        this.isConnected = z;
        this.isScanned = z2;
    }

    public IODeviceItem(IODevice.ProductId productId, String str, String str2, String str3, boolean z, boolean z2, boolean z3) {
        this.freeTrialId = 0;
        this.productId = productId;
        this.switcherName = str;
        this.macAddress = str2;
        this.serialNumber = str3;
        this.isConnected = z;
        this.isScanned = z2;
        this.isLinked = z3;
    }

    public IODeviceItem(IODevice.ProductId productId, String str, String str2, String str3, int i, boolean z) {
        this.freeTrialId = 0;
        this.productId = productId;
        this.switcherName = str;
        this.macAddress = str2;
        this.serialNumber = str3;
        this.payPlanCode = i;
        this.isConnected = z;
    }

    public IODeviceItem(IODevice.ProductId productId, String str, String str2, String str3, int i, boolean z, boolean z2, int i2) {
        this.freeTrialId = 0;
        this.productId = productId;
        this.switcherName = str;
        this.macAddress = str2;
        this.serialNumber = str3;
        this.payPlanCode = i;
        this.isConnected = z;
        this.isScanned = z2;
        this.status = i2;
    }

    public IODeviceItem(int i, IODevice.ProductId productId, String str, String str2, String str3, String str4, String str5) {
        this(i, productId);
        this.name = str;
        this.phoneNumber = str2;
        this.addr1 = str3;
        this.addr2 = str4;
        this.deliveryAt = str5;
    }

    public IODeviceItem(int i, IODevice.ProductId productId) {
        this.freeTrialId = i;
        this.productId = productId;
        this.switcherName = DeviceUtil.getDefaultDeviceName(productId);
        this.isScanned = false;
    }

    public String getSwitcherName() {
        return this.switcherName;
    }

    public void setSwitcherName(String str) {
        this.switcherName = str;
    }

    @Override // kr.switcher.device.switcher.interfaces.Convertible
    public String getMacAddress() {
        return this.macAddress;
    }

    public void setMacAddress(String str) {
        this.macAddress = str;
    }

    public String getSerialNumber() {
        return this.serialNumber;
    }

    public void setSerialNumber(String str) {
        this.serialNumber = str;
    }

    public IODevice.ProductId getProductId() {
        return this.productId;
    }

    public void setProductId(IODevice.ProductId productId) {
        this.productId = productId;
    }

    public int getPayPlanCode() {
        return this.payPlanCode;
    }

    public void setPayPlanCode(int i) {
        this.payPlanCode = i;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public boolean isConnected() {
        return this.isConnected;
    }

    public void setIsConnected(boolean z) {
        this.isConnected = z;
    }

    public boolean isScanned() {
        return this.isScanned;
    }

    public void setScanned(boolean z) {
        this.isScanned = z;
    }

    public int getFreeTrialId() {
        return this.freeTrialId;
    }

    public void setFreeTrialId(int i) {
        this.freeTrialId = i;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String str) {
        this.phoneNumber = str;
    }

    public String getAddr1() {
        return this.addr1;
    }

    public void setAddr1(String str) {
        this.addr1 = str;
    }

    public String getAddr2() {
        return this.addr2;
    }

    public void setAddr2(String str) {
        this.addr2 = str;
    }

    public String getDeliveryAt() {
        return this.deliveryAt;
    }

    public void setDeliveryAt(String str) {
        this.deliveryAt = str;
    }

    public int getModelChangeCount() {
        return this.modelChangeCount;
    }

    public void setModelChangeCount(int i) {
        this.modelChangeCount = i;
    }

    public boolean isLinked() {
        return this.isLinked;
    }

    public void setLinked(boolean z) {
        this.isLinked = z;
    }

    public String toString() {
        return this.macAddress;
    }

    public boolean equals(Object obj) {
        return this.macAddress.equalsIgnoreCase(((IODeviceItem) obj).getMacAddress());
    }

    public void rename(String str) {
        this.serialNumber = str;
    }
}
