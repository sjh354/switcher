package kr.switcher.ioble.scanner;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class InvalidBLEScanInfoGroup {
    private List<BLEScanInfo> scanInfoList = new ArrayList();

    public synchronized void add(BLEScanInfo bLEScanInfo) {
        if (!isThere(bLEScanInfo)) {
            this.scanInfoList.add(bLEScanInfo);
        }
    }

    public void clearScanInfo() {
        this.scanInfoList.clear();
    }

    public List<BLEScanInfo> getAllBLEScanInfoList() {
        return this.scanInfoList;
    }

    public boolean isThere(BLEScanInfo bLEScanInfo) {
        Iterator<BLEScanInfo> it = this.scanInfoList.iterator();
        while (it.hasNext()) {
            if (it.next().bluetoothDevice.getAddress().equals(bLEScanInfo.bluetoothDevice.getAddress())) {
                return true;
            }
        }
        return false;
    }
}
