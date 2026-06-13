package kr.switcher.switcherm.network.http.response;

import retrofit2.Callback;

/* JADX INFO: loaded from: classes2.dex */
public class CustomerMeAPIResponse extends HttpAPIResponse<CustomerMeAPIResponse> {
    public String name;
    public String phone_number;

    @Override // kr.switcher.switcherm.network.http.response.HttpAPIResponse
    public Callback<CustomerMeAPIResponse> response(HttpResponseHandler httpResponseHandler) {
        return super.response(httpResponseHandler);
    }
}
