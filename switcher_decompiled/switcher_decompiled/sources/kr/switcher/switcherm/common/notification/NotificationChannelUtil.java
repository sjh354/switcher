package kr.switcher.switcherm.common.notification;

import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.internal.view.SupportMenu;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.ui.splash.SplashActivity;

/* JADX INFO: loaded from: classes2.dex */
public class NotificationChannelUtil {
    private static final String GROUP_IO = "I/O";

    @Retention(RetentionPolicy.SOURCE)
    public @interface Channel {
        public static final String COMMENT = "comment";
        public static final String MESSAGE = "message";
        public static final String NOTICE = "notice";
    }

    private static int getSmallIcon() {
        return R.drawable.ic_logo;
    }

    public static void createChannel(Context context) {
        getManager(context).createNotificationChannelGroup(new NotificationChannelGroup(GROUP_IO, GROUP_IO));
        NotificationChannel notificationChannel = new NotificationChannel(Channel.MESSAGE, "IO 알림", 4);
        notificationChannel.setDescription("IO 알림");
        notificationChannel.setGroup(GROUP_IO);
        notificationChannel.setLightColor(SupportMenu.CATEGORY_MASK);
        notificationChannel.setLockscreenVisibility(1);
        getManager(context).createNotificationChannel(notificationChannel);
    }

    private static NotificationManager getManager(Context context) {
        return (NotificationManager) context.getSystemService("notification");
    }

    public static void deleteChannel(Context context, String str) {
        getManager(context).deleteNotificationChannel(str);
    }

    public static void sendNotification(Context context, int i, String str, String str2, String str3) {
        NotificationManagerCompat.from(context).notify(i, new NotificationCompat.Builder(context, str).setSmallIcon(getSmallIcon()).setContentTitle(str2).setContentText(str3).setPriority(1).setCategory(NotificationCompat.CATEGORY_MESSAGE).setColor(IOUtil.getColorResource(R.color.periwinkle)).setContentIntent(PendingIntent.getActivity(context, 0, new Intent(context, (Class<?>) SplashActivity.class), 67108864)).setAutoCancel(true).setOnlyAlertOnce(true).build());
    }
}
