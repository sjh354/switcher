package kr.switcher.switcherm.ui.irremoconregister.interactor;

import kr.switcher.device.remocon.Remocon;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.device.IODeviceHandler;
import kr.switcher.switcherm.device.IODeviceMapper;
import kr.switcher.switcherm.network.http.RestSwitcherAPIStore;
import kr.switcher.switcherm.network.http.response.CreateApplianceMeAPIResponse;
import kr.switcher.switcherm.network.http.response.HttpAPIResponse;
import kr.switcher.switcherm.network.http.response.HttpResponseHandler;
import kr.switcher.switcherm.preference.OAuthToken;

/* JADX INFO: loaded from: classes2.dex */
public class LinkerRemoconRegisterInteractor {
    private static final String TAG = "LinkerRemoconRegisterInteractor";
    private OnCreateRemoconListener listener;

    public interface OnCreateRemoconListener {
        void onCreateRemocon(Remocon remocon);

        void onError(String str);
    }

    public LinkerRemoconRegisterInteractor(OnCreateRemoconListener onCreateRemoconListener) {
        this.listener = onCreateRemoconListener;
    }

    public void createRemocon(String str) {
        RestSwitcherAPIStore.requestPostApplianceMe(str, new HttpResponseHandler() { // from class: kr.switcher.switcherm.ui.irremoconregister.interactor.LinkerRemoconRegisterInteractor.1
            @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
            public void onSuccess(HttpAPIResponse httpAPIResponse) {
                Remocon getRemocon = IODeviceMapper.parseGetRemocon((CreateApplianceMeAPIResponse) httpAPIResponse);
                IODeviceHandler.getInstance().addDevice(getRemocon);
                LinkerRemoconRegisterInteractor.this.listener.onCreateRemocon(getRemocon);
            }

            @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
            public void onFailure(String str2, String str3) {
                IOLog.error(LinkerRemoconRegisterInteractor.TAG, new OAuthToken().getOAuthToken(), "requestPostApplianceMe", new Exception("code:" + str2 + ", message:" + str3));
                LinkerRemoconRegisterInteractor.this.listener.onError(str3);
            }
        });
    }
}
