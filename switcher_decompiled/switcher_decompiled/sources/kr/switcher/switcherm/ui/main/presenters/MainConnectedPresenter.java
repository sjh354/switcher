package kr.switcher.switcherm.ui.main.presenters;

import kr.switcher.device.IODevice;
import kr.switcher.device.switcher.Switcher;
import kr.switcher.device.switcher.ble.SwitcherBLE;
import kr.switcher.device.switcher.interfaces.IODeviceCallbacks;
import kr.switcher.device.switcher.linker.SwitcherLinker;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.device.IODeviceHandler;
import kr.switcher.switcherm.device.switcher.handler.SwitcherHandler;
import kr.switcher.switcherm.preference.MirrorSwitchButtonPreference;
import kr.switcher.switcherm.signal.BatterySignal;
import kr.switcher.switcherm.ui.main.MainActivity;
import kr.switcher.switcherm.ui.main.helper.BatteryInvalidInspector;
import kr.switcher.switcherm.ui.main.helper.BatteryLabelMaker;
import kr.switcher.switcherm.ui.main.views.MainConnectedView;

/* JADX INFO: loaded from: classes2.dex */
public class MainConnectedPresenter implements IODeviceCallbacks.OnControlResponseListener {
    private static final String TAG = "MainConnectedPresenter";
    private MainConnectedView view;
    private BatteryLabelMaker batteryLabelMaker = new BatteryLabelMaker();
    private BatteryInvalidInspector batteryInvalidInspector = new BatteryInvalidInspector(SwitcherHandler.getInstance());

    public MainConnectedPresenter(MainConnectedView mainConnectedView) {
        this.view = mainConnectedView;
    }

    public void initialize(String str, IODevice.ProductId productId, int i) {
        this.view.trackConnectedForGA();
        this.view.trackConnectingTimeForGA();
        this.view.hideProgressbar();
        setIconStyle(str);
        setSwitcherType(productId);
        viewData(SwitcherHandler.getInstance().getSwitcher(str));
        if (BatterySignal.battery(str, i)) {
            this.view.showLowBatteryDialogView(i);
        }
    }

    public void onResume(String str, IODevice.ProductId productId, int i) {
        setIconStyle(str);
        setSwitcherType(productId);
        viewData(SwitcherHandler.getInstance().getSwitcher(str));
        if (BatterySignal.battery(str, i)) {
            this.view.showLowBatteryDialogView(i);
        }
    }

    private void viewData(Switcher switcher) {
        if (switcher == null) {
            return;
        }
        String strMakeBatteryLabel = this.batteryLabelMaker.makeBatteryLabel(this.batteryInvalidInspector.getFixedBatteryValue(switcher.getMacAddress(), switcher.getBattery()));
        MainActivity.MainBackgroundState mainBackgroundState = MainActivity.MainBackgroundState.CONNECTED;
        if (strMakeBatteryLabel.equals(BatteryLabelMaker.BATTERY_LOW)) {
            mainBackgroundState = MainActivity.MainBackgroundState.LOW_BATTERY;
        }
        if (switcher.getClass().equals(SwitcherLinker.class)) {
            mainBackgroundState = MainActivity.MainBackgroundState.CONNECTED_LINKER_THING;
        }
        this.view.sendMainData(switcher.getMacAddress(), switcher.getProductId(), switcher.getName(), strMakeBatteryLabel, mainBackgroundState);
    }

    private void setIconStyle(String str) {
        if (IODeviceHandler.getInstance().getDevice(str).getClass().equals(SwitcherLinker.class)) {
            this.view.setGatewayIcon();
        } else if (IODeviceHandler.getInstance().getDevice(str).getClass().equals(SwitcherBLE.class)) {
            this.view.setBluetoothIcon();
        }
    }

    public void setSwitcherType(IODevice.ProductId productId) {
        boolean mirrorSwitchButtonChecked = new MirrorSwitchButtonPreference().getMirrorSwitchButtonChecked();
        if (productId == IODevice.ProductId.SWITCHER_TYPE_ONE && mirrorSwitchButtonChecked) {
            this.view.showOneSetView();
            this.view.hideTwoSetView();
            this.view.showChangedOneButtonImage();
            return;
        }
        if (productId == IODevice.ProductId.SWITCHER_TYPE_ONE && !mirrorSwitchButtonChecked) {
            this.view.showOneSetView();
            this.view.hideTwoSetView();
            this.view.showNormalOneButtonImage();
            return;
        }
        if (productId == IODevice.ProductId.SWITCHER_TYPE_TWO && mirrorSwitchButtonChecked) {
            this.view.showTwoSetView();
            this.view.hideOneSetView();
            this.view.showChangedTwoButtonImage();
        } else if (productId == IODevice.ProductId.SWITCHER_TYPE_TWO && !mirrorSwitchButtonChecked) {
            this.view.showTwoSetView();
            this.view.hideOneSetView();
            this.view.showNormalTwoButtonImage();
        } else {
            this.view.hideOneSetView();
            this.view.hideTwoSetView();
            this.view.showErrorMessage(IOUtil.getStringResource(R.string.not_support_type));
        }
    }

    public void onOneSetOffButtonTouched(int i) {
        if (i == 0) {
            this.view.showOneSetOffSwitchPressed();
            this.view.showOneSetOnSwitchSpring();
        } else {
            if (i != 1) {
                return;
            }
            showProgressbar();
            this.view.showOneSetOffSwitchDefault();
            this.view.showOneSetOnSwitchDefault();
            this.view.onOneSetOff();
            this.view.trackLightingOneSetOff();
        }
    }

    public void onOneSetOnButtonTouched(int i) {
        if (i == 0) {
            this.view.showOneSetOnSwitchPressed();
            this.view.showOneSetOffSwitchSpring();
        } else {
            if (i != 1) {
                return;
            }
            showProgressbar();
            this.view.showOneSetOnSwitchDefault();
            this.view.showOneSetOffSwitchDefault();
            this.view.onOneSetOn();
            this.view.trackLightingOneSetOn();
        }
    }

    public void onTwoSetTopOffButtonTouched(int i) {
        if (i == 0) {
            this.view.showTwoSetTopOffSwitchPressed();
            this.view.showTwoSetTopOnSwitchSpring();
        } else {
            if (i != 1) {
                return;
            }
            showProgressbar();
            this.view.showTwoSetTopOffSwitchDefault();
            this.view.showTwoSetTopOnSwitchDefault();
            this.view.onTwoSetOneOff();
            this.view.trackLightingTwoSetOneOff();
        }
    }

    public void onTwoSetTopOnButtonTouched(int i) {
        if (i == 0) {
            this.view.showTwoSetTopOffSwitchSpring();
            this.view.showTwoSetTopOnSwitchPressed();
        } else {
            if (i != 1) {
                return;
            }
            showProgressbar();
            this.view.showTwoSetTopOffSwitchDefault();
            this.view.showTwoSetTopOnSwitchDefault();
            this.view.onTwoSetOneOn();
            this.view.trackLightingTwoSetOneOn();
        }
    }

    public void onTwoSetBottomOffButtonTouched(int i) {
        if (i == 0) {
            this.view.showTwoSetBottomOffSwitchPressed();
            this.view.showTwoSetBottomOnSwitchSpring();
        } else {
            if (i != 1) {
                return;
            }
            showProgressbar();
            this.view.showTwoSetBottomOffSwitchDefault();
            this.view.showTwoSetBottomOnSwitchDefault();
            this.view.onTwoSetTwoOff();
            this.view.trackLightingTwoSetTwoOff();
        }
    }

    public void onTwoSetBottomOnButtonTouched(int i) {
        if (i == 0) {
            this.view.showTwoSetBottomOffSwitchSpring();
            this.view.showTwoSetBottomOnSwitchPressed();
        } else {
            if (i != 1) {
                return;
            }
            showProgressbar();
            this.view.showTwoSetBottomOffSwitchDefault();
            this.view.showTwoSetBottomOnSwitchDefault();
            this.view.onTwoSetTwoOn();
            this.view.trackLightingTwoSetTwoOn();
        }
    }

    public void showProgressbar() {
        this.view.showProgressbar();
    }

    @Override // kr.switcher.device.switcher.interfaces.IODeviceCallbacks.OnControlResponseListener
    public void onControlResult(boolean z) {
        this.view.hideProgressbar();
        if (z) {
            return;
        }
        this.view.showErrorMessage("스위처 제어에 실패했습니다. 링커 연결을 확인해주세요.");
    }

    public void onDestroyView() {
        this.view.hideProgressbar();
    }
}
