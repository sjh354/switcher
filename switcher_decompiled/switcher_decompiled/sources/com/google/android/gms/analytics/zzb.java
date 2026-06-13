package com.google.android.gms.analytics;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.gtm.zzax;
import com.google.android.gms.internal.gtm.zzbg;
import com.google.android.gms.internal.gtm.zzbt;
import com.google.android.gms.internal.gtm.zzbv;
import com.google.android.gms.internal.gtm.zzbx;
import com.google.android.gms.internal.gtm.zzbz;
import com.google.android.gms.internal.gtm.zzez;
import com.google.android.gms.internal.gtm.zzfu;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzb extends zzbt implements zzt {
    private static DecimalFormat zza;
    private final zzbx zzb;
    private final String zzc;
    private final Uri zzd;

    public zzb(zzbx zzbxVar, String str) {
        super(zzbxVar);
        Preconditions.checkNotEmpty(str);
        this.zzb = zzbxVar;
        this.zzc = str;
        this.zzd = zza(str);
    }

    static Uri zza(String str) {
        Preconditions.checkNotEmpty(str);
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("uri");
        builder.authority("google-analytics.com");
        builder.path(str);
        return builder.build();
    }

    static String zzc(double d) {
        if (zza == null) {
            zza = new DecimalFormat("0.######");
        }
        return zza.format(d);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.Map zzd(com.google.android.gms.analytics.zzh r10) {
        /*
            Method dump skipped, instruction units count: 823
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.zzb.zzd(com.google.android.gms.analytics.zzh):java.util.Map");
    }

    private static void zzf(Map map, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        map.put(str, str2);
    }

    private static void zzg(Map map, String str, boolean z) {
        if (z) {
            map.put(str, "1");
        }
    }

    @Override // com.google.android.gms.analytics.zzt
    public final Uri zzb() {
        return this.zzd;
    }

    @Override // com.google.android.gms.analytics.zzt
    public final void zze(zzh zzhVar) {
        Preconditions.checkNotNull(zzhVar);
        Preconditions.checkArgument(zzhVar.zzm(), "Can't deliver not submitted measurement");
        Preconditions.checkNotMainThread("deliver should be called on worker thread");
        zzh zzhVar2 = new zzh(zzhVar);
        zzbg zzbgVar = (zzbg) zzhVar2.zzb(zzbg.class);
        if (TextUtils.isEmpty(zzbgVar.zzf())) {
            zzz().zzc(zzd(zzhVar2), "Ignoring measurement without type");
            return;
        }
        if (TextUtils.isEmpty(zzbgVar.zze())) {
            zzz().zzc(zzd(zzhVar2), "Ignoring measurement without client id");
            return;
        }
        if (this.zzb.zzc().getAppOptOut()) {
            return;
        }
        if (zzfu.zzj(0.0d, zzbgVar.zze())) {
            zzF("Sampling enabled. Hit sampled out. sampling rate", Double.valueOf(0.0d));
            return;
        }
        Map mapZzd = zzd(zzhVar2);
        mapZzd.put("v", "1");
        mapZzd.put("_v", zzbv.zzb);
        mapZzd.put("tid", this.zzc);
        if (this.zzb.zzc().isDryRunEnabled()) {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry entry : mapZzd.entrySet()) {
                if (sb.length() != 0) {
                    sb.append(", ");
                }
                sb.append((String) entry.getKey());
                sb.append("=");
                sb.append((String) entry.getValue());
            }
            zzM("Dry run is enabled. GoogleAnalytics would have sent", sb.toString());
            return;
        }
        HashMap map = new HashMap();
        zzfu.zzg(map, "uid", zzbgVar.zzg());
        zzax zzaxVar = (zzax) zzhVar.zzc(zzax.class);
        if (zzaxVar != null) {
            zzfu.zzg(map, "an", zzaxVar.zzf());
            zzfu.zzg(map, "aid", zzaxVar.zzd());
            zzfu.zzg(map, "av", zzaxVar.zzg());
            zzfu.zzg(map, "aiid", zzaxVar.zze());
        }
        mapZzd.put("_s", String.valueOf(zzs().zza(new zzbz(0L, zzbgVar.zze(), this.zzc, !TextUtils.isEmpty(zzbgVar.zzd()), 0L, map))));
        zzs().zzh(new zzez(zzz(), mapZzd, zzhVar.zza(), true));
    }
}
