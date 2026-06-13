package kr.switcher.switcherm.ui.setting.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import kr.switcher.device.switcher.Switcher;
import kr.switcher.device.switcher.interfaces.IODeviceCallbacks;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.device.switcher.handler.SwitcherHandler;
import kr.switcher.switcherm.ui.setting.interactor.SetNewShareCodeInteractor;
import kr.switcher.switcherm.ui.setting.presenter.ShareCodePresenter;
import kr.switcher.switcherm.ui.setting.view.ShareCodeView;

/* JADX INFO: loaded from: classes2.dex */
public class ShareCodeFragment extends Fragment implements ShareCodeView, SetNewShareCodeInteractor.OnChangeNewShareCodeListener {
    private static final String TAG = "ShareCodeFragment";
    private IODeviceCallbacks.OnShareCodeChangeResultCallback callback;
    private String connectedMacAddress;

    @BindView(R.id.et_share_code)
    EditText et_share_code;

    @BindView(R.id.pb_changing)
    ProgressBar pb_changing;
    private ShareCodePresenter presenter;
    private Switcher switcher;

    public static ShareCodeFragment newInstance(String str) {
        ShareCodeFragment shareCodeFragment = new ShareCodeFragment();
        Bundle bundle = new Bundle();
        bundle.putString("CONNECTED_MAC_ADDRESS", str);
        shareCodeFragment.setArguments(bundle);
        return shareCodeFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_share_code, viewGroup, false);
        ButterKnife.bind(this, viewInflate);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.connectedMacAddress = arguments.getString("CONNECTED_MAC_ADDRESS");
        }
        if (!IOUtil.checkIsIODeviceKey(this.connectedMacAddress)) {
            IOUtil.showToast(IOUtil.getStringResource(R.string.not_found_connected_macaddress));
            getActivity().finish();
            return null;
        }
        Switcher switcher = SwitcherHandler.getInstance().getSwitcher(this.connectedMacAddress);
        this.switcher = switcher;
        if (switcher == null) {
            IOUtil.showToast(IOUtil.getStringResource(R.string.not_found_connected_macaddress));
            getActivity().finish();
            return null;
        }
        this.presenter = new ShareCodePresenter(this, new SetNewShareCodeInteractor(getContext(), this.switcher, this));
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.presenter.onResume(this.switcher);
    }

    public void changeNewShareCode(IODeviceCallbacks.OnShareCodeChangeResultCallback onShareCodeChangeResultCallback) {
        this.callback = onShareCodeChangeResultCallback;
        this.presenter.changeNewShareCode(this.et_share_code.getText().toString());
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.presenter.onDestroyView();
    }

    @Override // kr.switcher.switcherm.ui.setting.view.ShareCodeView
    public void setShareCode(String str) {
        this.et_share_code.setText(str);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.ShareCodeView
    public void setFocusable() {
        this.et_share_code.setFocusable(true);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.ShareCodeView
    public void hideProgressbar() {
        this.pb_changing.setVisibility(8);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.ShareCodeView
    public void showProgressbar() {
        this.pb_changing.setVisibility(0);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.ShareCodeView
    public void hideKeyboard() {
        IOUtil.hideKeyBoard(this.et_share_code);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.ShareCodeView
    public void showMessage(String str) {
        IOUtil.showToast(str);
    }

    @Override // kr.switcher.switcherm.ui.setting.interactor.SetNewShareCodeInteractor.OnChangeNewShareCodeListener
    public void onChangeToServerResult(boolean z) {
        this.presenter.onChangeResult(z, this.et_share_code.getText().toString());
    }

    @Override // kr.switcher.switcherm.ui.setting.interactor.SetNewShareCodeInteractor.OnChangeNewShareCodeListener
    public void onUpdateToDBResult(boolean z) {
        this.presenter.onUpdateToDBResult(z, this.callback);
    }
}
