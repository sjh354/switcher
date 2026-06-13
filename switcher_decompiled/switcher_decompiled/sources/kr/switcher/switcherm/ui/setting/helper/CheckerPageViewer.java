package kr.switcher.switcherm.ui.setting.helper;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class CheckerPageViewer {
    private CheckerPageHashMap pageHashMap = new CheckerPageHashMap();

    public CheckerPageViewer(List<CheckerLevelItem> list) {
        setProductPage(list);
    }

    public void setProductPage(List<CheckerLevelItem> list) {
        for (CheckerLevelItem checkerLevelItem : list) {
            this.pageHashMap.put(checkerLevelItem.getId(), checkerLevelItem.getItemImage());
        }
    }

    public CheckerPageHashMap getPage() {
        return this.pageHashMap;
    }
}
