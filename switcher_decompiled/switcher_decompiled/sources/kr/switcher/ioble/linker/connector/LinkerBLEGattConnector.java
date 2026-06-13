package kr.switcher.ioble.linker.connector;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import kr.switcher.ioble.common.BLEUtil;
import kr.switcher.ioble.linker.protocol.LinkerBLEService;
import kr.switcher.ioble.switcher.connector.BLEConnectionStatusChecker;
import kr.switcher.ioble.switcher.connector.BLEStateChangeListener;

/* JADX INFO: loaded from: classes2.dex */
public class LinkerBLEGattConnector implements BLEConnectionStatusChecker.BLECheckStateListener {
    private LinkerBLEConnectionInfo connectionInfo;
    private LinkerBLEConnectionStatusListener listener;

    public interface LinkerBLEConnectionStatusListener {
        void onConnected(LinkerBLEConnectionInfo linkerBLEConnectionInfo);

        void onDisconnected(String str, int i);
    }

    public LinkerBLEGattConnector(LinkerBLEService linkerBLEService, LinkerBLEConnectionStatusListener linkerBLEConnectionStatusListener) {
        this.listener = linkerBLEConnectionStatusListener;
        this.connectionInfo = new LinkerBLEConnectionInfo(linkerBLEService);
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
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: kr.switcher.ioble.linker.connector.LinkerBLEGattConnector.1
            @Override // java.lang.Runnable
            public void run() {
                bluetoothGatt.discoverServices();
            }
        }, 600L);
    }

    @Override // kr.switcher.ioble.switcher.connector.BLEConnectionStatusChecker.BLECheckStateListener
    public void onConnectionFail(String str, int i) {
        LinkerBLEConnectionInfo linkerBLEConnectionInfo;
        if (i != 0 && i != 8 && i != 19 && (linkerBLEConnectionInfo = this.connectionInfo) != null && linkerBLEConnectionInfo.getBluetoothGatt() != null) {
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
