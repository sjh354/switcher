package kr.switcher.switcherm.ui.setting.interactor;

import kr.switcher.device.checker.Checker;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.network.http.RestSwitcherAPIStore;
import kr.switcher.switcherm.network.http.response.HttpAPIResponse;
import kr.switcher.switcherm.network.http.response.HttpResponseHandler;

/* JADX INFO: loaded from: classes2.dex */
public class ModifyCheckerSurveillanceInteractor {
    private static final String TAG = "ModifyCheckerSurveillanceInteractor";
    private OnModifyCheckerSurveillanceListener listener;

    public interface OnModifyCheckerSurveillanceListener {
        void onError(String str);

        void onModifySurveillance();
    }

    public ModifyCheckerSurveillanceInteractor(OnModifyCheckerSurveillanceListener onModifyCheckerSurveillanceListener) {
        this.listener = onModifyCheckerSurveillanceListener;
    }

    public void requestPutCheckersSurveillance(String str, Checker.Surveillance surveillance) {
        RestSwitcherAPIStore.requestPutCheckersSurveillance(IOUtil.makeBackendMacAddressFormat(str), surveillance, new HttpResponseHandler() { // from class: kr.switcher.switcherm.ui.setting.interactor.ModifyCheckerSurveillanceInteractor.1
            @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
            public void onFailure(String str2, String str3) {
            }

            @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
            public void onSuccess(HttpAPIResponse httpAPIResponse) {
                ModifyCheckerSurveillanceInteractor.this.listener.onModifySurveillance();
            }
        });
    }
}
