package kr.switcher.switcherm.common.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kr.switcher.device.IODeviceConfig;
import kr.switcher.device.switcher.Switcher;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.IOConfig;
import kr.switcher.switcherm.network.http.data.ReservationData;

/* JADX INFO: loaded from: classes2.dex */
public class ConverterUtil {
    public static List<ReservationData> convertSwitcherReservationToReservationDataList(List<Switcher.SwitcherReservation> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<Switcher.SwitcherReservation> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(convertSwitcherReservationToReservationData(it.next()));
        }
        return arrayList;
    }

    public static ReservationData convertSwitcherReservationToReservationData(Switcher.SwitcherReservation switcherReservation) {
        ReservationData reservationData = new ReservationData();
        reservationData.day = getDay(switcherReservation);
        reservationData.time = getTime(switcherReservation);
        reservationData.status = switcherReservation.light ? "ON" : IOConfig.OFF;
        reservationData.active = switcherReservation.enable ? "active" : IOConfig.INACTIVE;
        return reservationData;
    }

    private static String getDay(Switcher.SwitcherReservation switcherReservation) {
        String str = switcherReservation.mon ? "" + IOUtil.getStringResource(R.string.mon) : "";
        if (switcherReservation.tue) {
            str = str + IOUtil.getStringResource(R.string.tue);
        }
        if (switcherReservation.wed) {
            str = str + IOUtil.getStringResource(R.string.wed);
        }
        if (switcherReservation.thu) {
            str = str + IOUtil.getStringResource(R.string.thu);
        }
        if (switcherReservation.fri) {
            str = str + IOUtil.getStringResource(R.string.fri);
        }
        if (switcherReservation.sat) {
            str = str + IOUtil.getStringResource(R.string.sat);
        }
        return switcherReservation.sun ? str + IOUtil.getStringResource(R.string.sun) : str;
    }

    public static String getTime(Switcher.SwitcherReservation switcherReservation) {
        return getTime(switcherReservation.ampm, switcherReservation.hour, switcherReservation.min);
    }

    public static String getTime(String str, int i, int i2) {
        return (((str.toUpperCase() + " ") + String.format("%02d", Integer.valueOf(i))) + ":") + String.format("%02d", Integer.valueOf(i2));
    }

    public static String getTimeKorean(String str, int i, int i2) {
        return ((((convertAmPmStringKorean(str) + " ") + String.format("%02d", Integer.valueOf(i))) + "시 ") + String.format("%02d", Integer.valueOf(i2))) + "분";
    }

    private static String convertAmPmStringKorean(String str) {
        if (str.equalsIgnoreCase(IODeviceConfig.AM)) {
            return IOUtil.getStringResource(R.string.am);
        }
        return str.equalsIgnoreCase("pm") ? IOUtil.getStringResource(R.string.pm) : str;
    }
}
