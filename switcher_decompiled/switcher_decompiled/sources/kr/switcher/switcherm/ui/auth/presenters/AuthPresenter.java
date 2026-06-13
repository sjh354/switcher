package kr.switcher.switcherm.ui.auth.presenters;

import kr.switcher.switcherm.ui.auth.domain.AccessTokensInfo;
import kr.switcher.switcherm.ui.auth.fragments.AuthIdentifyFragment;
import kr.switcher.switcherm.ui.auth.fragments.AuthPhoneNumberFragment;

/* JADX INFO: loaded from: classes2.dex */
public interface AuthPresenter {
    void doneFragment();

    void initialize();

    void onBackPressed(AuthPhoneNumberFragment authPhoneNumberFragment, AuthIdentifyFragment authIdentifyFragment);

    void onNewAction(String str, AccessTokensInfo accessTokensInfo, AuthPhoneNumberFragment authPhoneNumberFragment, AuthIdentifyFragment authIdentifyFragment);
}
