package com.google.android.gms.internal.gtm;

import android.util.Log;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzsd {
    public static zzam zza(zzam zzamVar) {
        zzan zzanVarZzg = zzam.zzg();
        zzanVarZzg.zzt(zzat.STRING);
        zzanVarZzg.zzt(zzamVar.zzh());
        zzanVarZzg.zzi();
        zzanVarZzg.zza(zzamVar.zzr());
        zzanVarZzg.zzo(zzamVar.zzP());
        return (zzam) zzanVarZzg.zzC();
    }

    public static zzrv zzb(zzac zzacVar) throws zzsc {
        zzam[] zzamVarArr = new zzam[zzacVar.zzf()];
        for (int i = 0; i < zzacVar.zzf(); i++) {
            zze(i, zzacVar, zzamVarArr, new HashSet(0));
        }
        zzrx zzrxVar = new zzrx(null);
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < zzacVar.zze(); i2++) {
            arrayList.add(zzf(zzacVar.zzi(i2), zzacVar, zzamVarArr, i2));
        }
        ArrayList arrayList2 = new ArrayList();
        for (int i3 = 0; i3 < zzacVar.zzc(); i3++) {
            arrayList2.add(zzf(zzacVar.zzh(i3), zzacVar, zzamVarArr, i3));
        }
        ArrayList arrayList3 = new ArrayList();
        for (int i4 = 0; i4 < zzacVar.zza(); i4++) {
            zzrr zzrrVarZzf = zzf(zzacVar.zzg(i4), zzacVar, zzamVarArr, i4);
            zzrxVar.zzb(zzrrVarZzf);
            arrayList3.add(zzrrVarZzf);
        }
        for (zzae zzaeVar : zzacVar.zzq()) {
            zzsb zzsbVar = new zzsb(null);
            Iterator it = zzaeVar.zzh().iterator();
            while (it.hasNext()) {
                zzsbVar.zzg((zzrr) arrayList2.get(((Integer) it.next()).intValue()));
            }
            Iterator it2 = zzaeVar.zzg().iterator();
            while (it2.hasNext()) {
                zzsbVar.zzf((zzrr) arrayList2.get(((Integer) it2.next()).intValue()));
            }
            Iterator it3 = zzaeVar.zze().iterator();
            while (it3.hasNext()) {
                zzsbVar.zzd((zzrr) arrayList.get(((Integer) it3.next()).intValue()));
            }
            Iterator it4 = zzaeVar.zzf().iterator();
            while (it4.hasNext()) {
                zzsbVar.zze(zzacVar.zzm(((Integer) it4.next()).intValue()).zzq());
            }
            Iterator it5 = zzaeVar.zzk().iterator();
            while (it5.hasNext()) {
                zzsbVar.zzj((zzrr) arrayList.get(((Integer) it5.next()).intValue()));
            }
            Iterator it6 = zzaeVar.zzl().iterator();
            while (it6.hasNext()) {
                zzsbVar.zzk(zzacVar.zzm(((Integer) it6.next()).intValue()).zzq());
            }
            Iterator it7 = zzaeVar.zzc().iterator();
            while (it7.hasNext()) {
                zzsbVar.zzb((zzrr) arrayList3.get(((Integer) it7.next()).intValue()));
            }
            Iterator it8 = zzaeVar.zzd().iterator();
            while (it8.hasNext()) {
                zzsbVar.zzc(zzacVar.zzm(((Integer) it8.next()).intValue()).zzq());
            }
            Iterator it9 = zzaeVar.zzi().iterator();
            while (it9.hasNext()) {
                zzsbVar.zzh((zzrr) arrayList3.get(((Integer) it9.next()).intValue()));
            }
            Iterator it10 = zzaeVar.zzj().iterator();
            while (it10.hasNext()) {
                zzsbVar.zzi(zzacVar.zzm(((Integer) it10.next()).intValue()).zzq());
            }
            zzrxVar.zzc(zzsbVar.zza());
        }
        zzrxVar.zze(zzacVar.zzn());
        zzrxVar.zzd(zzacVar.zzd());
        return zzrxVar.zza();
    }

    public static void zzc(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[1024];
        while (true) {
            int i = inputStream.read(bArr);
            if (i == -1) {
                return;
            } else {
                outputStream.write(bArr, 0, i);
            }
        }
    }

    private static zzag zzd(zzam zzamVar) throws zzsc {
        if (!zzamVar.zzX(zzag.zza)) {
            zzh("Expected a ServingValue and didn't get one. Value is: ".concat(String.valueOf(String.valueOf(zzamVar))));
        }
        return (zzag) zzamVar.zzW(zzag.zza);
    }

    private static zzam zze(int i, zzac zzacVar, zzam[] zzamVarArr, Set set) throws zzsc {
        zzan zzanVar;
        Integer numValueOf = Integer.valueOf(i);
        if (set.contains(numValueOf)) {
            zzh("Value cycle detected.  Current value reference: " + i + ".  Previous value references: " + set.toString() + ".");
        }
        zzan zzanVar2 = (zzan) ((zzam) zzg(zzacVar.zzr(), i, "values")).zzaa();
        zzam zzamVar = zzamVarArr[i];
        if (zzamVar != null) {
            return zzamVar;
        }
        set.add(numValueOf);
        zzat zzatVar = zzat.STRING;
        switch (zzanVar2.zzu()) {
            case STRING:
            case FUNCTION_ID:
            case INTEGER:
            case BOOLEAN:
                zzanVar = zzanVar2;
                break;
            case LIST:
                zzag zzagVarZzd = zzd((zzam) zzanVar2.zzC());
                zzan zzanVar3 = (zzan) zza((zzam) zzanVar2.zzC()).zzaa();
                zzanVar3.zzj();
                Iterator it = zzagVarZzd.zzf().iterator();
                while (it.hasNext()) {
                    zzanVar3.zze(zze(((Integer) it.next()).intValue(), zzacVar, zzamVarArr, set));
                }
                zzanVar = zzanVar3;
                break;
            case MAP:
                zzanVar = (zzan) zza((zzam) zzanVar2.zzC()).zzaa();
                zzag zzagVarZzd2 = zzd((zzam) zzanVar2.zzC());
                if (zzagVarZzd2.zzc() != zzagVarZzd2.zzd()) {
                    zzh("Uneven map keys (" + zzagVarZzd2.zzc() + ") and map values (" + zzagVarZzd2.zzd() + ")");
                }
                zzanVar.zzk();
                zzanVar.zzl();
                Iterator it2 = zzagVarZzd2.zzg().iterator();
                while (it2.hasNext()) {
                    zzanVar.zzf(zze(((Integer) it2.next()).intValue(), zzacVar, zzamVarArr, set));
                }
                Iterator it3 = zzagVarZzd2.zzh().iterator();
                while (it3.hasNext()) {
                    zzanVar.zzg(zze(((Integer) it3.next()).intValue(), zzacVar, zzamVarArr, set));
                }
                break;
            case MACRO_REFERENCE:
                zzanVar = (zzan) zza((zzam) zzanVar2.zzC()).zzaa();
                zzanVar.zzr(com.google.android.gms.tagmanager.zzfu.zzn(com.google.android.gms.tagmanager.zzfu.zzl(zze(zzd((zzam) zzanVar2.zzC()).zza(), zzacVar, zzamVarArr, set))));
                break;
            case TEMPLATE:
                zzanVar = (zzan) zza((zzam) zzanVar2.zzC()).zzaa();
                zzag zzagVarZzd3 = zzd((zzam) zzanVar2.zzC());
                zzanVar.zzm();
                Iterator it4 = zzagVarZzd3.zzi().iterator();
                while (it4.hasNext()) {
                    zzanVar.zzh(zze(((Integer) it4.next()).intValue(), zzacVar, zzamVarArr, set));
                }
                break;
            default:
                zzanVar = null;
                break;
        }
        if (zzanVar == null) {
            zzh("Invalid value: ".concat(String.valueOf(String.valueOf(zzanVar2))));
        }
        zzamVarArr[i] = (zzam) zzanVar.zzC();
        set.remove(Integer.valueOf(i));
        return (zzam) zzanVar.zzC();
    }

    private static zzrr zzf(zzu zzuVar, zzac zzacVar, zzam[] zzamVarArr, int i) throws zzsc {
        zzrt zzrtVar = new zzrt(null);
        Iterator it = zzuVar.zzc().iterator();
        while (it.hasNext()) {
            zzaa zzaaVar = (zzaa) zzg(zzacVar.zzp(), ((Integer) it.next()).intValue(), "properties");
            String str = (String) zzg(zzacVar.zzo(), zzaaVar.zza(), UserMetadata.KEYDATA_FILENAME);
            int iZzc = zzaaVar.zzc();
            if (iZzc < 0 || iZzc >= zzamVarArr.length) {
                zzh("Index out of bounds detected: " + iZzc + " in values");
            }
            zzam zzamVar = zzamVarArr[iZzc];
            if (zzb.PUSH_AFTER_EVALUATE.toString().equals(str)) {
                zzrtVar.zzc(zzamVar);
            } else {
                zzrtVar.zzb(str, zzamVar);
            }
        }
        return zzrtVar.zza();
    }

    private static Object zzg(List list, int i, String str) throws zzsc {
        if (i < 0 || i >= list.size()) {
            zzh("Index out of bounds detected: " + i + " in " + str);
        }
        return list.get(i);
    }

    private static void zzh(String str) throws zzsc {
        Log.e("GoogleTagManager", str);
        throw new zzsc(str);
    }
}
