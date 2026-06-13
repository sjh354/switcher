package com.google.android.gms.internal.gtm;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
final class zzber extends zzbeq {
    zzber() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbeq
    final int zza(Map.Entry entry) {
        return ((zzbfc) entry.getKey()).zzb;
    }

    @Override // com.google.android.gms.internal.gtm.zzbeq
    final zzbeu zzb(Object obj) {
        return ((zzbfb) obj).zzb;
    }

    @Override // com.google.android.gms.internal.gtm.zzbeq
    final zzbeu zzc(Object obj) {
        return ((zzbfb) obj).zzV();
    }

    @Override // com.google.android.gms.internal.gtm.zzbeq
    final Object zzd(zzbep zzbepVar, zzbgs zzbgsVar, int i) {
        return zzbepVar.zzb(zzbgsVar, i);
    }

    @Override // com.google.android.gms.internal.gtm.zzbeq
    final Object zze(zzbhe zzbheVar, Object obj, zzbep zzbepVar, zzbeu zzbeuVar, Object obj2, zzbhz zzbhzVar) throws IOException {
        Object objValueOf;
        Object objZzf;
        zzbfd zzbfdVar = (zzbfd) obj;
        zzbfc zzbfcVar = zzbfdVar.zzd;
        int i = zzbfcVar.zzb;
        boolean z = zzbfcVar.zzd;
        if (zzbfcVar.zzc != zzbip.ENUM) {
            switch (zzbfdVar.zzd.zzc) {
                case DOUBLE:
                    objValueOf = Double.valueOf(zzbheVar.zza());
                    break;
                case FLOAT:
                    objValueOf = Float.valueOf(zzbheVar.zzb());
                    break;
                case INT64:
                    objValueOf = Long.valueOf(zzbheVar.zzl());
                    break;
                case UINT64:
                    objValueOf = Long.valueOf(zzbheVar.zzo());
                    break;
                case INT32:
                    objValueOf = Integer.valueOf(zzbheVar.zzg());
                    break;
                case FIXED64:
                    objValueOf = Long.valueOf(zzbheVar.zzk());
                    break;
                case FIXED32:
                    objValueOf = Integer.valueOf(zzbheVar.zzf());
                    break;
                case BOOL:
                    objValueOf = Boolean.valueOf(zzbheVar.zzS());
                    break;
                case STRING:
                    objValueOf = zzbheVar.zzv();
                    break;
                case GROUP:
                    objValueOf = zzbheVar.zzr(zzbfdVar.zzc.getClass(), zzbepVar);
                    break;
                case MESSAGE:
                    objValueOf = zzbheVar.zzt(zzbfdVar.zzc.getClass(), zzbepVar);
                    break;
                case BYTES:
                    objValueOf = zzbheVar.zzq();
                    break;
                case UINT32:
                    objValueOf = Integer.valueOf(zzbheVar.zzj());
                    break;
                case ENUM:
                    throw new IllegalStateException("Shouldn't reach here.");
                case SFIXED32:
                    objValueOf = Integer.valueOf(zzbheVar.zzh());
                    break;
                case SFIXED64:
                    objValueOf = Long.valueOf(zzbheVar.zzm());
                    break;
                case SINT32:
                    objValueOf = Integer.valueOf(zzbheVar.zzi());
                    break;
                case SINT64:
                    objValueOf = Long.valueOf(zzbheVar.zzn());
                    break;
                default:
                    objValueOf = null;
                    break;
            }
        } else {
            int iZzg = zzbheVar.zzg();
            if (zzbfdVar.zzd.zza.zza(iZzg) == null) {
                return zzbhh.zzD(i, iZzg, obj2, zzbhzVar);
            }
            objValueOf = Integer.valueOf(iZzg);
        }
        zzbfc zzbfcVar2 = zzbfdVar.zzd;
        if (zzbfcVar2.zzd) {
            zzbeuVar.zzh(zzbfcVar2, objValueOf);
        } else {
            int iOrdinal = zzbfcVar2.zzc.ordinal();
            if ((iOrdinal == 9 || iOrdinal == 10) && (objZzf = zzbeuVar.zzf(zzbfdVar.zzd)) != null) {
                objValueOf = zzbfq.zzg(objZzf, objValueOf);
            }
            zzbeuVar.zzk(zzbfdVar.zzd, objValueOf);
        }
        return obj2;
    }

    @Override // com.google.android.gms.internal.gtm.zzbeq
    final void zzf(Object obj) {
        ((zzbfb) obj).zzb.zzi();
    }

    @Override // com.google.android.gms.internal.gtm.zzbeq
    final void zzg(zzbhe zzbheVar, Object obj, zzbep zzbepVar, zzbeu zzbeuVar) throws IOException {
        zzbfd zzbfdVar = (zzbfd) obj;
        zzbeuVar.zzk(zzbfdVar.zzd, zzbheVar.zzt(zzbfdVar.zzc.getClass(), zzbepVar));
    }

    @Override // com.google.android.gms.internal.gtm.zzbeq
    final void zzh(zzbbw zzbbwVar, Object obj, zzbep zzbepVar, zzbeu zzbeuVar) throws IOException {
        byte[] bArr;
        zzbfd zzbfdVar = (zzbfd) obj;
        zzbgs zzbgsVarZzD = zzbfdVar.zzc.zzas().zzD();
        int iZzd = zzbbwVar.zzd();
        if (iZzd == 0) {
            bArr = zzbfq.zzd;
        } else {
            byte[] bArr2 = new byte[iZzd];
            zzbbwVar.zze(bArr2, 0, 0, iZzd);
            bArr = bArr2;
        }
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        if (!byteBufferWrap.hasArray()) {
            throw new IllegalArgumentException("Direct buffers not yet supported");
        }
        zzbbh zzbbhVar = new zzbbh(byteBufferWrap, true);
        zzbhb.zza().zzb(zzbgsVarZzD.getClass()).zzh(zzbgsVarZzD, zzbbhVar, zzbepVar);
        zzbeuVar.zzk(zzbfdVar.zzd, zzbgsVarZzD);
        if (zzbbhVar.zzc() != Integer.MAX_VALUE) {
            throw zzbfs.zzb();
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzbeq
    final boolean zzi(zzbgs zzbgsVar) {
        return zzbgsVar instanceof zzbfb;
    }

    @Override // com.google.android.gms.internal.gtm.zzbeq
    final void zzj(zzbck zzbckVar, Map.Entry entry) throws IOException {
        zzbfc zzbfcVar = (zzbfc) entry.getKey();
        if (!zzbfcVar.zzd) {
            zzbip zzbipVar = zzbip.DOUBLE;
            switch (zzbfcVar.zzc) {
                case DOUBLE:
                    zzbckVar.zzf(zzbfcVar.zzb, ((Double) entry.getValue()).doubleValue());
                    break;
                case FLOAT:
                    zzbckVar.zzo(zzbfcVar.zzb, ((Float) entry.getValue()).floatValue());
                    break;
                case INT64:
                    zzbckVar.zzt(zzbfcVar.zzb, ((Long) entry.getValue()).longValue());
                    break;
                case UINT64:
                    zzbckVar.zzK(zzbfcVar.zzb, ((Long) entry.getValue()).longValue());
                    break;
                case INT32:
                    zzbckVar.zzr(zzbfcVar.zzb, ((Integer) entry.getValue()).intValue());
                    break;
                case FIXED64:
                    zzbckVar.zzm(zzbfcVar.zzb, ((Long) entry.getValue()).longValue());
                    break;
                case FIXED32:
                    zzbckVar.zzk(zzbfcVar.zzb, ((Integer) entry.getValue()).intValue());
                    break;
                case BOOL:
                    zzbckVar.zzb(zzbfcVar.zzb, ((Boolean) entry.getValue()).booleanValue());
                    break;
                case STRING:
                    zzbckVar.zzG(zzbfcVar.zzb, (String) entry.getValue());
                    break;
                case GROUP:
                    zzbckVar.zzq(zzbfcVar.zzb, entry.getValue(), zzbhb.zza().zzb(entry.getValue().getClass()));
                    break;
                case MESSAGE:
                    zzbckVar.zzv(zzbfcVar.zzb, entry.getValue(), zzbhb.zza().zzb(entry.getValue().getClass()));
                    break;
                case BYTES:
                    zzbckVar.zzd(zzbfcVar.zzb, (zzbbw) entry.getValue());
                    break;
                case UINT32:
                    zzbckVar.zzI(zzbfcVar.zzb, ((Integer) entry.getValue()).intValue());
                    break;
                case ENUM:
                    zzbckVar.zzr(zzbfcVar.zzb, ((Integer) entry.getValue()).intValue());
                    break;
                case SFIXED32:
                    zzbckVar.zzx(zzbfcVar.zzb, ((Integer) entry.getValue()).intValue());
                    break;
                case SFIXED64:
                    zzbckVar.zzz(zzbfcVar.zzb, ((Long) entry.getValue()).longValue());
                    break;
                case SINT32:
                    zzbckVar.zzB(zzbfcVar.zzb, ((Integer) entry.getValue()).intValue());
                    break;
                case SINT64:
                    zzbckVar.zzD(zzbfcVar.zzb, ((Long) entry.getValue()).longValue());
                    break;
            }
        }
        zzbip zzbipVar2 = zzbip.DOUBLE;
        switch (zzbfcVar.zzc) {
            case DOUBLE:
                zzbhh.zzL(zzbfcVar.zzb, (List) entry.getValue(), zzbckVar, false);
                break;
            case FLOAT:
                zzbhh.zzP(zzbfcVar.zzb, (List) entry.getValue(), zzbckVar, false);
                break;
            case INT64:
                zzbhh.zzS(zzbfcVar.zzb, (List) entry.getValue(), zzbckVar, false);
                break;
            case UINT64:
                zzbhh.zzaa(zzbfcVar.zzb, (List) entry.getValue(), zzbckVar, false);
                break;
            case INT32:
                zzbhh.zzR(zzbfcVar.zzb, (List) entry.getValue(), zzbckVar, false);
                break;
            case FIXED64:
                zzbhh.zzO(zzbfcVar.zzb, (List) entry.getValue(), zzbckVar, false);
                break;
            case FIXED32:
                zzbhh.zzN(zzbfcVar.zzb, (List) entry.getValue(), zzbckVar, false);
                break;
            case BOOL:
                zzbhh.zzJ(zzbfcVar.zzb, (List) entry.getValue(), zzbckVar, false);
                break;
            case STRING:
                zzbhh.zzY(zzbfcVar.zzb, (List) entry.getValue(), zzbckVar);
                break;
            case GROUP:
                List list = (List) entry.getValue();
                if (list != null && !list.isEmpty()) {
                    zzbhh.zzQ(zzbfcVar.zzb, (List) entry.getValue(), zzbckVar, zzbhb.zza().zzb(list.get(0).getClass()));
                    break;
                }
                break;
            case MESSAGE:
                List list2 = (List) entry.getValue();
                if (list2 != null && !list2.isEmpty()) {
                    zzbhh.zzT(zzbfcVar.zzb, (List) entry.getValue(), zzbckVar, zzbhb.zza().zzb(list2.get(0).getClass()));
                    break;
                }
                break;
            case BYTES:
                zzbhh.zzK(zzbfcVar.zzb, (List) entry.getValue(), zzbckVar);
                break;
            case UINT32:
                zzbhh.zzZ(zzbfcVar.zzb, (List) entry.getValue(), zzbckVar, false);
                break;
            case ENUM:
                zzbhh.zzR(zzbfcVar.zzb, (List) entry.getValue(), zzbckVar, false);
                break;
            case SFIXED32:
                zzbhh.zzU(zzbfcVar.zzb, (List) entry.getValue(), zzbckVar, false);
                break;
            case SFIXED64:
                zzbhh.zzV(zzbfcVar.zzb, (List) entry.getValue(), zzbckVar, false);
                break;
            case SINT32:
                zzbhh.zzW(zzbfcVar.zzb, (List) entry.getValue(), zzbckVar, false);
                break;
            case SINT64:
                zzbhh.zzX(zzbfcVar.zzb, (List) entry.getValue(), zzbckVar, false);
                break;
        }
    }
}
