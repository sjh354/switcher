package kr.switcher.switcherm.ui.switcherList.views;

import android.os.Parcelable;
import java.util.List;
import kr.switcher.device.IODevice;
import kr.switcher.device.checker.ScannedCheckerGroup;
import kr.switcher.device.linker.ScannedLinkerGroup;
import kr.switcher.switcherm.ui.switcherList.adapter.IODeviceItem;

/* JADX INFO: loaded from: classes2.dex */
public interface SwitcherListView {
    void exit();

    void finish();

    void finishRefreshing();

    void getMyDevice(IODevice iODevice);

    void hideCardButton();

    void hideNoDeviceFound();

    void hideRemoconAddButton();

    void initRecyclerListView();

    void moveCheckerConnectActivity(int i, ScannedCheckerGroup scannedCheckerGroup);

    void moveLinkerConnectActivity(int i, ScannedLinkerGroup scannedLinkerGroup);

    void moveMainActivity(int i, Parcelable parcelable);

    void moveMainActivity(IODeviceItem iODeviceItem, Parcelable parcelable);

    void moveMainThingView(int i);

    void moveRemoconAddScreen();

    void moveSwitcherInfoActivity(String str, int i);

    void moveTroubleshootingScreen();

    void overridePendingTransition();

    void setRefresh();

    void setSwitcherItems(List<IODeviceItem> list);

    void showCardButton();

    void showCardChangeDialog();

    void showLookingForSwitcher();

    void showMessage(String str);

    void showNoCardDataIcon();

    void showNoDeviceFound();

    void showNormalCardDataIcon();

    void showRemoconAddButton();

    void trackScanFailForGA();

    void trackSwitcherListForGA();
}
