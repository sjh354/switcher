package kr.switcher.switcherm.ui.auth.fragments;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.telephony.SmsMessage;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.databinding.FragmentAuthIdentifyBinding;
import kr.switcher.switcherm.preference.LoginUser;
import kr.switcher.switcherm.preference.OAuthToken;
import kr.switcher.switcherm.ui.auth.AuthActivity;
import kr.switcher.switcherm.viewmodel.AuthIdentifyFragmentViewModel;

/* JADX INFO: loaded from: classes2.dex */
public class AuthIdentifyFragment extends Fragment {
    private static final String TAG = "AuthIdentifyFragment";
    private static AuthActivity.OnDoneListener onDoneListener;
    private FragmentAuthIdentifyBinding binder;
    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: kr.switcher.switcherm.ui.auth.fragments.AuthIdentifyFragment.4
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.provider.Telephony.SMS_RECEIVED".equals(intent.getAction())) {
                Object[] objArr = (Object[]) intent.getExtras().get("pdus");
                SmsMessage[] smsMessageArr = new SmsMessage[objArr.length];
                for (int i = 0; i < objArr.length; i++) {
                    smsMessageArr[i] = SmsMessage.createFromPdu((byte[]) objArr[i]);
                }
                Log.d("문자 수신 시간", new Date(smsMessageArr[0].getTimestampMillis()).toString());
                String originatingAddress = smsMessageArr[0].getOriginatingAddress();
                String string = smsMessageArr[0].getMessageBody().toString();
                Log.d("문자 내용", "발신자 : " + originatingAddress + ", 내용 : " + string);
                AuthIdentifyFragment.this.binder.etAuthNumber.setText(AuthIdentifyFragment.this.parseAuthNumber(string));
            }
        }
    };
    private CountDownTimer countDownTimer;
    private AuthIdentifyFragmentViewModel viewModel;

    public static AuthIdentifyFragment newInstance(String str, AuthActivity.OnDoneListener onDoneListener2) {
        AuthIdentifyFragment authIdentifyFragment = new AuthIdentifyFragment();
        Bundle bundle = new Bundle();
        onDoneListener = onDoneListener2;
        bundle.putString(TAG, str);
        authIdentifyFragment.setArguments(bundle);
        return authIdentifyFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getContext().registerReceiver(this.broadcastReceiver, makeIntentFilter());
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        getContext().unregisterReceiver(this.broadcastReceiver);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.binder = (FragmentAuthIdentifyBinding) DataBindingUtil.inflate(layoutInflater, R.layout.fragment_auth_identify, viewGroup, false);
        AuthIdentifyFragmentViewModel authIdentifyFragmentViewModel = new AuthIdentifyFragmentViewModel();
        this.viewModel = authIdentifyFragmentViewModel;
        this.binder.setViewModel(authIdentifyFragmentViewModel);
        View root = this.binder.getRoot();
        this.binder.etAuthNumber.requestFocus();
        this.binder.etAuthNumber.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: kr.switcher.switcherm.ui.auth.fragments.AuthIdentifyFragment.1
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i != 6) {
                    return true;
                }
                AuthIdentifyFragment.onDoneListener.onDone();
                return true;
            }
        });
        this.binder.etAuthNumber.addTextChangedListener(new TextWatcher() { // from class: kr.switcher.switcherm.ui.auth.fragments.AuthIdentifyFragment.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                new LoginUser().setAuthNumber(editable.toString());
            }
        });
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString(TAG) : "";
        if (string != null) {
            ((TextView) root.findViewById(R.id.tv_info_phone_number)).setText(string);
        }
        countdown();
        return root;
    }

    /* JADX WARN: Type inference failed for: r6v0, types: [kr.switcher.switcherm.ui.auth.fragments.AuthIdentifyFragment$3] */
    private void countdown() {
        this.countDownTimer = new CountDownTimer(60000L, 1000L) { // from class: kr.switcher.switcherm.ui.auth.fragments.AuthIdentifyFragment.3
            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                String strValueOf = String.valueOf(j);
                if (strValueOf.length() == 5) {
                    strValueOf = String.valueOf(j).substring(0, 2);
                } else if (String.valueOf(j).length() == 4) {
                    strValueOf = String.valueOf(j).substring(0, 1);
                }
                AuthIdentifyFragment.this.binder.tvSecond.setText(strValueOf + IOUtil.getStringResource(R.string.sec));
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                if (AuthIdentifyFragment.this.getActivity() == null) {
                    return;
                }
                FragmentTransaction fragmentTransactionBeginTransaction = AuthIdentifyFragment.this.getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransactionBeginTransaction.remove(AuthIdentifyFragment.this);
                fragmentTransactionBeginTransaction.replace(R.id.container, AuthPhoneNumberFragment.newInstance(AuthIdentifyFragment.onDoneListener), "AuthPhoneNumberFragment");
                try {
                    fragmentTransactionBeginTransaction.commit();
                } catch (Exception e) {
                    IOLog.error(AuthIdentifyFragment.TAG, new OAuthToken().getOAuthToken(), "onStartSignal", e);
                }
            }
        }.start();
    }

    private IntentFilter makeIntentFilter() {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.BOOT_COMPLETED");
        intentFilter.addAction("android.provider.Telephony.SMS_RECEIVED");
        return intentFilter;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        IOLog.activity(IOUtil.getStringResource(R.string.screen_title_1_2));
        new Handler().postDelayed(new Runnable() { // from class: kr.switcher.switcherm.ui.auth.fragments.AuthIdentifyFragment.5
            @Override // java.lang.Runnable
            public void run() {
                IOUtil.showKeyBoard(AuthIdentifyFragment.this.binder.etAuthNumber);
            }
        }, 300L);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        IOUtil.hideKeyBoard(this.binder.etAuthNumber);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String parseAuthNumber(String str) {
        Matcher matcher = Pattern.compile("[\\d]").matcher(str);
        String str2 = "";
        while (matcher.find()) {
            str2 = str2 + matcher.group(0);
        }
        return str2;
    }

    public void onNextButtonClicked() {
        CountDownTimer countDownTimer = this.countDownTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }
}
