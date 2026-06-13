package kr.switcher.switcherm.network.http.response;

import java.util.List;
import retrofit2.Callback;

/* JADX INFO: loaded from: classes2.dex */
public class IRAPIResponse extends HttpAPIResponse<List<IRAPIResponse>> {
    public int id;
    public String name;

    @Override // kr.switcher.switcherm.network.http.response.HttpAPIResponse
    public Callback<List<IRAPIResponse>> response(HttpResponseHandler httpResponseHandler) {
        return super.response(httpResponseHandler);
    }
}
