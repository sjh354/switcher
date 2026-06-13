package kr.switcher.switcherm.network.http.response;

import retrofit2.Callback;

/* JADX INFO: loaded from: classes2.dex */
public class NewHashingShareCodeAPIResponse extends HttpAPIResponse {
    public NewHashingShareCodeInfo data;

    public String getShareCode() {
        return this.data.shareCode;
    }

    public String getHashingShareCode() {
        return this.data.hashingShareCode;
    }

    @Override // kr.switcher.switcherm.network.http.response.HttpAPIResponse
    public Callback<NewHashingShareCodeAPIResponse> response(HttpResponseHandler httpResponseHandler) {
        return super.response(httpResponseHandler);
    }

    public class NewHashingShareCodeInfo {
        String hashingShareCode;
        String shareCode;

        public NewHashingShareCodeInfo() {
        }
    }
}
