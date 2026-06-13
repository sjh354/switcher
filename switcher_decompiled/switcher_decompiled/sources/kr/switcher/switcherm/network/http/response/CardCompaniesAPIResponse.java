package kr.switcher.switcherm.network.http.response;

import java.util.List;
import retrofit2.Callback;

/* JADX INFO: loaded from: classes2.dex */
public class CardCompaniesAPIResponse extends HttpAPIResponse<List<CardCompaniesAPIResponse>> {
    public int code;
    public String name;

    @Override // kr.switcher.switcherm.network.http.response.HttpAPIResponse
    public Callback<List<CardCompaniesAPIResponse>> response(HttpResponseHandler httpResponseHandler) {
        return super.response(httpResponseHandler);
    }
}
