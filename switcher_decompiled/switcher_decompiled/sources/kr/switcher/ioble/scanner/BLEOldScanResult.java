package kr.switcher.ioble.scanner;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import kr.switcher.ioble.common.BLEUtil;
import kr.switcher.ioble.scanner.BLEScanListener;

/* JADX INFO: loaded from: classes2.dex */
public class BLEOldScanResult implements BLEScanListener, BluetoothAdapter.LeScanCallback {
    private String filteredMacAddress;
    private BLEScanListener.ScanResultListener listener;

    public BLEOldScanResult(BLEScanListener.ScanResultListener scanResultListener, String str) {
        this.listener = scanResultListener;
        this.filteredMacAddress = str;
    }

    @Override // android.bluetooth.BluetoothAdapter.LeScanCallback
    public void onLeScan(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
        if (!BLEUtil.checkIsBluetoothAddress(this.filteredMacAddress) || this.filteredMacAddress.equals(bluetoothDevice.getAddress())) {
            BLEScanInfo bLEScanInfo = new BLEScanInfo(bluetoothDevice, i, bArr);
            BLEScanListener.ScanResultListener scanResultListener = this.listener;
            if (scanResultListener != null) {
                scanResultListener.onScanResult(bLEScanInfo);
            }
        }
    }
}
