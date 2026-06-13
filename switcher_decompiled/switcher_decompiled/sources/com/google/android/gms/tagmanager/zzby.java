package com.google.android.gms.tagmanager;

import android.util.Log;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
final class zzby extends zzbt {
    private static final String zza = com.google.android.gms.internal.gtm.zza.HASH.toString();
    private static final String zzb = com.google.android.gms.internal.gtm.zzb.ARG0.toString();
    private static final String zzc = com.google.android.gms.internal.gtm.zzb.ALGORITHM.toString();
    private static final String zzd = com.google.android.gms.internal.gtm.zzb.INPUT_FORMAT.toString();

    public zzby() {
        super(zza, zzb);
    }

    @Override // com.google.android.gms.tagmanager.zzbt
    public final com.google.android.gms.internal.gtm.zzam zza(Map map) {
        byte[] bArrZzb;
        com.google.android.gms.internal.gtm.zzam zzamVar = (com.google.android.gms.internal.gtm.zzam) map.get(zzb);
        if (zzamVar == null || zzamVar == zzfu.zzb()) {
            return zzfu.zzb();
        }
        String strZzn = zzfu.zzn(zzfu.zzl(zzamVar));
        com.google.android.gms.internal.gtm.zzam zzamVar2 = (com.google.android.gms.internal.gtm.zzam) map.get(zzc);
        String strZzn2 = zzamVar2 == null ? "MD5" : zzfu.zzn(zzfu.zzl(zzamVar2));
        com.google.android.gms.internal.gtm.zzam zzamVar3 = (com.google.android.gms.internal.gtm.zzam) map.get(zzd);
        String strZzn3 = zzamVar3 == null ? "text" : zzfu.zzn(zzfu.zzl(zzamVar3));
        if ("text".equals(strZzn3)) {
            bArrZzb = strZzn.getBytes();
        } else {
            if (!"base16".equals(strZzn3)) {
                Log.e("GoogleTagManager", "Hash: unknown input format: ".concat(String.valueOf(strZzn3)));
                return zzfu.zzb();
            }
            bArrZzb = zzp.zzb(strZzn);
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(strZzn2);
            messageDigest.update(bArrZzb);
            return zzfu.zzc(zzp.zza(messageDigest.digest()));
        } catch (NoSuchAlgorithmException unused) {
            Log.e("GoogleTagManager", "Hash: unknown algorithm: ".concat(String.valueOf(strZzn2)));
            return zzfu.zzb();
        }
    }

    @Override // com.google.android.gms.tagmanager.zzbt
    public final boolean zzb() {
        return true;
    }
}
