package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Map;
import kr.switcher.switcherm.network.http.RestErrorCode;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzfd extends zzbu {
    private static zzfd zza;

    public zzfd(zzbx zzbxVar) {
        super(zzbxVar);
    }

    public static zzfd zza() {
        return zza;
    }

    protected static final String zzf(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Integer) {
            obj = Long.valueOf(((Integer) obj).intValue());
        }
        if (!(obj instanceof Long)) {
            return obj instanceof Boolean ? obj.toString() : obj instanceof Throwable ? obj.getClass().getCanonicalName() : "-";
        }
        Long l = (Long) obj;
        if (Math.abs(l.longValue()) < 100) {
            return obj.toString();
        }
        String str = obj.toString().charAt(0) != '-' ? "" : "-";
        String strValueOf = String.valueOf(Math.abs(l.longValue()));
        return str + Math.round(Math.pow(10.0d, strValueOf.length() - 1)) + "..." + str + Math.round(Math.pow(10.0d, strValueOf.length()) - 1.0d);
    }

    public final void zzb(zzez zzezVar, String str) {
        zzR("Discarding hit. ".concat(str), zzezVar != null ? zzezVar.toString() : "no hit data");
    }

    public final void zzc(Map map, String str) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry entry : map.entrySet()) {
            if (sb.length() > 0) {
                sb.append(',');
            }
            sb.append((String) entry.getKey());
            sb.append('=');
            sb.append((String) entry.getValue());
        }
        zzR("Discarding hit. ".concat(str), sb.toString());
    }

    @Override // com.google.android.gms.internal.gtm.zzbu
    protected final void zzd() {
        synchronized (zzfd.class) {
            zza = this;
        }
    }

    public final synchronized void zze(int i, String str, Object obj, Object obj2, Object obj3) {
        char c;
        Preconditions.checkNotNull(str);
        if (zzw().zzb()) {
            zzw();
            c = 'C';
        } else {
            zzw();
            c = 'c';
        }
        String strSubstring = RestErrorCode.CUSTOMER_DOES_NOT_EXIST + "01VDIWEA?".charAt(i) + c + zzbv.zza + ":" + zzD(str, zzf(obj), zzf(obj2), zzf(obj3));
        if (strSubstring.length() > 1024) {
            strSubstring = strSubstring.substring(0, 1024);
        }
        zzfj zzfjVarZzp = zzt().zzp();
        if (zzfjVarZzp != null) {
            zzfjVarZzp.zze().zzc(strSubstring);
        }
    }
}
