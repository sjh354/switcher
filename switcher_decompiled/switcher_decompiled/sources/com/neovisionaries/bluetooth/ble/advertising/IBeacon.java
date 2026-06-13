package com.neovisionaries.bluetooth.ble.advertising;

import com.neovisionaries.bluetooth.ble.util.Bytes;
import com.neovisionaries.bluetooth.ble.util.UUIDCreator;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public class IBeacon extends ADManufacturerSpecific {
    private static final int MAJOR_INDEX = 20;
    private static final int MINOR_INDEX = 22;
    private static final int POWER_INDEX = 24;
    private static final String STRING_FORMAT = "iBeacon(UUID=%s,Major=%d,Minor=%d,Power=%d)";
    private static final int UUID_INDEX = 4;
    private static final long serialVersionUID = 2;
    private int mMajor;
    private int mMinor;
    private int mPower;
    private UUID mUUID;

    public IBeacon() {
        this(26, 255, new byte[]{76, 0, 2, 21, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 76);
    }

    public IBeacon(int i, int i2, byte[] bArr, int i3) {
        super(i, i2, bArr, i3);
        parse(bArr);
    }

    public UUID getUUID() {
        return this.mUUID;
    }

    public void setUUID(UUID uuid) {
        if (uuid == null) {
            throw new IllegalArgumentException("'uuid' is null.");
        }
        this.mUUID = uuid;
        long mostSignificantBits = uuid.getMostSignificantBits();
        long leastSignificantBits = uuid.getLeastSignificantBits();
        byte[] data = getData();
        data[4] = (byte) ((mostSignificantBits >> 56) & 255);
        data[5] = (byte) ((mostSignificantBits >> 48) & 255);
        data[6] = (byte) ((mostSignificantBits >> 40) & 255);
        data[7] = (byte) ((mostSignificantBits >> 32) & 255);
        data[8] = (byte) ((mostSignificantBits >> 24) & 255);
        data[9] = (byte) ((mostSignificantBits >> 16) & 255);
        data[10] = (byte) ((mostSignificantBits >> 8) & 255);
        data[11] = (byte) (mostSignificantBits & 255);
        data[12] = (byte) ((leastSignificantBits >> 56) & 255);
        data[13] = (byte) ((leastSignificantBits >> 48) & 255);
        data[14] = (byte) ((leastSignificantBits >> 40) & 255);
        data[15] = (byte) ((leastSignificantBits >> 32) & 255);
        data[16] = (byte) ((leastSignificantBits >> 24) & 255);
        data[17] = (byte) ((leastSignificantBits >> 16) & 255);
        data[18] = (byte) ((leastSignificantBits >> 8) & 255);
        data[19] = (byte) ((leastSignificantBits >> 0) & 255);
    }

    public int getMajor() {
        return this.mMajor;
    }

    public void setMajor(int i) {
        if (i < 0 || 65535 < i) {
            throw new IllegalArgumentException("'major' is out of the valid range: " + i);
        }
        this.mMajor = i;
        byte[] data = getData();
        data[20] = (byte) ((i >> 8) & 255);
        data[21] = (byte) (i & 255);
    }

    public int getMinor() {
        return this.mMinor;
    }

    public void setMinor(int i) {
        if (i < 0 || 65535 < i) {
            throw new IllegalArgumentException("'minor' is out of the valid range: " + i);
        }
        this.mMinor = i;
        byte[] data = getData();
        data[22] = (byte) ((i >> 8) & 255);
        data[23] = (byte) (i & 255);
    }

    public int getPower() {
        return this.mPower;
    }

    public void setPower(int i) {
        if (i < -128 || 127 < i) {
            throw new IllegalArgumentException("'power' is out of the valid range: " + i);
        }
        this.mPower = i;
        getData()[24] = (byte) (i & 255);
    }

    private void parse(byte[] bArr) {
        if (bArr == null || bArr.length < 25) {
            throw new IllegalArgumentException("The byte sequence cannot be parsed as an iBeacon.");
        }
        this.mUUID = buildUUID(bArr);
        this.mMajor = buildMajor(bArr);
        this.mMinor = buildMinor(bArr);
        this.mPower = buildPower(bArr);
    }

    private UUID buildUUID(byte[] bArr) {
        return UUIDCreator.from128(bArr, 4, false);
    }

    private int buildMajor(byte[] bArr) {
        return Bytes.parseBE2BytesAsInt(bArr, 20);
    }

    private int buildMinor(byte[] bArr) {
        return Bytes.parseBE2BytesAsInt(bArr, 22);
    }

    private int buildPower(byte[] bArr) {
        return bArr[24];
    }

    public static IBeacon create(int i, int i2, byte[] bArr, int i3) {
        if (bArr == null || bArr.length < 25) {
            return null;
        }
        return new IBeacon(i, i2, bArr, i3);
    }

    @Override // com.neovisionaries.bluetooth.ble.advertising.ADManufacturerSpecific, com.neovisionaries.bluetooth.ble.advertising.ADStructure
    public String toString() {
        return String.format(STRING_FORMAT, this.mUUID, Integer.valueOf(this.mMajor), Integer.valueOf(this.mMinor), Integer.valueOf(this.mPower));
    }
}
