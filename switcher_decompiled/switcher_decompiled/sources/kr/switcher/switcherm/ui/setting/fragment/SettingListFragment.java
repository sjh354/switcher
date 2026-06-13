package kr.switcher.switcherm.ui.setting.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.rey.material.widget.Switch;
import kr.switcher.device.IODevice;
import kr.switcher.device.switcher.Switcher;
import kr.switcher.device.switcher.SwitcherVersions;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.device.IODeviceDBProvider;
import kr.switcher.switcherm.device.IODeviceHandler;
import kr.switcher.switcherm.preference.MirrorSwitchButtonPreference;
import kr.switcher.switcherm.preference.SwitcherVersion;
import kr.switcher.switcherm.ui.setting.SettingActivity;
import kr.switcher.switcherm.ui.setting.helper.SettingListUtil;
import kr.switcher.switcherm.ui.setting.interactor.FindSettingInfoInteractor;
import kr.switcher.switcherm.ui.setting.presenter.SettingListPresenter;
import kr.switcher.switcherm.ui.setting.view.SettingListView;
import kr.switcher.switcherm.user.UserStateManager;

/* JADX INFO: loaded from: classes2.dex */
public class SettingListFragment extends Fragment implements SettingListView {
    private static final String TAG = "SettingListFragment";
    private static SettingActivity.LastVersionListener listener;
    private static SettingActivity.MovedFragmentListener movedFragmentListener;

    @BindView(R.id.cb_main_switcher)
    CheckBox cb_main_switcher;
    private String connectedMacAddress;

    @BindView(R.id.et_room_name)
    EditText et_room_name;
    private IODevice ioDevice;
    private SettingListPresenter presenter;

    @BindView(R.id.rl_firmware_update)
    RelativeLayout rl_firmware_update;

    @BindView(R.id.rl_selector_main_switcher)
    RelativeLayout rl_selector_main_switcher;

    @BindView(R.id.rl_share_code)
    RelativeLayout rl_share_code;

    @BindView(R.id.sc_mirror_button)
    Switch sc_mirror_button;

    @BindView(R.id.tv_firmware_version)
    TextView tv_firmware_version;

    @BindView(R.id.tv_name)
    TextView tv_name;

    @BindView(R.id.tv_new)
    TextView tv_new;

    public static SettingListFragment newInstance(String str, SettingActivity.MovedFragmentListener movedFragmentListener2, SettingActivity.LastVersionListener lastVersionListener) {
        SettingListFragment settingListFragment = new SettingListFragment();
        Bundle bundle = new Bundle();
        bundle.putString("CONNECTED_MAC_ADDRESS", str);
        listener = lastVersionListener;
        movedFragmentListener = movedFragmentListener2;
        settingListFragment.setArguments(bundle);
        return settingListFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_setting_list, viewGroup, false);
        ButterKnife.bind(this, viewInflate);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.connectedMacAddress = arguments.getString("CONNECTED_MAC_ADDRESS");
        }
        if (!SettingListUtil.checkIsValidData(this.connectedMacAddress)) {
            getActivity().finish();
            return null;
        }
        this.ioDevice = IODeviceHandler.getInstance().getDevice(this.connectedMacAddress);
        SettingListPresenter settingListPresenter = new SettingListPresenter(this, new FindSettingInfoInteractor());
        this.presenter = settingListPresenter;
        settingListPresenter.initialize(this.ioDevice);
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.presenter.onPause();
    }

    @Override // kr.switcher.switcherm.ui.setting.view.SettingListView
    public void trackSettingMineForGA() {
        IOLog.activity(IOUtil.getStringResource(R.string.screen_title_4_0));
    }

    @Override // kr.switcher.switcherm.ui.setting.view.SettingListView
    public void trackSettingOtherForGA() {
        IOLog.activity(IOUtil.getStringResource(R.string.screen_title_4_1));
    }

    @Override // kr.switcher.switcherm.ui.setting.view.SettingListView
    public void showMine() {
        this.rl_share_code.setVisibility(0);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.SettingListView
    public void showOther() {
        this.rl_share_code.setVisibility(8);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.SettingListView
    public void setRoomName(String str) {
        this.et_room_name.setText(str);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.SettingListView
    public void setCheckedMain(boolean z) {
        this.cb_main_switcher.setChecked(z);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.SettingListView
    public void setCheckedMirror(boolean z) {
        this.sc_mirror_button.setChecked(z);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.SettingListView
    public void setFirmwareVersion(String str) {
        ((Switcher) this.ioDevice).setFirmwareVersion(str);
        this.tv_firmware_version.setText(str);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.SettingListView
    public void showFirmwareVersion() {
        this.tv_firmware_version.setVisibility(0);
        this.tv_new.setVisibility(4);
        listener.onIsLastVersion(true);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.SettingListView
    public void showFirmwareNew() {
        this.tv_new.setVisibility(0);
        this.tv_firmware_version.setVisibility(4);
        listener.onIsLastVersion(false);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.SettingListView
    public void hideFirmwareMenu() {
        this.rl_firmware_update.setVisibility(8);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.SettingListView
    public void updateDevicerName() {
        new IODeviceDBProvider().updateDeviceNameToDB(this.ioDevice, this.et_room_name.getText().toString());
    }

    @Override // kr.switcher.switcherm.ui.setting.view.SettingListView
    public void setFirmwareLastVersion() {
        new SwitcherVersion().setLastVersion(SwitcherVersions.LAST_SWITCHER_VERSION);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.SettingListView
    public void setFirmwareDownloadLink(String str) {
        new SwitcherVersion().setLink(str);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.SettingListView
    public void setMainSwitcherMacAddress(String str) {
        UserStateManager.getInstance().setMainSwitcher(str);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.SettingListView
    public void setMirrorSwitchButton(Boolean bool) {
        new MirrorSwitchButtonPreference().setMirrorSwitchButtonPreference(bool.booleanValue());
    }

    @Override // kr.switcher.switcherm.ui.setting.view.SettingListView
    public void setCheckerSettingMenu() {
        this.rl_selector_main_switcher.setVisibility(8);
        this.rl_share_code.setVisibility(8);
        this.rl_firmware_update.setVisibility(8);
        this.tv_name.setText(R.string.checker_name_setting);
        this.et_room_name.setText(this.ioDevice.getName());
        EditText editText = this.et_room_name;
        editText.setSelection(editText.getText().length());
    }

    @OnClick({R.id.cb_main_switcher})
    public void onMainSwitcherButtonClicked() {
        this.presenter.onMainSwitcherButtonClicked(this.connectedMacAddress, this.cb_main_switcher.isChecked());
    }

    @OnClick({R.id.sc_mirror_button})
    public void onMirrorButtonClicked() {
        this.presenter.onMirrorButtonClicked(this.connectedMacAddress, this.sc_mirror_button.isChecked());
    }
}
