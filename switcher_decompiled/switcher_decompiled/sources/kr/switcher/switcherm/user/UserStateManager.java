package kr.switcher.switcherm.user;

import android.content.Context;
import kr.switcher.device.switcher.linker.http.microservice.MobileLinkerMicroService;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.database.DBUser;
import kr.switcher.switcherm.database.DBUserDAO;
import kr.switcher.switcherm.network.http.RestSwitcherAPIStore;
import kr.switcher.switcherm.network.http.microservice.MobileMicroService;
import kr.switcher.switcherm.network.http.response.AccessTokensAPIResponse;
import kr.switcher.switcherm.network.http.response.CustomerMeAPIResponse;
import kr.switcher.switcherm.network.http.response.HttpAPIResponse;
import kr.switcher.switcherm.network.http.response.HttpResponseHandler;
import kr.switcher.switcherm.preference.LoginUser;
import kr.switcher.switcherm.preference.OAuthToken;
import kr.switcher.switcherm.ui.auth.domain.AccessTokensInfo;
import kr.switcher.switcherm.user.helper.UserMapper;

/* JADX INFO: loaded from: classes2.dex */
public class UserStateManager {
    private static final String TAG = "UserStateManager";
    private static volatile UserStateManager instance;
    private Context context;
    private boolean isAuth;

    public interface AuthStartAppResponseCallback {
        void onAuthResult(String str);
    }

    public interface UserRestResponseCallback {
        void onUserInfo(User user);
    }

    public void initialize(Context context) {
        this.context = context;
        this.isAuth = false;
    }

    public static UserStateManager getInstance() {
        if (instance == null) {
            synchronized (UserStateManager.class) {
            }
        }
        return instance;
    }

    public User getCurrentUserFromDB() {
        DBUserDAO dBUserDAO = new DBUserDAO();
        dBUserDAO.open();
        DBUser data = dBUserDAO.getData();
        if (data == null) {
            return null;
        }
        dBUserDAO.close();
        return new User(data.getPhoneNumber(), data.getUserName(), data.getMainSwitcherCode(), data.getPostNumber(), data.getAddress1(), data.getAddress2());
    }

    public void setUserToDB(User user) {
        DBUserDAO dBUserDAO = new DBUserDAO();
        dBUserDAO.open();
        if (!dBUserDAO.delete(user.getPhoneNumber())) {
            IOLog.error(TAG, new OAuthToken().getOAuthToken(), "setUserToDB", new Exception("Failed delete user"));
        }
        if (user.getUserName() == null || user.getUserName().equals("")) {
            user.setUserName(IOUtil.getStringResource(R.string.default_user_name));
        }
        if (dBUserDAO.insertOrUpdate(user.getPhoneNumber(), user.getUserName(), user.getMainSwitcherCode(), user.getPostNumber(), user.getAddress1(), user.getAddress2()) == null) {
            IOUtil.showToast(this.context.getString(R.string.failure_is_not_saved_user_info));
            IOLog.error(TAG, new OAuthToken().getOAuthToken(), "setUserToDB", new Exception("Failed insert user"));
        }
        dBUserDAO.close();
        new LoginUser().setPhoneNumber(user.getPhoneNumber());
    }

    public int setMainSwitcher(String str) {
        User currentUserFromDB = getCurrentUserFromDB();
        if (currentUserFromDB == null) {
            return 402;
        }
        currentUserFromDB.setMainSwitcherMacAddress(str);
        DBUserDAO dBUserDAO = new DBUserDAO();
        dBUserDAO.open();
        if (dBUserDAO.updateMainSwitcher(currentUserFromDB.getPhoneNumber(), str) == null) {
            return 403;
        }
        dBUserDAO.close();
        return 1;
    }

    public void requestPostPhoneNumberToRestServer(User user, HttpResponseHandler httpResponseHandler) {
        RestSwitcherAPIStore.requestPostAuthNumber(user, httpResponseHandler);
    }

    public void requestGetStartAppToRestServer(final User user, AccessTokensInfo accessTokensInfo, final AuthStartAppResponseCallback authStartAppResponseCallback) {
        RestSwitcherAPIStore.requestGetAuthInfo(accessTokensInfo.getAccessTokenId(), accessTokensInfo.getAuthNumber(), new HttpResponseHandler() { // from class: kr.switcher.switcherm.user.UserStateManager.1
            @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
            public void onSuccess(HttpAPIResponse httpAPIResponse) {
                IOLog.i(UserStateManager.TAG, "response start app : " + httpAPIResponse);
                String str = ((AccessTokensAPIResponse) httpAPIResponse).key;
                if (str == null || str.equalsIgnoreCase("")) {
                    authStartAppResponseCallback.onAuthResult("");
                    IOLog.error(UserStateManager.TAG, new OAuthToken().getOAuthToken(), "requestGetStartAppToRestServer - onSuccess", new Exception("invalid token : " + str));
                } else {
                    new LoginUser().setPhoneNumber(user.getPhoneNumber());
                    UserStateManager.this.setAuthToken(str);
                    authStartAppResponseCallback.onAuthResult(str);
                    IOLog.i(UserStateManager.TAG, "received token : " + str);
                }
            }

            @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
            public void onFailure(String str, String str2) {
                IOLog.error(UserStateManager.TAG, new OAuthToken().getOAuthToken(), "requestGetAuthInfo()", new Exception("code:" + str + ", message:" + str2));
                authStartAppResponseCallback.onAuthResult("");
            }
        });
    }

    public void requestGetCustomerMeToRestServer(final UserRestResponseCallback userRestResponseCallback) {
        IOLog.d(TAG, "requestGetCustomerMeToRestServer()");
        RestSwitcherAPIStore.requestGetCustomerMe(new HttpResponseHandler() { // from class: kr.switcher.switcherm.user.UserStateManager.2
            @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
            public void onSuccess(HttpAPIResponse httpAPIResponse) {
                User getUserMe = UserMapper.parseGetUserMe((CustomerMeAPIResponse) httpAPIResponse);
                UserStateManager.this.setUserToDB(getUserMe);
                IOLog.logUser(getUserMe.getId(), getUserMe.getEmail(), getUserMe.getUserName(), new OAuthToken().getOAuthToken(), getUserMe.getPhoneNumber());
                userRestResponseCallback.onUserInfo(getUserMe);
            }

            @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
            public void onFailure(String str, String str2) {
                IOLog.error(UserStateManager.TAG, new OAuthToken().getOAuthToken(), "requestGetCustomerMeToRestServer", new Exception("code:" + str + ", message:" + str2));
            }
        });
    }

    public void setAuthToken(String str) {
        if (str == null) {
            str = "";
        }
        if (!str.equals("")) {
            MobileMicroService.setAccessToken(str);
            MobileLinkerMicroService.setAccessToken(str);
            this.isAuth = true;
            IOLog.i(TAG, "token : " + str);
        } else {
            this.isAuth = false;
        }
        new OAuthToken().setOAuthToken(str);
    }

    public boolean isAuthUser() {
        return this.isAuth;
    }

    public static final class Builder {
        private Context context;

        public Builder setContext(Context context) {
            this.context = context;
            return this;
        }

        public UserStateManager build() {
            UserStateManager unused = UserStateManager.instance = new UserStateManager();
            UserStateManager.instance.initialize(this.context);
            return UserStateManager.instance;
        }
    }
}
