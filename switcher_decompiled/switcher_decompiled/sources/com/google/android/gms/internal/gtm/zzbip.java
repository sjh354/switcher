package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzbip {
    DOUBLE(zzbiq.DOUBLE, 1),
    FLOAT(zzbiq.FLOAT, 5),
    INT64(zzbiq.LONG, 0),
    UINT64(zzbiq.LONG, 0),
    INT32(zzbiq.INT, 0),
    FIXED64(zzbiq.LONG, 1),
    FIXED32(zzbiq.INT, 5),
    BOOL(zzbiq.BOOLEAN, 0),
    STRING(zzbiq.STRING, 2),
    GROUP(zzbiq.MESSAGE, 3),
    MESSAGE(zzbiq.MESSAGE, 2),
    BYTES(zzbiq.BYTE_STRING, 2),
    UINT32(zzbiq.INT, 0),
    ENUM(zzbiq.ENUM, 0),
    SFIXED32(zzbiq.INT, 5),
    SFIXED64(zzbiq.LONG, 1),
    SINT32(zzbiq.INT, 0),
    SINT64(zzbiq.LONG, 0);

    private final zzbiq zzt;

    zzbip(zzbiq zzbiqVar, int i) {
        this.zzt = zzbiqVar;
    }

    public final zzbiq zza() {
        return this.zzt;
    }
}
