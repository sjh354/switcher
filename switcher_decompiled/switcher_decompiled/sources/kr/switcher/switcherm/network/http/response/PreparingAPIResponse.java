package kr.switcher.switcherm.network.http.response;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import retrofit2.Callback;

/* JADX INFO: loaded from: classes2.dex */
public class PreparingAPIResponse extends HttpAPIResponse<PreparingAPIResponse> {
    public List<PreparingInfo> results;

    public List<Integer> getFreeTrialIdList() {
        ArrayList arrayList = new ArrayList();
        Iterator<PreparingInfo> it = this.results.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(it.next().id));
        }
        return arrayList;
    }

    public List<Integer> getProductIdList() {
        ArrayList arrayList = new ArrayList();
        Iterator<PreparingInfo> it = this.results.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(it.next().stock.product_id));
        }
        return arrayList;
    }

    @Override // kr.switcher.switcherm.network.http.response.HttpAPIResponse
    public Callback<PreparingAPIResponse> response(HttpResponseHandler httpResponseHandler) {
        return super.response(httpResponseHandler);
    }

    class PreparingInfo {
        int id;
        StockInfo stock;

        PreparingInfo() {
        }

        class StockInfo {
            int product_id;

            StockInfo() {
            }
        }
    }
}
