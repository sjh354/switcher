package kr.switcher.switcherm.ui.setting.interactor;

import java.util.List;
import kr.switcher.device.switcher.Switcher;
import kr.switcher.switcherm.common.util.ConverterUtil;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.device.switcher.handler.SwitcherDBProvider;
import kr.switcher.switcherm.network.http.RestResponseHandler;
import kr.switcher.switcherm.network.http.RestSwitcherAPIStore;
import kr.switcher.switcherm.preference.OAuthToken;
import kr.switcher.switcherm.preference.TimerVersion;

/* JADX INFO: loaded from: classes2.dex */
public class ReservationInteractor {
    private static final String TAG = "ReservationInteractor";

    public String getLastTimerVersion() {
        return new TimerVersion().getTimerVersion();
    }

    public void requestPostReservationLogToSwitcherAPI(String str, List<Switcher.SwitcherReservation> list) {
        RestSwitcherAPIStore.requestPostReservationLog(str, ConverterUtil.convertSwitcherReservationToReservationDataList(list), new RestResponseHandler() { // from class: kr.switcher.switcherm.ui.setting.interactor.ReservationInteractor.1
            @Override // kr.switcher.switcherm.network.http.RestResponseHandler
            public void onSuccess(String str2) {
                IOLog.i(ReservationInteractor.TAG, str2);
            }

            @Override // kr.switcher.switcherm.network.http.RestResponseHandler
            public void onFailure(String str2, String str3) {
                IOLog.error(ReservationInteractor.TAG, new OAuthToken().getOAuthToken(), "requestPostReservationLogToSwitcherAPI", new Exception("code:" + str2 + ", message:" + str3));
            }
        });
    }

    public void saveReservationListToDB(Switcher switcher, List<Switcher.SwitcherReservation> list) {
        switcher.setSwitcherReservationList(new SwitcherDBProvider().updateSwitcherReservationListToDB(switcher.getMacAddress(), list));
    }
}
