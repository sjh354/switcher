package kr.switcher.device.switcher;

import java.util.Iterator;
import kr.switcher.device.common.DeviceUtil;
import kr.switcher.device.switcher.Switcher;

/* JADX INFO: loaded from: classes2.dex */
public class ConnectionChecker {
    private static int countOfFailingConnection;

    public boolean checkConnection(Switcher switcher) {
        if (!checkPhysicalConnection(switcher.getMacAddress())) {
            countOfFailingConnection++;
            return false;
        }
        return checkOnlySwitcherConnection(switcher);
    }

    public boolean checkOnlySwitcherConnection(Switcher switcher) {
        if (switcher.getConnectionState().equals(Switcher.ConnectionState.CONNECTED)) {
            setCountOfFailingConnectionZero();
            return true;
        }
        countOfFailingConnection++;
        return false;
    }

    public boolean checkPhysicalConnection(String str) {
        Iterator<String> it = DeviceUtil.getConnectedDeviceAddress().iterator();
        while (it.hasNext()) {
            if (it.next().equals(str)) {
                return true;
            }
        }
        return false;
    }

    public void setCountOfFailingConnectionZero() {
        countOfFailingConnection = 0;
    }

    public int getCountOfFailingConnection() {
        return countOfFailingConnection;
    }
}
