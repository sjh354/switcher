package kr.switcher.switcherm.ui.ircommandtest.interactor;

import kr.switcher.device.remocon.IRCommand;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.device.IODeviceMapper;
import kr.switcher.switcherm.network.http.RestSwitcherAPIStore;
import kr.switcher.switcherm.network.http.response.CreateIRDBRequestAPIResponse;
import kr.switcher.switcherm.network.http.response.HttpAPIResponse;
import kr.switcher.switcherm.network.http.response.HttpResponseHandler;
import kr.switcher.switcherm.preference.OAuthToken;

/* JADX INFO: loaded from: classes2.dex */
public class CreateIRCommandInteractor {
    private static final String TAG = "CreateIRCommandInteractor";
    private OnCreateIRCommandListener listener;

    public interface OnCreateIRCommandListener {
        void onCreateIRCommand(IRCommand iRCommand);

        void onError(String str);
    }

    public CreateIRCommandInteractor(OnCreateIRCommandListener onCreateIRCommandListener) {
        this.listener = onCreateIRCommandListener;
    }

    public void createIRCommand(String str) {
        RestSwitcherAPIStore.requestPostIRDBRequest(str, new HttpResponseHandler() { // from class: kr.switcher.switcherm.ui.ircommandtest.interactor.CreateIRCommandInteractor.1
            @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
            public void onSuccess(HttpAPIResponse httpAPIResponse) {
                CreateIRCommandInteractor.this.listener.onCreateIRCommand(IODeviceMapper.parseGetIRCommand((CreateIRDBRequestAPIResponse) httpAPIResponse));
            }

            @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
            public void onFailure(String str2, String str3) {
                IOLog.error(CreateIRCommandInteractor.TAG, new OAuthToken().getOAuthToken(), "requestPostApplianceMe", new Exception("code:" + str2 + ", message:" + str3));
                CreateIRCommandInteractor.this.listener.onError(str3);
            }
        });
    }
}
