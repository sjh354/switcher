package no.nordicsemi.android.dfu;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.content.Intent;
import android.preference.PreferenceManager;
import java.util.UUID;
import no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException;
import no.nordicsemi.android.dfu.internal.exception.DfuException;
import no.nordicsemi.android.dfu.internal.exception.UploadAbortedException;

/* JADX INFO: loaded from: classes2.dex */
class LegacyButtonlessDfuImpl extends BaseButtonlessDfuImpl {
    private BluetoothGattCharacteristic mControlPointCharacteristic;
    private int mVersion;
    static UUID DFU_SERVICE_UUID = LegacyDfuImpl.DEFAULT_DFU_SERVICE_UUID;
    static UUID DFU_CONTROL_POINT_UUID = LegacyDfuImpl.DEFAULT_DFU_CONTROL_POINT_UUID;
    static UUID DFU_VERSION_UUID = LegacyDfuImpl.DEFAULT_DFU_VERSION_UUID;
    private static final byte[] OP_CODE_ENTER_BOOTLOADER = {1, 4};

    private String getVersionFeatures(int i) {
        return i != 0 ? i != 1 ? i != 5 ? i != 6 ? i != 7 ? i != 8 ? "Unknown version" : "Bootloader from SDK 9.0 or newer. Signature supported" : "Bootloader from SDK 8.0 or newer. SHA-256 used instead of CRC-16 in the Init Packet" : "Bootloader from SDK 8.0 or newer. Bond sharing supported" : "Bootloader from SDK 7.0 or newer. No bond sharing" : "Application with Legacy buttonless update from SDK 7.0 or newer" : "Bootloader from SDK 6.1 or older";
    }

    LegacyButtonlessDfuImpl(Intent intent, DfuBaseService dfuBaseService) {
        super(intent, dfuBaseService);
    }

    @Override // no.nordicsemi.android.dfu.DfuService
    public boolean isClientCompatible(Intent intent, BluetoothGatt bluetoothGatt) throws UploadAbortedException, DfuException, DeviceDisconnectedException {
        BluetoothGattCharacteristic characteristic;
        int version;
        BluetoothGattService service = bluetoothGatt.getService(DFU_SERVICE_UUID);
        if (service == null || (characteristic = service.getCharacteristic(DFU_CONTROL_POINT_UUID)) == null || characteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIG) == null) {
            return false;
        }
        this.mControlPointCharacteristic = characteristic;
        this.mProgressInfo.setProgress(-2);
        this.mService.waitFor(1000);
        BluetoothGattCharacteristic characteristic2 = service.getCharacteristic(DFU_VERSION_UUID);
        if (characteristic2 != null) {
            version = readVersion(bluetoothGatt, characteristic2);
            this.mVersion = version;
            int i = version & 15;
            int i2 = version >> 8;
            logi("Version number read: " + i2 + "." + i + " -> " + getVersionFeatures(version));
            this.mService.sendLogBroadcast(10, "Version number read: " + i2 + "." + i);
        } else {
            logi("No DFU Version characteristic found -> " + getVersionFeatures(0));
            this.mService.sendLogBroadcast(10, "DFU Version characteristic not found");
            version = 0;
        }
        boolean booleanExtra = PreferenceManager.getDefaultSharedPreferences(this.mService).getBoolean(DfuSettingsConstants.SETTINGS_ASSUME_DFU_NODE, false);
        if (intent.hasExtra(DfuBaseService.EXTRA_FORCE_DFU)) {
            booleanExtra = intent.getBooleanExtra(DfuBaseService.EXTRA_FORCE_DFU, false);
        }
        boolean z = bluetoothGatt.getServices().size() > 3;
        if (version == 0 && z) {
            logi("Additional services found -> Bootloader from SDK 6.1. Updating SD and BL supported, extended init packet not supported");
        }
        return version == 1 || (!booleanExtra && version == 0 && z);
    }

    @Override // no.nordicsemi.android.dfu.DfuService
    public void performDfu(Intent intent) throws UploadAbortedException, DfuException, DeviceDisconnectedException {
        logw("Application with legacy buttonless update found");
        this.mService.sendLogBroadcast(15, "Application with buttonless update found");
        this.mService.sendLogBroadcast(1, "Jumping to the DFU Bootloader...");
        enableCCCD(this.mControlPointCharacteristic, 1);
        this.mService.sendLogBroadcast(10, "Notifications enabled");
        this.mService.waitFor(1000);
        this.mProgressInfo.setProgress(-3);
        logi("Sending Start DFU command (Op Code = 1, Upload Mode = 4)");
        writeOpCode(this.mControlPointCharacteristic, OP_CODE_ENTER_BOOTLOADER, true);
        this.mService.sendLogBroadcast(10, "Jump to bootloader sent (Op Code = 1, Upload Mode = 4)");
        this.mService.waitUntilDisconnected();
        this.mService.sendLogBroadcast(5, "Disconnected by the remote device");
        BluetoothGatt bluetoothGatt = this.mGatt;
        BluetoothGattService service = bluetoothGatt.getService(GENERIC_ATTRIBUTE_SERVICE_UUID);
        this.mService.refreshDeviceCache(bluetoothGatt, !((service == null || service.getCharacteristic(SERVICE_CHANGED_UUID) == null) ? false : true));
        this.mService.close(bluetoothGatt);
        logi("Starting service that will connect to the DFU bootloader");
        Intent intent2 = new Intent();
        intent2.fillIn(intent, 24);
        restartService(intent2, this.mVersion == 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0096  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int readVersion(android.bluetooth.BluetoothGatt r6, android.bluetooth.BluetoothGattCharacteristic r7) throws no.nordicsemi.android.dfu.internal.exception.UploadAbortedException, no.nordicsemi.android.dfu.internal.exception.DfuException, no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException {
        /*
            r5 = this;
            boolean r0 = r5.mConnected
            if (r0 == 0) goto La4
            boolean r0 = r5.mAborted
            if (r0 != 0) goto L9e
            r0 = 0
            if (r7 != 0) goto Lc
            return r0
        Lc:
            r1 = 0
            r5.mReceivedData = r1
            r5.mError = r0
            java.lang.String r2 = "Reading DFU version number..."
            r5.logi(r2)
            no.nordicsemi.android.dfu.DfuBaseService r2 = r5.mService
            r3 = 1
            java.lang.String r4 = "Reading DFU version number..."
            r2.sendLogBroadcast(r3, r4)
            r2 = r1
            byte[] r2 = (byte[]) r2
            r7.setValue(r1)
            no.nordicsemi.android.dfu.DfuBaseService r1 = r5.mService
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "gatt.readCharacteristic("
            java.lang.StringBuilder r2 = r2.append(r3)
            java.util.UUID r3 = r7.getUuid()
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = ")"
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.sendLogBroadcast(r0, r2)
            r6.readCharacteristic(r7)
            java.lang.Object r6 = r5.mLock     // Catch: java.lang.InterruptedException -> L73
            monitor-enter(r6)     // Catch: java.lang.InterruptedException -> L73
        L4c:
            boolean r1 = r5.mRequestCompleted     // Catch: java.lang.Throwable -> L70
            if (r1 == 0) goto L56
            byte[] r1 = r7.getValue()     // Catch: java.lang.Throwable -> L70
            if (r1 != 0) goto L62
        L56:
            boolean r1 = r5.mConnected     // Catch: java.lang.Throwable -> L70
            if (r1 == 0) goto L62
            int r1 = r5.mError     // Catch: java.lang.Throwable -> L70
            if (r1 != 0) goto L62
            boolean r1 = r5.mAborted     // Catch: java.lang.Throwable -> L70
            if (r1 == 0) goto L66
        L62:
            boolean r1 = r5.mPaused     // Catch: java.lang.Throwable -> L70
            if (r1 == 0) goto L6e
        L66:
            r5.mRequestCompleted = r0     // Catch: java.lang.Throwable -> L70
            java.lang.Object r1 = r5.mLock     // Catch: java.lang.Throwable -> L70
            r1.wait()     // Catch: java.lang.Throwable -> L70
            goto L4c
        L6e:
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L70
            goto L79
        L70:
            r1 = move-exception
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L70
            throw r1     // Catch: java.lang.InterruptedException -> L73
        L73:
            r6 = move-exception
            java.lang.String r1 = "Sleeping interrupted"
            r5.loge(r1, r6)
        L79:
            boolean r6 = r5.mConnected
            if (r6 == 0) goto L96
            int r6 = r5.mError
            if (r6 != 0) goto L8c
            r6 = 18
            java.lang.Integer r6 = r7.getIntValue(r6, r0)
            int r6 = r6.intValue()
            return r6
        L8c:
            no.nordicsemi.android.dfu.internal.exception.DfuException r6 = new no.nordicsemi.android.dfu.internal.exception.DfuException
            java.lang.String r7 = "Unable to read version number"
            int r0 = r5.mError
            r6.<init>(r7, r0)
            throw r6
        L96:
            no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException r6 = new no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException
            java.lang.String r7 = "Unable to read version number: device disconnected"
            r6.<init>(r7)
            throw r6
        L9e:
            no.nordicsemi.android.dfu.internal.exception.UploadAbortedException r6 = new no.nordicsemi.android.dfu.internal.exception.UploadAbortedException
            r6.<init>()
            throw r6
        La4:
            no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException r6 = new no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException
            java.lang.String r7 = "Unable to read version number: device disconnected"
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: no.nordicsemi.android.dfu.LegacyButtonlessDfuImpl.readVersion(android.bluetooth.BluetoothGatt, android.bluetooth.BluetoothGattCharacteristic):int");
    }
}
