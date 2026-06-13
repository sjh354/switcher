package kr.switcher.switcherm.network.http.response;

import retrofit2.Callback;

/* JADX INFO: loaded from: classes2.dex */
public class DeleteSubscriptionsMeAPIResponse extends HttpAPIResponse<DeleteSubscriptionsMeAPIResponse> {
    public String created_at;
    public int customer_id;
    public int id;
    public String sub_type;

    @Override // kr.switcher.switcherm.network.http.response.HttpAPIResponse
    public Callback<DeleteSubscriptionsMeAPIResponse> response(HttpResponseHandler httpResponseHandler) {
        return super.response(httpResponseHandler);
    }
}
