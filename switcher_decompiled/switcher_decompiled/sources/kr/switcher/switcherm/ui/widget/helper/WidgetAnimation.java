package kr.switcher.switcherm.ui.widget.helper;

import android.appwidget.AppWidgetManager;
import android.os.Handler;
import android.os.Looper;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kr.switcher.device.switcher.Switcher;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.device.switcher.handler.SwitcherHandler;

/* JADX INFO: loaded from: classes2.dex */
public class WidgetAnimation {
    private static final String TAG = "WidgetAnimation";
    private static volatile WidgetAnimation instance;
    private int blink = 0;
    private Handler handler = new Handler(Looper.getMainLooper());
    private Map<Integer, WidgetAnimationInfo> map;
    private List<Integer> views;

    static /* synthetic */ int access$204(WidgetAnimation widgetAnimation) {
        int i = widgetAnimation.blink + 1;
        widgetAnimation.blink = i;
        return i;
    }

    public static WidgetAnimation getInstance() {
        if (instance == null) {
            synchronized (WidgetAnimation.class) {
                instance = new WidgetAnimation();
            }
        }
        return instance;
    }

    public WidgetAnimation() {
        ArrayList arrayList = new ArrayList();
        this.views = arrayList;
        arrayList.add(8);
        this.views.add(0);
        this.map = new HashMap();
    }

    public void startAnimation(RemoteViews remoteViews, AppWidgetManager appWidgetManager, int i, String str) {
        String str2 = TAG;
        IOLog.d(str2, "start animation");
        if (isAppId(i)) {
            return;
        }
        this.map.put(Integer.valueOf(i), new WidgetAnimationInfo(remoteViews, appWidgetManager, str));
        IOLog.d(str2, "widget app id : " + i);
        this.blink = 0;
        if (this.handler.hasMessages(0)) {
            return;
        }
        this.handler.post(getAnimateRunnable(i));
    }

    public void stopAnimation(int i) {
        String str = TAG;
        IOLog.d(str, "stop animation (widget id : " + i + ")");
        removeAppId(i);
        if (this.handler.hasMessages(0)) {
            return;
        }
        IOLog.d(str, "remove callback");
        this.handler.removeCallbacks(getAnimateRunnable(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Runnable getAnimateRunnable(final int i) {
        return new Runnable() { // from class: kr.switcher.switcherm.ui.widget.helper.WidgetAnimation.1
            @Override // java.lang.Runnable
            public void run() {
                IOLog.d(WidgetAnimation.TAG, "run animation (widget id:" + i + ")");
                WidgetAnimationInfo widgetAnimationInfo = (WidgetAnimationInfo) WidgetAnimation.this.map.get(Integer.valueOf(i));
                if (widgetAnimationInfo == null) {
                    IOLog.d(WidgetAnimation.TAG, "widget animation info is null");
                    return;
                }
                RemoteViews remoteView = widgetAnimationInfo.getRemoteView();
                AppWidgetManager appWidgetManager = widgetAnimationInfo.getAppWidgetManager();
                Switcher switcher = SwitcherHandler.getInstance().getSwitcher(widgetAnimationInfo.getMacAddress());
                if (switcher == null) {
                    IOLog.d(WidgetAnimation.TAG, "switcher is null");
                    return;
                }
                Switcher.ConnectionState connectionState = switcher.getConnectionState();
                if (connectionState.equals(Switcher.ConnectionState.CONNECTED)) {
                    IOLog.d(WidgetAnimation.TAG, "connection state is connected");
                    WidgetAnimation.this.blink = 0;
                    WidgetAnimation.this.stopAnimation(i);
                } else if (connectionState.equals(Switcher.ConnectionState.CONNECTING)) {
                    IOLog.d(WidgetAnimation.TAG, "connection state is connecting");
                    WidgetAnimation widgetAnimation = WidgetAnimation.this;
                    widgetAnimation.blink = WidgetAnimation.access$204(widgetAnimation) % 2;
                } else {
                    IOLog.d(WidgetAnimation.TAG, "unknown connection state");
                    WidgetAnimation.this.stopAnimation(i);
                    return;
                }
                IOLog.d(WidgetAnimation.TAG, "blink" + WidgetAnimation.this.blink);
                remoteView.setViewVisibility(R.id.disabled, ((Integer) WidgetAnimation.this.views.get(WidgetAnimation.this.blink)).intValue());
                remoteView.setViewVisibility(R.id.connected, ((Integer) WidgetAnimation.this.views.get(Math.abs(WidgetAnimation.this.blink - 1))).intValue());
                appWidgetManager.updateAppWidget(i, remoteView);
                WidgetAnimation.this.handler.postDelayed(WidgetAnimation.this.getAnimateRunnable(i), 500L);
            }
        };
    }

    private boolean isAppId(int i) {
        Iterator<Integer> it = this.map.keySet().iterator();
        while (it.hasNext()) {
            if (i == it.next().intValue()) {
                return true;
            }
        }
        return false;
    }

    private void removeAppId(int i) {
        this.map.remove(Integer.valueOf(i));
    }

    public class WidgetAnimationInfo {
        private AppWidgetManager appWidgetManager;
        private String macAddress;
        private RemoteViews remoteView;

        public WidgetAnimationInfo(RemoteViews remoteViews, AppWidgetManager appWidgetManager, String str) {
            this.remoteView = remoteViews;
            this.appWidgetManager = appWidgetManager;
            this.macAddress = str;
        }

        public RemoteViews getRemoteView() {
            return this.remoteView;
        }

        public AppWidgetManager getAppWidgetManager() {
            return this.appWidgetManager;
        }

        public String getMacAddress() {
            return this.macAddress;
        }
    }
}
