package com.neovisionaries.bluetooth.ble.advertising;

import com.neovisionaries.bluetooth.ble.advertising.Eddystone;
import com.neovisionaries.bluetooth.ble.util.Bytes;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;

/* JADX INFO: loaded from: classes.dex */
public class EddystoneTLM extends Eddystone {
    private static final String STRING_FORMAT = "EddystoneTLM(Version=%d,BatteryVoltage=%d,BeaconTemperature=%f,AdvertisementCount=%d,ElapsedTime=%d)";
    private static final long serialVersionUID = 1;
    private final long mAdvertisementCount;
    private final int mBatteryVoltage;
    private final float mBeaconTemperature;
    private final long mElapsedTime;
    private transient String mString;
    private final int mTLMVersion;

    public EddystoneTLM() {
        this(17, 22, new byte[]{-86, -2, 32, 0, 0, 0, ByteCompanionObject.MIN_VALUE, 0, 0, 0, 0, 0, 0, 0, 0, 0});
    }

    public EddystoneTLM(int i, int i2, byte[] bArr) {
        super(i, i2, bArr, Eddystone.FrameType.TLM);
        this.mTLMVersion = extractTLMVersion(bArr);
        this.mBatteryVoltage = extractBatteryVoltage(bArr);
        this.mBeaconTemperature = extractBeaconTemperature(bArr);
        this.mAdvertisementCount = extractAdvertisementCount(bArr);
        this.mElapsedTime = extractElapsedTime(bArr);
    }

    private int extractTLMVersion(byte[] bArr) {
        if (bArr.length < 4) {
            return 0;
        }
        return bArr[3] & UByte.MAX_VALUE;
    }

    private int extractBatteryVoltage(byte[] bArr) {
        if (bArr.length < 6) {
            return 0;
        }
        return Bytes.parseBE2BytesAsInt(bArr, 4);
    }

    private float extractBeaconTemperature(byte[] bArr) {
        if (bArr.length < 8) {
            return -128.0f;
        }
        return Bytes.convertFixedPointToFloat(bArr, 6);
    }

    private long extractAdvertisementCount(byte[] bArr) {
        if (bArr.length < 12) {
            return 0L;
        }
        return Bytes.parseBE4BytesAsUnsigned(bArr, 8);
    }

    private long extractElapsedTime(byte[] bArr) {
        if (bArr.length < 16) {
            return 0L;
        }
        return Bytes.parseBE4BytesAsUnsigned(bArr, 12) * 100;
    }

    public int getTLMVersion() {
        return this.mTLMVersion;
    }

    public int getBatteryVoltage() {
        return this.mBatteryVoltage;
    }

    public float getBeaconTemperature() {
        return this.mBeaconTemperature;
    }

    public long getAdvertisementCount() {
        return this.mAdvertisementCount;
    }

    public long getElapsedTime() {
        return this.mElapsedTime;
    }

    @Override // com.neovisionaries.bluetooth.ble.advertising.Eddystone, com.neovisionaries.bluetooth.ble.advertising.ServiceData, com.neovisionaries.bluetooth.ble.advertising.ADStructure
    public String toString() {
        String str = this.mString;
        if (str != null) {
            return str;
        }
        String str2 = String.format(STRING_FORMAT, Integer.valueOf(this.mTLMVersion), Integer.valueOf(this.mBatteryVoltage), Float.valueOf(this.mBeaconTemperature), Long.valueOf(this.mAdvertisementCount), Long.valueOf(this.mElapsedTime));
        this.mString = str2;
        return str2;
    }
}
