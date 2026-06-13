package com.neovisionaries.bluetooth.ble.advertising;

import kotlin.UByte;

/* JADX INFO: loaded from: classes.dex */
class EddystoneBuilder implements ADStructureBuilder {
    EddystoneBuilder() {
    }

    @Override // com.neovisionaries.bluetooth.ble.advertising.ADStructureBuilder
    public ADStructure build(int i, int i2, byte[] bArr) {
        if (bArr == null || bArr.length < 3 || (bArr[0] & UByte.MAX_VALUE) != 170 || (bArr[1] & UByte.MAX_VALUE) != 254) {
            return null;
        }
        int i3 = bArr[2] & 240;
        if (i3 == 0) {
            return new EddystoneUID(i, i2, bArr);
        }
        if (i3 == 16) {
            return new EddystoneURL(i, i2, bArr);
        }
        if (i3 == 32) {
            return new EddystoneTLM(i, i2, bArr);
        }
        if (i3 != 48) {
            return null;
        }
        return new EddystoneEID(i, i2, bArr);
    }
}
