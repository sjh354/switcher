package kr.switcher.device.switcher.linker;

import android.os.Handler;
import android.util.Log;
import kr.switcher.device.IODevice;
import kr.switcher.device.common.DeviceUtil;
import kr.switcher.device.switcher.interfaces.IODeviceCallbacks;
import kr.switcher.device.switcher.linker.http.RestLinkerAPIStore;
import kr.switcher.device.switcher.linker.http.response.BatteryLevelAPIResponse;
import kr.switcher.device.switcher.linker.http.response.CommandResultAPIResponse;
import kr.switcher.device.switcher.linker.http.response.ControlAPIResponse;
import kr.switcher.device.switcher.linker.http.response.FingerLengthReadAPIResponse;
import kr.switcher.device.switcher.linker.http.response.FingerLengthTestAPIResponse;
import kr.switcher.device.switcher.linker.http.response.FingerLengthWriteAPIResponse;
import kr.switcher.device.switcher.linker.http.response.HttpAPIResponse;
import kr.switcher.device.switcher.linker.http.response.HttpResponseHandler;
import kr.switcher.device.switcher.linker.http.response.ReservationReadAPIResponse;
import kr.switcher.device.switcher.linker.http.response.ReservationWriteAPIResponse;
import kr.switcher.device.switcher.linker.http.response.ThingAPIResponse;

/* JADX INFO: loaded from: classes2.dex */
public class SwitcherLinkerAdapter {
    private static final String TAG = "SwitcherLinkerAdapter";
    private final int RETRY_COUNT = 10;
    private int failCount = 0;
    private int reconnectCount = 0;

    public interface OnCommandResultListener {
        void onResult(boolean z, String str);
    }

    public interface OnReadBatteryLevelListener {
        void onRead(String str);
    }

    public interface OnReadFingerLengthListener {
        void onRead(String str, String str2);
    }

    public interface OnReadReservationListener {
        void onRead(String str, String str2);
    }

    public interface OnWriteFingerLengthListener {
        void onResult(boolean z, String str);
    }

    public interface OnWriteReservationListener {
        void onResult(boolean z, String str);
    }

    public interface SwitcherLinkerStatusListener {
        void onStatus(int i);
    }

    public void disconnect() {
    }

    static /* synthetic */ int access$208(SwitcherLinkerAdapter switcherLinkerAdapter) {
        int i = switcherLinkerAdapter.failCount;
        switcherLinkerAdapter.failCount = i + 1;
        return i;
    }

    public void connect(String str, SwitcherLinkerStatusListener switcherLinkerStatusListener) {
        this.reconnectCount = 0;
        RestLinkerAPIStore.requestPostMainThing(str, null);
        connectAndReconnect(str, switcherLinkerStatusListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void connectAndReconnect(String str, SwitcherLinkerStatusListener switcherLinkerStatusListener) {
        int i = this.reconnectCount + 1;
        this.reconnectCount = i;
        if (i < 10) {
            reconnectWhenBeNotAlive(str, switcherLinkerStatusListener);
        } else {
            doWhenConnectionFailed(str, switcherLinkerStatusListener);
        }
    }

    private void reconnectWhenBeNotAlive(final String str, final SwitcherLinkerStatusListener switcherLinkerStatusListener) {
        RestLinkerAPIStore.requestGetDevice(str, new HttpResponseHandler() { // from class: kr.switcher.device.switcher.linker.SwitcherLinkerAdapter.1
            @Override // kr.switcher.device.switcher.linker.http.response.HttpResponseHandler
            public void onSuccess(HttpAPIResponse httpAPIResponse) {
                ThingAPIResponse thingAPIResponse = (ThingAPIResponse) httpAPIResponse;
                if (thingAPIResponse != null) {
                    if (!DeviceUtil.convertThingConnectionStatus(thingAPIResponse.connection_status).equals(IODevice.ThingConnectionStatus.ALIVE)) {
                        SwitcherLinkerAdapter.this.connectAndReconnect(str, switcherLinkerStatusListener);
                        return;
                    } else {
                        switcherLinkerStatusListener.onStatus(1);
                        return;
                    }
                }
                switcherLinkerStatusListener.onStatus(0);
            }

            @Override // kr.switcher.device.switcher.linker.http.response.HttpResponseHandler
            public void onFailure(String str2, String str3) {
                switcherLinkerStatusListener.onStatus(0);
            }
        });
    }

    private void doWhenConnectionFailed(String str, SwitcherLinkerStatusListener switcherLinkerStatusListener) {
        RestLinkerAPIStore.requestPostMainThing(str, new HttpResponseHandler() { // from class: kr.switcher.device.switcher.linker.SwitcherLinkerAdapter.2
            @Override // kr.switcher.device.switcher.linker.http.response.HttpResponseHandler
            public void onSuccess(HttpAPIResponse httpAPIResponse) {
                Log.d(SwitcherLinkerAdapter.TAG, "requestPostMainThing() success");
            }

            @Override // kr.switcher.device.switcher.linker.http.response.HttpResponseHandler
            public void onFailure(String str2, String str3) {
                Log.d(SwitcherLinkerAdapter.TAG, "requestPostMainThing() fail");
            }
        });
        switcherLinkerStatusListener.onStatus(0);
    }

    public void controlSwitch(String str, int i, final SwitcherLinker switcherLinker) {
        RestLinkerAPIStore.requestPostCommand(str, i, new HttpResponseHandler() { // from class: kr.switcher.device.switcher.linker.SwitcherLinkerAdapter.3
            @Override // kr.switcher.device.switcher.linker.http.response.HttpResponseHandler
            public void onSuccess(HttpAPIResponse httpAPIResponse) {
                switcherLinker.onCommandResult(SwitcherLinkerJsonParser.parseCommandId((ControlAPIResponse) httpAPIResponse));
            }

            @Override // kr.switcher.device.switcher.linker.http.response.HttpResponseHandler
            public void onFailure(String str2, String str3) {
                Log.i(SwitcherLinkerAdapter.TAG, str2 + ", " + str3);
                switcherLinker.onCommandResult("");
            }
        });
    }

    public void getCommandResult(final String str, final IODeviceCallbacks.OnControlResponseListener onControlResponseListener) {
        RestLinkerAPIStore.requestGetCommandResult(str, new HttpResponseHandler() { // from class: kr.switcher.device.switcher.linker.SwitcherLinkerAdapter.4
            @Override // kr.switcher.device.switcher.linker.http.response.HttpResponseHandler
            public void onSuccess(HttpAPIResponse httpAPIResponse) {
                onControlResponseListener.onControlResult(true);
                if (!"success".equals(SwitcherLinkerJsonParser.parseCommandResult((CommandResultAPIResponse) httpAPIResponse))) {
                    SwitcherLinkerAdapter.this.fail(str, onControlResponseListener);
                } else {
                    onControlResponseListener.onControlResult(true);
                    SwitcherLinkerAdapter.this.failCount = 0;
                }
            }

            @Override // kr.switcher.device.switcher.linker.http.response.HttpResponseHandler
            public void onFailure(String str2, String str3) {
                Log.i(SwitcherLinkerAdapter.TAG, str2 + ", " + str3);
                SwitcherLinkerAdapter.this.fail(str, onControlResponseListener);
            }
        });
    }

    public void readBattery(String str, final OnReadBatteryLevelListener onReadBatteryLevelListener) {
        RestLinkerAPIStore.requestPostBatteryLevel(str, new HttpResponseHandler() { // from class: kr.switcher.device.switcher.linker.SwitcherLinkerAdapter.5
            @Override // kr.switcher.device.switcher.linker.http.response.HttpResponseHandler
            public void onSuccess(HttpAPIResponse httpAPIResponse) {
                onReadBatteryLevelListener.onRead(SwitcherLinkerJsonParser.parseBatteryLevel((BatteryLevelAPIResponse) httpAPIResponse));
            }

            @Override // kr.switcher.device.switcher.linker.http.response.HttpResponseHandler
            public void onFailure(String str2, String str3) {
                onReadBatteryLevelListener.onRead(String.valueOf(-1));
                Log.i(SwitcherLinkerAdapter.TAG, str2 + ", " + str3);
            }
        });
    }

    public void readStrokeLevel(String str, final OnReadFingerLengthListener onReadFingerLengthListener) {
        RestLinkerAPIStore.requestPostFingerLengthRead(str, new HttpResponseHandler() { // from class: kr.switcher.device.switcher.linker.SwitcherLinkerAdapter.6
            @Override // kr.switcher.device.switcher.linker.http.response.HttpResponseHandler
            public void onSuccess(HttpAPIResponse httpAPIResponse) {
                FingerLengthReadAPIResponse fingerLengthReadAPIResponse = (FingerLengthReadAPIResponse) httpAPIResponse;
                onReadFingerLengthListener.onRead(SwitcherLinkerJsonParser.parseStrokeLevelValue(fingerLengthReadAPIResponse), SwitcherLinkerJsonParser.parseStrokeLevelReadCommandId(fingerLengthReadAPIResponse));
            }

            @Override // kr.switcher.device.switcher.linker.http.response.HttpResponseHandler
            public void onFailure(String str2, String str3) {
                onReadFingerLengthListener.onRead(String.valueOf(-1), "");
                Log.i(SwitcherLinkerAdapter.TAG, str2 + ", " + str3);
            }
        });
    }

    public void writeStrokeLevelFeedback(String str, int i, final OnWriteFingerLengthListener onWriteFingerLengthListener) {
        RestLinkerAPIStore.requestPostFingerLengthTest(str, i, new HttpResponseHandler() { // from class: kr.switcher.device.switcher.linker.SwitcherLinkerAdapter.7
            @Override // kr.switcher.device.switcher.linker.http.response.HttpResponseHandler
            public void onSuccess(HttpAPIResponse httpAPIResponse) {
                onWriteFingerLengthListener.onResult(true, SwitcherLinkerJsonParser.parseStrokeLevelFeedback((FingerLengthTestAPIResponse) httpAPIResponse));
            }

            @Override // kr.switcher.device.switcher.linker.http.response.HttpResponseHandler
            public void onFailure(String str2, String str3) {
                onWriteFingerLengthListener.onResult(false, "");
                Log.i(SwitcherLinkerAdapter.TAG, str2 + ", " + str3);
            }
        });
    }

    public void writeStrokeLevel(String str, int i, final OnWriteFingerLengthListener onWriteFingerLengthListener) {
        RestLinkerAPIStore.requestPostFingerLengthWrite(str, i, new HttpResponseHandler() { // from class: kr.switcher.device.switcher.linker.SwitcherLinkerAdapter.8
            @Override // kr.switcher.device.switcher.linker.http.response.HttpResponseHandler
            public void onSuccess(HttpAPIResponse httpAPIResponse) {
                onWriteFingerLengthListener.onResult(true, SwitcherLinkerJsonParser.parseStrokeLevelWrite((FingerLengthWriteAPIResponse) httpAPIResponse));
            }

            @Override // kr.switcher.device.switcher.linker.http.response.HttpResponseHandler
            public void onFailure(String str2, String str3) {
                onWriteFingerLengthListener.onResult(false, "");
                Log.i(SwitcherLinkerAdapter.TAG, str2 + ", " + str3);
            }
        });
    }

    public void getCommandResult(String str, final OnCommandResultListener onCommandResultListener) {
        RestLinkerAPIStore.requestGetCommandResult(str, new HttpResponseHandler() { // from class: kr.switcher.device.switcher.linker.SwitcherLinkerAdapter.9
            @Override // kr.switcher.device.switcher.linker.http.response.HttpResponseHandler
            public void onSuccess(HttpAPIResponse httpAPIResponse) {
                CommandResultAPIResponse commandResultAPIResponse = (CommandResultAPIResponse) httpAPIResponse;
                onCommandResultListener.onResult(SwitcherLinkerJsonParser.parseCommandResultStatus(commandResultAPIResponse), SwitcherLinkerJsonParser.parseCommandResultValue(commandResultAPIResponse));
            }

            @Override // kr.switcher.device.switcher.linker.http.response.HttpResponseHandler
            public void onFailure(String str2, String str3) {
                onCommandResultListener.onResult(false, "");
                Log.i(SwitcherLinkerAdapter.TAG, str2 + ", " + str3);
            }
        });
    }

    public void writeReservation(String str, String str2, final OnWriteReservationListener onWriteReservationListener) {
        RestLinkerAPIStore.requestPostReservationWrite(str, str2, new HttpResponseHandler() { // from class: kr.switcher.device.switcher.linker.SwitcherLinkerAdapter.10
            @Override // kr.switcher.device.switcher.linker.http.response.HttpResponseHandler
            public void onSuccess(HttpAPIResponse httpAPIResponse) {
                onWriteReservationListener.onResult(true, SwitcherLinkerJsonParser.parseReservationWrite((ReservationWriteAPIResponse) httpAPIResponse));
            }

            @Override // kr.switcher.device.switcher.linker.http.response.HttpResponseHandler
            public void onFailure(String str3, String str4) {
                onWriteReservationListener.onResult(false, "");
                Log.i(SwitcherLinkerAdapter.TAG, str3 + ", " + str4);
            }
        });
    }

    public void deleteReservation(String str, String str2, final OnWriteReservationListener onWriteReservationListener) {
        RestLinkerAPIStore.requestPostReservationDelete(str, str2, new HttpResponseHandler() { // from class: kr.switcher.device.switcher.linker.SwitcherLinkerAdapter.11
            @Override // kr.switcher.device.switcher.linker.http.response.HttpResponseHandler
            public void onSuccess(HttpAPIResponse httpAPIResponse) {
                onWriteReservationListener.onResult(true, SwitcherLinkerJsonParser.parseReservationWrite((ReservationWriteAPIResponse) httpAPIResponse));
            }

            @Override // kr.switcher.device.switcher.linker.http.response.HttpResponseHandler
            public void onFailure(String str3, String str4) {
                onWriteReservationListener.onResult(false, "");
                Log.i(SwitcherLinkerAdapter.TAG, str3 + ", " + str4);
            }
        });
    }

    public void readReservation(String str, final OnReadReservationListener onReadReservationListener) {
        RestLinkerAPIStore.requestPostReservationRead(str, new HttpResponseHandler() { // from class: kr.switcher.device.switcher.linker.SwitcherLinkerAdapter.12
            @Override // kr.switcher.device.switcher.linker.http.response.HttpResponseHandler
            public void onSuccess(HttpAPIResponse httpAPIResponse) {
                ReservationReadAPIResponse reservationReadAPIResponse = (ReservationReadAPIResponse) httpAPIResponse;
                onReadReservationListener.onRead(SwitcherLinkerJsonParser.parseReservationValue(reservationReadAPIResponse), SwitcherLinkerJsonParser.parseReservationReadCommandId(reservationReadAPIResponse));
            }

            @Override // kr.switcher.device.switcher.linker.http.response.HttpResponseHandler
            public void onFailure(String str2, String str3) {
                onReadReservationListener.onRead("", "");
                Log.i(SwitcherLinkerAdapter.TAG, str2 + ", " + str3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fail(final String str, final IODeviceCallbacks.OnControlResponseListener onControlResponseListener) {
        if (this.failCount < 10) {
            new Handler().postDelayed(new Runnable() { // from class: kr.switcher.device.switcher.linker.SwitcherLinkerAdapter.13
                @Override // java.lang.Runnable
                public void run() {
                    SwitcherLinkerAdapter.this.getCommandResult(str, onControlResponseListener);
                    SwitcherLinkerAdapter.access$208(SwitcherLinkerAdapter.this);
                }
            }, 1000L);
        } else {
            onControlResponseListener.onControlResult(false);
            this.failCount = 0;
        }
    }
}
