package kr.switcher.switcherm.device;

import android.util.Log;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kr.switcher.device.IODevice;
import kr.switcher.device.checker.Checker;
import kr.switcher.device.common.DeviceUtil;
import kr.switcher.device.linker.Linker;
import kr.switcher.device.remocon.Remocon;
import kr.switcher.device.switcher.Switcher;
import kr.switcher.device.switcher.ble.SwitcherBLE;
import kr.switcher.device.switcher.linker.SwitcherLinker;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.device.checker.CheckerDBProvider;
import kr.switcher.switcherm.device.checker.CheckerHandler;
import kr.switcher.switcherm.device.linker.LinkerDBProvider;
import kr.switcher.switcherm.device.linker.LinkerHandler;
import kr.switcher.switcherm.device.switcher.handler.SwitcherDBProvider;
import kr.switcher.switcherm.device.switcher.handler.SwitcherHandler;
import kr.switcher.switcherm.network.http.RestSwitcherAPIStore;
import kr.switcher.switcherm.network.http.response.AppliancesAPIResponse;
import kr.switcher.switcherm.network.http.response.DeviceAPIResponse;
import kr.switcher.switcherm.network.http.response.HttpAPIResponse;
import kr.switcher.switcherm.network.http.response.HttpResponseHandler;
import kr.switcher.switcherm.network.http.response.HttpResponseListHandler;
import kr.switcher.switcherm.network.http.response.PreparingAPIResponse;
import kr.switcher.switcherm.preference.OAuthToken;
import kr.switcher.switcherm.user.Preparing;

/* JADX INFO: loaded from: classes2.dex */
public class IODeviceHandler {
    private static final String TAG = "IODeviceHandler";
    private static volatile IODeviceHandler instance;
    private HashMap<String, IODevice> ioDeviceMap = new HashMap<>();
    private List<Preparing> preparings = new ArrayList();
    private IODeviceCreator ioDeviceCreator = new IODeviceCreator(this.ioDeviceMap);
    private PreparingCreator preparingCreator = new PreparingCreator();
    private RemoconCreator remoconCreator = new RemoconCreator(this.ioDeviceMap);

    public interface OnCreateIODeviceListener {
        void onFailure(String str, String str2);

        void onSuccess(IODevice iODevice);
    }

    public interface OnCreatePreparingListener {
        void onResult(List<Preparing> list);
    }

    public interface OnCreateRemoconListener {
        void onResult(List<Remocon> list);
    }

    public interface OnCreateResultListener {
        void onResult(String str, String str2);
    }

    public IODeviceHandler() {
        initDeviceHandlers();
    }

    private void initDeviceHandlers() {
        if (SwitcherHandler.getInstance() == null) {
            new SwitcherHandler.Builder().build(this.ioDeviceMap);
        }
        if (LinkerHandler.getInstance() == null) {
            new LinkerHandler.Builder().build(this.ioDeviceMap);
        }
        if (CheckerHandler.getInstance() == null) {
            new CheckerHandler.Builder().build(this.ioDeviceMap);
        }
    }

    public static IODeviceHandler getInstance() {
        if (instance == null) {
            synchronized (IODeviceHandler.class) {
            }
        }
        return instance;
    }

    public void removeDevice(IODevice iODevice) {
        this.ioDeviceCreator.remove(iODevice);
    }

    public static final class Builder {
        public IODeviceHandler build() {
            IODeviceHandler unused = IODeviceHandler.instance = new IODeviceHandler();
            return IODeviceHandler.instance;
        }
    }

    public void createIODevices(OnCreateResultListener onCreateResultListener) {
        this.ioDeviceCreator.create(onCreateResultListener);
        this.preparingCreator.create(new OnCreatePreparingListener() { // from class: kr.switcher.switcherm.device.IODeviceHandler.1
            @Override // kr.switcher.switcherm.device.IODeviceHandler.OnCreatePreparingListener
            public void onResult(List<Preparing> list) {
                IODeviceHandler.this.preparings = list;
            }
        });
        this.remoconCreator.create();
    }

    public void createDeviceByMacAddress(final String str, final boolean z, final OnCreateIODeviceListener onCreateIODeviceListener) {
        RestSwitcherAPIStore.requestGetDevice(str, new HttpResponseHandler() { // from class: kr.switcher.switcherm.device.IODeviceHandler.2
            @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
            public void onSuccess(HttpAPIResponse httpAPIResponse) {
                IODevice getDevice = IODeviceJsonParser.parseGetDevice((DeviceAPIResponse) httpAPIResponse, IOUtil.makeLocalMacAddressFormat(str));
                if (getDevice.getProductId().equals(IODevice.ProductId.SWITCHER_TYPE_ONE) || getDevice.getProductId().equals(IODevice.ProductId.SWITCHER_TYPE_TWO)) {
                    Switcher switcher = (Switcher) getDevice;
                    SwitcherDBProvider switcherDBProvider = new SwitcherDBProvider();
                    getDevice.setName(switcherDBProvider.getSwitcherName(switcher));
                    if (!z) {
                        switcher.beGuest();
                        switcher.setShareCode(getDevice.getShareCode());
                    }
                    switcherDBProvider.setSwitcherInfoToDB(switcher);
                    OnCreateIODeviceListener onCreateIODeviceListener2 = onCreateIODeviceListener;
                    if (onCreateIODeviceListener2 != null) {
                        onCreateIODeviceListener2.onSuccess(switcher);
                        return;
                    }
                    return;
                }
                if (getDevice.getProductId().equals(IODevice.ProductId.LINKER)) {
                    Linker linker = (Linker) getDevice;
                    new LinkerDBProvider().setLinkers(Arrays.asList(linker));
                    OnCreateIODeviceListener onCreateIODeviceListener3 = onCreateIODeviceListener;
                    if (onCreateIODeviceListener3 != null) {
                        onCreateIODeviceListener3.onSuccess(linker);
                        return;
                    }
                    return;
                }
                if (getDevice.getProductId().equals(IODevice.ProductId.CHECKER)) {
                    Checker checker = (Checker) getDevice;
                    new CheckerDBProvider().setCheckers(Arrays.asList(checker));
                    OnCreateIODeviceListener onCreateIODeviceListener4 = onCreateIODeviceListener;
                    if (onCreateIODeviceListener4 != null) {
                        onCreateIODeviceListener4.onSuccess(checker);
                    }
                }
            }

            @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
            public void onFailure(String str2, String str3) {
                OnCreateIODeviceListener onCreateIODeviceListener2 = onCreateIODeviceListener;
                if (onCreateIODeviceListener2 != null) {
                    onCreateIODeviceListener2.onFailure(str2, str3);
                }
                IOLog.error(IODeviceHandler.TAG, new OAuthToken().getOAuthToken(), "requestGetDevice()", new Exception("code:" + str2 + ", message:" + str3));
            }
        });
    }

    public void addDevice(IODevice iODevice) {
        this.ioDeviceCreator.putDevice(iODevice);
    }

    public void replaceDevice(IODevice iODevice) {
        this.ioDeviceMap.remove(iODevice.getMacAddress());
        this.ioDeviceCreator.putDevice(iODevice);
    }

    public IODevice getDevice(String str) {
        return this.ioDeviceMap.get(str);
    }

    public List<IODevice> getDeviceAll() {
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = this.ioDeviceMap.keySet().iterator();
        while (it.hasNext()) {
            arrayList.add(this.ioDeviceMap.get(it.next()));
        }
        return arrayList;
    }

    public List<IODevice> getMyDeviceAll() {
        ArrayList arrayList = new ArrayList();
        for (String str : this.ioDeviceMap.keySet()) {
            if (this.ioDeviceMap.get(str).isMine()) {
                arrayList.add(this.ioDeviceMap.get(str));
            }
        }
        return arrayList;
    }

    public List<IODevice> getOtherDeviceAll() {
        ArrayList arrayList = new ArrayList();
        for (String str : this.ioDeviceMap.keySet()) {
            if (!this.ioDeviceMap.get(str).isMine()) {
                arrayList.add(this.ioDeviceMap.get(str));
            }
        }
        return arrayList;
    }

    public List<Preparing> getPreparingAll() {
        return this.preparings;
    }

    public Preparing getPreparing(int i) {
        for (Preparing preparing : this.preparings) {
            if (preparing.getFreeTrialId() == i) {
                return preparing;
            }
        }
        return null;
    }

    class IODeviceCreator {
        private final String TAG;
        private IODeviceDBProvider dbProvider;
        private HashMap<String, IODevice> ioDeviceMap;
        private OnCreateResultListener listener;

        private IODeviceCreator(HashMap<String, IODevice> map) {
            this.TAG = IODeviceCreator.class.getSimpleName();
            this.ioDeviceMap = map;
            IODeviceDBProvider iODeviceDBProvider = new IODeviceDBProvider();
            this.dbProvider = iODeviceDBProvider;
            Iterator<IODevice> it = iODeviceDBProvider.getIODeviceAll().iterator();
            while (it.hasNext()) {
                putDevice(it.next());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void create(OnCreateResultListener onCreateResultListener) {
            this.listener = onCreateResultListener;
            createIODevices();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void putDevice(IODevice iODevice) {
            HashMap<String, IODevice> map = this.ioDeviceMap;
            if (map == null) {
                return;
            }
            if (map.containsKey(iODevice.getMacAddress())) {
                IODevice iODevice2 = this.ioDeviceMap.get(iODevice.getMacAddress());
                if ((iODevice2.getClass().equals(SwitcherBLE.class) || iODevice2.getClass().equals(SwitcherLinker.class)) && ((Switcher) iODevice2).getConnectionState().equals(Switcher.ConnectionState.CONNECTED)) {
                    IOLog.i(this.TAG, "can't change connected switcher (" + iODevice.getMacAddress() + ")");
                    if (iODevice.getOption() != null) {
                        iODevice2.setOption(iODevice.getOption());
                        return;
                    }
                    return;
                }
                this.ioDeviceMap.remove(iODevice.getMacAddress());
            }
            this.ioDeviceMap.put(iODevice.getMacAddress(), iODevice);
        }

        private void createIODevices() {
            RestSwitcherAPIStore.requestDevicesMe(new HttpResponseListHandler() { // from class: kr.switcher.switcherm.device.IODeviceHandler.IODeviceCreator.1
                @Override // kr.switcher.switcherm.network.http.response.HttpResponseListHandler
                public void onSuccess(List list) {
                    if (IODeviceCreator.this.listener != null) {
                        IODeviceCreator.this.listener.onResult("success", "");
                    }
                    List<IODevice> getDevicesMe = IODeviceMapper.parseGetDevicesMe(list);
                    getDevicesMe.addAll(IODeviceCreator.this.dbProvider.getShareDevices());
                    IODeviceCreator.this.dbProvider.removeUnusedDevices(getDevicesMe);
                    IODeviceCreator.this.createByType(getDevicesMe);
                }

                @Override // kr.switcher.switcherm.network.http.response.HttpResponseListHandler
                public void onFailure(String str, String str2) {
                    if (IODeviceCreator.this.listener != null) {
                        IODeviceCreator.this.listener.onResult(str, str2);
                    }
                    IOLog.error(IODeviceCreator.this.TAG, new OAuthToken().getOAuthToken(), "createIODevices()", new Exception("code:" + str + ", message:" + str2));
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void createByType(List<IODevice> list) {
            for (IODevice iODevice : list) {
                if (iODevice.getClass().equals(SwitcherBLE.class) || iODevice.getClass().equals(SwitcherLinker.class)) {
                    createSwitcher(iODevice);
                } else if (iODevice.getClass().equals(Linker.class)) {
                    createLinker((Linker) iODevice);
                } else if (iODevice.getClass().equals(Checker.class)) {
                    createChecker((Checker) iODevice);
                }
            }
        }

        private void createSwitcher(IODevice iODevice) {
            SwitcherHandler.getInstance().create(iODevice, iODevice.isMine(), new OnCreateIODeviceListener() { // from class: kr.switcher.switcherm.device.IODeviceHandler.IODeviceCreator.2
                @Override // kr.switcher.switcherm.device.IODeviceHandler.OnCreateIODeviceListener
                public void onSuccess(IODevice iODevice2) {
                    if (iODevice2 != null) {
                        if (!iODevice2.getThingConnectionStatus().equals(IODevice.ThingConnectionStatus.ALIVE)) {
                            IODeviceCreator.this.putDevice(iODevice2);
                        } else if (iODevice2.getClass().equals(SwitcherBLE.class)) {
                            IODeviceCreator.this.linkSwitcher((SwitcherBLE) iODevice2);
                        }
                    }
                }

                @Override // kr.switcher.switcherm.device.IODeviceHandler.OnCreateIODeviceListener
                public void onFailure(String str, String str2) {
                    IODeviceCreator.this.listener.onResult(str, str2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void linkSwitcher(SwitcherBLE switcherBLE) {
            SwitcherLinker switcherLinker = new SwitcherLinker(switcherBLE.getMacAddress(), switcherBLE.getSerialNumber(), switcherBLE.getName(), switcherBLE.getProductId(), switcherBLE.getShareCode(), switcherBLE.getOwner(), switcherBLE.getOption(), switcherBLE.getThingConnectionStatus());
            switcherLinker.setBattery(switcherBLE.getBattery());
            putDevice(switcherLinker);
        }

        private void createLinker(Linker linker) {
            LinkerHandler.getInstance().create(linker, new OnCreateIODeviceListener() { // from class: kr.switcher.switcherm.device.IODeviceHandler.IODeviceCreator.3
                @Override // kr.switcher.switcherm.device.IODeviceHandler.OnCreateIODeviceListener
                public void onSuccess(IODevice iODevice) {
                    if (iODevice != null) {
                        IODeviceCreator.this.putDevice(iODevice);
                    }
                }

                @Override // kr.switcher.switcherm.device.IODeviceHandler.OnCreateIODeviceListener
                public void onFailure(String str, String str2) {
                    IODeviceCreator.this.listener.onResult(str, str2);
                }
            });
        }

        private void createChecker(Checker checker) {
            CheckerHandler.getInstance().create(checker, new OnCreateIODeviceListener() { // from class: kr.switcher.switcherm.device.IODeviceHandler.IODeviceCreator.4
                @Override // kr.switcher.switcherm.device.IODeviceHandler.OnCreateIODeviceListener
                public void onSuccess(IODevice iODevice) {
                    if (iODevice != null) {
                        IODeviceCreator.this.putDevice(iODevice);
                    }
                }

                @Override // kr.switcher.switcherm.device.IODeviceHandler.OnCreateIODeviceListener
                public void onFailure(String str, String str2) {
                    IODeviceCreator.this.listener.onResult(str, str2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void remove(IODevice iODevice) {
            Iterator<IODevice> it = this.dbProvider.getIODeviceAll().iterator();
            while (it.hasNext()) {
                Log.d(this.TAG, "Local DB IO Device DB Provider device" + it.next().getName());
            }
            this.ioDeviceMap.remove(iODevice.getMacAddress());
            if (iODevice.getProductId().equals(IODevice.ProductId.REMOCON)) {
                this.dbProvider.removeRemocon(iODevice);
            }
            this.dbProvider.removeDevice(iODevice);
        }
    }

    class RemoconCreator {
        private final String TAG = RemoconCreator.class.getSimpleName();
        private LinkerDBProvider dbProvider = new LinkerDBProvider();
        private HashMap<String, IODevice> ioDeviceMap;

        public RemoconCreator(HashMap<String, IODevice> map) {
            this.ioDeviceMap = map;
        }

        private void putDevice(IODevice iODevice) {
            HashMap<String, IODevice> map = this.ioDeviceMap;
            if (map == null) {
                return;
            }
            if (map.containsKey(iODevice.getMacAddress())) {
                this.ioDeviceMap.remove(iODevice.getMacAddress());
            }
            this.ioDeviceMap.put(iODevice.getMacAddress(), iODevice);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void create() {
            RestSwitcherAPIStore.requestGetAppliances(new HttpResponseListHandler() { // from class: kr.switcher.switcherm.device.IODeviceHandler.RemoconCreator.1
                @Override // kr.switcher.switcherm.network.http.response.HttpResponseListHandler
                public void onSuccess(List list) {
                    RemoconCreator.this.deleteHashMapRemocon();
                    RemoconCreator.this.dbProvider.setRemocons(IODeviceMapper.parseGetAppliances(list));
                    RemoconCreator.this.putRemocons(list);
                }

                @Override // kr.switcher.switcherm.network.http.response.HttpResponseListHandler
                public void onFailure(String str, String str2) {
                    IOLog.error(RemoconCreator.this.TAG, new OAuthToken().getOAuthToken(), "requestGetAppliances", new Exception("code:" + str + ", message:" + str2));
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void putRemocons(List<AppliancesAPIResponse> list) {
            for (int i = 0; i < list.size(); i++) {
                putDevice(new Remocon(String.valueOf(list.get(i).id), list.get(i).name, Remocon.convertIntToControllerID(list.get(i).remote_controller)));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void deleteHashMapRemocon() {
            ArrayList arrayList = new ArrayList();
            for (String str : this.ioDeviceMap.keySet()) {
                if (this.ioDeviceMap.get(str).getProductId().equals(IODevice.ProductId.REMOCON)) {
                    arrayList.add(this.ioDeviceMap.get(str));
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.ioDeviceMap.remove(((IODevice) it.next()).getMacAddress());
            }
        }
    }

    class PreparingCreator {
        private final String TAG = PreparingCreator.class.getSimpleName();

        PreparingCreator() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void create(final OnCreatePreparingListener onCreatePreparingListener) {
            RestSwitcherAPIStore.requestGetPreparing(new HttpResponseHandler() { // from class: kr.switcher.switcherm.device.IODeviceHandler.PreparingCreator.1
                @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
                public void onSuccess(HttpAPIResponse httpAPIResponse) {
                    onCreatePreparingListener.onResult(PreparingCreator.this.parsePreparings((PreparingAPIResponse) httpAPIResponse));
                }

                @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
                public void onFailure(String str, String str2) {
                    IOLog.error(PreparingCreator.this.TAG, new OAuthToken().getOAuthToken(), "requestGetPreparing", new Exception("code:" + str + ", message:" + str2));
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public List<Preparing> parsePreparings(PreparingAPIResponse preparingAPIResponse) {
            ArrayList arrayList = new ArrayList();
            List<Integer> freeTrialIdList = preparingAPIResponse.getFreeTrialIdList();
            List<Integer> productIdList = preparingAPIResponse.getProductIdList();
            for (int i = 0; i < freeTrialIdList.size(); i++) {
                arrayList.add(new Preparing(freeTrialIdList.get(i).intValue(), DeviceUtil.convertProductId(productIdList.get(i).intValue())));
            }
            return arrayList;
        }
    }
}
