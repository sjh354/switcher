package kr.switcher.switcherm.network.http.response;

import retrofit2.Callback;

/* JADX INFO: loaded from: classes2.dex */
public class AddressMeAPIResponse extends HttpAPIResponse<AddressMeAPIResponse> {
    public int id;
    public boolean is_default;
    public String main_address;
    public String postal_code;
    public String sub_address;

    @Override // kr.switcher.switcherm.network.http.response.HttpAPIResponse
    public Callback<AddressMeAPIResponse> response(HttpResponseHandler httpResponseHandler) {
        return super.response(httpResponseHandler);
    }
}
