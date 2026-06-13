package kr.switcher.ioble.protocol;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;

/* JADX INFO: loaded from: classes2.dex */
public class CharacteristicStorage {
    public static int SERVICE_NUM = 8;
    private BluetoothGattCharacteristic authorityStateCharacteristic;
    private BluetoothGattCharacteristic batteryLevelCharacteristic;
    private BluetoothGattCharacteristic firmwareVersionCharacteristic;
    private BluetoothGattCharacteristic realtimeCharacteristic;
    private BluetoothGattCharacteristic serialNumberCharacteristic;
    private BluetoothGattCharacteristic switchOperationCharacteristic;
    private BluetoothGattCharacteristic switchStrokeLevelCharacteristic;
    private BluetoothGattCharacteristic timerCharacteristic;
    private BluetoothGattCharacteristic timerOperationCharacteristic;
    private BluetoothGattCharacteristic timerUDRevCharacteristic;

    public CharacteristicStorage(BluetoothGatt bluetoothGatt) {
        this.batteryLevelCharacteristic = bluetoothGatt.getService(SwitcherBLEProtocol.UUID_FOR_BATTERY_LEVEL_SERVICE).getCharacteristic(SwitcherBLEProtocol.UUID_FOR_BATTERY_LEVEL_CHARACTERISTIC);
        this.switchOperationCharacteristic = bluetoothGatt.getService(SwitcherBLEProtocol.UUID_FOR_SWITCH_SERVICE).getCharacteristic(SwitcherBLEProtocol.UUID_FOR_SWITCH_OPERATION_CHARACTERISTIC);
        this.switchStrokeLevelCharacteristic = bluetoothGatt.getService(SwitcherBLEProtocol.UUID_FOR_SWITCH_SERVICE).getCharacteristic(SwitcherBLEProtocol.UUID_FOR_SWITCH_STROKE_LEVEL_CHARACTERISTIC);
        this.timerOperationCharacteristic = bluetoothGatt.getService(SwitcherBLEProtocol.UUID_FOR_TIMER_SERVICE).getCharacteristic(SwitcherBLEProtocol.UUID_FOR_TIMER_OPERATION_CHARACTERISTIC);
        this.timerCharacteristic = bluetoothGatt.getService(SwitcherBLEProtocol.UUID_FOR_TIMER_SERVICE).getCharacteristic(SwitcherBLEProtocol.UUID_FOR_TIMER_CHARACTERISTIC);
        this.timerUDRevCharacteristic = bluetoothGatt.getService(SwitcherBLEProtocol.UUID_FOR_TIMER_SERVICE).getCharacteristic(SwitcherBLEProtocol.UUID_FOR_TIMER_UD_REV_CHARACTERISTIC);
        this.authorityStateCharacteristic = bluetoothGatt.getService(SwitcherBLEProtocol.UUID_FOR_AUTHORITY_SERVICE).getCharacteristic(SwitcherBLEProtocol.UUID_FOR_AUTHORITY_STATE_CHARACTERISTIC);
        this.firmwareVersionCharacteristic = bluetoothGatt.getService(SwitcherBLEProtocol.UUID_FOR_SWITCHER_INFORMATION_SERVICE).getCharacteristic(SwitcherBLEProtocol.UUID_FOR_FIRMWARE_VERSION_CHARACTERISTIC);
        this.serialNumberCharacteristic = bluetoothGatt.getService(SwitcherBLEProtocol.UUID_FOR_SWITCHER_INFORMATION_SERVICE).getCharacteristic(SwitcherBLEProtocol.UUID_FOR_SERIAL_NUMBER_CHARACTERISTIC);
        this.realtimeCharacteristic = bluetoothGatt.getService(SwitcherBLEProtocol.UUID_FOR_SWITCHER_INFORMATION_SERVICE).getCharacteristic(SwitcherBLEProtocol.UUID_FOR_REAL_TIME_CHARACTERISTIC);
    }

    public BluetoothGattCharacteristic getBatteryLevelCharacteristic() {
        return this.batteryLevelCharacteristic;
    }

    public BluetoothGattCharacteristic getSwitchOperationCharacteristic() {
        return this.switchOperationCharacteristic;
    }

    public BluetoothGattCharacteristic getSwitchStrokeLevelCharacteristic() {
        return this.switchStrokeLevelCharacteristic;
    }

    public BluetoothGattCharacteristic getTimerOperationCharacteristic() {
        return this.timerOperationCharacteristic;
    }

    public BluetoothGattCharacteristic getTimerCharacteristic() {
        return this.timerCharacteristic;
    }

    public BluetoothGattCharacteristic getTimerUDRevCharacteristic() {
        return this.timerUDRevCharacteristic;
    }

    public BluetoothGattCharacteristic getAuthorityStateCharacteristic() {
        return this.authorityStateCharacteristic;
    }

    public BluetoothGattCharacteristic getFirmwareVersionCharacteristic() {
        return this.firmwareVersionCharacteristic;
    }

    public BluetoothGattCharacteristic getSerialNumberCharacteristic() {
        return this.serialNumberCharacteristic;
    }

    public BluetoothGattCharacteristic getRealtimeCharacteristic() {
        return this.realtimeCharacteristic;
    }
}
