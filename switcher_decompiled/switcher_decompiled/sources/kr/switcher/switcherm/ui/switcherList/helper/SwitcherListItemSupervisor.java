package kr.switcher.switcherm.ui.switcherList.helper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kr.switcher.device.IODevice;
import kr.switcher.device.common.DeviceUtil;
import kr.switcher.device.switcher.interfaces.Convertible;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.device.IODeviceHandler;
import kr.switcher.switcherm.ui.switcherList.adapter.IODeviceItem;

/* JADX INFO: loaded from: classes2.dex */
public class SwitcherListItemSupervisor {
    private Convertible connectedItem;
    private List<Convertible> list;
    private List<Convertible> myCheckerItemList;
    private List<Convertible> myLinkerItemList;
    private List<IODevice> myList;
    private List<Convertible> myRemoconItemList;
    private List<Convertible> myScannedBLEItemList;
    private List<Convertible> myScannedLinkerItemList;
    private List<Convertible> scannedSharedItemList;
    private List<IODevice> sharedList;

    public SwitcherListItemSupervisor(List<Convertible> list) {
        initialize();
        Iterator<Convertible> it = list.iterator();
        while (it.hasNext()) {
            IODeviceItem iODeviceItem = (IODeviceItem) it.next().convert(true);
            if (checkIsInvalidSwitcher(iODeviceItem)) {
                this.list.add(iODeviceItem);
            }
        }
    }

    private void initialize() {
        this.list = new ArrayList();
        this.myList = new ArrayList();
        this.sharedList = new ArrayList();
        this.myScannedLinkerItemList = new ArrayList();
        this.myScannedBLEItemList = new ArrayList();
        this.scannedSharedItemList = new ArrayList();
        this.myLinkerItemList = new ArrayList();
        this.myCheckerItemList = new ArrayList();
        this.myRemoconItemList = new ArrayList();
    }

    public SwitcherListItemSupervisor addConnectedItem(Convertible convertible) {
        if (convertible != null) {
            this.connectedItem = convertible;
        }
        return this;
    }

    public SwitcherListItemSupervisor addMyItemList(List<IODevice> list) {
        Iterator<IODevice> it = list.iterator();
        while (it.hasNext()) {
            this.myList.add(it.next());
        }
        ArrayList<Convertible> arrayList = new ArrayList();
        arrayList.addAll(this.list);
        for (Convertible convertible : arrayList) {
            Iterator<IODevice> it2 = list.iterator();
            while (true) {
                if (it2.hasNext()) {
                    if (convertible.getMacAddress().equals(it2.next().getMacAddress())) {
                        addMyItem(convertible);
                        break;
                    }
                }
            }
        }
        return this;
    }

    private void addMyItem(Convertible convertible) {
        IODeviceItem iODeviceItem = (IODeviceItem) convertible;
        if (!iODeviceItem.isConnected()) {
            if (iODeviceItem.isScanned()) {
                this.myScannedBLEItemList.add(iODeviceItem);
            } else if (iODeviceItem.isLinked()) {
                if (iODeviceItem.getProductId().equals(IODevice.ProductId.LINKER)) {
                    this.myLinkerItemList.add(iODeviceItem);
                } else if (iODeviceItem.getProductId().equals(IODevice.ProductId.CHECKER)) {
                    this.myCheckerItemList.add(iODeviceItem);
                } else if (iODeviceItem.getProductId().equals(IODevice.ProductId.REMOCON)) {
                    this.myRemoconItemList.add(iODeviceItem);
                } else {
                    this.myScannedLinkerItemList.add(iODeviceItem);
                }
            }
        }
        this.list.remove(convertible);
        removeMyItem(convertible.getMacAddress());
    }

    private void removeMyItem(String str) {
        IODevice iODevice = null;
        for (IODevice iODevice2 : this.myList) {
            if (iODevice2.getMacAddress().equals(str)) {
                iODevice = iODevice2;
            }
        }
        this.myList.remove(iODevice);
    }

    public SwitcherListItemSupervisor addSharedItemList(List<IODevice> list) {
        this.sharedList.addAll(list);
        ArrayList<Convertible> arrayList = new ArrayList();
        arrayList.addAll(this.list);
        for (Convertible convertible : arrayList) {
            Iterator<IODevice> it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    IODevice next = it.next();
                    if (convertible.getMacAddress().equals(next.getMacAddress())) {
                        this.scannedSharedItemList.add(convertible);
                        this.list.remove(convertible);
                        this.sharedList.remove(next);
                        break;
                    }
                }
            }
        }
        return this;
    }

    public List<IODeviceItem> getItems() {
        ArrayList arrayList = new ArrayList();
        Iterator<Convertible> it = this.list.iterator();
        while (it.hasNext()) {
            arrayList.add((IODeviceItem) it.next());
        }
        return arrayList;
    }

    private List<Convertible> sortScannedMyItemList(List<Convertible> list) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list);
        arrayList.addAll(this.myScannedLinkerItemList);
        arrayList.addAll(this.myCheckerItemList);
        if (this.myLinkerItemList.size() > 0) {
            arrayList.addAll(this.myRemoconItemList);
        }
        arrayList.addAll(this.myScannedBLEItemList);
        return filterDuplicationItem(arrayList);
    }

    private List<Convertible> sortSharedItemList(List<Convertible> list) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list);
        arrayList.addAll(this.scannedSharedItemList);
        return arrayList;
    }

    private List<Convertible> sortScannedItemList(List<Convertible> list) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list);
        arrayList.addAll(this.list);
        arrayList.addAll(this.myLinkerItemList);
        return arrayList;
    }

    private List<Convertible> sortMyItemList(List<Convertible> list) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list);
        for (IODevice iODevice : this.myList) {
            if (!checkIsConnectedItem(iODevice.getMacAddress())) {
                IODeviceItem iODeviceItem = new IODeviceItem(iODevice.getProductId(), iODevice.getName(), iODevice.getMacAddress(), iODevice.getSerialNumber(), false);
                iODeviceItem.setStatus(iODevice.getOption().getShipping().getStatus());
                arrayList.add(iODeviceItem);
            }
        }
        return arrayList;
    }

    private boolean checkIsConnectedItem(String str) {
        Convertible convertible = this.connectedItem;
        return convertible != null && str.equalsIgnoreCase(convertible.getMacAddress());
    }

    public SwitcherListItemSupervisor sort() {
        ArrayList arrayList = new ArrayList();
        Convertible convertible = this.connectedItem;
        if (convertible != null) {
            arrayList.add(0, convertible);
        }
        List<Convertible> listSortMyItemList = sortMyItemList(sortScannedItemList(sortSharedItemList(sortScannedMyItemList(arrayList))));
        this.list.clear();
        this.list.addAll(listSortMyItemList);
        return this;
    }

    public SwitcherListItemSupervisor rename() {
        ArrayList arrayList = new ArrayList();
        Iterator<Convertible> it = this.list.iterator();
        while (it.hasNext()) {
            IODeviceItem iODeviceItem = (IODeviceItem) it.next();
            arrayList.add(iODeviceItem);
            IODevice device = IODeviceHandler.getInstance().getDevice(iODeviceItem.getMacAddress());
            if (device == null) {
                iODeviceItem.rename(getDefaultSerialNumberName(iODeviceItem.getSerialNumber()));
            } else {
                iODeviceItem.setSwitcherName(getSwitcherName(device));
                renameSwitcher(iODeviceItem, device.getOwner());
            }
        }
        this.list.clear();
        this.list.addAll(arrayList);
        return this;
    }

    private String getSwitcherName(IODevice iODevice) {
        String name = iODevice.getName();
        return name.length() < 1 ? DeviceUtil.getDefaultDeviceName(iODevice) : name;
    }

    private void renameSwitcher(IODeviceItem iODeviceItem, String str) {
        if (iODeviceItem.isConnected()) {
            iODeviceItem.rename(str);
            return;
        }
        if (isScannedMySwitcher(iODeviceItem)) {
            iODeviceItem.rename("내 스위처");
            return;
        }
        if (isSharedSwitcher(iODeviceItem)) {
            iODeviceItem.rename(str);
        } else if (isMySwitcher(iODeviceItem)) {
            iODeviceItem.rename(getDefaultSerialNumberName(iODeviceItem.getSerialNumber()));
        } else {
            iODeviceItem.rename(getDefaultSerialNumberName(iODeviceItem.getSerialNumber()));
        }
    }

    private String getDefaultSerialNumberName(String str) {
        return IOUtil.getStringResource(R.string.product_code_name) + str;
    }

    private boolean isScannedMySwitcher(IODeviceItem iODeviceItem) {
        Iterator<Convertible> it = this.myScannedLinkerItemList.iterator();
        while (it.hasNext()) {
            if (it.next().equals(iODeviceItem)) {
                return true;
            }
        }
        Iterator<Convertible> it2 = this.myScannedBLEItemList.iterator();
        while (it2.hasNext()) {
            if (it2.next().equals(iODeviceItem)) {
                return true;
            }
        }
        return false;
    }

    private boolean isMySwitcher(IODeviceItem iODeviceItem) {
        Iterator<Convertible> it = this.myScannedBLEItemList.iterator();
        while (it.hasNext()) {
            if (it.next().getMacAddress().equals(iODeviceItem.getMacAddress())) {
                return true;
            }
        }
        Iterator<Convertible> it2 = this.myScannedLinkerItemList.iterator();
        while (it2.hasNext()) {
            if (it2.next().getMacAddress().equals(iODeviceItem.getMacAddress())) {
                return true;
            }
        }
        return false;
    }

    private boolean isSharedSwitcher(IODeviceItem iODeviceItem) {
        Iterator<Convertible> it = this.scannedSharedItemList.iterator();
        while (it.hasNext()) {
            if (it.next().getMacAddress().equals(iODeviceItem.getMacAddress())) {
                return true;
            }
        }
        return false;
    }

    public List<Convertible> filterDuplicationItem(List<Convertible> list) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Convertible convertible : list) {
            if (!linkedHashMap.containsKey(convertible.getMacAddress())) {
                linkedHashMap.put(convertible.getMacAddress(), convertible);
            }
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = linkedHashMap.keySet().iterator();
        while (it.hasNext()) {
            arrayList.add((Convertible) linkedHashMap.get(it.next()));
        }
        return arrayList;
    }

    private boolean checkIsInvalidSwitcher(IODeviceItem iODeviceItem) {
        return ((iODeviceItem.getProductId() != IODevice.ProductId.SWITCHER_TYPE_ONE && iODeviceItem.getProductId() != IODevice.ProductId.SWITCHER_TYPE_TWO && iODeviceItem.getProductId() != IODevice.ProductId.LINKER && iODeviceItem.getProductId() != IODevice.ProductId.REMOCON && iODeviceItem.getProductId() != IODevice.ProductId.CHECKER) || "".equals(iODeviceItem.getSwitcherName()) || "".equals(iODeviceItem.getMacAddress()) || "".equals(iODeviceItem.getSerialNumber())) ? false : true;
    }
}
