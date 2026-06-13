package kr.switcher.switcherm.ui.setting.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import antistatic.spinnerwheel.AbstractWheel;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.rey.material.widget.Button;
import java.util.List;
import kr.switcher.device.remocon.IRCommand;
import kr.switcher.device.remocon.Remocon;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.device.IODeviceHandler;
import kr.switcher.switcherm.preference.OAuthToken;
import kr.switcher.switcherm.ui.setting.adapter.ReservationWheelAdapter;
import kr.switcher.switcherm.ui.setting.helper.DayOfWeekRepeater;
import kr.switcher.switcherm.ui.setting.helper.RemoconReservationInfo;
import kr.switcher.switcherm.ui.setting.helper.RemoconReservationJsonParser;
import kr.switcher.switcherm.ui.setting.interactor.DeleteReservationInteractor;
import kr.switcher.switcherm.ui.setting.interactor.FindAirconCommandListInteractor;
import kr.switcher.switcherm.ui.setting.interactor.SendReservationToServerInteractor;
import kr.switcher.switcherm.ui.setting.presenter.SettopReservationPresenter;
import kr.switcher.switcherm.ui.setting.view.SettopReservationView;

/* JADX INFO: loaded from: classes2.dex */
public class SettopReservationFragment extends Fragment implements SettopReservationView, FindAirconCommandListInteractor.OnFindAirconCommandListListener, SendReservationToServerInteractor.OnSendReservationToServerListener, DeleteReservationInteractor.OnDeleteReservationListener, DeleteReservationInteractor.OnChangeReservationDataListener {
    private static final String OFF_BUTTON = "off";
    private static final String ON_BUTTON = "on";
    private static final String PARM_SETTOP_REMOCON_RESERVATION = "SETTOP_REMOCON_RESERVATION";
    private static final String TAG = "SettopReservationFragment";

    @BindView(R.id.btn_reservation_remove)
    Button btn_reservation_remove;
    private Remocon connectedRemocon;

    @BindView(R.id.et_channel)
    EditText et_channel;

    @BindView(R.id.et_reservation_title)
    EditText et_reservation_title;
    private ReservationWheelAdapter hourAdapter;

    @BindView(R.id.lin_insert_channel)
    LinearLayout lin_insert_channel;

    @BindView(R.id.lin_timer_off)
    LinearLayout lin_timer_off;

    @BindView(R.id.lin_timer_on)
    LinearLayout lin_timer_on;
    private ReservationWheelAdapter minAdapter;

    @BindView(R.id.pb_loading)
    ProgressBar pb_loading;
    private SettopReservationPresenter presenter;
    private Remocon.RemoconReservation rResrv;

    @BindView(R.id.rl_remove)
    RelativeLayout rl_remove;

    @BindView(R.id.tv_channel_unit)
    TextView tv_channel_unit;

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

    @BindView(R.id.wv_hour)
    AbstractWheel wv_hour;

    @BindView(R.id.wv_min)
    AbstractWheel wv_min;
    public static Boolean IS_ON_COMMAND = true;
    public static String CLICKED_BUTTON = "clickedButton";
    private String tag = " ";
    String clickedButton = " ";

    @Override // kr.switcher.switcherm.ui.setting.interactor.DeleteReservationInteractor.OnChangeReservationDataListener
    public void onChangeReservationDataFailure(String str) {
    }

    @Override // kr.switcher.switcherm.ui.setting.interactor.DeleteReservationInteractor.OnDeleteReservationListener
    public void onDeleteReservationError(String str) {
    }

    @Override // kr.switcher.switcherm.ui.setting.interactor.FindAirconCommandListInteractor.OnFindAirconCommandListListener
    public void onError(String str) {
    }

    public static SettopReservationFragment newInstance(String str, Remocon.RemoconReservation remoconReservation) {
        SettopReservationFragment settopReservationFragment = new SettopReservationFragment();
        Bundle bundle = new Bundle();
        bundle.putString("CONNECTED_MAC_ADDRESS", str);
        bundle.putString(PARM_SETTOP_REMOCON_RESERVATION, RemoconReservationJsonParser.makeRemoconReservationJson(remoconReservation));
        settopReservationFragment.setArguments(bundle);
        return settopReservationFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String string;
        View viewInflate = layoutInflater.inflate(R.layout.fragment_settop_reservation, viewGroup, false);
        ButterKnife.bind(this, viewInflate);
        this.rResrv = null;
        Bundle arguments = getArguments();
        if (arguments != null) {
            string = arguments.getString("CONNECTED_MAC_ADDRESS");
            try {
                this.rResrv = RemoconReservationJsonParser.parseRemoconReservation(arguments.getString(PARM_SETTOP_REMOCON_RESERVATION));
            } catch (Exception e) {
                IOLog.error(TAG, new OAuthToken().getOAuthToken(), "onCreateView", e);
            }
        } else {
            string = null;
        }
        if (string == null) {
            return null;
        }
        Remocon remocon = (Remocon) IODeviceHandler.getInstance().getDevice(string);
        this.connectedRemocon = remocon;
        if (remocon == null) {
            return null;
        }
        SettopReservationPresenter settopReservationPresenter = new SettopReservationPresenter(this, new FindAirconCommandListInteractor(this), new SendReservationToServerInteractor(this), new DeleteReservationInteractor(this, this));
        this.presenter = settopReservationPresenter;
        settopReservationPresenter.initialize(this.connectedRemocon, this.rResrv);
        return viewInflate;
    }

    public void onSaveReservationButtonClicked() {
        String string = this.et_reservation_title.getText().toString();
        if (string.equals("") || string.length() < 1) {
            string = "제목 없음";
        }
        String str = string;
        if (IS_ON_COMMAND.booleanValue()) {
            String string2 = this.et_channel.getText().toString();
            this.tag = string2;
            if (string2.length() < 1) {
                this.tag = "none";
            }
        } else {
            this.tag = "off";
        }
        this.presenter.onSaveRervationButtonClicked(this.rResrv, new RemoconReservationInfo(str, this.tv_mon, this.tv_tue, this.tv_wed, this.tv_thu, this.tv_fri, this.tv_sat, this.tv_sun, this.wv_hour, this.wv_min, this.tag));
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        IOUtil.hideKeyBoard(this.et_reservation_title);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.SettopReservationView
    public void initWheel() {
        this.hourAdapter = new ReservationWheelAdapter(getContext());
        this.minAdapter = new ReservationWheelAdapter(getContext());
        this.wv_hour.setViewAdapter(this.hourAdapter);
        this.wv_min.setViewAdapter(this.minAdapter);
        for (int i = 0; i < 24; i++) {
            this.hourAdapter.add(IOUtil.convertNumberAddZero(i));
        }
        for (int i2 = 0; i2 < 60; i2++) {
            this.minAdapter.add(IOUtil.convertNumberAddZero(i2));
        }
    }

    @Override // kr.switcher.switcherm.ui.setting.view.SettopReservationView
    public void hideProgressbar() {
        this.pb_loading.setVisibility(8);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.SettopReservationView
    public void showProgressbar() {
        this.pb_loading.setVisibility(0);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.SettopReservationView
    public void selectDaily() {
        this.tv_daily.setTextColor(IOUtil.getColorResource(R.color.periwinkle));
    }

    @Override // kr.switcher.switcherm.ui.setting.view.SettopReservationView
    public void unSelectDaily() {
        this.tv_daily.setTextColor(IOUtil.getColorResource(R.color.slate_grey));
    }

    @Override // kr.switcher.switcherm.ui.setting.view.SettopReservationView
    public void selectWeekday() {
        this.tv_weekday.setTextColor(IOUtil.getColorResource(R.color.periwinkle));
    }

    @Override // kr.switcher.switcherm.ui.setting.view.SettopReservationView
    public void unSelectWeekday() {
        this.tv_weekday.setTextColor(IOUtil.getColorResource(R.color.slate_grey));
    }

    @Override // kr.switcher.switcherm.ui.setting.view.SettopReservationView
    public void selectWeekend() {
        this.tv_weekend.setTextColor(IOUtil.getColorResource(R.color.periwinkle));
    }

    @Override // kr.switcher.switcherm.ui.setting.view.SettopReservationView
    public void unSelectWeekend() {
        this.tv_weekend.setTextColor(IOUtil.getColorResource(R.color.slate_grey));
    }

    @Override // kr.switcher.switcherm.ui.setting.view.SettopReservationView
    public void selectMon() {
        this.tv_mon.setTextColor(IOUtil.getColorResource(R.color.periwinkle));
        this.tv_mon.setSelected(true);
        this.tv_mon.setTypeface(null, 1);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.SettopReservationView
    public void unSelectMon() {
        this.tv_mon.setTextColor(IOUtil.getColorResource(R.color.slate_grey));
        this.tv_mon.setSelected(false);
        this.tv_mon.setTypeface(null, 0);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.SettopReservationView
    public void selectTue() {
        this.tv_tue.setTextColor(IOUtil.getColorResource(R.color.periwinkle));
        this.tv_tue.setSelected(true);
        this.tv_tue.setTypeface(null, 1);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.SettopReservationView
    public void unSelectTue() {
        this.tv_tue.setTextColor(IOUtil.getColorResource(R.color.slate_grey));
        this.tv_tue.setSelected(false);
        this.tv_tue.setTypeface(null, 0);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.SettopReservationView
    public void selectWed() {
        this.tv_wed.setTextColor(IOUtil.getColorResource(R.color.periwinkle));
        this.tv_wed.setSelected(true);
        this.tv_wed.setTypeface(null, 1);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.SettopReservationView
    public void unSelectWed() {
        this.tv_wed.setTextColor(IOUtil.getColorResource(R.color.slate_grey));
        this.tv_wed.setSelected(false);
        this.tv_wed.setTypeface(null, 0);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.SettopReservationView
    public void selectThu() {
        this.tv_thu.setTextColor(IOUtil.getColorResource(R.color.periwinkle));
        this.tv_thu.setSelected(true);
        this.tv_thu.setTypeface(null, 1);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.SettopReservationView
    public void unSelectThu() {
        this.tv_thu.setTextColor(IOUtil.getColorResource(R.color.slate_grey));
        this.tv_thu.setSelected(false);
        this.tv_thu.setTypeface(null, 0);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.SettopReservationView
    public void selectFri() {
        this.tv_fri.setTextColor(IOUtil.getColorResource(R.color.periwinkle));
        this.tv_fri.setSelected(true);
        this.tv_fri.setTypeface(null, 1);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.SettopReservationView
    public void unSelectFri() {
        this.tv_fri.setTextColor(IOUtil.getColorResource(R.color.slate_grey));
        this.tv_fri.setSelected(false);
        this.tv_fri.setTypeface(null, 0);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.SettopReservationView
    public void selectSat() {
        this.tv_sat.setTextColor(IOUtil.getColorResource(R.color.periwinkle));
        this.tv_sat.setSelected(true);
        this.tv_sat.setTypeface(null, 1);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.SettopReservationView
    public void unSelectSat() {
        this.tv_sat.setTextColor(IOUtil.getColorResource(R.color.slate_grey));
        this.tv_sat.setSelected(false);
        this.tv_sat.setTypeface(null, 0);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.SettopReservationView
    public void selectSun() {
        this.tv_sun.setTextColor(IOUtil.getColorResource(R.color.periwinkle));
        this.tv_sun.setSelected(true);
        this.tv_sun.setTypeface(null, 1);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.SettopReservationView
    public void unSelectSun() {
        this.tv_sun.setTextColor(IOUtil.getColorResource(R.color.slate_grey));
        this.tv_sun.setSelected(false);
        this.tv_sun.setTypeface(null, 0);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.SettopReservationView
    public void setRepeater() {
        DayOfWeekRepeater dayOfWeekRepeater = new DayOfWeekRepeater();
        dayOfWeekRepeater.setDayOfWeek(this.tv_mon.isSelected(), this.tv_tue.isSelected(), this.tv_wed.isSelected(), this.tv_thu.isSelected(), this.tv_fri.isSelected(), this.tv_sat.isSelected(), this.tv_sun.isSelected());
        this.presenter.setRepeater(dayOfWeekRepeater);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.SettopReservationView
    public void setColorTimerOnTextWhenIsOn() {
        this.tv_timer_on.setTextColor(IOUtil.getColorResource(R.color.white));
    }

    @Override // kr.switcher.switcherm.ui.setting.view.SettopReservationView
    public void setColorTimerOnTextWhenIsOff() {
        this.tv_timer_on.setTextColor(IOUtil.getColorResource(R.color.slate_grey));
    }

    @Override // kr.switcher.switcherm.ui.setting.view.SettopReservationView
    public void setColorTimerOffTextWhenIsOn() {
        this.tv_timer_off.setTextColor(IOUtil.getColorResource(R.color.slate_grey));
    }

    @Override // kr.switcher.switcherm.ui.setting.view.SettopReservationView
    public void setColorTimerOffTextWhenIsOff() {
        this.tv_timer_off.setTextColor(IOUtil.getColorResource(R.color.white));
    }

    @Override // kr.switcher.switcherm.ui.setting.view.SettopReservationView
    public void setBackgroundTimerOffWhenIsOn() {
        this.lin_timer_off.setBackgroundColor(IOUtil.getColorResource(R.color.white));
    }

    @Override // kr.switcher.switcherm.ui.setting.view.SettopReservationView
    public void setBackgroundTimerOffWhenIsOff() {
        this.lin_timer_off.setBackgroundColor(IOUtil.getColorResource(R.color.periwinkle));
    }

    @Override // kr.switcher.switcherm.ui.setting.view.SettopReservationView
    public void setBackgroundTimerOnWhenIsOn() {
        this.lin_timer_on.setBackgroundColor(IOUtil.getColorResource(R.color.periwinkle));
    }

    @Override // kr.switcher.switcherm.ui.setting.view.SettopReservationView
    public void setBackgroundTimerOnWhenIsOff() {
        this.lin_timer_on.setBackgroundColor(IOUtil.getColorResource(R.color.white));
    }

    @Override // kr.switcher.switcherm.ui.setting.view.SettopReservationView
    public void setTitle(String str) {
        this.et_reservation_title.setText(str);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.SettopReservationView
    public void setTimerInfo(Remocon.RemoconReservation remoconReservation) {
        this.wv_hour.setCurrentItem(remoconReservation.hour);
        this.wv_min.setCurrentItem(remoconReservation.min);
        this.presenter.setSwitch(remoconReservation.tag);
        this.presenter.setMon(remoconReservation.mon);
        this.presenter.setTue(remoconReservation.tue);
        this.presenter.setWed(remoconReservation.wed);
        this.presenter.setThu(remoconReservation.thu);
        this.presenter.setFri(remoconReservation.fri);
        this.presenter.setSat(remoconReservation.sat);
        this.presenter.setSun(remoconReservation.sun);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.SettopReservationView
    public void showRemoveButton() {
        this.rl_remove.setVisibility(0);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.SettopReservationView
    public void hideRemoveButton() {
        this.rl_remove.setVisibility(8);
    }

    @Override // kr.switcher.switcherm.ui.setting.interactor.FindAirconCommandListInteractor.OnFindAirconCommandListListener
    public void onFindRemoconReservation(List<IRCommand> list) {
        this.presenter.onFindRemoconReservation(list);
    }

    @Override // kr.switcher.switcherm.ui.setting.interactor.SendReservationToServerInteractor.OnSendReservationToServerListener
    public void onSendReservationSuccess() {
        IOUtil.showToast("예약 등록 완료");
        hideProgressbar();
        backButtonClicked();
    }

    @Override // kr.switcher.switcherm.ui.setting.interactor.SendReservationToServerInteractor.OnSendReservationToServerListener
    public void onSendReservationError(String str) {
        hideProgressbar();
        if (str.equals("35")) {
            IOUtil.showToast("중복되는 예약설정이 존재합니다. 시간을 수정해주세요 :)");
        }
    }

    @Override // kr.switcher.switcherm.ui.setting.view.SettopReservationView
    public void setRemoconReservationData(Remocon.RemoconReservation remoconReservation) {
        this.presenter.setRemoconReservationData(remoconReservation);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.SettopReservationView
    public void backButtonClicked() {
        getActivity().onBackPressed();
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
        IS_ON_COMMAND = false;
        this.presenter.setSwitch("off");
        CLICKED_BUTTON = "off";
        this.tag = "off";
    }

    @OnClick({R.id.lin_timer_on})
    public void onTimerSwitchOnButtonClicked() {
        IS_ON_COMMAND = true;
        this.presenter.setSwitch("on");
        CLICKED_BUTTON = "on";
    }

    @OnClick({R.id.btn_reservation_remove})
    public void onRemoveButtonClicked() {
        showTestDialog();
    }

    @Override // kr.switcher.switcherm.ui.setting.interactor.DeleteReservationInteractor.OnDeleteReservationListener
    public void onDeleteReservationSuccess() {
        this.presenter.onDeleteReservationSuccess();
    }

    @Override // kr.switcher.switcherm.ui.setting.view.SettopReservationView
    public void showTestDialog() {
        new MaterialDialog.Builder(getContext()).content("예약 삭제를 하시겠습니까?").positiveText("예").negativeText("아니오").negativeColor(R.color.periwinkle).positiveColor(R.color.periwinkle).onPositive(new MaterialDialog.SingleButtonCallback() { // from class: kr.switcher.switcherm.ui.setting.fragment.SettopReservationFragment.2
            @Override // com.afollestad.materialdialogs.MaterialDialog.SingleButtonCallback
            public void onClick(MaterialDialog materialDialog, DialogAction dialogAction) {
                SettopReservationFragment.this.presenter.onRemoveButtonClicked(SettopReservationFragment.this.rResrv.weekTime);
            }
        }).onNegative(new MaterialDialog.SingleButtonCallback() { // from class: kr.switcher.switcherm.ui.setting.fragment.SettopReservationFragment.1
            @Override // com.afollestad.materialdialogs.MaterialDialog.SingleButtonCallback
            public void onClick(MaterialDialog materialDialog, DialogAction dialogAction) {
            }
        }).cancelable(false).show();
    }

    @Override // kr.switcher.switcherm.ui.setting.view.SettopReservationView
    public void setCannelNumber(String str) {
        this.et_channel.setText(str);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.SettopReservationView
    public void setInactiveChannelField() {
        this.lin_insert_channel.setAlpha(0.2f);
        this.et_channel.setFocusable(false);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.SettopReservationView
    public void setActiveChannelField() {
        this.lin_insert_channel.setAlpha(1.0f);
        this.et_channel.setFocusableInTouchMode(true);
    }

    @Override // kr.switcher.switcherm.ui.setting.interactor.DeleteReservationInteractor.OnChangeReservationDataListener
    public void onChangeReservationDataSuccess(Remocon.RemoconReservation remoconReservation, String str) {
        this.presenter.onChangeReservationDataSuccess(remoconReservation, this.connectedRemocon.getId(), str);
    }
}
