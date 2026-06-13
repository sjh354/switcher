package kr.switcher.ioble.switcher.connector;

import android.bluetooth.BluetoothGattCharacteristic;
import java.util.UUID;
import kr.switcher.ioble.protocol.SwitcherBLEProtocol;

/* JADX INFO: loaded from: classes2.dex */
public class CharacteristicReadParser {
    public static String parse(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        UUID uuid = bluetoothGattCharacteristic.getUuid();
        if (SwitcherBLEProtocol.UUID_FOR_BATTERY_LEVEL_CHARACTERISTIC.equals(uuid)) {
            return getBatteryValue(bluetoothGattCharacteristic);
        }
        if (SwitcherBLEProtocol.UUID_FOR_AUTHORITY_STATE_CHARACTERISTIC.equals(uuid)) {
            return getAuthorityStateValue(bluetoothGattCharacteristic);
        }
        if (SwitcherBLEProtocol.UUID_FOR_TIMER_CHARACTERISTIC.equals(uuid)) {
            return getTimerValue(bluetoothGattCharacteristic);
        }
        if (SwitcherBLEProtocol.UUID_FOR_FIRMWARE_VERSION_CHARACTERISTIC.equals(uuid)) {
            return getFirmwareVersionValue(bluetoothGattCharacteristic);
        }
        if (SwitcherBLEProtocol.UUID_FOR_REAL_TIME_CHARACTERISTIC.equals(uuid)) {
            return getRealtimeValue(bluetoothGattCharacteristic);
        }
        if (SwitcherBLEProtocol.UUID_FOR_SWITCH_STROKE_LEVEL_CHARACTERISTIC.equals(uuid)) {
            return getStrokeLevelValue(bluetoothGattCharacteristic);
        }
        String str = "";
        for (int i = 0; i < 4; i++) {
            str = str + bluetoothGattCharacteristic.getIntValue(17, i);
        }
        return str;
    }

    private static String getBatteryValue(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        return String.valueOf(Integer.parseInt(String.format("%02x", bluetoothGattCharacteristic.getIntValue(17, 0)), 16));
    }

    private static String getAuthorityStateValue(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        return String.valueOf(bluetoothGattCharacteristic.getIntValue(17, 0));
    }

    private static String getTimerValue(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        String str = "";
        for (int i = 0; i < 50; i++) {
            str = str + String.format("%02x", Integer.valueOf(bluetoothGattCharacteristic.getIntValue(17, i).intValue()));
        }
        return str;
    }

    private static String getFirmwareVersionValue(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        return (("" + String.format("%d.", bluetoothGattCharacteristic.getIntValue(17, 0))) + String.format("%d.", bluetoothGattCharacteristic.getIntValue(17, 1))) + String.format("%d", bluetoothGattCharacteristic.getIntValue(17, 2));
    }

    private static String getRealtimeValue(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        String str = "";
        for (int i = 0; i < 3; i++) {
            str = str + String.format("%02x", bluetoothGattCharacteristic.getIntValue(17, i));
        }
        return str;
    }

    private static String getStrokeLevelValue(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        return String.format("%02x", bluetoothGattCharacteristic.getIntValue(17, 0));
    }
}
