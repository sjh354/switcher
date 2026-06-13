package kr.switcher.device.switcher;

import java.util.List;
import kr.switcher.device.switcher.Switcher;

/* JADX INFO: loaded from: classes2.dex */
public class SwitcherReservationChecker {
    private List<Switcher.SwitcherReservation> timers;

    public SwitcherReservationChecker(List<Switcher.SwitcherReservation> list) {
        this.timers = list;
    }

    public void add(Switcher.SwitcherReservation switcherReservation) {
        this.timers.add(switcherReservation);
    }

    public boolean checkIsDuplicationTimer(Switcher.SwitcherReservation switcherReservation) {
        for (Switcher.SwitcherReservation switcherReservation2 : this.timers) {
            if (switcherReservation.id == -1 || switcherReservation2.id != switcherReservation.id) {
                if (checkIsDuplicationTimer(switcherReservation2, switcherReservation)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkIsDuplicationTimer(Switcher.SwitcherReservation switcherReservation, Switcher.SwitcherReservation switcherReservation2) {
        if (switcherReservation.hour != switcherReservation2.hour || switcherReservation.min != switcherReservation2.min || !switcherReservation.ampm.equalsIgnoreCase(switcherReservation2.ampm) || !switcherReservation.switcherTarget.equals(switcherReservation2.switcherTarget)) {
            return false;
        }
        if (switcherReservation.mon && switcherReservation2.mon) {
            return true;
        }
        if (switcherReservation.tue && switcherReservation2.tue) {
            return true;
        }
        if (switcherReservation.wed && switcherReservation2.wed) {
            return true;
        }
        if (switcherReservation.thu && switcherReservation2.thu) {
            return true;
        }
        if (switcherReservation.fri && switcherReservation2.fri) {
            return true;
        }
        if (switcherReservation.sat && switcherReservation2.sat) {
            return true;
        }
        return switcherReservation.sun && switcherReservation2.sun;
    }
}
