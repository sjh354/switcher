package kr.switcher.device.switcher.linker;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kr.switcher.device.common.DeviceUtil;
import kr.switcher.device.switcher.linker.http.response.BatteryLevelAPIResponse;
import kr.switcher.device.switcher.linker.http.response.CommandResultAPIResponse;
import kr.switcher.device.switcher.linker.http.response.ControlAPIResponse;
import kr.switcher.device.switcher.linker.http.response.FingerLengthReadAPIResponse;
import kr.switcher.device.switcher.linker.http.response.FingerLengthTestAPIResponse;
import kr.switcher.device.switcher.linker.http.response.FingerLengthWriteAPIResponse;
import kr.switcher.device.switcher.linker.http.response.ReservationReadAPIResponse;
import kr.switcher.device.switcher.linker.http.response.ReservationWriteAPIResponse;

/* JADX INFO: loaded from: classes2.dex */
public class SwitcherLinkerJsonParser {
    public static int parseSwitcherStatus(String str) throws Exception {
        try {
            return ((SwitcherStatus) new Gson().fromJson(str, SwitcherStatus.class)).status;
        } catch (JsonSyntaxException e) {
            throw e;
        } catch (NullPointerException e2) {
            throw e2;
        }
    }

    public static String parseCommandStatus(String str) throws Exception {
        try {
            return ((CommandData) new Gson().fromJson(str, CommandData.class)).status;
        } catch (JsonSyntaxException e) {
            throw e;
        } catch (NullPointerException e2) {
            throw e2;
        }
    }

    public static String parseCommandResult(CommandResultAPIResponse commandResultAPIResponse) {
        return commandResultAPIResponse != null ? commandResultAPIResponse.status : "";
    }

    public static List<String> parseGetDeviceList(String str) throws Exception {
        try {
            List list = (List) new Gson().fromJson(str, new TypeToken<List<DeviceData>>() { // from class: kr.switcher.device.switcher.linker.SwitcherLinkerJsonParser.1
            }.getType());
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(DeviceUtil.makeMacAddressWithSemicolon(((DeviceData) it.next()).mac_address));
            }
            return arrayList;
        } catch (JsonSyntaxException e) {
            throw e;
        } catch (NullPointerException e2) {
            throw e2;
        } catch (Exception e3) {
            throw e3;
        }
    }

    public static String parseBatteryLevel(BatteryLevelAPIResponse batteryLevelAPIResponse) {
        if (batteryLevelAPIResponse != null) {
            return batteryLevelAPIResponse.value;
        }
        return String.valueOf(-1);
    }

    public static String parseStrokeLevelValue(FingerLengthReadAPIResponse fingerLengthReadAPIResponse) {
        if (fingerLengthReadAPIResponse != null) {
            return fingerLengthReadAPIResponse.value;
        }
        return String.valueOf(-1);
    }

    public static String parseStrokeLevelReadCommandId(FingerLengthReadAPIResponse fingerLengthReadAPIResponse) {
        return fingerLengthReadAPIResponse != null ? fingerLengthReadAPIResponse.command_id : "";
    }

    public static String parseStrokeLevelWrite(FingerLengthWriteAPIResponse fingerLengthWriteAPIResponse) {
        return fingerLengthWriteAPIResponse != null ? fingerLengthWriteAPIResponse.command_id : "";
    }

    public static String parseStrokeLevelFeedback(FingerLengthTestAPIResponse fingerLengthTestAPIResponse) {
        return fingerLengthTestAPIResponse != null ? fingerLengthTestAPIResponse.command_id : "";
    }

    public static boolean parseCommandResultStatus(CommandResultAPIResponse commandResultAPIResponse) {
        if (commandResultAPIResponse != null) {
            return commandResultAPIResponse.status.equals("success");
        }
        return false;
    }

    public static String parseCommandResultValue(CommandResultAPIResponse commandResultAPIResponse) {
        if (commandResultAPIResponse != null) {
            return commandResultAPIResponse.getValue();
        }
        return null;
    }

    public static String parseReservationWrite(ReservationWriteAPIResponse reservationWriteAPIResponse) {
        return reservationWriteAPIResponse != null ? reservationWriteAPIResponse.command_id : "";
    }

    public static String parseReservationValue(ReservationReadAPIResponse reservationReadAPIResponse) {
        return reservationReadAPIResponse != null ? reservationReadAPIResponse.value : "";
    }

    public static String parseReservationReadCommandId(ReservationReadAPIResponse reservationReadAPIResponse) {
        return reservationReadAPIResponse != null ? reservationReadAPIResponse.command_id : "";
    }

    public static String parseCommandId(ControlAPIResponse controlAPIResponse) {
        return controlAPIResponse != null ? controlAPIResponse.command_id : "";
    }

    private class SwitcherStatus {
        int status;

        private SwitcherStatus() {
        }
    }

    private class CommandData {
        String status;

        private CommandData() {
        }
    }

    private class CommandResult {
        String result;

        private CommandResult() {
        }
    }

    private class DeviceData {
        String mac_address;
        int product_id;
        int status;

        private DeviceData() {
        }
    }

    private class BatteryResult {
        String created_at;
        String mac_address;
        String value;

        private BatteryResult() {
        }
    }
}
