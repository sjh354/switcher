package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
final class zzbbq extends zzbbt {
    private final int zzc;
    private final int zzd;

    zzbbq(byte[] bArr, int i, int i2) {
        super(bArr);
        zzk(i, i + i2, bArr.length);
        this.zzc = i;
        this.zzd = i2;
    }

    @Override // com.google.android.gms.internal.gtm.zzbbt, com.google.android.gms.internal.gtm.zzbbw
    final byte zzb(int i) {
        return this.zza[this.zzc + i];
    }

    @Override // com.google.android.gms.internal.gtm.zzbbt
    protected final int zzc() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.gtm.zzbbt, com.google.android.gms.internal.gtm.zzbbw
    public final int zzd() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.gtm.zzbbt, com.google.android.gms.internal.gtm.zzbbw
    protected final void zze(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zza, this.zzc, bArr, 0, i3);
    }

    @Override // com.google.android.gms.internal.gtm.zzbbt, com.google.android.gms.internal.gtm.zzbbw
    public final byte zza(int i) {
        int i2 = this.zzd;
        if (((i2 - (i + 1)) | i) >= 0) {
            return this.zza[this.zzc + i];
        }
        if (i < 0) {
            throw new ArrayIndexOutOfBoundsException("Index < 0: " + i);
        }
        throw new ArrayIndexOutOfBoundsException("Index > length: " + i + ", " + i2);
    }
}
