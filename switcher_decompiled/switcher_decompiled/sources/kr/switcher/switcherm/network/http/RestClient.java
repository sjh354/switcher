package kr.switcher.switcherm.network.http;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import cz.msebera.android.httpclient.Header;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.network.http.helper.ResponseBodyJsonParser;
import kr.switcher.switcherm.preference.OAuthToken;

/* JADX INFO: loaded from: classes2.dex */
public class RestClient {
    public static String ACCESS_TOKEN = null;
    protected static final int DEFAULT_TIMEOUT = 20000;
    public static final String HEADER_AUTH_TOKEN = "Authorization";
    public static final String HEADER_AUTH_TOKEN_VALUE = "Bearer";
    public static final int HTTP_SUCCESS = 200;
    private static final String TAG = "RestClient";
    protected static AsyncHttpClient client = new AsyncHttpClient();

    public static void addAuthTokenInHeader(String str) {
        client.removeHeader("Authorization");
        client.addHeader("Authorization", "Bearer " + str);
        ACCESS_TOKEN = "Bearer " + str;
    }

    protected static void get(String str, RequestParams requestParams, final RestResponseHandler restResponseHandler) {
        client.setTimeout(20000);
        client.get(str, requestParams, new AsyncHttpResponseHandler() { // from class: kr.switcher.switcherm.network.http.RestClient.1
            @Override // com.loopj.android.http.AsyncHttpResponseHandler
            public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
                if (restResponseHandler != null) {
                    RestClient.responseResultData(new String(bArr), restResponseHandler);
                }
            }

            @Override // com.loopj.android.http.AsyncHttpResponseHandler
            public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
                if (restResponseHandler != null) {
                    RestClient.responseFailureData(bArr != null ? new String(bArr) : "", restResponseHandler);
                }
            }
        });
    }

    protected static void post(String str, RequestParams requestParams, final RestResponseHandler restResponseHandler) {
        client.setTimeout(20000);
        client.post(str, requestParams, new AsyncHttpResponseHandler() { // from class: kr.switcher.switcherm.network.http.RestClient.2
            @Override // com.loopj.android.http.AsyncHttpResponseHandler
            public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
                if (restResponseHandler != null) {
                    RestClient.responseResultData(new String(bArr), restResponseHandler);
                }
            }

            @Override // com.loopj.android.http.AsyncHttpResponseHandler
            public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
                if (restResponseHandler != null) {
                    RestClient.responseFailureData(bArr != null ? new String(bArr) : "", restResponseHandler);
                }
            }
        });
    }

    protected static void put(String str, RequestParams requestParams, final RestResponseHandler restResponseHandler) {
        client.setTimeout(20000);
        client.put(str, requestParams, new AsyncHttpResponseHandler() { // from class: kr.switcher.switcherm.network.http.RestClient.3
            @Override // com.loopj.android.http.AsyncHttpResponseHandler
            public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
                if (restResponseHandler != null) {
                    RestClient.responseResultData(new String(bArr), restResponseHandler);
                }
            }

            @Override // com.loopj.android.http.AsyncHttpResponseHandler
            public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
                if (restResponseHandler != null) {
                    RestClient.responseFailureData(bArr != null ? new String(bArr) : "", restResponseHandler);
                }
            }
        });
    }

    protected static void delete(String str, RequestParams requestParams, final RestResponseHandler restResponseHandler) {
        client.setTimeout(20000);
        client.delete(str, requestParams, new AsyncHttpResponseHandler() { // from class: kr.switcher.switcherm.network.http.RestClient.4
            @Override // com.loopj.android.http.AsyncHttpResponseHandler
            public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
                if (restResponseHandler != null) {
                    RestClient.responseResultData(new String(bArr), restResponseHandler);
                }
            }

            @Override // com.loopj.android.http.AsyncHttpResponseHandler
            public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
                if (restResponseHandler != null) {
                    RestClient.responseFailureData(bArr != null ? new String(bArr) : "", restResponseHandler);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void responseResultData(String str, RestResponseHandler restResponseHandler) {
        IOLog.d(TAG, "received response json : \n" + str);
        String strMakeJsonBody = new ResponseBodyJsonParser().makeJsonBody(str);
        if (!"null".equals(strMakeJsonBody)) {
            restResponseHandler.onSuccess(strMakeJsonBody);
        } else {
            responseFailureData(str, restResponseHandler);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void responseFailureData(String str, RestResponseHandler restResponseHandler) {
        String str2;
        String str3 = "";
        try {
            RestFailureResponseVo responseBody = ResponseBodyJsonParser.parseResponseBody(str);
            if (responseBody != null) {
                str2 = responseBody.message;
                try {
                    str3 = responseBody.code;
                    RestErrorCode.showReason(str3);
                } catch (Exception e) {
                    e = e;
                    String str4 = TAG;
                    IOLog.d(str4, "result json : " + str);
                    IOLog.error(str4, new OAuthToken().getOAuthToken(), "responseFailureData", e);
                }
            } else {
                str2 = "";
            }
        } catch (Exception e2) {
            e = e2;
            str2 = "";
        }
        if (RestErrorCode.ACCESSTOKEN_DOES_NOT_EXIST.equals(str3) || RestErrorCode.ACCESSTOKEN_IS_NOT_MATCHED.equals(str3) || RestErrorCode.ACCESS_TOKEN_IS_EMPTY.equals(str3)) {
            return;
        }
        restResponseHandler.onFailure(str3, str2);
    }

    public class RestFailureResponseVo {
        String code;
        String message;
        String status;

        public RestFailureResponseVo() {
        }
    }
}
