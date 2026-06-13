package kr.switcher.switcherm.network.http.response;

import retrofit2.Callback;

/* JADX INFO: loaded from: classes2.dex */
public class CreateAppliancesDatabasesAPIResponse extends HttpAPIResponse {
    public int id;
    public String name;

    @Override // kr.switcher.switcherm.network.http.response.HttpAPIResponse
    public Callback<CreateAppliancesDatabasesAPIResponse> response(HttpResponseHandler httpResponseHandler) {
        return super.response(httpResponseHandler);
    }
}
