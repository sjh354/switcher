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
import kr.switcher.device.remocon.IRCommand;
import kr.switcher.device.remocon.Remocon;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.device.IODeviceHandler;
import kr.switcher.switcherm.ui.ircommandregister.LinkerCommandRegisterActivity;
import kr.switcher.switcherm.ui.ircommandtest.IrCommandTestActivity;
import kr.switcher.switcherm.ui.ircommandtest.IrCommandTestScreenController;
import kr.switcher.switcherm.ui.ircommandtest.interactor.CreateIRCommandInteractor;
import kr.switcher.switcherm.ui.ircommandtest.presenter.LinkerInsertIrCommandPresenter;
import kr.switcher.switcherm.ui.ircommandtest.view.InsertFragmentView;

/* JADX INFO: loaded from: classes2.dex */
public class LinkerInsertIrCommandFragment extends Fragment implements InsertFragmentView, CreateIRCommandInteractor.OnCreateIRCommandListener {

    @BindView(R.id.btn_insert_command)
    TextView btn_insert_command;
    private String commandName;
    private CountDownTimer countDownTimer;
    private IRCommand irCommand;
    private LinkerInsertIrCommandPresenter presenter;
    private Remocon remocon;

    @BindView(R.id.tv_command_name)
    TextView tv_command_name;

    public static LinkerInsertIrCommandFragment newInstance(String str, String str2) {
        LinkerInsertIrCommandFragment linkerInsertIrCommandFragment = new LinkerInsertIrCommandFragment();
        Bundle bundle = new Bundle();
        bundle.putString(LinkerCommandRegisterActivity.PARM_REMOCON_KEY, str);
        bundle.putString(IrCommandTestActivity.PARM_COMMAND_NAME, str2);
        linkerInsertIrCommandFragment.setArguments(bundle);
        return linkerInsertIrCommandFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_linker_insert_ir_command, viewGroup, false);
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
        String string = arguments.getString(IrCommandTestActivity.PARM_COMMAND_NAME);
        this.commandName = string;
        this.tv_command_name.setText(string);
        this.tv_command_name.setTextColor(R.color.periwinkle);
        LinkerInsertIrCommandPresenter linkerInsertIrCommandPresenter = new LinkerInsertIrCommandPresenter(this, new CreateIRCommandInteractor(this));
        this.presenter = linkerInsertIrCommandPresenter;
        linkerInsertIrCommandPresenter.onCreateView();
        return viewInflate;
    }

    @OnClick({R.id.btn_insert_command})
    public void onCommandInsertButtonClicked() {
        this.presenter.onCommandInsertButtonClicked(this.commandName);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // kr.switcher.switcherm.ui.ircommandtest.view.InsertFragmentView
    public void showErrorMessage(String str) {
        IOUtil.showToast(str);
    }

    /* JADX WARN: Type inference failed for: r6v0, types: [kr.switcher.switcherm.ui.ircommandtest.fragment.LinkerInsertIrCommandFragment$1] */
    @Override // kr.switcher.switcherm.ui.ircommandtest.view.InsertFragmentView
    public void countdown() {
        this.countDownTimer = new CountDownTimer(10000L, 1000L) { // from class: kr.switcher.switcherm.ui.ircommandtest.fragment.LinkerInsertIrCommandFragment.1
            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                LinkerInsertIrCommandFragment.this.btn_insert_command.setText(String.valueOf(j / 1000) + IOUtil.getStringResource(R.string.sec));
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                LinkerInsertIrCommandFragment.this.btn_insert_command.setText("0초");
                LinkerInsertIrCommandFragment.this.moveIRCommandTestScreen();
            }
        }.start();
    }

    @Override // kr.switcher.switcherm.ui.ircommandtest.view.InsertFragmentView
    public void finish() {
        getActivity().finish();
    }

    @Override // kr.switcher.switcherm.ui.ircommandtest.view.InsertFragmentView
    public void inactiveRegisterButton() {
        this.btn_insert_command.setBackground(IOUtil.getDrawable(R.drawable.shape_white_fill));
        this.btn_insert_command.setEnabled(false);
    }

    @Override // kr.switcher.switcherm.ui.ircommandtest.view.InsertFragmentView
    public void activeRegisterButton() {
        this.btn_insert_command.setTextColor(IOUtil.getColorResource(R.color.periwinkle));
        this.btn_insert_command.setBackground(IOUtil.getDrawable(R.drawable.shape_periwinkle));
    }

    @Override // kr.switcher.switcherm.ui.ircommandtest.view.InsertFragmentView
    public void moveIRCommandTestScreen() {
        IrCommandTestScreenController.moveTestFragment((AppCompatActivity) getActivity(), this.remocon.getMacAddress(), this.irCommand);
    }

    @Override // kr.switcher.switcherm.ui.ircommandtest.view.InsertFragmentView
    public void showWarningToastForRegister() {
        IOUtil.showToast("에러발생!");
    }

    @Override // kr.switcher.switcherm.ui.ircommandtest.interactor.CreateIRCommandInteractor.OnCreateIRCommandListener
    public void onCreateIRCommand(IRCommand iRCommand) {
        this.remocon.addCommand(iRCommand);
        this.irCommand = iRCommand;
        iRCommand.setName(this.commandName);
    }

    @Override // kr.switcher.switcherm.ui.ircommandtest.interactor.CreateIRCommandInteractor.OnCreateIRCommandListener
    public void onError(String str) {
        this.presenter.onError();
    }
}
