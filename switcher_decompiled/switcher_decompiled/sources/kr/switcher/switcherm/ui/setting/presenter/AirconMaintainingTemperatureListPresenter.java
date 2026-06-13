package kr.switcher.switcherm.ui.setting.presenter;

import java.util.ArrayList;
import java.util.List;
import kr.switcher.device.remocon.Remocon;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.ui.setting.adapter.AirconMaintainingTemperatureItem;
import kr.switcher.switcherm.ui.setting.interactor.DeleteMaintenanceInteractor;
import kr.switcher.switcherm.ui.setting.interactor.FindAirconMaintenanceListInteractor;
import kr.switcher.switcherm.ui.setting.interactor.ModifyAirconMaintenanceInteractor;
import kr.switcher.switcherm.ui.setting.view.AirconMaintainingTemperatureListView;

/* JADX INFO: loaded from: classes2.dex */
public class AirconMaintainingTemperatureListPresenter {
    private static final String TAG = "AirconMaintainingTemperatureListPresenter";
    private DeleteMaintenanceInteractor dInteractor;
    private FindAirconMaintenanceListInteractor interactor;
    private ModifyAirconMaintenanceInteractor mInteractor;
    private AirconMaintainingTemperatureListView view;

    public AirconMaintainingTemperatureListPresenter(AirconMaintainingTemperatureListView airconMaintainingTemperatureListView, FindAirconMaintenanceListInteractor findAirconMaintenanceListInteractor, DeleteMaintenanceInteractor deleteMaintenanceInteractor, ModifyAirconMaintenanceInteractor modifyAirconMaintenanceInteractor) {
        this.view = airconMaintainingTemperatureListView;
        this.interactor = findAirconMaintenanceListInteractor;
        this.dInteractor = deleteMaintenanceInteractor;
        this.mInteractor = modifyAirconMaintenanceInteractor;
    }

    public void onCreateView() {
        this.view.showProgressbar();
        this.view.timeoutLoading();
    }

    public void onResume(Remocon remocon) {
        this.view.initRecyclerListView();
        this.interactor.requestGetRemoconMaintenance(remocon.getId());
    }

    public void timeout(boolean z) {
        if (z) {
            this.view.disableProgressbar();
            this.view.showCanNotLoaded();
            IOLog.i(TAG, "timeout refresh timer");
        }
    }

    public void onRefresh(Remocon remocon) {
        this.view.timeoutLoading();
        onResume(remocon);
    }

    public void onItemClick(boolean z, int i) {
        if (z) {
            return;
        }
        this.view.moveAirconMaintainingTemperatureFragment(i);
    }

    public void convertRemoconMaintainingTemperatureData(List<AirconMaintainingTemperatureItem> list) {
        ArrayList arrayList = new ArrayList();
        for (AirconMaintainingTemperatureItem airconMaintainingTemperatureItem : list) {
            Remocon.RemoconMaintenanceTemperature remoconMaintenanceTemperature = new Remocon.RemoconMaintenanceTemperature(airconMaintainingTemperatureItem.id, airconMaintainingTemperatureItem.title, airconMaintainingTemperatureItem.is_enabled, airconMaintainingTemperatureItem.goal_temperature, airconMaintainingTemperatureItem.weekdays, airconMaintainingTemperatureItem.start_time_at, airconMaintainingTemperatureItem.end_time_at, airconMaintainingTemperatureItem.created_at, airconMaintainingTemperatureItem.appliances);
            getDayOfWeek(remoconMaintenanceTemperature, airconMaintainingTemperatureItem.weekdays);
            remoconMaintenanceTemperature.startHour = getHour(airconMaintainingTemperatureItem.start_time_at);
            remoconMaintenanceTemperature.endHour = getHour(airconMaintainingTemperatureItem.end_time_at);
            remoconMaintenanceTemperature.startMin = getMin(airconMaintainingTemperatureItem.start_time_at);
            remoconMaintenanceTemperature.endMin = getMin(airconMaintainingTemperatureItem.start_time_at);
            arrayList.add(remoconMaintenanceTemperature);
        }
        this.view.setRemoconReservations(arrayList);
    }

    public void onCheckedChange(Remocon.RemoconMaintenanceTemperature remoconMaintenanceTemperature, String str) {
        remoconMaintenanceTemperature.is_enabled = Boolean.valueOf(Boolean.parseBoolean(str));
        this.mInteractor.requestPutRemoconMaintenance(remoconMaintenanceTemperature);
    }

    public void onFindRemoconMaintenance(List<AirconMaintainingTemperatureItem> list) {
        if (list.size() == 0) {
            this.view.showEmpty();
        } else {
            this.view.hideEmpty();
        }
        convertRemoconMaintainingTemperatureData(list);
    }

    private void getDayOfWeek(Remocon.RemoconMaintenanceTemperature remoconMaintenanceTemperature, String str) {
        if (str == null || str.length() <= 0) {
            return;
        }
        if (str.charAt(0) == '1') {
            remoconMaintenanceTemperature.mon = true;
        } else {
            remoconMaintenanceTemperature.mon = false;
        }
        if (str.charAt(1) == '1') {
            remoconMaintenanceTemperature.tue = true;
        } else {
            remoconMaintenanceTemperature.tue = false;
        }
        if (str.charAt(2) == '1') {
            remoconMaintenanceTemperature.wed = true;
        } else {
            remoconMaintenanceTemperature.wed = false;
        }
        if (str.charAt(3) == '1') {
            remoconMaintenanceTemperature.thu = true;
        } else {
            remoconMaintenanceTemperature.thu = false;
        }
        if (str.charAt(4) == '1') {
            remoconMaintenanceTemperature.fri = true;
        } else {
            remoconMaintenanceTemperature.fri = false;
        }
        if (str.charAt(5) == '1') {
            remoconMaintenanceTemperature.sat = true;
        } else {
            remoconMaintenanceTemperature.sat = false;
        }
        if (str.charAt(6) == '1') {
            remoconMaintenanceTemperature.sun = true;
        } else {
            remoconMaintenanceTemperature.sun = false;
        }
    }

    private int getMin(String str) {
        return Integer.parseInt(str.substring(2));
    }

    private int getHour(String str) {
        return Integer.parseInt(str.substring(0, 2));
    }

    public void removeMaintenance(Remocon.RemoconMaintenanceTemperature remoconMaintenanceTemperature, int i) {
        this.dInteractor.requestDeleteMaintenance(String.valueOf(remoconMaintenanceTemperature.id), i);
    }
}
