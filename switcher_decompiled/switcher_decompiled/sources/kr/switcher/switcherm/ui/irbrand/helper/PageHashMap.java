package kr.switcher.switcherm.ui.irbrand.helper;

import android.graphics.drawable.Drawable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class PageHashMap {
    private int id;
    private final int INDEX_PROPOSE = 0;
    private HashMap<Integer, Drawable> drawableHashMap = new HashMap<>();
    private HashMap<Integer, List<String>> infoListHashMap = new HashMap<>();

    public void put(int i, Drawable drawable, String str) {
        int i2 = i - 1;
        this.id = i;
        this.drawableHashMap.put(Integer.valueOf(i2), drawable);
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        this.infoListHashMap.put(Integer.valueOf(i2), arrayList);
    }

    public Drawable getPageDrawable(int i) {
        return this.drawableHashMap.get(Integer.valueOf(i));
    }

    public String getProposeMessage(int i) {
        return this.infoListHashMap.get(Integer.valueOf(i)) == null ? "" : this.infoListHashMap.get(Integer.valueOf(i)).get(0);
    }

    public int getId() {
        return this.id;
    }

    public int getSize() {
        return this.drawableHashMap.size();
    }
}
