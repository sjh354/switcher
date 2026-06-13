package com.google.android.gms.internal.gtm;

import java.io.IOException;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
class zzbbt extends zzbbs {
    protected final byte[] zza;

    zzbbt(byte[] bArr) {
        bArr.getClass();
        this.zza = bArr;
    }

    @Override // com.google.android.gms.internal.gtm.zzbbw
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzbbw) || zzd() != ((zzbbw) obj).zzd()) {
            return false;
        }
        if (zzd() == 0) {
            return true;
        }
        if (!(obj instanceof zzbbt)) {
            return obj.equals(this);
        }
        zzbbt zzbbtVar = (zzbbt) obj;
        int iZzl = zzl();
        int iZzl2 = zzbbtVar.zzl();
        if (iZzl != 0 && iZzl2 != 0 && iZzl != iZzl2) {
            return false;
        }
        int iZzd = zzd();
        if (iZzd > zzbbtVar.zzd()) {
            throw new IllegalArgumentException("Length too large: " + iZzd + zzd());
        }
        if (iZzd > zzbbtVar.zzd()) {
            throw new IllegalArgumentException("Ran off end of other: 0, " + iZzd + ", " + zzbbtVar.zzd());
        }
        if (!(zzbbtVar instanceof zzbbt)) {
            return zzbbtVar.zzg(0, iZzd).equals(zzg(0, iZzd));
        }
        byte[] bArr = this.zza;
        byte[] bArr2 = zzbbtVar.zza;
        int iZzc = zzc() + iZzd;
        int iZzc2 = zzc();
        int iZzc3 = zzbbtVar.zzc();
        while (iZzc2 < iZzc) {
            if (bArr[iZzc2] != bArr2[iZzc3]) {
                return false;
            }
            iZzc2++;
            iZzc3++;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.gtm.zzbbw
    public byte zza(int i) {
        return this.zza[i];
    }

    @Override // com.google.android.gms.internal.gtm.zzbbw
    byte zzb(int i) {
        return this.zza[i];
    }

    protected int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.gtm.zzbbw
    public int zzd() {
        return this.zza.length;
    }

    @Override // com.google.android.gms.internal.gtm.zzbbw
    protected void zze(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zza, 0, bArr, 0, i3);
    }

    @Override // com.google.android.gms.internal.gtm.zzbbw
    protected final int zzf(int i, int i2, int i3) {
        return zzbfq.zzd(i, this.zza, zzc(), i3);
    }

    @Override // com.google.android.gms.internal.gtm.zzbbw
    public final zzbbw zzg(int i, int i2) {
        int iZzk = zzk(0, i2, zzd());
        return iZzk == 0 ? zzbbw.zzb : new zzbbq(this.zza, zzc(), iZzk);
    }

    @Override // com.google.android.gms.internal.gtm.zzbbw
    protected final String zzh(Charset charset) {
        return new String(this.zza, zzc(), zzd(), charset);
    }

    @Override // com.google.android.gms.internal.gtm.zzbbw
    final void zzi(zzbbm zzbbmVar) throws IOException {
        zzbbmVar.zza(this.zza, zzc(), zzd());
    }

    @Override // com.google.android.gms.internal.gtm.zzbbw
    public final boolean zzj() {
        int iZzc = zzc();
        return zzbio.zzf(this.zza, iZzc, zzd() + iZzc);
    }
}
