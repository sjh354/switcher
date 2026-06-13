package kr.switcher.device.switcher.linker;

import android.os.Handler;
import java.util.ArrayList;
import kr.switcher.device.IODevice;
import kr.switcher.device.common.DeviceUtil;
import kr.switcher.device.switcher.Switcher;
import kr.switcher.device.switcher.SwitcherProcessor;
import kr.switcher.device.switcher.SwitcherReservationChecker;
import kr.switcher.device.switcher.interfaces.IODeviceCallbacks;
import kr.switcher.device.switcher.linker.SwitcherLinkerAdapter;
import kr.switcher.device.switcher.option.DeviceOption;

/* JADX INFO: loaded from: classes2.dex */
public class SwitcherLinker extends Switcher implements IODeviceCallbacks.OnCommandResultCallback, IODeviceCallbacks.OnControlResponseListener {
    private int RETRY_DELAY_MS;
    private final int RETRY_NUM;
    private SwitcherLinkerAdapter adapter;
    private SwitcherProcessor processor;
    private int retryCnt;

    interface OnCompleteListener {
        void onComplete(String str);
    }

    @Override // kr.switcher.device.switcher.Switcher
    public void changeShareCode(String str, String str2, IODeviceCallbacks.ActionShareCodeResultCallback actionShareCodeResultCallback) {
    }

    @Override // kr.switcher.device.switcher.Switcher
    public void readFirmwareVersion(IODeviceCallbacks.FirmwareVersionResultCallback firmwareVersionResultCallback) {
    }

    @Override // kr.switcher.device.switcher.Switcher
    public void saveRealTime() {
    }

    public SwitcherLinker(String str, String str2, String str3, IODevice.ProductId productId, String str4, String str5, DeviceOption deviceOption, IODevice.ThingConnectionStatus thingConnectionStatus) {
        super(str, str3, productId, str4, "", new ArrayList());
        this.RETRY_NUM = 5;
        this.retryCnt = 0;
        this.RETRY_DELAY_MS = 1000;
        setSerialNumber(str2);
        setOwner(str5);
        setOption(deviceOption);
        this.adapter = new SwitcherLinkerAdapter();
        this.processor = new SwitcherProcessor(this);
        this.thingConnectionStatus = thingConnectionStatus;
    }

    @Override // kr.switcher.device.IODevice
    public void disconnect() {
        setConnectionState(Switcher.ConnectionState.IDLE);
        if (this.listener != null) {
            this.listener.onDisconnected(this.macAddress, 1);
        }
    }

    @Override // kr.switcher.device.switcher.Switcher
    public void controlSwitch(int i, IODeviceCallbacks.OnControlResponseListener onControlResponseListener) {
        this.controlResponseListener = onControlResponseListener;
        this.adapter.controlSwitch(this.macAddress, i, this);
    }

    @Override // kr.switcher.device.switcher.Switcher
    public void readBatteryInfo() {
        this.adapter.readBattery(this.macAddress, new SwitcherLinkerAdapter.OnReadBatteryLevelListener() { // from class: kr.switcher.device.switcher.linker.SwitcherLinker.1
            @Override // kr.switcher.device.switcher.linker.SwitcherLinkerAdapter.OnReadBatteryLevelListener
            public void onRead(String str) {
                if (str != null) {
                    SwitcherLinker.this.processor.onReadBattery(str);
                }
            }
        });
    }

    @Override // kr.switcher.device.switcher.Switcher
    public void readAuthorityState() {
        this.processor.onReadAuthority(String.valueOf(0), this.listener);
    }

    @Override // kr.switcher.device.switcher.Switcher
    public int addReservation(Switcher.SwitcherReservation switcherReservation, IODeviceCallbacks.ReservationUpdateResultCallback reservationUpdateResultCallback) {
        if (10 <= this.sResrvs.size()) {
            return 106;
        }
        switcherReservation.id = DeviceUtil.generateNewReservationId(this.sResrvs);
        return updateReservation(switcherReservation, reservationUpdateResultCallback);
    }

    @Override // kr.switcher.device.switcher.Switcher
    public int updateReservation(final Switcher.SwitcherReservation switcherReservation, final IODeviceCallbacks.ReservationUpdateResultCallback reservationUpdateResultCallback) {
        if (new SwitcherReservationChecker(this.sResrvs).checkIsDuplicationTimer(switcherReservation)) {
            return 112;
        }
        Switcher.SwitcherReservation.makeTimerVersion(true);
        this.adapter.writeReservation(this.macAddress, "00" + Switcher.SwitcherReservation.getResrvDataForBLE(switcherReservation) + Switcher.SwitcherReservation.currentTimerVersion, new SwitcherLinkerAdapter.OnWriteReservationListener() { // from class: kr.switcher.device.switcher.linker.SwitcherLinker.2
            @Override // kr.switcher.device.switcher.linker.SwitcherLinkerAdapter.OnWriteReservationListener
            public void onResult(final boolean z, String str) {
                SwitcherLinker.this.requestCommandResult(str, 0, new OnCompleteListener() { // from class: kr.switcher.device.switcher.linker.SwitcherLinker.2.1
                    @Override // kr.switcher.device.switcher.linker.SwitcherLinker.OnCompleteListener
                    public void onComplete(String str2) {
                        SwitcherLinker.this.processor.onWroteReservationAdd(switcherReservation, z, reservationUpdateResultCallback);
                    }
                });
            }
        });
        return 1;
    }

    @Override // kr.switcher.device.switcher.Switcher
    public void removeReservation(final int i, final IODeviceCallbacks.ReservationUpdateResultCallback reservationUpdateResultCallback) {
        Switcher.SwitcherReservation.makeTimerVersion(this.sResrvs.size() > 1);
        this.adapter.deleteReservation(this.macAddress, "01" + String.format("%02d", Integer.valueOf(i)) + "0000000000" + Switcher.SwitcherReservation.currentTimerVersion, new SwitcherLinkerAdapter.OnWriteReservationListener() { // from class: kr.switcher.device.switcher.linker.SwitcherLinker.3
            @Override // kr.switcher.device.switcher.linker.SwitcherLinkerAdapter.OnWriteReservationListener
            public void onResult(final boolean z, String str) {
                SwitcherLinker.this.requestCommandResult(str, 0, new OnCompleteListener() { // from class: kr.switcher.device.switcher.linker.SwitcherLinker.3.1
                    @Override // kr.switcher.device.switcher.linker.SwitcherLinker.OnCompleteListener
                    public void onComplete(String str2) {
                        SwitcherLinker.this.processor.onWroteReservationRemove(i, z, reservationUpdateResultCallback);
                    }
                });
            }
        });
    }

    @Override // kr.switcher.device.switcher.Switcher
    public void readReservation(final IODeviceCallbacks.LoadTimerInfoResultResponseCallback loadTimerInfoResultResponseCallback) {
        this.adapter.readReservation(this.macAddress, new SwitcherLinkerAdapter.OnReadReservationListener() { // from class: kr.switcher.device.switcher.linker.SwitcherLinker.4
            @Override // kr.switcher.device.switcher.linker.SwitcherLinkerAdapter.OnReadReservationListener
            public void onRead(String str, String str2) {
                if (SwitcherLinker.this.sResrvs.size() < 1) {
                    SwitcherLinker.this.processor.onReadReservation(str, loadTimerInfoResultResponseCallback);
                }
                SwitcherLinker.this.requestCommandResult(str2, 0, new OnCompleteListener() { // from class: kr.switcher.device.switcher.linker.SwitcherLinker.4.1
                    @Override // kr.switcher.device.switcher.linker.SwitcherLinker.OnCompleteListener
                    public void onComplete(String str3) {
                        SwitcherLinker.this.processor.onReadReservation(str3, loadTimerInfoResultResponseCallback);
                    }
                });
            }
        });
    }

    @Override // kr.switcher.device.switcher.Switcher
    public void updateStrokeLevel(int i, boolean z, IODeviceCallbacks.StrokeLevelUpdateResultResponseCallback strokeLevelUpdateResultResponseCallback) {
        this.retryCnt = 0;
        if (z) {
            String str = this.macAddress;
            int i2 = this.retryCnt;
            this.retryCnt = i2 + 1;
            requestStrokeLevelFeedback(str, i, i2, strokeLevelUpdateResultResponseCallback);
            return;
        }
        String str2 = this.macAddress;
        int i3 = this.retryCnt;
        this.retryCnt = i3 + 1;
        requestStrokeLevelWrite(str2, i, i3, strokeLevelUpdateResultResponseCallback);
    }

    @Override // kr.switcher.device.switcher.Switcher
    public void readStrokeLevel(IODeviceCallbacks.StrokeLevelReadResultResponseCallback strokeLevelReadResultResponseCallback) {
        requestStrokeLevel(this.macAddress, strokeLevelReadResultResponseCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestCommandResult(final String str, final int i, final OnCompleteListener onCompleteListener) {
        if (i < 5) {
            new Handler().postDelayed(new Runnable() { // from class: kr.switcher.device.switcher.linker.SwitcherLinker.5
                @Override // java.lang.Runnable
                public void run() {
                    SwitcherLinker.this.adapter.getCommandResult(str, new SwitcherLinkerAdapter.OnCommandResultListener() { // from class: kr.switcher.device.switcher.linker.SwitcherLinker.5.1
                        @Override // kr.switcher.device.switcher.linker.SwitcherLinkerAdapter.OnCommandResultListener
                        public void onResult(boolean z, String str2) {
                            if (!z) {
                                SwitcherLinker.this.requestCommandResult(str, i + 1, onCompleteListener);
                            } else {
                                onCompleteListener.onComplete(str2);
                            }
                        }
                    });
                }
            }, this.RETRY_DELAY_MS);
        }
    }

    private void requestStrokeLevel(String str, final IODeviceCallbacks.StrokeLevelReadResultResponseCallback strokeLevelReadResultResponseCallback) {
        this.adapter.readStrokeLevel(str, new SwitcherLinkerAdapter.OnReadFingerLengthListener() { // from class: kr.switcher.device.switcher.linker.SwitcherLinker.6
            @Override // kr.switcher.device.switcher.linker.SwitcherLinkerAdapter.OnReadFingerLengthListener
            public void onRead(String str2, String str3) {
                if (SwitcherLinker.this.strokeLevel == -1) {
                    SwitcherLinker.this.processor.onReadStrokeLevel(str2, strokeLevelReadResultResponseCallback);
                }
                SwitcherLinker.this.requestCommandResult(str3, 0, new OnCompleteListener() { // from class: kr.switcher.device.switcher.linker.SwitcherLinker.6.1
                    @Override // kr.switcher.device.switcher.linker.SwitcherLinker.OnCompleteListener
                    public void onComplete(String str4) {
                        SwitcherLinker.this.processor.onReadStrokeLevel(str4, strokeLevelReadResultResponseCallback);
                    }
                });
            }
        });
    }

    private void requestStrokeLevelFeedback(final String str, final int i, int i2, final IODeviceCallbacks.StrokeLevelUpdateResultResponseCallback strokeLevelUpdateResultResponseCallback) {
        this.adapter.writeStrokeLevelFeedback(str, i, new SwitcherLinkerAdapter.OnWriteFingerLengthListener() { // from class: kr.switcher.device.switcher.linker.SwitcherLinker.7
            @Override // kr.switcher.device.switcher.linker.SwitcherLinkerAdapter.OnWriteFingerLengthListener
            public void onResult(boolean z, String str2) {
                SwitcherLinker.this.requestCommandResult(str2, 0, new OnCompleteListener() { // from class: kr.switcher.device.switcher.linker.SwitcherLinker.7.1
                    @Override // kr.switcher.device.switcher.linker.SwitcherLinker.OnCompleteListener
                    public void onComplete(String str3) {
                        SwitcherLinker.this.processor.onWroteStrokeLevel(str, i, true, strokeLevelUpdateResultResponseCallback);
                    }
                });
            }
        });
    }

    private void requestStrokeLevelWrite(final String str, final int i, int i2, final IODeviceCallbacks.StrokeLevelUpdateResultResponseCallback strokeLevelUpdateResultResponseCallback) {
        this.adapter.writeStrokeLevel(str, i, new SwitcherLinkerAdapter.OnWriteFingerLengthListener() { // from class: kr.switcher.device.switcher.linker.SwitcherLinker.8
            @Override // kr.switcher.device.switcher.linker.SwitcherLinkerAdapter.OnWriteFingerLengthListener
            public void onResult(boolean z, String str2) {
                SwitcherLinker.this.requestCommandResult(str2, 0, new OnCompleteListener() { // from class: kr.switcher.device.switcher.linker.SwitcherLinker.8.1
                    @Override // kr.switcher.device.switcher.linker.SwitcherLinker.OnCompleteListener
                    public void onComplete(String str3) {
                        SwitcherLinker.this.processor.onWroteStrokeLevel(str, i, true, strokeLevelUpdateResultResponseCallback);
                    }
                });
            }
        });
    }

    @Override // kr.switcher.device.switcher.interfaces.IODeviceCallbacks.OnCommandResultCallback
    public void onCommandResult(String str) {
        this.adapter.getCommandResult(str, this);
    }

    @Override // kr.switcher.device.switcher.interfaces.IODeviceCallbacks.OnControlResponseListener
    public void onControlResult(boolean z) {
        this.connectionState = Switcher.ConnectionState.CONNECTED;
        this.controlResponseListener.onControlResult(z);
    }

    @Override // kr.switcher.device.IODevice
    public int connect(final IODeviceCallbacks.OnDeviceConnectListener onDeviceConnectListener) {
        super.connect(onDeviceConnectListener);
        this.adapter.connect(this.macAddress, new SwitcherLinkerAdapter.SwitcherLinkerStatusListener() { // from class: kr.switcher.device.switcher.linker.SwitcherLinker.9
            @Override // kr.switcher.device.switcher.linker.SwitcherLinkerAdapter.SwitcherLinkerStatusListener
            public void onStatus(int i) {
                if (i == 1) {
                    SwitcherLinker.this.setConnectionState(Switcher.ConnectionState.CONNECTED);
                    SwitcherLinker.this.processor.onConnected();
                } else if (i == 0) {
                    onDeviceConnectListener.onDisconnected(SwitcherLinker.this.macAddress, 0);
                }
            }
        });
        return 1;
    }
}
