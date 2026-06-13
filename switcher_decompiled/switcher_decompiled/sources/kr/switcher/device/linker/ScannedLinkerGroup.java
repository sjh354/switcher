package kr.switcher.device.linker;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class ScannedLinkerGroup implements Parcelable {
    public static final Parcelable.Creator<ScannedLinkerGroup> CREATOR = new Parcelable.Creator<ScannedLinkerGroup>() { // from class: kr.switcher.device.linker.ScannedLinkerGroup.1
        @Override // android.os.Parcelable.Creator
        public ScannedLinkerGroup createFromParcel(Parcel parcel) {
            return new ScannedLinkerGroup(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public ScannedLinkerGroup[] newArray(int i) {
            return new ScannedLinkerGroup[i];
        }
    };
    private ArrayList<ScannedBLELinker> devices;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ScannedLinkerGroup() {
        this.devices = new ArrayList<>();
    }

    protected ScannedLinkerGroup(Parcel parcel) {
        this.devices = parcel.createTypedArrayList(ScannedBLELinker.CREATOR);
    }

    public synchronized void add(ScannedBLELinker scannedBLELinker) {
        if (!isThere(scannedBLELinker)) {
            this.devices.add(scannedBLELinker);
            Collections.sort(this.devices);
        }
    }

    public void add(ArrayList<ScannedBLELinker> arrayList) {
        Iterator<ScannedBLELinker> it = arrayList.iterator();
        while (it.hasNext()) {
            add(it.next());
        }
    }

    public void clearDevices() {
        this.devices.clear();
    }

    public boolean isThere(ScannedBLELinker scannedBLELinker) {
        Iterator<ScannedBLELinker> it = this.devices.iterator();
        while (it.hasNext()) {
            if (it.next().getDevice().getAddress().equals(scannedBLELinker.getDevice().getAddress())) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<ScannedBLELinker> getAllDeviceList() {
        return this.devices;
    }

    public ScannedBLELinker get(int i) {
        return this.devices.get(i);
    }

    public ScannedBLELinker get(String str) {
        for (ScannedBLELinker scannedBLELinker : this.devices) {
            if (scannedBLELinker.getDevice().getAddress().equals(str)) {
                return scannedBLELinker;
            }
        }
        return null;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.devices);
    }
}
