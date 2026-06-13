package kr.switcher.switcherm.ui.auth.interactors;

import kr.switcher.switcherm.ui.auth.domain.AccessTokensInfo;

/* JADX INFO: loaded from: classes2.dex */
public interface AuthInfoInteractor {
    public static final int DEVICES_IS_NULL = -7;
    public static final int FAILED_REQUEST = -1;
    public static final int RESULT_SUCCESS = 1;
    public static final int TOKEN_IS_NULL = -4;
    public static final int USER_IS_NULL = -5;
    public static final int WRONG_AUTH_NUMBER = -3;
    public static final int WRONG_PHONE_NUMBER = -2;
    public static final int WRONG_TOKEN = -6;

    public interface OnGetAccessTokenListener {
        void onGetAccessTokenResult(int i);
    }

    public interface OnGetAuthNumberListener {
        void onGetAuthNumberResult(String str, AccessTokensInfo accessTokensInfo, int i);
    }

    void requestAccessToken(String str, AccessTokensInfo accessTokensInfo, OnGetAccessTokenListener onGetAccessTokenListener);

    void requestAuthNumber(String str, OnGetAuthNumberListener onGetAuthNumberListener);
}
