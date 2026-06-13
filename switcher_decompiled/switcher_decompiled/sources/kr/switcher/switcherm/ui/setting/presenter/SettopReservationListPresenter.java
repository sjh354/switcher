package kr.switcher.switcherm.ui.setting.presenter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kr.switcher.device.remocon.Remocon;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.device.linker.LinkerHandler;
import kr.switcher.switcherm.ui.setting.adapter.AirconReservationItem;
import kr.switcher.switcherm.ui.setting.interactor.AirconReservationListInteractor;
import kr.switcher.switcherm.ui.setting.interactor.DeleteReservationInteractor;
import kr.switcher.switcherm.ui.setting.interactor.SendReservationToServerInteractor;
import kr.switcher.switcherm.ui.setting.view.SettopReservationListView;

/* JADX INFO: loaded from: classes2.dex */
public class SettopReservationListPresenter {
    private static final String TAG = "SettopReservationListPresenter";
    private DeleteReservationInteractor deleteReservationInteractor;
    private AirconReservationListInteractor interactor;
    private SendReservationToServerInteractor sendReservationToServerInteractor;
    private SettopReservationListView view;

    public SettopReservationListPresenter(SettopReservationListView settopReservationListView, AirconReservationListInteractor airconReservationListInteractor, DeleteReservationInteractor deleteReservationInteractor, SendReservationToServerInteractor sendReservationToServerInteractor) {
        this.view = settopReservationListView;
        this.interactor = airconReservationListInteractor;
        this.deleteReservationInteractor = deleteReservationInteractor;
        this.sendReservationToServerInteractor = sendReservationToServerInteractor;
    }

    public void onCreateView() {
        this.view.showProgressbar();
        this.view.timeoutLoading();
    }

    public void onResume(Remocon remocon) {
        IOLog.i(TAG, "Settop reservation list onResume");
        this.view.initRecyclerListView();
        if (LinkerHandler.getInstance().getAliveLinkers().size() > 0) {
            this.interactor.requestGetRemoconReservation(IOUtil.makeBackendMacAddressFormat(LinkerHandler.getInstance().getAliveLinkers().get(0).getMacAddress()), remocon.getId());
        }
    }

    public void onRefresh(Remocon remocon) {
        onResume(remocon);
        this.view.timeoutLoading();
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
        this.view.moveSettopReservationFragment(i);
    }

    public void timeout(boolean z) {
        if (z) {
            this.view.disableProgressbar();
            this.view.showCanNotLoaded();
            IOLog.i(TAG, "timeout refresh timer");
        }
    }

    public void onFindRemoconReservation(List<AirconReservationItem> list) {
        if (list.size() == 0) {
            this.view.showEmpty();
        } else {
            this.view.hideEmpty();
        }
        this.view.convertRemoconReservationData(list);
    }

    public void convertRemoconReservationData(List<AirconReservationItem> list) {
        ArrayList arrayList = new ArrayList();
        for (AirconReservationItem airconReservationItem : list) {
            Remocon.RemoconReservation remoconReservation = new Remocon.RemoconReservation(airconReservationItem.getWeek_time(), airconReservationItem.getTitle(), airconReservationItem.getTime(), airconReservationItem.getIs_enabled(), airconReservationItem.getTag(), getIrIdList(airconReservationItem.getIr_id_list()));
            getDayOfWeek(remoconReservation, airconReservationItem.getWeek());
            remoconReservation.hour = getHour(airconReservationItem.getWeek_time());
            remoconReservation.min = getMin(airconReservationItem.getWeek_time());
            arrayList.add(remoconReservation);
        }
        this.view.setRemoconReservations(arrayList);
    }

    private String getTitle(String str) {
        return (str == null || str.length() <= 0) ? IOUtil.getStringResource(R.string.reservation_default_title) : str;
    }

    private String getDateTime(String str) {
        if (str == null || str.length() <= 0) {
            return IOUtil.getStringResource(R.string.reservation_default_date_time);
        }
        return convertTimeFormat(str);
    }

    private int getHour(String str) {
        return Integer.parseInt(str.substring(7, 9));
    }

    private int getMin(String str) {
        return Integer.parseInt(str.substring(9));
    }

    private void getDayOfWeek(Remocon.RemoconReservation remoconReservation, String str) {
        if (str == null || str.length() <= 0) {
            return;
        }
        if (str.charAt(0) == '1') {
            remoconReservation.mon = true;
        } else {
            remoconReservation.mon = false;
        }
        if (str.charAt(1) == '1') {
            remoconReservation.tue = true;
        } else {
            remoconReservation.tue = false;
        }
        if (str.charAt(2) == '1') {
            remoconReservation.wed = true;
        } else {
            remoconReservation.wed = false;
        }
        if (str.charAt(3) == '1') {
            remoconReservation.thu = true;
        } else {
            remoconReservation.thu = false;
        }
        if (str.charAt(4) == '1') {
            remoconReservation.fri = true;
        } else {
            remoconReservation.fri = false;
        }
        if (str.charAt(5) == '1') {
            remoconReservation.sat = true;
        } else {
            remoconReservation.sat = false;
        }
        if (str.charAt(6) == '1') {
            remoconReservation.sun = true;
        } else {
            remoconReservation.sun = false;
        }
    }

    public List<String> getIrIdList(List<String> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    public static String convertTimeFormat(String str) {
        if (str == null || str.length() < 1) {
            return null;
        }
        try {
            return new SimpleDateFormat("HH:mm").format(new SimpleDateFormat("HHmm").parse(str));
        } catch (ParseException e) {
            e.printStackTrace();
            return str;
        }
    }

    public void removeReservation(Remocon.RemoconReservation remoconReservation) {
        if (LinkerHandler.getInstance().getAliveLinkers().size() > 0) {
            this.deleteReservationInteractor.requestDeleteReservation(IOUtil.makeBackendMacAddressFormat(LinkerHandler.getInstance().getAliveLinkers().get(0).getMacAddress()), remoconReservation.weekTime);
        }
    }

    public void onCheckedChange(Remocon.RemoconReservation remoconReservation, String str) {
        remoconReservation.isEnabled = str;
        this.deleteReservationInteractor.requestChangeReservationData(remoconReservation, IOUtil.makeBackendMacAddressFormat((LinkerHandler.getInstance().getAliveLinkers().size() > 0 ? LinkerHandler.getInstance().getAliveLinkers().get(0) : null).getMacAddress()), remoconReservation.weekTime);
    }

    public void onChangeReservationDataSuccess(Remocon.RemoconReservation remoconReservation, String str, String str2) {
        this.sendReservationToServerInteractor.requestPostToServer(str2, str, remoconReservation);
    }
}
