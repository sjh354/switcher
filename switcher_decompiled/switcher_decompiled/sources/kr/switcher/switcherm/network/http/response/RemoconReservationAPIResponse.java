package kr.switcher.switcherm.network.http.response;

import java.util.List;
import retrofit2.Callback;

/* JADX INFO: loaded from: classes2.dex */
public class RemoconReservationAPIResponse extends HttpAPIResponse {
    public String appliance_id;
    public String created_at;
    public List<String> ir_id_list;
    public String is_enabled;
    public String mac_address;
    public String tag;
    public String time;
    public String title;
    public String week;
    public String week_time;

    @Override // kr.switcher.switcherm.network.http.response.HttpAPIResponse
    public Callback<RemoconReservationAPIResponse> response(HttpResponseHandler httpResponseHandler) {
        return super.response(httpResponseHandler);
    }
}
