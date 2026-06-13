package kr.switcher.switcherm.common.ga;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

/* JADX INFO: loaded from: classes2.dex */
public class GALogger {
    public static final String ACTION_ACCEPT_ALARM_LIGHT_OFF_3MINS_LATER = "accept_alarm_light_off_3mins_later";
    public static final String ACTION_ACCEPT_ALARM_SIGNAL_INTRODUCTION = "accept_alarm_signal_introduction";
    public static final String ACTION_ACCEPT_ALARM_SIGNAL_USECASE_SUGGESTION = "accept_alarm_signal_usecase_suggestion";
    public static final String ACTION_ACTIVATE_ALARM = "activate_alarm";
    public static final String ACTION_CREATE_ALARM = "create_alarm";
    public static final String ACTION_DEACTIVATE_ALARM = "deactivate_alarm";
    public static final String ACTION_DELETE_ALARM = "delete_alarm";
    public static final String ACTION_DENY_ALARM_LIGHT_OFF_3MINS_LATER = "deny_alarm_light_off_3mins_later";
    public static final String ACTION_DENY_ALARM_SIGNAL_INTRODUCTION = "deny_alarm_signal_introduction";
    public static final String ACTION_DENY_ALARM_SIGNAL_USECASE_SUGGESTION = "deny_alarm_signal_usecase_suggestion";
    public static final String ACTION_EDIT_ALARM = "edit_alarm";
    public static final String ACTION_FINGER_LENGTH_DEFAULT = "default";
    public static final String ACTION_FINGER_LENGTH_LONG = "long";
    public static final String ACTION_FINGER_LENGTH_SHORT = "short";
    public static final String ACTION_MOVE_KAKAO_FOR_PAYMENT_PLAN_CHANGE = "move_to_kakaotalk_for_payment_plan_change";
    public static final String ACTION_REQUEST_SHARE_CODE_TO_MASTER_FROM_GUEST = "request_share_code_to_master_from_guest";
    public static final String CATEGORY_ACTION = "action";
    public static final String CATEGORY_AUTOMATION = "automation";
    public static final String CATEGORY_SALES = "sales";
    public static final String CATEGORY_SAVE_FINGER_LENGTH = "save_finger_length";
    public static final String CATEGORY_SECURITY = "security";
    public static final String CATEGORY_SIGNAL = "signal";
    public static final String CATEGORY_TEST_FINGER_LENGTH = "test_finger_length";
    public static final String CONNECTING_TIME = "CONNECTING_TIME";
    public static final String ID = "UA-67524903-2";
    public static final String READING_DATA_TIME = "READING_DATA_TIME";
    public static final String RECONNECTING_TIME = "RECONNECTING_TIME";
    public static final String SCANNING_TIME = "SCANNING_TIME";
    public static final String SWITCH_LIGHTING_TYPE1_OFF = "SWITCH_LIGHTING_TYPE1_OFF";
    public static final String SWITCH_LIGHTING_TYPE1_ON = "SWITCH_LIGHTING_TYPE1_ON";
    public static final String SWITCH_LIGHTING_TYPE2_1WAY_OFF = "SWITCH_LIGHTING_TYPE2_1WAY_OFF";
    public static final String SWITCH_LIGHTING_TYPE2_1WAY_ON = "SWITCH_LIGHTING_TYPE2_1WAY_ON";
    public static final String SWITCH_LIGHTING_TYPE2_2WAY_OFF = "SWITCH_LIGHTING_TYPE2_2WAY_OFF";
    public static final String SWITCH_LIGHTING_TYPE2_2WAY_ON = "SWITCH_LIGHTING_TYPE2_2WAY_ON";
    public static final String TOTAL_CONNECTING_TIME = "TOTAL_CONNECTING_TIME";
    private static Context context;

    public static void setContext(Context context2) {
        context = context2;
    }

    public static void trackActivity(String str) {
        Tracker trackerNewTracker = GoogleAnalytics.getInstance(context).newTracker(ID);
        trackerNewTracker.setScreenName(str);
        trackerNewTracker.send(new HitBuilders.ScreenViewBuilder().build());
    }

    public static void recordCrash(Exception exc) {
        GoogleAnalytics.getInstance(context).newTracker(ID).send(new HitBuilders.ExceptionBuilder().setDescription(Log.getStackTraceString(exc)).setFatal(true).build());
    }

    public static void recordEvent(String str) {
        GoogleAnalytics.getInstance(context).newTracker(ID).send(new HitBuilders.EventBuilder().setCategory(CATEGORY_ACTION).setAction(str).build());
    }

    public static void recordEvent(String str, long j) {
        GoogleAnalytics.getInstance(context).newTracker(ID).send(new HitBuilders.EventBuilder().setCategory(CATEGORY_ACTION).setAction(str).setValue(j).build());
    }

    public static void recordEvent(String str, String str2) {
        GoogleAnalytics.getInstance(context).newTracker(ID).send(new HitBuilders.EventBuilder().setCategory(str).setAction(str2).build());
    }

    public static void recordEvent(String str, String str2, String str3) {
        GoogleAnalytics.getInstance(context).newTracker(ID).send(new HitBuilders.EventBuilder().setCategory(str).setAction(str2).setLabel(str3).build());
    }
}
