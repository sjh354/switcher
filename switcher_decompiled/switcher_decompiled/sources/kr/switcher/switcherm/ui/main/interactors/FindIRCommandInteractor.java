package kr.switcher.switcherm.ui.main.interactors;

import java.util.List;
import kr.switcher.device.remocon.IRCommand;
import kr.switcher.device.remocon.Remocon;
import kr.switcher.device.switcher.Switcher;
import kr.switcher.switcherm.common.IOConfig;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.device.IODeviceMapper;
import kr.switcher.switcherm.network.http.RestErrorCode;
import kr.switcher.switcherm.network.http.RestSwitcherAPIStore;
import kr.switcher.switcherm.network.http.response.HttpAPIResponse;
import kr.switcher.switcherm.network.http.response.HttpResponseHandler;
import kr.switcher.switcherm.network.http.response.HttpResponseListHandler;
import kr.switcher.switcherm.preference.OAuthToken;
import kr.switcher.switcherm.ui.main.adapter.CommandItem;

/* JADX INFO: loaded from: classes2.dex */
public class FindIRCommandInteractor {
    public static String TAG = "FindIRCommandInteractor";
    private OnFindIRCommandListener listener;

    public interface OnFindIRCommandListener {
        void onCHRelease(boolean z, String str, String str2);

        void onFind(List<IRCommand> list);

        void onRelease(boolean z);

        void onRemove(boolean z, String str);
    }

    public FindIRCommandInteractor(OnFindIRCommandListener onFindIRCommandListener) {
        this.listener = onFindIRCommandListener;
    }

    public void findIRCommand(Remocon remocon) {
        RestSwitcherAPIStore.requestGetIR(remocon.getId(), new HttpResponseListHandler() { // from class: kr.switcher.switcherm.ui.main.interactors.FindIRCommandInteractor.1
            @Override // kr.switcher.switcherm.network.http.response.HttpResponseListHandler
            public void onSuccess(List list) {
                FindIRCommandInteractor.this.listener.onFind(IODeviceMapper.parseGetIR(list));
            }

            @Override // kr.switcher.switcherm.network.http.response.HttpResponseListHandler
            public void onFailure(String str, String str2) {
                IOLog.error(FindIRCommandInteractor.TAG, new OAuthToken().getOAuthToken(), "requestGetIR", new Exception("code:" + str + ", message:" + str2));
            }
        });
    }

    public void releaseIR(CommandItem commandItem) {
        RestSwitcherAPIStore.requestPostRelease(commandItem.getId(), new HttpResponseHandler() { // from class: kr.switcher.switcherm.ui.main.interactors.FindIRCommandInteractor.2
            @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
            public void onSuccess(HttpAPIResponse httpAPIResponse) {
                FindIRCommandInteractor.this.listener.onRelease(true);
            }

            @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
            public void onFailure(String str, String str2) {
                IOLog.error(FindIRCommandInteractor.TAG, new OAuthToken().getOAuthToken(), "releaseIR", new Exception("code:" + str + ", message:" + str2));
                FindIRCommandInteractor.this.listener.onRelease(false);
            }
        });
    }

    public void releaseIR(final IRCommand iRCommand) {
        RestSwitcherAPIStore.requestPostRelease(iRCommand.getId(), new HttpResponseHandler() { // from class: kr.switcher.switcherm.ui.main.interactors.FindIRCommandInteractor.3
            @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
            public void onSuccess(HttpAPIResponse httpAPIResponse) {
                String name = iRCommand.getName();
                if (name.equals("ON") || name.equals(IOConfig.OFF)) {
                    IOUtil.showToast("전원 명령어 실행");
                } else if (name.equals(Switcher.SwitcherReservation.SWITCH_1WAY_FIRMWARE) || name.equals("1") || name.equals(RestErrorCode.PHONE_NUMBER_IS_WRONG) || name.equals(RestErrorCode.CUSTOMER_DOES_NOT_EXIST) || name.equals(RestErrorCode.AUTHNUMBER_IS_WRONG) || name.equals(RestErrorCode.ACCESS_TOKEN_IS_EMPTY) || name.equals(RestErrorCode.ACCESSTOKEN_DOES_NOT_EXIST) || name.equals(RestErrorCode.ACCESSTOKEN_IS_NOT_MATCHED) || name.equals(RestErrorCode.MACADDRESS_IS_EMPTY) || name.equals(RestErrorCode.MACADDRESS_DOES_NOT_EXIST)) {
                    IOUtil.showToast("채널 명령어 실행");
                } else {
                    IOUtil.showToast(name + " 명령어 실행");
                }
                FindIRCommandInteractor.this.listener.onRelease(true);
            }

            @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
            public void onFailure(String str, String str2) {
                IOUtil.showToast(iRCommand.getName() + " 명령어가 저장되어있지 않습니다.");
                IOLog.error(FindIRCommandInteractor.TAG, new OAuthToken().getOAuthToken(), "releaseIR", new Exception("code:" + str + ", message:" + str2));
                FindIRCommandInteractor.this.listener.onRelease(false);
            }
        });
    }

    public void releaseCHIR(final IRCommand iRCommand, final String str) {
        RestSwitcherAPIStore.requestPostRelease(iRCommand.getId(), new HttpResponseHandler() { // from class: kr.switcher.switcherm.ui.main.interactors.FindIRCommandInteractor.4
            @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
            public void onFailure(String str2, String str3) {
            }

            @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
            public void onSuccess(HttpAPIResponse httpAPIResponse) {
                FindIRCommandInteractor.this.listener.onCHRelease(true, iRCommand.getName(), str);
            }
        });
    }

    public void removeIR(final String str) {
        RestSwitcherAPIStore.requestDeleteIRCommand(str, new HttpResponseHandler() { // from class: kr.switcher.switcherm.ui.main.interactors.FindIRCommandInteractor.5
            @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
            public void onSuccess(HttpAPIResponse httpAPIResponse) {
                FindIRCommandInteractor.this.listener.onRemove(true, str);
            }

            @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
            public void onFailure(String str2, String str3) {
                IOLog.error(FindIRCommandInteractor.TAG, new OAuthToken().getOAuthToken(), "removeIR", new Exception("code:" + str2 + ", message:" + str3));
                FindIRCommandInteractor.this.listener.onRemove(false, str);
            }
        });
    }
}
