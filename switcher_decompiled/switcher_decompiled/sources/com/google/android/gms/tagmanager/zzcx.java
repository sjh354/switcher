package com.google.android.gms.tagmanager;

import android.util.Log;
import com.google.android.gms.common.internal.ImagesContract;
import cz.msebera.android.httpclient.message.TokenParser;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
final class zzcx extends zzbt {
    private static final String zza = com.google.android.gms.internal.gtm.zza.JOINER.toString();
    private static final String zzb = com.google.android.gms.internal.gtm.zzb.ARG0.toString();
    private static final String zzc = com.google.android.gms.internal.gtm.zzb.ITEM_SEPARATOR.toString();
    private static final String zzd = com.google.android.gms.internal.gtm.zzb.KEY_VALUE_SEPARATOR.toString();
    private static final String zze = com.google.android.gms.internal.gtm.zzb.ESCAPE.toString();

    public zzcx() {
        super(zza, zzb);
    }

    private static final void zzc(Set set, String str) {
        for (int i = 0; i < str.length(); i++) {
            set.add(Character.valueOf(str.charAt(i)));
        }
    }

    private static final String zzd(String str, int i, Set set) {
        com.google.android.gms.internal.gtm.zzat zzatVar = com.google.android.gms.internal.gtm.zzat.STRING;
        int i2 = i - 1;
        if (i2 == 1) {
            try {
                return zzfx.zza(str);
            } catch (UnsupportedEncodingException e) {
                Log.e("GoogleTagManager", "Joiner: unsupported encoding", e);
                return str;
            }
        }
        if (i2 != 2) {
            return str;
        }
        String strReplace = str.replace("\\", "\\\\");
        Iterator it = set.iterator();
        while (it.hasNext()) {
            String string = ((Character) it.next()).toString();
            strReplace = strReplace.replace(string, "\\".concat(String.valueOf(string)));
        }
        return strReplace;
    }

    @Override // com.google.android.gms.tagmanager.zzbt
    public final com.google.android.gms.internal.gtm.zzam zza(Map map) {
        int i;
        com.google.android.gms.internal.gtm.zzam zzamVar = (com.google.android.gms.internal.gtm.zzam) map.get(zzb);
        if (zzamVar == null) {
            return zzfu.zzb();
        }
        com.google.android.gms.internal.gtm.zzam zzamVar2 = (com.google.android.gms.internal.gtm.zzam) map.get(zzc);
        String strZzn = zzamVar2 != null ? zzfu.zzn(zzfu.zzl(zzamVar2)) : "";
        com.google.android.gms.internal.gtm.zzam zzamVar3 = (com.google.android.gms.internal.gtm.zzam) map.get(zzd);
        String strZzn2 = zzamVar3 != null ? zzfu.zzn(zzfu.zzl(zzamVar3)) : "=";
        com.google.android.gms.internal.gtm.zzam zzamVar4 = (com.google.android.gms.internal.gtm.zzam) map.get(zze);
        HashSet hashSet = null;
        boolean z = true;
        if (zzamVar4 != null) {
            String strZzn3 = zzfu.zzn(zzfu.zzl(zzamVar4));
            if (ImagesContract.URL.equals(strZzn3)) {
                i = 2;
            } else {
                if (!"backslash".equals(strZzn3)) {
                    Log.e("GoogleTagManager", "Joiner: unsupported escape type: ".concat(String.valueOf(strZzn3)));
                    return zzfu.zzb();
                }
                hashSet = new HashSet();
                zzc(hashSet, strZzn);
                zzc(hashSet, strZzn2);
                hashSet.remove(Character.valueOf(TokenParser.ESCAPE));
                i = 3;
            }
        } else {
            i = 1;
        }
        StringBuilder sb = new StringBuilder();
        com.google.android.gms.internal.gtm.zzat zzatVar = com.google.android.gms.internal.gtm.zzat.STRING;
        int iOrdinal = zzamVar.zzh().ordinal();
        if (iOrdinal == 1) {
            for (com.google.android.gms.internal.gtm.zzam zzamVar5 : zzamVar.zzs()) {
                if (!z) {
                    sb.append(strZzn);
                }
                sb.append(zzd(zzfu.zzn(zzfu.zzl(zzamVar5)), i, hashSet));
                z = false;
            }
        } else if (iOrdinal != 2) {
            sb.append(zzd(zzfu.zzn(zzfu.zzl(zzamVar)), i, hashSet));
        } else {
            for (int i2 = 0; i2 < zzamVar.zzc(); i2++) {
                if (i2 > 0) {
                    sb.append(strZzn);
                }
                String strZzn4 = zzfu.zzn(zzfu.zzl(zzamVar.zzl(i2)));
                String strZzn5 = zzfu.zzn(zzfu.zzl(zzamVar.zzm(i2)));
                sb.append(zzd(strZzn4, i, hashSet));
                sb.append(strZzn2);
                sb.append(zzd(strZzn5, i, hashSet));
            }
        }
        return zzfu.zzc(sb.toString());
    }

    @Override // com.google.android.gms.tagmanager.zzbt
    public final boolean zzb() {
        return true;
    }
}
