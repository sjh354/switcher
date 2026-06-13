package kr.switcher.device.switcher.linker.http.response;

import retrofit2.Callback;

/* JADX INFO: loaded from: classes2.dex */
public class ReservationReadAPIResponse extends HttpAPIResponse {
    public static final String VALUE_NULL = "null";
    public String command_id;
    public String created_at;
    public String value;

    @Override // kr.switcher.device.switcher.linker.http.response.HttpAPIResponse
    public Callback<ReservationReadAPIResponse> response(HttpResponseHandler httpResponseHandler) {
        return super.response(httpResponseHandler);
    }
}
