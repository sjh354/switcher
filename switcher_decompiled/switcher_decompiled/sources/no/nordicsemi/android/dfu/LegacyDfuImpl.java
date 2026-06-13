package no.nordicsemi.android.dfu;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.content.Intent;
import java.util.UUID;
import no.nordicsemi.android.dfu.BaseCustomDfuImpl;
import no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException;
import no.nordicsemi.android.dfu.internal.exception.DfuException;
import no.nordicsemi.android.dfu.internal.exception.UnknownResponseException;
import no.nordicsemi.android.dfu.internal.exception.UploadAbortedException;

/* JADX INFO: loaded from: classes2.dex */
class LegacyDfuImpl extends BaseCustomDfuImpl {
    static final UUID DEFAULT_DFU_CONTROL_POINT_UUID;
    static final UUID DEFAULT_DFU_PACKET_UUID;
    static final UUID DEFAULT_DFU_SERVICE_UUID;
    static final UUID DEFAULT_DFU_VERSION_UUID;
    static UUID DFU_CONTROL_POINT_UUID = null;
    static UUID DFU_PACKET_UUID = null;
    static UUID DFU_SERVICE_UUID = null;
    private static final int DFU_STATUS_SUCCESS = 1;
    static UUID DFU_VERSION_UUID = null;
    private static final byte[] OP_CODE_ACTIVATE_AND_RESET;
    private static final int OP_CODE_ACTIVATE_AND_RESET_KEY = 5;
    private static final byte[] OP_CODE_INIT_DFU_PARAMS;
    private static final byte[] OP_CODE_INIT_DFU_PARAMS_COMPLETE;
    private static final int OP_CODE_INIT_DFU_PARAMS_KEY = 2;
    private static final byte[] OP_CODE_INIT_DFU_PARAMS_START;
    private static final int OP_CODE_PACKET_RECEIPT_NOTIF_KEY = 17;
    private static final byte[] OP_CODE_PACKET_RECEIPT_NOTIF_REQ;
    private static final int OP_CODE_PACKET_RECEIPT_NOTIF_REQ_KEY = 8;
    private static final byte[] OP_CODE_RECEIVE_FIRMWARE_IMAGE;
    private static final int OP_CODE_RECEIVE_FIRMWARE_IMAGE_KEY = 3;
    private static final byte[] OP_CODE_RESET;
    private static final int OP_CODE_RESET_KEY = 6;
    private static final int OP_CODE_RESPONSE_CODE_KEY = 16;
    private static final byte[] OP_CODE_START_DFU;
    private static final int OP_CODE_START_DFU_KEY = 1;
    private static final byte[] OP_CODE_START_DFU_V1;
    private static final byte[] OP_CODE_VALIDATE;
    private static final int OP_CODE_VALIDATE_KEY = 4;
    private final LegacyBluetoothCallback mBluetoothCallback;
    private BluetoothGattCharacteristic mControlPointCharacteristic;
    private boolean mImageSizeInProgress;
    private BluetoothGattCharacteristic mPacketCharacteristic;

    static {
        UUID uuid = new UUID(23296205844446L, 1523193452336828707L);
        DEFAULT_DFU_SERVICE_UUID = uuid;
        UUID uuid2 = new UUID(23300500811742L, 1523193452336828707L);
        DEFAULT_DFU_CONTROL_POINT_UUID = uuid2;
        UUID uuid3 = new UUID(23304795779038L, 1523193452336828707L);
        DEFAULT_DFU_PACKET_UUID = uuid3;
        UUID uuid4 = new UUID(23313385713630L, 1523193452336828707L);
        DEFAULT_DFU_VERSION_UUID = uuid4;
        DFU_SERVICE_UUID = uuid;
        DFU_CONTROL_POINT_UUID = uuid2;
        DFU_PACKET_UUID = uuid3;
        DFU_VERSION_UUID = uuid4;
        OP_CODE_START_DFU = new byte[]{1, 0};
        OP_CODE_START_DFU_V1 = new byte[]{1};
        OP_CODE_INIT_DFU_PARAMS = new byte[]{2};
        OP_CODE_INIT_DFU_PARAMS_START = new byte[]{2, 0};
        OP_CODE_INIT_DFU_PARAMS_COMPLETE = new byte[]{2, 1};
        OP_CODE_RECEIVE_FIRMWARE_IMAGE = new byte[]{3};
        OP_CODE_VALIDATE = new byte[]{4};
        OP_CODE_ACTIVATE_AND_RESET = new byte[]{5};
        OP_CODE_RESET = new byte[]{6};
        OP_CODE_PACKET_RECEIPT_NOTIF_REQ = new byte[]{8, 0, 0};
    }

    protected class LegacyBluetoothCallback extends BaseCustomDfuImpl.BaseCustomBluetoothCallback {
        protected LegacyBluetoothCallback() {
            super();
        }

        @Override // no.nordicsemi.android.dfu.BaseCustomDfuImpl.BaseCustomBluetoothCallback
        protected void onPacketCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            if (LegacyDfuImpl.this.mImageSizeInProgress) {
                LegacyDfuImpl.this.mService.sendLogBroadcast(5, "Data written to " + bluetoothGattCharacteristic.getUuid() + ", value (0x): " + parse(bluetoothGattCharacteristic));
                LegacyDfuImpl.this.mImageSizeInProgress = false;
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            if (bluetoothGattCharacteristic.getIntValue(17, 0).intValue() == 17) {
                LegacyDfuImpl.this.mProgressInfo.setBytesReceived(bluetoothGattCharacteristic.getIntValue(20, 1).intValue());
                handlePacketReceiptNotification(bluetoothGatt, bluetoothGattCharacteristic);
            } else if (!LegacyDfuImpl.this.mRemoteErrorOccurred) {
                if (bluetoothGattCharacteristic.getIntValue(17, 2).intValue() != 1) {
                    LegacyDfuImpl.this.mRemoteErrorOccurred = true;
                }
                handleNotification(bluetoothGatt, bluetoothGattCharacteristic);
            }
            LegacyDfuImpl.this.notifyLock();
        }
    }

    LegacyDfuImpl(Intent intent, DfuBaseService dfuBaseService) {
        super(intent, dfuBaseService);
        this.mBluetoothCallback = new LegacyBluetoothCallback();
    }

    @Override // no.nordicsemi.android.dfu.DfuService
    public boolean isClientCompatible(Intent intent, BluetoothGatt bluetoothGatt) {
        BluetoothGattCharacteristic characteristic;
        BluetoothGattService service = bluetoothGatt.getService(DFU_SERVICE_UUID);
        if (service == null || (characteristic = service.getCharacteristic(DFU_CONTROL_POINT_UUID)) == null || characteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIG) == null) {
            return false;
        }
        this.mControlPointCharacteristic = characteristic;
        BluetoothGattCharacteristic characteristic2 = service.getCharacteristic(DFU_PACKET_UUID);
        this.mPacketCharacteristic = characteristic2;
        return characteristic2 != null;
    }

    @Override // no.nordicsemi.android.dfu.DfuCallback
    public BaseCustomDfuImpl.BaseCustomBluetoothCallback getGattCallback() {
        return this.mBluetoothCallback;
    }

    @Override // no.nordicsemi.android.dfu.BaseCustomDfuImpl
    protected UUID getControlPointCharacteristicUUID() {
        return DFU_CONTROL_POINT_UUID;
    }

    @Override // no.nordicsemi.android.dfu.BaseCustomDfuImpl
    protected UUID getPacketCharacteristicUUID() {
        return DFU_PACKET_UUID;
    }

    @Override // no.nordicsemi.android.dfu.BaseCustomDfuImpl
    protected UUID getDfuServiceUUID() {
        return DFU_SERVICE_UUID;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(7:(9:174|36|37|165|38|39|167|40|41)|(3:169|43|44)(12:47|(5:50|51|160|52|53)|80|98|(4:100|(1:102)(1:103)|104|(1:106)(2:107|108))|(1:116)(1:115)|(1:118)|119|163|120|121|(2:123|(4:125|(1:127)(1:128)|129|179)(2:130|131))(2:132|133))|67|68|159|69|(1:178)(2:74|(2:76|77)(12:78|(2:81|82)|80|98|(0)|(4:110|112|114|116)(0)|(0)|119|163|120|121|(0)(0)))) */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x06be, code lost:
    
        throw new no.nordicsemi.android.dfu.internal.exception.RemoteDfuException(r6, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x06bf, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x06c1, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x06d4, code lost:
    
        r2 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0335, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x033c, code lost:
    
        if (r0.getErrorNumber() != 3) goto L140;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0341, code lost:
    
        r27.mRemoteErrorOccurred = false;
        logw("DFU target does not support DFU v.2");
        r27.mService.sendLogBroadcast(15, "DFU target does not support DFU v.2");
        r27.mService.sendLogBroadcast(1, "Switching to DFU v.1");
        logi("Resending Start DFU command (Op Code = 1)");
        writeOpCode(r27.mControlPointCharacteristic, no.nordicsemi.android.dfu.LegacyDfuImpl.OP_CODE_START_DFU_V1);
        r27.mService.sendLogBroadcast(10, "DFU Start sent (Op Code = 1)");
        logi("Sending application image size to DFU Packet: " + r27.mImageSizeInBytes + " bytes");
        writeImageSize(r27.mPacketCharacteristic, r27.mImageSizeInBytes);
        r27.mService.sendLogBroadcast(10, "Firmware image size sent (" + r27.mImageSizeInBytes + " bytes)");
        r3 = readNotificationResponse();
        r5 = getStatusCode(r3, 1);
        r4 = ", Status = ";
        r27.mService.sendLogBroadcast(10, "Response received (Op Code = " + ((int) r3[1]) + r4 + r5 + ")");
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x03e6, code lost:
    
        if (r5 == 2) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x03e8, code lost:
    
        resetAndRestart(r14, r28);
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x03eb, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x03ed, code lost:
    
        if (r5 == 1) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x03ef, code lost:
    
        r3 = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x03f4 A[Catch: UnknownResponseException -> 0x01fe, UploadAbortedException -> 0x0206, RemoteDfuException -> 0x06c1, TryCatch #10 {RemoteDfuException -> 0x06c1, blocks: (B:87:0x0337, B:91:0x0341, B:93:0x03e8, B:98:0x03f0, B:100:0x03f4, B:102:0x03ff, B:104:0x0475, B:107:0x04a9, B:108:0x04b0, B:103:0x0445, B:110:0x04b3, B:112:0x04b7, B:118:0x04c5, B:119:0x0509, B:120:0x0528, B:121:0x053b, B:123:0x05a5, B:125:0x066d, B:129:0x069c, B:130:0x06a1, B:131:0x06a8, B:132:0x06a9, B:133:0x06b0, B:135:0x06b2, B:136:0x06b8, B:116:0x04c1, B:137:0x06b9, B:138:0x06be, B:139:0x06bf, B:140:0x06c0), top: B:171:0x0337 }] */
    /* JADX WARN: Removed duplicated region for block: B:116:0x04c1 A[Catch: UnknownResponseException -> 0x01fe, UploadAbortedException -> 0x0206, RemoteDfuException -> 0x06c1, TryCatch #10 {RemoteDfuException -> 0x06c1, blocks: (B:87:0x0337, B:91:0x0341, B:93:0x03e8, B:98:0x03f0, B:100:0x03f4, B:102:0x03ff, B:104:0x0475, B:107:0x04a9, B:108:0x04b0, B:103:0x0445, B:110:0x04b3, B:112:0x04b7, B:118:0x04c5, B:119:0x0509, B:120:0x0528, B:121:0x053b, B:123:0x05a5, B:125:0x066d, B:129:0x069c, B:130:0x06a1, B:131:0x06a8, B:132:0x06a9, B:133:0x06b0, B:135:0x06b2, B:136:0x06b8, B:116:0x04c1, B:137:0x06b9, B:138:0x06be, B:139:0x06bf, B:140:0x06c0), top: B:171:0x0337 }] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x04c5 A[Catch: UnknownResponseException -> 0x01fe, UploadAbortedException -> 0x0206, RemoteDfuException -> 0x06c1, TryCatch #10 {RemoteDfuException -> 0x06c1, blocks: (B:87:0x0337, B:91:0x0341, B:93:0x03e8, B:98:0x03f0, B:100:0x03f4, B:102:0x03ff, B:104:0x0475, B:107:0x04a9, B:108:0x04b0, B:103:0x0445, B:110:0x04b3, B:112:0x04b7, B:118:0x04c5, B:119:0x0509, B:120:0x0528, B:121:0x053b, B:123:0x05a5, B:125:0x066d, B:129:0x069c, B:130:0x06a1, B:131:0x06a8, B:132:0x06a9, B:133:0x06b0, B:135:0x06b2, B:136:0x06b8, B:116:0x04c1, B:137:0x06b9, B:138:0x06be, B:139:0x06bf, B:140:0x06c0), top: B:171:0x0337 }] */
    /* JADX WARN: Removed duplicated region for block: B:123:0x05a5 A[Catch: UnknownResponseException -> 0x01fe, UploadAbortedException -> 0x0206, RemoteDfuException -> 0x06c1, TryCatch #10 {RemoteDfuException -> 0x06c1, blocks: (B:87:0x0337, B:91:0x0341, B:93:0x03e8, B:98:0x03f0, B:100:0x03f4, B:102:0x03ff, B:104:0x0475, B:107:0x04a9, B:108:0x04b0, B:103:0x0445, B:110:0x04b3, B:112:0x04b7, B:118:0x04c5, B:119:0x0509, B:120:0x0528, B:121:0x053b, B:123:0x05a5, B:125:0x066d, B:129:0x069c, B:130:0x06a1, B:131:0x06a8, B:132:0x06a9, B:133:0x06b0, B:135:0x06b2, B:136:0x06b8, B:116:0x04c1, B:137:0x06b9, B:138:0x06be, B:139:0x06bf, B:140:0x06c0), top: B:171:0x0337 }] */
    /* JADX WARN: Removed duplicated region for block: B:132:0x06a9 A[Catch: UnknownResponseException -> 0x01fe, UploadAbortedException -> 0x0206, RemoteDfuException -> 0x06c1, TryCatch #10 {RemoteDfuException -> 0x06c1, blocks: (B:87:0x0337, B:91:0x0341, B:93:0x03e8, B:98:0x03f0, B:100:0x03f4, B:102:0x03ff, B:104:0x0475, B:107:0x04a9, B:108:0x04b0, B:103:0x0445, B:110:0x04b3, B:112:0x04b7, B:118:0x04c5, B:119:0x0509, B:120:0x0528, B:121:0x053b, B:123:0x05a5, B:125:0x066d, B:129:0x069c, B:130:0x06a1, B:131:0x06a8, B:132:0x06a9, B:133:0x06b0, B:135:0x06b2, B:136:0x06b8, B:116:0x04c1, B:137:0x06b9, B:138:0x06be, B:139:0x06bf, B:140:0x06c0), top: B:171:0x0337 }] */
    @Override // no.nordicsemi.android.dfu.DfuService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void performDfu(android.content.Intent r28) throws no.nordicsemi.android.dfu.internal.exception.UploadAbortedException, no.nordicsemi.android.dfu.internal.exception.DfuException, no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException {
        /*
            Method dump skipped, instruction units count: 1915
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: no.nordicsemi.android.dfu.LegacyDfuImpl.performDfu(android.content.Intent):void");
    }

    private void setNumberOfPackets(byte[] bArr, int i) {
        bArr[1] = (byte) (i & 255);
        bArr[2] = (byte) ((i >> 8) & 255);
    }

    private int getStatusCode(byte[] bArr, int i) throws UnknownResponseException {
        byte b;
        if (bArr == null || bArr.length != 3 || bArr[0] != 16 || bArr[1] != i || (b = bArr[2]) < 1 || b > 6) {
            throw new UnknownResponseException("Invalid response received", bArr, 16, i);
        }
        return b;
    }

    private int readVersion(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        if (bluetoothGattCharacteristic != null) {
            return bluetoothGattCharacteristic.getIntValue(18, 0).intValue();
        }
        return 0;
    }

    private void writeOpCode(BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr) throws UploadAbortedException, DfuException, DeviceDisconnectedException {
        byte b = bArr[0];
        writeOpCode(bluetoothGattCharacteristic, bArr, b == 6 || b == 5);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void writeImageSize(android.bluetooth.BluetoothGattCharacteristic r5, int r6) throws no.nordicsemi.android.dfu.internal.exception.UploadAbortedException, no.nordicsemi.android.dfu.internal.exception.DfuException, no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException {
        /*
            r4 = this;
            r0 = 0
            r4.mReceivedData = r0
            r0 = 0
            r4.mError = r0
            r1 = 1
            r4.mImageSizeInProgress = r1
            r5.setWriteType(r1)
            r2 = 4
            byte[] r2 = new byte[r2]
            r5.setValue(r2)
            r2 = 20
            r5.setValue(r6, r2, r0)
            no.nordicsemi.android.dfu.DfuBaseService r6 = r4.mService
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Writing to characteristic "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.util.UUID r3 = r5.getUuid()
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            r6.sendLogBroadcast(r1, r2)
            no.nordicsemi.android.dfu.DfuBaseService r6 = r4.mService
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "gatt.writeCharacteristic("
            java.lang.StringBuilder r1 = r1.append(r2)
            java.util.UUID r2 = r5.getUuid()
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r2 = ")"
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            r6.sendLogBroadcast(r0, r1)
            android.bluetooth.BluetoothGatt r6 = r4.mGatt
            r6.writeCharacteristic(r5)
            java.lang.Object r5 = r4.mLock     // Catch: java.lang.InterruptedException -> L7c
            monitor-enter(r5)     // Catch: java.lang.InterruptedException -> L7c
        L5d:
            boolean r6 = r4.mImageSizeInProgress     // Catch: java.lang.Throwable -> L79
            if (r6 == 0) goto L6d
            boolean r6 = r4.mConnected     // Catch: java.lang.Throwable -> L79
            if (r6 == 0) goto L6d
            int r6 = r4.mError     // Catch: java.lang.Throwable -> L79
            if (r6 != 0) goto L6d
            boolean r6 = r4.mAborted     // Catch: java.lang.Throwable -> L79
            if (r6 == 0) goto L71
        L6d:
            boolean r6 = r4.mPaused     // Catch: java.lang.Throwable -> L79
            if (r6 == 0) goto L77
        L71:
            java.lang.Object r6 = r4.mLock     // Catch: java.lang.Throwable -> L79
            r6.wait()     // Catch: java.lang.Throwable -> L79
            goto L5d
        L77:
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L79
            goto L82
        L79:
            r6 = move-exception
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L79
            throw r6     // Catch: java.lang.InterruptedException -> L7c
        L7c:
            r5 = move-exception
            java.lang.String r6 = "Sleeping interrupted"
            r4.loge(r6, r5)
        L82:
            boolean r5 = r4.mAborted
            if (r5 != 0) goto La1
            boolean r5 = r4.mConnected
            if (r5 == 0) goto L99
            int r5 = r4.mError
            if (r5 != 0) goto L8f
            return
        L8f:
            no.nordicsemi.android.dfu.internal.exception.DfuException r5 = new no.nordicsemi.android.dfu.internal.exception.DfuException
            java.lang.String r6 = "Unable to write Image Size"
            int r0 = r4.mError
            r5.<init>(r6, r0)
            throw r5
        L99:
            no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException r5 = new no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException
            java.lang.String r6 = "Unable to write Image Size: device disconnected"
            r5.<init>(r6)
            throw r5
        La1:
            no.nordicsemi.android.dfu.internal.exception.UploadAbortedException r5 = new no.nordicsemi.android.dfu.internal.exception.UploadAbortedException
            r5.<init>()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: no.nordicsemi.android.dfu.LegacyDfuImpl.writeImageSize(android.bluetooth.BluetoothGattCharacteristic, int):void");
    }

    private void writeImageSize(BluetoothGattCharacteristic bluetoothGattCharacteristic, int i, int i2, int i3) throws UploadAbortedException, DfuException, DeviceDisconnectedException {
        this.mReceivedData = null;
        this.mError = 0;
        this.mImageSizeInProgress = true;
        bluetoothGattCharacteristic.setWriteType(1);
        bluetoothGattCharacteristic.setValue(new byte[12]);
        bluetoothGattCharacteristic.setValue(i, 20, 0);
        bluetoothGattCharacteristic.setValue(i2, 20, 4);
        bluetoothGattCharacteristic.setValue(i3, 20, 8);
        this.mService.sendLogBroadcast(1, "Writing to characteristic " + bluetoothGattCharacteristic.getUuid());
        this.mService.sendLogBroadcast(0, "gatt.writeCharacteristic(" + bluetoothGattCharacteristic.getUuid() + ")");
        this.mGatt.writeCharacteristic(bluetoothGattCharacteristic);
        try {
            synchronized (this.mLock) {
                while (true) {
                    if ((!this.mImageSizeInProgress || !this.mConnected || this.mError != 0 || this.mAborted) && !this.mPaused) {
                        break;
                    } else {
                        this.mLock.wait();
                    }
                }
            }
        } catch (InterruptedException e) {
            loge("Sleeping interrupted", e);
        }
        if (this.mAborted) {
            throw new UploadAbortedException();
        }
        if (!this.mConnected) {
            throw new DeviceDisconnectedException("Unable to write Image Sizes: device disconnected");
        }
        if (this.mError != 0) {
            throw new DfuException("Unable to write Image Sizes", this.mError);
        }
    }

    private void resetAndRestart(BluetoothGatt bluetoothGatt, Intent intent) throws UploadAbortedException, DfuException, DeviceDisconnectedException {
        this.mService.sendLogBroadcast(15, "Last upload interrupted. Restarting device...");
        this.mProgressInfo.setProgress(-5);
        logi("Sending Reset command (Op Code = 6)");
        writeOpCode(this.mControlPointCharacteristic, OP_CODE_RESET);
        this.mService.sendLogBroadcast(10, "Reset request sent");
        this.mService.waitUntilDisconnected();
        this.mService.sendLogBroadcast(5, "Disconnected by the remote device");
        BluetoothGattService service = bluetoothGatt.getService(GENERIC_ATTRIBUTE_SERVICE_UUID);
        this.mService.refreshDeviceCache(bluetoothGatt, !((service == null || service.getCharacteristic(SERVICE_CHANGED_UUID) == null) ? false : true));
        this.mService.close(bluetoothGatt);
        logi("Restarting the service");
        Intent intent2 = new Intent();
        intent2.fillIn(intent, 24);
        restartService(intent2, false);
    }
}
