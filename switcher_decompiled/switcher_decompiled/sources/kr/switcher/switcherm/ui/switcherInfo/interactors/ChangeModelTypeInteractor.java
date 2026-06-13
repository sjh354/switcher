package kr.switcher.switcherm.ui.switcherInfo.interactors;

import kr.switcher.switcherm.network.http.RestResponseHandler;
import kr.switcher.switcherm.network.http.RestSwitcherAPIStore;

/* JADX INFO: loaded from: classes2.dex */
public class ChangeModelTypeInteractor {

    public interface OnChangeResultListener {
        void onChangeResult(boolean z);
    }

    public void changeModelType(int i, int i2, final OnChangeResultListener onChangeResultListener) {
        RestSwitcherAPIStore.requestPutModelType(i, i2, new RestResponseHandler() { // from class: kr.switcher.switcherm.ui.switcherInfo.interactors.ChangeModelTypeInteractor.1
            @Override // kr.switcher.switcherm.network.http.RestResponseHandler
            public void onSuccess(String str) {
                onChangeResultListener.onChangeResult(true);
            }

            @Override // kr.switcher.switcherm.network.http.RestResponseHandler
            public void onFailure(String str, String str2) {
                onChangeResultListener.onChangeResult(false);
            }
        });
    }
}
