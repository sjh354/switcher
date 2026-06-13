package kr.switcher.switcherm.ui.widget.interactor;

import java.util.List;
import kr.switcher.device.remocon.Remocon;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.device.IODeviceMapper;
import kr.switcher.switcherm.network.http.RestSwitcherAPIStore;
import kr.switcher.switcherm.network.http.response.HttpResponseListHandler;
import kr.switcher.switcherm.preference.OAuthToken;

/* JADX INFO: loaded from: classes2.dex */
public class FindRemoconForWidgetInteractor {
    private static final String TAG = "FindRemoconForWidgetInteractor";
    private OnFoundRemoconForWidgetListener rListener;

    public interface OnFoundRemoconForWidgetListener {
        void onFoundRemoconList(List<Remocon> list);
    }

    public FindRemoconForWidgetInteractor(OnFoundRemoconForWidgetListener onFoundRemoconForWidgetListener) {
        this.rListener = onFoundRemoconForWidgetListener;
    }

    public void getRemoconList(final int i) {
        IOLog.d(TAG, "||WIDGET|| FindRemoconForWidgetInteractor==================================");
        RestSwitcherAPIStore.requestGetAppliances(new HttpResponseListHandler() { // from class: kr.switcher.switcherm.ui.widget.interactor.FindRemoconForWidgetInteractor.1
            @Override // kr.switcher.switcherm.network.http.response.HttpResponseListHandler
            public void onSuccess(List list) {
                FindRemoconForWidgetInteractor.this.rListener.onFoundRemoconList(IODeviceMapper.parseGetAppliances(list, i));
            }

            @Override // kr.switcher.switcherm.network.http.response.HttpResponseListHandler
            public void onFailure(String str, String str2) {
                IOLog.error(FindRemoconForWidgetInteractor.TAG, new OAuthToken().getOAuthToken(), "requestGetAppliances", new Exception("code:" + str + ", message:" + str2));
            }
        });
    }
}
