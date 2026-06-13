package kr.switcher.switcherm.ui.setting.interactor;

import kr.switcher.device.remocon.Remocon;
import kr.switcher.switcherm.network.http.RestSwitcherAPIStore;
import kr.switcher.switcherm.network.http.response.HttpAPIResponse;
import kr.switcher.switcherm.network.http.response.HttpResponseHandler;

/* JADX INFO: loaded from: classes2.dex */
public class SendReservationToServerInteractor {
    private static final String TAG = "SendReservationToServerInteractor";
    private OnSendReservationToServerListener sListener;

    public interface OnSendReservationToServerListener {
        void onSendReservationError(String str);

        void onSendReservationSuccess();
    }

    public SendReservationToServerInteractor(OnSendReservationToServerListener onSendReservationToServerListener) {
        this.sListener = onSendReservationToServerListener;
    }

    public void requestPostToServer(String str, String str2, Remocon.RemoconReservation remoconReservation) {
        RestSwitcherAPIStore.requestPostReservationData(str, str2, remoconReservation, new HttpResponseHandler() { // from class: kr.switcher.switcherm.ui.setting.interactor.SendReservationToServerInteractor.1
            @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
            public void onSuccess(HttpAPIResponse httpAPIResponse) {
                SendReservationToServerInteractor.this.sListener.onSendReservationSuccess();
            }

            @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
            public void onFailure(String str3, String str4) {
                SendReservationToServerInteractor.this.sListener.onSendReservationError(str3);
            }
        });
    }
}
