package kr.switcher.switcherm.ui.dialog.signal;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import kr.switcher.switcherm.R;

/* JADX INFO: loaded from: classes2.dex */
public class SignalTypeDialogFragment_ViewBinding implements Unbinder {
    private SignalTypeDialogFragment target;
    private View view7f09006c;
    private View view7f0900bd;

    public SignalTypeDialogFragment_ViewBinding(final SignalTypeDialogFragment signalTypeDialogFragment, View view) {
        this.target = signalTypeDialogFragment;
        signalTypeDialogFragment.tv_suggestion = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_suggestion, "field 'tv_suggestion'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.btn_yes, "field 'btn_yes' and method 'onAcceptButtonClicked'");
        signalTypeDialogFragment.btn_yes = (TextView) Utils.castView(viewFindRequiredView, R.id.btn_yes, "field 'btn_yes'", TextView.class);
        this.view7f0900bd = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.dialog.signal.SignalTypeDialogFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                signalTypeDialogFragment.onAcceptButtonClicked();
            }
        });
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.btn_deny, "method 'onDenyButtonClicked'");
        this.view7f09006c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.dialog.signal.SignalTypeDialogFragment_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                signalTypeDialogFragment.onDenyButtonClicked();
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        SignalTypeDialogFragment signalTypeDialogFragment = this.target;
        if (signalTypeDialogFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        signalTypeDialogFragment.tv_suggestion = null;
        signalTypeDialogFragment.btn_yes = null;
        this.view7f0900bd.setOnClickListener(null);
        this.view7f0900bd = null;
        this.view7f09006c.setOnClickListener(null);
        this.view7f09006c = null;
    }
}
