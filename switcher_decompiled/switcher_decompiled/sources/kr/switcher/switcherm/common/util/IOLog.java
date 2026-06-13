package kr.switcher.switcherm.common.util;

import kr.switcher.switcherm.common.ga.GALogger;
import kr.switcher.switcherm.domain.entity.UserDeviceInfo;
import kr.switcher.switcherm.network.http.RestResponseHandler;
import kr.switcher.switcherm.network.http.RestSwitcherAPIStore;
import kr.switcher.switcherm.preference.LoginUser;
import kr.switcher.switcherm.preference.SpeedMeasurement;

/* JADX INFO: loaded from: classes2.dex */
public class IOLog {
    public static final String DEVICE_LOG_TYPE_CONNECT = "CONNECT";
    public static final String DEVICE_LOG_TYPE_SCAN = "SCAN";
    private static final String TAG = "switcher";
    private static final String ga = "ga_event";

    public static void activity(String str) {
    }

    public static void logUser(String str, String str2, String str3, String str4, String str5) {
    }

    public static void event(String str) {
        GALogger.recordEvent(str);
    }

    public static void event(String str, long j) {
        GALogger.recordEvent(str, j);
    }

    public static void event(String str, String str2) {
        i(ga, "category:" + str + ", action:" + str2);
        GALogger.recordEvent(str, str2);
    }

    public static void event(String str, String str2, String str3) {
        i(ga, "category:" + str + ", action:" + str2 + ", label:" + str3);
        GALogger.recordEvent(str, str2, str3);
    }

    public static void d(String str, String str2) {
        String str3 = "switcher-" + str;
    }

    public static void i(String str, String str2) {
        String str3 = "switcher-" + str;
    }

    public static void i(String str, String str2, String str3) {
        i(str, "msg:" + str2 + ", event:" + str3);
        event(str3);
    }

    public static void i(String str, String str2, String str3, long j) {
        i(str, "msg:" + str2 + ", event:" + str3 + ", value:" + j);
        event(str3, j);
    }

    public static void e(String str, String str2, Exception exc) {
        String str3 = "switcher-" + str;
    }

    public static void error(String str, String str2, Exception exc) {
        if (str2 == null) {
            str2 = "";
        }
        e(str, "[" + IOUtil.getCurrentDateTime() + "] | [token: " + str2 + "] | [" + exc.getStackTrace()[0].getMethodName() + "()] | ", exc);
    }

    public static void error(String str, String str2, String str3, Exception exc) {
        if (str2 == null) {
            str2 = "";
        }
        e(str, "[" + IOUtil.getCurrentDateTime() + "] | [token: " + str2 + "] | [" + str3 + "()] | ", exc);
    }

    public static void reportConnectingTime(String str) {
        SpeedMeasurement speedMeasurement = new SpeedMeasurement();
        long scanningTimeMilliSecond = speedMeasurement.getScanningTimeMilliSecond(str);
        long connectionTimeMilliSecond = speedMeasurement.getConnectionTimeMilliSecond(str);
        long reconnectionTimeMilliSecond = speedMeasurement.getReconnectionTimeMilliSecond(str);
        long readingDataTimeMilliSecond = speedMeasurement.getReadingDataTimeMilliSecond(str);
        event(GALogger.TOTAL_CONNECTING_TIME, scanningTimeMilliSecond + connectionTimeMilliSecond + readingDataTimeMilliSecond);
        event(GALogger.SCANNING_TIME, scanningTimeMilliSecond);
        if (connectionTimeMilliSecond != -1) {
            event(GALogger.CONNECTING_TIME, connectionTimeMilliSecond);
        }
        if (reconnectionTimeMilliSecond != -1) {
            event(GALogger.RECONNECTING_TIME, reconnectionTimeMilliSecond);
        }
        event(GALogger.READING_DATA_TIME, readingDataTimeMilliSecond);
    }

    public static void deviceLog(String str, String str2, String str3) {
        i("deviceLog", "mac address : " + str + ", type : " + str2 + ", error code : " + str3);
        RestSwitcherAPIStore.requestPostDeviceLog(str, new LoginUser().getPhoneNumber(), new UserDeviceInfo().getDeviceInfo(), str2, str3, new RestResponseHandler() { // from class: kr.switcher.switcherm.common.util.IOLog.1
            @Override // kr.switcher.switcherm.network.http.RestResponseHandler
            public void onSuccess(String str4) {
                IOLog.i(IOLog.TAG, str4);
            }

            @Override // kr.switcher.switcherm.network.http.RestResponseHandler
            public void onFailure(String str4, String str5) {
                IOLog.i(IOLog.TAG, str5);
            }
        });
    }
}
