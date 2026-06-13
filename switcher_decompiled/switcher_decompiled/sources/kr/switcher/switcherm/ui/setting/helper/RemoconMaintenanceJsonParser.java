package kr.switcher.switcherm.ui.setting.helper;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import kr.switcher.device.remocon.Remocon;

/* JADX INFO: loaded from: classes2.dex */
public class RemoconMaintenanceJsonParser {
    public static String makeRemoconMaintenanceJson(Remocon.RemoconMaintenanceTemperature remoconMaintenanceTemperature) {
        return new Gson().toJson(remoconMaintenanceTemperature);
    }

    public static Remocon.RemoconMaintenanceTemperature parseRemoconMaintenance(String str) {
        try {
            return (Remocon.RemoconMaintenanceTemperature) new Gson().fromJson(str, Remocon.RemoconMaintenanceTemperature.class);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
            throw e;
        } catch (NullPointerException e2) {
            e2.printStackTrace();
            throw e2;
        }
    }
}
