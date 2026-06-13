package kr.switcher.device.switcher.linker.http.response;

import retrofit2.Callback;

/* JADX INFO: loaded from: classes2.dex */
public class FingerLengthTestAPIResponse extends HttpAPIResponse {
    public String command_id;
    public String created_at;

    @Override // kr.switcher.device.switcher.linker.http.response.HttpAPIResponse
    public Callback<FingerLengthTestAPIResponse> response(HttpResponseHandler httpResponseHandler) {
        return super.response(httpResponseHandler);
    }
}
