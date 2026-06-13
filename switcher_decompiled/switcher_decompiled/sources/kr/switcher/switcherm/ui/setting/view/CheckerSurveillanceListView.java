package kr.switcher.switcherm.ui.setting.view;

import java.util.List;
import kr.switcher.device.checker.Checker;
import kr.switcher.switcherm.ui.setting.adapter.CheckerSurveillanceItem;

/* JADX INFO: loaded from: classes2.dex */
public interface CheckerSurveillanceListView {
    void convertCheckerSurveillanceData(List<CheckerSurveillanceItem> list);

    void disableProgressbar();

    void hideEmpty();

    void initRecyclerListView();

    void moveCheckerSurveillanceFragment(int i);

    void onReservationSize(int i);

    void setCheckerSurveillance(List<Checker.Surveillance> list);

    void showCanNotLoaded();

    void showDeleteDialog(int i);

    void showEmpty();

    void showProgressbar();

    void showReservationList();

    void timeoutLoading();
}
