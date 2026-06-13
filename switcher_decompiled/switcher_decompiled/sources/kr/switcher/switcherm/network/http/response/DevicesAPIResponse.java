package kr.switcher.switcherm.network.http.response;

import retrofit2.Callback;

/* JADX INFO: loaded from: classes2.dex */
public class DevicesAPIResponse extends HttpAPIResponse {
    public String access_token;
    public int checker_id;
    public String created_at;
    public int device_id;
    public boolean is_open;
    public String mac_address;
    public String name;
    public int product_id;
    public String serial_number;
    public String status;
    public String type;
    public String type_id;
    public String warranty_date;

    @Override // kr.switcher.switcherm.network.http.response.HttpAPIResponse
    public Callback<DevicesAPIResponse> response(HttpResponseHandler httpResponseHandler) {
        return super.response(httpResponseHandler);
    }

    public boolean isIs_open() {
        return this.is_open;
    }
}
