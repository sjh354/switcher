package kr.switcher.switcherm.ui.switcherList.interactors;

import java.util.List;
import kr.switcher.switcherm.network.http.RestSwitcherAPIStore;
import kr.switcher.switcherm.network.http.response.HttpResponseListHandler;
import kr.switcher.switcherm.ui.switcherInfo.adapter.PaymentCardItem;
import kr.switcher.switcherm.ui.switcherInfo.helper.SwitcherInfoJsonParser;

/* JADX INFO: loaded from: classes2.dex */
public class GetMyCreditCardInteractor {
    private static final String TAG = "GetMyCreditCardInteractor";
    private OnGetMyCreditCardListener listener;

    public interface OnGetMyCreditCardListener {
        void onGetCardList(Boolean bool);
    }

    public GetMyCreditCardInteractor(OnGetMyCreditCardListener onGetMyCreditCardListener) {
        this.listener = onGetMyCreditCardListener;
    }

    public void getMyCreditCard() {
        RestSwitcherAPIStore.requestGetCreditCardMe(new HttpResponseListHandler() { // from class: kr.switcher.switcherm.ui.switcherList.interactors.GetMyCreditCardInteractor.1
            @Override // kr.switcher.switcherm.network.http.response.HttpResponseListHandler
            public void onFailure(String str, String str2) {
            }

            @Override // kr.switcher.switcherm.network.http.response.HttpResponseListHandler
            public void onSuccess(List list) {
                PaymentCardItem getMainPaymentCard = SwitcherInfoJsonParser.parseGetMainPaymentCard(list);
                if (getMainPaymentCard == null) {
                    return;
                }
                if (getMainPaymentCard == null || !getMainPaymentCard.getPaymentCardName().equals("기본등록")) {
                    GetMyCreditCardInteractor.this.listener.onGetCardList(false);
                } else {
                    GetMyCreditCardInteractor.this.listener.onGetCardList(true);
                }
            }
        });
    }
}
