package kr.switcher.switcherm.ui.setting.interactor;

import kr.switcher.device.checker.Checker;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.network.http.RestSwitcherAPIStore;
import kr.switcher.switcherm.network.http.response.HttpAPIResponse;
import kr.switcher.switcherm.network.http.response.HttpResponseHandler;
import kr.switcher.switcherm.preference.OAuthToken;

/* JADX INFO: loaded from: classes2.dex */
public class MakeSurveillanceInteractor {
    private static final String TAG = "MakeSurveillanceInteractor";
    private OnMakeSurveillanceListener listener;

    public interface OnMakeSurveillanceListener {
        void onMakeSurveillanceError(String str, String str2);

        void onMakeSurveillanceSuccess();
    }

    public MakeSurveillanceInteractor(OnMakeSurveillanceListener onMakeSurveillanceListener) {
        this.listener = onMakeSurveillanceListener;
    }

    public void requestPostSurveillance(String str, Checker.Surveillance surveillance) {
        RestSwitcherAPIStore.requestPostCheckerSurveillance(IOUtil.makeBackendMacAddressFormat(str), surveillance, new HttpResponseHandler() { // from class: kr.switcher.switcherm.ui.setting.interactor.MakeSurveillanceInteractor.1
            @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
            public void onSuccess(HttpAPIResponse httpAPIResponse) {
                MakeSurveillanceInteractor.this.listener.onMakeSurveillanceSuccess();
            }

            @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
            public void onFailure(String str2, String str3) {
                IOLog.error(MakeSurveillanceInteractor.TAG, new OAuthToken().getOAuthToken(), "requestPostSurveillance", new Exception("code:" + str2 + ", message:" + str3));
                MakeSurveillanceInteractor.this.listener.onMakeSurveillanceError(str2, str3);
            }
        });
    }
}
