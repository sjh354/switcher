package kr.switcher.switcherm.ui.main.views;

import java.util.List;
import kr.switcher.device.IODevice;
import kr.switcher.switcherm.ui.main.MainActivity;
import kr.switcher.switcherm.ui.main.adapter.CommandItem;

/* JADX INFO: loaded from: classes2.dex */
public interface MainConnectedRemoconView {
    void initRecyclerListView();

    void moveIRCommandRegisterScreen();

    void onMainData(String str, IODevice.ProductId productId, String str2, String str3, MainActivity.MainBackgroundState mainBackgroundState);

    void removeItem(String str);

    void setCommandItems(List<CommandItem> list);

    void showInfoDialog(int i);

    void showMessage(String str);

    void showProgressbar();
}
