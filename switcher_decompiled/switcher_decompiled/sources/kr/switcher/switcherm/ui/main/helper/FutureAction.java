package kr.switcher.switcherm.ui.main.helper;

import java.io.Serializable;
import kr.switcher.device.switcher.Switcher;

/* JADX INFO: loaded from: classes2.dex */
public class FutureAction {
    private OnFutureActionListener listener;

    public enum Action implements Serializable {
        ACTION_CONNECT,
        ACTION_CODE,
        ACTION_REGISTER
    }

    public interface OnFutureActionListener {
        void onAction(Action action);
    }

    public void setOnFutureActionListener(OnFutureActionListener onFutureActionListener) {
        this.listener = onFutureActionListener;
    }

    public void what(Switcher switcher) {
        what(switcher, switcher.isMine());
    }

    public void what(Switcher switcher, boolean z) {
        if (z) {
            whatActionForMine(switcher);
        } else {
            whatActionForOther(switcher);
        }
    }

    private void whatActionForMine(Switcher switcher) {
        if (switcher.getOwner() == null) {
            this.listener.onAction(Action.ACTION_REGISTER);
        } else {
            this.listener.onAction(Action.ACTION_CONNECT);
        }
    }

    private void whatActionForOther(Switcher switcher) {
        if (switcher.getOwner() == null) {
            this.listener.onAction(Action.ACTION_REGISTER);
        } else {
            whatActionCodeOrConnect(switcher);
        }
    }

    private void whatActionCodeOrConnect(Switcher switcher) {
        String shareCode = switcher.getShareCode();
        if (shareCode == null || shareCode.length() != 4) {
            this.listener.onAction(Action.ACTION_CODE);
        } else {
            this.listener.onAction(Action.ACTION_CONNECT);
        }
    }
}
