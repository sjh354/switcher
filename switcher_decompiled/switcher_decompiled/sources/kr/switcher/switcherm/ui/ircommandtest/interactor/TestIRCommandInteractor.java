package kr.switcher.switcherm.ui.ircommandtest.interactor;

import kr.switcher.device.remocon.IRCommand;
import kr.switcher.device.remocon.Remocon;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.device.IODeviceMapper;
import kr.switcher.switcherm.network.http.RestSwitcherAPIStore;
import kr.switcher.switcherm.network.http.response.CreateIRDBTestAPIResponse;
import kr.switcher.switcherm.network.http.response.HttpAPIResponse;
import kr.switcher.switcherm.network.http.response.HttpResponseHandler;
import kr.switcher.switcherm.preference.OAuthToken;

/* JADX INFO: loaded from: classes2.dex */
public class TestIRCommandInteractor {
    private static final String TAG = "TestIRCommandInteractor";
    private OnConfirmIRCommandListener confirmListener;
    private OnDeleteIRCommandListener deleteListener;
    private OnMatchingIRCommandListener matchingListener;
    private OnTestIRCommandListener testListener;

    public interface OnConfirmIRCommandListener {
        void onConfirmSuccess();

        void onError(String str);
    }

    public interface OnDeleteIRCommandListener {
        void onDeleteSuccess();

        void onError(String str);
    }

    public interface OnMatchingIRCommandListener {
        void onError(String str);

        void onMatchingSuccess();
    }

    public interface OnTestIRCommandListener {
        void onError(String str);

        void onTestIRCommand(IRCommand iRCommand);
    }

    public TestIRCommandInteractor(OnTestIRCommandListener onTestIRCommandListener, OnMatchingIRCommandListener onMatchingIRCommandListener, OnConfirmIRCommandListener onConfirmIRCommandListener, OnDeleteIRCommandListener onDeleteIRCommandListener) {
        this.testListener = onTestIRCommandListener;
        this.matchingListener = onMatchingIRCommandListener;
        this.confirmListener = onConfirmIRCommandListener;
        this.deleteListener = onDeleteIRCommandListener;
    }

    public void matchingIRCommand(Remocon remocon, IRCommand iRCommand) {
        RestSwitcherAPIStore.putModifyIRInfo(iRCommand.getId(), "appliance", remocon.getId(), new HttpResponseHandler() { // from class: kr.switcher.switcherm.ui.ircommandtest.interactor.TestIRCommandInteractor.1
            @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
            public void onSuccess(HttpAPIResponse httpAPIResponse) {
                TestIRCommandInteractor.this.matchingListener.onMatchingSuccess();
            }

            @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
            public void onFailure(String str, String str2) {
                IOLog.error(TestIRCommandInteractor.TAG, new OAuthToken().getOAuthToken(), "putModifyIRInfo", new Exception("code:" + str + ", message:" + str2));
                TestIRCommandInteractor.this.matchingListener.onError(str2);
            }
        });
    }

    public void testIRCommand(String str) {
        RestSwitcherAPIStore.requestPostIRDBTest(str, new HttpResponseHandler() { // from class: kr.switcher.switcherm.ui.ircommandtest.interactor.TestIRCommandInteractor.2
            @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
            public void onSuccess(HttpAPIResponse httpAPIResponse) {
                TestIRCommandInteractor.this.testListener.onTestIRCommand(IODeviceMapper.parseGetIRCommandFromTest((CreateIRDBTestAPIResponse) httpAPIResponse));
            }

            @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
            public void onFailure(String str2, String str3) {
                IOLog.error(TestIRCommandInteractor.TAG, new OAuthToken().getOAuthToken(), "requestPostIRDBTest", new Exception("code:" + str2 + ", message:" + str3));
                TestIRCommandInteractor.this.testListener.onError(str3);
            }
        });
    }

    public void onConfirmIRCommand(String str) {
        RestSwitcherAPIStore.requestPostIRDBConfirm(str, new HttpResponseHandler() { // from class: kr.switcher.switcherm.ui.ircommandtest.interactor.TestIRCommandInteractor.3
            @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
            public void onSuccess(HttpAPIResponse httpAPIResponse) {
                TestIRCommandInteractor.this.confirmListener.onConfirmSuccess();
            }

            @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
            public void onFailure(String str2, String str3) {
                IOLog.error(TestIRCommandInteractor.TAG, new OAuthToken().getOAuthToken(), "repuestPostIRDBConfirm", new Exception("code:" + str2 + ", message:" + str3));
                TestIRCommandInteractor.this.confirmListener.onError(str3);
            }
        });
    }

    public void onDeleteIRCommand(IRCommand iRCommand) {
        RestSwitcherAPIStore.requestDeleteIRCommand(iRCommand.getId(), new HttpResponseHandler() { // from class: kr.switcher.switcherm.ui.ircommandtest.interactor.TestIRCommandInteractor.4
            @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
            public void onSuccess(HttpAPIResponse httpAPIResponse) {
                TestIRCommandInteractor.this.deleteListener.onDeleteSuccess();
            }

            @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
            public void onFailure(String str, String str2) {
                IOLog.error(TestIRCommandInteractor.TAG, new OAuthToken().getOAuthToken(), "repuestDeleteIRCommand", new Exception("code:" + str + ", message:" + str2));
                TestIRCommandInteractor.this.deleteListener.onError(str2);
            }
        });
    }
}
