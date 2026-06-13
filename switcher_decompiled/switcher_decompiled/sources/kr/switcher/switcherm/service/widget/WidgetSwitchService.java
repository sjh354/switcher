package kr.switcher.switcherm.service.widget;

import kr.switcher.device.switcher.Switcher;
import kr.switcher.device.switcher.interfaces.IODeviceCallbacks;
import kr.switcher.switcherm.common.util.IOUtil;

/* JADX INFO: loaded from: classes2.dex */
public class WidgetSwitchService implements IODeviceCallbacks.OnControlResponseListener {
    private static final String TAG = "WidgetSwitchService";
    private static boolean isWaiting;
    private OnControlSwitchListener listener;
    private int switchPosition;
    private Switcher switcher;

    public interface OnControlSwitchListener {
        void onComplete(boolean z);

        void onWaiting();
    }

    public WidgetSwitchService(Switcher switcher, int i, OnControlSwitchListener onControlSwitchListener) {
        this.switcher = switcher;
        this.switchPosition = i;
        this.listener = onControlSwitchListener;
    }

    public void setSwitcher(Switcher switcher) {
        this.switcher = switcher;
    }

    public void controlSwitch() {
        this.switcher.controlSwitch(this.switchPosition, this);
        if (!isWaiting) {
            isWaiting = true;
        } else {
            IOUtil.showToast("명령을 수행하고 있습니다. 잠시만 기다려주세요.");
        }
        onWaiting();
    }

    @Override // kr.switcher.device.switcher.interfaces.IODeviceCallbacks.OnControlResponseListener
    public void onControlResult(boolean z) {
        isWaiting = false;
        onComplete(z);
    }

    private void onWaiting() {
        OnControlSwitchListener onControlSwitchListener = this.listener;
        if (onControlSwitchListener != null) {
            onControlSwitchListener.onWaiting();
        }
    }

    private void onComplete(boolean z) {
        OnControlSwitchListener onControlSwitchListener = this.listener;
        if (onControlSwitchListener != null) {
            onControlSwitchListener.onComplete(z);
        }
    }
}
