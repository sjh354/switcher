package kr.switcher.device.switcher.linker.http.response;

import retrofit2.Callback;

/* JADX INFO: loaded from: classes2.dex */
public class BatteryLevelAPIResponse extends HttpAPIResponse {
    public String created_at;
    public String mac_address;
    public String value;

    @Override // kr.switcher.device.switcher.linker.http.response.HttpAPIResponse
    public Callback<BatteryLevelAPIResponse> response(HttpResponseHandler httpResponseHandler) {
        return super.response(httpResponseHandler);
    }
}
