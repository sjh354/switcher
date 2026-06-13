package kr.switcher.switcherm.network.http.response;

import retrofit2.Callback;

/* JADX INFO: loaded from: classes2.dex */
public class AccessTokensAPIResponse extends HttpAPIResponse {
    public String authentication_number;
    public String created_at;
    public String customer;
    public String id;
    public String key;
    public String status;

    @Override // kr.switcher.switcherm.network.http.response.HttpAPIResponse
    public Callback<AccessTokensAPIResponse> response(HttpResponseHandler httpResponseHandler) {
        return super.response(httpResponseHandler);
    }
}
