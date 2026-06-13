package kr.switcher.switcherm.network.wifi;

import android.content.Context;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;

/* JADX INFO: loaded from: classes2.dex */
public class WifiConnector {
    private Context context;

    public WifiConnector(Context context) {
        this.context = context;
    }

    public void connectWifi(WifiData wifiData) {
        WifiConfiguration wifiConfiguration = new WifiConfiguration();
        wifiConfiguration.SSID = "\"".concat(wifiData.getSsid()).concat("\"");
        wifiConfiguration.status = 1;
        wifiConfiguration.priority = 40;
        int oAuthCode = wifiData.getOAuthCode();
        if (oAuthCode == 0) {
            wifiConfiguration.allowedKeyManagement.set(0);
            wifiConfiguration.allowedProtocols.set(1);
            wifiConfiguration.allowedProtocols.set(0);
            wifiConfiguration.allowedAuthAlgorithms.clear();
            wifiConfiguration.allowedPairwiseCiphers.set(2);
        } else if (oAuthCode == 1) {
            wifiConfiguration.allowedKeyManagement.set(0);
            wifiConfiguration.allowedProtocols.set(1);
            wifiConfiguration.allowedProtocols.set(0);
            wifiConfiguration.allowedAuthAlgorithms.set(0);
            wifiConfiguration.allowedAuthAlgorithms.set(1);
            wifiConfiguration.allowedPairwiseCiphers.set(2);
            wifiConfiguration.allowedGroupCiphers.set(0);
            wifiConfiguration.allowedGroupCiphers.set(1);
            wifiConfiguration.wepKeys[0] = wifiData.getPassword();
            wifiConfiguration.wepTxKeyIndex = 0;
        } else if (oAuthCode == 2) {
            wifiConfiguration.allowedAuthAlgorithms.set(0);
            wifiConfiguration.allowedProtocols.set(1);
            wifiConfiguration.allowedKeyManagement.set(1);
            wifiConfiguration.allowedPairwiseCiphers.set(2);
            wifiConfiguration.allowedPairwiseCiphers.set(1);
            wifiConfiguration.allowedGroupCiphers.set(3);
            wifiConfiguration.allowedGroupCiphers.set(2);
            wifiConfiguration.preSharedKey = "\"".concat(wifiData.getPassword()).concat("\"");
        }
        connect(wifiConfiguration);
    }

    private void connect(WifiConfiguration wifiConfiguration) {
        WifiManager wifiManager = (WifiManager) this.context.getSystemService("wifi");
        if (!wifiManager.isWifiEnabled()) {
            wifiManager.setWifiEnabled(true);
        }
        int iAddNetwork = wifiManager.addNetwork(wifiConfiguration);
        if (iAddNetwork != -1) {
            wifiManager.enableNetwork(iAddNetwork, true);
        }
    }

    public String getConnectedSSID() {
        return ((WifiManager) this.context.getSystemService("wifi")).getConnectionInfo().getSSID();
    }
}
