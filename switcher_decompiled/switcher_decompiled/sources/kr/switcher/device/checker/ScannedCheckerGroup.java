package kr.switcher.device.checker;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class ScannedCheckerGroup implements Parcelable {
    public static final Parcelable.Creator<ScannedCheckerGroup> CREATOR = new Parcelable.Creator<ScannedCheckerGroup>() { // from class: kr.switcher.device.checker.ScannedCheckerGroup.1
        @Override // android.os.Parcelable.Creator
        public ScannedCheckerGroup createFromParcel(Parcel parcel) {
            return new ScannedCheckerGroup(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public ScannedCheckerGroup[] newArray(int i) {
            return new ScannedCheckerGroup[i];
        }
    };
    private ArrayList<ScannedBLEChecker> devices;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ScannedCheckerGroup() {
        this.devices = new ArrayList<>();
    }

    protected ScannedCheckerGroup(Parcel parcel) {
        this.devices = parcel.createTypedArrayList(ScannedBLEChecker.CREATOR);
    }

    public synchronized void add(ScannedBLEChecker scannedBLEChecker) {
        if (!isThere(scannedBLEChecker)) {
            this.devices.add(scannedBLEChecker);
            Collections.sort(this.devices);
        }
    }

    public void add(ArrayList<ScannedBLEChecker> arrayList) {
        Iterator<ScannedBLEChecker> it = arrayList.iterator();
        while (it.hasNext()) {
            add(it.next());
        }
    }

    public void clearDevices() {
        this.devices.clear();
    }

    public boolean isThere(ScannedBLEChecker scannedBLEChecker) {
        Iterator<ScannedBLEChecker> it = this.devices.iterator();
        while (it.hasNext()) {
            if (it.next().getDevice().getAddress().equals(scannedBLEChecker.getDevice().getAddress())) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<ScannedBLEChecker> getAllDeviceList() {
        return this.devices;
    }

    public ScannedBLEChecker get(int i) {
        return this.devices.get(i);
    }

    public ScannedBLEChecker get(String str) {
        for (ScannedBLEChecker scannedBLEChecker : this.devices) {
            if (scannedBLEChecker.getDevice().getAddress().equals(str)) {
                return scannedBLEChecker;
            }
        }
        return null;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.devices);
    }
}
