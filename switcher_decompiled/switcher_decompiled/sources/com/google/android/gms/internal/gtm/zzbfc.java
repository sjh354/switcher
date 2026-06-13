package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
final class zzbfc implements zzbet {
    final zzbfi zza;
    final int zzb;
    final zzbip zzc;
    final boolean zzd;

    zzbfc(zzbfi zzbfiVar, int i, zzbip zzbipVar, boolean z, boolean z2) {
        this.zza = zzbfiVar;
        this.zzb = i;
        this.zzc = zzbipVar;
        this.zzd = z;
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(Object obj) {
        return this.zzb - ((zzbfc) obj).zzb;
    }

    @Override // com.google.android.gms.internal.gtm.zzbet
    public final int zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.gtm.zzbet
    public final zzbgr zzb(zzbgr zzbgrVar, zzbgs zzbgsVar) {
        ((zzbez) zzbgrVar).zzz((zzbff) zzbgsVar);
        return zzbgrVar;
    }

    @Override // com.google.android.gms.internal.gtm.zzbet
    public final zzbgx zzc(zzbgx zzbgxVar, zzbgx zzbgxVar2) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.gtm.zzbet
    public final zzbip zzd() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.gtm.zzbet
    public final zzbiq zze() {
        return this.zzc.zza();
    }

    @Override // com.google.android.gms.internal.gtm.zzbet
    public final boolean zzf() {
        return false;
    }

    @Override // com.google.android.gms.internal.gtm.zzbet
    public final boolean zzg() {
        return this.zzd;
    }
}
