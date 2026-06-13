package com.google.android.gms.tagmanager;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
final class zzec extends zzbt {
    private static final String zza = com.google.android.gms.internal.gtm.zza.REGEX_GROUP.toString();
    private static final String zzb = com.google.android.gms.internal.gtm.zzb.ARG0.toString();
    private static final String zzc = com.google.android.gms.internal.gtm.zzb.ARG1.toString();
    private static final String zzd = com.google.android.gms.internal.gtm.zzb.IGNORE_CASE.toString();
    private static final String zze = com.google.android.gms.internal.gtm.zzb.GROUP.toString();

    public zzec() {
        super(zza, zzb, zzc);
    }

    @Override // com.google.android.gms.tagmanager.zzbt
    public final com.google.android.gms.internal.gtm.zzam zza(Map map) {
        com.google.android.gms.internal.gtm.zzam zzamVar = (com.google.android.gms.internal.gtm.zzam) map.get(zzb);
        com.google.android.gms.internal.gtm.zzam zzamVar2 = (com.google.android.gms.internal.gtm.zzam) map.get(zzc);
        if (zzamVar == null || zzamVar == zzfu.zzb() || zzamVar2 == null || zzamVar2 == zzfu.zzb()) {
            return zzfu.zzb();
        }
        int iIntValue = 1;
        int i = true != zzfu.zzg(zzfu.zzl((com.google.android.gms.internal.gtm.zzam) map.get(zzd))).booleanValue() ? 64 : 66;
        com.google.android.gms.internal.gtm.zzam zzamVar3 = (com.google.android.gms.internal.gtm.zzam) map.get(zze);
        if (zzamVar3 != null) {
            Long lZzk = zzfu.zzk(zzfu.zzl(zzamVar3));
            if (lZzk == zzfu.zzj()) {
                return zzfu.zzb();
            }
            iIntValue = lZzk.intValue();
            if (iIntValue < 0) {
                return zzfu.zzb();
            }
        }
        try {
            Matcher matcher = Pattern.compile(zzfu.zzn(zzfu.zzl(zzamVar2)), i).matcher(zzfu.zzn(zzfu.zzl(zzamVar)));
            String strGroup = null;
            if (matcher.find() && matcher.groupCount() >= iIntValue) {
                strGroup = matcher.group(iIntValue);
            }
            return strGroup == null ? zzfu.zzb() : zzfu.zzc(strGroup);
        } catch (PatternSyntaxException unused) {
            return zzfu.zzb();
        }
    }

    @Override // com.google.android.gms.tagmanager.zzbt
    public final boolean zzb() {
        return true;
    }
}
