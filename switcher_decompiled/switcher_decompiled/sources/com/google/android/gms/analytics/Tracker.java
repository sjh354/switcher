package com.google.android.gms.analytics;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.gtm.zzbu;
import com.google.android.gms.internal.gtm.zzbx;
import com.google.android.gms.internal.gtm.zzfb;
import com.google.android.gms.internal.gtm.zzft;
import com.google.android.gms.internal.gtm.zzfu;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import kr.switcher.device.switcher.Switcher;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public class Tracker extends zzbu {
    private boolean zza;
    private final Map zzb;
    private final Map zzc;
    private final zzfb zzd;
    private final zzv zze;
    private ExceptionReporter zzf;
    private zzft zzg;

    Tracker(zzbx zzbxVar, String str, zzfb zzfbVar) {
        super(zzbxVar);
        HashMap map = new HashMap();
        this.zzb = map;
        this.zzc = new HashMap();
        if (str != null) {
            map.put("&tid", str);
        }
        map.put("useSecure", "1");
        map.put("&a", Integer.toString(new Random().nextInt(Integer.MAX_VALUE) + 1));
        this.zzd = new zzfb(60, 2000L, "tracking", zzC());
        this.zze = new zzv(this, zzbxVar);
    }

    private static void zzY(Map map, Map map2) {
        Preconditions.checkNotNull(map2);
        if (map == null) {
            return;
        }
        for (Map.Entry entry : map.entrySet()) {
            String strZzn = zzn(entry);
            if (strZzn != null) {
                map2.put(strZzn, (String) entry.getValue());
            }
        }
    }

    private static String zzn(Map.Entry entry) {
        String str = (String) entry.getKey();
        if (!str.startsWith("&") || str.length() < 2) {
            return null;
        }
        return ((String) entry.getKey()).substring(1);
    }

    public void enableAdvertisingIdCollection(boolean z) {
        this.zza = z;
    }

    public void enableAutoActivityTracking(boolean z) {
        this.zze.zzc(z);
    }

    public void enableExceptionReporting(boolean z) {
        synchronized (this) {
            ExceptionReporter exceptionReporter = this.zzf;
            if ((exceptionReporter != null) == z) {
                return;
            }
            if (z) {
                ExceptionReporter exceptionReporter2 = new ExceptionReporter(this, Thread.getDefaultUncaughtExceptionHandler(), zzo());
                this.zzf = exceptionReporter2;
                Thread.setDefaultUncaughtExceptionHandler(exceptionReporter2);
                zzN("Uncaught exceptions will be reported to Google Analytics");
            } else {
                Thread.setDefaultUncaughtExceptionHandler(exceptionReporter.zza());
                zzN("Uncaught exceptions will not be reported to Google Analytics");
            }
        }
    }

    public String get(String str) {
        zzV();
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.zzb.containsKey(str)) {
            return (String) this.zzb.get(str);
        }
        if (str.equals("&ul")) {
            return zzfu.zzd(Locale.getDefault());
        }
        if (str.equals("&cid")) {
            return zzv().zzb();
        }
        if (str.equals("&sr")) {
            return zzx().zzb();
        }
        if (str.equals("&aid")) {
            return zzu().zza().zzd();
        }
        if (str.equals("&an")) {
            return zzu().zza().zzf();
        }
        if (str.equals("&av")) {
            return zzu().zza().zzg();
        }
        if (str.equals("&aiid")) {
            return zzu().zza().zze();
        }
        return null;
    }

    public void send(Map<String, String> map) {
        long jCurrentTimeMillis = zzC().currentTimeMillis();
        if (zzp().getAppOptOut()) {
            zzE("AppOptOut is set to true. Not sending Google Analytics hit");
            return;
        }
        boolean zIsDryRunEnabled = zzp().isDryRunEnabled();
        HashMap map2 = new HashMap();
        zzY(this.zzb, map2);
        zzY(map, map2);
        String str = (String) this.zzb.get("useSecure");
        int i = 1;
        boolean z = str == null || str.equalsIgnoreCase("true") || str.equalsIgnoreCase("yes") || str.equalsIgnoreCase("1") || !(str.equalsIgnoreCase("false") || str.equalsIgnoreCase("no") || str.equalsIgnoreCase(Switcher.SwitcherReservation.SWITCH_1WAY_FIRMWARE));
        Map map3 = this.zzc;
        Preconditions.checkNotNull(map2);
        for (Map.Entry entry : map3.entrySet()) {
            String strZzn = zzn(entry);
            if (strZzn != null && !map2.containsKey(strZzn)) {
                map2.put(strZzn, (String) entry.getValue());
            }
        }
        this.zzc.clear();
        String str2 = (String) map2.get("t");
        if (TextUtils.isEmpty(str2)) {
            zzz().zzc(map2, "Missing hit type parameter");
            return;
        }
        String str3 = (String) map2.get("tid");
        if (TextUtils.isEmpty(str3)) {
            zzz().zzc(map2, "Missing tracking id parameter");
            return;
        }
        boolean z2 = this.zza;
        synchronized (this) {
            if ("screenview".equalsIgnoreCase(str2) || "pageview".equalsIgnoreCase(str2) || "appview".equalsIgnoreCase(str2) || TextUtils.isEmpty(str2)) {
                String str4 = (String) this.zzb.get("&a");
                Preconditions.checkNotNull(str4);
                int i2 = Integer.parseInt(str4) + 1;
                if (i2 < Integer.MAX_VALUE) {
                    i = i2;
                }
                this.zzb.put("&a", Integer.toString(i));
            }
        }
        zzq().zzi(new zzu(this, map2, z2, str2, jCurrentTimeMillis, zIsDryRunEnabled, z, str3));
    }

    public void set(String str, String str2) {
        Preconditions.checkNotNull(str, "Key should be non-null");
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.zzb.put(str, str2);
    }

    public void setAnonymizeIp(boolean z) {
        set("&aip", zzfu.zzc(z));
    }

    public void setAppId(String str) {
        set("&aid", str);
    }

    public void setAppInstallerId(String str) {
        set("&aiid", str);
    }

    public void setAppName(String str) {
        set("&an", str);
    }

    public void setAppVersion(String str) {
        set("&av", str);
    }

    public void setCampaignParamsOnNextHit(Uri uri) {
        if (uri == null || uri.isOpaque()) {
            return;
        }
        String queryParameter = uri.getQueryParameter("referrer");
        if (TextUtils.isEmpty(queryParameter)) {
            return;
        }
        Uri uri2 = Uri.parse("http://hostname/?".concat(String.valueOf(queryParameter)));
        String queryParameter2 = uri2.getQueryParameter("utm_id");
        if (queryParameter2 != null) {
            this.zzc.put("&ci", queryParameter2);
        }
        String queryParameter3 = uri2.getQueryParameter("anid");
        if (queryParameter3 != null) {
            this.zzc.put("&anid", queryParameter3);
        }
        String queryParameter4 = uri2.getQueryParameter("utm_campaign");
        if (queryParameter4 != null) {
            this.zzc.put("&cn", queryParameter4);
        }
        String queryParameter5 = uri2.getQueryParameter("utm_content");
        if (queryParameter5 != null) {
            this.zzc.put("&cc", queryParameter5);
        }
        String queryParameter6 = uri2.getQueryParameter("utm_medium");
        if (queryParameter6 != null) {
            this.zzc.put("&cm", queryParameter6);
        }
        String queryParameter7 = uri2.getQueryParameter("utm_source");
        if (queryParameter7 != null) {
            this.zzc.put("&cs", queryParameter7);
        }
        String queryParameter8 = uri2.getQueryParameter("utm_term");
        if (queryParameter8 != null) {
            this.zzc.put("&ck", queryParameter8);
        }
        String queryParameter9 = uri2.getQueryParameter("dclid");
        if (queryParameter9 != null) {
            this.zzc.put("&dclid", queryParameter9);
        }
        String queryParameter10 = uri2.getQueryParameter("gclid");
        if (queryParameter10 != null) {
            this.zzc.put("&gclid", queryParameter10);
        }
        String queryParameter11 = uri2.getQueryParameter(FirebaseAnalytics.Param.ACLID);
        if (queryParameter11 != null) {
            this.zzc.put("&aclid", queryParameter11);
        }
    }

    public void setClientId(String str) {
        set("&cid", str);
    }

    public void setEncoding(String str) {
        set("&de", str);
    }

    public void setHostname(String str) {
        set("&dh", str);
    }

    public void setLanguage(String str) {
        set("&ul", str);
    }

    public void setLocation(String str) {
        set("&dl", str);
    }

    public void setPage(String str) {
        set("&dp", str);
    }

    public void setReferrer(String str) {
        set("&dr", str);
    }

    public void setSampleRate(double d) {
        set("&sf", Double.toString(d));
    }

    public void setScreenColors(String str) {
        set("&sd", str);
    }

    public void setScreenName(String str) {
        set("&cd", str);
    }

    public void setSessionTimeout(long j) {
        this.zze.zze(j * 1000);
    }

    public void setTitle(String str) {
        set("&dt", str);
    }

    public void setUseSecure(boolean z) {
        set("useSecure", zzfu.zzc(z));
    }

    public void setViewportSize(String str) {
        set("&vp", str);
    }

    @Override // com.google.android.gms.internal.gtm.zzbu
    protected final void zzd() {
        this.zze.zzW();
        String strZza = zzB().zza();
        if (strZza != null) {
            set("&an", strZza);
        }
        String strZzb = zzB().zzb();
        if (strZzb != null) {
            set("&av", strZzb);
        }
    }

    final void zzm(zzft zzftVar) {
        zzN("Loading Tracker config values");
        this.zzg = zzftVar;
        String str = zzftVar.zza;
        if (str != null) {
            set("&tid", str);
            zzO("trackingId loaded", str);
        }
        double d = zzftVar.zzb;
        if (d >= 0.0d) {
            String string = Double.toString(d);
            set("&sf", string);
            zzO("Sample frequency loaded", string);
        }
        int i = zzftVar.zzc;
        if (i >= 0) {
            setSessionTimeout(i);
            zzO("Session timeout loaded", Integer.valueOf(i));
        }
        int i2 = zzftVar.zzd;
        if (i2 != -1) {
            boolean z = 1 == i2;
            enableAutoActivityTracking(z);
            zzO("Auto activity tracking loaded", Boolean.valueOf(z));
        }
        int i3 = zzftVar.zze;
        if (i3 != -1) {
            if (i3 != 0) {
                set("&aip", "1");
            }
            zzO("Anonymize ip loaded", Boolean.valueOf(1 == i3));
        }
        enableExceptionReporting(zzftVar.zzf == 1);
    }

    public void setScreenResolution(int i, int i2) {
        if (i < 0 && i2 < 0) {
            zzQ("Invalid width or height. The values should be non-negative.");
            return;
        }
        set("&sr", i + "x" + i2);
    }
}
