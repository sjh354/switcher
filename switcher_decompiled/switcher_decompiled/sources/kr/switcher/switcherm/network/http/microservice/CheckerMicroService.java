package kr.switcher.switcherm.network.http.microservice;

/* JADX INFO: loaded from: classes2.dex */
public class CheckerMicroService extends MicroService {
    public static String ACCESS_TOKEN = "";
    public static final String AUTHENTICATION = "Bearer";
    public static final String AUTHENTICATION_HEADER = "Authorization";
    public static final String HOST_DEV_URL = "api.checker.i-o.studio/";
    public static final String HOST_PROD_URL = "api.checker.i-o.studio/";
    private final String API_VERSION = "v1/";

    public CheckerMicroService() {
        makeUrl("api.checker.i-o.studio/", "api.checker.i-o.studio/", "v1/");
    }

    @Override // kr.switcher.switcherm.network.http.microservice.MicroService
    public String getBaseUrl() {
        return super.getBaseUrl();
    }

    public static void setAccessToken(String str) {
        ACCESS_TOKEN = "Bearer " + str;
    }
}
