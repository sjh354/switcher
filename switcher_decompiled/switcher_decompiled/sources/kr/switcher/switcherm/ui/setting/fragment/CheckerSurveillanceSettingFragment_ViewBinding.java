package kr.switcher.switcherm.ui.setting.fragment;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import antistatic.spinnerwheel.AbstractWheel;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.rey.material.widget.Button;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.ui.setting.viewpager.ChekcerLevelViewPager;

/* JADX INFO: loaded from: classes2.dex */
public class CheckerSurveillanceSettingFragment_ViewBinding implements Unbinder {
    private CheckerSurveillanceSettingFragment target;
    private View view7f09008e;
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

    public CheckerSurveillanceSettingFragment_ViewBinding(final CheckerSurveillanceSettingFragment checkerSurveillanceSettingFragment, View view) {
        this.target = checkerSurveillanceSettingFragment;
        checkerSurveillanceSettingFragment.et_title = (EditText) Utils.findRequiredViewAsType(view, R.id.et_title, "field 'et_title'", EditText.class);
        checkerSurveillanceSettingFragment.wv_start_hour = (AbstractWheel) Utils.findRequiredViewAsType(view, R.id.wv_start_hour, "field 'wv_start_hour'", AbstractWheel.class);
        checkerSurveillanceSettingFragment.wv_start_min = (AbstractWheel) Utils.findRequiredViewAsType(view, R.id.wv_start_min, "field 'wv_start_min'", AbstractWheel.class);
        checkerSurveillanceSettingFragment.wv_end_hour = (AbstractWheel) Utils.findRequiredViewAsType(view, R.id.wv_end_hour, "field 'wv_end_hour'", AbstractWheel.class);
        checkerSurveillanceSettingFragment.wv_end_min = (AbstractWheel) Utils.findRequiredViewAsType(view, R.id.wv_end_min, "field 'wv_end_min'", AbstractWheel.class);
        checkerSurveillanceSettingFragment.tv_daily = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_daily, "field 'tv_daily'", TextView.class);
        checkerSurveillanceSettingFragment.tv_weekday = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_weekday, "field 'tv_weekday'", TextView.class);
        checkerSurveillanceSettingFragment.tv_weekend = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_weekend, "field 'tv_weekend'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.tv_mon, "field 'tv_mon' and method 'onMondayButtonClicked'");
        checkerSurveillanceSettingFragment.tv_mon = (TextView) Utils.castView(viewFindRequiredView, R.id.tv_mon, "field 'tv_mon'", TextView.class);
        this.view7f0902e4 = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.setting.fragment.CheckerSurveillanceSettingFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                checkerSurveillanceSettingFragment.onMondayButtonClicked();
            }
        });
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.tv_tue, "field 'tv_tue' and method 'onTuedayButtonClicked'");
        checkerSurveillanceSettingFragment.tv_tue = (TextView) Utils.castView(viewFindRequiredView2, R.id.tv_tue, "field 'tv_tue'", TextView.class);
        this.view7f09033e = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.setting.fragment.CheckerSurveillanceSettingFragment_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                checkerSurveillanceSettingFragment.onTuedayButtonClicked();
            }
        });
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.tv_wed, "field 'tv_wed' and method 'onWeddayButtonClicked'");
        checkerSurveillanceSettingFragment.tv_wed = (TextView) Utils.castView(viewFindRequiredView3, R.id.tv_wed, "field 'tv_wed'", TextView.class);
        this.view7f090345 = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.setting.fragment.CheckerSurveillanceSettingFragment_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                checkerSurveillanceSettingFragment.onWeddayButtonClicked();
            }
        });
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.tv_thu, "field 'tv_thu' and method 'onThudayButtonClicked'");
        checkerSurveillanceSettingFragment.tv_thu = (TextView) Utils.castView(viewFindRequiredView4, R.id.tv_thu, "field 'tv_thu'", TextView.class);
        this.view7f090333 = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.setting.fragment.CheckerSurveillanceSettingFragment_ViewBinding.4
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                checkerSurveillanceSettingFragment.onThudayButtonClicked();
            }
        });
        View viewFindRequiredView5 = Utils.findRequiredView(view, R.id.tv_fri, "field 'tv_fri' and method 'onFridayButtonClicked'");
        checkerSurveillanceSettingFragment.tv_fri = (TextView) Utils.castView(viewFindRequiredView5, R.id.tv_fri, "field 'tv_fri'", TextView.class);
        this.view7f0902c6 = viewFindRequiredView5;
        viewFindRequiredView5.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.setting.fragment.CheckerSurveillanceSettingFragment_ViewBinding.5
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                checkerSurveillanceSettingFragment.onFridayButtonClicked();
            }
        });
        View viewFindRequiredView6 = Utils.findRequiredView(view, R.id.tv_sat, "field 'tv_sat' and method 'onSatdayButtonClicked'");
        checkerSurveillanceSettingFragment.tv_sat = (TextView) Utils.castView(viewFindRequiredView6, R.id.tv_sat, "field 'tv_sat'", TextView.class);
        this.view7f090318 = viewFindRequiredView6;
        viewFindRequiredView6.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.setting.fragment.CheckerSurveillanceSettingFragment_ViewBinding.6
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                checkerSurveillanceSettingFragment.onSatdayButtonClicked();
            }
        });
        View viewFindRequiredView7 = Utils.findRequiredView(view, R.id.tv_sun, "field 'tv_sun' and method 'onSundayButtonClicked'");
        checkerSurveillanceSettingFragment.tv_sun = (TextView) Utils.castView(viewFindRequiredView7, R.id.tv_sun, "field 'tv_sun'", TextView.class);
        this.view7f09032a = viewFindRequiredView7;
        viewFindRequiredView7.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.setting.fragment.CheckerSurveillanceSettingFragment_ViewBinding.7
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                checkerSurveillanceSettingFragment.onSundayButtonClicked();
            }
        });
        View viewFindRequiredView8 = Utils.findRequiredView(view, R.id.btn_remove, "field 'btn_remove' and method 'onRemoveButtonClicked'");
        checkerSurveillanceSettingFragment.btn_remove = (Button) Utils.castView(viewFindRequiredView8, R.id.btn_remove, "field 'btn_remove'", Button.class);
        this.view7f09008e = viewFindRequiredView8;
        viewFindRequiredView8.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.setting.fragment.CheckerSurveillanceSettingFragment_ViewBinding.8
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                checkerSurveillanceSettingFragment.onRemoveButtonClicked();
            }
        });
        checkerSurveillanceSettingFragment.rl_remove = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_remove, "field 'rl_remove'", RelativeLayout.class);
        checkerSurveillanceSettingFragment.pb_loading = (ProgressBar) Utils.findRequiredViewAsType(view, R.id.pb_loading, "field 'pb_loading'", ProgressBar.class);
        checkerSurveillanceSettingFragment.vp_propose = (ChekcerLevelViewPager) Utils.findRequiredViewAsType(view, R.id.vp_propose, "field 'vp_propose'", ChekcerLevelViewPager.class);
        checkerSurveillanceSettingFragment.iv_left_arrow_btn = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_left_arrow_btn, "field 'iv_left_arrow_btn'", ImageView.class);
        checkerSurveillanceSettingFragment.iv_right_arrow_btn = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_right_arrow_btn, "field 'iv_right_arrow_btn'", ImageView.class);
        checkerSurveillanceSettingFragment.rl_left_arrow_btn = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_left_arrow_btn, "field 'rl_left_arrow_btn'", RelativeLayout.class);
        checkerSurveillanceSettingFragment.rl_right_arrow_btn = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_right_arrow_btn, "field 'rl_right_arrow_btn'", RelativeLayout.class);
        View viewFindRequiredView9 = Utils.findRequiredView(view, R.id.rl_daily, "method 'onDailyButtonClicked'");
        this.view7f0901e4 = viewFindRequiredView9;
        viewFindRequiredView9.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.setting.fragment.CheckerSurveillanceSettingFragment_ViewBinding.9
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                checkerSurveillanceSettingFragment.onDailyButtonClicked();
            }
        });
        View viewFindRequiredView10 = Utils.findRequiredView(view, R.id.rl_weekday, "method 'onWeekdayButtonClicked'");
        this.view7f09021a = viewFindRequiredView10;
        viewFindRequiredView10.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.setting.fragment.CheckerSurveillanceSettingFragment_ViewBinding.10
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                checkerSurveillanceSettingFragment.onWeekdayButtonClicked();
            }
        });
        View viewFindRequiredView11 = Utils.findRequiredView(view, R.id.rl_weekend, "method 'onWeekendButtonClicked'");
        this.view7f09021b = viewFindRequiredView11;
        viewFindRequiredView11.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.setting.fragment.CheckerSurveillanceSettingFragment_ViewBinding.11
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                checkerSurveillanceSettingFragment.onWeekendButtonClicked();
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        CheckerSurveillanceSettingFragment checkerSurveillanceSettingFragment = this.target;
        if (checkerSurveillanceSettingFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        checkerSurveillanceSettingFragment.et_title = null;
        checkerSurveillanceSettingFragment.wv_start_hour = null;
        checkerSurveillanceSettingFragment.wv_start_min = null;
        checkerSurveillanceSettingFragment.wv_end_hour = null;
        checkerSurveillanceSettingFragment.wv_end_min = null;
        checkerSurveillanceSettingFragment.tv_daily = null;
        checkerSurveillanceSettingFragment.tv_weekday = null;
        checkerSurveillanceSettingFragment.tv_weekend = null;
        checkerSurveillanceSettingFragment.tv_mon = null;
        checkerSurveillanceSettingFragment.tv_tue = null;
        checkerSurveillanceSettingFragment.tv_wed = null;
        checkerSurveillanceSettingFragment.tv_thu = null;
        checkerSurveillanceSettingFragment.tv_fri = null;
        checkerSurveillanceSettingFragment.tv_sat = null;
        checkerSurveillanceSettingFragment.tv_sun = null;
        checkerSurveillanceSettingFragment.btn_remove = null;
        checkerSurveillanceSettingFragment.rl_remove = null;
        checkerSurveillanceSettingFragment.pb_loading = null;
        checkerSurveillanceSettingFragment.vp_propose = null;
        checkerSurveillanceSettingFragment.iv_left_arrow_btn = null;
        checkerSurveillanceSettingFragment.iv_right_arrow_btn = null;
        checkerSurveillanceSettingFragment.rl_left_arrow_btn = null;
        checkerSurveillanceSettingFragment.rl_right_arrow_btn = null;
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
        this.view7f09008e.setOnClickListener(null);
        this.view7f09008e = null;
        this.view7f0901e4.setOnClickListener(null);
        this.view7f0901e4 = null;
        this.view7f09021a.setOnClickListener(null);
        this.view7f09021a = null;
        this.view7f09021b.setOnClickListener(null);
        this.view7f09021b = null;
    }
}
