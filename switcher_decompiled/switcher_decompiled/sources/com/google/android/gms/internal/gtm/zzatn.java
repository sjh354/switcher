package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzatn extends zzbff implements zzbgt {
    private static final zzbfm zza = new zzbfm<Integer, zzatr>() { // from class: com.google.android.gms.internal.gtm.zzatn.1
        @Override // com.google.android.gms.internal.gtm.zzbfm
        public /* bridge */ /* synthetic */ zzatr zzb(Integer num) {
            throw null;
        }
    };
    private static final zzatn zzb;
    private int zzf;
    private zzamq zzg;
    private int zzh;
    private byte zzj = 2;
    private zzbfl zzi = zzah();

    static {
        zzatn zzatnVar = new zzatn();
        zzb = zzatnVar;
        zzbff.zzan(zzatn.class, zzatnVar);
    }

    private zzatn() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzj);
        }
        if (i2 == 2) {
            return zzam(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0001\u0001ᐉ\u0000\u0002င\u0001\u0003\u001e", new Object[]{"zzf", "zzg", "zzh", "zzi", zzatr.zzc()});
        }
        if (i2 == 3) {
            return new zzatn();
        }
        zzatm zzatmVar = null;
        if (i2 == 4) {
            return new zzato(zzatmVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        this.zzj = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
