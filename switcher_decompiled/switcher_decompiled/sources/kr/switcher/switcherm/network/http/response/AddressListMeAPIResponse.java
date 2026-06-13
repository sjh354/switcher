package kr.switcher.switcherm.network.http.response;

import java.util.List;
import retrofit2.Callback;

/* JADX INFO: loaded from: classes2.dex */
public class AddressListMeAPIResponse extends HttpAPIResponse<List<AddressListMeAPIResponse>> {
    public int id;
    public boolean is_default;
    public String main_address;
    public String postal_code;
    public String sub_address;

    @Override // kr.switcher.switcherm.network.http.response.HttpAPIResponse
    public Callback<List<AddressListMeAPIResponse>> response(HttpResponseHandler httpResponseHandler) {
        return super.response(httpResponseHandler);
    }
}
