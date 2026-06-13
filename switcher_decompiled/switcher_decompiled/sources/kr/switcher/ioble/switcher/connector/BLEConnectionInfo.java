package kr.switcher.ioble.switcher.connector;

import android.bluetooth.BluetoothGatt;
import kr.switcher.ioble.protocol.SwitcherBLEService;

/* JADX INFO: loaded from: classes2.dex */
public class BLEConnectionInfo {
    private BluetoothGatt gatt;
    private SwitcherBLEService service;

    public BLEConnectionInfo(SwitcherBLEService switcherBLEService) {
        this.service = switcherBLEService;
    }

    public void setBluetoothGatt(BluetoothGatt bluetoothGatt) {
        this.gatt = bluetoothGatt;
        this.service.setBluetoothGatt(bluetoothGatt);
    }

    public BluetoothGatt getBluetoothGatt() {
        return this.gatt;
    }

    public CharacteristicParser getCharacteristicParser() {
        return this.service.getCharacteristicParser();
    }

    public SwitcherBLEService getBLEService() {
        return this.service;
    }

    public String getMacAddress() {
        return this.gatt.getDevice().getAddress();
    }

    public String getDeviceName() {
        return this.gatt.getDevice().getName();
    }
}
