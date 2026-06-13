package kr.switcher.switcherm.ui.main;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import kr.switcher.switcherm.R;

/* JADX INFO: loaded from: classes2.dex */
public class MainActivity_ViewBinding implements Unbinder {
    private MainActivity target;
    private View view7f090064;
    private View view7f09007b;
    private View view7f09007c;
    private View view7f09009b;

    public MainActivity_ViewBinding(MainActivity mainActivity) {
        this(mainActivity, mainActivity.getWindow().getDecorView());
    }

    public MainActivity_ViewBinding(final MainActivity mainActivity, View view) {
        this.target = mainActivity;
        mainActivity.lin_top = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.lin_top, "field 'lin_top'", LinearLayout.class);
        mainActivity.rv_icon_sector = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rv_icon_sector, "field 'rv_icon_sector'", RelativeLayout.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.btn_switcher_info_menu, "field 'btn_switcher_info_menu' and method 'onMoveSwitcherInfoMenuButtonClicked'");
        mainActivity.btn_switcher_info_menu = (RelativeLayout) Utils.castView(viewFindRequiredView, R.id.btn_switcher_info_menu, "field 'btn_switcher_info_menu'", RelativeLayout.class);
        this.view7f09009b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.main.MainActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                mainActivity.onMoveSwitcherInfoMenuButtonClicked();
            }
        });
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.btn_my_page_menu, "field 'btn_my_page_menu' and method 'onMoveMyPageMenuButtonClicked'");
        mainActivity.btn_my_page_menu = (RelativeLayout) Utils.castView(viewFindRequiredView2, R.id.btn_my_page_menu, "field 'btn_my_page_menu'", RelativeLayout.class);
        this.view7f09007c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.main.MainActivity_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                mainActivity.onMoveMyPageMenuButtonClicked();
            }
        });
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.btn_chart_menu, "field 'btn_chart_menu' and method 'onMoveChartMenuButtonClicked'");
        mainActivity.btn_chart_menu = (RelativeLayout) Utils.castView(viewFindRequiredView3, R.id.btn_chart_menu, "field 'btn_chart_menu'", RelativeLayout.class);
        this.view7f090064 = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.main.MainActivity_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                mainActivity.onMoveChartMenuButtonClicked();
            }
        });
        mainActivity.iv_switcher_icon = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_switcher_icon, "field 'iv_switcher_icon'", ImageView.class);
        mainActivity.iv_battery_warning = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_battery_warning, "field 'iv_battery_warning'", ImageView.class);
        mainActivity.btn_scan_list_menu = (ImageView) Utils.findRequiredViewAsType(view, R.id.btn_scan_list_menu, "field 'btn_scan_list_menu'", ImageView.class);
        mainActivity.tv_title = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'tv_title'", TextView.class);
        mainActivity.tv_switcher_name = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_switcher_name, "field 'tv_switcher_name'", TextView.class);
        mainActivity.tv_info = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_info, "field 'tv_info'", TextView.class);
        mainActivity.pb_searching = (ProgressBar) Utils.findRequiredViewAsType(view, R.id.pb_searching, "field 'pb_searching'", ProgressBar.class);
        mainActivity.iv_switcher_info_menu = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_switcher_info_menu, "field 'iv_switcher_info_menu'", ImageView.class);
        mainActivity.rl_current_temperature = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_current_temperature, "field 'rl_current_temperature'", RelativeLayout.class);
        mainActivity.tv_temperature_number = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_temperature_number, "field 'tv_temperature_number'", TextView.class);
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.btn_move_scan_list_menu, "method 'onMoveScanListMenuButtonClicked'");
        this.view7f09007b = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.main.MainActivity_ViewBinding.4
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                mainActivity.onMoveScanListMenuButtonClicked();
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        MainActivity mainActivity = this.target;
        if (mainActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        mainActivity.lin_top = null;
        mainActivity.rv_icon_sector = null;
        mainActivity.btn_switcher_info_menu = null;
        mainActivity.btn_my_page_menu = null;
        mainActivity.btn_chart_menu = null;
        mainActivity.iv_switcher_icon = null;
        mainActivity.iv_battery_warning = null;
        mainActivity.btn_scan_list_menu = null;
        mainActivity.tv_title = null;
        mainActivity.tv_switcher_name = null;
        mainActivity.tv_info = null;
        mainActivity.pb_searching = null;
        mainActivity.iv_switcher_info_menu = null;
        mainActivity.rl_current_temperature = null;
        mainActivity.tv_temperature_number = null;
        this.view7f09009b.setOnClickListener(null);
        this.view7f09009b = null;
        this.view7f09007c.setOnClickListener(null);
        this.view7f09007c = null;
        this.view7f090064.setOnClickListener(null);
        this.view7f090064 = null;
        this.view7f09007b.setOnClickListener(null);
        this.view7f09007b = null;
    }
}
