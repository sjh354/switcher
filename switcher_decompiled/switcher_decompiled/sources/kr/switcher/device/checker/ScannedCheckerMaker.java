package kr.switcher.device.checker;

import kr.switcher.ioble.checker.CheckerAdvertisementPacket;
import kr.switcher.ioble.scanner.BLEScanInfo;

/* JADX INFO: loaded from: classes2.dex */
public class ScannedCheckerMaker {
    public static ScannedBLEChecker makeScannedBLEChecker(BLEScanInfo bLEScanInfo) {
        try {
            return new ScannedBLEChecker(bLEScanInfo.bluetoothDevice, new CheckerAdvertisementPacket(bLEScanInfo.scanRecord), bLEScanInfo.rssi);
        } catch (Exception unused) {
            return null;
        }
    }
}
