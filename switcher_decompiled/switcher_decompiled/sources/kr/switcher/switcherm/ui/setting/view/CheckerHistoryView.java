package kr.switcher.switcherm.ui.setting.view;

import java.util.List;
import kr.switcher.switcherm.ui.setting.adapter.CheckerHistoryItem;

/* JADX INFO: loaded from: classes2.dex */
public interface CheckerHistoryView {
    void addNextCheckerHistoryItems(List<CheckerHistoryItem> list);

    void halfYearBtnChange();

    void hideProgressBar();

    void initRecyclerListView();

    void oneMonthBtnChange();

    void oneWeekBtnChange();

    void setCheckerHistoryItems(List<CheckerHistoryItem> list);

    void showNoSearchComment();

    void showProgressBar(int i);
}
