package kr.switcher.switcherm.ui.setting.presenter;

import java.util.List;
import kr.switcher.device.switcher.Switcher;
import kr.switcher.device.switcher.interfaces.IODeviceCallbacks;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.ui.setting.interactor.ReservationInteractor;
import kr.switcher.switcherm.ui.setting.view.ReservationListView;

/* JADX INFO: loaded from: classes2.dex */
public class ReservationListPresenter implements IODeviceCallbacks.LoadTimerInfoResultResponseCallback {
    private static final String TAG = "ReservationListPresenter";
    private ReservationInteractor interactor;
    private ReservationListView view;

    public ReservationListPresenter(ReservationListView reservationListView, ReservationInteractor reservationInteractor) {
        this.view = reservationListView;
        this.interactor = reservationInteractor;
    }

    public void signal() {
        this.view.signal();
    }

    public void onResume(Switcher switcher) {
        this.view.showProgressbar();
        this.view.timeoutLoading();
        this.view.initRecyclerListView();
        setTimerListFromSwitcher(switcher);
        this.view.setReservations(switcher.sResrvs);
    }

    public void onRefresh(Switcher switcher) {
        this.view.timeoutLoading();
        setTimerListFromSwitcher(switcher);
    }

    private void setTimerListFromSwitcher(Switcher switcher) {
        String lastTimerVersion = this.interactor.getLastTimerVersion();
        this.view.requestGetReservationList(switcher);
        IOLog.i(TAG, "last timer version : " + lastTimerVersion);
    }

    public void showReservationListView(int i) {
        if (i > 0) {
            this.view.showReservationList();
        } else {
            this.view.showEmpty();
        }
        this.view.disableProgressbar();
        this.view.onReservationSize(i);
    }

    public void onItemClick(boolean z, int i) {
        if (z) {
            return;
        }
        this.view.moveReservationFragment(i);
    }

    public void timeout(boolean z) {
        if (z) {
            this.view.disableProgressbar();
            this.view.showCanNotLoaded();
            IOLog.i(TAG, "timeout refresh timer");
        }
    }

    @Override // kr.switcher.device.switcher.interfaces.IODeviceCallbacks.LoadTimerInfoResultResponseCallback
    public void onLoadReservationListResult(List<Switcher.SwitcherReservation> list) {
        this.view.addReservationItems(list);
    }

    public void addReservationItems(Switcher switcher, List<Switcher.SwitcherReservation> list) {
        this.interactor.saveReservationListToDB(switcher, list);
    }

    public void onPause(String str, List<Switcher.SwitcherReservation> list) {
        this.interactor.requestPostReservationLogToSwitcherAPI(str, list);
    }
}
