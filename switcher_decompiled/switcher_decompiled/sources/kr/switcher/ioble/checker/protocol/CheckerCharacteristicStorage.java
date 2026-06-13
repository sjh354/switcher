package kr.switcher.ioble.checker.protocol;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;

/* JADX INFO: loaded from: classes2.dex */
public class CheckerCharacteristicStorage {
    private BluetoothGattCharacteristic accessTokenCharacteristic;
    private BluetoothGattCharacteristic wifiPasswordCharacteristic;
    private BluetoothGattCharacteristic wifiSSIDCharacteristic;

    public CheckerCharacteristicStorage(BluetoothGatt bluetoothGatt) {
        this.wifiSSIDCharacteristic = bluetoothGatt.getService(CheckerBLEProtocol.UUID_FOR_WIFI_SSID_SERVICE).getCharacteristic(CheckerBLEProtocol.UUID_FOR_WIFI_SSID_CHARACTERISTIC);
        this.wifiPasswordCharacteristic = bluetoothGatt.getService(CheckerBLEProtocol.UUID_FOR_WIFI_PASSWORD_SERVICE).getCharacteristic(CheckerBLEProtocol.UUID_FOR_WIFI_PASSWORD_CHARACTERISTIC);
        this.accessTokenCharacteristic = bluetoothGatt.getService(CheckerBLEProtocol.UUID_FOR_ACCESS_TOKEN_SERVICE).getCharacteristic(CheckerBLEProtocol.UUID_FOR_ACCESS_TOKEN_CHARACTERISTIC);
    }

    public BluetoothGattCharacteristic getWifiSSIDCharacteristic() {
        return this.wifiSSIDCharacteristic;
    }

    public BluetoothGattCharacteristic getWifiPasswordCharacteristic() {
        return this.wifiPasswordCharacteristic;
    }

    public BluetoothGattCharacteristic getAccessTokenCharacteristic() {
        return this.accessTokenCharacteristic;
    }
}
