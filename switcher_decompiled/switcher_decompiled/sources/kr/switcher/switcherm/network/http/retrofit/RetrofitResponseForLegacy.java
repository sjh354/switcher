package kr.switcher.switcherm.network.http.retrofit;

import kr.switcher.device.switcher.Switcher;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.network.http.RestErrorCode;
import kr.switcher.switcherm.network.http.RestResponseHandler;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: classes2.dex */
public class RetrofitResponseForLegacy {
    public static Callback<ResponseBodyForLegacy> response(final RestResponseHandler restResponseHandler) {
        return new Callback<ResponseBodyForLegacy>() { // from class: kr.switcher.switcherm.network.http.retrofit.RetrofitResponseForLegacy.1
            @Override // retrofit2.Callback
            public void onResponse(Call<ResponseBodyForLegacy> call, Response<ResponseBodyForLegacy> response) {
                if (response.isSuccessful()) {
                    ResponseBodyForLegacy responseBodyForLegacyBody = response.body();
                    if (responseBodyForLegacyBody.getCode() != null) {
                        RestErrorCode.showReason(responseBodyForLegacyBody.getCode());
                        restResponseHandler.onFailure(responseBodyForLegacyBody.getCode(), responseBodyForLegacyBody.getMessage());
                    }
                    if (responseBodyForLegacyBody.getData() == null || responseBodyForLegacyBody.getData().getResult() == null) {
                        return;
                    }
                    restResponseHandler.onSuccess(responseBodyForLegacyBody.getData().getResult());
                    IOLog.i("ContentValues", "result : " + responseBodyForLegacyBody.getData().getResult());
                }
            }

            @Override // retrofit2.Callback
            public void onFailure(Call<ResponseBodyForLegacy> call, Throwable th) {
                IOLog.i("ContentValues", "message : " + th.getMessage() + ", " + call.request());
                restResponseHandler.onFailure(Switcher.SwitcherReservation.SWITCH_1WAY_FIRMWARE, th.getMessage());
            }
        };
    }
}
