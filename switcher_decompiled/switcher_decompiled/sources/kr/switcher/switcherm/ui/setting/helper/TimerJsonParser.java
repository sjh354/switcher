package kr.switcher.switcherm.ui.setting.helper;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import kr.switcher.device.switcher.Switcher;

/* JADX INFO: loaded from: classes2.dex */
public class TimerJsonParser {
    public static String makeSwitcherReservationJson(Switcher.SwitcherReservation switcherReservation) {
        return new Gson().toJson(switcherReservation);
    }

    public static Switcher.SwitcherReservation parseSwitcherReservation(String str) {
        try {
            return (Switcher.SwitcherReservation) new Gson().fromJson(str, Switcher.SwitcherReservation.class);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
            throw e;
        } catch (NullPointerException e2) {
            e2.printStackTrace();
            throw e2;
        }
    }
}
