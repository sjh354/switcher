package kr.switcher.switcherm.ui.switcherInfo.presenters;

import kr.switcher.device.IODevice;
import kr.switcher.device.common.DeviceUtil;
import kr.switcher.switcherm.common.util.IODeviceIconMaker;
import kr.switcher.switcherm.ui.switcherInfo.interactors.FindSwitcherInfoInteractor;
import kr.switcher.switcherm.ui.switcherInfo.views.WholesaleFreeView;

/* JADX INFO: loaded from: classes2.dex */
public class WholesaleFreePresenter implements FindSwitcherInfoInteractor.OnGetSwitcherInfoListener {
    private FindSwitcherInfoInteractor interactor;
    private WholesaleFreeView view;

    public WholesaleFreePresenter(WholesaleFreeView wholesaleFreeView, FindSwitcherInfoInteractor findSwitcherInfoInteractor) {
        this.view = wholesaleFreeView;
        this.interactor = findSwitcherInfoInteractor;
    }

    public void onResume(IODevice iODevice) {
        this.view.trackWholesaleFreeForGA();
        this.view.setSwitcherImage(IODeviceIconMaker.makeInfoIcon(iODevice.getProductId(), iODevice.getMacAddress()));
        this.view.setSwitcherType("'" + DeviceUtil.getDefaultDeviceName(iODevice) + "'");
        this.view.setRoomName(iODevice.getName());
        this.view.setOwnerName(iODevice.getOwner());
        this.view.setPKey(iODevice.getSerialNumber());
        this.view.setShareCode(iODevice.getShareCode());
        this.view.setFirstPaymentAt("2018년 4월 16일");
        this.interactor.requestSwitcherDetails(this);
    }

    @Override // kr.switcher.switcherm.ui.switcherInfo.interactors.FindSwitcherInfoInteractor.OnGetSwitcherInfoListener
    public void onGetSwitcherInfoResult(IODevice iODevice, String str, String str2, String str3, String str4, String str5) {
        this.view.setPaymentCard(str);
    }
}
