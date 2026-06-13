package kr.switcher.switcherm.ui.main.views;

import java.util.List;
import kr.switcher.device.IODevice;
import kr.switcher.device.remocon.IRCommand;
import kr.switcher.switcherm.ui.main.MainActivity;

/* JADX INFO: loaded from: classes2.dex */
public interface AirconRemoconConnectedView {
    List<IRCommand> getAirconTemperatureCommandList();

    String getCommandName(int i);

    String getCurrentTemperature(int i);

    void hideMaintenanceBadge();

    void hideProgressbar();

    void hideReservationBadge();

    void hideWidgetBadge();

    void initButton();

    void initCommandList();

    void initRecyclerListView();

    void initWheel();

    void moveIRCommandRegisterScreen();

    void notifyDataSetChanged();

    void onAirVolumeButtonClicked();

    void onCustomButtonClicked();

    void onETCButtonClicked();

    void onMainData(String str, IODevice.ProductId productId, String str2, String str3, MainActivity.MainBackgroundState mainBackgroundState);

    void onModeButtonClicked();

    void setAirVolumeButtonClicked();

    void setAirconOffCommand(IRCommand iRCommand);

    void setAirconOnCommand(IRCommand iRCommand);

    void setCommandList(List<IRCommand> list, List<IRCommand> list2, List<IRCommand> list3, List<IRCommand> list4, List<IRCommand> list5);

    void setCustomButtonClicked();

    void setETCButtonClicked();

    void setModeButtonClicked();

    void setRemoconCommandItems(List<IRCommand> list);

    void showInfoDialog(int i);

    void showMaintenanceBadge();

    void showProgressbar();

    void showProgressbar(int i);

    void showReservationBadge();

    void showWidgetBadge();
}
