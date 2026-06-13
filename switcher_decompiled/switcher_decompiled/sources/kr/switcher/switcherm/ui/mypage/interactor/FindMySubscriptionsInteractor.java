package kr.switcher.switcherm.ui.mypage.interactor;

import java.util.Iterator;
import java.util.List;
import kr.switcher.switcherm.network.http.RestSwitcherAPIStore;
import kr.switcher.switcherm.network.http.response.HttpResponseListHandler;
import kr.switcher.switcherm.network.http.response.SubscriptionsMeAPIResponse;
import kr.switcher.switcherm.ui.mypage.helper.SubscriptionsMeItem;

/* JADX INFO: loaded from: classes2.dex */
public class FindMySubscriptionsInteractor {
    private static final String TAG = "FindMySubscriptionsInteractor";
    private OnFindMySubscriptionListener listener;

    public interface OnFindMySubscriptionListener {
        void onFindMySubscriptionSuccess(SubscriptionsMeItem subscriptionsMeItem);
    }

    public FindMySubscriptionsInteractor(OnFindMySubscriptionListener onFindMySubscriptionListener) {
        this.listener = onFindMySubscriptionListener;
    }

    public void getSubscriptionsMe() {
        RestSwitcherAPIStore.requestGetSubscriptionsMe(new HttpResponseListHandler() { // from class: kr.switcher.switcherm.ui.mypage.interactor.FindMySubscriptionsInteractor.1
            @Override // kr.switcher.switcherm.network.http.response.HttpResponseListHandler
            public void onFailure(String str, String str2) {
            }

            @Override // kr.switcher.switcherm.network.http.response.HttpResponseListHandler
            public void onSuccess(List list) {
                int i = 0;
                Boolean bool = false;
                if (list.size() == 0) {
                    FindMySubscriptionsInteractor.this.listener.onFindMySubscriptionSuccess(new SubscriptionsMeItem(bool, bool));
                    return;
                }
                Iterator it = list.iterator();
                int i2 = 0;
                Boolean bool2 = bool;
                while (it.hasNext()) {
                    SubscriptionsMeAPIResponse subscriptionsMeAPIResponse = (SubscriptionsMeAPIResponse) it.next();
                    if (subscriptionsMeAPIResponse.sub_type.equals("marketing")) {
                        bool = true;
                        i = subscriptionsMeAPIResponse.id;
                    } else if (subscriptionsMeAPIResponse.sub_type.equals("info")) {
                        bool2 = true;
                        i2 = subscriptionsMeAPIResponse.id;
                    }
                }
                FindMySubscriptionsInteractor.this.listener.onFindMySubscriptionSuccess(new SubscriptionsMeItem(bool, i, bool2, i2));
            }
        });
    }
}
