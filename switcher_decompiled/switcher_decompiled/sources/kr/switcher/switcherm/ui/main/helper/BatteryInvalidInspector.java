package kr.switcher.switcherm.ui.main.helper;

import kr.switcher.switcherm.device.switcher.handler.SwitcherHandler;

/* JADX INFO: loaded from: classes2.dex */
public class BatteryInvalidInspector {
    public static final int CALIBRATION_VALUE = 3;
    private SwitcherHandler handler;

    public BatteryInvalidInspector(SwitcherHandler switcherHandler) {
        this.handler = switcherHandler;
    }

    public int getFixedBatteryValue(String str, int i) {
        if (i < 0 || i > 100) {
            int batteryFromDB = this.handler.getBatteryFromDB(str);
            return batteryFromDB >= 3 ? batteryFromDB - 3 : batteryFromDB;
        }
        this.handler.setBatteryToDB(str, i);
        return i;
    }
}
