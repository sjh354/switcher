package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzaij extends zzbff implements zzbgt {
    private static final zzbfm zza = new zzbfm<Integer, zzaiq>() { // from class: com.google.android.gms.internal.gtm.zzaij.1
        @Override // com.google.android.gms.internal.gtm.zzbfm
        public /* bridge */ /* synthetic */ zzaiq zzb(Integer num) {
            throw null;
        }
    };
    private static final zzaij zzb;
    private int zzf;
    private zzaqi zzg;
    private zzamq zzh;
    private int zzi;
    private float zzj;
    private zzaqi zzk;
    private zzaqi zzl;
    private boolean zzm;
    private boolean zzn;
    private zzamq zzq;
    private zzana zzr;
    private byte zzs = 2;
    private int zzo = 1;
    private zzbfl zzp = zzah();

    static {
        zzaij zzaijVar = new zzaij();
        zzb = zzaijVar;
        zzbff.zzan(zzaij.class, zzaijVar);
    }

    private zzaij() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzs);
        }
        if (i2 == 2) {
            return zzam(zzb, "\u0001\f\u0000\u0001\u0002Ǵ\f\u0000\u0001\u0005\u0002ခ\u0003\u0003ᐉ\u0004\u0004ᐉ\u0005\u0005ဇ\u0006\u0006ဇ\u0007\bဌ\b\tᐉ\u0000\nᐉ\u0001\u000bင\u0002\f\u001e\rᐉ\tǴဉ\n", new Object[]{"zzf", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", zzain.zzc(), "zzg", "zzh", "zzi", "zzp", zzaiq.zzc(), "zzq", "zzr"});
        }
        if (i2 == 3) {
            return new zzaij();
        }
        zzaii zzaiiVar = null;
        if (i2 == 4) {
            return new zzaik(zzaiiVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        this.zzs = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
