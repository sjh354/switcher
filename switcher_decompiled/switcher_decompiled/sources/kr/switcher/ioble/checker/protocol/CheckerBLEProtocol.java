package kr.switcher.ioble.checker.protocol;

import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public class CheckerBLEProtocol {
    public static final String BASE_UUID_STRING = "-0000-1000-8000-00805f9b34fb";
    public static final String CLIENT_CHARACTERISTIC_CONFIG = "00002902-0000-1000-8000-00805f9b34fb";
    public static final UUID UUID_FOR_WIFI_SSID_SERVICE = UUID.fromString("0000450A-0000-1000-8000-00805f9b34fb");
    public static final UUID UUID_FOR_WIFI_SSID_CHARACTERISTIC = UUID.fromString("000045AA-0000-1000-8000-00805f9b34fb");
    public static final UUID UUID_FOR_WIFI_PASSWORD_SERVICE = UUID.fromString("0000450B-0000-1000-8000-00805f9b34fb");
    public static final UUID UUID_FOR_WIFI_PASSWORD_CHARACTERISTIC = UUID.fromString("000045BA-0000-1000-8000-00805f9b34fb");
    public static final UUID UUID_FOR_ACCESS_TOKEN_SERVICE = UUID.fromString("0000450C-0000-1000-8000-00805f9b34fb");
    public static final UUID UUID_FOR_ACCESS_TOKEN_CHARACTERISTIC = UUID.fromString("000045CA-0000-1000-8000-00805f9b34fb");
}
