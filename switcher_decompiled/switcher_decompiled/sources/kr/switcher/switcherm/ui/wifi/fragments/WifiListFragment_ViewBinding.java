package kr.switcher.switcherm.ui.wifi.fragments;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import kr.switcher.switcherm.R;

/* JADX INFO: loaded from: classes2.dex */
public class WifiListFragment_ViewBinding implements Unbinder {
    private WifiListFragment target;
    private View view7f0902c7;

    public WifiListFragment_ViewBinding(final WifiListFragment wifiListFragment, View view) {
        this.target = wifiListFragment;
        wifiListFragment.rl_wifi_list = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_wifi_list, "field 'rl_wifi_list'", RelativeLayout.class);
        wifiListFragment.rl_find_wifi = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_find_wifi, "field 'rl_find_wifi'", RelativeLayout.class);
        wifiListFragment.rl_gps_suggest = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_gps_suggest, "field 'rl_gps_suggest'", RelativeLayout.class);
        wifiListFragment.rv_wifi_list = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_wifi_list, "field 'rv_wifi_list'", RecyclerView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.tv_gps_setting, "field 'tv_gps_setting' and method 'onGPSSettingButtonClicked'");
        wifiListFragment.tv_gps_setting = (TextView) Utils.castView(viewFindRequiredView, R.id.tv_gps_setting, "field 'tv_gps_setting'", TextView.class);
        this.view7f0902c7 = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.wifi.fragments.WifiListFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                wifiListFragment.onGPSSettingButtonClicked();
            }
        });
        wifiListFragment.tv_issue = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_issue, "field 'tv_issue'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        WifiListFragment wifiListFragment = this.target;
        if (wifiListFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        wifiListFragment.rl_wifi_list = null;
        wifiListFragment.rl_find_wifi = null;
        wifiListFragment.rl_gps_suggest = null;
        wifiListFragment.rv_wifi_list = null;
        wifiListFragment.tv_gps_setting = null;
        wifiListFragment.tv_issue = null;
        this.view7f0902c7.setOnClickListener(null);
        this.view7f0902c7 = null;
    }
}
