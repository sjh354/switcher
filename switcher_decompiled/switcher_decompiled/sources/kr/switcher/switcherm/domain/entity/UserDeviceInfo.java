package kr.switcher.switcherm.domain.entity;

import kr.switcher.switcherm.common.util.IOUtil;

/* JADX INFO: loaded from: classes2.dex */
public class UserDeviceInfo {
    private int availableDiskPercent;
    private int availableRamPercent;
    private String os;
    private String phoneModel;

    public UserDeviceInfo getDeviceInfo() {
        this.phoneModel = IOUtil.getModel();
        this.os = IOUtil.getOSVersion();
        this.availableDiskPercent = IOUtil.getDiskPercent();
        this.availableRamPercent = IOUtil.getRamPercent();
        return this;
    }

    public String getPhoneModel() {
        return this.phoneModel;
    }

    public String getOs() {
        return this.os;
    }

    public int getAvailableDiskPercent() {
        return this.availableDiskPercent;
    }

    public int getAvailableRamPercent() {
        return this.availableRamPercent;
    }
}
