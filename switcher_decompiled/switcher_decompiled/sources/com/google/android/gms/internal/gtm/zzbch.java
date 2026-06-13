package com.google.android.gms.internal.gtm;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
final class zzbch extends zzbce {
    private final OutputStream zzf;

    zzbch(OutputStream outputStream, int i) {
        super(i);
        this.zzf = outputStream;
    }

    private final void zzP() throws IOException {
        this.zzf.write(this.zza, 0, this.zzc);
        this.zzc = 0;
    }

    private final void zzQ(int i) throws IOException {
        if (this.zzb - this.zzc < i) {
            zzP();
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzbcj
    public final void zzR() throws IOException {
        if (this.zzc > 0) {
            zzP();
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzbcj
    public final void zzS(byte b) throws IOException {
        if (this.zzc == this.zzb) {
            zzP();
        }
        zzc(b);
    }

    @Override // com.google.android.gms.internal.gtm.zzbcj
    public final void zzT(int i, boolean z) throws IOException {
        zzQ(11);
        zzf(i << 3);
        zzc(z ? (byte) 1 : (byte) 0);
    }

    @Override // com.google.android.gms.internal.gtm.zzbcj
    public final void zzU(int i, zzbbw zzbbwVar) throws IOException {
        zzu((i << 3) | 2);
        zzu(zzbbwVar.zzd());
        zzbbwVar.zzi(this);
    }

    @Override // com.google.android.gms.internal.gtm.zzbcj, com.google.android.gms.internal.gtm.zzbbm
    public final void zza(byte[] bArr, int i, int i2) throws IOException {
        zzr(bArr, i, i2);
    }

    @Override // com.google.android.gms.internal.gtm.zzbcj
    public final void zzh(int i, int i2) throws IOException {
        zzQ(14);
        zzf((i << 3) | 5);
        zzd(i2);
    }

    @Override // com.google.android.gms.internal.gtm.zzbcj
    public final void zzi(int i) throws IOException {
        zzQ(4);
        zzd(i);
    }

    @Override // com.google.android.gms.internal.gtm.zzbcj
    public final void zzj(int i, long j) throws IOException {
        zzQ(18);
        zzf((i << 3) | 1);
        zze(j);
    }

    @Override // com.google.android.gms.internal.gtm.zzbcj
    public final void zzk(long j) throws IOException {
        zzQ(8);
        zze(j);
    }

    @Override // com.google.android.gms.internal.gtm.zzbcj
    public final void zzl(int i, int i2) throws IOException {
        zzQ(20);
        zzf(i << 3);
        if (i2 >= 0) {
            zzf(i2);
        } else {
            zzg(i2);
        }
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
        zzx(str);
    }

    public final void zzr(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.zzb;
        int i4 = this.zzc;
        int i5 = i3 - i4;
        if (i5 >= i2) {
            System.arraycopy(bArr, i, this.zza, i4, i2);
            this.zzc += i2;
            this.zzd += i2;
            return;
        }
        System.arraycopy(bArr, i, this.zza, i4, i5);
        int i6 = i + i5;
        int i7 = i2 - i5;
        this.zzc = this.zzb;
        this.zzd += i5;
        zzP();
        if (i7 <= this.zzb) {
            System.arraycopy(bArr, i6, this.zza, 0, i7);
            this.zzc = i7;
        } else {
            this.zzf.write(bArr, i6, i7);
        }
        this.zzd += i7;
    }

    @Override // com.google.android.gms.internal.gtm.zzbcj
    public final void zzs(int i, int i2) throws IOException {
        zzu((i << 3) | i2);
    }

    @Override // com.google.android.gms.internal.gtm.zzbcj
    public final void zzt(int i, int i2) throws IOException {
        zzQ(20);
        zzf(i << 3);
        zzf(i2);
    }

    @Override // com.google.android.gms.internal.gtm.zzbcj
    public final void zzu(int i) throws IOException {
        zzQ(5);
        zzf(i);
    }

    @Override // com.google.android.gms.internal.gtm.zzbcj
    public final void zzv(int i, long j) throws IOException {
        zzQ(20);
        zzf(i << 3);
        zzg(j);
    }

    @Override // com.google.android.gms.internal.gtm.zzbcj
    public final void zzw(long j) throws IOException {
        zzQ(10);
        zzg(j);
    }

    public final void zzx(String str) throws IOException {
        int iZzc;
        try {
            int length = str.length() * 3;
            int iZzJ = zzJ(length);
            int i = iZzJ + length;
            int i2 = this.zzb;
            if (i > i2) {
                byte[] bArr = new byte[length];
                int iZzb = zzbio.zzb(str, bArr, 0, length);
                zzu(iZzb);
                zzr(bArr, 0, iZzb);
                return;
            }
            if (i > i2 - this.zzc) {
                zzP();
            }
            int iZzJ2 = zzJ(str.length());
            int i3 = this.zzc;
            try {
                if (iZzJ2 == iZzJ) {
                    int i4 = i3 + iZzJ2;
                    this.zzc = i4;
                    int iZzb2 = zzbio.zzb(str, this.zza, i4, this.zzb - i4);
                    this.zzc = i3;
                    iZzc = (iZzb2 - i3) - iZzJ2;
                    zzf(iZzc);
                    this.zzc = iZzb2;
                } else {
                    iZzc = zzbio.zzc(str);
                    zzf(iZzc);
                    this.zzc = zzbio.zzb(str, this.zza, this.zzc, iZzc);
                }
                this.zzd += iZzc;
            } catch (zzbin e) {
                this.zzd -= this.zzc - i3;
                this.zzc = i3;
                throw e;
            } catch (ArrayIndexOutOfBoundsException e2) {
                throw new zzbcg(e2);
            }
        } catch (zzbin e3) {
            zzN(str, e3);
        }
    }
}
