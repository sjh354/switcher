package com.google.android.gms.internal.gtm;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
final class zzbcf extends zzbcj {
    private final byte[] zza;
    private final int zzb;
    private int zzc;

    zzbcf(byte[] bArr, int i, int i2) {
        super(null);
        if (bArr == null) {
            throw new NullPointerException("buffer");
        }
        int length = bArr.length;
        if (((length - i2) | i2) < 0) {
            throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(length), 0, Integer.valueOf(i2)));
        }
        this.zza = bArr;
        this.zzc = 0;
        this.zzb = i2;
    }

    @Override // com.google.android.gms.internal.gtm.zzbcj
    public final void zzR() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbcj
    public final void zzT(int i, boolean z) throws IOException {
        zzu(i << 3);
        zzS(z ? (byte) 1 : (byte) 0);
    }

    @Override // com.google.android.gms.internal.gtm.zzbcj
    public final void zzU(int i, zzbbw zzbbwVar) throws IOException {
        zzu((i << 3) | 2);
        zzu(zzbbwVar.zzd());
        zzbbwVar.zzi(this);
    }

    @Override // com.google.android.gms.internal.gtm.zzbcj, com.google.android.gms.internal.gtm.zzbbm
    public final void zza(byte[] bArr, int i, int i2) throws IOException {
        zze(bArr, i, i2);
    }

    @Override // com.google.android.gms.internal.gtm.zzbcj
    public final int zzb() {
        return this.zzb - this.zzc;
    }

    @Override // com.google.android.gms.internal.gtm.zzbcj
    public final void zzh(int i, int i2) throws IOException {
        zzu((i << 3) | 5);
        zzi(i2);
    }

    @Override // com.google.android.gms.internal.gtm.zzbcj
    public final void zzi(int i) throws IOException {
        try {
            byte[] bArr = this.zza;
            int i2 = this.zzc;
            int i3 = i2 + 1;
            bArr[i2] = (byte) (i & 255);
            int i4 = i3 + 1;
            bArr[i3] = (byte) ((i >> 8) & 255);
            int i5 = i4 + 1;
            bArr[i4] = (byte) ((i >> 16) & 255);
            this.zzc = i5 + 1;
            bArr[i5] = (byte) ((i >> 24) & 255);
        } catch (IndexOutOfBoundsException e) {
            throw new zzbcg(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzc), Integer.valueOf(this.zzb), 1), e);
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzbcj
    public final void zzj(int i, long j) throws IOException {
        zzu((i << 3) | 1);
        zzk(j);
    }

    @Override // com.google.android.gms.internal.gtm.zzbcj
    public final void zzk(long j) throws IOException {
        try {
            byte[] bArr = this.zza;
            int i = this.zzc;
            int i2 = i + 1;
            bArr[i] = (byte) (((int) j) & 255);
            int i3 = i2 + 1;
            bArr[i2] = (byte) (((int) (j >> 8)) & 255);
            int i4 = i3 + 1;
            bArr[i3] = (byte) (((int) (j >> 16)) & 255);
            int i5 = i4 + 1;
            bArr[i4] = (byte) (((int) (j >> 24)) & 255);
            int i6 = i5 + 1;
            bArr[i5] = (byte) (((int) (j >> 32)) & 255);
            int i7 = i6 + 1;
            bArr[i6] = (byte) (((int) (j >> 40)) & 255);
            int i8 = i7 + 1;
            bArr[i7] = (byte) (((int) (j >> 48)) & 255);
            this.zzc = i8 + 1;
            bArr[i8] = (byte) (((int) (j >> 56)) & 255);
        } catch (IndexOutOfBoundsException e) {
            throw new zzbcg(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzc), Integer.valueOf(this.zzb), 1), e);
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzbcj
    public final void zzl(int i, int i2) throws IOException {
        zzu(i << 3);
        zzm(i2);
    }

    @Override // com.google.android.gms.internal.gtm.zzbcj
    public final void zzm(int i) throws IOException {
        if (i >= 0) {
            zzu(i);
        } else {
            zzw(i);
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzbcj
    final void zzn(int i, zzbgs zzbgsVar, zzbhf zzbhfVar) throws IOException {
        zzu((i << 3) | 2);
        zzbay zzbayVar = (zzbay) zzbgsVar;
        int iZzQ = zzbayVar.zzQ();
        if (iZzQ == -1) {
            iZzQ = zzbhfVar.zza(zzbayVar);
            zzbayVar.zzT(iZzQ);
        }
        zzu(iZzQ);
        zzbhfVar.zzn(zzbgsVar, this.zze);
    }

    @Override // com.google.android.gms.internal.gtm.zzbcj
    public final void zzo(int i, zzbgs zzbgsVar) throws IOException {
        zzu(11);
        zzt(2, i);
        zzu(26);
        zzu(zzbgsVar.zzY());
        zzbgsVar.zzau(this);
        zzu(12);
    }

    @Override // com.google.android.gms.internal.gtm.zzbcj
    public final void zzp(int i, zzbbw zzbbwVar) throws IOException {
        zzu(11);
        zzt(2, i);
        zzU(3, zzbbwVar);
        zzu(12);
    }

    @Override // com.google.android.gms.internal.gtm.zzbcj
    public final void zzq(int i, String str) throws IOException {
        zzu((i << 3) | 2);
        zzr(str);
    }

    public final void zzr(String str) throws IOException {
        int i = this.zzc;
        try {
            int iZzJ = zzJ(str.length() * 3);
            int iZzJ2 = zzJ(str.length());
            if (iZzJ2 != iZzJ) {
                zzu(zzbio.zzc(str));
                byte[] bArr = this.zza;
                int i2 = this.zzc;
                this.zzc = zzbio.zzb(str, bArr, i2, this.zzb - i2);
                return;
            }
            int i3 = i + iZzJ2;
            this.zzc = i3;
            int iZzb = zzbio.zzb(str, this.zza, i3, this.zzb - i3);
            this.zzc = i;
            zzu((iZzb - i) - iZzJ2);
            this.zzc = iZzb;
        } catch (zzbin e) {
            this.zzc = i;
            zzN(str, e);
        } catch (IndexOutOfBoundsException e2) {
            throw new zzbcg(e2);
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzbcj
    public final void zzs(int i, int i2) throws IOException {
        zzu((i << 3) | i2);
    }

    @Override // com.google.android.gms.internal.gtm.zzbcj
    public final void zzt(int i, int i2) throws IOException {
        zzu(i << 3);
        zzu(i2);
    }

    @Override // com.google.android.gms.internal.gtm.zzbcj
    public final void zzv(int i, long j) throws IOException {
        zzu(i << 3);
        zzw(j);
    }

    @Override // com.google.android.gms.internal.gtm.zzbcj
    public final void zzS(byte b) throws IOException {
        try {
            byte[] bArr = this.zza;
            int i = this.zzc;
            this.zzc = i + 1;
            bArr[i] = b;
        } catch (IndexOutOfBoundsException e) {
            throw new zzbcg(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzc), Integer.valueOf(this.zzb), 1), e);
        }
    }

    public final void zze(byte[] bArr, int i, int i2) throws IOException {
        try {
            System.arraycopy(bArr, i, this.zza, this.zzc, i2);
            this.zzc += i2;
        } catch (IndexOutOfBoundsException e) {
            throw new zzbcg(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzc), Integer.valueOf(this.zzb), Integer.valueOf(i2)), e);
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzbcj
    public final void zzu(int i) throws IOException {
        while ((i & (-128)) != 0) {
            try {
                byte[] bArr = this.zza;
                int i2 = this.zzc;
                this.zzc = i2 + 1;
                bArr[i2] = (byte) ((i & 127) | 128);
                i >>>= 7;
            } catch (IndexOutOfBoundsException e) {
                throw new zzbcg(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzc), Integer.valueOf(this.zzb), 1), e);
            }
        }
        byte[] bArr2 = this.zza;
        int i3 = this.zzc;
        this.zzc = i3 + 1;
        bArr2[i3] = (byte) i;
    }

    @Override // com.google.android.gms.internal.gtm.zzbcj
    public final void zzw(long j) throws IOException {
        if (zzbcj.zzb && this.zzb - this.zzc >= 10) {
            while ((j & (-128)) != 0) {
                byte[] bArr = this.zza;
                int i = this.zzc;
                this.zzc = i + 1;
                zzbij.zzn(bArr, i, (byte) ((((int) j) & 127) | 128));
                j >>>= 7;
            }
            byte[] bArr2 = this.zza;
            int i2 = this.zzc;
            this.zzc = i2 + 1;
            zzbij.zzn(bArr2, i2, (byte) j);
            return;
        }
        while ((j & (-128)) != 0) {
            try {
                byte[] bArr3 = this.zza;
                int i3 = this.zzc;
                this.zzc = i3 + 1;
                bArr3[i3] = (byte) ((((int) j) & 127) | 128);
                j >>>= 7;
            } catch (IndexOutOfBoundsException e) {
                throw new zzbcg(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzc), Integer.valueOf(this.zzb), 1), e);
            }
        }
        byte[] bArr4 = this.zza;
        int i4 = this.zzc;
        this.zzc = i4 + 1;
        bArr4[i4] = (byte) j;
    }
}
