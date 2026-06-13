package kr.switcher.switcherm.network.http.response;

import java.util.List;
import retrofit2.Callback;

/* JADX INFO: loaded from: classes2.dex */
public class RemoteControllersAPIResponse extends HttpAPIResponse {
    public int count;
    public String next;
    public String previous;
    public List<ControllerResult> results;

    @Override // kr.switcher.switcherm.network.http.response.HttpAPIResponse
    public Callback<RemoteControllersAPIResponse> response(HttpResponseHandler httpResponseHandler) {
        return super.response(httpResponseHandler);
    }

    public class ControllerResult {
        private int id;
        private String name;

        public ControllerResult(int i, String str) {
            this.id = i;
            this.name = str;
        }

        public int getId() {
            return this.id;
        }

        public String getName() {
            return this.name;
        }
    }
}
