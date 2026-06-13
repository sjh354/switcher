package kr.switcher.device.common;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kr.switcher.device.IODevice;
import kr.switcher.device.R;
import kr.switcher.device.preference.PreferenceHelper;
import kr.switcher.device.preference.TimerVersion;
import kr.switcher.device.switcher.Switcher;
import kr.switcher.device.switcher.ble.ScannedBLESwitcher;
import kr.switcher.ioble.common.BLEUtil;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceUtil {
    private static final int CHECKER_NUM = 4;
    private static final int LINKER_NUM = 3;
    private static final int REMOCON_NUM = 31;
    private static final int SWITCHER_TYPE_ONE_NUM = 1;
    private static final int SWITCHER_TYPE_TWO_NUM = 2;
    private static final String TAG = "DeviceUtil";
    private static Context context;

    public static Context getContext() {
        return context;
    }

    public static void initialize(Context context2) {
        context = context2;
        BLEUtil.setContext(context2);
        PreferenceHelper.setContext(context2);
    }

    public static BluetoothDevice getConnectedBluetoothDevice(String str, Switcher switcher) throws NullPointerException {
        Context context2 = context;
        if (context2 == null) {
            return null;
        }
        BluetoothDevice bluetoothDevice = null;
        for (BluetoothDevice bluetoothDevice2 : ((BluetoothManager) context2.getSystemService("bluetooth")).getConnectedDevices(7)) {
            if (bluetoothDevice2.getAddress().equalsIgnoreCase(str)) {
                bluetoothDevice = bluetoothDevice2;
            }
        }
        if (bluetoothDevice == null || switcher == null) {
            return null;
        }
        Log.i(TAG, "connected switcher is present");
        return bluetoothDevice;
    }

    public static int checkSwitcherToConnect(Switcher switcher) {
        BluetoothDevice connectedBluetoothDevice;
        try {
            connectedBluetoothDevice = getConnectedBluetoothDevice(switcher.getMacAddress(), switcher);
        } catch (NullPointerException unused) {
            connectedBluetoothDevice = null;
        }
        if (connectedBluetoothDevice != null) {
            switcher.attachToDevice(new ScannedBLESwitcher(connectedBluetoothDevice, null));
            return 1;
        }
        if (switcher.getAttachedDevice() == null) {
            Log.i(TAG, "not attached ble device (state:" + switcher.getConnectionState() + ")");
            return 202;
        }
        String serialNumber = switcher.getAttachedDevice().getAdvertisementPacket().getSerialNumber();
        if (serialNumber == null || serialNumber.equalsIgnoreCase("")) {
            Log.e(TAG, "checkConnectToSwitcher - no productcode in ad");
        }
        if (switcher.getAttachedDevice().getAdvertisementPacket().getSwitcherType() != 0) {
            return 1;
        }
        Log.e(TAG, "checkConnectToSwitcher - no way info in ad");
        return 1;
    }

    public static boolean isConnectedDeviceAddress(String str) {
        Iterator<String> it = getConnectedDeviceAddress().iterator();
        while (it.hasNext()) {
            if (it.next().equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static List<String> getConnectedDeviceAddress() {
        Context context2 = context;
        if (context2 == null) {
            return new ArrayList();
        }
        BluetoothManager bluetoothManager = (BluetoothManager) context2.getSystemService("bluetooth");
        if (bluetoothManager == null) {
            return new ArrayList();
        }
        List<BluetoothDevice> connectedDevices = bluetoothManager.getConnectedDevices(7);
        ArrayList arrayList = new ArrayList();
        if (connectedDevices.size() > 0) {
            for (BluetoothDevice bluetoothDevice : connectedDevices) {
                if (bluetoothDevice.getName() != null && bluetoothDevice.getName().contains(Switcher.SWITCHER_NAME)) {
                    arrayList.add(bluetoothDevice.getAddress());
                }
            }
        }
        return arrayList;
    }

    public static int isSwitcherConnected(Switcher switcher) {
        if (switcher == null) {
            return 101;
        }
        return switcher.getConnectionState() != Switcher.ConnectionState.CONNECTED ? 203 : 1;
    }

    public static void setLastTimerVersion() {
        try {
            new TimerVersion().setTimerVersion(Switcher.SwitcherReservation.currentTimerVersion);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    public static int generateNewReservationId(List<Switcher.SwitcherReservation> list) {
        int i = 0;
        int i2 = -1;
        while (i < 10 && i2 <= -1) {
            Iterator<Switcher.SwitcherReservation> it = list.iterator();
            int i3 = i;
            while (it.hasNext()) {
                if (it.next().id == i3) {
                    i3 = -1;
                }
            }
            i++;
            i2 = i3;
        }
        return i2;
    }

    public static boolean isMySwitcher(String str, List<String> list) {
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    public static String getDefaultDeviceName(IODevice iODevice) {
        return getDefaultDeviceName(iODevice.getProductId());
    }

    /* JADX INFO: renamed from: kr.switcher.device.common.DeviceUtil$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$kr$switcher$device$IODevice$ProductId;

        static {
            int[] iArr = new int[IODevice.ProductId.values().length];
            $SwitchMap$kr$switcher$device$IODevice$ProductId = iArr;
            try {
                iArr[IODevice.ProductId.SWITCHER_TYPE_ONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$kr$switcher$device$IODevice$ProductId[IODevice.ProductId.SWITCHER_TYPE_TWO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$kr$switcher$device$IODevice$ProductId[IODevice.ProductId.LINKER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$kr$switcher$device$IODevice$ProductId[IODevice.ProductId.CHECKER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$kr$switcher$device$IODevice$ProductId[IODevice.ProductId.REMOCON.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public static String getDefaultDeviceName(IODevice.ProductId productId) {
        int i = AnonymousClass1.$SwitchMap$kr$switcher$device$IODevice$ProductId[productId.ordinal()];
        if (i == 1) {
            return getStringResource(R.string.switcher_1way_name);
        }
        if (i == 2) {
            return getStringResource(R.string.switcher_2way_name);
        }
        if (i == 3) {
            return getStringResource(R.string.linker_name);
        }
        if (i != 4) {
            return i != 5 ? "" : getStringResource(R.string.remocon_name);
        }
        return getStringResource(R.string.checker_name);
    }

    public static String getStringResource(int i) {
        Context context2 = context;
        return context2 == null ? "" : context2.getString(i);
    }

    public static boolean checkIsBluetoothAddress(String str) {
        if (str == null || str.length() != 17) {
            return false;
        }
        for (int i = 0; i < 17; i++) {
            char cCharAt = str.charAt(i);
            int i2 = i % 3;
            if (i2 == 0 || i2 == 1) {
                if ((cCharAt < '0' || cCharAt > '9') && (cCharAt < 'A' || cCharAt > 'F')) {
                    return false;
                }
            } else if (i2 == 2 && cCharAt != ':') {
                return false;
            }
        }
        return true;
    }

    public static boolean isConnectedInternet() {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        return (connectivityManager == null || connectivityManager.getActiveNetworkInfo() == null) ? false : true;
    }

    public static int getMinDifferenceCurrentTimeAnd(int i, int i2) {
        return Math.abs(i2 - i);
    }

    public static String makeMacAddressOnlyHex(String str) {
        return str.replace(":", "");
    }

    public static String makeBackendMacAddressFormat(String str) {
        return str.replace(":", "");
    }

    public static String makeMacAddressWithSemicolon(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.insert(10, ":");
        stringBuffer.insert(8, ":");
        stringBuffer.insert(6, ":");
        stringBuffer.insert(4, ":");
        stringBuffer.insert(2, ":");
        return stringBuffer.toString();
    }

    public static IODevice.ProductId convertProductId(int i) {
        if (i == 1) {
            return IODevice.ProductId.SWITCHER_TYPE_ONE;
        }
        if (i == 2) {
            return IODevice.ProductId.SWITCHER_TYPE_TWO;
        }
        if (i == 3) {
            return IODevice.ProductId.LINKER;
        }
        if (i == 4) {
            return IODevice.ProductId.CHECKER;
        }
        if (i != 31) {
            return null;
        }
        return IODevice.ProductId.REMOCON;
    }

    public static int convertSwitcherType(IODevice.ProductId productId) {
        int i = AnonymousClass1.$SwitchMap$kr$switcher$device$IODevice$ProductId[productId.ordinal()];
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (i != 2) {
                i2 = 3;
                if (i != 3) {
                    i2 = 4;
                    if (i != 4) {
                        return i != 5 ? 0 : 31;
                    }
                }
            }
        }
        return i2;
    }

    public static IODevice.ThingConnectionStatus convertThingConnectionStatus(String str) {
        if (str == null) {
            return IODevice.ThingConnectionStatus.UNKNOWN;
        }
        str.hashCode();
        if (str.equals("dead")) {
            return IODevice.ThingConnectionStatus.DEAD;
        }
        if (str.equals("alive")) {
            return IODevice.ThingConnectionStatus.ALIVE;
        }
        return IODevice.ThingConnectionStatus.UNKNOWN;
    }
}
