package kr.switcher.switcherm.device.switcher.handler;

import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kr.switcher.device.IODevice;
import kr.switcher.device.common.DeviceUtil;
import kr.switcher.device.switcher.Switcher;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.database.DBIODevice;
import kr.switcher.switcherm.database.DBIODeviceDAO;
import kr.switcher.switcherm.database.DBPricingModel;
import kr.switcher.switcherm.database.DBPricingModelDAO;
import kr.switcher.switcherm.database.DBReservation;
import kr.switcher.switcherm.database.DBReservationDAO;
import kr.switcher.switcherm.device.switcher.handler.helper.ReservationMap;
import kr.switcher.switcherm.preference.OAuthToken;
import kr.switcher.switcherm.user.UserStateManager;

/* JADX INFO: loaded from: classes2.dex */
public class SwitcherDBProvider {
    private static final String TAG = "SwitcherDBProvider";

    public int setSwitcherInfoToDB(Switcher switcher) {
        DBIODeviceDAO dBIODeviceDAO = new DBIODeviceDAO();
        dBIODeviceDAO.open();
        DBIODevice dBIODeviceInsertOrUpdate = dBIODeviceDAO.insertOrUpdate(switcher.getMacAddress(), switcher.getSerialNumber(), switcher.getName(), switcher.getShareCode(), DeviceUtil.convertSwitcherType(switcher.getProductId()), switcher.getOwner(), switcher.isMine());
        if (IOUtil.checkIsIODeviceKey(switcher.getMacAddress()) && dBIODeviceInsertOrUpdate == null) {
            IOLog.e(TAG, "failed insert(or update) switcher (macaddress:" + switcher.getMacAddress() + ")", new NullPointerException());
            dBIODeviceDAO.close();
            return 401;
        }
        dBIODeviceDAO.close();
        return 1;
    }

    public Switcher getSwitcherInfoFromDB(String str) {
        DBIODeviceDAO dBIODeviceDAO = new DBIODeviceDAO();
        dBIODeviceDAO.open();
        DBIODevice data = dBIODeviceDAO.getData(str);
        dBIODeviceDAO.close();
        Switcher switcher = (Switcher) SwitcherUtil.convertDbIODeviceToIODevice(data);
        if (switcher != null) {
            updateSwitcherNameToDB(switcher, data.getName());
        }
        return switcher;
    }

    public List<Switcher> getSwitcherAll() {
        ArrayList arrayList = new ArrayList();
        DBIODeviceDAO dBIODeviceDAO = new DBIODeviceDAO();
        dBIODeviceDAO.open();
        List<DBIODevice> datas = dBIODeviceDAO.getDatas(IODevice.ProductId.SWITCHER_TYPE_ONE);
        datas.addAll(dBIODeviceDAO.getDatas(IODevice.ProductId.SWITCHER_TYPE_TWO));
        dBIODeviceDAO.close();
        Iterator<DBIODevice> it = datas.iterator();
        while (it.hasNext()) {
            arrayList.add((Switcher) SwitcherUtil.convertDbIODeviceToIODevice(it.next()));
        }
        return arrayList;
    }

    public boolean removeSwitcherFromDB(String str) {
        DBIODeviceDAO dBIODeviceDAO = new DBIODeviceDAO();
        dBIODeviceDAO.open();
        boolean zDelete = dBIODeviceDAO.delete(str);
        dBIODeviceDAO.close();
        return zDelete;
    }

    public boolean removeMyDevices() {
        DBIODeviceDAO dBIODeviceDAO = new DBIODeviceDAO();
        dBIODeviceDAO.open();
        boolean zDeleteMyDevices = dBIODeviceDAO.deleteMyDevices();
        dBIODeviceDAO.close();
        return zDeleteMyDevices;
    }

    public int setPricingModels(List<DBPricingModel> list) {
        Iterator<DBPricingModel> it = list.iterator();
        while (it.hasNext()) {
            setPricingModel(it.next());
        }
        return 1;
    }

    public int setPricingModel(DBPricingModel dBPricingModel) {
        DBPricingModelDAO dBPricingModelDAO = new DBPricingModelDAO();
        dBPricingModelDAO.open();
        if (dBPricingModelDAO.insertOrUpdate(dBPricingModel.getCode(), dBPricingModel.getPrice(), dBPricingModel.getPlanName(), dBPricingModel.getPlanInfo()) == null) {
            IOLog.error(TAG, new OAuthToken().getOAuthToken(), "setPricingModel", new Exception("failed update pricing model"));
        }
        dBPricingModelDAO.close();
        return 1;
    }

    public int updateSwitcherTypeToDB(String str, int i) {
        DBIODeviceDAO dBIODeviceDAO = new DBIODeviceDAO();
        dBIODeviceDAO.open();
        if (dBIODeviceDAO.updateType(str, i) == null) {
            return 404;
        }
        dBIODeviceDAO.close();
        return 1;
    }

    public int updateShareCodeToDB(Switcher switcher, String str) {
        if (switcher == null) {
            return 404;
        }
        DBIODeviceDAO dBIODeviceDAO = new DBIODeviceDAO();
        dBIODeviceDAO.open();
        if (dBIODeviceDAO.updateShareCode(switcher.getMacAddress(), str) == null) {
            return 404;
        }
        dBIODeviceDAO.close();
        switcher.setShareCode(str);
        return 1;
    }

    public int updateSwitcherNameToDB(IODevice iODevice, String str) {
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

    public List<Switcher.SwitcherReservation> loadSwitcherReservationList(String str) {
        DBReservationDAO dBReservationDAO = new DBReservationDAO();
        dBReservationDAO.open();
        List<DBReservation> timers = dBReservationDAO.getTimers(str);
        dBReservationDAO.close();
        ArrayList arrayList = new ArrayList();
        if (timers != null) {
            for (Iterator<DBReservation> it = timers.iterator(); it.hasNext(); it = it) {
                DBReservation next = it.next();
                arrayList.add(new Switcher.SwitcherReservation((int) next.getId(), next.getTitle(), next.isMon(), next.isTue(), next.isWed(), next.isThu(), next.isFri(), next.isSat(), next.isSun(), next.getAmPm(), next.getHour(), next.getMin(), next.isLight(), next.getSwitcherTarget(), next.isEnable()));
            }
        }
        return arrayList;
    }

    public List<Switcher.SwitcherReservation> updateSwitcherReservationListToDB(String str, List<Switcher.SwitcherReservation> list) {
        String str2 = str;
        DBReservationDAO dBReservationDAO = new DBReservationDAO();
        dBReservationDAO.open();
        List<DBReservation> timers = dBReservationDAO.getTimers(str2);
        ReservationMap reservationMap = new ReservationMap(timers);
        if (timers != null && timers.size() > 0 && !dBReservationDAO.deleteTimers(str2)) {
            Log.e(TAG, "failed to delete timer");
        }
        for (Switcher.SwitcherReservation switcherReservation : list) {
            String str3 = TAG;
            IOLog.i(str3, "reservation info\nmacaddress:" + str2 + ", id:" + switcherReservation.id + ", title:" + reservationMap.get(switcherReservation) + ", mon:" + switcherReservation.mon + ", tue:" + switcherReservation.tue + ", wed:" + switcherReservation.wed + ", thu:" + switcherReservation.thu + ", fri:" + switcherReservation.fri + ", sat:" + switcherReservation.sat + ", sun:" + switcherReservation.sun + ", ampm:" + switcherReservation.ampm + ", hour:" + switcherReservation.hour + ", min:" + switcherReservation.min + ", light:" + switcherReservation.light + ", target:" + switcherReservation.switcherTarget + ", enable:" + switcherReservation.enable);
            DBReservationDAO dBReservationDAO2 = dBReservationDAO;
            ReservationMap reservationMap2 = reservationMap;
            if (dBReservationDAO2.insertTimer(str, switcherReservation.id, reservationMap.get(switcherReservation), switcherReservation.mon, switcherReservation.tue, switcherReservation.wed, switcherReservation.thu, switcherReservation.fri, switcherReservation.sat, switcherReservation.sun, switcherReservation.ampm, switcherReservation.hour, switcherReservation.min, switcherReservation.light, switcherReservation.switcherTarget, switcherReservation.enable) == null) {
                IOLog.error(str3, new OAuthToken().getOAuthToken(), "updateSwitcherReservationListToDB", new Exception("failed to insert timer"));
            }
            str2 = str;
            reservationMap = reservationMap2;
            dBReservationDAO = dBReservationDAO2;
        }
        String str4 = str2;
        DBReservationDAO dBReservationDAO3 = dBReservationDAO;
        List<DBReservation> timers2 = dBReservationDAO3.getTimers(str4);
        dBReservationDAO3.close();
        return convertDBTimerToSwitcherReservation(timers2);
    }

    public List<Switcher.SwitcherReservation> updateReservationToDB(String str, Switcher.SwitcherReservation switcherReservation) {
        DBReservationDAO dBReservationDAO = new DBReservationDAO();
        dBReservationDAO.open();
        if (dBReservationDAO.insertTimer(str, switcherReservation.id, switcherReservation.title, switcherReservation.mon, switcherReservation.tue, switcherReservation.wed, switcherReservation.thu, switcherReservation.fri, switcherReservation.sat, switcherReservation.sun, switcherReservation.ampm, switcherReservation.hour, switcherReservation.min, switcherReservation.light, switcherReservation.switcherTarget, switcherReservation.enable) == null) {
            IOLog.error(TAG, new OAuthToken().getOAuthToken(), "updateReservationToDB", new Exception(IOUtil.getStringResource(R.string.failed_update_db_timer_message)));
            return null;
        }
        List<DBReservation> timers = dBReservationDAO.getTimers(str);
        dBReservationDAO.close();
        return convertDBTimerToSwitcherReservation(timers);
    }

    public List<Switcher.SwitcherReservation> deleteReservationToDB(String str, int i) {
        DBReservationDAO dBReservationDAO = new DBReservationDAO();
        dBReservationDAO.open();
        if (!dBReservationDAO.deleteTimer(str, i)) {
            IOLog.error(TAG, new OAuthToken().getOAuthToken(), "deleteReservationToDB", new Exception(IOUtil.getStringResource(R.string.failed_remove_db_timer_message)));
            return null;
        }
        List<DBReservation> timers = dBReservationDAO.getTimers(str);
        dBReservationDAO.close();
        return convertDBTimerToSwitcherReservation(timers);
    }

    public List<Switcher.SwitcherReservation> convertDBTimerToSwitcherReservation(List<DBReservation> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (list.size() > 0) {
            for (Iterator<DBReservation> it = list.iterator(); it.hasNext(); it = it) {
                DBReservation next = it.next();
                arrayList.add(new Switcher.SwitcherReservation((int) next.getId(), next.getTitle(), next.isMon(), next.isTue(), next.isWed(), next.isThu(), next.isFri(), next.isSat(), next.isSun(), next.getAmPm(), next.getHour(), next.getMin(), next.isLight(), next.getSwitcherTarget(), next.isEnable()));
            }
        }
        return arrayList;
    }

    public void cleanSwitcher(List<String> list) {
        DBIODeviceDAO dBIODeviceDAO = new DBIODeviceDAO();
        dBIODeviceDAO.open();
        Iterator<String> it = getSwitcherAddressToRemove(getMyAddressListByDBSwitcherList(dBIODeviceDAO.getDatas()), list).iterator();
        while (it.hasNext()) {
            dBIODeviceDAO.delete(it.next());
        }
        dBIODeviceDAO.close();
    }

    private List<String> getMyAddressListByDBSwitcherList(List<DBIODevice> list) {
        ArrayList arrayList = new ArrayList();
        for (DBIODevice dBIODevice : list) {
            if (dBIODevice.getOwner() != null && dBIODevice.getOwner().equalsIgnoreCase(UserStateManager.getInstance().getCurrentUserFromDB().getUserName())) {
                arrayList.add(dBIODevice.getMacAddress());
            }
        }
        return arrayList;
    }

    public List<String> getSwitcherAddressToRemove(List<String> list, List<String> list2) {
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            boolean z = false;
            Iterator<String> it = list2.iterator();
            while (it.hasNext()) {
                if (str.equals(it.next())) {
                    z = true;
                }
            }
            if (!z) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    public int getLastBattery(String str) {
        DBIODeviceDAO dBIODeviceDAO = new DBIODeviceDAO();
        dBIODeviceDAO.open();
        DBIODevice data = dBIODeviceDAO.getData(str);
        dBIODeviceDAO.close();
        return data.getBattery();
    }

    public void setLastBattery(String str, int i) {
        DBIODeviceDAO dBIODeviceDAO = new DBIODeviceDAO();
        dBIODeviceDAO.open();
        dBIODeviceDAO.updateBattery(str, i);
        dBIODeviceDAO.close();
    }

    public String getSwitcherName(Switcher switcher) {
        Switcher switcherInfoFromDB = getSwitcherInfoFromDB(switcher.getMacAddress());
        if (switcherInfoFromDB != null) {
            return switcherInfoFromDB.getName();
        }
        return DeviceUtil.getDefaultDeviceName(switcher);
    }

    public List<IODevice> getShareSwitchers() {
        DBIODeviceDAO dBIODeviceDAO = new DBIODeviceDAO();
        dBIODeviceDAO.open();
        List<DBIODevice> datas = dBIODeviceDAO.getDatas();
        dBIODeviceDAO.close();
        ArrayList arrayList = new ArrayList();
        for (DBIODevice dBIODevice : datas) {
            if (dBIODevice.isMine() == 0) {
                arrayList.add(SwitcherUtil.convertDbIODeviceToIODevice(dBIODevice));
            }
        }
        return arrayList;
    }

    public List<IODevice> getMyDevices() {
        IODevice iODeviceConvertDbIODeviceToIODevice;
        DBIODeviceDAO dBIODeviceDAO = new DBIODeviceDAO();
        dBIODeviceDAO.open();
        List<DBIODevice> datas = dBIODeviceDAO.getDatas();
        dBIODeviceDAO.close();
        ArrayList arrayList = new ArrayList();
        for (DBIODevice dBIODevice : datas) {
            if (dBIODevice.isMine() == 1 && (iODeviceConvertDbIODeviceToIODevice = SwitcherUtil.convertDbIODeviceToIODevice(dBIODevice)) != null) {
                arrayList.add(iODeviceConvertDbIODeviceToIODevice);
            }
        }
        return arrayList;
    }
}
