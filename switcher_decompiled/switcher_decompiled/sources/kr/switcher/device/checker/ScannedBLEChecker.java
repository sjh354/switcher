package kr.switcher.device.checker;

import android.bluetooth.BluetoothDevice;
import android.os.Parcel;
import android.os.Parcelable;
import kr.switcher.device.common.ScannedBLEDevice;
import kr.switcher.ioble.checker.CheckerAdvertisementPacket;
import kr.switcher.ioble.scanner.AdvertisementPacket;

/* JADX INFO: loaded from: classes2.dex */
public class ScannedBLEChecker extends ScannedBLEDevice {
    public static final Parcelable.Creator<ScannedBLEChecker> CREATOR = new Parcelable.Creator<ScannedBLEChecker>() { // from class: kr.switcher.device.checker.ScannedBLEChecker.1
        @Override // android.os.Parcelable.Creator
        public ScannedBLEChecker createFromParcel(Parcel parcel) {
            return new ScannedBLEChecker(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public ScannedBLEChecker[] newArray(int i) {
            return new ScannedBLEChecker[i];
        }
    };

    public ScannedBLEChecker(BluetoothDevice bluetoothDevice, AdvertisementPacket advertisementPacket) {
        super(bluetoothDevice, advertisementPacket);
    }

    public ScannedBLEChecker(BluetoothDevice bluetoothDevice, AdvertisementPacket advertisementPacket, int i) {
        super(bluetoothDevice, advertisementPacket, i);
    }

    protected ScannedBLEChecker(Parcel parcel) {
        super(parcel);
    }

    @Override // kr.switcher.device.common.ScannedBLEDevice
    public CheckerAdvertisementPacket getAdvertisementPacket() {
        return (CheckerAdvertisementPacket) super.getAdvertisementPacket();
    }
}
