package kr.switcher.switcherm.ui.dialog;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import kr.switcher.switcherm.R;

/* JADX INFO: loaded from: classes2.dex */
public class ChangeDialogFragment_ViewBinding implements Unbinder {
    private ChangeDialogFragment target;
    private View view7f090060;
    private View view7f090061;

    public ChangeDialogFragment_ViewBinding(final ChangeDialogFragment changeDialogFragment, View view) {
        this.target = changeDialogFragment;
        changeDialogFragment.tv_topic_name = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_topic_name, "field 'tv_topic_name'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.btn_change, "method 'onChangeButtonClicked'");
        this.view7f090061 = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.dialog.ChangeDialogFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                changeDialogFragment.onChangeButtonClicked();
            }
        });
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.btn_cancel, "method 'onCancelButtonClicked'");
        this.view7f090060 = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.dialog.ChangeDialogFragment_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                changeDialogFragment.onCancelButtonClicked();
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        ChangeDialogFragment changeDialogFragment = this.target;
        if (changeDialogFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        changeDialogFragment.tv_topic_name = null;
        this.view7f090061.setOnClickListener(null);
        this.view7f090061 = null;
        this.view7f090060.setOnClickListener(null);
        this.view7f090060 = null;
    }
}
