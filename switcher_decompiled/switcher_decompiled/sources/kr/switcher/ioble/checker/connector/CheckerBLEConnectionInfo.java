package kr.switcher.ioble.checker.connector;

import android.bluetooth.BluetoothGatt;
import kr.switcher.ioble.checker.protocol.CheckerBLEService;
import kr.switcher.ioble.switcher.connector.CharacteristicParser;

/* JADX INFO: loaded from: classes2.dex */
public class CheckerBLEConnectionInfo {
    private BluetoothGatt gatt;
    private CheckerBLEService service;

    public CheckerBLEConnectionInfo(CheckerBLEService checkerBLEService) {
        this.service = checkerBLEService;
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

    public CheckerBLEService getBLEService() {
        return this.service;
    }

    public String getMacAddress() {
        return this.gatt.getDevice().getAddress();
    }

    public String getDeviceName() {
        return this.gatt.getDevice().getName();
    }
}
