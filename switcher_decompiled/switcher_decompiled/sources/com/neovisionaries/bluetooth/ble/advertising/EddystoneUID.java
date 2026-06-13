package com.neovisionaries.bluetooth.ble.advertising;

import com.neovisionaries.bluetooth.ble.advertising.Eddystone;
import com.neovisionaries.bluetooth.ble.util.Bytes;

/* JADX INFO: loaded from: classes.dex */
public class EddystoneUID extends Eddystone {
    private static final String STRING_FORMAT = "EddyStoneUID(TxPower=%d,NamespaceId=%s,InstanceId=%s)";
    private static final long serialVersionUID = 1;
    private transient byte[] mBeaconId;
    private transient String mBeaconIdAsString;
    private transient byte[] mInstanceId;
    private transient String mInstanceIdAsString;
    private transient byte[] mNamespaceId;
    private transient String mNamespaceIdAsString;
    private transient String mString;
    private final int mTxPower;

    public EddystoneUID() {
        this(23, 22, new byte[]{-86, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
    }

    public EddystoneUID(int i, int i2, byte[] bArr) {
        super(i, i2, bArr, Eddystone.FrameType.UID);
        this.mTxPower = extractTxPower(bArr);
    }

    private int extractTxPower(byte[] bArr) {
        if (4 <= bArr.length) {
            return bArr[3];
        }
        return 0;
    }

    public int getTxPower() {
        return this.mTxPower;
    }

    public byte[] getNamespaceId() {
        if (this.mNamespaceId == null) {
            this.mNamespaceId = Bytes.copyOfRange(getData(), 4, 14);
        }
        return this.mNamespaceId;
    }

    public String getNamespaceIdAsString() {
        if (this.mNamespaceIdAsString == null) {
            this.mNamespaceIdAsString = Bytes.toHexString(getNamespaceId(), true);
        }
        return this.mNamespaceIdAsString;
    }

    public byte[] getInstanceId() {
        if (this.mInstanceId == null) {
            this.mInstanceId = Bytes.copyOfRange(getData(), 14, 20);
        }
        return this.mInstanceId;
    }

    public String getInstanceIdAsString() {
        if (this.mInstanceIdAsString == null) {
            this.mInstanceIdAsString = Bytes.toHexString(getInstanceId(), true);
        }
        return this.mInstanceIdAsString;
    }

    public byte[] getBeaconId() {
        if (this.mBeaconId == null) {
            this.mBeaconId = Bytes.copyOfRange(getData(), 4, 20);
        }
        return this.mBeaconId;
    }

    public String getBeaconIdAsString() {
        if (this.mBeaconIdAsString == null) {
            this.mBeaconIdAsString = Bytes.toHexString(getBeaconId(), true);
        }
        return this.mBeaconIdAsString;
    }

    @Override // com.neovisionaries.bluetooth.ble.advertising.Eddystone, com.neovisionaries.bluetooth.ble.advertising.ServiceData, com.neovisionaries.bluetooth.ble.advertising.ADStructure
    public String toString() {
        String str = this.mString;
        if (str != null) {
            return str;
        }
        String str2 = String.format(STRING_FORMAT, Integer.valueOf(this.mTxPower), getNamespaceIdAsString(), getInstanceIdAsString());
        this.mString = str2;
        return str2;
    }
}
