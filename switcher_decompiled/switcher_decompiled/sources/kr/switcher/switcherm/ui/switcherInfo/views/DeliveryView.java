package kr.switcher.switcherm.ui.switcherInfo.views;

import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes2.dex */
public interface DeliveryView {
    void setAddress1(String str);

    void setAddress2(String str);

    void setName(String str);

    void setPKey(String str);

    void setPhoneNumber(String str);

    void setSwitcherImage(Drawable drawable);

    void setSwitcherName(String str);

    void trackDeliveryForGA();
}
