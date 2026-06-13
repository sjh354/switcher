package kr.switcher.switcherm.ui.main.event;

import kr.switcher.device.switcher.Switcher;
import kr.switcher.device.switcher.interfaces.IODeviceCallbacks;
import kr.switcher.switcherm.common.util.IOLog;

/* JADX INFO: loaded from: classes2.dex */
public class SwitcherOnOffController {
    private static final String TAG = "SwitcherOnOffController";
    private Switcher switcher;

    public SwitcherOnOffController(Switcher switcher) {
        this.switcher = switcher;
    }

    public void onOneSetOn(IODeviceCallbacks.OnControlResponseListener onControlResponseListener) {
        controlSwitch(0, onControlResponseListener);
    }

    public void onOneSetOff(IODeviceCallbacks.OnControlResponseListener onControlResponseListener) {
        controlSwitch(1, onControlResponseListener);
    }

    public void onTwoSetOneOn(IODeviceCallbacks.OnControlResponseListener onControlResponseListener) {
        controlSwitch(0, onControlResponseListener);
    }

    public void onTwoSetOneOff(IODeviceCallbacks.OnControlResponseListener onControlResponseListener) {
        controlSwitch(1, onControlResponseListener);
    }

    public void onTwoSetTwoOn(IODeviceCallbacks.OnControlResponseListener onControlResponseListener) {
        controlSwitch(2, onControlResponseListener);
    }

    public void onTwoSetTwoOff(IODeviceCallbacks.OnControlResponseListener onControlResponseListener) {
        controlSwitch(3, onControlResponseListener);
    }

    public int controlSwitch(int i, IODeviceCallbacks.OnControlResponseListener onControlResponseListener) {
        Switcher switcher = this.switcher;
        if (switcher == null) {
            return 102;
        }
        switcher.controlSwitch(i, onControlResponseListener);
        IOLog.i(TAG, "controll switch");
        return 1;
    }
}
