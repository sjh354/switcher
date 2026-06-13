package kr.switcher.ioble.scanner;

/* JADX INFO: loaded from: classes2.dex */
public interface BLEScanListener {

    public interface ScanResultListener {
        void onScanFailed(int i);

        void onScanResult(BLEScanInfo bLEScanInfo);
    }
}
