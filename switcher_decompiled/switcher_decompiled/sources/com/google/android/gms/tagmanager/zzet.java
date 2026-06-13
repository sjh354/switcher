package com.google.android.gms.tagmanager;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.internal.gtm.zzrr;
import com.google.android.gms.internal.gtm.zzrv;
import com.google.android.gms.internal.gtm.zzrz;
import com.google.android.gms.internal.gtm.zzsd;
import cz.msebera.android.httpclient.message.TokenParser;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
final class zzet {
    private static final zzdr zza = new zzdr(zzfu.zzb(), true);
    private final zzrv zzb;
    private final Map zzc;
    private final Map zzd;
    private final Map zze;
    private final Set zzf;
    private final DataLayer zzg;
    private final Map zzh;
    private volatile String zzi;
    private int zzj;
    private final zzdk zzk;
    private final zzda zzl;
    private final zzda zzm;

    public zzet(Context context, zzrv zzrvVar, DataLayer dataLayer, zzap zzapVar, zzap zzapVar2, zzdk zzdkVar, byte[] bArr) {
        this.zzb = zzrvVar;
        HashSet<zzrz> hashSet = new HashSet(zzrvVar.zzc());
        this.zzf = hashSet;
        this.zzg = dataLayer;
        this.zzk = zzdkVar;
        this.zzl = zzr.zza(1048576, new zzem(this));
        this.zzm = zzr.zza(1048576, new zzen(this));
        HashMap map = new HashMap();
        this.zzc = map;
        zzj(map, new zzo(context));
        zzj(map, new zzaq(zzapVar2));
        zzj(map, new zzbe(dataLayer));
        zzj(map, new zzfv(context, dataLayer));
        HashMap map2 = new HashMap();
        this.zzd = map2;
        zzj(map2, new zzan());
        zzj(map2, new zzbq());
        zzj(map2, new zzbr());
        zzj(map2, new zzbv());
        zzj(map2, new zzbw());
        zzj(map2, new zzdc());
        zzj(map2, new zzdd());
        zzj(map2, new zzed());
        zzj(map2, new zzfj());
        HashMap map3 = new HashMap();
        this.zze = map3;
        zzj(map3, new zze(zzd.zzb(context)));
        zzj(map3, new zzf(zzd.zzb(context)));
        zzj(map3, new zzh(context));
        zzj(map3, new zzi(context));
        zzj(map3, new zzj(context));
        zzj(map3, new zzk(context));
        zzj(map3, new zzl(context));
        zzj(map3, new zzs());
        zzj(map3, new zzam(zzrvVar.zzb()));
        zzj(map3, new zzaq(zzapVar));
        zzj(map3, new zzax(dataLayer));
        zzj(map3, new zzbh(context));
        zzj(map3, new zzbi());
        zzj(map3, new zzbp());
        zzj(map3, new zzbs(this));
        zzj(map3, new zzbx());
        zzj(map3, new zzby());
        zzj(map3, new zzcv(context));
        zzj(map3, new zzcx());
        zzj(map3, new zzdb());
        zzj(map3, new zzdh());
        zzj(map3, new zzdi(context));
        zzj(map3, new zzds());
        zzj(map3, new zzdw());
        zzj(map3, new zzea());
        zzj(map3, new zzec());
        zzj(map3, new zzee(context));
        zzj(map3, new zzeu());
        zzj(map3, new zzev());
        zzj(map3, new zzfp());
        zzj(map3, new zzfw());
        this.zzh = new HashMap();
        for (zzrz zzrzVar : hashSet) {
            for (int i = 0; i < zzrzVar.zza().size(); i++) {
                zzrr zzrrVar = (zzrr) zzrzVar.zza().get(i);
                zzes zzesVarZzg = zzg(this.zzh, zzh(zzrrVar));
                zzesVarZzg.zzk(zzrzVar);
                zzesVarZzg.zzg(zzrzVar, zzrrVar);
                zzesVarZzg.zzh(zzrzVar, "Unknown");
            }
            for (int i2 = 0; i2 < zzrzVar.zzf().size(); i2++) {
                zzrr zzrrVar2 = (zzrr) zzrzVar.zzf().get(i2);
                zzes zzesVarZzg2 = zzg(this.zzh, zzh(zzrrVar2));
                zzesVarZzg2.zzk(zzrzVar);
                zzesVarZzg2.zzi(zzrzVar, zzrrVar2);
                zzesVarZzg2.zzj(zzrzVar, "Unknown");
            }
        }
        for (Map.Entry entry : this.zzb.zzd().entrySet()) {
            for (zzrr zzrrVar3 : (List) entry.getValue()) {
                if (!zzfu.zzg(zzfu.zzl((com.google.android.gms.internal.gtm.zzam) zzrrVar3.zzc().get(com.google.android.gms.internal.gtm.zzb.NOT_DEFAULT_MACRO.toString()))).booleanValue()) {
                    zzg(this.zzh, (String) entry.getKey()).zzl(zzrrVar3);
                }
            }
        }
    }

    private static zzes zzg(Map map, String str) {
        zzes zzesVar = (zzes) map.get(str);
        if (zzesVar != null) {
            return zzesVar;
        }
        zzes zzesVar2 = new zzes();
        map.put(str, zzesVar2);
        return zzesVar2;
    }

    private static String zzh(zzrr zzrrVar) {
        return zzfu.zzn(zzfu.zzl((com.google.android.gms.internal.gtm.zzam) zzrrVar.zzc().get(com.google.android.gms.internal.gtm.zzb.INSTANCE_NAME.toString())));
    }

    private final String zzi() {
        if (this.zzj <= 1) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(Integer.toString(this.zzj));
        for (int i = 2; i < this.zzj; i++) {
            sb.append(TokenParser.SP);
        }
        sb.append(": ");
        return sb.toString();
    }

    private static void zzj(Map map, zzbt zzbtVar) {
        if (map.containsKey(zzbtVar.zze())) {
            throw new IllegalArgumentException("Duplicate function type name: ".concat(String.valueOf(zzbtVar.zze())));
        }
        map.put(zzbtVar.zze(), zzbtVar);
    }

    private final void zzk(com.google.android.gms.internal.gtm.zzam zzamVar, Set set) throws InterruptedException {
        zzdr zzdrVarZzo;
        if (zzamVar == null || (zzdrVarZzo = zzo(zzamVar, set, new zzdp())) == zza) {
            return;
        }
        Object objZzl = zzfu.zzl((com.google.android.gms.internal.gtm.zzam) zzdrVarZzo.zza());
        if (objZzl instanceof Map) {
            this.zzg.push((Map) objZzl);
            return;
        }
        if (!(objZzl instanceof List)) {
            Log.w("GoogleTagManager", "pushAfterEvaluate: value not a Map or List");
            return;
        }
        for (Object obj : (List) objZzl) {
            if (obj instanceof Map) {
                this.zzg.push((Map) obj);
            } else {
                Log.w("GoogleTagManager", "pushAfterEvaluate: value not a Map");
            }
        }
    }

    private final zzdr zzl(Set set, Set set2, zzeq zzeqVar, zzdo zzdoVar) throws InterruptedException {
        zzdr zzdrVar;
        Set hashSet = new HashSet();
        Set hashSet2 = new HashSet();
        Iterator it = set.iterator();
        while (true) {
            boolean z = true;
            while (it.hasNext()) {
                zzrz zzrzVar = (zzrz) it.next();
                zzdn zzdnVar = new zzdn();
                Iterator it2 = zzrzVar.zzd().iterator();
                while (true) {
                    boolean z2 = true;
                    while (true) {
                        if (!it2.hasNext()) {
                            Iterator it3 = zzrzVar.zze().iterator();
                            while (true) {
                                if (!it3.hasNext()) {
                                    zzfu.zzc(true);
                                    zzdrVar = new zzdr(true, z2);
                                    break;
                                }
                                zzdr zzdrVarZzf = zzf((zzrr) it3.next(), set2, new zzdm());
                                if (!((Boolean) zzdrVarZzf.zza()).booleanValue()) {
                                    zzfu.zzc(false);
                                    zzdrVar = new zzdr(false, zzdrVarZzf.zzb());
                                    break;
                                }
                                z2 = z2 && zzdrVarZzf.zzb();
                            }
                        } else {
                            zzdr zzdrVarZzf2 = zzf((zzrr) it2.next(), set2, new zzdm());
                            if (((Boolean) zzdrVarZzf2.zza()).booleanValue()) {
                                zzfu.zzc(false);
                                zzdrVar = new zzdr(false, zzdrVarZzf2.zzb());
                                break;
                            }
                            if (!z2 || !zzdrVarZzf2.zzb()) {
                                z2 = false;
                            }
                        }
                    }
                }
                if (((Boolean) zzdrVar.zza()).booleanValue()) {
                    zzeqVar.zza(zzrzVar, hashSet, hashSet2, zzdnVar);
                }
                if (!z || !zzdrVar.zzb()) {
                    z = false;
                }
            }
            hashSet.removeAll(hashSet2);
            return new zzdr(hashSet, z);
        }
    }

    private final zzdr zzm(String str, Set set, zzdl zzdlVar) throws InterruptedException {
        zzrr zzrrVarZza;
        this.zzj++;
        zzer zzerVar = (zzer) this.zzm.zza(str);
        if (zzerVar != null) {
            zzk(zzerVar.zzb(), set);
            this.zzj--;
            return zzerVar.zzc();
        }
        zzes zzesVar = (zzes) this.zzh.get(str);
        if (zzesVar == null) {
            Log.e("GoogleTagManager", zzi() + "Invalid macro: " + str);
            this.zzj = this.zzj + (-1);
            return zza;
        }
        zzdr zzdrVarZzl = zzl(zzesVar.zzf(), set, new zzeo(this, zzesVar.zzc(), zzesVar.zzb(), zzesVar.zze(), zzesVar.zzd()), new zzdo());
        if (((Set) zzdrVarZzl.zza()).isEmpty()) {
            zzrrVarZza = zzesVar.zza();
        } else {
            if (((Set) zzdrVarZzl.zza()).size() > 1) {
                Log.w("GoogleTagManager", zzi() + "Multiple macros active for macroName " + str);
            }
            zzrrVarZza = (zzrr) ((Set) zzdrVarZzl.zza()).iterator().next();
        }
        if (zzrrVarZza == null) {
            this.zzj--;
            return zza;
        }
        zzdr zzdrVarZzn = zzn(this.zze, zzrrVarZza, set, new zzdm());
        boolean z = zzdrVarZzl.zzb() && zzdrVarZzn.zzb();
        zzdr zzdrVar = zza;
        if (zzdrVarZzn != zzdrVar) {
            zzdrVar = new zzdr((com.google.android.gms.internal.gtm.zzam) zzdrVarZzn.zza(), z);
        }
        com.google.android.gms.internal.gtm.zzam zzamVarZza = zzrrVarZza.zza();
        if (zzdrVar.zzb()) {
            this.zzm.zzb(str, new zzer(zzdrVar, zzamVarZza));
        }
        zzk(zzamVarZza, set);
        this.zzj--;
        return zzdrVar;
    }

    private final zzdr zzn(Map map, zzrr zzrrVar, Set set, zzdm zzdmVar) throws InterruptedException {
        com.google.android.gms.internal.gtm.zzam zzamVar = (com.google.android.gms.internal.gtm.zzam) zzrrVar.zzc().get(com.google.android.gms.internal.gtm.zzb.FUNCTION.toString());
        if (zzamVar == null) {
            Log.e("GoogleTagManager", "No function id in properties");
            return zza;
        }
        String strZzo = zzamVar.zzo();
        zzbt zzbtVar = (zzbt) map.get(strZzo);
        if (zzbtVar == null) {
            Log.e("GoogleTagManager", String.valueOf(strZzo).concat(" has no backing implementation."));
            return zza;
        }
        zzdr zzdrVar = (zzdr) this.zzl.zza(zzrrVar);
        if (zzdrVar != null) {
            return zzdrVar;
        }
        HashMap map2 = new HashMap();
        boolean z = true;
        for (Map.Entry entry : zzrrVar.zzc().entrySet()) {
            com.google.android.gms.internal.gtm.zzam zzamVar2 = (com.google.android.gms.internal.gtm.zzam) entry.getValue();
            zzdr zzdrVarZzo = zzo(zzamVar2, set, new zzdp());
            zzdr zzdrVar2 = zza;
            if (zzdrVarZzo == zzdrVar2) {
                return zzdrVar2;
            }
            if (zzdrVarZzo.zzb()) {
                zzrrVar.zzd((String) entry.getKey(), (com.google.android.gms.internal.gtm.zzam) zzdrVarZzo.zza());
            } else {
                z = false;
            }
            map2.put((String) entry.getKey(), (com.google.android.gms.internal.gtm.zzam) zzdrVarZzo.zza());
        }
        if (zzbtVar.zzg(map2.keySet())) {
            boolean z2 = z && zzbtVar.zzb();
            zzdr zzdrVar3 = new zzdr(zzbtVar.zza(map2), z2);
            if (z2) {
                this.zzl.zzb(zzrrVar, zzdrVar3);
            }
            return zzdrVar3;
        }
        Log.e("GoogleTagManager", "Incorrect keys for function " + strZzo + " required " + zzbtVar.zzf().toString() + " had " + String.valueOf(map2.keySet()));
        return zza;
    }

    private final zzdr zzo(com.google.android.gms.internal.gtm.zzam zzamVar, Set set, zzdp zzdpVar) throws InterruptedException {
        if (!zzamVar.zzP()) {
            return new zzdr(zzamVar, true);
        }
        com.google.android.gms.internal.gtm.zzat zzatVar = com.google.android.gms.internal.gtm.zzat.STRING;
        int iOrdinal = zzamVar.zzh().ordinal();
        if (iOrdinal == 1) {
            com.google.android.gms.internal.gtm.zzan zzanVar = (com.google.android.gms.internal.gtm.zzan) zzsd.zza(zzamVar).zzaa();
            zzanVar.zzj();
            for (int i = 0; i < zzamVar.zza(); i++) {
                zzdr zzdrVarZzo = zzo(zzamVar.zzk(i), set, new zzdp());
                zzdr zzdrVar = zza;
                if (zzdrVarZzo == zzdrVar) {
                    return zzdrVar;
                }
                zzanVar.zze((com.google.android.gms.internal.gtm.zzam) zzdrVarZzo.zza());
            }
            return new zzdr((com.google.android.gms.internal.gtm.zzam) zzanVar.zzC(), false);
        }
        if (iOrdinal == 2) {
            com.google.android.gms.internal.gtm.zzan zzanVar2 = (com.google.android.gms.internal.gtm.zzan) zzsd.zza(zzamVar).zzaa();
            if (zzamVar.zzc() != zzamVar.zzd()) {
                Log.e("GoogleTagManager", "Invalid serving value: ".concat(zzamVar.toString()));
                return zza;
            }
            zzanVar2.zzk();
            zzanVar2.zzl();
            for (int i2 = 0; i2 < zzamVar.zzc(); i2++) {
                zzdr zzdrVarZzo2 = zzo(zzamVar.zzl(i2), set, new zzdp());
                zzdr zzdrVarZzo3 = zzo(zzamVar.zzm(i2), set, new zzdp());
                zzdr zzdrVar2 = zza;
                if (zzdrVarZzo2 == zzdrVar2 || zzdrVarZzo3 == zzdrVar2) {
                    return zzdrVar2;
                }
                zzanVar2.zzf((com.google.android.gms.internal.gtm.zzam) zzdrVarZzo2.zza());
                zzanVar2.zzg((com.google.android.gms.internal.gtm.zzam) zzdrVarZzo3.zza());
            }
            return new zzdr((com.google.android.gms.internal.gtm.zzam) zzanVar2.zzC(), false);
        }
        if (iOrdinal != 3) {
            if (iOrdinal != 6) {
                Log.e("GoogleTagManager", "Unknown type: ".concat(String.valueOf(String.valueOf(zzamVar.zzh()))));
                return zza;
            }
            com.google.android.gms.internal.gtm.zzan zzanVar3 = (com.google.android.gms.internal.gtm.zzan) zzsd.zza(zzamVar).zzaa();
            zzanVar3.zzm();
            for (int i3 = 0; i3 < zzamVar.zze(); i3++) {
                zzdr zzdrVarZzo4 = zzo(zzamVar.zzn(i3), set, new zzdp());
                zzdr zzdrVar3 = zza;
                if (zzdrVarZzo4 == zzdrVar3) {
                    return zzdrVar3;
                }
                zzanVar3.zzh((com.google.android.gms.internal.gtm.zzam) zzdrVarZzo4.zza());
            }
            return new zzdr((com.google.android.gms.internal.gtm.zzam) zzanVar3.zzC(), false);
        }
        if (set.contains(zzamVar.zzp())) {
            Log.e("GoogleTagManager", "Macro cycle detected.  Current macro reference: " + zzamVar.zzp() + ".  Previous macro references: " + set.toString() + ".");
            return zza;
        }
        set.add(zzamVar.zzp());
        zzdr zzdrVarZzm = zzm(zzamVar.zzp(), set, new zzdl());
        for (com.google.android.gms.internal.gtm.zzaq zzaqVar : (com.google.android.gms.internal.gtm.zzaq[]) zzamVar.zzr().toArray(new com.google.android.gms.internal.gtm.zzaq[0])) {
            if (zzfu.zzl((com.google.android.gms.internal.gtm.zzam) zzdrVarZzm.zza()) instanceof String) {
                com.google.android.gms.internal.gtm.zzaq zzaqVar2 = com.google.android.gms.internal.gtm.zzaq.ESCAPE_HTML;
                if (zzaqVar.ordinal() == 11) {
                    try {
                        zzdrVarZzm = new zzdr(zzfu.zzc(zzfx.zza(zzfu.zzn(zzfu.zzl((com.google.android.gms.internal.gtm.zzam) zzdrVarZzm.zza())))), zzdrVarZzm.zzb());
                    } catch (UnsupportedEncodingException e) {
                        Log.e("GoogleTagManager", "Escape URI: unsupported encoding", e);
                    }
                }
            } else {
                Log.e("GoogleTagManager", "Escaping can only be applied to strings.");
            }
        }
        set.remove(zzamVar.zzp());
        return zzdrVarZzm;
    }

    public final zzdr zza(String str) {
        this.zzj = 0;
        return zzm(str, new HashSet(), new zzdl());
    }

    final synchronized String zzb() {
        return this.zzi;
    }

    public final synchronized void zzc(String str) {
        zzd(str);
        Iterator it = ((Set) zzl(this.zzf, new HashSet(), new zzep(this), new zzdo()).zza()).iterator();
        while (it.hasNext()) {
            zzn(this.zzc, (zzrr) it.next(), new HashSet(), new zzdm());
        }
        zzd(null);
    }

    final synchronized void zzd(String str) {
        this.zzi = str;
    }

    public final synchronized void zze(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            com.google.android.gms.internal.gtm.zzai zzaiVar = (com.google.android.gms.internal.gtm.zzai) it.next();
            if (zzaiVar.zzf() && zzaiVar.zzd().startsWith("gaExperiment:")) {
                DataLayer dataLayer = this.zzg;
                if (zzaiVar.zze()) {
                    Iterator it2 = zzaiVar.zza().zze().iterator();
                    while (it2.hasNext()) {
                        dataLayer.zzd(zzfu.zzn(zzfu.zzl((com.google.android.gms.internal.gtm.zzam) it2.next())));
                    }
                    Iterator it3 = zzaiVar.zza().zzf().iterator();
                    while (true) {
                        Map<String, Object> map = null;
                        if (!it3.hasNext()) {
                            break;
                        }
                        Object objZzl = zzfu.zzl((com.google.android.gms.internal.gtm.zzam) it3.next());
                        if (objZzl instanceof Map) {
                            map = (Map) objZzl;
                        } else {
                            Log.w("GoogleTagManager", "value: " + String.valueOf(objZzl) + " is not a map value, ignored.");
                        }
                        if (map != null) {
                            dataLayer.push(map);
                        }
                    }
                    for (com.google.android.gms.internal.gtm.zzw zzwVar : zzaiVar.zza().zzd()) {
                        if (zzwVar.zzh()) {
                            Object objValueOf = dataLayer.get(zzwVar.zzf());
                            Long lValueOf = !(objValueOf instanceof Number) ? null : Long.valueOf(((Number) objValueOf).longValue());
                            long jZzd = zzwVar.zzd();
                            long jZzc = zzwVar.zzc();
                            if (!zzwVar.zzg() || lValueOf == null || lValueOf.longValue() < jZzd || lValueOf.longValue() > jZzc) {
                                if (jZzd <= jZzc) {
                                    objValueOf = Long.valueOf(Math.round((Math.random() * (jZzc - jZzd)) + jZzd));
                                } else {
                                    Log.w("GoogleTagManager", "GaExperimentRandom: random range invalid");
                                }
                            }
                            dataLayer.zzd(zzwVar.zzf());
                            Map mapZza = dataLayer.zza(zzwVar.zzf(), objValueOf);
                            if (zzwVar.zza() > 0) {
                                if (mapZza.containsKey("gtm")) {
                                    Object obj = mapZza.get("gtm");
                                    if (obj instanceof Map) {
                                        ((Map) obj).put("lifetime", Long.valueOf(zzwVar.zza()));
                                    } else {
                                        Log.w("GoogleTagManager", "GaExperimentRandom: gtm not a map");
                                    }
                                } else {
                                    mapZza.put("gtm", DataLayer.mapOf("lifetime", Long.valueOf(zzwVar.zza())));
                                }
                            }
                            dataLayer.push(mapZza);
                        } else {
                            Log.w("GoogleTagManager", "GaExperimentRandom: No key");
                        }
                    }
                } else {
                    Log.w("GoogleTagManager", "supplemental missing experimentSupplemental");
                }
            } else {
                zzdg.zzb.zzd("Ignored supplemental: ".concat(String.valueOf(String.valueOf(zzaiVar))));
            }
        }
    }

    final zzdr zzf(zzrr zzrrVar, Set set, zzdm zzdmVar) throws InterruptedException {
        zzdr zzdrVarZzn = zzn(this.zzd, zzrrVar, set, zzdmVar);
        Boolean boolZzg = zzfu.zzg(zzfu.zzl((com.google.android.gms.internal.gtm.zzam) zzdrVarZzn.zza()));
        zzfu.zzc(boolZzg);
        return new zzdr(boolZzg, zzdrVarZzn.zzb());
    }
}
