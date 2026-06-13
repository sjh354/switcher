package kr.switcher.switcherm.service.widget;

import java.util.List;
import kr.switcher.device.IODevice;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.preference.WidgetCheckerPreference;
import kr.switcher.switcherm.preference.WidgetPreference;
import kr.switcher.switcherm.ui.main.interactors.GetCheckerIsOpenInteractor;
import kr.switcher.switcherm.ui.setting.adapter.CheckerHistoryItem;
import kr.switcher.switcherm.ui.setting.adapter.CheckerSurveillanceItem;
import kr.switcher.switcherm.ui.setting.interactor.FindRecentCheckerHistoryInteractor;
import kr.switcher.switcherm.ui.widget.interactor.GetCheckerSurveillanceInfoForWidgetInteractor;

/* JADX INFO: loaded from: classes2.dex */
public class WidgetCheckerService {
    private static final String TAG = "WidgetCheckerService";
    private int checkerCommand;
    private IODevice ioDevice;
    private String CHECKER_REFRESH_COMMAND = "REFRESH";
    public String TYPE_OPEN = "TYPE_OPEN";
    public String TYPE_CLOSE = "TYPE_CLOSE";
    public String TYPE_OPEN_WIDGET = "마지막 열림 시각";
    public String TYPE_CLOSE_WIDGET = "마지막 닫힘 시각";

    public WidgetCheckerService(IODevice iODevice, int i) {
        this.ioDevice = iODevice;
        this.checkerCommand = i;
    }

    public void refreshWidget() {
        getCheckerData(IOUtil.makeBackendMacAddressFormat(this.ioDevice.getMacAddress()), new WidgetPreference().getWidgetId(this.ioDevice.getMacAddress()));
    }

    public void getCheckerData(final String str, final int i) {
        IOLog.i(TAG, "GET CHECKER DATA");
        new GetCheckerSurveillanceInfoForWidgetInteractor().getCheckerSurveillanceInfo(str, new GetCheckerSurveillanceInfoForWidgetInteractor.OnGetCheckerSurveillanceListener() { // from class: kr.switcher.switcherm.service.widget.WidgetCheckerService.1
            @Override // kr.switcher.switcherm.ui.widget.interactor.GetCheckerSurveillanceInfoForWidgetInteractor.OnGetCheckerSurveillanceListener
            public void onFind(List<CheckerSurveillanceItem> list) {
                int iIntValue = Integer.valueOf(IOUtil.getCurrentDateTimehhmm()).intValue();
                String currentDayOfWeek = IOUtil.getCurrentDayOfWeek();
                String str2 = "False";
                int i2 = 0;
                for (CheckerSurveillanceItem checkerSurveillanceItem : list) {
                    if (WidgetCheckerService.this.checkDayOfWeek(currentDayOfWeek, checkerSurveillanceItem.weekDays).booleanValue() && iIntValue > Integer.valueOf(checkerSurveillanceItem.startAt.substring(0, 4)).intValue() && iIntValue < Integer.valueOf(checkerSurveillanceItem.endAt.substring(0, 4)).intValue()) {
                        str2 = checkerSurveillanceItem.isActive;
                        i2 = checkerSurveillanceItem.level;
                    }
                }
                new WidgetCheckerPreference().setWidgetCheckerSurveillanceIsActive(i, str2);
                if (str2.equals("True")) {
                    new WidgetCheckerPreference().setWidgetCheckerSurveillanceLevel(i, i2);
                }
                WidgetCheckerService.this.getCheckerHistoryData(str, i);
            }
        });
    }

    public void getCheckerHistoryData(final String str, final int i) {
        new FindRecentCheckerHistoryInteractor().findRecentCheckerHistoryForWidget(str, new FindRecentCheckerHistoryInteractor.OnFindRecentCheckerHistoryListener() { // from class: kr.switcher.switcherm.service.widget.WidgetCheckerService.2
            @Override // kr.switcher.switcherm.ui.setting.interactor.FindRecentCheckerHistoryInteractor.OnFindRecentCheckerHistoryListener
            public void onFindNextPageHistories(List<CheckerHistoryItem> list) {
            }

            @Override // kr.switcher.switcherm.ui.setting.interactor.FindRecentCheckerHistoryInteractor.OnFindRecentCheckerHistoryListener
            public void onFindHistories(List<CheckerHistoryItem> list) {
                if (list != null) {
                    CheckerHistoryItem checkerHistoryItem = list.get(0);
                    WidgetCheckerPreference widgetCheckerPreference = new WidgetCheckerPreference();
                    if (checkerHistoryItem.getTransition_type().equals(WidgetCheckerService.this.TYPE_OPEN)) {
                        widgetCheckerPreference.setWidgetCheckerLastHistoryIsOpened(i, WidgetCheckerService.this.TYPE_OPEN_WIDGET);
                    } else if (checkerHistoryItem.getTransition_type().equals(WidgetCheckerService.this.TYPE_CLOSE)) {
                        widgetCheckerPreference.setWidgetCheckerLastHistoryIsOpened(i, WidgetCheckerService.this.TYPE_CLOSE_WIDGET);
                    }
                    String strReplace = checkerHistoryItem.getCreated_at().substring(5, 10).replace('-', '/');
                    String strSubstring = checkerHistoryItem.getCreated_at().substring(11, 16);
                    widgetCheckerPreference.setWidgetCheckerLastHistoryDate(i, strReplace);
                    widgetCheckerPreference.setWidgetCheckerLastHistoryTime(i, strSubstring);
                }
                WidgetCheckerService.this.getCheckerIsOpenData(str, i);
            }
        });
    }

    public void getCheckerIsOpenData(String str, final int i) {
        new GetCheckerIsOpenInteractor().getCheckerInfoForWidget(str, new GetCheckerIsOpenInteractor.OnGetCheckerInfoListener() { // from class: kr.switcher.switcherm.service.widget.WidgetCheckerService.3
            @Override // kr.switcher.switcherm.ui.main.interactors.GetCheckerIsOpenInteractor.OnGetCheckerInfoListener
            public void onGetCheckerInfo(String str2) {
                new WidgetCheckerPreference().setWidgetCheckerBattery(i, str2);
                new WidgetCheckerPreference().setWidgetCheckerRefreshFinished(i, "true");
                IOUtil.sendBroadcastToCheckerWidget();
            }
        });
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
