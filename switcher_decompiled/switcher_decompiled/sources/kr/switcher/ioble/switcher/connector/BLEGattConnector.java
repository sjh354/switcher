package kr.switcher.ioble.switcher.connector;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import kr.switcher.ioble.common.BLEUtil;
import kr.switcher.ioble.protocol.CharacteristicStorage;
import kr.switcher.ioble.protocol.SwitcherBLEService;
import kr.switcher.ioble.switcher.connector.BLEConnectionStatusChecker;

/* JADX INFO: loaded from: classes2.dex */
public class BLEGattConnector implements BLEConnectionStatusChecker.BLECheckStateListener {
    private BLEConnectionInfo connectionInfo;
    private BLEConnectionStatusListener listener;

    public interface BLEConnectionStatusListener {
        void onConnected(BLEConnectionInfo bLEConnectionInfo);

        void onDisconnected(String str, int i);
    }

    public BLEGattConnector(SwitcherBLEService switcherBLEService, BLEConnectionStatusListener bLEConnectionStatusListener) {
        this.listener = bLEConnectionStatusListener;
        this.connectionInfo = new BLEConnectionInfo(switcherBLEService);
    }

    public void connectBLEDevice(Context context, BluetoothDevice bluetoothDevice) {
        bluetoothDevice.connectGatt(context, false, new BLEStateChangeListener(this, this.connectionInfo.getCharacteristicParser()));
    }

    public void disconnectBLEDevice(BluetoothGatt bluetoothGatt) {
        BLEUtil.refreshCache(bluetoothGatt, false);
        if (bluetoothGatt != null) {
            bluetoothGatt.close();
        }
    }

    @Override // kr.switcher.ioble.switcher.connector.BLEConnectionStatusChecker.BLECheckStateListener
    public void onConnectionSuccess(final BluetoothGatt bluetoothGatt) {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: kr.switcher.ioble.switcher.connector.BLEGattConnector.1
            @Override // java.lang.Runnable
            public void run() {
                bluetoothGatt.discoverServices();
            }
        }, 600L);
    }

    @Override // kr.switcher.ioble.switcher.connector.BLEConnectionStatusChecker.BLECheckStateListener
    public void onConnectionFail(String str, int i) {
        BLEConnectionInfo bLEConnectionInfo;
        if (i != 0 && i != 8 && i != 19 && (bLEConnectionInfo = this.connectionInfo) != null && bLEConnectionInfo.getBluetoothGatt() != null) {
            BLEUtil.removeBond(this.connectionInfo.getBluetoothGatt().getDevice());
        }
        this.listener.onDisconnected(str, i);
    }

    @Override // kr.switcher.ioble.switcher.connector.BLEConnectionStatusChecker.BLECheckStateListener
    public void onServiceDiscoveredSuccess(BluetoothGatt bluetoothGatt) {
        Log.i("BLEGattConnector", "Discovered services number : " + bluetoothGatt.getServices().size());
        if (bluetoothGatt.getServices().size() == CharacteristicStorage.SERVICE_NUM) {
            this.connectionInfo.setBluetoothGatt(bluetoothGatt);
            this.listener.onConnected(this.connectionInfo);
        } else {
            Log.e("BLEGattConnector", "GATT Service size : " + bluetoothGatt.getServices().size());
            repairAndOnDisconnect(bluetoothGatt);
        }
    }

    public void repairAndOnDisconnect(final BluetoothGatt bluetoothGatt) {
        bluetoothGatt.disconnect();
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: kr.switcher.ioble.switcher.connector.BLEGattConnector.2
            @Override // java.lang.Runnable
            public void run() {
                BLEUtil.createBond(bluetoothGatt.getDevice());
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: kr.switcher.ioble.switcher.connector.BLEGattConnector.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        BLEUtil.removeBond(bluetoothGatt.getDevice());
                        BLEGattConnector.this.listener.onDisconnected(bluetoothGatt.getDevice().getAddress(), 13);
                    }
                }, 3000L);
            }
        }, 1000L);
    }
}
