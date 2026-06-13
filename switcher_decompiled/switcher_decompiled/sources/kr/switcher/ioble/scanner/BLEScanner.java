package kr.switcher.ioble.scanner;

import android.content.Context;
import kr.switcher.ioble.common.BLEUtil;
import kr.switcher.ioble.scanner.BLEScanListener;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BLEScanner {
    private static final long SCAN_DURATION = 5000;
    private static volatile BLEScanner instance;
    protected Context context = BLEUtil.getContext();
    protected ScanningChecker scanningChecker = new ScanningChecker();
    protected ScanTimeTask scanTimeTask = new ScanTimeTask();
    protected String filteredMacAddress = "";

    public abstract void setFilters(String str);

    public abstract void startScan(BLEScanListener.ScanResultListener scanResultListener);

    public static BLEScanner getScanner(Context context) {
        if (instance == null) {
            synchronized (BLEScanner.class) {
                if (instance == null) {
                    instance = BLEScannerFactory.createBLEScanner(context);
                }
            }
        }
        return instance;
    }

    protected void startScan() {
        this.scanningChecker.startScan();
    }

    public void stopScan() {
        this.scanningChecker.stopScan();
    }
}
