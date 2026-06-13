package kr.switcher.switcherm.ui.auth.presenters;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;
import com.loopj.android.http.AsyncHttpClient;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.network.http.RestSwitcherAPIStore;
import kr.switcher.switcherm.network.http.response.HttpAPIResponse;
import kr.switcher.switcherm.network.http.response.HttpResponseHandler;
import kr.switcher.switcherm.preference.FCMPreference;
import kr.switcher.switcherm.ui.auth.domain.AccessTokensInfo;
import kr.switcher.switcherm.ui.auth.fragments.AuthIdentifyFragment;
import kr.switcher.switcherm.ui.auth.fragments.AuthPhoneNumberFragment;
import kr.switcher.switcherm.ui.auth.interactors.AuthInfoInteractor;
import kr.switcher.switcherm.ui.auth.views.AuthView;

/* JADX INFO: loaded from: classes2.dex */
public class AuthPresenterImpl implements AuthPresenter, AuthInfoInteractor.OnGetAuthNumberListener, AuthInfoInteractor.OnGetAccessTokenListener {
    private static final String TAG = "AuthPresenterImpl";
    private Context context;
    private AuthInfoInteractor interactor;
    private AuthView view;

    public AuthPresenterImpl(Context context, AuthView authView, AuthInfoInteractor authInfoInteractor) {
        this.context = context;
        this.view = authView;
        this.interactor = authInfoInteractor;
    }

    @Override // kr.switcher.switcherm.ui.auth.presenters.AuthPresenter
    public void initialize() {
        this.view.checkSMSPermission();
        this.view.moveAuthPhoneNumberFragment();
    }

    @Override // kr.switcher.switcherm.ui.auth.presenters.AuthPresenter
    public void onBackPressed(AuthPhoneNumberFragment authPhoneNumberFragment, AuthIdentifyFragment authIdentifyFragment) {
        if (authPhoneNumberFragment != null) {
            this.view.moveBackView();
        } else if (authIdentifyFragment != null) {
            this.view.moveAuthPhoneNumberFragment();
        }
    }

    @Override // kr.switcher.switcherm.ui.auth.presenters.AuthPresenter
    public void onNewAction(String str, AccessTokensInfo accessTokensInfo, AuthPhoneNumberFragment authPhoneNumberFragment, AuthIdentifyFragment authIdentifyFragment) {
        this.view.showProgressbar();
        if (authPhoneNumberFragment != null) {
            this.interactor.requestAuthNumber(str, this);
        } else if (authIdentifyFragment != null) {
            authIdentifyFragment.onNextButtonClicked();
            this.interactor.requestAccessToken(str, accessTokensInfo, this);
        }
    }

    @Override // kr.switcher.switcherm.ui.auth.presenters.AuthPresenter
    public void doneFragment() {
        this.view.onNextButtonClicked(null);
    }

    @Override // kr.switcher.switcherm.ui.auth.interactors.AuthInfoInteractor.OnGetAuthNumberListener
    public void onGetAuthNumberResult(String str, AccessTokensInfo accessTokensInfo, int i) {
        this.view.hideProgressbar();
        if (i == -2) {
            this.view.showErrorMessage(IOUtil.getStringResource(R.string.enter_mobile_phone_number));
            return;
        }
        if (i == -1) {
            this.view.showErrorMessage(IOUtil.getStringResource(R.string.failed_reqeust_auth));
        } else if (i == 1) {
            this.view.setAccessTokens(accessTokensInfo);
            this.view.moveAuthIdentifyFragment(str);
        } else {
            this.view.showErrorMessage(IOUtil.getStringResource(R.string.etc_error));
        }
    }

    @Override // kr.switcher.switcherm.ui.auth.interactors.AuthInfoInteractor.OnGetAccessTokenListener
    public void onGetAccessTokenResult(int i) {
        this.view.hideProgressbar();
        if (i == -5) {
            this.view.moveAuthPhoneNumberFragment();
            return;
        }
        if (i == -4) {
            this.view.showErrorMessage(IOUtil.getStringResource(R.string.certification_number_received_fail));
            this.view.moveAuthPhoneNumberFragment();
        } else if (i == -3) {
            this.view.showErrorMessage(IOUtil.getStringResource(R.string.enter_the_four_digit_number));
        } else {
            if (i != 1) {
                return;
            }
            sendFCMTokenToServer();
            this.view.moveHelloActivity();
        }
    }

    private void sendFCMTokenToServer() {
        final FCMPreference fCMPreference = new FCMPreference();
        FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new OnCompleteListener<String>() { // from class: kr.switcher.switcherm.ui.auth.presenters.AuthPresenterImpl.1
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public void onComplete(Task<String> task) {
                if (!task.isSuccessful()) {
                    Log.w(AuthPresenterImpl.TAG, "토큰 생성 실패", task.getException());
                    return;
                }
                String result = task.getResult();
                fCMPreference.setFCMPreference(result);
                RestSwitcherAPIStore.requestPostFCMMobileDevices(result, new HttpResponseHandler() { // from class: kr.switcher.switcherm.ui.auth.presenters.AuthPresenterImpl.1.1
                    @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
                    public void onSuccess(HttpAPIResponse httpAPIResponse) {
                        IOLog.i(AuthPresenterImpl.TAG, "Updating FCM token to server was succeed");
                    }

                    @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
                    public void onFailure(String str, String str2) {
                        IOLog.i(AuthPresenterImpl.TAG, "Updating FCM token to server was Failed");
                    }
                });
                AsyncHttpClient.log.d("MessageToken", result);
            }
        });
    }
}
