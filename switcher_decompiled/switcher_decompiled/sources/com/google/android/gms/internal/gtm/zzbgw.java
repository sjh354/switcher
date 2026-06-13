package com.google.android.gms.internal.gtm;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
final class zzbgw implements zzbhf {
    private final zzbgs zza;
    private final zzbhz zzb;
    private final boolean zzc;
    private final zzbeq zzd;

    private zzbgw(zzbhz zzbhzVar, zzbeq zzbeqVar, zzbgs zzbgsVar) {
        this.zzb = zzbhzVar;
        this.zzc = zzbeqVar.zzi(zzbgsVar);
        this.zzd = zzbeqVar;
        this.zza = zzbgsVar;
    }

    static zzbgw zzc(zzbhz zzbhzVar, zzbeq zzbeqVar, zzbgs zzbgsVar) {
        return new zzbgw(zzbhzVar, zzbeqVar, zzbgsVar);
    }

    @Override // com.google.android.gms.internal.gtm.zzbhf
    public final int zza(Object obj) {
        zzbhz zzbhzVar = this.zzb;
        int iZzb = zzbhzVar.zzb(zzbhzVar.zzd(obj));
        return this.zzc ? iZzb + this.zzd.zzb(obj).zzc() : iZzb;
    }

    @Override // com.google.android.gms.internal.gtm.zzbhf
    public final int zzb(Object obj) {
        int iHashCode = this.zzb.zzd(obj).hashCode();
        return this.zzc ? (iHashCode * 53) + this.zzd.zzb(obj).zza.hashCode() : iHashCode;
    }

    @Override // com.google.android.gms.internal.gtm.zzbhf
    public final Object zze() {
        return this.zza.zzas().zzD();
    }

    @Override // com.google.android.gms.internal.gtm.zzbhf
    public final void zzf(Object obj) {
        this.zzb.zzm(obj);
        this.zzd.zzf(obj);
    }

    @Override // com.google.android.gms.internal.gtm.zzbhf
    public final void zzg(Object obj, Object obj2) {
        zzbhh.zzF(this.zzb, obj, obj2);
        if (this.zzc) {
            zzbhh.zzE(this.zzd, obj, obj2);
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzbhf
    public final void zzh(Object obj, zzbhe zzbheVar, zzbep zzbepVar) throws IOException {
        boolean zZzT;
        zzbhz zzbhzVar = this.zzb;
        zzbeq zzbeqVar = this.zzd;
        Object objZzc = zzbhzVar.zzc(obj);
        zzbeu zzbeuVarZzc = zzbeqVar.zzc(obj);
        while (zzbheVar.zzc() != Integer.MAX_VALUE) {
            try {
                int iZzd = zzbheVar.zzd();
                if (iZzd != 11) {
                    if ((iZzd & 7) == 2) {
                        Object objZzd = zzbeqVar.zzd(zzbepVar, this.zza, iZzd >>> 3);
                        if (objZzd != null) {
                            zzbeqVar.zzg(zzbheVar, objZzd, zzbepVar, zzbeuVarZzc);
                        } else {
                            zZzT = zzbhzVar.zzp(objZzc, zzbheVar);
                        }
                    } else {
                        zZzT = zzbheVar.zzT();
                    }
                    if (!zZzT) {
                        return;
                    }
                } else {
                    int iZzj = 0;
                    Object objZzd2 = null;
                    zzbbw zzbbwVarZzq = null;
                    while (zzbheVar.zzc() != Integer.MAX_VALUE) {
                        int iZzd2 = zzbheVar.zzd();
                        if (iZzd2 == 16) {
                            iZzj = zzbheVar.zzj();
                            objZzd2 = zzbeqVar.zzd(zzbepVar, this.zza, iZzj);
                        } else if (iZzd2 == 26) {
                            if (objZzd2 != null) {
                                zzbeqVar.zzg(zzbheVar, objZzd2, zzbepVar, zzbeuVarZzc);
                            } else {
                                zzbbwVarZzq = zzbheVar.zzq();
                            }
                        } else if (!zzbheVar.zzT()) {
                            break;
                        }
                    }
                    if (zzbheVar.zzd() != 12) {
                        throw zzbfs.zzb();
                    }
                    if (zzbbwVarZzq != null) {
                        if (objZzd2 != null) {
                            zzbeqVar.zzh(zzbbwVarZzq, objZzd2, zzbepVar, zzbeuVarZzc);
                        } else {
                            zzbhzVar.zzk(objZzc, iZzj, zzbbwVarZzq);
                        }
                    }
                }
            } finally {
                zzbhzVar.zzn(obj, objZzc);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00bf A[EDGE_INSN: B:57:0x00bf->B:33:0x00bf BREAK  A[LOOP:1: B:18:0x0067->B:60:0x0067], SYNTHETIC] */
    @Override // com.google.android.gms.internal.gtm.zzbhf
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzi(java.lang.Object r11, byte[] r12, int r13, int r14, com.google.android.gms.internal.gtm.zzbbf r15) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 210
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzbgw.zzi(java.lang.Object, byte[], int, int, com.google.android.gms.internal.gtm.zzbbf):void");
    }

    @Override // com.google.android.gms.internal.gtm.zzbhf
    public final boolean zzj(Object obj, Object obj2) {
        if (!this.zzb.zzd(obj).equals(this.zzb.zzd(obj2))) {
            return false;
        }
        if (this.zzc) {
            return this.zzd.zzb(obj).equals(this.zzd.zzb(obj2));
        }
        return true;
    }

    @Override // com.google.android.gms.internal.gtm.zzbhf
    public final boolean zzk(Object obj) {
        return this.zzd.zzb(obj).zzm();
    }

    @Override // com.google.android.gms.internal.gtm.zzbhf
    public final void zzn(Object obj, zzbck zzbckVar) throws IOException {
        Iterator itZzg = this.zzd.zzb(obj).zzg();
        while (itZzg.hasNext()) {
            Map.Entry entry = (Map.Entry) itZzg.next();
            zzbet zzbetVar = (zzbet) entry.getKey();
            if (zzbetVar.zze() != zzbiq.MESSAGE || zzbetVar.zzg()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            zzbetVar.zzf();
            if (entry instanceof zzbfv) {
                zzbckVar.zzw(zzbetVar.zza(), ((zzbfv) entry).zza().zzb());
            } else {
                zzbckVar.zzw(zzbetVar.zza(), entry.getValue());
            }
        }
        zzbhz zzbhzVar = this.zzb;
        zzbhzVar.zzr(zzbhzVar.zzd(obj), zzbckVar);
    }
}
