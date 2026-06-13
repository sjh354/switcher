package com.google.android.gms.internal.gtm;

import sun.misc.Unsafe;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
final class zzbih extends zzbii {
    zzbih(Unsafe unsafe) {
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

    /* JADX WARN: Failed to inline method: com.google.android.gms.internal.gtm.zzbij.zzi(java.lang.Object, long, boolean):void */
    /* JADX WARN: Failed to inline method: com.google.android.gms.internal.gtm.zzbij.zzj(java.lang.Object, long, boolean):void */
    /* JADX WARN: Unknown register number '(r5v0 'z' boolean)' in method call: com.google.android.gms.internal.gtm.zzbij.zzi(java.lang.Object, long, boolean):void */
    /* JADX WARN: Unknown register number '(r5v0 'z' boolean)' in method call: com.google.android.gms.internal.gtm.zzbij.zzj(java.lang.Object, long, boolean):void */
    @Override // com.google.android.gms.internal.gtm.zzbii
    public final void zzc(Object obj, long j, boolean z) {
        if (zzbij.zzb) {
            zzbij.zzi(obj, j, z);
        } else {
            zzbij.zzj(obj, j, z);
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
