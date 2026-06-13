package kr.switcher.switcherm.network.http.response;

import java.util.List;
import kr.switcher.switcherm.ui.setting.adapter.CheckerHistoryItem;
import retrofit2.Callback;

/* JADX INFO: loaded from: classes2.dex */
public class CheckerHistoriesAPIResponse extends HttpAPIResponse {
    public int count;
    public String next;
    public String previous;
    public List<CheckerHistoryItem> results;

    @Override // kr.switcher.switcherm.network.http.response.HttpAPIResponse
    public Callback<CheckerHistoriesAPIResponse> response(HttpResponseHandler httpResponseHandler) {
        return super.response(httpResponseHandler);
    }
}
