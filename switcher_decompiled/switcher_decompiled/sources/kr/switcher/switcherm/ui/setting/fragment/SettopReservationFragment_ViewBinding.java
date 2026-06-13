package kr.switcher.switcherm.ui.setting.fragment;

import android.view.View;
import android.widget.EditText;
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
public class SettopReservationFragment_ViewBinding implements Unbinder {
    private SettopReservationFragment target;
    private View view7f090091;
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

    public SettopReservationFragment_ViewBinding(final SettopReservationFragment settopReservationFragment, View view) {
        this.target = settopReservationFragment;
        settopReservationFragment.et_reservation_title = (EditText) Utils.findRequiredViewAsType(view, R.id.et_reservation_title, "field 'et_reservation_title'", EditText.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.lin_timer_off, "field 'lin_timer_off' and method 'onTimerSwitchOffButtonClicked'");
        settopReservationFragment.lin_timer_off = (LinearLayout) Utils.castView(viewFindRequiredView, R.id.lin_timer_off, "field 'lin_timer_off'", LinearLayout.class);
        this.view7f090184 = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.setting.fragment.SettopReservationFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                settopReservationFragment.onTimerSwitchOffButtonClicked();
            }
        });
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.lin_timer_on, "field 'lin_timer_on' and method 'onTimerSwitchOnButtonClicked'");
        settopReservationFragment.lin_timer_on = (LinearLayout) Utils.castView(viewFindRequiredView2, R.id.lin_timer_on, "field 'lin_timer_on'", LinearLayout.class);
        this.view7f090185 = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.setting.fragment.SettopReservationFragment_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                settopReservationFragment.onTimerSwitchOnButtonClicked();
            }
        });
        settopReservationFragment.tv_timer_off = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_timer_off, "field 'tv_timer_off'", TextView.class);
        settopReservationFragment.tv_timer_on = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_timer_on, "field 'tv_timer_on'", TextView.class);
        settopReservationFragment.wv_hour = (AbstractWheel) Utils.findRequiredViewAsType(view, R.id.wv_hour, "field 'wv_hour'", AbstractWheel.class);
        settopReservationFragment.wv_min = (AbstractWheel) Utils.findRequiredViewAsType(view, R.id.wv_min, "field 'wv_min'", AbstractWheel.class);
        settopReservationFragment.lin_insert_channel = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.lin_insert_channel, "field 'lin_insert_channel'", LinearLayout.class);
        settopReservationFragment.et_channel = (EditText) Utils.findRequiredViewAsType(view, R.id.et_channel, "field 'et_channel'", EditText.class);
        settopReservationFragment.tv_channel_unit = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_channel_unit, "field 'tv_channel_unit'", TextView.class);
        settopReservationFragment.tv_daily = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_daily, "field 'tv_daily'", TextView.class);
        settopReservationFragment.tv_weekday = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_weekday, "field 'tv_weekday'", TextView.class);
        settopReservationFragment.tv_weekend = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_weekend, "field 'tv_weekend'", TextView.class);
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.tv_mon, "field 'tv_mon' and method 'onMondayButtonClicked'");
        settopReservationFragment.tv_mon = (TextView) Utils.castView(viewFindRequiredView3, R.id.tv_mon, "field 'tv_mon'", TextView.class);
        this.view7f0902e4 = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.setting.fragment.SettopReservationFragment_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                settopReservationFragment.onMondayButtonClicked();
            }
        });
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.tv_tue, "field 'tv_tue' and method 'onTuedayButtonClicked'");
        settopReservationFragment.tv_tue = (TextView) Utils.castView(viewFindRequiredView4, R.id.tv_tue, "field 'tv_tue'", TextView.class);
        this.view7f09033e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.setting.fragment.SettopReservationFragment_ViewBinding.4
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                settopReservationFragment.onTuedayButtonClicked();
            }
        });
        View viewFindRequiredView5 = Utils.findRequiredView(view, R.id.tv_wed, "field 'tv_wed' and method 'onWeddayButtonClicked'");
        settopReservationFragment.tv_wed = (TextView) Utils.castView(viewFindRequiredView5, R.id.tv_wed, "field 'tv_wed'", TextView.class);
        this.view7f090345 = viewFindRequiredView5;
        viewFindRequiredView5.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.setting.fragment.SettopReservationFragment_ViewBinding.5
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                settopReservationFragment.onWeddayButtonClicked();
            }
        });
        View viewFindRequiredView6 = Utils.findRequiredView(view, R.id.tv_thu, "field 'tv_thu' and method 'onThudayButtonClicked'");
        settopReservationFragment.tv_thu = (TextView) Utils.castView(viewFindRequiredView6, R.id.tv_thu, "field 'tv_thu'", TextView.class);
        this.view7f090333 = viewFindRequiredView6;
        viewFindRequiredView6.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.setting.fragment.SettopReservationFragment_ViewBinding.6
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                settopReservationFragment.onThudayButtonClicked();
            }
        });
        View viewFindRequiredView7 = Utils.findRequiredView(view, R.id.tv_fri, "field 'tv_fri' and method 'onFridayButtonClicked'");
        settopReservationFragment.tv_fri = (TextView) Utils.castView(viewFindRequiredView7, R.id.tv_fri, "field 'tv_fri'", TextView.class);
        this.view7f0902c6 = viewFindRequiredView7;
        viewFindRequiredView7.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.setting.fragment.SettopReservationFragment_ViewBinding.7
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                settopReservationFragment.onFridayButtonClicked();
            }
        });
        View viewFindRequiredView8 = Utils.findRequiredView(view, R.id.tv_sat, "field 'tv_sat' and method 'onSatdayButtonClicked'");
        settopReservationFragment.tv_sat = (TextView) Utils.castView(viewFindRequiredView8, R.id.tv_sat, "field 'tv_sat'", TextView.class);
        this.view7f090318 = viewFindRequiredView8;
        viewFindRequiredView8.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.setting.fragment.SettopReservationFragment_ViewBinding.8
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                settopReservationFragment.onSatdayButtonClicked();
            }
        });
        View viewFindRequiredView9 = Utils.findRequiredView(view, R.id.tv_sun, "field 'tv_sun' and method 'onSundayButtonClicked'");
        settopReservationFragment.tv_sun = (TextView) Utils.castView(viewFindRequiredView9, R.id.tv_sun, "field 'tv_sun'", TextView.class);
        this.view7f09032a = viewFindRequiredView9;
        viewFindRequiredView9.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.setting.fragment.SettopReservationFragment_ViewBinding.9
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                settopReservationFragment.onSundayButtonClicked();
            }
        });
        View viewFindRequiredView10 = Utils.findRequiredView(view, R.id.btn_reservation_remove, "field 'btn_reservation_remove' and method 'onRemoveButtonClicked'");
        settopReservationFragment.btn_reservation_remove = (Button) Utils.castView(viewFindRequiredView10, R.id.btn_reservation_remove, "field 'btn_reservation_remove'", Button.class);
        this.view7f090091 = viewFindRequiredView10;
        viewFindRequiredView10.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.setting.fragment.SettopReservationFragment_ViewBinding.10
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                settopReservationFragment.onRemoveButtonClicked();
            }
        });
        settopReservationFragment.rl_remove = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_remove, "field 'rl_remove'", RelativeLayout.class);
        settopReservationFragment.pb_loading = (ProgressBar) Utils.findRequiredViewAsType(view, R.id.pb_loading, "field 'pb_loading'", ProgressBar.class);
        View viewFindRequiredView11 = Utils.findRequiredView(view, R.id.rl_daily, "method 'onDailyButtonClicked'");
        this.view7f0901e4 = viewFindRequiredView11;
        viewFindRequiredView11.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.setting.fragment.SettopReservationFragment_ViewBinding.11
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                settopReservationFragment.onDailyButtonClicked();
            }
        });
        View viewFindRequiredView12 = Utils.findRequiredView(view, R.id.rl_weekday, "method 'onWeekdayButtonClicked'");
        this.view7f09021a = viewFindRequiredView12;
        viewFindRequiredView12.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.setting.fragment.SettopReservationFragment_ViewBinding.12
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                settopReservationFragment.onWeekdayButtonClicked();
            }
        });
        View viewFindRequiredView13 = Utils.findRequiredView(view, R.id.rl_weekend, "method 'onWeekendButtonClicked'");
        this.view7f09021b = viewFindRequiredView13;
        viewFindRequiredView13.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.setting.fragment.SettopReservationFragment_ViewBinding.13
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                settopReservationFragment.onWeekendButtonClicked();
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        SettopReservationFragment settopReservationFragment = this.target;
        if (settopReservationFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        settopReservationFragment.et_reservation_title = null;
        settopReservationFragment.lin_timer_off = null;
        settopReservationFragment.lin_timer_on = null;
        settopReservationFragment.tv_timer_off = null;
        settopReservationFragment.tv_timer_on = null;
        settopReservationFragment.wv_hour = null;
        settopReservationFragment.wv_min = null;
        settopReservationFragment.lin_insert_channel = null;
        settopReservationFragment.et_channel = null;
        settopReservationFragment.tv_channel_unit = null;
        settopReservationFragment.tv_daily = null;
        settopReservationFragment.tv_weekday = null;
        settopReservationFragment.tv_weekend = null;
        settopReservationFragment.tv_mon = null;
        settopReservationFragment.tv_tue = null;
        settopReservationFragment.tv_wed = null;
        settopReservationFragment.tv_thu = null;
        settopReservationFragment.tv_fri = null;
        settopReservationFragment.tv_sat = null;
        settopReservationFragment.tv_sun = null;
        settopReservationFragment.btn_reservation_remove = null;
        settopReservationFragment.rl_remove = null;
        settopReservationFragment.pb_loading = null;
        this.view7f090184.setOnClickListener(null);
        this.view7f090184 = null;
        this.view7f090185.setOnClickListener(null);
        this.view7f090185 = null;
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
