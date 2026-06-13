package com.neovisionaries.bluetooth.ble.advertising;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class ADStructure implements Serializable {
    private static final String STRING_FORMAT = "ADStructure(Length=%d,Type=0x%02X)";
    private static final long serialVersionUID = 1;
    private byte[] mData;
    private int mLength;
    private int mType;

    public ADStructure() {
    }

    public ADStructure(int i, int i2, byte[] bArr) {
        this.mLength = i;
        this.mType = i2;
        this.mData = bArr;
    }

    public int getLength() {
        return this.mLength;
    }

    public void setLength(int i) {
        this.mLength = i;
    }

    public int getType() {
        return this.mType;
    }

    public void setType(int i) {
        this.mType = i;
    }

    public byte[] getData() {
        return this.mData;
    }

    public void setData(byte[] bArr) {
        this.mData = bArr;
    }

    public String toString() {
        return String.format(STRING_FORMAT, Integer.valueOf(this.mLength), Integer.valueOf(this.mType));
    }
}
