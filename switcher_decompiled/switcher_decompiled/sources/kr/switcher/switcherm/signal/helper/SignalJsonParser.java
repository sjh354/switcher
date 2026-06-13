package kr.switcher.switcherm.signal.helper;

import kr.switcher.switcherm.network.http.response.SignalFeatureAPIResponse;
import kr.switcher.switcherm.network.http.response.SignalMarketingAPIResponse;
import kr.switcher.switcherm.signal.SignalData;

/* JADX INFO: loaded from: classes2.dex */
public class SignalJsonParser {
    private static final String TAG = "SignalJsonParser";

    public static SignalData parseSignalDataForFeature(SignalFeatureAPIResponse signalFeatureAPIResponse) {
        return new SignalData(signalFeatureAPIResponse.architecture_id, signalFeatureAPIResponse.instance_id, signalFeatureAPIResponse.suggestion_text, signalFeatureAPIResponse.button_text, signalFeatureAPIResponse.url);
    }

    public static SignalData parseSignalDataForMarketing(SignalMarketingAPIResponse signalMarketingAPIResponse) {
        return new SignalData(0, signalMarketingAPIResponse.instance_id, signalMarketingAPIResponse.content_text, signalMarketingAPIResponse.title_text, signalMarketingAPIResponse.url);
    }
}
