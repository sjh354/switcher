package com.google.android.gms.internal.gtm;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
final class zzbca extends zzbcc {
    private final InputStream zze;
    private final byte[] zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private int zzk;
    private int zzl;

    /* synthetic */ zzbca(InputStream inputStream, int i, zzbbz zzbbzVar) {
        super(null);
        this.zzl = Integer.MAX_VALUE;
        zzbfq.zzf(inputStream, "input");
        this.zze = inputStream;
        this.zzf = new byte[4096];
        this.zzg = 0;
        this.zzi = 0;
        this.zzk = 0;
    }

    private final List zzu(int i) throws IOException {
        ArrayList arrayList = new ArrayList();
        while (i > 0) {
            int iMin = Math.min(i, 4096);
            byte[] bArr = new byte[iMin];
            int i2 = 0;
            while (i2 < iMin) {
                int i3 = this.zze.read(bArr, i2, iMin - i2);
                if (i3 == -1) {
                    throw zzbfs.zzj();
                }
                this.zzk += i3;
                i2 += i3;
            }
            i -= iMin;
            arrayList.add(bArr);
        }
        return arrayList;
    }

    private final void zzv() {
        int i = this.zzg + this.zzh;
        this.zzg = i;
        int i2 = this.zzk + i;
        int i3 = this.zzl;
        if (i2 <= i3) {
            this.zzh = 0;
            return;
        }
        int i4 = i2 - i3;
        this.zzh = i4;
        this.zzg = i - i4;
    }

    private final void zzw(int i) throws IOException {
        if (zzx(i)) {
            return;
        }
        if (i <= (Integer.MAX_VALUE - this.zzk) - this.zzi) {
            throw zzbfs.zzj();
        }
        throw zzbfs.zzi();
    }

    private final boolean zzx(int i) throws IOException {
        int i2 = this.zzi;
        int i3 = this.zzg;
        if (i2 + i <= i3) {
            throw new IllegalStateException("refillBuffer() called when " + i + " bytes were already available in buffer");
        }
        int i4 = this.zzk;
        if (i > (Integer.MAX_VALUE - i4) - i2 || i4 + i2 + i > this.zzl) {
            return false;
        }
        if (i2 > 0) {
            if (i3 > i2) {
                byte[] bArr = this.zzf;
                System.arraycopy(bArr, i2, bArr, 0, i3 - i2);
            }
            i4 = this.zzk + i2;
            this.zzk = i4;
            i3 = this.zzg - i2;
            this.zzg = i3;
            this.zzi = 0;
        }
        try {
            int i5 = this.zze.read(this.zzf, i3, Math.min(4096 - i3, (Integer.MAX_VALUE - i4) - i3));
            if (i5 == 0 || i5 < -1 || i5 > 4096) {
                throw new IllegalStateException(String.valueOf(this.zze.getClass()) + "#read(byte[]) returned invalid result: " + i5 + "\nThe InputStream implementation is buggy.");
            }
            if (i5 <= 0) {
                return false;
            }
            this.zzg += i5;
            zzv();
            if (this.zzg >= i) {
                return true;
            }
            return zzx(i);
        } catch (zzbfs e) {
            e.zzk();
            throw e;
        }
    }

    private final byte[] zzy(int i, boolean z) throws IOException {
        byte[] bArrZzz = zzz(i);
        if (bArrZzz != null) {
            return bArrZzz;
        }
        int i2 = this.zzi;
        int i3 = this.zzg;
        int i4 = i3 - i2;
        this.zzk += i3;
        this.zzi = 0;
        this.zzg = 0;
        List<byte[]> listZzu = zzu(i - i4);
        byte[] bArr = new byte[i];
        System.arraycopy(this.zzf, i2, bArr, 0, i4);
        for (byte[] bArr2 : listZzu) {
            int length = bArr2.length;
            System.arraycopy(bArr2, 0, bArr, i4, length);
            i4 += length;
        }
        return bArr;
    }

    private final byte[] zzz(int i) throws IOException {
        if (i == 0) {
            return zzbfq.zzd;
        }
        if (i < 0) {
            throw zzbfs.zzf();
        }
        int i2 = this.zzk;
        int i3 = this.zzi;
        int i4 = i2 + i3 + i;
        if ((-2147483647) + i4 > 0) {
            throw zzbfs.zzi();
        }
        int i5 = this.zzl;
        if (i4 > i5) {
            zzr((i5 - i2) - i3);
            throw zzbfs.zzj();
        }
        int i6 = this.zzg - i3;
        int i7 = i - i6;
        if (i7 >= 4096) {
            try {
                if (i7 > this.zze.available()) {
                    return null;
                }
            } catch (zzbfs e) {
                e.zzk();
                throw e;
            }
        }
        byte[] bArr = new byte[i];
        System.arraycopy(this.zzf, this.zzi, bArr, 0, i6);
        this.zzk += this.zzg;
        this.zzi = 0;
        this.zzg = 0;
        while (i6 < i) {
            try {
                int i8 = this.zze.read(bArr, i6, i - i6);
                if (i8 == -1) {
                    throw zzbfs.zzj();
                }
                this.zzk += i8;
                i6 += i8;
            } catch (zzbfs e2) {
                e2.zzk();
                throw e2;
            }
        }
        return bArr;
    }

    @Override // com.google.android.gms.internal.gtm.zzbcc
    public final int zza() {
        return this.zzk + this.zzi;
    }

    @Override // com.google.android.gms.internal.gtm.zzbcc
    public final int zzb(int i) throws zzbfs {
        if (i < 0) {
            throw zzbfs.zzf();
        }
        int i2 = i + this.zzk + this.zzi;
        int i3 = this.zzl;
        if (i2 > i3) {
            throw zzbfs.zzj();
        }
        this.zzl = i2;
        zzv();
        return i3;
    }

    @Override // com.google.android.gms.internal.gtm.zzbcc
    public final int zzc() throws IOException {
        if (zzi()) {
            this.zzj = 0;
            return 0;
        }
        int iZzn = zzn();
        this.zzj = iZzn;
        if ((iZzn >>> 3) != 0) {
            return iZzn;
        }
        throw zzbfs.zzc();
    }

    @Override // com.google.android.gms.internal.gtm.zzbcc
    public final zzbbw zzd() throws IOException {
        int iZzn = zzn();
        int i = this.zzg;
        int i2 = this.zzi;
        if (iZzn <= i - i2 && iZzn > 0) {
            zzbbw zzbbwVarZzn = zzbbw.zzn(this.zzf, i2, iZzn);
            this.zzi += iZzn;
            return zzbbwVarZzn;
        }
        if (iZzn == 0) {
            return zzbbw.zzb;
        }
        byte[] bArrZzz = zzz(iZzn);
        if (bArrZzz != null) {
            return zzbbw.zzm(bArrZzz);
        }
        int i3 = this.zzi;
        int i4 = this.zzg;
        int i5 = i4 - i3;
        this.zzk += i4;
        this.zzi = 0;
        this.zzg = 0;
        List<byte[]> listZzu = zzu(iZzn - i5);
        byte[] bArr = new byte[iZzn];
        System.arraycopy(this.zzf, i3, bArr, 0, i5);
        for (byte[] bArr2 : listZzu) {
            int length = bArr2.length;
            System.arraycopy(bArr2, 0, bArr, i5, length);
            i5 += length;
        }
        return zzbbw.zzp(bArr);
    }

    @Override // com.google.android.gms.internal.gtm.zzbcc
    public final String zze() throws IOException {
        int iZzn = zzn();
        if (iZzn > 0) {
            int i = this.zzg;
            int i2 = this.zzi;
            if (iZzn <= i - i2) {
                String str = new String(this.zzf, i2, iZzn, zzbfq.zzb);
                this.zzi += iZzn;
                return str;
            }
        }
        if (iZzn == 0) {
            return "";
        }
        if (iZzn > this.zzg) {
            return new String(zzy(iZzn, false), zzbfq.zzb);
        }
        zzw(iZzn);
        String str2 = new String(this.zzf, this.zzi, iZzn, zzbfq.zzb);
        this.zzi += iZzn;
        return str2;
    }

    @Override // com.google.android.gms.internal.gtm.zzbcc
    public final String zzf() throws IOException {
        byte[] bArrZzy;
        int iZzn = zzn();
        int i = this.zzi;
        int i2 = this.zzg;
        if (iZzn <= i2 - i && iZzn > 0) {
            bArrZzy = this.zzf;
            this.zzi = i + iZzn;
        } else {
            if (iZzn == 0) {
                return "";
            }
            if (iZzn <= i2) {
                zzw(iZzn);
                bArrZzy = this.zzf;
                this.zzi = iZzn;
            } else {
                bArrZzy = zzy(iZzn, false);
            }
            i = 0;
        }
        return zzbio.zzd(bArrZzy, i, iZzn);
    }

    @Override // com.google.android.gms.internal.gtm.zzbcc
    public final void zzg(int i) throws zzbfs {
        if (this.zzj != i) {
            throw zzbfs.zzb();
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzbcc
    public final void zzh(int i) {
        this.zzl = i;
        zzv();
    }

    @Override // com.google.android.gms.internal.gtm.zzbcc
    public final boolean zzi() throws IOException {
        return this.zzi == this.zzg && !zzx(1);
    }

    @Override // com.google.android.gms.internal.gtm.zzbcc
    public final boolean zzj() throws IOException {
        return zzp() != 0;
    }

    public final byte zzl() throws IOException {
        if (this.zzi == this.zzg) {
            zzw(1);
        }
        byte[] bArr = this.zzf;
        int i = this.zzi;
        this.zzi = i + 1;
        return bArr[i];
    }

    public final int zzm() throws IOException {
        int i = this.zzi;
        if (this.zzg - i < 4) {
            zzw(4);
            i = this.zzi;
        }
        byte[] bArr = this.zzf;
        this.zzi = i + 4;
        return ((bArr[i + 3] & UByte.MAX_VALUE) << 24) | (bArr[i] & UByte.MAX_VALUE) | ((bArr[i + 1] & UByte.MAX_VALUE) << 8) | ((bArr[i + 2] & UByte.MAX_VALUE) << 16);
    }

    public final long zzo() throws IOException {
        int i = this.zzi;
        if (this.zzg - i < 8) {
            zzw(8);
            i = this.zzi;
        }
        byte[] bArr = this.zzf;
        this.zzi = i + 8;
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    final long zzq() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte bZzl = zzl();
            j |= ((long) (bZzl & ByteCompanionObject.MAX_VALUE)) << i;
            if ((bZzl & ByteCompanionObject.MIN_VALUE) == 0) {
                return j;
            }
        }
        throw zzbfs.zze();
    }

    public final void zzr(int i) throws IOException {
        int i2 = this.zzg;
        int i3 = this.zzi;
        int i4 = i2 - i3;
        if (i <= i4 && i >= 0) {
            this.zzi = i3 + i;
            return;
        }
        if (i < 0) {
            throw zzbfs.zzf();
        }
        int i5 = this.zzk;
        int i6 = i5 + i3;
        int i7 = this.zzl;
        if (i6 + i > i7) {
            zzr((i7 - i5) - i3);
            throw zzbfs.zzj();
        }
        this.zzk = i6;
        this.zzg = 0;
        this.zzi = 0;
        while (i4 < i) {
            try {
                long j = i - i4;
                try {
                    long jSkip = this.zze.skip(j);
                    if (jSkip < 0 || jSkip > j) {
                        throw new IllegalStateException(String.valueOf(this.zze.getClass()) + "#skip returned invalid result: " + jSkip + "\nThe InputStream implementation is buggy.");
                    }
                    if (jSkip == 0) {
                        break;
                    } else {
                        i4 += (int) jSkip;
                    }
                } catch (zzbfs e) {
                    e.zzk();
                    throw e;
                }
            } finally {
                this.zzk += i4;
                zzv();
            }
        }
        if (i4 >= i) {
            return;
        }
        int i8 = this.zzg;
        int i9 = i8 - this.zzi;
        this.zzi = i8;
        zzw(1);
        while (true) {
            int i10 = i - i9;
            int i11 = this.zzg;
            if (i10 <= i11) {
                this.zzi = i10;
                return;
            } else {
                i9 += i11;
                this.zzi = i11;
                zzw(1);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0067, code lost:
    
        if (r2[r3] >= 0) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int zzn() throws java.io.IOException {
        /*
            r5 = this;
            int r0 = r5.zzi
            int r1 = r5.zzg
            if (r1 != r0) goto L7
            goto L6c
        L7:
            byte[] r2 = r5.zzf
            int r3 = r0 + 1
            r0 = r2[r0]
            if (r0 < 0) goto L12
            r5.zzi = r3
            return r0
        L12:
            int r1 = r1 - r3
            r4 = 9
            if (r1 < r4) goto L6c
            int r1 = r3 + 1
            r3 = r2[r3]
            int r3 = r3 << 7
            r0 = r0 ^ r3
            if (r0 >= 0) goto L23
            r0 = r0 ^ (-128(0xffffffffffffff80, float:NaN))
            goto L69
        L23:
            int r3 = r1 + 1
            r1 = r2[r1]
            int r1 = r1 << 14
            r0 = r0 ^ r1
            if (r0 < 0) goto L30
            r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
        L2e:
            r1 = r3
            goto L69
        L30:
            int r1 = r3 + 1
            r3 = r2[r3]
            int r3 = r3 << 21
            r0 = r0 ^ r3
            if (r0 >= 0) goto L3e
            r2 = -2080896(0xffffffffffe03f80, float:NaN)
            r0 = r0 ^ r2
            goto L69
        L3e:
            int r3 = r1 + 1
            r1 = r2[r1]
            int r4 = r1 << 28
            r0 = r0 ^ r4
            r4 = 266354560(0xfe03f80, float:2.2112565E-29)
            r0 = r0 ^ r4
            if (r1 >= 0) goto L2e
            int r1 = r3 + 1
            r3 = r2[r3]
            if (r3 >= 0) goto L69
            int r3 = r1 + 1
            r1 = r2[r1]
            if (r1 >= 0) goto L2e
            int r1 = r3 + 1
            r3 = r2[r3]
            if (r3 >= 0) goto L69
            int r3 = r1 + 1
            r1 = r2[r1]
            if (r1 >= 0) goto L2e
            int r1 = r3 + 1
            r2 = r2[r3]
            if (r2 < 0) goto L6c
        L69:
            r5.zzi = r1
            return r0
        L6c:
            long r0 = r5.zzq()
            int r0 = (int) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzbca.zzn():int");
    }

    @Override // com.google.android.gms.internal.gtm.zzbcc
    public final boolean zzk(int i) throws IOException {
        int iZzc;
        int i2 = i & 7;
        int i3 = 0;
        if (i2 == 0) {
            if (this.zzg - this.zzi < 10) {
                while (i3 < 10) {
                    if (zzl() < 0) {
                        i3++;
                    }
                }
                throw zzbfs.zze();
            }
            while (i3 < 10) {
                byte[] bArr = this.zzf;
                int i4 = this.zzi;
                this.zzi = i4 + 1;
                if (bArr[i4] < 0) {
                    i3++;
                }
            }
            throw zzbfs.zze();
            return true;
        }
        if (i2 == 1) {
            zzr(8);
            return true;
        }
        if (i2 == 2) {
            zzr(zzn());
            return true;
        }
        if (i2 != 3) {
            if (i2 == 4) {
                return false;
            }
            if (i2 != 5) {
                throw zzbfs.zza();
            }
            zzr(4);
            return true;
        }
        do {
            iZzc = zzc();
            if (iZzc == 0) {
                break;
            }
        } while (zzk(iZzc));
        zzg(((i >>> 3) << 3) | 4);
        return true;
    }

    public final long zzp() throws IOException {
        long j;
        long j2;
        long j3;
        long j4;
        int i;
        int i2 = this.zzi;
        int i3 = this.zzg;
        if (i3 != i2) {
            byte[] bArr = this.zzf;
            int i4 = i2 + 1;
            byte b = bArr[i2];
            if (b >= 0) {
                this.zzi = i4;
                return b;
            }
            if (i3 - i4 >= 9) {
                int i5 = i4 + 1;
                int i6 = b ^ (bArr[i4] << 7);
                if (i6 >= 0) {
                    int i7 = i5 + 1;
                    int i8 = i6 ^ (bArr[i5] << 14);
                    if (i8 >= 0) {
                        j = i8 ^ 16256;
                    } else {
                        i5 = i7 + 1;
                        int i9 = i8 ^ (bArr[i7] << 21);
                        if (i9 < 0) {
                            i = i9 ^ (-2080896);
                        } else {
                            i7 = i5 + 1;
                            long j5 = (((long) bArr[i5]) << 28) ^ ((long) i9);
                            if (j5 < 0) {
                                int i10 = i7 + 1;
                                long j6 = j5 ^ (((long) bArr[i7]) << 35);
                                if (j6 < 0) {
                                    j3 = -34093383808L;
                                } else {
                                    i7 = i10 + 1;
                                    j5 = j6 ^ (((long) bArr[i10]) << 42);
                                    if (j5 >= 0) {
                                        j4 = 4363953127296L;
                                    } else {
                                        i10 = i7 + 1;
                                        j6 = j5 ^ (((long) bArr[i7]) << 49);
                                        if (j6 < 0) {
                                            j3 = -558586000294016L;
                                        } else {
                                            i7 = i10 + 1;
                                            j = (j6 ^ (((long) bArr[i10]) << 56)) ^ 71499008037633920L;
                                            if (j < 0) {
                                                i10 = i7 + 1;
                                                if (bArr[i7] >= 0) {
                                                    j2 = j;
                                                    i5 = i10;
                                                    this.zzi = i5;
                                                    return j2;
                                                }
                                            }
                                        }
                                    }
                                }
                                j2 = j3 ^ j6;
                                i5 = i10;
                                this.zzi = i5;
                                return j2;
                            }
                            j4 = 266354560;
                            j = j5 ^ j4;
                        }
                    }
                    i5 = i7;
                    j2 = j;
                    this.zzi = i5;
                    return j2;
                }
                i = i6 ^ (-128);
                j2 = i;
                this.zzi = i5;
                return j2;
            }
        }
        return zzq();
    }
}
