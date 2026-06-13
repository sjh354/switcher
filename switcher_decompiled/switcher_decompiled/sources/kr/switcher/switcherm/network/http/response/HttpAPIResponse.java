package kr.switcher.switcherm.network.http.response;

import com.google.gson.Gson;
import java.util.List;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.network.http.RestErrorCode;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: classes2.dex */
public abstract class HttpAPIResponse<T> {
    private static final String TAG = "HttpAPIResponse";

    public Callback<T> response(final HttpResponseHandler httpResponseHandler) {
        return new Callback<T>() { // from class: kr.switcher.switcherm.network.http.response.HttpAPIResponse.1
            @Override // retrofit2.Callback
            public void onResponse(Call<T> call, Response<T> response) {
                if (response.isSuccessful()) {
                    httpResponseHandler.onSuccess((HttpAPIResponse) response.body());
                    return;
                }
                try {
                    if (response.code() == 404) {
                        httpResponseHandler.onFailure(String.valueOf(response.code()), "not found");
                        return;
                    }
                    String strString = response.errorBody().string();
                    IOLog.i(HttpAPIResponse.TAG, "error message : " + strString);
                    ErrorBody errorBody = (ErrorBody) new Gson().fromJson(strString, (Class) ErrorBody.class);
                    RestErrorCode.showReason(errorBody.code);
                    httpResponseHandler.onFailure(errorBody.code, errorBody.msg);
                } catch (Exception e) {
                    e.printStackTrace();
                    RestErrorCode.showReason(RestErrorCode.UNHANDLED_INTERNAL_SERVER_ERROR);
                    httpResponseHandler.onFailure("", "");
                }
            }

            @Override // retrofit2.Callback
            public void onFailure(Call<T> call, Throwable th) {
                IOLog.i(HttpAPIResponse.TAG, "message : " + th.getMessage() + ", " + call.request());
                if (!IOUtil.isConnectedInternet()) {
                    httpResponseHandler.onFailure(RestErrorCode.NOT_CONNECTED_INTERNET, th.getMessage());
                } else {
                    httpResponseHandler.onFailure(RestErrorCode.UNHANDLED_INTERNAL_SERVER_ERROR, th.getMessage());
                }
            }
        };
    }

    public Callback<T> responseList(final HttpResponseListHandler httpResponseListHandler) {
        return new Callback<T>() { // from class: kr.switcher.switcherm.network.http.response.HttpAPIResponse.2
            @Override // retrofit2.Callback
            public void onResponse(Call<T> call, Response<T> response) {
                String strValueOf;
                if (!response.isSuccessful()) {
                    try {
                        IOLog.i(HttpAPIResponse.TAG, "error message : " + response.errorBody().string());
                        ErrorBody errorBody = (ErrorBody) new Gson().fromJson(response.errorBody().string(), (Class) ErrorBody.class);
                        String str = "";
                        if (errorBody != null) {
                            strValueOf = errorBody.code;
                            str = errorBody.msg;
                        } else {
                            strValueOf = String.valueOf(response.code());
                        }
                        RestErrorCode.showReason(strValueOf);
                        httpResponseListHandler.onFailure(strValueOf, str);
                        return;
                    } catch (Exception e) {
                        e.printStackTrace();
                        RestErrorCode.showReason(RestErrorCode.UNHANDLED_INTERNAL_SERVER_ERROR);
                        return;
                    }
                }
                List<HttpAPIResponse<T>> list = (List) response.body();
                if (list != null) {
                    httpResponseListHandler.onSuccess(list);
                } else {
                    RestErrorCode.showReason(RestErrorCode.UNHANDLED_INTERNAL_SERVER_ERROR);
                    httpResponseListHandler.onFailure(RestErrorCode.UNHANDLED_INTERNAL_SERVER_ERROR, IOUtil.getStringResource(R.string.unhandled_internal_server_error));
                }
            }

            @Override // retrofit2.Callback
            public void onFailure(Call<T> call, Throwable th) {
                IOLog.i(HttpAPIResponse.TAG, "message : " + th.getMessage() + ", " + call.request());
                if (!IOUtil.isConnectedInternet()) {
                    httpResponseListHandler.onFailure(RestErrorCode.NOT_CONNECTED_INTERNET, th.getMessage());
                } else {
                    httpResponseListHandler.onFailure(RestErrorCode.UNHANDLED_INTERNAL_SERVER_ERROR, th.getMessage());
                }
            }
        };
    }
}
