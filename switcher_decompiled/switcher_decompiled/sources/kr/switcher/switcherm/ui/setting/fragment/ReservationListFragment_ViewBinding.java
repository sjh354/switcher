package kr.switcher.switcherm.ui.setting.fragment;

import android.view.View;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import kr.switcher.switcherm.R;

/* JADX INFO: loaded from: classes2.dex */
public class ReservationListFragment_ViewBinding implements Unbinder {
    private ReservationListFragment target;

    public ReservationListFragment_ViewBinding(ReservationListFragment reservationListFragment, View view) {
        this.target = reservationListFragment;
        reservationListFragment.rl_empty = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_empty, "field 'rl_empty'", RelativeLayout.class);
        reservationListFragment.rl_can_not_load = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_can_not_load, "field 'rl_can_not_load'", RelativeLayout.class);
        reservationListFragment.sr_timer_list = (SwipeRefreshLayout) Utils.findRequiredViewAsType(view, R.id.sr_timer_list, "field 'sr_timer_list'", SwipeRefreshLayout.class);
        reservationListFragment.rv_timer_list = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_timer_list, "field 'rv_timer_list'", RecyclerView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        ReservationListFragment reservationListFragment = this.target;
        if (reservationListFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        reservationListFragment.rl_empty = null;
        reservationListFragment.rl_can_not_load = null;
        reservationListFragment.sr_timer_list = null;
        reservationListFragment.rv_timer_list = null;
    }
}
