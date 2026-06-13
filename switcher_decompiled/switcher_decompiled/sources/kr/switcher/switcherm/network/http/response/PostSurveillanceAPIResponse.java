package kr.switcher.switcherm.network.http.response;

import retrofit2.Callback;

/* JADX INFO: loaded from: classes2.dex */
public class PostSurveillanceAPIResponse extends HttpAPIResponse {
    public int alarm_duration_min;
    public int chekcer;
    public String created_at;
    public String end_at;
    public int id;
    public Boolean is_active;
    public int level;
    public String start_at;
    public String title;
    public int trespass_duration_min;
    public String week_days;

    @Override // kr.switcher.switcherm.network.http.response.HttpAPIResponse
    public Callback<PostSurveillanceAPIResponse> response(HttpResponseHandler httpResponseHandler) {
        return super.response(httpResponseHandler);
    }
}
