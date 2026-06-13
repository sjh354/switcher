package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzbev {
    DOUBLE(0, 1, zzbft.DOUBLE),
    FLOAT(1, 1, zzbft.FLOAT),
    INT64(2, 1, zzbft.LONG),
    UINT64(3, 1, zzbft.LONG),
    INT32(4, 1, zzbft.INT),
    FIXED64(5, 1, zzbft.LONG),
    FIXED32(6, 1, zzbft.INT),
    BOOL(7, 1, zzbft.BOOLEAN),
    STRING(8, 1, zzbft.STRING),
    MESSAGE(9, 1, zzbft.MESSAGE),
    BYTES(10, 1, zzbft.BYTE_STRING),
    UINT32(11, 1, zzbft.INT),
    ENUM(12, 1, zzbft.ENUM),
    SFIXED32(13, 1, zzbft.INT),
    SFIXED64(14, 1, zzbft.LONG),
    SINT32(15, 1, zzbft.INT),
    SINT64(16, 1, zzbft.LONG),
    GROUP(17, 1, zzbft.MESSAGE),
    DOUBLE_LIST(18, 2, zzbft.DOUBLE),
    FLOAT_LIST(19, 2, zzbft.FLOAT),
    INT64_LIST(20, 2, zzbft.LONG),
    UINT64_LIST(21, 2, zzbft.LONG),
    INT32_LIST(22, 2, zzbft.INT),
    FIXED64_LIST(23, 2, zzbft.LONG),
    FIXED32_LIST(24, 2, zzbft.INT),
    BOOL_LIST(25, 2, zzbft.BOOLEAN),
    STRING_LIST(26, 2, zzbft.STRING),
    MESSAGE_LIST(27, 2, zzbft.MESSAGE),
    BYTES_LIST(28, 2, zzbft.BYTE_STRING),
    UINT32_LIST(29, 2, zzbft.INT),
    ENUM_LIST(30, 2, zzbft.ENUM),
    SFIXED32_LIST(31, 2, zzbft.INT),
    SFIXED64_LIST(32, 2, zzbft.LONG),
    SINT32_LIST(33, 2, zzbft.INT),
    SINT64_LIST(34, 2, zzbft.LONG),
    DOUBLE_LIST_PACKED(35, 3, zzbft.DOUBLE),
    FLOAT_LIST_PACKED(36, 3, zzbft.FLOAT),
    INT64_LIST_PACKED(37, 3, zzbft.LONG),
    UINT64_LIST_PACKED(38, 3, zzbft.LONG),
    INT32_LIST_PACKED(39, 3, zzbft.INT),
    FIXED64_LIST_PACKED(40, 3, zzbft.LONG),
    FIXED32_LIST_PACKED(41, 3, zzbft.INT),
    BOOL_LIST_PACKED(42, 3, zzbft.BOOLEAN),
    UINT32_LIST_PACKED(43, 3, zzbft.INT),
    ENUM_LIST_PACKED(44, 3, zzbft.ENUM),
    SFIXED32_LIST_PACKED(45, 3, zzbft.INT),
    SFIXED64_LIST_PACKED(46, 3, zzbft.LONG),
    SINT32_LIST_PACKED(47, 3, zzbft.INT),
    SINT64_LIST_PACKED(48, 3, zzbft.LONG),
    GROUP_LIST(49, 2, zzbft.MESSAGE),
    MAP(50, 4, zzbft.VOID);

    private static final zzbev[] zzZ;
    private final zzbft zzab;
    private final int zzac;
    private final Class zzad;

    static {
        zzbev[] zzbevVarArrValues = values();
        zzZ = new zzbev[zzbevVarArrValues.length];
        for (zzbev zzbevVar : zzbevVarArrValues) {
            zzZ[zzbevVar.zzac] = zzbevVar;
        }
    }

    zzbev(int i, int i2, zzbft zzbftVar) {
        this.zzac = i;
        this.zzab = zzbftVar;
        zzbft zzbftVar2 = zzbft.VOID;
        int i3 = i2 - 1;
        if (i3 == 1 || i3 == 3) {
            this.zzad = zzbftVar.zza();
        } else {
            this.zzad = null;
        }
        if (i2 == 1) {
            zzbftVar.ordinal();
        }
    }

    public final int zza() {
        return this.zzac;
    }
}
