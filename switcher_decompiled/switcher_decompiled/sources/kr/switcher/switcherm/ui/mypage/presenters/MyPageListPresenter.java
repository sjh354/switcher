package kr.switcher.switcherm.ui.mypage.presenters;

import java.util.List;
import kr.switcher.switcherm.preference.AutoBluetoothPreference;
import kr.switcher.switcherm.ui.mypage.MyPageItem;
import kr.switcher.switcherm.ui.mypage.adapter.MySwitcherAdapter;
import kr.switcher.switcherm.ui.mypage.helper.SubscriptionsMeItem;
import kr.switcher.switcherm.ui.mypage.interactor.CreateSubscriptionsInteractor;
import kr.switcher.switcherm.ui.mypage.interactor.DeleteMySubscriptionsInteractor;
import kr.switcher.switcherm.ui.mypage.interactor.FindMySubscriptionsInteractor;
import kr.switcher.switcherm.ui.mypage.interactor.FindMySwitcherInteractor;
import kr.switcher.switcherm.ui.mypage.interactor.GetMyWalletInteractor;
import kr.switcher.switcherm.ui.mypage.views.MyPageListView;
import kr.switcher.switcherm.user.User;

/* JADX INFO: loaded from: classes2.dex */
public class MyPageListPresenter implements FindMySwitcherInteractor.OnFindMyPageItemsListener, MySwitcherAdapter.OnItemClickListener, GetMyWalletInteractor.OnGetMyWalletListener {
    private CreateSubscriptionsInteractor createSubInteractor;
    private DeleteMySubscriptionsInteractor deleteSubsInteractor;
    private FindMySwitcherInteractor interactor;
    private GetMyWalletInteractor ioCashInteractor;
    private FindMySubscriptionsInteractor subInteractor;
    private MyPageListView view;

    public void onDeleteSubSuccess() {
    }

    public MyPageListPresenter(MyPageListView myPageListView, FindMySwitcherInteractor findMySwitcherInteractor, GetMyWalletInteractor getMyWalletInteractor, FindMySubscriptionsInteractor findMySubscriptionsInteractor, DeleteMySubscriptionsInteractor deleteMySubscriptionsInteractor, CreateSubscriptionsInteractor createSubscriptionsInteractor) {
        this.view = myPageListView;
        this.interactor = findMySwitcherInteractor;
        this.ioCashInteractor = getMyWalletInteractor;
        this.subInteractor = findMySubscriptionsInteractor;
        this.deleteSubsInteractor = deleteMySubscriptionsInteractor;
        this.createSubInteractor = createSubscriptionsInteractor;
    }

    public void onResume(User user) {
        this.view.setUserName(user.getUserName());
        this.view.initRecyclerListView();
        this.interactor.findMyMyPageItems(this);
        this.ioCashInteractor.getMyIOCash(this);
        this.subInteractor.getSubscriptionsMe();
        if (new AutoBluetoothPreference().getAutoBluetooth().booleanValue()) {
            this.view.checkAutoBluetooth();
        } else {
            this.view.uncheckAutoBluetooth();
        }
    }

    @Override // kr.switcher.switcherm.ui.mypage.interactor.FindMySwitcherInteractor.OnFindMyPageItemsListener
    public void onFindMyPageItems(List<MyPageItem> list) {
        this.view.setMyPageItems(list);
        this.view.refresh();
    }

    @Override // kr.switcher.switcherm.ui.mypage.adapter.MySwitcherAdapter.OnItemClickListener
    public void onItemClickToConnect(int i) {
        this.view.moveSwitcherInfoActivity(i);
    }

    @Override // kr.switcher.switcherm.ui.mypage.interactor.GetMyWalletInteractor.OnGetMyWalletListener
    public void onGetMyWallet(MyPageItem myPageItem) {
        this.view.setIOCash(myPageItem.getIoCash());
        this.view.refresh();
    }

    public void onAuthBluetoothButtonClicked(boolean z) {
        new AutoBluetoothPreference().setAutoBluetooth(Boolean.valueOf(z));
    }

    public void onFindMySubscriptionSuccess(SubscriptionsMeItem subscriptionsMeItem) {
        this.view.setSub(subscriptionsMeItem);
    }

    public void onInfoSubButtonClicked(boolean z, SubscriptionsMeItem subscriptionsMeItem) {
        if (z) {
            this.createSubInteractor.postSubscriptionsMe("info");
        } else {
            if (z) {
                return;
            }
            this.deleteSubsInteractor.deleteSubscriptionsMe(subscriptionsMeItem.getInfoId());
        }
    }

    public void onMarketingSubButtonClicked(boolean z, SubscriptionsMeItem subscriptionsMeItem) {
        if (z) {
            this.createSubInteractor.postSubscriptionsMe("marketing");
        } else {
            if (z) {
                return;
            }
            this.deleteSubsInteractor.deleteSubscriptionsMe(subscriptionsMeItem.getMarkettingId());
        }
    }
}
