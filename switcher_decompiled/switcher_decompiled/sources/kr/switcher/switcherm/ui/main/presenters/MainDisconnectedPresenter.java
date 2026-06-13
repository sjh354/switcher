package kr.switcher.switcherm.ui.main.presenters;

import android.os.Handler;
import android.os.Looper;
import kr.switcher.device.switcher.Switcher;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.device.switcher.handler.SwitcherHandler;
import kr.switcher.switcherm.ui.main.MainActivity;
import kr.switcher.switcherm.ui.main.views.MainDisconnectedView;

/* JADX INFO: loaded from: classes2.dex */
public class MainDisconnectedPresenter {
    private MainDisconnectedView view;

    public MainDisconnectedPresenter(MainDisconnectedView mainDisconnectedView) {
        this.view = mainDisconnectedView;
    }

    public void onCreateView(Switcher switcher, int i) {
        this.view.hideProgressbar();
        this.view.sendMainData(switcher.getMacAddress(), switcher.getProductId(), switcher.getName(), IOUtil.getStringResource(R.string.disconnected), MainActivity.MainBackgroundState.DISCONNECTED);
        handleErrorStatus(switcher, i);
    }

    private void handleErrorStatus(Switcher switcher, int i) {
        this.view.showProgressbar();
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: kr.switcher.switcherm.ui.main.presenters.MainDisconnectedPresenter.1
            @Override // java.lang.Runnable
            public void run() {
                MainDisconnectedPresenter.this.view.hideProgressbar();
            }
        }, 3000L);
    }

    public void onPause() {
        this.view.hideProgressbar();
    }

    public void reconnect(String str) {
        this.view.showProgressbar();
        if (SwitcherHandler.getInstance().getSwitcher(str) != null) {
            this.view.moveConnectingScreen(str);
        }
    }
}
