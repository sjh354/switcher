package kr.switcher.device.switcher.ble;

import android.bluetooth.BluetoothGatt;
import android.util.Log;
import java.util.List;
import java.util.UUID;
import kr.switcher.device.IODevice;
import kr.switcher.device.common.DeviceUtil;
import kr.switcher.device.common.ScannedBLEDevice;
import kr.switcher.device.switcher.Switcher;
import kr.switcher.device.switcher.SwitcherProcessor;
import kr.switcher.device.switcher.SwitcherReservationChecker;
import kr.switcher.device.switcher.interfaces.IODeviceCallbacks;
import kr.switcher.ioble.common.BLEUtil;
import kr.switcher.ioble.protocol.SwitcherBLEService;
import kr.switcher.ioble.switcher.connector.BLEConnectionInfo;
import kr.switcher.ioble.switcher.connector.BLEGattConnector;
import kr.switcher.ioble.switcher.connector.CharacteristicParser;

/* JADX INFO: loaded from: classes2.dex */
public class SwitcherBLE extends Switcher implements BLEGattConnector.BLEConnectionStatusListener {
    private static final String TAG = "SwitcherBLE";
    private BLEConnectionInfo connectionInfo;
    private BLEGattConnector connector;
    private BLEConnectionInfo disconnectionInfo;
    private SwitcherProcessor processor;

    public enum BLE_REPAIR_OPTION {
        REFRESH_CACHE,
        BOND,
        REMOVE
    }

    @Override // kr.switcher.device.switcher.Switcher
    public void changeShareCode(String str, String str2, IODeviceCallbacks.ActionShareCodeResultCallback actionShareCodeResultCallback) {
    }

    public SwitcherBLE(String str, IODevice.ProductId productId) {
        super(str, productId);
        initialize(new BLEGattConnector(new SwitcherBLEService(), this));
    }

    public SwitcherBLE(String str, String str2, IODevice.ProductId productId, String str3, String str4, List<Switcher.SwitcherReservation> list) {
        super(str, str2, productId, str3, str4, list);
        initialize(new BLEGattConnector(new SwitcherBLEService(), this));
    }

    public void initialize(BLEGattConnector bLEGattConnector) {
        this.processor = new SwitcherProcessor(this);
        this.connector = bLEGattConnector;
    }

    @Override // kr.switcher.device.IODevice
    public int connect(IODeviceCallbacks.OnDeviceConnectListener onDeviceConnectListener) {
        super.connect(onDeviceConnectListener);
        int iCheckSwitcherToConnect = DeviceUtil.checkSwitcherToConnect(this);
        if (iCheckSwitcherToConnect != 1) {
            Log.i(TAG, "check result for connect : " + iCheckSwitcherToConnect);
            return iCheckSwitcherToConnect;
        }
        if (this.scannedBLEDevice != null && this.scannedBLEDevice.getDevice() != null) {
            this.connector.connectBLEDevice(DeviceUtil.getContext(), this.scannedBLEDevice.getDevice());
        } else {
            onDeviceConnectListener.onDisconnected(this.macAddress, 202);
        }
        return 1;
    }

    @Override // kr.switcher.device.IODevice
    public void disconnect() {
        BLEConnectionInfo bLEConnectionInfo = this.connectionInfo;
        if (bLEConnectionInfo == null) {
            return;
        }
        this.connector.disconnectBLEDevice(bLEConnectionInfo.getBluetoothGatt());
        reset();
        if (this.listener != null) {
            this.listener.onDisconnected(this.macAddress, 1);
        }
    }

    public boolean repair(BLE_REPAIR_OPTION ble_repair_option) {
        BluetoothGatt bluetoothGatt;
        BLEConnectionInfo bLEConnectionInfo = this.connectionInfo;
        if (bLEConnectionInfo != null && bLEConnectionInfo.getBluetoothGatt() != null && this.connectionInfo.getBluetoothGatt().getDevice() != null) {
            bluetoothGatt = this.connectionInfo.getBluetoothGatt();
        } else {
            BLEConnectionInfo bLEConnectionInfo2 = this.disconnectionInfo;
            bluetoothGatt = (bLEConnectionInfo2 == null || bLEConnectionInfo2.getBluetoothGatt() == null || this.disconnectionInfo.getBluetoothGatt().getDevice() == null) ? null : this.disconnectionInfo.getBluetoothGatt();
        }
        if (bluetoothGatt == null) {
            return false;
        }
        int i = AnonymousClass12.$SwitchMap$kr$switcher$device$switcher$ble$SwitcherBLE$BLE_REPAIR_OPTION[ble_repair_option.ordinal()];
        if (i == 1) {
            BLEUtil.refreshCache(bluetoothGatt, true);
        } else if (i == 2) {
            BLEUtil.createBond(bluetoothGatt.getDevice());
        } else if (i == 3) {
            BLEUtil.removeBond(bluetoothGatt.getDevice());
        }
        return true;
    }

    /* JADX INFO: renamed from: kr.switcher.device.switcher.ble.SwitcherBLE$12, reason: invalid class name */
    static /* synthetic */ class AnonymousClass12 {
        static final /* synthetic */ int[] $SwitchMap$kr$switcher$device$switcher$ble$SwitcherBLE$BLE_REPAIR_OPTION;

        static {
            int[] iArr = new int[BLE_REPAIR_OPTION.values().length];
            $SwitchMap$kr$switcher$device$switcher$ble$SwitcherBLE$BLE_REPAIR_OPTION = iArr;
            try {
                iArr[BLE_REPAIR_OPTION.REFRESH_CACHE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$kr$switcher$device$switcher$ble$SwitcherBLE$BLE_REPAIR_OPTION[BLE_REPAIR_OPTION.BOND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$kr$switcher$device$switcher$ble$SwitcherBLE$BLE_REPAIR_OPTION[BLE_REPAIR_OPTION.REMOVE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private void reset() {
        this.connectionState = Switcher.ConnectionState.IDLE;
        this.scannedBLEDevice = null;
        this.authority = -1;
        this.battery = -1;
        this.disconnectionInfo = this.connectionInfo;
        this.connectionInfo = null;
    }

    @Override // kr.switcher.device.switcher.Switcher
    public void readBatteryInfo() {
        if (checkIsConnectionInfo()) {
            this.connectionInfo.getBLEService().readBatteryService(new CharacteristicParser.ReadServiceListener() { // from class: kr.switcher.device.switcher.ble.SwitcherBLE.1
                @Override // kr.switcher.ioble.switcher.connector.CharacteristicParser.ReadServiceListener
                public void onReadServiceResult(String str, UUID uuid) {
                    SwitcherBLE.this.processor.onReadBattery(str);
                }
            });
        }
    }

    @Override // kr.switcher.device.switcher.Switcher
    public void readAuthorityState() {
        if (checkIsConnectionInfo()) {
            this.connectionInfo.getBLEService().readAuthorityState(new CharacteristicParser.ReadServiceListener() { // from class: kr.switcher.device.switcher.ble.SwitcherBLE.2
                @Override // kr.switcher.ioble.switcher.connector.CharacteristicParser.ReadServiceListener
                public void onReadServiceResult(String str, UUID uuid) {
                    SwitcherBLE.this.processor.onReadAuthority(str, SwitcherBLE.this.listener);
                }
            });
        }
    }

    public void readRealTime() {
        if (checkIsConnectionInfo()) {
            this.connectionInfo.getBLEService().readRealTime(new CharacteristicParser.ReadServiceListener() { // from class: kr.switcher.device.switcher.ble.SwitcherBLE.3
                @Override // kr.switcher.ioble.switcher.connector.CharacteristicParser.ReadServiceListener
                public void onReadServiceResult(String str, UUID uuid) {
                }
            });
        }
    }

    @Override // kr.switcher.device.switcher.Switcher
    public void saveRealTime() {
        if (checkIsConnectionInfo()) {
            this.connectionInfo.getBLEService().writeRealTime(new CharacteristicParser.WriteServiceListener() { // from class: kr.switcher.device.switcher.ble.SwitcherBLE.4
                @Override // kr.switcher.ioble.switcher.connector.CharacteristicParser.WriteServiceListener
                public void onWriteServiceResult(boolean z, UUID uuid) {
                    SwitcherBLE.this.processor.onWroteRealTime(z);
                }
            });
        }
    }

    @Override // kr.switcher.device.switcher.Switcher
    public void controlSwitch(int i, final IODeviceCallbacks.OnControlResponseListener onControlResponseListener) {
        if (checkIsConnectionInfo()) {
            this.connectionInfo.getBLEService().writeSwitch(i, new CharacteristicParser.WriteServiceListener() { // from class: kr.switcher.device.switcher.ble.SwitcherBLE.5
                @Override // kr.switcher.ioble.switcher.connector.CharacteristicParser.WriteServiceListener
                public void onWriteServiceResult(boolean z, UUID uuid) {
                    SwitcherBLE.this.processor.onWroteSwitch(z, onControlResponseListener);
                }
            });
        }
    }

    @Override // kr.switcher.device.switcher.Switcher
    public int addReservation(Switcher.SwitcherReservation switcherReservation, IODeviceCallbacks.ReservationUpdateResultCallback reservationUpdateResultCallback) {
        if (10 <= this.sResrvs.size()) {
            return 106;
        }
        switcherReservation.id = DeviceUtil.generateNewReservationId(this.sResrvs);
        return updateReservation(switcherReservation, reservationUpdateResultCallback);
    }

    @Override // kr.switcher.device.switcher.Switcher
    public int updateReservation(final Switcher.SwitcherReservation switcherReservation, final IODeviceCallbacks.ReservationUpdateResultCallback reservationUpdateResultCallback) {
        if (new SwitcherReservationChecker(this.sResrvs).checkIsDuplicationTimer(switcherReservation)) {
            return 112;
        }
        Switcher.SwitcherReservation.makeTimerVersion(true);
        if (checkIsConnectionInfo()) {
            this.connectionInfo.getBLEService().writeAddTimer(Switcher.SwitcherReservation.getResrvDataForBLE(switcherReservation), Switcher.SwitcherReservation.currentTimerVersion, new CharacteristicParser.WriteServiceListener() { // from class: kr.switcher.device.switcher.ble.SwitcherBLE.6
                @Override // kr.switcher.ioble.switcher.connector.CharacteristicParser.WriteServiceListener
                public void onWriteServiceResult(boolean z, UUID uuid) {
                    SwitcherBLE.this.processor.onWroteReservationAdd(switcherReservation, z, reservationUpdateResultCallback);
                }
            });
        }
        return 1;
    }

    @Override // kr.switcher.device.switcher.Switcher
    public void removeReservation(final int i, final IODeviceCallbacks.ReservationUpdateResultCallback reservationUpdateResultCallback) {
        Switcher.SwitcherReservation.makeTimerVersion(this.sResrvs.size() > 1);
        if (checkIsConnectionInfo()) {
            this.connectionInfo.getBLEService().writeRemoveTimer(String.valueOf(i), Switcher.SwitcherReservation.currentTimerVersion, new CharacteristicParser.WriteServiceListener() { // from class: kr.switcher.device.switcher.ble.SwitcherBLE.7
                @Override // kr.switcher.ioble.switcher.connector.CharacteristicParser.WriteServiceListener
                public void onWriteServiceResult(boolean z, UUID uuid) {
                    SwitcherBLE.this.processor.onWroteReservationRemove(i, z, reservationUpdateResultCallback);
                }
            });
        }
    }

    @Override // kr.switcher.device.switcher.Switcher
    public void readReservation(final IODeviceCallbacks.LoadTimerInfoResultResponseCallback loadTimerInfoResultResponseCallback) {
        if (checkIsConnectionInfo()) {
            this.connectionInfo.getBLEService().readTimer(new CharacteristicParser.ReadServiceListener() { // from class: kr.switcher.device.switcher.ble.SwitcherBLE.8
                @Override // kr.switcher.ioble.switcher.connector.CharacteristicParser.ReadServiceListener
                public void onReadServiceResult(String str, UUID uuid) {
                    SwitcherBLE.this.processor.onReadReservation(str, loadTimerInfoResultResponseCallback);
                }
            });
        }
    }

    @Override // kr.switcher.device.switcher.Switcher
    public void readFirmwareVersion(final IODeviceCallbacks.FirmwareVersionResultCallback firmwareVersionResultCallback) {
        if (checkIsConnectionInfo()) {
            this.connectionInfo.getBLEService().readFirmwareVersion(new CharacteristicParser.ReadServiceListener() { // from class: kr.switcher.device.switcher.ble.SwitcherBLE.9
                @Override // kr.switcher.ioble.switcher.connector.CharacteristicParser.ReadServiceListener
                public void onReadServiceResult(String str, UUID uuid) {
                    SwitcherBLE.this.processor.onReadFirmwareVersion(str, firmwareVersionResultCallback);
                }
            });
        }
    }

    @Override // kr.switcher.device.switcher.Switcher
    public void updateStrokeLevel(final int i, boolean z, final IODeviceCallbacks.StrokeLevelUpdateResultResponseCallback strokeLevelUpdateResultResponseCallback) {
        if (checkIsConnectionInfo()) {
            this.connectionInfo.getBLEService().writeStrokeLevel(i, z, new CharacteristicParser.WriteServiceListener() { // from class: kr.switcher.device.switcher.ble.SwitcherBLE.10
                @Override // kr.switcher.ioble.switcher.connector.CharacteristicParser.WriteServiceListener
                public void onWriteServiceResult(boolean z2, UUID uuid) {
                    SwitcherBLE.this.processor.onWroteStrokeLevel(SwitcherBLE.this.macAddress, i, z2, strokeLevelUpdateResultResponseCallback);
                }
            });
        }
    }

    @Override // kr.switcher.device.switcher.Switcher
    public void readStrokeLevel(final IODeviceCallbacks.StrokeLevelReadResultResponseCallback strokeLevelReadResultResponseCallback) {
        if (checkIsConnectionInfo()) {
            this.connectionInfo.getBLEService().readStrokeLevel(new CharacteristicParser.ReadServiceListener() { // from class: kr.switcher.device.switcher.ble.SwitcherBLE.11
                @Override // kr.switcher.ioble.switcher.connector.CharacteristicParser.ReadServiceListener
                public void onReadServiceResult(String str, UUID uuid) {
                    SwitcherBLE.this.processor.onReadStrokeLevel(str, strokeLevelReadResultResponseCallback);
                }
            });
        }
    }

    @Override // kr.switcher.device.IODevice
    public void attachToDevice(ScannedBLEDevice scannedBLEDevice) {
        super.attachToDevice(scannedBLEDevice);
        setScannedBLESwitcher((ScannedBLESwitcher) scannedBLEDevice);
    }

    @Override // kr.switcher.ioble.switcher.connector.BLEGattConnector.BLEConnectionStatusListener
    public void onConnected(BLEConnectionInfo bLEConnectionInfo) {
        Log.i(TAG, "ble connected (mac address:" + bLEConnectionInfo.getMacAddress() + ")");
        setConnectionInfo(bLEConnectionInfo);
        setConnectionState(Switcher.ConnectionState.CONNECTED);
        this.processor.onConnected();
    }

    @Override // kr.switcher.ioble.switcher.connector.BLEGattConnector.BLEConnectionStatusListener
    public void onDisconnected(String str, int i) {
        reset();
        if (this.listener != null) {
            this.listener.onDisconnected(str, i);
        }
    }

    public void setConnectionInfo(BLEConnectionInfo bLEConnectionInfo) {
        this.connectionInfo = bLEConnectionInfo;
    }

    public BLEConnectionInfo getConnectionInfo() {
        return this.connectionInfo;
    }

    private void setScannedBLESwitcher(ScannedBLESwitcher scannedBLESwitcher) {
        if (scannedBLESwitcher == null) {
            return;
        }
        if (scannedBLESwitcher.getDevice() != null) {
            setMacAddress(scannedBLESwitcher.getDevice().getAddress());
        }
        if (scannedBLESwitcher.getAdvertisementPacket() != null) {
            if (scannedBLESwitcher.getAdvertisementPacket().getSwitcherType() != 0) {
                if (this.name.length() < 1) {
                    setName(DeviceUtil.getDefaultDeviceName(DeviceUtil.convertProductId(scannedBLESwitcher.getAdvertisementPacket().getSwitcherType())));
                }
                this.productId = DeviceUtil.convertProductId(scannedBLESwitcher.getAdvertisementPacket().getSwitcherType());
            }
            if (scannedBLESwitcher.getAdvertisementPacket().getSerialNumber() != null) {
                setSerialNumber(scannedBLESwitcher.getAdvertisementPacket().getSerialNumber());
            }
        }
    }

    private boolean checkIsConnectionInfo() {
        if (this.connectionInfo != null) {
            return true;
        }
        if (this.listener != null) {
            this.listener.onDisconnected(this.macAddress, 0);
        }
        return false;
    }
}
