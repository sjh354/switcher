package kr.switcher.switcherm.ui.irremoconregister;

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
import kr.switcher.device.remocon.Remocon;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.activity.IOActivity;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.ui.ircommandregister.LinkerCommandRegisterActivity;
import kr.switcher.switcherm.ui.irremoconregister.interactor.LinkerRemoconRegisterInteractor;
import kr.switcher.switcherm.ui.irremoconregister.presenter.LinkerRemoconRegisterPresenter;
import kr.switcher.switcherm.ui.irremoconregister.view.IrRemoconRegisterView;

/* JADX INFO: loaded from: classes2.dex */
public class LinkerRemoconRegisterActivity extends IOActivity implements IrRemoconRegisterView, TextWatcher, TextView.OnEditorActionListener, LinkerRemoconRegisterInteractor.OnCreateRemoconListener {

    @BindView(R.id.btn_remocon_register)
    TextView btn_remocon_register;

    @BindView(R.id.et_remocon_name)
    EditText et_remocon_name;

    @BindView(R.id.pb_registering)
    AVLoadingIndicatorView pb_registering;
    private LinkerRemoconRegisterPresenter presenter;

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // kr.switcher.switcherm.common.activity.IOActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_linker_remocon_register);
        ButterKnife.bind(this);
        LinkerRemoconRegisterPresenter linkerRemoconRegisterPresenter = new LinkerRemoconRegisterPresenter(this, new LinkerRemoconRegisterInteractor(this));
        this.presenter = linkerRemoconRegisterPresenter;
        linkerRemoconRegisterPresenter.onCreate();
        this.et_remocon_name.addTextChangedListener(this);
        this.et_remocon_name.setOnEditorActionListener(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    @OnClick({R.id.btn_previous})
    public void onCancelButtonClicked() {
        this.presenter.onCancelButtonClicked();
    }

    @OnClick({R.id.btn_remocon_register})
    public void onRegisterButtonClicked() {
        this.presenter.onRemoconRegisterButtonClicked(this.et_remocon_name.getText().toString());
    }

    @Override // kr.switcher.switcherm.ui.irremoconregister.view.IrRemoconRegisterView
    public void showErrorMessage(String str) {
        IOUtil.showToast(str);
    }

    @Override // kr.switcher.switcherm.ui.irremoconregister.view.IrRemoconRegisterView
    public void showProgressbar(int i) {
        IOUtil.showProgressbarDialog(this, this.pb_registering, i);
    }

    @Override // kr.switcher.switcherm.ui.irremoconregister.view.IrRemoconRegisterView
    public void hideProgressbar() {
        IOUtil.hideProgressbarDialog(this, this.pb_registering);
    }

    @Override // kr.switcher.switcherm.ui.irremoconregister.view.IrRemoconRegisterView
    public void inactiveRegisterButton() {
        this.btn_remocon_register.setTextColor(IOUtil.getColorResource(R.color.silver_three));
        this.btn_remocon_register.setBackground(IOUtil.getDrawable(R.drawable.shape_off_blue_fill));
    }

    @Override // kr.switcher.switcherm.ui.irremoconregister.view.IrRemoconRegisterView
    public void activeRegisterButton() {
        this.btn_remocon_register.setTextColor(IOUtil.getColorResource(R.color.periwinkle));
        this.btn_remocon_register.setBackground(IOUtil.getDrawable(R.drawable.shape_white_fill));
    }

    @Override // kr.switcher.switcherm.ui.irremoconregister.view.IrRemoconRegisterView
    public void showWarningToastForRegister() {
        IOUtil.showToast("리모컨 이름을 입력해 주세요.");
    }

    @Override // kr.switcher.switcherm.ui.irremoconregister.view.IrRemoconRegisterView
    public void moveIRCommandRegisterScreen(Remocon remocon) {
        Intent intent = new Intent(this, (Class<?>) LinkerCommandRegisterActivity.class);
        intent.putExtra(LinkerCommandRegisterActivity.PARM_REMOCON_KEY, remocon.getMacAddress());
        finish();
        startActivity(intent);
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.presenter.onTextChanged(this.et_remocon_name.getText().toString());
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6) {
            return true;
        }
        IOUtil.hideKeyBoard(this.et_remocon_name);
        return true;
    }

    @Override // kr.switcher.switcherm.ui.irremoconregister.interactor.LinkerRemoconRegisterInteractor.OnCreateRemoconListener
    public void onCreateRemocon(Remocon remocon) {
        this.presenter.onCreateRemocon(remocon);
    }

    @Override // kr.switcher.switcherm.ui.irremoconregister.interactor.LinkerRemoconRegisterInteractor.OnCreateRemoconListener
    public void onError(String str) {
        this.presenter.onError(str);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        onCancelButtonClicked();
        finish();
    }
}
