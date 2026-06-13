package kr.switcher.switcherm.ui.setting.interactor;

import kr.switcher.device.remocon.Remocon;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.network.http.RestSwitcherAPIStore;
import kr.switcher.switcherm.network.http.response.HttpAPIResponse;
import kr.switcher.switcherm.network.http.response.HttpResponseHandler;
import kr.switcher.switcherm.preference.OAuthToken;

/* JADX INFO: loaded from: classes2.dex */
public class MakeMaintenanceInteractor {
    private static final String TAG = "MakeMaintenanceInteractor";
    private OnMakeMaintenanceListener listener;

    public interface OnMakeMaintenanceListener {
        void onMakeMaintenanceError(String str, String str2);

        void onMakeMaintenanceSuccess();
    }

    public MakeMaintenanceInteractor(OnMakeMaintenanceListener onMakeMaintenanceListener) {
        this.listener = onMakeMaintenanceListener;
    }

    public void requestPostMaintenance(String str, Remocon.RemoconMaintenanceTemperature remoconMaintenanceTemperature) {
        RestSwitcherAPIStore.requestPostRemoconMaintenance(str, remoconMaintenanceTemperature, new HttpResponseHandler() { // from class: kr.switcher.switcherm.ui.setting.interactor.MakeMaintenanceInteractor.1
            @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
            public void onSuccess(HttpAPIResponse httpAPIResponse) {
                MakeMaintenanceInteractor.this.listener.onMakeMaintenanceSuccess();
            }

            @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
            public void onFailure(String str2, String str3) {
                IOLog.error(MakeMaintenanceInteractor.TAG, new OAuthToken().getOAuthToken(), "requestGetRemoconMaintenance", new Exception("code:" + str2 + ", message:" + str3));
                MakeMaintenanceInteractor.this.listener.onMakeMaintenanceError(str2, str3);
            }
        });
    }
}
