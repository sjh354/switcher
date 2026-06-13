package kr.switcher.device.switcher.ble;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class ScannedSwitcherGroup implements Parcelable {
    public static final Parcelable.Creator<ScannedSwitcherGroup> CREATOR = new Parcelable.Creator<ScannedSwitcherGroup>() { // from class: kr.switcher.device.switcher.ble.ScannedSwitcherGroup.1
        @Override // android.os.Parcelable.Creator
        public ScannedSwitcherGroup createFromParcel(Parcel parcel) {
            return new ScannedSwitcherGroup(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public ScannedSwitcherGroup[] newArray(int i) {
            return new ScannedSwitcherGroup[i];
        }
    };
    private ArrayList<ScannedBLESwitcher> devices;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ScannedSwitcherGroup() {
        this.devices = new ArrayList<>();
    }

    protected ScannedSwitcherGroup(Parcel parcel) {
        this.devices = parcel.createTypedArrayList(ScannedBLESwitcher.CREATOR);
    }

    public synchronized void add(ScannedBLESwitcher scannedBLESwitcher) {
        if (!isThere(scannedBLESwitcher)) {
            this.devices.add(scannedBLESwitcher);
            Collections.sort(this.devices);
        }
    }

    public void add(ArrayList<ScannedBLESwitcher> arrayList) {
        Iterator<ScannedBLESwitcher> it = arrayList.iterator();
        while (it.hasNext()) {
            add(it.next());
        }
    }

    public void clearDevices() {
        this.devices.clear();
    }

    public boolean isThere(ScannedBLESwitcher scannedBLESwitcher) {
        Iterator<ScannedBLESwitcher> it = this.devices.iterator();
        while (it.hasNext()) {
            if (it.next().getDevice().getAddress().equals(scannedBLESwitcher.getDevice().getAddress())) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<ScannedBLESwitcher> getAllDeviceList() {
        return this.devices;
    }

    public ScannedBLESwitcher get(int i) {
        return this.devices.get(i);
    }

    public ScannedBLESwitcher get(String str) {
        for (ScannedBLESwitcher scannedBLESwitcher : this.devices) {
            if (scannedBLESwitcher.getDevice().getAddress().equals(str)) {
                return scannedBLESwitcher;
            }
        }
        return null;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.devices);
    }
}
