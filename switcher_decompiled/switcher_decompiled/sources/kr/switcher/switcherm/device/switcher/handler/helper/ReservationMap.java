package kr.switcher.switcherm.device.switcher.handler.helper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kr.switcher.device.switcher.Switcher;
import kr.switcher.switcherm.database.DBReservation;

/* JADX INFO: loaded from: classes2.dex */
public class ReservationMap {
    private final String EMPTY = "";
    private Map<String, String> map = new HashMap();

    public ReservationMap(List<DBReservation> list) {
        for (DBReservation dBReservation : list) {
            this.map.put(createKey(dBReservation), dBReservation.getTitle());
        }
    }

    private String createKey(DBReservation dBReservation) {
        return "" + dBReservation.isMon() + dBReservation.isTue() + dBReservation.isWed() + dBReservation.isThu() + dBReservation.isFri() + dBReservation.isSat() + dBReservation.isSun() + dBReservation.getAmPm() + dBReservation.getHour() + dBReservation.getMin();
    }

    public String createKey(Switcher.SwitcherReservation switcherReservation) {
        return "" + switcherReservation.mon + switcherReservation.tue + switcherReservation.wed + switcherReservation.thu + switcherReservation.fri + switcherReservation.sat + switcherReservation.sun + switcherReservation.ampm + switcherReservation.hour + switcherReservation.min;
    }

    public String get(String str) {
        String str2 = this.map.get(str);
        return str2 == null ? "" : str2;
    }

    public String get(Switcher.SwitcherReservation switcherReservation) {
        return get(createKey(switcherReservation));
    }
}
