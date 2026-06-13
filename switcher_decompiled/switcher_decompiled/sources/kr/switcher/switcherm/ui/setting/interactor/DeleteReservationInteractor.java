package kr.switcher.switcherm.ui.setting.interactor;

import kr.switcher.device.remocon.Remocon;
import kr.switcher.switcherm.network.http.RestSwitcherAPIStore;
import kr.switcher.switcherm.network.http.response.HttpAPIResponse;
import kr.switcher.switcherm.network.http.response.HttpResponseHandler;

/* JADX INFO: loaded from: classes2.dex */
public class DeleteReservationInteractor {
    private static final String TAG = "DeleteReservationInteractor";
    private OnChangeReservationDataListener cListener;
    private OnDeleteReservationListener dListener;

    public interface OnChangeReservationDataListener {
        void onChangeReservationDataFailure(String str);

        void onChangeReservationDataSuccess(Remocon.RemoconReservation remoconReservation, String str);
    }

    public interface OnDeleteReservationListener {
        void onDeleteReservationError(String str);

        void onDeleteReservationSuccess();
    }

    public DeleteReservationInteractor(OnDeleteReservationListener onDeleteReservationListener, OnChangeReservationDataListener onChangeReservationDataListener) {
        this.dListener = onDeleteReservationListener;
        this.cListener = onChangeReservationDataListener;
    }

    public void requestDeleteReservation(String str, String str2) {
        RestSwitcherAPIStore.requestDeleteReservation(str, str2, new HttpResponseHandler() { // from class: kr.switcher.switcherm.ui.setting.interactor.DeleteReservationInteractor.1
            @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
            public void onSuccess(HttpAPIResponse httpAPIResponse) {
                DeleteReservationInteractor.this.dListener.onDeleteReservationSuccess();
            }

            @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
            public void onFailure(String str3, String str4) {
                DeleteReservationInteractor.this.dListener.onDeleteReservationError(str3);
            }
        });
    }

    public void requestChangeReservationData(final Remocon.RemoconReservation remoconReservation, final String str, String str2) {
        RestSwitcherAPIStore.requestDeleteReservation(str, str2, new HttpResponseHandler() { // from class: kr.switcher.switcherm.ui.setting.interactor.DeleteReservationInteractor.2
            @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
            public void onSuccess(HttpAPIResponse httpAPIResponse) {
                DeleteReservationInteractor.this.cListener.onChangeReservationDataSuccess(remoconReservation, str);
            }

            @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
            public void onFailure(String str3, String str4) {
                DeleteReservationInteractor.this.cListener.onChangeReservationDataFailure(str3);
            }
        });
    }
}
