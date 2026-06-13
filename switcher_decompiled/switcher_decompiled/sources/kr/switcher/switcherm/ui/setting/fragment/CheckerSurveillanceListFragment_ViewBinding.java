package kr.switcher.switcherm.ui.setting.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import kr.switcher.switcherm.R;

/* JADX INFO: loaded from: classes2.dex */
public class CheckerSurveillanceListFragment_ViewBinding implements Unbinder {
    private CheckerSurveillanceListFragment target;

    public CheckerSurveillanceListFragment_ViewBinding(CheckerSurveillanceListFragment checkerSurveillanceListFragment, View view) {
        this.target = checkerSurveillanceListFragment;
        checkerSurveillanceListFragment.rl_empty = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_empty, "field 'rl_empty'", RelativeLayout.class);
        checkerSurveillanceListFragment.iv_empty_timer = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_empty_timer, "field 'iv_empty_timer'", ImageView.class);
        checkerSurveillanceListFragment.rl_can_not_load = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_can_not_load, "field 'rl_can_not_load'", RelativeLayout.class);
        checkerSurveillanceListFragment.sr_timer_list = (SwipeRefreshLayout) Utils.findRequiredViewAsType(view, R.id.sr_timer_list, "field 'sr_timer_list'", SwipeRefreshLayout.class);
        checkerSurveillanceListFragment.rv_timer_list = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_timer_list, "field 'rv_timer_list'", RecyclerView.class);
        checkerSurveillanceListFragment.tv_empty = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_empty, "field 'tv_empty'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        CheckerSurveillanceListFragment checkerSurveillanceListFragment = this.target;
        if (checkerSurveillanceListFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        checkerSurveillanceListFragment.rl_empty = null;
        checkerSurveillanceListFragment.iv_empty_timer = null;
        checkerSurveillanceListFragment.rl_can_not_load = null;
        checkerSurveillanceListFragment.sr_timer_list = null;
        checkerSurveillanceListFragment.rv_timer_list = null;
        checkerSurveillanceListFragment.tv_empty = null;
    }
}
