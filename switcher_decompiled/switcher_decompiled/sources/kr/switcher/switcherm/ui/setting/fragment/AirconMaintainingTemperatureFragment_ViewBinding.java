package kr.switcher.switcherm.ui.setting.fragment;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import antistatic.spinnerwheel.AbstractWheel;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.rey.material.widget.Button;
import kr.switcher.switcherm.R;

/* JADX INFO: loaded from: classes2.dex */
public class AirconMaintainingTemperatureFragment_ViewBinding implements Unbinder {
    private AirconMaintainingTemperatureFragment target;
    private View view7f090078;
    private View view7f09009c;
    private View view7f09009d;
    private View view7f0901e4;
    private View view7f09021a;
    private View view7f09021b;
    private View view7f0902c6;
    private View view7f0902e4;
    private View view7f090318;
    private View view7f09032a;
    private View view7f090333;
    private View view7f09033e;
    private View view7f090345;

    public AirconMaintainingTemperatureFragment_ViewBinding(final AirconMaintainingTemperatureFragment airconMaintainingTemperatureFragment, View view) {
        this.target = airconMaintainingTemperatureFragment;
        airconMaintainingTemperatureFragment.et_title = (EditText) Utils.findRequiredViewAsType(view, R.id.et_title, "field 'et_title'", EditText.class);
        airconMaintainingTemperatureFragment.tv_reservation_temperature = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_reservation_temperature, "field 'tv_reservation_temperature'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.btn_temperature_up, "field 'btn_temperature_up' and method 'onTemperatureUpButtonClicked'");
        airconMaintainingTemperatureFragment.btn_temperature_up = (ImageButton) Utils.castView(viewFindRequiredView, R.id.btn_temperature_up, "field 'btn_temperature_up'", ImageButton.class);
        this.view7f09009d = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.setting.fragment.AirconMaintainingTemperatureFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                airconMaintainingTemperatureFragment.onTemperatureUpButtonClicked();
            }
        });
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.btn_temperature_down, "field 'btn_temperature_down' and method 'onTemperatureDownButtonClicked'");
        airconMaintainingTemperatureFragment.btn_temperature_down = (ImageButton) Utils.castView(viewFindRequiredView2, R.id.btn_temperature_down, "field 'btn_temperature_down'", ImageButton.class);
        this.view7f09009c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.setting.fragment.AirconMaintainingTemperatureFragment_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                airconMaintainingTemperatureFragment.onTemperatureDownButtonClicked();
            }
        });
        airconMaintainingTemperatureFragment.wv_start_hour = (AbstractWheel) Utils.findRequiredViewAsType(view, R.id.wv_start_hour, "field 'wv_start_hour'", AbstractWheel.class);
        airconMaintainingTemperatureFragment.wv_start_min = (AbstractWheel) Utils.findRequiredViewAsType(view, R.id.wv_start_min, "field 'wv_start_min'", AbstractWheel.class);
        airconMaintainingTemperatureFragment.wv_end_hour = (AbstractWheel) Utils.findRequiredViewAsType(view, R.id.wv_end_hour, "field 'wv_end_hour'", AbstractWheel.class);
        airconMaintainingTemperatureFragment.wv_end_min = (AbstractWheel) Utils.findRequiredViewAsType(view, R.id.wv_end_min, "field 'wv_end_min'", AbstractWheel.class);
        airconMaintainingTemperatureFragment.tv_daily = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_daily, "field 'tv_daily'", TextView.class);
        airconMaintainingTemperatureFragment.tv_weekday = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_weekday, "field 'tv_weekday'", TextView.class);
        airconMaintainingTemperatureFragment.tv_weekend = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_weekend, "field 'tv_weekend'", TextView.class);
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.tv_mon, "field 'tv_mon' and method 'onMondayButtonClicked'");
        airconMaintainingTemperatureFragment.tv_mon = (TextView) Utils.castView(viewFindRequiredView3, R.id.tv_mon, "field 'tv_mon'", TextView.class);
        this.view7f0902e4 = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.setting.fragment.AirconMaintainingTemperatureFragment_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                airconMaintainingTemperatureFragment.onMondayButtonClicked();
            }
        });
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.tv_tue, "field 'tv_tue' and method 'onTuedayButtonClicked'");
        airconMaintainingTemperatureFragment.tv_tue = (TextView) Utils.castView(viewFindRequiredView4, R.id.tv_tue, "field 'tv_tue'", TextView.class);
        this.view7f09033e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.setting.fragment.AirconMaintainingTemperatureFragment_ViewBinding.4
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                airconMaintainingTemperatureFragment.onTuedayButtonClicked();
            }
        });
        View viewFindRequiredView5 = Utils.findRequiredView(view, R.id.tv_wed, "field 'tv_wed' and method 'onWeddayButtonClicked'");
        airconMaintainingTemperatureFragment.tv_wed = (TextView) Utils.castView(viewFindRequiredView5, R.id.tv_wed, "field 'tv_wed'", TextView.class);
        this.view7f090345 = viewFindRequiredView5;
        viewFindRequiredView5.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.setting.fragment.AirconMaintainingTemperatureFragment_ViewBinding.5
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                airconMaintainingTemperatureFragment.onWeddayButtonClicked();
            }
        });
        View viewFindRequiredView6 = Utils.findRequiredView(view, R.id.tv_thu, "field 'tv_thu' and method 'onThudayButtonClicked'");
        airconMaintainingTemperatureFragment.tv_thu = (TextView) Utils.castView(viewFindRequiredView6, R.id.tv_thu, "field 'tv_thu'", TextView.class);
        this.view7f090333 = viewFindRequiredView6;
        viewFindRequiredView6.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.setting.fragment.AirconMaintainingTemperatureFragment_ViewBinding.6
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                airconMaintainingTemperatureFragment.onThudayButtonClicked();
            }
        });
        View viewFindRequiredView7 = Utils.findRequiredView(view, R.id.tv_fri, "field 'tv_fri' and method 'onFridayButtonClicked'");
        airconMaintainingTemperatureFragment.tv_fri = (TextView) Utils.castView(viewFindRequiredView7, R.id.tv_fri, "field 'tv_fri'", TextView.class);
        this.view7f0902c6 = viewFindRequiredView7;
        viewFindRequiredView7.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.setting.fragment.AirconMaintainingTemperatureFragment_ViewBinding.7
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                airconMaintainingTemperatureFragment.onFridayButtonClicked();
            }
        });
        View viewFindRequiredView8 = Utils.findRequiredView(view, R.id.tv_sat, "field 'tv_sat' and method 'onSatdayButtonClicked'");
        airconMaintainingTemperatureFragment.tv_sat = (TextView) Utils.castView(viewFindRequiredView8, R.id.tv_sat, "field 'tv_sat'", TextView.class);
        this.view7f090318 = viewFindRequiredView8;
        viewFindRequiredView8.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.setting.fragment.AirconMaintainingTemperatureFragment_ViewBinding.8
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                airconMaintainingTemperatureFragment.onSatdayButtonClicked();
            }
        });
        View viewFindRequiredView9 = Utils.findRequiredView(view, R.id.tv_sun, "field 'tv_sun' and method 'onSundayButtonClicked'");
        airconMaintainingTemperatureFragment.tv_sun = (TextView) Utils.castView(viewFindRequiredView9, R.id.tv_sun, "field 'tv_sun'", TextView.class);
        this.view7f09032a = viewFindRequiredView9;
        viewFindRequiredView9.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.setting.fragment.AirconMaintainingTemperatureFragment_ViewBinding.9
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                airconMaintainingTemperatureFragment.onSundayButtonClicked();
            }
        });
        View viewFindRequiredView10 = Utils.findRequiredView(view, R.id.btn_maintenance_remove, "field 'btn_maintenance_remove' and method 'onRemoveButtonClicked'");
        airconMaintainingTemperatureFragment.btn_maintenance_remove = (Button) Utils.castView(viewFindRequiredView10, R.id.btn_maintenance_remove, "field 'btn_maintenance_remove'", Button.class);
        this.view7f090078 = viewFindRequiredView10;
        viewFindRequiredView10.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.setting.fragment.AirconMaintainingTemperatureFragment_ViewBinding.10
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                airconMaintainingTemperatureFragment.onRemoveButtonClicked();
            }
        });
        airconMaintainingTemperatureFragment.rl_remove = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_remove, "field 'rl_remove'", RelativeLayout.class);
        airconMaintainingTemperatureFragment.pb_loading = (ProgressBar) Utils.findRequiredViewAsType(view, R.id.pb_loading, "field 'pb_loading'", ProgressBar.class);
        View viewFindRequiredView11 = Utils.findRequiredView(view, R.id.rl_daily, "method 'onDailyButtonClicked'");
        this.view7f0901e4 = viewFindRequiredView11;
        viewFindRequiredView11.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.setting.fragment.AirconMaintainingTemperatureFragment_ViewBinding.11
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                airconMaintainingTemperatureFragment.onDailyButtonClicked();
            }
        });
        View viewFindRequiredView12 = Utils.findRequiredView(view, R.id.rl_weekday, "method 'onWeekdayButtonClicked'");
        this.view7f09021a = viewFindRequiredView12;
        viewFindRequiredView12.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.setting.fragment.AirconMaintainingTemperatureFragment_ViewBinding.12
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                airconMaintainingTemperatureFragment.onWeekdayButtonClicked();
            }
        });
        View viewFindRequiredView13 = Utils.findRequiredView(view, R.id.rl_weekend, "method 'onWeekendButtonClicked'");
        this.view7f09021b = viewFindRequiredView13;
        viewFindRequiredView13.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.setting.fragment.AirconMaintainingTemperatureFragment_ViewBinding.13
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                airconMaintainingTemperatureFragment.onWeekendButtonClicked();
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        AirconMaintainingTemperatureFragment airconMaintainingTemperatureFragment = this.target;
        if (airconMaintainingTemperatureFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        airconMaintainingTemperatureFragment.et_title = null;
        airconMaintainingTemperatureFragment.tv_reservation_temperature = null;
        airconMaintainingTemperatureFragment.btn_temperature_up = null;
        airconMaintainingTemperatureFragment.btn_temperature_down = null;
        airconMaintainingTemperatureFragment.wv_start_hour = null;
        airconMaintainingTemperatureFragment.wv_start_min = null;
        airconMaintainingTemperatureFragment.wv_end_hour = null;
        airconMaintainingTemperatureFragment.wv_end_min = null;
        airconMaintainingTemperatureFragment.tv_daily = null;
        airconMaintainingTemperatureFragment.tv_weekday = null;
        airconMaintainingTemperatureFragment.tv_weekend = null;
        airconMaintainingTemperatureFragment.tv_mon = null;
        airconMaintainingTemperatureFragment.tv_tue = null;
        airconMaintainingTemperatureFragment.tv_wed = null;
        airconMaintainingTemperatureFragment.tv_thu = null;
        airconMaintainingTemperatureFragment.tv_fri = null;
        airconMaintainingTemperatureFragment.tv_sat = null;
        airconMaintainingTemperatureFragment.tv_sun = null;
        airconMaintainingTemperatureFragment.btn_maintenance_remove = null;
        airconMaintainingTemperatureFragment.rl_remove = null;
        airconMaintainingTemperatureFragment.pb_loading = null;
        this.view7f09009d.setOnClickListener(null);
        this.view7f09009d = null;
        this.view7f09009c.setOnClickListener(null);
        this.view7f09009c = null;
        this.view7f0902e4.setOnClickListener(null);
        this.view7f0902e4 = null;
        this.view7f09033e.setOnClickListener(null);
        this.view7f09033e = null;
        this.view7f090345.setOnClickListener(null);
        this.view7f090345 = null;
        this.view7f090333.setOnClickListener(null);
        this.view7f090333 = null;
        this.view7f0902c6.setOnClickListener(null);
        this.view7f0902c6 = null;
        this.view7f090318.setOnClickListener(null);
        this.view7f090318 = null;
        this.view7f09032a.setOnClickListener(null);
        this.view7f09032a = null;
        this.view7f090078.setOnClickListener(null);
        this.view7f090078 = null;
        this.view7f0901e4.setOnClickListener(null);
        this.view7f0901e4 = null;
        this.view7f09021a.setOnClickListener(null);
        this.view7f09021a = null;
        this.view7f09021b.setOnClickListener(null);
        this.view7f09021b = null;
    }
}
