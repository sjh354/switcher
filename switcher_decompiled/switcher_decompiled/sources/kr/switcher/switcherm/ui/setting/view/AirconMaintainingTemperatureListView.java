package kr.switcher.switcherm.ui.setting.view;

import java.util.List;
import kr.switcher.device.remocon.Remocon;
import kr.switcher.switcherm.ui.setting.adapter.AirconMaintainingTemperatureItem;

/* JADX INFO: loaded from: classes2.dex */
public interface AirconMaintainingTemperatureListView {
    void convertRemoconMaintainingTemperatureData(List<AirconMaintainingTemperatureItem> list);

    void disableProgressbar();

    void hideEmpty();

    void initRecyclerListView();

    void moveAirconMaintainingTemperatureFragment(int i);

    void onReservationSize(int i);

    void setRemoconReservations(List<Remocon.RemoconMaintenanceTemperature> list);

    void showCanNotLoaded();

    void showDeleteDialog(int i);

    void showEmpty();

    void showProgressbar();

    void showReservationList();

    void timeoutLoading();
}
