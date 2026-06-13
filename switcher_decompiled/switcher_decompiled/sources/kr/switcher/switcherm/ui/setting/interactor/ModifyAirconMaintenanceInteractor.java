package kr.switcher.switcherm.ui.setting.interactor;

import kr.switcher.device.remocon.Remocon;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.network.http.RestSwitcherAPIStore;
import kr.switcher.switcherm.network.http.response.HttpAPIResponse;
import kr.switcher.switcherm.network.http.response.HttpResponseHandler;
import kr.switcher.switcherm.preference.OAuthToken;

/* JADX INFO: loaded from: classes2.dex */
public class ModifyAirconMaintenanceInteractor {
    private static final String TAG = "ModifyAirconMaintenanceInteractor";
    private OnModifyAirconMaintenanceListener listener;

    public interface OnModifyAirconMaintenanceListener {
        void onModifyError(String str);

        void onModifySuccess();
    }

    public ModifyAirconMaintenanceInteractor(OnModifyAirconMaintenanceListener onModifyAirconMaintenanceListener) {
        this.listener = onModifyAirconMaintenanceListener;
    }

    public void requestPutRemoconMaintenance(Remocon.RemoconMaintenanceTemperature remoconMaintenanceTemperature) {
        RestSwitcherAPIStore.requestPutRemoconMaintenance(remoconMaintenanceTemperature, new HttpResponseHandler() { // from class: kr.switcher.switcherm.ui.setting.interactor.ModifyAirconMaintenanceInteractor.1
            @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
            public void onSuccess(HttpAPIResponse httpAPIResponse) {
                ModifyAirconMaintenanceInteractor.this.listener.onModifySuccess();
            }

            @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
            public void onFailure(String str, String str2) {
                IOLog.error(ModifyAirconMaintenanceInteractor.TAG, new OAuthToken().getOAuthToken(), "requestGetRemoconMaintenance", new Exception("code:" + str + ", message:" + str2));
                ModifyAirconMaintenanceInteractor.this.listener.onModifyError(str2);
            }
        });
    }
}
