package com.google.firebase.messaging;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@23.0.0 */
/* JADX INFO: loaded from: classes.dex */
final class ProxyNotificationPreferences {
    private static SharedPreferences getPreference(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        return context.getSharedPreferences("com.google.firebase.messaging", 0);
    }

    static boolean isProxyNotificationInitialized(Context context) {
        return getPreference(context).getBoolean("proxy_notification_initialized", false);
    }

    static void setProxyNotificationsInitialized(Context context, boolean z) {
        SharedPreferences.Editor editorEdit = getPreference(context).edit();
        editorEdit.putBoolean("proxy_notification_initialized", true);
        editorEdit.apply();
    }
}
