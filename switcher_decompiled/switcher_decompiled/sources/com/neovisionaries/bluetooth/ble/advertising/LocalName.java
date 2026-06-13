package com.neovisionaries.bluetooth.ble.advertising;

import java.io.UnsupportedEncodingException;

/* JADX INFO: loaded from: classes.dex */
public class LocalName extends ADStructure {
    private static final int COMPLETE = 9;
    private static final int SHORTENED = 8;
    private static final String STRING_FORMAT = "LocalName(%s,%s)";
    private static final long serialVersionUID = 1;
    private String mLocalName;

    public LocalName() {
        this(1, 9, null);
    }

    public LocalName(int i, int i2, byte[] bArr) {
        super(i, i2, bArr);
        parse(bArr);
    }

    private void parse(byte[] bArr) {
        if (bArr == null || bArr.length < 1) {
            return;
        }
        try {
            this.mLocalName = new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
        }
    }

    public boolean isShortened() {
        return getType() == 8;
    }

    public boolean isComplete() {
        return getType() == 9;
    }

    public String getLocalName() {
        return this.mLocalName;
    }

    @Override // com.neovisionaries.bluetooth.ble.advertising.ADStructure
    public String toString() {
        Object[] objArr = new Object[2];
        objArr[0] = isShortened() ? "SHORTENED" : "COMPLETE";
        objArr[1] = this.mLocalName;
        return String.format(STRING_FORMAT, objArr);
    }
}
