package kr.switcher.device.linker;

import kr.switcher.ioble.linker.LinkerAdvertisementPacket;
import kr.switcher.ioble.scanner.BLEScanInfo;

/* JADX INFO: loaded from: classes2.dex */
public class ScannedLinkerMaker {
    public static ScannedBLELinker makeScannedBLELinker(BLEScanInfo bLEScanInfo) {
        try {
            return new ScannedBLELinker(bLEScanInfo.bluetoothDevice, new LinkerAdvertisementPacket(bLEScanInfo.scanRecord), bLEScanInfo.rssi);
        } catch (Exception unused) {
            return null;
        }
    }
}
