package kr.switcher.switcherm.service.widget;

import android.os.Handler;
import java.util.List;
import kr.switcher.device.switcher.Switcher;
import kr.switcher.device.switcher.SwitcherConnector;
import kr.switcher.device.switcher.ble.BLEScanner;
import kr.switcher.device.switcher.interfaces.IODeviceCallbacks;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.device.switcher.handler.SwitcherHandler;
import kr.switcher.switcherm.device.switcher.handler.SwitcherUtil;
import kr.switcher.switcherm.preference.AutoBluetoothPreference;
import kr.switcher.switcherm.signal.BatterySignal;

/* JADX INFO: loaded from: classes2.dex */
public class WidgetSwitcherConnector implements IODeviceCallbacks.SwitcherConnectionResultCallback {
    private static final String TAG = "WidgetSwitcherConnector";
    private static boolean isConnecting = false;
    private final int CONNECTION_TIME_OUT = 10000;
    private Handler connectionTimeoutHandler;
    private Runnable connectionTimeoutRunnable;
    private OnConnectSwitcherListener listener;
    private Switcher switcher;

    public interface OnConnectSwitcherListener {
        void onBatteryInfo(int i);

        void onConnectionResult(Switcher switcher);
    }

    public WidgetSwitcherConnector(Switcher switcher, OnConnectSwitcherListener onConnectSwitcherListener) {
        this.switcher = switcher;
        this.listener = onConnectSwitcherListener;
    }

    public void connect() {
        onConnectionResult(this.switcher);
        if (isConnected(this.switcher)) {
            IOLog.i(TAG, "already connected");
            return;
        }
        if (isConnecting(this.switcher.getConnectionState())) {
            IOLog.i(TAG, "already connecting");
            return;
        }
        IOLog.i(TAG, "connect switcher (" + this.switcher.getMacAddress() + ")");
        this.switcher.setConnectionState(Switcher.ConnectionState.CONNECTING);
        onConnectionResult(this.switcher);
        if (new AutoBluetoothPreference().getAutoBluetooth().booleanValue()) {
            SwitcherUtil.activeBluetoothIfOffWithDelay();
        }
        new SwitcherConnector(this.switcher, new BLEScanner(), this).connectSwitcher();
        connectionTimeout(this.switcher);
        setConnectingStatus(true);
    }

    private void initConnectingStatus() {
        new Handler().postDelayed(new Runnable() { // from class: kr.switcher.switcherm.service.widget.WidgetSwitcherConnector.1
            @Override // java.lang.Runnable
            public void run() {
                WidgetSwitcherConnector.this.setConnectingStatus(false);
            }
        }, 3000L);
    }

    public void setConnectingStatus(boolean z) {
        isConnecting = z;
    }

    private void connectionTimeout(final Switcher switcher) {
        this.connectionTimeoutHandler = new Handler();
        Runnable runnable = new Runnable() { // from class: kr.switcher.switcherm.service.widget.WidgetSwitcherConnector.2
            @Override // java.lang.Runnable
            public void run() {
                IOLog.i(WidgetSwitcherConnector.TAG, "failed connection");
                switcher.setConnectionState(Switcher.ConnectionState.FAILED);
                WidgetSwitcherConnector.this.onConnectionResult(switcher);
                WidgetSwitcherConnector.this.setConnectingStatus(false);
            }
        };
        this.connectionTimeoutRunnable = runnable;
        this.connectionTimeoutHandler.postDelayed(runnable, 10000L);
    }

    private boolean isConnecting(Switcher.ConnectionState connectionState) {
        if (connectionState.equals(Switcher.ConnectionState.CONNECTING)) {
            return true;
        }
        if (!isConnecting) {
            return false;
        }
        initConnectingStatus();
        return true;
    }

    private boolean isConnected(Switcher switcher) {
        return switcher.equals(Switcher.ConnectionState.CONNECTED);
    }

    public void disconnect() {
        this.switcher.disconnect();
    }

    public void disconnectList(List<Switcher> list) {
        for (Switcher switcher : list) {
            IOLog.i(TAG, "disconnect switcher (mac address:" + switcher.getMacAddress() + ")");
            switcher.disconnect();
        }
    }

    @Override // kr.switcher.device.switcher.interfaces.IODeviceCallbacks.SwitcherConnectionResultCallback
    public void onConnectionStateResult(Switcher switcher, int i) {
        setConnectingStatus(false);
        if (switcher.getConnectionState().equals(Switcher.ConnectionState.CONNECTED) && switcher.getAuthority() == 0) {
            Handler handler = this.connectionTimeoutHandler;
            if (handler != null) {
                handler.removeCallbacks(this.connectionTimeoutRunnable);
            }
            SwitcherHandler.getInstance().update(switcher);
            onConnectionResult(switcher);
            onBatteryInfo(BatterySignal.battery(switcher.getMacAddress(), switcher.getBattery()), switcher.getBattery());
            IOLog.reportConnectingTime(switcher.getMacAddress());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onConnectionResult(Switcher switcher) {
        OnConnectSwitcherListener onConnectSwitcherListener = this.listener;
        if (onConnectSwitcherListener != null) {
            onConnectSwitcherListener.onConnectionResult(switcher);
        }
    }

    public void onBatteryInfo(boolean z, int i) {
        OnConnectSwitcherListener onConnectSwitcherListener;
        if (!z || (onConnectSwitcherListener = this.listener) == null) {
            return;
        }
        onConnectSwitcherListener.onBatteryInfo(i);
    }
}
