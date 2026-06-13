package kr.switcher.switcherm.ui.setting.presenter;

import kr.switcher.device.switcher.Switcher;
import kr.switcher.device.switcher.interfaces.IODeviceCallbacks;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.ui.setting.interactor.SetNewShareCodeInteractor;
import kr.switcher.switcherm.ui.setting.view.ShareCodeView;

/* JADX INFO: loaded from: classes2.dex */
public class ShareCodePresenter {
    private static final String TAG = "ShareCodePresenter";
    private SetNewShareCodeInteractor interactor;
    private ShareCodeView view;

    public ShareCodePresenter(ShareCodeView shareCodeView, SetNewShareCodeInteractor setNewShareCodeInteractor) {
        this.view = shareCodeView;
        this.interactor = setNewShareCodeInteractor;
    }

    public void onResume(Switcher switcher) {
        this.view.setShareCode(switcher.getShareCode());
        this.view.setFocusable();
        this.view.hideProgressbar();
    }

    public void changeNewShareCode(String str) {
        this.view.showProgressbar();
        if (str.length() != 4) {
            IOUtil.showToast(IOUtil.getStringResource(R.string.canceled_share_code_change_message));
        } else if (!IOUtil.isDigit(str)) {
            IOUtil.showToast("공유코드는 숫자만 입력 가능합니다");
        } else {
            IOLog.i(TAG, "new sharecode : " + str);
            this.interactor.changeShareCode(str);
        }
    }

    public void onDestroyView() {
        this.view.hideKeyboard();
    }

    public void onChangeResult(boolean z, String str) {
        this.view.hideProgressbar();
        if (z) {
            this.interactor.setNewShareCodeToDB(str);
        } else {
            this.view.showMessage("서버에 공유코드를 저장하지 못했습니다");
        }
    }

    public void onUpdateToDBResult(boolean z, IODeviceCallbacks.OnShareCodeChangeResultCallback onShareCodeChangeResultCallback) {
        if (z) {
            onShareCodeChangeResultCallback.onShareCodeChangeResult(z);
        } else {
            this.view.showMessage("공유코드를 저장하지 못했습니다");
        }
    }
}
