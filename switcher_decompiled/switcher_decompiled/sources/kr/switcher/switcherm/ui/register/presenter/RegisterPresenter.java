package kr.switcher.switcherm.ui.register.presenter;

import kr.switcher.device.IODevice;
import kr.switcher.device.switcher.interfaces.IODeviceCallbacks;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.device.IODeviceHandler;
import kr.switcher.switcherm.ui.register.interactor.SwitcherRegisterInteractor;
import kr.switcher.switcherm.ui.register.view.RegisterView;
import kr.switcher.switcherm.user.User;

/* JADX INFO: loaded from: classes2.dex */
public class RegisterPresenter implements SwitcherRegisterInteractor.OnRegisterResultListener, SwitcherRegisterInteractor.OnFirmwareInitializeListener, IODeviceCallbacks.OnDeviceConnectListener, SwitcherRegisterInteractor.OnUserInfoListener {
    private SwitcherRegisterInteractor interactor;
    private RegisterView view;

    @Override // kr.switcher.device.switcher.interfaces.IODeviceCallbacks.OnDeviceConnectListener
    public void onConnected(IODevice iODevice) {
    }

    public RegisterPresenter(RegisterView registerView, SwitcherRegisterInteractor switcherRegisterInteractor) {
        this.view = registerView;
        this.interactor = switcherRegisterInteractor;
        switcherRegisterInteractor.setOnRegisterResultListener(this);
        this.interactor.setOnFirmwareInitializeListener(this);
        this.interactor.setOnUserInfoListener(this);
    }

    public void initialize(IODevice iODevice, User user) {
        iODevice.setSwitcherConnectListener(this);
        this.view.trackRegisterForGA();
        this.view.hideProgressbar();
        this.view.setProductionNumber(iODevice.getSerialNumber());
        setOwnerName(user.getUserName());
        this.view.inactiveRegisterButton();
        if (iODevice.getProductId().equals(IODevice.ProductId.SWITCHER_TYPE_ONE)) {
            this.view.setSwitcherTypeOneSet();
        } else if (iODevice.getProductId().equals(IODevice.ProductId.SWITCHER_TYPE_TWO)) {
            this.view.setSwitcherTypeTwoSet();
        } else if (iODevice.getProductId().equals(IODevice.ProductId.LINKER)) {
            this.view.setLinkerType();
        } else if (iODevice.getProductId().equals(IODevice.ProductId.CHECKER)) {
            this.view.setCheckerType();
        }
        this.view.initializeHashingCode(iODevice.getMacAddress());
    }

    private void setOwnerName(String str) {
        if (str == null || str.length() < 1 || str.equalsIgnoreCase(IOUtil.getStringResource(R.string.default_user_name))) {
            this.view.editableOwnerName();
        } else {
            this.view.setOwnerName(str);
            this.view.uneditableOwnerName();
        }
    }

    public void onCancelButtonClicked() {
        this.view.moveSwitcherListScreen();
        this.interactor.disconnectSwitcher();
        this.interactor.removeDevice();
    }

    public void onRegisterButtonClicked(String str, String str2) {
        if (!checkIsValidData(str, str2)) {
            warning();
        } else {
            this.view.showProgressbar(10000);
            this.interactor.register(str);
        }
    }

    private void warning() {
        this.view.showWarningDialog();
        this.view.trackWarningForGA();
    }

    @Override // kr.switcher.switcherm.ui.register.interactor.SwitcherRegisterInteractor.OnRegisterResultListener
    public void onResult(boolean z, String str) {
        if (z) {
            this.interactor.initializeFirmware();
        } else {
            this.view.hideProgressbar();
            this.view.showErrorMessage(IOUtil.getStringResource(R.string.failed_register_switcher));
        }
    }

    @Override // kr.switcher.switcherm.ui.register.interactor.SwitcherRegisterInteractor.OnFirmwareInitializeListener
    public void onInitializeFirmwareComplete() {
        this.interactor.getUserInfo();
    }

    @Override // kr.switcher.switcherm.ui.register.interactor.SwitcherRegisterInteractor.OnUserInfoListener
    public void onUserInfoComplete(boolean z, String str) {
        this.view.hideProgressbar();
        if (!z) {
            this.view.showErrorMessage(IOUtil.getStringResource(R.string.not_found_user));
        }
        this.view.updateSwitcherName();
        IODevice device = IODeviceHandler.getInstance().getDevice(str);
        if (device.getProductId().equals(IODevice.ProductId.LINKER) || device.getProductId().equals(IODevice.ProductId.CHECKER)) {
            this.view.moveWifiSettingScreen(device);
        } else {
            this.view.moveMainConnectedScreen(str);
            this.interactor.disconnectSwitcher();
        }
    }

    @Override // kr.switcher.device.switcher.interfaces.IODeviceCallbacks.OnDeviceConnectListener
    public void onDisconnected(String str, int i) {
        this.view.moveSwitcherListScreen();
    }

    public void onTextChanged(String str, String str2) {
        if (!checkIsValidData(str, str2)) {
            this.view.inactiveRegisterButton();
        } else {
            this.view.activeRegisterButton();
        }
    }

    private boolean checkIsValidData(String str, String str2) {
        return str != null && str.length() >= 1 && str2 != null && str2.length() >= 1;
    }
}
