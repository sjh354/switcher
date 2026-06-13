package kr.switcher.switcherm.ui.switcherInfo.fragments;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import kr.switcher.switcherm.R;

/* JADX INFO: loaded from: classes2.dex */
public class WholesaleFragment_ViewBinding implements Unbinder {
    private WholesaleFragment target;
    private View view7f090071;

    public WholesaleFragment_ViewBinding(final WholesaleFragment wholesaleFragment, View view) {
        this.target = wholesaleFragment;
        wholesaleFragment.lin_owner_menu = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.lin_owner_menu, "field 'lin_owner_menu'", LinearLayout.class);
        wholesaleFragment.iv_switcher_icon = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_switcher_icon, "field 'iv_switcher_icon'", ImageView.class);
        wholesaleFragment.tv_switcher_type = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_switcher_type, "field 'tv_switcher_type'", TextView.class);
        wholesaleFragment.tv_room_name = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_room_name, "field 'tv_room_name'", TextView.class);
        wholesaleFragment.tv_owner = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_owner, "field 'tv_owner'", TextView.class);
        wholesaleFragment.tv_serial_number = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_serial_number, "field 'tv_serial_number'", TextView.class);
        wholesaleFragment.tv_share_code = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_share_code, "field 'tv_share_code'", TextView.class);
        wholesaleFragment.tv_warranty_date = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_warranty_date, "field 'tv_warranty_date'", TextView.class);
        wholesaleFragment.pb_initialize = (ProgressBar) Utils.findRequiredViewAsType(view, R.id.pb_initialize, "field 'pb_initialize'", ProgressBar.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.btn_initialize, "field 'btn_initialize' and method 'onInitializeButtonClicked'");
        wholesaleFragment.btn_initialize = (TextView) Utils.castView(viewFindRequiredView, R.id.btn_initialize, "field 'btn_initialize'", TextView.class);
        this.view7f090071 = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.switcherInfo.fragments.WholesaleFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                wholesaleFragment.onInitializeButtonClicked();
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        WholesaleFragment wholesaleFragment = this.target;
        if (wholesaleFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        wholesaleFragment.lin_owner_menu = null;
        wholesaleFragment.iv_switcher_icon = null;
        wholesaleFragment.tv_switcher_type = null;
        wholesaleFragment.tv_room_name = null;
        wholesaleFragment.tv_owner = null;
        wholesaleFragment.tv_serial_number = null;
        wholesaleFragment.tv_share_code = null;
        wholesaleFragment.tv_warranty_date = null;
        wholesaleFragment.pb_initialize = null;
        wholesaleFragment.btn_initialize = null;
        this.view7f090071.setOnClickListener(null);
        this.view7f090071 = null;
    }
}
