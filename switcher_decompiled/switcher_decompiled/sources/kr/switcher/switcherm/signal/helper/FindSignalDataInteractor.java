package kr.switcher.switcherm.signal.helper;

import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.device.linker.LinkerHandler;
import kr.switcher.switcherm.network.http.RestSwitcherAPIStore;
import kr.switcher.switcherm.network.http.response.HttpAPIResponse;
import kr.switcher.switcherm.network.http.response.HttpResponseHandler;
import kr.switcher.switcherm.network.http.response.SignalFeatureAPIResponse;
import kr.switcher.switcherm.network.http.response.SignalMarketingAPIResponse;
import kr.switcher.switcherm.signal.SignalData;
import kr.switcher.switcherm.ui.dialog.signal.interactor.SendStatusForSignalInteractor;

/* JADX INFO: loaded from: classes2.dex */
public class FindSignalDataInteractor {
    private static final String TAG = "FindSignalDataInteractor";
    private OnFoundSignalDataListener listener;

    public interface OnFoundSignalDataListener {
        void onEmpty();

        void onFoundSignalData(SignalData signalData);
    }

    public FindSignalDataInteractor(OnFoundSignalDataListener onFoundSignalDataListener) {
        this.listener = onFoundSignalDataListener;
    }

    public void findSignalForFeature(final String str) {
        RestSwitcherAPIStore.requestGetSignalBySwitcher(str, new HttpResponseHandler() { // from class: kr.switcher.switcherm.signal.helper.FindSignalDataInteractor.1
            @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
            public void onSuccess(HttpAPIResponse httpAPIResponse) {
                SignalData signalDataForFeature = SignalJsonParser.parseSignalDataForFeature((SignalFeatureAPIResponse) httpAPIResponse);
                if (signalDataForFeature.checkIsValidData()) {
                    FindSignalDataInteractor.this.listener.onFoundSignalData(signalDataForFeature);
                } else {
                    new SendStatusForSignalInteractor().sendStatus(str, signalDataForFeature, SignalData.SIGNAL_STATUS_NOT_APPLICABLE);
                }
            }

            @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
            public void onFailure(String str2, String str3) {
                FindSignalDataInteractor.this.listener.onEmpty();
                IOLog.i(FindSignalDataInteractor.TAG, "code:" + str2 + ", message:" + str3);
            }
        });
    }

    public void findSignalForMarketing() {
        RestSwitcherAPIStore.requestGetSignalForMarketing(new HttpResponseHandler() { // from class: kr.switcher.switcherm.signal.helper.FindSignalDataInteractor.2
            @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
            public void onSuccess(HttpAPIResponse httpAPIResponse) {
                SignalData signalDataForMarketing = SignalJsonParser.parseSignalDataForMarketing((SignalMarketingAPIResponse) httpAPIResponse);
                if (signalDataForMarketing.checkIsValidData()) {
                    FindSignalDataInteractor.this.listener.onFoundSignalData(signalDataForMarketing);
                }
            }

            @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
            public void onFailure(String str, String str2) {
                FindSignalDataInteractor.this.listener.onEmpty();
                IOLog.i(FindSignalDataInteractor.TAG, "code:" + str + ", message:" + str2);
            }
        });
    }

    public void findSignalForLocalMarketing() {
        if (LinkerHandler.getInstance().getAllLinkers().size() == 0) {
            this.listener.onFoundSignalData(new SignalData(0, 0, "에어컨도 위젯으로 켜고 꺼 보실래요?", "아이오 소식", "https://try.i-o.studio"));
        }
    }
}
