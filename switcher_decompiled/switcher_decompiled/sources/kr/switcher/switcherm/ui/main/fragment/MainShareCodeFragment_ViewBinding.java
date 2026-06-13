package kr.switcher.switcherm.ui.main.fragment;

import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import kr.switcher.switcherm.R;

/* JADX INFO: loaded from: classes2.dex */
public class MainShareCodeFragment_ViewBinding implements Unbinder {
    private MainShareCodeFragment target;
    private View view7f090072;
    private View view7f09008b;
    private View view7f09008f;

    public MainShareCodeFragment_ViewBinding(final MainShareCodeFragment mainShareCodeFragment, View view) {
        this.target = mainShareCodeFragment;
        mainShareCodeFragment.pb_comparing = (ProgressBar) Utils.findRequiredViewAsType(view, R.id.pb_comparing, "field 'pb_comparing'", ProgressBar.class);
        mainShareCodeFragment.et_share_code = (EditText) Utils.findRequiredViewAsType(view, R.id.et_share_code, "field 'et_share_code'", EditText.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.btn_request_share_code, "field 'btn_request_share_code' and method 'onRequestShareCodeButtonClicked'");
        mainShareCodeFragment.btn_request_share_code = (TextView) Utils.castView(viewFindRequiredView, R.id.btn_request_share_code, "field 'btn_request_share_code'", TextView.class);
        this.view7f09008f = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.main.fragment.MainShareCodeFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                mainShareCodeFragment.onRequestShareCodeButtonClicked();
            }
        });
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.btn_input_share_code, "field 'btn_input_share_code' and method 'onInputShareCodeButtonClicked'");
        mainShareCodeFragment.btn_input_share_code = (RelativeLayout) Utils.castView(viewFindRequiredView2, R.id.btn_input_share_code, "field 'btn_input_share_code'", RelativeLayout.class);
        this.view7f090072 = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.main.fragment.MainShareCodeFragment_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                mainShareCodeFragment.onInputShareCodeButtonClicked();
            }
        });
        mainShareCodeFragment.rl_product_image = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_product_image, "field 'rl_product_image'", RelativeLayout.class);
        mainShareCodeFragment.lin_request = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.lin_request, "field 'lin_request'", LinearLayout.class);
        mainShareCodeFragment.lin_refresh = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.lin_refresh, "field 'lin_refresh'", LinearLayout.class);
        mainShareCodeFragment.lin_request_1 = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.lin_request_1, "field 'lin_request_1'", LinearLayout.class);
        mainShareCodeFragment.lin_request_2 = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.lin_request_2, "field 'lin_request_2'", LinearLayout.class);
        mainShareCodeFragment.lin_request_3 = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.lin_request_3, "field 'lin_request_3'", LinearLayout.class);
        mainShareCodeFragment.lin_share_code_input = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.lin_share_code_input, "field 'lin_share_code_input'", LinearLayout.class);
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.btn_refresh, "method 'onRefreshInternetStatusButtonClicked'");
        this.view7f09008b = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.main.fragment.MainShareCodeFragment_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                mainShareCodeFragment.onRefreshInternetStatusButtonClicked();
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        MainShareCodeFragment mainShareCodeFragment = this.target;
        if (mainShareCodeFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        mainShareCodeFragment.pb_comparing = null;
        mainShareCodeFragment.et_share_code = null;
        mainShareCodeFragment.btn_request_share_code = null;
        mainShareCodeFragment.btn_input_share_code = null;
        mainShareCodeFragment.rl_product_image = null;
        mainShareCodeFragment.lin_request = null;
        mainShareCodeFragment.lin_refresh = null;
        mainShareCodeFragment.lin_request_1 = null;
        mainShareCodeFragment.lin_request_2 = null;
        mainShareCodeFragment.lin_request_3 = null;
        mainShareCodeFragment.lin_share_code_input = null;
        this.view7f09008f.setOnClickListener(null);
        this.view7f09008f = null;
        this.view7f090072.setOnClickListener(null);
        this.view7f090072 = null;
        this.view7f09008b.setOnClickListener(null);
        this.view7f09008b = null;
    }
}
