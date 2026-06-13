package kr.switcher.switcherm.device.switcher.handler;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kr.switcher.device.IODevice;
import kr.switcher.device.common.DeviceUtil;
import kr.switcher.device.switcher.Switcher;
import kr.switcher.device.switcher.ble.ScannedBLESwitcher;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.database.DBIODevice;
import kr.switcher.switcherm.device.switcher.SwitcherFactory;
import kr.switcher.switcherm.preference.OAuthToken;
import kr.switcher.switcherm.preference.PreferenceHelper;
import kr.switcher.switcherm.preference.TimerVersion;

/* JADX INFO: loaded from: classes2.dex */
public class SwitcherUtil {
    private static final String TAG = "SwitcherUtil";

    public static BluetoothDevice getConnectedBluetoothDevice(Context context, String str, Switcher switcher) {
        if (context == null) {
            return null;
        }
        BluetoothDevice bluetoothDevice = null;
        for (BluetoothDevice bluetoothDevice2 : ((BluetoothManager) context.getSystemService("bluetooth")).getConnectedDevices(7)) {
            if (bluetoothDevice2.getAddress().equalsIgnoreCase(str)) {
                bluetoothDevice = bluetoothDevice2;
            }
        }
        if (bluetoothDevice == null || switcher == null) {
            return null;
        }
        IOLog.i(TAG, "connected switcher is present");
        return bluetoothDevice;
    }

    public static int checkSwitcherToConnect(Switcher switcher) {
        BluetoothDevice connectedBluetoothDevice = getConnectedBluetoothDevice(PreferenceHelper.context, switcher.getMacAddress(), switcher);
        if (connectedBluetoothDevice != null) {
            switcher.attachToDevice(new ScannedBLESwitcher(connectedBluetoothDevice, null));
            return 1;
        }
        if (switcher.getAttachedDevice() == null) {
            IOLog.i(TAG, "not attached ble device (state:" + switcher.getConnectionState() + ")");
            return 202;
        }
        String serialNumber = switcher.getAttachedDevice().getAdvertisementPacket().getSerialNumber();
        if (serialNumber == null || serialNumber.equalsIgnoreCase("")) {
            IOLog.error(TAG, new OAuthToken().getOAuthToken(), "checkConnectToSwitcher", new Exception("no productcode in ad"));
        }
        if (switcher.getAttachedDevice().getAdvertisementPacket().getSwitcherType() != 0) {
            return 1;
        }
        IOLog.error(TAG, new OAuthToken().getOAuthToken(), "checkConnectToSwitcher", new Exception("no way info in ad"));
        return 1;
    }

    public static String getPaymentDate(Switcher switcher) {
        return switcher.getDeviceOption().getPaymentInfo().getNextPayAt().split("-")[0] + IOUtil.getStringResource(R.string.year) + " " + switcher.getDeviceOption().getPaymentInfo().getNextPayAt().split("-")[1] + IOUtil.getStringResource(R.string.month) + " " + switcher.getDeviceOption().getPaymentInfo().getNextPayAt().split("-")[2].substring(0, 2) + IOUtil.getStringResource(R.string.day);
    }

    public static IODevice convertDbIODeviceToIODevice(DBIODevice dBIODevice) {
        IODevice iODeviceCreateIODevice;
        if (dBIODevice == null || (iODeviceCreateIODevice = new SwitcherFactory().createIODevice(DeviceUtil.convertProductId(dBIODevice.getProductId()), dBIODevice.getMacAddress(), dBIODevice.getSerialNumber(), dBIODevice.getOwner())) == null) {
            return null;
        }
        if (dBIODevice.getShareCode() != null && dBIODevice.getShareCode().length() >= 4) {
            iODeviceCreateIODevice.setShareCode(dBIODevice.getShareCode());
        }
        if (dBIODevice.isMine() == 0) {
            iODeviceCreateIODevice.beGuest();
        }
        return iODeviceCreateIODevice;
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
        if (PreferenceHelper.context == null) {
            return new ArrayList();
        }
        BluetoothManager bluetoothManager = (BluetoothManager) PreferenceHelper.context.getSystemService("bluetooth");
        if (bluetoothManager == null) {
            return new ArrayList();
        }
        try {
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
        } catch (NullPointerException e) {
            IOLog.i(TAG, e.getMessage());
            return new ArrayList();
        }
    }

    public static int isSwitcherConnected(Switcher switcher) {
        if (switcher == null) {
            return 101;
        }
        return switcher.getConnectionState() != Switcher.ConnectionState.CONNECTED ? 203 : 1;
    }

    public static void activeBluetooth() {
        try {
            BluetoothManager bluetoothManager = (BluetoothManager) PreferenceHelper.context.getSystemService("bluetooth");
            if (bluetoothManager.getAdapter().isEnabled()) {
                return;
            }
            bluetoothManager.getAdapter().enable();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    public static void unactiveBluetooth() {
        try {
            BluetoothManager bluetoothManager = (BluetoothManager) PreferenceHelper.context.getSystemService("bluetooth");
            if (bluetoothManager.getAdapter().isEnabled()) {
                bluetoothManager.getAdapter().disable();
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    public static boolean isBluetoothActive() {
        try {
            return ((BluetoothManager) PreferenceHelper.context.getSystemService("bluetooth")).getAdapter().isEnabled();
        } catch (NullPointerException unused) {
            return false;
        }
    }

    public static void activeBluetoothIfOffWithDelay() {
        if (isBluetoothActive()) {
            return;
        }
        activeBluetooth();
        IOUtil.sleep(2000);
    }

    public static void setLastTimerVersion() {
        new TimerVersion().setTimerVersion(Switcher.SwitcherReservation.currentTimerVersion);
    }

    public static int getSwitcherReservationId(List<Switcher.SwitcherReservation> list) {
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
}
