package kr.switcher.switcherm.ui.wifi.fragments;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.network.wifi.WifiData;
import kr.switcher.switcherm.ui.wifi.view.WifiPasswordView;

/* JADX INFO: loaded from: classes2.dex */
public class WifiPasswordFragment extends Fragment implements WifiPasswordView {
    private static final String PARM_WIFI_DATA = "WIFI_DATA";
    private static final String PARM_WIFI_NAME = "WIFI_NAME";
    private static OnPasswordResultCallback callback;

    @BindView(R.id.et_password)
    EditText et_password;

    @BindView(R.id.tv_wifi_name)
    TextView tv_wifi_name;

    public interface OnPasswordResultCallback {
        void OnPasswordResult(String str);
    }

    public static WifiPasswordFragment newInstance(OnPasswordResultCallback onPasswordResultCallback, WifiData wifiData) {
        WifiPasswordFragment wifiPasswordFragment = new WifiPasswordFragment();
        callback = onPasswordResultCallback;
        Bundle bundle = new Bundle();
        bundle.putString(PARM_WIFI_NAME, wifiData.getSsid());
        wifiPasswordFragment.setArguments(bundle);
        return wifiPasswordFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_wifi_password, viewGroup, false);
        ButterKnife.bind(this, viewInflate);
        Bundle arguments = getArguments();
        if (arguments == null) {
            return viewInflate;
        }
        String string = arguments.getString(PARM_WIFI_NAME);
        if (string != null) {
            this.tv_wifi_name.setText(string);
        }
        this.et_password.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: kr.switcher.switcherm.ui.wifi.fragments.WifiPasswordFragment.1
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i != 6) {
                    return true;
                }
                WifiPasswordFragment.this.onConfirmButtonClicked();
                return true;
            }
        });
        IOUtil.showKeyBoard(this.et_password);
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        IOUtil.hideKeyBoard(this.et_password);
    }

    @OnClick({R.id.btn_wifi_confirm})
    public void onConfirmButtonClicked() {
        callback.OnPasswordResult(this.et_password.getText().toString());
        IOUtil.hideKeyBoard(this.et_password);
    }

    public void showErrorMessage(String str) {
        IOUtil.showToast(str);
    }
}
