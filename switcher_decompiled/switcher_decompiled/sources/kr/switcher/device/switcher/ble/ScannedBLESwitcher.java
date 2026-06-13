package kr.switcher.device.switcher.ble;

import android.bluetooth.BluetoothDevice;
import android.os.Parcel;
import android.os.Parcelable;
import kr.switcher.device.common.ScannedBLEDevice;
import kr.switcher.ioble.scanner.AdvertisementPacket;
import kr.switcher.ioble.switcher.SwitcherAdvertisementPacket;

/* JADX INFO: loaded from: classes2.dex */
public class ScannedBLESwitcher extends ScannedBLEDevice {
    public static final Parcelable.Creator<ScannedBLESwitcher> CREATOR = new Parcelable.Creator<ScannedBLESwitcher>() { // from class: kr.switcher.device.switcher.ble.ScannedBLESwitcher.1
        @Override // android.os.Parcelable.Creator
        public ScannedBLESwitcher createFromParcel(Parcel parcel) {
            return new ScannedBLESwitcher(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public ScannedBLESwitcher[] newArray(int i) {
            return new ScannedBLESwitcher[i];
        }
    };

    public ScannedBLESwitcher(BluetoothDevice bluetoothDevice, AdvertisementPacket advertisementPacket) {
        super(bluetoothDevice, advertisementPacket);
    }

    public ScannedBLESwitcher(BluetoothDevice bluetoothDevice, AdvertisementPacket advertisementPacket, int i) {
        super(bluetoothDevice, advertisementPacket, i);
    }

    protected ScannedBLESwitcher(Parcel parcel) {
        super(parcel);
    }

    @Override // kr.switcher.device.common.ScannedBLEDevice
    public SwitcherAdvertisementPacket getAdvertisementPacket() {
        return (SwitcherAdvertisementPacket) super.getAdvertisementPacket();
    }
}
