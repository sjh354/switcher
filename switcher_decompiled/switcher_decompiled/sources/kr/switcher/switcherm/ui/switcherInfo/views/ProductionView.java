package kr.switcher.switcherm.ui.switcherInfo.views;

import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes2.dex */
public interface ProductionView {
    void disableChangeButton();

    void enableChangeButton();

    void hideProgressbar();

    void setAddress1(String str);

    void setAddress2(String str);

    void setChangeButtonName(String str);

    void setDeliveryAt(String str);

    void setName(String str);

    void setPhoneNumber(String str);

    void setSwitcherImage(Drawable drawable);

    void setSwitcherType(String str);

    void showChangeDialog(String str);

    void showErrorMessage(String str);

    void showProgressbar();

    void trackDisableForGA();

    void trackProductionForGA();
}
