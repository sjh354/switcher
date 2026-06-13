package kr.switcher.switcherm.ui.switcherInfo.fragments;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import kr.switcher.switcherm.R;

/* JADX INFO: loaded from: classes2.dex */
public class BuyingTypeChangeFragment_ViewBinding implements Unbinder {
    private BuyingTypeChangeFragment target;
    private View view7f09007a;
    private View view7f0900c6;
    private View view7f0900c7;

    public BuyingTypeChangeFragment_ViewBinding(final BuyingTypeChangeFragment buyingTypeChangeFragment, View view) {
        this.target = buyingTypeChangeFragment;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.cb_buying_type_lease, "field 'cb_buying_type_lease' and method 'leaseCheckboxChecked'");
        buyingTypeChangeFragment.cb_buying_type_lease = (CheckBox) Utils.castView(viewFindRequiredView, R.id.cb_buying_type_lease, "field 'cb_buying_type_lease'", CheckBox.class);
        this.view7f0900c6 = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.switcherInfo.fragments.BuyingTypeChangeFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                buyingTypeChangeFragment.leaseCheckboxChecked();
            }
        });
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.cb_buying_type_wholesale, "field 'cb_buying_type_wholesale' and method 'wolesaleCheckboxChecked'");
        buyingTypeChangeFragment.cb_buying_type_wholesale = (CheckBox) Utils.castView(viewFindRequiredView2, R.id.cb_buying_type_wholesale, "field 'cb_buying_type_wholesale'", CheckBox.class);
        this.view7f0900c7 = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.switcherInfo.fragments.BuyingTypeChangeFragment_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                buyingTypeChangeFragment.wolesaleCheckboxChecked();
            }
        });
        buyingTypeChangeFragment.tv_my_buying_type_lease = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_my_buying_type_lease, "field 'tv_my_buying_type_lease'", TextView.class);
        buyingTypeChangeFragment.tv_my_buying_type_wholesale = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_my_buying_type_wholesale, "field 'tv_my_buying_type_wholesale'", TextView.class);
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.btn_move_kakao, "method 'onMoveKakaotalkButtonClicked'");
        this.view7f09007a = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.switcherInfo.fragments.BuyingTypeChangeFragment_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                buyingTypeChangeFragment.onMoveKakaotalkButtonClicked();
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        BuyingTypeChangeFragment buyingTypeChangeFragment = this.target;
        if (buyingTypeChangeFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        buyingTypeChangeFragment.cb_buying_type_lease = null;
        buyingTypeChangeFragment.cb_buying_type_wholesale = null;
        buyingTypeChangeFragment.tv_my_buying_type_lease = null;
        buyingTypeChangeFragment.tv_my_buying_type_wholesale = null;
        this.view7f0900c6.setOnClickListener(null);
        this.view7f0900c6 = null;
        this.view7f0900c7.setOnClickListener(null);
        this.view7f0900c7 = null;
        this.view7f09007a.setOnClickListener(null);
        this.view7f09007a = null;
    }
}
