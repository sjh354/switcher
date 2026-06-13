package com.google.android.gms.analytics;

import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.gtm.zzax;
import com.google.android.gms.internal.gtm.zzbk;
import com.google.android.gms.internal.gtm.zzbv;
import com.google.android.gms.internal.gtm.zzbz;
import com.google.android.gms.internal.gtm.zzez;
import com.google.android.gms.internal.gtm.zzfu;
import java.util.HashMap;
import java.util.Map;
import kr.switcher.device.switcher.Switcher;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
final class zzu implements Runnable {
    final /* synthetic */ Map zza;
    final /* synthetic */ boolean zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ long zzd;
    final /* synthetic */ boolean zze;
    final /* synthetic */ boolean zzf;
    final /* synthetic */ String zzg;
    final /* synthetic */ Tracker zzh;

    zzu(Tracker tracker, Map map, boolean z, String str, long j, boolean z2, boolean z3, String str2) {
        this.zzh = tracker;
        this.zza = map;
        this.zzb = z;
        this.zzc = str;
        this.zzd = j;
        this.zze = z2;
        this.zzf = z3;
        this.zzg = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        double d;
        if (this.zzh.zze.zzf()) {
            this.zza.put("sc", "start");
        }
        Map map = this.zza;
        GoogleAnalytics googleAnalyticsZzp = this.zzh.zzp();
        Preconditions.checkNotMainThread("getClientId can not be called from the main thread");
        String strZzb = googleAnalyticsZzp.zzb().zzi().zzb();
        if (strZzb != null && TextUtils.isEmpty((CharSequence) map.get("cid"))) {
            map.put("cid", strZzb);
        }
        String str = (String) this.zza.get("sf");
        if (str != null) {
            try {
                d = Double.parseDouble(str);
            } catch (NumberFormatException unused) {
                d = 100.0d;
            }
            if (zzfu.zzj(d, (String) this.zza.get("cid"))) {
                this.zzh.zzF("Sampling enabled. Hit sampled out. sample rate", Double.valueOf(d));
                return;
            }
        }
        zzbk zzbkVarZzr = this.zzh.zzr();
        if (this.zzb) {
            Map map2 = this.zza;
            boolean zZzb = zzbkVarZzr.zzb();
            if (!map2.containsKey("ate")) {
                map2.put("ate", true != zZzb ? Switcher.SwitcherReservation.SWITCH_1WAY_FIRMWARE : "1");
            }
            zzfu.zzg(this.zza, "adid", zzbkVarZzr.zza());
        } else {
            this.zza.remove("ate");
            this.zza.remove("adid");
        }
        zzax zzaxVarZza = this.zzh.zzu().zza();
        zzfu.zzg(this.zza, "an", zzaxVarZza.zzf());
        zzfu.zzg(this.zza, "av", zzaxVarZza.zzg());
        zzfu.zzg(this.zza, "aid", zzaxVarZza.zzd());
        zzfu.zzg(this.zza, "aiid", zzaxVarZza.zze());
        this.zza.put("v", "1");
        this.zza.put("_v", zzbv.zzb);
        zzfu.zzg(this.zza, "ul", this.zzh.zzx().zza().zzd());
        zzfu.zzg(this.zza, "sr", this.zzh.zzx().zzb());
        if (!this.zzc.equals("transaction") && !this.zzc.equals("item") && !this.zzh.zzd.zza()) {
            this.zzh.zzz().zzc(this.zza, "Too many hits sent too quickly, rate limiting invoked");
            return;
        }
        long jZza = zzfu.zza((String) this.zza.get("ht"));
        if (jZza == 0) {
            jZza = this.zzd;
        }
        long j = jZza;
        if (this.zze) {
            this.zzh.zzz().zzM("Dry run enabled. Would have sent hit", new zzez(this.zzh, this.zza, j, this.zzf));
            return;
        }
        String str2 = (String) this.zza.get("cid");
        HashMap map3 = new HashMap();
        zzfu.zzh(map3, "uid", this.zza);
        zzfu.zzh(map3, "an", this.zza);
        zzfu.zzh(map3, "aid", this.zza);
        zzfu.zzh(map3, "av", this.zza);
        zzfu.zzh(map3, "aiid", this.zza);
        Preconditions.checkNotNull(str2);
        this.zza.put("_s", String.valueOf(this.zzh.zzs().zza(new zzbz(0L, str2, this.zzg, !TextUtils.isEmpty((CharSequence) this.zza.get("adid")), 0L, map3))));
        this.zzh.zzs().zzh(new zzez(this.zzh, this.zza, j, this.zzf));
    }
}
