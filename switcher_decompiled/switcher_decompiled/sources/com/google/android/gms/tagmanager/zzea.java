package com.google.android.gms.tagmanager;

import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
final class zzea extends zzbt {
    private static final String zza = com.google.android.gms.internal.gtm.zza.RANDOM.toString();
    private static final String zzb = com.google.android.gms.internal.gtm.zzb.MIN.toString();
    private static final String zzc = com.google.android.gms.internal.gtm.zzb.MAX.toString();

    public zzea() {
        super(zza, new String[0]);
    }

    @Override // com.google.android.gms.tagmanager.zzbt
    public final com.google.android.gms.internal.gtm.zzam zza(Map map) {
        com.google.android.gms.internal.gtm.zzam zzamVar = (com.google.android.gms.internal.gtm.zzam) map.get(zzb);
        com.google.android.gms.internal.gtm.zzam zzamVar2 = (com.google.android.gms.internal.gtm.zzam) map.get(zzc);
        double d = 2.147483647E9d;
        double d2 = 0.0d;
        if (zzamVar != null && zzamVar != zzfu.zzb() && zzamVar2 != null && zzamVar2 != zzfu.zzb()) {
            zzft zzftVarZze = zzfu.zze(zzfu.zzl(zzamVar));
            zzft zzftVarZze2 = zzfu.zze(zzfu.zzl(zzamVar2));
            if (zzftVarZze != zzfu.zzd() && zzftVarZze2 != zzfu.zzd()) {
                double dDoubleValue = zzftVarZze.doubleValue();
                double dDoubleValue2 = zzftVarZze2.doubleValue();
                if (dDoubleValue <= dDoubleValue2) {
                    d2 = dDoubleValue;
                    d = dDoubleValue2;
                }
            }
        }
        return zzfu.zzc(Long.valueOf(Math.round((Math.random() * (d - d2)) + d2)));
    }

    @Override // com.google.android.gms.tagmanager.zzbt
    public final boolean zzb() {
        return false;
    }
}
