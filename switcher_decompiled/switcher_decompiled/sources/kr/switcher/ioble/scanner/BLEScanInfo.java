package kr.switcher.ioble.scanner;

import android.bluetooth.BluetoothDevice;
import no.nordicsemi.android.support.v18.scanner.ScanResult;

/* JADX INFO: loaded from: classes2.dex */
public class BLEScanInfo {
    public BluetoothDevice bluetoothDevice;
    public int rssi;
    public byte[] scanRecord;

    public BLEScanInfo(ScanResult scanResult) {
        this.bluetoothDevice = scanResult.getDevice();
        this.rssi = scanResult.getRssi();
        this.scanRecord = scanResult.getScanRecord().getBytes();
    }

    public BLEScanInfo(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
        this.bluetoothDevice = bluetoothDevice;
        this.rssi = i;
        this.scanRecord = bArr;
    }
}
