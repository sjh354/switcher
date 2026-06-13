package kr.switcher.switcherm.common.util;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.bluetooth.BluetoothGattCharacteristic;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.StatFs;
import android.text.Html;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import antistatic.spinnerwheel.AbstractWheel;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.wang.avi.AVLoadingIndicatorView;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import kotlin.UByte;
import kr.switcher.device.IODevice;
import kr.switcher.device.IODeviceConfig;
import kr.switcher.device.common.DeviceUtil;
import kr.switcher.device.switcher.Switcher;
import kr.switcher.device.switcher.linker.http.microservice.MobileLinkerMicroService;
import kr.switcher.ioble.scanner.BLEScanner;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.ga.GALogger;
import kr.switcher.switcherm.database.DBIODeviceDAO;
import kr.switcher.switcherm.database.DBPricingModelDAO;
import kr.switcher.switcherm.database.DBProductionServiceDAO;
import kr.switcher.switcherm.database.DBReservationDAO;
import kr.switcher.switcherm.database.DBSubscriptionServiceDAO;
import kr.switcher.switcherm.database.DBUserDAO;
import kr.switcher.switcherm.device.IODeviceHandler;
import kr.switcher.switcherm.device.switcher.handler.SwitcherHandler;
import kr.switcher.switcherm.network.http.microservice.MobileMicroService;
import kr.switcher.switcherm.preference.OAuthToken;
import kr.switcher.switcherm.preference.PreferenceHelper;
import kr.switcher.switcherm.signal.BatterySignal;
import kr.switcher.switcherm.signal.ReservationSignal;
import kr.switcher.switcherm.ui.dialog.IODialogController;
import kr.switcher.switcherm.ui.splash.SplashActivity;
import kr.switcher.switcherm.ui.widget.AirconWidget;
import kr.switcher.switcherm.ui.widget.CheckerWidget;
import kr.switcher.switcherm.ui.widget.OneButtonWidget;
import kr.switcher.switcherm.ui.widget.SettopWidget;
import kr.switcher.switcherm.ui.widget.TwoButtonWidget;
import kr.switcher.switcherm.user.User;
import kr.switcher.switcherm.user.UserStateManager;

/* JADX INFO: loaded from: classes2.dex */
public class IOUtil {
    private static final String DEV_PHONE_NUMBER = "01093206114";
    private static final String DEV_TOKEN = "zWJ9cuO9dHn25k7DNIJCpZB7ZUa2ZIDzvmbV75toymA=";
    private static final String DEV_USER_NAME = "이재훈";
    private static final long MEGABYTE = 1048576;
    private static final String TAG = "IOUtil";
    private static Context context;
    private static final char[] hexArray = "0123456789ABCDEF".toCharArray();
    private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();

    public static int getDayOfWeekNumberForSwitcher(int i) {
        if (i - 2 >= 0) {
            return i - 2;
        }
        return 6;
    }

    public static void setContext(Context context2) {
        context = context2;
    }

    public static Context getContext() {
        return context;
    }

    public static void initialize(Context context2) {
        setContext(context2);
        GALogger.setContext(context2);
        DeviceUtil.initialize(context2);
        PreferenceHelper.setContext(context2);
        ReservationSignal.initialize();
        BatterySignal.initialize();
        IODialogController.setContext(context2);
        DBUserDAO.setContext(context2);
        DBIODeviceDAO.setContext(context2);
        DBSubscriptionServiceDAO.setContext(context2);
        DBProductionServiceDAO.setContext(context2);
        DBReservationDAO.setContext(context2);
        DBPricingModelDAO.setContext(context2);
        BLEScanner.getScanner(context2);
        MobileMicroService.setIsDev(false);
        MobileLinkerMicroService.setIsDev(false);
        if (UserStateManager.getInstance() == null) {
            new UserStateManager.Builder().setContext(context2).build();
        }
        if (IODeviceHandler.getInstance() == null) {
            new IODeviceHandler.Builder().build();
        }
        UserStateManager.getInstance().setAuthToken(new OAuthToken().getOAuthToken());
    }

    public static void showToast(final String str) {
        if (context == null) {
            return;
        }
        IOLog.i(NotificationCompat.CATEGORY_MESSAGE, str);
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: kr.switcher.switcherm.common.util.IOUtil.1
            @Override // java.lang.Runnable
            public void run() {
                Toast.makeText(IOUtil.context, str, 0).show();
            }
        });
    }

    public static void showToastLong(final String str) {
        if (context == null) {
            return;
        }
        IOLog.i(NotificationCompat.CATEGORY_MESSAGE, str);
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: kr.switcher.switcherm.common.util.IOUtil.2
            @Override // java.lang.Runnable
            public void run() {
                Toast.makeText(IOUtil.context, str, 1).show();
            }
        });
    }

    public static void showToast(int i) {
        showToast(getStringResource(i));
    }

    public static void sleep(int i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static boolean checkIsIODeviceKey(String str) {
        if (str == null) {
            return false;
        }
        if (str.contains(IODevice.ProductId.REMOCON + "")) {
            return true;
        }
        if (str.length() != 17) {
            return false;
        }
        for (int i = 0; i < 17; i++) {
            char cCharAt = str.charAt(i);
            int i2 = i % 3;
            if (i2 == 0 || i2 == 1) {
                if ((cCharAt < '0' || cCharAt > '9') && (cCharAt < 'A' || cCharAt > 'F')) {
                    return false;
                }
            } else if (i2 == 2 && cCharAt != ':') {
                return false;
            }
        }
        return true;
    }

    public static String hexToHexString(String str) {
        String str2 = "";
        int i = 0;
        for (int i2 = 0; i2 < str.length(); i2++) {
            i++;
            str2 = str2 + String.format("%02x", Integer.valueOf(Integer.parseInt(str.substring(i2, i))));
        }
        return str2;
    }

    public static byte[] hexStringToByteArray(String str) {
        int length = str.length();
        byte[] bArr = new byte[length / 2];
        for (int i = 0; i < length; i += 2) {
            bArr[i / 2] = (byte) ((Character.digit(str.charAt(i), 16) << 4) + Character.digit(str.charAt(i + 1), 16));
        }
        return bArr;
    }

    public static String hexToBinary(String str) {
        return String.format("%08d", Integer.valueOf(Integer.parseInt(new BigInteger(str, 16).toString(2))));
    }

    public static int byteToint(byte[] bArr) {
        return (bArr[3] & UByte.MAX_VALUE) | ((bArr[0] & UByte.MAX_VALUE) << 24) | ((bArr[1] & UByte.MAX_VALUE) << 16) | ((bArr[2] & UByte.MAX_VALUE) << 8);
    }

    public static String bytesToHex(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & UByte.MAX_VALUE;
            int i3 = i * 2;
            char[] cArr2 = hexArray;
            cArr[i3] = cArr2[i2 >>> 4];
            cArr[i3 + 1] = cArr2[i2 & 15];
        }
        return new String(cArr);
    }

    public static String getStringResource(int i) {
        Context context2 = context;
        return context2 == null ? "" : context2.getString(i);
    }

    public static int getColorResource(int i) {
        Context context2 = context;
        if (context2 == null) {
            return 0;
        }
        return ContextCompat.getColor(context2, i);
    }

    public static String parse(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        char[] cArr = new char[(bArr.length * 3) - 1];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & UByte.MAX_VALUE;
            int i3 = i * 3;
            char[] cArr2 = HEX_ARRAY;
            cArr[i3] = cArr2[i2 >>> 4];
            cArr[i3 + 1] = cArr2[i2 & 15];
            if (i != bArr.length - 1) {
                cArr[i3 + 2] = '-';
            }
        }
        return "(0x) " + new String(cArr);
    }

    public static String parse(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        return parse(bluetoothGattCharacteristic.getValue());
    }

    public static String convertNumberAddZero(int i) {
        return (i < 10 ? "" + Switcher.SwitcherReservation.SWITCH_1WAY_FIRMWARE : "") + String.valueOf(i);
    }

    public static AlertDialog createConfirmDialog(String str, String str2, DialogInterface.OnClickListener onClickListener) {
        if (context == null) {
            return null;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(str);
        builder.setMessage(str2);
        builder.setCancelable(false);
        builder.setPositiveButton(getStringResource(R.string.confirm), onClickListener);
        return builder.create();
    }

    public static boolean isDigit(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static void hideKeyBoard(EditText editText) {
        try {
            ((InputMethodManager) context.getSystemService("input_method")).hideSoftInputFromWindow(editText.getWindowToken(), 0);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    public static void showKeyBoard() {
        try {
            ((InputMethodManager) context.getSystemService("input_method")).toggleSoftInput(2, 1);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    public static void showKeyBoard(EditText editText) {
        editText.requestFocus();
        try {
            ((InputMethodManager) context.getSystemService("input_method")).toggleSoftInput(2, 1);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    public static void setListViewSize(RecyclerView recyclerView, int i, int i2) {
        int dimensionPixelSize = (context.getResources().getDimensionPixelSize(i) + 1) * i2;
        ViewGroup.LayoutParams layoutParams = recyclerView.getLayoutParams();
        layoutParams.height = dimensionPixelSize;
        recyclerView.setLayoutParams(layoutParams);
    }

    public static String getDayOfWeekString(int i) {
        switch (i) {
            case 1:
                return getStringResource(R.string.sun_day);
            case 2:
                return getStringResource(R.string.mon_day);
            case 3:
                return getStringResource(R.string.tue_day);
            case 4:
                return getStringResource(R.string.wed_day);
            case 5:
                return getStringResource(R.string.thu_day);
            case 6:
                return getStringResource(R.string.fri_day);
            case 7:
                return getStringResource(R.string.sat_day);
            default:
                return "";
        }
    }

    public static String getCurrentAmPm() {
        return Calendar.getInstance().get(9) == 0 ? IODeviceConfig.AM : "pm";
    }

    public static String getMainSwitcherAddress() {
        User currentUserFromDB = UserStateManager.getInstance().getCurrentUserFromDB();
        return currentUserFromDB == null ? "" : currentUserFromDB.getMainSwitcherCode();
    }

    public static int getMinDifferenceCurrentTimeAnd(int i, int i2, int i3) {
        return Math.abs(((getDayOfWeekNumberForSwitcher(Calendar.getInstance().get(7)) + Calendar.getInstance().get(11)) + Calendar.getInstance().get(12)) - ((i + i2) + i3));
    }

    public static Drawable makeDrawable(int i) {
        if (context == null) {
            return null;
        }
        return getDrawable(i);
    }

    public static Drawable getDrawable(int i) {
        if (Build.VERSION.SDK_INT >= 21) {
            return context.getDrawable(i);
        }
        if (context.getResources() != null) {
            return context.getResources().getDrawable(i);
        }
        return null;
    }

    public static String getCurrentDateTime() {
        return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
    }

    public static String getCurrentDateTimehhmm() {
        return new SimpleDateFormat("hhmm").format(new Date());
    }

    public static String getCurrentDayOfWeek() {
        return new SimpleDateFormat("EE").format(new Date());
    }

    public static void sendBroadcastToOneButtonWidget() {
        Intent intent = new Intent(context, (Class<?>) OneButtonWidget.class);
        intent.setAction("android.appwidget.action.APPWIDGET_UPDATE");
        intent.putExtra("appWidgetIds", AppWidgetManager.getInstance(context).getAppWidgetIds(new ComponentName(context, (Class<?>) OneButtonWidget.class)));
        context.sendBroadcast(intent);
    }

    public static void sendBroadcastToTwoButtonWidget() {
        Intent intent = new Intent(context, (Class<?>) TwoButtonWidget.class);
        intent.setAction("android.appwidget.action.APPWIDGET_UPDATE");
        intent.putExtra("appWidgetIds", AppWidgetManager.getInstance(context).getAppWidgetIds(new ComponentName(context, (Class<?>) TwoButtonWidget.class)));
        context.sendBroadcast(intent);
    }

    public static void sendBroadcastToAirconWidget() {
        Intent intent = new Intent(context, (Class<?>) AirconWidget.class);
        intent.setAction("android.appwidget.action.APPWIDGET_UPDATE");
        intent.putExtra("appWidgetIds", AppWidgetManager.getInstance(context).getAppWidgetIds(new ComponentName(context, (Class<?>) AirconWidget.class)));
        context.sendBroadcast(intent);
    }

    public static void sendBroadcastToCheckerWidget() {
        Intent intent = new Intent(context, (Class<?>) CheckerWidget.class);
        intent.setAction("android.appwidget.action.APPWIDGET_UPDATE");
        intent.putExtra("appWidgetIds", AppWidgetManager.getInstance(context).getAppWidgetIds(new ComponentName(context, (Class<?>) CheckerWidget.class)));
        context.sendBroadcast(intent);
    }

    public static void sendBroadcastToSettopWidget() {
        Intent intent = new Intent(context, (Class<?>) SettopWidget.class);
        intent.setAction("android.appwidget.action.APPWIDGET_UPDATE");
        intent.putExtra("appWidgetIds", AppWidgetManager.getInstance(context).getAppWidgetIds(new ComponentName(context, (Class<?>) SettopWidget.class)));
        context.sendBroadcast(intent);
    }

    public static List<String> getMonths() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(1 + getStringResource(R.string.mon));
        arrayList.add(2 + getStringResource(R.string.mon));
        arrayList.add(3 + getStringResource(R.string.mon));
        arrayList.add(4 + getStringResource(R.string.mon));
        arrayList.add(5 + getStringResource(R.string.mon));
        arrayList.add(6 + getStringResource(R.string.mon));
        arrayList.add(7 + getStringResource(R.string.mon));
        arrayList.add(8 + getStringResource(R.string.mon));
        arrayList.add(9 + getStringResource(R.string.mon));
        arrayList.add(10 + getStringResource(R.string.mon));
        arrayList.add(11 + getStringResource(R.string.mon));
        arrayList.add(12 + getStringResource(R.string.mon));
        return arrayList;
    }

    public static List<String> getValidityYears() {
        ArrayList arrayList = new ArrayList();
        int i = Calendar.getInstance().get(1);
        arrayList.add(i + getStringResource(R.string.year));
        arrayList.add((i + 1) + getStringResource(R.string.year));
        arrayList.add((i + 2) + getStringResource(R.string.year));
        arrayList.add((i + 3) + getStringResource(R.string.year));
        arrayList.add((i + 4) + getStringResource(R.string.year));
        arrayList.add((i + 5) + getStringResource(R.string.year));
        arrayList.add((i + 6) + getStringResource(R.string.year));
        arrayList.add((i + 7) + getStringResource(R.string.year));
        arrayList.add((i + 8) + getStringResource(R.string.year));
        arrayList.add((i + 9) + getStringResource(R.string.year));
        arrayList.add((i + 10) + getStringResource(R.string.year));
        arrayList.add((i + 11) + getStringResource(R.string.year));
        arrayList.add((i + 12) + getStringResource(R.string.year));
        arrayList.add((i + 13) + getStringResource(R.string.year));
        arrayList.add((i + 14) + getStringResource(R.string.year));
        return arrayList;
    }

    public static Object getItemInList(List<? extends Object> list, int i) {
        if (i < 0 || i >= list.size()) {
            return null;
        }
        return list.get(i);
    }

    public static float getDp(int i) {
        return TypedValue.applyDimension(1, i, context.getResources().getDisplayMetrics());
    }

    public static boolean isConnectedInternet() {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        return (connectivityManager == null || connectivityManager.getActiveNetworkInfo() == null) ? false : true;
    }

    public static void appendTextView(LinearLayout linearLayout, String str, int i, int i2) {
        TextView textView = new TextView(context);
        textView.setText(str);
        textView.setTextColor(i);
        textView.setTextSize(i2);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        textView.setLayoutParams(layoutParams);
        textView.setGravity(17);
        linearLayout.addView(textView);
    }

    public static ArrayList<?> addAllSeveralList(List<?>... listArr) {
        ArrayList<?> arrayList = new ArrayList<>();
        for (List<?> list : listArr) {
            arrayList.addAll(arrayList.size(), list);
        }
        return arrayList;
    }

    public static boolean checkIsNullParameter(String... strArr) {
        for (String str : strArr) {
            if (str == null) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkIsNullAndEmptyParameter(String... strArr) {
        for (String str : strArr) {
            if (str == null || str.equals("")) {
                return true;
            }
        }
        return false;
    }

    public static void timeoutProgressbar(final Activity activity, final ProgressBar progressBar, int i) {
        new Handler().postDelayed(new Runnable() { // from class: kr.switcher.switcherm.common.util.IOUtil.3
            @Override // java.lang.Runnable
            public void run() {
                IOUtil.hideProgressbarDialog(activity, progressBar);
            }
        }, i);
    }

    public static void timeoutProgressbar(final Activity activity, final AVLoadingIndicatorView aVLoadingIndicatorView, int i) {
        new Handler().postDelayed(new Runnable() { // from class: kr.switcher.switcherm.common.util.IOUtil.4
            @Override // java.lang.Runnable
            public void run() {
                IOUtil.hideProgressbarDialog(activity, aVLoadingIndicatorView);
            }
        }, i);
    }

    public static Drawable getSwitcherImage(int i) {
        if (1 == i) {
            return makeDrawable(R.drawable.ic_switcher_one);
        }
        if (2 == i) {
            return makeDrawable(R.drawable.ic_switcher_two);
        }
        return null;
    }

    public static Drawable getSwitcherImage(IODevice.ProductId productId) {
        if (IODevice.ProductId.SWITCHER_TYPE_ONE == productId) {
            return makeDrawable(R.drawable.ic_switcher_one);
        }
        if (IODevice.ProductId.SWITCHER_TYPE_TWO == productId) {
            return makeDrawable(R.drawable.ic_switcher_two);
        }
        if (IODevice.ProductId.LINKER == productId) {
            return makeDrawable(R.drawable.ic_linker);
        }
        return null;
    }

    public static Drawable getMainSwitcherImage(IODevice.ProductId productId) {
        if (IODevice.ProductId.SWITCHER_TYPE_ONE == productId) {
            return makeDrawable(R.drawable.ic_main_switcher_one);
        }
        if (IODevice.ProductId.SWITCHER_TYPE_TWO == productId) {
            return makeDrawable(R.drawable.ic_main_switcher_two);
        }
        if (IODevice.ProductId.REMOCON == productId) {
            return makeDrawable(R.drawable.ic_main_remocon);
        }
        return null;
    }

    public static void showProgressbarDialog(Activity activity, ProgressBar progressBar, int i) {
        progressBar.setVisibility(0);
        try {
            activity.getWindow().setFlags(16, 16);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        timeoutProgressbar(activity, progressBar, i);
    }

    public static void showProgressbarDialog(Activity activity, AVLoadingIndicatorView aVLoadingIndicatorView, int i) {
        aVLoadingIndicatorView.setVisibility(0);
        try {
            activity.getWindow().setFlags(16, 16);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        timeoutProgressbar(activity, aVLoadingIndicatorView, i);
    }

    public static void hideProgressbarDialog(final Activity activity, final ProgressBar progressBar) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: kr.switcher.switcherm.common.util.IOUtil.5
            @Override // java.lang.Runnable
            public void run() {
                progressBar.setVisibility(8);
                try {
                    activity.getWindow().clearFlags(16);
                } catch (NullPointerException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static void hideProgressbarDialog(final Activity activity, final AVLoadingIndicatorView aVLoadingIndicatorView) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: kr.switcher.switcherm.common.util.IOUtil.6
            @Override // java.lang.Runnable
            public void run() {
                aVLoadingIndicatorView.setVisibility(8);
                try {
                    activity.getWindow().clearFlags(16);
                } catch (NullPointerException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static boolean isRestartApp() {
        return getContext() == null || SwitcherHandler.getInstance() == null;
    }

    public static void restartApp(Activity activity) {
        ((AlarmManager) activity.getSystemService(NotificationCompat.CATEGORY_ALARM)).set(1, System.currentTimeMillis(), PendingIntent.getActivity(activity, 0, new Intent(activity, (Class<?>) SplashActivity.class), 67108864));
        System.exit(2);
    }

    public static float dpToPixels(int i) {
        return i * context.getResources().getDisplayMetrics().density;
    }

    public static String getAmPmForWheel(AbstractWheel abstractWheel) {
        return abstractWheel.getCurrentItem() == 0 ? IODeviceConfig.AM : "pm";
    }

    public static int getHourForWheel(AbstractWheel abstractWheel) {
        return abstractWheel.getCurrentItem();
    }

    public static int getMinForWheel(AbstractWheel abstractWheel) {
        return abstractWheel.getCurrentItem();
    }

    public static String convertDateFormat(String str) {
        if (str == null || str.length() < 1) {
            return "";
        }
        try {
            return new SimpleDateFormat("yyyy년 MM월 dd일").format(new SimpleDateFormat("yyyy-MM-dd").parse(str));
        } catch (ParseException e) {
            e.printStackTrace();
            return str;
        }
    }

    public static String convertTimeFormatForCheckerHistory(String str) {
        if (str == null || str.length() < 1) {
            return "";
        }
        try {
            return new SimpleDateFormat("a hh:mm").format(new SimpleDateFormat("HH:mm:ss").parse(str));
        } catch (ParseException e) {
            e.printStackTrace();
            return str;
        }
    }

    public static double getAvailableRamSizeMB() {
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(new ActivityManager.MemoryInfo());
        return r0.availMem / MEGABYTE;
    }

    public static double getTotalRamSizeMB() {
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(new ActivityManager.MemoryInfo());
        return r0.totalMem / MEGABYTE;
    }

    public static int getRamPercent() {
        return (int) Math.round((getAvailableRamSizeMB() / getTotalRamSizeMB()) * 100.0d);
    }

    public static double getAvailableInternalMemorySizeMB() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return (statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong()) / MEGABYTE;
    }

    public static double getTotalInternalMemorySizeMB() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return (statFs.getBlockCountLong() * statFs.getBlockSizeLong()) / MEGABYTE;
    }

    public static int getDiskPercent() {
        return (int) Math.round((getAvailableInternalMemorySizeMB() / getTotalInternalMemorySizeMB()) * 100.0d);
    }

    public static String getModel() {
        return Build.MODEL;
    }

    public static String getOSVersion() {
        return Build.VERSION.RELEASE;
    }

    public static void setBlinkEffect(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.blink));
    }

    public static void underlineTextView(TextView textView, String str) {
        textView.setText(Html.fromHtml("<u>" + str + "</u>"));
    }

    public static String makeLocalMacAddressFormat(String str) {
        return str == null ? "" : str.length() == 17 ? str : str.length() != 12 ? "" : String.format("%s%s:%s%s:%s%s:%s%s:%s%s:%s%s", Character.valueOf(str.charAt(0)), Character.valueOf(str.charAt(1)), Character.valueOf(str.charAt(2)), Character.valueOf(str.charAt(3)), Character.valueOf(str.charAt(4)), Character.valueOf(str.charAt(5)), Character.valueOf(str.charAt(6)), Character.valueOf(str.charAt(7)), Character.valueOf(str.charAt(8)), Character.valueOf(str.charAt(9)), Character.valueOf(str.charAt(10)), Character.valueOf(str.charAt(11)));
    }

    public static String makeBackendMacAddressFormat(String str) {
        return str.replace(":", "");
    }

    public static String convertPaymentTypeName(int i) {
        switch (i) {
            case 1:
                return getStringResource(R.string.payment_type_lease);
            case 2:
                return getStringResource(R.string.payment_type_wholesale);
            case 3:
                return getStringResource(R.string.payment_type_rental_plan1);
            case 4:
                return getStringResource(R.string.payment_type_rental_plan2);
            case 5:
                return getStringResource(R.string.payment_type_rental_plan3);
            case 6:
                return getStringResource(R.string.payment_type_rental_plan4);
            default:
                return "";
        }
    }

    public static boolean checkGPSIsEnabled() {
        return ((LocationManager) context.getSystemService(FirebaseAnalytics.Param.LOCATION)).isProviderEnabled("gps");
    }

    public static boolean checkWifiIsEnabled() {
        return ((WifiManager) context.getSystemService("wifi")).isWifiEnabled();
    }
}
