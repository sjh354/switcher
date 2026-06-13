package kr.switcher.switcherm.device.checker;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kr.switcher.device.IODevice;
import kr.switcher.device.checker.Checker;
import kr.switcher.device.common.DeviceUtil;
import kr.switcher.switcherm.database.DBIODevice;
import kr.switcher.switcherm.database.DBIODeviceDAO;
import kr.switcher.switcherm.device.switcher.handler.SwitcherUtil;

/* JADX INFO: loaded from: classes2.dex */
public class CheckerDBProvider {
    public void setCheckers(List<Checker> list) {
        DBIODeviceDAO dBIODeviceDAO = new DBIODeviceDAO();
        dBIODeviceDAO.open();
        for (Checker checker : list) {
            dBIODeviceDAO.insertOrUpdate(checker.getMacAddress(), checker.getSerialNumber(), checker.getName(), checker.getShareCode(), DeviceUtil.convertSwitcherType(IODevice.ProductId.CHECKER), checker.getOwner(), true);
        }
        dBIODeviceDAO.close();
    }

    public List<Checker> getCheckerAll() {
        ArrayList arrayList = new ArrayList();
        DBIODeviceDAO dBIODeviceDAO = new DBIODeviceDAO();
        dBIODeviceDAO.open();
        List<DBIODevice> datas = dBIODeviceDAO.getDatas(IODevice.ProductId.CHECKER);
        dBIODeviceDAO.close();
        Iterator<DBIODevice> it = datas.iterator();
        while (it.hasNext()) {
            arrayList.add((Checker) SwitcherUtil.convertDbIODeviceToIODevice(it.next()));
        }
        return arrayList;
    }
}
