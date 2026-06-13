package kr.switcher.switcherm.ui.irbrand.helper;

import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes2.dex */
public class ControllerItem {
    private int id;
    private Drawable itemImage;
    private String name;

    public void setItemImage(Drawable drawable) {
        this.itemImage = drawable;
    }

    public ControllerItem(int i, String str) {
        this.id = i;
        this.name = str;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Drawable getItemImage() {
        return this.itemImage;
    }
}
