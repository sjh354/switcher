package kr.switcher.switcherm.ui.setting.adapter;

import kr.switcher.device.switcher.Switcher;

/* JADX INFO: loaded from: classes2.dex */
public class ReservationItem {
    private String connectedMacAddress;
    private Switcher.SwitcherReservation switcherTimer;

    public ReservationItem(String str, Switcher.SwitcherReservation switcherReservation) {
        this.connectedMacAddress = str;
        this.switcherTimer = switcherReservation;
    }

    public String getConnectedMacAddress() {
        return this.connectedMacAddress;
    }

    public void setConnectedMacAddress(String str) {
        this.connectedMacAddress = str;
    }

    public Switcher.SwitcherReservation getSwitcherReservation() {
        return this.switcherTimer;
    }

    public void setSwitcherReservation(Switcher.SwitcherReservation switcherReservation) {
        this.switcherTimer = switcherReservation;
    }
}
