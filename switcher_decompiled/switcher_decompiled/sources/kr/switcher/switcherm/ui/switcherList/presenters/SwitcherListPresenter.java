package kr.switcher.switcherm.ui.switcherList.presenters;

import android.content.Context;
import android.os.Handler;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import java.util.Iterator;
import java.util.List;
import kr.switcher.device.IODevice;
import kr.switcher.device.switcher.ble.ScannedSwitcherGroup;
import kr.switcher.switcherm.device.IODeviceHandler;
import kr.switcher.switcherm.device.linker.LinkerHandler;
import kr.switcher.switcherm.device.switcher.handler.SwitcherUtil;
import kr.switcher.switcherm.preference.AutoBluetoothPreference;
import kr.switcher.switcherm.ui.switcherList.adapter.IODeviceItem;
import kr.switcher.switcherm.ui.switcherList.adapter.SwitcherAdapter;
import kr.switcher.switcherm.ui.switcherList.interactors.GetCreditCardSignalInteractor;
import kr.switcher.switcherm.ui.switcherList.interactors.GetMyCreditCardInteractor;
import kr.switcher.switcherm.ui.switcherList.interactors.ScanSwitcherInteractor;
import kr.switcher.switcherm.ui.switcherList.views.SwitcherListView;
import kr.switcher.switcherm.viewmodel.SwitcherInfoActivityViewModel;

/* JADX INFO: loaded from: classes2.dex */
public class SwitcherListPresenter implements SwipeRefreshLayout.OnRefreshListener, ScanSwitcherInteractor.OnResultScannedSwitcherListener, Runnable, SwitcherAdapter.OnItemClickListener {
    private static final int REFRESH_TIMEOUT = 4000;
    private static final String TAG = "SwitcherListPresenter";
    private GetMyCreditCardInteractor cardInteractor;
    private ScanSwitcherInteractor interactor;
    private GetCreditCardSignalInteractor signalInteractor;
    private SwitcherListView view;

    public SwitcherListPresenter(SwitcherListView switcherListView, ScanSwitcherInteractor scanSwitcherInteractor, GetMyCreditCardInteractor getMyCreditCardInteractor, GetCreditCardSignalInteractor getCreditCardSignalInteractor) {
        this.view = switcherListView;
        this.interactor = scanSwitcherInteractor;
        this.cardInteractor = getMyCreditCardInteractor;
        this.signalInteractor = getCreditCardSignalInteractor;
    }

    public void initialize() {
        this.view.trackSwitcherListForGA();
        this.view.initRecyclerListView();
        this.view.showLookingForSwitcher();
        this.view.hideCardButton();
    }

    public void onResume(Context context) {
        if (new AutoBluetoothPreference().getAutoBluetooth().booleanValue()) {
            SwitcherUtil.activeBluetooth();
        }
        this.interactor.initialize(this);
        findSwitcher();
        this.signalInteractor.getRequestCreditCardSignal();
    }

    public void onPause() {
        this.interactor.stopTimer();
        stopScan();
    }

    private void stopScan() {
        this.interactor.stopScan();
    }

    public void finish() {
        this.view.overridePendingTransition();
    }

    public ScannedSwitcherGroup getScannedSwitcherGroup() {
        return this.interactor.getScannedSwitcherGroup();
    }

    private void findSwitcher() {
        new Handler().post(new Runnable() { // from class: kr.switcher.switcherm.ui.switcherList.presenters.SwitcherListPresenter.1
            @Override // java.lang.Runnable
            public void run() {
                SwitcherListPresenter.this.interactor.findProduction();
                SwitcherListPresenter.this.interactor.findIODevices();
                SwitcherListPresenter.this.interactor.findSwitcherBLE();
            }
        });
        finishToRefresh();
        if (checkCustomerDeviceAmount() > 0) {
            checkCreditCardValidity();
            this.view.showCardButton();
        }
    }

    private void checkCreditCardValidity() {
        this.cardInteractor.getMyCreditCard();
    }

    private int checkCustomerDeviceAmount() {
        List<IODevice> deviceAll = IODeviceHandler.getInstance().getDeviceAll();
        Iterator<IODevice> it = deviceAll.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            IODevice next = it.next();
            if (!String.valueOf(next.getProductId()).equals(SwitcherInfoActivityViewModel.MENU_REMOCON)) {
                this.view.getMyDevice(next);
                break;
            }
        }
        return deviceAll.size();
    }

    public void finishToRefresh() {
        new Handler().postDelayed(new Runnable() { // from class: kr.switcher.switcherm.ui.switcherList.presenters.SwitcherListPresenter.2
            @Override // java.lang.Runnable
            public void run() {
                SwitcherListPresenter.this.view.finishRefreshing();
            }
        }, 4000L);
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
    public void onRefresh() {
        this.view.setRefresh();
        this.view.showLookingForSwitcher();
        stopScan();
        findSwitcher();
    }

    @Override // kr.switcher.switcherm.ui.switcherList.interactors.ScanSwitcherInteractor.OnResultScannedSwitcherListener
    public void onGetScannedSwitcherResult(List<IODeviceItem> list) {
        this.view.setSwitcherItems(list);
        boolean z = false;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isScanned() || list.get(i).isConnected() || list.get(i).isLinked()) {
                z = true;
                break;
            }
        }
        if (z) {
            this.view.hideNoDeviceFound();
        } else {
            this.view.showNoDeviceFound();
            this.view.trackScanFailForGA();
        }
        setLinkerStatus(list);
    }

    private void setLinkerStatus(List<IODeviceItem> list) {
        this.view.hideRemoconAddButton();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getProductId() == IODevice.ProductId.LINKER && list.get(i).isLinked()) {
                this.view.showRemoconAddButton();
            }
        }
    }

    @Override // kr.switcher.switcherm.ui.switcherList.adapter.SwitcherAdapter.OnItemClickListener
    public void onItemClickToConnect(int i) {
        this.view.moveMainActivity(i, this.interactor.getScannedSwitcherGroup());
        this.view.finish();
    }

    @Override // kr.switcher.switcherm.ui.switcherList.adapter.SwitcherAdapter.OnItemClickListener
    public void onItemClickToInfo(String str, int i) {
        this.view.moveSwitcherInfoActivity(str, i);
    }

    @Override // kr.switcher.switcherm.ui.switcherList.adapter.SwitcherAdapter.OnItemClickListener
    public void onItemClickToLinkerWifiSetting(int i) {
        this.view.moveMainActivity(i, this.interactor.getScannedLinkerGroup());
        this.view.finish();
    }

    @Override // kr.switcher.switcherm.ui.switcherList.adapter.SwitcherAdapter.OnItemClickListener
    public void onItemClickToCheckerWifiSetting(int i) {
        this.view.moveMainActivity(i, this.interactor.getScannedCheckerGroup());
        this.view.finish();
    }

    @Override // kr.switcher.switcherm.ui.switcherList.adapter.SwitcherAdapter.OnItemClickListener
    public void onItemClickToMainThing(int i) {
        this.view.moveMainThingView(i);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.view.setRefresh();
        finishToRefresh();
    }

    public void onAddRemoconButtonClicked() {
        this.view.moveRemoconAddScreen();
    }

    public void onTroubleshootingButtonClicked() {
        this.view.moveTroubleshootingScreen();
    }

    public void onConfirmResult(boolean z, final IODeviceItem iODeviceItem) {
        if (z) {
            this.interactor.changeMainThing(iODeviceItem, new ScanSwitcherInteractor.OnMainThingResultListener() { // from class: kr.switcher.switcherm.ui.switcherList.presenters.SwitcherListPresenter.3
                @Override // kr.switcher.switcherm.ui.switcherList.interactors.ScanSwitcherInteractor.OnMainThingResultListener
                public void onResult(boolean z2) {
                    if (z2) {
                        SwitcherListPresenter.this.view.showMessage("링커에 연결할 스위처를 변경하였습니다");
                        SwitcherListPresenter.this.view.moveMainActivity(iODeviceItem, SwitcherListPresenter.this.interactor.getScannedSwitcherGroup());
                    } else {
                        SwitcherListPresenter.this.view.showMessage("변경에 실패했습니다");
                    }
                }
            });
        }
    }

    public void onGetCardList(Boolean bool) {
        if (bool.booleanValue()) {
            this.view.showCardButton();
            this.view.showNoCardDataIcon();
        } else {
            this.view.showNormalCardDataIcon();
        }
    }

    public void onGetCreditCardSignal(boolean z) {
        if (z) {
            return;
        }
        this.view.showCardChangeDialog();
    }

    public void onBackPressed() {
        if (LinkerHandler.getInstance().getAllLinkers().size() == 0) {
            this.view.finish();
        } else {
            this.view.exit();
        }
    }
}
