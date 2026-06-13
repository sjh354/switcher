package kr.switcher.switcherm.ui.switcherInfo.views;

import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes2.dex */
public interface RemoconInfoView {
    void setRemoconIcon(Drawable drawable);

    void setRemoconName(String str);

    void setRemoconType(String str);

    void showErrorMessage(String str);
}
