package kr.switcher.switcherm.device.checker;

import com.google.firebase.messaging.Constants;
import java.util.Arrays;
import java.util.HashMap;
import kr.switcher.device.IODevice;
import kr.switcher.device.checker.Checker;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.device.IODeviceHandler;
import kr.switcher.switcherm.device.IODeviceJsonParser;
import kr.switcher.switcherm.network.http.RestSwitcherAPIStore;
import kr.switcher.switcherm.network.http.response.DeviceAPIResponse;
import kr.switcher.switcherm.network.http.response.HttpAPIResponse;
import kr.switcher.switcherm.network.http.response.HttpResponseHandler;
import kr.switcher.switcherm.preference.OAuthToken;

/* JADX INFO: loaded from: classes2.dex */
public class CheckerHandler {
    private static final String TAG = "CheckerHandler";
    private static volatile CheckerHandler instance;
    private HashMap<String, IODevice> ioDeviceMap;
    private CheckerDBProvider dbProvider = new CheckerDBProvider();
    private CheckerCreator creator = new CheckerCreator();

    public CheckerHandler(HashMap<String, IODevice> map) {
        this.ioDeviceMap = map;
    }

    public static CheckerHandler getInstance() {
        if (instance == null) {
            synchronized (CheckerHandler.class) {
            }
        }
        return instance;
    }

    public void create(IODevice iODevice, IODeviceHandler.OnCreateIODeviceListener onCreateIODeviceListener) {
        this.creator.create(iODevice, onCreateIODeviceListener);
    }

    public static final class Builder {
        public CheckerHandler build(HashMap<String, IODevice> map) {
            CheckerHandler unused = CheckerHandler.instance = new CheckerHandler(map);
            return CheckerHandler.instance;
        }
    }

    public Checker getChecker(String str) {
        return (Checker) IODeviceHandler.getInstance().getDevice(str);
    }

    class CheckerCreator {
        CheckerCreator() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void create(final IODevice iODevice, final IODeviceHandler.OnCreateIODeviceListener onCreateIODeviceListener) {
            RestSwitcherAPIStore.requestGetDevice(iODevice.getMacAddress(), new HttpResponseHandler() { // from class: kr.switcher.switcherm.device.checker.CheckerHandler.CheckerCreator.1
                @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
                public void onSuccess(HttpAPIResponse httpAPIResponse) {
                    Checker checker = (Checker) IODeviceJsonParser.parseGetDevice((DeviceAPIResponse) httpAPIResponse, iODevice.getMacAddress());
                    if (checker != null) {
                        CheckerHandler.this.dbProvider.setCheckers(Arrays.asList(checker));
                        IODeviceHandler.OnCreateIODeviceListener onCreateIODeviceListener2 = onCreateIODeviceListener;
                        if (onCreateIODeviceListener2 != null) {
                            onCreateIODeviceListener2.onSuccess(checker);
                            return;
                        }
                        return;
                    }
                    IODeviceHandler.OnCreateIODeviceListener onCreateIODeviceListener3 = onCreateIODeviceListener;
                    if (onCreateIODeviceListener3 != null) {
                        onCreateIODeviceListener3.onFailure("", Constants.IPC_BUNDLE_KEY_SEND_ERROR);
                    }
                }

                @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
                public void onFailure(String str, String str2) {
                    IODeviceHandler.OnCreateIODeviceListener onCreateIODeviceListener2 = onCreateIODeviceListener;
                    if (onCreateIODeviceListener2 != null) {
                        onCreateIODeviceListener2.onFailure(str, str2);
                    }
                    IOLog.error(CheckerHandler.TAG, new OAuthToken().getOAuthToken(), "requestGetChecker()", new Exception("code:" + str + ", message:" + str2));
                }
            });
        }
    }
}
