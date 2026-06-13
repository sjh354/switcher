package kr.switcher.device.switcher.ble;

import kr.switcher.ioble.scanner.BLEScanInfo;
import kr.switcher.ioble.switcher.SwitcherAdvertisementPacket;

/* JADX INFO: loaded from: classes2.dex */
public class ScannedSwitcherMaker {
    public static ScannedBLESwitcher makeScannedBLESwitcher(BLEScanInfo bLEScanInfo) {
        try {
            return new ScannedBLESwitcher(bLEScanInfo.bluetoothDevice, new SwitcherAdvertisementPacket(bLEScanInfo.scanRecord), bLEScanInfo.rssi);
        } catch (Exception unused) {
            return null;
        }
    }
}
