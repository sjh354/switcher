package kr.switcher.switcherm.ui.main.fragment;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import kr.switcher.switcherm.R;

/* JADX INFO: loaded from: classes2.dex */
public class MainDisconnectedFragment_ViewBinding implements Unbinder {
    private MainDisconnectedFragment target;
    private View view7f09008a;
    private View view7f0900a5;

    public MainDisconnectedFragment_ViewBinding(final MainDisconnectedFragment mainDisconnectedFragment, View view) {
        this.target = mainDisconnectedFragment;
        mainDisconnectedFragment.pb_reconnecting = (ProgressBar) Utils.findRequiredViewAsType(view, R.id.pb_reconnecting, "field 'pb_reconnecting'", ProgressBar.class);
        mainDisconnectedFragment.tv_manual1 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_manual1, "field 'tv_manual1'", TextView.class);
        mainDisconnectedFragment.tv_manual2_1 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_manual2_1, "field 'tv_manual2_1'", TextView.class);
        mainDisconnectedFragment.tv_manual2_2 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_manual2_2, "field 'tv_manual2_2'", TextView.class);
        mainDisconnectedFragment.lin_manual2 = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.lin_manual2, "field 'lin_manual2'", LinearLayout.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.btn_reconnect, "method 'onReconnectButtonClicked'");
        this.view7f09008a = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.main.fragment.MainDisconnectedFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                mainDisconnectedFragment.onReconnectButtonClicked();
            }
        });
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.btn_troubleshooting, "method 'onTroubleshootingButtonClicked'");
        this.view7f0900a5 = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.main.fragment.MainDisconnectedFragment_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                mainDisconnectedFragment.onTroubleshootingButtonClicked();
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        MainDisconnectedFragment mainDisconnectedFragment = this.target;
        if (mainDisconnectedFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        mainDisconnectedFragment.pb_reconnecting = null;
        mainDisconnectedFragment.tv_manual1 = null;
        mainDisconnectedFragment.tv_manual2_1 = null;
        mainDisconnectedFragment.tv_manual2_2 = null;
        mainDisconnectedFragment.lin_manual2 = null;
        this.view7f09008a.setOnClickListener(null);
        this.view7f09008a = null;
        this.view7f0900a5.setOnClickListener(null);
        this.view7f0900a5 = null;
    }
}
