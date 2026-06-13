package kr.switcher.switcherm.ui.setting.interactor;

import kr.switcher.device.IODevice;
import kr.switcher.device.switcher.Switcher;
import kr.switcher.device.switcher.SwitcherVersions;
import kr.switcher.device.switcher.interfaces.IODeviceCallbacks;
import kr.switcher.switcherm.device.switcher.handler.SwitcherHandler;
import kr.switcher.switcherm.ui.setting.helper.SettingListUtil;
import kr.switcher.switcherm.user.UserStateManager;

/* JADX INFO: loaded from: classes2.dex */
public class FindSettingInfoInteractor implements IODeviceCallbacks.FirmwareVersionResultCallback {
    private SettingInfoListener listener;

    public interface SettingInfoListener {
        void onFirmwareDownloadLink(String str);

        void onFirmwareVersion(String str, String str2);

        void onIsMain(boolean z);

        void onIsMine(boolean z);

        void onSwitcherName(String str);
    }

    public void setSettingInfoListener(SettingInfoListener settingInfoListener) {
        this.listener = settingInfoListener;
    }

    public void findSettingInfo(String str) {
        Switcher switcher = SwitcherHandler.getInstance().getSwitcher(str);
        if (switcher == null) {
            return;
        }
        getFirmwareVersion(str, this);
        SettingInfoListener settingInfoListener = this.listener;
        if (settingInfoListener != null) {
            settingInfoListener.onIsMine(switcher.isMine());
            this.listener.onSwitcherName(switcher.getName());
            this.listener.onIsMain(SettingListUtil.isMainSwitcher(str, UserStateManager.getInstance().getCurrentUserFromDB().getMainSwitcherCode()));
            this.listener.onFirmwareVersion(switcher.getFirmwareVersion(), SwitcherVersions.LAST_SWITCHER_VERSION);
            setFirmwareDownloadLink(switcher.getProductId());
        }
    }

    /* JADX INFO: renamed from: kr.switcher.switcherm.ui.setting.interactor.FindSettingInfoInteractor$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$kr$switcher$device$IODevice$ProductId;

        static {
            int[] iArr = new int[IODevice.ProductId.values().length];
            $SwitchMap$kr$switcher$device$IODevice$ProductId = iArr;
            try {
                iArr[IODevice.ProductId.SWITCHER_TYPE_ONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$kr$switcher$device$IODevice$ProductId[IODevice.ProductId.SWITCHER_TYPE_TWO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private void setFirmwareDownloadLink(IODevice.ProductId productId) {
        int i = AnonymousClass1.$SwitchMap$kr$switcher$device$IODevice$ProductId[productId.ordinal()];
        if (i == 1) {
            this.listener.onFirmwareDownloadLink(SwitcherVersions.FIRMWARE_DOWNLOAD_LINK_1_SET);
        } else if (i == 2) {
            this.listener.onFirmwareDownloadLink(SwitcherVersions.FIRMWARE_DOWNLOAD_LINK_2_SET);
        } else {
            this.listener.onFirmwareDownloadLink(null);
        }
    }

    private void getFirmwareVersion(String str, IODeviceCallbacks.FirmwareVersionResultCallback firmwareVersionResultCallback) {
        Switcher switcher = SwitcherHandler.getInstance().getSwitcher(str);
        if (switcher != null) {
            switcher.readFirmwareVersion(firmwareVersionResultCallback);
        }
    }

    @Override // kr.switcher.device.switcher.interfaces.IODeviceCallbacks.FirmwareVersionResultCallback
    public void onFirmwareVersion(String str) {
        SettingInfoListener settingInfoListener = this.listener;
        if (settingInfoListener != null) {
            settingInfoListener.onFirmwareVersion(str, SwitcherVersions.LAST_SWITCHER_VERSION);
        }
    }
}
