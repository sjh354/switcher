package kr.switcher.switcherm.ui.switcherInfo.views;

import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes2.dex */
public interface WholesaleFreeView {
    void finish();

    void moveSwitcherListScreen();

    void onResume();

    void setFirstPaymentAt(String str);

    void setOwnerName(String str);

    void setPKey(String str);

    void setPaymentCard(String str);

    void setRoomName(String str);

    void setShareCode(String str);

    void setSwitcherImage(Drawable drawable);

    void setSwitcherType(String str);

    void showMessage(String str);

    void trackWholesaleFreeForGA();
}
