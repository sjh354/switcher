package kr.switcher.switcherm.ui.setting.interactor;

import java.util.List;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.device.IODeviceMapper;
import kr.switcher.switcherm.network.http.RestSwitcherAPIStore;
import kr.switcher.switcherm.network.http.response.HttpResponseListHandler;
import kr.switcher.switcherm.preference.OAuthToken;
import kr.switcher.switcherm.ui.setting.adapter.AirconReservationItem;

/* JADX INFO: loaded from: classes2.dex */
public class AirconReservationListInteractor {
    private static final String TAG = "AirconReservationListInteractor";
    private OnAirconReservationListListener listener;

    public interface OnAirconReservationListListener {
        void onError(String str);

        void onFindRemoconReservation(List<AirconReservationItem> list);
    }

    public AirconReservationListInteractor(OnAirconReservationListListener onAirconReservationListListener) {
        this.listener = onAirconReservationListListener;
    }

    public void requestGetRemoconReservation(String str, String str2) {
        RestSwitcherAPIStore.requestGetRemoconReservation(str, str2, new HttpResponseListHandler() { // from class: kr.switcher.switcherm.ui.setting.interactor.AirconReservationListInteractor.1
            @Override // kr.switcher.switcherm.network.http.response.HttpResponseListHandler
            public void onSuccess(List list) {
                List<AirconReservationItem> getRemoconResrvation = IODeviceMapper.parseGetRemoconResrvation(list);
                AirconReservationListInteractor.this.listener.onFindRemoconReservation(getRemoconResrvation);
                getRemoconResrvation.clear();
            }

            @Override // kr.switcher.switcherm.network.http.response.HttpResponseListHandler
            public void onFailure(String str3, String str4) {
                IOLog.error(AirconReservationListInteractor.TAG, new OAuthToken().getOAuthToken(), "requestGetRemoconReservation", new Exception("code:" + str3 + ", message:" + str4));
                AirconReservationListInteractor.this.listener.onError(str4);
            }
        });
    }
}
