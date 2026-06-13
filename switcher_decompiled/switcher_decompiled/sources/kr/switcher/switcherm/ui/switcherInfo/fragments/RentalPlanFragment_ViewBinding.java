package kr.switcher.switcherm.ui.switcherInfo.fragments;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import kr.switcher.switcherm.R;

/* JADX INFO: loaded from: classes2.dex */
public class RentalPlanFragment_ViewBinding implements Unbinder {
    private RentalPlanFragment target;
    private View view7f09005e;
    private View view7f09007a;

    public RentalPlanFragment_ViewBinding(final RentalPlanFragment rentalPlanFragment, View view) {
        this.target = rentalPlanFragment;
        rentalPlanFragment.tv_title1 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title1, "field 'tv_title1'", TextView.class);
        rentalPlanFragment.tv_title2 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title2, "field 'tv_title2'", TextView.class);
        rentalPlanFragment.tv_title3 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title3, "field 'tv_title3'", TextView.class);
        rentalPlanFragment.tv_title4 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title4, "field 'tv_title4'", TextView.class);
        rentalPlanFragment.tv_price1 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_price1, "field 'tv_price1'", TextView.class);
        rentalPlanFragment.tv_price2 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_price2, "field 'tv_price2'", TextView.class);
        rentalPlanFragment.tv_price3 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_price3, "field 'tv_price3'", TextView.class);
        rentalPlanFragment.tv_price4 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_price4, "field 'tv_price4'", TextView.class);
        rentalPlanFragment.tv_mine1 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_mine1, "field 'tv_mine1'", TextView.class);
        rentalPlanFragment.tv_mine2 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_mine2, "field 'tv_mine2'", TextView.class);
        rentalPlanFragment.tv_mine3 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_mine3, "field 'tv_mine3'", TextView.class);
        rentalPlanFragment.tv_mine4 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_mine4, "field 'tv_mine4'", TextView.class);
        rentalPlanFragment.tv_description1 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_description1, "field 'tv_description1'", TextView.class);
        rentalPlanFragment.tv_description2 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_description2, "field 'tv_description2'", TextView.class);
        rentalPlanFragment.tv_description3 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_description3, "field 'tv_description3'", TextView.class);
        rentalPlanFragment.tv_description4 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_description4, "field 'tv_description4'", TextView.class);
        rentalPlanFragment.tv_purchase_price = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_purchase_price, "field 'tv_purchase_price'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.btn_move_kakao, "method 'onMoveKakaotalkButtonClicked'");
        this.view7f09007a = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.switcherInfo.fragments.RentalPlanFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                rentalPlanFragment.onMoveKakaotalkButtonClicked();
            }
        });
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.btn_buy_now, "method 'onBuyNowButtonClicked'");
        this.view7f09005e = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.switcherInfo.fragments.RentalPlanFragment_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                rentalPlanFragment.onBuyNowButtonClicked();
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        RentalPlanFragment rentalPlanFragment = this.target;
        if (rentalPlanFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        rentalPlanFragment.tv_title1 = null;
        rentalPlanFragment.tv_title2 = null;
        rentalPlanFragment.tv_title3 = null;
        rentalPlanFragment.tv_title4 = null;
        rentalPlanFragment.tv_price1 = null;
        rentalPlanFragment.tv_price2 = null;
        rentalPlanFragment.tv_price3 = null;
        rentalPlanFragment.tv_price4 = null;
        rentalPlanFragment.tv_mine1 = null;
        rentalPlanFragment.tv_mine2 = null;
        rentalPlanFragment.tv_mine3 = null;
        rentalPlanFragment.tv_mine4 = null;
        rentalPlanFragment.tv_description1 = null;
        rentalPlanFragment.tv_description2 = null;
        rentalPlanFragment.tv_description3 = null;
        rentalPlanFragment.tv_description4 = null;
        rentalPlanFragment.tv_purchase_price = null;
        this.view7f09007a.setOnClickListener(null);
        this.view7f09007a = null;
        this.view7f09005e.setOnClickListener(null);
        this.view7f09005e = null;
    }
}
