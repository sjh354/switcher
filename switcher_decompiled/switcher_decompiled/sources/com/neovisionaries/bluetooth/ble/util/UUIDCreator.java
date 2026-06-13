package com.neovisionaries.bluetooth.ble.util;

import java.util.UUID;
import kotlin.UByte;

/* JADX INFO: loaded from: classes.dex */
public class UUIDCreator {
    private static final String BASE_UUID_FORMAT = "%02x%02x%02x%02x-0000-1000-8000-00805f9b34fb";
    private static final String GENERIC_UUID_FORMAT = "%02x%02x%02x%02x-%02x%02x-%02x%02x-%02x%02x-%02x%02x%02x%02x%02x%02x";

    private UUIDCreator() {
    }

    public static UUID from16(byte[] bArr) {
        return from16(bArr, 0);
    }

    public static UUID from16(byte[] bArr, int i) {
        return from16(bArr, i, true);
    }

    public static UUID from16(byte[] bArr, int i, boolean z) {
        int i2;
        int i3;
        byte b;
        if (bArr == null || i < 0 || bArr.length <= (i2 = i + 1) || Integer.MAX_VALUE == i) {
            return null;
        }
        if (z) {
            i3 = bArr[i2] & UByte.MAX_VALUE;
            b = bArr[i + 0];
        } else {
            i3 = bArr[i + 0] & UByte.MAX_VALUE;
            b = bArr[i2];
        }
        return fromBase(0, 0, i3, b & UByte.MAX_VALUE);
    }

    public static UUID from32(byte[] bArr) {
        return from32(bArr, 0);
    }

    public static UUID from32(byte[] bArr, int i) {
        return from32(bArr, i, true);
    }

    public static UUID from32(byte[] bArr, int i, boolean z) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        if (bArr == null || i < 0 || bArr.length <= (i2 = i + 3) || 2147483644 < i) {
            return null;
        }
        if (z) {
            i3 = bArr[i2] & UByte.MAX_VALUE;
            i4 = bArr[i + 2] & UByte.MAX_VALUE;
            i6 = bArr[i + 1] & UByte.MAX_VALUE;
            i5 = bArr[i + 0] & UByte.MAX_VALUE;
        } else {
            i3 = bArr[i + 0] & UByte.MAX_VALUE;
            i4 = bArr[i + 1] & UByte.MAX_VALUE;
            int i7 = bArr[i + 2] & UByte.MAX_VALUE;
            i5 = bArr[i2] & UByte.MAX_VALUE;
            i6 = i7;
        }
        return fromBase(i3, i4, i6, i5);
    }

    private static UUID fromBase(int i, int i2, int i3, int i4) {
        return UUID.fromString(String.format(BASE_UUID_FORMAT, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)));
    }

    public static UUID from128(byte[] bArr) {
        return from128(bArr, 0);
    }

    public static UUID from128(byte[] bArr, int i) {
        return from128(bArr, i, true);
    }

    public static UUID from128(byte[] bArr, int i, boolean z) {
        int i2;
        String str;
        if (bArr == null || i < 0 || bArr.length <= (i2 = i + 15) || 2147483632 < i) {
            return null;
        }
        if (z) {
            str = String.format(GENERIC_UUID_FORMAT, Integer.valueOf(bArr[i2] & UByte.MAX_VALUE), Integer.valueOf(bArr[i + 14] & UByte.MAX_VALUE), Integer.valueOf(bArr[i + 13] & UByte.MAX_VALUE), Integer.valueOf(bArr[i + 12] & UByte.MAX_VALUE), Integer.valueOf(bArr[i + 11] & UByte.MAX_VALUE), Integer.valueOf(bArr[i + 10] & UByte.MAX_VALUE), Integer.valueOf(bArr[i + 9] & UByte.MAX_VALUE), Integer.valueOf(bArr[i + 8] & UByte.MAX_VALUE), Integer.valueOf(bArr[i + 7] & UByte.MAX_VALUE), Integer.valueOf(bArr[i + 6] & UByte.MAX_VALUE), Integer.valueOf(bArr[i + 5] & UByte.MAX_VALUE), Integer.valueOf(bArr[i + 4] & UByte.MAX_VALUE), Integer.valueOf(bArr[i + 3] & UByte.MAX_VALUE), Integer.valueOf(bArr[i + 2] & UByte.MAX_VALUE), Integer.valueOf(bArr[i + 1] & UByte.MAX_VALUE), Integer.valueOf(bArr[i + 0] & UByte.MAX_VALUE));
        } else {
            str = String.format(GENERIC_UUID_FORMAT, Integer.valueOf(bArr[i + 0] & UByte.MAX_VALUE), Integer.valueOf(bArr[i + 1] & UByte.MAX_VALUE), Integer.valueOf(bArr[i + 2] & UByte.MAX_VALUE), Integer.valueOf(bArr[i + 3] & UByte.MAX_VALUE), Integer.valueOf(bArr[i + 4] & UByte.MAX_VALUE), Integer.valueOf(bArr[i + 5] & UByte.MAX_VALUE), Integer.valueOf(bArr[i + 6] & UByte.MAX_VALUE), Integer.valueOf(bArr[i + 7] & UByte.MAX_VALUE), Integer.valueOf(bArr[i + 8] & UByte.MAX_VALUE), Integer.valueOf(bArr[i + 9] & UByte.MAX_VALUE), Integer.valueOf(bArr[i + 10] & UByte.MAX_VALUE), Integer.valueOf(bArr[i + 11] & UByte.MAX_VALUE), Integer.valueOf(bArr[i + 12] & UByte.MAX_VALUE), Integer.valueOf(bArr[i + 13] & UByte.MAX_VALUE), Integer.valueOf(bArr[i + 14] & UByte.MAX_VALUE), Integer.valueOf(bArr[i2] & UByte.MAX_VALUE));
        }
        return UUID.fromString(str);
    }
}
