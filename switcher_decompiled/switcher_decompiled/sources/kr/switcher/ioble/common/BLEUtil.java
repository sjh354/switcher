package kr.switcher.ioble.common;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.util.Log;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.Set;
import kotlin.UByte;

/* JADX INFO: loaded from: classes2.dex */
public class BLEUtil {
    private static Context context;
    private static final char[] hexArray = "0123456789ABCDEF".toCharArray();

    public static int getDayOfWeekNumberForSwitcher(int i) {
        if (i - 2 >= 0) {
            return i - 2;
        }
        return 6;
    }

    public static void setContext(Context context2) {
        context = context2;
    }

    public static Context getContext() {
        return context;
    }

    public static String hexToBinary(String str) {
        return String.format("%08d", Integer.valueOf(Integer.parseInt(new BigInteger(str, 16).toString(2))));
    }

    public static String hexToHexString(String str) {
        String str2 = "";
        int i = 0;
        for (int i2 = 0; i2 < str.length(); i2++) {
            i++;
            str2 = str2 + String.format("%02x", Integer.valueOf(Integer.parseInt(str.substring(i2, i))));
        }
        return str2;
    }

    public static byte[] hexStringToByteArray(String str) {
        int length = str.length();
        byte[] bArr = new byte[length / 2];
        for (int i = 0; i < length; i += 2) {
            bArr[i / 2] = (byte) ((Character.digit(str.charAt(i), 16) << 4) + Character.digit(str.charAt(i + 1), 16));
        }
        return bArr;
    }

    public static String bytesToHex(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & UByte.MAX_VALUE;
            int i3 = i * 2;
            char[] cArr2 = hexArray;
            cArr[i3] = cArr2[i2 >>> 4];
            cArr[i3 + 1] = cArr2[i2 & 15];
        }
        return new String(cArr);
    }

    public static void createBond(BluetoothDevice bluetoothDevice) {
        Set<BluetoothDevice> bondedDevices = ((BluetoothManager) context.getApplicationContext().getSystemService("bluetooth")).getAdapter().getBondedDevices();
        boolean z = false;
        if (bondedDevices.size() > 0) {
            Iterator<BluetoothDevice> it = bondedDevices.iterator();
            while (it.hasNext()) {
                if (bluetoothDevice.getAddress().equalsIgnoreCase(it.next().getAddress())) {
                    z = true;
                }
            }
        }
        if (z) {
            return;
        }
        try {
            bluetoothDevice.createBond();
            Log.e("BleDeviceConnection", "create bond (name:" + bluetoothDevice.getName() + ", address:" + bluetoothDevice.getAddress() + ")");
        } catch (Exception e) {
            Log.e("BleDeviceConnection", e.getMessage());
        }
    }

    public static void removeBond(BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice == null || bluetoothDevice.getBondState() == 10) {
            return;
        }
        try {
            bluetoothDevice.getClass().getMethod("removeBond", null).invoke(bluetoothDevice, null);
            Log.i("ContentValues", "deleted bonding information");
        } catch (Exception unused) {
            Log.e("ContentValues", "failed removeBond");
        }
    }

    public static void refreshCache(BluetoothGatt bluetoothGatt, boolean z) {
        if (bluetoothGatt == null) {
            return;
        }
        if (z || bluetoothGatt.getDevice().getBondState() == 10) {
            Log.i("ContentValues", "gatt.refresh() (hidden)");
            try {
                Method method = bluetoothGatt.getClass().getMethod("refresh", new Class[0]);
                if (method != null) {
                    Log.i("ContentValues", "Refreshing result: " + ((Boolean) method.invoke(bluetoothGatt, new Object[0])).booleanValue());
                    return;
                }
                return;
            } catch (Exception unused) {
                Log.d("ContentValues", "An exception occurred while refreshing device");
                return;
            }
        }
        removeBond(bluetoothGatt.getDevice());
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
}
