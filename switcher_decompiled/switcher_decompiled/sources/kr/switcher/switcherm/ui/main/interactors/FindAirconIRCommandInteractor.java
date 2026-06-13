package kr.switcher.switcherm.ui.main.interactors;

import java.util.List;
import kr.switcher.device.remocon.IRCommand;
import kr.switcher.device.remocon.Remocon;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.device.IODeviceMapper;
import kr.switcher.switcherm.network.http.RestSwitcherAPIStore;
import kr.switcher.switcherm.network.http.response.HttpAPIResponse;
import kr.switcher.switcherm.network.http.response.HttpResponseHandler;
import kr.switcher.switcherm.network.http.response.HttpResponseListHandler;
import kr.switcher.switcherm.preference.OAuthToken;

/* JADX INFO: loaded from: classes2.dex */
public class FindAirconIRCommandInteractor {
    public static String TAG = "FindAirconIRCommandInteractor";
    private OnFindAirconIRCommandListener listener;

    public interface OnFindAirconIRCommandListener {
        void onFind(List<IRCommand> list);

        void onRelease(boolean z);

        void onRemove(boolean z, String str);
    }

    public FindAirconIRCommandInteractor(OnFindAirconIRCommandListener onFindAirconIRCommandListener) {
        this.listener = onFindAirconIRCommandListener;
    }

    public void findAirconIRCommand(Remocon remocon) {
        RestSwitcherAPIStore.requestGetIR(remocon.getId(), new HttpResponseListHandler() { // from class: kr.switcher.switcherm.ui.main.interactors.FindAirconIRCommandInteractor.1
            @Override // kr.switcher.switcherm.network.http.response.HttpResponseListHandler
            public void onSuccess(List list) {
                FindAirconIRCommandInteractor.this.listener.onFind(IODeviceMapper.parseGetIR(list));
            }

            @Override // kr.switcher.switcherm.network.http.response.HttpResponseListHandler
            public void onFailure(String str, String str2) {
                IOLog.error(FindAirconIRCommandInteractor.TAG, new OAuthToken().getOAuthToken(), "requestGetIR", new Exception("code:" + str + ", message:" + str2));
            }
        });
    }

    public void releaseIR(IRCommand iRCommand) {
        RestSwitcherAPIStore.requestPostRelease(iRCommand.getId(), new HttpResponseHandler() { // from class: kr.switcher.switcherm.ui.main.interactors.FindAirconIRCommandInteractor.2
            @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
            public void onSuccess(HttpAPIResponse httpAPIResponse) {
                FindAirconIRCommandInteractor.this.listener.onRelease(true);
            }

            @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
            public void onFailure(String str, String str2) {
                IOLog.error(FindAirconIRCommandInteractor.TAG, new OAuthToken().getOAuthToken(), "releaseIR", new Exception("code:" + str + ", message:" + str2));
                FindAirconIRCommandInteractor.this.listener.onRelease(false);
            }
        });
    }

    public void removeIR(final String str) {
        RestSwitcherAPIStore.requestDeleteIRCommand(str, new HttpResponseHandler() { // from class: kr.switcher.switcherm.ui.main.interactors.FindAirconIRCommandInteractor.3
            @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
            public void onSuccess(HttpAPIResponse httpAPIResponse) {
                FindAirconIRCommandInteractor.this.listener.onRemove(true, str);
            }

            @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
            public void onFailure(String str2, String str3) {
                IOLog.error(FindAirconIRCommandInteractor.TAG, new OAuthToken().getOAuthToken(), "removeIR", new Exception("code:" + str2 + ", message:" + str3));
                FindAirconIRCommandInteractor.this.listener.onRemove(false, str);
            }
        });
    }
}
