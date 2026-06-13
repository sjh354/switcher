package kr.switcher.switcherm.ui.setting;

import android.os.Bundle;
import android.view.View;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import java.util.List;
import kr.switcher.device.IODevice;
import kr.switcher.device.switcher.Switcher;
import kr.switcher.device.switcher.interfaces.IODeviceCallbacks;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.activity.IOActivity;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.databinding.ActivitySettingBinding;
import kr.switcher.switcherm.device.IODeviceHandler;
import kr.switcher.switcherm.device.switcher.handler.SwitcherHandler;
import kr.switcher.switcherm.preference.OAuthToken;
import kr.switcher.switcherm.preference.TimerVersion;
import kr.switcher.switcherm.ui.setting.fragment.AirconMaintainingTemperatureFragment;
import kr.switcher.switcherm.ui.setting.fragment.AirconMaintainingTemperatureListFragment;
import kr.switcher.switcherm.ui.setting.fragment.AirconReservationFragment;
import kr.switcher.switcherm.ui.setting.fragment.AirconReservationListFragment;
import kr.switcher.switcherm.ui.setting.fragment.CheckerHistoryFragment;
import kr.switcher.switcherm.ui.setting.fragment.CheckerSurveillanceListFragment;
import kr.switcher.switcherm.ui.setting.fragment.CheckerSurveillanceSettingFragment;
import kr.switcher.switcherm.ui.setting.fragment.DFUFragment;
import kr.switcher.switcherm.ui.setting.fragment.ReservationFragment;
import kr.switcher.switcherm.ui.setting.fragment.ReservationListFragment;
import kr.switcher.switcherm.ui.setting.fragment.SettingListFragment;
import kr.switcher.switcherm.ui.setting.fragment.SettopReservationFragment;
import kr.switcher.switcherm.ui.setting.fragment.SettopReservationListFragment;
import kr.switcher.switcherm.ui.setting.fragment.ShareCodeFragment;
import kr.switcher.switcherm.ui.setting.fragment.StrokeLevelFragment;
import kr.switcher.switcherm.viewmodel.SettingActivityViewModel;

/* JADX INFO: loaded from: classes2.dex */
public class SettingActivity extends IOActivity {
    public static final String PARM_CONNECTED_MAC_ADDRESS = "CONNECTED_MAC_ADDRESS";
    public static final String PARM_NEXT_FRAGMENT = "NEXT_FRAGMENT";
    private static final String TAG = "SettingActivity";
    private AirconMaintainingTemperatureFragment airconMaintainingTemperatureFragment;
    private AirconMaintainingTemperatureListFragment airconMaintainingTemperatureListFragment;
    private AirconReservationFragment airconReservationFragment;
    private AirconReservationListFragment airconReservationListFragment;
    private ActivitySettingBinding binder;
    private CheckerHistoryFragment checkerHistoryFragment;
    private CheckerSurveillanceListFragment checkerSurveillanceListFragment;
    private CheckerSurveillanceSettingFragment checkerSurveillanceSettingFragment;
    private IODevice connectedDevice;
    private String connectedMacAddress;
    private DFUFragment dfuFragment;
    private ReservationFragment reservationFragment;
    private ReservationListFragment reservationListFragment;
    private SettingListFragment settingListFragment;
    private SettopReservationFragment settopReservationFragment;
    private SettopReservationListFragment settopReservationListFragment;
    private ShareCodeFragment shareCodeFragment;
    private StrokeLevelFragment strokeFragment;
    private SettingActivityViewModel viewModel;

    public interface LastVersionListener {
        void onIsLastVersion(boolean z);
    }

    public interface MovedFragmentListener {
        void onFragmentMoved(Fragment fragment);
    }

    public interface StrokeTestListener {
        void onFinishTest();

        void onStartTest();
    }

    public interface TimerSizeListener {
        void onReservationSize(int i);
    }

    public void onSwitchEnable(View view) {
    }

    @Override // kr.switcher.switcherm.common.activity.IOActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.binder = (ActivitySettingBinding) DataBindingUtil.setContentView(this, R.layout.activity_setting);
        SettingActivityViewModel settingActivityViewModel = new SettingActivityViewModel(this, SettingActivityViewModel.MENU_LIST);
        this.viewModel = settingActivityViewModel;
        this.binder.setViewModel(settingActivityViewModel);
        String stringExtra = getIntent().getStringExtra("CONNECTED_MAC_ADDRESS");
        this.connectedMacAddress = stringExtra;
        if (!IOUtil.checkIsIODeviceKey(stringExtra)) {
            List<Switcher> connectedSwitcherList = SwitcherHandler.getInstance().getConnectedSwitcherList();
            if (connectedSwitcherList == null || connectedSwitcherList.size() < 1) {
                finish();
                return;
            }
            String macAddress = SwitcherHandler.getInstance().getConnectedSwitcherList().get(0).getMacAddress();
            this.connectedMacAddress = macAddress;
            if (!IOUtil.checkIsIODeviceKey(macAddress)) {
                IOUtil.showToast(IOUtil.getStringResource(R.string.not_found_connected_macaddress));
                finish();
                return;
            }
        }
        IODevice device = IODeviceHandler.getInstance().getDevice(this.connectedMacAddress);
        this.connectedDevice = device;
        if (device == null) {
            IOUtil.showToast(IOUtil.getStringResource(R.string.not_found_connected_macaddress));
            finish();
            return;
        }
        this.settingListFragment = SettingListFragment.newInstance(this.connectedMacAddress, moveTimerFragmentListener(), getLastVersionListener());
        this.shareCodeFragment = ShareCodeFragment.newInstance(this.connectedMacAddress);
        this.reservationListFragment = ReservationListFragment.newInstance(this.connectedMacAddress, moveTimerFragmentListener(), getTimerSizeListener());
        this.reservationFragment = ReservationFragment.newInstance(this.connectedMacAddress, null);
        this.dfuFragment = DFUFragment.newInstance(this.connectedMacAddress);
        this.strokeFragment = StrokeLevelFragment.newInstance(this.connectedMacAddress, getStrokeTestListener());
        this.checkerHistoryFragment = CheckerHistoryFragment.newInstance(this.connectedMacAddress);
        this.airconReservationListFragment = AirconReservationListFragment.newInstance(this.connectedMacAddress, moveAirconReservationFragmentListener(), getTimerSizeListener());
        this.airconReservationFragment = AirconReservationFragment.newInstance(this.connectedMacAddress, null);
        this.airconMaintainingTemperatureListFragment = AirconMaintainingTemperatureListFragment.newInstance(this.connectedMacAddress, moveAirconMaintainingTemperatureListener());
        this.airconMaintainingTemperatureFragment = AirconMaintainingTemperatureFragment.newInstance(this.connectedMacAddress, null);
        this.checkerSurveillanceSettingFragment = CheckerSurveillanceSettingFragment.newInstance(this.connectedMacAddress, null);
        this.checkerSurveillanceListFragment = CheckerSurveillanceListFragment.newInstance(this.connectedMacAddress, moveCheckerSurveillanceListener());
        this.settopReservationListFragment = SettopReservationListFragment.newInstance(this.connectedMacAddress, moveSettopReservationFragmentListener(), getTimerSizeListener());
        this.settopReservationFragment = SettopReservationFragment.newInstance(this.connectedMacAddress, null);
        String stringExtra2 = getIntent().getStringExtra(PARM_NEXT_FRAGMENT);
        if ("ReservationFragment".equals(stringExtra2)) {
            moveFragment(this.reservationFragment, "ReservationFragment", SettingActivityViewModel.MENU_TIMER);
            return;
        }
        if ("ReservationListFragment".equals(stringExtra2)) {
            moveFragment(this.reservationListFragment, "ReservationListFragment", SettingActivityViewModel.MENU_TIMER_LIST);
            return;
        }
        if ("StrokeLevelFragment".equals(stringExtra2)) {
            moveFragment(this.strokeFragment, "StrokeLevelFragment", SettingActivityViewModel.MENU_STROKE_LEVEL);
            return;
        }
        if ("CheckerHistoryFragment".equals(stringExtra2)) {
            moveFragment(this.checkerHistoryFragment, "CheckerHistoryFragment", SettingActivityViewModel.MENU_CHECKER_HISTORY);
            return;
        }
        if ("AirconReservationFragment".equals(stringExtra2)) {
            moveFragment(this.airconReservationFragment, "AirconReservationFragment", SettingActivityViewModel.MENU_AIRCON_RESERVATION);
            return;
        }
        if ("AirconReservationListFragment".equals(stringExtra2)) {
            moveFragment(this.airconReservationListFragment, "AirconReservationListFragment", SettingActivityViewModel.MENU_AIRCON_RESERVATION_LIST);
            return;
        }
        if ("AirconMaintainingTemperatureListFragment".equals(stringExtra2)) {
            moveFragment(this.airconMaintainingTemperatureListFragment, "AirconMaintainingTemperatureListFragment", SettingActivityViewModel.MENU_AIRCON_MAINTAINING_TEMPERATURE_LIST);
            return;
        }
        if ("AirconMaintainingTemperatureFragment".equals(stringExtra2)) {
            moveFragment(this.airconMaintainingTemperatureFragment, "AirconMaintainingTemperatureFragment", SettingActivityViewModel.MENU_AIRCON_MAINTAINING_TEMPERATURE);
            return;
        }
        if ("CheckerSurveillanceSettingFragment".equals(stringExtra2)) {
            moveFragment(this.checkerSurveillanceSettingFragment, "CheckerSurveillanceSettingFragment", SettingActivityViewModel.MENU_CHECKER_SURVEILLANCE);
            return;
        }
        if ("CheckerSurveillanceListFragment".equals(stringExtra2)) {
            moveFragment(this.checkerSurveillanceListFragment, "CheckerSurveillanceListFragment", SettingActivityViewModel.MENU_CHECKER_SURVEILLANCE_LIST);
            return;
        }
        if ("SettopReservationListFragment".equals(stringExtra2)) {
            moveFragment(this.settopReservationListFragment, "SettopReservationListFragment", SettingActivityViewModel.MENU_SETTOP_RESERVATION_LIST);
        } else if ("SettopReservationFragment".equals(stringExtra2)) {
            moveFragment(this.settopReservationFragment, "SettopReservationFragment", SettingActivityViewModel.MENU_SETTOP_RESERVATION);
        } else {
            moveFragment(this.settingListFragment, "SettingListFragment", SettingActivityViewModel.MENU_LIST);
        }
    }

    private MovedFragmentListener moveSettopReservationFragmentListener() {
        return new MovedFragmentListener() { // from class: kr.switcher.switcherm.ui.setting.SettingActivity.1
            @Override // kr.switcher.switcherm.ui.setting.SettingActivity.MovedFragmentListener
            public void onFragmentMoved(Fragment fragment) {
                if (fragment != null) {
                    SettingActivity.this.settopReservationFragment = (SettopReservationFragment) fragment;
                }
                SettingActivity settingActivity = SettingActivity.this;
                settingActivity.moveFragment(settingActivity.settopReservationFragment, "SettopReservationFragment", SettingActivityViewModel.MENU_SETTOP_RESERVATION);
            }
        };
    }

    private MovedFragmentListener moveTimerFragmentListener() {
        return new MovedFragmentListener() { // from class: kr.switcher.switcherm.ui.setting.SettingActivity.2
            @Override // kr.switcher.switcherm.ui.setting.SettingActivity.MovedFragmentListener
            public void onFragmentMoved(Fragment fragment) {
                if (fragment != null) {
                    SettingActivity.this.reservationFragment = (ReservationFragment) fragment;
                }
                SettingActivity settingActivity = SettingActivity.this;
                settingActivity.moveFragment(settingActivity.reservationFragment, "ReservationFragment", SettingActivityViewModel.MENU_TIMER);
            }
        };
    }

    private MovedFragmentListener moveAirconReservationFragmentListener() {
        return new MovedFragmentListener() { // from class: kr.switcher.switcherm.ui.setting.SettingActivity.3
            @Override // kr.switcher.switcherm.ui.setting.SettingActivity.MovedFragmentListener
            public void onFragmentMoved(Fragment fragment) {
                if (fragment != null) {
                    SettingActivity.this.airconReservationFragment = (AirconReservationFragment) fragment;
                }
                SettingActivity settingActivity = SettingActivity.this;
                settingActivity.moveFragment(settingActivity.airconReservationFragment, "AirconReservationFragment", SettingActivityViewModel.MENU_AIRCON_RESERVATION);
            }
        };
    }

    private MovedFragmentListener moveAirconMaintainingTemperatureListener() {
        return new MovedFragmentListener() { // from class: kr.switcher.switcherm.ui.setting.SettingActivity.4
            @Override // kr.switcher.switcherm.ui.setting.SettingActivity.MovedFragmentListener
            public void onFragmentMoved(Fragment fragment) {
                if (fragment != null) {
                    SettingActivity.this.airconMaintainingTemperatureFragment = (AirconMaintainingTemperatureFragment) fragment;
                }
                SettingActivity settingActivity = SettingActivity.this;
                settingActivity.moveFragment(settingActivity.airconMaintainingTemperatureFragment, "AirconMaintainingTemperatureFragment", SettingActivityViewModel.MENU_AIRCON_MAINTAINING_TEMPERATURE);
            }
        };
    }

    private MovedFragmentListener moveCheckerSurveillanceListener() {
        return new MovedFragmentListener() { // from class: kr.switcher.switcherm.ui.setting.SettingActivity.5
            @Override // kr.switcher.switcherm.ui.setting.SettingActivity.MovedFragmentListener
            public void onFragmentMoved(Fragment fragment) {
                if (fragment != null) {
                    SettingActivity.this.checkerSurveillanceSettingFragment = (CheckerSurveillanceSettingFragment) fragment;
                }
                SettingActivity settingActivity = SettingActivity.this;
                settingActivity.moveFragment(settingActivity.checkerSurveillanceSettingFragment, "CheckerSurveillanceSettingFragment", SettingActivityViewModel.MENU_CHECKER_SURVEILLANCE);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void moveFragment(Fragment fragment, String str, String str2) {
        this.viewModel.setState(str2);
        FragmentTransaction fragmentTransactionBeginTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransactionBeginTransaction.replace(R.id.container, fragment, str);
        try {
            fragmentTransactionBeginTransaction.commit();
        } catch (Exception e) {
            IOLog.error(TAG, new OAuthToken().getOAuthToken(), "moveWifiConnectFragment", e);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        SettingListFragment settingListFragment = (SettingListFragment) getSupportFragmentManager().findFragmentByTag("SettingListFragment");
        ReservationListFragment reservationListFragment = (ReservationListFragment) getSupportFragmentManager().findFragmentByTag("ReservationListFragment");
        ReservationFragment reservationFragment = (ReservationFragment) getSupportFragmentManager().findFragmentByTag("ReservationFragment");
        ShareCodeFragment shareCodeFragment = (ShareCodeFragment) getSupportFragmentManager().findFragmentByTag("ShareCodeFragment");
        DFUFragment dFUFragment = (DFUFragment) getSupportFragmentManager().findFragmentByTag("DFUFragment");
        StrokeLevelFragment strokeLevelFragment = (StrokeLevelFragment) getSupportFragmentManager().findFragmentByTag("StrokeLevelFragment");
        AirconReservationFragment airconReservationFragment = (AirconReservationFragment) getSupportFragmentManager().findFragmentByTag("AirconReservationFragment");
        SettopReservationFragment settopReservationFragment = (SettopReservationFragment) getSupportFragmentManager().findFragmentByTag("SettopReservationFragment");
        AirconMaintainingTemperatureFragment airconMaintainingTemperatureFragment = (AirconMaintainingTemperatureFragment) getSupportFragmentManager().findFragmentByTag("AirconMaintainingTemperatureFragment");
        CheckerSurveillanceSettingFragment checkerSurveillanceSettingFragment = (CheckerSurveillanceSettingFragment) getSupportFragmentManager().findFragmentByTag("CheckerSurveillanceSettingFragment");
        if (settingListFragment != null) {
            finishActivity();
            return;
        }
        if (reservationListFragment != null) {
            finishActivity();
            return;
        }
        if (reservationFragment != null) {
            moveFragment(this.reservationListFragment, "ReservationListFragment", SettingActivityViewModel.MENU_TIMER_LIST);
            this.reservationFragment = ReservationFragment.newInstance(this.connectedMacAddress, null);
            return;
        }
        if (shareCodeFragment != null) {
            moveFragment(this.settingListFragment, "SettingListFragment", SettingActivityViewModel.MENU_LIST);
            return;
        }
        if (dFUFragment != null) {
            moveFragment(this.settingListFragment, "SettingListFragment", SettingActivityViewModel.MENU_LIST);
            return;
        }
        if (strokeLevelFragment != null) {
            finishActivity();
            return;
        }
        if (airconReservationFragment != null) {
            moveFragment(this.airconReservationListFragment, "AirconReservationListFragment", SettingActivityViewModel.MENU_AIRCON_RESERVATION_LIST);
            this.airconReservationFragment = AirconReservationFragment.newInstance(this.connectedMacAddress, null);
            return;
        }
        if (airconMaintainingTemperatureFragment != null) {
            moveFragment(this.airconMaintainingTemperatureListFragment, "AirconMaintainingTemperatureListFragment", SettingActivityViewModel.MENU_AIRCON_MAINTAINING_TEMPERATURE_LIST);
            this.airconMaintainingTemperatureFragment = AirconMaintainingTemperatureFragment.newInstance(this.connectedMacAddress, null);
        } else if (checkerSurveillanceSettingFragment != null) {
            moveFragment(this.checkerSurveillanceListFragment, "CheckerSurveillanceListFragment", SettingActivityViewModel.MENU_CHECKER_SURVEILLANCE_LIST);
            this.checkerSurveillanceSettingFragment = CheckerSurveillanceSettingFragment.newInstance(this.connectedMacAddress, null);
        } else if (settopReservationFragment != null) {
            moveFragment(this.settopReservationListFragment, "SettopReservationListFragment", SettingActivityViewModel.MENU_SETTOP_RESERVATION_LIST);
            this.settopReservationFragment = SettopReservationFragment.newInstance(this.connectedMacAddress, null);
        } else {
            finishActivity();
        }
    }

    private void finishActivity() {
        finish();
    }

    public void onLeftButtonClicked(View view) {
        onBackPressed();
    }

    public void onRightButtonClicked(View view) {
        SettingListFragment settingListFragment = (SettingListFragment) getSupportFragmentManager().findFragmentByTag("SettingListFragment");
        ReservationListFragment reservationListFragment = (ReservationListFragment) getSupportFragmentManager().findFragmentByTag("ReservationListFragment");
        ReservationFragment reservationFragment = (ReservationFragment) getSupportFragmentManager().findFragmentByTag("ReservationFragment");
        AirconReservationListFragment airconReservationListFragment = (AirconReservationListFragment) getSupportFragmentManager().findFragmentByTag("AirconReservationListFragment");
        AirconReservationFragment airconReservationFragment = (AirconReservationFragment) getSupportFragmentManager().findFragmentByTag("AirconReservationFragment");
        ShareCodeFragment shareCodeFragment = (ShareCodeFragment) getSupportFragmentManager().findFragmentByTag("ShareCodeFragment");
        StrokeLevelFragment strokeLevelFragment = (StrokeLevelFragment) getSupportFragmentManager().findFragmentByTag("StrokeLevelFragment");
        AirconMaintainingTemperatureListFragment airconMaintainingTemperatureListFragment = (AirconMaintainingTemperatureListFragment) getSupportFragmentManager().findFragmentByTag("AirconMaintainingTemperatureListFragment");
        AirconMaintainingTemperatureFragment airconMaintainingTemperatureFragment = (AirconMaintainingTemperatureFragment) getSupportFragmentManager().findFragmentByTag("AirconMaintainingTemperatureFragment");
        CheckerSurveillanceSettingFragment checkerSurveillanceSettingFragment = (CheckerSurveillanceSettingFragment) getSupportFragmentManager().findFragmentByTag("CheckerSurveillanceSettingFragment");
        CheckerSurveillanceListFragment checkerSurveillanceListFragment = (CheckerSurveillanceListFragment) getSupportFragmentManager().findFragmentByTag("CheckerSurveillanceListFragment");
        SettopReservationListFragment settopReservationListFragment = (SettopReservationListFragment) getSupportFragmentManager().findFragmentByTag("SettopReservationListFragment");
        SettopReservationFragment settopReservationFragment = (SettopReservationFragment) getSupportFragmentManager().findFragmentByTag("SettopReservationFragment");
        if (settingListFragment != null) {
            return;
        }
        if (reservationListFragment != null) {
            if (((Switcher) this.connectedDevice).sResrvs.size() >= 10) {
                return;
            }
            moveFragment(this.reservationFragment, "ReservationFragment", SettingActivityViewModel.MENU_TIMER);
            return;
        }
        if (airconReservationListFragment != null) {
            moveFragment(this.airconReservationFragment, "AirconReservationFragment", SettingActivityViewModel.MENU_AIRCON_RESERVATION);
            return;
        }
        if (settopReservationListFragment != null) {
            moveFragment(this.settopReservationFragment, "SettopReservationFragment", SettingActivityViewModel.MENU_SETTOP_RESERVATION);
            return;
        }
        if (airconMaintainingTemperatureListFragment != null) {
            moveFragment(this.airconMaintainingTemperatureFragment, "AirconMaintainingTemperatureFragment", SettingActivityViewModel.MENU_AIRCON_MAINTAINING_TEMPERATURE);
            return;
        }
        if (shareCodeFragment != null && !SettingActivityViewModel.MENU_SHARE_CODE_CLICKED.equals(this.viewModel.getState())) {
            this.viewModel.setState(SettingActivityViewModel.MENU_SHARE_CODE_CLICKED);
            shareCodeFragment.changeNewShareCode(new IODeviceCallbacks.OnShareCodeChangeResultCallback() { // from class: kr.switcher.switcherm.ui.setting.SettingActivity.6
                @Override // kr.switcher.device.switcher.interfaces.IODeviceCallbacks.OnShareCodeChangeResultCallback
                public void onShareCodeChangeResult(boolean z) {
                    if (z) {
                        IOUtil.showToast(IOUtil.getStringResource(R.string.changed_share_code_message));
                        SettingActivity.this.onBackPressed();
                    }
                }
            });
            return;
        }
        if (reservationFragment != null) {
            reservationFragment.onSaveReservationButtonClicked(new IODeviceCallbacks.ReservationUpdateResultCallback() { // from class: kr.switcher.switcherm.ui.setting.SettingActivity.7
                @Override // kr.switcher.device.switcher.interfaces.IODeviceCallbacks.ReservationUpdateResultCallback
                public void onUpdatedReservation(boolean z) {
                    TimerVersion timerVersion = new TimerVersion();
                    if (z) {
                        timerVersion.setTimerVersion(Switcher.SwitcherReservation.currentTimerVersion);
                        IOUtil.showToast(IOUtil.getStringResource(R.string.saved_timer_message));
                        SettingActivity.this.onBackPressed();
                    } else {
                        Switcher.SwitcherReservation.currentTimerVersion = timerVersion.getTimerVersion();
                        IOUtil.showToast(IOUtil.getStringResource(R.string.failed_save_timer_message));
                    }
                }
            });
            return;
        }
        if (airconReservationFragment != null) {
            airconReservationFragment.onSaveReservationButtonClicked();
            return;
        }
        if (settopReservationFragment != null) {
            settopReservationFragment.onSaveReservationButtonClicked();
            return;
        }
        if (airconMaintainingTemperatureFragment != null) {
            airconMaintainingTemperatureFragment.onSaveReservationButtonClicked();
            return;
        }
        if (checkerSurveillanceSettingFragment != null) {
            checkerSurveillanceSettingFragment.onSaveButtonClicked();
        } else if (checkerSurveillanceListFragment != null) {
            moveFragment(this.checkerSurveillanceSettingFragment, "CheckerSurveillanceSettingFragment", SettingActivityViewModel.MENU_CHECKER_SURVEILLANCE);
        } else if (strokeLevelFragment != null) {
            strokeLevelFragment.onSaveButtonClicked();
        }
    }

    public void onMoveShareCodeButtonClicked(View view) {
        moveFragment(this.shareCodeFragment, "ShareCodeFragment", SettingActivityViewModel.MENU_SHARE_CODE);
    }

    public void onMoveFirmwareButtonClicked(View view) {
        moveFragment(this.dfuFragment, "DFUFragment", SettingActivityViewModel.MENU_FIRMWARE_UPDATE);
    }

    public void onRemoveTimer(View view) {
        this.reservationFragment.onRemoveReservationButtonClicked(new IODeviceCallbacks.ReservationUpdateResultCallback() { // from class: kr.switcher.switcherm.ui.setting.SettingActivity.8
            @Override // kr.switcher.device.switcher.interfaces.IODeviceCallbacks.ReservationUpdateResultCallback
            public void onUpdatedReservation(boolean z) {
                if (z) {
                    IOUtil.showToast(IOUtil.getStringResource(R.string.removed_timer_message));
                    SettingActivity.this.onBackPressed();
                } else {
                    IOUtil.showToast(IOUtil.getStringResource(R.string.failed_remove_timer_message));
                }
            }
        });
    }

    public void onUpdateFirmwareButtonClicked(View view) {
        this.dfuFragment.onUpdateFirmwareButtonClicked();
    }

    private LastVersionListener getLastVersionListener() {
        return new LastVersionListener() { // from class: kr.switcher.switcherm.ui.setting.SettingActivity.9
            @Override // kr.switcher.switcherm.ui.setting.SettingActivity.LastVersionListener
            public void onIsLastVersion(boolean z) {
                if (SettingActivity.this.dfuFragment != null) {
                    SettingActivity.this.dfuFragment.setIsLastVersion(z);
                }
            }
        };
    }

    private TimerSizeListener getTimerSizeListener() {
        return new TimerSizeListener() { // from class: kr.switcher.switcherm.ui.setting.SettingActivity.10
            @Override // kr.switcher.switcherm.ui.setting.SettingActivity.TimerSizeListener
            public void onReservationSize(int i) {
                if (i == 10) {
                    SettingActivity.this.viewModel.setState(SettingActivityViewModel.MENU_TIMER_LIST_FULL);
                } else {
                    SettingActivity.this.viewModel.setState(SettingActivityViewModel.MENU_TIMER_LIST);
                }
            }
        };
    }

    private StrokeTestListener getStrokeTestListener() {
        return new StrokeTestListener() { // from class: kr.switcher.switcherm.ui.setting.SettingActivity.11
            @Override // kr.switcher.switcherm.ui.setting.SettingActivity.StrokeTestListener
            public void onStartTest() {
                SettingActivity.this.viewModel.setState(SettingActivityViewModel.MENU_STROKE_LEVEL_TEST_ING);
            }

            @Override // kr.switcher.switcherm.ui.setting.SettingActivity.StrokeTestListener
            public void onFinishTest() {
                SettingActivity.this.viewModel.setState(SettingActivityViewModel.MENU_STROKE_LEVEL);
            }
        };
    }
}
