package kr.switcher.switcherm.ui.switcherInfo.views;

import android.graphics.drawable.Drawable;
import kr.switcher.device.IODevice;

/* JADX INFO: loaded from: classes2.dex */
public interface WholesaleView {
    void finish();

    void hideInitButton();

    void hideOwnerMenu();

    void hideProgressbar();

    void moveSwitcherListScreen();

    void onResume();

    void setInitButton(IODevice iODevice);

    void setOwnerName(String str);

    void setPKey(String str);

    void setRoomName(String str);

    void setShareCode(String str);

    void setSwitcherImage(Drawable drawable);

    void setSwitcherType(String str);

    void setWarrantyDate(String str);

    void showErrorMessage(String str);

    void showInitButton();

    void showOwnerMenu();

    void showProgressbar();

    void showWarningForInitializeDialog();

    void showWarningForProductInitializeDialog();

    void terminateMainSwitcher();

    void trackGuestUsingForGA();

    void trackWarningForGA();

    void trackWholesaleForGA();
}
