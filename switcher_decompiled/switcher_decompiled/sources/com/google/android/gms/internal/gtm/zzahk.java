package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzahk extends zzbff implements zzbgt {
    private static final zzbfm zza = new zzbfm<Integer, zzaho>() { // from class: com.google.android.gms.internal.gtm.zzahk.1
        @Override // com.google.android.gms.internal.gtm.zzbfm
        public /* bridge */ /* synthetic */ zzaho zzb(Integer num) {
            throw null;
        }
    };
    private static final zzahk zzb;
    private int zzf;
    private boolean zzh;
    private zzbfp zzg = zzaj();
    private zzbfp zzi = zzaj();
    private zzbfp zzj = zzaj();
    private zzbfp zzk = zzaj();
    private zzbfp zzl = zzaj();
    private zzbfp zzm = zzaj();
    private zzbfp zzn = zzaj();
    private zzbfl zzo = zzah();

    static {
        zzahk zzahkVar = new zzahk();
        zzb = zzahkVar;
        zzbff.zzan(zzahk.class, zzahkVar);
    }

    private zzahk() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzam(zzb, "\u0001\t\u0000\u0001\u0001\t\t\u0000\b\u0000\u0001\u001b\u0002ဇ\u0000\u0003\u001b\u0004\u001b\u0005\u001b\u0006\u001b\u0007\u001b\b\u001b\t,", new Object[]{"zzf", "zzg", zzahy.class, "zzh", "zzi", zzxm.class, "zzj", zzxm.class, "zzk", zzxm.class, "zzl", zzxm.class, "zzm", zzwx.class, "zzn", zzwx.class, "zzo", zzaho.zzc()});
        }
        if (i2 == 3) {
            return new zzahk();
        }
        AnonymousClass1 anonymousClass1 = null;
        if (i2 == 4) {
            return new zzahl(anonymousClass1);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
