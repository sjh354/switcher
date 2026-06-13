package kr.switcher.switcherm.ui.main;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import java.io.Serializable;
import kr.switcher.device.switcher.Switcher;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.activity.IOActivity;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.device.IODeviceHandler;
import kr.switcher.switcherm.device.linker.LinkerHandler;
import kr.switcher.switcherm.device.switcher.handler.SwitcherHandler;
import kr.switcher.switcherm.signal.ReservationSignal;
import kr.switcher.switcherm.ui.irbrandgraph.IRBrandGraphActivity;
import kr.switcher.switcherm.ui.main.helper.LatestSensorValue;
import kr.switcher.switcherm.ui.main.helper.MainScreenController;
import kr.switcher.switcherm.ui.main.interactors.GetCurrentSensorValueInteractor;
import kr.switcher.switcherm.ui.main.presenters.MainPresenter;
import kr.switcher.switcherm.ui.main.views.MainView;
import kr.switcher.switcherm.ui.mypage.MypageActivity;
import kr.switcher.switcherm.ui.setting.SettingActivity;
import kr.switcher.switcherm.ui.switcherInfo.SwitcherInfoActivity;
import kr.switcher.switcherm.ui.switcherList.SwitcherListActivity;

/* JADX INFO: loaded from: classes2.dex */
public class MainActivity extends IOActivity implements MainView, GetCurrentSensorValueInteractor.OnGetCurrentSensorValueListener {
    public static final String CONNECTED_SWITCHER_ADDRESS = "CONNECTED_SWITCHER_ADDRESS";
    public static final int RES_BROKEN_CONNECTION = 103;
    public static final int RES_CALL_SWITCHER_LIST = 104;
    public static final int RES_NO_SWITCHER_FOUND = 102;
    public static final int RES_SWITCHER_FOUND_TO_CONNECT = 101;
    private static final String TAG = "MainActivity";

    @BindView(R.id.btn_chart_menu)
    RelativeLayout btn_chart_menu;

    @BindView(R.id.btn_my_page_menu)
    RelativeLayout btn_my_page_menu;

    @BindView(R.id.btn_scan_list_menu)
    ImageView btn_scan_list_menu;

    @BindView(R.id.btn_switcher_info_menu)
    RelativeLayout btn_switcher_info_menu;

    @BindView(R.id.iv_battery_warning)
    ImageView iv_battery_warning;

    @BindView(R.id.iv_switcher_icon)
    ImageView iv_switcher_icon;

    @BindView(R.id.iv_switcher_info_menu)
    ImageView iv_switcher_info_menu;

    @BindView(R.id.lin_top)
    LinearLayout lin_top;

    @BindView(R.id.pb_searching)
    ProgressBar pb_searching;
    private MainPresenter presenter;

    @BindView(R.id.rl_current_temperature)
    RelativeLayout rl_current_temperature;

    @BindView(R.id.rv_icon_sector)
    RelativeLayout rv_icon_sector;
    private String switcherMacAddress;

    @BindView(R.id.tv_info)
    TextView tv_info;

    @BindView(R.id.tv_switcher_name)
    TextView tv_switcher_name;

    @BindView(R.id.tv_temperature_number)
    TextView tv_temperature_number;

    @BindView(R.id.tv_title)
    TextView tv_title;

    public enum MainBackgroundState implements Serializable {
        NORMAL,
        CONNECTED,
        LOW_BATTERY,
        DISCONNECTED,
        PERMISSION,
        CONNECTED_LINKER_THING,
        CONNECTED_MANUAL_REMOCON,
        CONNECTED_CHECKER,
        CONNECTED_REMOCON_AIRCON,
        CONNECTED_REMOCON_SETTOP
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainView
    public void changeLinkerInfoIC() {
    }

    @Override // kr.switcher.switcherm.common.activity.IOActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        MainPresenter mainPresenter = new MainPresenter(this, this, new GetCurrentSensorValueInteractor(this));
        this.presenter = mainPresenter;
        MainScreenController.initialize(this, mainPresenter);
        this.presenter.initialize();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.presenter.onResume(IODeviceHandler.getInstance().getDevice(this.switcherMacAddress));
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.presenter.onActivityResult(i, i2, intent);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.presenter.onPause(SwitcherHandler.getInstance().getSwitcher(this.switcherMacAddress));
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.presenter.onDestroy();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        this.presenter.onBackPressed();
    }

    @Override // android.app.Activity, kr.switcher.switcherm.ui.main.views.MainView
    public void finish() {
        super.finish();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        this.presenter.onRequestPermissionsResult(i, strArr, iArr);
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainView
    public void setSwitcherMacAddress(String str) {
        this.switcherMacAddress = str;
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainView
    public void setTimerSizeForSignal() {
        ReservationSignal.setTimerSize(SwitcherHandler.getInstance().getAllSwitcherReservationSize());
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainView
    public void showProgressbar() {
        this.pb_searching.setVisibility(0);
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainView
    public void hideProgressbar() {
        this.pb_searching.setVisibility(8);
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainView
    public void callSwitcherListActivity() {
        runOnUiThread(new Runnable() { // from class: kr.switcher.switcherm.ui.main.MainActivity.1
            @Override // java.lang.Runnable
            public void run() {
                MainActivity.this.startActivityForResult(new Intent(MainActivity.this.getApplicationContext(), (Class<?>) SwitcherListActivity.class), 1);
                MainActivity.this.overridePendingTransition(R.anim.activity_in, R.anim.activity_holding);
            }
        });
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainView
    public void moveMainDefaultScreen() {
        MainScreenController.moveMainScreen(MainScreenController.MainScreen.DEFAULT, new Intent());
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainView
    public void moveMainConnectingScreen(Intent intent) {
        MainScreenController.moveMainScreen(MainScreenController.MainScreen.CONNECTING, intent);
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainView
    public void moveMainDisconnectScreen(Intent intent) {
        MainScreenController.moveMainScreen(MainScreenController.MainScreen.DISCONNECTED, intent);
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainView
    public void moveMainBLEPermissionReqScreen() {
        MainScreenController.moveMainScreen(MainScreenController.MainScreen.PERMISSION, new Intent());
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainView
    public void moveSettingScreen(String str) {
        if (IOUtil.checkIsIODeviceKey(this.switcherMacAddress)) {
            Intent intent = new Intent(this, (Class<?>) SettingActivity.class);
            intent.putExtra("CONNECTED_MAC_ADDRESS", this.switcherMacAddress);
            intent.putExtra(SettingActivity.PARM_NEXT_FRAGMENT, str);
            startActivity(intent);
        }
    }

    @OnClick({R.id.btn_move_scan_list_menu})
    public void onMoveScanListMenuButtonClicked() {
        callSwitcherListActivity();
    }

    @OnClick({R.id.btn_switcher_info_menu})
    public void onMoveSwitcherInfoMenuButtonClicked() {
        if (!IOUtil.checkIsIODeviceKey(this.switcherMacAddress)) {
            IOUtil.showToast(IOUtil.getStringResource(R.string.etc_error));
            return;
        }
        Intent intent = new Intent(this, (Class<?>) SwitcherInfoActivity.class);
        intent.putExtra("CONNECTED_MAC_ADDRESS", this.switcherMacAddress);
        startActivityForResult(intent, 0);
    }

    @OnClick({R.id.btn_my_page_menu})
    public void onMoveMyPageMenuButtonClicked() {
        startActivity(new Intent(this, (Class<?>) MypageActivity.class));
    }

    @OnClick({R.id.btn_chart_menu})
    public void onMoveChartMenuButtonClicked() {
        Intent intent = new Intent(getApplicationContext(), (Class<?>) IRBrandGraphActivity.class);
        if (LinkerHandler.getInstance().getAliveLinkers().size() > 0) {
            intent.putExtra(IRBrandGraphActivity.INTENT_PARM_LINKER_MAC_ADDRESS, LinkerHandler.getInstance().getAliveLinkers().get(0).getMacAddress());
        }
        intent.putExtra(IRBrandGraphActivity.INTENT_PARM_CONNECTED_DEVICE_MAC_ADDRESS, this.switcherMacAddress);
        startActivity(intent);
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainView
    public void setTitle(String str) {
        this.tv_title.setText(str);
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainView
    public void setSwitcherIcon(Drawable drawable) {
        this.iv_switcher_icon.setImageDrawable(drawable);
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainView
    public void setInfoIcon(Drawable drawable) {
        this.iv_switcher_info_menu.setImageDrawable(drawable);
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainView
    public void setRemoconComponentRatio() {
        this.lin_top.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 140.0f));
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainView
    public void setNormalComponentRatio() {
        this.lin_top.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 192.0f));
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainView
    public void showCurrentTemperature() {
        this.rl_current_temperature.setVisibility(0);
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainView
    public void hideCurrentTemperature() {
        this.rl_current_temperature.setVisibility(8);
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainView
    public void setSwitcherName(String str) {
        this.tv_switcher_name.setText(str);
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainView
    public void setInfo(String str) {
        this.tv_info.setText(str);
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainView
    public void setNormalTransitionView() {
        this.lin_top.setBackground(new TransitionDrawable(new Drawable[]{IOUtil.getDrawable(R.drawable.disconnected_bg), IOUtil.getDrawable(R.drawable.connected_bg)}));
        ((TransitionDrawable) this.lin_top.getBackground()).startTransition(600);
        this.iv_battery_warning.setVisibility(8);
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainView
    public void setLowBatteryTransitionView() {
        this.lin_top.setBackground(new TransitionDrawable(new Drawable[]{IOUtil.getDrawable(R.drawable.disconnected_bg), IOUtil.getDrawable(R.drawable.low_battery_bg)}));
        ((TransitionDrawable) this.lin_top.getBackground()).startTransition(600);
        this.iv_battery_warning.setVisibility(0);
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainView
    public void reverseTransition() {
        ((TransitionDrawable) this.lin_top.getBackground()).reverseTransition(600);
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainView
    public void resetTransition() {
        ((TransitionDrawable) this.lin_top.getBackground()).resetTransition();
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainView
    public void showMenuForDefaultScreen() {
        this.btn_scan_list_menu.setVisibility(0);
        this.btn_switcher_info_menu.setVisibility(8);
        this.btn_my_page_menu.setVisibility(8);
        this.btn_chart_menu.setVisibility(8);
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainView
    public void showMenuForConnectScreen() {
        this.btn_scan_list_menu.setVisibility(0);
        this.btn_switcher_info_menu.setVisibility(0);
        this.btn_my_page_menu.setVisibility(8);
        this.btn_chart_menu.setVisibility(8);
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainView
    public void showMenuForPermissionScreen() {
        this.btn_scan_list_menu.setVisibility(8);
        this.btn_switcher_info_menu.setVisibility(8);
        this.btn_my_page_menu.setVisibility(0);
        this.btn_chart_menu.setVisibility(8);
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainView
    public void showMenuForLinkerThingConnectionScreen() {
        this.btn_scan_list_menu.setVisibility(0);
        this.btn_switcher_info_menu.setVisibility(0);
        this.btn_my_page_menu.setVisibility(8);
        this.btn_chart_menu.setVisibility(0);
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainView
    public void showMenuForManualRemoconConnectionScreen() {
        this.btn_scan_list_menu.setVisibility(0);
        this.btn_switcher_info_menu.setVisibility(0);
        this.btn_my_page_menu.setVisibility(8);
        this.btn_chart_menu.setVisibility(8);
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainView
    public void showMenuForManualCheckerConnectionScreen() {
        this.btn_scan_list_menu.setVisibility(0);
        this.btn_switcher_info_menu.setVisibility(0);
        this.btn_my_page_menu.setVisibility(8);
        this.btn_chart_menu.setVisibility(8);
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainView
    public void showMenuForAirconRemoconConnectionScreen() {
        this.btn_scan_list_menu.setVisibility(0);
        this.btn_switcher_info_menu.setVisibility(0);
        this.btn_my_page_menu.setVisibility(8);
        this.btn_chart_menu.setVisibility(0);
        this.rl_current_temperature.setVisibility(0);
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainView
    public void showMenuForTVRemoconConnectionScreen() {
        this.btn_scan_list_menu.setVisibility(0);
        this.btn_switcher_info_menu.setVisibility(0);
        this.btn_my_page_menu.setVisibility(8);
        this.btn_chart_menu.setVisibility(0);
        this.rl_current_temperature.setVisibility(8);
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainView
    public void disconnectSwitcher() {
        Switcher switcher = SwitcherHandler.getInstance().getSwitcher(this.switcherMacAddress);
        if (switcher != null) {
            switcher.disconnect();
        }
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainView
    public void disconnectAllSwitcher() {
        SwitcherHandler.getInstance().disconnectAll();
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainView
    public void changeCheckerInfoIC() {
        this.btn_switcher_info_menu.setBackground(IOUtil.getDrawable(R.drawable.btn_checker_info));
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainView
    public void sendBroadcastToOneButtonWidget() {
        IOUtil.sendBroadcastToOneButtonWidget();
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainView
    public void sendBroadcastToTwoButtonWidget() {
        IOUtil.sendBroadcastToTwoButtonWidget();
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainView
    public void sendBroadcastToAirconWidget() {
        IOUtil.sendBroadcastToAirconWidget();
    }

    @Override // kr.switcher.switcherm.ui.main.interactors.GetCurrentSensorValueInteractor.OnGetCurrentSensorValueListener
    public void onFind(LatestSensorValue latestSensorValue) {
        this.tv_temperature_number.setText(latestSensorValue.temperature.substring(0, 4));
    }
}
