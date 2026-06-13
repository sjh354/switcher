package kr.switcher.switcherm.ui.switcherInfo.fragments;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import kr.switcher.switcherm.R;

/* JADX INFO: loaded from: classes2.dex */
public class ReturnBookingFragment_ViewBinding implements Unbinder {
    private ReturnBookingFragment target;
    private View view7f09031c;

    public ReturnBookingFragment_ViewBinding(final ReturnBookingFragment returnBookingFragment, View view) {
        this.target = returnBookingFragment;
        returnBookingFragment.tv_return_name = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_return_name, "field 'tv_return_name'", TextView.class);
        returnBookingFragment.tv_phone_number = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_phone_number, "field 'tv_phone_number'", TextView.class);
        returnBookingFragment.tv_post_number = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_post_number, "field 'tv_post_number'", TextView.class);
        returnBookingFragment.tv_address1 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_address1, "field 'tv_address1'", TextView.class);
        returnBookingFragment.et_address2 = (EditText) Utils.findRequiredViewAsType(view, R.id.et_address2, "field 'et_address2'", EditText.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.tv_setting_courier_visit_btn, "method 'onMoveSettingCourierVisitButtonClicked'");
        this.view7f09031c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.switcherInfo.fragments.ReturnBookingFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                returnBookingFragment.onMoveSettingCourierVisitButtonClicked();
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        ReturnBookingFragment returnBookingFragment = this.target;
        if (returnBookingFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        returnBookingFragment.tv_return_name = null;
        returnBookingFragment.tv_phone_number = null;
        returnBookingFragment.tv_post_number = null;
        returnBookingFragment.tv_address1 = null;
        returnBookingFragment.et_address2 = null;
        this.view7f09031c.setOnClickListener(null);
        this.view7f09031c = null;
    }
}
