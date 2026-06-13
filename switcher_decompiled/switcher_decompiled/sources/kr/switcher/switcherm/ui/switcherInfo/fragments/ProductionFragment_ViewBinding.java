package kr.switcher.switcherm.ui.switcherInfo.fragments;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import kr.switcher.switcherm.R;

/* JADX INFO: loaded from: classes2.dex */
public class ProductionFragment_ViewBinding implements Unbinder {
    private ProductionFragment target;
    private View view7f090058;
    private View view7f09032d;

    public ProductionFragment_ViewBinding(final ProductionFragment productionFragment, View view) {
        this.target = productionFragment;
        productionFragment.iv_switcher_icon = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_switcher_icon, "field 'iv_switcher_icon'", ImageView.class);
        productionFragment.tv_switcher_name = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_switcher_name, "field 'tv_switcher_name'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.tv_switcher_type, "field 'tv_switcher_type' and method 'onChangeButtonClicked'");
        productionFragment.tv_switcher_type = (TextView) Utils.castView(viewFindRequiredView, R.id.tv_switcher_type, "field 'tv_switcher_type'", TextView.class);
        this.view7f09032d = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.switcherInfo.fragments.ProductionFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                productionFragment.onChangeButtonClicked();
            }
        });
        productionFragment.tv_owner = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_owner, "field 'tv_owner'", TextView.class);
        productionFragment.tv_phone_number = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_phone_number, "field 'tv_phone_number'", TextView.class);
        productionFragment.tv_shipping_address1 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_shipping_address1, "field 'tv_shipping_address1'", TextView.class);
        productionFragment.tv_shipping_address2 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_shipping_address2, "field 'tv_shipping_address2'", TextView.class);
        productionFragment.tv_shipping_date = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_shipping_date, "field 'tv_shipping_date'", TextView.class);
        productionFragment.pb_changing = (ProgressBar) Utils.findRequiredViewAsType(view, R.id.pb_changing, "field 'pb_changing'", ProgressBar.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.btn_answer_kakaotalk, "method 'onAnswerKakaotalkButtonClicked'");
        this.view7f090058 = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.switcherInfo.fragments.ProductionFragment_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                productionFragment.onAnswerKakaotalkButtonClicked();
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        ProductionFragment productionFragment = this.target;
        if (productionFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        productionFragment.iv_switcher_icon = null;
        productionFragment.tv_switcher_name = null;
        productionFragment.tv_switcher_type = null;
        productionFragment.tv_owner = null;
        productionFragment.tv_phone_number = null;
        productionFragment.tv_shipping_address1 = null;
        productionFragment.tv_shipping_address2 = null;
        productionFragment.tv_shipping_date = null;
        productionFragment.pb_changing = null;
        this.view7f09032d.setOnClickListener(null);
        this.view7f09032d = null;
        this.view7f090058.setOnClickListener(null);
        this.view7f090058 = null;
    }
}
