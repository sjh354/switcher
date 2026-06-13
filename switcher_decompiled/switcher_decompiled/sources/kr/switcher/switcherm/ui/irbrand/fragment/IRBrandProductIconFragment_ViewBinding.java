package kr.switcher.switcherm.ui.irbrand.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import kr.switcher.switcherm.R;

/* JADX INFO: loaded from: classes2.dex */
public class IRBrandProductIconFragment_ViewBinding implements Unbinder {
    private IRBrandProductIconFragment target;

    public IRBrandProductIconFragment_ViewBinding(IRBrandProductIconFragment iRBrandProductIconFragment, View view) {
        this.target = iRBrandProductIconFragment;
        iRBrandProductIconFragment.iv_switcher_icon = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_ir_product_icon, "field 'iv_switcher_icon'", ImageView.class);
        iRBrandProductIconFragment.tv_propose_message = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_propose_message, "field 'tv_propose_message'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        IRBrandProductIconFragment iRBrandProductIconFragment = this.target;
        if (iRBrandProductIconFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        iRBrandProductIconFragment.iv_switcher_icon = null;
        iRBrandProductIconFragment.tv_propose_message = null;
    }
}
