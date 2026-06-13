package kr.switcher.switcherm.network.http.response;

import java.util.List;
import retrofit2.Callback;

/* JADX INFO: loaded from: classes2.dex */
public class CreditCardInfoAPIResponse extends HttpAPIResponse<List<CreditCardInfoAPIResponse>> {
    public String card_number;
    public String company_name;
    public String expiration_month;
    public String expiration_year;
    public int id;
    public boolean is_main;

    public String getExpirationDate() {
        return String.format("%02d%02d", Integer.valueOf(Integer.parseInt(this.expiration_month)), Integer.valueOf(Integer.parseInt(this.expiration_year.substring(2, 4))));
    }

    @Override // kr.switcher.switcherm.network.http.response.HttpAPIResponse
    public Callback<List<CreditCardInfoAPIResponse>> response(HttpResponseHandler httpResponseHandler) {
        return super.response(httpResponseHandler);
    }
}
