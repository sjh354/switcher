package kr.switcher.device.switcher.linker.http.microservice;

import android.util.Log;

/* JADX INFO: loaded from: classes2.dex */
public class MicroService {
    public static final String DEV = "dev";
    public static final String PROD = "prod";
    public static final String PROTOCOL_HTTP = "http://";
    public static final String PROTOCOL_HTTPS = "https://";
    private static final String TAG = "MicroService";
    private static Boolean isDev = false;
    private String PROD_URL = "";
    private String DEV_URL = "";

    protected void makeUrl(String str, String str2, String str3) {
        this.PROD_URL = "https://" + str + str3;
        this.DEV_URL = "https://" + str2 + str3;
    }

    protected String getBaseUrl() {
        String str = this.PROD_URL;
        if (isDev.booleanValue()) {
            str = this.DEV_URL;
        }
        Log.i(TAG, "Service URL : " + str);
        return str;
    }

    public static void setIsDev(boolean z) {
        isDev = Boolean.valueOf(z);
    }
}
