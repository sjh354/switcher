package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzaeh extends zzbff implements zzbgt {
    private static final zzbfm zza = new zzbfm<Integer, zzabs>() { // from class: com.google.android.gms.internal.gtm.zzaeh.1
        @Override // com.google.android.gms.internal.gtm.zzbfm
        public /* bridge */ /* synthetic */ zzabs zzb(Integer num) {
            throw null;
        }
    };
    private static final zzaeh zzb;
    private int zzf;
    private zzacr zzl;
    private byte zzm = 2;
    private zzbfp zzg = zzaj();
    private zzbfl zzh = zzah();
    private zzbfp zzi = zzaj();
    private zzbfp zzj = zzaj();
    private zzbfp zzk = zzaj();

    static {
        zzaeh zzaehVar = new zzaeh();
        zzb = zzaehVar;
        zzbff.zzan(zzaeh.class, zzaehVar);
    }

    private zzaeh() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzm);
        }
        if (i2 == 2) {
            return zzam(zzb, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0005\u0002\u0001\u001b\u0002\u001e\u0003\u001b\u0004Л\u0005\u001b\u0006ᐉ\u0000", new Object[]{"zzf", "zzg", zzaee.class, "zzh", zzabs.zzc(), "zzi", zzadn.class, "zzj", zzacw.class, "zzk", zzady.class, "zzl"});
        }
        if (i2 == 3) {
            return new zzaeh();
        }
        zzacm zzacmVar = null;
        if (i2 == 4) {
            return new zzaei(zzacmVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        this.zzm = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
