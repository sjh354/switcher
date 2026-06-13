package kr.switcher.ioble.switcher.connector;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import kr.switcher.ioble.switcher.connector.BLEConnectionStatusChecker;

/* JADX INFO: loaded from: classes2.dex */
public class BLEStateChangeListener extends BluetoothGattCallback {
    private BLEConnectionStatusChecker.BLECheckStateListener bleCheckStateListener;
    private CharacteristicStatusListener characteristicStatusListener;
    private BLEConnectionStatusChecker checker = new BLEConnectionStatusChecker();

    public BLEStateChangeListener(BLEConnectionStatusChecker.BLECheckStateListener bLECheckStateListener, CharacteristicStatusListener characteristicStatusListener) {
        this.bleCheckStateListener = bLECheckStateListener;
        this.characteristicStatusListener = characteristicStatusListener;
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
        this.checker.checkBLEConnectionState(bluetoothGatt, i, i2, this.bleCheckStateListener);
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
        this.checker.checkBLEServiceDiscovered(bluetoothGatt, i, this.bleCheckStateListener);
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
        super.onCharacteristicRead(bluetoothGatt, bluetoothGattCharacteristic, i);
        this.characteristicStatusListener.onCharacteristicRead(bluetoothGatt, bluetoothGattCharacteristic, i);
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
        super.onCharacteristicWrite(bluetoothGatt, bluetoothGattCharacteristic, i);
        this.characteristicStatusListener.onCharacteristicWrite(bluetoothGatt, bluetoothGattCharacteristic, i);
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super.onCharacteristicChanged(bluetoothGatt, bluetoothGattCharacteristic);
        this.characteristicStatusListener.onCharacteristicChanged(bluetoothGatt, bluetoothGattCharacteristic);
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public void onDescriptorRead(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
        super.onDescriptorRead(bluetoothGatt, bluetoothGattDescriptor, i);
        this.characteristicStatusListener.onDescriptorRead(bluetoothGatt, bluetoothGattDescriptor, i);
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
        super.onDescriptorWrite(bluetoothGatt, bluetoothGattDescriptor, i);
        this.characteristicStatusListener.onDescriptorWrite(bluetoothGatt, bluetoothGattDescriptor, i);
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public void onReliableWriteCompleted(BluetoothGatt bluetoothGatt, int i) {
        super.onReliableWriteCompleted(bluetoothGatt, i);
        this.characteristicStatusListener.onReliableWriteCompleted(bluetoothGatt, i);
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public void onReadRemoteRssi(BluetoothGatt bluetoothGatt, int i, int i2) {
        super.onReadRemoteRssi(bluetoothGatt, i, i2);
        this.characteristicStatusListener.onReadRemoteRssi(bluetoothGatt, i, i2);
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public void onMtuChanged(BluetoothGatt bluetoothGatt, int i, int i2) {
        super.onMtuChanged(bluetoothGatt, i, i2);
        this.characteristicStatusListener.onMtuChanged(bluetoothGatt, i, i2);
    }
}
