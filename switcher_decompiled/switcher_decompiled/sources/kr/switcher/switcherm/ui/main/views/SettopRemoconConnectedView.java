package kr.switcher.switcherm.ui.main.views;

import java.util.List;
import kr.switcher.device.IODevice;
import kr.switcher.device.remocon.IRCommand;
import kr.switcher.switcherm.ui.main.MainActivity;

/* JADX INFO: loaded from: classes2.dex */
public interface SettopRemoconConnectedView {
    String getCommandName(int i);

    void hideProgressbar();

    void hideReservationBadge();

    void hideWidgetBadge();

    void initCommandList();

    void initRecyclerListView();

    void moveIRCommandRegisterScreen();

    void notifyDataSetChanged();

    void onMainData(String str, IODevice.ProductId productId, String str2, String str3, MainActivity.MainBackgroundState mainBackgroundState);

    void onReleaseIR(String str);

    void setCommandList(List<IRCommand> list, List<IRCommand> list2, List<IRCommand> list3);

    void setRemoconCommandItems(List<IRCommand> list);

    void showChannelDialog();

    void showChannelDownButtonDefault();

    void showChannelDownButtonPressed();

    void showChannelDownButtonSpring();

    void showChannelUpButtonDefault();

    void showChannelUpButtonPressed();

    void showChannelUpButtonSpring();

    void showInfoDialog(int i);

    void showProgressbar();

    void showProgressbar(int i);

    void showReservationBadge();

    void showVolumeDownButtonDefault();

    void showVolumeDownButtonSpring();

    void showVolumeDwonButtonPressed();

    void showVolumeUpButtonDefault();

    void showVolumeUpButtonPressed();

    void showVolumeUpButtonSpring();

    void showWidgetBadge();
}
