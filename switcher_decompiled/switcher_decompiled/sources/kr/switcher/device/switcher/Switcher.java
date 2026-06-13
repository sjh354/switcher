package kr.switcher.device.switcher;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import kr.switcher.device.IODevice;
import kr.switcher.device.IODeviceConfig;
import kr.switcher.device.common.DeviceUtil;
import kr.switcher.device.switcher.ble.ScannedBLESwitcher;
import kr.switcher.device.switcher.interfaces.IODeviceCallbacks;
import kr.switcher.device.switcher.option.DeviceOption;

/* JADX INFO: loaded from: classes2.dex */
public abstract class Switcher extends IODevice {
    public static final int AUTHORITY_LOCK = 1;
    public static final int AUTHORITY_NOT_MATCH = 2;
    public static final int AUTHORITY_UNKNOWN = -1;
    public static final int AUTHORITY_UNLOCK = 0;
    public static final int BATTERY_DEFAULT_VALUE = -1;
    public static final int INVALID_STROKE_LEVEL = -1;
    public static final int OFF_1WAY = 1;
    public static final int OFF_2WAY = 3;
    public static final int ON_1WAY = 0;
    public static final int ON_2WAY = 2;
    public static final int RESERVATION_LENGTH = 10;
    public static final int SCANNED_SWITCHER_TYPE_ONE = 1;
    public static final int SCANNED_SWITCHER_TYPE_TWO = 2;
    public static final int STROKE_LONG_LEVEL = 2;
    public static final int STROKE_MEDIUM_LEVEL = 1;
    public static final int STROKE_SHORT_LEVEL = 0;
    public static final String SWITCHER_NAME = "SWITCHER";
    protected int authority;
    protected int battery;
    protected ConnectionState connectionState;
    protected IODeviceCallbacks.OnControlResponseListener controlResponseListener;
    protected String firmwareVersion;
    public List<SwitcherReservation> sResrvs;
    protected int strokeLevel;

    public enum ConnectionState implements Serializable {
        IDLE,
        CONNECTING,
        CONNECTED,
        FAILED,
        CONTROL
    }

    public abstract int addReservation(SwitcherReservation switcherReservation, IODeviceCallbacks.ReservationUpdateResultCallback reservationUpdateResultCallback);

    public abstract void changeShareCode(String str, String str2, IODeviceCallbacks.ActionShareCodeResultCallback actionShareCodeResultCallback);

    public abstract void controlSwitch(int i, IODeviceCallbacks.OnControlResponseListener onControlResponseListener);

    public abstract void readAuthorityState();

    public abstract void readBatteryInfo();

    public abstract void readFirmwareVersion(IODeviceCallbacks.FirmwareVersionResultCallback firmwareVersionResultCallback);

    public abstract void readReservation(IODeviceCallbacks.LoadTimerInfoResultResponseCallback loadTimerInfoResultResponseCallback);

    public abstract void readStrokeLevel(IODeviceCallbacks.StrokeLevelReadResultResponseCallback strokeLevelReadResultResponseCallback);

    public abstract void removeReservation(int i, IODeviceCallbacks.ReservationUpdateResultCallback reservationUpdateResultCallback);

    public abstract void saveRealTime();

    public abstract int updateReservation(SwitcherReservation switcherReservation, IODeviceCallbacks.ReservationUpdateResultCallback reservationUpdateResultCallback);

    public abstract void updateStrokeLevel(int i, boolean z, IODeviceCallbacks.StrokeLevelUpdateResultResponseCallback strokeLevelUpdateResultResponseCallback);

    public Switcher(String str, IODevice.ProductId productId) {
        this.strokeLevel = -1;
        this.connectionState = ConnectionState.IDLE;
        this.firmwareVersion = "9.9.9";
        initialize(str, productId);
    }

    public Switcher(String str, String str2, IODevice.ProductId productId, String str3, String str4, List<SwitcherReservation> list) {
        this.strokeLevel = -1;
        this.connectionState = ConnectionState.IDLE;
        this.firmwareVersion = "9.9.9";
        initialize(str, productId);
        this.name = str2;
        this.shareCode = str3;
        this.firmwareVersion = str4;
        this.authority = -1;
        this.sResrvs = list;
    }

    public void initialize(String str, IODevice.ProductId productId) {
        this.macAddress = str;
        this.productId = productId;
        this.battery = -1;
        this.sResrvs = new LinkedList();
        this.option = new DeviceOption();
    }

    public String getFirmwareVersion() {
        return this.firmwareVersion;
    }

    public void setFirmwareVersion(String str) {
        this.firmwareVersion = str;
    }

    public int getAuthority() {
        return this.authority;
    }

    public void setAuthority(int i) {
        this.authority = i;
    }

    public int getBattery() {
        return this.battery;
    }

    public void setBattery(int i) {
        this.battery = i;
    }

    public int getStrokeLevel() {
        return this.strokeLevel;
    }

    public void setStrokeLevel(int i) {
        this.strokeLevel = i;
    }

    public ConnectionState getConnectionState() {
        return this.connectionState;
    }

    public void setConnectionState(ConnectionState connectionState) {
        this.connectionState = connectionState;
    }

    @Override // kr.switcher.device.IODevice
    public ScannedBLESwitcher getAttachedDevice() {
        return (ScannedBLESwitcher) this.scannedBLEDevice;
    }

    public List<SwitcherReservation> getSwitcherReservationList() {
        return this.sResrvs;
    }

    public void setSwitcherReservationList(List<SwitcherReservation> list) {
        if (list == null) {
            this.sResrvs = new ArrayList();
        } else {
            this.sResrvs = list;
        }
        DeviceUtil.setLastTimerVersion();
    }

    public void addSwitcherReservation(SwitcherReservation switcherReservation) {
        removeDuplicatedReservation(switcherReservation.id);
        this.sResrvs.add(switcherReservation);
        DeviceUtil.setLastTimerVersion();
    }

    public void removeSwitcherReservation(int i) {
        removeDuplicatedReservation(i);
        DeviceUtil.setLastTimerVersion();
    }

    private void removeDuplicatedReservation(int i) {
        SwitcherReservation switcherReservation = null;
        for (SwitcherReservation switcherReservation2 : this.sResrvs) {
            if (switcherReservation2.id == i) {
                switcherReservation = switcherReservation2;
            }
        }
        if (switcherReservation != null) {
            this.sResrvs.remove(switcherReservation);
        }
    }

    public DeviceOption getDeviceOption() {
        return this.option;
    }

    public void setDeviceOption(DeviceOption deviceOption) {
        this.option = deviceOption;
    }

    public static class SwitcherReservation {
        public static final String PROTOCOL_ADD = "00";
        public static final String PROTOCOL_REMOVE = "01";
        public static final String SWITCH_1WAY_FIRMWARE = "0";
        public static final String SWITCH_2WAY_FIRMWARE = "1";
        public static String currentTimerVersion;
        public String ampm;
        public boolean enable;
        public boolean fri;
        public int hour;
        public int id;
        public boolean light;
        public int min;
        public boolean mon;
        public boolean sat;
        public boolean sun;
        public String switcherTarget;
        public boolean thu;
        public String title;
        public boolean tue;
        public boolean wed;

        public SwitcherReservation() {
            this.id = 0;
        }

        public SwitcherReservation(int i, String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, String str2, int i2, int i3, boolean z8, String str3, boolean z9) {
            this.id = i;
            this.title = str;
            this.mon = z;
            this.tue = z2;
            this.wed = z3;
            this.thu = z4;
            this.fri = z5;
            this.sat = z6;
            this.sun = z7;
            this.ampm = str2;
            this.hour = i2;
            this.min = i3;
            this.light = z8;
            this.switcherTarget = str3;
            this.enable = z9;
        }

        public SwitcherReservation(String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, String str2, int i, int i2, boolean z8, String str3, boolean z9) {
            this.id = 0;
            this.mon = z;
            this.title = str;
            this.tue = z2;
            this.wed = z3;
            this.thu = z4;
            this.fri = z5;
            this.sat = z6;
            this.sun = z7;
            this.ampm = str2;
            this.hour = i;
            this.min = i2;
            this.light = z8;
            this.switcherTarget = str3;
            this.enable = z9;
        }

        public SwitcherReservation(String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, String str2, int i, int i2) {
            this.id = 0;
            this.mon = z;
            this.title = str;
            this.tue = z2;
            this.wed = z3;
            this.thu = z4;
            this.fri = z5;
            this.sat = z6;
            this.sun = z7;
            this.ampm = str2;
            this.hour = i;
            this.min = i2;
        }

        public static String getResrvDataForBLE(SwitcherReservation switcherReservation) {
            try {
                String str = String.format("%02x", Integer.valueOf(switcherReservation.id));
                String str2 = String.format("%02x", Integer.valueOf(Integer.parseInt(((((((String.valueOf(switcherReservation.mon ? 1 : 0) + (switcherReservation.tue ? 1 : 0)) + (switcherReservation.wed ? 1 : 0)) + (switcherReservation.thu ? 1 : 0)) + (switcherReservation.fri ? 1 : 0)) + (switcherReservation.sat ? 1 : 0)) + (switcherReservation.sun ? 1 : 0)) + (switcherReservation.enable ? 1 : 0), 2)));
                int i = switcherReservation.hour;
                if (IODeviceConfig.AM.equalsIgnoreCase(switcherReservation.ampm)) {
                    if (i == 12) {
                        i = 0;
                    }
                } else if (i != 12) {
                    i += 12;
                }
                String str3 = String.format("%02x", Integer.valueOf(i));
                String str4 = String.format("%02x", Integer.valueOf(switcherReservation.min));
                String str5 = String.format("%02x", Integer.valueOf(Integer.parseInt(switcherReservation.switcherTarget)));
                Object[] objArr = new Object[1];
                objArr[0] = Integer.valueOf(switcherReservation.light ? 0 : 1);
                return str + str2 + str3 + str4 + str5 + String.format("%02x", objArr);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                return "";
            } catch (Exception e2) {
                e2.printStackTrace();
                return "";
            }
        }

        public static void makeTimerVersion(boolean z) {
            if (z) {
                int i = Calendar.getInstance().get(11);
                int i2 = Calendar.getInstance().get(12);
                int i3 = Calendar.getInstance().get(13);
                currentTimerVersion = String.format("%02x", Integer.valueOf(i)) + String.format("%02x", Integer.valueOf(i2)) + String.format("%02x", Integer.valueOf(i3));
                return;
            }
            currentTimerVersion = "FFFFFF";
        }
    }
}
