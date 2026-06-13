package kr.switcher.device.switcher.linker.http.response;

import android.util.Log;
import com.google.gson.Gson;
import kr.switcher.device.common.DeviceUtil;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: classes2.dex */
public abstract class HttpAPIResponse<T> {
    private static final String TAG = "HttpAPIResponse";

    public Callback<T> response(final HttpResponseHandler httpResponseHandler) {
        return new Callback<T>() { // from class: kr.switcher.device.switcher.linker.http.response.HttpAPIResponse.1
            @Override // retrofit2.Callback
            public void onResponse(Call<T> call, Response<T> response) {
                if (httpResponseHandler == null) {
                    return;
                }
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
                    Log.i(HttpAPIResponse.TAG, "error message : " + strString);
                    ErrorBody errorBody = (ErrorBody) new Gson().fromJson(strString, (Class) ErrorBody.class);
                    httpResponseHandler.onFailure(errorBody.code, errorBody.msg);
                } catch (Exception e) {
                    e.printStackTrace();
                    httpResponseHandler.onFailure("", "");
                }
            }

            @Override // retrofit2.Callback
            public void onFailure(Call<T> call, Throwable th) {
                Log.i(HttpAPIResponse.TAG, "message : " + th.getMessage() + ", " + call.request());
                if (httpResponseHandler == null) {
                    return;
                }
                if (!DeviceUtil.isConnectedInternet()) {
                    httpResponseHandler.onFailure("not connected internet", th.getMessage());
                } else {
                    httpResponseHandler.onFailure("etc error", th.getMessage());
                }
            }
        };
    }

    public Callback<T> responseList(final HttpResponseListHandler httpResponseListHandler) {
        return new Callback<T>() { // from class: kr.switcher.device.switcher.linker.http.response.HttpAPIResponse.2
            @Override // retrofit2.Callback
            public void onResponse(Call<T> call, Response<T> response) {
                if (httpResponseListHandler == null) {
                    return;
                }
                response.isSuccessful();
            }

            @Override // retrofit2.Callback
            public void onFailure(Call<T> call, Throwable th) {
                Log.i(HttpAPIResponse.TAG, "message : " + th.getMessage() + ", " + call.request());
                if (!DeviceUtil.isConnectedInternet()) {
                    httpResponseListHandler.onFailure("not connected internet\"", th.getMessage());
                } else {
                    httpResponseListHandler.onFailure("etc error", th.getMessage());
                }
            }
        };
    }
}
