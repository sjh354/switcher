package kr.switcher.switcherm.ui.ircommandtest.presenter;

import kr.switcher.switcherm.common.activity.IOActivity;
import kr.switcher.switcherm.ui.ircommandtest.fragment.LinkerInsertIrCommandFragment;
import kr.switcher.switcherm.ui.ircommandtest.view.IrCommandTestView;

/* JADX INFO: loaded from: classes2.dex */
public class IRCommandTestPresenter {
    private IrCommandTestView view;

    public IRCommandTestPresenter(IrCommandTestView irCommandTestView) {
        this.view = irCommandTestView;
    }

    public void onPreviousButtonClicked(IOActivity iOActivity) {
        if (((LinkerInsertIrCommandFragment) iOActivity.getSupportFragmentManager().findFragmentByTag("LinkerInsertIrCommandFragment")) == null) {
            this.view.moveIRCommandInsertFragment();
        } else {
            this.view.finishActivity();
        }
    }
}
