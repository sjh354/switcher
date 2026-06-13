package kr.switcher.switcherm.network.http.response;

import java.util.List;
import retrofit2.Callback;

/* JADX INFO: loaded from: classes2.dex */
public class DevicesMeAPIResponse extends HttpAPIResponse<List<DevicesMeAPIResponse>> {
    public String connection_status;
    public String device_id;
    public String id;
    public String mac_address;
    public String product_id;
    public String warranty_date;

    public String getMacAddress() {
        return this.mac_address;
    }

    @Override // kr.switcher.switcherm.network.http.response.HttpAPIResponse
    public Callback<List<DevicesMeAPIResponse>> response(HttpResponseHandler httpResponseHandler) {
        return super.response(httpResponseHandler);
    }
}
