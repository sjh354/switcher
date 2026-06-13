package kr.switcher.switcherm.ui.main.helper;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import java.io.Serializable;
import kr.switcher.device.IODevice;
import kr.switcher.device.common.ScannedBLEDevice;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.activity.ActivityController;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.signal.IOSignal;
import kr.switcher.switcherm.ui.main.MainActivity;
import kr.switcher.switcherm.ui.main.fragment.AirconRemoconConnectedFragment;
import kr.switcher.switcherm.ui.main.fragment.MainBLEPermissionReqFragment;
import kr.switcher.switcherm.ui.main.fragment.MainConnectedCheckerFragment;
import kr.switcher.switcherm.ui.main.fragment.MainConnectedFragment;
import kr.switcher.switcherm.ui.main.fragment.MainConnectedRemoconFragment;
import kr.switcher.switcherm.ui.main.fragment.MainConnectingFragment;
import kr.switcher.switcherm.ui.main.fragment.MainDefaultFragment;
import kr.switcher.switcherm.ui.main.fragment.MainDisconnectedFragment;
import kr.switcher.switcherm.ui.main.fragment.MainPaymentFailFragment;
import kr.switcher.switcherm.ui.main.fragment.MainShareCodeFragment;
import kr.switcher.switcherm.ui.main.fragment.SettopRemoconConnectedFragment;

/* JADX INFO: loaded from: classes2.dex */
public class MainScreenController {
    public static final String INTENT_PARM_CONNECTED_MAC_ADDRESS = "CONNECTED_MAC_ADDRESS";
    public static final String INTENT_PARM_DISCONNECTED_MAC_ADDRESS = "DISCONNECTED_MAC_ADDRESS";
    public static final String INTENT_PARM_ERROR_STATUS = "ERROR_STATUS";
    public static final String INTENT_PARM_MAC_ADDRESS_TO_CONNECT = "MAC_ADDRESS_TO_CONNECT";
    public static final String INTENT_PARM_MAC_ADDRESS_TO_PAY = "MAC_ADDRESS_TO_PAY";
    public static final String INTENT_PARM_MAC_ADDRESS_TO_SHARE = "MAC_ADDRESS_TO_SHARE";
    public static final String INTENT_PARM_SCANNED_DEVICE_TO_CONNECT = "SCANNED_DEVICE_TO_CONNECT";
    public static final String INTENT_PARM_SCANNED_SWITCHERS = "SCANNED_SWITCHERS";
    private static final String TAG = "MainScreenController";
    private static AppCompatActivity activity;
    private static OnMainDataResultCallback callback;

    public enum MainScreen implements Serializable {
        DEFAULT,
        CONNECTING,
        CONNECTED,
        DISCONNECTED,
        SHARE_CODE,
        PAYMENT_FAIL,
        PERMISSION,
        REGISTER,
        CONNECTED_REMOCON,
        CONNECTED_CHECKER,
        CONNECTED_REMOCON_AIRCON,
        CONNECTED_REMOCON_SETTOP
    }

    public interface OnMainDataResultCallback {
        void onMainData(String str, IODevice.ProductId productId, String str2, String str3, MainActivity.MainBackgroundState mainBackgroundState);
    }

    public static void initialize(AppCompatActivity appCompatActivity, OnMainDataResultCallback onMainDataResultCallback) {
        activity = appCompatActivity;
        callback = onMainDataResultCallback;
    }

    public static void moveMainScreen(MainScreen mainScreen, Intent intent) {
        if (isAliveActivity()) {
            ScannedBLEDevice scannedBLEDevice = (ScannedBLEDevice) intent.getParcelableExtra(INTENT_PARM_SCANNED_DEVICE_TO_CONNECT);
            String stringExtra = intent.getStringExtra(INTENT_PARM_MAC_ADDRESS_TO_CONNECT);
            String stringExtra2 = intent.getStringExtra("CONNECTED_MAC_ADDRESS");
            String stringExtra3 = intent.getStringExtra(INTENT_PARM_DISCONNECTED_MAC_ADDRESS);
            int intExtra = intent.getIntExtra(INTENT_PARM_ERROR_STATUS, 0);
            String stringExtra4 = intent.getStringExtra(INTENT_PARM_MAC_ADDRESS_TO_PAY);
            IOLog.i(TAG, "move screen : " + mainScreen);
            switch (AnonymousClass1.$SwitchMap$kr$switcher$switcherm$ui$main$helper$MainScreenController$MainScreen[mainScreen.ordinal()]) {
                case 1:
                    moveScreen(MainDefaultFragment.newInstance(callback), "MainDefaultFragment");
                    break;
                case 2:
                    if (stringExtra.equalsIgnoreCase(stringExtra2)) {
                        moveMainScreen(MainScreen.CONNECTED, intent);
                    } else {
                        moveScreen(MainConnectingFragment.newInstance(scannedBLEDevice, stringExtra, callback), "MainDefaultFragment");
                    }
                    break;
                case 3:
                    MainConnectedFragment mainConnectedFragmentNewInstance = MainConnectedFragment.newInstance(stringExtra2, callback);
                    IOSignal.registerSignalFragment(mainConnectedFragmentNewInstance);
                    moveScreen(mainConnectedFragmentNewInstance, "MainConnectedFragment");
                    break;
                case 4:
                    moveScreen(MainDisconnectedFragment.newInstance(stringExtra3, intExtra, callback), "MainDisconnectedFragment");
                    break;
                case 5:
                    moveScreen(MainShareCodeFragment.newInstance(scannedBLEDevice, callback), "MainShareCodeFragment");
                    break;
                case 6:
                    moveScreen(MainPaymentFailFragment.newInstance(stringExtra4, callback), "MainPaymentFailFragment");
                    break;
                case 7:
                    moveScreen(MainBLEPermissionReqFragment.newInstance(callback), "MainBLEPermissionReqFragment");
                    break;
                case 8:
                    moveScreen(MainDefaultFragment.newInstance(callback), "MainDefaultFragment");
                    ActivityController.moveRegisterActivity(activity, stringExtra2);
                    break;
                case 9:
                    moveScreen(MainConnectedRemoconFragment.newInstance(stringExtra2, callback), "MainConnectedRemoconFragment");
                    break;
                case 10:
                    moveScreen(MainConnectedCheckerFragment.newInstance(stringExtra2, callback), "MainConnectedCheckerFragment");
                    break;
                case 11:
                    moveScreen(AirconRemoconConnectedFragment.newInstance(stringExtra2, callback), "AirconRemoconConnectedFragment");
                    break;
                case 12:
                    moveScreen(SettopRemoconConnectedFragment.newInstance(stringExtra2, callback), "SettopRemoconConnectedFragment");
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: kr.switcher.switcherm.ui.main.helper.MainScreenController$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$kr$switcher$switcherm$ui$main$helper$MainScreenController$MainScreen;

        static {
            int[] iArr = new int[MainScreen.values().length];
            $SwitchMap$kr$switcher$switcherm$ui$main$helper$MainScreenController$MainScreen = iArr;
            try {
                iArr[MainScreen.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$kr$switcher$switcherm$ui$main$helper$MainScreenController$MainScreen[MainScreen.CONNECTING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$kr$switcher$switcherm$ui$main$helper$MainScreenController$MainScreen[MainScreen.CONNECTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$kr$switcher$switcherm$ui$main$helper$MainScreenController$MainScreen[MainScreen.DISCONNECTED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$kr$switcher$switcherm$ui$main$helper$MainScreenController$MainScreen[MainScreen.SHARE_CODE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$kr$switcher$switcherm$ui$main$helper$MainScreenController$MainScreen[MainScreen.PAYMENT_FAIL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$kr$switcher$switcherm$ui$main$helper$MainScreenController$MainScreen[MainScreen.PERMISSION.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$kr$switcher$switcherm$ui$main$helper$MainScreenController$MainScreen[MainScreen.REGISTER.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$kr$switcher$switcherm$ui$main$helper$MainScreenController$MainScreen[MainScreen.CONNECTED_REMOCON.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$kr$switcher$switcherm$ui$main$helper$MainScreenController$MainScreen[MainScreen.CONNECTED_CHECKER.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$kr$switcher$switcherm$ui$main$helper$MainScreenController$MainScreen[MainScreen.CONNECTED_REMOCON_AIRCON.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$kr$switcher$switcherm$ui$main$helper$MainScreenController$MainScreen[MainScreen.CONNECTED_REMOCON_SETTOP.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    private static void moveScreen(Fragment fragment, String str) {
        FragmentTransaction fragmentTransactionBeginTransaction = activity.getSupportFragmentManager().beginTransaction();
        fragmentTransactionBeginTransaction.replace(R.id.container, fragment, str);
        try {
            fragmentTransactionBeginTransaction.commitAllowingStateLoss();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }

    private static boolean isAliveActivity() {
        AppCompatActivity appCompatActivity = activity;
        return (appCompatActivity == null || appCompatActivity.getSupportFragmentManager() == null) ? false : true;
    }
}
