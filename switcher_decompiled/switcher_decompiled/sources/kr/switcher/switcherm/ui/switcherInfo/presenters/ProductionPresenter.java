package kr.switcher.switcherm.ui.switcherInfo.presenters;

import android.os.Handler;
import kr.switcher.device.common.DeviceUtil;
import kr.switcher.switcherm.common.util.IODeviceIconMaker;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.ui.dialog.ConfirmCallback;
import kr.switcher.switcherm.ui.switcherInfo.helper.SwitcherInfoHelper;
import kr.switcher.switcherm.ui.switcherInfo.interactors.ChangeModelTypeInteractor;
import kr.switcher.switcherm.ui.switcherInfo.interactors.FindRequestInteractor;
import kr.switcher.switcherm.ui.switcherInfo.views.ProductionView;
import kr.switcher.switcherm.user.Preparing;
import kr.switcher.switcherm.user.User;

/* JADX INFO: loaded from: classes2.dex */
public class ProductionPresenter implements FindRequestInteractor.OnGetPreparingListener, ConfirmCallback, ChangeModelTypeInteractor.OnChangeResultListener {
    private ChangeModelTypeInteractor changeInteractor;
    private String currentDate;
    private FindRequestInteractor findInteractor;
    private ProductionView view;
    private final int CHANGE_TIMEOUT = 4000;
    private final int END_DAY = 1;
    private SwitcherInfoHelper helper = new SwitcherInfoHelper();

    public void change() {
    }

    public boolean checkEnableChange(Preparing preparing) {
        return false;
    }

    @Override // kr.switcher.switcherm.ui.switcherInfo.interactors.ChangeModelTypeInteractor.OnChangeResultListener
    public void onChangeResult(boolean z) {
    }

    @Override // kr.switcher.switcherm.ui.dialog.ConfirmCallback
    public void onConfirmResult(boolean z) {
    }

    @Override // kr.switcher.switcherm.ui.switcherInfo.interactors.FindRequestInteractor.OnGetPreparingListener
    public void onPreparing(Preparing preparing) {
    }

    public ProductionPresenter(ProductionView productionView, User user, FindRequestInteractor findRequestInteractor, ChangeModelTypeInteractor changeModelTypeInteractor) {
        this.view = productionView;
        this.findInteractor = findRequestInteractor;
        this.changeInteractor = changeModelTypeInteractor;
        setCurrentDate(IOUtil.getCurrentDateTime());
        productionView.setName(user.getUserName());
        productionView.setPhoneNumber(user.getPhoneNumber());
    }

    public void onCreateView(Preparing preparing) {
        this.view.setSwitcherImage(IODeviceIconMaker.makeInfoIcon(preparing.getProductId(), ""));
        this.view.setSwitcherType(DeviceUtil.getDefaultDeviceName(preparing.getProductId()));
        this.findInteractor.findPreparing(preparing.getFreeTrialId(), this);
        this.view.hideProgressbar();
    }

    public void setCurrentDate(String str) {
        this.currentDate = str;
    }

    private void timeoutChange() {
        new Handler().postDelayed(new Runnable() { // from class: kr.switcher.switcherm.ui.switcherInfo.presenters.ProductionPresenter.1
            @Override // java.lang.Runnable
            public void run() {
                ProductionPresenter.this.view.hideProgressbar();
            }
        }, 4000L);
    }
}
