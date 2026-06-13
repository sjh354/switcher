package kr.switcher.switcherm.ui.main.helper;

import kr.switcher.device.switcher.Switcher;

/* JADX INFO: loaded from: classes2.dex */
public class SwitcherInfoValidator {
    public boolean checkIsSwitcherOwner(Switcher switcher) {
        return (switcher == null || switcher.getOwner() == null || "".equals(switcher.getOwner())) ? false : true;
    }

    public boolean checkHashingKey(String str) {
        return str != null && str.length() == 4;
    }
}
