package kr.switcher.switcherm.ui.ircommandtest;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import kr.switcher.switcherm.R;

/* JADX INFO: loaded from: classes2.dex */
public class IrCommandTestActivity_ViewBinding implements Unbinder {
    private IrCommandTestActivity target;
    private View view7f090089;

    public IrCommandTestActivity_ViewBinding(IrCommandTestActivity irCommandTestActivity) {
        this(irCommandTestActivity, irCommandTestActivity.getWindow().getDecorView());
    }

    public IrCommandTestActivity_ViewBinding(final IrCommandTestActivity irCommandTestActivity, View view) {
        this.target = irCommandTestActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.btn_previous, "method 'onPreviousButtonClicked'");
        this.view7f090089 = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.ircommandtest.IrCommandTestActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                irCommandTestActivity.onPreviousButtonClicked();
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        if (this.target == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        this.view7f090089.setOnClickListener(null);
        this.view7f090089 = null;
    }
}
