package kr.switcher.switcherm.service.view;

import kr.switcher.device.IODevice;
import kr.switcher.device.checker.Checker;
import kr.switcher.device.remocon.Remocon;
import kr.switcher.device.switcher.Switcher;

/* JADX INFO: loaded from: classes2.dex */
public interface WidgetServiceView {
    void checkerRefresh(Checker checker, int i);

    void connect();

    void controlLinker(Remocon remocon);

    void controlSwitch();

    void disconnect();

    void foundRemoconInfo(Remocon remocon, int i);

    void foundSwitcherInfo(Switcher switcher, int i);

    void onScreenOff();

    void onScreenOn();

    void refreshAirconWidget(Remocon remocon, int i);

    void remoconConnect();

    void sendBroadcastToAirconWidget();

    void sendBroadcastToOneButtonWidget();

    void sendBroadcastToSettopWidget();

    void sendBroadcastToTwoButtonWidget();

    void sendMessage(String str);

    void setLinkerToWidgetAirconService(IODevice iODevice);

    void setSwitcherToWidgetSwitchService(Switcher switcher);

    void updateTemperature(Remocon remocon, int i);
}
