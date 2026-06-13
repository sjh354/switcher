package kr.switcher.switcherm.ui.irbrand;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import kr.switcher.switcherm.R;

/* JADX INFO: loaded from: classes2.dex */
public class IRBrandActivity_ViewBinding implements Unbinder {
    private IRBrandActivity target;
    private View view7f090089;

    public IRBrandActivity_ViewBinding(IRBrandActivity iRBrandActivity) {
        this(iRBrandActivity, iRBrandActivity.getWindow().getDecorView());
    }

    public IRBrandActivity_ViewBinding(final IRBrandActivity iRBrandActivity, View view) {
        this.target = iRBrandActivity;
        iRBrandActivity.tv_activity_title = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_activity_title, "field 'tv_activity_title'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.btn_previous, "method 'onPreviousButtonClicked'");
        this.view7f090089 = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.irbrand.IRBrandActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                iRBrandActivity.onPreviousButtonClicked();
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        IRBrandActivity iRBrandActivity = this.target;
        if (iRBrandActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        iRBrandActivity.tv_activity_title = null;
        this.view7f090089.setOnClickListener(null);
        this.view7f090089 = null;
    }
}
