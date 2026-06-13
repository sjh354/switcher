package kr.switcher.switcherm.ui.setting.interactor;

import java.util.List;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.device.IODeviceMapper;
import kr.switcher.switcherm.network.http.RestSwitcherAPIStore;
import kr.switcher.switcherm.network.http.response.HttpResponseListHandler;
import kr.switcher.switcherm.preference.OAuthToken;
import kr.switcher.switcherm.ui.setting.adapter.CheckerSurveillanceItem;

/* JADX INFO: loaded from: classes2.dex */
public class FindCheckerSurveillanceListInteractor {
    private static final String TAG = "FindCheckerSurveillanceListInteractor";
    private OnFindCheckerSurveillanceListListener listener;

    public interface OnFindCheckerSurveillanceListListener {
        void onFindCheckerSurveillance(List<CheckerSurveillanceItem> list);

        void onFindSurveillanceError(String str);
    }

    public FindCheckerSurveillanceListInteractor(OnFindCheckerSurveillanceListListener onFindCheckerSurveillanceListListener) {
        this.listener = onFindCheckerSurveillanceListListener;
    }

    public void requestGetCheckersSurveillance(String str) {
        RestSwitcherAPIStore.requestGetCheckersSurveillance(IOUtil.makeBackendMacAddressFormat(str), new HttpResponseListHandler() { // from class: kr.switcher.switcherm.ui.setting.interactor.FindCheckerSurveillanceListInteractor.1
            @Override // kr.switcher.switcherm.network.http.response.HttpResponseListHandler
            public void onSuccess(List list) {
                List<CheckerSurveillanceItem> getCheckersSurveillance = IODeviceMapper.parseGetCheckersSurveillance(list);
                FindCheckerSurveillanceListInteractor.this.listener.onFindCheckerSurveillance(getCheckersSurveillance);
                getCheckersSurveillance.clear();
            }

            @Override // kr.switcher.switcherm.network.http.response.HttpResponseListHandler
            public void onFailure(String str2, String str3) {
                IOLog.error(FindCheckerSurveillanceListInteractor.TAG, new OAuthToken().getOAuthToken(), "requestGetCheckersSurveillance", new Exception("code:" + str2 + ", message:" + str3));
                FindCheckerSurveillanceListInteractor.this.listener.onFindSurveillanceError(str3);
            }
        });
    }
}
