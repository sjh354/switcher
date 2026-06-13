package kr.switcher.switcherm.device.switcher;

import kr.switcher.device.IODevice;
import kr.switcher.device.checker.Checker;
import kr.switcher.device.common.DeviceUtil;
import kr.switcher.device.linker.Linker;
import kr.switcher.device.remocon.Remocon;
import kr.switcher.device.switcher.Switcher;
import kr.switcher.device.switcher.ble.SwitcherBLE;
import kr.switcher.switcherm.database.DBIODevice;
import kr.switcher.switcherm.database.DBIODeviceDAO;
import kr.switcher.switcherm.device.switcher.handler.SwitcherDBProvider;

/* JADX INFO: loaded from: classes2.dex */
public class SwitcherFactory {
    private static String TAG = "SwitcherFactory";

    public IODevice createIODevice(IODevice.ProductId productId, String str, String str2, String str3) {
        IODevice switcherBLE;
        if (productId == null) {
            return null;
        }
        if (productId.equals(IODevice.ProductId.SWITCHER_TYPE_ONE) || productId.equals(IODevice.ProductId.SWITCHER_TYPE_TWO)) {
            switcherBLE = new SwitcherBLE(str, productId);
        } else if (productId.equals(IODevice.ProductId.LINKER)) {
            switcherBLE = new Linker(str);
        } else if (productId.equals(IODevice.ProductId.CHECKER)) {
            switcherBLE = new Checker(str);
        } else {
            switcherBLE = productId.equals(IODevice.ProductId.REMOCON) ? new Remocon(str, "") : null;
        }
        if (switcherBLE == null) {
            return null;
        }
        SwitcherDBProvider switcherDBProvider = new SwitcherDBProvider();
        switcherBLE.setSerialNumber(str2);
        switcherBLE.setOwner(str3);
        setName(switcherBLE);
        if (switcherBLE.getProductId().equals(IODevice.ProductId.SWITCHER_TYPE_ONE) || switcherBLE.getProductId().equals(IODevice.ProductId.SWITCHER_TYPE_TWO)) {
            ((Switcher) switcherBLE).setSwitcherReservationList(switcherDBProvider.loadSwitcherReservationList(str));
        }
        return switcherBLE;
    }

    private void setName(IODevice iODevice) {
        String defaultDeviceName;
        DBIODeviceDAO dBIODeviceDAO = new DBIODeviceDAO();
        dBIODeviceDAO.open();
        DBIODevice data = dBIODeviceDAO.getData(iODevice.getMacAddress());
        dBIODeviceDAO.close();
        if (data != null) {
            defaultDeviceName = data.getName();
        } else {
            defaultDeviceName = DeviceUtil.getDefaultDeviceName(iODevice);
        }
        iODevice.setName(defaultDeviceName);
    }
}
