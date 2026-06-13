package com.google.android.gms.internal.gtm;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
final class zzbib extends zzbhz {
    zzbib() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbhz
    final /* synthetic */ int zza(Object obj) {
        return ((zzbia) obj).zza();
    }

    @Override // com.google.android.gms.internal.gtm.zzbhz
    final /* synthetic */ int zzb(Object obj) {
        return ((zzbia) obj).zzb();
    }

    @Override // com.google.android.gms.internal.gtm.zzbhz
    final /* bridge */ /* synthetic */ Object zzc(Object obj) {
        zzbff zzbffVar = (zzbff) obj;
        zzbia zzbiaVar = zzbffVar.zzd;
        if (zzbiaVar != zzbia.zzc()) {
            return zzbiaVar;
        }
        zzbia zzbiaVarZze = zzbia.zze();
        zzbffVar.zzd = zzbiaVarZze;
        return zzbiaVarZze;
    }

    @Override // com.google.android.gms.internal.gtm.zzbhz
    final /* synthetic */ Object zzd(Object obj) {
        return ((zzbff) obj).zzd;
    }

    @Override // com.google.android.gms.internal.gtm.zzbhz
    final /* bridge */ /* synthetic */ Object zze(Object obj, Object obj2) {
        zzbia zzbiaVar = (zzbia) obj2;
        return zzbiaVar.equals(zzbia.zzc()) ? obj : zzbia.zzd((zzbia) obj, zzbiaVar);
    }

    @Override // com.google.android.gms.internal.gtm.zzbhz
    final /* synthetic */ Object zzf() {
        return zzbia.zze();
    }

    @Override // com.google.android.gms.internal.gtm.zzbhz
    final /* synthetic */ Object zzg(Object obj) {
        ((zzbia) obj).zzf();
        return obj;
    }

    @Override // com.google.android.gms.internal.gtm.zzbhz
    final /* bridge */ /* synthetic */ void zzh(Object obj, int i, int i2) {
        ((zzbia) obj).zzh((i << 3) | 5, Integer.valueOf(i2));
    }

    @Override // com.google.android.gms.internal.gtm.zzbhz
    final /* bridge */ /* synthetic */ void zzi(Object obj, int i, long j) {
        ((zzbia) obj).zzh((i << 3) | 1, Long.valueOf(j));
    }

    @Override // com.google.android.gms.internal.gtm.zzbhz
    final /* bridge */ /* synthetic */ void zzj(Object obj, int i, Object obj2) {
        ((zzbia) obj).zzh((i << 3) | 3, obj2);
    }

    @Override // com.google.android.gms.internal.gtm.zzbhz
    final /* bridge */ /* synthetic */ void zzk(Object obj, int i, zzbbw zzbbwVar) {
        ((zzbia) obj).zzh((i << 3) | 2, zzbbwVar);
    }

    @Override // com.google.android.gms.internal.gtm.zzbhz
    final /* bridge */ /* synthetic */ void zzl(Object obj, int i, long j) {
        ((zzbia) obj).zzh(i << 3, Long.valueOf(j));
    }

    @Override // com.google.android.gms.internal.gtm.zzbhz
    final void zzm(Object obj) {
        ((zzbff) obj).zzd.zzf();
    }

    @Override // com.google.android.gms.internal.gtm.zzbhz
    final /* synthetic */ void zzn(Object obj, Object obj2) {
        ((zzbff) obj).zzd = (zzbia) obj2;
    }

    @Override // com.google.android.gms.internal.gtm.zzbhz
    final /* synthetic */ void zzo(Object obj, Object obj2) {
        ((zzbff) obj).zzd = (zzbia) obj2;
    }

    @Override // com.google.android.gms.internal.gtm.zzbhz
    final boolean zzq(zzbhe zzbheVar) {
        return false;
    }

    @Override // com.google.android.gms.internal.gtm.zzbhz
    final /* synthetic */ void zzr(Object obj, zzbck zzbckVar) throws IOException {
        ((zzbia) obj).zzi(zzbckVar);
    }

    @Override // com.google.android.gms.internal.gtm.zzbhz
    final /* synthetic */ void zzs(Object obj, zzbck zzbckVar) throws IOException {
        ((zzbia) obj).zzj(zzbckVar);
    }
}
