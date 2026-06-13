package kr.switcher.switcherm.ui.mypage.interactor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kr.switcher.device.IODevice;
import kr.switcher.switcherm.device.IODeviceHandler;
import kr.switcher.switcherm.ui.mypage.MyPageItem;
import kr.switcher.switcherm.user.Preparing;

/* JADX INFO: loaded from: classes2.dex */
public class FindMySwitcherInteractor {

    public interface OnFindMyPageItemsListener {
        void onFindMyPageItems(List<MyPageItem> list);
    }

    public void findMyMyPageItems(OnFindMyPageItemsListener onFindMyPageItemsListener) {
        ArrayList arrayList = new ArrayList();
        for (IODevice iODevice : IODeviceHandler.getInstance().getMyDeviceAll()) {
            if (iODevice.getProductId() != IODevice.ProductId.REMOCON) {
                arrayList.add(new MyPageItem(iODevice.getProductId(), iODevice.getMacAddress(), iODevice.getSerialNumber(), iODevice.getName()));
            }
        }
        onFindMyPageItemsListener.onFindMyPageItems(arrayList);
        for (Preparing preparing : IODeviceHandler.getInstance().getPreparingAll()) {
            onFindMyPageItemsListener.onFindMyPageItems(Arrays.asList(new MyPageItem(preparing.getProductId(), preparing.getFreeTrialId())));
        }
    }
}
