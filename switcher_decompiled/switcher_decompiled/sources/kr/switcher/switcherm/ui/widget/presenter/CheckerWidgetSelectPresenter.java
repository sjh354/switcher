package kr.switcher.switcherm.ui.widget.presenter;

import java.util.List;
import kr.switcher.device.checker.Checker;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.preference.WidgetCheckerPreference;
import kr.switcher.switcherm.ui.setting.adapter.CheckerHistoryItem;
import kr.switcher.switcherm.ui.setting.adapter.CheckerSurveillanceItem;
import kr.switcher.switcherm.ui.switcherList.helper.SwitcherListItemFactory;
import kr.switcher.switcherm.ui.widget.interactor.FindCheckerForWidgetInteractor;
import kr.switcher.switcherm.ui.widget.view.CheckerWidgetSelectView;

/* JADX INFO: loaded from: classes2.dex */
public class CheckerWidgetSelectPresenter {
    private static final String TAG = "CheckerWidgetSelectPresenter";
    private FindCheckerForWidgetInteractor interactor;
    private CheckerWidgetSelectView view;
    public String TYPE_OPEN = "TYPE_OPEN";
    public String TYPE_CLOSE = "TYPE_CLOSE";
    public String TYPE_OPEN_WIDGET = "마지막 열림 시각";
    public String TYPE_CLOSE_WIDGET = "마지막 닫힘 시각";

    public CheckerWidgetSelectPresenter(CheckerWidgetSelectView checkerWidgetSelectView, FindCheckerForWidgetInteractor findCheckerForWidgetInteractor) {
        this.view = checkerWidgetSelectView;
        this.interactor = findCheckerForWidgetInteractor;
    }

    public void onResume() {
        FindCheckerForWidgetInteractor findCheckerForWidgetInteractor = this.interactor;
        findCheckerForWidgetInteractor.getCheckerList(findCheckerForWidgetInteractor.createCheckerList());
    }

    public void onFoundCheckerList(List<Checker> list) {
        this.view.setRecyclerView(SwitcherListItemFactory.createChecherWidgetList(list));
    }

    public void onItemClick(String str, boolean z) {
        if (z) {
            this.view.showMessage(IOUtil.getStringResource(R.string.already_added_checker_widget));
        } else {
            this.view.addWidget(str);
        }
    }

    public void onFind(int i, List<CheckerSurveillanceItem> list) {
        int iIntValue = Integer.valueOf(IOUtil.getCurrentDateTimehhmm()).intValue();
        String currentDayOfWeek = IOUtil.getCurrentDayOfWeek();
        String str = "False";
        int i2 = 0;
        for (CheckerSurveillanceItem checkerSurveillanceItem : list) {
            if (checkDayOfWeek(currentDayOfWeek, checkerSurveillanceItem.weekDays).booleanValue() && iIntValue > Integer.valueOf(checkerSurveillanceItem.startAt.substring(0, 4)).intValue() && iIntValue < Integer.valueOf(checkerSurveillanceItem.endAt.substring(0, 4)).intValue()) {
                str = checkerSurveillanceItem.isActive;
                i2 = checkerSurveillanceItem.level;
            }
        }
        new WidgetCheckerPreference().setWidgetCheckerSurveillanceIsActive(i, str);
        if (str.equals("True")) {
            new WidgetCheckerPreference().setWidgetCheckerSurveillanceLevel(i, i2);
        }
        IOUtil.sendBroadcastToCheckerWidget();
    }

    public void onFindHistories(int i, List<CheckerHistoryItem> list) {
        if (list != null) {
            CheckerHistoryItem checkerHistoryItem = list.get(0);
            WidgetCheckerPreference widgetCheckerPreference = new WidgetCheckerPreference();
            if (checkerHistoryItem.getTransition_type().equals(this.TYPE_OPEN)) {
                widgetCheckerPreference.setWidgetCheckerLastHistoryIsOpened(i, this.TYPE_OPEN_WIDGET);
            } else if (checkerHistoryItem.getTransition_type().equals(this.TYPE_CLOSE)) {
                widgetCheckerPreference.setWidgetCheckerLastHistoryIsOpened(i, this.TYPE_CLOSE_WIDGET);
            }
            String strReplace = checkerHistoryItem.getCreated_at().substring(5, 10).replace('-', '/');
            String strSubstring = checkerHistoryItem.getCreated_at().substring(11, 16);
            widgetCheckerPreference.setWidgetCheckerLastHistoryDate(i, strReplace);
            widgetCheckerPreference.setWidgetCheckerLastHistoryTime(i, strSubstring);
            this.view.sendBroadcastToWidget();
        }
    }

    public void onGetCheckerInfo(int i, String str) {
        new WidgetCheckerPreference().setWidgetCheckerBattery(i, str);
        this.view.sendBroadcastToWidget();
    }

    public Boolean checkDayOfWeek(String str, String str2) {
        int i;
        str.hashCode();
        i = 6;
        switch (str) {
            case "금":
                i = 4;
                break;
            case "목":
                i = 3;
                break;
            case "수":
                i = 2;
                break;
            case "월":
                i = 0;
                break;
            case "일":
                break;
            case "토":
                i = 5;
                break;
            case "화":
                i = 1;
                break;
            default:
                i = -1;
                break;
        }
        if (str2.charAt(i) == '1') {
            return true;
        }
        return false;
    }
}
