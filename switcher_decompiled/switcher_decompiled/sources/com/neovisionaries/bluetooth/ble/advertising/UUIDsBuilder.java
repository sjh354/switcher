package com.neovisionaries.bluetooth.ble.advertising;

import com.neovisionaries.bluetooth.ble.util.UUIDCreator;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
class UUIDsBuilder implements ADStructureBuilder {
    UUIDsBuilder() {
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0016  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x001b  */
    @Override // com.neovisionaries.bluetooth.ble.advertising.ADStructureBuilder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.neovisionaries.bluetooth.ble.advertising.ADStructure build(int r3, int r4, byte[] r5) {
        /*
            r2 = this;
            r0 = 20
            if (r4 == r0) goto L1b
            r0 = 21
            if (r4 == r0) goto L16
            r0 = 31
            if (r4 == r0) goto L11
            switch(r4) {
                case 2: goto L1b;
                case 3: goto L1b;
                case 4: goto L11;
                case 5: goto L11;
                case 6: goto L16;
                case 7: goto L16;
                default: goto Lf;
            }
        Lf:
            r3 = 0
            return r3
        L11:
            java.util.UUID[] r0 = r2.extract32(r5)
            goto L1f
        L16:
            java.util.UUID[] r0 = r2.extract128(r5)
            goto L1f
        L1b:
            java.util.UUID[] r0 = r2.extract16(r5)
        L1f:
            com.neovisionaries.bluetooth.ble.advertising.UUIDs r1 = new com.neovisionaries.bluetooth.ble.advertising.UUIDs
            r1.<init>(r3, r4, r5, r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.neovisionaries.bluetooth.ble.advertising.UUIDsBuilder.build(int, int, byte[]):com.neovisionaries.bluetooth.ble.advertising.ADStructure");
    }

    private UUID[] extract16(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        int length = bArr.length / 2;
        UUID[] uuidArr = new UUID[length];
        for (int i = 0; i < length; i++) {
            uuidArr[i] = UUIDCreator.from16(bArr, i * 2);
        }
        return uuidArr;
    }

    private UUID[] extract32(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        int length = bArr.length / 4;
        UUID[] uuidArr = new UUID[length];
        for (int i = 0; i < length; i++) {
            uuidArr[i] = UUIDCreator.from32(bArr, i * 4);
        }
        return uuidArr;
    }

    private UUID[] extract128(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        int length = bArr.length / 16;
        UUID[] uuidArr = new UUID[length];
        for (int i = 0; i < length; i++) {
            uuidArr[i] = UUIDCreator.from128(bArr, i * 16);
        }
        return uuidArr;
    }
}
