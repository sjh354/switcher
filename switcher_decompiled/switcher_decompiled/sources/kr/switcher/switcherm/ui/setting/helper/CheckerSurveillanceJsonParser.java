package kr.switcher.switcherm.ui.setting.helper;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import kr.switcher.device.checker.Checker;

/* JADX INFO: loaded from: classes2.dex */
public class CheckerSurveillanceJsonParser {
    public static String makeCheckerSurveillanceJson(Checker.Surveillance surveillance) {
        return new Gson().toJson(surveillance);
    }

    public static Checker.Surveillance parseCheckerSurveillance(String str) {
        try {
            return (Checker.Surveillance) new Gson().fromJson(str, Checker.Surveillance.class);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
            throw e;
        } catch (NullPointerException e2) {
            e2.printStackTrace();
            throw e2;
        }
    }
}
