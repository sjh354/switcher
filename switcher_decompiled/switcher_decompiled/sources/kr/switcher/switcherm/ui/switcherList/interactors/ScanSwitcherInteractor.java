package kr.switcher.switcherm.ui.switcherList.interactors;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import kr.switcher.device.IODevice;
import kr.switcher.device.checker.ScannedCheckerGroup;
import kr.switcher.device.linker.ScannedLinkerGroup;
import kr.switcher.device.switcher.Switcher;
import kr.switcher.device.switcher.ble.BLEScanner;
import kr.switcher.device.switcher.ble.ScannedBLESwitcher;
import kr.switcher.device.switcher.ble.ScannedSwitcherGroup;
import kr.switcher.device.switcher.ble.SwitcherBLE;
import kr.switcher.device.switcher.linker.SwitcherLinker;
import kr.switcher.device.switcher.linker.http.RestLinkerAPIStore;
import kr.switcher.device.switcher.linker.http.response.HttpAPIResponse;
import kr.switcher.device.switcher.linker.http.response.HttpResponseHandler;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.device.IODeviceHandler;
import kr.switcher.switcherm.device.switcher.handler.SwitcherHandler;
import kr.switcher.switcherm.device.switcher.handler.SwitcherUtil;
import kr.switcher.switcherm.network.http.RestErrorCode;
import kr.switcher.switcherm.preference.OAuthToken;
import kr.switcher.switcherm.ui.switcherList.adapter.IODeviceItem;
import kr.switcher.switcherm.ui.switcherList.helper.SwitcherListItemFactory;
import kr.switcher.switcherm.user.Preparing;
import kr.switcher.switcherm.user.UserStateManager;

/* JADX INFO: loaded from: classes2.dex */
public class ScanSwitcherInteractor implements BLEScanner.SwitcherBLESCanCallback {
    private static final String TAG = "ScanSwitcherInteractor";
    private int REFRESH_TIME = 2000;
    private BLEScanner bleScanner;
    private OnResultScannedSwitcherListener listener;
    private ArrayList<IODeviceItem> productionItemList;
    private TimerTask scanTimerTask;
    private ScannedCheckerGroup scannedCheckerGroup;
    private ArrayList<IODeviceItem> scannedIODeviceItemList;
    private ScannedLinkerGroup scannedLinkerGroup;
    private ScannedSwitcherGroup scannedSwitcherGroup;
    private Timer timer;

    public interface OnMainThingResultListener {
        void onResult(boolean z);
    }

    public interface OnResultScannedSwitcherListener {
        void onGetScannedSwitcherResult(List<IODeviceItem> list);
    }

    @Override // kr.switcher.device.switcher.ble.BLEScanner.SwitcherBLESCanCallback
    public void onFoundMainSwitcherResult(ScannedBLESwitcher scannedBLESwitcher) {
    }

    public void initialize(OnResultScannedSwitcherListener onResultScannedSwitcherListener) {
        this.listener = onResultScannedSwitcherListener;
        this.bleScanner = new BLEScanner();
        this.scannedSwitcherGroup = new ScannedSwitcherGroup();
        this.productionItemList = new ArrayList<>();
        this.scannedIODeviceItemList = new ArrayList<>();
        this.timer = new Timer(true);
        this.scanTimerTask = getScanTimerTask();
        startScanTimer();
    }

    private void startScanTimer() {
        Timer timer = this.timer;
        if (timer != null) {
            timer.schedule(this.scanTimerTask, 1000L, this.REFRESH_TIME);
        }
    }

    public void stopTimer() {
        Timer timer = this.timer;
        if (timer != null) {
            timer.cancel();
        }
    }

    private TimerTask getScanTimerTask() {
        return new TimerTask() { // from class: kr.switcher.switcherm.ui.switcherList.interactors.ScanSwitcherInteractor.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                ScanSwitcherInteractor.this.setScannedOtherDevices();
            }

            @Override // java.util.TimerTask
            public boolean cancel() {
                ScanSwitcherInteractor.this.stopScan();
                return super.cancel();
            }
        };
    }

    public void findSwitcherBLE() {
        if (SwitcherUtil.isBluetoothActive()) {
            this.bleScanner.scanSwitcher(this);
        }
    }

    public void findIODevices() {
        IODeviceHandler.getInstance().createIODevices(new IODeviceHandler.OnCreateResultListener() { // from class: kr.switcher.switcherm.ui.switcherList.interactors.ScanSwitcherInteractor.2
            @Override // kr.switcher.switcherm.device.IODeviceHandler.OnCreateResultListener
            public void onResult(String str, String str2) {
                if (str.equals(RestErrorCode.UNAUTHORIZED)) {
                    UserStateManager.getInstance().setAuthToken(null);
                }
            }
        });
    }

    public void findProduction() {
        this.productionItemList.clear();
        for (Preparing preparing : IODeviceHandler.getInstance().getPreparingAll()) {
            this.productionItemList.add(new IODeviceItem(preparing.getFreeTrialId(), preparing.getProductId(), "", "", "", "", ""));
        }
    }

    public void stopScan() {
        this.bleScanner.stopScan();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setScannedOtherDevices() {
        IOLog.d(TAG, "setScannedOtherDevices");
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: kr.switcher.switcherm.ui.switcherList.interactors.ScanSwitcherInteractor.3
            @Override // java.lang.Runnable
            public void run() {
                ScanSwitcherInteractor scanSwitcherInteractor = ScanSwitcherInteractor.this;
                scanSwitcherInteractor.scannedSwitcherGroup = scanSwitcherInteractor.bleScanner.getScannedSwitcherGroup();
                ScanSwitcherInteractor scanSwitcherInteractor2 = ScanSwitcherInteractor.this;
                scanSwitcherInteractor2.scannedLinkerGroup = scanSwitcherInteractor2.bleScanner.getScannedLinkerGroup();
                ScanSwitcherInteractor scanSwitcherInteractor3 = ScanSwitcherInteractor.this;
                scanSwitcherInteractor3.scannedCheckerGroup = scanSwitcherInteractor3.bleScanner.getScannedCheckerGroup();
                ScanSwitcherInteractor.this.scannedIODeviceItemList.clear();
                List<IODeviceItem> listCreate = SwitcherListItemFactory.create(ScanSwitcherInteractor.this.scannedSwitcherGroup.getAllDeviceList());
                if (listCreate != null) {
                    ScanSwitcherInteractor.this.scannedIODeviceItemList.addAll(listCreate);
                }
                ScanSwitcherInteractor.this.scannedIODeviceItemList.addAll(ScanSwitcherInteractor.this.productionItemList);
                for (int i = 0; i < ScanSwitcherInteractor.this.scannedLinkerGroup.getAllDeviceList().size(); i++) {
                    ScanSwitcherInteractor.this.scannedIODeviceItemList.add(i, new IODeviceItem(IODevice.ProductId.LINKER, "링커", ScanSwitcherInteractor.this.scannedLinkerGroup.getAllDeviceList().get(i).getDevice().getAddress(), "와이파이 설정", false, true));
                }
                for (int i2 = 0; i2 < ScanSwitcherInteractor.this.scannedCheckerGroup.getAllDeviceList().size(); i2++) {
                    ScanSwitcherInteractor.this.scannedIODeviceItemList.add(i2, new IODeviceItem(IODevice.ProductId.CHECKER, "체커", ScanSwitcherInteractor.this.scannedCheckerGroup.getAllDeviceList().get(i2).getDevice().getAddress(), "와이파이 설정", false, true));
                }
                ScanSwitcherInteractor.this.listener.onGetScannedSwitcherResult(ScanSwitcherInteractor.this.scannedIODeviceItemList);
            }
        });
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

    @Override // kr.switcher.device.switcher.ble.BLEScanner.SwitcherBLESCanCallback
    public void onScanStatus(int i) {
        IOLog.deviceLog("", IOLog.DEVICE_LOG_TYPE_SCAN, String.valueOf(i));
        switch (i) {
            case 301:
                IOLog.error(TAG, new OAuthToken().getOAuthToken(), "addDevice", new Exception("device is null"));
                break;
            case 302:
                IOLog.error(TAG, new OAuthToken().getOAuthToken(), "addDevice", new Exception("device name is null"));
                break;
            case 303:
                break;
            case 304:
                IOLog.error(TAG, new OAuthToken().getOAuthToken(), "addDevice", new Exception("invalid address"));
                break;
            case 305:
                IOLog.error(TAG, new OAuthToken().getOAuthToken(), "addDevice", new Exception("advertising's serial number is null"));
                break;
            default:
                IOLog.error(TAG, new OAuthToken().getOAuthToken(), "onScanFailed", new Exception("scan fail (error code : " + i + ")"));
                break;
        }
    }

    public void changeMainThing(final IODeviceItem iODeviceItem, final OnMainThingResultListener onMainThingResultListener) {
        RestLinkerAPIStore.requestPostMainThing(iODeviceItem.getMacAddress(), new HttpResponseHandler() { // from class: kr.switcher.switcherm.ui.switcherList.interactors.ScanSwitcherInteractor.4
            @Override // kr.switcher.device.switcher.linker.http.response.HttpResponseHandler
            public void onSuccess(HttpAPIResponse httpAPIResponse) {
                Switcher switcher = SwitcherHandler.getInstance().getSwitcher(iODeviceItem.getMacAddress());
                if (switcher != null) {
                    if (switcher.getClass().equals(SwitcherBLE.class)) {
                        ScanSwitcherInteractor.this.linkSwitcher((SwitcherBLE) switcher);
                    }
                    onMainThingResultListener.onResult(true);
                    return;
                }
                onMainThingResultListener.onResult(false);
            }

            @Override // kr.switcher.device.switcher.linker.http.response.HttpResponseHandler
            public void onFailure(String str, String str2) {
                onMainThingResultListener.onResult(false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void linkSwitcher(SwitcherBLE switcherBLE) {
        SwitcherLinker switcherLinker = new SwitcherLinker(switcherBLE.getMacAddress(), switcherBLE.getSerialNumber(), switcherBLE.getName(), switcherBLE.getProductId(), switcherBLE.getShareCode(), switcherBLE.getOwner(), switcherBLE.getOption(), switcherBLE.getThingConnectionStatus());
        switcherLinker.setBattery(switcherBLE.getBattery());
        IODeviceHandler.getInstance().replaceDevice(switcherLinker);
    }
}
