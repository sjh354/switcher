package kr.switcher.switcherm.network.http.helper;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.network.http.RestClient;
import kr.switcher.switcherm.preference.OAuthToken;

/* JADX INFO: loaded from: classes2.dex */
public class ResponseBodyJsonParser {
    public static final String PARSING_NULL = "null";
    private static final String TAG = "ResponseBodyJsonParser";
    private final String ARG_DATA = "\"data\"";

    public String makeJsonBody(String str) {
        if (!str.contains("\"data\"")) {
            return "null";
        }
        try {
            return str.substring(str.indexOf(":", 1) + 1, str.lastIndexOf("}"));
        } catch (Exception e) {
            IOLog.error(TAG, new OAuthToken().getOAuthToken(), "makeJsonBody", e);
            return "";
        }
    }

    public static RestClient.RestFailureResponseVo parseResponseBody(String str) throws Exception {
        try {
            return (RestClient.RestFailureResponseVo) new Gson().fromJson(str, RestClient.RestFailureResponseVo.class);
        } catch (JsonSyntaxException e) {
            throw e;
        } catch (NullPointerException e2) {
            throw e2;
        }
    }
}
