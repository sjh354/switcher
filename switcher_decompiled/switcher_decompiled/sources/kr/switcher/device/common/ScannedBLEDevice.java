package kr.switcher.device.common;

import android.bluetooth.BluetoothDevice;
import android.os.Parcel;
import android.os.Parcelable;
import kr.switcher.ioble.scanner.AdvertisementPacket;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ScannedBLEDevice implements Parcelable, Comparable<ScannedBLEDevice> {
    protected AdvertisementPacket advertisementPacket;
    protected BluetoothDevice device;
    protected int rssi;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ScannedBLEDevice(BluetoothDevice bluetoothDevice, AdvertisementPacket advertisementPacket) {
        this.device = bluetoothDevice;
        this.advertisementPacket = advertisementPacket;
    }

    public ScannedBLEDevice(BluetoothDevice bluetoothDevice, AdvertisementPacket advertisementPacket, int i) {
        this.device = bluetoothDevice;
        this.advertisementPacket = advertisementPacket;
        this.rssi = i;
    }

    protected ScannedBLEDevice(Parcel parcel) {
        this.device = (BluetoothDevice) parcel.readParcelable(BluetoothDevice.class.getClassLoader());
        this.advertisementPacket = (AdvertisementPacket) parcel.readParcelable(AdvertisementPacket.class.getClassLoader());
    }

    public BluetoothDevice getDevice() {
        return this.device;
    }

    public AdvertisementPacket getAdvertisementPacket() {
        return this.advertisementPacket;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.device, i);
        parcel.writeParcelable(this.advertisementPacket, i);
    }

    public boolean equals(Object obj) {
        return getDevice().getAddress().equals(((ScannedBLEDevice) obj).getDevice().getAddress());
    }

    @Override // java.lang.Comparable
    public int compareTo(ScannedBLEDevice scannedBLEDevice) {
        int i;
        int i2;
        if (scannedBLEDevice == null || (i = this.rssi) == (i2 = scannedBLEDevice.rssi)) {
            return 0;
        }
        if (i < i2) {
            return 1;
        }
        return i > i2 ? -1 : 0;
    }
}
