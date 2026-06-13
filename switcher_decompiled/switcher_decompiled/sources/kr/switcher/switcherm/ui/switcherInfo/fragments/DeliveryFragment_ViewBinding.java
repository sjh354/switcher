package kr.switcher.switcherm.ui.switcherInfo.fragments;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import kr.switcher.switcherm.R;

/* JADX INFO: loaded from: classes2.dex */
public class DeliveryFragment_ViewBinding implements Unbinder {
    private DeliveryFragment target;
    private View view7f090058;

    public DeliveryFragment_ViewBinding(final DeliveryFragment deliveryFragment, View view) {
        this.target = deliveryFragment;
        deliveryFragment.iv_switcher_icon = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_switcher_icon, "field 'iv_switcher_icon'", ImageView.class);
        deliveryFragment.tv_switcher_name = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_switcher_name, "field 'tv_switcher_name'", TextView.class);
        deliveryFragment.tv_owner = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_owner, "field 'tv_owner'", TextView.class);
        deliveryFragment.tv_serial_number = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_serial_number, "field 'tv_serial_number'", TextView.class);
        deliveryFragment.tv_phone_number = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_phone_number, "field 'tv_phone_number'", TextView.class);
        deliveryFragment.tv_shipping_address1 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_shipping_address1, "field 'tv_shipping_address1'", TextView.class);
        deliveryFragment.tv_shipping_address2 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_shipping_address2, "field 'tv_shipping_address2'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.btn_answer_kakaotalk, "method 'onAnswerKakaotalkButtonClicked'");
        this.view7f090058 = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.switcherInfo.fragments.DeliveryFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                deliveryFragment.onAnswerKakaotalkButtonClicked();
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        DeliveryFragment deliveryFragment = this.target;
        if (deliveryFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        deliveryFragment.iv_switcher_icon = null;
        deliveryFragment.tv_switcher_name = null;
        deliveryFragment.tv_owner = null;
        deliveryFragment.tv_serial_number = null;
        deliveryFragment.tv_phone_number = null;
        deliveryFragment.tv_shipping_address1 = null;
        deliveryFragment.tv_shipping_address2 = null;
        this.view7f090058.setOnClickListener(null);
        this.view7f090058 = null;
    }
}
