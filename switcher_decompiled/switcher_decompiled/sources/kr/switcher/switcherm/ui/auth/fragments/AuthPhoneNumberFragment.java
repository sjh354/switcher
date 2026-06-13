package kr.switcher.switcherm.ui.auth.fragments;

import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.databinding.FragmentAuthPhoneNumberBinding;
import kr.switcher.switcherm.preference.LoginUser;
import kr.switcher.switcherm.ui.auth.AuthActivity;
import kr.switcher.switcherm.viewmodel.AuthPhoneNumberFragmentViewModel;

/* JADX INFO: loaded from: classes2.dex */
public class AuthPhoneNumberFragment extends Fragment {
    private static AuthActivity.OnDoneListener onDoneListener;
    private FragmentAuthPhoneNumberBinding binder;
    private AuthPhoneNumberFragmentViewModel viewModel;

    public static AuthPhoneNumberFragment newInstance(AuthActivity.OnDoneListener onDoneListener2) {
        AuthPhoneNumberFragment authPhoneNumberFragment = new AuthPhoneNumberFragment();
        Bundle bundle = new Bundle();
        onDoneListener = onDoneListener2;
        authPhoneNumberFragment.setArguments(bundle);
        return authPhoneNumberFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.binder = (FragmentAuthPhoneNumberBinding) DataBindingUtil.inflate(layoutInflater, R.layout.fragment_auth_phone_number, viewGroup, false);
        AuthPhoneNumberFragmentViewModel authPhoneNumberFragmentViewModel = new AuthPhoneNumberFragmentViewModel();
        this.viewModel = authPhoneNumberFragmentViewModel;
        this.binder.setViewModel(authPhoneNumberFragmentViewModel);
        View root = this.binder.getRoot();
        this.binder.etPhoneNumber.requestFocus();
        final LoginUser loginUser = new LoginUser();
        String phoneNumber = loginUser.getPhoneNumber();
        if (phoneNumber != null && phoneNumber.length() > 10) {
            this.binder.etPhoneNumber.setText(phoneNumber);
        }
        this.binder.etPhoneNumber.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: kr.switcher.switcherm.ui.auth.fragments.AuthPhoneNumberFragment.1
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i != 6) {
                    return true;
                }
                AuthPhoneNumberFragment.onDoneListener.onDone();
                return true;
            }
        });
        this.binder.etPhoneNumber.addTextChangedListener(new TextWatcher() { // from class: kr.switcher.switcherm.ui.auth.fragments.AuthPhoneNumberFragment.2
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                loginUser.setPhoneNumber(AuthPhoneNumberFragment.this.binder.etPhoneNumber.getText().toString());
            }
        });
        return root;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        IOLog.activity(IOUtil.getStringResource(R.string.screen_title_1_1));
        new Handler().postDelayed(new Runnable() { // from class: kr.switcher.switcherm.ui.auth.fragments.AuthPhoneNumberFragment.3
            @Override // java.lang.Runnable
            public void run() {
                IOUtil.showKeyBoard(AuthPhoneNumberFragment.this.binder.etPhoneNumber);
            }
        }, 300L);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        IOUtil.hideKeyBoard(this.binder.etPhoneNumber);
    }
}
