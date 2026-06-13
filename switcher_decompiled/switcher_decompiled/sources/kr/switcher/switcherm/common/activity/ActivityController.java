package kr.switcher.switcherm.common.activity;

import android.app.Activity;
import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import kr.switcher.switcherm.ui.questionnaire.QuestionnaireActivity;
import kr.switcher.switcherm.ui.register.RegisterActivity;
import kr.switcher.switcherm.ui.setting.SettingActivity;

/* JADX INFO: loaded from: classes2.dex */
public class ActivityController {
    public static void moveSettingMenuActivity(Activity activity, String str) {
        Intent intent = new Intent(activity, (Class<?>) SettingActivity.class);
        intent.putExtra("CONNECTED_MAC_ADDRESS", str);
        activity.startActivityForResult(intent, 1);
    }

    public static void moveSettingReservationMenuActivity(Activity activity, String str) {
        Intent intent = new Intent(activity, (Class<?>) SettingActivity.class);
        intent.putExtra("CONNECTED_MAC_ADDRESS", str);
        intent.putExtra(SettingActivity.PARM_NEXT_FRAGMENT, "ReservationListFragment");
        activity.startActivity(intent);
    }

    public static void moveSettingAirconReservationMenuActivity(Activity activity, String str) {
        Intent intent = new Intent(activity, (Class<?>) SettingActivity.class);
        intent.putExtra("CONNECTED_MAC_ADDRESS", str);
        intent.putExtra(SettingActivity.PARM_NEXT_FRAGMENT, "AirconReservationListFragment");
        activity.startActivity(intent);
    }

    public static void moveSettingAirconMaintainingTemperatureMenuActivity(Activity activity, String str) {
        Intent intent = new Intent(activity, (Class<?>) SettingActivity.class);
        intent.putExtra("CONNECTED_MAC_ADDRESS", str);
        intent.putExtra(SettingActivity.PARM_NEXT_FRAGMENT, "AirconMaintainingTemperatureListFragment");
        activity.startActivity(intent);
    }

    public static void moveSettingSettopReservationMenuActivity(Activity activity, String str) {
        Intent intent = new Intent(activity, (Class<?>) SettingActivity.class);
        intent.putExtra("CONNECTED_MAC_ADDRESS", str);
        intent.putExtra(SettingActivity.PARM_NEXT_FRAGMENT, "SettopReservationListFragment");
        activity.startActivity(intent);
    }

    public static void moveCheckerHistoryMenuActivity(Activity activity, String str) {
        Intent intent = new Intent(activity, (Class<?>) SettingActivity.class);
        intent.putExtra("CONNECTED_MAC_ADDRESS", str);
        intent.putExtra(SettingActivity.PARM_NEXT_FRAGMENT, "CheckerHistoryFragment");
        activity.startActivity(intent);
    }

    public static void moveSettingStrokeMenuActivity(Activity activity, String str) {
        Intent intent = new Intent(activity, (Class<?>) SettingActivity.class);
        intent.putExtra("CONNECTED_MAC_ADDRESS", str);
        intent.putExtra(SettingActivity.PARM_NEXT_FRAGMENT, "StrokeLevelFragment");
        activity.startActivity(intent);
    }

    public static void moveQuestionnaireActivity(Activity activity, String str) {
        Intent intent = new Intent(activity, (Class<?>) QuestionnaireActivity.class);
        intent.putExtra("CONNECTED_MAC_ADDRESS", str);
        activity.startActivity(intent);
    }

    public static void moveRegisterActivity(Activity activity, String str) {
        Intent intent = new Intent(activity, (Class<?>) RegisterActivity.class);
        intent.putExtra("CONNECTED_MAC_ADDRESS", str);
        activity.startActivityForResult(intent, 1);
    }

    public static void moveSurveillanceMenuActivity(FragmentActivity fragmentActivity, String str) {
        Intent intent = new Intent(fragmentActivity, (Class<?>) SettingActivity.class);
        intent.putExtra("CONNECTED_MAC_ADDRESS", str);
        intent.putExtra(SettingActivity.PARM_NEXT_FRAGMENT, "CheckerSurveillanceListFragment");
        fragmentActivity.startActivity(intent);
    }
}
