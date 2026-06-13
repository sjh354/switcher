package kr.switcher.switcherm.ui.setting.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
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
import kr.switcher.device.remocon.Remocon;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.device.IODeviceHandler;
import kr.switcher.switcherm.preference.OAuthToken;
import kr.switcher.switcherm.ui.setting.adapter.ReservationWheelAdapter;
import kr.switcher.switcherm.ui.setting.helper.DayOfWeekRepeater;
import kr.switcher.switcherm.ui.setting.helper.RemoconMaintenanceInfo;
import kr.switcher.switcherm.ui.setting.helper.RemoconMaintenanceJsonParser;
import kr.switcher.switcherm.ui.setting.interactor.DeleteMaintenanceInteractor;
import kr.switcher.switcherm.ui.setting.interactor.MakeMaintenanceInteractor;
import kr.switcher.switcherm.ui.setting.interactor.ModifyAirconMaintenanceInteractor;
import kr.switcher.switcherm.ui.setting.presenter.AirconMaintainingTemperaturePresenter;
import kr.switcher.switcherm.ui.setting.view.AirconMaintainingTemperatureView;

/* JADX INFO: loaded from: classes2.dex */
public class AirconMaintainingTemperatureFragment extends Fragment implements AirconMaintainingTemperatureView, MakeMaintenanceInteractor.OnMakeMaintenanceListener, ModifyAirconMaintenanceInteractor.OnModifyAirconMaintenanceListener, DeleteMaintenanceInteractor.OnDeleteReservationListener {
    private static final String PARM_AIRCON_MAINTENANCE = "AIRCON_MAINTENANCE";
    private static final String TAG = "AirconMaintainingTemperatureFragment";
    private String TEMPERATURE_DEFAULT = "22";

    @BindView(R.id.btn_maintenance_remove)
    Button btn_maintenance_remove;

    @BindView(R.id.btn_temperature_down)
    ImageButton btn_temperature_down;

    @BindView(R.id.btn_temperature_up)
    ImageButton btn_temperature_up;
    private Remocon connectedRemocon;
    private ReservationWheelAdapter endHourAdapter;
    private ReservationWheelAdapter endMinAdapter;

    @BindView(R.id.et_title)
    EditText et_title;

    @BindView(R.id.pb_loading)
    ProgressBar pb_loading;
    private AirconMaintainingTemperaturePresenter presenter;
    private Remocon.RemoconMaintenanceTemperature rMaintenance;

    @BindView(R.id.rl_remove)
    RelativeLayout rl_remove;
    private ReservationWheelAdapter startHourAdapter;
    private ReservationWheelAdapter startMinAdapter;

    @BindView(R.id.tv_daily)
    TextView tv_daily;

    @BindView(R.id.tv_fri)
    TextView tv_fri;

    @BindView(R.id.tv_mon)
    TextView tv_mon;

    @BindView(R.id.tv_reservation_temperature)
    TextView tv_reservation_temperature;

    @BindView(R.id.tv_sat)
    TextView tv_sat;

    @BindView(R.id.tv_sun)
    TextView tv_sun;

    @BindView(R.id.tv_thu)
    TextView tv_thu;

    @BindView(R.id.tv_tue)
    TextView tv_tue;

    @BindView(R.id.tv_wed)
    TextView tv_wed;

    @BindView(R.id.tv_weekday)
    TextView tv_weekday;

    @BindView(R.id.tv_weekend)
    TextView tv_weekend;

    @BindView(R.id.wv_end_hour)
    AbstractWheel wv_end_hour;

    @BindView(R.id.wv_end_min)
    AbstractWheel wv_end_min;

    @BindView(R.id.wv_start_hour)
    AbstractWheel wv_start_hour;

    @BindView(R.id.wv_start_min)
    AbstractWheel wv_start_min;

    @Override // kr.switcher.switcherm.ui.setting.interactor.DeleteMaintenanceInteractor.OnDeleteReservationListener
    public void onDeleteMaintenanceError(String str) {
    }

    @Override // kr.switcher.switcherm.ui.setting.interactor.DeleteMaintenanceInteractor.OnDeleteReservationListener
    public void onDeleteMaintenanceSuccess(int i) {
    }

    public static AirconMaintainingTemperatureFragment newInstance(String str, Remocon.RemoconMaintenanceTemperature remoconMaintenanceTemperature) {
        AirconMaintainingTemperatureFragment airconMaintainingTemperatureFragment = new AirconMaintainingTemperatureFragment();
        Bundle bundle = new Bundle();
        bundle.putString("CONNECTED_MAC_ADDRESS", str);
        bundle.putString(PARM_AIRCON_MAINTENANCE, RemoconMaintenanceJsonParser.makeRemoconMaintenanceJson(remoconMaintenanceTemperature));
        airconMaintainingTemperatureFragment.setArguments(bundle);
        return airconMaintainingTemperatureFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String string;
        View viewInflate = layoutInflater.inflate(R.layout.fragment_maintaining_temperature, viewGroup, false);
        ButterKnife.bind(this, viewInflate);
        this.rMaintenance = null;
        Bundle arguments = getArguments();
        if (arguments != null) {
            string = arguments.getString("CONNECTED_MAC_ADDRESS");
            try {
                this.rMaintenance = RemoconMaintenanceJsonParser.parseRemoconMaintenance(arguments.getString(PARM_AIRCON_MAINTENANCE));
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
        AirconMaintainingTemperaturePresenter airconMaintainingTemperaturePresenter = new AirconMaintainingTemperaturePresenter(this, new MakeMaintenanceInteractor(this), new ModifyAirconMaintenanceInteractor(this), new DeleteMaintenanceInteractor(this));
        this.presenter = airconMaintainingTemperaturePresenter;
        airconMaintainingTemperaturePresenter.onCreateView(this.rMaintenance);
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        IOUtil.hideKeyBoard(this.et_title);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.AirconMaintainingTemperatureView
    public void initWheel() {
        this.startHourAdapter = new ReservationWheelAdapter(getContext());
        this.startMinAdapter = new ReservationWheelAdapter(getContext());
        this.endHourAdapter = new ReservationWheelAdapter(getContext());
        this.endMinAdapter = new ReservationWheelAdapter(getContext());
        this.wv_start_hour.setViewAdapter(this.startHourAdapter);
        this.wv_start_min.setViewAdapter(this.startMinAdapter);
        this.wv_end_hour.setViewAdapter(this.endHourAdapter);
        this.wv_end_min.setViewAdapter(this.endMinAdapter);
        for (int i = 0; i < 24; i++) {
            this.startHourAdapter.add(IOUtil.convertNumberAddZero(i));
        }
        for (int i2 = 0; i2 < 60; i2++) {
            this.startMinAdapter.add(IOUtil.convertNumberAddZero(i2));
        }
        for (int i3 = 0; i3 < 24; i3++) {
            this.endHourAdapter.add(IOUtil.convertNumberAddZero(i3));
        }
        for (int i4 = 0; i4 < 60; i4++) {
            this.endMinAdapter.add(IOUtil.convertNumberAddZero(i4));
        }
    }

    @Override // kr.switcher.switcherm.ui.setting.view.AirconMaintainingTemperatureView
    public void hideProgressbar() {
        this.pb_loading.setVisibility(8);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.AirconMaintainingTemperatureView
    public void showProgressbar() {
        this.pb_loading.setVisibility(0);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.AirconMaintainingTemperatureView
    public void selectDaily() {
        this.tv_daily.setTextColor(IOUtil.getColorResource(R.color.periwinkle));
    }

    @Override // kr.switcher.switcherm.ui.setting.view.AirconMaintainingTemperatureView
    public void unSelectDaily() {
        this.tv_daily.setTextColor(IOUtil.getColorResource(R.color.slate_grey));
    }

    @Override // kr.switcher.switcherm.ui.setting.view.AirconMaintainingTemperatureView
    public void selectWeekday() {
        this.tv_weekday.setTextColor(IOUtil.getColorResource(R.color.periwinkle));
    }

    @Override // kr.switcher.switcherm.ui.setting.view.AirconMaintainingTemperatureView
    public void unSelectWeekday() {
        this.tv_weekday.setTextColor(IOUtil.getColorResource(R.color.slate_grey));
    }

    @Override // kr.switcher.switcherm.ui.setting.view.AirconMaintainingTemperatureView
    public void selectWeekend() {
        this.tv_weekend.setTextColor(IOUtil.getColorResource(R.color.periwinkle));
    }

    @Override // kr.switcher.switcherm.ui.setting.view.AirconMaintainingTemperatureView
    public void unSelectWeekend() {
        this.tv_weekend.setTextColor(IOUtil.getColorResource(R.color.slate_grey));
    }

    @Override // kr.switcher.switcherm.ui.setting.view.AirconMaintainingTemperatureView
    public void selectMon() {
        this.tv_mon.setTextColor(IOUtil.getColorResource(R.color.periwinkle));
        this.tv_mon.setSelected(true);
        this.tv_mon.setTypeface(null, 1);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.AirconMaintainingTemperatureView
    public void unSelectMon() {
        this.tv_mon.setTextColor(IOUtil.getColorResource(R.color.slate_grey));
        this.tv_mon.setSelected(false);
        this.tv_mon.setTypeface(null, 0);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.AirconMaintainingTemperatureView
    public void selectTue() {
        this.tv_tue.setTextColor(IOUtil.getColorResource(R.color.periwinkle));
        this.tv_tue.setSelected(true);
        this.tv_tue.setTypeface(null, 1);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.AirconMaintainingTemperatureView
    public void unSelectTue() {
        this.tv_tue.setTextColor(IOUtil.getColorResource(R.color.slate_grey));
        this.tv_tue.setSelected(false);
        this.tv_tue.setTypeface(null, 0);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.AirconMaintainingTemperatureView
    public void selectWed() {
        this.tv_wed.setTextColor(IOUtil.getColorResource(R.color.periwinkle));
        this.tv_wed.setSelected(true);
        this.tv_wed.setTypeface(null, 1);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.AirconMaintainingTemperatureView
    public void unSelectWed() {
        this.tv_wed.setTextColor(IOUtil.getColorResource(R.color.slate_grey));
        this.tv_wed.setSelected(false);
        this.tv_wed.setTypeface(null, 0);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.AirconMaintainingTemperatureView
    public void selectThu() {
        this.tv_thu.setTextColor(IOUtil.getColorResource(R.color.periwinkle));
        this.tv_thu.setSelected(true);
        this.tv_thu.setTypeface(null, 1);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.AirconMaintainingTemperatureView
    public void unSelectThu() {
        this.tv_thu.setTextColor(IOUtil.getColorResource(R.color.slate_grey));
        this.tv_thu.setSelected(false);
        this.tv_thu.setTypeface(null, 0);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.AirconMaintainingTemperatureView
    public void selectFri() {
        this.tv_fri.setTextColor(IOUtil.getColorResource(R.color.periwinkle));
        this.tv_fri.setSelected(true);
        this.tv_fri.setTypeface(null, 1);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.AirconMaintainingTemperatureView
    public void unSelectFri() {
        this.tv_fri.setTextColor(IOUtil.getColorResource(R.color.slate_grey));
        this.tv_fri.setSelected(false);
        this.tv_fri.setTypeface(null, 0);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.AirconMaintainingTemperatureView
    public void selectSat() {
        this.tv_sat.setTextColor(IOUtil.getColorResource(R.color.periwinkle));
        this.tv_sat.setSelected(true);
        this.tv_sat.setTypeface(null, 1);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.AirconMaintainingTemperatureView
    public void unSelectSat() {
        this.tv_sat.setTextColor(IOUtil.getColorResource(R.color.slate_grey));
        this.tv_sat.setSelected(false);
        this.tv_sat.setTypeface(null, 0);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.AirconMaintainingTemperatureView
    public void selectSun() {
        this.tv_sun.setTextColor(IOUtil.getColorResource(R.color.periwinkle));
        this.tv_sun.setSelected(true);
        this.tv_sun.setTypeface(null, 1);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.AirconMaintainingTemperatureView
    public void unSelectSun() {
        this.tv_sun.setTextColor(IOUtil.getColorResource(R.color.slate_grey));
        this.tv_sun.setSelected(false);
        this.tv_sun.setTypeface(null, 0);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.AirconMaintainingTemperatureView
    public void setRepeater() {
        DayOfWeekRepeater dayOfWeekRepeater = new DayOfWeekRepeater();
        dayOfWeekRepeater.setDayOfWeek(this.tv_mon.isSelected(), this.tv_tue.isSelected(), this.tv_wed.isSelected(), this.tv_thu.isSelected(), this.tv_fri.isSelected(), this.tv_sat.isSelected(), this.tv_sun.isSelected());
        this.presenter.setRepeater(dayOfWeekRepeater);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.AirconMaintainingTemperatureView
    public void setTitle(String str) {
        this.et_title.setText(str);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.AirconMaintainingTemperatureView
    public void setMaintenanceInfo(Remocon.RemoconMaintenanceTemperature remoconMaintenanceTemperature) {
        this.wv_start_hour.setCurrentItem(remoconMaintenanceTemperature.startHour);
        this.wv_end_hour.setCurrentItem(remoconMaintenanceTemperature.endHour);
        this.wv_start_min.setCurrentItem(remoconMaintenanceTemperature.startMin);
        this.wv_end_min.setCurrentItem(remoconMaintenanceTemperature.endMin);
        this.tv_reservation_temperature.setText(String.valueOf(remoconMaintenanceTemperature.goal_temperature));
        this.presenter.setMon(remoconMaintenanceTemperature.mon);
        this.presenter.setTue(remoconMaintenanceTemperature.tue);
        this.presenter.setWed(remoconMaintenanceTemperature.wed);
        this.presenter.setThu(remoconMaintenanceTemperature.thu);
        this.presenter.setFri(remoconMaintenanceTemperature.fri);
        this.presenter.setSat(remoconMaintenanceTemperature.sat);
        this.presenter.setSun(remoconMaintenanceTemperature.sun);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.AirconMaintainingTemperatureView
    public void showRemoveButton() {
        this.rl_remove.setVisibility(0);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.AirconMaintainingTemperatureView
    public void hideRemoveButton() {
        this.rl_remove.setVisibility(8);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.AirconMaintainingTemperatureView
    public void setTemperature(int i) {
        this.tv_reservation_temperature.setText(String.valueOf(i));
    }

    @Override // kr.switcher.switcherm.ui.setting.view.AirconMaintainingTemperatureView
    public void setRemoconMaintenanceData(Remocon.RemoconMaintenanceTemperature remoconMaintenanceTemperature) {
        this.presenter.setRemoconMaintenanceData(remoconMaintenanceTemperature);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.AirconMaintainingTemperatureView
    public void showSameTimeSettingError() {
        IOUtil.showToast(R.string.same_time_setting_error);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.AirconMaintainingTemperatureView
    public void showLogicalOrderError() {
        IOUtil.showToast(R.string.logical_order_error);
        hideProgressbar();
    }

    @Override // kr.switcher.switcherm.ui.setting.view.AirconMaintainingTemperatureView
    public void backButtonClicked() {
        if (getActivity() == null) {
            return;
        }
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

    @OnClick({R.id.btn_temperature_up})
    public void onTemperatureUpButtonClicked() {
        TextView textView = this.tv_reservation_temperature;
        textView.setText(this.presenter.onTemperatureUpButtonClicked(String.valueOf(textView.getText())));
    }

    @OnClick({R.id.btn_temperature_down})
    public void onTemperatureDownButtonClicked() {
        TextView textView = this.tv_reservation_temperature;
        textView.setText(this.presenter.onTemperatureDownButtonClicked(String.valueOf(textView.getText())));
    }

    @OnClick({R.id.btn_maintenance_remove})
    public void onRemoveButtonClicked() {
        showTestDialog();
    }

    @Override // kr.switcher.switcherm.ui.setting.view.AirconMaintainingTemperatureView
    public void showTestDialog() {
        new MaterialDialog.Builder(getContext()).content("설정을 삭제 하시겠습니까?").positiveText("예").negativeText("아니오").negativeColor(R.color.periwinkle).positiveColor(R.color.periwinkle).onPositive(new MaterialDialog.SingleButtonCallback() { // from class: kr.switcher.switcherm.ui.setting.fragment.AirconMaintainingTemperatureFragment.2
            @Override // com.afollestad.materialdialogs.MaterialDialog.SingleButtonCallback
            public void onClick(MaterialDialog materialDialog, DialogAction dialogAction) {
                AirconMaintainingTemperatureFragment.this.presenter.onRemoveButtonClicked(AirconMaintainingTemperatureFragment.this.rMaintenance.id);
            }
        }).onNegative(new MaterialDialog.SingleButtonCallback() { // from class: kr.switcher.switcherm.ui.setting.fragment.AirconMaintainingTemperatureFragment.1
            @Override // com.afollestad.materialdialogs.MaterialDialog.SingleButtonCallback
            public void onClick(MaterialDialog materialDialog, DialogAction dialogAction) {
            }
        }).cancelable(false).show();
    }

    @Override // kr.switcher.switcherm.ui.setting.view.AirconMaintainingTemperatureView
    public void showDefaultTemperature() {
        this.tv_reservation_temperature.setText(this.TEMPERATURE_DEFAULT);
    }

    public void onSaveReservationButtonClicked() {
        String string = this.et_title.getText().toString();
        if (string.equals("") || string.length() < 1) {
            string = "제목 없음";
        }
        this.presenter.onSaveRervationButtonClicked(this.connectedRemocon.getId(), this.rMaintenance, new RemoconMaintenanceInfo(string, this.tv_mon, this.tv_tue, this.tv_wed, this.tv_thu, this.tv_fri, this.tv_sat, this.tv_sun, this.tv_reservation_temperature, this.wv_start_hour, this.wv_end_hour, this.wv_start_min, this.wv_end_min));
    }

    @Override // kr.switcher.switcherm.ui.setting.interactor.MakeMaintenanceInteractor.OnMakeMaintenanceListener
    public void onMakeMaintenanceSuccess() {
        IOUtil.showToast("예약 등록 완료");
        hideProgressbar();
        backButtonClicked();
    }

    @Override // kr.switcher.switcherm.ui.setting.interactor.MakeMaintenanceInteractor.OnMakeMaintenanceListener
    public void onMakeMaintenanceError(String str, String str2) {
        hideProgressbar();
        if (str.equals("35")) {
            if (str2.indexOf("maintenance id") != -1) {
                IOUtil.showToast(R.string.maintenance_invaded_error);
            } else {
                IOUtil.showToast(R.string.maintenance_invaded_error);
            }
        }
    }

    @Override // kr.switcher.switcherm.ui.setting.interactor.ModifyAirconMaintenanceInteractor.OnModifyAirconMaintenanceListener
    public void onModifySuccess() {
        IOUtil.showToast("온도 유지 정보 수정 완료");
        backButtonClicked();
    }

    @Override // kr.switcher.switcherm.ui.setting.interactor.ModifyAirconMaintenanceInteractor.OnModifyAirconMaintenanceListener
    public void onModifyError(String str) {
        hideProgressbar();
    }

    @Override // kr.switcher.switcherm.ui.setting.interactor.DeleteMaintenanceInteractor.OnDeleteReservationListener
    public void onDeleteMaintenanceSuccess() {
        IOUtil.showToast("온도유지 삭제 완료");
        backButtonClicked();
    }
}
