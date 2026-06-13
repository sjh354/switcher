package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzsn implements zzbfh {
    ARCH_UNKNOWN(0),
    ARCH_NON_NATIVE(1),
    ARCH_ARMV5(2),
    ARCH_ARMV7(4),
    ARCH_ARM64(5),
    ARCH_MIPS(6),
    ARCH_MIPS_64(7),
    ARCH_X86(8),
    ARCH_X86_64(9);

    private static final zzbfi zzj = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzsl
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzsn.zzb(i);
        }
    };
    private final int zzl;

    zzsn(int i) {
        this.zzl = i;
    }

    public static zzsn zzb(int i) {
        switch (i) {
            case 0:
                return ARCH_UNKNOWN;
            case 1:
                return ARCH_NON_NATIVE;
            case 2:
                return ARCH_ARMV5;
            case 3:
            default:
                return null;
            case 4:
                return ARCH_ARMV7;
            case 5:
                return ARCH_ARM64;
            case 6:
                return ARCH_MIPS;
            case 7:
                return ARCH_MIPS_64;
            case 8:
                return ARCH_X86;
            case 9:
                return ARCH_X86_64;
        }
    }

    public static zzbfj zzc() {
        return zzsm.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.zzl);
    }

    @Override // com.google.android.gms.internal.gtm.zzbfh
    public final int zza() {
        return this.zzl;
    }
}
