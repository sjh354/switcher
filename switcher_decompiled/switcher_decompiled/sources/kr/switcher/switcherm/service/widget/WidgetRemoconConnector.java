package kr.switcher.switcherm.service.widget;

import android.os.Handler;
import kr.switcher.device.IODevice;
import kr.switcher.device.remocon.Remocon;
import kr.switcher.device.switcher.interfaces.IODeviceCallbacks;
import kr.switcher.switcherm.common.util.IOLog;

/* JADX INFO: loaded from: classes2.dex */
public class WidgetRemoconConnector implements IODeviceCallbacks.OnDeviceConnectListener {
    private static final String TAG = "WidgetRemoconConnector";
    private static boolean isConnecting = false;
    private final int CONNECTION_TIME_OUT = 10000;
    private Handler connectionTimeoutHandler;
    private Runnable connectionTimeoutRunnable;
    private IODevice ioDevice;
    private OnConnectAirconListener listener;
    private Remocon remocon;

    public interface OnConnectAirconListener {
        void onConnectionResult(IODevice iODevice);
    }

    @Override // kr.switcher.device.switcher.interfaces.IODeviceCallbacks.OnDeviceConnectListener
    public void onDisconnected(String str, int i) {
    }

    @Override // kr.switcher.device.switcher.interfaces.IODeviceCallbacks.OnDeviceConnectListener
    public void onConnected(IODevice iODevice) {
        setConnectingStatus(false);
        if (iODevice.getThingConnectionStatus().equals(IODevice.ThingConnectionStatus.ALIVE)) {
            Handler handler = this.connectionTimeoutHandler;
            if (handler != null) {
                handler.removeCallbacks(this.connectionTimeoutRunnable);
            }
            onConnectionResult(this.remocon);
            IOLog.reportConnectingTime(this.remocon.getMacAddress());
        }
    }

    public WidgetRemoconConnector(Remocon remocon, OnConnectAirconListener onConnectAirconListener) {
        this.remocon = remocon;
        this.listener = onConnectAirconListener;
    }

    public void remoconConnect() {
        onConnectionResult(this.remocon);
        if (isConnected(this.remocon)) {
            IOLog.i(TAG, "already connected");
            return;
        }
        if (isConnecting(this.remocon.getThingConnectionStatus())) {
            IOLog.i(TAG, "already connecting");
            return;
        }
        IOLog.i(TAG, "connect aircon (" + this.ioDevice.getMacAddress() + ")");
        this.remocon.setThingConnectionStatus(IODevice.ThingConnectionStatus.ALIVE);
        onConnectionResult(this.ioDevice);
        connectionTimeout(this.ioDevice);
        setConnectingStatus(true);
    }

    private void initConnectingStatus() {
        new Handler().postDelayed(new Runnable() { // from class: kr.switcher.switcherm.service.widget.WidgetRemoconConnector.1
            @Override // java.lang.Runnable
            public void run() {
                WidgetRemoconConnector.this.setConnectingStatus(false);
            }
        }, 3000L);
    }

    public void setConnectingStatus(boolean z) {
        isConnecting = z;
    }

    private void connectionTimeout(final IODevice iODevice) {
        this.connectionTimeoutHandler = new Handler();
        Runnable runnable = new Runnable() { // from class: kr.switcher.switcherm.service.widget.WidgetRemoconConnector.2
            @Override // java.lang.Runnable
            public void run() {
                IOLog.i(WidgetRemoconConnector.TAG, "failed connection");
                iODevice.setThingConnectionStatus(IODevice.ThingConnectionStatus.DEAD);
                WidgetRemoconConnector.this.onConnectionResult(iODevice);
                WidgetRemoconConnector.this.setConnectingStatus(false);
            }
        };
        this.connectionTimeoutRunnable = runnable;
        this.connectionTimeoutHandler.postDelayed(runnable, 10000L);
    }

    private boolean isConnecting(IODevice.ThingConnectionStatus thingConnectionStatus) {
        if (thingConnectionStatus.equals(IODevice.ThingConnectionStatus.ALIVE)) {
            return true;
        }
        if (!isConnecting) {
            return false;
        }
        initConnectingStatus();
        return true;
    }

    private boolean isConnected(IODevice iODevice) {
        return iODevice.equals(IODevice.ThingConnectionStatus.ALIVE);
    }

    public void disconnect() {
        this.remocon.disconnect();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onConnectionResult(IODevice iODevice) {
        OnConnectAirconListener onConnectAirconListener = this.listener;
        if (onConnectAirconListener != null) {
            onConnectAirconListener.onConnectionResult(iODevice);
        }
    }
}
