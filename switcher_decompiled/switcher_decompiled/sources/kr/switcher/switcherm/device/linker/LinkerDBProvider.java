package kr.switcher.switcherm.device.linker;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kr.switcher.device.IODevice;
import kr.switcher.device.common.DeviceUtil;
import kr.switcher.device.linker.Linker;
import kr.switcher.device.remocon.Remocon;
import kr.switcher.switcherm.database.DBIODevice;
import kr.switcher.switcherm.database.DBIODeviceDAO;

/* JADX INFO: loaded from: classes2.dex */
public class LinkerDBProvider {
    private static String TAG = "LinkerDBProvider";

    public void setLinkers(List<Linker> list) {
        DBIODeviceDAO dBIODeviceDAO = new DBIODeviceDAO();
        dBIODeviceDAO.open();
        for (Linker linker : list) {
            dBIODeviceDAO.insertOrUpdate(linker.getMacAddress(), linker.getSerialNumber(), linker.getName(), linker.getShareCode(), DeviceUtil.convertSwitcherType(IODevice.ProductId.LINKER), linker.getOwner(), true);
        }
        dBIODeviceDAO.close();
    }

    public List<Linker> getLinkerAll() {
        ArrayList arrayList = new ArrayList();
        DBIODeviceDAO dBIODeviceDAO = new DBIODeviceDAO();
        dBIODeviceDAO.open();
        List<DBIODevice> datas = dBIODeviceDAO.getDatas(IODevice.ProductId.LINKER);
        dBIODeviceDAO.close();
        Iterator<DBIODevice> it = datas.iterator();
        while (it.hasNext()) {
            arrayList.add(new Linker(it.next().getMacAddress()));
        }
        return arrayList;
    }

    public void setRemocons(List<Remocon> list) {
        DBIODeviceDAO dBIODeviceDAO = new DBIODeviceDAO();
        dBIODeviceDAO.open();
        dBIODeviceDAO.getDatas(IODevice.ProductId.REMOCON);
        dBIODeviceDAO.deleteRemocons();
        for (Remocon remocon : list) {
            dBIODeviceDAO.insertOrUpdate(remocon.getMacAddress(), remocon.getSerialNumber(), remocon.getName(), remocon.getShareCode(), DeviceUtil.convertSwitcherType(IODevice.ProductId.REMOCON), remocon.getOwner(), true);
        }
        dBIODeviceDAO.close();
    }

    public List<Remocon> getRemoconAll() {
        ArrayList arrayList = new ArrayList();
        DBIODeviceDAO dBIODeviceDAO = new DBIODeviceDAO();
        dBIODeviceDAO.open();
        List<DBIODevice> datas = dBIODeviceDAO.getDatas(IODevice.ProductId.REMOCON);
        dBIODeviceDAO.close();
        for (DBIODevice dBIODevice : datas) {
            arrayList.add(new Remocon(dBIODevice.getMacAddress(), dBIODevice.getName()));
        }
        return arrayList;
    }

    public boolean removeRemocon(IODevice iODevice) {
        DBIODeviceDAO dBIODeviceDAO = new DBIODeviceDAO();
        dBIODeviceDAO.open();
        boolean zDelete = dBIODeviceDAO.delete(iODevice.getMacAddress());
        dBIODeviceDAO.close();
        return zDelete;
    }
}
