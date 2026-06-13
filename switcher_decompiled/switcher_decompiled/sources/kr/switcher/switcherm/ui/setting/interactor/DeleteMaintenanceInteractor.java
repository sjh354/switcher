package kr.switcher.switcherm.ui.setting.interactor;

import kr.switcher.switcherm.network.http.RestSwitcherAPIStore;
import kr.switcher.switcherm.network.http.response.HttpAPIResponse;
import kr.switcher.switcherm.network.http.response.HttpResponseHandler;

/* JADX INFO: loaded from: classes2.dex */
public class DeleteMaintenanceInteractor {
    private static final String TAG = "DeleteMaintenanceInteractor";
    private OnDeleteReservationListener dListener;

    public interface OnDeleteReservationListener {
        void onDeleteMaintenanceError(String str);

        void onDeleteMaintenanceSuccess();

        void onDeleteMaintenanceSuccess(int i);
    }

    public DeleteMaintenanceInteractor(OnDeleteReservationListener onDeleteReservationListener) {
        this.dListener = onDeleteReservationListener;
    }

    public void requestDeleteMaintenance(String str) {
        RestSwitcherAPIStore.requestDeleteMaintenance(str, new HttpResponseHandler() { // from class: kr.switcher.switcherm.ui.setting.interactor.DeleteMaintenanceInteractor.1
            @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
            public void onSuccess(HttpAPIResponse httpAPIResponse) {
                DeleteMaintenanceInteractor.this.dListener.onDeleteMaintenanceSuccess();
            }

            @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
            public void onFailure(String str2, String str3) {
                DeleteMaintenanceInteractor.this.dListener.onDeleteMaintenanceError(str2);
            }
        });
    }

    public void requestDeleteMaintenance(String str, final int i) {
        RestSwitcherAPIStore.requestDeleteMaintenance(str, new HttpResponseHandler() { // from class: kr.switcher.switcherm.ui.setting.interactor.DeleteMaintenanceInteractor.2
            @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
            public void onSuccess(HttpAPIResponse httpAPIResponse) {
                DeleteMaintenanceInteractor.this.dListener.onDeleteMaintenanceSuccess(i);
            }

            @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
            public void onFailure(String str2, String str3) {
                DeleteMaintenanceInteractor.this.dListener.onDeleteMaintenanceError(str2);
            }
        });
    }
}
