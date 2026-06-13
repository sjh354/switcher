package kr.switcher.switcherm.ui.setting.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import antistatic.spinnerwheel.AbstractWheel;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.rey.material.widget.Button;
import java.util.ArrayList;
import java.util.List;
import kr.switcher.device.checker.Checker;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.device.IODeviceHandler;
import kr.switcher.switcherm.preference.OAuthToken;
import kr.switcher.switcherm.ui.main.presenters.SettopRemoconConnectedPresenter;
import kr.switcher.switcherm.ui.setting.adapter.CheckerLevelAdapter;
import kr.switcher.switcherm.ui.setting.adapter.ReservationWheelAdapter;
import kr.switcher.switcherm.ui.setting.helper.CheckerLevelItem;
import kr.switcher.switcherm.ui.setting.helper.CheckerPageViewer;
import kr.switcher.switcherm.ui.setting.helper.CheckerSurveillanceInfo;
import kr.switcher.switcherm.ui.setting.helper.CheckerSurveillanceJsonParser;
import kr.switcher.switcherm.ui.setting.helper.DayOfWeekRepeater;
import kr.switcher.switcherm.ui.setting.interactor.DeleteSurveillanceInteractor;
import kr.switcher.switcherm.ui.setting.interactor.MakeSurveillanceInteractor;
import kr.switcher.switcherm.ui.setting.interactor.ModifyCheckerSurveillanceInteractor;
import kr.switcher.switcherm.ui.setting.presenter.CheckerSurveillanceSettingPresenter;
import kr.switcher.switcherm.ui.setting.view.CheckerSurveillanceSettingView;
import kr.switcher.switcherm.ui.setting.viewpager.ChekcerLevelViewPager;

/* JADX INFO: loaded from: classes2.dex */
public class CheckerSurveillanceSettingFragment extends Fragment implements CheckerSurveillanceSettingView, MakeSurveillanceInteractor.OnMakeSurveillanceListener, ModifyCheckerSurveillanceInteractor.OnModifyCheckerSurveillanceListener, DeleteSurveillanceInteractor.OnDeleteSurveillanceListener {
    private static final String ALARM_DURATION_MIN = "1";
    private static final String PARM_CHECKER_SURVEILLANCE = "CHECKER_SURVEILLANCE";
    private static final String TAG = "CheckerSurveillanceSettingFragment";
    private static final String TRESPASS_DURATION_MIN = "1";

    @BindView(R.id.btn_remove)
    Button btn_remove;
    private List<CheckerLevelItem> checkerLevelItemList = new ArrayList();
    private Checker connectedChecker;
    private int currentPosition;
    private ReservationWheelAdapter endHourAdapter;
    private ReservationWheelAdapter endMinAdapter;

    @BindView(R.id.et_title)
    EditText et_title;

    @BindView(R.id.iv_left_arrow_btn)
    ImageView iv_left_arrow_btn;

    @BindView(R.id.iv_right_arrow_btn)
    ImageView iv_right_arrow_btn;
    private CheckerLevelAdapter pagerAdapter;

    @BindView(R.id.pb_loading)
    ProgressBar pb_loading;
    private CheckerSurveillanceSettingPresenter presenter;

    @BindView(R.id.rl_left_arrow_btn)
    RelativeLayout rl_left_arrow_btn;

    @BindView(R.id.rl_remove)
    RelativeLayout rl_remove;

    @BindView(R.id.rl_right_arrow_btn)
    RelativeLayout rl_right_arrow_btn;
    private Checker.Surveillance selectedSurveillance;
    private ReservationWheelAdapter startHourAdapter;
    private ReservationWheelAdapter startMinAdapter;

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

    @BindView(R.id.tv_tue)
    TextView tv_tue;

    @BindView(R.id.tv_wed)
    TextView tv_wed;

    @BindView(R.id.tv_weekday)
    TextView tv_weekday;

    @BindView(R.id.tv_weekend)
    TextView tv_weekend;

    @BindView(R.id.vp_propose)
    ChekcerLevelViewPager vp_propose;

    @BindView(R.id.wv_end_hour)
    AbstractWheel wv_end_hour;

    @BindView(R.id.wv_end_min)
    AbstractWheel wv_end_min;

    @BindView(R.id.wv_start_hour)
    AbstractWheel wv_start_hour;

    @BindView(R.id.wv_start_min)
    AbstractWheel wv_start_min;

    @Override // kr.switcher.switcherm.ui.setting.interactor.DeleteSurveillanceInteractor.OnDeleteSurveillanceListener
    public void onDeleteSurveillanceError(String str) {
    }

    @Override // kr.switcher.switcherm.ui.setting.interactor.ModifyCheckerSurveillanceInteractor.OnModifyCheckerSurveillanceListener
    public void onError(String str) {
    }

    public static CheckerSurveillanceSettingFragment newInstance(String str, Checker.Surveillance surveillance) {
        CheckerSurveillanceSettingFragment checkerSurveillanceSettingFragment = new CheckerSurveillanceSettingFragment();
        Bundle bundle = new Bundle();
        bundle.putString("CONNECTED_MAC_ADDRESS", str);
        bundle.putString(PARM_CHECKER_SURVEILLANCE, CheckerSurveillanceJsonParser.makeCheckerSurveillanceJson(surveillance));
        checkerSurveillanceSettingFragment.setArguments(bundle);
        return checkerSurveillanceSettingFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String string;
        View viewInflate = layoutInflater.inflate(R.layout.fragment_surveillance, viewGroup, false);
        ButterKnife.bind(this, viewInflate);
        this.selectedSurveillance = null;
        Bundle arguments = getArguments();
        if (arguments != null) {
            string = arguments.getString("CONNECTED_MAC_ADDRESS");
            try {
                this.selectedSurveillance = CheckerSurveillanceJsonParser.parseCheckerSurveillance(arguments.getString(PARM_CHECKER_SURVEILLANCE));
            } catch (Exception e) {
                IOLog.error(TAG, new OAuthToken().getOAuthToken(), "checkerSurveillance onCreateView", e);
            }
        } else {
            string = null;
        }
        if (string == null) {
            return null;
        }
        Checker checker = (Checker) IODeviceHandler.getInstance().getDevice(string);
        this.connectedChecker = checker;
        if (checker == null) {
            return null;
        }
        CheckerSurveillanceSettingPresenter checkerSurveillanceSettingPresenter = new CheckerSurveillanceSettingPresenter(this, new MakeSurveillanceInteractor(this), new ModifyCheckerSurveillanceInteractor(this), new DeleteSurveillanceInteractor(this));
        this.presenter = checkerSurveillanceSettingPresenter;
        checkerSurveillanceSettingPresenter.onCreateView(this.selectedSurveillance);
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        IOUtil.hideKeyBoard(this.et_title);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.CheckerSurveillanceSettingView
    public void initViewPager(int i) {
        setLevelImage();
        CheckerLevelAdapter checkerLevelAdapter = new CheckerLevelAdapter(((AppCompatActivity) getContext()).getSupportFragmentManager(), new CheckerPageViewer(this.checkerLevelItemList).getPage());
        this.pagerAdapter = checkerLevelAdapter;
        this.vp_propose.setAdapter(checkerLevelAdapter);
        this.vp_propose.setCurrentItem(i);
        this.pagerAdapter.notifyDataSetChanged();
        this.currentPosition = i;
    }

    @Override // kr.switcher.switcherm.ui.setting.view.CheckerSurveillanceSettingView
    public void setPagerListener(int i) {
        this.iv_right_arrow_btn.setOnClickListener(this.presenter.onClickRightArrowButtonClicked(i));
        this.iv_left_arrow_btn.setOnClickListener(this.presenter.onClickLeftArrowButtonClicked());
        this.vp_propose.addOnPageChangeListener(this.presenter.onPageChangeListener());
    }

    @Override // kr.switcher.switcherm.ui.setting.view.CheckerSurveillanceSettingView
    public void setLevelImage() {
        this.checkerLevelItemList.add(new CheckerLevelItem(1, IOUtil.getDrawable(R.drawable.ic_info_checker_level_one)));
        this.checkerLevelItemList.add(new CheckerLevelItem(2, IOUtil.getDrawable(R.drawable.ic_info_checker_level_two)));
    }

    @Override // kr.switcher.switcherm.ui.setting.view.CheckerSurveillanceSettingView
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

    @Override // kr.switcher.switcherm.ui.setting.view.CheckerSurveillanceSettingView
    public void hideProgressbar() {
        this.pb_loading.setVisibility(8);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.CheckerSurveillanceSettingView
    public void showProgressbar() {
        this.pb_loading.setVisibility(0);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.CheckerSurveillanceSettingView
    public void selectDaily() {
        this.tv_daily.setTextColor(IOUtil.getColorResource(R.color.periwinkle));
    }

    @Override // kr.switcher.switcherm.ui.setting.view.CheckerSurveillanceSettingView
    public void unSelectDaily() {
        this.tv_daily.setTextColor(IOUtil.getColorResource(R.color.slate_grey));
    }

    @Override // kr.switcher.switcherm.ui.setting.view.CheckerSurveillanceSettingView
    public void selectWeekday() {
        this.tv_weekday.setTextColor(IOUtil.getColorResource(R.color.periwinkle));
    }

    @Override // kr.switcher.switcherm.ui.setting.view.CheckerSurveillanceSettingView
    public void unSelectWeekday() {
        this.tv_weekday.setTextColor(IOUtil.getColorResource(R.color.slate_grey));
    }

    @Override // kr.switcher.switcherm.ui.setting.view.CheckerSurveillanceSettingView
    public void selectWeekend() {
        this.tv_weekend.setTextColor(IOUtil.getColorResource(R.color.periwinkle));
    }

    @Override // kr.switcher.switcherm.ui.setting.view.CheckerSurveillanceSettingView
    public void unSelectWeekend() {
        this.tv_weekend.setTextColor(IOUtil.getColorResource(R.color.slate_grey));
    }

    @Override // kr.switcher.switcherm.ui.setting.view.CheckerSurveillanceSettingView
    public void selectMon() {
        this.tv_mon.setTextColor(IOUtil.getColorResource(R.color.periwinkle));
        this.tv_mon.setSelected(true);
        this.tv_mon.setTypeface(null, 1);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.CheckerSurveillanceSettingView
    public void unSelectMon() {
        this.tv_mon.setTextColor(IOUtil.getColorResource(R.color.slate_grey));
        this.tv_mon.setSelected(false);
        this.tv_mon.setTypeface(null, 0);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.CheckerSurveillanceSettingView
    public void selectTue() {
        this.tv_tue.setTextColor(IOUtil.getColorResource(R.color.periwinkle));
        this.tv_tue.setSelected(true);
        this.tv_tue.setTypeface(null, 1);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.CheckerSurveillanceSettingView
    public void unSelectTue() {
        this.tv_tue.setTextColor(IOUtil.getColorResource(R.color.slate_grey));
        this.tv_tue.setSelected(false);
        this.tv_tue.setTypeface(null, 0);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.CheckerSurveillanceSettingView
    public void selectWed() {
        this.tv_wed.setTextColor(IOUtil.getColorResource(R.color.periwinkle));
        this.tv_wed.setSelected(true);
        this.tv_wed.setTypeface(null, 1);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.CheckerSurveillanceSettingView
    public void unSelectWed() {
        this.tv_wed.setTextColor(IOUtil.getColorResource(R.color.slate_grey));
        this.tv_wed.setSelected(false);
        this.tv_wed.setTypeface(null, 0);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.CheckerSurveillanceSettingView
    public void selectThu() {
        this.tv_thu.setTextColor(IOUtil.getColorResource(R.color.periwinkle));
        this.tv_thu.setSelected(true);
        this.tv_thu.setTypeface(null, 1);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.CheckerSurveillanceSettingView
    public void unSelectThu() {
        this.tv_thu.setTextColor(IOUtil.getColorResource(R.color.slate_grey));
        this.tv_thu.setSelected(false);
        this.tv_thu.setTypeface(null, 0);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.CheckerSurveillanceSettingView
    public void selectFri() {
        this.tv_fri.setTextColor(IOUtil.getColorResource(R.color.periwinkle));
        this.tv_fri.setSelected(true);
        this.tv_fri.setTypeface(null, 1);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.CheckerSurveillanceSettingView
    public void unSelectFri() {
        this.tv_fri.setTextColor(IOUtil.getColorResource(R.color.slate_grey));
        this.tv_fri.setSelected(false);
        this.tv_fri.setTypeface(null, 0);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.CheckerSurveillanceSettingView
    public void selectSat() {
        this.tv_sat.setTextColor(IOUtil.getColorResource(R.color.periwinkle));
        this.tv_sat.setSelected(true);
        this.tv_sat.setTypeface(null, 1);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.CheckerSurveillanceSettingView
    public void unSelectSat() {
        this.tv_sat.setTextColor(IOUtil.getColorResource(R.color.slate_grey));
        this.tv_sat.setSelected(false);
        this.tv_sat.setTypeface(null, 0);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.CheckerSurveillanceSettingView
    public void selectSun() {
        this.tv_sun.setTextColor(IOUtil.getColorResource(R.color.periwinkle));
        this.tv_sun.setSelected(true);
        this.tv_sun.setTypeface(null, 1);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.CheckerSurveillanceSettingView
    public void unSelectSun() {
        this.tv_sun.setTextColor(IOUtil.getColorResource(R.color.slate_grey));
        this.tv_sun.setSelected(false);
        this.tv_sun.setTypeface(null, 0);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.CheckerSurveillanceSettingView
    public void setRepeater() {
        DayOfWeekRepeater dayOfWeekRepeater = new DayOfWeekRepeater();
        dayOfWeekRepeater.setDayOfWeek(this.tv_mon.isSelected(), this.tv_tue.isSelected(), this.tv_wed.isSelected(), this.tv_thu.isSelected(), this.tv_fri.isSelected(), this.tv_sat.isSelected(), this.tv_sun.isSelected());
        this.presenter.setRepeater(dayOfWeekRepeater);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.CheckerSurveillanceSettingView
    public void setTitle(String str) {
        this.et_title.setText(str);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.CheckerSurveillanceSettingView
    public void setSurveillanceInfo(Checker.Surveillance surveillance) {
        if (!surveillance.title.equals("")) {
            this.et_title.setText(surveillance.title);
        }
        this.wv_start_hour.setCurrentItem(surveillance.startHour);
        this.wv_end_hour.setCurrentItem(surveillance.endHour);
        this.wv_start_min.setCurrentItem(surveillance.startMin);
        this.wv_end_min.setCurrentItem(surveillance.endMin);
        this.presenter.setMon(surveillance.mon.booleanValue());
        this.presenter.setTue(surveillance.tue.booleanValue());
        this.presenter.setWed(surveillance.wed.booleanValue());
        this.presenter.setThu(surveillance.thu.booleanValue());
        this.presenter.setFri(surveillance.fri.booleanValue());
        this.presenter.setSat(surveillance.sat.booleanValue());
        this.presenter.setSun(surveillance.sun.booleanValue());
    }

    @Override // kr.switcher.switcherm.ui.setting.view.CheckerSurveillanceSettingView
    public void showRemoveButton() {
        this.rl_remove.setVisibility(0);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.CheckerSurveillanceSettingView
    public void hideRemoveButton() {
        this.rl_remove.setVisibility(8);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.CheckerSurveillanceSettingView
    public void showSameTimeSettingError() {
        IOUtil.showToast(R.string.same_time_setting_error);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.CheckerSurveillanceSettingView
    public void showLogicalOrderError() {
        IOUtil.showToast(R.string.logical_order_error);
        hideProgressbar();
    }

    @Override // kr.switcher.switcherm.ui.setting.view.CheckerSurveillanceSettingView
    public void onClickRightArrowButtonClicked(int i) {
        this.presenter.setNextPosition(this.vp_propose.getCurrentItem(), i);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.CheckerSurveillanceSettingView
    public void onClickLeftArrowButtonClicked() {
        this.presenter.setPreviousPosition(this.vp_propose.getCurrentItem());
    }

    @Override // kr.switcher.switcherm.ui.setting.view.CheckerSurveillanceSettingView
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

    @OnClick({R.id.btn_remove})
    public void onRemoveButtonClicked() {
        showTestDialog();
    }

    @Override // kr.switcher.switcherm.ui.setting.view.CheckerSurveillanceSettingView
    public void showTestDialog() {
        new MaterialDialog.Builder(getContext()).content("설정을 삭제 하시겠습니까?").positiveText("예").negativeText("아니오").negativeColor(R.color.periwinkle).positiveColor(R.color.periwinkle).onPositive(new MaterialDialog.SingleButtonCallback() { // from class: kr.switcher.switcherm.ui.setting.fragment.CheckerSurveillanceSettingFragment.2
            @Override // com.afollestad.materialdialogs.MaterialDialog.SingleButtonCallback
            public void onClick(MaterialDialog materialDialog, DialogAction dialogAction) {
                CheckerSurveillanceSettingFragment.this.presenter.onRemoveButtonClicked(CheckerSurveillanceSettingFragment.this.connectedChecker.getMacAddress(), CheckerSurveillanceSettingFragment.this.selectedSurveillance.id);
            }
        }).onNegative(new MaterialDialog.SingleButtonCallback() { // from class: kr.switcher.switcherm.ui.setting.fragment.CheckerSurveillanceSettingFragment.1
            @Override // com.afollestad.materialdialogs.MaterialDialog.SingleButtonCallback
            public void onClick(MaterialDialog materialDialog, DialogAction dialogAction) {
            }
        }).cancelable(false).show();
    }

    public void showUpdateDialog() {
        new MaterialDialog.Builder(getContext()).content("경계모드 2단계는 현재 개발중입니다. \n 8월중으로 업데이트 될 예정이니 \n 조금만 기다려 주세요 :) ").positiveText(SettopRemoconConnectedPresenter.BUTTON_CONFIRM).positiveColor(R.color.periwinkle).cancelable(false).show();
    }

    public void onSaveButtonClicked() {
        String string = this.et_title.getText().toString();
        if (string.equals("") || string.length() < 1) {
            string = "제목 없음";
        }
        this.presenter.onSaveButtonClicked(this.connectedChecker.getMacAddress(), this.selectedSurveillance, this.currentPosition, new CheckerSurveillanceInfo(string, this.tv_mon, this.tv_tue, this.tv_wed, this.tv_thu, this.tv_fri, this.tv_sat, this.tv_sun, this.wv_start_hour, this.wv_end_hour, this.wv_start_min, this.wv_end_min));
    }

    @Override // kr.switcher.switcherm.ui.setting.interactor.MakeSurveillanceInteractor.OnMakeSurveillanceListener
    public void onMakeSurveillanceSuccess() {
        backButtonClicked();
        IOUtil.showToast("경계모드 설정 완료");
    }

    @Override // kr.switcher.switcherm.ui.setting.interactor.MakeSurveillanceInteractor.OnMakeSurveillanceListener
    public void onMakeSurveillanceError(String str, String str2) {
        hideProgressbar();
    }

    @Override // kr.switcher.switcherm.ui.setting.interactor.ModifyCheckerSurveillanceInteractor.OnModifyCheckerSurveillanceListener
    public void onModifySurveillance() {
        IOUtil.showToast("경계 모드 수정 완료");
        backButtonClicked();
    }

    @Override // kr.switcher.switcherm.ui.setting.interactor.DeleteSurveillanceInteractor.OnDeleteSurveillanceListener
    public void onDeleteSurveillanceSuccess() {
        getActivity().onBackPressed();
        IOUtil.showToast("경계모드 삭제 성공");
    }

    @Override // kr.switcher.switcherm.ui.setting.view.CheckerSurveillanceSettingView
    public void setProposeCurrentItem(int i) {
        this.vp_propose.setCurrentItem(i, true);
        this.currentPosition = i;
    }

    @Override // kr.switcher.switcherm.ui.setting.view.CheckerSurveillanceSettingView
    public void showRightArrowButton() {
        this.rl_right_arrow_btn.setVisibility(0);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.CheckerSurveillanceSettingView
    public void hideLeftArrowButton() {
        this.rl_left_arrow_btn.setVisibility(8);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.CheckerSurveillanceSettingView
    public void showLeftArrowButton() {
        this.rl_left_arrow_btn.setVisibility(0);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.CheckerSurveillanceSettingView
    public void hideRightArrowButton() {
        this.rl_right_arrow_btn.setVisibility(8);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.CheckerSurveillanceSettingView
    public void refreshViewPage() {
        this.pagerAdapter.notifyDataSetChanged();
    }
}
