package kr.switcher.ioble.linker.protocol;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;

/* JADX INFO: loaded from: classes2.dex */
public class LinkerCharacteristicStorage {
    private BluetoothGattCharacteristic wifiPasswordCharacteristic;
    private BluetoothGattCharacteristic wifiSSIDCharacteristic;

    public LinkerCharacteristicStorage(BluetoothGatt bluetoothGatt) {
        try {
            this.wifiSSIDCharacteristic = bluetoothGatt.getService(LinkerBLEProtocol.UUID_FOR_WIFI_SSID_SERVICE).getCharacteristic(LinkerBLEProtocol.UUID_FOR_WIFI_SSID_CHARACTERISTIC);
            this.wifiPasswordCharacteristic = bluetoothGatt.getService(LinkerBLEProtocol.UUID_FOR_WIFI_PASSWORD_SERVICE).getCharacteristic(LinkerBLEProtocol.UUID_FOR_WIFI_PASSWORD_CHARACTERISTIC);
        } catch (NullPointerException unused) {
            this.wifiSSIDCharacteristic = bluetoothGatt.getService(LinkerBLEProtocol.UUID_FOR_WIFI_SSID_SERVICE_LEGACY).getCharacteristic(LinkerBLEProtocol.UUID_FOR_WIFI_SSID_CHARACTERISTIC_LEGACY);
            this.wifiPasswordCharacteristic = bluetoothGatt.getService(LinkerBLEProtocol.UUID_FOR_WIFI_PASSWORD_SERVICE_LEGACY).getCharacteristic(LinkerBLEProtocol.UUID_FOR_WIFI_PASSWORD_CHARACTERISTIC_LEGACY);
        }
    }

    public BluetoothGattCharacteristic getWifiSSIDCharacteristic() {
        return this.wifiSSIDCharacteristic;
    }

    public BluetoothGattCharacteristic getWifiPasswordCharacteristic() {
        return this.wifiPasswordCharacteristic;
    }
}
