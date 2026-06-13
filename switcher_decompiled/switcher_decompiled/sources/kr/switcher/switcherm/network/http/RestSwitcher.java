package kr.switcher.switcherm.network.http;

import com.loopj.android.http.RequestParams;

/* JADX INFO: loaded from: classes2.dex */
public class RestSwitcher extends RestClient {
    public static final String API_VERSION = "v3";
    public static final String DEVELOP_URL = "https://io-switcher-dev.switcher.kr/v3/mobile/";
    public static final String HOST_DEV_URL = "io-switcher-dev.switcher.kr/";
    public static final String HOST_PROD_URL = "io-switcher-prod.switcher.kr/";
    public static final String PRODUCT_URL = "https://io-switcher-prod.switcher.kr/v3/mobile/";
    public static final String PROTOCOL_HTTP = "http://";
    public static final String PROTOCOL_HTTPS = "https://";

    public static void get(String str, RequestParams requestParams, RestResponseHandler restResponseHandler) {
        RestClient.get(getAbsoluteUrl(str), requestParams, restResponseHandler);
    }

    public static void post(String str, RequestParams requestParams, RestResponseHandler restResponseHandler) {
        RestClient.post(getAbsoluteUrl(str), requestParams, restResponseHandler);
    }

    public static void put(String str, RequestParams requestParams, RestResponseHandler restResponseHandler) {
        RestClient.put(getAbsoluteUrl(str), requestParams, restResponseHandler);
    }

    public static void delete(String str, RequestParams requestParams, RestResponseHandler restResponseHandler) {
        RestClient.delete(getAbsoluteUrl(str), requestParams, restResponseHandler);
    }

    public static String getAbsoluteUrl(String str) {
        return PRODUCT_URL + str;
    }
}
