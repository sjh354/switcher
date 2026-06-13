package kr.switcher.switcherm.ui.setting.interactor;

import java.util.List;
import kr.switcher.device.remocon.IRCommand;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.device.IODeviceMapper;
import kr.switcher.switcherm.network.http.RestSwitcherAPIStore;
import kr.switcher.switcherm.network.http.response.HttpResponseListHandler;
import kr.switcher.switcherm.preference.OAuthToken;

/* JADX INFO: loaded from: classes2.dex */
public class FindAirconCommandListInteractor {
    private static final String TAG = "FindAirconCommandListInteractor";
    private OnFindAirconCommandListListener listener;

    public interface OnFindAirconCommandListListener {
        void onError(String str);

        void onFindRemoconReservation(List<IRCommand> list);
    }

    public FindAirconCommandListInteractor(OnFindAirconCommandListListener onFindAirconCommandListListener) {
        this.listener = onFindAirconCommandListListener;
    }

    public void requestGetAirconCommandList(String str) {
        RestSwitcherAPIStore.requestGetIR(str, new HttpResponseListHandler() { // from class: kr.switcher.switcherm.ui.setting.interactor.FindAirconCommandListInteractor.1
            @Override // kr.switcher.switcherm.network.http.response.HttpResponseListHandler
            public void onSuccess(List list) {
                FindAirconCommandListInteractor.this.listener.onFindRemoconReservation(IODeviceMapper.parseGetIR(list));
            }

            @Override // kr.switcher.switcherm.network.http.response.HttpResponseListHandler
            public void onFailure(String str2, String str3) {
                IOLog.error(FindAirconCommandListInteractor.TAG, new OAuthToken().getOAuthToken(), "requestGetAirconCommandList", new Exception("code:" + str2 + ", message:" + str3));
                FindAirconCommandListInteractor.this.listener.onError(str3);
            }
        });
    }
}
