package kr.switcher.switcherm.ui.widget.presenter;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.widget.RemoteViews;
import java.util.List;
import kr.switcher.device.linker.Linker;
import kr.switcher.device.remocon.Remocon;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.device.IODeviceHandler;
import kr.switcher.switcherm.device.linker.LinkerHandler;
import kr.switcher.switcherm.preference.PreferenceHelper;
import kr.switcher.switcherm.preference.WidgetPreference;
import kr.switcher.switcherm.service.IOService;
import kr.switcher.switcherm.service.WidgetService;
import kr.switcher.switcherm.ui.widget.presenter.helper.PendingIntentsMaker;
import kr.switcher.switcherm.ui.widget.view.SettopWidgetView;

/* JADX INFO: loaded from: classes2.dex */
public class SettopWidgetPresenter {
    public static final int CHANNEL_DOWN = 2;
    public static final int CHANNEL_UP = 1;
    public static final int POWER = 0;
    private static final String TAG = "SettopWidgetPresenter";
    public static final int VOLUME_DOWN = 4;
    public static final int VOLUME_UP = 3;
    private IODeviceHandler ioDeviceHandler;
    private Linker linker;
    private LinkerHandler linkerHandler;
    private WidgetPreference preference;
    private SettopWidgetView view;

    public SettopWidgetPresenter(SettopWidgetView settopWidgetView, IODeviceHandler iODeviceHandler, LinkerHandler linkerHandler, WidgetPreference widgetPreference, Context context) {
        this.view = settopWidgetView;
        this.ioDeviceHandler = iODeviceHandler;
        this.preference = widgetPreference;
        this.linkerHandler = linkerHandler;
        PreferenceHelper.setContext(context);
    }

    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] iArr) {
        for (int i : iArr) {
            updateAppWidget(context, appWidgetManager, i, new RemoteViews(context.getPackageName(), R.layout.widget_settop));
        }
    }

    public void updateAppWidget(Context context, AppWidgetManager appWidgetManager, int i, RemoteViews remoteViews) {
        String widgetSwitcherAddress = this.preference.getWidgetSwitcherAddress(i);
        if (LinkerHandler.getInstance().getAliveLinkers().size() > 0) {
            this.linker = LinkerHandler.getInstance().getAliveLinkers().get(0);
        }
        if (this.linker != null) {
            this.view.showSettopConnected(remoteViews);
        } else {
            this.view.showSettopDisconnected(remoteViews);
        }
        Remocon remocon = (Remocon) this.ioDeviceHandler.getDevice(widgetSwitcherAddress);
        if (remocon != null) {
            this.view.setSettopName(remoteViews, remocon.getName());
        } else {
            this.view.setSettopName(remoteViews, "찾을 수 없음");
        }
        this.view.setButtonEvent(remoteViews, getButtonPendingIntents(context, i));
        this.view.updateAppWidget(appWidgetManager, i, remoteViews);
    }

    private List<PendingIntent> getButtonPendingIntents(Context context, int i) {
        Intent[] intentArr = new Intent[10];
        for (int i2 = 0; i2 < 10; i2++) {
            Intent intent = new Intent(context, (Class<?>) WidgetService.class);
            intentArr[i2] = intent;
            intent.setData(Uri.parse(String.valueOf(i)));
            int i3 = i2 % 5;
            if (i3 == 0) {
                intentArr[i2].putExtra(IOService.PARM_SETTOP_BUTTON, 0);
            } else if (i3 == 1) {
                intentArr[i2].putExtra(IOService.PARM_SETTOP_BUTTON, 1);
            } else if (i3 == 2) {
                intentArr[i2].putExtra(IOService.PARM_SETTOP_BUTTON, 2);
            } else if (i3 == 3) {
                intentArr[i2].putExtra(IOService.PARM_SETTOP_BUTTON, 3);
            } else if (i3 == 4) {
                intentArr[i2].putExtra(IOService.PARM_SETTOP_BUTTON, 4);
            }
        }
        return PendingIntentsMaker.makePendingIntents(context, intentArr);
    }

    public void onDeleted(int[] iArr) {
        for (int i : iArr) {
            this.preference.setWidgetSwitcherAddress(i, this.preference.getWidgetSwitcherAddress(i));
            Log.i(TAG, "delete widget (id:" + i + ")");
        }
    }
}
