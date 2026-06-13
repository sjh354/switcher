package kr.switcher.switcherm.common.notification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.activity.IOActivity;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.preference.LocalMarketingPreference;
import kr.switcher.switcherm.signal.SignalData;
import kr.switcher.switcherm.ui.splash.SplashActivity;

/* JADX INFO: loaded from: classes2.dex */
public class NotificationReceiver extends BroadcastReceiver {
    private static String TAG = "NotificationReceiver";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        NotificationUtil.cancelNotification(context);
        String stringExtra = intent.getStringExtra(NotiButtonParameter.PARM_NOTI_ACTION);
        Parcelable parcelableExtra = intent.getParcelableExtra(IOActivity.ACTION_VALUE);
        int intExtra = intent.getIntExtra(IOActivity.ACTION, IOActivity.ACTION_MAIN);
        SignalData signalData = (SignalData) parcelableExtra;
        if (stringExtra.equals(NotiButtonParameter.NOTI_ACTION_DISABLE)) {
            if (signalData.getType() == 4) {
                new LocalMarketingPreference().setMarketingWidgetBanner(false);
                return;
            } else {
                new LocalMarketingPreference().setLocalMarketingLinker(false);
                return;
            }
        }
        if (stringExtra.equals(NotiButtonParameter.NOTI_ACTION_CONFIRM)) {
            if (signalData.getType() == 4) {
                new LocalMarketingPreference().setMarketingWidgetBanner(false);
                recordGA(signalData.getTitleText());
            } else {
                new LocalMarketingPreference().setLocalMarketingLinker(false);
            }
            Intent intent2 = new Intent(context.getApplicationContext(), (Class<?>) SplashActivity.class);
            intent2.putExtra(IOActivity.ACTION, intExtra);
            intent2.putExtra(IOActivity.ACTION_VALUE, parcelableExtra);
            intent2.setFlags(603979776);
            context.startActivity(intent2);
        }
    }

    private void recordGA(String str) {
        IOLog.i(TAG, "IOtest title" + str);
        if (str.equals(IOUtil.getStringResource(R.string.widget_banner_title_checker))) {
            IOLog.event("move_free_try", "banner", "checker");
        } else if (str.equals(IOUtil.getStringResource(R.string.widget_banner_title_linker))) {
            IOLog.event("move_free_try", "banner", "linker");
        } else if (str.equals(IOUtil.getStringResource(R.string.widget_banner_title_switcher))) {
            IOLog.event("move_free_try", "banner", "switcher");
        }
    }
}
