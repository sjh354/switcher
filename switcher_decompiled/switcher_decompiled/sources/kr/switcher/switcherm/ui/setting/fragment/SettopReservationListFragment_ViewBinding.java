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
public class SettopReservationListFragment_ViewBinding implements Unbinder {
    private SettopReservationListFragment target;

    public SettopReservationListFragment_ViewBinding(SettopReservationListFragment settopReservationListFragment, View view) {
        this.target = settopReservationListFragment;
        settopReservationListFragment.rl_empty = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_empty, "field 'rl_empty'", RelativeLayout.class);
        settopReservationListFragment.rl_can_not_load = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_can_not_load, "field 'rl_can_not_load'", RelativeLayout.class);
        settopReservationListFragment.iv_empty_timer = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_empty_timer, "field 'iv_empty_timer'", ImageView.class);
        settopReservationListFragment.tv_empty = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_empty, "field 'tv_empty'", TextView.class);
        settopReservationListFragment.sr_timer_list = (SwipeRefreshLayout) Utils.findRequiredViewAsType(view, R.id.sr_timer_list, "field 'sr_timer_list'", SwipeRefreshLayout.class);
        settopReservationListFragment.rv_timer_list = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_timer_list, "field 'rv_timer_list'", RecyclerView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        SettopReservationListFragment settopReservationListFragment = this.target;
        if (settopReservationListFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        settopReservationListFragment.rl_empty = null;
        settopReservationListFragment.rl_can_not_load = null;
        settopReservationListFragment.iv_empty_timer = null;
        settopReservationListFragment.tv_empty = null;
        settopReservationListFragment.sr_timer_list = null;
        settopReservationListFragment.rv_timer_list = null;
    }
}
