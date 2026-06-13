package kr.switcher.switcherm.network.http.response;

import retrofit2.Callback;

/* JADX INFO: loaded from: classes2.dex */
public class FreeTrialAPIResponse extends HttpAPIResponse {
    public String end_at;
    public int id;
    public int payment_method;

    @Override // kr.switcher.switcherm.network.http.response.HttpAPIResponse
    public Callback<FreeTrialAPIResponse> response(HttpResponseHandler httpResponseHandler) {
        return super.response(httpResponseHandler);
    }
}
