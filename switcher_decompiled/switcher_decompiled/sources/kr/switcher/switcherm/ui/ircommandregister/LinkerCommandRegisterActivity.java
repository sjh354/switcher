package kr.switcher.switcherm.ui.ircommandregister;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.wang.avi.AVLoadingIndicatorView;
import java.util.List;
import kr.switcher.device.remocon.IRCommand;
import kr.switcher.device.remocon.Remocon;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.activity.IOActivity;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.device.IODeviceHandler;
import kr.switcher.switcherm.ui.irbrand.IRBrandActivity;
import kr.switcher.switcherm.ui.ircommandregister.presenter.LinkerCommandRegisterPresenter;
import kr.switcher.switcherm.ui.ircommandregister.view.LinkerCommandRegisterView;
import kr.switcher.switcherm.ui.ircommandtest.IrCommandTestActivity;
import kr.switcher.switcherm.ui.main.interactors.FindAirconIRCommandInteractor;

/* JADX INFO: loaded from: classes2.dex */
public class LinkerCommandRegisterActivity extends IOActivity implements LinkerCommandRegisterView, TextWatcher, TextView.OnEditorActionListener, FindAirconIRCommandInteractor.OnFindAirconIRCommandListener {
    public static final String PARM_REMOCON_KEY = "REMOCON_KEY";

    @BindView(R.id.btn_command_register)
    TextView btn_command_register;

    @BindView(R.id.et_command)
    EditText et_command;

    @BindView(R.id.pb_registering)
    AVLoadingIndicatorView pb_registering;
    private LinkerCommandRegisterPresenter presenter;
    private Remocon remocon;
    private List<IRCommand> remoconCommandItemList;

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean z) {
    }

    @Override // kr.switcher.switcherm.ui.main.interactors.FindAirconIRCommandInteractor.OnFindAirconIRCommandListener
    public void onRelease(boolean z) {
    }

    @Override // kr.switcher.switcherm.ui.main.interactors.FindAirconIRCommandInteractor.OnFindAirconIRCommandListener
    public void onRemove(boolean z, String str) {
    }

    @Override // kr.switcher.switcherm.common.activity.IOActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_linker_command_register);
        ButterKnife.bind(this);
        Remocon remocon = (Remocon) IODeviceHandler.getInstance().getDevice(getIntent().getStringExtra(PARM_REMOCON_KEY));
        this.remocon = remocon;
        if (remocon == null) {
            finish();
            return;
        }
        LinkerCommandRegisterPresenter linkerCommandRegisterPresenter = new LinkerCommandRegisterPresenter(this, new FindAirconIRCommandInteractor(this));
        this.presenter = linkerCommandRegisterPresenter;
        linkerCommandRegisterPresenter.onCreate(this.remocon);
        this.et_command.addTextChangedListener(this);
        this.et_command.setOnEditorActionListener(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    @OnClick({R.id.btn_previous})
    public void onPreviousButtonClicked() {
        this.presenter.onPreviousButtonClicked();
    }

    @OnClick({R.id.btn_command_register})
    public void onCommandRegisterButtonClicked() {
        this.presenter.onCommandRegisterButtonClicked(this.et_command.getText().toString());
    }

    @Override // kr.switcher.switcherm.ui.ircommandregister.view.LinkerCommandRegisterView
    public void showErrorMessage(String str) {
        IOUtil.showToast(str);
    }

    @Override // kr.switcher.switcherm.ui.ircommandregister.view.LinkerCommandRegisterView
    public void showProgressbar(int i) {
        IOUtil.showProgressbarDialog(this, this.pb_registering, i);
    }

    @Override // kr.switcher.switcherm.ui.ircommandregister.view.LinkerCommandRegisterView
    public void hideProgressbar() {
        IOUtil.hideProgressbarDialog(this, this.pb_registering);
    }

    @Override // kr.switcher.switcherm.ui.ircommandregister.view.LinkerCommandRegisterView
    public void inactiveRegisterButton() {
        this.btn_command_register.setTextColor(IOUtil.getColorResource(R.color.silver_three));
        this.btn_command_register.setBackground(IOUtil.getDrawable(R.drawable.shape_off_blue_fill));
    }

    @Override // kr.switcher.switcherm.ui.ircommandregister.view.LinkerCommandRegisterView
    public void activeRegisterButton() {
        this.btn_command_register.setTextColor(IOUtil.getColorResource(R.color.periwinkle));
        this.btn_command_register.setBackground(IOUtil.getDrawable(R.drawable.shape_white_fill));
    }

    @Override // kr.switcher.switcherm.ui.ircommandregister.view.LinkerCommandRegisterView
    public void showWarningToastForRegister() {
        IOUtil.showToast("명령어 이름을 입력해 주세요.");
    }

    @Override // kr.switcher.switcherm.ui.ircommandregister.view.LinkerCommandRegisterView
    public void moveInsertCommandScreen() {
        finish();
        Intent intent = new Intent(this, (Class<?>) IrCommandTestActivity.class);
        intent.putExtra(PARM_REMOCON_KEY, this.remocon.getMacAddress());
        intent.putExtra(IrCommandTestActivity.PARM_COMMAND_NAME, this.et_command.getText().toString());
        startActivity(intent);
    }

    @Override // kr.switcher.switcherm.ui.ircommandregister.view.LinkerCommandRegisterView
    public void moveIRBrandActivity() {
        Intent intent = new Intent(this, (Class<?>) IRBrandActivity.class);
        finish();
        startActivity(intent);
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.presenter.onTextChanged(this.et_command.getText().toString());
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6) {
            return true;
        }
        IOUtil.hideKeyBoard(this.et_command);
        return true;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        this.presenter.onBackPressed();
    }

    @Override // kr.switcher.switcherm.ui.ircommandregister.view.LinkerCommandRegisterView
    public boolean checkIsOverlapCommand(String str) {
        return this.presenter.checkIsOverlapCommand(str, this.remoconCommandItemList).booleanValue();
    }

    @Override // kr.switcher.switcherm.ui.ircommandregister.view.LinkerCommandRegisterView
    public void showOverlapCommandNameComment() {
        IOUtil.showToast("중복된 이름의 명령어가 존재합니다. 이름을 변경해 주세요.");
    }

    @Override // kr.switcher.switcherm.ui.main.interactors.FindAirconIRCommandInteractor.OnFindAirconIRCommandListener
    public void onFind(List<IRCommand> list) {
        this.remoconCommandItemList = list;
    }
}
