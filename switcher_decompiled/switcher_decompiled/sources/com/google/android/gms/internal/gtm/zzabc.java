package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzabc extends zzbff implements zzbgt {
    private static final zzbfm zza = new zzbfm<Integer, zzabm>() { // from class: com.google.android.gms.internal.gtm.zzabc.1
        @Override // com.google.android.gms.internal.gtm.zzbfm
        public /* bridge */ /* synthetic */ zzabm zzb(Integer num) {
            throw null;
        }
    };
    private static final zzbfm zzb = new zzbfm<Integer, zzabj>() { // from class: com.google.android.gms.internal.gtm.zzabc.2
        @Override // com.google.android.gms.internal.gtm.zzbfm
        public /* bridge */ /* synthetic */ zzabj zzb(Integer num) {
            throw null;
        }
    };
    private static final zzabc zzf;
    private int zzg;
    private zzayj zzh;
    private zzbfl zzi = zzah();
    private zzbfl zzj = zzah();
    private int zzk;

    static {
        zzabc zzabcVar = new zzabc();
        zzf = zzabcVar;
        zzbff.zzan(zzabc.class, zzabcVar);
    }

    private zzabc() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzam(zzf, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0002\u0000\u0001ဉ\u0000\u0002\u001e\u0003ဌ\u0001\u0004\u001e", new Object[]{"zzg", "zzh", "zzi", zzabm.zzc(), "zzk", zzabg.zzc(), "zzj", zzabj.zzc()});
        }
        if (i2 == 3) {
            return new zzabc();
        }
        zzaau zzaauVar = null;
        if (i2 == 4) {
            return new zzabd(zzaauVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzf;
    }
}
