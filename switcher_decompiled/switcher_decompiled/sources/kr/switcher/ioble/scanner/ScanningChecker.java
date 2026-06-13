package kr.switcher.ioble.scanner;

/* JADX INFO: loaded from: classes2.dex */
public class ScanningChecker {
    private static boolean isScanning;

    public ScanningChecker() {
        isScanning = false;
    }

    public void startScan() {
        isScanning = true;
    }

    public void stopScan() {
        isScanning = false;
    }

    public boolean isScanning() {
        return isScanning;
    }
}
