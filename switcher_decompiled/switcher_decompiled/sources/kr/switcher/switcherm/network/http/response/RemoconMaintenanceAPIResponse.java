package kr.switcher.switcherm.network.http.response;

import retrofit2.Callback;

/* JADX INFO: loaded from: classes2.dex */
public class RemoconMaintenanceAPIResponse extends HttpAPIResponse {
    public int appliances;
    public String created_at;
    public String end_time_at;
    public int goal_temperature;
    public int id;
    public Boolean is_enabled;
    public String start_time_at;
    public String title;
    public String week_days;

    @Override // kr.switcher.switcherm.network.http.response.HttpAPIResponse
    public Callback<RemoconMaintenanceAPIResponse> response(HttpResponseHandler httpResponseHandler) {
        return super.response(httpResponseHandler);
    }
}
