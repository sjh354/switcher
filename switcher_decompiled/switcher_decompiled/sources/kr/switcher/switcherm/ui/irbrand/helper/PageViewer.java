package kr.switcher.switcherm.ui.irbrand.helper;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class PageViewer {
    private PageHashMap pageHashMap = new PageHashMap();

    public PageViewer(List<ControllerItem> list) {
        setProductPage(list);
    }

    public void setProductPage(List<ControllerItem> list) {
        for (ControllerItem controllerItem : list) {
            this.pageHashMap.put(controllerItem.getId(), controllerItem.getItemImage(), controllerItem.getName());
        }
    }

    public PageHashMap getPage() {
        return this.pageHashMap;
    }
}
