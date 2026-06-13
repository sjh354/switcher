package kr.switcher.device.switcher.ble;

import android.bluetooth.BluetoothAdapter;
import kr.switcher.device.checker.Checker;
import kr.switcher.device.checker.ScannedBLEChecker;
import kr.switcher.device.checker.ScannedCheckerMaker;
import kr.switcher.device.linker.Linker;
import kr.switcher.device.linker.ScannedBLELinker;
import kr.switcher.device.linker.ScannedLinkerMaker;
import kr.switcher.device.switcher.Switcher;
import kr.switcher.ioble.scanner.BLEScanInfo;
import kr.switcher.ioble.scanner.BLEScanListener;

/* JADX INFO: loaded from: classes2.dex */
public class BLEScanResult implements BLEScanListener.ScanResultListener {
    private static final String TAG = "BLEScanResult";
    private ScannedBLEListener listener;

    public interface ScannedBLEListener {
        void addCheckerDevice(ScannedBLEChecker scannedBLEChecker);

        void addDevice(ScannedBLESwitcher scannedBLESwitcher);

        void addLinkerDevice(ScannedBLELinker scannedBLELinker);

        void scanFailed(int i);
    }

    public BLEScanResult(ScannedBLEListener scannedBLEListener) {
        this.listener = scannedBLEListener;
    }

    @Override // kr.switcher.ioble.scanner.BLEScanListener.ScanResultListener
    public void onScanResult(BLEScanInfo bLEScanInfo) {
        String name;
        ScannedBLEChecker scannedBLECheckerMakeScannedBLEChecker;
        if (this.listener == null || (name = bLEScanInfo.bluetoothDevice.getName()) == null) {
            return;
        }
        if (name.contains(Switcher.SWITCHER_NAME)) {
            ScannedBLESwitcher scannedBLESwitcherMakeScannedBLESwitcher = ScannedSwitcherMaker.makeScannedBLESwitcher(bLEScanInfo);
            if (scannedBLESwitcherMakeScannedBLESwitcher != null) {
                this.listener.addDevice(scannedBLESwitcherMakeScannedBLESwitcher);
                return;
            }
            return;
        }
        if (name.contains(Linker.LINKER_NAME)) {
            ScannedBLELinker scannedBLELinkerMakeScannedBLELinker = ScannedLinkerMaker.makeScannedBLELinker(bLEScanInfo);
            if (scannedBLELinkerMakeScannedBLELinker != null) {
                this.listener.addLinkerDevice(scannedBLELinkerMakeScannedBLELinker);
                return;
            }
            return;
        }
        if (!name.contains(Checker.CHECKER_NAME) || (scannedBLECheckerMakeScannedBLEChecker = ScannedCheckerMaker.makeScannedBLEChecker(bLEScanInfo)) == null) {
            return;
        }
        this.listener.addCheckerDevice(scannedBLECheckerMakeScannedBLEChecker);
    }

    @Override // kr.switcher.ioble.scanner.BLEScanListener.ScanResultListener
    public void onScanFailed(int i) {
        this.listener.scanFailed(i);
        BluetoothAdapter.getDefaultAdapter().enable();
    }
}
