package kr.switcher.switcherm.ui.setting.presenter;

import java.util.ArrayList;
import java.util.List;
import kr.switcher.device.checker.Checker;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.ui.setting.adapter.CheckerSurveillanceItem;
import kr.switcher.switcherm.ui.setting.interactor.DeleteSurveillanceInteractor;
import kr.switcher.switcherm.ui.setting.interactor.FindCheckerSurveillanceListInteractor;
import kr.switcher.switcherm.ui.setting.interactor.ModifyCheckerSurveillanceInteractor;
import kr.switcher.switcherm.ui.setting.view.CheckerSurveillanceListView;

/* JADX INFO: loaded from: classes2.dex */
public class CheckerSurveillanceListPresenter {
    private static final String TAG = "CheckerSurveillanceListPresenter";
    private DeleteSurveillanceInteractor deleteInteractor;
    private FindCheckerSurveillanceListInteractor interactor;
    private String macAddress;
    private ModifyCheckerSurveillanceInteractor modifyInteractor;
    private CheckerSurveillanceListView view;

    public CheckerSurveillanceListPresenter(CheckerSurveillanceListView checkerSurveillanceListView, FindCheckerSurveillanceListInteractor findCheckerSurveillanceListInteractor, ModifyCheckerSurveillanceInteractor modifyCheckerSurveillanceInteractor, DeleteSurveillanceInteractor deleteSurveillanceInteractor) {
        this.view = checkerSurveillanceListView;
        this.interactor = findCheckerSurveillanceListInteractor;
        this.modifyInteractor = modifyCheckerSurveillanceInteractor;
        this.deleteInteractor = deleteSurveillanceInteractor;
    }

    public void onCreateView() {
        this.view.showProgressbar();
        this.view.timeoutLoading();
    }

    public void onResume(String str) {
        this.macAddress = str;
        this.view.initRecyclerListView();
        this.interactor.requestGetCheckersSurveillance(str);
    }

    public void timeout(boolean z) {
        if (z) {
            this.view.disableProgressbar();
            this.view.showCanNotLoaded();
            IOLog.i(TAG, "timeout refresh timer");
        }
    }

    public void onRefresh(String str) {
        this.view.timeoutLoading();
        onResume(str);
    }

    public void onItemClick(boolean z, int i) {
        if (z) {
            return;
        }
        this.view.moveCheckerSurveillanceFragment(i);
    }

    public void convertCheckerSurveillanceData(List<CheckerSurveillanceItem> list) {
        ArrayList arrayList = new ArrayList();
        for (CheckerSurveillanceItem checkerSurveillanceItem : list) {
            Checker.Surveillance surveillance = new Checker.Surveillance(checkerSurveillanceItem.id, checkerSurveillanceItem.title, checkerSurveillanceItem.level, checkerSurveillanceItem.isActive, checkerSurveillanceItem.trespass_duration_min, checkerSurveillanceItem.alarm_duration_min, checkerSurveillanceItem.weekDays, checkerSurveillanceItem.startAt, checkerSurveillanceItem.endAt, checkerSurveillanceItem.createdAt);
            getDayOfWeek(surveillance, checkerSurveillanceItem.weekDays);
            surveillance.startHour = getHour(checkerSurveillanceItem.startAt);
            surveillance.endHour = getHour(checkerSurveillanceItem.endAt);
            surveillance.startMin = getMin(checkerSurveillanceItem.startAt);
            surveillance.endMin = getMin(checkerSurveillanceItem.endAt);
            arrayList.add(surveillance);
        }
        this.view.setCheckerSurveillance(arrayList);
    }

    public void onCheckedChange(Checker.Surveillance surveillance, String str) {
        if (str.equals("true")) {
            surveillance.isActive = "True";
        } else {
            surveillance.isActive = "False";
        }
        this.modifyInteractor.requestPutCheckersSurveillance(this.macAddress, surveillance);
    }

    private void getDayOfWeek(Checker.Surveillance surveillance, String str) {
        if (str == null || str.length() <= 0) {
            return;
        }
        if (str.charAt(0) == '1') {
            surveillance.mon = true;
        } else {
            surveillance.mon = false;
        }
        if (str.charAt(1) == '1') {
            surveillance.tue = true;
        } else {
            surveillance.tue = false;
        }
        if (str.charAt(2) == '1') {
            surveillance.wed = true;
        } else {
            surveillance.wed = false;
        }
        if (str.charAt(3) == '1') {
            surveillance.thu = true;
        } else {
            surveillance.thu = false;
        }
        if (str.charAt(4) == '1') {
            surveillance.fri = true;
        } else {
            surveillance.fri = false;
        }
        if (str.charAt(5) == '1') {
            surveillance.sat = true;
        } else {
            surveillance.sat = false;
        }
        if (str.charAt(6) == '1') {
            surveillance.sun = true;
        } else {
            surveillance.sun = false;
        }
    }

    private int getMin(String str) {
        return Integer.parseInt(str.substring(2, 4));
    }

    private int getHour(String str) {
        return Integer.parseInt(str.substring(0, 2));
    }

    public void onFindCheckerSurveillance(List<CheckerSurveillanceItem> list) {
        if (list.size() == 0) {
            this.view.showEmpty();
        } else {
            this.view.hideEmpty();
        }
        convertCheckerSurveillanceData(list);
    }

    public void deleteButtonClicked(String str, Checker.Surveillance surveillance) {
        this.deleteInteractor.requestDeleteCheckersSurveillance(str, String.valueOf(surveillance.id));
    }
}
