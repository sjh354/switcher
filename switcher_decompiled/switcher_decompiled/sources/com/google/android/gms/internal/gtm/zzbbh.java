package com.google.android.gms.internal.gtm;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
final class zzbbh extends zzbbj {
    private final byte[] zza;
    private int zzb;
    private int zzc;
    private int zzd;
    private int zze;

    public zzbbh(ByteBuffer byteBuffer, boolean z) {
        super(null);
        this.zza = byteBuffer.array();
        this.zzb = byteBuffer.arrayOffset() + byteBuffer.position();
        this.zzc = byteBuffer.arrayOffset() + byteBuffer.limit();
    }

    private final byte zzU() throws IOException {
        int i = this.zzb;
        if (i == this.zzc) {
            throw zzbfs.zzj();
        }
        byte[] bArr = this.zza;
        this.zzb = i + 1;
        return bArr[i];
    }

    private final int zzV() throws IOException {
        zzad(4);
        return zzW();
    }

    private final int zzW() {
        int i = this.zzb;
        byte[] bArr = this.zza;
        this.zzb = i + 4;
        return ((bArr[i + 3] & UByte.MAX_VALUE) << 24) | (bArr[i] & UByte.MAX_VALUE) | ((bArr[i + 1] & UByte.MAX_VALUE) << 8) | ((bArr[i + 2] & UByte.MAX_VALUE) << 16);
    }

    private final int zzX() throws IOException {
        int i;
        int i2 = this.zzb;
        int i3 = this.zzc;
        if (i3 == i2) {
            throw zzbfs.zzj();
        }
        byte[] bArr = this.zza;
        int i4 = i2 + 1;
        byte b = bArr[i2];
        if (b >= 0) {
            this.zzb = i4;
            return b;
        }
        if (i3 - i4 < 9) {
            return (int) zzaa();
        }
        int i5 = i4 + 1;
        int i6 = b ^ (bArr[i4] << 7);
        if (i6 < 0) {
            i = i6 ^ (-128);
        } else {
            int i7 = i5 + 1;
            int i8 = i6 ^ (bArr[i5] << 14);
            if (i8 >= 0) {
                i = i8 ^ 16256;
            } else {
                i5 = i7 + 1;
                int i9 = i8 ^ (bArr[i7] << 21);
                if (i9 < 0) {
                    i = i9 ^ (-2080896);
                } else {
                    i7 = i5 + 1;
                    byte b2 = bArr[i5];
                    i = (i9 ^ (b2 << 28)) ^ 266354560;
                    if (b2 < 0) {
                        i5 = i7 + 1;
                        if (bArr[i7] < 0) {
                            i7 = i5 + 1;
                            if (bArr[i5] < 0) {
                                i5 = i7 + 1;
                                if (bArr[i7] < 0) {
                                    i7 = i5 + 1;
                                    if (bArr[i5] < 0) {
                                        i5 = i7 + 1;
                                        if (bArr[i7] < 0) {
                                            throw zzbfs.zze();
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            i5 = i7;
        }
        this.zzb = i5;
        return i;
    }

    private final long zzY() throws IOException {
        zzad(8);
        return zzZ();
    }

    private final long zzZ() {
        int i = this.zzb;
        byte[] bArr = this.zza;
        this.zzb = i + 8;
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    private final long zzaa() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte bZzU = zzU();
            j |= ((long) (bZzU & ByteCompanionObject.MAX_VALUE)) << i;
            if ((bZzU & ByteCompanionObject.MIN_VALUE) == 0) {
                return j;
            }
        }
        throw zzbfs.zze();
    }

    private final Object zzab(zzbhf zzbhfVar, zzbep zzbepVar) throws IOException {
        int i = this.zze;
        this.zze = ((this.zzd >>> 3) << 3) | 4;
        try {
            Object objZze = zzbhfVar.zze();
            zzbhfVar.zzh(objZze, this, zzbepVar);
            zzbhfVar.zzf(objZze);
            if (this.zzd == this.zze) {
                return objZze;
            }
            throw zzbfs.zzg();
        } finally {
            this.zze = i;
        }
    }

    private final Object zzac(zzbhf zzbhfVar, zzbep zzbepVar) throws IOException {
        int iZzX = zzX();
        zzad(iZzX);
        int i = this.zzc;
        int i2 = this.zzb + iZzX;
        this.zzc = i2;
        try {
            Object objZze = zzbhfVar.zze();
            zzbhfVar.zzh(objZze, this, zzbepVar);
            zzbhfVar.zzf(objZze);
            if (this.zzb == i2) {
                return objZze;
            }
            throw zzbfs.zzg();
        } finally {
            this.zzc = i;
        }
    }

    private final void zzad(int i) throws IOException {
        if (i < 0 || i > this.zzc - this.zzb) {
            throw zzbfs.zzj();
        }
    }

    private final void zzae(int i) throws IOException {
        if (this.zzb != i) {
            throw zzbfs.zzj();
        }
    }

    private final void zzaf(int i) throws IOException {
        if ((this.zzd & 7) != i) {
            throw zzbfs.zza();
        }
    }

    private final void zzag(int i) throws IOException {
        zzad(i);
        this.zzb += i;
    }

    private final void zzah(int i) throws IOException {
        zzad(i);
        if ((i & 3) != 0) {
            throw zzbfs.zzg();
        }
    }

    private final void zzai(int i) throws IOException {
        zzad(i);
        if ((i & 7) != 0) {
            throw zzbfs.zzg();
        }
    }

    private final boolean zzaj() {
        return this.zzb == this.zzc;
    }

    @Override // com.google.android.gms.internal.gtm.zzbhe
    public final void zzA(List list) throws IOException {
        int i;
        int i2;
        if (!(list instanceof zzbej)) {
            int i3 = this.zzd & 7;
            if (i3 == 1) {
                do {
                    list.add(Double.valueOf(zza()));
                    if (zzaj()) {
                        return;
                    } else {
                        i = this.zzb;
                    }
                } while (zzX() == this.zzd);
                this.zzb = i;
                return;
            }
            if (i3 != 2) {
                throw zzbfs.zza();
            }
            int iZzX = zzX();
            zzai(iZzX);
            int i4 = this.zzb + iZzX;
            while (this.zzb < i4) {
                list.add(Double.valueOf(Double.longBitsToDouble(zzZ())));
            }
            return;
        }
        zzbej zzbejVar = (zzbej) list;
        int i5 = this.zzd & 7;
        if (i5 == 1) {
            do {
                zzbejVar.zze(zza());
                if (zzaj()) {
                    return;
                } else {
                    i2 = this.zzb;
                }
            } while (zzX() == this.zzd);
            this.zzb = i2;
            return;
        }
        if (i5 != 2) {
            throw zzbfs.zza();
        }
        int iZzX2 = zzX();
        zzai(iZzX2);
        int i6 = this.zzb + iZzX2;
        while (this.zzb < i6) {
            zzbejVar.zze(Double.longBitsToDouble(zzZ()));
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzbhe
    public final void zzB(List list) throws IOException {
        int i;
        int i2;
        if (!(list instanceof zzbfg)) {
            int i3 = this.zzd & 7;
            if (i3 != 0) {
                if (i3 != 2) {
                    throw zzbfs.zza();
                }
                int iZzX = this.zzb + zzX();
                while (this.zzb < iZzX) {
                    list.add(Integer.valueOf(zzX()));
                }
                return;
            }
            do {
                list.add(Integer.valueOf(zze()));
                if (zzaj()) {
                    return;
                } else {
                    i = this.zzb;
                }
            } while (zzX() == this.zzd);
            this.zzb = i;
            return;
        }
        zzbfg zzbfgVar = (zzbfg) list;
        int i4 = this.zzd & 7;
        if (i4 != 0) {
            if (i4 != 2) {
                throw zzbfs.zza();
            }
            int iZzX2 = this.zzb + zzX();
            while (this.zzb < iZzX2) {
                zzbfgVar.zzh(zzX());
            }
            return;
        }
        do {
            zzbfgVar.zzh(zze());
            if (zzaj()) {
                return;
            } else {
                i2 = this.zzb;
            }
        } while (zzX() == this.zzd);
        this.zzb = i2;
    }

    @Override // com.google.android.gms.internal.gtm.zzbhe
    public final void zzC(List list) throws IOException {
        int i;
        int i2;
        if (!(list instanceof zzbfg)) {
            int i3 = this.zzd & 7;
            if (i3 == 2) {
                int iZzX = zzX();
                zzah(iZzX);
                int i4 = this.zzb + iZzX;
                while (this.zzb < i4) {
                    list.add(Integer.valueOf(zzW()));
                }
                return;
            }
            if (i3 != 5) {
                throw zzbfs.zza();
            }
            do {
                list.add(Integer.valueOf(zzf()));
                if (zzaj()) {
                    return;
                } else {
                    i = this.zzb;
                }
            } while (zzX() == this.zzd);
            this.zzb = i;
            return;
        }
        zzbfg zzbfgVar = (zzbfg) list;
        int i5 = this.zzd & 7;
        if (i5 == 2) {
            int iZzX2 = zzX();
            zzah(iZzX2);
            int i6 = this.zzb + iZzX2;
            while (this.zzb < i6) {
                zzbfgVar.zzh(zzW());
            }
            return;
        }
        if (i5 != 5) {
            throw zzbfs.zza();
        }
        do {
            zzbfgVar.zzh(zzf());
            if (zzaj()) {
                return;
            } else {
                i2 = this.zzb;
            }
        } while (zzX() == this.zzd);
        this.zzb = i2;
    }

    @Override // com.google.android.gms.internal.gtm.zzbhe
    public final void zzD(List list) throws IOException {
        int i;
        int i2;
        if (!(list instanceof zzbgh)) {
            int i3 = this.zzd & 7;
            if (i3 == 1) {
                do {
                    list.add(Long.valueOf(zzk()));
                    if (zzaj()) {
                        return;
                    } else {
                        i = this.zzb;
                    }
                } while (zzX() == this.zzd);
                this.zzb = i;
                return;
            }
            if (i3 != 2) {
                throw zzbfs.zza();
            }
            int iZzX = zzX();
            zzai(iZzX);
            int i4 = this.zzb + iZzX;
            while (this.zzb < i4) {
                list.add(Long.valueOf(zzZ()));
            }
            return;
        }
        zzbgh zzbghVar = (zzbgh) list;
        int i5 = this.zzd & 7;
        if (i5 == 1) {
            do {
                zzbghVar.zzg(zzk());
                if (zzaj()) {
                    return;
                } else {
                    i2 = this.zzb;
                }
            } while (zzX() == this.zzd);
            this.zzb = i2;
            return;
        }
        if (i5 != 2) {
            throw zzbfs.zza();
        }
        int iZzX2 = zzX();
        zzai(iZzX2);
        int i6 = this.zzb + iZzX2;
        while (this.zzb < i6) {
            zzbghVar.zzg(zzZ());
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzbhe
    public final void zzE(List list) throws IOException {
        int i;
        int i2;
        if (!(list instanceof zzbew)) {
            int i3 = this.zzd & 7;
            if (i3 == 2) {
                int iZzX = zzX();
                zzah(iZzX);
                int i4 = this.zzb + iZzX;
                while (this.zzb < i4) {
                    list.add(Float.valueOf(Float.intBitsToFloat(zzW())));
                }
                return;
            }
            if (i3 != 5) {
                throw zzbfs.zza();
            }
            do {
                list.add(Float.valueOf(zzb()));
                if (zzaj()) {
                    return;
                } else {
                    i = this.zzb;
                }
            } while (zzX() == this.zzd);
            this.zzb = i;
            return;
        }
        zzbew zzbewVar = (zzbew) list;
        int i5 = this.zzd & 7;
        if (i5 == 2) {
            int iZzX2 = zzX();
            zzah(iZzX2);
            int i6 = this.zzb + iZzX2;
            while (this.zzb < i6) {
                zzbewVar.zzf(Float.intBitsToFloat(zzW()));
            }
            return;
        }
        if (i5 != 5) {
            throw zzbfs.zza();
        }
        do {
            zzbewVar.zzf(zzb());
            if (zzaj()) {
                return;
            } else {
                i2 = this.zzb;
            }
        } while (zzX() == this.zzd);
        this.zzb = i2;
    }

    @Override // com.google.android.gms.internal.gtm.zzbhe
    @Deprecated
    public final void zzF(List list, zzbhf zzbhfVar, zzbep zzbepVar) throws IOException {
        int i;
        int i2 = this.zzd;
        if ((i2 & 7) != 3) {
            throw zzbfs.zza();
        }
        do {
            list.add(zzab(zzbhfVar, zzbepVar));
            if (zzaj()) {
                return;
            } else {
                i = this.zzb;
            }
        } while (zzX() == i2);
        this.zzb = i;
    }

    @Override // com.google.android.gms.internal.gtm.zzbhe
    public final void zzG(List list) throws IOException {
        int i;
        int i2;
        if (!(list instanceof zzbfg)) {
            int i3 = this.zzd & 7;
            if (i3 == 0) {
                do {
                    list.add(Integer.valueOf(zzg()));
                    if (zzaj()) {
                        return;
                    } else {
                        i = this.zzb;
                    }
                } while (zzX() == this.zzd);
                this.zzb = i;
                return;
            }
            if (i3 != 2) {
                throw zzbfs.zza();
            }
            int iZzX = this.zzb + zzX();
            while (this.zzb < iZzX) {
                list.add(Integer.valueOf(zzX()));
            }
            zzae(iZzX);
            return;
        }
        zzbfg zzbfgVar = (zzbfg) list;
        int i4 = this.zzd & 7;
        if (i4 == 0) {
            do {
                zzbfgVar.zzh(zzg());
                if (zzaj()) {
                    return;
                } else {
                    i2 = this.zzb;
                }
            } while (zzX() == this.zzd);
            this.zzb = i2;
            return;
        }
        if (i4 != 2) {
            throw zzbfs.zza();
        }
        int iZzX2 = this.zzb + zzX();
        while (this.zzb < iZzX2) {
            zzbfgVar.zzh(zzX());
        }
        zzae(iZzX2);
    }

    @Override // com.google.android.gms.internal.gtm.zzbhe
    public final void zzH(List list) throws IOException {
        int i;
        int i2;
        if (!(list instanceof zzbgh)) {
            int i3 = this.zzd & 7;
            if (i3 == 0) {
                do {
                    list.add(Long.valueOf(zzl()));
                    if (zzaj()) {
                        return;
                    } else {
                        i = this.zzb;
                    }
                } while (zzX() == this.zzd);
                this.zzb = i;
                return;
            }
            if (i3 != 2) {
                throw zzbfs.zza();
            }
            int iZzX = this.zzb + zzX();
            while (this.zzb < iZzX) {
                list.add(Long.valueOf(zzp()));
            }
            zzae(iZzX);
            return;
        }
        zzbgh zzbghVar = (zzbgh) list;
        int i4 = this.zzd & 7;
        if (i4 == 0) {
            do {
                zzbghVar.zzg(zzl());
                if (zzaj()) {
                    return;
                } else {
                    i2 = this.zzb;
                }
            } while (zzX() == this.zzd);
            this.zzb = i2;
            return;
        }
        if (i4 != 2) {
            throw zzbfs.zza();
        }
        int iZzX2 = this.zzb + zzX();
        while (this.zzb < iZzX2) {
            zzbghVar.zzg(zzp());
        }
        zzae(iZzX2);
    }

    @Override // com.google.android.gms.internal.gtm.zzbhe
    public final void zzI(List list, zzbhf zzbhfVar, zzbep zzbepVar) throws IOException {
        int i;
        int i2 = this.zzd;
        if ((i2 & 7) != 2) {
            throw zzbfs.zza();
        }
        do {
            list.add(zzac(zzbhfVar, zzbepVar));
            if (zzaj()) {
                return;
            } else {
                i = this.zzb;
            }
        } while (zzX() == i2);
        this.zzb = i;
    }

    @Override // com.google.android.gms.internal.gtm.zzbhe
    public final void zzJ(List list) throws IOException {
        int i;
        int i2;
        if (!(list instanceof zzbfg)) {
            int i3 = this.zzd & 7;
            if (i3 == 2) {
                int iZzX = zzX();
                zzah(iZzX);
                int i4 = this.zzb + iZzX;
                while (this.zzb < i4) {
                    list.add(Integer.valueOf(zzW()));
                }
                return;
            }
            if (i3 != 5) {
                throw zzbfs.zza();
            }
            do {
                list.add(Integer.valueOf(zzh()));
                if (zzaj()) {
                    return;
                } else {
                    i = this.zzb;
                }
            } while (zzX() == this.zzd);
            this.zzb = i;
            return;
        }
        zzbfg zzbfgVar = (zzbfg) list;
        int i5 = this.zzd & 7;
        if (i5 == 2) {
            int iZzX2 = zzX();
            zzah(iZzX2);
            int i6 = this.zzb + iZzX2;
            while (this.zzb < i6) {
                zzbfgVar.zzh(zzW());
            }
            return;
        }
        if (i5 != 5) {
            throw zzbfs.zza();
        }
        do {
            zzbfgVar.zzh(zzh());
            if (zzaj()) {
                return;
            } else {
                i2 = this.zzb;
            }
        } while (zzX() == this.zzd);
        this.zzb = i2;
    }

    @Override // com.google.android.gms.internal.gtm.zzbhe
    public final void zzK(List list) throws IOException {
        int i;
        int i2;
        if (!(list instanceof zzbgh)) {
            int i3 = this.zzd & 7;
            if (i3 == 1) {
                do {
                    list.add(Long.valueOf(zzm()));
                    if (zzaj()) {
                        return;
                    } else {
                        i = this.zzb;
                    }
                } while (zzX() == this.zzd);
                this.zzb = i;
                return;
            }
            if (i3 != 2) {
                throw zzbfs.zza();
            }
            int iZzX = zzX();
            zzai(iZzX);
            int i4 = this.zzb + iZzX;
            while (this.zzb < i4) {
                list.add(Long.valueOf(zzZ()));
            }
            return;
        }
        zzbgh zzbghVar = (zzbgh) list;
        int i5 = this.zzd & 7;
        if (i5 == 1) {
            do {
                zzbghVar.zzg(zzm());
                if (zzaj()) {
                    return;
                } else {
                    i2 = this.zzb;
                }
            } while (zzX() == this.zzd);
            this.zzb = i2;
            return;
        }
        if (i5 != 2) {
            throw zzbfs.zza();
        }
        int iZzX2 = zzX();
        zzai(iZzX2);
        int i6 = this.zzb + iZzX2;
        while (this.zzb < i6) {
            zzbghVar.zzg(zzZ());
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzbhe
    public final void zzL(List list) throws IOException {
        int i;
        int i2;
        if (!(list instanceof zzbfg)) {
            int i3 = this.zzd & 7;
            if (i3 != 0) {
                if (i3 != 2) {
                    throw zzbfs.zza();
                }
                int iZzX = this.zzb + zzX();
                while (this.zzb < iZzX) {
                    list.add(Integer.valueOf(zzbcc.zzs(zzX())));
                }
                return;
            }
            do {
                list.add(Integer.valueOf(zzi()));
                if (zzaj()) {
                    return;
                } else {
                    i = this.zzb;
                }
            } while (zzX() == this.zzd);
            this.zzb = i;
            return;
        }
        zzbfg zzbfgVar = (zzbfg) list;
        int i4 = this.zzd & 7;
        if (i4 != 0) {
            if (i4 != 2) {
                throw zzbfs.zza();
            }
            int iZzX2 = this.zzb + zzX();
            while (this.zzb < iZzX2) {
                zzbfgVar.zzh(zzbcc.zzs(zzX()));
            }
            return;
        }
        do {
            zzbfgVar.zzh(zzi());
            if (zzaj()) {
                return;
            } else {
                i2 = this.zzb;
            }
        } while (zzX() == this.zzd);
        this.zzb = i2;
    }

    @Override // com.google.android.gms.internal.gtm.zzbhe
    public final void zzM(List list) throws IOException {
        int i;
        int i2;
        if (!(list instanceof zzbgh)) {
            int i3 = this.zzd & 7;
            if (i3 != 0) {
                if (i3 != 2) {
                    throw zzbfs.zza();
                }
                int iZzX = this.zzb + zzX();
                while (this.zzb < iZzX) {
                    list.add(Long.valueOf(zzbcc.zzt(zzp())));
                }
                return;
            }
            do {
                list.add(Long.valueOf(zzn()));
                if (zzaj()) {
                    return;
                } else {
                    i = this.zzb;
                }
            } while (zzX() == this.zzd);
            this.zzb = i;
            return;
        }
        zzbgh zzbghVar = (zzbgh) list;
        int i4 = this.zzd & 7;
        if (i4 != 0) {
            if (i4 != 2) {
                throw zzbfs.zza();
            }
            int iZzX2 = this.zzb + zzX();
            while (this.zzb < iZzX2) {
                zzbghVar.zzg(zzbcc.zzt(zzp()));
            }
            return;
        }
        do {
            zzbghVar.zzg(zzn());
            if (zzaj()) {
                return;
            } else {
                i2 = this.zzb;
            }
        } while (zzX() == this.zzd);
        this.zzb = i2;
    }

    @Override // com.google.android.gms.internal.gtm.zzbhe
    public final void zzN(List list) throws IOException {
        zzO(list, false);
    }

    public final void zzO(List list, boolean z) throws IOException {
        int i;
        int i2;
        if ((this.zzd & 7) != 2) {
            throw zzbfs.zza();
        }
        if (!(list instanceof zzbga) || z) {
            do {
                list.add(zzw(z));
                if (zzaj()) {
                    return;
                } else {
                    i = this.zzb;
                }
            } while (zzX() == this.zzd);
            this.zzb = i;
            return;
        }
        zzbga zzbgaVar = (zzbga) list;
        do {
            zzbgaVar.zzi(zzq());
            if (zzaj()) {
                return;
            } else {
                i2 = this.zzb;
            }
        } while (zzX() == this.zzd);
        this.zzb = i2;
    }

    @Override // com.google.android.gms.internal.gtm.zzbhe
    public final void zzP(List list) throws IOException {
        zzO(list, true);
    }

    @Override // com.google.android.gms.internal.gtm.zzbhe
    public final void zzQ(List list) throws IOException {
        int i;
        int i2;
        if (!(list instanceof zzbfg)) {
            int i3 = this.zzd & 7;
            if (i3 != 0) {
                if (i3 != 2) {
                    throw zzbfs.zza();
                }
                int iZzX = this.zzb + zzX();
                while (this.zzb < iZzX) {
                    list.add(Integer.valueOf(zzX()));
                }
                return;
            }
            do {
                list.add(Integer.valueOf(zzj()));
                if (zzaj()) {
                    return;
                } else {
                    i = this.zzb;
                }
            } while (zzX() == this.zzd);
            this.zzb = i;
            return;
        }
        zzbfg zzbfgVar = (zzbfg) list;
        int i4 = this.zzd & 7;
        if (i4 != 0) {
            if (i4 != 2) {
                throw zzbfs.zza();
            }
            int iZzX2 = this.zzb + zzX();
            while (this.zzb < iZzX2) {
                zzbfgVar.zzh(zzX());
            }
            return;
        }
        do {
            zzbfgVar.zzh(zzj());
            if (zzaj()) {
                return;
            } else {
                i2 = this.zzb;
            }
        } while (zzX() == this.zzd);
        this.zzb = i2;
    }

    @Override // com.google.android.gms.internal.gtm.zzbhe
    public final void zzR(List list) throws IOException {
        int i;
        int i2;
        if (!(list instanceof zzbgh)) {
            int i3 = this.zzd & 7;
            if (i3 == 0) {
                do {
                    list.add(Long.valueOf(zzo()));
                    if (zzaj()) {
                        return;
                    } else {
                        i = this.zzb;
                    }
                } while (zzX() == this.zzd);
                this.zzb = i;
                return;
            }
            if (i3 != 2) {
                throw zzbfs.zza();
            }
            int iZzX = this.zzb + zzX();
            while (this.zzb < iZzX) {
                list.add(Long.valueOf(zzp()));
            }
            zzae(iZzX);
            return;
        }
        zzbgh zzbghVar = (zzbgh) list;
        int i4 = this.zzd & 7;
        if (i4 == 0) {
            do {
                zzbghVar.zzg(zzo());
                if (zzaj()) {
                    return;
                } else {
                    i2 = this.zzb;
                }
            } while (zzX() == this.zzd);
            this.zzb = i2;
            return;
        }
        if (i4 != 2) {
            throw zzbfs.zza();
        }
        int iZzX2 = this.zzb + zzX();
        while (this.zzb < iZzX2) {
            zzbghVar.zzg(zzp());
        }
        zzae(iZzX2);
    }

    @Override // com.google.android.gms.internal.gtm.zzbhe
    public final boolean zzS() throws IOException {
        zzaf(0);
        return zzX() != 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0076  */
    @Override // com.google.android.gms.internal.gtm.zzbhe
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean zzT() throws java.io.IOException {
        /*
            r7 = this;
            boolean r0 = r7.zzaj()
            r1 = 0
            if (r0 != 0) goto L85
            int r0 = r7.zzd
            int r2 = r7.zze
            if (r0 != r2) goto Lf
            goto L85
        Lf:
            r3 = r0 & 7
            r4 = 1
            if (r3 == 0) goto L59
            if (r3 == r4) goto L53
            r1 = 2
            if (r3 == r1) goto L4b
            r1 = 4
            r5 = 3
            if (r3 == r5) goto L29
            r0 = 5
            if (r3 != r0) goto L24
            r7.zzag(r1)
            return r4
        L24:
            com.google.android.gms.internal.gtm.zzbfr r0 = com.google.android.gms.internal.gtm.zzbfs.zza()
            throw r0
        L29:
            int r0 = r0 >>> r5
            int r0 = r0 << r5
            r0 = r0 | r1
            r7.zze = r0
        L2e:
            int r0 = r7.zzc()
            r1 = 2147483647(0x7fffffff, float:NaN)
            if (r0 == r1) goto L3d
            boolean r0 = r7.zzT()
            if (r0 != 0) goto L2e
        L3d:
            int r0 = r7.zzd
            int r1 = r7.zze
            if (r0 != r1) goto L46
            r7.zze = r2
            return r4
        L46:
            com.google.android.gms.internal.gtm.zzbfs r0 = com.google.android.gms.internal.gtm.zzbfs.zzg()
            throw r0
        L4b:
            int r0 = r7.zzX()
            r7.zzag(r0)
            return r4
        L53:
            r0 = 8
            r7.zzag(r0)
            return r4
        L59:
            int r0 = r7.zzc
            int r2 = r7.zzb
            int r0 = r0 - r2
            r3 = 10
            if (r0 < r3) goto L74
            byte[] r0 = r7.zza
            r5 = r1
        L65:
            if (r5 >= r3) goto L74
            int r6 = r2 + 1
            r2 = r0[r2]
            if (r2 < 0) goto L70
            r7.zzb = r6
            goto L7f
        L70:
            int r5 = r5 + 1
            r2 = r6
            goto L65
        L74:
            if (r1 >= r3) goto L80
            byte r0 = r7.zzU()
            if (r0 >= 0) goto L7f
            int r1 = r1 + 1
            goto L74
        L7f:
            return r4
        L80:
            com.google.android.gms.internal.gtm.zzbfs r0 = com.google.android.gms.internal.gtm.zzbfs.zze()
            throw r0
        L85:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzbbh.zzT():boolean");
    }

    @Override // com.google.android.gms.internal.gtm.zzbhe
    public final double zza() throws IOException {
        zzaf(1);
        return Double.longBitsToDouble(zzY());
    }

    @Override // com.google.android.gms.internal.gtm.zzbhe
    public final float zzb() throws IOException {
        zzaf(5);
        return Float.intBitsToFloat(zzV());
    }

    @Override // com.google.android.gms.internal.gtm.zzbhe
    public final int zzc() throws IOException {
        if (zzaj()) {
            return Integer.MAX_VALUE;
        }
        int iZzX = zzX();
        this.zzd = iZzX;
        if (iZzX == this.zze) {
            return Integer.MAX_VALUE;
        }
        return iZzX >>> 3;
    }

    @Override // com.google.android.gms.internal.gtm.zzbhe
    public final int zzd() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.gtm.zzbhe
    public final int zze() throws IOException {
        zzaf(0);
        return zzX();
    }

    @Override // com.google.android.gms.internal.gtm.zzbhe
    public final int zzf() throws IOException {
        zzaf(5);
        return zzV();
    }

    @Override // com.google.android.gms.internal.gtm.zzbhe
    public final int zzg() throws IOException {
        zzaf(0);
        return zzX();
    }

    @Override // com.google.android.gms.internal.gtm.zzbhe
    public final int zzh() throws IOException {
        zzaf(5);
        return zzV();
    }

    @Override // com.google.android.gms.internal.gtm.zzbhe
    public final int zzi() throws IOException {
        zzaf(0);
        return zzbcc.zzs(zzX());
    }

    @Override // com.google.android.gms.internal.gtm.zzbhe
    public final int zzj() throws IOException {
        zzaf(0);
        return zzX();
    }

    @Override // com.google.android.gms.internal.gtm.zzbhe
    public final long zzk() throws IOException {
        zzaf(1);
        return zzY();
    }

    @Override // com.google.android.gms.internal.gtm.zzbhe
    public final long zzl() throws IOException {
        zzaf(0);
        return zzp();
    }

    @Override // com.google.android.gms.internal.gtm.zzbhe
    public final long zzm() throws IOException {
        zzaf(1);
        return zzY();
    }

    @Override // com.google.android.gms.internal.gtm.zzbhe
    public final long zzn() throws IOException {
        zzaf(0);
        return zzbcc.zzt(zzp());
    }

    @Override // com.google.android.gms.internal.gtm.zzbhe
    public final long zzo() throws IOException {
        zzaf(0);
        return zzp();
    }

    public final long zzp() throws IOException {
        long j;
        long j2;
        long j3;
        long j4;
        int i;
        int i2 = this.zzb;
        int i3 = this.zzc;
        if (i3 == i2) {
            throw zzbfs.zzj();
        }
        byte[] bArr = this.zza;
        int i4 = i2 + 1;
        byte b = bArr[i2];
        if (b >= 0) {
            this.zzb = i4;
            return b;
        }
        if (i3 - i4 < 9) {
            return zzaa();
        }
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
                                        if (bArr[i7] < 0) {
                                            throw zzbfs.zze();
                                        }
                                        j2 = j;
                                        i5 = i10;
                                        this.zzb = i5;
                                        return j2;
                                    }
                                }
                            }
                        }
                        j2 = j3 ^ j6;
                        i5 = i10;
                        this.zzb = i5;
                        return j2;
                    }
                    j4 = 266354560;
                    j = j5 ^ j4;
                }
            }
            i5 = i7;
            j2 = j;
            this.zzb = i5;
            return j2;
        }
        i = i6 ^ (-128);
        j2 = i;
        this.zzb = i5;
        return j2;
    }

    @Override // com.google.android.gms.internal.gtm.zzbhe
    public final zzbbw zzq() throws IOException {
        zzaf(2);
        int iZzX = zzX();
        if (iZzX == 0) {
            return zzbbw.zzb;
        }
        zzad(iZzX);
        zzbbw zzbbwVarZzq = zzbbw.zzq(this.zza, this.zzb, iZzX);
        this.zzb += iZzX;
        return zzbbwVarZzq;
    }

    @Override // com.google.android.gms.internal.gtm.zzbhe
    @Deprecated
    public final Object zzr(Class cls, zzbep zzbepVar) throws IOException {
        zzaf(3);
        return zzab(zzbhb.zza().zzb(cls), zzbepVar);
    }

    @Override // com.google.android.gms.internal.gtm.zzbhe
    @Deprecated
    public final Object zzs(zzbhf zzbhfVar, zzbep zzbepVar) throws IOException {
        zzaf(3);
        return zzab(zzbhfVar, zzbepVar);
    }

    @Override // com.google.android.gms.internal.gtm.zzbhe
    public final Object zzt(Class cls, zzbep zzbepVar) throws IOException {
        zzaf(2);
        return zzac(zzbhb.zza().zzb(cls), zzbepVar);
    }

    @Override // com.google.android.gms.internal.gtm.zzbhe
    public final Object zzu(zzbhf zzbhfVar, zzbep zzbepVar) throws IOException {
        zzaf(2);
        return zzac(zzbhfVar, zzbepVar);
    }

    @Override // com.google.android.gms.internal.gtm.zzbhe
    public final String zzv() throws IOException {
        return zzw(false);
    }

    public final String zzw(boolean z) throws IOException {
        zzaf(2);
        int iZzX = zzX();
        if (iZzX == 0) {
            return "";
        }
        zzad(iZzX);
        if (z) {
            byte[] bArr = this.zza;
            int i = this.zzb;
            if (!zzbio.zzf(bArr, i, i + iZzX)) {
                throw zzbfs.zzd();
            }
        }
        String str = new String(this.zza, this.zzb, iZzX, zzbfq.zzb);
        this.zzb += iZzX;
        return str;
    }

    @Override // com.google.android.gms.internal.gtm.zzbhe
    public final String zzx() throws IOException {
        return zzw(true);
    }

    @Override // com.google.android.gms.internal.gtm.zzbhe
    public final void zzy(List list) throws IOException {
        int i;
        int i2;
        if (!(list instanceof zzbbl)) {
            int i3 = this.zzd & 7;
            if (i3 != 0) {
                if (i3 != 2) {
                    throw zzbfs.zza();
                }
                int iZzX = this.zzb + zzX();
                while (this.zzb < iZzX) {
                    list.add(Boolean.valueOf(zzX() != 0));
                }
                zzae(iZzX);
                return;
            }
            do {
                list.add(Boolean.valueOf(zzS()));
                if (zzaj()) {
                    return;
                } else {
                    i = this.zzb;
                }
            } while (zzX() == this.zzd);
            this.zzb = i;
            return;
        }
        zzbbl zzbblVar = (zzbbl) list;
        int i4 = this.zzd & 7;
        if (i4 != 0) {
            if (i4 != 2) {
                throw zzbfs.zza();
            }
            int iZzX2 = this.zzb + zzX();
            while (this.zzb < iZzX2) {
                zzbblVar.zze(zzX() != 0);
            }
            zzae(iZzX2);
            return;
        }
        do {
            zzbblVar.zze(zzS());
            if (zzaj()) {
                return;
            } else {
                i2 = this.zzb;
            }
        } while (zzX() == this.zzd);
        this.zzb = i2;
    }

    @Override // com.google.android.gms.internal.gtm.zzbhe
    public final void zzz(List list) throws IOException {
        int i;
        if ((this.zzd & 7) != 2) {
            throw zzbfs.zza();
        }
        do {
            list.add(zzq());
            if (zzaj()) {
                return;
            } else {
                i = this.zzb;
            }
        } while (zzX() == this.zzd);
        this.zzb = i;
    }
}
