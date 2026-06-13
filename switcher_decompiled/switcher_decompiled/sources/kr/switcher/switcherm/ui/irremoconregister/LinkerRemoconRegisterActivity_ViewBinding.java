package kr.switcher.switcherm.ui.irremoconregister;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.wang.avi.AVLoadingIndicatorView;
import kr.switcher.switcherm.R;

/* JADX INFO: loaded from: classes2.dex */
public class LinkerRemoconRegisterActivity_ViewBinding implements Unbinder {
    private LinkerRemoconRegisterActivity target;
    private View view7f090089;
    private View view7f09008d;

    public LinkerRemoconRegisterActivity_ViewBinding(LinkerRemoconRegisterActivity linkerRemoconRegisterActivity) {
        this(linkerRemoconRegisterActivity, linkerRemoconRegisterActivity.getWindow().getDecorView());
    }

    public LinkerRemoconRegisterActivity_ViewBinding(final LinkerRemoconRegisterActivity linkerRemoconRegisterActivity, View view) {
        this.target = linkerRemoconRegisterActivity;
        linkerRemoconRegisterActivity.et_remocon_name = (EditText) Utils.findRequiredViewAsType(view, R.id.et_remocon_name, "field 'et_remocon_name'", EditText.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.btn_remocon_register, "field 'btn_remocon_register' and method 'onRegisterButtonClicked'");
        linkerRemoconRegisterActivity.btn_remocon_register = (TextView) Utils.castView(viewFindRequiredView, R.id.btn_remocon_register, "field 'btn_remocon_register'", TextView.class);
        this.view7f09008d = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.irremoconregister.LinkerRemoconRegisterActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                linkerRemoconRegisterActivity.onRegisterButtonClicked();
            }
        });
        linkerRemoconRegisterActivity.pb_registering = (AVLoadingIndicatorView) Utils.findRequiredViewAsType(view, R.id.pb_registering, "field 'pb_registering'", AVLoadingIndicatorView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.btn_previous, "method 'onCancelButtonClicked'");
        this.view7f090089 = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.irremoconregister.LinkerRemoconRegisterActivity_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                linkerRemoconRegisterActivity.onCancelButtonClicked();
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        LinkerRemoconRegisterActivity linkerRemoconRegisterActivity = this.target;
        if (linkerRemoconRegisterActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        linkerRemoconRegisterActivity.et_remocon_name = null;
        linkerRemoconRegisterActivity.btn_remocon_register = null;
        linkerRemoconRegisterActivity.pb_registering = null;
        this.view7f09008d.setOnClickListener(null);
        this.view7f09008d = null;
        this.view7f090089.setOnClickListener(null);
        this.view7f090089 = null;
    }
}
