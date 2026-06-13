package com.neovisionaries.bluetooth.ble.util;

import kotlin.UByte;

/* JADX INFO: loaded from: classes.dex */
public class Bytes {
    private static final char[] UPPER_HEX_CHARS = "0123456789ABCDEF".toCharArray();
    private static final char[] LOWER_HEX_CHARS = "0123456789abcdef".toCharArray();

    private Bytes() {
    }

    public static int parseBE2BytesAsInt(byte[] bArr, int i) {
        return ((bArr[i + 1] & UByte.MAX_VALUE) << 0) | ((bArr[i + 0] & UByte.MAX_VALUE) << 8);
    }

    public static int parseBE4BytesAsInt(byte[] bArr, int i) {
        return (bArr[i + 3] & UByte.MAX_VALUE) | ((bArr[i + 0] & UByte.MAX_VALUE) << 24) | ((bArr[i + 1] & UByte.MAX_VALUE) << 16) | ((bArr[i + 2] & UByte.MAX_VALUE) << 8);
    }

    public static long parseBE4BytesAsUnsigned(byte[] bArr, int i) {
        return (((long) (bArr[i + 3] & UByte.MAX_VALUE)) << 0) | (((long) (bArr[i + 0] & UByte.MAX_VALUE)) << 24) | (((long) (bArr[i + 1] & UByte.MAX_VALUE)) << 16) | (((long) (bArr[i + 2] & UByte.MAX_VALUE)) << 8);
    }

    public static float convertFixedPointToFloat(byte[] bArr, int i) {
        return bArr[i] + ((bArr[i + 1] & UByte.MAX_VALUE) / 256.0f);
    }

    public static String toHexString(byte[] bArr, boolean z) {
        if (bArr == null) {
            return null;
        }
        char[] cArr = z ? UPPER_HEX_CHARS : LOWER_HEX_CHARS;
        char[] cArr2 = new char[bArr.length * 2];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = i * 2;
            byte b = bArr[i];
            cArr2[i2] = cArr[(b & 240) >> 4];
            cArr2[i2 + 1] = cArr[b & 15];
        }
        return new String(cArr2);
    }

    public static byte[] copyOfRange(byte[] bArr, int i, int i2) {
        int i3;
        if (bArr == null || i < 0 || i2 < 0 || (i3 = i2 - i) < 0 || bArr.length < i + i3) {
            return null;
        }
        byte[] bArr2 = new byte[i3];
        System.arraycopy(bArr, i, bArr2, 0, i3);
        return bArr2;
    }
}
