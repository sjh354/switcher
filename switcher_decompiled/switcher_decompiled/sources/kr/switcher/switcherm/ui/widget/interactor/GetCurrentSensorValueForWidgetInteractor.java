package kr.switcher.switcherm.ui.widget.interactor;

import java.util.List;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.device.IODeviceMapper;
import kr.switcher.switcherm.network.http.RestSwitcherAPIStore;
import kr.switcher.switcherm.network.http.response.HttpAPIResponse;
import kr.switcher.switcherm.network.http.response.HttpResponseHandler;
import kr.switcher.switcherm.network.http.response.HttpResponseListHandler;
import kr.switcher.switcherm.network.http.response.SensorsLatestAPIResponse;
import kr.switcher.switcherm.ui.main.helper.LatestSensorValue;

/* JADX INFO: loaded from: classes2.dex */
public class GetCurrentSensorValueForWidgetInteractor {
    public static String TAG = "GetCurrentSensorValueForWidgetInteractor";
    private OnGetAliveLinkerListener getAliveLinkerListener;
    private OnGetCurrentSensorValueListener listener;

    public interface OnGetAliveLinkerListener {
        void onError();

        void onFindAliveLinker(String str);
    }

    public interface OnGetCurrentSensorValueListener {
        void onFind(String str);
    }

    public GetCurrentSensorValueForWidgetInteractor() {
    }

    public GetCurrentSensorValueForWidgetInteractor(OnGetCurrentSensorValueListener onGetCurrentSensorValueListener, OnGetAliveLinkerListener onGetAliveLinkerListener) {
        this.listener = onGetCurrentSensorValueListener;
        this.getAliveLinkerListener = onGetAliveLinkerListener;
    }

    public void getCurrentSensorValueListener(String str, final OnGetCurrentSensorValueListener onGetCurrentSensorValueListener) {
        RestSwitcherAPIStore.requestGetSensorsLatest(IOUtil.makeBackendMacAddressFormat(str), new HttpResponseHandler() { // from class: kr.switcher.switcherm.ui.widget.interactor.GetCurrentSensorValueForWidgetInteractor.1
            @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
            public void onFailure(String str2, String str3) {
            }

            @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
            public void onSuccess(HttpAPIResponse httpAPIResponse) {
                LatestSensorValue latestSensorValue = new LatestSensorValue();
                latestSensorValue.temperature = ((SensorsLatestAPIResponse) httpAPIResponse).temperature;
                onGetCurrentSensorValueListener.onFind(latestSensorValue.temperature);
            }
        });
    }

    public void getAliveLinker(final OnGetAliveLinkerListener onGetAliveLinkerListener) {
        RestSwitcherAPIStore.requestDevicesMe(new HttpResponseListHandler() { // from class: kr.switcher.switcherm.ui.widget.interactor.GetCurrentSensorValueForWidgetInteractor.2
            @Override // kr.switcher.switcherm.network.http.response.HttpResponseListHandler
            public void onSuccess(List list) {
                String getAliveLinkerMacAddress = IODeviceMapper.parseGetAliveLinkerMacAddress(list);
                if (getAliveLinkerMacAddress != null) {
                    onGetAliveLinkerListener.onFindAliveLinker(IOUtil.makeLocalMacAddressFormat(getAliveLinkerMacAddress));
                }
            }

            @Override // kr.switcher.switcherm.network.http.response.HttpResponseListHandler
            public void onFailure(String str, String str2) {
                onGetAliveLinkerListener.onError();
            }
        });
    }
}
