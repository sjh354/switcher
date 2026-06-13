package kr.switcher.device.switcher;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import kr.switcher.device.IODevice;
import kr.switcher.device.common.DeviceUtil;
import kr.switcher.device.switcher.Switcher;
import kr.switcher.device.switcher.ble.BLEScanner;
import kr.switcher.device.switcher.ble.ScannedBLESwitcher;
import kr.switcher.device.switcher.interfaces.IODeviceCallbacks;
import kr.switcher.device.switcher.linker.SwitcherLinker;
import kr.switcher.device.switcher.linker.http.RestLinkerAPIStore;
import kr.switcher.device.switcher.linker.http.response.HttpAPIResponse;
import kr.switcher.device.switcher.linker.http.response.HttpResponseHandler;
import kr.switcher.device.switcher.linker.http.response.ThingAPIResponse;

/* JADX INFO: loaded from: classes2.dex */
public class SwitcherConnector implements IODeviceCallbacks.OnDeviceConnectListener, BLEScanner.SwitcherBLESCanCallback {
    private static final String TAG = "SwitcherConnector";
    private IODeviceCallbacks.SwitcherConnectionResultCallback callback;
    private Handler connectionTimeoutHandler = new Handler(Looper.getMainLooper());
    private Runnable connectionTimeoutRunnable;
    private BLEScanner scanner;
    private Switcher switcher;

    public SwitcherConnector(Switcher switcher, BLEScanner bLEScanner, IODeviceCallbacks.SwitcherConnectionResultCallback switcherConnectionResultCallback) {
        this.switcher = switcher;
        this.callback = switcherConnectionResultCallback;
        this.scanner = bLEScanner;
    }

    public int connectSwitcher() {
        return connectSwitcher(this.switcher);
    }

    private int connectSwitcher(Switcher switcher) {
        String shareCode = switcher.getShareCode();
        if ((shareCode == null || shareCode.length() != 4) && switcher.getOwner() != null) {
            Log.i(TAG, "has not hashing code");
            return 113;
        }
        int iConnect = switcher.connect(this);
        if (iConnect == 1) {
            Log.i(TAG, "connect (macaddress:" + switcher.getMacAddress() + ")");
            timeoutConnection(switcher);
            return 1;
        }
        if (iConnect == 202) {
            scanSwitcher(switcher.getMacAddress());
            searchLinkedSwitcher(switcher.getMacAddress());
        }
        return iConnect;
    }

    private void scanSwitcher(String str) {
        this.scanner.scanSwitcher(str, this);
        Log.i(TAG, "scan switcher (mac address:" + str + ")");
    }

    private void searchLinkedSwitcher(String str) {
        RestLinkerAPIStore.requestGetDevice(str, new HttpResponseHandler() { // from class: kr.switcher.device.switcher.SwitcherConnector.1
            @Override // kr.switcher.device.switcher.linker.http.response.HttpResponseHandler
            public void onFailure(String str2, String str3) {
            }

            @Override // kr.switcher.device.switcher.linker.http.response.HttpResponseHandler
            public void onSuccess(HttpAPIResponse httpAPIResponse) {
                ThingAPIResponse thingAPIResponse = (ThingAPIResponse) httpAPIResponse;
                if (thingAPIResponse != null) {
                    IODevice.ThingConnectionStatus thingConnectionStatusConvertThingConnectionStatus = DeviceUtil.convertThingConnectionStatus(thingAPIResponse.connection_status);
                    if (thingConnectionStatusConvertThingConnectionStatus.equals(IODevice.ThingConnectionStatus.ALIVE)) {
                        SwitcherLinker switcherLinker = new SwitcherLinker(SwitcherConnector.this.switcher.getMacAddress(), SwitcherConnector.this.switcher.getSerialNumber(), SwitcherConnector.this.switcher.getName(), SwitcherConnector.this.switcher.getProductId(), SwitcherConnector.this.switcher.getShareCode(), SwitcherConnector.this.switcher.getOwner(), SwitcherConnector.this.switcher.getOption(), thingConnectionStatusConvertThingConnectionStatus);
                        switcherLinker.setBattery(SwitcherConnector.this.switcher.getBattery());
                        SwitcherConnector.this.switcher = switcherLinker;
                        SwitcherConnector.this.connectSwitcher();
                    }
                }
            }
        });
    }

    private void timeoutConnection(Switcher switcher) {
        removeConnectionTimeoutRunnable();
        Runnable connectionTimeoutRunnable = getConnectionTimeoutRunnable(switcher);
        this.connectionTimeoutRunnable = connectionTimeoutRunnable;
        this.connectionTimeoutHandler.postDelayed(connectionTimeoutRunnable, 10000L);
    }

    private void removeConnectionTimeoutRunnable() {
        Handler handler = this.connectionTimeoutHandler;
        if (handler != null) {
            handler.removeCallbacks(this.connectionTimeoutRunnable);
        }
    }

    private Runnable getConnectionTimeoutRunnable(final Switcher switcher) {
        return new Runnable() { // from class: kr.switcher.device.switcher.SwitcherConnector.2
            @Override // java.lang.Runnable
            public void run() {
                if (switcher.getConnectionState().equals(Switcher.ConnectionState.CONNECTED)) {
                    return;
                }
                switcher.setAuthority(-1);
                switcher.setConnectionState(Switcher.ConnectionState.FAILED);
                Log.i(SwitcherConnector.TAG, "connect timeout");
            }
        };
    }

    public void disconnectSwitcher() {
        this.switcher.disconnect();
        Log.i(TAG, "disconnect (macaddress:" + this.switcher.getMacAddress() + ")");
    }

    public Switcher getSwitcherToConnect() {
        return this.switcher;
    }

    @Override // kr.switcher.device.switcher.interfaces.IODeviceCallbacks.OnDeviceConnectListener
    public void onConnected(IODevice iODevice) {
        Switcher switcher = (Switcher) iODevice;
        if (switcher.getConnectionState().equals(Switcher.ConnectionState.CONNECTED)) {
            removeConnectionTimeoutRunnable();
        }
        this.callback.onConnectionStateResult(switcher, 0);
    }

    @Override // kr.switcher.device.switcher.interfaces.IODeviceCallbacks.OnDeviceConnectListener
    public void onDisconnected(String str, int i) {
        Log.i(TAG, "connection result - mac address : " + str + ", result status : " + i);
        this.switcher.setConnectionState(Switcher.ConnectionState.IDLE);
        this.callback.onConnectionStateResult(this.switcher, i);
    }

    @Override // kr.switcher.device.switcher.ble.BLEScanner.SwitcherBLESCanCallback
    public void onFoundMainSwitcherResult(ScannedBLESwitcher scannedBLESwitcher) {
        this.switcher.attachToDevice(scannedBLESwitcher);
        this.switcher.setConnectionState(Switcher.ConnectionState.CONNECTING);
        this.callback.onConnectionStateResult(this.switcher, 0);
        connectSwitcher();
        this.scanner.stopScan();
        Log.i(TAG, "found main switcher : " + scannedBLESwitcher.getDevice().getAddress());
    }

    @Override // kr.switcher.device.switcher.ble.BLEScanner.SwitcherBLESCanCallback
    public void onScanStatus(int i) {
        Log.i(TAG, "scan status : " + i);
    }
}
