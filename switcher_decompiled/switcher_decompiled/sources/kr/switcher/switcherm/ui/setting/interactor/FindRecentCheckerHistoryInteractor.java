package kr.switcher.switcherm.ui.setting.interactor;

import java.util.List;
import kr.switcher.device.checker.Checker;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.device.IODeviceMapper;
import kr.switcher.switcherm.network.http.RestSwitcherAPIStore;
import kr.switcher.switcherm.network.http.response.CheckerHistoriesAPIResponse;
import kr.switcher.switcherm.network.http.response.HttpAPIResponse;
import kr.switcher.switcherm.network.http.response.HttpResponseHandler;
import kr.switcher.switcherm.preference.OAuthToken;
import kr.switcher.switcherm.ui.setting.adapter.CheckerHistoryItem;

/* JADX INFO: loaded from: classes2.dex */
public class FindRecentCheckerHistoryInteractor {
    private static final String TAG = "FindRecentCheckerHistoryInteractor";
    private OnFindRecentCheckerHistoryListener listener;
    private String nextPageURL = null;

    public interface OnFindRecentCheckerHistoryListener {
        void onFindHistories(List<CheckerHistoryItem> list);

        void onFindNextPageHistories(List<CheckerHistoryItem> list);
    }

    public FindRecentCheckerHistoryInteractor(OnFindRecentCheckerHistoryListener onFindRecentCheckerHistoryListener) {
        this.listener = onFindRecentCheckerHistoryListener;
    }

    public FindRecentCheckerHistoryInteractor() {
    }

    public void findNextPageHistory() {
        String str = this.nextPageURL;
        if (str != null) {
            RestSwitcherAPIStore.requestGetNextPageHistory(getInfoFromNextURL(parseNextPageURL(str)), new HttpResponseHandler() { // from class: kr.switcher.switcherm.ui.setting.interactor.FindRecentCheckerHistoryInteractor.1
                @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
                public void onSuccess(HttpAPIResponse httpAPIResponse) {
                    CheckerHistoriesAPIResponse checkerHistoriesAPIResponse = (CheckerHistoriesAPIResponse) httpAPIResponse;
                    FindRecentCheckerHistoryInteractor.this.nextPageURL = checkerHistoriesAPIResponse.next;
                    FindRecentCheckerHistoryInteractor.this.listener.onFindNextPageHistories(IODeviceMapper.parseGetCheckerHistories(checkerHistoriesAPIResponse));
                }

                @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
                public void onFailure(String str2, String str3) {
                    IOLog.error(FindRecentCheckerHistoryInteractor.TAG, new OAuthToken().getOAuthToken(), "findNextPageCheckerHistory", new Exception("code:" + str2 + ", message:" + str3));
                }
            });
        }
    }

    public void findRecentCheckerHistory(Checker checker, int i) {
        RestSwitcherAPIStore.requestGetHistory(checker.getMacAddress(), i, new HttpResponseHandler() { // from class: kr.switcher.switcherm.ui.setting.interactor.FindRecentCheckerHistoryInteractor.2
            @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
            public void onSuccess(HttpAPIResponse httpAPIResponse) {
                CheckerHistoriesAPIResponse checkerHistoriesAPIResponse = (CheckerHistoriesAPIResponse) httpAPIResponse;
                List<CheckerHistoryItem> getCheckerHistories = IODeviceMapper.parseGetCheckerHistories(checkerHistoriesAPIResponse);
                FindRecentCheckerHistoryInteractor.this.nextPageURL = checkerHistoriesAPIResponse.next;
                FindRecentCheckerHistoryInteractor.this.listener.onFindHistories(getCheckerHistories);
            }

            @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
            public void onFailure(String str, String str2) {
                IOLog.error(FindRecentCheckerHistoryInteractor.TAG, new OAuthToken().getOAuthToken(), "findRecentCheckerHistory", new Exception("code:" + str + ", message:" + str2));
            }
        });
    }

    public void findRecentCheckerHistoryForWidget(String str, final OnFindRecentCheckerHistoryListener onFindRecentCheckerHistoryListener) {
        RestSwitcherAPIStore.requestGetHistory(str, 10, new HttpResponseHandler() { // from class: kr.switcher.switcherm.ui.setting.interactor.FindRecentCheckerHistoryInteractor.3
            @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
            public void onSuccess(HttpAPIResponse httpAPIResponse) {
                onFindRecentCheckerHistoryListener.onFindHistories(IODeviceMapper.parseGetCheckerHistories((CheckerHistoriesAPIResponse) httpAPIResponse));
            }

            @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
            public void onFailure(String str2, String str3) {
                IOLog.error(FindRecentCheckerHistoryInteractor.TAG, new OAuthToken().getOAuthToken(), "findRecentCheckerHistory", new Exception("code:" + str2 + ", message:" + str3));
            }
        });
    }

    public String parseNextPageURL(String str) {
        return str.substring(str.indexOf("checkers"));
    }

    public CheckerURLinfo getInfoFromNextURL(String str) {
        CheckerURLinfo checkerURLinfo = new CheckerURLinfo();
        String[] strArrSplit = str.split("/");
        checkerURLinfo.setMacAddress(strArrSplit[2]);
        checkerURLinfo.setDays(strArrSplit[5]);
        checkerURLinfo.setPage(strArrSplit[6].split("=")[1]);
        return checkerURLinfo;
    }

    public class CheckerURLinfo {
        public String days;
        public String macAddress;
        public String page;

        public CheckerURLinfo() {
        }

        public void setMacAddress(String str) {
            this.macAddress = str;
        }

        public void setDays(String str) {
            this.days = str;
        }

        public void setPage(String str) {
            this.page = str;
        }

        public String getMacAddress() {
            return this.macAddress;
        }

        public String getDays() {
            return this.days;
        }

        public String getPage() {
            return this.page;
        }
    }
}
