package kr.switcher.device.switcher.ble;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class SwitcherGroup {
    private List<SwitcherBLE> switchers = new ArrayList();

    public void addSwitcher(SwitcherBLE switcherBLE) {
        if (isThere(switcherBLE)) {
            return;
        }
        this.switchers.add(switcherBLE);
    }

    public void removeSwitcher(String str) {
        remove(str);
    }

    private void remove(String str) {
        for (SwitcherBLE switcherBLE : this.switchers) {
            if (switcherBLE.getMacAddress().equals(str)) {
                this.switchers.remove(switcherBLE);
            }
        }
    }

    public SwitcherBLE getSwitcher(String str) {
        for (SwitcherBLE switcherBLE : this.switchers) {
            if (switcherBLE.getMacAddress().equals(str)) {
                return switcherBLE;
            }
        }
        return null;
    }

    public boolean isThere(SwitcherBLE switcherBLE) {
        Iterator<SwitcherBLE> it = this.switchers.iterator();
        while (it.hasNext()) {
            if (it.next().getMacAddress().equals(switcherBLE.getMacAddress())) {
                return true;
            }
        }
        return false;
    }
}
