package kr.switcher.switcherm.network.http.response;

import retrofit2.Callback;

/* JADX INFO: loaded from: classes2.dex */
public class ProductReturnAPIResponse extends HttpAPIResponse {
    public String invoice_number;

    @Override // kr.switcher.switcherm.network.http.response.HttpAPIResponse
    public Callback<ProductReturnAPIResponse> response(HttpResponseHandler httpResponseHandler) {
        return super.response(httpResponseHandler);
    }
}
