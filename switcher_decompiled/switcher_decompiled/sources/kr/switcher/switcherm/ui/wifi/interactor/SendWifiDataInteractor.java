package kr.switcher.switcherm.ui.wifi.interactor;

import android.os.Handler;
import android.os.Looper;
import kr.switcher.device.IODevice;
import kr.switcher.device.checker.Checker;
import kr.switcher.device.linker.Linker;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.device.IODeviceHandler;
import kr.switcher.switcherm.network.http.RestSwitcherAPIStore;
import kr.switcher.switcherm.network.http.microservice.MobileMicroService;
import kr.switcher.switcherm.network.http.response.DeviceAPIResponse;
import kr.switcher.switcherm.network.http.response.HttpAPIResponse;
import kr.switcher.switcherm.network.http.response.HttpResponseHandler;
import kr.switcher.switcherm.network.wifi.WifiData;
import no.nordicsemi.android.dfu.internal.scanner.BootloaderScanner;

/* JADX INFO: loaded from: classes2.dex */
public class SendWifiDataInteractor {
    private int count = 0;
    private OnSendWifiDataListener listener;

    public interface OnSendWifiDataListener {
        void onFail(String str);

        void onFinish();

        void onSend(String str);
    }

    public SendWifiDataInteractor(OnSendWifiDataListener onSendWifiDataListener) {
        this.listener = onSendWifiDataListener;
    }

    public void sendWifiData(final WifiData wifiData, final IODevice iODevice) {
        if (iODevice.getClass().equals(Linker.class)) {
            ((Linker) iODevice).sendWifiInfo(wifiData.getSsid(), wifiData.getPassword(), new Linker.OnWifiSSIDSendListener() { // from class: kr.switcher.switcherm.ui.wifi.interactor.SendWifiDataInteractor.1
                @Override // kr.switcher.device.linker.Linker.OnWifiSSIDSendListener
                public void onWifiSSIDSendResult(boolean z) {
                    if (z) {
                        SendWifiDataInteractor.this.listener.onSend("링커가 " + wifiData.getSsid() + " 와이파이 연결을 시도하고 있습니다");
                        SendWifiDataInteractor.this.checkAliveAndFinish(iODevice);
                    } else {
                        SendWifiDataInteractor.this.listener.onFail(wifiData.getSsid() + " 와이파이 연결에 실패하였습니다");
                    }
                }
            });
        } else if (iODevice.getClass().equals(Checker.class)) {
            String str = MobileMicroService.ACCESS_TOKEN;
            try {
                str = MobileMicroService.ACCESS_TOKEN.split(" ")[1];
            } catch (Exception unused) {
            }
            ((Checker) iODevice).sendWifiInfo(wifiData.getSsid(), wifiData.getPassword(), str, new Checker.OnWifiSSIDSendListener() { // from class: kr.switcher.switcherm.ui.wifi.interactor.SendWifiDataInteractor.2
                @Override // kr.switcher.device.checker.Checker.OnWifiSSIDSendListener
                public void onWifiSSIDSendResult(boolean z) {
                    if (z) {
                        SendWifiDataInteractor.this.listener.onSend("체커가 " + wifiData.getSsid() + " 와이파이 연결을 시도하고 있습니다");
                        SendWifiDataInteractor.this.checkAliveAndFinish(iODevice);
                    } else {
                        SendWifiDataInteractor.this.listener.onFail(wifiData.getSsid() + " 와이파이 연결에 실패하였습니다");
                    }
                }
            });
        }
    }

    /* JADX INFO: renamed from: kr.switcher.switcherm.ui.wifi.interactor.SendWifiDataInteractor$3, reason: invalid class name */
    class AnonymousClass3 implements Runnable {
        final /* synthetic */ IODevice val$ioDevice;

        AnonymousClass3(IODevice iODevice) {
            this.val$ioDevice = iODevice;
        }

        @Override // java.lang.Runnable
        public void run() {
            RestSwitcherAPIStore.requestGetDevice(this.val$ioDevice.getMacAddress(), new HttpResponseHandler() { // from class: kr.switcher.switcherm.ui.wifi.interactor.SendWifiDataInteractor.3.1
                @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
                public void onSuccess(HttpAPIResponse httpAPIResponse) {
                    DeviceAPIResponse deviceAPIResponse = (DeviceAPIResponse) httpAPIResponse;
                    if (deviceAPIResponse != null) {
                        if (!deviceAPIResponse.getConnectionStatus().equals(IODevice.ThingConnectionStatus.ALIVE)) {
                            if (SendWifiDataInteractor.this.count != 60) {
                                SendWifiDataInteractor.this.checkAliveAndFinish(AnonymousClass3.this.val$ioDevice);
                                return;
                            } else {
                                IOUtil.showToast("기기 연결에 실패했습니다");
                                return;
                            }
                        }
                        IOUtil.showToast("기기에 연결이 완료되었습니다");
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: kr.switcher.switcherm.ui.wifi.interactor.SendWifiDataInteractor.3.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                IOUtil.showToast("내 I/O 디바이스들 연결중...");
                            }
                        }, 2000L);
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: kr.switcher.switcherm.ui.wifi.interactor.SendWifiDataInteractor.3.1.2
                            @Override // java.lang.Runnable
                            public void run() {
                                IOUtil.showToast("끝!");
                                IODeviceHandler.getInstance().createIODevices(null);
                                SendWifiDataInteractor.this.listener.onFinish();
                            }
                        }, BootloaderScanner.TIMEOUT);
                    }
                }

                @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
                public void onFailure(String str, String str2) {
                    SendWifiDataInteractor.this.listener.onFail("기기 연결에 실패했습니다");
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkAliveAndFinish(IODevice iODevice) {
        new Handler(Looper.getMainLooper()).postDelayed(new AnonymousClass3(iODevice), 1000L);
    }
}
