package com.neovisionaries.bluetooth.ble.advertising;

import com.neovisionaries.bluetooth.ble.util.UUIDCreator;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public class ServiceData extends ADStructure {
    private static final String STRING_FORMAT = "ServiceData(ServiceUUID=%s)";
    private static final long serialVersionUID = 1;
    private final UUID mServiceUUID;

    public ServiceData() {
        this(1, 22, null);
    }

    public ServiceData(int i, int i2, byte[] bArr) {
        super(i, i2, bArr);
        this.mServiceUUID = extractServiceUUID(i2, bArr);
    }

    private UUID extractServiceUUID(int i, byte[] bArr) {
        if (i == 22) {
            return UUIDCreator.from16(bArr);
        }
        if (i == 32) {
            return UUIDCreator.from32(bArr);
        }
        if (i != 33) {
            return null;
        }
        return UUIDCreator.from128(bArr);
    }

    public UUID getServiceUUID() {
        return this.mServiceUUID;
    }

    @Override // com.neovisionaries.bluetooth.ble.advertising.ADStructure
    public String toString() {
        return String.format(STRING_FORMAT, this.mServiceUUID);
    }
}
