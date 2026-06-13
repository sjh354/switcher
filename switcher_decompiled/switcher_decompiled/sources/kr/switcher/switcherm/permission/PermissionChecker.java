package kr.switcher.switcherm.permission;

import android.app.Activity;
import android.content.Context;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

/* JADX INFO: loaded from: classes2.dex */
public class PermissionChecker {
    public static final int MY_PERMISSIONS_REQUEST_ACCESS_COARSE_LOCATION = 2;
    public static final int MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION = 1;
    public static final int MY_PERMISSIONS_REQUEST_BLUETOOTH = 4;
    public static final int MY_PERMISSIONS_REQUEST_BLUETOOTH_ADVERTISE = 6;
    public static final int MY_PERMISSIONS_REQUEST_BLUETOOTH_CONNECT = 7;
    public static final int MY_PERMISSIONS_REQUEST_BLUETOOTH_SCAN = 5;
    public static final int MY_PERMISSIONS_REQUEST_IGNORING_BATTERY_OPTIMIZATION = 3;
    public static final int MY_PERMISSIONS_REQUEST_RECEIVE_SMS = 0;

    public static boolean checkSMSPermission(Context context) {
        return ContextCompat.checkSelfPermission(context, "android.permission.RECEIVE_SMS") == 0;
    }

    public static void requestSMSPermission(Activity activity) {
        if (ActivityCompat.shouldShowRequestPermissionRationale(activity, "android.permission.RECEIVE_SMS")) {
            ActivityCompat.requestPermissions(activity, new String[]{"android.permission.RECEIVE_SMS"}, 0);
        } else {
            ActivityCompat.requestPermissions(activity, new String[]{"android.permission.RECEIVE_SMS"}, 0);
        }
    }

    public static boolean checkFineLocationPermission(Context context) {
        return ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") == 0;
    }

    public static boolean checkBluetoothConnectPermission(Context context) {
        return ContextCompat.checkSelfPermission(context, "android.permission.BLUETOOTH_CONNECT") == 0;
    }

    public static boolean checkBluetoothScanPermission(Context context) {
        return ContextCompat.checkSelfPermission(context, "android.permission.BLUETOOTH_SCAN") == 0;
    }

    public static void requestFineLocationPermission(Activity activity) {
        if (ActivityCompat.shouldShowRequestPermissionRationale(activity, "android.permission.ACCESS_FINE_LOCATION")) {
            ActivityCompat.requestPermissions(activity, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 1);
        } else {
            ActivityCompat.requestPermissions(activity, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 1);
        }
    }

    public static void requestBluetoothConnectPermission(Activity activity) {
        if (ActivityCompat.shouldShowRequestPermissionRationale(activity, "android.permission.BLUETOOTH_CONNECT")) {
            ActivityCompat.requestPermissions(activity, new String[]{"android.permission.BLUETOOTH_CONNECT", "android.permission.BLUETOOTH_SCAN", "android.permission.BLUETOOTH_ADVERTISE"}, 7);
        } else {
            ActivityCompat.requestPermissions(activity, new String[]{"android.permission.BLUETOOTH_CONNECT", "android.permission.BLUETOOTH_SCAN", "android.permission.BLUETOOTH_ADVERTISE"}, 7);
        }
    }

    public static boolean checkIgonoringBatteryOptimization(Context context) {
        return ContextCompat.checkSelfPermission(context, "android.permission.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS") == 0;
    }

    public static void requestIgnoringBatteryOptimization(Activity activity) {
        if (ActivityCompat.shouldShowRequestPermissionRationale(activity, "android.permission.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS")) {
            ActivityCompat.requestPermissions(activity, new String[]{"android.permission.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS"}, 3);
        } else {
            ActivityCompat.requestPermissions(activity, new String[]{"android.permission.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS"}, 3);
        }
    }

    public static boolean checkCoarseLocationPermission(Context context) {
        return ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_COARSE_LOCATION") == 0;
    }

    public static void requestCoarseLocationPermission(Activity activity) {
        if (ActivityCompat.shouldShowRequestPermissionRationale(activity, "android.permission.ACCESS_COARSE_LOCATION")) {
            ActivityCompat.requestPermissions(activity, new String[]{"android.permission.ACCESS_COARSE_LOCATION"}, 2);
        } else {
            ActivityCompat.requestPermissions(activity, new String[]{"android.permission.ACCESS_COARSE_LOCATION"}, 2);
        }
    }
}
