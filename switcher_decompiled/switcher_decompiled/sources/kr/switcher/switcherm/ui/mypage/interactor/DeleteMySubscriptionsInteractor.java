package kr.switcher.switcherm.ui.mypage.interactor;

import kr.switcher.switcherm.network.http.RestSwitcherAPIStore;
import kr.switcher.switcherm.network.http.response.HttpAPIResponse;
import kr.switcher.switcherm.network.http.response.HttpResponseHandler;

/* JADX INFO: loaded from: classes2.dex */
public class DeleteMySubscriptionsInteractor {
    private static final String TAG = "DeleteMySubscriptionsInteractor";
    private OnDeleteMySubscriptionListener listener;

    public interface OnDeleteMySubscriptionListener {
        void onDeleteSubSuccess();
    }

    public DeleteMySubscriptionsInteractor(OnDeleteMySubscriptionListener onDeleteMySubscriptionListener) {
        this.listener = onDeleteMySubscriptionListener;
    }

    public void deleteSubscriptionsMe(int i) {
        RestSwitcherAPIStore.requestDeleteSubscriptionsMe(i, new HttpResponseHandler() { // from class: kr.switcher.switcherm.ui.mypage.interactor.DeleteMySubscriptionsInteractor.1
            @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
            public void onFailure(String str, String str2) {
            }

            @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
            public void onSuccess(HttpAPIResponse httpAPIResponse) {
                DeleteMySubscriptionsInteractor.this.listener.onDeleteSubSuccess();
            }
        });
    }
}
