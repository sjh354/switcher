package kr.switcher.ioble.protocol;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.util.Log;
import java.util.Calendar;
import kr.switcher.device.switcher.Switcher;
import kr.switcher.ioble.common.BLEUtil;
import kr.switcher.ioble.switcher.connector.CharacteristicParser;

/* JADX INFO: loaded from: classes2.dex */
public class SwitcherBLEService {
    private BluetoothGatt gatt;
    private CharacteristicStorage storage;
    private String TAG = "SwitcherBLEService";
    private CharacteristicParser parser = new CharacteristicParser();

    public void setBluetoothGatt(BluetoothGatt bluetoothGatt) {
        this.gatt = bluetoothGatt;
        this.storage = new CharacteristicStorage(bluetoothGatt);
    }

    public CharacteristicParser getCharacteristicParser() {
        return this.parser;
    }

    public void readService(BluetoothGattCharacteristic bluetoothGattCharacteristic, CharacteristicParser.ReadServiceListener readServiceListener) {
        this.parser.setReadServiceListener(readServiceListener);
        this.gatt.readCharacteristic(bluetoothGattCharacteristic);
    }

    public void writeService(String str, BluetoothGattCharacteristic bluetoothGattCharacteristic, CharacteristicParser.WriteServiceListener writeServiceListener) {
        this.parser.setWriteServiceListener(writeServiceListener);
        bluetoothGattCharacteristic.setWriteType(2);
        bluetoothGattCharacteristic.setValue(BLEUtil.hexStringToByteArray(str));
        printResultOfWriteCharacteristic(this.gatt.writeCharacteristic(bluetoothGattCharacteristic), str);
    }

    public void writeService(int i, BluetoothGattCharacteristic bluetoothGattCharacteristic, CharacteristicParser.WriteServiceListener writeServiceListener) {
        this.parser.setWriteServiceListener(writeServiceListener);
        bluetoothGattCharacteristic.setWriteType(2);
        bluetoothGattCharacteristic.setValue(i, 17, 0);
        printResultOfWriteCharacteristic(this.gatt.writeCharacteristic(bluetoothGattCharacteristic), String.valueOf(i));
    }

    public void readBatteryService(CharacteristicParser.ReadServiceListener readServiceListener) {
        readService(this.storage.getBatteryLevelCharacteristic(), readServiceListener);
    }

    public void readAuthorityState(CharacteristicParser.ReadServiceListener readServiceListener) {
        readService(this.storage.getAuthorityStateCharacteristic(), readServiceListener);
    }

    public void readStrokeLevel(CharacteristicParser.ReadServiceListener readServiceListener) {
        readService(this.storage.getSwitchStrokeLevelCharacteristic(), readServiceListener);
    }

    public void readTimer(CharacteristicParser.ReadServiceListener readServiceListener) {
        readService(this.storage.getTimerCharacteristic(), readServiceListener);
    }

    public void readRealTime(CharacteristicParser.ReadServiceListener readServiceListener) {
        readService(this.storage.getRealtimeCharacteristic(), readServiceListener);
    }

    public void readFirmwareVersion(CharacteristicParser.ReadServiceListener readServiceListener) {
        readService(this.storage.getFirmwareVersionCharacteristic(), readServiceListener);
    }

    public void writeSwitch(int i, CharacteristicParser.WriteServiceListener writeServiceListener) {
        writeService(i, this.storage.getSwitchOperationCharacteristic(), writeServiceListener);
    }

    public void writeStrokeLevel(int i, boolean z, CharacteristicParser.WriteServiceListener writeServiceListener) {
        writeService(Integer.parseInt(i + (z ? "1" : Switcher.SwitcherReservation.SWITCH_1WAY_FIRMWARE), 16), this.storage.getSwitchStrokeLevelCharacteristic(), writeServiceListener);
    }

    public void writeAddTimer(String str, String str2, CharacteristicParser.WriteServiceListener writeServiceListener) {
        if (str.length() != 12) {
            printResultOfWriteCharacteristic(false, str);
        } else {
            writeService("00" + str + str2, this.storage.getTimerOperationCharacteristic(), writeServiceListener);
        }
    }

    public void writeRemoveTimer(String str, String str2, CharacteristicParser.WriteServiceListener writeServiceListener) {
        String strHexToHexString = BLEUtil.hexToHexString(str);
        if (strHexToHexString.length() != 2) {
            printResultOfWriteCharacteristic(false, str);
        } else {
            writeService("01" + strHexToHexString + "0000000000" + str2, this.storage.getTimerOperationCharacteristic(), writeServiceListener);
        }
    }

    public void writeRealTime(CharacteristicParser.WriteServiceListener writeServiceListener) {
        Calendar calendar = Calendar.getInstance();
        writeService(String.format("%02x", Integer.valueOf(BLEUtil.getDayOfWeekNumberForSwitcher(calendar.get(7)))) + String.format("%02x", Integer.valueOf(calendar.get(11))) + String.format("%02x", Integer.valueOf(calendar.get(12))), this.storage.getRealtimeCharacteristic(), writeServiceListener);
    }

    private void printResultOfWriteCharacteristic(boolean z, String str) {
        if (z) {
            Log.i(this.TAG, "successfully wrote " + str);
        } else {
            Log.i(this.TAG, " failed to wrote " + str);
        }
    }
}
