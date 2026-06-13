package kr.switcher.device.checker;

import android.util.Log;
import java.util.UUID;
import kr.switcher.device.IODevice;
import kr.switcher.device.common.DeviceUtil;
import kr.switcher.device.switcher.interfaces.IODeviceCallbacks;
import kr.switcher.ioble.checker.connector.CheckerBLEConnectionInfo;
import kr.switcher.ioble.checker.connector.CheckerBLEGattConnector;
import kr.switcher.ioble.checker.protocol.CheckerBLEService;
import kr.switcher.ioble.switcher.connector.CharacteristicParser;

/* JADX INFO: loaded from: classes2.dex */
public class Checker extends IODevice implements CheckerBLEGattConnector.CheckerBLEConnectionStatusListener {
    public static final String CHECKER_NAME = "CHECKER";
    private static final String TAG = "Checker";
    String batteryLevel;
    private CheckerBLEConnectionInfo connectionInfo;
    private CheckerBLEGattConnector connector;

    public interface OnWifiSSIDSendListener {
        void onWifiSSIDSendResult(boolean z);
    }

    public Checker(String str) {
        initialize(str);
    }

    public Checker(String str, ScannedBLEChecker scannedBLEChecker) {
        super(str, scannedBLEChecker);
        initialize(str);
    }

    private void initialize(String str) {
        this.macAddress = str;
        this.connector = new CheckerBLEGattConnector(new CheckerBLEService(), this);
        this.productId = IODevice.ProductId.CHECKER;
    }

    @Override // kr.switcher.device.IODevice
    public int connect(IODeviceCallbacks.OnDeviceConnectListener onDeviceConnectListener) {
        super.connect(onDeviceConnectListener);
        if (this.scannedBLEDevice != null && this.scannedBLEDevice.getDevice() != null) {
            this.connector.connectBLEDevice(DeviceUtil.getContext(), this.scannedBLEDevice.getDevice());
            return 1;
        }
        onDeviceConnectListener.onDisconnected(this.macAddress, 202);
        return 1;
    }

    @Override // kr.switcher.device.IODevice
    public void disconnect() {
        CheckerBLEConnectionInfo checkerBLEConnectionInfo = this.connectionInfo;
        if (checkerBLEConnectionInfo == null) {
            return;
        }
        this.connector.disconnectBLEDevice(checkerBLEConnectionInfo.getBluetoothGatt());
        reset();
        if (this.listener != null) {
            this.listener.onDisconnected(this.macAddress, 1);
        }
    }

    private void reset() {
        this.scannedBLEDevice = null;
        this.connectionInfo = null;
    }

    private boolean checkIsConnectionInfo() {
        if (this.connectionInfo != null) {
            return true;
        }
        if (this.listener != null) {
            this.listener.onDisconnected(this.macAddress, 0);
        }
        return false;
    }

    /* JADX INFO: renamed from: kr.switcher.device.checker.Checker$1, reason: invalid class name */
    class AnonymousClass1 implements CharacteristicParser.WriteServiceListener {
        final /* synthetic */ OnWifiSSIDSendListener val$listener;
        final /* synthetic */ String val$password;
        final /* synthetic */ String val$ssid;

        AnonymousClass1(String str, String str2, OnWifiSSIDSendListener onWifiSSIDSendListener) {
            this.val$ssid = str;
            this.val$password = str2;
            this.val$listener = onWifiSSIDSendListener;
        }

        @Override // kr.switcher.ioble.switcher.connector.CharacteristicParser.WriteServiceListener
        public void onWriteServiceResult(boolean z, UUID uuid) {
            if (z) {
                Checker.this.connectionInfo.getBLEService().writeWifiSSID(this.val$ssid, new CharacteristicParser.WriteServiceListener() { // from class: kr.switcher.device.checker.Checker.1.1
                    @Override // kr.switcher.ioble.switcher.connector.CharacteristicParser.WriteServiceListener
                    public void onWriteServiceResult(boolean z2, UUID uuid2) {
                        if (z2) {
                            Checker.this.connectionInfo.getBLEService().writeWifiPassword(AnonymousClass1.this.val$password, new CharacteristicParser.WriteServiceListener() { // from class: kr.switcher.device.checker.Checker.1.1.1
                                @Override // kr.switcher.ioble.switcher.connector.CharacteristicParser.WriteServiceListener
                                public void onWriteServiceResult(boolean z3, UUID uuid3) {
                                    AnonymousClass1.this.val$listener.onWifiSSIDSendResult(true);
                                }
                            });
                        } else {
                            AnonymousClass1.this.val$listener.onWifiSSIDSendResult(false);
                        }
                    }
                });
            }
        }
    }

    public void sendWifiInfo(String str, String str2, String str3, OnWifiSSIDSendListener onWifiSSIDSendListener) {
        if (checkIsConnectionInfo()) {
            this.connectionInfo.getBLEService().writeAccessToken(str3, new AnonymousClass1(str, str2, onWifiSSIDSendListener));
        }
    }

    @Override // kr.switcher.ioble.checker.connector.CheckerBLEGattConnector.CheckerBLEConnectionStatusListener
    public void onConnected(CheckerBLEConnectionInfo checkerBLEConnectionInfo) {
        Log.i(TAG, "checker ble connected (mac address:" + checkerBLEConnectionInfo.getMacAddress() + ")");
        this.connectionInfo = checkerBLEConnectionInfo;
        this.listener.onConnected(this);
    }

    @Override // kr.switcher.ioble.checker.connector.CheckerBLEGattConnector.CheckerBLEConnectionStatusListener
    public void onDisconnected(String str, int i) {
        this.listener.onDisconnected(str, i);
    }

    public String getBatteryLevel() {
        return this.batteryLevel;
    }

    public void setBatteryLevel(String str) {
        this.batteryLevel = str;
    }

    public static class Surveillance {
        public int alarm_duration_min;
        public String createdAt;
        public String endAt;
        public int endHour;
        public int endMin;
        public Boolean fri;
        public int id;
        public String isActive;
        public int level;
        public Boolean mon;
        public Boolean sat;
        public String startAt;
        public int startHour;
        public int startMin;
        public Boolean sun;
        public Boolean thu;
        public String title;
        public int trespass_duration_min;
        public Boolean tue;
        public Boolean wed;
        public String weekDays;

        public Surveillance(String str, String str2, int i, int i2, int i3, int i4, int i5, int i6, int i7, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, Boolean bool7) {
            this.title = str;
            this.isActive = str2;
            this.trespass_duration_min = i;
            this.alarm_duration_min = i2;
            this.level = i3;
            this.startHour = i4;
            this.startMin = i5;
            this.endHour = i6;
            this.endMin = i7;
            this.mon = bool;
            this.tue = bool2;
            this.wed = bool3;
            this.thu = bool4;
            this.fri = bool5;
            this.sat = bool6;
            this.sun = bool7;
        }

        public Surveillance(int i, String str, String str2, int i2, int i3, int i4, String str3, String str4, String str5, String str6) {
            this.id = i;
            this.title = str;
            this.isActive = str2;
            this.trespass_duration_min = i2;
            this.alarm_duration_min = i3;
            this.level = i4;
            this.weekDays = str3;
            this.startAt = str4;
            this.endAt = str5;
            this.createdAt = str6;
        }

        public Surveillance(String str, String str2, int i, int i2, int i3, String str3, String str4, String str5, String str6) {
            this.title = str;
            this.isActive = str2;
            this.trespass_duration_min = i;
            this.alarm_duration_min = i2;
            this.level = i3;
            this.weekDays = str3;
            this.startAt = str4;
            this.endAt = str5;
            this.createdAt = str6;
        }

        public Surveillance(int i, String str, String str2, int i2, int i3, int i4, String str3, String str4, String str5, String str6, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, Boolean bool7) {
            this.id = i;
            this.title = str;
            this.isActive = str2;
            this.trespass_duration_min = i2;
            this.alarm_duration_min = i3;
            this.level = i4;
            this.weekDays = str3;
            this.startAt = str4;
            this.endAt = str5;
            this.createdAt = str6;
            this.mon = bool;
            this.tue = bool2;
            this.wed = bool3;
            this.thu = bool4;
            this.fri = bool5;
            this.sat = bool6;
            this.sun = bool7;
        }

        public Surveillance(String str, int i, int i2, int i3, int i4, int i5, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, Boolean bool7) {
            this.title = str;
            this.level = i;
            this.startHour = i2;
            this.startMin = i3;
            this.endHour = i4;
            this.endMin = i5;
            this.mon = bool;
            this.tue = bool2;
            this.wed = bool3;
            this.thu = bool4;
            this.fri = bool5;
            this.sat = bool6;
            this.sun = bool7;
        }

        public Surveillance(String str, int i, int i2, int i3, int i4, int i5, int i6, int i7, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, Boolean bool7) {
            this.title = str;
            this.trespass_duration_min = i;
            this.alarm_duration_min = i2;
            this.level = i3;
            this.startHour = i4;
            this.startMin = i5;
            this.endHour = i6;
            this.endMin = i7;
            this.mon = bool;
            this.tue = bool2;
            this.wed = bool3;
            this.thu = bool4;
            this.fri = bool5;
            this.sat = bool6;
            this.sun = bool7;
        }

        public Surveillance(int i, String str, int i2, String str2, int i3, int i4, String str3, String str4, String str5, String str6) {
            this.id = i;
            this.title = str;
            this.level = i2;
            this.isActive = str2;
            this.trespass_duration_min = i3;
            this.alarm_duration_min = i4;
            this.weekDays = str3;
            this.startAt = str4;
            this.endAt = str5;
            this.createdAt = str6;
        }

        public void makeDaysData() {
            this.mon = Boolean.valueOf(this.weekDays.charAt(0) == '1');
            this.tue = Boolean.valueOf(this.weekDays.charAt(1) == '1');
            this.wed = Boolean.valueOf(this.weekDays.charAt(2) == '1');
            this.thu = Boolean.valueOf(this.weekDays.charAt(3) == '1');
            this.fri = Boolean.valueOf(this.weekDays.charAt(4) == '1');
            this.sat = Boolean.valueOf(this.weekDays.charAt(5) == '1');
            this.sun = Boolean.valueOf(this.weekDays.charAt(6) == '1');
        }

        public void makeWeekDays() {
            this.weekDays += (this.mon.booleanValue() ? 1 : 0);
            this.weekDays += (this.tue.booleanValue() ? 1 : 0);
            this.weekDays += (this.wed.booleanValue() ? 1 : 0);
            this.weekDays += (this.thu.booleanValue() ? 1 : 0);
            this.weekDays += (this.fri.booleanValue() ? 1 : 0);
            this.weekDays += (this.sat.booleanValue() ? 1 : 0);
            this.weekDays += (this.sun.booleanValue() ? 1 : 0);
        }
    }
}
