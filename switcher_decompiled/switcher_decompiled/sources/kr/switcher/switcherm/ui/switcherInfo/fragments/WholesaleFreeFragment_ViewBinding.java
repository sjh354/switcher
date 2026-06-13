package kr.switcher.switcherm.ui.switcherInfo.fragments;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import kr.switcher.switcherm.R;

/* JADX INFO: loaded from: classes2.dex */
public class WholesaleFreeFragment_ViewBinding implements Unbinder {
    private WholesaleFreeFragment target;

    public WholesaleFreeFragment_ViewBinding(WholesaleFreeFragment wholesaleFreeFragment, View view) {
        this.target = wholesaleFreeFragment;
        wholesaleFreeFragment.iv_switcher_icon = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_switcher_icon, "field 'iv_switcher_icon'", ImageView.class);
        wholesaleFreeFragment.tv_switcher_type = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_switcher_type, "field 'tv_switcher_type'", TextView.class);
        wholesaleFreeFragment.tv_room_name = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_room_name, "field 'tv_room_name'", TextView.class);
        wholesaleFreeFragment.tv_owner = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_owner, "field 'tv_owner'", TextView.class);
        wholesaleFreeFragment.tv_serial_number = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_serial_number, "field 'tv_serial_number'", TextView.class);
        wholesaleFreeFragment.tv_share_code = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_share_code, "field 'tv_share_code'", TextView.class);
        wholesaleFreeFragment.tv_payment_card = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_payment_card, "field 'tv_payment_card'", TextView.class);
        wholesaleFreeFragment.tv_first_payment_at = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_first_payment_at, "field 'tv_first_payment_at'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        WholesaleFreeFragment wholesaleFreeFragment = this.target;
        if (wholesaleFreeFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        wholesaleFreeFragment.iv_switcher_icon = null;
        wholesaleFreeFragment.tv_switcher_type = null;
        wholesaleFreeFragment.tv_room_name = null;
        wholesaleFreeFragment.tv_owner = null;
        wholesaleFreeFragment.tv_serial_number = null;
        wholesaleFreeFragment.tv_share_code = null;
        wholesaleFreeFragment.tv_payment_card = null;
        wholesaleFreeFragment.tv_first_payment_at = null;
    }
}
