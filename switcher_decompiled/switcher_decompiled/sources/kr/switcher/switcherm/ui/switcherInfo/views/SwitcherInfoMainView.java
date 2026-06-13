package kr.switcher.switcherm.ui.switcherInfo.views;

import kr.switcher.device.IODevice;

/* JADX INFO: loaded from: classes2.dex */
public interface SwitcherInfoMainView {
    void initViewModel(IODevice.ProductId productId);

    void setWhoAmI(boolean z);

    void showErrorMessage(String str);

    void viewData(IODevice iODevice, String str, String str2, String str3, String str4, String str5);
}
