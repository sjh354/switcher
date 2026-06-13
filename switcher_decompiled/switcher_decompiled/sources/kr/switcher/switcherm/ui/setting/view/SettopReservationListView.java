package kr.switcher.switcherm.ui.setting.view;

import java.util.List;
import kr.switcher.device.remocon.Remocon;
import kr.switcher.switcherm.ui.setting.adapter.AirconReservationItem;

/* JADX INFO: loaded from: classes2.dex */
public interface SettopReservationListView {
    void convertRemoconReservationData(List<AirconReservationItem> list);

    void disableProgressbar();

    void hideEmpty();

    void initRecyclerListView();

    void moveSettopReservationFragment(int i);

    void onReservationSize(int i);

    void setRemoconReservations(List<Remocon.RemoconReservation> list);

    void showCanNotLoaded();

    void showDeleteDialog(int i);

    void showEmpty();

    void showProgressbar();

    void showReservationList();

    void timeoutLoading();
}
