package kr.switcher.switcherm.ui.auth.interactors;

import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.device.IODeviceHandler;
import kr.switcher.switcherm.network.http.RestErrorCode;
import kr.switcher.switcherm.network.http.response.AccessTokensAPIResponse;
import kr.switcher.switcherm.network.http.response.HttpAPIResponse;
import kr.switcher.switcherm.network.http.response.HttpResponseHandler;
import kr.switcher.switcherm.preference.LoginUser;
import kr.switcher.switcherm.ui.auth.domain.AccessTokensInfo;
import kr.switcher.switcherm.ui.auth.interactors.AuthInfoInteractor;
import kr.switcher.switcherm.user.User;
import kr.switcher.switcherm.user.UserStateManager;

/* JADX INFO: loaded from: classes2.dex */
public class AuthInfoInteractorImpl implements AuthInfoInteractor {
    private static final String TAG = "AuthInfoInteractorImpl";

    @Override // kr.switcher.switcherm.ui.auth.interactors.AuthInfoInteractor
    public void requestAuthNumber(final String str, final AuthInfoInteractor.OnGetAuthNumberListener onGetAuthNumberListener) {
        if (str != null && str.length() >= 10) {
            User user = new User();
            user.setPhoneNumber(str);
            UserStateManager.getInstance().requestPostPhoneNumberToRestServer(user, new HttpResponseHandler() { // from class: kr.switcher.switcherm.ui.auth.interactors.AuthInfoInteractorImpl.1
                @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
                public void onSuccess(HttpAPIResponse httpAPIResponse) {
                    onGetAuthNumberListener.onGetAuthNumberResult(str, new AccessTokensInfo(((AccessTokensAPIResponse) httpAPIResponse).id), 1);
                }

                @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
                public void onFailure(String str2, String str3) {
                    onGetAuthNumberListener.onGetAuthNumberResult(str, null, -1);
                }
            });
            return;
        }
        onGetAuthNumberListener.onGetAuthNumberResult("", null, -2);
    }

    @Override // kr.switcher.switcherm.ui.auth.interactors.AuthInfoInteractor
    public void requestAccessToken(String str, AccessTokensInfo accessTokensInfo, final AuthInfoInteractor.OnGetAccessTokenListener onGetAccessTokenListener) {
        User user = new User();
        user.setPhoneNumber(str);
        String authNumber = new LoginUser().getAuthNumber();
        IOLog.i(TAG, "push auth number : " + authNumber);
        if (authNumber == null || authNumber.length() != 4) {
            onGetAccessTokenListener.onGetAccessTokenResult(-3);
        } else {
            accessTokensInfo.setAuthNumber(authNumber);
            UserStateManager.getInstance().requestGetStartAppToRestServer(user, accessTokensInfo, new UserStateManager.AuthStartAppResponseCallback() { // from class: kr.switcher.switcherm.ui.auth.interactors.AuthInfoInteractorImpl.2
                @Override // kr.switcher.switcherm.user.UserStateManager.AuthStartAppResponseCallback
                public void onAuthResult(String str2) {
                    if (str2 != null) {
                        if (!"".equals(str2)) {
                            UserStateManager.getInstance().requestGetCustomerMeToRestServer(AuthInfoInteractorImpl.this.getUserRestResponseCallback(onGetAccessTokenListener));
                            return;
                        } else {
                            onGetAccessTokenListener.onGetAccessTokenResult(-6);
                            return;
                        }
                    }
                    onGetAccessTokenListener.onGetAccessTokenResult(-4);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public UserStateManager.UserRestResponseCallback getUserRestResponseCallback(final AuthInfoInteractor.OnGetAccessTokenListener onGetAccessTokenListener) {
        return new UserStateManager.UserRestResponseCallback() { // from class: kr.switcher.switcherm.ui.auth.interactors.AuthInfoInteractorImpl.3
            @Override // kr.switcher.switcherm.user.UserStateManager.UserRestResponseCallback
            public void onUserInfo(User user) {
                if (user == null) {
                    UserStateManager.getInstance().setAuthToken("");
                    onGetAccessTokenListener.onGetAccessTokenResult(-5);
                } else {
                    IODeviceHandler.getInstance().createIODevices(new IODeviceHandler.OnCreateResultListener() { // from class: kr.switcher.switcherm.ui.auth.interactors.AuthInfoInteractorImpl.3.1
                        @Override // kr.switcher.switcherm.device.IODeviceHandler.OnCreateResultListener
                        public void onResult(String str, String str2) {
                            if (str.equals(RestErrorCode.UNAUTHORIZED)) {
                                UserStateManager.getInstance().setAuthToken(null);
                            } else {
                                onGetAccessTokenListener.onGetAccessTokenResult(1);
                            }
                        }
                    });
                }
            }
        };
    }
}
