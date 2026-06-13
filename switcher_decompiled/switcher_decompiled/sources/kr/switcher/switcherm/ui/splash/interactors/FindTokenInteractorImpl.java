package kr.switcher.switcherm.ui.splash.interactors;

import android.os.Handler;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.device.IODeviceHandler;
import kr.switcher.switcherm.network.http.RestErrorCode;
import kr.switcher.switcherm.network.http.RestSwitcherAPIStore;
import kr.switcher.switcherm.network.http.response.HttpAPIResponse;
import kr.switcher.switcherm.network.http.response.HttpResponseHandler;
import kr.switcher.switcherm.preference.LoginUser;
import kr.switcher.switcherm.preference.OAuthToken;
import kr.switcher.switcherm.ui.splash.interactors.FindTokenInteractor;
import kr.switcher.switcherm.user.User;
import kr.switcher.switcherm.user.UserStateManager;
import no.nordicsemi.android.dfu.internal.scanner.BootloaderScanner;

/* JADX INFO: loaded from: classes2.dex */
public class FindTokenInteractorImpl implements FindTokenInteractor {
    private static final int SERVER_RESPONSE_TIME_OUT = 5000;
    private static final String TAG = "FindTokenInteractorImpl";
    private boolean isHere;
    private Handler serverTimeoutHandler;
    private Runnable serverTimeoutRunnable;

    @Override // kr.switcher.switcherm.ui.splash.interactors.FindTokenInteractor
    public void findIsToken(final FindTokenInteractor.OnFinishedListener onFinishedListener) {
        this.isHere = true;
        final UserStateManager userStateManager = UserStateManager.getInstance();
        this.serverTimeoutHandler = new Handler();
        this.serverTimeoutRunnable = new Runnable() { // from class: kr.switcher.switcherm.ui.splash.interactors.FindTokenInteractorImpl.1
            @Override // java.lang.Runnable
            public void run() {
                IOLog.i(FindTokenInteractorImpl.TAG, "server response timeout. will move other activity");
                FindTokenInteractorImpl.this.finish(onFinishedListener, userStateManager.isAuthUser());
            }
        };
        if (!userStateManager.isAuthUser()) {
            finish(onFinishedListener, false);
            return;
        }
        LoginUser loginUser = new LoginUser();
        if (!loginUser.getMigration()) {
            requestMigration(loginUser.getPhoneNumber(), onFinishedListener);
            return;
        }
        if (userStateManager.getCurrentUserFromDB() == null) {
            UserStateManager.getInstance().requestGetCustomerMeToRestServer(new UserStateManager.UserRestResponseCallback() { // from class: kr.switcher.switcherm.ui.splash.interactors.FindTokenInteractorImpl.2
                @Override // kr.switcher.switcherm.user.UserStateManager.UserRestResponseCallback
                public void onUserInfo(User user) {
                    IOLog.i(FindTokenInteractorImpl.TAG, "user name : " + user.getUserName() + ", phone number : " + user.getPhoneNumber());
                }
            });
        }
        IODeviceHandler.getInstance().createIODevices(new IODeviceHandler.OnCreateResultListener() { // from class: kr.switcher.switcherm.ui.splash.interactors.FindTokenInteractorImpl.3
            @Override // kr.switcher.switcherm.device.IODeviceHandler.OnCreateResultListener
            public void onResult(String str, String str2) {
                if (str.equals("success")) {
                    FindTokenInteractorImpl.this.finish(onFinishedListener, true);
                } else if (str.equals(RestErrorCode.UNAUTHORIZED)) {
                    UserStateManager.getInstance().setAuthToken(null);
                    FindTokenInteractorImpl.this.finish(onFinishedListener, false);
                    IOUtil.showToast(str + " " + str2);
                }
            }
        });
        this.serverTimeoutHandler.postDelayed(this.serverTimeoutRunnable, BootloaderScanner.TIMEOUT);
    }

    @Override // kr.switcher.switcherm.ui.splash.interactors.FindTokenInteractor
    public void requestMigration(String str, final FindTokenInteractor.OnFinishedListener onFinishedListener) {
        IOLog.d(TAG, "requestMigration");
        RestSwitcherAPIStore.requestPostMigration(str, new HttpResponseHandler() { // from class: kr.switcher.switcherm.ui.splash.interactors.FindTokenInteractorImpl.4
            @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
            public void onSuccess(HttpAPIResponse httpAPIResponse) {
                UserStateManager.getInstance().requestGetCustomerMeToRestServer(new UserStateManager.UserRestResponseCallback() { // from class: kr.switcher.switcherm.ui.splash.interactors.FindTokenInteractorImpl.4.1
                    @Override // kr.switcher.switcherm.user.UserStateManager.UserRestResponseCallback
                    public void onUserInfo(User user) {
                        IOLog.i(FindTokenInteractorImpl.TAG, "user name : " + user.getUserName() + ", phone number : " + user.getPhoneNumber());
                    }
                });
                onFinishedListener.onMigration(true);
            }

            @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
            public void onFailure(String str2, String str3) {
                IOLog.error(FindTokenInteractorImpl.TAG, new OAuthToken().getOAuthToken(), "requestMigration", new Exception("code:" + str2 + ", message:" + str3));
                onFinishedListener.onMigration(false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finish(FindTokenInteractor.OnFinishedListener onFinishedListener, boolean z) {
        if (this.isHere) {
            onFinishedListener.onIsToken(z);
        }
        finish();
        this.isHere = false;
    }

    @Override // kr.switcher.switcherm.ui.splash.interactors.FindTokenInteractor
    public void finish() {
        Handler handler = this.serverTimeoutHandler;
        if (handler != null) {
            handler.removeCallbacks(this.serverTimeoutRunnable);
        }
    }
}
