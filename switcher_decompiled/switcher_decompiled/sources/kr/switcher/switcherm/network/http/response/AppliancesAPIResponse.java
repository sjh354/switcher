package kr.switcher.switcherm.network.http.response;

import java.util.List;
import retrofit2.Callback;

/* JADX INFO: loaded from: classes2.dex */
public class AppliancesAPIResponse extends HttpAPIResponse<List<AppliancesAPIResponse>> {
    public int id;
    public String name;
    public int remote_controller;

    @Override // kr.switcher.switcherm.network.http.response.HttpAPIResponse
    public Callback<List<AppliancesAPIResponse>> response(HttpResponseHandler httpResponseHandler) {
        return super.response(httpResponseHandler);
    }
}
