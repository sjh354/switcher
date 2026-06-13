package com.google.android.gms.internal.gtm;

import sun.misc.Unsafe;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
final class zzbig extends zzbii {
    zzbig(Unsafe unsafe) {
        super(unsafe);
    }

    @Override // com.google.android.gms.internal.gtm.zzbii
    public final double zza(Object obj, long j) {
        return Double.longBitsToDouble(zzk(obj, j));
    }

    @Override // com.google.android.gms.internal.gtm.zzbii
    public final float zzb(Object obj, long j) {
        return Float.intBitsToFloat(zzj(obj, j));
    }

    @Override // com.google.android.gms.internal.gtm.zzbii
    public final void zzc(Object obj, long j, boolean z) {
        if (zzbij.zzb) {
            zzbij.zzD(obj, j, z ? (byte) 1 : (byte) 0);
        } else {
            zzbij.zzE(obj, j, z ? (byte) 1 : (byte) 0);
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzbii
    public final void zzd(Object obj, long j, byte b) {
        if (zzbij.zzb) {
            zzbij.zzD(obj, j, b);
        } else {
            zzbij.zzE(obj, j, b);
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzbii
    public final void zze(Object obj, long j, double d) {
        zzo(obj, j, Double.doubleToLongBits(d));
    }

    @Override // com.google.android.gms.internal.gtm.zzbii
    public final void zzf(Object obj, long j, float f) {
        zzn(obj, j, Float.floatToIntBits(f));
    }

    @Override // com.google.android.gms.internal.gtm.zzbii
    public final boolean zzg(Object obj, long j) {
        return zzbij.zzb ? zzbij.zzt(obj, j) : zzbij.zzu(obj, j);
    }
}
