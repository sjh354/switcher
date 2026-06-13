package kr.switcher.switcherm.ui.widget.presenter;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.widget.RemoteViews;
import java.util.List;
import kr.switcher.device.switcher.Switcher;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.device.switcher.handler.SwitcherHandler;
import kr.switcher.switcherm.permission.PermissionChecker;
import kr.switcher.switcherm.preference.PreferenceHelper;
import kr.switcher.switcherm.preference.WidgetPreference;
import kr.switcher.switcherm.service.IOService;
import kr.switcher.switcherm.service.WidgetService;
import kr.switcher.switcherm.ui.widget.presenter.helper.PendingIntentsMaker;
import kr.switcher.switcherm.ui.widget.view.OneButtonWidgetView;

/* JADX INFO: loaded from: classes2.dex */
public class OneButtonWidgetPresenter {
    private static final String TAG = "OneButtonWidgetPresenter";
    private WidgetPreference preference;
    private SwitcherHandler switcherHandler;
    private OneButtonWidgetView view;

    public OneButtonWidgetPresenter(OneButtonWidgetView oneButtonWidgetView, SwitcherHandler switcherHandler, WidgetPreference widgetPreference, Context context) {
        this.view = oneButtonWidgetView;
        this.switcherHandler = switcherHandler;
        this.preference = widgetPreference;
        PreferenceHelper.setContext(context);
    }

    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] iArr) {
        boolean zCheckFineLocationPermission = PermissionChecker.checkFineLocationPermission(context);
        for (int i : iArr) {
            updateAppWidget(context, appWidgetManager, i, new RemoteViews(context.getPackageName(), R.layout.widget_one_button), zCheckFineLocationPermission);
        }
    }

    public void updateAppWidget(Context context, AppWidgetManager appWidgetManager, int i, RemoteViews remoteViews, boolean z) {
        if (z) {
            String widgetSwitcherAddress = this.preference.getWidgetSwitcherAddress(i);
            Switcher switcher = this.switcherHandler.getSwitcher(widgetSwitcherAddress);
            if (switcher == null) {
                this.view.showDisabled(remoteViews, appWidgetManager, i, widgetSwitcherAddress);
            } else {
                this.view.setSwitcherName(remoteViews, switcher.getName());
                Switcher.ConnectionState connectionState = switcher.getConnectionState();
                IOLog.i(TAG, "connection status : " + connectionState);
                int i2 = AnonymousClass1.$SwitchMap$kr$switcher$device$switcher$Switcher$ConnectionState[connectionState.ordinal()];
                if (i2 == 1) {
                    this.view.showConnected(remoteViews, appWidgetManager, i, widgetSwitcherAddress);
                } else if (i2 == 2) {
                    this.view.showConnecting(remoteViews, appWidgetManager, i, widgetSwitcherAddress);
                } else {
                    this.view.showDisabled(remoteViews, appWidgetManager, i, widgetSwitcherAddress);
                }
            }
            this.view.setButtonEvent(remoteViews, getButtonPendingIntents(context, i));
        } else {
            this.view.showNoBlePermission(remoteViews);
        }
        this.view.updateAppWidget(appWidgetManager, i, remoteViews);
    }

    /* JADX INFO: renamed from: kr.switcher.switcherm.ui.widget.presenter.OneButtonWidgetPresenter$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$kr$switcher$device$switcher$Switcher$ConnectionState;

        static {
            int[] iArr = new int[Switcher.ConnectionState.values().length];
            $SwitchMap$kr$switcher$device$switcher$Switcher$ConnectionState = iArr;
            try {
                iArr[Switcher.ConnectionState.CONNECTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$kr$switcher$device$switcher$Switcher$ConnectionState[Switcher.ConnectionState.CONNECTING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private List<PendingIntent> getButtonPendingIntents(Context context, int i) {
        Intent[] intentArr = new Intent[4];
        for (int i2 = 0; i2 < 4; i2++) {
            Intent intent = new Intent(context, (Class<?>) WidgetService.class);
            intentArr[i2] = intent;
            intent.setData(Uri.parse(String.valueOf(i)));
            if (i2 % 2 == 0) {
                intentArr[i2].putExtra(IOService.PARM_SWITCH_POSITION, 0);
            } else {
                intentArr[i2].putExtra(IOService.PARM_SWITCH_POSITION, 1);
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
