package kr.switcher.switcherm.ui.widget.presenter;

import java.util.List;
import kr.switcher.device.remocon.Remocon;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.preference.WidgetPreference;
import kr.switcher.switcherm.ui.switcherList.helper.SwitcherListItemFactory;
import kr.switcher.switcherm.ui.widget.interactor.FindRemoconForWidgetInteractor;
import kr.switcher.switcherm.ui.widget.view.AirconWidgetSelectView;

/* JADX INFO: loaded from: classes2.dex */
public class AirconWidgetSelectPresenter {
    private static final int CONTROLLER_ID_AIRCON = 2;
    private FindRemoconForWidgetInteractor interactor;
    private AirconWidgetSelectView view;

    public AirconWidgetSelectPresenter(AirconWidgetSelectView airconWidgetSelectView, FindRemoconForWidgetInteractor findRemoconForWidgetInteractor) {
        this.view = airconWidgetSelectView;
        this.interactor = findRemoconForWidgetInteractor;
    }

    public void onResume() {
        this.interactor.getRemoconList(2);
    }

    public void onFoundRemoconList(List<Remocon> list) {
        this.view.setRecyclerView(SwitcherListItemFactory.createRemconWidgetList(list));
    }

    public void onItemClick(String str, boolean z) {
        if (z) {
            this.view.showMessage(IOUtil.getStringResource(R.string.already_added_remocon_widget));
        } else {
            this.view.addWidget(str);
        }
    }

    public void onFind(int i, String str) {
        new WidgetPreference().setWidgetLinkerTemperature(i, str);
        this.view.sendBroadcastToWidget();
    }
}
