package com.google.android.gms.tagmanager;

import android.util.Base64;
import android.util.Log;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
final class zzbp extends zzbt {
    private static final String zza = com.google.android.gms.internal.gtm.zza.ENCODE.toString();
    private static final String zzb = com.google.android.gms.internal.gtm.zzb.ARG0.toString();
    private static final String zzc = com.google.android.gms.internal.gtm.zzb.NO_PADDING.toString();
    private static final String zzd = com.google.android.gms.internal.gtm.zzb.INPUT_FORMAT.toString();
    private static final String zze = com.google.android.gms.internal.gtm.zzb.OUTPUT_FORMAT.toString();

    public zzbp() {
        super(zza, zzb);
    }

    @Override // com.google.android.gms.tagmanager.zzbt
    public final com.google.android.gms.internal.gtm.zzam zza(Map map) {
        byte[] bArrDecode;
        String strEncodeToString;
        com.google.android.gms.internal.gtm.zzam zzamVar = (com.google.android.gms.internal.gtm.zzam) map.get(zzb);
        if (zzamVar == null || zzamVar == zzfu.zzb()) {
            return zzfu.zzb();
        }
        String strZzn = zzfu.zzn(zzfu.zzl(zzamVar));
        com.google.android.gms.internal.gtm.zzam zzamVar2 = (com.google.android.gms.internal.gtm.zzam) map.get(zzd);
        String strZzn2 = zzamVar2 == null ? "text" : zzfu.zzn(zzfu.zzl(zzamVar2));
        com.google.android.gms.internal.gtm.zzam zzamVar3 = (com.google.android.gms.internal.gtm.zzam) map.get(zze);
        String strZzn3 = zzamVar3 == null ? "base16" : zzfu.zzn(zzfu.zzl(zzamVar3));
        com.google.android.gms.internal.gtm.zzam zzamVar4 = (com.google.android.gms.internal.gtm.zzam) map.get(zzc);
        int i = 2;
        if (zzamVar4 != null && zzfu.zzg(zzfu.zzl(zzamVar4)).booleanValue()) {
            i = 3;
        }
        try {
            if ("text".equals(strZzn2)) {
                bArrDecode = strZzn.getBytes();
            } else if ("base16".equals(strZzn2)) {
                bArrDecode = zzp.zzb(strZzn);
            } else if ("base64".equals(strZzn2)) {
                bArrDecode = Base64.decode(strZzn, i);
            } else {
                if (!"base64url".equals(strZzn2)) {
                    Log.e("GoogleTagManager", "Encode: unknown input format: " + strZzn2);
                    return zzfu.zzb();
                }
                bArrDecode = Base64.decode(strZzn, i | 8);
            }
            if ("base16".equals(strZzn3)) {
                strEncodeToString = zzp.zza(bArrDecode);
            } else if ("base64".equals(strZzn3)) {
                strEncodeToString = Base64.encodeToString(bArrDecode, i);
            } else {
                if (!"base64url".equals(strZzn3)) {
                    Log.e("GoogleTagManager", "Encode: unknown output format: ".concat(String.valueOf(strZzn3)));
                    return zzfu.zzb();
                }
                strEncodeToString = Base64.encodeToString(bArrDecode, i | 8);
            }
            return zzfu.zzc(strEncodeToString);
        } catch (IllegalArgumentException unused) {
            Log.e("GoogleTagManager", "Encode: invalid input:");
            return zzfu.zzb();
        }
    }

    @Override // com.google.android.gms.tagmanager.zzbt
    public final boolean zzb() {
        return true;
    }
}
