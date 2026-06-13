package kr.switcher.device;

import kr.switcher.device.common.ScannedBLEDevice;
import kr.switcher.device.switcher.interfaces.IODeviceCallbacks;
import kr.switcher.device.switcher.option.DeviceOption;

/* JADX INFO: loaded from: classes2.dex */
public class IODevice {
    protected boolean isMine;
    protected IODeviceCallbacks.OnDeviceConnectListener listener;
    protected String macAddress;
    protected String name;
    protected DeviceOption option;
    protected String owner;
    protected ProductId productId;
    protected ScannedBLEDevice scannedBLEDevice;
    protected String serialNumber;
    protected String shareCode;
    protected ThingConnectionStatus thingConnectionStatus;

    public enum ProductId {
        SWITCHER_TYPE_ONE,
        SWITCHER_TYPE_TWO,
        LINKER,
        REMOCON,
        CHECKER
    }

    public enum ThingConnectionStatus {
        UNKNOWN,
        ALIVE,
        DEAD
    }

    public void disconnect() {
    }

    public IODevice() {
        this.macAddress = "";
        this.serialNumber = "";
        this.name = "";
        this.owner = "";
        this.isMine = true;
        this.thingConnectionStatus = ThingConnectionStatus.UNKNOWN;
        this.option = new DeviceOption();
    }

    public IODevice(String str) {
        this.macAddress = "";
        this.serialNumber = "";
        this.name = "";
        this.owner = "";
        this.isMine = true;
        this.thingConnectionStatus = ThingConnectionStatus.UNKNOWN;
        this.macAddress = str;
    }

    public IODevice(String str, String str2, ProductId productId) {
        this.macAddress = "";
        this.serialNumber = "";
        this.name = "";
        this.owner = "";
        this.isMine = true;
        this.thingConnectionStatus = ThingConnectionStatus.UNKNOWN;
        this.macAddress = str;
        this.serialNumber = str2;
        this.productId = productId;
        this.option = new DeviceOption();
    }

    public IODevice(String str, ScannedBLEDevice scannedBLEDevice) {
        this.macAddress = "";
        this.serialNumber = "";
        this.name = "";
        this.owner = "";
        this.isMine = true;
        this.thingConnectionStatus = ThingConnectionStatus.UNKNOWN;
        this.scannedBLEDevice = scannedBLEDevice;
    }

    public String getMacAddress() {
        return this.macAddress;
    }

    public String getSerialNumber() {
        return this.serialNumber;
    }

    public String getName() {
        return this.name;
    }

    public void beGuest() {
        this.isMine = false;
    }

    public boolean isMine() {
        return this.isMine;
    }

    public ProductId getProductId() {
        return this.productId;
    }

    public DeviceOption getOption() {
        return this.option;
    }

    public String getOwner() {
        return this.owner;
    }

    public String getShareCode() {
        return this.shareCode;
    }

    public void setMacAddress(String str) {
        this.macAddress = str;
    }

    public void setSerialNumber(String str) {
        this.serialNumber = str;
    }

    public void setProductId(ProductId productId) {
        this.productId = productId;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setOwner(String str) {
        this.owner = str;
    }

    public void setShareCode(String str) {
        this.shareCode = str;
    }

    public void setMine(boolean z) {
        this.isMine = z;
    }

    public void setOption(DeviceOption deviceOption) {
        this.option = deviceOption;
    }

    public ThingConnectionStatus getThingConnectionStatus() {
        return this.thingConnectionStatus;
    }

    public void setThingConnectionStatus(ThingConnectionStatus thingConnectionStatus) {
        this.thingConnectionStatus = thingConnectionStatus;
    }

    public ScannedBLEDevice getAttachedDevice() {
        return this.scannedBLEDevice;
    }

    public void attachToDevice(ScannedBLEDevice scannedBLEDevice) {
        this.scannedBLEDevice = scannedBLEDevice;
    }

    public int connect(IODeviceCallbacks.OnDeviceConnectListener onDeviceConnectListener) {
        this.listener = onDeviceConnectListener;
        return 1;
    }

    public void setSwitcherConnectListener(IODeviceCallbacks.OnDeviceConnectListener onDeviceConnectListener) {
        this.listener = onDeviceConnectListener;
    }
}
