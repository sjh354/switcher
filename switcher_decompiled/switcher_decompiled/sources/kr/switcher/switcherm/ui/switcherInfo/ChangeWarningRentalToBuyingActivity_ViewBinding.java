package kr.switcher.switcherm.ui.switcherInfo;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import kr.switcher.switcherm.R;

/* JADX INFO: loaded from: classes2.dex */
public class ChangeWarningRentalToBuyingActivity_ViewBinding implements Unbinder {
    private ChangeWarningRentalToBuyingActivity target;
    private View view7f090065;

    public ChangeWarningRentalToBuyingActivity_ViewBinding(ChangeWarningRentalToBuyingActivity changeWarningRentalToBuyingActivity) {
        this(changeWarningRentalToBuyingActivity, changeWarningRentalToBuyingActivity.getWindow().getDecorView());
    }

    public ChangeWarningRentalToBuyingActivity_ViewBinding(final ChangeWarningRentalToBuyingActivity changeWarningRentalToBuyingActivity, View view) {
        this.target = changeWarningRentalToBuyingActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.btn_close, "method 'onCloseButtonClicked'");
        this.view7f090065 = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.switcherInfo.ChangeWarningRentalToBuyingActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                changeWarningRentalToBuyingActivity.onCloseButtonClicked();
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        if (this.target == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        this.view7f090065.setOnClickListener(null);
        this.view7f090065 = null;
    }
}
