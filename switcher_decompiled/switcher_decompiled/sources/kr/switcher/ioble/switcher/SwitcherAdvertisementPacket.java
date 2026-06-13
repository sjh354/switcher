package kr.switcher.ioble.switcher;

import android.os.Parcel;
import android.os.Parcelable;
import com.neovisionaries.bluetooth.ble.advertising.ADPayloadParser;
import com.neovisionaries.bluetooth.ble.advertising.ADStructure;
import kr.switcher.ioble.common.BLEUtil;
import kr.switcher.ioble.scanner.AdvertisementPacket;

/* JADX INFO: loaded from: classes2.dex */
public class SwitcherAdvertisementPacket extends AdvertisementPacket {
    public static final Parcelable.Creator<SwitcherAdvertisementPacket> CREATOR = new Parcelable.Creator<SwitcherAdvertisementPacket>() { // from class: kr.switcher.ioble.switcher.SwitcherAdvertisementPacket.1
        @Override // android.os.Parcelable.Creator
        public SwitcherAdvertisementPacket createFromParcel(Parcel parcel) {
            return new SwitcherAdvertisementPacket(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public SwitcherAdvertisementPacket[] newArray(int i) {
            return new SwitcherAdvertisementPacket[i];
        }
    };
    String macAddress;
    String serialNumber;
    int switcherType;
    String timerVersion;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public SwitcherAdvertisementPacket(byte[] bArr) throws Exception {
        for (ADStructure aDStructure : ADPayloadParser.getInstance().parse(bArr)) {
            if (255 == aDStructure.getType()) {
                String strBytesToHex = BLEUtil.bytesToHex(aDStructure.getData());
                this.macAddress = strBytesToHex.substring(0, 12);
                this.serialNumber = strBytesToHex.substring(13, 14) + strBytesToHex.substring(15, 16) + strBytesToHex.substring(17, 18) + strBytesToHex.substring(19, 20) + strBytesToHex.substring(21, 22) + strBytesToHex.substring(23, 24) + strBytesToHex.substring(25, 26) + strBytesToHex.substring(27, 28);
                this.switcherType = Integer.parseInt(strBytesToHex.substring(28, 30));
                this.timerVersion = strBytesToHex.substring(30);
                return;
            }
        }
    }

    protected SwitcherAdvertisementPacket(Parcel parcel) {
        this.macAddress = parcel.readString();
        this.serialNumber = parcel.readString();
        this.switcherType = parcel.readInt();
        this.timerVersion = parcel.readString();
    }

    public String getMacAddress() {
        return this.macAddress;
    }

    public int getSwitcherType() {
        return this.switcherType;
    }

    public String getSerialNumber() {
        return this.serialNumber;
    }

    public String getTimerVersion() {
        return this.timerVersion;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.macAddress);
        parcel.writeString(this.serialNumber);
        parcel.writeInt(this.switcherType);
        parcel.writeString(this.timerVersion);
    }
}
