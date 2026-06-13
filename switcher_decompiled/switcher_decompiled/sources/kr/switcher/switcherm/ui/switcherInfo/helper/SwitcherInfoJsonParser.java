package kr.switcher.switcherm.ui.switcherInfo.helper;

import com.google.gson.JsonSyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kr.switcher.switcherm.network.http.response.CardCompaniesAPIResponse;
import kr.switcher.switcherm.network.http.response.CreditCardInfoAPIResponse;
import kr.switcher.switcherm.ui.switcherInfo.adapter.PaymentCardItem;

/* JADX INFO: loaded from: classes2.dex */
public class SwitcherInfoJsonParser {
    private static final String TAG = "SwitcherInfoJsonParser";

    public static PaymentCardItem parseGetMainPaymentCard(List<CreditCardInfoAPIResponse> list) {
        PaymentCardItem paymentCardItem = null;
        try {
            for (CreditCardInfoAPIResponse creditCardInfoAPIResponse : list) {
                if (creditCardInfoAPIResponse.is_main) {
                    paymentCardItem = new PaymentCardItem(creditCardInfoAPIResponse.id, creditCardInfoAPIResponse.company_name, creditCardInfoAPIResponse.card_number, creditCardInfoAPIResponse.getExpirationDate(), creditCardInfoAPIResponse.is_main);
                }
            }
            return paymentCardItem;
        } catch (NullPointerException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static ArrayList<String> parseGetCardCompanies(List<CardCompaniesAPIResponse> list) throws Exception {
        try {
            ArrayList<String> arrayList = new ArrayList<>();
            Iterator<CardCompaniesAPIResponse> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().name);
            }
            return arrayList;
        } catch (JsonSyntaxException e) {
            throw e;
        } catch (NullPointerException e2) {
            throw e2;
        }
    }
}
