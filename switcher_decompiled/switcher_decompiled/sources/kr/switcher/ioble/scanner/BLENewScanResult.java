package kr.switcher.ioble.scanner;

import android.util.Log;
import java.util.Iterator;
import java.util.List;
import kr.switcher.ioble.common.BLEUtil;
import kr.switcher.ioble.scanner.BLEScanListener;
import no.nordicsemi.android.support.v18.scanner.ScanCallback;
import no.nordicsemi.android.support.v18.scanner.ScanResult;

/* JADX INFO: loaded from: classes2.dex */
public class BLENewScanResult extends ScanCallback implements BLEScanListener {
    private static final String TAG = "BLENewScanResult";
    private String filteredMacAddress;
    private BLEScanListener.ScanResultListener listener;

    public BLENewScanResult(BLEScanListener.ScanResultListener scanResultListener, String str) {
        this.listener = scanResultListener;
        this.filteredMacAddress = str;
    }

    @Override // no.nordicsemi.android.support.v18.scanner.ScanCallback
    public void onScanResult(int i, ScanResult scanResult) {
        BLEScanInfo bLEScanInfo = new BLEScanInfo(scanResult);
        BLEScanListener.ScanResultListener scanResultListener = this.listener;
        if (scanResultListener != null) {
            scanResultListener.onScanResult(bLEScanInfo);
        }
    }

    @Override // no.nordicsemi.android.support.v18.scanner.ScanCallback
    public void onBatchScanResults(List<ScanResult> list) {
        Iterator<ScanResult> it = list.iterator();
        while (it.hasNext()) {
            BLEScanInfo bLEScanInfo = new BLEScanInfo(it.next());
            if (!BLEUtil.checkIsBluetoothAddress(this.filteredMacAddress) || this.filteredMacAddress.equals(bLEScanInfo.bluetoothDevice.getAddress())) {
                Log.d(TAG, "scanned item : " + bLEScanInfo.bluetoothDevice.getAddress() + ", " + bLEScanInfo.bluetoothDevice.getName());
                BLEScanListener.ScanResultListener scanResultListener = this.listener;
                if (scanResultListener != null) {
                    scanResultListener.onScanResult(bLEScanInfo);
                }
            }
        }
    }

    @Override // no.nordicsemi.android.support.v18.scanner.ScanCallback
    public void onScanFailed(int i) {
        super.onScanFailed(i);
        Log.e(TAG, "scan fail (error code:" + i + ")");
        BLEScanListener.ScanResultListener scanResultListener = this.listener;
        if (scanResultListener != null) {
            scanResultListener.onScanFailed(i);
        }
    }
}
