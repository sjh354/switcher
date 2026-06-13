package kr.switcher.switcherm.network.http.response;

import retrofit2.Callback;

/* JADX INFO: loaded from: classes2.dex */
public class SignalMarketingAPIResponse extends HttpAPIResponse {
    public String content_text;
    public int instance_id;
    public String title_text;
    public String url;

    @Override // kr.switcher.switcherm.network.http.response.HttpAPIResponse
    public Callback<SignalMarketingAPIResponse> response(HttpResponseHandler httpResponseHandler) {
        return super.response(httpResponseHandler);
    }
}
