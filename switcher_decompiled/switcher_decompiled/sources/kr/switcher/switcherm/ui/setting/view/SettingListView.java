package kr.switcher.switcherm.ui.setting.view;

/* JADX INFO: loaded from: classes2.dex */
public interface SettingListView {
    void hideFirmwareMenu();

    void setCheckedMain(boolean z);

    void setCheckedMirror(boolean z);

    void setCheckerSettingMenu();

    void setFirmwareDownloadLink(String str);

    void setFirmwareLastVersion();

    void setFirmwareVersion(String str);

    void setMainSwitcherMacAddress(String str);

    void setMirrorSwitchButton(Boolean bool);

    void setRoomName(String str);

    void showFirmwareNew();

    void showFirmwareVersion();

    void showMine();

    void showOther();

    void trackSettingMineForGA();

    void trackSettingOtherForGA();

    void updateDevicerName();
}
