package kr.switcher.switcherm.ui.setting.view;

import java.util.List;
import kr.switcher.device.switcher.Switcher;

/* JADX INFO: loaded from: classes2.dex */
public interface ReservationListView {
    void addReservationItems(List<Switcher.SwitcherReservation> list);

    void disableProgressbar();

    void initRecyclerListView();

    void moveReservationFragment(int i);

    void onReservationSize(int i);

    void requestGetReservationList(Switcher switcher);

    void setReservations(List<Switcher.SwitcherReservation> list);

    void showCanNotLoaded();

    void showEmpty();

    void showProgressbar();

    void showReservationList();

    void signal();

    void timeoutLoading();
}
