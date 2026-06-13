package kr.switcher.switcherm.ui.irbrand.fragment;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.ui.irbrand.viewpager.IRBrandViewPager;
import me.relex.circleindicator.CircleIndicator;

/* JADX INFO: loaded from: classes2.dex */
public class IRBrandProductSelectFragment_ViewBinding implements Unbinder {
    private IRBrandProductSelectFragment target;
    private View view7f090068;

    public IRBrandProductSelectFragment_ViewBinding(final IRBrandProductSelectFragment iRBrandProductSelectFragment, View view) {
        this.target = iRBrandProductSelectFragment;
        iRBrandProductSelectFragment.ci_propose = (CircleIndicator) Utils.findRequiredViewAsType(view, R.id.ci_propose, "field 'ci_propose'", CircleIndicator.class);
        iRBrandProductSelectFragment.vp_propose = (IRBrandViewPager) Utils.findRequiredViewAsType(view, R.id.vp_propose, "field 'vp_propose'", IRBrandViewPager.class);
        iRBrandProductSelectFragment.iv_left_arrow_btn = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_left_arrow_btn, "field 'iv_left_arrow_btn'", ImageView.class);
        iRBrandProductSelectFragment.iv_right_arrow_btn = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_right_arrow_btn, "field 'iv_right_arrow_btn'", ImageView.class);
        iRBrandProductSelectFragment.rl_left_arrow_btn = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_left_arrow_btn, "field 'rl_left_arrow_btn'", RelativeLayout.class);
        iRBrandProductSelectFragment.rl_right_arrow_btn = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_right_arrow_btn, "field 'rl_right_arrow_btn'", RelativeLayout.class);
        iRBrandProductSelectFragment.tv_controller_name = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_controller_name, "field 'tv_controller_name'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.btn_controller_register, "field 'btn_controller_register' and method 'onRegisterBtnClicked'");
        iRBrandProductSelectFragment.btn_controller_register = (TextView) Utils.castView(viewFindRequiredView, R.id.btn_controller_register, "field 'btn_controller_register'", TextView.class);
        this.view7f090068 = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.irbrand.fragment.IRBrandProductSelectFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                iRBrandProductSelectFragment.onRegisterBtnClicked();
            }
        });
        iRBrandProductSelectFragment.et_controller_name = (EditText) Utils.findRequiredViewAsType(view, R.id.et_controller_name, "field 'et_controller_name'", EditText.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        IRBrandProductSelectFragment iRBrandProductSelectFragment = this.target;
        if (iRBrandProductSelectFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        iRBrandProductSelectFragment.ci_propose = null;
        iRBrandProductSelectFragment.vp_propose = null;
        iRBrandProductSelectFragment.iv_left_arrow_btn = null;
        iRBrandProductSelectFragment.iv_right_arrow_btn = null;
        iRBrandProductSelectFragment.rl_left_arrow_btn = null;
        iRBrandProductSelectFragment.rl_right_arrow_btn = null;
        iRBrandProductSelectFragment.tv_controller_name = null;
        iRBrandProductSelectFragment.btn_controller_register = null;
        iRBrandProductSelectFragment.et_controller_name = null;
        this.view7f090068.setOnClickListener(null);
        this.view7f090068 = null;
    }
}
