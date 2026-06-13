package com.google.android.gms.internal.gtm;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.HttpUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import kr.switcher.device.switcher.Switcher;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzfu {
    public static long zza(String str) {
        if (str == null) {
            return 0L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return 0L;
        }
    }

    public static zzay zzb(zzfd zzfdVar, String str) {
        Preconditions.checkNotNull(zzfdVar);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        new HashMap();
        try {
            Map<String, String> map = HttpUtils.parse(new URI("?" + str), "UTF-8");
            zzay zzayVar = new zzay();
            zzayVar.zzp(map.get("utm_content"));
            zzayVar.zzu(map.get("utm_medium"));
            zzayVar.zzv(map.get("utm_campaign"));
            zzayVar.zzw(map.get("utm_source"));
            zzayVar.zzt(map.get("utm_term"));
            zzayVar.zzs(map.get("utm_id"));
            zzayVar.zzo(map.get("anid"));
            zzayVar.zzr(map.get("gclid"));
            zzayVar.zzq(map.get("dclid"));
            zzayVar.zzn(map.get(FirebaseAnalytics.Param.ACLID));
            return zzayVar;
        } catch (URISyntaxException e) {
            zzfdVar.zzR("No valid campaign data found", e);
            return null;
        }
    }

    public static String zzc(boolean z) {
        return true != z ? Switcher.SwitcherReservation.SWITCH_1WAY_FIRMWARE : "1";
    }

    public static String zzd(Locale locale) {
        if (locale == null) {
            return null;
        }
        String language = locale.getLanguage();
        if (TextUtils.isEmpty(language)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(language.toLowerCase(locale));
        if (!TextUtils.isEmpty(locale.getCountry())) {
            sb.append("-");
            sb.append(locale.getCountry().toLowerCase(locale));
        }
        return sb.toString();
    }

    public static MessageDigest zze(String str) {
        MessageDigest messageDigest;
        for (int i = 0; i < 2; i++) {
            try {
                messageDigest = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException unused) {
            }
            if (messageDigest != null) {
                return messageDigest;
            }
        }
        return null;
    }

    public static Map zzf(String str) {
        HashMap map = new HashMap();
        for (String str2 : str.split("&")) {
            String[] strArrSplit = str2.split("=", 3);
            int length = strArrSplit.length;
            if (length > 1) {
                map.put(strArrSplit[0], TextUtils.isEmpty(strArrSplit[1]) ? null : strArrSplit[1]);
                if (length == 3 && !TextUtils.isEmpty(strArrSplit[1]) && !map.containsKey(strArrSplit[1])) {
                    map.put(strArrSplit[1], TextUtils.isEmpty(strArrSplit[2]) ? null : strArrSplit[2]);
                }
            } else if (length == 1 && strArrSplit[0].length() != 0) {
                map.put(strArrSplit[0], null);
            }
        }
        return map;
    }

    public static void zzg(Map map, String str, String str2) {
        if (str2 == null || map.containsKey(str)) {
            return;
        }
        map.put(str, str2);
    }

    public static void zzh(Map map, String str, Map map2) {
        zzg(map, str, (String) map2.get(str));
    }

    public static boolean zzi(Context context, String str, boolean z) {
        try {
            ActivityInfo receiverInfo = context.getPackageManager().getReceiverInfo(new ComponentName(context, str), 0);
            if (receiverInfo != null && receiverInfo.enabled) {
                if (!z) {
                    return true;
                }
                if (receiverInfo.exported) {
                    return true;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    public static boolean zzj(double d, String str) {
        int i;
        if (d > 0.0d && d < 100.0d) {
            if (TextUtils.isEmpty(str)) {
                i = 1;
            } else {
                i = 0;
                for (int length = str.length() - 1; length >= 0; length--) {
                    char cCharAt = str.charAt(length);
                    i = ((i << 6) & 268435455) + cCharAt + (cCharAt << 14);
                    int i2 = 266338304 & i;
                    if (i2 != 0) {
                        i ^= i2 >> 21;
                    }
                }
            }
            if (i % 10000 >= d * 100.0d) {
                return true;
            }
        }
        return false;
    }
}
