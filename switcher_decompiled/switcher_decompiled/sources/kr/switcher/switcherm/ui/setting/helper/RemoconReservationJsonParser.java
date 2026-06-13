package kr.switcher.switcherm.ui.setting.helper;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import kr.switcher.device.remocon.Remocon;

/* JADX INFO: loaded from: classes2.dex */
public class RemoconReservationJsonParser {
    public static String makeRemoconReservationJson(Remocon.RemoconReservation remoconReservation) {
        return new Gson().toJson(remoconReservation);
    }

    public static Remocon.RemoconReservation parseRemoconReservation(String str) {
        try {
            return (Remocon.RemoconReservation) new Gson().fromJson(str, Remocon.RemoconReservation.class);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
            throw e;
        } catch (NullPointerException e2) {
            e2.printStackTrace();
            throw e2;
        }
    }
}
