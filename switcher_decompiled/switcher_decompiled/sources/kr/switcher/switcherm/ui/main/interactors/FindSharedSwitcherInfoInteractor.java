package kr.switcher.switcherm.ui.main.interactors;

import kr.switcher.device.IODevice;
import kr.switcher.device.switcher.Switcher;
import kr.switcher.device.switcher.ble.ScannedBLESwitcher;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.device.IODeviceHandler;
import kr.switcher.switcherm.network.http.RestSwitcherAPIStore;
import kr.switcher.switcherm.network.http.response.HttpAPIResponse;
import kr.switcher.switcherm.network.http.response.HttpResponseHandler;
import kr.switcher.switcherm.preference.OAuthToken;
import kr.switcher.switcherm.ui.main.helper.SwitcherInfoValidator;

/* JADX INFO: loaded from: classes2.dex */
public class FindSharedSwitcherInfoInteractor {
    private static final String TAG = "FindSharedSwitcherInfoInteractor";
    private String macAddress;
    private SwitcherInfoValidator validator = new SwitcherInfoValidator();

    public interface OnGetSharedSwitcherOwnerListener {
        void onGetOwnerResult(String str);
    }

    public interface OnGetSharedSwitcherShareCodeListener {
        void onGetShareCodeResult(Boolean bool, String str);
    }

    public interface OnRequestShareCodeResultListener {
        void onRequestResult(boolean z);
    }

    public FindSharedSwitcherInfoInteractor(String str) {
        this.macAddress = str;
    }

    public void getOwner(final OnGetSharedSwitcherOwnerListener onGetSharedSwitcherOwnerListener) {
        IODeviceHandler.getInstance().createDeviceByMacAddress(this.macAddress, false, new IODeviceHandler.OnCreateIODeviceListener() { // from class: kr.switcher.switcherm.ui.main.interactors.FindSharedSwitcherInfoInteractor.1
            @Override // kr.switcher.switcherm.device.IODeviceHandler.OnCreateIODeviceListener
            public void onFailure(String str, String str2) {
            }

            @Override // kr.switcher.switcherm.device.IODeviceHandler.OnCreateIODeviceListener
            public void onSuccess(IODevice iODevice) {
                FindSharedSwitcherInfoInteractor.this.returnOwnerResult((Switcher) iODevice, onGetSharedSwitcherOwnerListener);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void returnOwnerResult(Switcher switcher, OnGetSharedSwitcherOwnerListener onGetSharedSwitcherOwnerListener) {
        if (!this.validator.checkIsSwitcherOwner(switcher)) {
            onGetSharedSwitcherOwnerListener.onGetOwnerResult("unknown");
        } else {
            onGetSharedSwitcherOwnerListener.onGetOwnerResult(switcher.getOwner());
        }
    }

    public void requestGuestDevice(String str, final String str2, final OnGetSharedSwitcherShareCodeListener onGetSharedSwitcherShareCodeListener) {
        RestSwitcherAPIStore.requestPostGuestDevice(str, str2, new HttpResponseHandler() { // from class: kr.switcher.switcherm.ui.main.interactors.FindSharedSwitcherInfoInteractor.2
            @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
            public void onSuccess(HttpAPIResponse httpAPIResponse) {
                try {
                    onGetSharedSwitcherShareCodeListener.onGetShareCodeResult(true, str2);
                } catch (NullPointerException e) {
                    IOLog.error(FindSharedSwitcherInfoInteractor.TAG, new OAuthToken().getOAuthToken(), "getHashingCode - onSuccess", e);
                }
            }

            @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
            public void onFailure(String str3, String str4) {
                IOLog.error(FindSharedSwitcherInfoInteractor.TAG, new OAuthToken().getOAuthToken(), "requestGetHashingKey", new Exception("code:" + str3 + ", message:" + str4));
                onGetSharedSwitcherShareCodeListener.onGetShareCodeResult(false, null);
            }
        });
    }

    public void requestShareCode(String str, final OnRequestShareCodeResultListener onRequestShareCodeResultListener) {
        RestSwitcherAPIStore.requestGetShareCodeOwner(str, new HttpResponseHandler() { // from class: kr.switcher.switcherm.ui.main.interactors.FindSharedSwitcherInfoInteractor.3
            @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
            public void onSuccess(HttpAPIResponse httpAPIResponse) {
                onRequestShareCodeResultListener.onRequestResult(true);
            }

            @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
            public void onFailure(String str2, String str3) {
                IOLog.error(FindSharedSwitcherInfoInteractor.TAG, new OAuthToken().getOAuthToken(), "requestShareCode", new Exception("code:" + str2 + ", message:" + str3));
                onRequestShareCodeResultListener.onRequestResult(false);
            }
        });
    }

    public void createSharedSwitcher(final ScannedBLESwitcher scannedBLESwitcher) {
        IODeviceHandler.getInstance().createDeviceByMacAddress(this.macAddress, false, new IODeviceHandler.OnCreateIODeviceListener() { // from class: kr.switcher.switcherm.ui.main.interactors.FindSharedSwitcherInfoInteractor.4
            @Override // kr.switcher.switcherm.device.IODeviceHandler.OnCreateIODeviceListener
            public void onFailure(String str, String str2) {
            }

            @Override // kr.switcher.switcherm.device.IODeviceHandler.OnCreateIODeviceListener
            public void onSuccess(IODevice iODevice) {
                ((Switcher) iODevice).attachToDevice(scannedBLESwitcher);
            }
        });
    }
}
