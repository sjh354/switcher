package kr.switcher.switcherm.ui.switcherInfo.presenters;

import kr.switcher.device.IODevice;
import kr.switcher.switcherm.common.util.IODeviceIconMaker;
import kr.switcher.switcherm.ui.switcherInfo.views.DeliveryView;
import kr.switcher.switcherm.user.User;

/* JADX INFO: loaded from: classes2.dex */
public class DeliveryPresenter {
    private DeliveryView view;

    public DeliveryPresenter(DeliveryView deliveryView) {
        this.view = deliveryView;
    }

    public void initialize(IODevice iODevice, User user) {
        this.view.trackDeliveryForGA();
        this.view.setSwitcherImage(IODeviceIconMaker.makeInfoIcon(iODevice.getProductId(), iODevice.getMacAddress()));
        this.view.setSwitcherName(iODevice.getName());
        this.view.setName(user.getUserName());
        this.view.setPKey(iODevice.getSerialNumber());
        this.view.setPhoneNumber(user.getPhoneNumber());
        this.view.setAddress1(user.getAddress1());
        this.view.setAddress2(user.getAddress2());
    }
}
