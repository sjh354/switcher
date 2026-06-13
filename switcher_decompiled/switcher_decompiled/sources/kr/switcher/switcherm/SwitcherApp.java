package kr.switcher.switcherm;

import android.app.Application;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import kr.switcher.device.switcher.Switcher;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.preference.FCMPreference;
import kr.switcher.switcherm.preference.OAuthToken;
import kr.switcher.switcherm.preference.TimerVersion;
import kr.switcher.switcherm.user.User;
import kr.switcher.switcherm.user.UserStateManager;

/* JADX INFO: loaded from: classes2.dex */
public class SwitcherApp extends Application {
    private static final String TAG = "SwitcherApp";

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        initialize();
    }

    private void initialize() {
        FirebaseCrashlytics.getInstance().setCrashlyticsCollectionEnabled(true);
        IOUtil.initialize(getApplicationContext());
        User currentUserFromDB = UserStateManager.getInstance().getCurrentUserFromDB();
        if (currentUserFromDB != null) {
            IOLog.logUser(currentUserFromDB.getId(), currentUserFromDB.getEmail(), currentUserFromDB.getUserName(), new OAuthToken().getOAuthToken(), currentUserFromDB.getPhoneNumber());
        }
        Switcher.SwitcherReservation.currentTimerVersion = new TimerVersion().getTimerVersion();
        if (new FCMPreference().getFCMToken() != null) {
            IOLog.i(TAG, "FCM InstanceId Published");
        }
    }
}
