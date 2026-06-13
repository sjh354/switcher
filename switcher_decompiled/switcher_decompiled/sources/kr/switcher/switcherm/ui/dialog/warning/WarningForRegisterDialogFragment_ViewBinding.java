package kr.switcher.switcherm.ui.dialog.warning;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import kr.switcher.switcherm.R;

/* JADX INFO: loaded from: classes2.dex */
public class WarningForRegisterDialogFragment_ViewBinding implements Unbinder {
    private WarningForRegisterDialogFragment target;
    private View view7f090067;

    public WarningForRegisterDialogFragment_ViewBinding(final WarningForRegisterDialogFragment warningForRegisterDialogFragment, View view) {
        this.target = warningForRegisterDialogFragment;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.btn_confirm, "method 'onConfirmButtonClicked'");
        this.view7f090067 = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.dialog.warning.WarningForRegisterDialogFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                warningForRegisterDialogFragment.onConfirmButtonClicked();
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        if (this.target == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        this.view7f090067.setOnClickListener(null);
        this.view7f090067 = null;
    }
}
