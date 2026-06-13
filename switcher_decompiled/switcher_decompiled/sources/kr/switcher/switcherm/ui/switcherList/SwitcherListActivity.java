package kr.switcher.switcherm.ui.switcherList;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import java.util.List;
import kr.switcher.device.IODevice;
import kr.switcher.device.checker.ScannedCheckerGroup;
import kr.switcher.device.linker.ScannedLinkerGroup;
import kr.switcher.device.switcher.ble.ScannedSwitcherGroup;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.activity.IOActivity;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.device.IODeviceHandler;
import kr.switcher.switcherm.signal.SignalData;
import kr.switcher.switcherm.ui.dialog.ConfirmCallback;
import kr.switcher.switcherm.ui.dialog.IODialogController;
import kr.switcher.switcherm.ui.irbrand.IRBrandActivity;
import kr.switcher.switcherm.ui.main.MainActivity;
import kr.switcher.switcherm.ui.main.helper.MainScreenController;
import kr.switcher.switcherm.ui.mypage.MypageActivity;
import kr.switcher.switcherm.ui.switcherInfo.SwitcherInfoActivity;
import kr.switcher.switcherm.ui.switcherList.adapter.IODeviceItem;
import kr.switcher.switcherm.ui.switcherList.adapter.SwitcherAdapter;
import kr.switcher.switcherm.ui.switcherList.interactors.GetCreditCardSignalInteractor;
import kr.switcher.switcherm.ui.switcherList.interactors.GetMyCreditCardInteractor;
import kr.switcher.switcherm.ui.switcherList.interactors.ScanSwitcherInteractor;
import kr.switcher.switcherm.ui.switcherList.presenters.SwitcherListPresenter;
import kr.switcher.switcherm.ui.switcherList.views.SwitcherListView;
import kr.switcher.switcherm.ui.troubleshooting.TroubleshootingActivity;
import kr.switcher.switcherm.ui.wifi.WifiActivity;

/* JADX INFO: loaded from: classes2.dex */
public class SwitcherListActivity extends IOActivity implements SwitcherListView, GetMyCreditCardInteractor.OnGetMyCreditCardListener, GetCreditCardSignalInteractor.OnGetCreditCardSignalListener {
    public static final String INTENT_PARM_MAC_ADDRESS = "MAC_ADDRESS";
    public static final String INTENT_PARM_MAC_ADDRESS_FOR_CARD = "MAC_ADDRESS_FOR_CARD";
    public static final String INTENT_PARM_SSID = "SSID";
    public static final String INTENT_PARM_SWITCHER_TO_CONNECT = "SWITCHER_TO_CONNECT";
    private static final String TAG = "SwitcherListActivity";
    private SwitcherAdapter adapter;

    @BindView(R.id.btn_add_remocon)
    View btn_add_remocon;

    @BindView(R.id.btn_mycard)
    ImageView btn_mycard;
    private boolean isNotFound;
    private String macAddressForCardChange;
    private SwitcherListPresenter presenter;

    @BindView(R.id.rl_add_remocon)
    RelativeLayout rl_add_remocon;

    @BindView(R.id.rl_mycard)
    RelativeLayout rl_mycard;

    @BindView(R.id.rl_scanning)
    RelativeLayout rl_scanning;

    @BindView(R.id.rv_switcher_list)
    RecyclerView rv_switcher_list;

    @BindView(R.id.sr_switcher_list)
    SwipeRefreshLayout sr_switcher_list;

    @BindView(R.id.tv_add_remocon)
    TextView tv_add_remocon;

    @Override // kr.switcher.switcherm.common.activity.IOActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_switcher_list);
        ButterKnife.bind(this);
        this.btn_add_remocon.setOnTouchListener(new View.OnTouchListener() { // from class: kr.switcher.switcherm.ui.switcherList.SwitcherListActivity.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    SwitcherListActivity.this.tv_add_remocon.setAlpha(0.5f);
                } else if (action == 1) {
                    SwitcherListActivity.this.tv_add_remocon.setAlpha(1.0f);
                    SwitcherListActivity.this.presenter.onAddRemoconButtonClicked();
                }
                return true;
            }
        });
        this.presenter = new SwitcherListPresenter(this, new ScanSwitcherInteractor(), new GetMyCreditCardInteractor(this), new GetCreditCardSignalInteractor(this));
        this.adapter = new SwitcherAdapter(this.presenter);
        this.sr_switcher_list.setOnRefreshListener(this.presenter);
        this.presenter.initialize();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.presenter.onResume(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.presenter.onPause();
    }

    @Override // android.app.Activity, kr.switcher.switcherm.ui.switcherList.views.SwitcherListView
    public void finish() {
        super.finish();
        this.presenter.finish();
    }

    @Override // kr.switcher.switcherm.ui.switcherList.views.SwitcherListView
    public void overridePendingTransition() {
        overridePendingTransition(R.anim.activity_holding, R.anim.activity_out);
    }

    @Override // kr.switcher.switcherm.ui.switcherList.views.SwitcherListView
    public void setRefresh() {
        this.adapter.removeAll();
        this.sr_switcher_list.setRefreshing(true);
    }

    @Override // kr.switcher.switcherm.ui.switcherList.views.SwitcherListView
    public void initRecyclerListView() {
        this.rv_switcher_list.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        this.rv_switcher_list.setAdapter(this.adapter);
        this.sr_switcher_list.post(this.presenter);
    }

    @Override // kr.switcher.switcherm.ui.switcherList.views.SwitcherListView
    public void finishRefreshing() {
        this.sr_switcher_list.setRefreshing(false);
    }

    @Override // kr.switcher.switcherm.ui.switcherList.views.SwitcherListView
    public void setSwitcherItems(List<IODeviceItem> list) {
        this.adapter.setSwitcherItems(list);
    }

    @Override // kr.switcher.switcherm.ui.switcherList.views.SwitcherListView
    public void showLookingForSwitcher() {
        this.rl_scanning.setVisibility(0);
    }

    @Override // kr.switcher.switcherm.ui.switcherList.views.SwitcherListView
    public void showNoDeviceFound() {
        this.rl_scanning.setVisibility(4);
        this.isNotFound = true;
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: kr.switcher.switcherm.ui.switcherList.SwitcherListActivity.2
            @Override // java.lang.Runnable
            public void run() {
                if (SwitcherListActivity.this.isNotFound) {
                    IODialogController.showSignalTypeDialog(SwitcherListActivity.this, "", new SignalData(99, 0, "혹시 스위처를 찾지 못하고 있나요?", "문제 해결", null, SwitcherListActivity.this.macAddressForCardChange), null);
                }
            }
        }, 3000L);
    }

    @Override // kr.switcher.switcherm.ui.switcherList.views.SwitcherListView
    public void hideNoDeviceFound() {
        this.rl_scanning.setVisibility(4);
        this.isNotFound = false;
    }

    @Override // kr.switcher.switcherm.ui.switcherList.views.SwitcherListView
    public void trackSwitcherListForGA() {
        IOLog.activity(IOUtil.getStringResource(R.string.screen_title_3_0));
    }

    @Override // kr.switcher.switcherm.ui.switcherList.views.SwitcherListView
    public void trackScanFailForGA() {
        IOLog.activity(IOUtil.getStringResource(R.string.screen_title_3_1));
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    @OnClick({R.id.rl_refresh_list})
    public void onRefreshScanListButtonClicked() {
        this.presenter.onRefresh();
    }

    @OnClick({R.id.rl_myinfo})
    public void onMoveMypageMenuButtonClicked() {
        startActivity(new Intent(this, (Class<?>) MypageActivity.class));
    }

    @OnClick({R.id.rl_mycard})
    public void onMoveMyCardMenuButtonClicked() {
        Intent intent = new Intent(this, (Class<?>) SwitcherInfoActivity.class);
        intent.putExtra(INTENT_PARM_MAC_ADDRESS_FOR_CARD, this.macAddressForCardChange);
        startActivity(intent);
    }

    @Override // kr.switcher.switcherm.ui.switcherList.views.SwitcherListView
    public void moveMainActivity(int i, Parcelable parcelable) {
        moveMainActivity(this.adapter.getItem(i), parcelable);
    }

    @Override // kr.switcher.switcherm.ui.switcherList.views.SwitcherListView
    public void moveMainActivity(IODeviceItem iODeviceItem, Parcelable parcelable) {
        Intent intent = new Intent(this, (Class<?>) MainActivity.class);
        if (parcelable.getClass().equals(ScannedSwitcherGroup.class)) {
            intent.putExtra(MainScreenController.INTENT_PARM_SCANNED_DEVICE_TO_CONNECT, ((ScannedSwitcherGroup) parcelable).get(iODeviceItem.getMacAddress()));
        } else if (parcelable.getClass().equals(ScannedLinkerGroup.class)) {
            intent.putExtra(MainScreenController.INTENT_PARM_SCANNED_DEVICE_TO_CONNECT, ((ScannedLinkerGroup) parcelable).get(iODeviceItem.getMacAddress()));
        } else if (parcelable.getClass().equals(ScannedCheckerGroup.class)) {
            intent.putExtra(MainScreenController.INTENT_PARM_SCANNED_DEVICE_TO_CONNECT, ((ScannedCheckerGroup) parcelable).get(iODeviceItem.getMacAddress()));
        }
        intent.putExtra(MainScreenController.INTENT_PARM_MAC_ADDRESS_TO_CONNECT, iODeviceItem.getMacAddress());
        if (iODeviceItem.isConnected()) {
            intent.putExtra("CONNECTED_MAC_ADDRESS", iODeviceItem.getMacAddress());
        }
        setResult(101, intent);
        finish();
    }

    @Override // kr.switcher.switcherm.ui.switcherList.views.SwitcherListView
    public void moveSwitcherInfoActivity(String str, int i) {
        Intent intent = new Intent(this, (Class<?>) SwitcherInfoActivity.class);
        intent.putExtra("CONNECTED_MAC_ADDRESS", str);
        intent.putExtra(SwitcherInfoActivity.PARM_FREE_TRIAL_ID, i);
        startActivity(intent);
    }

    @Override // kr.switcher.switcherm.ui.switcherList.views.SwitcherListView
    public void moveLinkerConnectActivity(int i, ScannedLinkerGroup scannedLinkerGroup) {
        IODeviceItem item = this.adapter.getItem(i);
        Intent intent = new Intent(this, (Class<?>) WifiActivity.class);
        intent.putExtra(MainScreenController.INTENT_PARM_SCANNED_DEVICE_TO_CONNECT, scannedLinkerGroup.get(item.getMacAddress()));
        startActivity(intent);
    }

    @Override // kr.switcher.switcherm.ui.switcherList.views.SwitcherListView
    public void moveCheckerConnectActivity(int i, ScannedCheckerGroup scannedCheckerGroup) {
        IODeviceItem item = this.adapter.getItem(i);
        Intent intent = new Intent(this, (Class<?>) WifiActivity.class);
        intent.putExtra(MainScreenController.INTENT_PARM_SCANNED_DEVICE_TO_CONNECT, scannedCheckerGroup.get(item.getMacAddress()));
        startActivity(intent);
    }

    @Override // kr.switcher.switcherm.ui.switcherList.views.SwitcherListView
    public void hideRemoconAddButton() {
        this.rl_add_remocon.setVisibility(8);
    }

    @Override // kr.switcher.switcherm.ui.switcherList.views.SwitcherListView
    public void showRemoconAddButton() {
        this.rl_add_remocon.setVisibility(0);
    }

    @Override // kr.switcher.switcherm.ui.switcherList.views.SwitcherListView
    public void moveRemoconAddScreen() {
        startActivity(new Intent(this, (Class<?>) IRBrandActivity.class));
    }

    @Override // kr.switcher.switcherm.ui.switcherList.views.SwitcherListView
    public void moveTroubleshootingScreen() {
        Intent intent = new Intent(this, (Class<?>) TroubleshootingActivity.class);
        intent.putExtra(TroubleshootingActivity.AI_FROM, TroubleshootingActivity.FROM_SCANNED_SWITCHER);
        startActivity(intent);
    }

    @Override // kr.switcher.switcherm.ui.switcherList.views.SwitcherListView
    public void moveMainThingView(int i) {
        final IODeviceItem item = this.adapter.getItem(i);
        IODialogController.showConfirmDialog(this, "링커 주변에 '" + IODeviceHandler.getInstance().getDevice(item.getMacAddress()).getSerialNumber() + "' 스위처가 있나요?", new ConfirmCallback() { // from class: kr.switcher.switcherm.ui.switcherList.SwitcherListActivity.3
            @Override // kr.switcher.switcherm.ui.dialog.ConfirmCallback
            public void onConfirmResult(boolean z) {
                SwitcherListActivity.this.presenter.onConfirmResult(z, item);
            }
        });
    }

    @Override // kr.switcher.switcherm.ui.switcherList.views.SwitcherListView
    public void showMessage(String str) {
        IOUtil.showToast(str);
    }

    @Override // kr.switcher.switcherm.ui.switcherList.views.SwitcherListView
    public void showNoCardDataIcon() {
        this.btn_mycard.setBackground(IOUtil.getDrawable(R.drawable.ic_nomycarddata));
    }

    @Override // kr.switcher.switcherm.ui.switcherList.views.SwitcherListView
    public void showNormalCardDataIcon() {
        this.btn_mycard.setBackground(IOUtil.getDrawable(R.drawable.ic_mycard));
    }

    @Override // kr.switcher.switcherm.ui.switcherList.views.SwitcherListView
    public void showCardButton() {
        this.rl_mycard.setVisibility(0);
    }

    @Override // kr.switcher.switcherm.ui.switcherList.views.SwitcherListView
    public void hideCardButton() {
        this.rl_mycard.setVisibility(8);
    }

    @Override // kr.switcher.switcherm.ui.switcherList.views.SwitcherListView
    public void getMyDevice(IODevice iODevice) {
        this.macAddressForCardChange = iODevice.getMacAddress();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        this.presenter.onBackPressed();
    }

    @Override // kr.switcher.switcherm.ui.switcherList.interactors.GetMyCreditCardInteractor.OnGetMyCreditCardListener
    public void onGetCardList(Boolean bool) {
        this.presenter.onGetCardList(bool);
    }

    @Override // kr.switcher.switcherm.ui.switcherList.views.SwitcherListView
    public void showCardChangeDialog() {
        IODialogController.showSignalTypeDialog(this, "", new SignalData(98, 0, "지금 결제 카드 등록하면 1,000원 할인", "카드 등록 하기", null), null);
    }

    @Override // kr.switcher.switcherm.ui.switcherList.views.SwitcherListView
    public void exit() {
        ActivityCompat.finishAffinity(this);
    }

    @Override // kr.switcher.switcherm.ui.switcherList.interactors.GetCreditCardSignalInteractor.OnGetCreditCardSignalListener
    public void onGetCreditCardSignal(boolean z) {
        this.presenter.onGetCreditCardSignal(z);
    }
}
