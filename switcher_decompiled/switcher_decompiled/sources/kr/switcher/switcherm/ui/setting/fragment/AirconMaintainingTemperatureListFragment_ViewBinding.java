package kr.switcher.switcherm.ui.setting.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import kr.switcher.switcherm.R;

/* JADX INFO: loaded from: classes2.dex */
public class AirconMaintainingTemperatureListFragment_ViewBinding implements Unbinder {
    private AirconMaintainingTemperatureListFragment target;

    public AirconMaintainingTemperatureListFragment_ViewBinding(AirconMaintainingTemperatureListFragment airconMaintainingTemperatureListFragment, View view) {
        this.target = airconMaintainingTemperatureListFragment;
        airconMaintainingTemperatureListFragment.rl_empty = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_empty, "field 'rl_empty'", RelativeLayout.class);
        airconMaintainingTemperatureListFragment.iv_empty_timer = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_empty_timer, "field 'iv_empty_timer'", ImageView.class);
        airconMaintainingTemperatureListFragment.rl_can_not_load = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_can_not_load, "field 'rl_can_not_load'", RelativeLayout.class);
        airconMaintainingTemperatureListFragment.sr_timer_list = (SwipeRefreshLayout) Utils.findRequiredViewAsType(view, R.id.sr_timer_list, "field 'sr_timer_list'", SwipeRefreshLayout.class);
        airconMaintainingTemperatureListFragment.rv_timer_list = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_timer_list, "field 'rv_timer_list'", RecyclerView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        AirconMaintainingTemperatureListFragment airconMaintainingTemperatureListFragment = this.target;
        if (airconMaintainingTemperatureListFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        airconMaintainingTemperatureListFragment.rl_empty = null;
        airconMaintainingTemperatureListFragment.iv_empty_timer = null;
        airconMaintainingTemperatureListFragment.rl_can_not_load = null;
        airconMaintainingTemperatureListFragment.sr_timer_list = null;
        airconMaintainingTemperatureListFragment.rv_timer_list = null;
    }
}
