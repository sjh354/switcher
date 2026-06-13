package kr.switcher.switcherm.ui.mypage.views;

import java.util.List;
import kr.switcher.switcherm.ui.mypage.MyPageItem;
import kr.switcher.switcherm.ui.mypage.helper.SubscriptionsMeItem;

/* JADX INFO: loaded from: classes2.dex */
public interface MyPageListView {
    void checkAutoBluetooth();

    void initRecyclerListView();

    void moveSwitcherInfoActivity(int i);

    void refresh();

    void setIOCash(String str);

    void setMyPageItems(List<MyPageItem> list);

    void setSub(SubscriptionsMeItem subscriptionsMeItem);

    void setUserName(String str);

    void showChangeInfoToast();

    void showChangeMarketingToast();

    void showMessage(String str);

    void uncheckAutoBluetooth();
}
