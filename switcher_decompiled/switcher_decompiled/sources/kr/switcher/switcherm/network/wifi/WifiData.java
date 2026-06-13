package kr.switcher.switcherm.network.wifi;

import android.net.wifi.ScanResult;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public class WifiData implements Parcelable {
    public static final int OPEN = 0;
    public static final int WPA = 1;
    public static final int WPA2 = 2;
    private String bssid;
    private String oauth;
    private ScanResult scanResult;
    private String sec;
    private String ssid;
    private final String[] OAUTH_MODES = {"WEP", "WPA", "WPA2", "WPA_EAP", "IEEE8021X"};
    private final String[] SEC_MODE = {"CCMP", "TKIP"};
    private String password = "";

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public WifiData(ScanResult scanResult) {
        this.ssid = "";
        this.ssid = scanResult.SSID;
        this.bssid = scanResult.BSSID;
        this.oauth = scanResult.capabilities;
        this.sec = getSec(scanResult);
        this.scanResult = scanResult;
    }

    public String getSec(ScanResult scanResult) {
        String str = scanResult.capabilities;
        for (int length = this.SEC_MODE.length - 1; length >= 0; length--) {
            if (str.contains(this.SEC_MODE[length])) {
                return this.SEC_MODE[length];
            }
        }
        return "";
    }

    public String getSsid() {
        return this.ssid;
    }

    public void setSsid(String str) {
        this.ssid = str;
    }

    public String getBssid() {
        return this.bssid;
    }

    public void setBssid(String str) {
        this.bssid = str;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String str) {
        this.password = str;
    }

    public String getOauth() {
        return this.oauth;
    }

    public int getOAuthCode() {
        String str = this.oauth;
        for (int length = this.OAUTH_MODES.length - 1; length >= 0; length--) {
            if (str.contains(this.OAUTH_MODES[length])) {
                return length;
            }
        }
        return 0;
    }

    public void setOauth(String str) {
        this.oauth = str;
    }

    public String getSec() {
        return this.sec;
    }

    public void setSec(String str) {
        this.sec = str;
    }

    public ScanResult getScanResult() {
        return this.scanResult;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.ssid);
        parcel.writeString(this.password);
        parcel.writeString(this.oauth);
    }
}
