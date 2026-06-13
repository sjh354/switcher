package kr.switcher.switcherm.ui.irbrand.presenter;

import kr.switcher.switcherm.common.activity.IOActivity;
import kr.switcher.switcherm.ui.irbrand.fragment.IRBrandListFragment;
import kr.switcher.switcherm.ui.irbrand.view.IRBrandView;

/* JADX INFO: loaded from: classes2.dex */
public class IRBrandPresenter {
    private IRBrandView view;

    public IRBrandPresenter(IRBrandView iRBrandView) {
        this.view = iRBrandView;
    }

    public void onPreviousButtonClicked(IOActivity iOActivity) {
        if (((IRBrandListFragment) iOActivity.getSupportFragmentManager().findFragmentByTag("IRBrandListFragment")) == null) {
            this.view.finishActivity();
        } else {
            this.view.moveProductSelectFragment();
        }
    }
}
