package kr.switcher.switcherm.ui.dialog;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import kr.switcher.switcherm.R;

/* JADX INFO: loaded from: classes2.dex */
public class PayDetailConfirmFragment_ViewBinding implements Unbinder {
    private PayDetailConfirmFragment target;
    private View view7f090060;
    private View view7f090061;
    private View view7f090080;
    private View view7f0902bd;
    private View view7f0902c1;
    private View view7f090317;

    public PayDetailConfirmFragment_ViewBinding(final PayDetailConfirmFragment payDetailConfirmFragment, View view) {
        this.target = payDetailConfirmFragment;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.tv_device_price, "field 'tv_device_price' and method 'onDevicePriceTextClicked'");
        payDetailConfirmFragment.tv_device_price = (TextView) Utils.castView(viewFindRequiredView, R.id.tv_device_price, "field 'tv_device_price'", TextView.class);
        this.view7f0902bd = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.dialog.PayDetailConfirmFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                payDetailConfirmFragment.onDevicePriceTextClicked();
            }
        });
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.tv_sale_price, "field 'tv_sale_price' and method 'onSalePriceTextClicked'");
        payDetailConfirmFragment.tv_sale_price = (TextView) Utils.castView(viewFindRequiredView2, R.id.tv_sale_price, "field 'tv_sale_price'", TextView.class);
        this.view7f090317 = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.dialog.PayDetailConfirmFragment_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                payDetailConfirmFragment.onSalePriceTextClicked();
            }
        });
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.tv_exchanging_number, "field 'tv_exchanging_number' and method 'onExchangingNumberTextClicked'");
        payDetailConfirmFragment.tv_exchanging_number = (TextView) Utils.castView(viewFindRequiredView3, R.id.tv_exchanging_number, "field 'tv_exchanging_number'", TextView.class);
        this.view7f0902c1 = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.dialog.PayDetailConfirmFragment_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                payDetailConfirmFragment.onExchangingNumberTextClicked();
            }
        });
        payDetailConfirmFragment.tv_payment_price = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_payment_price, "field 'tv_payment_price'", TextView.class);
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.btn_notice, "field 'btn_notice' and method 'onNoticeButtonClicked'");
        payDetailConfirmFragment.btn_notice = (TextView) Utils.castView(viewFindRequiredView4, R.id.btn_notice, "field 'btn_notice'", TextView.class);
        this.view7f090080 = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.dialog.PayDetailConfirmFragment_ViewBinding.4
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                payDetailConfirmFragment.onNoticeButtonClicked();
            }
        });
        View viewFindRequiredView5 = Utils.findRequiredView(view, R.id.btn_change, "method 'onChangeButtonClicked'");
        this.view7f090061 = viewFindRequiredView5;
        viewFindRequiredView5.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.dialog.PayDetailConfirmFragment_ViewBinding.5
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                payDetailConfirmFragment.onChangeButtonClicked();
            }
        });
        View viewFindRequiredView6 = Utils.findRequiredView(view, R.id.btn_cancel, "method 'onCancelButtonClicked'");
        this.view7f090060 = viewFindRequiredView6;
        viewFindRequiredView6.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.dialog.PayDetailConfirmFragment_ViewBinding.6
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                payDetailConfirmFragment.onCancelButtonClicked();
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        PayDetailConfirmFragment payDetailConfirmFragment = this.target;
        if (payDetailConfirmFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        payDetailConfirmFragment.tv_device_price = null;
        payDetailConfirmFragment.tv_sale_price = null;
        payDetailConfirmFragment.tv_exchanging_number = null;
        payDetailConfirmFragment.tv_payment_price = null;
        payDetailConfirmFragment.btn_notice = null;
        this.view7f0902bd.setOnClickListener(null);
        this.view7f0902bd = null;
        this.view7f090317.setOnClickListener(null);
        this.view7f090317 = null;
        this.view7f0902c1.setOnClickListener(null);
        this.view7f0902c1 = null;
        this.view7f090080.setOnClickListener(null);
        this.view7f090080 = null;
        this.view7f090061.setOnClickListener(null);
        this.view7f090061 = null;
        this.view7f090060.setOnClickListener(null);
        this.view7f090060 = null;
    }
}
