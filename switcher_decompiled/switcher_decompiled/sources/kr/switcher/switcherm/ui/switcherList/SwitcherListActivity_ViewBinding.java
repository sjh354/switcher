package kr.switcher.switcherm.ui.switcherList;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import kr.switcher.switcherm.R;

/* JADX INFO: loaded from: classes2.dex */
public class SwitcherListActivity_ViewBinding implements Unbinder {
    private SwitcherListActivity target;
    private View view7f0901fa;
    private View view7f0901fb;
    private View view7f090201;

    public SwitcherListActivity_ViewBinding(SwitcherListActivity switcherListActivity) {
        this(switcherListActivity, switcherListActivity.getWindow().getDecorView());
    }

    public SwitcherListActivity_ViewBinding(final SwitcherListActivity switcherListActivity, View view) {
        this.target = switcherListActivity;
        switcherListActivity.sr_switcher_list = (SwipeRefreshLayout) Utils.findRequiredViewAsType(view, R.id.sr_switcher_list, "field 'sr_switcher_list'", SwipeRefreshLayout.class);
        switcherListActivity.rv_switcher_list = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_switcher_list, "field 'rv_switcher_list'", RecyclerView.class);
        switcherListActivity.rl_scanning = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_scanning, "field 'rl_scanning'", RelativeLayout.class);
        switcherListActivity.rl_add_remocon = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_add_remocon, "field 'rl_add_remocon'", RelativeLayout.class);
        switcherListActivity.btn_add_remocon = Utils.findRequiredView(view, R.id.btn_add_remocon, "field 'btn_add_remocon'");
        switcherListActivity.tv_add_remocon = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_add_remocon, "field 'tv_add_remocon'", TextView.class);
        switcherListActivity.btn_mycard = (ImageView) Utils.findRequiredViewAsType(view, R.id.btn_mycard, "field 'btn_mycard'", ImageView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.rl_mycard, "field 'rl_mycard' and method 'onMoveMyCardMenuButtonClicked'");
        switcherListActivity.rl_mycard = (RelativeLayout) Utils.castView(viewFindRequiredView, R.id.rl_mycard, "field 'rl_mycard'", RelativeLayout.class);
        this.view7f0901fa = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.switcherList.SwitcherListActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                switcherListActivity.onMoveMyCardMenuButtonClicked();
            }
        });
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.rl_refresh_list, "method 'onRefreshScanListButtonClicked'");
        this.view7f090201 = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.switcherList.SwitcherListActivity_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                switcherListActivity.onRefreshScanListButtonClicked();
            }
        });
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.rl_myinfo, "method 'onMoveMypageMenuButtonClicked'");
        this.view7f0901fb = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.switcherList.SwitcherListActivity_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                switcherListActivity.onMoveMypageMenuButtonClicked();
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        SwitcherListActivity switcherListActivity = this.target;
        if (switcherListActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        switcherListActivity.sr_switcher_list = null;
        switcherListActivity.rv_switcher_list = null;
        switcherListActivity.rl_scanning = null;
        switcherListActivity.rl_add_remocon = null;
        switcherListActivity.btn_add_remocon = null;
        switcherListActivity.tv_add_remocon = null;
        switcherListActivity.btn_mycard = null;
        switcherListActivity.rl_mycard = null;
        this.view7f0901fa.setOnClickListener(null);
        this.view7f0901fa = null;
        this.view7f090201.setOnClickListener(null);
        this.view7f090201 = null;
        this.view7f0901fb.setOnClickListener(null);
        this.view7f0901fb = null;
    }
}
