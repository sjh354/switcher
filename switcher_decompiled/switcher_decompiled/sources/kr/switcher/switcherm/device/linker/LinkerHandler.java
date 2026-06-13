package kr.switcher.switcherm.device.linker;

import com.google.firebase.messaging.Constants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import kr.switcher.device.IODevice;
import kr.switcher.device.linker.Linker;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.device.IODeviceHandler;
import kr.switcher.switcherm.device.IODeviceJsonParser;
import kr.switcher.switcherm.network.http.RestSwitcherAPIStore;
import kr.switcher.switcherm.network.http.response.DeviceAPIResponse;
import kr.switcher.switcherm.network.http.response.HttpAPIResponse;
import kr.switcher.switcherm.network.http.response.HttpResponseHandler;
import kr.switcher.switcherm.preference.OAuthToken;

/* JADX INFO: loaded from: classes2.dex */
public class LinkerHandler {
    private static final String TAG = "LinkerHandler";
    private static volatile LinkerHandler instance;
    private HashMap<String, IODevice> ioDeviceMap;
    private LinkerDBProvider dbProvider = new LinkerDBProvider();
    private LinkerCreator creator = new LinkerCreator();

    interface ThingCreateListener {
        void onCreate(String str);
    }

    public LinkerHandler(HashMap<String, IODevice> map) {
        this.ioDeviceMap = map;
    }

    public static LinkerHandler getInstance() {
        if (instance == null) {
            synchronized (LinkerHandler.class) {
            }
        }
        return instance;
    }

    public void create(IODevice iODevice, IODeviceHandler.OnCreateIODeviceListener onCreateIODeviceListener) {
        this.creator.create(iODevice, onCreateIODeviceListener);
    }

    public Linker getMainLinker() {
        List<Linker> linkerAll = this.dbProvider.getLinkerAll();
        if (linkerAll.size() > 0) {
            return linkerAll.get(0);
        }
        return null;
    }

    public static final class Builder {
        public LinkerHandler build(HashMap<String, IODevice> map) {
            LinkerHandler unused = LinkerHandler.instance = new LinkerHandler(map);
            return LinkerHandler.instance;
        }
    }

    public List<Linker> getAllLinkers() {
        ArrayList arrayList = new ArrayList();
        for (String str : this.ioDeviceMap.keySet()) {
            if (this.ioDeviceMap.get(str).getClass().equals(Linker.class)) {
                arrayList.add((Linker) this.ioDeviceMap.get(str));
            }
        }
        return arrayList;
    }

    public List<Linker> getAliveLinkers() {
        ArrayList arrayList = new ArrayList();
        for (String str : this.ioDeviceMap.keySet()) {
            if (this.ioDeviceMap.get(str).getClass().equals(Linker.class)) {
                Linker linker = (Linker) this.ioDeviceMap.get(str);
                if (linker.getThingConnectionStatus().equals(IODevice.ThingConnectionStatus.ALIVE)) {
                    arrayList.add(linker);
                }
            }
        }
        return arrayList;
    }

    public Linker getLinker(String str) {
        return (Linker) IODeviceHandler.getInstance().getDevice(str);
    }

    class LinkerCreator {
        LinkerCreator() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void create(final IODevice iODevice, final IODeviceHandler.OnCreateIODeviceListener onCreateIODeviceListener) {
            RestSwitcherAPIStore.requestGetDevice(iODevice.getMacAddress(), new HttpResponseHandler() { // from class: kr.switcher.switcherm.device.linker.LinkerHandler.LinkerCreator.1
                @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
                public void onSuccess(HttpAPIResponse httpAPIResponse) {
                    Linker linker = (Linker) IODeviceJsonParser.parseGetDevice((DeviceAPIResponse) httpAPIResponse, iODevice.getMacAddress());
                    if (linker == null) {
                        IODeviceHandler.OnCreateIODeviceListener onCreateIODeviceListener2 = onCreateIODeviceListener;
                        if (onCreateIODeviceListener2 != null) {
                            onCreateIODeviceListener2.onFailure("", Constants.IPC_BUNDLE_KEY_SEND_ERROR);
                            return;
                        }
                        return;
                    }
                    linker.setName("링커");
                    LinkerHandler.this.dbProvider.setLinkers(Arrays.asList(linker));
                    IODeviceHandler.OnCreateIODeviceListener onCreateIODeviceListener3 = onCreateIODeviceListener;
                    if (onCreateIODeviceListener3 != null) {
                        onCreateIODeviceListener3.onSuccess(linker);
                    }
                }

                @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
                public void onFailure(String str, String str2) {
                    IODeviceHandler.OnCreateIODeviceListener onCreateIODeviceListener2 = onCreateIODeviceListener;
                    if (onCreateIODeviceListener2 != null) {
                        onCreateIODeviceListener2.onFailure(str, str2);
                    }
                    IOLog.error(LinkerHandler.TAG, new OAuthToken().getOAuthToken(), "requestGetLinker()", new Exception("code:" + str + ", message:" + str2));
                }
            });
        }
    }
}
