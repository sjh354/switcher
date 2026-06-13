package kr.switcher.switcherm.common.notification;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Parcelable;
import androidx.core.app.NotificationCompat;
import com.google.firebase.messaging.RemoteMessage;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.activity.IOActivity;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.ui.splash.SplashActivity;

/* JADX INFO: loaded from: classes2.dex */
public class NotificationUtil {
    public static void sendNotification(Context context, String str, String str2, int i, Parcelable parcelable, List<NotiButtonParameter> list) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        if (Build.VERSION.SDK_INT >= 26) {
            notificationManager.createNotificationChannel(new NotificationChannel("MESSAGE", "I/O 알림", 4));
        }
        NotificationCompat.Builder onlyAlertOnce = new NotificationCompat.Builder(context, "MESSAGE").setSmallIcon(R.drawable.ic_logo).setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_logo)).setBadgeIconType(R.drawable.ic_logo).setContentTitle(str).setContentText(str2).setAutoCancel(true).setPriority(1).setCategory(NotificationCompat.CATEGORY_MESSAGE).setColor(IOUtil.getColorResource(R.color.periwinkle)).setAutoCancel(true).setOnlyAlertOnce(true);
        for (int i2 = 0; i2 < list.size(); i2++) {
            NotiButtonParameter notiButtonParameter = list.get(i2);
            Intent intent = new Intent(context, (Class<?>) NotificationReceiver.class);
            intent.putExtra(IOActivity.ACTION, i);
            intent.putExtra(notiButtonParameter.getAction(), notiButtonParameter.getValue());
            intent.putExtra(IOActivity.ACTION_VALUE, parcelable);
            onlyAlertOnce.addAction(R.drawable.ic_logo, notiButtonParameter.getTitle(), PendingIntent.getBroadcast(context, i2, intent, 201326592));
        }
        if (list.size() == 0) {
            Intent intent2 = new Intent(context.getApplicationContext(), (Class<?>) SplashActivity.class);
            intent2.putExtra(IOActivity.ACTION, i);
            intent2.putExtra(IOActivity.ACTION_VALUE, parcelable);
            intent2.setFlags(603979776);
            onlyAlertOnce.setContentIntent(PendingIntent.getActivity(context.getApplicationContext(), 0, intent2, 201326592));
        }
        notificationManager.notify(0, onlyAlertOnce.build());
    }

    public static void sendNotification(Context context, String str, String str2, int i, Parcelable parcelable) {
        sendNotification(context, str, str2, i, parcelable, new ArrayList());
    }

    public static void sendNotification(Context context, String str, String str2, int i) {
        sendNotification(context, str, str2, i, null, new ArrayList());
    }

    public static void cancelNotification(Context context) {
        getManager(context).cancelAll();
    }

    private static NotificationManager getManager(Context context) {
        return (NotificationManager) context.getSystemService("notification");
    }

    public static void sendNotification(Context context, RemoteMessage remoteMessage) {
        sendNotification(context, ((RemoteMessage.Notification) Objects.requireNonNull(remoteMessage.getNotification())).getTitle(), remoteMessage.getNotification().getBody(), IOActivity.ACTION_PUSH);
    }
}
