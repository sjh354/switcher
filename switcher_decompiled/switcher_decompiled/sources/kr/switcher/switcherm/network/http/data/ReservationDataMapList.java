package kr.switcher.switcherm.network.http.data;

import androidx.core.app.NotificationCompat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import no.nordicsemi.android.log.LogContract;

/* JADX INFO: loaded from: classes2.dex */
public class ReservationDataMapList {
    private final String ARG_DAY = "day";
    private final String ARG_TIME = LogContract.LogColumns.TIME;
    private final String ARG_STATUS = NotificationCompat.CATEGORY_STATUS;
    private final String ARG_ACTIVE = "active";
    List<Map<String, String>> listOfMaps = new ArrayList();

    public ReservationDataMapList(List<ReservationData> list) {
        for (ReservationData reservationData : list) {
            HashMap map = new HashMap();
            map.put("day", reservationData.day);
            map.put(LogContract.LogColumns.TIME, reservationData.time);
            map.put(NotificationCompat.CATEGORY_STATUS, reservationData.status);
            map.put("active", reservationData.active);
            this.listOfMaps.add(map);
        }
    }

    public List<Map<String, String>> get() {
        return this.listOfMaps;
    }
}
