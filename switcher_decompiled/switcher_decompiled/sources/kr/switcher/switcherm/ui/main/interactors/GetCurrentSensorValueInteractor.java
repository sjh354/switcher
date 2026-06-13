package kr.switcher.switcherm.ui.main.interactors;

import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.network.http.RestSwitcherAPIStore;
import kr.switcher.switcherm.network.http.response.HttpAPIResponse;
import kr.switcher.switcherm.network.http.response.HttpResponseHandler;
import kr.switcher.switcherm.network.http.response.SensorsLatestAPIResponse;
import kr.switcher.switcherm.ui.main.helper.LatestSensorValue;

/* JADX INFO: loaded from: classes2.dex */
public class GetCurrentSensorValueInteractor {
    public static String TAG = "GetCurrentSensorValueInteractor";
    private OnGetCurrentSensorValueListener listener;

    public interface OnGetCurrentSensorValueListener {
        void onFind(LatestSensorValue latestSensorValue);
    }

    public GetCurrentSensorValueInteractor(OnGetCurrentSensorValueListener onGetCurrentSensorValueListener) {
        this.listener = onGetCurrentSensorValueListener;
    }

    public void getCurrentSensorValueListener(String str) {
        RestSwitcherAPIStore.requestGetSensorsLatest(IOUtil.makeBackendMacAddressFormat(str), new HttpResponseHandler() { // from class: kr.switcher.switcherm.ui.main.interactors.GetCurrentSensorValueInteractor.1
            @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
            public void onFailure(String str2, String str3) {
            }

            @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
            public void onSuccess(HttpAPIResponse httpAPIResponse) {
                LatestSensorValue latestSensorValue = new LatestSensorValue();
                SensorsLatestAPIResponse sensorsLatestAPIResponse = (SensorsLatestAPIResponse) httpAPIResponse;
                latestSensorValue.mac_address = sensorsLatestAPIResponse.mac_address;
                latestSensorValue.created_at = sensorsLatestAPIResponse.created_at;
                latestSensorValue.decibel = sensorsLatestAPIResponse.decibel;
                latestSensorValue.id = sensorsLatestAPIResponse.id;
                latestSensorValue.illumination_intensity = sensorsLatestAPIResponse.illumination_intensity;
                latestSensorValue.temperature = sensorsLatestAPIResponse.temperature;
                GetCurrentSensorValueInteractor.this.listener.onFind(latestSensorValue);
            }
        });
    }
}
