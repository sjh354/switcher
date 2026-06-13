package kr.switcher.switcherm.ui.setting.presenter;

import java.util.List;
import kr.switcher.device.checker.Checker;
import kr.switcher.switcherm.ui.setting.adapter.CheckerHistoryItem;
import kr.switcher.switcherm.ui.setting.interactor.FindRecentCheckerHistoryInteractor;
import kr.switcher.switcherm.ui.setting.view.CheckerHistoryView;

/* JADX INFO: loaded from: classes2.dex */
public class CheckerHistoryPresenter {
    private FindRecentCheckerHistoryInteractor interactor;
    private CheckerHistoryView view;

    public CheckerHistoryPresenter(CheckerHistoryView checkerHistoryView, FindRecentCheckerHistoryInteractor findRecentCheckerHistoryInteractor) {
        this.view = checkerHistoryView;
        this.interactor = findRecentCheckerHistoryInteractor;
    }

    public void onFindHistories(List<CheckerHistoryItem> list) {
        if (list.size() == 0) {
            this.view.showNoSearchComment();
        } else {
            this.view.setCheckerHistoryItems(list);
        }
    }

    public void onNextPageHistories(List<CheckerHistoryItem> list) {
        if (list.size() > 0) {
            this.view.addNextCheckerHistoryItems(list);
        }
    }

    public void onResume(Checker checker) {
        this.view.initRecyclerListView();
        this.view.oneWeekBtnChange();
        this.interactor.findRecentCheckerHistory(checker, 7);
    }

    public void onOneWeekBtnClicked(Checker checker) {
        this.view.oneWeekBtnChange();
        this.interactor.findRecentCheckerHistory(checker, 7);
    }

    public void onOneMonthBtnClicked(Checker checker) {
        this.view.oneMonthBtnChange();
        this.interactor.findRecentCheckerHistory(checker, 30);
    }

    public void onHalfYearBtnClicked(Checker checker) {
        this.view.halfYearBtnChange();
        this.interactor.findRecentCheckerHistory(checker, 180);
    }

    public void onBottomReached() {
        this.interactor.findNextPageHistory();
    }
}
