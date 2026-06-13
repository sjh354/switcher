package kr.switcher.switcherm.network.http.response;

import retrofit2.Callback;

/* JADX INFO: loaded from: classes2.dex */
public class SignalFeatureAPIResponse extends HttpAPIResponse {
    public int architecture_id;
    public String button_text;
    public int instance_id;
    public String suggestion_text;
    public String url;

    @Override // kr.switcher.switcherm.network.http.response.HttpAPIResponse
    public Callback<SignalFeatureAPIResponse> response(HttpResponseHandler httpResponseHandler) {
        return super.response(httpResponseHandler);
    }
}
