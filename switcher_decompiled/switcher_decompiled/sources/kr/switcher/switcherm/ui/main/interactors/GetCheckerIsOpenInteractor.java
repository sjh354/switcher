package kr.switcher.switcherm.ui.main.interactors;

import kr.switcher.device.checker.Checker;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.network.http.RestSwitcherAPIStore;
import kr.switcher.switcherm.network.http.response.DeviceAPIResponse;
import kr.switcher.switcherm.network.http.response.HttpAPIResponse;
import kr.switcher.switcherm.network.http.response.HttpResponseHandler;
import kr.switcher.switcherm.preference.OAuthToken;

/* JADX INFO: loaded from: classes2.dex */
public class GetCheckerIsOpenInteractor {
    public static String TAG = "GetCheckerIsOpenInteractor";
    private OnGetCheckerIsOpenListener listener;

    public interface OnGetCheckerInfoListener {
        void onGetCheckerInfo(String str);
    }

    public interface OnGetCheckerIsOpenListener {
        void onGetCheckerIsOpen(String str);
    }

    public GetCheckerIsOpenInteractor(OnGetCheckerIsOpenListener onGetCheckerIsOpenListener) {
        this.listener = onGetCheckerIsOpenListener;
    }

    public GetCheckerIsOpenInteractor() {
    }

    public void getCheckerIsOpen(Checker checker) {
        RestSwitcherAPIStore.requestGetDevice(checker.getMacAddress(), new HttpResponseHandler() { // from class: kr.switcher.switcherm.ui.main.interactors.GetCheckerIsOpenInteractor.1
            @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
            public void onSuccess(HttpAPIResponse httpAPIResponse) {
                GetCheckerIsOpenInteractor.this.listener.onGetCheckerIsOpen(String.valueOf(((DeviceAPIResponse) httpAPIResponse).getIsOpen()));
            }

            @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
            public void onFailure(String str, String str2) {
                IOLog.error(GetCheckerIsOpenInteractor.TAG, new OAuthToken().getOAuthToken(), "requestGetDevice", new Exception("code:" + str + ", message:" + str2));
            }
        });
    }

    public void getCheckerInfoForWidget(String str, final OnGetCheckerInfoListener onGetCheckerInfoListener) {
        RestSwitcherAPIStore.requestGetDevice(str, new HttpResponseHandler() { // from class: kr.switcher.switcherm.ui.main.interactors.GetCheckerIsOpenInteractor.2
            @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
            public void onSuccess(HttpAPIResponse httpAPIResponse) {
                onGetCheckerInfoListener.onGetCheckerInfo(((DeviceAPIResponse) httpAPIResponse).meta.battery_level);
            }

            @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
            public void onFailure(String str2, String str3) {
                IOLog.error(GetCheckerIsOpenInteractor.TAG, new OAuthToken().getOAuthToken(), "requestGetDevice", new Exception("code:" + str2 + ", message:" + str3));
            }
        });
    }
}
