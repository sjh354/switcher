package kr.switcher.device.switcher.linker.http.microservice;

/* JADX INFO: loaded from: classes2.dex */
public class MobileLinkerMicroService extends MicroService {
    public static String ACCESS_TOKEN = "";
    public static final String AUTHENTICATION = "Bearer";
    public static final String AUTHENTICATION_HEADER = "Authorization";
    public static final String HOST_DEV_URL = "api.mobile.i-o.studio/";
    public static final String HOST_PROD_URL = "api.mobile.i-o.studio/";
    private final String API_VERSION = "v1/";

    public MobileLinkerMicroService() {
        makeUrl("api.mobile.i-o.studio/", "api.mobile.i-o.studio/", "v1/");
    }

    @Override // kr.switcher.device.switcher.linker.http.microservice.MicroService
    public String getBaseUrl() {
        return super.getBaseUrl();
    }

    public static void setAccessToken(String str) {
        ACCESS_TOKEN = "Bearer " + str;
    }
}
