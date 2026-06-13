package kr.switcher.switcherm.ui.main.presenters;

import kr.switcher.device.common.DeviceUtil;
import kr.switcher.device.switcher.ble.ScannedBLESwitcher;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.ui.main.MainActivity;
import kr.switcher.switcherm.ui.main.interactors.FindSharedSwitcherInfoInteractor;
import kr.switcher.switcherm.ui.main.views.MainShareCodeView;

/* JADX INFO: loaded from: classes2.dex */
public class MainShareCodePresenter implements FindSharedSwitcherInfoInteractor.OnGetSharedSwitcherOwnerListener, FindSharedSwitcherInfoInteractor.OnGetSharedSwitcherShareCodeListener, FindSharedSwitcherInfoInteractor.OnRequestShareCodeResultListener {
    public static final String OWNER_EMPTY = "";
    public static final String OWNER_UNKNOWN = "unknown";
    private FindSharedSwitcherInfoInteractor interactor;
    private MainShareCodeView view;

    public MainShareCodePresenter(MainShareCodeView mainShareCodeView, FindSharedSwitcherInfoInteractor findSharedSwitcherInfoInteractor) {
        this.view = mainShareCodeView;
        this.interactor = findSharedSwitcherInfoInteractor;
    }

    public void initialize(ScannedBLESwitcher scannedBLESwitcher) {
        this.view.trackCodeForGA();
        this.view.showProgressbar();
        this.view.clearLinearLayout();
        this.view.showDefaultView();
        this.view.sendMainData(scannedBLESwitcher.getDevice().getAddress(), DeviceUtil.convertProductId(scannedBLESwitcher.getAdvertisementPacket().getSwitcherType()), DeviceUtil.getDefaultDeviceName(DeviceUtil.convertProductId(scannedBLESwitcher.getAdvertisementPacket().getSwitcherType())), IOUtil.getStringResource(R.string.serial_number) + scannedBLESwitcher.getAdvertisementPacket().getSerialNumber(), MainActivity.MainBackgroundState.NORMAL);
        this.interactor.getOwner(this);
        this.interactor.createSharedSwitcher(scannedBLESwitcher);
    }

    public void checkInternet() {
        this.view.showProgressbar();
        onCheckInternetResult(IOUtil.isConnectedInternet());
    }

    public void onCheckInternetResult(boolean z) {
        this.view.hideProgressbar();
        if (z) {
            this.view.initialize();
            return;
        }
        this.view.showNoInternetDialog();
        this.view.clearLinearLayout();
        this.view.showNoInternetView();
        this.view.trackNoWifiForGA();
    }

    public void onInputShareCodeButtonClicked(String str, String str2) {
        if (!IOUtil.checkIsIODeviceKey(str)) {
            this.view.showErrorMessage(IOUtil.getStringResource(R.string.etc_error) + " (invalid mac address)");
        } else if (str2.length() != 4) {
            this.view.showErrorMessage(IOUtil.getStringResource(R.string.enter_four_digit_message));
        } else {
            this.view.showProgressbar();
            this.interactor.requestGuestDevice(str, str2, this);
        }
    }

    public void onEditorAction(int i, String str, String str2) {
        if (i == 6) {
            onInputShareCodeButtonClicked(str, str2);
        }
    }

    public void onRequestShareCodeButtonClicked(String str) {
        this.view.showProgressbar();
        this.interactor.requestShareCode(str, this);
        this.view.requestShareCodeEventForGA();
    }

    public void onRefreshInternetStatusButtonClicked() {
        checkInternet();
    }

    public void dismissSuccessDialog() {
        this.view.clearLinearLayout();
        this.view.showRequestedView();
        this.view.trackRequestedForGA();
    }

    @Override // kr.switcher.switcherm.ui.main.interactors.FindSharedSwitcherInfoInteractor.OnGetSharedSwitcherOwnerListener
    public void onGetOwnerResult(String str) {
        this.view.hideProgressbar();
        this.view.clearLinearLayout();
        if (!"unknown".equals(str)) {
            this.view.showCodeView(str);
        } else {
            this.view.showUnknownView();
        }
    }

    @Override // kr.switcher.switcherm.ui.main.interactors.FindSharedSwitcherInfoInteractor.OnGetSharedSwitcherShareCodeListener
    public void onGetShareCodeResult(Boolean bool, String str) {
        if (!bool.booleanValue()) {
            this.view.hideProgressbar();
            return;
        }
        this.view.saveShareCodeToDB(str);
        this.view.moveConnectingScreen();
        this.view.finishJob(str);
    }

    @Override // kr.switcher.switcherm.ui.main.interactors.FindSharedSwitcherInfoInteractor.OnRequestShareCodeResultListener
    public void onRequestResult(boolean z) {
        if (z) {
            this.view.hideProgressbar();
            this.view.showSuccessDialog();
            this.view.trackSuccessForGA();
        } else {
            this.view.hideProgressbar();
            this.view.showFailureDialog();
            this.view.trackFailForGA();
        }
    }
}
