package kr.switcher.switcherm.network.wifi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import java.util.ArrayList;
import java.util.List;
import kr.switcher.switcherm.common.util.IOLog;

/* JADX INFO: loaded from: classes2.dex */
public class WifiScanner {
    private static final String TAG = "WifiScanner";
    private OnWifiResultCallback callback;
    private Context context;
    private IntentFilter intentFilter;
    private boolean isReg;
    private BroadcastReceiver receiver;
    private WifiManager wifiManager;

    public interface OnWifiResultCallback {
        void onWifiResult(List<WifiData> list);
    }

    public WifiScanner(Context context) {
        this.context = context;
        this.wifiManager = (WifiManager) context.getSystemService("wifi");
        IntentFilter intentFilter = new IntentFilter("android.net.wifi.SCAN_RESULTS");
        this.intentFilter = intentFilter;
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        setReceiver();
        context.registerReceiver(this.receiver, this.intentFilter);
        this.isReg = true;
    }

    public void setWifiResultCallback(OnWifiResultCallback onWifiResultCallback) {
        this.callback = onWifiResultCallback;
    }

    private void setReceiver() {
        this.receiver = new BroadcastReceiver() { // from class: kr.switcher.switcherm.network.wifi.WifiScanner.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                String action = intent.getAction();
                if (action.equals("android.net.wifi.SCAN_RESULTS")) {
                    if (WifiScanner.this.callback != null) {
                        OnWifiResultCallback onWifiResultCallback = WifiScanner.this.callback;
                        WifiScanner wifiScanner = WifiScanner.this;
                        onWifiResultCallback.onWifiResult(wifiScanner.getWifiInfoList(wifiScanner.wifiManager.getScanResults()));
                        return;
                    }
                    return;
                }
                if (action.equals("android.net.wifi.STATE_CHANGE")) {
                    context.sendBroadcast(new Intent("wifi.ON_NETWORK_STATE_CHANGED"));
                }
            }
        };
    }

    public void startScan() {
        this.wifiManager.startScan();
    }

    public void stopScan() {
        if (this.isReg) {
            this.context.unregisterReceiver(this.receiver);
            this.isReg = false;
        }
    }

    public IntentFilter getIntentFilter() {
        return this.intentFilter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<WifiData> getWifiInfoList(List<ScanResult> list) {
        ArrayList arrayList = new ArrayList();
        for (ScanResult scanResult : list) {
            IOLog.d(TAG, "scanned wifi list : " + scanResult.SSID);
            if (scanResult.SSID.length() > 0 && (scanResult.frequency <= 4900 || scanResult.frequency >= 5900)) {
                arrayList.add(new WifiData(scanResult));
            }
        }
        return arrayList;
    }
}
