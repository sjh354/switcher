package kr.switcher.ioble.checker.connector;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import kr.switcher.ioble.checker.protocol.CheckerBLEService;
import kr.switcher.ioble.common.BLEUtil;
import kr.switcher.ioble.switcher.connector.BLEConnectionStatusChecker;
import kr.switcher.ioble.switcher.connector.BLEStateChangeListener;

/* JADX INFO: loaded from: classes2.dex */
public class CheckerBLEGattConnector implements BLEConnectionStatusChecker.BLECheckStateListener {
    private CheckerBLEConnectionInfo connectionInfo;
    private CheckerBLEConnectionStatusListener listener;

    public interface CheckerBLEConnectionStatusListener {
        void onConnected(CheckerBLEConnectionInfo checkerBLEConnectionInfo);

        void onDisconnected(String str, int i);
    }

    public CheckerBLEGattConnector(CheckerBLEService checkerBLEService, CheckerBLEConnectionStatusListener checkerBLEConnectionStatusListener) {
        this.listener = checkerBLEConnectionStatusListener;
        this.connectionInfo = new CheckerBLEConnectionInfo(checkerBLEService);
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
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: kr.switcher.ioble.checker.connector.CheckerBLEGattConnector.1
            @Override // java.lang.Runnable
            public void run() {
                bluetoothGatt.discoverServices();
            }
        }, 600L);
    }

    @Override // kr.switcher.ioble.switcher.connector.BLEConnectionStatusChecker.BLECheckStateListener
    public void onConnectionFail(String str, int i) {
        CheckerBLEConnectionInfo checkerBLEConnectionInfo;
        if (i != 0 && i != 8 && i != 19 && (checkerBLEConnectionInfo = this.connectionInfo) != null && checkerBLEConnectionInfo.getBluetoothGatt() != null) {
            BLEUtil.removeBond(this.connectionInfo.getBluetoothGatt().getDevice());
        }
        this.listener.onDisconnected(str, i);
    }

    @Override // kr.switcher.ioble.switcher.connector.BLEConnectionStatusChecker.BLECheckStateListener
    public void onServiceDiscoveredSuccess(BluetoothGatt bluetoothGatt) {
        this.connectionInfo.setBluetoothGatt(bluetoothGatt);
        this.listener.onConnected(this.connectionInfo);
    }
}
