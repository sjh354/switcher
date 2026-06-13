package kr.switcher.switcherm.ui.dialog.signal.interactor;

import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.network.http.RestSwitcherAPIStore;
import kr.switcher.switcherm.network.http.response.HttpAPIResponse;
import kr.switcher.switcherm.network.http.response.HttpResponseHandler;
import kr.switcher.switcherm.signal.SignalData;

/* JADX INFO: loaded from: classes2.dex */
public class SendStatusForSignalInteractor extends HttpResponseHandler {
    private static final String TAG = "SendStatusForSignalInteractor";
    public OnSendResultListener listener;

    public interface OnSendResultListener {
        void onResult(boolean z);
    }

    public void setOnSendResultListener(OnSendResultListener onSendResultListener) {
        this.listener = onSendResultListener;
    }

    public void sendStatus(String str, SignalData signalData, String str2) {
        IOLog.i(TAG, "send status - instanceId:" + signalData.getInstanceId() + ", status:" + str2);
        if (signalData.getType() == 98) {
            return;
        }
        if (signalData.getType() == 0) {
            RestSwitcherAPIStore.requestPutSignalForMarketing(signalData.getInstanceId(), str2, this);
        } else {
            RestSwitcherAPIStore.requestPutSignalForFeature(str, signalData.getInstanceId(), str2, this);
        }
    }

    @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
    public void onSuccess(HttpAPIResponse httpAPIResponse) {
        IOLog.i(TAG, "succeeded update status for signal");
        OnSendResultListener onSendResultListener = this.listener;
        if (onSendResultListener != null) {
            onSendResultListener.onResult(true);
        }
    }

    @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
    public void onFailure(String str, String str2) {
        IOLog.i(TAG, "code:" + str + ", message:" + str2);
        OnSendResultListener onSendResultListener = this.listener;
        if (onSendResultListener != null) {
            onSendResultListener.onResult(false);
        }
    }
}
