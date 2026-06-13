package kr.switcher.switcherm.ui.dialog;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import kr.switcher.switcherm.signal.SignalData;
import kr.switcher.switcherm.signal.SignalFragment;
import kr.switcher.switcherm.ui.dialog.lowbattery.LowBatteryDialogFragment;
import kr.switcher.switcherm.ui.dialog.signal.AlarmSignalUsecaseSuggestionFragment;
import kr.switcher.switcherm.ui.dialog.signal.SignalTypeDialogFragment;
import kr.switcher.switcherm.ui.dialog.warning.WarningForCheckerInitializeDialogFragment;
import kr.switcher.switcherm.ui.dialog.warning.WarningForInitializeDialogFragment;
import kr.switcher.switcherm.ui.dialog.warning.WarningForRegisterDialogFragment;

/* JADX INFO: loaded from: classes2.dex */
public class IODialogController {
    private static Context context;

    public static void setContext(Context context2) {
        context = context2;
    }

    public static void showConfirmDialog(Context context2, String str, ConfirmCallback confirmCallback) {
        ConfirmDialogFragment.newInstance(str, confirmCallback).show(((AppCompatActivity) context2).getSupportFragmentManager(), "ConfirmDialogFragment");
    }

    public static void showSignalDialog(Context context2, String str, String str2, String str3, int i, int i2, ConfirmCallback confirmCallback) {
        SignalDialogFragment.newInstance(str, str2, str3, i, i2, confirmCallback).show(((AppCompatActivity) context2).getSupportFragmentManager(), "SignalDialogFragment");
    }

    public static void showSignalDialog3(Context context2, ConfirmCallback confirmCallback) {
        AlarmSignalUsecaseSuggestionFragment.newInstance(confirmCallback).show(((AppCompatActivity) context2).getSupportFragmentManager(), "AlarmSignalUsecaseSuggestionFragment");
    }

    public static void showLowBatteryDialog(Context context2, int i) {
        LowBatteryDialogFragment.newInstance(i).show(((AppCompatActivity) context2).getSupportFragmentManager(), "LowBatteryDialogFragment");
    }

    public static void showChangeDialog(Context context2, String str, ConfirmCallback confirmCallback) {
        ChangeDialogFragment.newInstance(str, confirmCallback).show(((AppCompatActivity) context2).getSupportFragmentManager(), "ChangeDialogFragment");
    }

    public static SignalTypeDialogFragment showSignalTypeDialog(Context context2, String str, SignalData signalData, SignalFragment.OnSignalListener onSignalListener) {
        FragmentManager supportFragmentManager = ((AppCompatActivity) context2).getSupportFragmentManager();
        if (!checkCanShowDialog(context2)) {
            return null;
        }
        SignalTypeDialogFragment signalTypeDialogFragmentNewInstance = SignalTypeDialogFragment.newInstance(str, signalData, onSignalListener);
        supportFragmentManager.beginTransaction().add(signalTypeDialogFragmentNewInstance, "SignalTypeDialogFragment").commitAllowingStateLoss();
        return signalTypeDialogFragmentNewInstance;
    }

    private static boolean checkCanShowDialog(Context context2) {
        return ((SignalTypeDialogFragment) ((AppCompatActivity) context2).getSupportFragmentManager().findFragmentByTag("SignalTypeDialogFragment")) == null;
    }

    public static void showWarningForRegisterDialog(Context context2) {
        FragmentManager supportFragmentManager = ((AppCompatActivity) context2).getSupportFragmentManager();
        if (checkCanShowDialog(context2)) {
            WarningForRegisterDialogFragment.newInstance().show(supportFragmentManager, "WarningForRegisterDialogFragment");
        }
    }

    public static void showWarningForInitializeDialog(Context context2, ConfirmCallback confirmCallback) {
        FragmentManager supportFragmentManager = ((AppCompatActivity) context2).getSupportFragmentManager();
        if (checkCanShowDialog(context2)) {
            WarningForInitializeDialogFragment.newInstance(confirmCallback).show(supportFragmentManager, "WarningForInitializeDialogFragment");
        }
    }

    public static void showWarningForProducInitializeDialog(Context context2, ConfirmCallback confirmCallback) {
        FragmentManager supportFragmentManager = ((AppCompatActivity) context2).getSupportFragmentManager();
        if (checkCanShowDialog(context2)) {
            WarningForCheckerInitializeDialogFragment.newInstance(confirmCallback).show(supportFragmentManager, "WarningForCheckerInitializeDialogFragment");
        }
    }

    public static void showPayDetailConfirmDialog(Context context2, String str, String str2, String str3, String str4, ConfirmCallback confirmCallback) {
        PayDetailConfirmFragment.newInstance(str, str2, str3, str4, confirmCallback).show(((AppCompatActivity) context2).getSupportFragmentManager(), "ChangeDialogFragment");
    }
}
