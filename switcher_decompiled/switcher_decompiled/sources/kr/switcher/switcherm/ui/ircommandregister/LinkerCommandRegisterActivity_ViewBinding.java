package kr.switcher.switcherm.ui.ircommandregister;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.wang.avi.AVLoadingIndicatorView;
import kr.switcher.switcherm.R;

/* JADX INFO: loaded from: classes2.dex */
public class LinkerCommandRegisterActivity_ViewBinding implements Unbinder {
    private LinkerCommandRegisterActivity target;
    private View view7f090066;
    private View view7f090089;

    public LinkerCommandRegisterActivity_ViewBinding(LinkerCommandRegisterActivity linkerCommandRegisterActivity) {
        this(linkerCommandRegisterActivity, linkerCommandRegisterActivity.getWindow().getDecorView());
    }

    public LinkerCommandRegisterActivity_ViewBinding(final LinkerCommandRegisterActivity linkerCommandRegisterActivity, View view) {
        this.target = linkerCommandRegisterActivity;
        linkerCommandRegisterActivity.et_command = (EditText) Utils.findRequiredViewAsType(view, R.id.et_command, "field 'et_command'", EditText.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.btn_command_register, "field 'btn_command_register' and method 'onCommandRegisterButtonClicked'");
        linkerCommandRegisterActivity.btn_command_register = (TextView) Utils.castView(viewFindRequiredView, R.id.btn_command_register, "field 'btn_command_register'", TextView.class);
        this.view7f090066 = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.ircommandregister.LinkerCommandRegisterActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                linkerCommandRegisterActivity.onCommandRegisterButtonClicked();
            }
        });
        linkerCommandRegisterActivity.pb_registering = (AVLoadingIndicatorView) Utils.findRequiredViewAsType(view, R.id.pb_registering, "field 'pb_registering'", AVLoadingIndicatorView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.btn_previous, "method 'onPreviousButtonClicked'");
        this.view7f090089 = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.ircommandregister.LinkerCommandRegisterActivity_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                linkerCommandRegisterActivity.onPreviousButtonClicked();
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        LinkerCommandRegisterActivity linkerCommandRegisterActivity = this.target;
        if (linkerCommandRegisterActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        linkerCommandRegisterActivity.et_command = null;
        linkerCommandRegisterActivity.btn_command_register = null;
        linkerCommandRegisterActivity.pb_registering = null;
        this.view7f090066.setOnClickListener(null);
        this.view7f090066 = null;
        this.view7f090089.setOnClickListener(null);
        this.view7f090089 = null;
    }
}
