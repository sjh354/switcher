package kr.switcher.device.remocon;

import android.util.Log;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import kr.switcher.device.IODevice;
import kr.switcher.device.switcher.interfaces.IODeviceCallbacks;
import kr.switcher.switcherm.viewmodel.SwitcherInfoActivityViewModel;

/* JADX INFO: loaded from: classes2.dex */
public class Remocon extends IODevice {
    private static final int CONTROLLER_ID_AIRCON = 2;
    private static final int CONTROLLER_ID_REMOCON = 0;
    private static final int CONTROLLER_ID_SET_TOP_BOX = 3;
    private static final int CONTROLLER_ID_TV = 1;
    private static final int CONTROLLER_ID_UNKNOWN = -1;
    private static String TAG = "Remocon";
    private List<IRCommand> commands;
    private ControllerID controllerId;
    private String id;
    public List<RemoconMaintenanceTemperature> mTemperatures;
    private String name;
    public List<RemoconReservation> rResrvs;

    @Override // kr.switcher.device.IODevice
    public int connect(IODeviceCallbacks.OnDeviceConnectListener onDeviceConnectListener) {
        return 0;
    }

    @Override // kr.switcher.device.IODevice
    public void disconnect() {
    }

    public enum ControllerID {
        REMOCON(0),
        TV(1),
        AIRCON(2),
        SET_TOP_BOX(3),
        UNKNOWN(-1);

        private int id;

        ControllerID(int i) {
            this.id = i;
        }

        public int getValue() {
            return this.id;
        }
    }

    public Remocon(String str, String str2) {
        if (str.substring(0, 7).equals(SwitcherInfoActivityViewModel.MENU_REMOCON)) {
            initByMacaddress(str, str2, ControllerID.REMOCON);
        } else {
            init(str, str2, ControllerID.REMOCON);
        }
    }

    public Remocon(String str, String str2, ControllerID controllerID) {
        init(str, str2, controllerID);
    }

    public Remocon(String str, String str2, ControllerID controllerID, List<RemoconReservation> list) {
        this.id = str;
        this.name = str2;
        this.controllerId = controllerID;
        this.rResrvs = list;
        init(str, str2, controllerID);
    }

    private void init(String str, String str2, ControllerID controllerID) {
        this.id = str;
        this.name = str2;
        this.commands = new ArrayList();
        this.productId = IODevice.ProductId.REMOCON;
        this.thingConnectionStatus = IODevice.ThingConnectionStatus.ALIVE;
        this.macAddress = this.productId + String.valueOf(convertControllerIDToInt(controllerID)) + str;
        this.serialNumber = "-";
        this.controllerId = controllerID;
        this.rResrvs = new LinkedList();
    }

    private void initByMacaddress(String str, String str2, ControllerID controllerID) {
        this.id = str.substring(8);
        this.name = str2;
        this.commands = new ArrayList();
        this.productId = IODevice.ProductId.REMOCON;
        this.thingConnectionStatus = IODevice.ThingConnectionStatus.ALIVE;
        this.macAddress = str;
        this.serialNumber = "-";
        this.controllerId = getControllerIDFromMacAddress(str);
        Log.d(TAG, "||WIDGET|| INIT 2 MAC ADDRESS : " + this.macAddress);
        Log.d(TAG, "||WIDGET|| INIT 2 CONTROLLER ID : " + this.controllerId);
        this.rResrvs = new LinkedList();
    }

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    @Override // kr.switcher.device.IODevice
    public String getName() {
        return this.name;
    }

    @Override // kr.switcher.device.IODevice
    public void setName(String str) {
        this.name = str;
    }

    public void setControllerId(ControllerID controllerID) {
        this.controllerId = controllerID;
    }

    public ControllerID getControllerId() {
        return this.controllerId;
    }

    public void addCommand(IRCommand iRCommand) {
        this.commands.add(iRCommand);
    }

    public void removeCommand(String str) {
        for (int i = 0; i < this.commands.size(); i++) {
            if (this.commands.get(i).getId().equals(str)) {
                this.commands.remove(i);
            }
        }
    }

    public void clearCommands() {
        this.commands.clear();
    }

    public IRCommand getCommand(String str) {
        for (int i = 0; i < this.commands.size(); i++) {
            if (this.commands.get(i).getId().equals(str)) {
                return this.commands.get(i);
            }
        }
        return null;
    }

    public static ControllerID convertIntToControllerID(int i) {
        if (i == 0) {
            return ControllerID.REMOCON;
        }
        if (i == 1) {
            return ControllerID.TV;
        }
        if (i == 2) {
            return ControllerID.AIRCON;
        }
        if (i == 3) {
            return ControllerID.SET_TOP_BOX;
        }
        return ControllerID.UNKNOWN;
    }

    /* JADX INFO: renamed from: kr.switcher.device.remocon.Remocon$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$kr$switcher$device$remocon$Remocon$ControllerID;

        static {
            int[] iArr = new int[ControllerID.values().length];
            $SwitchMap$kr$switcher$device$remocon$Remocon$ControllerID = iArr;
            try {
                iArr[ControllerID.REMOCON.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$kr$switcher$device$remocon$Remocon$ControllerID[ControllerID.TV.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$kr$switcher$device$remocon$Remocon$ControllerID[ControllerID.AIRCON.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$kr$switcher$device$remocon$Remocon$ControllerID[ControllerID.SET_TOP_BOX.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static int convertControllerIDToInt(ControllerID controllerID) {
        int i = AnonymousClass1.$SwitchMap$kr$switcher$device$remocon$Remocon$ControllerID[controllerID.ordinal()];
        if (i == 1) {
            return 0;
        }
        if (i == 2) {
            return 1;
        }
        if (i != 3) {
            return i != 4 ? -1 : 3;
        }
        return 2;
    }

    public static ControllerID getControllerIDFromMacAddress(String str) {
        switch (str.charAt(7)) {
            case '0':
                return ControllerID.REMOCON;
            case '1':
                return ControllerID.TV;
            case '2':
                return ControllerID.AIRCON;
            case '3':
                return ControllerID.SET_TOP_BOX;
            default:
                return ControllerID.UNKNOWN;
        }
    }

    public List<RemoconReservation> getRemoconReservationList() {
        return this.rResrvs;
    }

    public void setRemoconReservationList(List<RemoconReservation> list) {
        if (list == null) {
            this.rResrvs = new ArrayList();
        } else {
            this.rResrvs = list;
        }
    }

    public void addRemoconReservation(RemoconReservation remoconReservation) {
        removeDuplicatedReservation(remoconReservation.weekTime);
        this.rResrvs.add(remoconReservation);
    }

    private void removeDuplicatedReservation(String str) {
        RemoconReservation remoconReservation = null;
        for (RemoconReservation remoconReservation2 : this.rResrvs) {
            if (remoconReservation2.weekTime.equals(str)) {
                remoconReservation = remoconReservation2;
            }
        }
        if (remoconReservation != null) {
            this.rResrvs.remove(remoconReservation);
        }
    }

    public void removeRemconReservation(String str) {
        removeDuplicatedReservation(str);
    }

    public static class RemoconReservation {
        public static final String PROTOCOL_ADD = "00";
        public static final String PROTOCOL_REMOVE = "01";
        public boolean fri;
        public int hour;
        public List<String> irIdList;
        public String isEnabled;
        public int min;
        public boolean mon;
        public boolean sat;
        public boolean sun;
        public String tag;
        public boolean thu;
        public String time;
        public String title;
        public boolean tue;
        public boolean wed;
        public String weekTime;

        public RemoconReservation() {
            this.irIdList = new ArrayList();
        }

        public RemoconReservation(String str, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, Boolean bool7, int i, int i2) {
            this.irIdList = new ArrayList();
            this.title = str;
            this.mon = bool.booleanValue();
            this.tue = bool2.booleanValue();
            this.wed = bool3.booleanValue();
            this.thu = bool4.booleanValue();
            this.fri = bool5.booleanValue();
            this.sat = bool6.booleanValue();
            this.sun = bool7.booleanValue();
            this.hour = i;
            this.min = i2;
        }

        public RemoconReservation(String str, String str2, String str3, String str4, String str5, List<String> list) {
            new ArrayList();
            this.weekTime = str;
            this.title = str2;
            this.time = str3;
            this.isEnabled = str4;
            this.tag = str5;
            this.irIdList = list;
        }

        public RemoconReservation(String str, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, Boolean bool7, int i, int i2, String str2) {
            this.irIdList = new ArrayList();
            this.title = str;
            this.mon = bool.booleanValue();
            this.tue = bool2.booleanValue();
            this.wed = bool3.booleanValue();
            this.thu = bool4.booleanValue();
            this.fri = bool5.booleanValue();
            this.sat = bool6.booleanValue();
            this.sun = bool7.booleanValue();
            this.hour = i;
            this.min = i2;
            this.tag = str2;
        }
    }

    public static class RemoconMaintenanceTemperature {
        public int appliances;
        public String created_at;
        public int endHour;
        public int endMin;
        public String end_time_at;
        public boolean fri;
        public int goal_temperature;
        public int id;
        public Boolean is_enabled;
        public boolean mon;
        public boolean sat;
        public int startHour;
        public int startMin;
        public String start_time_at;
        public boolean sun;
        public boolean thu;
        public String title;
        public boolean tue;
        public boolean wed;
        public String weekdays;

        public RemoconMaintenanceTemperature(int i, String str, Boolean bool, int i2, String str2, String str3, String str4, String str5, int i3) {
            this.id = i;
            this.title = str;
            this.is_enabled = bool;
            this.goal_temperature = i2;
            this.weekdays = str2;
            this.start_time_at = str3;
            this.end_time_at = str4;
            this.created_at = str5;
            this.appliances = i3;
        }

        public RemoconMaintenanceTemperature(String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, int i, int i2, int i3, int i4, int i5) {
            this.title = str;
            this.mon = z;
            this.tue = z2;
            this.wed = z3;
            this.thu = z4;
            this.fri = z5;
            this.sat = z6;
            this.sun = z7;
            this.startHour = i2;
            this.endHour = i3;
            this.startMin = i4;
            this.endMin = i5;
            this.goal_temperature = i;
        }
    }
}
