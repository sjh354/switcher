package kr.switcher.switcherm.network.http.response;

import java.util.ArrayList;
import java.util.List;
import retrofit2.Callback;

/* JADX INFO: loaded from: classes2.dex */
public class PricingModelAPIResponse extends HttpAPIResponse {
    public List<PricingModelInfo> data = new ArrayList();

    @Override // kr.switcher.switcherm.network.http.response.HttpAPIResponse
    public Callback<PricingModelAPIResponse> response(HttpResponseHandler httpResponseHandler) {
        return super.response(httpResponseHandler);
    }

    public class PricingModelInfo {
        public String createdAt;
        public String description;
        public int id;
        public int price;
        public int status;
        public String title;
        public String updatedAt;

        public PricingModelInfo() {
        }
    }
}
