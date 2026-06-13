package kr.switcher.device.switcher;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import java.util.ArrayList;
import kr.switcher.device.IODeviceConfig;
import kr.switcher.device.switcher.Switcher;
import kr.switcher.device.switcher.interfaces.IODeviceCallbacks;
import kr.switcher.ioble.common.BLEUtil;

/* JADX INFO: loaded from: classes2.dex */
public class SwitcherProcessor {
    private static final String TAG = "SwitcherProcessor";
    private Handler handler = new Handler(Looper.getMainLooper());
    private Switcher switcher;

    public SwitcherProcessor(Switcher switcher) {
        this.switcher = switcher;
    }

    public void onConnected() {
        this.switcher.readBatteryInfo();
    }

    public void onReadBattery(String str) {
        int i;
        try {
            i = Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            i = -1;
        }
        this.switcher.setBattery(i);
        this.switcher.readAuthorityState();
        Log.i(TAG, "switcher`s battery : " + i);
    }

    public void onReadAuthority(String str, final IODeviceCallbacks.OnDeviceConnectListener onDeviceConnectListener) {
        int i;
        try {
            i = Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            i = -1;
        }
        this.switcher.setAuthority(i);
        if (i == 0) {
            this.handler.post(new Runnable() { // from class: kr.switcher.device.switcher.SwitcherProcessor.1
                @Override // java.lang.Runnable
                public void run() {
                    IODeviceCallbacks.OnDeviceConnectListener onDeviceConnectListener2 = onDeviceConnectListener;
                    if (onDeviceConnectListener2 != null) {
                        onDeviceConnectListener2.onConnected(SwitcherProcessor.this.switcher);
                    }
                }
            });
        } else {
            this.switcher.setConnectionState(Switcher.ConnectionState.IDLE);
            this.handler.post(new Runnable() { // from class: kr.switcher.device.switcher.SwitcherProcessor.2
                @Override // java.lang.Runnable
                public void run() {
                    IODeviceCallbacks.OnDeviceConnectListener onDeviceConnectListener2 = onDeviceConnectListener;
                    if (onDeviceConnectListener2 != null) {
                        onDeviceConnectListener2.onDisconnected(SwitcherProcessor.this.switcher.getMacAddress(), 0);
                    }
                }
            });
        }
        this.handler.post(new Runnable() { // from class: kr.switcher.device.switcher.SwitcherProcessor.3
            @Override // java.lang.Runnable
            public void run() {
                SwitcherProcessor.this.switcher.saveRealTime();
            }
        });
        Log.i(TAG, "switcher`s authority : " + i);
    }

    public void onWroteRealTime(boolean z) {
        Log.i(TAG, "save real time result : " + z);
    }

    public void onWroteSwitch(final boolean z, final IODeviceCallbacks.OnControlResponseListener onControlResponseListener) {
        this.handler.post(new Runnable() { // from class: kr.switcher.device.switcher.SwitcherProcessor.4
            @Override // java.lang.Runnable
            public void run() {
                IODeviceCallbacks.OnControlResponseListener onControlResponseListener2 = onControlResponseListener;
                if (onControlResponseListener2 != null) {
                    onControlResponseListener2.onControlResult(z);
                }
            }
        });
    }

    public void onWroteReservationAdd(Switcher.SwitcherReservation switcherReservation, final boolean z, final IODeviceCallbacks.ReservationUpdateResultCallback reservationUpdateResultCallback) {
        if (z) {
            this.switcher.addSwitcherReservation(switcherReservation);
        }
        this.handler.post(new Runnable() { // from class: kr.switcher.device.switcher.SwitcherProcessor.5
            @Override // java.lang.Runnable
            public void run() {
                IODeviceCallbacks.ReservationUpdateResultCallback reservationUpdateResultCallback2 = reservationUpdateResultCallback;
                if (reservationUpdateResultCallback2 != null) {
                    reservationUpdateResultCallback2.onUpdatedReservation(z);
                }
            }
        });
    }

    public void onWroteReservationRemove(int i, final boolean z, final IODeviceCallbacks.ReservationUpdateResultCallback reservationUpdateResultCallback) {
        if (z) {
            this.switcher.removeSwitcherReservation(i);
        }
        this.handler.post(new Runnable() { // from class: kr.switcher.device.switcher.SwitcherProcessor.6
            @Override // java.lang.Runnable
            public void run() {
                IODeviceCallbacks.ReservationUpdateResultCallback reservationUpdateResultCallback2 = reservationUpdateResultCallback;
                if (reservationUpdateResultCallback2 != null) {
                    reservationUpdateResultCallback2.onUpdatedReservation(z);
                }
            }
        });
    }

    public void onReadReservation(String str, final IODeviceCallbacks.LoadTimerInfoResultResponseCallback loadTimerInfoResultResponseCallback) {
        Log.d(TAG, "firmware reservation data : " + str);
        int i = 2;
        if (50 == str.length() / 2) {
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            int i3 = 0;
            for (int i4 = 50; i2 < i4; i4 = 50) {
                Switcher.SwitcherReservation switcherReservation = new Switcher.SwitcherReservation();
                int i5 = i3 * 10;
                String strSubstring = str.substring(i5, i5 + 10);
                if (!strSubstring.equalsIgnoreCase(IODeviceConfig.INVALID_TIMER_DATA)) {
                    String strHexToBinary = BLEUtil.hexToBinary(strSubstring.substring(0, i));
                    switcherReservation.mon = Integer.parseInt(strHexToBinary.substring(0, 1)) == 1;
                    switcherReservation.tue = Integer.parseInt(strHexToBinary.substring(1, i)) == 1;
                    switcherReservation.wed = Integer.parseInt(strHexToBinary.substring(i, 3)) == 1;
                    switcherReservation.thu = Integer.parseInt(strHexToBinary.substring(3, 4)) == 1;
                    switcherReservation.fri = Integer.parseInt(strHexToBinary.substring(4, 5)) == 1;
                    switcherReservation.sat = Integer.parseInt(strHexToBinary.substring(5, 6)) == 1;
                    switcherReservation.sun = Integer.parseInt(strHexToBinary.substring(6, 7)) == 1;
                    switcherReservation.enable = Integer.parseInt(strHexToBinary.substring(7, 8)) == 1;
                    switcherReservation.hour = Integer.parseInt(strSubstring.substring(i, 4), 16);
                    if (switcherReservation.hour >= 0 && switcherReservation.hour < 12) {
                        if (switcherReservation.hour == 0) {
                            switcherReservation.hour = 12;
                        }
                        switcherReservation.ampm = IODeviceConfig.AM;
                    } else if (12 <= switcherReservation.hour && switcherReservation.hour < 24) {
                        if (switcherReservation.hour != 12) {
                            switcherReservation.hour -= 12;
                        }
                        switcherReservation.ampm = "pm";
                    } else {
                        Log.e(TAG, "Invalid time format (hour:" + switcherReservation.hour + ")");
                        break;
                    }
                    switcherReservation.min = Integer.parseInt(strSubstring.substring(4, 6), 16);
                    switcherReservation.switcherTarget = Integer.parseInt(strSubstring.substring(6, 8), 16) + "";
                    switcherReservation.light = Integer.parseInt(strSubstring.substring(8, 10), 16) == 0;
                    switcherReservation.id = i3;
                    arrayList.add(switcherReservation);
                }
                i3++;
                i2 += 5;
                i = 2;
            }
            this.switcher.setSwitcherReservationList(arrayList);
            this.handler.post(new Runnable() { // from class: kr.switcher.device.switcher.SwitcherProcessor.7
                @Override // java.lang.Runnable
                public void run() {
                    IODeviceCallbacks.LoadTimerInfoResultResponseCallback loadTimerInfoResultResponseCallback2 = loadTimerInfoResultResponseCallback;
                    if (loadTimerInfoResultResponseCallback2 != null) {
                        loadTimerInfoResultResponseCallback2.onLoadReservationListResult(SwitcherProcessor.this.switcher.sResrvs);
                    }
                }
            });
        }
    }

    public void onWroteStrokeLevel(String str, int i, final boolean z, final IODeviceCallbacks.StrokeLevelUpdateResultResponseCallback strokeLevelUpdateResultResponseCallback) {
        this.handler.post(new Runnable() { // from class: kr.switcher.device.switcher.SwitcherProcessor.8
            @Override // java.lang.Runnable
            public void run() {
                IODeviceCallbacks.StrokeLevelUpdateResultResponseCallback strokeLevelUpdateResultResponseCallback2 = strokeLevelUpdateResultResponseCallback;
                if (strokeLevelUpdateResultResponseCallback2 != null) {
                    strokeLevelUpdateResultResponseCallback2.onStrokeLevelResult(z);
                }
            }
        });
    }

    public void onReadStrokeLevel(String str, final IODeviceCallbacks.StrokeLevelReadResultResponseCallback strokeLevelReadResultResponseCallback) {
        final int i;
        try {
            i = Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            i = -1;
        }
        if (i == -1 && i > 2) {
            strokeLevelReadResultResponseCallback.onStrokeLevelResult(-1);
        } else {
            this.switcher.setStrokeLevel(i);
            this.handler.post(new Runnable() { // from class: kr.switcher.device.switcher.SwitcherProcessor.9
                @Override // java.lang.Runnable
                public void run() {
                    IODeviceCallbacks.StrokeLevelReadResultResponseCallback strokeLevelReadResultResponseCallback2 = strokeLevelReadResultResponseCallback;
                    if (strokeLevelReadResultResponseCallback2 != null) {
                        strokeLevelReadResultResponseCallback2.onStrokeLevelResult(i);
                    }
                }
            });
        }
    }

    public void onReadFirmwareVersion(final String str, final IODeviceCallbacks.FirmwareVersionResultCallback firmwareVersionResultCallback) {
        this.switcher.setFirmwareVersion(str);
        this.handler.post(new Runnable() { // from class: kr.switcher.device.switcher.SwitcherProcessor.10
            @Override // java.lang.Runnable
            public void run() {
                IODeviceCallbacks.FirmwareVersionResultCallback firmwareVersionResultCallback2 = firmwareVersionResultCallback;
                if (firmwareVersionResultCallback2 != null) {
                    firmwareVersionResultCallback2.onFirmwareVersion(str);
                }
            }
        });
    }

    public void onWroteShareCode(final boolean z, final IODeviceCallbacks.ActionShareCodeResultCallback actionShareCodeResultCallback) {
        this.handler.post(new Runnable() { // from class: kr.switcher.device.switcher.SwitcherProcessor.11
            @Override // java.lang.Runnable
            public void run() {
                IODeviceCallbacks.ActionShareCodeResultCallback actionShareCodeResultCallback2 = actionShareCodeResultCallback;
                if (actionShareCodeResultCallback2 != null) {
                    actionShareCodeResultCallback2.onActionComplete(z);
                }
            }
        });
    }
}
