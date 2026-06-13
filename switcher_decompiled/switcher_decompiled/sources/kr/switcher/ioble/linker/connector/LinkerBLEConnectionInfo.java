package kr.switcher.ioble.linker.connector;

import android.bluetooth.BluetoothGatt;
import kr.switcher.ioble.linker.protocol.LinkerBLEService;
import kr.switcher.ioble.switcher.connector.CharacteristicParser;

/* JADX INFO: loaded from: classes2.dex */
public class LinkerBLEConnectionInfo {
    private BluetoothGatt gatt;
    private LinkerBLEService service;

    public LinkerBLEConnectionInfo(LinkerBLEService linkerBLEService) {
        this.service = linkerBLEService;
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

    public LinkerBLEService getBLEService() {
        return this.service;
    }

    public String getMacAddress() {
        return this.gatt.getDevice().getAddress();
    }

    public String getDeviceName() {
        return this.gatt.getDevice().getName();
    }
}
