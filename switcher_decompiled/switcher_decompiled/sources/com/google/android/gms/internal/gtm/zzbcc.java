package com.google.android.gms.internal.gtm;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public abstract class zzbcc {
    public static final /* synthetic */ int zzd = 0;
    private static volatile int zze = 100;
    int zza;
    final int zzb = zze;
    zzbcd zzc;

    /* synthetic */ zzbcc(zzbcb zzbcbVar) {
    }

    public static int zzs(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    public static long zzt(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }

    public abstract int zza();

    public abstract int zzb(int i) throws zzbfs;

    public abstract int zzc() throws IOException;

    public abstract zzbbw zzd() throws IOException;

    public abstract String zze() throws IOException;

    public abstract String zzf() throws IOException;

    public abstract void zzg(int i) throws zzbfs;

    public abstract void zzh(int i);

    public abstract boolean zzi() throws IOException;

    public abstract boolean zzj() throws IOException;

    public abstract boolean zzk(int i) throws IOException;
}
