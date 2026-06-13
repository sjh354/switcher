package com.neovisionaries.bluetooth.ble.advertising;

import androidx.work.Data;
import java.util.regex.Pattern;
import kotlin.UByte;

/* JADX INFO: loaded from: classes.dex */
public class Ucode extends ADManufacturerSpecific {
    private static final int COUNT_INDEX = 21;
    private static final int LOW_BATTERY_BIT = 32;
    private static final int POWER_INDEX = 20;
    private static final int STATUS_INDEX = 19;
    private static final String STRING_FORMAT = "ucode(Version=%d,Ucode=%s,Status=%d,BatteryLow=%s,Interval=%d,Power=%d,Count=%d)";
    private static final String UCODE_FORMAT = "%02X%02X%02X%02X%02X%02X%02X%02X%02X%02X%02X%02X%02X%02X%02X%02X";
    private static final int UCODE_INDEX = 3;
    private static final Pattern UCODE_PATTERN = Pattern.compile("^[0-9A-Fa-f]{32}$");
    private static final int VERSION_INDEX = 2;
    private static final long serialVersionUID = 1;
    private int mCount;
    private int mPower;
    private int mStatus;
    private String mUcode;
    private int mVersion;

    private int toInt(char c) {
        if ('0' <= c && c <= '9') {
            return c - '0';
        }
        char c2 = 'A';
        if ('A' > c || c > 'F') {
            c2 = 'a';
            if ('a' > c || c > 'f') {
                return 0;
            }
        }
        return (c - c2) + 10;
    }

    public Ucode() {
        this(26, 255, new byte[]{-102, 1, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 410);
    }

    public Ucode(int i, int i2, byte[] bArr, int i3) {
        super(i, i2, bArr, i3);
        parse(bArr);
    }

    public int getVersion() {
        return this.mVersion;
    }

    public void setVersion(int i) {
        if (i < 0 || 255 < i) {
            throw new IllegalArgumentException("'version' is out of the valid range: " + i);
        }
        this.mVersion = i;
        getData()[2] = (byte) (i & 255);
    }

    public String getUcode() {
        return this.mUcode;
    }

    public void setUcode(String str) {
        if (str == null) {
            throw new IllegalArgumentException("'ucode' is null.");
        }
        if (!UCODE_PATTERN.matcher(str).matches()) {
            throw new IllegalArgumentException("The format of 'ucode' is wrong: " + str);
        }
        this.mUcode = str;
        byte[] data = getData();
        for (int i = 0; i < 32; i += 2) {
            data[(15 - (i / 2)) + 3] = readHex(str, i);
        }
    }

    private byte readHex(String str, int i) {
        return (byte) ((toInt(str.charAt(i + 1)) | (toInt(str.charAt(i)) << 4)) & 255);
    }

    public int getStatus() {
        return this.mStatus;
    }

    public void setStatus(int i) {
        this.mStatus = i;
        getData()[19] = (byte) (i & 255);
    }

    public boolean isBatteryLow() {
        return (this.mStatus & 32) != 0;
    }

    public int getInterval() {
        switch (this.mStatus & 15) {
            case 0:
                return 10;
            case 1:
                return 20;
            case 2:
                return 40;
            case 3:
                return 80;
            case 4:
                return 160;
            case 5:
                return 320;
            case 6:
                return 640;
            case 7:
                return 1280;
            case 8:
                return 2560;
            case 9:
                return 5120;
            default:
                return Data.MAX_DATA_BYTES;
        }
    }

    public int getPower() {
        return this.mPower;
    }

    public void setPower(int i) {
        if (i < -128 || 127 < i) {
            throw new IllegalArgumentException("'power' is out of the valid range: " + i);
        }
        this.mPower = i;
        getData()[20] = (byte) i;
    }

    public int getCount() {
        return this.mCount;
    }

    public void setCount(int i) {
        if (i < 0 || 255 < i) {
            throw new IllegalArgumentException("'count' is out of the valid range: " + i);
        }
        this.mCount = i;
        getData()[21] = (byte) i;
    }

    private void parse(byte[] bArr) {
        if (bArr == null || bArr.length < 22) {
            throw new IllegalArgumentException("The byte sequence cannot be parsed as a ucode.");
        }
        this.mVersion = buildVersion(bArr);
        this.mUcode = buildUcode(bArr);
        this.mStatus = buildStatus(bArr);
        this.mPower = buildPower(bArr);
        this.mCount = buildCount(bArr);
    }

    private int buildVersion(byte[] bArr) {
        return bArr[2] & UByte.MAX_VALUE;
    }

    private String buildUcode(byte[] bArr) {
        return String.format(UCODE_FORMAT, Integer.valueOf(bArr[18] & UByte.MAX_VALUE), Integer.valueOf(bArr[17] & UByte.MAX_VALUE), Integer.valueOf(bArr[16] & UByte.MAX_VALUE), Integer.valueOf(bArr[15] & UByte.MAX_VALUE), Integer.valueOf(bArr[14] & UByte.MAX_VALUE), Integer.valueOf(bArr[13] & UByte.MAX_VALUE), Integer.valueOf(bArr[12] & UByte.MAX_VALUE), Integer.valueOf(bArr[11] & UByte.MAX_VALUE), Integer.valueOf(bArr[10] & UByte.MAX_VALUE), Integer.valueOf(bArr[9] & UByte.MAX_VALUE), Integer.valueOf(bArr[8] & UByte.MAX_VALUE), Integer.valueOf(bArr[7] & UByte.MAX_VALUE), Integer.valueOf(bArr[6] & UByte.MAX_VALUE), Integer.valueOf(bArr[5] & UByte.MAX_VALUE), Integer.valueOf(bArr[4] & UByte.MAX_VALUE), Integer.valueOf(bArr[3] & UByte.MAX_VALUE));
    }

    private int buildStatus(byte[] bArr) {
        return bArr[19] & UByte.MAX_VALUE;
    }

    private int buildPower(byte[] bArr) {
        return bArr[20];
    }

    private int buildCount(byte[] bArr) {
        return bArr[21] & UByte.MAX_VALUE;
    }

    public static Ucode create(int i, int i2, byte[] bArr, int i3) {
        if (bArr == null || bArr.length < 22) {
            return null;
        }
        return new Ucode(i, i2, bArr, i3);
    }

    @Override // com.neovisionaries.bluetooth.ble.advertising.ADManufacturerSpecific, com.neovisionaries.bluetooth.ble.advertising.ADStructure
    public String toString() {
        return String.format(STRING_FORMAT, Integer.valueOf(this.mVersion), this.mUcode, Integer.valueOf(this.mStatus), Boolean.valueOf(isBatteryLow()), Integer.valueOf(getInterval()), Integer.valueOf(this.mPower), Integer.valueOf(this.mCount));
    }
}
