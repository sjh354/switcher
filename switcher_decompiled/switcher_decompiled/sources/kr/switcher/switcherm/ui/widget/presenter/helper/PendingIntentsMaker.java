package kr.switcher.switcherm.ui.widget.presenter.helper;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import java.util.ArrayList;
import java.util.List;
import kr.switcher.switcherm.ui.splash.SplashActivity;

/* JADX INFO: loaded from: classes2.dex */
public class PendingIntentsMaker {
    public static List<PendingIntent> makePendingIntents(Context context, Intent[] intentArr) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < intentArr.length; i++) {
            if (Build.VERSION.SDK_INT >= 26) {
                arrayList.add(PendingIntent.getForegroundService(context, i, intentArr[i], 201326592));
            } else {
                arrayList.add(PendingIntent.getService(context, i, intentArr[i], 201326592));
            }
        }
        arrayList.add(PendingIntent.getActivity(context, 0, new Intent(context, (Class<?>) SplashActivity.class), 67108864));
        return arrayList;
    }
}
