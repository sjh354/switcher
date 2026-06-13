package kr.switcher.switcherm.network.http.response;

import retrofit2.Callback;

/* JADX INFO: loaded from: classes2.dex */
public class NewShareCodeAPIResponse extends HttpAPIResponse {
    public String access_token;
    public String id;
    public String mac_address;
    public String product;
    public String serial_number;
    public String status;

    @Override // kr.switcher.switcherm.network.http.response.HttpAPIResponse
    public Callback<NewShareCodeAPIResponse> response(HttpResponseHandler httpResponseHandler) {
        return super.response(httpResponseHandler);
    }
}
