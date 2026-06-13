package kr.switcher.ioble.switcher.connector;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public class CharacteristicParser implements CharacteristicStatusListener {
    private ReadServiceListener readServiceListener;
    private WriteServiceListener writeServiceListener;

    public interface ReadServiceListener {
        void onReadServiceResult(String str, UUID uuid);
    }

    public interface WriteServiceListener {
        void onWriteServiceResult(boolean z, UUID uuid);
    }

    @Override // kr.switcher.ioble.switcher.connector.CharacteristicStatusListener
    public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
    }

    @Override // kr.switcher.ioble.switcher.connector.CharacteristicStatusListener
    public void onDescriptorRead(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
    }

    @Override // kr.switcher.ioble.switcher.connector.CharacteristicStatusListener
    public void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
    }

    @Override // kr.switcher.ioble.switcher.connector.CharacteristicStatusListener
    public void onMtuChanged(BluetoothGatt bluetoothGatt, int i, int i2) {
    }

    @Override // kr.switcher.ioble.switcher.connector.CharacteristicStatusListener
    public void onReadRemoteRssi(BluetoothGatt bluetoothGatt, int i, int i2) {
    }

    @Override // kr.switcher.ioble.switcher.connector.CharacteristicStatusListener
    public void onReliableWriteCompleted(BluetoothGatt bluetoothGatt, int i) {
    }

    public void setReadServiceListener(ReadServiceListener readServiceListener) {
        this.readServiceListener = readServiceListener;
    }

    public void setWriteServiceListener(WriteServiceListener writeServiceListener) {
        this.writeServiceListener = writeServiceListener;
    }

    @Override // kr.switcher.ioble.switcher.connector.CharacteristicStatusListener
    public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
        this.readServiceListener.onReadServiceResult(CharacteristicReadParser.parse(bluetoothGattCharacteristic), bluetoothGattCharacteristic.getUuid());
    }

    @Override // kr.switcher.ioble.switcher.connector.CharacteristicStatusListener
    public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
        this.writeServiceListener.onWriteServiceResult(CharacteristicWriteResult.result(i), bluetoothGattCharacteristic.getUuid());
    }
}
