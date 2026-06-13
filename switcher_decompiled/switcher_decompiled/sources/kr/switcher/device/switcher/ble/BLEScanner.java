package kr.switcher.device.switcher.ble;

import android.bluetooth.BluetoothDevice;
import android.os.Handler;
import android.util.Log;
import java.util.List;
import kr.switcher.device.IODevice;
import kr.switcher.device.SReturnCode;
import kr.switcher.device.checker.Checker;
import kr.switcher.device.checker.ScannedBLEChecker;
import kr.switcher.device.checker.ScannedCheckerGroup;
import kr.switcher.device.common.DeviceUtil;
import kr.switcher.device.linker.Linker;
import kr.switcher.device.linker.ScannedBLELinker;
import kr.switcher.device.linker.ScannedLinkerGroup;
import kr.switcher.device.switcher.Switcher;
import kr.switcher.device.switcher.ble.BLEScanResult;
import kr.switcher.ioble.checker.CheckerAdvertisementPacket;
import kr.switcher.ioble.switcher.SwitcherAdvertisementPacket;

/* JADX INFO: loaded from: classes2.dex */
public class BLEScanner implements BLEScanResult.ScannedBLEListener {
    private static final String EMPTY = "";
    private static final String TAG = "BLEScanner";
    private SwitcherBLESCanCallback callback;
    private ScannedCheckerGroup scannedCheckerGroup;
    private ScannedLinkerGroup scannedLinkerGroup;
    private ScannedSwitcherGroup scannedSwitcherGroup;
    private Handler timeoutScanHandler;
    private Runnable timeoutScanRunnable;

    public interface SwitcherBLESCanCallback {
        void onFoundMainSwitcherResult(ScannedBLESwitcher scannedBLESwitcher);

        void onScanStatus(int i);
    }

    public BLEScanner() {
        initialize();
    }

    private void initialize() {
        this.scannedSwitcherGroup = new ScannedSwitcherGroup();
        this.scannedLinkerGroup = new ScannedLinkerGroup();
        this.scannedCheckerGroup = new ScannedCheckerGroup();
        this.timeoutScanHandler = new Handler();
        this.timeoutScanRunnable = new Runnable() { // from class: kr.switcher.device.switcher.ble.BLEScanner.1
            @Override // java.lang.Runnable
            public void run() {
                BLEScanner.this.stopScan();
            }
        };
    }

    public void setSwitcherBLEScanCallback(SwitcherBLESCanCallback switcherBLESCanCallback) {
        this.callback = switcherBLESCanCallback;
    }

    public void scanSwitcher(SwitcherBLESCanCallback switcherBLESCanCallback) {
        scanSwitcher("", switcherBLESCanCallback);
    }

    public void scanSwitcher(String str, SwitcherBLESCanCallback switcherBLESCanCallback) {
        Log.d(TAG, "start scan (mac address:" + str + ")");
        initialize();
        setSwitcherBLEScanCallback(switcherBLESCanCallback);
        kr.switcher.ioble.scanner.BLEScanner scanner = kr.switcher.ioble.scanner.BLEScanner.getScanner(DeviceUtil.getContext());
        scanner.setFilters(str);
        scanner.startScan(new BLEScanResult(this));
        timeoutScan();
    }

    public void stopScan() {
        Log.d(TAG, "stop scan");
        kr.switcher.ioble.scanner.BLEScanner.getScanner(DeviceUtil.getContext()).stopScan();
    }

    private void timeoutScan() {
        this.timeoutScanHandler.postDelayed(this.timeoutScanRunnable, 10000L);
    }

    public List<ScannedBLESwitcher> getScannedSwitchers() {
        return this.scannedSwitcherGroup.getAllDeviceList();
    }

    public ScannedSwitcherGroup getScannedSwitcherGroup() {
        return this.scannedSwitcherGroup;
    }

    public ScannedLinkerGroup getScannedLinkerGroup() {
        return this.scannedLinkerGroup;
    }

    public ScannedCheckerGroup getScannedCheckerGroup() {
        return this.scannedCheckerGroup;
    }

    @Override // kr.switcher.device.switcher.ble.BLEScanResult.ScannedBLEListener
    public void addDevice(ScannedBLESwitcher scannedBLESwitcher) {
        int iCheckIsInvalidDevice = checkIsInvalidDevice(scannedBLESwitcher);
        onScanStatus(iCheckIsInvalidDevice);
        if (iCheckIsInvalidDevice == 1 || iCheckIsInvalidDevice == 305) {
            this.scannedSwitcherGroup.add(scannedBLESwitcher);
            if (this.callback != null) {
                Log.d(TAG, "scanned main switcher (mac address:" + scannedBLESwitcher.getDevice().getAddress() + ")");
                this.callback.onFoundMainSwitcherResult(scannedBLESwitcher);
                this.callback = null;
                this.timeoutScanHandler.removeCallbacks(this.timeoutScanRunnable);
                return;
            }
            Log.d(TAG, "scanned switcher (mac address:" + scannedBLESwitcher.getDevice().getAddress() + ")");
        }
    }

    @Override // kr.switcher.device.switcher.ble.BLEScanResult.ScannedBLEListener
    public void addLinkerDevice(ScannedBLELinker scannedBLELinker) {
        int iCheckIsInvalidLinkerDevice = checkIsInvalidLinkerDevice(scannedBLELinker);
        onScanStatus(iCheckIsInvalidLinkerDevice);
        if (iCheckIsInvalidLinkerDevice == 1 || iCheckIsInvalidLinkerDevice == 305) {
            this.scannedLinkerGroup.add(scannedBLELinker);
            Log.d(TAG, "scanned linker (mac address:" + scannedBLELinker.getDevice().getAddress() + ")");
        }
    }

    @Override // kr.switcher.device.switcher.ble.BLEScanResult.ScannedBLEListener
    public void addCheckerDevice(ScannedBLEChecker scannedBLEChecker) {
        int iCheckIsInvalidCheckerDevice = checkIsInvalidCheckerDevice(scannedBLEChecker);
        onScanStatus(iCheckIsInvalidCheckerDevice);
        if (iCheckIsInvalidCheckerDevice == 1 || iCheckIsInvalidCheckerDevice == 305) {
            this.scannedCheckerGroup.add(scannedBLEChecker);
            Log.d(TAG, "scanned linker (mac address:" + scannedBLEChecker.getDevice().getAddress() + ")");
        }
    }

    @Override // kr.switcher.device.switcher.ble.BLEScanResult.ScannedBLEListener
    public void scanFailed(int i) {
        onScanStatus(i);
    }

    private void onScanStatus(int i) {
        SwitcherBLESCanCallback switcherBLESCanCallback = this.callback;
        if (switcherBLESCanCallback != null) {
            switcherBLESCanCallback.onScanStatus(i);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private int checkIsInvalidDevice(ScannedBLESwitcher scannedBLESwitcher) {
        BluetoothDevice device = scannedBLESwitcher.getDevice();
        SwitcherAdvertisementPacket advertisementPacket = scannedBLESwitcher.getAdvertisementPacket();
        if (device == null) {
            return 301;
        }
        Log.d(TAG, "check scanned device : " + scannedBLESwitcher.getDevice().getAddress());
        if (device.getName() == null) {
            return 302;
        }
        if (!device.getName().contains(Switcher.SWITCHER_NAME)) {
            return 303;
        }
        if (!DeviceUtil.checkIsBluetoothAddress(device.getAddress())) {
            return 304;
        }
        if (advertisementPacket.getClass().getSimpleName().equals(SwitcherAdvertisementPacket.class)) {
            return advertisementPacket.getSerialNumber() == null ? 305 : 1;
        }
        if (!advertisementPacket.getClass().getSimpleName().equals(CheckerAdvertisementPacket.class) || DeviceUtil.convertProductId(((CheckerAdvertisementPacket) advertisementPacket).getType()).equals(IODevice.ProductId.CHECKER)) {
            return 1;
        }
        return SReturnCode.INVALID_CHECKER_TYPE;
    }

    private int checkIsInvalidLinkerDevice(ScannedBLELinker scannedBLELinker) {
        BluetoothDevice device = scannedBLELinker.getDevice();
        if (device == null) {
            return 301;
        }
        Log.d(TAG, "check scanned linker device : " + scannedBLELinker.getDevice().getAddress());
        if (device.getName() == null) {
            return 302;
        }
        if (device.getName().contains(Linker.LINKER_NAME)) {
            return !DeviceUtil.checkIsBluetoothAddress(device.getAddress()) ? 304 : 1;
        }
        return 303;
    }

    private int checkIsInvalidCheckerDevice(ScannedBLEChecker scannedBLEChecker) {
        BluetoothDevice device = scannedBLEChecker.getDevice();
        if (device == null) {
            return 301;
        }
        Log.d(TAG, "check scanned checker device : " + scannedBLEChecker.getDevice().getAddress());
        if (device.getName() == null) {
            return 302;
        }
        if (device.getName().contains(Checker.CHECKER_NAME)) {
            return !DeviceUtil.checkIsBluetoothAddress(device.getAddress()) ? 304 : 1;
        }
        return 303;
    }
}
