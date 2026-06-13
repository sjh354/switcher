package kr.switcher.switcherm.ui.switcherInfo.presenters;

import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.ui.switcherInfo.views.BuyingTypeChangeView;

/* JADX INFO: loaded from: classes2.dex */
public class BuyingTypeChangePresenter {
    private BuyingTypeChangeView view;

    public BuyingTypeChangePresenter(BuyingTypeChangeView buyingTypeChangeView) {
        this.view = buyingTypeChangeView;
    }

    public void onCreateView(int i) {
        this.view.trackPlanChangeForGA();
        if (i == 1) {
            checkLease();
        } else if (i == 2) {
            checkWholesale();
        } else {
            this.view.showMessage(IOUtil.getStringResource(R.string.not_support_buying_type));
        }
    }

    private void checkLease() {
        this.view.checkLease();
        this.view.unCheckWholesale();
    }

    private void checkWholesale() {
        this.view.checkWholesale();
        this.view.unCheckLease();
    }

    public void leaseCheckboxChecked() {
        checkLease();
    }

    public void wholesaleCheckboxChecked() {
        checkWholesale();
    }
}
