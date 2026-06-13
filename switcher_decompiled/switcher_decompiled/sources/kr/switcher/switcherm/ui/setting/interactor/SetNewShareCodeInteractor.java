package kr.switcher.switcherm.ui.setting.interactor;

import android.content.Context;
import kr.switcher.device.switcher.Switcher;
import kr.switcher.switcherm.device.switcher.handler.SwitcherDBProvider;
import kr.switcher.switcherm.network.http.RestSwitcherAPIStore;
import kr.switcher.switcherm.network.http.response.HttpAPIResponse;
import kr.switcher.switcherm.network.http.response.HttpResponseHandler;

/* JADX INFO: loaded from: classes2.dex */
public class SetNewShareCodeInteractor {
    private static final String TAG = "SetNewShareCodeInteractor";
    private SwitcherDBProvider dbProvider = new SwitcherDBProvider();
    private OnChangeNewShareCodeListener listener;
    private Switcher switcher;

    public interface OnChangeNewShareCodeListener {
        void onChangeToServerResult(boolean z);

        void onUpdateToDBResult(boolean z);
    }

    public SetNewShareCodeInteractor(Context context, Switcher switcher, OnChangeNewShareCodeListener onChangeNewShareCodeListener) {
        this.switcher = switcher;
        this.listener = onChangeNewShareCodeListener;
    }

    public void changeShareCode(String str) {
        RestSwitcherAPIStore.requestPutNewShareCode(this.switcher.getMacAddress(), str, new HttpResponseHandler() { // from class: kr.switcher.switcherm.ui.setting.interactor.SetNewShareCodeInteractor.1
            @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
            public void onSuccess(HttpAPIResponse httpAPIResponse) {
                SetNewShareCodeInteractor.this.listener.onChangeToServerResult(true);
            }

            @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
            public void onFailure(String str2, String str3) {
                SetNewShareCodeInteractor.this.listener.onChangeToServerResult(false);
            }
        });
    }

    public void setNewShareCodeToDB(String str) {
        if (this.dbProvider.updateShareCodeToDB(this.switcher, str) == 1) {
            this.listener.onUpdateToDBResult(true);
        } else {
            this.listener.onUpdateToDBResult(false);
        }
    }
}
