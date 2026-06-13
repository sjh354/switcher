package kr.switcher.switcherm.network.http.response;

import retrofit2.Callback;

/* JADX INFO: loaded from: classes2.dex */
public class DeleteIRCommandAPIResponse extends HttpAPIResponse {
    public String command_id;
    public String command_no;
    public int ir_id;
    public String status;

    @Override // kr.switcher.switcherm.network.http.response.HttpAPIResponse
    public Callback<DeleteIRCommandAPIResponse> response(HttpResponseHandler httpResponseHandler) {
        return super.response(httpResponseHandler);
    }
}
