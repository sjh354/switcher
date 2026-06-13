package kr.switcher.ioble.switcher.connector;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;

/* JADX INFO: loaded from: classes2.dex */
public interface CharacteristicStatusListener {
    void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic);

    void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i);

    void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i);

    void onDescriptorRead(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i);

    void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i);

    void onMtuChanged(BluetoothGatt bluetoothGatt, int i, int i2);

    void onReadRemoteRssi(BluetoothGatt bluetoothGatt, int i, int i2);

    void onReliableWriteCompleted(BluetoothGatt bluetoothGatt, int i);
}
