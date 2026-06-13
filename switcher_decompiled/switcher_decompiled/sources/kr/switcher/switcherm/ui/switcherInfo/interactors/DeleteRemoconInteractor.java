package kr.switcher.switcherm.ui.switcherInfo.interactors;

import kr.switcher.device.remocon.Remocon;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.device.IODeviceHandler;
import kr.switcher.switcherm.network.http.RestSwitcherAPIStore;
import kr.switcher.switcherm.network.http.response.HttpAPIResponse;
import kr.switcher.switcherm.network.http.response.HttpResponseHandler;
import kr.switcher.switcherm.preference.OAuthToken;

/* JADX INFO: loaded from: classes2.dex */
public class DeleteRemoconInteractor {
    private static final String TAG = "DeleteRemoconInteractor";
    private OnDeleteRemoconListener listener;
    private Remocon remocon;

    public interface OnDeleteRemoconListener {
        void onDeleteSuccess();

        void onError(String str);
    }

    public DeleteRemoconInteractor(OnDeleteRemoconListener onDeleteRemoconListener) {
        this.listener = onDeleteRemoconListener;
    }

    public void deleteRemocon(final Remocon remocon) {
        RestSwitcherAPIStore.requestDeleteRemocon(remocon.getId(), new HttpResponseHandler() { // from class: kr.switcher.switcherm.ui.switcherInfo.interactors.DeleteRemoconInteractor.1
            @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
            public void onSuccess(HttpAPIResponse httpAPIResponse) {
                IODeviceHandler.getInstance().removeDevice(remocon);
                DeleteRemoconInteractor.this.listener.onDeleteSuccess();
            }

            @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
            public void onFailure(String str, String str2) {
                IOLog.error(DeleteRemoconInteractor.TAG, new OAuthToken().getOAuthToken(), "requestDeleteRemocon", new Exception("code:" + str + ", message:" + str2));
                DeleteRemoconInteractor.this.listener.onError(str2);
            }
        });
    }
}
