package kr.switcher.switcherm.ui.setting.fragment;

import android.view.View;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import kr.switcher.switcherm.R;

/* JADX INFO: loaded from: classes2.dex */
public class AirconReservationListFragment_ViewBinding implements Unbinder {
    private AirconReservationListFragment target;

    public AirconReservationListFragment_ViewBinding(AirconReservationListFragment airconReservationListFragment, View view) {
        this.target = airconReservationListFragment;
        airconReservationListFragment.rl_empty = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_empty, "field 'rl_empty'", RelativeLayout.class);
        airconReservationListFragment.rl_can_not_load = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_can_not_load, "field 'rl_can_not_load'", RelativeLayout.class);
        airconReservationListFragment.sr_timer_list = (SwipeRefreshLayout) Utils.findRequiredViewAsType(view, R.id.sr_timer_list, "field 'sr_timer_list'", SwipeRefreshLayout.class);
        airconReservationListFragment.rv_timer_list = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_timer_list, "field 'rv_timer_list'", RecyclerView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        AirconReservationListFragment airconReservationListFragment = this.target;
        if (airconReservationListFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        airconReservationListFragment.rl_empty = null;
        airconReservationListFragment.rl_can_not_load = null;
        airconReservationListFragment.sr_timer_list = null;
        airconReservationListFragment.rv_timer_list = null;
    }
}
