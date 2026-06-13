package kr.switcher.device.switcher.linker.http.response;

import retrofit2.Callback;

/* JADX INFO: loaded from: classes2.dex */
public class CommandResultAPIResponse extends HttpAPIResponse {
    public String command_id;
    public String command_no;
    public String created_at;
    public Payload payload;
    public String status;
    public String value;

    public String getValue() {
        Payload payload = this.payload;
        if (payload == null) {
            return this.value;
        }
        return payload.value;
    }

    @Override // kr.switcher.device.switcher.linker.http.response.HttpAPIResponse
    public Callback<CommandResultAPIResponse> response(HttpResponseHandler httpResponseHandler) {
        return super.response(httpResponseHandler);
    }

    private class Payload {
        String value;

        private Payload() {
        }
    }
}
