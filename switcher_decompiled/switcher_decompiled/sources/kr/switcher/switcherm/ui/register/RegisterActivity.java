package kr.switcher.switcherm.ui.register;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.wang.avi.AVLoadingIndicatorView;
import kr.switcher.device.IODevice;
import kr.switcher.device.switcher.Switcher;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.activity.IOActivity;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.device.IODeviceHandler;
import kr.switcher.switcherm.device.switcher.handler.SwitcherDBProvider;
import kr.switcher.switcherm.device.switcher.handler.SwitcherHandler;
import kr.switcher.switcherm.ui.dialog.IODialogController;
import kr.switcher.switcherm.ui.main.MainActivity;
import kr.switcher.switcherm.ui.main.helper.MainScreenController;
import kr.switcher.switcherm.ui.register.interactor.SwitcherRegisterInteractor;
import kr.switcher.switcherm.ui.register.presenter.RegisterPresenter;
import kr.switcher.switcherm.ui.register.view.RegisterView;
import kr.switcher.switcherm.ui.wifi.WifiActivity;
import kr.switcher.switcherm.user.UserStateManager;

/* JADX INFO: loaded from: classes2.dex */
public class RegisterActivity extends IOActivity implements RegisterView, TextWatcher {

    @BindView(R.id.btn_register)
    TextView btn_register;
    private String connectedMacAddress;

    @BindView(R.id.et_owner)
    EditText et_owner;

    @BindView(R.id.et_room_name)
    EditText et_room_name;

    @BindView(R.id.iv_switcher_type)
    ImageView iv_switcher_type;

    @BindView(R.id.pb_registering)
    AVLoadingIndicatorView pb_registering;
    private RegisterPresenter presenter;

    @BindView(R.id.tv_production_number)
    TextView tv_production_number;

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // kr.switcher.switcherm.ui.register.view.RegisterView
    public void initializeHashingCode(String str) {
    }

    @Override // kr.switcher.switcherm.common.activity.IOActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        this.connectedMacAddress = getIntent().getStringExtra("CONNECTED_MAC_ADDRESS");
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        IODevice device = IODeviceHandler.getInstance().getDevice(this.connectedMacAddress);
        if (device == null) {
            finish();
            return;
        }
        this.presenter = new RegisterPresenter(this, new SwitcherRegisterInteractor(device));
        this.et_room_name.addTextChangedListener(this);
        this.et_owner.addTextChangedListener(this);
        this.presenter.initialize(device, UserStateManager.getInstance().getCurrentUserFromDB());
    }

    @OnClick({R.id.btn_cancel})
    public void onCancelButtonClicked() {
        this.presenter.onCancelButtonClicked();
    }

    @OnClick({R.id.btn_register})
    public void onRegisterButtonClicked() {
        this.presenter.onRegisterButtonClicked(this.et_owner.getText().toString(), this.et_room_name.getText().toString());
    }

    @Override // kr.switcher.switcherm.ui.register.view.RegisterView
    public void setProductionNumber(String str) {
        this.tv_production_number.setText(str);
    }

    @Override // kr.switcher.switcherm.ui.register.view.RegisterView
    public void moveSwitcherListScreen() {
        setResult(104, new Intent(this, (Class<?>) MainActivity.class));
        finish();
    }

    @Override // kr.switcher.switcherm.ui.register.view.RegisterView
    public void moveMainConnectedScreen(String str) {
        Intent intent = new Intent(this, (Class<?>) MainActivity.class);
        intent.putExtra(MainScreenController.INTENT_PARM_MAC_ADDRESS_TO_CONNECT, str);
        setResult(101, intent);
        finish();
    }

    @Override // kr.switcher.switcherm.ui.register.view.RegisterView
    public void showWarningDialog() {
        IODialogController.showWarningForRegisterDialog(this);
    }

    @Override // kr.switcher.switcherm.ui.register.view.RegisterView
    public void showErrorMessage(String str) {
        IOUtil.showToast(str);
    }

    @Override // kr.switcher.switcherm.ui.register.view.RegisterView
    public void setOwnerName(String str) {
        this.et_owner.setText(str);
    }

    @Override // kr.switcher.switcherm.ui.register.view.RegisterView
    public void showProgressbar(int i) {
        IOUtil.showProgressbarDialog(this, this.pb_registering, i);
    }

    @Override // kr.switcher.switcherm.ui.register.view.RegisterView
    public void hideProgressbar() {
        IOUtil.hideProgressbarDialog(this, this.pb_registering);
    }

    @Override // kr.switcher.switcherm.ui.register.view.RegisterView
    public void updateSwitcherName() {
        Switcher switcher = SwitcherHandler.getInstance().getSwitcher(this.connectedMacAddress);
        if (switcher != null) {
            new SwitcherDBProvider().updateSwitcherNameToDB(switcher, this.et_room_name.getText().toString());
        }
    }

    @Override // kr.switcher.switcherm.ui.register.view.RegisterView
    public void trackRegisterForGA() {
        IOLog.activity(IOUtil.getStringResource(R.string.screen_title_2_2_0));
    }

    @Override // kr.switcher.switcherm.ui.register.view.RegisterView
    public void trackWarningForGA() {
        IOLog.activity(IOUtil.getStringResource(R.string.screen_title_2_2_0_0));
    }

    @Override // kr.switcher.switcherm.ui.register.view.RegisterView
    public void inactiveRegisterButton() {
        this.btn_register.setTextColor(IOUtil.getColorResource(R.color.silver_three));
        this.btn_register.setBackground(IOUtil.getDrawable(R.drawable.shape_off_blue_fill));
    }

    @Override // kr.switcher.switcherm.ui.register.view.RegisterView
    public void activeRegisterButton() {
        this.btn_register.setTextColor(IOUtil.getColorResource(R.color.periwinkle));
        this.btn_register.setBackground(IOUtil.getDrawable(R.drawable.shape_white_fill));
    }

    @Override // kr.switcher.switcherm.ui.register.view.RegisterView
    public void setSwitcherTypeOneSet() {
        this.iv_switcher_type.setImageDrawable(IOUtil.getDrawable(R.drawable.ic_main_switcher_one));
    }

    @Override // kr.switcher.switcherm.ui.register.view.RegisterView
    public void setSwitcherTypeTwoSet() {
        this.iv_switcher_type.setImageDrawable(IOUtil.getDrawable(R.drawable.ic_main_switcher_two));
    }

    @Override // kr.switcher.switcherm.ui.register.view.RegisterView
    public void setLinkerType() {
        this.iv_switcher_type.setImageDrawable(IOUtil.getDrawable(R.drawable.ic_main_linker));
    }

    @Override // kr.switcher.switcherm.ui.register.view.RegisterView
    public void setCheckerType() {
        this.iv_switcher_type.setImageDrawable(IOUtil.getDrawable(R.drawable.ic_main_checker));
    }

    @Override // kr.switcher.switcherm.ui.register.view.RegisterView
    public void moveWifiSettingScreen(IODevice iODevice) {
        Intent intent = new Intent(this, (Class<?>) WifiActivity.class);
        intent.putExtra(WifiActivity.INTENT_PARM_CONNECTED_MAC_ADDRESS, iODevice.getMacAddress());
        startActivity(intent);
        finish();
    }

    @Override // kr.switcher.switcherm.ui.register.view.RegisterView
    public void uneditableOwnerName() {
        this.et_owner.setEnabled(false);
    }

    @Override // kr.switcher.switcherm.ui.register.view.RegisterView
    public void editableOwnerName() {
        this.et_owner.setEnabled(true);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        this.presenter.onCancelButtonClicked();
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.presenter.onTextChanged(this.et_owner.getText().toString(), this.et_room_name.getText().toString());
    }
}
