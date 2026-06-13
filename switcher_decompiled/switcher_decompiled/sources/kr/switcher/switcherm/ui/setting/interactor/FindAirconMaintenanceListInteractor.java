package kr.switcher.switcherm.ui.setting.interactor;

import java.util.List;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.device.IODeviceMapper;
import kr.switcher.switcherm.network.http.RestSwitcherAPIStore;
import kr.switcher.switcherm.network.http.response.HttpResponseListHandler;
import kr.switcher.switcherm.preference.OAuthToken;
import kr.switcher.switcherm.ui.setting.adapter.AirconMaintainingTemperatureItem;

/* JADX INFO: loaded from: classes2.dex */
public class FindAirconMaintenanceListInteractor {
    private static final String TAG = "FindAirconMaintenanceListInteractor";
    private OnFindAirconMaintainaListListener listener;

    public interface OnFindAirconMaintainaListListener {
        void onError(String str);

        void onFindRemoconMaintenance(List<AirconMaintainingTemperatureItem> list);
    }

    public FindAirconMaintenanceListInteractor(OnFindAirconMaintainaListListener onFindAirconMaintainaListListener) {
        this.listener = onFindAirconMaintainaListListener;
    }

    public void requestGetRemoconMaintenance(String str) {
        RestSwitcherAPIStore.requestGetRemoconMaintenance(str, new HttpResponseListHandler() { // from class: kr.switcher.switcherm.ui.setting.interactor.FindAirconMaintenanceListInteractor.1
            @Override // kr.switcher.switcherm.network.http.response.HttpResponseListHandler
            public void onSuccess(List list) {
                List<AirconMaintainingTemperatureItem> getRemoconMaintenance = IODeviceMapper.parseGetRemoconMaintenance(list);
                FindAirconMaintenanceListInteractor.this.listener.onFindRemoconMaintenance(getRemoconMaintenance);
                getRemoconMaintenance.clear();
            }

            @Override // kr.switcher.switcherm.network.http.response.HttpResponseListHandler
            public void onFailure(String str2, String str3) {
                IOLog.error(FindAirconMaintenanceListInteractor.TAG, new OAuthToken().getOAuthToken(), "requestGetRemoconMaintenance", new Exception("code:" + str2 + ", message:" + str3));
                FindAirconMaintenanceListInteractor.this.listener.onError(str3);
            }
        });
    }
}
