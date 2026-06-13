package no.nordicsemi.android.dfu;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.UUID;
import kotlin.UByte;
import no.nordicsemi.android.dfu.DfuCallback;
import no.nordicsemi.android.dfu.internal.ArchiveInputStream;
import no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException;
import no.nordicsemi.android.dfu.internal.exception.DfuException;
import no.nordicsemi.android.dfu.internal.exception.UploadAbortedException;
import no.nordicsemi.android.dfu.internal.scanner.BootloaderScannerFactory;

/* JADX INFO: loaded from: classes2.dex */
abstract class BaseDfuImpl implements DfuService {
    static final int INDICATIONS = 2;
    private static final int MAX_PACKET_SIZE_DEFAULT = 20;
    static final int NOTIFICATIONS = 1;
    private static final String TAG = "DfuImpl";
    boolean mAborted;
    private int mCurrentMtu;
    int mError;
    int mFileType;
    InputStream mFirmwareStream;
    BluetoothGatt mGatt;
    int mImageSizeInBytes;
    int mInitPacketSizeInBytes;
    InputStream mInitPacketStream;
    boolean mPaused;
    DfuProgressInfo mProgressInfo;
    boolean mRequestCompleted;
    boolean mResetRequestSent;
    DfuBaseService mService;
    static final UUID GENERIC_ATTRIBUTE_SERVICE_UUID = new UUID(26392574038016L, -9223371485494954757L);
    static final UUID SERVICE_CHANGED_UUID = new UUID(46200963207168L, -9223371485494954757L);
    static final UUID CLIENT_CHARACTERISTIC_CONFIG = new UUID(45088566677504L, -9223371485494954757L);
    private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();
    final Object mLock = new Object();
    byte[] mReceivedData = null;
    byte[] mBuffer = new byte[20];
    boolean mConnected = true;

    protected class BaseBluetoothGattCallback extends DfuCallback.DfuGattCallback {
        protected BaseBluetoothGattCallback() {
        }

        @Override // no.nordicsemi.android.dfu.DfuCallback.DfuGattCallback
        public void onDisconnected() {
            BaseDfuImpl.this.mConnected = false;
            BaseDfuImpl.this.notifyLock();
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            if (i == 0) {
                BaseDfuImpl.this.mService.sendLogBroadcast(5, "Read Response received from " + bluetoothGattCharacteristic.getUuid() + ", value (0x): " + parse(bluetoothGattCharacteristic));
                BaseDfuImpl.this.mReceivedData = bluetoothGattCharacteristic.getValue();
                BaseDfuImpl.this.mRequestCompleted = true;
            } else {
                BaseDfuImpl.this.loge("Characteristic read error: " + i);
                BaseDfuImpl.this.mError = i | 16384;
            }
            BaseDfuImpl.this.notifyLock();
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onDescriptorRead(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
            if (i == 0) {
                if (BaseDfuImpl.CLIENT_CHARACTERISTIC_CONFIG.equals(bluetoothGattDescriptor.getUuid())) {
                    BaseDfuImpl.this.mService.sendLogBroadcast(5, "Read Response received from descr." + bluetoothGattDescriptor.getCharacteristic().getUuid() + ", value (0x): " + parse(bluetoothGattDescriptor));
                    if (BaseDfuImpl.SERVICE_CHANGED_UUID.equals(bluetoothGattDescriptor.getCharacteristic().getUuid())) {
                        BaseDfuImpl.this.mRequestCompleted = true;
                    } else {
                        BaseDfuImpl.this.loge("Unknown descriptor read");
                    }
                }
            } else {
                BaseDfuImpl.this.loge("Descriptor read error: " + i);
                BaseDfuImpl.this.mError = i | 16384;
            }
            BaseDfuImpl.this.notifyLock();
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
            if (i == 0) {
                if (BaseDfuImpl.CLIENT_CHARACTERISTIC_CONFIG.equals(bluetoothGattDescriptor.getUuid())) {
                    BaseDfuImpl.this.mService.sendLogBroadcast(5, "Data written to descr." + bluetoothGattDescriptor.getCharacteristic().getUuid() + ", value (0x): " + parse(bluetoothGattDescriptor));
                    if (BaseDfuImpl.SERVICE_CHANGED_UUID.equals(bluetoothGattDescriptor.getCharacteristic().getUuid())) {
                        BaseDfuImpl.this.mService.sendLogBroadcast(1, "Indications enabled for " + bluetoothGattDescriptor.getCharacteristic().getUuid());
                    } else {
                        BaseDfuImpl.this.mService.sendLogBroadcast(1, "Notifications enabled for " + bluetoothGattDescriptor.getCharacteristic().getUuid());
                    }
                }
            } else {
                BaseDfuImpl.this.loge("Descriptor write error: " + i);
                BaseDfuImpl.this.mError = i | 16384;
            }
            BaseDfuImpl.this.notifyLock();
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onMtuChanged(BluetoothGatt bluetoothGatt, int i, int i2) {
            if (i2 == 0) {
                BaseDfuImpl.this.mService.sendLogBroadcast(5, "MTU changed to: " + i);
                int i3 = i - 3;
                if (i3 > BaseDfuImpl.this.mBuffer.length) {
                    BaseDfuImpl.this.mBuffer = new byte[i3];
                }
                BaseDfuImpl.this.logi("MTU changed to: " + i);
            } else {
                BaseDfuImpl.this.logw("Changing MTU failed: " + i2 + " (mtu: " + i + ")");
                if (i2 == 4 && BaseDfuImpl.this.mCurrentMtu > 23 && BaseDfuImpl.this.mCurrentMtu - 3 > BaseDfuImpl.this.mBuffer.length) {
                    BaseDfuImpl.this.mBuffer = new byte[r3.mCurrentMtu - 3];
                    BaseDfuImpl.this.logi("MTU restored to: " + BaseDfuImpl.this.mCurrentMtu);
                }
            }
            BaseDfuImpl.this.mRequestCompleted = true;
            BaseDfuImpl.this.notifyLock();
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onPhyUpdate(BluetoothGatt bluetoothGatt, int i, int i2, int i3) {
            if (i3 == 0) {
                BaseDfuImpl.this.mService.sendLogBroadcast(5, "PHY updated (TX: " + phyToString(i) + ", RX: " + phyToString(i2) + ")");
                BaseDfuImpl.this.logi("PHY updated (TX: " + phyToString(i) + ", RX: " + phyToString(i2) + ")");
            } else {
                BaseDfuImpl.this.logw("Updating PHY failed: " + i3 + " (txPhy: " + i + ", rxPhy: " + i2 + ")");
            }
        }

        protected String parse(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            return parse(bluetoothGattCharacteristic.getValue());
        }

        protected String parse(BluetoothGattDescriptor bluetoothGattDescriptor) {
            return parse(bluetoothGattDescriptor.getValue());
        }

        private String parse(byte[] bArr) {
            int length;
            if (bArr == null || (length = bArr.length) == 0) {
                return "";
            }
            char[] cArr = new char[(length * 3) - 1];
            for (int i = 0; i < length; i++) {
                int i2 = bArr[i] & UByte.MAX_VALUE;
                int i3 = i * 3;
                cArr[i3] = BaseDfuImpl.HEX_ARRAY[i2 >>> 4];
                cArr[i3 + 1] = BaseDfuImpl.HEX_ARRAY[i2 & 15];
                if (i != length - 1) {
                    cArr[i3 + 2] = '-';
                }
            }
            return new String(cArr);
        }

        private String phyToString(int i) {
            return i != 1 ? i != 2 ? i != 3 ? "UNKNOWN (" + i + ")" : "LE Coded" : "LE 2M" : "LE 1M";
        }
    }

    BaseDfuImpl(Intent intent, DfuBaseService dfuBaseService) {
        this.mService = dfuBaseService;
        this.mProgressInfo = dfuBaseService.mProgressInfo;
    }

    @Override // no.nordicsemi.android.dfu.DfuService
    public void release() {
        this.mService = null;
    }

    @Override // no.nordicsemi.android.dfu.DfuController
    public void pause() {
        this.mPaused = true;
    }

    @Override // no.nordicsemi.android.dfu.DfuController
    public void resume() {
        this.mPaused = false;
        notifyLock();
    }

    @Override // no.nordicsemi.android.dfu.DfuController
    public void abort() {
        this.mPaused = false;
        this.mAborted = true;
        notifyLock();
    }

    @Override // no.nordicsemi.android.dfu.DfuCallback
    public void onBondStateChanged(int i) {
        this.mRequestCompleted = true;
        notifyLock();
    }

    @Override // no.nordicsemi.android.dfu.DfuService
    public boolean initialize(Intent intent, BluetoothGatt bluetoothGatt, int i, InputStream inputStream, InputStream inputStream2) throws UploadAbortedException, DfuException, DeviceDisconnectedException {
        int iAvailable;
        BluetoothGattService service;
        BluetoothGattCharacteristic characteristic;
        this.mGatt = bluetoothGatt;
        this.mFileType = i;
        this.mFirmwareStream = inputStream;
        this.mInitPacketStream = inputStream2;
        int intExtra = intent.getIntExtra(DfuBaseService.EXTRA_PART_CURRENT, 1);
        int intExtra2 = intent.getIntExtra(DfuBaseService.EXTRA_PARTS_TOTAL, 1);
        this.mCurrentMtu = intent.getIntExtra(DfuBaseService.EXTRA_CURRENT_MTU, 23);
        if (i > 4) {
            logw("DFU target does not support (SD/BL)+App update, splitting into 2 parts");
            this.mService.sendLogBroadcast(15, "Sending system components");
            int i2 = this.mFileType & (-5);
            this.mFileType = i2;
            ((ArchiveInputStream) this.mFirmwareStream).setContentType(i2);
            intExtra2 = 2;
        }
        if (intExtra == 2) {
            this.mService.sendLogBroadcast(15, "Sending application");
        }
        int iAvailable2 = 0;
        if (inputStream2 != null) {
            try {
                if (inputStream2.markSupported()) {
                    inputStream2.reset();
                }
                iAvailable = inputStream2.available();
            } catch (Exception unused) {
                iAvailable = 0;
            }
        } else {
            iAvailable = 0;
        }
        this.mInitPacketSizeInBytes = iAvailable;
        try {
            if (inputStream.markSupported()) {
                if (inputStream instanceof ArchiveInputStream) {
                    ((ArchiveInputStream) inputStream).fullReset();
                } else {
                    inputStream.reset();
                }
            }
            iAvailable2 = inputStream.available();
        } catch (Exception unused2) {
        }
        this.mImageSizeInBytes = iAvailable2;
        this.mProgressInfo.init(iAvailable2, intExtra, intExtra2);
        if (bluetoothGatt.getDevice().getBondState() == 12 && (service = bluetoothGatt.getService(GENERIC_ATTRIBUTE_SERVICE_UUID)) != null && (characteristic = service.getCharacteristic(SERVICE_CHANGED_UUID)) != null) {
            if (!isServiceChangedCCCDEnabled()) {
                enableCCCD(characteristic, 2);
            }
            this.mService.sendLogBroadcast(10, "Service Changed indications enabled");
        }
        return true;
    }

    void notifyLock() {
        synchronized (this.mLock) {
            this.mLock.notifyAll();
        }
    }

    void waitIfPaused() {
        try {
            synchronized (this.mLock) {
                while (this.mPaused) {
                    this.mLock.wait();
                }
            }
        } catch (InterruptedException e) {
            loge("Sleeping interrupted", e);
        }
    }

    void enableCCCD(BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) throws UploadAbortedException, DfuException, DeviceDisconnectedException {
        BluetoothGatt bluetoothGatt = this.mGatt;
        String str = i == 1 ? "notifications" : "indications";
        if (!this.mConnected) {
            throw new DeviceDisconnectedException("Unable to set " + str + " state: device disconnected");
        }
        if (this.mAborted) {
            throw new UploadAbortedException();
        }
        this.mReceivedData = null;
        this.mError = 0;
        BluetoothGattDescriptor descriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIG);
        boolean z = descriptor.getValue() != null && descriptor.getValue().length == 2 && descriptor.getValue()[0] > 0 && descriptor.getValue()[1] == 0;
        if (z) {
            return;
        }
        logi("Enabling " + str + "...");
        this.mService.sendLogBroadcast(1, "Enabling " + str + " for " + bluetoothGattCharacteristic.getUuid());
        this.mService.sendLogBroadcast(0, "gatt.setCharacteristicNotification(" + bluetoothGattCharacteristic.getUuid() + ", true)");
        bluetoothGatt.setCharacteristicNotification(bluetoothGattCharacteristic, true);
        descriptor.setValue(i == 1 ? BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE : BluetoothGattDescriptor.ENABLE_INDICATION_VALUE);
        this.mService.sendLogBroadcast(0, "gatt.writeDescriptor(" + descriptor.getUuid() + (i == 1 ? ", value=0x01-00)" : ", value=0x02-00)"));
        bluetoothGatt.writeDescriptor(descriptor);
        try {
            synchronized (this.mLock) {
                while (true) {
                    if (!z) {
                        if (!this.mConnected || this.mError != 0) {
                        }
                        this.mLock.wait();
                        z = descriptor.getValue() == null && descriptor.getValue().length == 2 && descriptor.getValue()[0] > 0 && descriptor.getValue()[1] == 0;
                    }
                    if (!this.mPaused) {
                        break;
                    }
                    this.mLock.wait();
                    if (descriptor.getValue() == null) {
                    }
                }
            }
        } catch (InterruptedException e) {
            loge("Sleeping interrupted", e);
        }
        if (!this.mConnected) {
            throw new DeviceDisconnectedException("Unable to set " + str + " state: device disconnected");
        }
        if (this.mError != 0) {
            throw new DfuException("Unable to set " + str + " state", this.mError);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ba  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean isServiceChangedCCCDEnabled() throws no.nordicsemi.android.dfu.internal.exception.UploadAbortedException, no.nordicsemi.android.dfu.internal.exception.DfuException, no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException {
        /*
            Method dump skipped, instruction units count: 208
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: no.nordicsemi.android.dfu.BaseDfuImpl.isServiceChangedCCCDEnabled():boolean");
    }

    void writeOpCode(BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr, boolean z) throws UploadAbortedException, DfuException, DeviceDisconnectedException {
        boolean z2;
        if (this.mAborted) {
            throw new UploadAbortedException();
        }
        this.mReceivedData = null;
        this.mError = 0;
        this.mRequestCompleted = false;
        this.mResetRequestSent = z;
        bluetoothGattCharacteristic.setWriteType(2);
        bluetoothGattCharacteristic.setValue(bArr);
        this.mService.sendLogBroadcast(1, "Writing to characteristic " + bluetoothGattCharacteristic.getUuid());
        this.mService.sendLogBroadcast(0, "gatt.writeCharacteristic(" + bluetoothGattCharacteristic.getUuid() + ")");
        this.mGatt.writeCharacteristic(bluetoothGattCharacteristic);
        try {
        } catch (InterruptedException e) {
            loge("Sleeping interrupted", e);
        }
        synchronized (this.mLock) {
            while (true) {
                if ((this.mRequestCompleted || !this.mConnected || this.mError != 0) && !this.mPaused) {
                    break;
                } else {
                    this.mLock.wait();
                }
                loge("Sleeping interrupted", e);
                z2 = this.mResetRequestSent;
                if (z2 && !this.mConnected) {
                    throw new DeviceDisconnectedException("Unable to write Op Code " + ((int) bArr[0]) + ": device disconnected");
                }
                if (z2 && this.mError != 0) {
                    throw new DfuException("Unable to write Op Code " + ((int) bArr[0]), this.mError);
                }
            }
        }
        z2 = this.mResetRequestSent;
        if (z2) {
        }
        if (z2) {
        }
    }

    boolean createBond() {
        boolean zCreateBondApi18;
        BluetoothDevice device = this.mGatt.getDevice();
        if (device.getBondState() == 12) {
            return true;
        }
        this.mRequestCompleted = false;
        this.mService.sendLogBroadcast(1, "Starting pairing...");
        if (Build.VERSION.SDK_INT >= 19) {
            this.mService.sendLogBroadcast(0, "gatt.getDevice().createBond()");
            zCreateBondApi18 = device.createBond();
        } else {
            zCreateBondApi18 = createBondApi18(device);
        }
        try {
            synchronized (this.mLock) {
                while (!this.mRequestCompleted && !this.mAborted) {
                    this.mLock.wait();
                }
            }
        } catch (InterruptedException e) {
            loge("Sleeping interrupted", e);
        }
        return zCreateBondApi18;
    }

    private boolean createBondApi18(BluetoothDevice bluetoothDevice) {
        try {
            Method method = bluetoothDevice.getClass().getMethod("createBond", new Class[0]);
            this.mService.sendLogBroadcast(0, "gatt.getDevice().createBond() (hidden)");
            return ((Boolean) method.invoke(bluetoothDevice, new Object[0])).booleanValue();
        } catch (Exception e) {
            Log.w(TAG, "An exception occurred while creating bond", e);
            return false;
        }
    }

    boolean removeBond() {
        BluetoothDevice device = this.mGatt.getDevice();
        if (device.getBondState() == 10) {
            return true;
        }
        this.mService.sendLogBroadcast(1, "Removing bond information...");
        boolean zBooleanValue = false;
        try {
            Method method = device.getClass().getMethod("removeBond", new Class[0]);
            this.mRequestCompleted = false;
            this.mService.sendLogBroadcast(0, "gatt.getDevice().removeBond() (hidden)");
            zBooleanValue = ((Boolean) method.invoke(device, new Object[0])).booleanValue();
            try {
                synchronized (this.mLock) {
                    while (!this.mRequestCompleted && !this.mAborted) {
                        this.mLock.wait();
                    }
                }
            } catch (InterruptedException e) {
                loge("Sleeping interrupted", e);
            }
        } catch (Exception e2) {
            Log.w(TAG, "An exception occurred while removing bond information", e2);
        }
        return zBooleanValue;
    }

    boolean isBonded() {
        return this.mGatt.getDevice().getBondState() == 12;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x005e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void requestMtu(int r5) throws no.nordicsemi.android.dfu.internal.exception.UploadAbortedException, no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException {
        /*
            r4 = this;
            boolean r0 = r4.mAborted
            if (r0 != 0) goto L67
            r0 = 0
            r4.mRequestCompleted = r0
            no.nordicsemi.android.dfu.DfuBaseService r1 = r4.mService
            r2 = 1
            java.lang.String r3 = "Requesting new MTU..."
            r1.sendLogBroadcast(r2, r3)
            no.nordicsemi.android.dfu.DfuBaseService r1 = r4.mService
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "gatt.requestMtu("
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r5)
            java.lang.String r3 = ")"
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.sendLogBroadcast(r0, r2)
            android.bluetooth.BluetoothGatt r0 = r4.mGatt
            boolean r5 = r0.requestMtu(r5)
            if (r5 != 0) goto L36
            return
        L36:
            java.lang.Object r5 = r4.mLock     // Catch: java.lang.InterruptedException -> L54
            monitor-enter(r5)     // Catch: java.lang.InterruptedException -> L54
        L39:
            boolean r0 = r4.mRequestCompleted     // Catch: java.lang.Throwable -> L51
            if (r0 != 0) goto L45
            boolean r0 = r4.mConnected     // Catch: java.lang.Throwable -> L51
            if (r0 == 0) goto L45
            int r0 = r4.mError     // Catch: java.lang.Throwable -> L51
            if (r0 == 0) goto L49
        L45:
            boolean r0 = r4.mPaused     // Catch: java.lang.Throwable -> L51
            if (r0 == 0) goto L4f
        L49:
            java.lang.Object r0 = r4.mLock     // Catch: java.lang.Throwable -> L51
            r0.wait()     // Catch: java.lang.Throwable -> L51
            goto L39
        L4f:
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L51
            goto L5a
        L51:
            r0 = move-exception
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L51
            throw r0     // Catch: java.lang.InterruptedException -> L54
        L54:
            r5 = move-exception
            java.lang.String r0 = "Sleeping interrupted"
            r4.loge(r0, r5)
        L5a:
            boolean r5 = r4.mConnected
            if (r5 == 0) goto L5f
            return
        L5f:
            no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException r5 = new no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException
            java.lang.String r0 = "Unable to read Service Changed CCCD: device disconnected"
            r5.<init>(r0)
            throw r5
        L67:
            no.nordicsemi.android.dfu.internal.exception.UploadAbortedException r5 = new no.nordicsemi.android.dfu.internal.exception.UploadAbortedException
            r5.<init>()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: no.nordicsemi.android.dfu.BaseDfuImpl.requestMtu(int):void");
    }

    byte[] readNotificationResponse() throws UploadAbortedException, DfuException, DeviceDisconnectedException {
        try {
            synchronized (this.mLock) {
                while (true) {
                    if ((this.mReceivedData != null || !this.mConnected || this.mError != 0 || this.mAborted) && !this.mPaused) {
                        break;
                    }
                    this.mLock.wait();
                }
            }
        } catch (InterruptedException e) {
            loge("Sleeping interrupted", e);
        }
        if (this.mAborted) {
            throw new UploadAbortedException();
        }
        if (!this.mConnected) {
            throw new DeviceDisconnectedException("Unable to write Op Code: device disconnected");
        }
        if (this.mError != 0) {
            throw new DfuException("Unable to write Op Code", this.mError);
        }
        return this.mReceivedData;
    }

    void restartService(Intent intent, boolean z) {
        String strSearchFor;
        if (z) {
            this.mService.sendLogBroadcast(1, "Scanning for the DFU Bootloader...");
            strSearchFor = BootloaderScannerFactory.getScanner().searchFor(this.mGatt.getDevice().getAddress());
            logi("Scanning for new address finished with: " + strSearchFor);
            if (strSearchFor != null) {
                this.mService.sendLogBroadcast(5, "DFU Bootloader found with address " + strSearchFor);
            } else {
                this.mService.sendLogBroadcast(5, "DFU Bootloader not found. Trying the same address...");
            }
        } else {
            strSearchFor = null;
        }
        if (strSearchFor != null) {
            intent.putExtra(DfuBaseService.EXTRA_DEVICE_ADDRESS, strSearchFor);
        }
        intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_DFU_ATTEMPT", 0);
        this.mService.startService(intent);
    }

    protected String parse(byte[] bArr) {
        int length;
        if (bArr == null || (length = bArr.length) == 0) {
            return "";
        }
        char[] cArr = new char[(length * 3) - 1];
        for (int i = 0; i < length; i++) {
            int i2 = bArr[i] & UByte.MAX_VALUE;
            int i3 = i * 3;
            char[] cArr2 = HEX_ARRAY;
            cArr[i3] = cArr2[i2 >>> 4];
            cArr[i3 + 1] = cArr2[i2 & 15];
            if (i != length - 1) {
                cArr[i3 + 2] = '-';
            }
        }
        return new String(cArr);
    }

    void loge(String str) {
        Log.e(TAG, str);
    }

    void loge(String str, Throwable th) {
        Log.e(TAG, str, th);
    }

    void logw(String str) {
        if (DfuBaseService.DEBUG) {
            Log.w(TAG, str);
        }
    }

    void logi(String str) {
        if (DfuBaseService.DEBUG) {
            Log.i(TAG, str);
        }
    }
}
