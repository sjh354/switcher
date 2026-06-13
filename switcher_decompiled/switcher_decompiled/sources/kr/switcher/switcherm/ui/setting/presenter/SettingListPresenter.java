package kr.switcher.switcherm.ui.setting.presenter;

import kr.switcher.device.IODevice;
import kr.switcher.device.checker.Checker;
import kr.switcher.device.switcher.SwitcherVersions;
import kr.switcher.device.switcher.linker.SwitcherLinker;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.preference.MirrorSwitchButtonPreference;
import kr.switcher.switcherm.ui.setting.interactor.FindSettingInfoInteractor;
import kr.switcher.switcherm.ui.setting.view.SettingListView;

/* JADX INFO: loaded from: classes2.dex */
public class SettingListPresenter implements FindSettingInfoInteractor.SettingInfoListener {
    public static final String EMPTY_MAC_ADDRESS = "";
    private FindSettingInfoInteractor interactor;
    private SettingListView view;

    public SettingListPresenter(SettingListView settingListView, FindSettingInfoInteractor findSettingInfoInteractor) {
        this.view = settingListView;
        this.interactor = findSettingInfoInteractor;
        findSettingInfoInteractor.setSettingInfoListener(this);
    }

    public void initialize(IODevice iODevice) {
        if (iODevice.getClass().equals(Checker.class)) {
            this.view.setCheckerSettingMenu();
        } else if (iODevice.getClass().equals(SwitcherLinker.class)) {
            this.view.hideFirmwareMenu();
            this.view.showFirmwareVersion();
            this.view.setFirmwareLastVersion();
        }
        this.interactor.findSettingInfo(iODevice.getMacAddress());
        initIsMirrorSwitchButton();
    }

    public void onPause() {
        this.view.updateDevicerName();
    }

    public void onMainSwitcherButtonClicked(String str, boolean z) {
        if (!z) {
            this.view.setMainSwitcherMacAddress("");
        } else {
            this.view.setMainSwitcherMacAddress(str);
        }
        this.view.setCheckedMain(z);
    }

    public void onMirrorButtonClicked(String str, boolean z) {
        new MirrorSwitchButtonPreference().setMirrorSwitchButtonPreference(z);
        this.view.setMirrorSwitchButton(Boolean.valueOf(z));
        this.view.setCheckedMirror(z);
    }

    public void initIsMirrorSwitchButton() {
        this.view.setCheckedMirror(new MirrorSwitchButtonPreference().getMirrorSwitchButtonChecked());
    }

    @Override // kr.switcher.switcherm.ui.setting.interactor.FindSettingInfoInteractor.SettingInfoListener
    public void onIsMine(boolean z) {
        if (z) {
            this.view.trackSettingMineForGA();
            this.view.showMine();
        } else {
            this.view.trackSettingOtherForGA();
            this.view.showOther();
        }
    }

    @Override // kr.switcher.switcherm.ui.setting.interactor.FindSettingInfoInteractor.SettingInfoListener
    public void onSwitcherName(String str) {
        this.view.setRoomName(str);
    }

    @Override // kr.switcher.switcherm.ui.setting.interactor.FindSettingInfoInteractor.SettingInfoListener
    public void onIsMain(boolean z) {
        this.view.setCheckedMain(z);
    }

    @Override // kr.switcher.switcherm.ui.setting.interactor.FindSettingInfoInteractor.SettingInfoListener
    public void onFirmwareVersion(String str, String str2) {
        if (new SwitcherVersions().isHigherOrEqualThanLastVersion(str)) {
            this.view.showFirmwareVersion();
        } else {
            this.view.showFirmwareNew();
        }
        this.view.setFirmwareVersion(str);
    }

    @Override // kr.switcher.switcherm.ui.setting.interactor.FindSettingInfoInteractor.SettingInfoListener
    public void onFirmwareDownloadLink(String str) {
        if (str != null) {
            this.view.setFirmwareDownloadLink(str);
        } else {
            this.view.setFirmwareVersion(IOUtil.getStringResource(R.string.unavailable));
            this.view.showFirmwareVersion();
        }
    }
}
