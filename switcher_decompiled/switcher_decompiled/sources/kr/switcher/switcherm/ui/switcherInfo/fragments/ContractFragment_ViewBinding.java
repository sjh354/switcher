package kr.switcher.switcherm.ui.switcherInfo.fragments;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import kr.switcher.switcherm.R;

/* JADX INFO: loaded from: classes2.dex */
public class ContractFragment_ViewBinding implements Unbinder {
    private ContractFragment target;

    public ContractFragment_ViewBinding(ContractFragment contractFragment, View view) {
        this.target = contractFragment;
        contractFragment.iv_switcher_icon = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_switcher_icon, "field 'iv_switcher_icon'", ImageView.class);
        contractFragment.tv_switcher_type = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_switcher_type, "field 'tv_switcher_type'", TextView.class);
        contractFragment.tv_room_name = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_room_name, "field 'tv_room_name'", TextView.class);
        contractFragment.tv_owner = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_owner, "field 'tv_owner'", TextView.class);
        contractFragment.tv_serial_number = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_serial_number, "field 'tv_serial_number'", TextView.class);
        contractFragment.tv_share_code = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_share_code, "field 'tv_share_code'", TextView.class);
        contractFragment.tv_payment_card = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_payment_card, "field 'tv_payment_card'", TextView.class);
        contractFragment.tv_next_payment_at = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_next_payment_at, "field 'tv_next_payment_at'", TextView.class);
        contractFragment.tv_payment_type = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_payment_type, "field 'tv_payment_type'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        ContractFragment contractFragment = this.target;
        if (contractFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        contractFragment.iv_switcher_icon = null;
        contractFragment.tv_switcher_type = null;
        contractFragment.tv_room_name = null;
        contractFragment.tv_owner = null;
        contractFragment.tv_serial_number = null;
        contractFragment.tv_share_code = null;
        contractFragment.tv_payment_card = null;
        contractFragment.tv_next_payment_at = null;
        contractFragment.tv_payment_type = null;
    }
}
