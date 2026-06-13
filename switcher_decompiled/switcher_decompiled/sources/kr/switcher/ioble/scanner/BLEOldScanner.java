package kr.switcher.ioble.scanner;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import kr.switcher.ioble.scanner.BLEScanListener;
import kr.switcher.ioble.scanner.ScanTimeTask;

/* JADX INFO: loaded from: classes2.dex */
public class BLEOldScanner extends BLEScanner implements ScanTimeTask.ScanningTimeoutListener {
    BluetoothAdapter adapter = ((BluetoothManager) this.context.getSystemService("bluetooth")).getAdapter();
    BLEOldScanResult result = new BLEOldScanResult(null, "");

    @Override // kr.switcher.ioble.scanner.BLEScanner
    public void startScan(BLEScanListener.ScanResultListener scanResultListener) {
        super.startScan();
        this.result = new BLEOldScanResult(scanResultListener, this.filteredMacAddress);
        this.scanTimeTask.start(this);
    }

    @Override // kr.switcher.ioble.scanner.BLEScanner
    public void stopScan() {
        if (this.scanningChecker.isScanning()) {
            super.stopScan();
        }
    }

    @Override // kr.switcher.ioble.scanner.BLEScanner
    public void setFilters(String str) {
        this.filteredMacAddress = str;
    }

    @Override // kr.switcher.ioble.scanner.ScanTimeTask.ScanningTimeoutListener
    public void onTimeoutScan() {
        stopScan();
    }
}
