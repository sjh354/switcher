package kr.switcher.switcherm.ui.dialog.warning;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import kr.switcher.switcherm.R;

/* JADX INFO: loaded from: classes2.dex */
public class WarningForInitializeDialogFragment_ViewBinding implements Unbinder {
    private WarningForInitializeDialogFragment target;
    private View view7f090060;
    private View view7f090071;

    public WarningForInitializeDialogFragment_ViewBinding(final WarningForInitializeDialogFragment warningForInitializeDialogFragment, View view) {
        this.target = warningForInitializeDialogFragment;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.btn_cancel, "method 'onCancelButtonClicked'");
        this.view7f090060 = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.dialog.warning.WarningForInitializeDialogFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                warningForInitializeDialogFragment.onCancelButtonClicked();
            }
        });
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.btn_initialize, "method 'onInitializeButtonClicked'");
        this.view7f090071 = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.dialog.warning.WarningForInitializeDialogFragment_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                warningForInitializeDialogFragment.onInitializeButtonClicked();
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        if (this.target == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        this.view7f090060.setOnClickListener(null);
        this.view7f090060 = null;
        this.view7f090071.setOnClickListener(null);
        this.view7f090071 = null;
    }
}
