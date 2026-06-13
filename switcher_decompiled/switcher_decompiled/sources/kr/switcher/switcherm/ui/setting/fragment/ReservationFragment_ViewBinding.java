package kr.switcher.switcherm.ui.setting.fragment;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import antistatic.spinnerwheel.AbstractWheel;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import kr.switcher.switcherm.R;

/* JADX INFO: loaded from: classes2.dex */
public class ReservationFragment_ViewBinding implements Unbinder {
    private ReservationFragment target;
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

    public ReservationFragment_ViewBinding(final ReservationFragment reservationFragment, View view) {
        this.target = reservationFragment;
        reservationFragment.vp_switcher_type = (ViewPager) Utils.findRequiredViewAsType(view, R.id.vp_switcher_type, "field 'vp_switcher_type'", ViewPager.class);
        reservationFragment.wv_ampm = (AbstractWheel) Utils.findRequiredViewAsType(view, R.id.wv_ampm, "field 'wv_ampm'", AbstractWheel.class);
        reservationFragment.wv_hour = (AbstractWheel) Utils.findRequiredViewAsType(view, R.id.wv_hour, "field 'wv_hour'", AbstractWheel.class);
        reservationFragment.wv_min = (AbstractWheel) Utils.findRequiredViewAsType(view, R.id.wv_min, "field 'wv_min'", AbstractWheel.class);
        reservationFragment.btn_remove = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.btn_remove, "field 'btn_remove'", RelativeLayout.class);
        reservationFragment.rl_view_pager = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_view_pager, "field 'rl_view_pager'", RelativeLayout.class);
        reservationFragment.btn_right_arrow = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.btn_right_arrow, "field 'btn_right_arrow'", RelativeLayout.class);
        reservationFragment.btn_left_arrow = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.btn_left_arrow, "field 'btn_left_arrow'", RelativeLayout.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.lin_timer_off, "field 'lin_timer_off' and method 'onTimerSwitchOffButtonClicked'");
        reservationFragment.lin_timer_off = (LinearLayout) Utils.castView(viewFindRequiredView, R.id.lin_timer_off, "field 'lin_timer_off'", LinearLayout.class);
        this.view7f090184 = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.setting.fragment.ReservationFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                reservationFragment.onTimerSwitchOffButtonClicked();
            }
        });
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.lin_timer_on, "field 'lin_timer_on' and method 'onTimerSwitchOnButtonClicked'");
        reservationFragment.lin_timer_on = (LinearLayout) Utils.castView(viewFindRequiredView2, R.id.lin_timer_on, "field 'lin_timer_on'", LinearLayout.class);
        this.view7f090185 = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.setting.fragment.ReservationFragment_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                reservationFragment.onTimerSwitchOnButtonClicked();
            }
        });
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.tv_mon, "field 'tv_mon' and method 'onMondayButtonClicked'");
        reservationFragment.tv_mon = (TextView) Utils.castView(viewFindRequiredView3, R.id.tv_mon, "field 'tv_mon'", TextView.class);
        this.view7f0902e4 = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.setting.fragment.ReservationFragment_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                reservationFragment.onMondayButtonClicked();
            }
        });
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.tv_tue, "field 'tv_tue' and method 'onTuedayButtonClicked'");
        reservationFragment.tv_tue = (TextView) Utils.castView(viewFindRequiredView4, R.id.tv_tue, "field 'tv_tue'", TextView.class);
        this.view7f09033e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.setting.fragment.ReservationFragment_ViewBinding.4
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                reservationFragment.onTuedayButtonClicked();
            }
        });
        View viewFindRequiredView5 = Utils.findRequiredView(view, R.id.tv_wed, "field 'tv_wed' and method 'onWeddayButtonClicked'");
        reservationFragment.tv_wed = (TextView) Utils.castView(viewFindRequiredView5, R.id.tv_wed, "field 'tv_wed'", TextView.class);
        this.view7f090345 = viewFindRequiredView5;
        viewFindRequiredView5.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.setting.fragment.ReservationFragment_ViewBinding.5
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                reservationFragment.onWeddayButtonClicked();
            }
        });
        View viewFindRequiredView6 = Utils.findRequiredView(view, R.id.tv_thu, "field 'tv_thu' and method 'onThudayButtonClicked'");
        reservationFragment.tv_thu = (TextView) Utils.castView(viewFindRequiredView6, R.id.tv_thu, "field 'tv_thu'", TextView.class);
        this.view7f090333 = viewFindRequiredView6;
        viewFindRequiredView6.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.setting.fragment.ReservationFragment_ViewBinding.6
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                reservationFragment.onThudayButtonClicked();
            }
        });
        View viewFindRequiredView7 = Utils.findRequiredView(view, R.id.tv_fri, "field 'tv_fri' and method 'onFridayButtonClicked'");
        reservationFragment.tv_fri = (TextView) Utils.castView(viewFindRequiredView7, R.id.tv_fri, "field 'tv_fri'", TextView.class);
        this.view7f0902c6 = viewFindRequiredView7;
        viewFindRequiredView7.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.setting.fragment.ReservationFragment_ViewBinding.7
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                reservationFragment.onFridayButtonClicked();
            }
        });
        View viewFindRequiredView8 = Utils.findRequiredView(view, R.id.tv_sat, "field 'tv_sat' and method 'onSatdayButtonClicked'");
        reservationFragment.tv_sat = (TextView) Utils.castView(viewFindRequiredView8, R.id.tv_sat, "field 'tv_sat'", TextView.class);
        this.view7f090318 = viewFindRequiredView8;
        viewFindRequiredView8.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.setting.fragment.ReservationFragment_ViewBinding.8
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                reservationFragment.onSatdayButtonClicked();
            }
        });
        View viewFindRequiredView9 = Utils.findRequiredView(view, R.id.tv_sun, "field 'tv_sun' and method 'onSundayButtonClicked'");
        reservationFragment.tv_sun = (TextView) Utils.castView(viewFindRequiredView9, R.id.tv_sun, "field 'tv_sun'", TextView.class);
        this.view7f09032a = viewFindRequiredView9;
        viewFindRequiredView9.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.setting.fragment.ReservationFragment_ViewBinding.9
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                reservationFragment.onSundayButtonClicked();
            }
        });
        reservationFragment.tv_timer_off = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_timer_off, "field 'tv_timer_off'", TextView.class);
        reservationFragment.tv_timer_on = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_timer_on, "field 'tv_timer_on'", TextView.class);
        reservationFragment.tv_daily = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_daily, "field 'tv_daily'", TextView.class);
        reservationFragment.tv_weekday = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_weekday, "field 'tv_weekday'", TextView.class);
        reservationFragment.tv_weekend = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_weekend, "field 'tv_weekend'", TextView.class);
        reservationFragment.iv_timer_on = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_timer_on, "field 'iv_timer_on'", ImageView.class);
        reservationFragment.iv_timer_off = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_timer_off, "field 'iv_timer_off'", ImageView.class);
        reservationFragment.et_reservation_title = (EditText) Utils.findRequiredViewAsType(view, R.id.et_reservation_title, "field 'et_reservation_title'", EditText.class);
        reservationFragment.pb_loading = (ProgressBar) Utils.findRequiredViewAsType(view, R.id.pb_loading, "field 'pb_loading'", ProgressBar.class);
        View viewFindRequiredView10 = Utils.findRequiredView(view, R.id.rl_daily, "method 'onDailyButtonClicked'");
        this.view7f0901e4 = viewFindRequiredView10;
        viewFindRequiredView10.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.setting.fragment.ReservationFragment_ViewBinding.10
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                reservationFragment.onDailyButtonClicked();
            }
        });
        View viewFindRequiredView11 = Utils.findRequiredView(view, R.id.rl_weekday, "method 'onWeekdayButtonClicked'");
        this.view7f09021a = viewFindRequiredView11;
        viewFindRequiredView11.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.setting.fragment.ReservationFragment_ViewBinding.11
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                reservationFragment.onWeekdayButtonClicked();
            }
        });
        View viewFindRequiredView12 = Utils.findRequiredView(view, R.id.rl_weekend, "method 'onWeekendButtonClicked'");
        this.view7f09021b = viewFindRequiredView12;
        viewFindRequiredView12.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.setting.fragment.ReservationFragment_ViewBinding.12
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                reservationFragment.onWeekendButtonClicked();
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        ReservationFragment reservationFragment = this.target;
        if (reservationFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        reservationFragment.vp_switcher_type = null;
        reservationFragment.wv_ampm = null;
        reservationFragment.wv_hour = null;
        reservationFragment.wv_min = null;
        reservationFragment.btn_remove = null;
        reservationFragment.rl_view_pager = null;
        reservationFragment.btn_right_arrow = null;
        reservationFragment.btn_left_arrow = null;
        reservationFragment.lin_timer_off = null;
        reservationFragment.lin_timer_on = null;
        reservationFragment.tv_mon = null;
        reservationFragment.tv_tue = null;
        reservationFragment.tv_wed = null;
        reservationFragment.tv_thu = null;
        reservationFragment.tv_fri = null;
        reservationFragment.tv_sat = null;
        reservationFragment.tv_sun = null;
        reservationFragment.tv_timer_off = null;
        reservationFragment.tv_timer_on = null;
        reservationFragment.tv_daily = null;
        reservationFragment.tv_weekday = null;
        reservationFragment.tv_weekend = null;
        reservationFragment.iv_timer_on = null;
        reservationFragment.iv_timer_off = null;
        reservationFragment.et_reservation_title = null;
        reservationFragment.pb_loading = null;
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
        this.view7f0901e4.setOnClickListener(null);
        this.view7f0901e4 = null;
        this.view7f09021a.setOnClickListener(null);
        this.view7f09021a = null;
        this.view7f09021b.setOnClickListener(null);
        this.view7f09021b = null;
    }
}
