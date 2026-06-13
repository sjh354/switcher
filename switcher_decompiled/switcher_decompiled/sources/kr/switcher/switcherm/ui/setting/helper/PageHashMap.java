package kr.switcher.switcherm.ui.setting.helper;

import android.graphics.drawable.Drawable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class PageHashMap {
    private int id;
    private final int INDEX_PROPOSE = 0;
    private final int INDEX_SITUATION = 1;
    private HashMap<Integer, Drawable> drawableHashMap = new HashMap<>();
    private HashMap<Integer, List<String>> infoListHashMap = new HashMap<>();

    public void put(int i, Drawable drawable, String str, String str2) {
        this.id = i;
        this.drawableHashMap.put(Integer.valueOf(i), drawable);
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        arrayList.add(str2);
        this.infoListHashMap.put(Integer.valueOf(i), arrayList);
    }

    public Drawable getPageDrawable(int i) {
        return this.drawableHashMap.get(Integer.valueOf(i));
    }

    public String getProposeMessage(int i) {
        return this.infoListHashMap.get(Integer.valueOf(i)) == null ? "" : this.infoListHashMap.get(Integer.valueOf(i)).get(0);
    }

    public String getSituationMessage(int i) {
        return this.infoListHashMap.get(Integer.valueOf(i)) == null ? "" : this.infoListHashMap.get(Integer.valueOf(i)).get(1);
    }

    public int getId() {
        return this.id;
    }

    public int getSize() {
        return this.drawableHashMap.size();
    }
}
