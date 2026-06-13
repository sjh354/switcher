package kr.switcher.switcherm.ui.widget.interactor;

import java.util.List;
import kr.switcher.device.checker.Checker;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.device.IODeviceMapper;
import kr.switcher.switcherm.network.http.RestSwitcherAPIStore;
import kr.switcher.switcherm.network.http.response.HttpResponseListHandler;
import kr.switcher.switcherm.ui.setting.adapter.CheckerSurveillanceItem;

/* JADX INFO: loaded from: classes2.dex */
public class GetCheckerSurveillanceInfoForWidgetInteractor {
    public static String TAG = "GetCheckerSurveillanceInfoForWidgetInteractor";
    private OnGetAliveCheckerListener getAliveCheckerListener;
    private OnGetCheckerSurveillanceListener listener;

    public interface OnGetAliveCheckerListener {
        void onFindAliveChecker(Checker checker);
    }

    public interface OnGetCheckerSurveillanceListener {
        void onFind(List<CheckerSurveillanceItem> list);
    }

    public GetCheckerSurveillanceInfoForWidgetInteractor(OnGetCheckerSurveillanceListener onGetCheckerSurveillanceListener, OnGetAliveCheckerListener onGetAliveCheckerListener) {
        this.listener = onGetCheckerSurveillanceListener;
        this.getAliveCheckerListener = onGetAliveCheckerListener;
    }

    public GetCheckerSurveillanceInfoForWidgetInteractor() {
    }

    public void getCheckerSurveillanceInfo(String str, final OnGetCheckerSurveillanceListener onGetCheckerSurveillanceListener) {
        RestSwitcherAPIStore.requestGetCheckersSurveillance(IOUtil.makeBackendMacAddressFormat(str), new HttpResponseListHandler() { // from class: kr.switcher.switcherm.ui.widget.interactor.GetCheckerSurveillanceInfoForWidgetInteractor.1
            @Override // kr.switcher.switcherm.network.http.response.HttpResponseListHandler
            public void onFailure(String str2, String str3) {
            }

            @Override // kr.switcher.switcherm.network.http.response.HttpResponseListHandler
            public void onSuccess(List list) {
                if (list == null) {
                    IOLog.i(GetCheckerSurveillanceInfoForWidgetInteractor.TAG, "No checker's Surveillance.");
                } else {
                    onGetCheckerSurveillanceListener.onFind(IODeviceMapper.parseGetCheckersSurveillance(list));
                }
            }
        });
    }

    public void getAliveLinker() {
        RestSwitcherAPIStore.requestDevicesMe(new HttpResponseListHandler() { // from class: kr.switcher.switcherm.ui.widget.interactor.GetCheckerSurveillanceInfoForWidgetInteractor.2
            @Override // kr.switcher.switcherm.network.http.response.HttpResponseListHandler
            public void onFailure(String str, String str2) {
            }

            @Override // kr.switcher.switcherm.network.http.response.HttpResponseListHandler
            public void onSuccess(List list) {
            }
        });
    }
}
