package kr.switcher.switcherm.ui.ircommandtest.fragment;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.wang.avi.AVLoadingIndicatorView;
import kr.switcher.device.remocon.IRCommand;
import kr.switcher.device.remocon.Remocon;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.device.IODeviceHandler;
import kr.switcher.switcherm.ui.ircommandregister.LinkerCommandRegisterActivity;
import kr.switcher.switcherm.ui.ircommandtest.IrCommandTestActivity;
import kr.switcher.switcherm.ui.ircommandtest.IrCommandTestScreenController;
import kr.switcher.switcherm.ui.ircommandtest.interactor.TestIRCommandInteractor;
import kr.switcher.switcherm.ui.ircommandtest.presenter.LinkerTestIrCommandPresenter;
import kr.switcher.switcherm.ui.ircommandtest.view.TestFragmentView;

/* JADX INFO: loaded from: classes2.dex */
public class LinkerTestIrCommandFragment extends Fragment implements TestFragmentView, TestIRCommandInteractor.OnTestIRCommandListener, TestIRCommandInteractor.OnMatchingIRCommandListener, TestIRCommandInteractor.OnConfirmIRCommandListener, TestIRCommandInteractor.OnDeleteIRCommandListener {

    @BindView(R.id.btn_test_command)
    TextView btn_test_command;
    private String commandName;
    private CountDownTimer countDownTimer;
    private IRCommand irCommand;
    private String ir_id;

    @BindView(R.id.pb_registering)
    AVLoadingIndicatorView pb_registering;
    private LinkerTestIrCommandPresenter presenter;
    private Remocon remocon;

    @Override // kr.switcher.switcherm.ui.ircommandtest.interactor.TestIRCommandInteractor.OnDeleteIRCommandListener
    public void onDeleteSuccess() {
    }

    public static LinkerTestIrCommandFragment newInstance(String str, IRCommand iRCommand) {
        LinkerTestIrCommandFragment linkerTestIrCommandFragment = new LinkerTestIrCommandFragment();
        Bundle bundle = new Bundle();
        bundle.putString(IrCommandTestActivity.PARM_COMMAND_NAME, iRCommand.getName());
        bundle.putString(LinkerCommandRegisterActivity.PARM_REMOCON_KEY, str);
        bundle.putString(IrCommandTestActivity.PARM_IR_ID, iRCommand.getId());
        linkerTestIrCommandFragment.setArguments(bundle);
        return linkerTestIrCommandFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_linker_test_ir_command, viewGroup, false);
        ButterKnife.bind(this, viewInflate);
        Bundle arguments = getArguments();
        if (arguments == null) {
            return null;
        }
        Remocon remocon = (Remocon) IODeviceHandler.getInstance().getDevice(arguments.getString(LinkerCommandRegisterActivity.PARM_REMOCON_KEY));
        this.remocon = remocon;
        if (remocon == null) {
            return null;
        }
        this.commandName = arguments.getString(IrCommandTestActivity.PARM_COMMAND_NAME);
        this.ir_id = arguments.getString(IrCommandTestActivity.PARM_IR_ID);
        LinkerTestIrCommandPresenter linkerTestIrCommandPresenter = new LinkerTestIrCommandPresenter(this, new TestIRCommandInteractor(this, this, this, this));
        this.presenter = linkerTestIrCommandPresenter;
        linkerTestIrCommandPresenter.onCreateView();
        return viewInflate;
    }

    @OnClick({R.id.btn_test_command})
    public void onTestBtnClicked() {
        this.presenter.onTestBtnClicked(this.ir_id);
    }

    @Override // kr.switcher.switcherm.ui.ircommandtest.view.TestFragmentView
    public void moveIRCommandInsertScreen() {
        IrCommandTestScreenController.moveInsertFragment((AppCompatActivity) getActivity(), this.remocon.getMacAddress(), this.irCommand.getName());
    }

    @Override // kr.switcher.switcherm.ui.ircommandtest.view.TestFragmentView
    public void activeTestButton() {
        this.btn_test_command.setTextColor(IOUtil.getColorResource(R.color.periwinkle));
        this.btn_test_command.setBackground(IOUtil.getDrawable(R.drawable.shape_periwinkle));
    }

    @Override // kr.switcher.switcherm.ui.ircommandtest.view.TestFragmentView
    public void inactiveTestButton() {
        this.btn_test_command.setTextColor(IOUtil.getColorResource(R.color.white_three));
        this.btn_test_command.setBackground(IOUtil.getDrawable(R.drawable.shape_white_fill));
        this.btn_test_command.setText(" ");
        this.btn_test_command.setEnabled(false);
    }

    @Override // kr.switcher.switcherm.ui.ircommandtest.view.TestFragmentView
    public void hideProgressBar() {
        IOUtil.hideProgressbarDialog(getActivity(), this.pb_registering);
    }

    @Override // kr.switcher.switcherm.ui.ircommandtest.view.TestFragmentView
    public void showProgressBar(int i) {
        IOUtil.showProgressbarDialog(getActivity(), this.pb_registering, i);
    }

    @Override // kr.switcher.switcherm.ui.ircommandtest.view.TestFragmentView
    public void finish() {
        getActivity().finish();
    }

    /* JADX WARN: Type inference failed for: r6v0, types: [kr.switcher.switcherm.ui.ircommandtest.fragment.LinkerTestIrCommandFragment$1] */
    @Override // kr.switcher.switcherm.ui.ircommandtest.view.TestFragmentView
    public void showTestDialog() {
        this.countDownTimer = new CountDownTimer(2000L, 1000L) { // from class: kr.switcher.switcherm.ui.ircommandtest.fragment.LinkerTestIrCommandFragment.1
            @Override // android.os.CountDownTimer
            public void onTick(long j) {
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                new MaterialDialog.Builder(LinkerTestIrCommandFragment.this.getContext()).content("명령어가 작동 되었나요?").positiveText("예").negativeText("아니오").negativeColor(R.color.periwinkle).positiveColor(R.color.periwinkle).onPositive(new MaterialDialog.SingleButtonCallback() { // from class: kr.switcher.switcherm.ui.ircommandtest.fragment.LinkerTestIrCommandFragment.1.2
                    @Override // com.afollestad.materialdialogs.MaterialDialog.SingleButtonCallback
                    public void onClick(MaterialDialog materialDialog, DialogAction dialogAction) {
                        LinkerTestIrCommandFragment.this.presenter.onConfirmIRCommand(LinkerTestIrCommandFragment.this.irCommand);
                    }
                }).onNegative(new MaterialDialog.SingleButtonCallback() { // from class: kr.switcher.switcherm.ui.ircommandtest.fragment.LinkerTestIrCommandFragment.1.1
                    @Override // com.afollestad.materialdialogs.MaterialDialog.SingleButtonCallback
                    public void onClick(MaterialDialog materialDialog, DialogAction dialogAction) {
                        LinkerTestIrCommandFragment.this.remocon.removeCommand(LinkerTestIrCommandFragment.this.ir_id);
                        LinkerTestIrCommandFragment.this.presenter.onDeleteIRCommand(LinkerTestIrCommandFragment.this.irCommand);
                        LinkerTestIrCommandFragment.this.moveIRCommandInsertScreen();
                    }
                }).cancelable(false).show();
            }
        }.start();
    }

    @Override // kr.switcher.switcherm.ui.ircommandtest.interactor.TestIRCommandInteractor.OnMatchingIRCommandListener
    public void onMatchingSuccess() {
        finish();
    }

    @Override // kr.switcher.switcherm.ui.ircommandtest.interactor.TestIRCommandInteractor.OnConfirmIRCommandListener
    public void onConfirmSuccess() {
        this.presenter.onMatchingCommand(this.remocon, this.irCommand);
    }

    @Override // kr.switcher.switcherm.ui.ircommandtest.interactor.TestIRCommandInteractor.OnTestIRCommandListener
    public void onTestIRCommand(IRCommand iRCommand) {
        this.irCommand = iRCommand;
        iRCommand.setName(this.commandName);
        this.remocon.removeCommand(iRCommand.getId());
        this.remocon.addCommand(iRCommand);
    }

    @Override // kr.switcher.switcherm.ui.ircommandtest.interactor.TestIRCommandInteractor.OnTestIRCommandListener, kr.switcher.switcherm.ui.ircommandtest.interactor.TestIRCommandInteractor.OnMatchingIRCommandListener, kr.switcher.switcherm.ui.ircommandtest.interactor.TestIRCommandInteractor.OnConfirmIRCommandListener, kr.switcher.switcherm.ui.ircommandtest.interactor.TestIRCommandInteractor.OnDeleteIRCommandListener
    public void onError(String str) {
        this.presenter.onError(str);
    }
}
