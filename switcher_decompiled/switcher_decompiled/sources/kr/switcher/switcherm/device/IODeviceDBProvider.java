package kr.switcher.switcherm.device;

import android.util.Log;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kr.switcher.device.IODevice;
import kr.switcher.device.checker.Checker;
import kr.switcher.device.common.DeviceUtil;
import kr.switcher.device.linker.Linker;
import kr.switcher.device.remocon.Remocon;
import kr.switcher.device.switcher.Switcher;
import kr.switcher.device.switcher.ble.SwitcherBLE;
import kr.switcher.device.switcher.linker.SwitcherLinker;
import kr.switcher.switcherm.database.DBIODeviceDAO;
import kr.switcher.switcherm.device.checker.CheckerDBProvider;
import kr.switcher.switcherm.device.linker.LinkerDBProvider;
import kr.switcher.switcherm.device.switcher.handler.SwitcherDBProvider;

/* JADX INFO: loaded from: classes2.dex */
public class IODeviceDBProvider {
    private static final String TAG = "IODeviceDBProvider";
    private SwitcherDBProvider switcherDBProvider = new SwitcherDBProvider();
    private LinkerDBProvider linkerDBProvider = new LinkerDBProvider();
    private CheckerDBProvider checkerDBProvider = new CheckerDBProvider();

    public List<IODevice> getIODeviceAll() {
        ArrayList arrayList = new ArrayList();
        List<Switcher> switcherAll = this.switcherDBProvider.getSwitcherAll();
        List<Linker> linkerAll = this.linkerDBProvider.getLinkerAll();
        List<Remocon> remoconAll = this.linkerDBProvider.getRemoconAll();
        List<Checker> checkerAll = this.checkerDBProvider.getCheckerAll();
        arrayList.addAll(switcherAll);
        arrayList.addAll(linkerAll);
        arrayList.addAll(remoconAll);
        arrayList.addAll(checkerAll);
        return arrayList;
    }

    public String getSwitcherName(Switcher switcher) {
        return this.switcherDBProvider.getSwitcherName(switcher);
    }

    public void setLinker(Linker linker) {
        this.linkerDBProvider.setLinkers(Arrays.asList(linker));
    }

    public List<IODevice> getShareDevices() {
        return this.switcherDBProvider.getShareSwitchers();
    }

    public void removeDevice(IODevice iODevice) {
        if (iODevice.getClass().equals(SwitcherBLE.class) || iODevice.getClass().equals(SwitcherLinker.class)) {
            this.switcherDBProvider.removeSwitcherFromDB(iODevice.getMacAddress());
        }
    }

    public void removeRemocon(IODevice iODevice) {
        List<IODevice> myDevices = this.switcherDBProvider.getMyDevices();
        List<Remocon> remoconAll = this.linkerDBProvider.getRemoconAll();
        Iterator<IODevice> it = myDevices.iterator();
        while (it.hasNext()) {
            Log.d(TAG, "Local DB Switcher DB ioDevice : " + it.next().getName());
        }
        Iterator<Remocon> it2 = remoconAll.iterator();
        while (it2.hasNext()) {
            Log.d(TAG, "Local DB Linker DB ioDevice : " + it2.next().getName());
        }
        this.switcherDBProvider.removeSwitcherFromDB(iODevice.getMacAddress());
        this.linkerDBProvider.removeRemocon(iODevice);
    }

    public void removeUnusedDevices(List<IODevice> list) {
        ArrayList<IODevice> arrayList = new ArrayList();
        for (IODevice iODevice : this.switcherDBProvider.getMyDevices()) {
            arrayList.add(iODevice);
            Iterator<IODevice> it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (iODevice.getMacAddress().equals(it.next().getMacAddress())) {
                        arrayList.remove(iODevice);
                        break;
                    }
                }
            }
        }
        for (IODevice iODevice2 : arrayList) {
            if (!iODevice2.getProductId().equals(IODevice.ProductId.REMOCON)) {
                this.switcherDBProvider.removeSwitcherFromDB(iODevice2.getMacAddress());
            }
        }
    }

    public int updateDeviceNameToDB(IODevice iODevice, String str) {
        if (iODevice == null) {
            return 102;
        }
        if (str.length() < 1) {
            str = DeviceUtil.getDefaultDeviceName(iODevice);
        }
        DBIODeviceDAO dBIODeviceDAO = new DBIODeviceDAO();
        dBIODeviceDAO.open();
        if (dBIODeviceDAO.updateName(iODevice.getMacAddress(), str) == null) {
            return 405;
        }
        dBIODeviceDAO.close();
        iODevice.setName(str);
        return 1;
    }
}
