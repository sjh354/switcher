package kr.switcher.switcherm.network.http.response;

import retrofit2.Callback;

/* JADX INFO: loaded from: classes2.dex */
public class HashingKeyAPIResponse extends HttpAPIResponse {
    public HashingKeyInfo data;

    public String getHashingKey() {
        return this.data.hashingKey;
    }

    @Override // kr.switcher.switcherm.network.http.response.HttpAPIResponse
    public Callback<HashingKeyAPIResponse> response(HttpResponseHandler httpResponseHandler) {
        return super.response(httpResponseHandler);
    }

    public class HashingKeyInfo {
        public String hashingKey;

        public HashingKeyInfo() {
        }
    }
}
