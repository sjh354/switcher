package kr.switcher.switcherm.ui.widget.presenter;

import java.util.List;
import kr.switcher.device.switcher.Switcher;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.ui.switcherList.helper.SwitcherListItemFactory;
import kr.switcher.switcherm.ui.widget.interactor.FindSwitcherForWidgetInteractor;
import kr.switcher.switcherm.ui.widget.view.OneButtonWidgetSelectView;

/* JADX INFO: loaded from: classes2.dex */
public class OneButtonWidgetSelectPresenter {
    private FindSwitcherForWidgetInteractor interactor;
    private OneButtonWidgetSelectView view;

    public OneButtonWidgetSelectPresenter(OneButtonWidgetSelectView oneButtonWidgetSelectView, FindSwitcherForWidgetInteractor findSwitcherForWidgetInteractor) {
        this.view = oneButtonWidgetSelectView;
        this.interactor = findSwitcherForWidgetInteractor;
    }

    public void onResume() {
        FindSwitcherForWidgetInteractor findSwitcherForWidgetInteractor = this.interactor;
        findSwitcherForWidgetInteractor.getOneButtonSwitcherList(findSwitcherForWidgetInteractor.createSwitcherList());
    }

    public void onFoundSwitcherList(List<Switcher> list) {
        this.view.setRecyclerView(SwitcherListItemFactory.createWidgetList(list));
    }

    public void onItemClick(String str, boolean z) {
        if (z) {
            this.view.showMessage(IOUtil.getStringResource(R.string.already_added_widget));
        } else {
            this.view.addWidget(str);
        }
    }
}
