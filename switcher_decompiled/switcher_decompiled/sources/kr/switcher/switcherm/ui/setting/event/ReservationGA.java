package kr.switcher.switcherm.ui.setting.event;

import kotlinx.coroutines.DebugKt;
import kr.switcher.switcherm.common.ga.GALogger;
import kr.switcher.switcherm.common.util.IOLog;

/* JADX INFO: loaded from: classes2.dex */
public class ReservationGA {
    private final String ON = DebugKt.DEBUG_PROPERTY_VALUE_ON;
    private final String OFF = DebugKt.DEBUG_PROPERTY_VALUE_OFF;

    private String getOnOff(boolean z) {
        return z ? DebugKt.DEBUG_PROPERTY_VALUE_ON : DebugKt.DEBUG_PROPERTY_VALUE_OFF;
    }

    public void setGAActivateAlarm(boolean z, boolean z2) {
        if (z) {
            IOLog.event(GALogger.CATEGORY_AUTOMATION, GALogger.ACTION_ACTIVATE_ALARM, getOnOff(z2));
        } else {
            IOLog.event(GALogger.CATEGORY_AUTOMATION, GALogger.ACTION_DEACTIVATE_ALARM, getOnOff(z2));
        }
    }

    public void setGADeleteAlarm(boolean z) {
        IOLog.event(GALogger.CATEGORY_AUTOMATION, GALogger.ACTION_DELETE_ALARM, getOnOff(z));
    }

    public void setGAEditAlarm(boolean z) {
        IOLog.event(GALogger.CATEGORY_AUTOMATION, GALogger.ACTION_EDIT_ALARM, getOnOff(z));
    }

    public void setGACreateAlarm(boolean z) {
        IOLog.event(GALogger.CATEGORY_AUTOMATION, GALogger.ACTION_CREATE_ALARM, getOnOff(z));
    }
}
