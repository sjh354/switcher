package com.neovisionaries.bluetooth.ble.advertising;

/* JADX INFO: loaded from: classes.dex */
public abstract class Eddystone extends ServiceData {
    private static final String STRING_FORMAT = "EddyStone(FrameType=%s)";
    private static final long serialVersionUID = 1;
    private final FrameType mFrameType;

    public enum FrameType {
        UID,
        URL,
        TLM,
        EID
    }

    public Eddystone() {
        this(3, 22, new byte[]{-86, -2}, null);
    }

    public Eddystone(int i, int i2, byte[] bArr, FrameType frameType) {
        super(i, i2, bArr);
        this.mFrameType = frameType;
    }

    public FrameType getFrameType() {
        return this.mFrameType;
    }

    @Override // com.neovisionaries.bluetooth.ble.advertising.ServiceData, com.neovisionaries.bluetooth.ble.advertising.ADStructure
    public String toString() {
        return String.format(STRING_FORMAT, this.mFrameType);
    }
}
