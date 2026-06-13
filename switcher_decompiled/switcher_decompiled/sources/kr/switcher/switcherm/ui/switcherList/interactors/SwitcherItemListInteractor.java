package kr.switcher.switcherm.ui.switcherList.interactors;

import java.util.ArrayList;
import java.util.List;
import kr.switcher.switcherm.ui.switcherList.adapter.IODeviceItem;

/* JADX INFO: loaded from: classes2.dex */
public class SwitcherItemListInteractor {
    private List<IODeviceItem> IODeviceItems = new ArrayList();
    private List<IODeviceItem> hubItems = new ArrayList();

    public void setIODeviceItems(List<IODeviceItem> list) {
        this.IODeviceItems = list;
        list.addAll(this.hubItems);
    }

    public List<IODeviceItem> getIODeviceItems() {
        List<IODeviceItem> list = this.IODeviceItems;
        return list == null ? new ArrayList() : list;
    }

    public void clearSwitcherItems() {
        List<IODeviceItem> list = this.IODeviceItems;
        if (list != null) {
            list.clear();
        }
    }

    public void setHubItems(List<IODeviceItem> list) {
        this.hubItems = list;
    }
}
