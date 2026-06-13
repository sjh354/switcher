package com.google.android.gms.internal.gtm;

import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbia {
    private static final zzbia zza = new zzbia(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    private zzbia() {
        this(0, new int[8], new Object[8], true);
    }

    private zzbia(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zze = -1;
        this.zzb = i;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z;
    }

    public static zzbia zzc() {
        return zza;
    }

    static zzbia zzd(zzbia zzbiaVar, zzbia zzbiaVar2) {
        int i = zzbiaVar.zzb + zzbiaVar2.zzb;
        int[] iArrCopyOf = Arrays.copyOf(zzbiaVar.zzc, i);
        System.arraycopy(zzbiaVar2.zzc, 0, iArrCopyOf, zzbiaVar.zzb, zzbiaVar2.zzb);
        Object[] objArrCopyOf = Arrays.copyOf(zzbiaVar.zzd, i);
        System.arraycopy(zzbiaVar2.zzd, 0, objArrCopyOf, zzbiaVar.zzb, zzbiaVar2.zzb);
        return new zzbia(i, iArrCopyOf, objArrCopyOf, true);
    }

    static zzbia zze() {
        return new zzbia(0, new int[8], new Object[8], true);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzbia)) {
            return false;
        }
        zzbia zzbiaVar = (zzbia) obj;
        int i = this.zzb;
        if (i == zzbiaVar.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzbiaVar.zzc;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    Object[] objArr = this.zzd;
                    Object[] objArr2 = zzbiaVar.zzd;
                    int i3 = this.zzb;
                    for (int i4 = 0; i4 < i3; i4++) {
                        if (objArr[i4].equals(objArr2[i4])) {
                        }
                    }
                    return true;
                }
                if (iArr[i2] != iArr2[i2]) {
                    break;
                }
                i2++;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.zzb;
        int i2 = (i + 527) * 31;
        int[] iArr = this.zzc;
        int iHashCode = 17;
        int i3 = 17;
        for (int i4 = 0; i4 < i; i4++) {
            i3 = (i3 * 31) + iArr[i4];
        }
        int i5 = (i2 + i3) * 31;
        Object[] objArr = this.zzd;
        int i6 = this.zzb;
        for (int i7 = 0; i7 < i6; i7++) {
            iHashCode = (iHashCode * 31) + objArr[i7].hashCode();
        }
        return i5 + iHashCode;
    }

    public final int zza() {
        int iZzJ;
        int iZzK;
        int iZzJ2;
        int i = this.zze;
        if (i != -1) {
            return i;
        }
        int iZzJ3 = 0;
        for (int i2 = 0; i2 < this.zzb; i2++) {
            int i3 = this.zzc[i2];
            int i4 = i3 >>> 3;
            int i5 = i3 & 7;
            if (i5 != 0) {
                if (i5 == 1) {
                    ((Long) this.zzd[i2]).longValue();
                    iZzJ2 = zzbcj.zzJ(i4 << 3) + 8;
                } else if (i5 == 2) {
                    zzbbw zzbbwVar = (zzbbw) this.zzd[i2];
                    int iZzJ4 = zzbcj.zzJ(i4 << 3);
                    int iZzd = zzbbwVar.zzd();
                    iZzJ3 += iZzJ4 + zzbcj.zzJ(iZzd) + iZzd;
                } else if (i5 == 3) {
                    int iZzI = zzbcj.zzI(i4);
                    iZzJ = iZzI + iZzI;
                    iZzK = ((zzbia) this.zzd[i2]).zza();
                } else {
                    if (i5 != 5) {
                        throw new IllegalStateException(zzbfs.zza());
                    }
                    ((Integer) this.zzd[i2]).intValue();
                    iZzJ2 = zzbcj.zzJ(i4 << 3) + 4;
                }
                iZzJ3 += iZzJ2;
            } else {
                long jLongValue = ((Long) this.zzd[i2]).longValue();
                iZzJ = zzbcj.zzJ(i4 << 3);
                iZzK = zzbcj.zzK(jLongValue);
            }
            iZzJ2 = iZzJ + iZzK;
            iZzJ3 += iZzJ2;
        }
        this.zze = iZzJ3;
        return iZzJ3;
    }

    public final int zzb() {
        int i = this.zze;
        if (i != -1) {
            return i;
        }
        int iZzJ = 0;
        for (int i2 = 0; i2 < this.zzb; i2++) {
            int i3 = this.zzc[i2];
            zzbbw zzbbwVar = (zzbbw) this.zzd[i2];
            int iZzJ2 = zzbcj.zzJ(8);
            int iZzd = zzbbwVar.zzd();
            iZzJ += iZzJ2 + iZzJ2 + zzbcj.zzJ(16) + zzbcj.zzJ(i3 >>> 3) + zzbcj.zzJ(24) + zzbcj.zzJ(iZzd) + iZzd;
        }
        this.zze = iZzJ;
        return iZzJ;
    }

    public final void zzf() {
        this.zzf = false;
    }

    final void zzg(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.zzb; i2++) {
            zzbgu.zzb(sb, i, String.valueOf(this.zzc[i2] >>> 3), this.zzd[i2]);
        }
    }

    final void zzh(int i, Object obj) {
        if (!this.zzf) {
            throw new UnsupportedOperationException();
        }
        int i2 = this.zzb;
        int[] iArr = this.zzc;
        if (i2 == iArr.length) {
            int i3 = i2 + (i2 < 4 ? 8 : i2 >> 1);
            this.zzc = Arrays.copyOf(iArr, i3);
            this.zzd = Arrays.copyOf(this.zzd, i3);
        }
        int[] iArr2 = this.zzc;
        int i4 = this.zzb;
        iArr2[i4] = i;
        this.zzd[i4] = obj;
        this.zzb = i4 + 1;
    }

    final void zzi(zzbck zzbckVar) throws IOException {
        for (int i = 0; i < this.zzb; i++) {
            zzbckVar.zzw(this.zzc[i] >>> 3, this.zzd[i]);
        }
    }

    public final void zzj(zzbck zzbckVar) throws IOException {
        if (this.zzb != 0) {
            for (int i = 0; i < this.zzb; i++) {
                int i2 = this.zzc[i];
                Object obj = this.zzd[i];
                int i3 = i2 >>> 3;
                int i4 = i2 & 7;
                if (i4 == 0) {
                    zzbckVar.zzt(i3, ((Long) obj).longValue());
                } else if (i4 == 1) {
                    zzbckVar.zzm(i3, ((Long) obj).longValue());
                } else if (i4 == 2) {
                    zzbckVar.zzd(i3, (zzbbw) obj);
                } else if (i4 == 3) {
                    zzbckVar.zzF(i3);
                    ((zzbia) obj).zzj(zzbckVar);
                    zzbckVar.zzh(i3);
                } else {
                    if (i4 != 5) {
                        throw new RuntimeException(zzbfs.zza());
                    }
                    zzbckVar.zzk(i3, ((Integer) obj).intValue());
                }
            }
        }
    }
}
