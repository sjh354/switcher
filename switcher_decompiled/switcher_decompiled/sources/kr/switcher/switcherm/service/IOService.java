package kr.switcher.switcherm.service;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.IBinder;
import android.os.PowerManager;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import kr.switcher.device.switcher.Switcher;
import kr.switcher.device.switcher.SwitcherConnector;
import kr.switcher.device.switcher.ble.BLEScanner;
import kr.switcher.device.switcher.ble.ScannedBLESwitcher;
import kr.switcher.device.switcher.interfaces.IODeviceCallbacks;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.database.DBIODeviceDAO;
import kr.switcher.switcherm.device.IODeviceHandler;
import kr.switcher.switcherm.device.switcher.handler.SwitcherHandler;
import kr.switcher.switcherm.device.switcher.handler.SwitcherUtil;
import kr.switcher.switcherm.preference.OAuthToken;
import kr.switcher.switcherm.ui.main.event.SwitcherOnOffController;

/* JADX INFO: loaded from: classes2.dex */
public class IOService extends Service implements IODeviceCallbacks.SwitcherConnectionResultCallback, IODeviceCallbacks.OnControlResponseListener {
    public static String BORAD_CAST_NOTIFICATION = "kr.switcher.switcherm.service.ioservice.broadcast.BUTTON_CLICEKD";
    public static String PARM_AIRCON_BUTTON = "AIRCON_BUTTON";
    public static String PARM_CHECKER_REFRESH_BUTTON = "CHECKER_REFRESH_BUTTON";
    public static String PARM_SETTOP_BUTTON = "SETTOP_BUTTON";
    public static String PARM_SWITCHER_ADDRESS = "PARM_SWITCHER_ADDRESS";
    public static String PARM_SWITCH_POSITION = "PARM_SWITCH_POSITION";
    private static String TAG = "IOService";
    private SwitcherConnector connector;
    private int light;
    private Timer timer = null;
    private BroadcastReceiver notifyBroadcastReceiver = new BroadcastReceiver() { // from class: kr.switcher.switcherm.service.IOService.2
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String stringExtra = intent.getStringExtra(IOService.PARM_SWITCHER_ADDRESS);
            IOService.this.light = intent.getIntExtra(IOService.PARM_SWITCH_POSITION, -1);
            IOLog.i(IOService.TAG, "light : " + IOService.this.light);
            if (IOService.this.light < 0) {
                return;
            }
            Switcher switcher = SwitcherHandler.getInstance().getSwitcher(stringExtra);
            if (switcher == null) {
                IOLog.i(IOService.TAG, "switcher is null");
                return;
            }
            if (!switcher.getConnectionState().equals(Switcher.ConnectionState.CONNECTED)) {
                IOService.this.connectMainSwitcher(switcher);
            } else {
                IOService iOService = IOService.this;
                iOService.controlSwitcher(switcher, iOService.light);
            }
            IOLog.i(IOService.TAG, "connect switcher : " + stringExtra);
        }
    };

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // kr.switcher.device.switcher.interfaces.IODeviceCallbacks.OnControlResponseListener
    public void onControlResult(boolean z) {
    }

    @Override // android.app.Service
    public void onCreate() {
        IOLog.i(TAG, "onCreateRemocon()");
        if (IODeviceHandler.getInstance() == null) {
            DBIODeviceDAO.setContext(this);
            new IODeviceHandler.Builder().build();
        }
        this.timer = new Timer();
        registerReceiver(this.notifyBroadcastReceiver, makeIntentFilter());
    }

    private IntentFilter makeIntentFilter() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(BORAD_CAST_NOTIFICATION);
        return intentFilter;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        IOLog.i(TAG, "onStartCommand()");
        this.timer.scheduleAtFixedRate(new TimerAction(), 0L, 10000L);
        return 1;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        stopSelf();
        this.timer.cancel();
        unregisterReceiver(this.notifyBroadcastReceiver);
        IOLog.i(TAG, "onScreenOff()");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean scanMyDevice() {
        IOLog.i(TAG, "scanMyDevice");
        List<String> connectedDeviceAddress = SwitcherUtil.getConnectedDeviceAddress();
        if (connectedDeviceAddress.size() <= 0) {
            return true;
        }
        Iterator<String> it = connectedDeviceAddress.iterator();
        while (it.hasNext()) {
            IOLog.i(TAG, "connected device : " + it.next());
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void connectMainSwitcher(final Switcher switcher) {
        IOLog.i(TAG, "scanning my switcher... (" + switcher.getMacAddress() + ")");
        final BLEScanner bLEScanner = new BLEScanner();
        bLEScanner.scanSwitcher(switcher.getMacAddress(), new BLEScanner.SwitcherBLESCanCallback() { // from class: kr.switcher.switcherm.service.IOService.1
            @Override // kr.switcher.device.switcher.ble.BLEScanner.SwitcherBLESCanCallback
            public void onFoundMainSwitcherResult(ScannedBLESwitcher scannedBLESwitcher) {
                switcher.attachToDevice(scannedBLESwitcher);
                if (new SwitcherConnector(switcher, bLEScanner, IOService.this).connectSwitcher() == 1) {
                    IOLog.i(IOService.TAG, "switcher is connected");
                } else {
                    IOLog.i(IOService.TAG, "failed to onConnectToSwitcher");
                }
            }

            @Override // kr.switcher.device.switcher.ble.BLEScanner.SwitcherBLESCanCallback
            public void onScanStatus(int i) {
                switch (i) {
                    case 301:
                        IOLog.error(IOService.TAG, new OAuthToken().getOAuthToken(), "addDevice", new Exception("device is null"));
                        break;
                    case 302:
                        IOLog.error(IOService.TAG, new OAuthToken().getOAuthToken(), "addDevice", new Exception("device name is null"));
                        break;
                    case 303:
                        break;
                    case 304:
                        IOLog.error(IOService.TAG, new OAuthToken().getOAuthToken(), "addDevice", new Exception("invalid address"));
                        break;
                    case 305:
                        IOLog.error(IOService.TAG, new OAuthToken().getOAuthToken(), "addDevice", new Exception("advertising's serial number is null"));
                        break;
                    default:
                        IOLog.error(IOService.TAG, new OAuthToken().getOAuthToken(), "onScanFailed", new Exception("scan fail (error code : " + i + ")"));
                        break;
                }
            }
        });
    }

    private void disconnectSwitcher(String str) {
        Switcher.ConnectionState connectionState = SwitcherUtil.getConnectedDeviceAddress() != null ? Switcher.ConnectionState.CONNECTED : Switcher.ConnectionState.IDLE;
        IOLog.i(TAG, "connection state : " + connectionState);
        if (connectionState.equals(Switcher.ConnectionState.CONNECTED)) {
            this.connector.disconnectSwitcher();
        }
    }

    @Override // kr.switcher.device.switcher.interfaces.IODeviceCallbacks.SwitcherConnectionResultCallback
    public void onConnectionStateResult(Switcher switcher, int i) {
        IOLog.i(TAG, "switcher state : " + Switcher.ConnectionState.CONNECTED);
        if (switcher.getConnectionState().equals(Switcher.ConnectionState.CONNECTED)) {
            controlSwitcher(switcher, this.light);
        }
    }

    public class TimerAction extends TimerTask {
        public TimerAction() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            IOService.this.scanMyDevice();
            isScreenOn();
        }

        private boolean isScreenOn() {
            PowerManager powerManager = (PowerManager) IOService.this.getSystemService("power");
            if (Build.VERSION.SDK_INT < 21) {
                return powerManager.isScreenOn();
            }
            return powerManager.isInteractive();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void controlSwitcher(Switcher switcher, int i) {
        new SwitcherOnOffController(switcher).controlSwitch(i, this);
        IOLog.i(TAG, "control switch");
    }
}
