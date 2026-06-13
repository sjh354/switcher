package kr.switcher.switcherm.ui.main.presenters;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import java.util.List;
import kr.switcher.device.IODevice;
import kr.switcher.device.linker.Linker;
import kr.switcher.device.switcher.Switcher;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IODeviceIconMaker;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.device.linker.LinkerHandler;
import kr.switcher.switcherm.device.switcher.handler.SwitcherHandler;
import kr.switcher.switcherm.permission.PermissionChecker;
import kr.switcher.switcherm.ui.dialog.ConfirmCallback;
import kr.switcher.switcherm.ui.main.MainActivity;
import kr.switcher.switcherm.ui.main.helper.BLEConnectionManager;
import kr.switcher.switcherm.ui.main.helper.MainScreenController;
import kr.switcher.switcherm.ui.main.interactors.GetCurrentSensorValueInteractor;
import kr.switcher.switcherm.ui.main.views.MainView;

/* JADX INFO: loaded from: classes2.dex */
public class MainPresenter implements MainScreenController.OnMainDataResultCallback, ConfirmCallback {
    private Context context;
    private GetCurrentSensorValueInteractor interactor;
    private Linker linker;
    private MainView view;

    public MainPresenter(MainView mainView, Context context, GetCurrentSensorValueInteractor getCurrentSensorValueInteractor) {
        this.view = mainView;
        this.context = context;
        this.interactor = getCurrentSensorValueInteractor;
    }

    public void initialize() {
        setTitle();
        this.view.hideProgressbar();
        this.view.setNormalTransitionView();
        this.view.setTimerSizeForSignal();
        this.view.moveMainDefaultScreen();
        if (checkPermission()) {
            connectSwitcher();
        }
    }

    private void connectSwitcher() {
        String switcherToAutoConnect = BLEConnectionManager.getSwitcherToAutoConnect();
        if (IOUtil.checkIsIODeviceKey(switcherToAutoConnect)) {
            Intent intent = new Intent();
            intent.putExtra(MainScreenController.INTENT_PARM_MAC_ADDRESS_TO_CONNECT, switcherToAutoConnect);
            onActivityResult(0, 101, intent);
            return;
        }
        this.view.callSwitcherListActivity();
    }

    private void setTitle() {
        this.view.setTitle(IOUtil.getStringResource(R.string.application_name));
    }

    private boolean checkPermission() {
        Boolean bool;
        Boolean bool2 = false;
        Boolean.valueOf(false);
        Boolean.valueOf(false);
        if (!PermissionChecker.checkFineLocationPermission(this.context)) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
            builder.create();
            builder.setTitle("위치 권한 요청");
            builder.setMessage("I/O앱은 스마트폰의 블루투스를 사용하여 제품들과 연결 및 제어합니다. \n이를 위해 백그라운드 위치권한 허용을 요청드리고 있습니다. \n(* 앱이 종료되었거나 사용 중이 아닐때도 위치 데이터를 수집하여 위젯실행시 블루투스 통신을 위해 사용 합니다.)");
            builder.setCancelable(true);
            builder.setNegativeButton("취소", new DialogInterface.OnClickListener() { // from class: kr.switcher.switcherm.ui.main.presenters.MainPresenter.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    PermissionChecker.requestFineLocationPermission((Activity) MainPresenter.this.context);
                }
            });
            builder.setPositiveButton(SettopRemoconConnectedPresenter.BUTTON_CONFIRM, new DialogInterface.OnClickListener() { // from class: kr.switcher.switcherm.ui.main.presenters.MainPresenter.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    PermissionChecker.requestFineLocationPermission((Activity) MainPresenter.this.context);
                }
            });
            builder.show();
            bool = bool2;
        } else {
            bool = true;
        }
        if (PermissionChecker.checkIgonoringBatteryOptimization(this.context)) {
            bool2 = true;
        } else {
            PermissionChecker.requestIgnoringBatteryOptimization((Activity) this.context);
        }
        return bool.booleanValue() && bool2.booleanValue();
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i != 1) {
            return;
        }
        if (iArr.length > 0 && iArr[0] == 0) {
            this.view.moveMainDefaultScreen();
            this.view.callSwitcherListActivity();
        } else {
            IOUtil.showToast("스위처를 사용하기 위해서는 권한을 허용해야 합니다.");
            this.view.moveMainBLEPermissionReqScreen();
        }
    }

    public void onResume(IODevice iODevice) {
        this.view.hideCurrentTemperature();
        sendBroadcast(iODevice);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (intent == null) {
            return;
        }
        if (i2 == 101) {
            disconnectSwitcher(intent.getStringExtra(MainScreenController.INTENT_PARM_MAC_ADDRESS_TO_CONNECT), SwitcherHandler.getInstance().getConnectedSwitcherList());
            this.view.moveMainConnectingScreen(intent);
            return;
        }
        if (i2 != 103) {
            if (i2 == 104) {
                this.view.callSwitcherListActivity();
            }
        } else {
            String stringExtra = intent.getStringExtra(MainActivity.CONNECTED_SWITCHER_ADDRESS);
            if (IOUtil.checkIsIODeviceKey(stringExtra)) {
                final Intent intent2 = new Intent();
                intent2.putExtra(MainScreenController.INTENT_PARM_MAC_ADDRESS_TO_CONNECT, stringExtra);
                new Handler().postDelayed(new Runnable() { // from class: kr.switcher.switcherm.ui.main.presenters.MainPresenter.3
                    @Override // java.lang.Runnable
                    public void run() {
                        MainPresenter.this.view.moveMainConnectingScreen(intent2);
                    }
                }, 1000L);
            }
        }
    }

    private void disconnectSwitcher(String str, List<Switcher> list) {
        for (Switcher switcher : list) {
            if (!switcher.getMacAddress().equals(str)) {
                switcher.disconnect();
                IOUtil.sleep(500);
            }
        }
    }

    public void onPause(Switcher switcher) {
        sendBroadcast(switcher);
    }

    public void onDestroy() {
        this.view.disconnectAllSwitcher();
    }

    @Override // kr.switcher.switcherm.ui.main.helper.MainScreenController.OnMainDataResultCallback
    public void onMainData(String str, IODevice.ProductId productId, String str2, String str3, MainActivity.MainBackgroundState mainBackgroundState) {
        this.view.setSwitcherMacAddress(str);
        setMainSwitcherImage(IODeviceIconMaker.makeMainIcon(productId, str));
        setInfoIcon(IODeviceIconMaker.makeInfoButtonIcon(productId, str));
        this.view.setSwitcherName(str2);
        this.view.setInfo(str3);
        setState(mainBackgroundState);
    }

    public void setMainSwitcherImage(Drawable drawable) {
        if (drawable != null) {
            this.view.setSwitcherIcon(drawable);
        }
    }

    public void setInfoIcon(Drawable drawable) {
        if (drawable != null) {
            this.view.setInfoIcon(drawable);
        }
    }

    /* JADX INFO: renamed from: kr.switcher.switcherm.ui.main.presenters.MainPresenter$4, reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$kr$switcher$switcherm$ui$main$MainActivity$MainBackgroundState;

        static {
            int[] iArr = new int[MainActivity.MainBackgroundState.values().length];
            $SwitchMap$kr$switcher$switcherm$ui$main$MainActivity$MainBackgroundState = iArr;
            try {
                iArr[MainActivity.MainBackgroundState.NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$kr$switcher$switcherm$ui$main$MainActivity$MainBackgroundState[MainActivity.MainBackgroundState.CONNECTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$kr$switcher$switcherm$ui$main$MainActivity$MainBackgroundState[MainActivity.MainBackgroundState.LOW_BATTERY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$kr$switcher$switcherm$ui$main$MainActivity$MainBackgroundState[MainActivity.MainBackgroundState.DISCONNECTED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$kr$switcher$switcherm$ui$main$MainActivity$MainBackgroundState[MainActivity.MainBackgroundState.PERMISSION.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$kr$switcher$switcherm$ui$main$MainActivity$MainBackgroundState[MainActivity.MainBackgroundState.CONNECTED_LINKER_THING.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$kr$switcher$switcherm$ui$main$MainActivity$MainBackgroundState[MainActivity.MainBackgroundState.CONNECTED_MANUAL_REMOCON.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$kr$switcher$switcherm$ui$main$MainActivity$MainBackgroundState[MainActivity.MainBackgroundState.CONNECTED_CHECKER.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$kr$switcher$switcherm$ui$main$MainActivity$MainBackgroundState[MainActivity.MainBackgroundState.CONNECTED_REMOCON_AIRCON.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$kr$switcher$switcherm$ui$main$MainActivity$MainBackgroundState[MainActivity.MainBackgroundState.CONNECTED_REMOCON_SETTOP.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    public void setState(MainActivity.MainBackgroundState mainBackgroundState) {
        switch (AnonymousClass4.$SwitchMap$kr$switcher$switcherm$ui$main$MainActivity$MainBackgroundState[mainBackgroundState.ordinal()]) {
            case 1:
                this.view.resetTransition();
                this.view.showMenuForDefaultScreen();
                this.view.setNormalComponentRatio();
                break;
            case 2:
                this.view.setNormalTransitionView();
                this.view.showMenuForConnectScreen();
                this.view.setNormalComponentRatio();
                break;
            case 3:
                this.view.setLowBatteryTransitionView();
                this.view.showMenuForConnectScreen();
                this.view.setNormalComponentRatio();
                break;
            case 4:
                this.view.resetTransition();
                this.view.showMenuForConnectScreen();
                this.view.setNormalComponentRatio();
                break;
            case 5:
                this.view.showMenuForPermissionScreen();
                this.view.setNormalComponentRatio();
                break;
            case 6:
                this.view.setNormalTransitionView();
                this.view.showMenuForLinkerThingConnectionScreen();
                this.view.setNormalComponentRatio();
                break;
            case 7:
                this.view.setNormalTransitionView();
                this.view.showMenuForManualRemoconConnectionScreen();
                this.view.setNormalComponentRatio();
                break;
            case 8:
                this.view.setNormalTransitionView();
                this.view.showMenuForManualCheckerConnectionScreen();
                this.view.setNormalComponentRatio();
                break;
            case 9:
                if (LinkerHandler.getInstance().getAliveLinkers().size() > 0) {
                    this.linker = LinkerHandler.getInstance().getAliveLinkers().get(0);
                }
                this.interactor.getCurrentSensorValueListener(this.linker.getMacAddress());
                this.view.setNormalTransitionView();
                this.view.showMenuForAirconRemoconConnectionScreen();
                this.view.setRemoconComponentRatio();
                break;
            case 10:
                if (LinkerHandler.getInstance().getAliveLinkers().size() > 0) {
                    this.linker = LinkerHandler.getInstance().getAliveLinkers().get(0);
                }
                this.view.setNormalTransitionView();
                this.view.showMenuForTVRemoconConnectionScreen();
                this.view.setRemoconComponentRatio();
                break;
        }
    }

    @Override // kr.switcher.switcherm.ui.dialog.ConfirmCallback
    public void onConfirmResult(boolean z) {
        if (z) {
            this.view.moveSettingScreen("ReservationFragment");
        }
    }

    private void sendBroadcast(IODevice iODevice) {
        if (iODevice == null) {
            return;
        }
        if (iODevice.getProductId() == IODevice.ProductId.SWITCHER_TYPE_ONE) {
            this.view.sendBroadcastToOneButtonWidget();
        } else if (iODevice.getProductId() == IODevice.ProductId.SWITCHER_TYPE_TWO) {
            this.view.sendBroadcastToTwoButtonWidget();
        }
    }

    public void onBackPressed() {
        if (LinkerHandler.getInstance().getAllLinkers().size() == 0) {
            this.view.finish();
        } else {
            this.view.callSwitcherListActivity();
        }
    }
}
