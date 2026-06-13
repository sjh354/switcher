package kr.switcher.switcherm.ui.auth.views;

import android.view.View;
import kr.switcher.switcherm.ui.auth.domain.AccessTokensInfo;

/* JADX INFO: loaded from: classes2.dex */
public interface AuthView {
    void checkSMSPermission();

    void hideProgressbar();

    void moveAuthIdentifyFragment(String str);

    void moveAuthPhoneNumberFragment();

    void moveBackView();

    void moveHelloActivity();

    void onNextButtonClicked(View view);

    void setAccessTokens(AccessTokensInfo accessTokensInfo);

    void showErrorMessage(String str);

    void showProgressbar();
}
