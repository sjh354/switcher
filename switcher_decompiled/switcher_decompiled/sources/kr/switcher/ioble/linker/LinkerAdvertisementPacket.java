package kr.switcher.ioble.linker;

import android.os.Parcel;
import android.os.Parcelable;
import com.neovisionaries.bluetooth.ble.advertising.ADPayloadParser;
import com.neovisionaries.bluetooth.ble.advertising.ADStructure;
import kr.switcher.ioble.common.BLEUtil;
import kr.switcher.ioble.scanner.AdvertisementPacket;

/* JADX INFO: loaded from: classes2.dex */
public class LinkerAdvertisementPacket extends AdvertisementPacket {
    public static final Parcelable.Creator<LinkerAdvertisementPacket> CREATOR = new Parcelable.Creator<LinkerAdvertisementPacket>() { // from class: kr.switcher.ioble.linker.LinkerAdvertisementPacket.1
        @Override // android.os.Parcelable.Creator
        public LinkerAdvertisementPacket createFromParcel(Parcel parcel) {
            return new LinkerAdvertisementPacket(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public LinkerAdvertisementPacket[] newArray(int i) {
            return new LinkerAdvertisementPacket[i];
        }
    };
    String macAddress;
    int type;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LinkerAdvertisementPacket(byte[] bArr) throws Exception {
        for (ADStructure aDStructure : ADPayloadParser.getInstance().parse(bArr)) {
            if (255 == aDStructure.getType()) {
                String strBytesToHex = BLEUtil.bytesToHex(aDStructure.getData());
                this.macAddress = strBytesToHex.substring(0, 12);
                this.type = Integer.parseInt(strBytesToHex.substring(12, 14));
                return;
            }
        }
    }

    protected LinkerAdvertisementPacket(Parcel parcel) {
        this.macAddress = parcel.readString();
        this.type = parcel.readInt();
    }

    public String getMacAddress() {
        return this.macAddress;
    }

    public int getType() {
        return this.type;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.macAddress);
        parcel.writeInt(this.type);
    }
}
