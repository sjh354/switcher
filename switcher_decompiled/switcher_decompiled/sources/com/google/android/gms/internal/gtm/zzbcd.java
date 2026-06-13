package com.google.android.gms.internal.gtm;

import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
final class zzbcd implements zzbhe {
    private final zzbcc zza;
    private int zzb;
    private int zzc;
    private int zzd = 0;

    private zzbcd(zzbcc zzbccVar) {
        zzbfq.zzf(zzbccVar, "input");
        this.zza = zzbccVar;
        zzbccVar.zzc = this;
    }

    private final Object zzO(zzbhf zzbhfVar, zzbep zzbepVar) throws IOException {
        int i = this.zzc;
        this.zzc = ((this.zzb >>> 3) << 3) | 4;
        try {
            Object objZze = zzbhfVar.zze();
            zzbhfVar.zzh(objZze, this, zzbepVar);
            zzbhfVar.zzf(objZze);
            if (this.zzb == this.zzc) {
                return objZze;
            }
            throw zzbfs.zzg();
        } finally {
            this.zzc = i;
        }
    }

    private final Object zzU(zzbhf zzbhfVar, zzbep zzbepVar) throws IOException {
        int iZzn = ((zzbca) this.zza).zzn();
        zzbcc zzbccVar = this.zza;
        if (zzbccVar.zza >= zzbccVar.zzb) {
            throw new zzbfs("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
        }
        int iZzb = zzbccVar.zzb(iZzn);
        Object objZze = zzbhfVar.zze();
        this.zza.zza++;
        zzbhfVar.zzh(objZze, this, zzbepVar);
        zzbhfVar.zzf(objZze);
        this.zza.zzg(0);
        r5.zza--;
        this.zza.zzh(iZzb);
        return objZze;
    }

    private final void zzV(int i) throws IOException {
        if (this.zza.zza() != i) {
            throw zzbfs.zzj();
        }
    }

    private final void zzW(int i) throws IOException {
        if ((this.zzb & 7) != i) {
            throw zzbfs.zza();
        }
    }

    private static final void zzX(int i) throws IOException {
        if ((i & 3) != 0) {
            throw zzbfs.zzg();
        }
    }

    private static final void zzY(int i) throws IOException {
        if ((i & 7) != 0) {
            throw zzbfs.zzg();
        }
    }

    public static zzbcd zzp(zzbcc zzbccVar) {
        zzbcd zzbcdVar = zzbccVar.zzc;
        return zzbcdVar != null ? zzbcdVar : new zzbcd(zzbccVar);
    }

    @Override // com.google.android.gms.internal.gtm.zzbhe
    public final void zzA(List list) throws IOException {
        int iZzc;
        int iZzc2;
        if (!(list instanceof zzbej)) {
            int i = this.zzb & 7;
            if (i == 1) {
                do {
                    list.add(Double.valueOf(Double.longBitsToDouble(((zzbca) this.zza).zzo())));
                    if (this.zza.zzi()) {
                        return;
                    } else {
                        iZzc = this.zza.zzc();
                    }
                } while (iZzc == this.zzb);
                this.zzd = iZzc;
                return;
            }
            if (i != 2) {
                throw zzbfs.zza();
            }
            int iZzn = ((zzbca) this.zza).zzn();
            zzY(iZzn);
            int iZza = this.zza.zza() + iZzn;
            do {
                list.add(Double.valueOf(Double.longBitsToDouble(((zzbca) this.zza).zzo())));
            } while (this.zza.zza() < iZza);
            return;
        }
        zzbej zzbejVar = (zzbej) list;
        int i2 = this.zzb & 7;
        if (i2 == 1) {
            do {
                zzbejVar.zze(Double.longBitsToDouble(((zzbca) this.zza).zzo()));
                if (this.zza.zzi()) {
                    return;
                } else {
                    iZzc2 = this.zza.zzc();
                }
            } while (iZzc2 == this.zzb);
            this.zzd = iZzc2;
            return;
        }
        if (i2 != 2) {
            throw zzbfs.zza();
        }
        int iZzn2 = ((zzbca) this.zza).zzn();
        zzY(iZzn2);
        int iZza2 = this.zza.zza() + iZzn2;
        do {
            zzbejVar.zze(Double.longBitsToDouble(((zzbca) this.zza).zzo()));
        } while (this.zza.zza() < iZza2);
    }

    @Override // com.google.android.gms.internal.gtm.zzbhe
    public final void zzB(List list) throws IOException {
        int iZzc;
        int iZzc2;
        if (!(list instanceof zzbfg)) {
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    list.add(Integer.valueOf(((zzbca) this.zza).zzn()));
                    if (this.zza.zzi()) {
                        return;
                    } else {
                        iZzc = this.zza.zzc();
                    }
                } while (iZzc == this.zzb);
                this.zzd = iZzc;
                return;
            }
            if (i != 2) {
                throw zzbfs.zza();
            }
            int iZza = this.zza.zza() + ((zzbca) this.zza).zzn();
            do {
                list.add(Integer.valueOf(((zzbca) this.zza).zzn()));
            } while (this.zza.zza() < iZza);
            zzV(iZza);
            return;
        }
        zzbfg zzbfgVar = (zzbfg) list;
        int i2 = this.zzb & 7;
        if (i2 == 0) {
            do {
                zzbfgVar.zzh(((zzbca) this.zza).zzn());
                if (this.zza.zzi()) {
                    return;
                } else {
                    iZzc2 = this.zza.zzc();
                }
            } while (iZzc2 == this.zzb);
            this.zzd = iZzc2;
            return;
        }
        if (i2 != 2) {
            throw zzbfs.zza();
        }
        int iZza2 = this.zza.zza() + ((zzbca) this.zza).zzn();
        do {
            zzbfgVar.zzh(((zzbca) this.zza).zzn());
        } while (this.zza.zza() < iZza2);
        zzV(iZza2);
    }

    @Override // com.google.android.gms.internal.gtm.zzbhe
    public final void zzC(List list) throws IOException {
        int iZzc;
        int iZzc2;
        if (!(list instanceof zzbfg)) {
            int i = this.zzb & 7;
            if (i == 2) {
                int iZzn = ((zzbca) this.zza).zzn();
                zzX(iZzn);
                int iZza = this.zza.zza() + iZzn;
                do {
                    list.add(Integer.valueOf(((zzbca) this.zza).zzm()));
                } while (this.zza.zza() < iZza);
                return;
            }
            if (i != 5) {
                throw zzbfs.zza();
            }
            do {
                list.add(Integer.valueOf(((zzbca) this.zza).zzm()));
                if (this.zza.zzi()) {
                    return;
                } else {
                    iZzc = this.zza.zzc();
                }
            } while (iZzc == this.zzb);
            this.zzd = iZzc;
            return;
        }
        zzbfg zzbfgVar = (zzbfg) list;
        int i2 = this.zzb & 7;
        if (i2 == 2) {
            int iZzn2 = ((zzbca) this.zza).zzn();
            zzX(iZzn2);
            int iZza2 = this.zza.zza() + iZzn2;
            do {
                zzbfgVar.zzh(((zzbca) this.zza).zzm());
            } while (this.zza.zza() < iZza2);
            return;
        }
        if (i2 != 5) {
            throw zzbfs.zza();
        }
        do {
            zzbfgVar.zzh(((zzbca) this.zza).zzm());
            if (this.zza.zzi()) {
                return;
            } else {
                iZzc2 = this.zza.zzc();
            }
        } while (iZzc2 == this.zzb);
        this.zzd = iZzc2;
    }

    @Override // com.google.android.gms.internal.gtm.zzbhe
    public final void zzD(List list) throws IOException {
        int iZzc;
        int iZzc2;
        if (!(list instanceof zzbgh)) {
            int i = this.zzb & 7;
            if (i == 1) {
                do {
                    list.add(Long.valueOf(((zzbca) this.zza).zzo()));
                    if (this.zza.zzi()) {
                        return;
                    } else {
                        iZzc = this.zza.zzc();
                    }
                } while (iZzc == this.zzb);
                this.zzd = iZzc;
                return;
            }
            if (i != 2) {
                throw zzbfs.zza();
            }
            int iZzn = ((zzbca) this.zza).zzn();
            zzY(iZzn);
            int iZza = this.zza.zza() + iZzn;
            do {
                list.add(Long.valueOf(((zzbca) this.zza).zzo()));
            } while (this.zza.zza() < iZza);
            return;
        }
        zzbgh zzbghVar = (zzbgh) list;
        int i2 = this.zzb & 7;
        if (i2 == 1) {
            do {
                zzbghVar.zzg(((zzbca) this.zza).zzo());
                if (this.zza.zzi()) {
                    return;
                } else {
                    iZzc2 = this.zza.zzc();
                }
            } while (iZzc2 == this.zzb);
            this.zzd = iZzc2;
            return;
        }
        if (i2 != 2) {
            throw zzbfs.zza();
        }
        int iZzn2 = ((zzbca) this.zza).zzn();
        zzY(iZzn2);
        int iZza2 = this.zza.zza() + iZzn2;
        do {
            zzbghVar.zzg(((zzbca) this.zza).zzo());
        } while (this.zza.zza() < iZza2);
    }

    @Override // com.google.android.gms.internal.gtm.zzbhe
    public final void zzE(List list) throws IOException {
        int iZzc;
        int iZzc2;
        if (!(list instanceof zzbew)) {
            int i = this.zzb & 7;
            if (i == 2) {
                int iZzn = ((zzbca) this.zza).zzn();
                zzX(iZzn);
                int iZza = this.zza.zza() + iZzn;
                do {
                    list.add(Float.valueOf(Float.intBitsToFloat(((zzbca) this.zza).zzm())));
                } while (this.zza.zza() < iZza);
                return;
            }
            if (i != 5) {
                throw zzbfs.zza();
            }
            do {
                list.add(Float.valueOf(Float.intBitsToFloat(((zzbca) this.zza).zzm())));
                if (this.zza.zzi()) {
                    return;
                } else {
                    iZzc = this.zza.zzc();
                }
            } while (iZzc == this.zzb);
            this.zzd = iZzc;
            return;
        }
        zzbew zzbewVar = (zzbew) list;
        int i2 = this.zzb & 7;
        if (i2 == 2) {
            int iZzn2 = ((zzbca) this.zza).zzn();
            zzX(iZzn2);
            int iZza2 = this.zza.zza() + iZzn2;
            do {
                zzbewVar.zzf(Float.intBitsToFloat(((zzbca) this.zza).zzm()));
            } while (this.zza.zza() < iZza2);
            return;
        }
        if (i2 != 5) {
            throw zzbfs.zza();
        }
        do {
            zzbewVar.zzf(Float.intBitsToFloat(((zzbca) this.zza).zzm()));
            if (this.zza.zzi()) {
                return;
            } else {
                iZzc2 = this.zza.zzc();
            }
        } while (iZzc2 == this.zzb);
        this.zzd = iZzc2;
    }

    @Override // com.google.android.gms.internal.gtm.zzbhe
    @Deprecated
    public final void zzF(List list, zzbhf zzbhfVar, zzbep zzbepVar) throws IOException {
        int iZzc;
        int i = this.zzb;
        if ((i & 7) != 3) {
            throw zzbfs.zza();
        }
        do {
            list.add(zzO(zzbhfVar, zzbepVar));
            if (this.zza.zzi() || this.zzd != 0) {
                return;
            } else {
                iZzc = this.zza.zzc();
            }
        } while (iZzc == i);
        this.zzd = iZzc;
    }

    @Override // com.google.android.gms.internal.gtm.zzbhe
    public final void zzG(List list) throws IOException {
        int iZzc;
        int iZzc2;
        if (!(list instanceof zzbfg)) {
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    list.add(Integer.valueOf(((zzbca) this.zza).zzn()));
                    if (this.zza.zzi()) {
                        return;
                    } else {
                        iZzc = this.zza.zzc();
                    }
                } while (iZzc == this.zzb);
                this.zzd = iZzc;
                return;
            }
            if (i != 2) {
                throw zzbfs.zza();
            }
            int iZza = this.zza.zza() + ((zzbca) this.zza).zzn();
            do {
                list.add(Integer.valueOf(((zzbca) this.zza).zzn()));
            } while (this.zza.zza() < iZza);
            zzV(iZza);
            return;
        }
        zzbfg zzbfgVar = (zzbfg) list;
        int i2 = this.zzb & 7;
        if (i2 == 0) {
            do {
                zzbfgVar.zzh(((zzbca) this.zza).zzn());
                if (this.zza.zzi()) {
                    return;
                } else {
                    iZzc2 = this.zza.zzc();
                }
            } while (iZzc2 == this.zzb);
            this.zzd = iZzc2;
            return;
        }
        if (i2 != 2) {
            throw zzbfs.zza();
        }
        int iZza2 = this.zza.zza() + ((zzbca) this.zza).zzn();
        do {
            zzbfgVar.zzh(((zzbca) this.zza).zzn());
        } while (this.zza.zza() < iZza2);
        zzV(iZza2);
    }

    @Override // com.google.android.gms.internal.gtm.zzbhe
    public final void zzH(List list) throws IOException {
        int iZzc;
        int iZzc2;
        if (!(list instanceof zzbgh)) {
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    list.add(Long.valueOf(((zzbca) this.zza).zzp()));
                    if (this.zza.zzi()) {
                        return;
                    } else {
                        iZzc = this.zza.zzc();
                    }
                } while (iZzc == this.zzb);
                this.zzd = iZzc;
                return;
            }
            if (i != 2) {
                throw zzbfs.zza();
            }
            int iZza = this.zza.zza() + ((zzbca) this.zza).zzn();
            do {
                list.add(Long.valueOf(((zzbca) this.zza).zzp()));
            } while (this.zza.zza() < iZza);
            zzV(iZza);
            return;
        }
        zzbgh zzbghVar = (zzbgh) list;
        int i2 = this.zzb & 7;
        if (i2 == 0) {
            do {
                zzbghVar.zzg(((zzbca) this.zza).zzp());
                if (this.zza.zzi()) {
                    return;
                } else {
                    iZzc2 = this.zza.zzc();
                }
            } while (iZzc2 == this.zzb);
            this.zzd = iZzc2;
            return;
        }
        if (i2 != 2) {
            throw zzbfs.zza();
        }
        int iZza2 = this.zza.zza() + ((zzbca) this.zza).zzn();
        do {
            zzbghVar.zzg(((zzbca) this.zza).zzp());
        } while (this.zza.zza() < iZza2);
        zzV(iZza2);
    }

    @Override // com.google.android.gms.internal.gtm.zzbhe
    public final void zzI(List list, zzbhf zzbhfVar, zzbep zzbepVar) throws IOException {
        int iZzc;
        int i = this.zzb;
        if ((i & 7) != 2) {
            throw zzbfs.zza();
        }
        do {
            list.add(zzU(zzbhfVar, zzbepVar));
            if (this.zza.zzi() || this.zzd != 0) {
                return;
            } else {
                iZzc = this.zza.zzc();
            }
        } while (iZzc == i);
        this.zzd = iZzc;
    }

    @Override // com.google.android.gms.internal.gtm.zzbhe
    public final void zzJ(List list) throws IOException {
        int iZzc;
        int iZzc2;
        if (!(list instanceof zzbfg)) {
            int i = this.zzb & 7;
            if (i == 2) {
                int iZzn = ((zzbca) this.zza).zzn();
                zzX(iZzn);
                int iZza = this.zza.zza() + iZzn;
                do {
                    list.add(Integer.valueOf(((zzbca) this.zza).zzm()));
                } while (this.zza.zza() < iZza);
                return;
            }
            if (i != 5) {
                throw zzbfs.zza();
            }
            do {
                list.add(Integer.valueOf(((zzbca) this.zza).zzm()));
                if (this.zza.zzi()) {
                    return;
                } else {
                    iZzc = this.zza.zzc();
                }
            } while (iZzc == this.zzb);
            this.zzd = iZzc;
            return;
        }
        zzbfg zzbfgVar = (zzbfg) list;
        int i2 = this.zzb & 7;
        if (i2 == 2) {
            int iZzn2 = ((zzbca) this.zza).zzn();
            zzX(iZzn2);
            int iZza2 = this.zza.zza() + iZzn2;
            do {
                zzbfgVar.zzh(((zzbca) this.zza).zzm());
            } while (this.zza.zza() < iZza2);
            return;
        }
        if (i2 != 5) {
            throw zzbfs.zza();
        }
        do {
            zzbfgVar.zzh(((zzbca) this.zza).zzm());
            if (this.zza.zzi()) {
                return;
            } else {
                iZzc2 = this.zza.zzc();
            }
        } while (iZzc2 == this.zzb);
        this.zzd = iZzc2;
    }

    @Override // com.google.android.gms.internal.gtm.zzbhe
    public final void zzK(List list) throws IOException {
        int iZzc;
        int iZzc2;
        if (!(list instanceof zzbgh)) {
            int i = this.zzb & 7;
            if (i == 1) {
                do {
                    list.add(Long.valueOf(((zzbca) this.zza).zzo()));
                    if (this.zza.zzi()) {
                        return;
                    } else {
                        iZzc = this.zza.zzc();
                    }
                } while (iZzc == this.zzb);
                this.zzd = iZzc;
                return;
            }
            if (i != 2) {
                throw zzbfs.zza();
            }
            int iZzn = ((zzbca) this.zza).zzn();
            zzY(iZzn);
            int iZza = this.zza.zza() + iZzn;
            do {
                list.add(Long.valueOf(((zzbca) this.zza).zzo()));
            } while (this.zza.zza() < iZza);
            return;
        }
        zzbgh zzbghVar = (zzbgh) list;
        int i2 = this.zzb & 7;
        if (i2 == 1) {
            do {
                zzbghVar.zzg(((zzbca) this.zza).zzo());
                if (this.zza.zzi()) {
                    return;
                } else {
                    iZzc2 = this.zza.zzc();
                }
            } while (iZzc2 == this.zzb);
            this.zzd = iZzc2;
            return;
        }
        if (i2 != 2) {
            throw zzbfs.zza();
        }
        int iZzn2 = ((zzbca) this.zza).zzn();
        zzY(iZzn2);
        int iZza2 = this.zza.zza() + iZzn2;
        do {
            zzbghVar.zzg(((zzbca) this.zza).zzo());
        } while (this.zza.zza() < iZza2);
    }

    @Override // com.google.android.gms.internal.gtm.zzbhe
    public final void zzL(List list) throws IOException {
        int iZzc;
        int iZzc2;
        if (!(list instanceof zzbfg)) {
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    list.add(Integer.valueOf(zzbca.zzs(((zzbca) this.zza).zzn())));
                    if (this.zza.zzi()) {
                        return;
                    } else {
                        iZzc = this.zza.zzc();
                    }
                } while (iZzc == this.zzb);
                this.zzd = iZzc;
                return;
            }
            if (i != 2) {
                throw zzbfs.zza();
            }
            int iZza = this.zza.zza() + ((zzbca) this.zza).zzn();
            do {
                list.add(Integer.valueOf(zzbca.zzs(((zzbca) this.zza).zzn())));
            } while (this.zza.zza() < iZza);
            zzV(iZza);
            return;
        }
        zzbfg zzbfgVar = (zzbfg) list;
        int i2 = this.zzb & 7;
        if (i2 == 0) {
            do {
                zzbfgVar.zzh(zzbca.zzs(((zzbca) this.zza).zzn()));
                if (this.zza.zzi()) {
                    return;
                } else {
                    iZzc2 = this.zza.zzc();
                }
            } while (iZzc2 == this.zzb);
            this.zzd = iZzc2;
            return;
        }
        if (i2 != 2) {
            throw zzbfs.zza();
        }
        int iZza2 = this.zza.zza() + ((zzbca) this.zza).zzn();
        do {
            zzbfgVar.zzh(zzbca.zzs(((zzbca) this.zza).zzn()));
        } while (this.zza.zza() < iZza2);
        zzV(iZza2);
    }

    @Override // com.google.android.gms.internal.gtm.zzbhe
    public final void zzM(List list) throws IOException {
        int iZzc;
        int iZzc2;
        if (!(list instanceof zzbgh)) {
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    list.add(Long.valueOf(zzbca.zzt(((zzbca) this.zza).zzp())));
                    if (this.zza.zzi()) {
                        return;
                    } else {
                        iZzc = this.zza.zzc();
                    }
                } while (iZzc == this.zzb);
                this.zzd = iZzc;
                return;
            }
            if (i != 2) {
                throw zzbfs.zza();
            }
            int iZza = this.zza.zza() + ((zzbca) this.zza).zzn();
            do {
                list.add(Long.valueOf(zzbca.zzt(((zzbca) this.zza).zzp())));
            } while (this.zza.zza() < iZza);
            zzV(iZza);
            return;
        }
        zzbgh zzbghVar = (zzbgh) list;
        int i2 = this.zzb & 7;
        if (i2 == 0) {
            do {
                zzbghVar.zzg(zzbca.zzt(((zzbca) this.zza).zzp()));
                if (this.zza.zzi()) {
                    return;
                } else {
                    iZzc2 = this.zza.zzc();
                }
            } while (iZzc2 == this.zzb);
            this.zzd = iZzc2;
            return;
        }
        if (i2 != 2) {
            throw zzbfs.zza();
        }
        int iZza2 = this.zza.zza() + ((zzbca) this.zza).zzn();
        do {
            zzbghVar.zzg(zzbca.zzt(((zzbca) this.zza).zzp()));
        } while (this.zza.zza() < iZza2);
        zzV(iZza2);
    }

    @Override // com.google.android.gms.internal.gtm.zzbhe
    public final void zzN(List list) throws IOException {
        zzw(list, false);
    }

    @Override // com.google.android.gms.internal.gtm.zzbhe
    public final void zzP(List list) throws IOException {
        zzw(list, true);
    }

    @Override // com.google.android.gms.internal.gtm.zzbhe
    public final void zzQ(List list) throws IOException {
        int iZzc;
        int iZzc2;
        if (!(list instanceof zzbfg)) {
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    list.add(Integer.valueOf(((zzbca) this.zza).zzn()));
                    if (this.zza.zzi()) {
                        return;
                    } else {
                        iZzc = this.zza.zzc();
                    }
                } while (iZzc == this.zzb);
                this.zzd = iZzc;
                return;
            }
            if (i != 2) {
                throw zzbfs.zza();
            }
            int iZza = this.zza.zza() + ((zzbca) this.zza).zzn();
            do {
                list.add(Integer.valueOf(((zzbca) this.zza).zzn()));
            } while (this.zza.zza() < iZza);
            zzV(iZza);
            return;
        }
        zzbfg zzbfgVar = (zzbfg) list;
        int i2 = this.zzb & 7;
        if (i2 == 0) {
            do {
                zzbfgVar.zzh(((zzbca) this.zza).zzn());
                if (this.zza.zzi()) {
                    return;
                } else {
                    iZzc2 = this.zza.zzc();
                }
            } while (iZzc2 == this.zzb);
            this.zzd = iZzc2;
            return;
        }
        if (i2 != 2) {
            throw zzbfs.zza();
        }
        int iZza2 = this.zza.zza() + ((zzbca) this.zza).zzn();
        do {
            zzbfgVar.zzh(((zzbca) this.zza).zzn());
        } while (this.zza.zza() < iZza2);
        zzV(iZza2);
    }

    @Override // com.google.android.gms.internal.gtm.zzbhe
    public final void zzR(List list) throws IOException {
        int iZzc;
        int iZzc2;
        if (!(list instanceof zzbgh)) {
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    list.add(Long.valueOf(((zzbca) this.zza).zzp()));
                    if (this.zza.zzi()) {
                        return;
                    } else {
                        iZzc = this.zza.zzc();
                    }
                } while (iZzc == this.zzb);
                this.zzd = iZzc;
                return;
            }
            if (i != 2) {
                throw zzbfs.zza();
            }
            int iZza = this.zza.zza() + ((zzbca) this.zza).zzn();
            do {
                list.add(Long.valueOf(((zzbca) this.zza).zzp()));
            } while (this.zza.zza() < iZza);
            zzV(iZza);
            return;
        }
        zzbgh zzbghVar = (zzbgh) list;
        int i2 = this.zzb & 7;
        if (i2 == 0) {
            do {
                zzbghVar.zzg(((zzbca) this.zza).zzp());
                if (this.zza.zzi()) {
                    return;
                } else {
                    iZzc2 = this.zza.zzc();
                }
            } while (iZzc2 == this.zzb);
            this.zzd = iZzc2;
            return;
        }
        if (i2 != 2) {
            throw zzbfs.zza();
        }
        int iZza2 = this.zza.zza() + ((zzbca) this.zza).zzn();
        do {
            zzbghVar.zzg(((zzbca) this.zza).zzp());
        } while (this.zza.zza() < iZza2);
        zzV(iZza2);
    }

    @Override // com.google.android.gms.internal.gtm.zzbhe
    public final boolean zzS() throws IOException {
        zzW(0);
        return this.zza.zzj();
    }

    @Override // com.google.android.gms.internal.gtm.zzbhe
    public final boolean zzT() throws IOException {
        int i;
        if (this.zza.zzi() || (i = this.zzb) == this.zzc) {
            return false;
        }
        return this.zza.zzk(i);
    }

    @Override // com.google.android.gms.internal.gtm.zzbhe
    public final double zza() throws IOException {
        zzW(1);
        return Double.longBitsToDouble(((zzbca) this.zza).zzo());
    }

    @Override // com.google.android.gms.internal.gtm.zzbhe
    public final float zzb() throws IOException {
        zzW(5);
        return Float.intBitsToFloat(((zzbca) this.zza).zzm());
    }

    @Override // com.google.android.gms.internal.gtm.zzbhe
    public final int zzc() throws IOException {
        int iZzc = this.zzd;
        if (iZzc != 0) {
            this.zzb = iZzc;
            this.zzd = 0;
        } else {
            iZzc = this.zza.zzc();
            this.zzb = iZzc;
        }
        if (iZzc == 0 || iZzc == this.zzc) {
            return Integer.MAX_VALUE;
        }
        return iZzc >>> 3;
    }

    @Override // com.google.android.gms.internal.gtm.zzbhe
    public final int zzd() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.gtm.zzbhe
    public final int zze() throws IOException {
        zzW(0);
        return ((zzbca) this.zza).zzn();
    }

    @Override // com.google.android.gms.internal.gtm.zzbhe
    public final int zzf() throws IOException {
        zzW(5);
        return ((zzbca) this.zza).zzm();
    }

    @Override // com.google.android.gms.internal.gtm.zzbhe
    public final int zzg() throws IOException {
        zzW(0);
        return ((zzbca) this.zza).zzn();
    }

    @Override // com.google.android.gms.internal.gtm.zzbhe
    public final int zzh() throws IOException {
        zzW(5);
        return ((zzbca) this.zza).zzm();
    }

    @Override // com.google.android.gms.internal.gtm.zzbhe
    public final int zzi() throws IOException {
        zzW(0);
        return zzbca.zzs(((zzbca) this.zza).zzn());
    }

    @Override // com.google.android.gms.internal.gtm.zzbhe
    public final int zzj() throws IOException {
        zzW(0);
        return ((zzbca) this.zza).zzn();
    }

    @Override // com.google.android.gms.internal.gtm.zzbhe
    public final long zzk() throws IOException {
        zzW(1);
        return ((zzbca) this.zza).zzo();
    }

    @Override // com.google.android.gms.internal.gtm.zzbhe
    public final long zzl() throws IOException {
        zzW(0);
        return ((zzbca) this.zza).zzp();
    }

    @Override // com.google.android.gms.internal.gtm.zzbhe
    public final long zzm() throws IOException {
        zzW(1);
        return ((zzbca) this.zza).zzo();
    }

    @Override // com.google.android.gms.internal.gtm.zzbhe
    public final long zzn() throws IOException {
        zzW(0);
        return zzbca.zzt(((zzbca) this.zza).zzp());
    }

    @Override // com.google.android.gms.internal.gtm.zzbhe
    public final long zzo() throws IOException {
        zzW(0);
        return ((zzbca) this.zza).zzp();
    }

    @Override // com.google.android.gms.internal.gtm.zzbhe
    public final zzbbw zzq() throws IOException {
        zzW(2);
        return this.zza.zzd();
    }

    @Override // com.google.android.gms.internal.gtm.zzbhe
    @Deprecated
    public final Object zzr(Class cls, zzbep zzbepVar) throws IOException {
        zzW(3);
        return zzO(zzbhb.zza().zzb(cls), zzbepVar);
    }

    @Override // com.google.android.gms.internal.gtm.zzbhe
    @Deprecated
    public final Object zzs(zzbhf zzbhfVar, zzbep zzbepVar) throws IOException {
        zzW(3);
        return zzO(zzbhfVar, zzbepVar);
    }

    @Override // com.google.android.gms.internal.gtm.zzbhe
    public final Object zzt(Class cls, zzbep zzbepVar) throws IOException {
        zzW(2);
        return zzU(zzbhb.zza().zzb(cls), zzbepVar);
    }

    @Override // com.google.android.gms.internal.gtm.zzbhe
    public final Object zzu(zzbhf zzbhfVar, zzbep zzbepVar) throws IOException {
        zzW(2);
        return zzU(zzbhfVar, zzbepVar);
    }

    @Override // com.google.android.gms.internal.gtm.zzbhe
    public final String zzv() throws IOException {
        zzW(2);
        return this.zza.zze();
    }

    public final void zzw(List list, boolean z) throws IOException {
        int iZzc;
        int iZzc2;
        if ((this.zzb & 7) != 2) {
            throw zzbfs.zza();
        }
        if (!(list instanceof zzbga) || z) {
            do {
                list.add(z ? zzx() : zzv());
                if (this.zza.zzi()) {
                    return;
                } else {
                    iZzc = this.zza.zzc();
                }
            } while (iZzc == this.zzb);
            this.zzd = iZzc;
            return;
        }
        zzbga zzbgaVar = (zzbga) list;
        do {
            zzbgaVar.zzi(zzq());
            if (this.zza.zzi()) {
                return;
            } else {
                iZzc2 = this.zza.zzc();
            }
        } while (iZzc2 == this.zzb);
        this.zzd = iZzc2;
    }

    @Override // com.google.android.gms.internal.gtm.zzbhe
    public final String zzx() throws IOException {
        zzW(2);
        return this.zza.zzf();
    }

    @Override // com.google.android.gms.internal.gtm.zzbhe
    public final void zzy(List list) throws IOException {
        int iZzc;
        int iZzc2;
        if (!(list instanceof zzbbl)) {
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    list.add(Boolean.valueOf(this.zza.zzj()));
                    if (this.zza.zzi()) {
                        return;
                    } else {
                        iZzc = this.zza.zzc();
                    }
                } while (iZzc == this.zzb);
                this.zzd = iZzc;
                return;
            }
            if (i != 2) {
                throw zzbfs.zza();
            }
            int iZza = this.zza.zza() + ((zzbca) this.zza).zzn();
            do {
                list.add(Boolean.valueOf(this.zza.zzj()));
            } while (this.zza.zza() < iZza);
            zzV(iZza);
            return;
        }
        zzbbl zzbblVar = (zzbbl) list;
        int i2 = this.zzb & 7;
        if (i2 == 0) {
            do {
                zzbblVar.zze(this.zza.zzj());
                if (this.zza.zzi()) {
                    return;
                } else {
                    iZzc2 = this.zza.zzc();
                }
            } while (iZzc2 == this.zzb);
            this.zzd = iZzc2;
            return;
        }
        if (i2 != 2) {
            throw zzbfs.zza();
        }
        int iZza2 = this.zza.zza() + ((zzbca) this.zza).zzn();
        do {
            zzbblVar.zze(this.zza.zzj());
        } while (this.zza.zza() < iZza2);
        zzV(iZza2);
    }

    @Override // com.google.android.gms.internal.gtm.zzbhe
    public final void zzz(List list) throws IOException {
        int iZzc;
        if ((this.zzb & 7) != 2) {
            throw zzbfs.zza();
        }
        do {
            list.add(zzq());
            if (this.zza.zzi()) {
                return;
            } else {
                iZzc = this.zza.zzc();
            }
        } while (iZzc == this.zzb);
        this.zzd = iZzc;
    }
}
