package kr.switcher.switcherm.ui.switcherList.helper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kr.switcher.device.IODevice;
import kr.switcher.device.checker.Checker;
import kr.switcher.device.common.DeviceUtil;
import kr.switcher.device.remocon.Remocon;
import kr.switcher.device.switcher.Switcher;
import kr.switcher.device.switcher.ble.ScannedBLESwitcher;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.device.IODeviceHandler;
import kr.switcher.switcherm.device.switcher.handler.SwitcherHandler;
import kr.switcher.switcherm.device.switcher.handler.SwitcherUtil;
import kr.switcher.switcherm.ui.switcherList.adapter.IODeviceItem;
import kr.switcher.switcherm.user.UserStateManager;

/* JADX INFO: loaded from: classes2.dex */
public class SwitcherListItemFactory {
    public static List<IODeviceItem> create(List<ScannedBLESwitcher> list) {
        if (UserStateManager.getInstance().getCurrentUserFromDB() == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        for (ScannedBLESwitcher scannedBLESwitcher : list) {
            arrayList.add(new IODeviceItem(DeviceUtil.convertProductId(scannedBLESwitcher.getAdvertisementPacket().getSwitcherType()), DeviceUtil.getDefaultDeviceName(DeviceUtil.convertProductId(scannedBLESwitcher.getAdvertisementPacket().getSwitcherType())), scannedBLESwitcher.getDevice().getAddress(), scannedBLESwitcher.getAdvertisementPacket().getSerialNumber(), false, true));
        }
        for (IODevice iODevice : IODeviceHandler.getInstance().getMyDeviceAll()) {
            if (iODevice.getThingConnectionStatus().equals(IODevice.ThingConnectionStatus.ALIVE)) {
                arrayList.add(new IODeviceItem(iODevice.getProductId(), DeviceUtil.getDefaultDeviceName(iODevice), iODevice.getMacAddress(), iODevice.getSerialNumber(), false, false, true));
            }
        }
        return new SwitcherListItemSupervisor(arrayList).addConnectedItem(getConnectedSwitcherItem()).addSharedItemList(IODeviceHandler.getInstance().getOtherDeviceAll()).addMyItemList(IODeviceHandler.getInstance().getMyDeviceAll()).sort().rename().getItems();
    }

    public static ArrayList<IODeviceItem> createWidgetList(List<Switcher> list) {
        ArrayList<IODeviceItem> arrayList = new ArrayList<>();
        for (Switcher switcher : list) {
            String owner = switcher.getOwner();
            if (owner == null || owner.length() < 1) {
                owner = IOUtil.getStringResource(R.string.product_code_name) + switcher.getSerialNumber();
            }
            arrayList.add(new IODeviceItem(switcher.getProductId(), switcher.getName(), switcher.getMacAddress(), owner, false));
        }
        return arrayList;
    }

    public static ArrayList<IODeviceItem> createRemconWidgetList(List<Remocon> list) {
        ArrayList<IODeviceItem> arrayList = new ArrayList<>();
        for (Remocon remocon : list) {
            String owner = remocon.getOwner();
            if (owner == null || owner.length() < 1) {
                owner = IOUtil.getStringResource(R.string.product_code_name) + remocon.getSerialNumber();
            }
            arrayList.add(new IODeviceItem(remocon.getProductId(), remocon.getName(), remocon.getMacAddress(), owner, false));
        }
        return arrayList;
    }

    public static ArrayList<IODeviceItem> createChecherWidgetList(List<Checker> list) {
        ArrayList<IODeviceItem> arrayList = new ArrayList<>();
        for (Checker checker : list) {
            arrayList.add(new IODeviceItem(checker.getProductId(), checker.getName(), checker.getMacAddress(), IOUtil.getStringResource(R.string.product_code_name) + checker.getSerialNumber(), false));
        }
        return arrayList;
    }

    private static IODeviceItem getConnectedSwitcherItem() {
        Iterator<String> it = SwitcherUtil.getConnectedDeviceAddress().iterator();
        if (!it.hasNext()) {
            return null;
        }
        Switcher switcher = SwitcherHandler.getInstance().getSwitcher(it.next());
        if (switcher == null) {
            return null;
        }
        return new IODeviceItem(switcher.getProductId(), switcher.getName(), switcher.getMacAddress(), switcher.getSerialNumber(), switcher.getDeviceOption().getPaymentInfo().getPaymentMethod(), true, true, switcher.getDeviceOption().getShipping().getStatus());
    }
}
