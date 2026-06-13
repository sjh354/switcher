package kr.switcher.switcherm.ui.switcherList.interactors;

import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.network.http.RestSwitcherAPIStore;
import kr.switcher.switcherm.network.http.response.CreditCardSignalAPIResponse;
import kr.switcher.switcherm.network.http.response.HttpAPIResponse;
import kr.switcher.switcherm.network.http.response.HttpResponseHandler;
import kr.switcher.switcherm.preference.OAuthToken;

/* JADX INFO: loaded from: classes2.dex */
public class GetCreditCardSignalInteractor {
    private static final String TAG = "GetCreditCardSignalInteractor";
    private OnGetCreditCardSignalListener listener;

    public interface OnGetCreditCardSignalListener {
        void onGetCreditCardSignal(boolean z);
    }

    public GetCreditCardSignalInteractor(OnGetCreditCardSignalListener onGetCreditCardSignalListener) {
        this.listener = onGetCreditCardSignalListener;
    }

    public void getRequestCreditCardSignal() {
        RestSwitcherAPIStore.requestGetCreditCardSignal(new HttpResponseHandler() { // from class: kr.switcher.switcherm.ui.switcherList.interactors.GetCreditCardSignalInteractor.1
            @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
            public void onSuccess(HttpAPIResponse httpAPIResponse) {
                GetCreditCardSignalInteractor.this.listener.onGetCreditCardSignal(((CreditCardSignalAPIResponse) httpAPIResponse).is_published);
            }

            @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
            public void onFailure(String str, String str2) {
                IOLog.error(GetCreditCardSignalInteractor.TAG, new OAuthToken().getOAuthToken(), "getRequestCreditCardSignal", new Exception("code:" + str + ", message:" + str2));
            }
        });
    }
}
