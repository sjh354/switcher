package kr.switcher.switcherm.ui.switcherInfo.fragments;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import kr.switcher.switcherm.R;

/* JADX INFO: loaded from: classes2.dex */
public class FreeTrialFragment_ViewBinding implements Unbinder {
    private FreeTrialFragment target;

    public FreeTrialFragment_ViewBinding(FreeTrialFragment freeTrialFragment, View view) {
        this.target = freeTrialFragment;
        freeTrialFragment.iv_switcher_icon = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_switcher_icon, "field 'iv_switcher_icon'", ImageView.class);
        freeTrialFragment.tv_switcher_type = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_switcher_type, "field 'tv_switcher_type'", TextView.class);
        freeTrialFragment.tv_room_name = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_room_name, "field 'tv_room_name'", TextView.class);
        freeTrialFragment.tv_owner = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_owner, "field 'tv_owner'", TextView.class);
        freeTrialFragment.tv_serial_number = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_serial_number, "field 'tv_serial_number'", TextView.class);
        freeTrialFragment.tv_share_code = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_share_code, "field 'tv_share_code'", TextView.class);
        freeTrialFragment.tv_payment_card = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_payment_card, "field 'tv_payment_card'", TextView.class);
        freeTrialFragment.tv_first_payment_at = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_first_payment_at, "field 'tv_first_payment_at'", TextView.class);
        freeTrialFragment.tv_payment_type = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_payment_type, "field 'tv_payment_type'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        FreeTrialFragment freeTrialFragment = this.target;
        if (freeTrialFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        freeTrialFragment.iv_switcher_icon = null;
        freeTrialFragment.tv_switcher_type = null;
        freeTrialFragment.tv_room_name = null;
        freeTrialFragment.tv_owner = null;
        freeTrialFragment.tv_serial_number = null;
        freeTrialFragment.tv_share_code = null;
        freeTrialFragment.tv_payment_card = null;
        freeTrialFragment.tv_first_payment_at = null;
        freeTrialFragment.tv_payment_type = null;
    }
}
