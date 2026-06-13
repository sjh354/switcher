package com.neovisionaries.bluetooth.ble.advertising;

import com.neovisionaries.bluetooth.ble.advertising.Eddystone;
import java.net.URL;

/* JADX INFO: loaded from: classes.dex */
public class EddystoneURL extends Eddystone {
    private static final String STRING_FORMAT = "EddystoneURL(TxPower=%d,URL=%s)";
    private static final long serialVersionUID = 1;
    private final int mTxPower;
    private final URL mURL;
    private static final String[] SCHEME_PREFIXES = {"http://www.", "https://www.", "http://", "https://"};
    private static final String[] EXPANSION_CODES = {".com/", ".org/", ".edu/", ".net/", ".info/", ".biz/", ".gov/", ".com", ".org", ".edu", ".net", ".info", ".biz", ".gov"};

    public EddystoneURL() {
        this(5, 22, new byte[]{-86, -2, 16, 0});
    }

    public EddystoneURL(int i, int i2, byte[] bArr) {
        super(i, i2, bArr, Eddystone.FrameType.URL);
        this.mTxPower = extractTxPower(bArr);
        this.mURL = extractURL(bArr);
    }

    private int extractTxPower(byte[] bArr) {
        if (4 <= bArr.length) {
            return bArr[3];
        }
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.net.URL extractURL(byte[] r6) {
        /*
            r5 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = r5.extractSchemePrefix(r6)
            if (r1 == 0) goto Le
            r0.append(r1)
        Le:
            r1 = 5
        Lf:
            int r2 = r6.length
            if (r1 >= r2) goto L30
            r2 = r6[r1]
            if (r2 < 0) goto L21
            java.lang.String[] r3 = com.neovisionaries.bluetooth.ble.advertising.EddystoneURL.EXPANSION_CODES
            int r4 = r3.length
            if (r2 >= r4) goto L21
            r2 = r3[r2]
            r0.append(r2)
            goto L2d
        L21:
            r3 = 32
            if (r3 >= r2) goto L2d
            r3 = 127(0x7f, float:1.78E-43)
            if (r2 >= r3) goto L2d
            char r2 = (char) r2
            r0.append(r2)
        L2d:
            int r1 = r1 + 1
            goto Lf
        L30:
            int r6 = r0.length()
            r1 = 0
            if (r6 != 0) goto L38
            return r1
        L38:
            java.net.URL r6 = new java.net.URL     // Catch: java.net.MalformedURLException -> L42
            java.lang.String r0 = r0.toString()     // Catch: java.net.MalformedURLException -> L42
            r6.<init>(r0)     // Catch: java.net.MalformedURLException -> L42
            return r6
        L42:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.neovisionaries.bluetooth.ble.advertising.EddystoneURL.extractURL(byte[]):java.net.URL");
    }

    private String extractSchemePrefix(byte[] bArr) {
        byte b;
        if (bArr.length >= 5 && (b = bArr[4]) >= 0) {
            String[] strArr = SCHEME_PREFIXES;
            if (strArr.length > b) {
                return strArr[b];
            }
        }
        return null;
    }

    public int getTxPower() {
        return this.mTxPower;
    }

    public URL getURL() {
        return this.mURL;
    }

    @Override // com.neovisionaries.bluetooth.ble.advertising.Eddystone, com.neovisionaries.bluetooth.ble.advertising.ServiceData, com.neovisionaries.bluetooth.ble.advertising.ADStructure
    public String toString() {
        return String.format(STRING_FORMAT, Integer.valueOf(this.mTxPower), this.mURL);
    }
}
