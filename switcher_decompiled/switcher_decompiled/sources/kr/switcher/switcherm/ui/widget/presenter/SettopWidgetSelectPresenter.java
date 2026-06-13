package kr.switcher.switcherm.ui.widget.presenter;

import java.util.List;
import kr.switcher.device.remocon.Remocon;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.ui.switcherList.helper.SwitcherListItemFactory;
import kr.switcher.switcherm.ui.widget.interactor.FindRemoconForWidgetInteractor;
import kr.switcher.switcherm.ui.widget.view.SettopWidgetSelectView;

/* JADX INFO: loaded from: classes2.dex */
public class SettopWidgetSelectPresenter {
    private static final int CONTROLLER_ID_SET_TOP_BOX = 3;
    private static final String TAG = "SettopWidgetSelectPresenter";
    private FindRemoconForWidgetInteractor interactor;
    private SettopWidgetSelectView view;

    public SettopWidgetSelectPresenter(SettopWidgetSelectView settopWidgetSelectView, FindRemoconForWidgetInteractor findRemoconForWidgetInteractor) {
        this.view = settopWidgetSelectView;
        this.interactor = findRemoconForWidgetInteractor;
    }

    public void onResume() {
        this.interactor.getRemoconList(3);
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
}
