package kr.switcher.ioble.linker.protocol;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.util.Log;
import kr.switcher.ioble.switcher.connector.CharacteristicParser;

/* JADX INFO: loaded from: classes2.dex */
public class LinkerBLEService {
    private BluetoothGatt gatt;
    private LinkerCharacteristicStorage storage;
    private String TAG = "LinkerBLEService";
    private CharacteristicParser parser = new CharacteristicParser();

    public void setBluetoothGatt(BluetoothGatt bluetoothGatt) {
        this.gatt = bluetoothGatt;
        this.storage = new LinkerCharacteristicStorage(bluetoothGatt);
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
        bluetoothGattCharacteristic.setValue(str.getBytes());
        printResultOfWriteCharacteristic(this.gatt.writeCharacteristic(bluetoothGattCharacteristic), str);
    }

    public void writeWifiSSID(String str, CharacteristicParser.WriteServiceListener writeServiceListener) {
        writeService(str, this.storage.getWifiSSIDCharacteristic(), writeServiceListener);
    }

    public void writeWifiPassword(String str, CharacteristicParser.WriteServiceListener writeServiceListener) {
        writeService(str, this.storage.getWifiPasswordCharacteristic(), writeServiceListener);
    }

    private void printResultOfWriteCharacteristic(boolean z, String str) {
        if (z) {
            Log.i(this.TAG, "successfully wrote " + str);
        } else {
            Log.i(this.TAG, " failed to wrote " + str);
        }
    }
}
