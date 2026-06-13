package kr.switcher.switcherm.network.http.response;

import retrofit2.Callback;

/* JADX INFO: loaded from: classes2.dex */
public class SensorsLatestAPIResponse extends HttpAPIResponse {
    public String created_at;
    public String decibel;
    public String id;
    public String illumination_intensity;
    public String mac_address;
    public String temperature;

    @Override // kr.switcher.switcherm.network.http.response.HttpAPIResponse
    public Callback<SensorsLatestAPIResponse> response(HttpResponseHandler httpResponseHandler) {
        return super.response(httpResponseHandler);
    }
}
