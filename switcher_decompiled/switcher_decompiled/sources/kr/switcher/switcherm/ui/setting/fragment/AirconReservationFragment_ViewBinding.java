package kr.switcher.switcherm.ui.setting.fragment;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
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
public class AirconReservationFragment_ViewBinding implements Unbinder {
    private AirconReservationFragment target;
    private View view7f090091;
    private View view7f09009c;
    private View view7f09009d;
    private View view7f090184;
    private View view7f090185;
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

    public AirconReservationFragment_ViewBinding(final AirconReservationFragment airconReservationFragment, View view) {
        this.target = airconReservationFragment;
        airconReservationFragment.et_reservation_title = (EditText) Utils.findRequiredViewAsType(view, R.id.et_reservation_title, "field 'et_reservation_title'", EditText.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.lin_timer_off, "field 'lin_timer_off' and method 'onTimerSwitchOffButtonClicked'");
        airconReservationFragment.lin_timer_off = (LinearLayout) Utils.castView(viewFindRequiredView, R.id.lin_timer_off, "field 'lin_timer_off'", LinearLayout.class);
        this.view7f090184 = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.setting.fragment.AirconReservationFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                airconReservationFragment.onTimerSwitchOffButtonClicked();
            }
        });
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.lin_timer_on, "field 'lin_timer_on' and method 'onTimerSwitchOnButtonClicked'");
        airconReservationFragment.lin_timer_on = (LinearLayout) Utils.castView(viewFindRequiredView2, R.id.lin_timer_on, "field 'lin_timer_on'", LinearLayout.class);
        this.view7f090185 = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.setting.fragment.AirconReservationFragment_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                airconReservationFragment.onTimerSwitchOnButtonClicked();
            }
        });
        airconReservationFragment.tv_timer_off = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_timer_off, "field 'tv_timer_off'", TextView.class);
        airconReservationFragment.tv_timer_on = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_timer_on, "field 'tv_timer_on'", TextView.class);
        airconReservationFragment.tv_reservation_temperature = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_reservation_temperature, "field 'tv_reservation_temperature'", TextView.class);
        airconReservationFragment.tv_setting_temperature = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_setting_temperature, "field 'tv_setting_temperature'", TextView.class);
        airconReservationFragment.tv_temperature_symbol = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_temperature_symbol, "field 'tv_temperature_symbol'", TextView.class);
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.btn_temperature_up, "field 'btn_temperature_up' and method 'onTemperatureUpButtonClicked'");
        airconReservationFragment.btn_temperature_up = (ImageButton) Utils.castView(viewFindRequiredView3, R.id.btn_temperature_up, "field 'btn_temperature_up'", ImageButton.class);
        this.view7f09009d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.setting.fragment.AirconReservationFragment_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                airconReservationFragment.onTemperatureUpButtonClicked();
            }
        });
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.btn_temperature_down, "field 'btn_temperature_down' and method 'onTemperatureDownButtonClicked'");
        airconReservationFragment.btn_temperature_down = (ImageButton) Utils.castView(viewFindRequiredView4, R.id.btn_temperature_down, "field 'btn_temperature_down'", ImageButton.class);
        this.view7f09009c = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.setting.fragment.AirconReservationFragment_ViewBinding.4
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                airconReservationFragment.onTemperatureDownButtonClicked();
            }
        });
        airconReservationFragment.wv_hour = (AbstractWheel) Utils.findRequiredViewAsType(view, R.id.wv_hour, "field 'wv_hour'", AbstractWheel.class);
        airconReservationFragment.wv_min = (AbstractWheel) Utils.findRequiredViewAsType(view, R.id.wv_min, "field 'wv_min'", AbstractWheel.class);
        airconReservationFragment.tv_daily = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_daily, "field 'tv_daily'", TextView.class);
        airconReservationFragment.tv_weekday = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_weekday, "field 'tv_weekday'", TextView.class);
        airconReservationFragment.tv_weekend = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_weekend, "field 'tv_weekend'", TextView.class);
        View viewFindRequiredView5 = Utils.findRequiredView(view, R.id.tv_mon, "field 'tv_mon' and method 'onMondayButtonClicked'");
        airconReservationFragment.tv_mon = (TextView) Utils.castView(viewFindRequiredView5, R.id.tv_mon, "field 'tv_mon'", TextView.class);
        this.view7f0902e4 = viewFindRequiredView5;
        viewFindRequiredView5.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.setting.fragment.AirconReservationFragment_ViewBinding.5
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                airconReservationFragment.onMondayButtonClicked();
            }
        });
        View viewFindRequiredView6 = Utils.findRequiredView(view, R.id.tv_tue, "field 'tv_tue' and method 'onTuedayButtonClicked'");
        airconReservationFragment.tv_tue = (TextView) Utils.castView(viewFindRequiredView6, R.id.tv_tue, "field 'tv_tue'", TextView.class);
        this.view7f09033e = viewFindRequiredView6;
        viewFindRequiredView6.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.setting.fragment.AirconReservationFragment_ViewBinding.6
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                airconReservationFragment.onTuedayButtonClicked();
            }
        });
        View viewFindRequiredView7 = Utils.findRequiredView(view, R.id.tv_wed, "field 'tv_wed' and method 'onWeddayButtonClicked'");
        airconReservationFragment.tv_wed = (TextView) Utils.castView(viewFindRequiredView7, R.id.tv_wed, "field 'tv_wed'", TextView.class);
        this.view7f090345 = viewFindRequiredView7;
        viewFindRequiredView7.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.setting.fragment.AirconReservationFragment_ViewBinding.7
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                airconReservationFragment.onWeddayButtonClicked();
            }
        });
        View viewFindRequiredView8 = Utils.findRequiredView(view, R.id.tv_thu, "field 'tv_thu' and method 'onThudayButtonClicked'");
        airconReservationFragment.tv_thu = (TextView) Utils.castView(viewFindRequiredView8, R.id.tv_thu, "field 'tv_thu'", TextView.class);
        this.view7f090333 = viewFindRequiredView8;
        viewFindRequiredView8.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.setting.fragment.AirconReservationFragment_ViewBinding.8
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                airconReservationFragment.onThudayButtonClicked();
            }
        });
        View viewFindRequiredView9 = Utils.findRequiredView(view, R.id.tv_fri, "field 'tv_fri' and method 'onFridayButtonClicked'");
        airconReservationFragment.tv_fri = (TextView) Utils.castView(viewFindRequiredView9, R.id.tv_fri, "field 'tv_fri'", TextView.class);
        this.view7f0902c6 = viewFindRequiredView9;
        viewFindRequiredView9.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.setting.fragment.AirconReservationFragment_ViewBinding.9
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                airconReservationFragment.onFridayButtonClicked();
            }
        });
        View viewFindRequiredView10 = Utils.findRequiredView(view, R.id.tv_sat, "field 'tv_sat' and method 'onSatdayButtonClicked'");
        airconReservationFragment.tv_sat = (TextView) Utils.castView(viewFindRequiredView10, R.id.tv_sat, "field 'tv_sat'", TextView.class);
        this.view7f090318 = viewFindRequiredView10;
        viewFindRequiredView10.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.setting.fragment.AirconReservationFragment_ViewBinding.10
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                airconReservationFragment.onSatdayButtonClicked();
            }
        });
        View viewFindRequiredView11 = Utils.findRequiredView(view, R.id.tv_sun, "field 'tv_sun' and method 'onSundayButtonClicked'");
        airconReservationFragment.tv_sun = (TextView) Utils.castView(viewFindRequiredView11, R.id.tv_sun, "field 'tv_sun'", TextView.class);
        this.view7f09032a = viewFindRequiredView11;
        viewFindRequiredView11.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.setting.fragment.AirconReservationFragment_ViewBinding.11
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                airconReservationFragment.onSundayButtonClicked();
            }
        });
        View viewFindRequiredView12 = Utils.findRequiredView(view, R.id.btn_reservation_remove, "field 'btn_reservation_remove' and method 'onRemoveButtonClicked'");
        airconReservationFragment.btn_reservation_remove = (Button) Utils.castView(viewFindRequiredView12, R.id.btn_reservation_remove, "field 'btn_reservation_remove'", Button.class);
        this.view7f090091 = viewFindRequiredView12;
        viewFindRequiredView12.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.setting.fragment.AirconReservationFragment_ViewBinding.12
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                airconReservationFragment.onRemoveButtonClicked();
            }
        });
        airconReservationFragment.rl_remove = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_remove, "field 'rl_remove'", RelativeLayout.class);
        airconReservationFragment.pb_loading = (ProgressBar) Utils.findRequiredViewAsType(view, R.id.pb_loading, "field 'pb_loading'", ProgressBar.class);
        View viewFindRequiredView13 = Utils.findRequiredView(view, R.id.rl_daily, "method 'onDailyButtonClicked'");
        this.view7f0901e4 = viewFindRequiredView13;
        viewFindRequiredView13.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.setting.fragment.AirconReservationFragment_ViewBinding.13
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                airconReservationFragment.onDailyButtonClicked();
            }
        });
        View viewFindRequiredView14 = Utils.findRequiredView(view, R.id.rl_weekday, "method 'onWeekdayButtonClicked'");
        this.view7f09021a = viewFindRequiredView14;
        viewFindRequiredView14.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.setting.fragment.AirconReservationFragment_ViewBinding.14
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                airconReservationFragment.onWeekdayButtonClicked();
            }
        });
        View viewFindRequiredView15 = Utils.findRequiredView(view, R.id.rl_weekend, "method 'onWeekendButtonClicked'");
        this.view7f09021b = viewFindRequiredView15;
        viewFindRequiredView15.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.setting.fragment.AirconReservationFragment_ViewBinding.15
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                airconReservationFragment.onWeekendButtonClicked();
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        AirconReservationFragment airconReservationFragment = this.target;
        if (airconReservationFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        airconReservationFragment.et_reservation_title = null;
        airconReservationFragment.lin_timer_off = null;
        airconReservationFragment.lin_timer_on = null;
        airconReservationFragment.tv_timer_off = null;
        airconReservationFragment.tv_timer_on = null;
        airconReservationFragment.tv_reservation_temperature = null;
        airconReservationFragment.tv_setting_temperature = null;
        airconReservationFragment.tv_temperature_symbol = null;
        airconReservationFragment.btn_temperature_up = null;
        airconReservationFragment.btn_temperature_down = null;
        airconReservationFragment.wv_hour = null;
        airconReservationFragment.wv_min = null;
        airconReservationFragment.tv_daily = null;
        airconReservationFragment.tv_weekday = null;
        airconReservationFragment.tv_weekend = null;
        airconReservationFragment.tv_mon = null;
        airconReservationFragment.tv_tue = null;
        airconReservationFragment.tv_wed = null;
        airconReservationFragment.tv_thu = null;
        airconReservationFragment.tv_fri = null;
        airconReservationFragment.tv_sat = null;
        airconReservationFragment.tv_sun = null;
        airconReservationFragment.btn_reservation_remove = null;
        airconReservationFragment.rl_remove = null;
        airconReservationFragment.pb_loading = null;
        this.view7f090184.setOnClickListener(null);
        this.view7f090184 = null;
        this.view7f090185.setOnClickListener(null);
        this.view7f090185 = null;
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
        this.view7f090091.setOnClickListener(null);
        this.view7f090091 = null;
        this.view7f0901e4.setOnClickListener(null);
        this.view7f0901e4 = null;
        this.view7f09021a.setOnClickListener(null);
        this.view7f09021a = null;
        this.view7f09021b.setOnClickListener(null);
        this.view7f09021b = null;
    }
}
