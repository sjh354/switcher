package kr.switcher.switcherm.preference;

/* JADX INFO: loaded from: classes2.dex */
public class SpeedMeasurement extends PreferenceHelper {
    public static final int ERROR_TIME = -1;
    private static final String FILE_NAME = "LOGIN_UESR";
    private String KEY_START_SCAN_TIME = "START_SCAN_TIME";
    private String KEY_END_SCAN_TIME = "END_SCAN_TIME";
    private String KEY_START_CONNECTION_TIME = "START_CONNECTION_TIME";
    private String KEY_START_RECONNECTION_TIME = "START_RECONNECTION_TIME";
    private String KEY_END_CONNECTION_TIME = "END_CONNECTION_TIME";
    private String KEY_START_READ_DATA_TIME = "START_READ_DATA_TIME";
    private String KEY_END_READ_DATA_TIME = "END_READ_DATA_TIME";

    @Override // kr.switcher.switcherm.preference.PreferenceHelper
    public String getFileName() {
        return FILE_NAME;
    }

    public void startScanning(String str) {
        endScanning(str, 0L);
        startScanning(str, System.currentTimeMillis());
    }

    private void startScanning(String str, long j) {
        setLong(this.KEY_START_SCAN_TIME + "." + str, j);
    }

    public void endScanning(String str) {
        if (getEndScanningTime(str) == 0) {
            endScanning(str, System.currentTimeMillis());
        }
    }

    private void endScanning(String str, long j) {
        setLong(this.KEY_END_SCAN_TIME + "." + str, j);
    }

    private long getStartScanningTime(String str) {
        return getLong(this.KEY_START_SCAN_TIME + "." + str, 0L);
    }

    private long getEndScanningTime(String str) {
        return getLong(this.KEY_END_SCAN_TIME + "." + str, 0L);
    }

    public long getScanningTimeMilliSecond(String str) {
        long endScanningTime = getEndScanningTime(str) - getStartScanningTime(str);
        if (endScanningTime < 0) {
            return -1L;
        }
        return endScanningTime;
    }

    public void startConnection(String str) {
        clearConnectionTime(str);
        setLong(this.KEY_START_CONNECTION_TIME + "." + str, System.currentTimeMillis());
    }

    public void startReconnection(String str) {
        clearConnectionTime(str);
        setLong(this.KEY_START_RECONNECTION_TIME + "." + str, System.currentTimeMillis());
    }

    private void clearConnectionTime(String str) {
        didDeviceConnect(str, 0L);
        setLong(this.KEY_START_CONNECTION_TIME + "." + str, 0L);
        setLong(this.KEY_START_RECONNECTION_TIME + "." + str, 0L);
    }

    public void didDeviceConnect(String str) {
        if (getEndConnectionTime(str) == 0) {
            didDeviceConnect(str, System.currentTimeMillis());
        }
    }

    private void didDeviceConnect(String str, long j) {
        setLong(this.KEY_END_CONNECTION_TIME + "." + str, j);
    }

    private long getStartConnectionTime(String str) {
        return getLong(this.KEY_START_CONNECTION_TIME + "." + str, 0L);
    }

    private long getStartReconnectionTime(String str) {
        return getLong(this.KEY_START_RECONNECTION_TIME + "." + str, 0L);
    }

    private long getEndConnectionTime(String str) {
        return getLong(this.KEY_END_CONNECTION_TIME + "." + str, 0L);
    }

    public long getConnectionTimeMilliSecond(String str) {
        long endConnectionTime = getEndConnectionTime(str);
        long startConnectionTime = getStartConnectionTime(str);
        if (startConnectionTime <= 0) {
            return -1L;
        }
        long j = endConnectionTime - startConnectionTime;
        if (j < 0) {
            return -1L;
        }
        return j;
    }

    public long getReconnectionTimeMilliSecond(String str) {
        long endConnectionTime = getEndConnectionTime(str);
        long startReconnectionTime = getStartReconnectionTime(str);
        if (startReconnectionTime <= 0) {
            return -1L;
        }
        long j = endConnectionTime - startReconnectionTime;
        if (j < 0) {
            return -1L;
        }
        return j;
    }

    public void startReadingData(String str) {
        finishReadingData(str, 0L);
        setLong(this.KEY_START_READ_DATA_TIME + "." + str, System.currentTimeMillis());
    }

    public void finishReadingData(String str) {
        if (getEndReadingData(str) == 0) {
            finishReadingData(str, System.currentTimeMillis());
        }
    }

    private void finishReadingData(String str, long j) {
        setLong(this.KEY_END_READ_DATA_TIME + "." + str, j);
    }

    private long getStartReadingData(String str) {
        return getLong(this.KEY_START_READ_DATA_TIME + "." + str, 0L);
    }

    private long getEndReadingData(String str) {
        return getLong(this.KEY_END_READ_DATA_TIME + "." + str, 0L);
    }

    public long getReadingDataTimeMilliSecond(String str) {
        long endReadingData = getEndReadingData(str) - getStartReadingData(str);
        if (endReadingData < 0) {
            return -1L;
        }
        return endReadingData;
    }
}
