package kr.switcher.switcherm.ui.irbrand.interactor;

import java.util.List;
import kr.switcher.device.remocon.Remocon;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.device.IODeviceHandler;
import kr.switcher.switcherm.device.IODeviceMapper;
import kr.switcher.switcherm.network.http.RestSwitcherAPIStore;
import kr.switcher.switcherm.network.http.response.CreateApplianceMeAPIResponse;
import kr.switcher.switcherm.network.http.response.HttpAPIResponse;
import kr.switcher.switcherm.network.http.response.HttpResponseHandler;
import kr.switcher.switcherm.network.http.response.RemoteControllersAPIResponse;
import kr.switcher.switcherm.preference.OAuthToken;
import kr.switcher.switcherm.ui.irbrand.helper.ControllerItem;

/* JADX INFO: loaded from: classes2.dex */
public class IRControllerInteractor {
    private static final String TAG = "IRControllerInteractor";
    private OnCreateRemoconListener createRemoconListener;
    private OnGetControllerListener getControllerListener;

    public interface OnCreateRemoconListener {
        void onCreateRemocon(Remocon remocon);

        void onError(String str);
    }

    public interface OnGetControllerListener {
        void onError(String str);

        void onGetController(List<ControllerItem> list);
    }

    public IRControllerInteractor(OnGetControllerListener onGetControllerListener, OnCreateRemoconListener onCreateRemoconListener) {
        this.getControllerListener = onGetControllerListener;
        this.createRemoconListener = onCreateRemoconListener;
    }

    public void getController() {
        RestSwitcherAPIStore.requestGetRemoteControllers(new HttpResponseHandler() { // from class: kr.switcher.switcherm.ui.irbrand.interactor.IRControllerInteractor.1
            @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
            public void onSuccess(HttpAPIResponse httpAPIResponse) {
                IRControllerInteractor.this.getControllerListener.onGetController(IODeviceMapper.parseGetController((RemoteControllersAPIResponse) httpAPIResponse));
            }

            @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
            public void onFailure(String str, String str2) {
                IOLog.error(IRControllerInteractor.TAG, new OAuthToken().getOAuthToken(), "requestGetRemoteControllers", new Exception("code:" + str + ", message:" + str2));
                IRControllerInteractor.this.getControllerListener.onError(str2);
            }
        });
    }

    public void createRemocon(String str) {
        RestSwitcherAPIStore.requestPostApplianceMe(str, new HttpResponseHandler() { // from class: kr.switcher.switcherm.ui.irbrand.interactor.IRControllerInteractor.2
            @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
            public void onSuccess(HttpAPIResponse httpAPIResponse) {
                Remocon getRemocon = IODeviceMapper.parseGetRemocon((CreateApplianceMeAPIResponse) httpAPIResponse);
                IODeviceHandler.getInstance().addDevice(getRemocon);
                IRControllerInteractor.this.createRemoconListener.onCreateRemocon(getRemocon);
            }

            @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
            public void onFailure(String str2, String str3) {
                IOLog.error(IRControllerInteractor.TAG, new OAuthToken().getOAuthToken(), "requestPostApplianceMe", new Exception("code:" + str2 + ", message:" + str3));
                IRControllerInteractor.this.createRemoconListener.onError(str3);
            }
        });
    }
}
