package kr.switcher.switcherm.network.http.response;

import java.util.List;
import retrofit2.Callback;

/* JADX INFO: loaded from: classes2.dex */
public class RegisterReservationResponse extends HttpAPIResponse {
    public String code;
    public List<String> invading_week_time_list;
    public String msg;

    @Override // kr.switcher.switcherm.network.http.response.HttpAPIResponse
    public Callback<RegisterReservationResponse> response(HttpResponseHandler httpResponseHandler) {
        return super.response(httpResponseHandler);
    }
}
