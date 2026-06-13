package kr.switcher.switcherm.ui.setting.helper;

import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes2.dex */
public class CheckerLevelItem {
    private int id;
    private Drawable itemImage;

    public void setItemImage(Drawable drawable) {
        this.itemImage = drawable;
    }

    public CheckerLevelItem(int i, Drawable drawable) {
        this.id = i;
        this.itemImage = drawable;
    }

    public int getId() {
        return this.id;
    }

    public Drawable getItemImage() {
        return this.itemImage;
    }
}
