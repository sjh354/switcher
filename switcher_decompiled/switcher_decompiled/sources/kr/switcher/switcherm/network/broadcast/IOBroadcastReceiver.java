package kr.switcher.switcherm.network.broadcast;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.util.Iterator;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.service.IOService;

/* JADX INFO: loaded from: classes2.dex */
public class IOBroadcastReceiver extends BroadcastReceiver {
    public static final String ACTION_LAUNCH = "luanch";
    public static final String ACTION_RESTART = "restart";
    public static final String ARG_SMS_MESSAGE = "sms_message";
    private final String TAG = "IOBroadcastReceiver";

    public IOBroadcastReceiver() {
        IOLog.d("IOBroadcastReceiver", "createLinkedDevices receiver");
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        action.hashCode();
        switch (action) {
            case "android.intent.action.SCREEN_OFF":
                IOLog.d(this.TAG, "스크린 OFF");
                break;
            case "android.intent.action.SCREEN_ON":
                IOLog.d(this.TAG, "스크린 ON");
                startIOService(context);
                break;
            case "luanch":
                IOLog.d(this.TAG, "Launch");
                startIOService(context);
                break;
            case "android.intent.action.BOOT_COMPLETED":
                IOLog.d(this.TAG, "부팅완료");
                startIOService(context);
                break;
            case "restart":
                IOLog.d(this.TAG, "Restart service");
                startIOService(context);
                break;
        }
    }

    private void startIOService(Context context) {
        if (isMyServiceRunning(context, IOService.class)) {
            return;
        }
        context.startService(new Intent(context, (Class<?>) IOService.class));
    }

    private void stopIOService(Context context) {
        context.stopService(new Intent(context, (Class<?>) IOService.class));
    }

    private boolean isMyServiceRunning(Context context, Class<?> cls) {
        Iterator<ActivityManager.RunningServiceInfo> it = ((ActivityManager) context.getSystemService("activity")).getRunningServices(Integer.MAX_VALUE).iterator();
        while (it.hasNext()) {
            if (cls.getName().equals(it.next().service.getClassName())) {
                return true;
            }
        }
        return false;
    }
}
