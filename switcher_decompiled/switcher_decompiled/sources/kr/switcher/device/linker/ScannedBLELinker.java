package kr.switcher.device.linker;

import android.bluetooth.BluetoothDevice;
import android.os.Parcel;
import android.os.Parcelable;
import kr.switcher.device.common.ScannedBLEDevice;
import kr.switcher.ioble.linker.LinkerAdvertisementPacket;
import kr.switcher.ioble.scanner.AdvertisementPacket;

/* JADX INFO: loaded from: classes2.dex */
public class ScannedBLELinker extends ScannedBLEDevice {
    public static final Parcelable.Creator<ScannedBLELinker> CREATOR = new Parcelable.Creator<ScannedBLELinker>() { // from class: kr.switcher.device.linker.ScannedBLELinker.1
        @Override // android.os.Parcelable.Creator
        public ScannedBLELinker createFromParcel(Parcel parcel) {
            return new ScannedBLELinker(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public ScannedBLELinker[] newArray(int i) {
            return new ScannedBLELinker[i];
        }
    };

    public ScannedBLELinker(BluetoothDevice bluetoothDevice, AdvertisementPacket advertisementPacket) {
        super(bluetoothDevice, advertisementPacket);
    }

    public ScannedBLELinker(BluetoothDevice bluetoothDevice, AdvertisementPacket advertisementPacket, int i) {
        super(bluetoothDevice, advertisementPacket, i);
    }

    protected ScannedBLELinker(Parcel parcel) {
        super(parcel);
    }

    @Override // kr.switcher.device.common.ScannedBLEDevice
    public LinkerAdvertisementPacket getAdvertisementPacket() {
        return (LinkerAdvertisementPacket) super.getAdvertisementPacket();
    }
}
