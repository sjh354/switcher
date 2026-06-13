package com.neovisionaries.bluetooth.ble.advertising;

import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public class UUIDs extends ADStructure {
    private static final String STRING_FORMAT = "UUIDs(%s)";
    private static final long serialVersionUID = 1;
    private UUID[] mUUIDs;

    public UUIDs() {
    }

    public UUIDs(int i, int i2, byte[] bArr, UUID... uuidArr) {
        super(i, i2, bArr);
        this.mUUIDs = uuidArr;
    }

    public UUID[] getUUIDs() {
        return this.mUUIDs;
    }

    public void setUUIDs(UUID[] uuidArr) {
        this.mUUIDs = uuidArr;
    }

    @Override // com.neovisionaries.bluetooth.ble.advertising.ADStructure
    public String toString() {
        if (this.mUUIDs == null) {
            return String.format(STRING_FORMAT, "null");
        }
        StringBuilder sb = new StringBuilder();
        for (UUID uuid : this.mUUIDs) {
            sb.append(uuid).append(",");
        }
        if (sb.length() != 0) {
            sb.setLength(sb.length() - 1);
        }
        return String.format(STRING_FORMAT, sb.toString());
    }
}
