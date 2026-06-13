package no.nordicsemi.android.dfu;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.content.Intent;
import android.os.Build;
import android.os.SystemClock;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.UUID;
import java.util.zip.CRC32;
import no.nordicsemi.android.dfu.BaseCustomDfuImpl;
import no.nordicsemi.android.dfu.BaseDfuImpl;
import no.nordicsemi.android.dfu.internal.ArchiveInputStream;
import no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException;
import no.nordicsemi.android.dfu.internal.exception.DfuException;
import no.nordicsemi.android.dfu.internal.exception.RemoteDfuException;
import no.nordicsemi.android.dfu.internal.exception.RemoteDfuExtendedErrorException;
import no.nordicsemi.android.dfu.internal.exception.UnknownResponseException;
import no.nordicsemi.android.dfu.internal.exception.UploadAbortedException;
import no.nordicsemi.android.error.SecureDfuError;

/* JADX INFO: loaded from: classes2.dex */
class SecureDfuImpl extends BaseCustomDfuImpl {
    static final UUID DEFAULT_DFU_CONTROL_POINT_UUID;
    static final UUID DEFAULT_DFU_PACKET_UUID;
    static final UUID DEFAULT_DFU_SERVICE_UUID;
    static UUID DFU_CONTROL_POINT_UUID = null;
    static UUID DFU_PACKET_UUID = null;
    static UUID DFU_SERVICE_UUID = null;
    private static final int DFU_STATUS_SUCCESS = 1;
    private static final int MAX_ATTEMPTS = 3;
    private static final int OBJECT_COMMAND = 1;
    private static final int OBJECT_DATA = 2;
    private static final byte[] OP_CODE_CALCULATE_CHECKSUM;
    private static final int OP_CODE_CALCULATE_CHECKSUM_KEY = 3;
    private static final byte[] OP_CODE_CREATE_COMMAND;
    private static final byte[] OP_CODE_CREATE_DATA;
    private static final int OP_CODE_CREATE_KEY = 1;
    private static final byte[] OP_CODE_EXECUTE;
    private static final int OP_CODE_EXECUTE_KEY = 4;
    private static final byte[] OP_CODE_PACKET_RECEIPT_NOTIF_REQ;
    private static final int OP_CODE_PACKET_RECEIPT_NOTIF_REQ_KEY = 2;
    private static final int OP_CODE_RESPONSE_CODE_KEY = 96;
    private static final byte[] OP_CODE_SELECT_OBJECT;
    private static final int OP_CODE_SELECT_OBJECT_KEY = 6;
    private final SecureBluetoothCallback mBluetoothCallback;
    private BluetoothGattCharacteristic mControlPointCharacteristic;
    private BluetoothGattCharacteristic mPacketCharacteristic;

    static {
        UUID uuid = new UUID(279658205548544L, -9223371485494954757L);
        DEFAULT_DFU_SERVICE_UUID = uuid;
        UUID uuid2 = new UUID(-8157989241631715488L, -6937650605005804976L);
        DEFAULT_DFU_CONTROL_POINT_UUID = uuid2;
        UUID uuid3 = new UUID(-8157989237336748192L, -6937650605005804976L);
        DEFAULT_DFU_PACKET_UUID = uuid3;
        DFU_SERVICE_UUID = uuid;
        DFU_CONTROL_POINT_UUID = uuid2;
        DFU_PACKET_UUID = uuid3;
        OP_CODE_CREATE_COMMAND = new byte[]{1, 1, 0, 0, 0, 0};
        OP_CODE_CREATE_DATA = new byte[]{1, 2, 0, 0, 0, 0};
        OP_CODE_PACKET_RECEIPT_NOTIF_REQ = new byte[]{2, 0, 0};
        OP_CODE_CALCULATE_CHECKSUM = new byte[]{3};
        OP_CODE_EXECUTE = new byte[]{4};
        OP_CODE_SELECT_OBJECT = new byte[]{6, 0};
    }

    protected class SecureBluetoothCallback extends BaseCustomDfuImpl.BaseCustomBluetoothCallback {
        protected SecureBluetoothCallback() {
            super();
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            if (bluetoothGattCharacteristic.getValue() == null || bluetoothGattCharacteristic.getValue().length < 3) {
                SecureDfuImpl.this.loge("Empty response: " + parse(bluetoothGattCharacteristic));
                SecureDfuImpl.this.mError = DfuBaseService.ERROR_INVALID_RESPONSE;
                SecureDfuImpl.this.notifyLock();
                return;
            }
            if (bluetoothGattCharacteristic.getIntValue(17, 0).intValue() == 96) {
                if (bluetoothGattCharacteristic.getIntValue(17, 1).intValue() == 3) {
                    int iIntValue = bluetoothGattCharacteristic.getIntValue(20, 3).intValue();
                    if (((int) (((ArchiveInputStream) SecureDfuImpl.this.mFirmwareStream).getCrc32() & 4294967295L)) == bluetoothGattCharacteristic.getIntValue(20, 7).intValue()) {
                        SecureDfuImpl.this.mProgressInfo.setBytesReceived(iIntValue);
                    } else if (SecureDfuImpl.this.mFirmwareUploadInProgress) {
                        SecureDfuImpl.this.mFirmwareUploadInProgress = false;
                        SecureDfuImpl.this.notifyLock();
                        return;
                    }
                    handlePacketReceiptNotification(bluetoothGatt, bluetoothGattCharacteristic);
                } else if (!SecureDfuImpl.this.mRemoteErrorOccurred) {
                    if (bluetoothGattCharacteristic.getIntValue(17, 2).intValue() != 1) {
                        SecureDfuImpl.this.mRemoteErrorOccurred = true;
                    }
                    handleNotification(bluetoothGatt, bluetoothGattCharacteristic);
                }
            } else {
                SecureDfuImpl.this.loge("Invalid response: " + parse(bluetoothGattCharacteristic));
                SecureDfuImpl.this.mError = DfuBaseService.ERROR_INVALID_RESPONSE;
            }
            SecureDfuImpl.this.notifyLock();
        }
    }

    SecureDfuImpl(Intent intent, DfuBaseService dfuBaseService) {
        super(intent, dfuBaseService);
        this.mBluetoothCallback = new SecureBluetoothCallback();
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

    @Override // no.nordicsemi.android.dfu.BaseDfuImpl, no.nordicsemi.android.dfu.DfuService
    public boolean initialize(Intent intent, BluetoothGatt bluetoothGatt, int i, InputStream inputStream, InputStream inputStream2) throws UploadAbortedException, DfuException, DeviceDisconnectedException {
        if (inputStream2 == null) {
            this.mService.sendLogBroadcast(20, "The Init packet is required by this version DFU Bootloader");
            this.mService.terminateConnection(bluetoothGatt, DfuBaseService.ERROR_INIT_PACKET_REQUIRED);
            return false;
        }
        return super.initialize(intent, bluetoothGatt, i, inputStream, inputStream2);
    }

    @Override // no.nordicsemi.android.dfu.DfuCallback
    public BaseDfuImpl.BaseBluetoothGattCallback getGattCallback() {
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

    @Override // no.nordicsemi.android.dfu.DfuService
    public void performDfu(Intent intent) throws UploadAbortedException, DfuException, DeviceDisconnectedException {
        logw("Secure DFU bootloader found");
        this.mProgressInfo.setProgress(-2);
        this.mService.waitFor(1000);
        BluetoothGatt bluetoothGatt = this.mGatt;
        if (intent.hasExtra(DfuBaseService.EXTRA_MTU) && Build.VERSION.SDK_INT >= 21) {
            int intExtra = intent.getIntExtra(DfuBaseService.EXTRA_MTU, 517);
            logi("Requesting MTU = " + intExtra);
            requestMtu(intExtra);
        }
        try {
            try {
                enableCCCD(this.mControlPointCharacteristic, 1);
                this.mService.sendLogBroadcast(10, "Notifications enabled");
                this.mService.waitFor(1000);
                boolean z = (intent.hasExtra(DfuBaseService.EXTRA_DISABLE_RESUME) && intent.getBooleanExtra(DfuBaseService.EXTRA_DISABLE_RESUME, false)) ? false : true;
                if (!z) {
                    logi("Resume feature disabled. Performing fresh DFU");
                }
                try {
                    sendInitPacket(bluetoothGatt, z);
                } catch (RemoteDfuException e) {
                    if (!this.mProgressInfo.isLastPart()) {
                        this.mRemoteErrorOccurred = false;
                        logw("Sending SD+BL failed. Trying to send App only");
                        this.mService.sendLogBroadcast(15, "Invalid system components. Trying to send application");
                        this.mFileType = 4;
                        ArchiveInputStream archiveInputStream = (ArchiveInputStream) this.mFirmwareStream;
                        archiveInputStream.setContentType(this.mFileType);
                        byte[] applicationInit = archiveInputStream.getApplicationInit();
                        this.mInitPacketStream = new ByteArrayInputStream(applicationInit);
                        this.mInitPacketSizeInBytes = applicationInit.length;
                        this.mImageSizeInBytes = archiveInputStream.applicationImageSize();
                        this.mProgressInfo.init(this.mImageSizeInBytes, 2, 2);
                        sendInitPacket(bluetoothGatt, false);
                    } else {
                        throw e;
                    }
                }
                sendFirmware(bluetoothGatt);
                this.mProgressInfo.setProgress(-5);
                this.mService.waitUntilDisconnected();
                this.mService.sendLogBroadcast(5, "Disconnected by the remote device");
                finalize(intent, false);
            } catch (RemoteDfuException e2) {
                int errorNumber = e2.getErrorNumber() | 512;
                loge(e2.getMessage() + ": " + SecureDfuError.parse(errorNumber));
                this.mService.sendLogBroadcast(20, String.format(Locale.US, "Remote DFU error: %s", SecureDfuError.parse(errorNumber)));
                if (e2 instanceof RemoteDfuExtendedErrorException) {
                    RemoteDfuExtendedErrorException remoteDfuExtendedErrorException = (RemoteDfuExtendedErrorException) e2;
                    int extendedErrorNumber = remoteDfuExtendedErrorException.getExtendedErrorNumber() | 1024;
                    loge("Extended Error details: " + SecureDfuError.parseExtendedError(extendedErrorNumber));
                    this.mService.sendLogBroadcast(20, "Details: " + SecureDfuError.parseExtendedError(extendedErrorNumber) + " (Code = " + remoteDfuExtendedErrorException.getExtendedErrorNumber() + ")");
                    this.mService.terminateConnection(bluetoothGatt, extendedErrorNumber | 8192);
                    return;
                }
                this.mService.terminateConnection(bluetoothGatt, errorNumber | 8192);
            }
        } catch (UnknownResponseException e3) {
            loge(e3.getMessage());
            this.mService.sendLogBroadcast(20, e3.getMessage());
            this.mService.terminateConnection(bluetoothGatt, DfuBaseService.ERROR_INVALID_RESPONSE);
        } catch (UploadAbortedException e4) {
            throw e4;
        }
    }

    private void sendInitPacket(BluetoothGatt bluetoothGatt, boolean z) throws UploadAbortedException, RemoteDfuException, UnknownResponseException, DfuException, DeviceDisconnectedException {
        boolean z2;
        boolean z3;
        IOException iOException;
        CRC32 crc32 = new CRC32();
        logi("Setting object to Command (Op Code = 6, Type = 1)");
        ObjectInfo objectInfoSelectObject = selectObject(1);
        int i = 3;
        logi(String.format(Locale.US, "Command object info received (Max size = %d, Offset = %d, CRC = %08X)", Integer.valueOf(objectInfoSelectObject.maxSize), Integer.valueOf(objectInfoSelectObject.offset), Integer.valueOf(objectInfoSelectObject.CRC32)));
        this.mService.sendLogBroadcast(10, String.format(Locale.US, "Command object info received (Max size = %d, Offset = %d, CRC = %08X)", Integer.valueOf(objectInfoSelectObject.maxSize), Integer.valueOf(objectInfoSelectObject.offset), Integer.valueOf(objectInfoSelectObject.CRC32)));
        int i2 = this.mInitPacketSizeInBytes;
        int i3 = objectInfoSelectObject.maxSize;
        if (!z || objectInfoSelectObject.offset <= 0 || objectInfoSelectObject.offset > this.mInitPacketSizeInBytes) {
            z2 = false;
            z3 = false;
        } else {
            try {
                byte[] bArr = new byte[objectInfoSelectObject.offset];
                this.mInitPacketStream.read(bArr);
                crc32.update(bArr);
                if (objectInfoSelectObject.CRC32 == ((int) (crc32.getValue() & 4294967295L))) {
                    logi("Init packet CRC is the same");
                    if (objectInfoSelectObject.offset == this.mInitPacketSizeInBytes) {
                        logi("-> Whole Init packet was sent before");
                        try {
                            this.mService.sendLogBroadcast(10, "Received CRC match Init packet");
                            z2 = true;
                            z3 = false;
                        } catch (IOException e) {
                            iOException = e;
                            z2 = true;
                            z3 = false;
                            loge("Error while reading " + objectInfoSelectObject.offset + " bytes from the init packet stream", iOException);
                            try {
                                this.mInitPacketStream.reset();
                                crc32.reset();
                                objectInfoSelectObject.offset = 0;
                            } catch (IOException e2) {
                                loge("Error while resetting the init packet stream", e2);
                                this.mService.terminateConnection(bluetoothGatt, DfuBaseService.ERROR_FILE_IO_EXCEPTION);
                                return;
                            }
                        }
                    } else {
                        logi("-> " + objectInfoSelectObject.offset + " bytes of Init packet were sent before");
                        try {
                            this.mService.sendLogBroadcast(10, "Resuming sending Init packet...");
                            z3 = true;
                            z2 = false;
                        } catch (IOException e3) {
                            iOException = e3;
                            z3 = true;
                            z2 = false;
                            loge("Error while reading " + objectInfoSelectObject.offset + " bytes from the init packet stream", iOException);
                            this.mInitPacketStream.reset();
                            crc32.reset();
                            objectInfoSelectObject.offset = 0;
                        }
                    }
                } else {
                    this.mInitPacketStream.reset();
                    crc32.reset();
                    objectInfoSelectObject.offset = 0;
                    z2 = false;
                    z3 = false;
                }
            } catch (IOException e4) {
                iOException = e4;
                z2 = false;
                z3 = false;
            }
        }
        if (!z2) {
            setPacketReceiptNotifications(0);
            this.mService.sendLogBroadcast(10, "Packet Receipt Notif disabled (Op Code = 2, Value = 0)");
            int i4 = 1;
            while (i4 <= i) {
                if (!z3) {
                    logi("Creating Init packet object (Op Code = 1, Type = 1, Size = " + this.mInitPacketSizeInBytes + ")");
                    writeCreateRequest(1, this.mInitPacketSizeInBytes);
                    this.mService.sendLogBroadcast(10, "Command object created");
                }
                try {
                    logi("Sending " + (this.mInitPacketSizeInBytes - objectInfoSelectObject.offset) + " bytes of init packet...");
                    writeInitData(this.mPacketCharacteristic, crc32);
                    int value = (int) (crc32.getValue() & 4294967295L);
                    this.mService.sendLogBroadcast(10, String.format(Locale.US, "Command object sent (CRC = %08X)", Integer.valueOf(value)));
                    logi("Sending Calculate Checksum command (Op Code = 3)");
                    ObjectChecksum checksum = readChecksum();
                    this.mService.sendLogBroadcast(10, String.format(Locale.US, "Checksum received (Offset = %d, CRC = %08X)", Integer.valueOf(checksum.offset), Integer.valueOf(checksum.CRC32)));
                    logi(String.format(Locale.US, "Checksum received (Offset = %d, CRC = %08X)", Integer.valueOf(checksum.offset), Integer.valueOf(checksum.CRC32)));
                    if (value == checksum.CRC32) {
                        break;
                    }
                    i = 3;
                    if (i4 < 3) {
                        i4++;
                        logi("CRC does not match! Retrying...(" + i4 + "/3)");
                        this.mService.sendLogBroadcast(15, "CRC does not match! Retrying...(" + i4 + "/3)");
                        try {
                            objectInfoSelectObject.offset = 0;
                            objectInfoSelectObject.CRC32 = 0;
                            this.mInitPacketStream.reset();
                            crc32.reset();
                            z3 = false;
                        } catch (IOException e5) {
                            loge("Error while resetting the init packet stream", e5);
                            this.mService.terminateConnection(bluetoothGatt, DfuBaseService.ERROR_FILE_IO_EXCEPTION);
                            return;
                        }
                    } else {
                        loge("CRC does not match!");
                        this.mService.sendLogBroadcast(20, "CRC does not match!");
                        this.mService.terminateConnection(bluetoothGatt, DfuBaseService.ERROR_CRC_ERROR);
                        return;
                    }
                } catch (DeviceDisconnectedException e6) {
                    loge("Disconnected while sending init packet");
                    throw e6;
                }
            }
        }
        logi("Executing init packet (Op Code = 4)");
        writeExecute();
        this.mService.sendLogBroadcast(10, "Command object executed");
    }

    private void sendFirmware(BluetoothGatt bluetoothGatt) throws UploadAbortedException, RemoteDfuException, UnknownResponseException, DfuException, DeviceDisconnectedException {
        String str;
        int i;
        String str2;
        boolean z;
        long j;
        long j2;
        boolean z2;
        String str3;
        boolean z3;
        int i2 = this.mPacketsBeforeNotification;
        if (i2 > 0) {
            setPacketReceiptNotifications(i2);
            this.mService.sendLogBroadcast(10, "Packet Receipt Notif Req (Op Code = 2) sent (Value = " + i2 + ")");
        }
        logi("Setting object to Data (Op Code = 6, Type = 2)");
        ObjectInfo objectInfoSelectObject = selectObject(2);
        logi(String.format(Locale.US, "Data object info received (Max size = %d, Offset = %d, CRC = %08X)", Integer.valueOf(objectInfoSelectObject.maxSize), Integer.valueOf(objectInfoSelectObject.offset), Integer.valueOf(objectInfoSelectObject.CRC32)));
        this.mService.sendLogBroadcast(10, String.format(Locale.US, "Data object info received (Max size = %d, Offset = %d, CRC = %08X)", Integer.valueOf(objectInfoSelectObject.maxSize), Integer.valueOf(objectInfoSelectObject.offset), Integer.valueOf(objectInfoSelectObject.CRC32)));
        this.mProgressInfo.setMaxObjectSizeInBytes(objectInfoSelectObject.maxSize);
        int i3 = ((this.mImageSizeInBytes + objectInfoSelectObject.maxSize) - 1) / objectInfoSelectObject.maxSize;
        if (objectInfoSelectObject.offset > 0) {
            try {
                int i4 = objectInfoSelectObject.offset / objectInfoSelectObject.maxSize;
                int i5 = objectInfoSelectObject.maxSize * i4;
                int i6 = objectInfoSelectObject.offset - i5;
                if (i6 == 0) {
                    i5 -= objectInfoSelectObject.maxSize;
                    i6 = objectInfoSelectObject.maxSize;
                }
                if (i5 > 0) {
                    i = i4;
                    str = "Packet Receipt Notif Req (Op Code = 2) sent (Value = ";
                    this.mFirmwareStream.read(new byte[i5]);
                    this.mFirmwareStream.mark(objectInfoSelectObject.maxSize);
                } else {
                    str = "Packet Receipt Notif Req (Op Code = 2) sent (Value = ";
                    i = i4;
                }
                this.mFirmwareStream.read(new byte[i6]);
                str2 = ")";
                if (((int) (((ArchiveInputStream) this.mFirmwareStream).getCrc32() & 4294967295L)) == objectInfoSelectObject.CRC32) {
                    logi(objectInfoSelectObject.offset + " bytes of data sent before, CRC match");
                    this.mService.sendLogBroadcast(10, objectInfoSelectObject.offset + " bytes of data sent before, CRC match");
                    this.mProgressInfo.setBytesSent(objectInfoSelectObject.offset);
                    this.mProgressInfo.setBytesReceived(objectInfoSelectObject.offset);
                    if (i6 != objectInfoSelectObject.maxSize || objectInfoSelectObject.offset >= this.mImageSizeInBytes) {
                        z = true;
                    } else {
                        logi("Executing data object (Op Code = 4)");
                        writeExecute();
                        this.mService.sendLogBroadcast(10, "Data object executed");
                    }
                } else {
                    logi(objectInfoSelectObject.offset + " bytes sent before, CRC does not match");
                    this.mService.sendLogBroadcast(15, objectInfoSelectObject.offset + " bytes sent before, CRC does not match");
                    this.mProgressInfo.setBytesSent(i5);
                    this.mProgressInfo.setBytesReceived(i5);
                    objectInfoSelectObject.offset -= i6;
                    objectInfoSelectObject.CRC32 = 0;
                    this.mFirmwareStream.reset();
                    logi("Resuming from byte " + objectInfoSelectObject.offset + "...");
                    this.mService.sendLogBroadcast(10, "Resuming from byte " + objectInfoSelectObject.offset + "...");
                }
                z = false;
            } catch (IOException e) {
                loge("Error while reading firmware stream", e);
                this.mService.terminateConnection(bluetoothGatt, DfuBaseService.ERROR_FILE_IO_EXCEPTION);
                return;
            }
        } else {
            str = "Packet Receipt Notif Req (Op Code = 2) sent (Value = ";
            str2 = ")";
            this.mProgressInfo.setBytesSent(0);
            z = false;
            i = 0;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (objectInfoSelectObject.offset < this.mImageSizeInBytes) {
            int i7 = 1;
            while (this.mProgressInfo.getAvailableObjectSizeIsBytes() > 0) {
                if (!z) {
                    int availableObjectSizeIsBytes = this.mProgressInfo.getAvailableObjectSizeIsBytes();
                    int i8 = i + 1;
                    logi("Creating Data object (Op Code = 1, Type = 2, Size = " + availableObjectSizeIsBytes + ") (" + i8 + "/" + i3 + str2);
                    writeCreateRequest(2, availableObjectSizeIsBytes);
                    j2 = jElapsedRealtime;
                    this.mService.sendLogBroadcast(10, "Data object (" + i8 + "/" + i3 + ") created");
                    this.mService.sendLogBroadcast(10, "Uploading firmware...");
                    z2 = z;
                } else {
                    j2 = jElapsedRealtime;
                    this.mService.sendLogBroadcast(10, "Resuming uploading firmware...");
                    z2 = false;
                }
                try {
                    logi("Uploading firmware...");
                    uploadFirmwareImage(this.mPacketCharacteristic);
                    logi("Sending Calculate Checksum command (Op Code = 3)");
                    ObjectChecksum checksum = readChecksum();
                    logi(String.format(Locale.US, "Checksum received (Offset = %d, CRC = %08X)", Integer.valueOf(checksum.offset), Integer.valueOf(checksum.CRC32)));
                    this.mService.sendLogBroadcast(10, String.format(Locale.US, "Checksum received (Offset = %d, CRC = %08X)", Integer.valueOf(checksum.offset), Integer.valueOf(checksum.CRC32)));
                    int bytesSent = this.mProgressInfo.getBytesSent() - checksum.offset;
                    if (bytesSent > 0) {
                        logw(bytesSent + " bytes were lost!");
                        this.mService.sendLogBroadcast(15, bytesSent + " bytes were lost");
                        try {
                            this.mFirmwareStream.reset();
                            this.mFirmwareStream.read(new byte[objectInfoSelectObject.maxSize - bytesSent]);
                            this.mProgressInfo.setBytesSent(checksum.offset);
                            this.mPacketsBeforeNotification = 1;
                            setPacketReceiptNotifications(1);
                            str3 = str;
                            this.mService.sendLogBroadcast(10, str3 + 1 + str2);
                        } catch (IOException e2) {
                            loge("Error while reading firmware stream", e2);
                            this.mService.terminateConnection(bluetoothGatt, DfuBaseService.ERROR_FILE_IO_EXCEPTION);
                            return;
                        }
                    } else {
                        str3 = str;
                    }
                    int crc32 = (int) (((ArchiveInputStream) this.mFirmwareStream).getCrc32() & 4294967295L);
                    if (crc32 != checksum.CRC32) {
                        z3 = z2;
                        String str4 = String.format(Locale.US, "CRC does not match! Expected %08X but found %08X.", Integer.valueOf(crc32), Integer.valueOf(checksum.CRC32));
                        if (i7 < 3) {
                            i7++;
                            String str5 = str4 + String.format(Locale.US, " Retrying...(%d/%d)", Integer.valueOf(i7), 3);
                            logi(str5);
                            this.mService.sendLogBroadcast(15, str5);
                            try {
                                this.mFirmwareStream.reset();
                                this.mProgressInfo.setBytesSent(((ArchiveInputStream) this.mFirmwareStream).getBytesRead());
                            } catch (IOException e3) {
                                loge("Error while resetting the firmware stream", e3);
                                this.mService.terminateConnection(bluetoothGatt, DfuBaseService.ERROR_FILE_IO_EXCEPTION);
                                return;
                            }
                        } else {
                            loge(str4);
                            this.mService.sendLogBroadcast(20, str4);
                            this.mService.terminateConnection(bluetoothGatt, DfuBaseService.ERROR_CRC_ERROR);
                            return;
                        }
                    } else if (bytesSent > 0) {
                        str = str3;
                        jElapsedRealtime = j2;
                        z = true;
                    } else {
                        logi("Executing data object (Op Code = 4)");
                        writeExecute(this.mProgressInfo.isComplete());
                        this.mService.sendLogBroadcast(10, "Data object executed");
                        i++;
                        this.mFirmwareStream.mark(0);
                        z3 = z2;
                        i7 = 1;
                    }
                    z = z3;
                    jElapsedRealtime = j2;
                    str = str3;
                } catch (DeviceDisconnectedException e4) {
                    loge("Disconnected while sending data");
                    throw e4;
                }
            }
            j = jElapsedRealtime;
        } else {
            j = jElapsedRealtime;
            logi("Executing data object (Op Code = 4)");
            writeExecute(true);
            this.mService.sendLogBroadcast(10, "Data object executed");
        }
        long jElapsedRealtime2 = SystemClock.elapsedRealtime() - j;
        logi("Transfer of " + (this.mProgressInfo.getBytesSent() - objectInfoSelectObject.offset) + " bytes has taken " + jElapsedRealtime2 + " ms");
        this.mService.sendLogBroadcast(10, "Upload completed in " + jElapsedRealtime2 + " ms");
    }

    private int getStatusCode(byte[] bArr, int i) throws UnknownResponseException {
        byte b;
        if (bArr != null && bArr.length >= 3 && bArr[0] == 96 && bArr[1] == i && ((b = bArr[2]) == 1 || b == 2 || b == 3 || b == 4 || b == 5 || b == 7 || b == 8 || b == 10 || b == 11)) {
            return b;
        }
        throw new UnknownResponseException("Invalid response received", bArr, 96, i);
    }

    private void setNumberOfPackets(byte[] bArr, int i) {
        bArr[1] = (byte) (i & 255);
        bArr[2] = (byte) ((i >> 8) & 255);
    }

    private void setObjectSize(byte[] bArr, int i) {
        bArr[2] = (byte) (i & 255);
        bArr[3] = (byte) ((i >> 8) & 255);
        bArr[4] = (byte) ((i >> 16) & 255);
        bArr[5] = (byte) ((i >> 24) & 255);
    }

    private void setPacketReceiptNotifications(int i) throws UploadAbortedException, RemoteDfuException, UnknownResponseException, DfuException, DeviceDisconnectedException {
        if (!this.mConnected) {
            throw new DeviceDisconnectedException("Unable to read Checksum: device disconnected");
        }
        logi("Sending the number of packets before notifications (Op Code = 2, Value = " + i + ")");
        byte[] bArr = OP_CODE_PACKET_RECEIPT_NOTIF_REQ;
        setNumberOfPackets(bArr, i);
        writeOpCode(this.mControlPointCharacteristic, bArr);
        byte[] notificationResponse = readNotificationResponse();
        int statusCode = getStatusCode(notificationResponse, 2);
        if (statusCode == 11) {
            throw new RemoteDfuExtendedErrorException("Sending the number of packets failed", notificationResponse[3]);
        }
        if (statusCode != 1) {
            throw new RemoteDfuException("Sending the number of packets failed", statusCode);
        }
    }

    private void writeOpCode(BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr) throws UploadAbortedException, DfuException, DeviceDisconnectedException {
        writeOpCode(bluetoothGattCharacteristic, bArr, false);
    }

    private void writeCreateRequest(int i, int i2) throws UploadAbortedException, RemoteDfuException, UnknownResponseException, DfuException, DeviceDisconnectedException {
        if (!this.mConnected) {
            throw new DeviceDisconnectedException("Unable to create object: device disconnected");
        }
        byte[] bArr = i == 1 ? OP_CODE_CREATE_COMMAND : OP_CODE_CREATE_DATA;
        setObjectSize(bArr, i2);
        writeOpCode(this.mControlPointCharacteristic, bArr);
        byte[] notificationResponse = readNotificationResponse();
        int statusCode = getStatusCode(notificationResponse, 1);
        if (statusCode == 11) {
            throw new RemoteDfuExtendedErrorException("Creating Command object failed", notificationResponse[3]);
        }
        if (statusCode != 1) {
            throw new RemoteDfuException("Creating Command object failed", statusCode);
        }
    }

    private ObjectInfo selectObject(int i) throws UploadAbortedException, RemoteDfuException, UnknownResponseException, DfuException, DeviceDisconnectedException {
        if (!this.mConnected) {
            throw new DeviceDisconnectedException("Unable to read object info: device disconnected");
        }
        byte[] bArr = OP_CODE_SELECT_OBJECT;
        bArr[1] = (byte) i;
        writeOpCode(this.mControlPointCharacteristic, bArr);
        byte[] notificationResponse = readNotificationResponse();
        int statusCode = getStatusCode(notificationResponse, 6);
        if (statusCode == 11) {
            throw new RemoteDfuExtendedErrorException("Selecting object failed", notificationResponse[3]);
        }
        if (statusCode != 1) {
            throw new RemoteDfuException("Selecting object failed", statusCode);
        }
        ObjectInfo objectInfo = new ObjectInfo();
        objectInfo.maxSize = this.mControlPointCharacteristic.getIntValue(20, 3).intValue();
        objectInfo.offset = this.mControlPointCharacteristic.getIntValue(20, 7).intValue();
        objectInfo.CRC32 = this.mControlPointCharacteristic.getIntValue(20, 11).intValue();
        return objectInfo;
    }

    private ObjectChecksum readChecksum() throws UploadAbortedException, RemoteDfuException, UnknownResponseException, DfuException, DeviceDisconnectedException {
        if (!this.mConnected) {
            throw new DeviceDisconnectedException("Unable to read Checksum: device disconnected");
        }
        writeOpCode(this.mControlPointCharacteristic, OP_CODE_CALCULATE_CHECKSUM);
        byte[] notificationResponse = readNotificationResponse();
        int statusCode = getStatusCode(notificationResponse, 3);
        if (statusCode == 11) {
            throw new RemoteDfuExtendedErrorException("Receiving Checksum failed", notificationResponse[3]);
        }
        if (statusCode != 1) {
            throw new RemoteDfuException("Receiving Checksum failed", statusCode);
        }
        ObjectChecksum objectChecksum = new ObjectChecksum();
        objectChecksum.offset = this.mControlPointCharacteristic.getIntValue(20, 3).intValue();
        objectChecksum.CRC32 = this.mControlPointCharacteristic.getIntValue(20, 7).intValue();
        return objectChecksum;
    }

    private void writeExecute() throws UploadAbortedException, RemoteDfuException, UnknownResponseException, DfuException, DeviceDisconnectedException {
        if (!this.mConnected) {
            throw new DeviceDisconnectedException("Unable to read Checksum: device disconnected");
        }
        writeOpCode(this.mControlPointCharacteristic, OP_CODE_EXECUTE);
        byte[] notificationResponse = readNotificationResponse();
        int statusCode = getStatusCode(notificationResponse, 4);
        if (statusCode == 11) {
            throw new RemoteDfuExtendedErrorException("Executing object failed", notificationResponse[3]);
        }
        if (statusCode != 1) {
            throw new RemoteDfuException("Executing object failed", statusCode);
        }
    }

    private void writeExecute(boolean z) throws UploadAbortedException, RemoteDfuException, UnknownResponseException, DfuException, DeviceDisconnectedException {
        try {
            writeExecute();
        } catch (RemoteDfuException e) {
            if (z && e.getErrorNumber() == 5) {
                logw(e.getMessage() + ": " + SecureDfuError.parse(517));
                if (this.mFileType == 1) {
                    logw("Are you sure your new SoftDevice is API compatible with the updated one? If not, update the bootloader as well");
                }
                this.mService.sendLogBroadcast(15, String.format(Locale.US, "Remote DFU error: %s. SD busy? Retrying...", SecureDfuError.parse(517)));
                logi("SD busy? Retrying...");
                logi("Executing data object (Op Code = 4)");
                writeExecute();
                return;
            }
            throw e;
        }
    }

    private class ObjectInfo extends ObjectChecksum {
        int maxSize;

        private ObjectInfo() {
            super();
        }
    }

    private class ObjectChecksum {
        int CRC32;
        int offset;

        private ObjectChecksum() {
        }
    }
}
