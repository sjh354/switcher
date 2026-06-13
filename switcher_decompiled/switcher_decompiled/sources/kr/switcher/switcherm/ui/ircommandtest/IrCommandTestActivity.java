package kr.switcher.switcherm.ui.ircommandtest;

import android.os.Bundle;
import butterknife.ButterKnife;
import butterknife.OnClick;
import kr.switcher.device.remocon.Remocon;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.activity.IOActivity;
import kr.switcher.switcherm.device.IODeviceHandler;
import kr.switcher.switcherm.ui.ircommandregister.LinkerCommandRegisterActivity;
import kr.switcher.switcherm.ui.ircommandtest.fragment.LinkerInsertIrCommandFragment;
import kr.switcher.switcherm.ui.ircommandtest.presenter.IRCommandTestPresenter;
import kr.switcher.switcherm.ui.ircommandtest.view.IrCommandTestView;

/* JADX INFO: loaded from: classes2.dex */
public class IrCommandTestActivity extends IOActivity implements IrCommandTestView {
    public static final String PARM_COMMAND_NAME = "COMMAND_NAME";
    public static final String PARM_IR_ID = "IR_ID";
    private String commandName;
    private LinkerInsertIrCommandFragment linkerInsertIrCommandFragment;
    private IRCommandTestPresenter presenter;
    private Remocon remocon;
    private String remoconKey;

    @Override // kr.switcher.switcherm.common.activity.IOActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.remoconKey = getIntent().getStringExtra(LinkerCommandRegisterActivity.PARM_REMOCON_KEY);
        this.commandName = getIntent().getStringExtra(PARM_COMMAND_NAME);
        Remocon remocon = (Remocon) IODeviceHandler.getInstance().getDevice(this.remoconKey);
        this.remocon = remocon;
        if (remocon == null || this.commandName == null) {
            finish();
            return;
        }
        setContentView(R.layout.activity_ir_command_test);
        ButterKnife.bind(this);
        this.presenter = new IRCommandTestPresenter(this);
        this.linkerInsertIrCommandFragment = LinkerInsertIrCommandFragment.newInstance(this.remoconKey, this.commandName);
        IrCommandTestScreenController.moveInsertFragment(this, this.remoconKey, this.commandName);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    @OnClick({R.id.btn_previous})
    public void onPreviousButtonClicked() {
        this.presenter.onPreviousButtonClicked(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        this.presenter.onPreviousButtonClicked(this);
    }

    @Override // kr.switcher.switcherm.ui.ircommandtest.view.IrCommandTestView
    public void finishActivity() {
        finish();
    }

    @Override // kr.switcher.switcherm.ui.ircommandtest.view.IrCommandTestView
    public void moveIRCommandInsertFragment() {
        IrCommandTestScreenController.moveInsertFragment(this, this.remoconKey, this.commandName);
    }
}
