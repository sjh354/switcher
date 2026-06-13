package kr.switcher.switcherm.ui.register.interactor;

import java.util.ArrayList;
import kr.switcher.device.IODevice;
import kr.switcher.device.switcher.Switcher;
import kr.switcher.device.switcher.interfaces.IODeviceCallbacks;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.device.IODeviceHandler;
import kr.switcher.switcherm.device.switcher.handler.SwitcherDBProvider;
import kr.switcher.switcherm.network.http.RestSwitcherAPIStore;
import kr.switcher.switcherm.network.http.response.HttpAPIResponse;
import kr.switcher.switcherm.network.http.response.HttpResponseHandler;
import kr.switcher.switcherm.preference.OAuthToken;
import kr.switcher.switcherm.user.User;
import kr.switcher.switcherm.user.UserStateManager;

/* JADX INFO: loaded from: classes2.dex */
public class SwitcherRegisterInteractor extends HttpResponseHandler implements IODeviceCallbacks.ReservationUpdateResultCallback, IODeviceCallbacks.StrokeLevelUpdateResultResponseCallback {
    private static final String TAG = "SwitcherRegisterInteractor";
    private int count = 0;
    private OnFirmwareInitializeListener initializeListener;
    private IODevice ioDevice;
    private OnRegisterResultListener registerResultListener;
    private OnUserInfoListener userInfoListener;

    public interface OnFirmwareInitializeListener {
        void onInitializeFirmwareComplete();
    }

    public interface OnRegisterResultListener {
        void onResult(boolean z, String str);
    }

    public interface OnUserInfoListener {
        void onUserInfoComplete(boolean z, String str);
    }

    public SwitcherRegisterInteractor(IODevice iODevice) {
        this.ioDevice = iODevice;
    }

    public void setOnRegisterResultListener(OnRegisterResultListener onRegisterResultListener) {
        this.registerResultListener = onRegisterResultListener;
    }

    public void setOnFirmwareInitializeListener(OnFirmwareInitializeListener onFirmwareInitializeListener) {
        this.initializeListener = onFirmwareInitializeListener;
    }

    public void setOnUserInfoListener(OnUserInfoListener onUserInfoListener) {
        this.userInfoListener = onUserInfoListener;
    }

    public void register(String str) {
        RestSwitcherAPIStore.requestPostRegisterSwitcher(this.ioDevice.getMacAddress(), str, this);
    }

    public void requestSwitcher() {
        IODeviceHandler.getInstance().createDeviceByMacAddress(this.ioDevice.getMacAddress(), true, new IODeviceHandler.OnCreateIODeviceListener() { // from class: kr.switcher.switcherm.ui.register.interactor.SwitcherRegisterInteractor.1
            @Override // kr.switcher.switcherm.device.IODeviceHandler.OnCreateIODeviceListener
            public void onFailure(String str, String str2) {
            }

            @Override // kr.switcher.switcherm.device.IODeviceHandler.OnCreateIODeviceListener
            public void onSuccess(IODevice iODevice) {
                SwitcherRegisterInteractor.this.ioDevice.setOwner(iODevice.getOwner());
                SwitcherRegisterInteractor.this.ioDevice.setSerialNumber(iODevice.getSerialNumber());
                SwitcherRegisterInteractor.this.ioDevice.setShareCode(iODevice.getShareCode());
                SwitcherRegisterInteractor.this.registerResultListener.onResult(true, SwitcherRegisterInteractor.this.ioDevice.getMacAddress());
            }
        });
    }

    public void disconnectSwitcher() {
        this.ioDevice.setSwitcherConnectListener(null);
        this.ioDevice.disconnect();
    }

    @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
    public void onSuccess(HttpAPIResponse httpAPIResponse) {
        requestSwitcher();
    }

    @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
    public void onFailure(String str, String str2) {
        IOLog.error(TAG, new OAuthToken().getOAuthToken(), "requestPostRegisterSwitcher", new Exception("code:" + str + ", message:" + str2));
        this.registerResultListener.onResult(false, this.ioDevice.getMacAddress());
    }

    @Override // kr.switcher.device.switcher.interfaces.IODeviceCallbacks.StrokeLevelUpdateResultResponseCallback
    public void onStrokeLevelResult(boolean z) {
        initializeReservation((Switcher) this.ioDevice);
    }

    public void initializeFirmware() {
        if (this.ioDevice.getProductId().equals(IODevice.ProductId.SWITCHER_TYPE_ONE) || this.ioDevice.getProductId().equals(IODevice.ProductId.SWITCHER_TYPE_TWO)) {
            initializeStrokeLevel((Switcher) this.ioDevice);
        } else {
            this.initializeListener.onInitializeFirmwareComplete();
        }
    }

    private void initializeStrokeLevel(Switcher switcher) {
        switcher.updateStrokeLevel(1, false, this);
    }

    private void initializeReservation(Switcher switcher) {
        int i = this.count;
        if (i < 10) {
            switcher.removeReservation(i, this);
            this.count++;
            return;
        }
        new SwitcherDBProvider().updateSwitcherReservationListToDB(switcher.getMacAddress(), new ArrayList());
        OnFirmwareInitializeListener onFirmwareInitializeListener = this.initializeListener;
        if (onFirmwareInitializeListener != null) {
            onFirmwareInitializeListener.onInitializeFirmwareComplete();
        }
    }

    public void removeDevice() {
        IODeviceHandler.getInstance().removeDevice(this.ioDevice);
    }

    @Override // kr.switcher.device.switcher.interfaces.IODeviceCallbacks.ReservationUpdateResultCallback
    public void onUpdatedReservation(boolean z) {
        if (z) {
            initializeReservation((Switcher) this.ioDevice);
        }
    }

    public void getUserInfo() {
        UserStateManager.getInstance().requestGetCustomerMeToRestServer(new UserStateManager.UserRestResponseCallback() { // from class: kr.switcher.switcherm.ui.register.interactor.SwitcherRegisterInteractor.2
            @Override // kr.switcher.switcherm.user.UserStateManager.UserRestResponseCallback
            public void onUserInfo(User user) {
                SwitcherRegisterInteractor.this.userInfoListener.onUserInfoComplete(user != null, SwitcherRegisterInteractor.this.ioDevice.getMacAddress());
            }
        });
    }
}
