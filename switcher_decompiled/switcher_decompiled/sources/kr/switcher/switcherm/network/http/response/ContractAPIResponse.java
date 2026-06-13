package kr.switcher.switcherm.network.http.response;

import retrofit2.Callback;

/* JADX INFO: loaded from: classes2.dex */
public class ContractAPIResponse extends HttpAPIResponse {
    public int id;
    public String last_pay_at;
    public String next_pay_at;
    public int payment_method;
    public String status;

    @Override // kr.switcher.switcherm.network.http.response.HttpAPIResponse
    public Callback<ContractAPIResponse> response(HttpResponseHandler httpResponseHandler) {
        return super.response(httpResponseHandler);
    }
}
