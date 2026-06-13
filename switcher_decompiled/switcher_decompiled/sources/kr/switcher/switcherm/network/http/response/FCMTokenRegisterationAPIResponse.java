package kr.switcher.switcherm.network.http.response;

import retrofit2.Callback;

/* JADX INFO: loaded from: classes2.dex */
public class FCMTokenRegisterationAPIResponse extends HttpAPIResponse {
    public String created_at;
    public int customer_id;
    public int id;
    public String registration_id;

    @Override // kr.switcher.switcherm.network.http.response.HttpAPIResponse
    public Callback<FCMTokenRegisterationAPIResponse> response(HttpResponseHandler httpResponseHandler) {
        return super.response(httpResponseHandler);
    }
}
