package kr.switcher.switcherm.network.http.response;

import retrofit2.Callback;

/* JADX INFO: loaded from: classes2.dex */
public class CreateApplianceMeAPIResponse extends HttpAPIResponse {
    public int id;
    public String name;
    public int remote_controller;

    @Override // kr.switcher.switcherm.network.http.response.HttpAPIResponse
    public Callback<CreateApplianceMeAPIResponse> response(HttpResponseHandler httpResponseHandler) {
        return super.response(httpResponseHandler);
    }
}
