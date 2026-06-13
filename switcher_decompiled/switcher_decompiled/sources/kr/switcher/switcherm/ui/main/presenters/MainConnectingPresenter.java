package kr.switcher.switcherm.ui.main.presenters;

import android.os.Handler;
import kr.switcher.device.IODevice;
import kr.switcher.device.IODeviceConfig;
import kr.switcher.device.checker.ScannedBLEChecker;
import kr.switcher.device.common.ScannedBLEDevice;
import kr.switcher.device.linker.ScannedBLELinker;
import kr.switcher.device.remocon.Remocon;
import kr.switcher.device.switcher.Switcher;
import kr.switcher.device.switcher.ble.ScannedBLESwitcher;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.device.IODeviceHandler;
import kr.switcher.switcherm.preference.OAuthToken;
import kr.switcher.switcherm.ui.main.MainActivity;
import kr.switcher.switcherm.ui.main.helper.FutureAction;
import kr.switcher.switcherm.ui.main.interactors.FindCheckerToConnectInteractor;
import kr.switcher.switcherm.ui.main.interactors.FindLinkerToConnectInteractor;
import kr.switcher.switcherm.ui.main.interactors.FindSwitcherToConnectInteractor;
import kr.switcher.switcherm.ui.main.views.MainConnectingView;
import kr.switcher.switcherm.ui.wifi.interactor.ConnectBLEDeviceInteractor;

/* JADX INFO: loaded from: classes2.dex */
public class MainConnectingPresenter implements FindSwitcherToConnectInteractor.OnFindSwitcherToConnectListener {
    private static final String TAG = "MainConnectingPresenter";
    private ConnectBLEDeviceInteractor bleDeviceInteractor;
    private FindCheckerToConnectInteractor checkerInteractor;
    private FutureAction futureAction;
    private FindLinkerToConnectInteractor linkerInteractor;
    private FindSwitcherToConnectInteractor switcherInteractor;
    private Handler timeoutConnectHandler;
    private Runnable timeoutConnectRunnable;
    private MainConnectingView view;

    public MainConnectingPresenter(MainConnectingView mainConnectingView, FindSwitcherToConnectInteractor findSwitcherToConnectInteractor, FindLinkerToConnectInteractor findLinkerToConnectInteractor, FindCheckerToConnectInteractor findCheckerToConnectInteractor, ConnectBLEDeviceInteractor connectBLEDeviceInteractor, FutureAction futureAction) {
        this.view = mainConnectingView;
        this.switcherInteractor = findSwitcherToConnectInteractor;
        findSwitcherToConnectInteractor.setOnFindSwitcherToConnectListener(this);
        this.linkerInteractor = findLinkerToConnectInteractor;
        findLinkerToConnectInteractor.setOnFindSwitcherToConnectListener(this);
        this.checkerInteractor = findCheckerToConnectInteractor;
        findCheckerToConnectInteractor.setOnFindSwitcherToConnectListener(this);
        this.futureAction = futureAction;
        this.bleDeviceInteractor = connectBLEDeviceInteractor;
    }

    public void initialize(ScannedBLEDevice scannedBLEDevice, String str) {
        this.timeoutConnectHandler = new Handler();
        this.timeoutConnectRunnable = getTimeoutConnectRunnable(str);
        IODevice device = IODeviceHandler.getInstance().getDevice(str);
        if (device == null) {
            if (scannedBLEDevice.getClass().equals(ScannedBLESwitcher.class)) {
                this.switcherInteractor.createSwitcher(str, (ScannedBLESwitcher) scannedBLEDevice);
                return;
            } else if (scannedBLEDevice.getClass().equals(ScannedBLELinker.class)) {
                this.linkerInteractor.createLinker((ScannedBLELinker) scannedBLEDevice);
                return;
            } else {
                if (scannedBLEDevice.getClass().equals(ScannedBLEChecker.class)) {
                    this.checkerInteractor.createChecker((ScannedBLEChecker) scannedBLEDevice);
                    return;
                }
                return;
            }
        }
        if (device.getProductId().equals(IODevice.ProductId.SWITCHER_TYPE_ONE) || device.getProductId().equals(IODevice.ProductId.SWITCHER_TYPE_TWO)) {
            Switcher switcher = (Switcher) device;
            if (switcher != null) {
                viewData(switcher);
                if (scannedBLEDevice != null) {
                    switcher.attachToDevice(scannedBLEDevice);
                }
                this.futureAction.setOnFutureActionListener(getFutureActionListener(switcher));
                this.futureAction.what(switcher);
                return;
            }
            return;
        }
        if (device.getProductId().equals(IODevice.ProductId.REMOCON)) {
            Remocon remocon = (Remocon) device;
            if (remocon == null) {
                return;
            }
            if (remocon.getControllerId().equals(Remocon.ControllerID.AIRCON)) {
                this.view.moveConnectedAirconRemoconScreen(remocon.getMacAddress());
                return;
            } else if (remocon.getControllerId().equals(Remocon.ControllerID.SET_TOP_BOX)) {
                this.view.moveConnectedSettopRemoconScreen(remocon.getMacAddress());
                return;
            } else {
                this.view.moveMainConnectedRemoconScreen(remocon.getMacAddress());
                return;
            }
        }
        if (device.getProductId().equals(IODevice.ProductId.CHECKER) && scannedBLEDevice == null) {
            this.view.moveMainConnectedCheckerScreen(device.getMacAddress());
        }
    }

    public void process(FutureAction.Action action, Switcher switcher) {
        ScannedBLESwitcher attachedDevice = switcher.getAttachedDevice();
        int i = AnonymousClass3.$SwitchMap$kr$switcher$switcherm$ui$main$helper$FutureAction$Action[action.ordinal()];
        if (i == 1) {
            this.switcherInteractor.connectSwitcher(attachedDevice, switcher.getMacAddress());
            this.timeoutConnectHandler.postDelayed(this.timeoutConnectRunnable, 10000L);
        } else if (i != 2) {
            if (i != 3) {
                return;
            }
            this.switcherInteractor.connectSwitcher(attachedDevice, switcher.getMacAddress(), IODeviceConfig.DEFAULT_HASHED_SHARE_CODE);
        } else if (attachedDevice != null) {
            this.view.moveMainShareCodeScreen(attachedDevice);
        }
    }

    private void viewData(Switcher switcher) {
        this.view.sendMainData(switcher.getMacAddress(), switcher.getProductId(), switcher.getName(), IOUtil.getStringResource(R.string.scanning), MainActivity.MainBackgroundState.NORMAL);
        setSwitcherType(switcher.getProductId());
    }

    public void setSwitcherType(IODevice.ProductId productId) {
        int i = AnonymousClass3.$SwitchMap$kr$switcher$device$IODevice$ProductId[productId.ordinal()];
        if (i == 1) {
            this.view.showOneSetView();
            this.view.hideTwoSetView();
        } else if (i == 2) {
            this.view.showTwoSetView();
            this.view.hideOneSetView();
        } else {
            this.view.showErrorMessage(IOUtil.getStringResource(R.string.not_support_type));
        }
    }

    private void processConnected(Switcher switcher) {
        if (switcher.getOwner() == null) {
            this.view.moveRegisterScreen(switcher.getMacAddress());
        } else if (switcher.getAuthority() != 0) {
            switcher.disconnect();
            this.view.moveMainDisconnectedScreen(switcher.getMacAddress(), switcher.getAuthority());
        } else {
            this.view.moveMainConnectedScreen(switcher.getMacAddress());
        }
    }

    private void processIdle(Switcher switcher) {
        IOLog.i(TAG, "connection close (authority:" + switcher.getAuthority() + ")");
        if (switcher.getAuthority() == 2) {
            this.view.showErrorMessage(IOUtil.getStringResource(R.string.not_match_share_code));
        } else if (switcher.getAuthority() == 1) {
            this.view.showErrorMessage(IOUtil.getStringResource(R.string.invalid_share_code));
        } else {
            switcher.getAuthority();
        }
        this.view.moveMainDisconnectedScreen(switcher.getMacAddress(), switcher.getAuthority());
    }

    public void onDestroyView() {
        this.timeoutConnectHandler.removeCallbacks(this.timeoutConnectRunnable);
    }

    private Runnable getTimeoutConnectRunnable(final String str) {
        return new Runnable() { // from class: kr.switcher.switcherm.ui.main.presenters.MainConnectingPresenter.1
            @Override // java.lang.Runnable
            public void run() {
                Switcher switcherInitSwitcher = MainConnectingPresenter.this.switcherInteractor.initSwitcher(str);
                if (switcherInitSwitcher != null) {
                    MainConnectingPresenter.this.onConnectionStateResult(switcherInitSwitcher, 0);
                }
            }
        };
    }

    /* JADX INFO: renamed from: kr.switcher.switcherm.ui.main.presenters.MainConnectingPresenter$3, reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$kr$switcher$device$IODevice$ProductId;
        static final /* synthetic */ int[] $SwitchMap$kr$switcher$device$switcher$Switcher$ConnectionState;
        static final /* synthetic */ int[] $SwitchMap$kr$switcher$switcherm$ui$main$helper$FutureAction$Action;

        static {
            int[] iArr = new int[Switcher.ConnectionState.values().length];
            $SwitchMap$kr$switcher$device$switcher$Switcher$ConnectionState = iArr;
            try {
                iArr[Switcher.ConnectionState.CONNECTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$kr$switcher$device$switcher$Switcher$ConnectionState[Switcher.ConnectionState.IDLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$kr$switcher$device$switcher$Switcher$ConnectionState[Switcher.ConnectionState.FAILED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$kr$switcher$device$switcher$Switcher$ConnectionState[Switcher.ConnectionState.CONNECTING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[IODevice.ProductId.values().length];
            $SwitchMap$kr$switcher$device$IODevice$ProductId = iArr2;
            try {
                iArr2[IODevice.ProductId.SWITCHER_TYPE_ONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$kr$switcher$device$IODevice$ProductId[IODevice.ProductId.SWITCHER_TYPE_TWO.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            int[] iArr3 = new int[FutureAction.Action.values().length];
            $SwitchMap$kr$switcher$switcherm$ui$main$helper$FutureAction$Action = iArr3;
            try {
                iArr3[FutureAction.Action.ACTION_CONNECT.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$kr$switcher$switcherm$ui$main$helper$FutureAction$Action[FutureAction.Action.ACTION_CODE.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$kr$switcher$switcherm$ui$main$helper$FutureAction$Action[FutureAction.Action.ACTION_REGISTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    @Override // kr.switcher.switcherm.ui.main.interactors.FindSwitcherToConnectInteractor.OnFindSwitcherToConnectListener
    public void onConnectionStateResult(Switcher switcher, int i) {
        int i2 = AnonymousClass3.$SwitchMap$kr$switcher$device$switcher$Switcher$ConnectionState[switcher.getConnectionState().ordinal()];
        if (i2 == 1) {
            processConnected(switcher);
        } else if (i2 == 2) {
            processIdle(switcher);
        } else if (i2 == 3) {
            this.view.moveMainDisconnectedScreen(switcher.getMacAddress(), i);
        } else if (i2 == 4) {
            this.view.trackConnectingForGA();
            this.view.sendMainData(switcher.getMacAddress(), switcher.getProductId(), switcher.getName(), IOUtil.getStringResource(R.string.connecting), MainActivity.MainBackgroundState.NORMAL);
        }
        if (i != 0) {
            IOLog.error(TAG, new OAuthToken().getOAuthToken(), "onConnectionStateResult", new Exception("error code : " + i));
        }
    }

    @Override // kr.switcher.switcherm.ui.main.interactors.FindSwitcherToConnectInteractor.OnFindSwitcherToConnectListener
    public void onConnectResult(int i, Switcher switcher) {
        if (i == 1) {
            this.view.sendMainData(switcher.getMacAddress(), switcher.getProductId(), switcher.getName(), IOUtil.getStringResource(R.string.connecting), MainActivity.MainBackgroundState.NORMAL);
            return;
        }
        if (i == 202) {
            this.view.trackScanningForGA();
            this.view.sendMainData(switcher.getMacAddress(), switcher.getProductId(), switcher.getName(), IOUtil.getStringResource(R.string.scanning), MainActivity.MainBackgroundState.NORMAL);
        } else if (i == 113) {
            this.view.moveMainShareCodeScreen(switcher.getAttachedDevice());
        } else {
            this.view.showErrorMessage(IOUtil.getStringResource(R.string.etc_error));
        }
    }

    @Override // kr.switcher.switcherm.ui.main.interactors.FindSwitcherToConnectInteractor.OnFindSwitcherToConnectListener
    public void onCreateResult(boolean z, String str) {
        if (z) {
            IODevice device = IODeviceHandler.getInstance().getDevice(str);
            if (device.getProductId().equals(IODevice.ProductId.SWITCHER_TYPE_ONE) || device.getProductId().equals(IODevice.ProductId.SWITCHER_TYPE_TWO)) {
                Switcher switcher = (Switcher) device;
                this.futureAction.setOnFutureActionListener(getFutureActionListener(switcher));
                this.futureAction.what(switcher);
                return;
            } else {
                if (device.getProductId().equals(IODevice.ProductId.CHECKER)) {
                    if (device.getAttachedDevice() != null) {
                        this.bleDeviceInteractor.connectDevice();
                        return;
                    } else {
                        this.view.moveMainConnectedCheckerScreen(device.getMacAddress());
                        return;
                    }
                }
                if (!device.getProductId().equals(IODevice.ProductId.LINKER) || device.getAttachedDevice() == null) {
                    return;
                }
                this.bleDeviceInteractor.connectDevice();
                return;
            }
        }
        this.view.sendMainData(str, null, "등록되지 않은 제품", "중단됨", MainActivity.MainBackgroundState.DISCONNECTED);
        this.view.showErrorMessage(IOUtil.getStringResource(R.string.not_registered_device));
    }

    public FutureAction.OnFutureActionListener getFutureActionListener(final Switcher switcher) {
        return new FutureAction.OnFutureActionListener() { // from class: kr.switcher.switcherm.ui.main.presenters.MainConnectingPresenter.2
            @Override // kr.switcher.switcherm.ui.main.helper.FutureAction.OnFutureActionListener
            public void onAction(FutureAction.Action action) {
                MainConnectingPresenter.this.process(action, switcher);
            }
        };
    }

    public void onConnect(IODevice iODevice) {
        if (iODevice.getOwner() == null || iODevice.getOwner().length() < 1) {
            this.view.moveRegisterScreen(iODevice.getMacAddress());
        } else {
            this.view.moveWifiSettingScreen(iODevice);
        }
    }
}
