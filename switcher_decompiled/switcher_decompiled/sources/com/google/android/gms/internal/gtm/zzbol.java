package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzbol implements zzbfh {
    COM_ANDROID_WEBVIEW(0),
    COM_GOOGLE_ANDROID_WEBVIEW(1),
    COM_ANDROID_CHROME(2),
    COM_CHROME_BETA(3),
    COM_CHROME_DEV(4),
    COM_CHROME_CANARY(5),
    COM_GOOGLE_ANDROID_APPS_CHROME(6),
    COM_GOOGLE_ANDROID_WEBVIEW_BETA(7),
    COM_GOOGLE_ANDROID_WEBVIEW_DEV(8),
    COM_GOOGLE_ANDROID_WEBVIEW_CANARY(9),
    COM_GOOGLE_ANDROID_WEBVIEW_DEBUG(10),
    OTHER(11);

    private static final zzbfi zzm = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzboj
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzbol.zzc(i);
        }
    };
    private final int zzo;

    zzbol(int i) {
        this.zzo = i;
    }

    public static zzbfj zzb() {
        return zzbok.zza;
    }

    public static zzbol zzc(int i) {
        switch (i) {
            case 0:
                return COM_ANDROID_WEBVIEW;
            case 1:
                return COM_GOOGLE_ANDROID_WEBVIEW;
            case 2:
                return COM_ANDROID_CHROME;
            case 3:
                return COM_CHROME_BETA;
            case 4:
                return COM_CHROME_DEV;
            case 5:
                return COM_CHROME_CANARY;
            case 6:
                return COM_GOOGLE_ANDROID_APPS_CHROME;
            case 7:
                return COM_GOOGLE_ANDROID_WEBVIEW_BETA;
            case 8:
                return COM_GOOGLE_ANDROID_WEBVIEW_DEV;
            case 9:
                return COM_GOOGLE_ANDROID_WEBVIEW_CANARY;
            case 10:
                return COM_GOOGLE_ANDROID_WEBVIEW_DEBUG;
            case 11:
                return OTHER;
            default:
                return null;
        }
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.zzo);
    }

    @Override // com.google.android.gms.internal.gtm.zzbfh
    public final int zza() {
        return this.zzo;
    }
}
