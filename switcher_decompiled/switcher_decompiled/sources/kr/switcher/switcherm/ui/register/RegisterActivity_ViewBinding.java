package kr.switcher.switcherm.ui.register;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.wang.avi.AVLoadingIndicatorView;
import kr.switcher.switcherm.R;

/* JADX INFO: loaded from: classes2.dex */
public class RegisterActivity_ViewBinding implements Unbinder {
    private RegisterActivity target;
    private View view7f090060;
    private View view7f09008c;

    public RegisterActivity_ViewBinding(RegisterActivity registerActivity) {
        this(registerActivity, registerActivity.getWindow().getDecorView());
    }

    public RegisterActivity_ViewBinding(final RegisterActivity registerActivity, View view) {
        this.target = registerActivity;
        registerActivity.tv_production_number = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_production_number, "field 'tv_production_number'", TextView.class);
        registerActivity.et_owner = (EditText) Utils.findRequiredViewAsType(view, R.id.et_owner, "field 'et_owner'", EditText.class);
        registerActivity.et_room_name = (EditText) Utils.findRequiredViewAsType(view, R.id.et_room_name, "field 'et_room_name'", EditText.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.btn_register, "field 'btn_register' and method 'onRegisterButtonClicked'");
        registerActivity.btn_register = (TextView) Utils.castView(viewFindRequiredView, R.id.btn_register, "field 'btn_register'", TextView.class);
        this.view7f09008c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.register.RegisterActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                registerActivity.onRegisterButtonClicked();
            }
        });
        registerActivity.iv_switcher_type = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_switcher_type, "field 'iv_switcher_type'", ImageView.class);
        registerActivity.pb_registering = (AVLoadingIndicatorView) Utils.findRequiredViewAsType(view, R.id.pb_registering, "field 'pb_registering'", AVLoadingIndicatorView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.btn_cancel, "method 'onCancelButtonClicked'");
        this.view7f090060 = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.register.RegisterActivity_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                registerActivity.onCancelButtonClicked();
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        RegisterActivity registerActivity = this.target;
        if (registerActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        registerActivity.tv_production_number = null;
        registerActivity.et_owner = null;
        registerActivity.et_room_name = null;
        registerActivity.btn_register = null;
        registerActivity.iv_switcher_type = null;
        registerActivity.pb_registering = null;
        this.view7f09008c.setOnClickListener(null);
        this.view7f09008c = null;
        this.view7f090060.setOnClickListener(null);
        this.view7f090060 = null;
    }
}
