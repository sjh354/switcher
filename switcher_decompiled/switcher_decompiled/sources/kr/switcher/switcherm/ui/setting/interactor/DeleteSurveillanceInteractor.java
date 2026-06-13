package kr.switcher.switcherm.ui.setting.interactor;

import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.network.http.RestSwitcherAPIStore;
import kr.switcher.switcherm.network.http.response.HttpAPIResponse;
import kr.switcher.switcherm.network.http.response.HttpResponseHandler;

/* JADX INFO: loaded from: classes2.dex */
public class DeleteSurveillanceInteractor {
    private static final String TAG = "DeleteSurveillanceInteractor";
    private OnDeleteSurveillanceListener deleteSurveillanceListener;

    public interface OnDeleteSurveillanceListener {
        void onDeleteSurveillanceError(String str);

        void onDeleteSurveillanceSuccess();
    }

    public DeleteSurveillanceInteractor(OnDeleteSurveillanceListener onDeleteSurveillanceListener) {
        this.deleteSurveillanceListener = onDeleteSurveillanceListener;
    }

    public void requestDeleteCheckersSurveillance(String str, String str2) {
        RestSwitcherAPIStore.requestDeleteCheckersSurveillance(IOUtil.makeBackendMacAddressFormat(str), String.valueOf(str2), new HttpResponseHandler() { // from class: kr.switcher.switcherm.ui.setting.interactor.DeleteSurveillanceInteractor.1
            @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
            public void onSuccess(HttpAPIResponse httpAPIResponse) {
                DeleteSurveillanceInteractor.this.deleteSurveillanceListener.onDeleteSurveillanceSuccess();
            }

            @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
            public void onFailure(String str3, String str4) {
                DeleteSurveillanceInteractor.this.deleteSurveillanceListener.onDeleteSurveillanceError(str3);
            }
        });
    }
}
