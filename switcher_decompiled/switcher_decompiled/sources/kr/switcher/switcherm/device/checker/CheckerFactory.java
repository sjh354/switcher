package kr.switcher.switcherm.device.checker;

import kr.switcher.device.checker.Checker;
import kr.switcher.device.common.DeviceUtil;
import kr.switcher.switcherm.database.DBIODevice;
import kr.switcher.switcherm.database.DBIODeviceDAO;
import kr.switcher.switcherm.network.http.response.DeviceAPIResponse;

/* JADX INFO: loaded from: classes2.dex */
public class CheckerFactory {
    public Checker createChecker(String str, String str2, String str3, DeviceAPIResponse.Meta meta) {
        Checker checker = new Checker(str);
        checker.setSerialNumber(str2);
        checker.setOwner(str3);
        if (meta != null) {
            checker.setBatteryLevel(meta.battery_level);
        } else {
            checker.setBatteryLevel("확인중");
        }
        setName(checker);
        return checker;
    }

    private void setName(Checker checker) {
        String defaultDeviceName;
        DBIODeviceDAO dBIODeviceDAO = new DBIODeviceDAO();
        dBIODeviceDAO.open();
        DBIODevice data = dBIODeviceDAO.getData(checker.getMacAddress());
        dBIODeviceDAO.close();
        if (data != null) {
            defaultDeviceName = data.getName();
        } else {
            defaultDeviceName = DeviceUtil.getDefaultDeviceName(checker);
        }
        checker.setName(defaultDeviceName);
    }
}
