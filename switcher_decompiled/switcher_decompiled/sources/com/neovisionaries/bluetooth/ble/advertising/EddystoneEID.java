package com.neovisionaries.bluetooth.ble.advertising;

import com.neovisionaries.bluetooth.ble.advertising.Eddystone;
import com.neovisionaries.bluetooth.ble.util.Bytes;

/* JADX INFO: loaded from: classes.dex */
public class EddystoneEID extends Eddystone {
    private static final String STRING_FORMAT = "EddyStoneEID(TxPower=%d,EID=%s)";
    private static final long serialVersionUID = 1;
    private transient byte[] mEID;
    private transient String mEIDAsString;
    private transient String mString;
    private final int mTxPower;

    public EddystoneEID() {
        this(13, 22, new byte[]{-86, -2, 48, 0, 0, 0, 0, 0, 0, 0, 0, 0});
    }

    public EddystoneEID(int i, int i2, byte[] bArr) {
        super(i, i2, bArr, Eddystone.FrameType.EID);
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

    public byte[] getEID() {
        if (this.mEID == null) {
            this.mEID = Bytes.copyOfRange(getData(), 4, 12);
        }
        return this.mEID;
    }

    public String getEIDAsString() {
        if (this.mEIDAsString == null) {
            this.mEIDAsString = Bytes.toHexString(getEID(), true);
        }
        return this.mEIDAsString;
    }

    @Override // com.neovisionaries.bluetooth.ble.advertising.Eddystone, com.neovisionaries.bluetooth.ble.advertising.ServiceData, com.neovisionaries.bluetooth.ble.advertising.ADStructure
    public String toString() {
        if (this.mString == null) {
            this.mString = String.format(STRING_FORMAT, Integer.valueOf(this.mTxPower), getEIDAsString());
        }
        return this.mString;
    }
}
