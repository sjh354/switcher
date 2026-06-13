package kr.switcher.switcherm.ui.setting.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import antistatic.spinnerwheel.AbstractWheel;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import kr.switcher.device.IODeviceConfig;
import kr.switcher.device.common.DeviceUtil;
import kr.switcher.device.switcher.Switcher;
import kr.switcher.device.switcher.interfaces.IODeviceCallbacks;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.device.switcher.handler.SwitcherDBProvider;
import kr.switcher.switcherm.device.switcher.handler.SwitcherHandler;
import kr.switcher.switcherm.preference.OAuthToken;
import kr.switcher.switcherm.ui.setting.adapter.ReservationWheelAdapter;
import kr.switcher.switcherm.ui.setting.adapter.SwitcherPagerAdapter;
import kr.switcher.switcherm.ui.setting.event.ReservationGA;
import kr.switcher.switcherm.ui.setting.helper.DayOfWeekRepeater;
import kr.switcher.switcherm.ui.setting.helper.ReservationInfo;
import kr.switcher.switcherm.ui.setting.helper.TimerJsonParser;
import kr.switcher.switcherm.ui.setting.presenter.ReservationPresenter;
import kr.switcher.switcherm.ui.setting.view.ReservationView;

/* JADX INFO: loaded from: classes2.dex */
public class ReservationFragment extends Fragment implements ReservationView {
    private static final String PARM_SWITCHER_TIMER = "SWITCHER_TIMER";
    public static final int POSITION_LEFTMOST = 0;
    public static final int POSITION_RIGHTMOST = 1;
    private static final String TAG = "ReservationFragment";
    private ReservationWheelAdapter ampmAdapter;

    @BindView(R.id.btn_left_arrow)
    RelativeLayout btn_left_arrow;

    @BindView(R.id.btn_remove)
    RelativeLayout btn_remove;

    @BindView(R.id.btn_right_arrow)
    RelativeLayout btn_right_arrow;
    private Switcher connectedSwitcher;

    @BindView(R.id.et_reservation_title)
    EditText et_reservation_title;
    private ReservationGA ga;
    private ReservationWheelAdapter hourAdapter;
    private boolean isSelected;

    @BindView(R.id.iv_timer_off)
    ImageView iv_timer_off;

    @BindView(R.id.iv_timer_on)
    ImageView iv_timer_on;

    @BindView(R.id.lin_timer_off)
    LinearLayout lin_timer_off;

    @BindView(R.id.lin_timer_on)
    LinearLayout lin_timer_on;
    private ReservationWheelAdapter minAdapter;
    private SwitcherPagerAdapter pagerAdapter;

    @BindView(R.id.pb_loading)
    ProgressBar pb_loading;
    private ReservationPresenter presenter;

    @BindView(R.id.rl_view_pager)
    RelativeLayout rl_view_pager;
    private ReservationWheelAdapter switchAdapter;
    private Switcher.SwitcherReservation switcherTimer;

    @BindView(R.id.tv_daily)
    TextView tv_daily;

    @BindView(R.id.tv_fri)
    TextView tv_fri;

    @BindView(R.id.tv_mon)
    TextView tv_mon;

    @BindView(R.id.tv_sat)
    TextView tv_sat;

    @BindView(R.id.tv_sun)
    TextView tv_sun;

    @BindView(R.id.tv_thu)
    TextView tv_thu;

    @BindView(R.id.tv_timer_off)
    TextView tv_timer_off;

    @BindView(R.id.tv_timer_on)
    TextView tv_timer_on;

    @BindView(R.id.tv_tue)
    TextView tv_tue;

    @BindView(R.id.tv_wed)
    TextView tv_wed;

    @BindView(R.id.tv_weekday)
    TextView tv_weekday;

    @BindView(R.id.tv_weekend)
    TextView tv_weekend;

    @BindView(R.id.vp_switcher_type)
    ViewPager vp_switcher_type;

    @BindView(R.id.wv_ampm)
    AbstractWheel wv_ampm;

    @BindView(R.id.wv_hour)
    AbstractWheel wv_hour;

    @BindView(R.id.wv_min)
    AbstractWheel wv_min;

    public static ReservationFragment newInstance(String str, Switcher.SwitcherReservation switcherReservation) {
        ReservationFragment reservationFragment = new ReservationFragment();
        Bundle bundle = new Bundle();
        bundle.putString("CONNECTED_MAC_ADDRESS", str);
        bundle.putString(PARM_SWITCHER_TIMER, TimerJsonParser.makeSwitcherReservationJson(switcherReservation));
        reservationFragment.setArguments(bundle);
        return reservationFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String string;
        View viewInflate = layoutInflater.inflate(R.layout.fragment_reservation, viewGroup, false);
        ButterKnife.bind(this, viewInflate);
        this.switcherTimer = null;
        Bundle arguments = getArguments();
        if (arguments != null) {
            string = arguments.getString("CONNECTED_MAC_ADDRESS");
            try {
                this.switcherTimer = TimerJsonParser.parseSwitcherReservation(arguments.getString(PARM_SWITCHER_TIMER));
            } catch (Exception e) {
                IOLog.error(TAG, new OAuthToken().getOAuthToken(), "onCreateView", e);
            }
        } else {
            string = null;
        }
        if (string == null) {
            return null;
        }
        Switcher switcher = SwitcherHandler.getInstance().getSwitcher(string);
        this.connectedSwitcher = switcher;
        if (switcher == null) {
            return null;
        }
        this.ga = new ReservationGA();
        ReservationPresenter reservationPresenter = new ReservationPresenter(this);
        this.presenter = reservationPresenter;
        reservationPresenter.initialize(this.connectedSwitcher, this.switcherTimer);
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        IOUtil.hideKeyBoard(this.et_reservation_title);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.ReservationView
    public void trackReservationForGA() {
        IOLog.activity(IOUtil.getStringResource(R.string.screen_title_2_3_1_3));
    }

    @Override // kr.switcher.switcherm.ui.setting.view.ReservationView
    public void trackCreateAlarmForGA(boolean z) {
        this.ga.setGACreateAlarm(z);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.ReservationView
    public void trackEditAlarmForGA(boolean z) {
        this.ga.setGAEditAlarm(z);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.ReservationView
    public void trackDeleteAlarmForGA(boolean z) {
        this.ga.setGADeleteAlarm(z);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.ReservationView
    public void selectRightItem(int i) {
        this.presenter.selectRightItem(this.vp_switcher_type.getCurrentItem(), i);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.ReservationView
    public void selectLeftItem() {
        this.presenter.selectLeftItem(this.vp_switcher_type.getCurrentItem());
    }

    @Override // kr.switcher.switcherm.ui.setting.view.ReservationView
    public void pageSelected(int i) {
        this.presenter.pageSelected(this.isSelected, i);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.ReservationView
    public void initViewPager(int i) {
        this.isSelected = false;
        int i2 = DeviceUtil.convertSwitcherType(this.connectedSwitcher.getProductId()) != 1 ? 2 : 1;
        SwitcherPagerAdapter switcherPagerAdapter = new SwitcherPagerAdapter(((AppCompatActivity) getContext()).getSupportFragmentManager(), i2);
        this.pagerAdapter = switcherPagerAdapter;
        this.vp_switcher_type.setAdapter(switcherPagerAdapter);
        this.btn_right_arrow.setOnClickListener(this.presenter.getRightArrowButtonClicked(i2));
        this.btn_left_arrow.setOnClickListener(this.presenter.getLeftArrowButtonClicked());
        this.vp_switcher_type.addOnPageChangeListener(this.presenter.getOnPageChangeListener());
        selectItem(i);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.ReservationView
    public void select(boolean z) {
        this.isSelected = z;
    }

    @Override // kr.switcher.switcherm.ui.setting.view.ReservationView
    public void selectItem(int i) {
        select(true);
        this.vp_switcher_type.setCurrentItem(i, true);
        this.presenter.setArrowStatus(i);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.ReservationView
    public void initWheel() {
        this.switchAdapter = new ReservationWheelAdapter(getContext());
        this.ampmAdapter = new ReservationWheelAdapter(getContext());
        this.hourAdapter = new ReservationWheelAdapter(getContext());
        this.minAdapter = new ReservationWheelAdapter(getContext());
        this.wv_ampm.setViewAdapter(this.ampmAdapter);
        this.wv_ampm.setCyclic(false);
        this.wv_hour.setViewAdapter(this.hourAdapter);
        this.wv_min.setViewAdapter(this.minAdapter);
        this.switchAdapter.add(IOUtil.getStringResource(R.string.switch_on));
        this.switchAdapter.add(IOUtil.getStringResource(R.string.switch_off));
        this.ampmAdapter.add(IOUtil.getStringResource(R.string.am));
        this.ampmAdapter.add(IOUtil.getStringResource(R.string.pm));
        int i = 0;
        while (i < 12) {
            i++;
            this.hourAdapter.add(IOUtil.convertNumberAddZero(i));
        }
        for (int i2 = 0; i2 < 60; i2++) {
            this.minAdapter.add(IOUtil.convertNumberAddZero(i2));
        }
    }

    @Override // kr.switcher.switcherm.ui.setting.view.ReservationView
    public void setTitle(String str) {
        this.et_reservation_title.setText(str);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.ReservationView
    public void setTimerInfo(Switcher.SwitcherReservation switcherReservation) {
        this.vp_switcher_type.setCurrentItem(Integer.parseInt(switcherReservation.switcherTarget));
        this.wv_ampm.setCurrentItem(!switcherReservation.ampm.equalsIgnoreCase(IODeviceConfig.AM) ? 1 : 0);
        this.wv_hour.setCurrentItem(switcherReservation.hour - 1);
        this.wv_min.setCurrentItem(switcherReservation.min);
        this.presenter.setSwitch(switcherReservation.light);
        this.presenter.setMon(switcherReservation.mon);
        this.presenter.setTue(switcherReservation.tue);
        this.presenter.setWed(switcherReservation.wed);
        this.presenter.setThu(switcherReservation.thu);
        this.presenter.setFri(switcherReservation.fri);
        this.presenter.setSat(switcherReservation.sat);
        this.presenter.setSun(switcherReservation.sun);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.ReservationView
    public void addReservation(Switcher.SwitcherReservation switcherReservation, IODeviceCallbacks.ReservationUpdateResultCallback reservationUpdateResultCallback) {
        ReservationPresenter reservationPresenter = this.presenter;
        reservationPresenter.showResult(this.connectedSwitcher.addReservation(switcherReservation, reservationPresenter.getReservationUpdateResultCallback(switcherReservation, reservationUpdateResultCallback)));
    }

    @Override // kr.switcher.switcherm.ui.setting.view.ReservationView
    public void updateReservation(Switcher.SwitcherReservation switcherReservation, IODeviceCallbacks.ReservationUpdateResultCallback reservationUpdateResultCallback) {
        ReservationPresenter reservationPresenter = this.presenter;
        reservationPresenter.showResult(this.connectedSwitcher.updateReservation(switcherReservation, reservationPresenter.getReservationUpdateResultCallback(switcherReservation, reservationUpdateResultCallback)));
    }

    @Override // kr.switcher.switcherm.ui.setting.view.ReservationView
    public void removeReservation(int i, IODeviceCallbacks.ReservationUpdateResultCallback reservationUpdateResultCallback) {
        this.connectedSwitcher.removeReservation(i, this.presenter.getReservationRemoveResultCallback(i, reservationUpdateResultCallback));
        this.presenter.showResult(1);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.ReservationView
    public void updateReservationToDB(Switcher.SwitcherReservation switcherReservation) {
        new SwitcherDBProvider().updateReservationToDB(this.connectedSwitcher.getMacAddress(), switcherReservation);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.ReservationView
    public void removeReservationToDB(int i) {
        new SwitcherDBProvider().deleteReservationToDB(this.connectedSwitcher.getMacAddress(), i);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.ReservationView
    public void showRemoveButton() {
        this.btn_remove.setVisibility(0);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.ReservationView
    public void hideRemoveButton() {
        this.btn_remove.setVisibility(8);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.ReservationView
    public void showViewPager() {
        this.rl_view_pager.setVisibility(0);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.ReservationView
    public void hideViewPager() {
        this.rl_view_pager.setVisibility(8);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.ReservationView
    public void showLeftArrowButton() {
        this.btn_left_arrow.setVisibility(0);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.ReservationView
    public void hideLeftArrowButton() {
        this.btn_left_arrow.setVisibility(8);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.ReservationView
    public void showRightArrowButton() {
        this.btn_right_arrow.setVisibility(0);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.ReservationView
    public void hideRightArrowButton() {
        this.btn_right_arrow.setVisibility(8);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.ReservationView
    public void selectTimerOn() {
        this.iv_timer_on.setSelected(true);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.ReservationView
    public void unSelectTimerOn() {
        this.iv_timer_on.setSelected(false);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.ReservationView
    public void selectTimerOff() {
        this.iv_timer_off.setSelected(true);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.ReservationView
    public void unSelectTimerOff() {
        this.iv_timer_off.setSelected(false);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.ReservationView
    public void setBackgroundTimerOffWhenIsOn() {
        this.lin_timer_off.setBackgroundColor(IOUtil.getColorResource(R.color.white));
    }

    @Override // kr.switcher.switcherm.ui.setting.view.ReservationView
    public void setBackgroundTimerOffWhenIsOff() {
        this.lin_timer_off.setBackgroundColor(IOUtil.getColorResource(R.color.periwinkle));
    }

    @Override // kr.switcher.switcherm.ui.setting.view.ReservationView
    public void setBackgroundTimerOnWhenIsOn() {
        this.lin_timer_on.setBackgroundColor(IOUtil.getColorResource(R.color.periwinkle));
    }

    @Override // kr.switcher.switcherm.ui.setting.view.ReservationView
    public void setBackgroundTimerOnWhenIsOff() {
        this.lin_timer_on.setBackgroundColor(IOUtil.getColorResource(R.color.white));
    }

    @Override // kr.switcher.switcherm.ui.setting.view.ReservationView
    public void setColorTimerOffTextWhenIsOn() {
        this.tv_timer_off.setTextColor(IOUtil.getColorResource(R.color.slate_grey));
    }

    @Override // kr.switcher.switcherm.ui.setting.view.ReservationView
    public void setColorTimerOffTextWhenIsOff() {
        this.tv_timer_off.setTextColor(IOUtil.getColorResource(R.color.white));
    }

    @Override // kr.switcher.switcherm.ui.setting.view.ReservationView
    public void setColorTimerOnTextWhenIsOn() {
        this.tv_timer_on.setTextColor(IOUtil.getColorResource(R.color.white));
    }

    @Override // kr.switcher.switcherm.ui.setting.view.ReservationView
    public void setColorTimerOnTextWhenIsOff() {
        this.tv_timer_on.setTextColor(IOUtil.getColorResource(R.color.slate_grey));
    }

    @Override // kr.switcher.switcherm.ui.setting.view.ReservationView
    public void setRepeater() {
        DayOfWeekRepeater dayOfWeekRepeater = new DayOfWeekRepeater();
        dayOfWeekRepeater.setDayOfWeek(this.tv_mon.isSelected(), this.tv_tue.isSelected(), this.tv_wed.isSelected(), this.tv_thu.isSelected(), this.tv_fri.isSelected(), this.tv_sat.isSelected(), this.tv_sun.isSelected());
        this.presenter.setRepeater(dayOfWeekRepeater);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.ReservationView
    public void selectDaily() {
        this.tv_daily.setTextColor(IOUtil.getColorResource(R.color.periwinkle));
    }

    @Override // kr.switcher.switcherm.ui.setting.view.ReservationView
    public void unSelectDaily() {
        this.tv_daily.setTextColor(IOUtil.getColorResource(R.color.slate_grey));
    }

    @Override // kr.switcher.switcherm.ui.setting.view.ReservationView
    public void selectWeekday() {
        this.tv_weekday.setTextColor(IOUtil.getColorResource(R.color.periwinkle));
    }

    @Override // kr.switcher.switcherm.ui.setting.view.ReservationView
    public void unSelectWeekday() {
        this.tv_weekday.setTextColor(IOUtil.getColorResource(R.color.slate_grey));
    }

    @Override // kr.switcher.switcherm.ui.setting.view.ReservationView
    public void selectWeekend() {
        this.tv_weekend.setTextColor(IOUtil.getColorResource(R.color.periwinkle));
    }

    @Override // kr.switcher.switcherm.ui.setting.view.ReservationView
    public void unSelectWeekend() {
        this.tv_weekend.setTextColor(IOUtil.getColorResource(R.color.slate_grey));
    }

    @Override // kr.switcher.switcherm.ui.setting.view.ReservationView
    public void selectMon() {
        this.tv_mon.setTextColor(IOUtil.getColorResource(R.color.periwinkle));
        this.tv_mon.setSelected(true);
        this.tv_mon.setTypeface(null, 1);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.ReservationView
    public void unSelectMon() {
        this.tv_mon.setTextColor(IOUtil.getColorResource(R.color.slate_grey));
        this.tv_mon.setSelected(false);
        this.tv_mon.setTypeface(null, 0);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.ReservationView
    public void selectTue() {
        this.tv_tue.setTextColor(IOUtil.getColorResource(R.color.periwinkle));
        this.tv_tue.setSelected(true);
        this.tv_tue.setTypeface(null, 1);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.ReservationView
    public void unSelectTue() {
        this.tv_tue.setTextColor(IOUtil.getColorResource(R.color.slate_grey));
        this.tv_tue.setSelected(false);
        this.tv_tue.setTypeface(null, 0);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.ReservationView
    public void selectWed() {
        this.tv_wed.setTextColor(IOUtil.getColorResource(R.color.periwinkle));
        this.tv_wed.setSelected(true);
        this.tv_wed.setTypeface(null, 1);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.ReservationView
    public void unSelectWed() {
        this.tv_wed.setTextColor(IOUtil.getColorResource(R.color.slate_grey));
        this.tv_wed.setSelected(false);
        this.tv_wed.setTypeface(null, 0);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.ReservationView
    public void selectThu() {
        this.tv_thu.setTextColor(IOUtil.getColorResource(R.color.periwinkle));
        this.tv_thu.setSelected(true);
        this.tv_thu.setTypeface(null, 1);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.ReservationView
    public void unSelectThu() {
        this.tv_thu.setTextColor(IOUtil.getColorResource(R.color.slate_grey));
        this.tv_thu.setSelected(false);
        this.tv_thu.setTypeface(null, 0);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.ReservationView
    public void selectFri() {
        this.tv_fri.setTextColor(IOUtil.getColorResource(R.color.periwinkle));
        this.tv_fri.setSelected(true);
        this.tv_fri.setTypeface(null, 1);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.ReservationView
    public void unSelectFri() {
        this.tv_fri.setTextColor(IOUtil.getColorResource(R.color.slate_grey));
        this.tv_fri.setSelected(false);
        this.tv_fri.setTypeface(null, 0);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.ReservationView
    public void selectSat() {
        this.tv_sat.setTextColor(IOUtil.getColorResource(R.color.periwinkle));
        this.tv_sat.setSelected(true);
        this.tv_sat.setTypeface(null, 1);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.ReservationView
    public void unSelectSat() {
        this.tv_sat.setTextColor(IOUtil.getColorResource(R.color.slate_grey));
        this.tv_sat.setSelected(false);
        this.tv_sat.setTypeface(null, 0);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.ReservationView
    public void selectSun() {
        this.tv_sun.setTextColor(IOUtil.getColorResource(R.color.periwinkle));
        this.tv_sun.setSelected(true);
        this.tv_sun.setTypeface(null, 1);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.ReservationView
    public void unSelectSun() {
        this.tv_sun.setTextColor(IOUtil.getColorResource(R.color.slate_grey));
        this.tv_sun.setSelected(false);
        this.tv_sun.setTypeface(null, 0);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.ReservationView
    public void showProgressbar() {
        this.pb_loading.setVisibility(0);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.ReservationView
    public void hideProgressbar() {
        this.pb_loading.setVisibility(8);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.ReservationView
    public void showErrorMessage(String str) {
        IOUtil.showToast(str);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.ReservationView
    public void finish() {
        getActivity().finish();
    }

    public void onSaveReservationButtonClicked(IODeviceCallbacks.ReservationUpdateResultCallback reservationUpdateResultCallback) {
        this.presenter.saveReservation(this.switcherTimer, this.pb_loading.getVisibility() == 0, new ReservationInfo(this.et_reservation_title.getText().toString(), this.tv_mon, this.tv_tue, this.tv_wed, this.tv_thu, this.tv_fri, this.tv_sat, this.tv_sun, this.wv_ampm, this.wv_hour, this.wv_min, this.iv_timer_on, this.iv_timer_off, this.vp_switcher_type), reservationUpdateResultCallback);
    }

    public void onRemoveReservationButtonClicked(IODeviceCallbacks.ReservationUpdateResultCallback reservationUpdateResultCallback) {
        this.presenter.removeReservation(this.switcherTimer, this.pb_loading.getVisibility() == 0, reservationUpdateResultCallback);
    }

    @OnClick({R.id.tv_mon})
    public void onMondayButtonClicked() {
        this.presenter.setMon(!this.tv_mon.isSelected());
    }

    @OnClick({R.id.tv_tue})
    public void onTuedayButtonClicked() {
        this.presenter.setTue(!this.tv_tue.isSelected());
    }

    @OnClick({R.id.tv_wed})
    public void onWeddayButtonClicked() {
        this.presenter.setWed(!this.tv_wed.isSelected());
    }

    @OnClick({R.id.tv_thu})
    public void onThudayButtonClicked() {
        this.presenter.setThu(!this.tv_thu.isSelected());
    }

    @OnClick({R.id.tv_fri})
    public void onFridayButtonClicked() {
        this.presenter.setFri(!this.tv_fri.isSelected());
    }

    @OnClick({R.id.tv_sat})
    public void onSatdayButtonClicked() {
        this.presenter.setSat(!this.tv_sat.isSelected());
    }

    @OnClick({R.id.tv_sun})
    public void onSundayButtonClicked() {
        this.presenter.setSun(!this.tv_sun.isSelected());
    }

    @OnClick({R.id.rl_daily})
    public void onDailyButtonClicked() {
        this.presenter.setDaily();
    }

    @OnClick({R.id.rl_weekday})
    public void onWeekdayButtonClicked() {
        this.presenter.setWeekday();
    }

    @OnClick({R.id.rl_weekend})
    public void onWeekendButtonClicked() {
        this.presenter.setWeekend();
    }

    @OnClick({R.id.lin_timer_off})
    public void onTimerSwitchOffButtonClicked() {
        this.presenter.setSwitch(false);
    }

    @OnClick({R.id.lin_timer_on})
    public void onTimerSwitchOnButtonClicked() {
        this.presenter.setSwitch(true);
    }
}
