package kr.switcher.switcherm.ui.mypage.interactor;

import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.network.http.RestSwitcherAPIStore;
import kr.switcher.switcherm.network.http.response.HttpAPIResponse;
import kr.switcher.switcherm.network.http.response.HttpResponseHandler;
import kr.switcher.switcherm.network.http.response.WalletsMeAPIResponse;
import kr.switcher.switcherm.preference.OAuthToken;
import kr.switcher.switcherm.ui.mypage.MyPageItem;

/* JADX INFO: loaded from: classes2.dex */
public class GetMyWalletInteractor {
    private static final String TAG = "GetMyWalletInteractor";

    public interface OnGetMyWalletListener {
        void onGetMyWallet(MyPageItem myPageItem);
    }

    public void getMyIOCash(final OnGetMyWalletListener onGetMyWalletListener) {
        RestSwitcherAPIStore.requestGetWalletsMe(new HttpResponseHandler() { // from class: kr.switcher.switcherm.ui.mypage.interactor.GetMyWalletInteractor.1
            @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
            public void onSuccess(HttpAPIResponse httpAPIResponse) {
                MyPageItem myPageItem = new MyPageItem();
                WalletsMeAPIResponse walletsMeAPIResponse = (WalletsMeAPIResponse) httpAPIResponse;
                if (walletsMeAPIResponse == null) {
                    myPageItem.setIoCash("-");
                } else {
                    myPageItem.setIoCash(walletsMeAPIResponse.cash);
                }
                onGetMyWalletListener.onGetMyWallet(myPageItem);
            }

            @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
            public void onFailure(String str, String str2) {
                IOLog.error(GetMyWalletInteractor.TAG, new OAuthToken().getOAuthToken(), "requestGetMyWalletsMe()", new Exception("code:" + str + ", message:" + str2));
            }
        });
    }
}
