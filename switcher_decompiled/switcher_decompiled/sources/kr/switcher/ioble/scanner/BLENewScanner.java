package kr.switcher.ioble.scanner;

import android.bluetooth.BluetoothManager;
import java.util.ArrayList;
import java.util.List;
import kr.switcher.ioble.scanner.BLEScanListener;
import kr.switcher.ioble.scanner.ScanTimeTask;
import no.nordicsemi.android.support.v18.scanner.BluetoothLeScannerCompat;
import no.nordicsemi.android.support.v18.scanner.ScanFilter;
import no.nordicsemi.android.support.v18.scanner.ScanSettings;

/* JADX INFO: loaded from: classes2.dex */
public class BLENewScanner extends BLEScanner implements ScanTimeTask.ScanningTimeoutListener {
    private List<ScanFilter> filters = new ArrayList();
    private BLENewScanResult scanResult;

    @Override // kr.switcher.ioble.scanner.BLEScanner
    public void setFilters(String str) {
        this.filteredMacAddress = str;
    }

    private boolean isBluetoothActive() {
        try {
            return ((BluetoothManager) this.context.getSystemService("bluetooth")).getAdapter().isEnabled();
        } catch (NullPointerException unused) {
            return false;
        }
    }

    @Override // kr.switcher.ioble.scanner.BLEScanner
    public void startScan(BLEScanListener.ScanResultListener scanResultListener) {
        super.startScan();
        if (isBluetoothActive()) {
            BluetoothLeScannerCompat scanner = BluetoothLeScannerCompat.getScanner();
            ScanSettings scanSettingsBuild = new ScanSettings.Builder().setReportDelay(1000L).setScanMode(2).setUseHardwareBatchingIfSupported(false).build();
            BLENewScanResult bLENewScanResult = new BLENewScanResult(scanResultListener, this.filteredMacAddress);
            this.scanResult = bLENewScanResult;
            scanner.startScan(this.filters, scanSettingsBuild, bLENewScanResult);
            this.scanTimeTask.start(this);
        }
    }

    @Override // kr.switcher.ioble.scanner.BLEScanner
    public void stopScan() {
        if (this.scanningChecker.isScanning()) {
            super.stopScan();
            BluetoothLeScannerCompat scanner = BluetoothLeScannerCompat.getScanner();
            BLENewScanResult bLENewScanResult = this.scanResult;
            if (bLENewScanResult != null) {
                scanner.stopScan(bLENewScanResult);
            }
            this.scanTimeTask.cancel();
        }
    }

    @Override // kr.switcher.ioble.scanner.ScanTimeTask.ScanningTimeoutListener
    public void onTimeoutScan() {
        stopScan();
    }
}
