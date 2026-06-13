package kr.switcher.switcherm.ui.switcherInfo.presenters;

import kr.switcher.device.IODevice;
import kr.switcher.device.switcher.Switcher;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.device.switcher.handler.SwitcherHandler;
import kr.switcher.switcherm.ui.switcherInfo.helper.SwitcherInfoHelper;
import kr.switcher.switcherm.ui.switcherInfo.interactors.FindSwitcherInfoInteractor;
import kr.switcher.switcherm.ui.switcherInfo.views.SwitcherInfoMainView;
import kr.switcher.switcherm.user.User;

/* JADX INFO: loaded from: classes2.dex */
public class SwitcherInfoMainPresenter implements FindSwitcherInfoInteractor.OnGetSwitcherInfoListener {
    private SwitcherInfoHelper helper;
    private FindSwitcherInfoInteractor interactor;
    private User user;
    private SwitcherInfoMainView view;

    public SwitcherInfoMainPresenter(SwitcherInfoMainView switcherInfoMainView, User user, FindSwitcherInfoInteractor findSwitcherInfoInteractor, SwitcherInfoHelper switcherInfoHelper) {
        this.view = switcherInfoMainView;
        this.user = user;
        this.interactor = findSwitcherInfoInteractor;
        this.helper = switcherInfoHelper;
    }

    public void initialize(String str) {
        Switcher switcher = SwitcherHandler.getInstance().getSwitcher(str);
        if (switcher == null) {
            this.view.showErrorMessage(IOUtil.getStringResource(R.string.not_found_switcher));
            return;
        }
        this.view.initViewModel(switcher.getProductId());
        this.view.viewData(switcher, "", "", "", "", "");
        setInfo(switcher);
    }

    public void setInfo(String str) {
        Switcher switcher = SwitcherHandler.getInstance().getSwitcher(str);
        if (switcher == null) {
            this.view.showErrorMessage(IOUtil.getStringResource(R.string.not_found_switcher));
        } else {
            setInfo(switcher);
        }
    }

    private void setInfo(IODevice iODevice) {
        this.view.setWhoAmI(iODevice.isMine());
        if (iODevice.isMine()) {
            onGetSwitcherInfoResult(iODevice, "", iODevice.getOption().getPaymentInfo().getNextPayAt(), IOUtil.convertPaymentTypeName(iODevice.getOption().getPaymentInfo().getPaymentMethod()), "", "");
            this.interactor.requestSwitcherDetails(this);
        }
    }

    @Override // kr.switcher.switcherm.ui.switcherInfo.interactors.FindSwitcherInfoInteractor.OnGetSwitcherInfoListener
    public void onGetSwitcherInfoResult(IODevice iODevice, String str, String str2, String str3, String str4, String str5) {
        this.view.viewData(iODevice, str, str2, str3, str4, str5);
    }
}
