package kr.switcher.ioble.switcher.connector;

import android.bluetooth.BluetoothGatt;

/* JADX INFO: loaded from: classes2.dex */
public class BLEConnectionStatusChecker {

    public interface BLECheckStateListener {
        void onConnectionFail(String str, int i);

        void onConnectionSuccess(BluetoothGatt bluetoothGatt);

        void onServiceDiscoveredSuccess(BluetoothGatt bluetoothGatt);
    }

    public void checkBLEConnectionState(BluetoothGatt bluetoothGatt, int i, int i2, BLECheckStateListener bLECheckStateListener) {
        if (i2 == 0) {
            bLECheckStateListener.onConnectionFail(bluetoothGatt.getDevice().getAddress(), i);
        } else {
            if (i2 != 2) {
                return;
            }
            bLECheckStateListener.onConnectionSuccess(bluetoothGatt);
        }
    }

    public void checkBLEServiceDiscovered(BluetoothGatt bluetoothGatt, int i, BLECheckStateListener bLECheckStateListener) {
        if (i == 0) {
            bLECheckStateListener.onServiceDiscoveredSuccess(bluetoothGatt);
        } else {
            bLECheckStateListener.onConnectionFail(bluetoothGatt.getDevice().getAddress(), i);
        }
    }
}
