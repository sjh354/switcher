package kr.switcher.switcherm.ui.mypage.interactor;

import kr.switcher.switcherm.network.http.RestSwitcherAPIStore;
import kr.switcher.switcherm.network.http.response.HttpAPIResponse;
import kr.switcher.switcherm.network.http.response.HttpResponseHandler;

/* JADX INFO: loaded from: classes2.dex */
public class CreateSubscriptionsInteractor {
    private static final String TAG = "CreateSubscriptionsInteractor";
    private OnCreateSubscriptionListener listener;

    public interface OnCreateSubscriptionListener {
        void onCreateSubSuccess(String str);
    }

    public CreateSubscriptionsInteractor(OnCreateSubscriptionListener onCreateSubscriptionListener) {
        this.listener = onCreateSubscriptionListener;
    }

    public void postSubscriptionsMe(String str) {
        RestSwitcherAPIStore.requestPostSubscriptionsMe(str, new HttpResponseHandler() { // from class: kr.switcher.switcherm.ui.mypage.interactor.CreateSubscriptionsInteractor.1
            @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
            public void onFailure(String str2, String str3) {
            }

            @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
            public void onSuccess(HttpAPIResponse httpAPIResponse) {
            }
        });
    }
}
