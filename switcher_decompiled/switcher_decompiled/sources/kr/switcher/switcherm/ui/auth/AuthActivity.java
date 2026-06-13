package kr.switcher.switcherm.ui.auth;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentTransaction;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.databinding.ActivityAuthBinding;
import kr.switcher.switcherm.permission.PermissionChecker;
import kr.switcher.switcherm.preference.LoginUser;
import kr.switcher.switcherm.preference.OAuthToken;
import kr.switcher.switcherm.ui.auth.domain.AccessTokensInfo;
import kr.switcher.switcherm.ui.auth.fragments.AuthIdentifyFragment;
import kr.switcher.switcherm.ui.auth.fragments.AuthPhoneNumberFragment;
import kr.switcher.switcherm.ui.auth.interactors.AuthInfoInteractorImpl;
import kr.switcher.switcherm.ui.auth.presenters.AuthPresenter;
import kr.switcher.switcherm.ui.auth.presenters.AuthPresenterImpl;
import kr.switcher.switcherm.ui.auth.views.AuthView;
import kr.switcher.switcherm.ui.start.HelloActivity;
import kr.switcher.switcherm.viewmodel.AuthActivityViewModel;

/* JADX INFO: loaded from: classes2.dex */
public class AuthActivity extends AppCompatActivity implements AuthView {
    private static final String TAG = "AuthActivity";
    private AccessTokensInfo accessTokensInfo;
    private ActivityAuthBinding binder;
    private OnDoneListener listener;
    private AuthPresenter presenter;
    private AuthActivityViewModel viewModel;

    public interface OnDoneListener {
        void onDone();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.binder = (ActivityAuthBinding) DataBindingUtil.setContentView(this, R.layout.activity_auth);
        AuthActivityViewModel authActivityViewModel = new AuthActivityViewModel(getApplicationContext());
        this.viewModel = authActivityViewModel;
        this.binder.setViewModel(authActivityViewModel);
        this.listener = getListener();
        AuthPresenterImpl authPresenterImpl = new AuthPresenterImpl(this, this, new AuthInfoInteractorImpl());
        this.presenter = authPresenterImpl;
        authPresenterImpl.initialize();
    }

    private OnDoneListener getListener() {
        return new OnDoneListener() { // from class: kr.switcher.switcherm.ui.auth.AuthActivity.1
            @Override // kr.switcher.switcherm.ui.auth.AuthActivity.OnDoneListener
            public void onDone() {
                AuthActivity.this.presenter.doneFragment();
            }
        };
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        this.presenter.onBackPressed((AuthPhoneNumberFragment) getSupportFragmentManager().findFragmentByTag("AuthPhoneNumberFragment"), (AuthIdentifyFragment) getSupportFragmentManager().findFragmentByTag("AuthIdentifyFragment"));
    }

    @Override // kr.switcher.switcherm.ui.auth.views.AuthView
    public void checkSMSPermission() {
        if (PermissionChecker.checkSMSPermission(this)) {
            return;
        }
        PermissionChecker.requestSMSPermission(this);
    }

    @Override // kr.switcher.switcherm.ui.auth.views.AuthView
    public void moveBackView() {
        super.onBackPressed();
    }

    @Override // kr.switcher.switcherm.ui.auth.views.AuthView
    public void moveAuthPhoneNumberFragment() {
        FragmentTransaction fragmentTransactionBeginTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransactionBeginTransaction.replace(R.id.container, AuthPhoneNumberFragment.newInstance(this.listener), "AuthPhoneNumberFragment");
        try {
            fragmentTransactionBeginTransaction.commit();
        } catch (Exception e) {
            IOLog.error(TAG, new OAuthToken().getOAuthToken(), "moveAuthPhoneNumberFragment", e);
        }
    }

    @Override // kr.switcher.switcherm.ui.auth.views.AuthView
    public void moveAuthIdentifyFragment(String str) {
        FragmentTransaction fragmentTransactionBeginTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransactionBeginTransaction.replace(R.id.container, AuthIdentifyFragment.newInstance(str, this.listener), "AuthIdentifyFragment");
        try {
            fragmentTransactionBeginTransaction.commit();
        } catch (Exception e) {
            IOLog.error(TAG, new OAuthToken().getOAuthToken(), "moveAuthIdentifyFragment", e);
        }
    }

    @Override // kr.switcher.switcherm.ui.auth.views.AuthView
    public void moveHelloActivity() {
        startActivity(new Intent(this, (Class<?>) HelloActivity.class));
        finish();
    }

    @Override // kr.switcher.switcherm.ui.auth.views.AuthView
    public void onNextButtonClicked(View view) {
        this.presenter.onNewAction(new LoginUser().getPhoneNumber(), this.accessTokensInfo, (AuthPhoneNumberFragment) getSupportFragmentManager().findFragmentByTag("AuthPhoneNumberFragment"), (AuthIdentifyFragment) getSupportFragmentManager().findFragmentByTag("AuthIdentifyFragment"));
    }

    @Override // kr.switcher.switcherm.ui.auth.views.AuthView
    public void setAccessTokens(AccessTokensInfo accessTokensInfo) {
        this.accessTokensInfo = accessTokensInfo;
    }

    @Override // kr.switcher.switcherm.ui.auth.views.AuthView
    public void showErrorMessage(String str) {
        IOUtil.showToast(str);
    }

    @Override // kr.switcher.switcherm.ui.auth.views.AuthView
    public void showProgressbar() {
        this.viewModel.showProgressbar();
    }

    @Override // kr.switcher.switcherm.ui.auth.views.AuthView
    public void hideProgressbar() {
        this.viewModel.hideProgressbar();
    }
}
