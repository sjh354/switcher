package kr.switcher.switcherm.ui.mypage.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import java.util.ArrayList;
import java.util.List;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.ui.dialog.IODialogController;
import kr.switcher.switcherm.ui.mypage.MyPageItem;
import kr.switcher.switcherm.ui.mypage.adapter.MySwitcherAdapter;
import kr.switcher.switcherm.ui.mypage.helper.SubscriptionsMeItem;
import kr.switcher.switcherm.ui.mypage.interactor.CreateSubscriptionsInteractor;
import kr.switcher.switcherm.ui.mypage.interactor.DeleteMySubscriptionsInteractor;
import kr.switcher.switcherm.ui.mypage.interactor.FindMySubscriptionsInteractor;
import kr.switcher.switcherm.ui.mypage.interactor.FindMySwitcherInteractor;
import kr.switcher.switcherm.ui.mypage.interactor.GetMyWalletInteractor;
import kr.switcher.switcherm.ui.mypage.presenters.MyPageListPresenter;
import kr.switcher.switcherm.ui.mypage.views.MyPageListView;
import kr.switcher.switcherm.ui.switcherInfo.SwitcherInfoActivity;
import kr.switcher.switcherm.user.User;
import kr.switcher.switcherm.user.UserStateManager;

/* JADX INFO: loaded from: classes2.dex */
public class MypageListFragment extends Fragment implements MyPageListView, FindMySubscriptionsInteractor.OnFindMySubscriptionListener, DeleteMySubscriptionsInteractor.OnDeleteMySubscriptionListener, CreateSubscriptionsInteractor.OnCreateSubscriptionListener {
    private static final String TAG = "MypageListFragment";
    private MySwitcherAdapter adapter;

    @BindView(R.id.cb_auto_bluetooth)
    CheckBox cb_auto_bluetooth;

    @BindView(R.id.cb_subscription_info)
    CheckBox cb_subscription_info;

    @BindView(R.id.cb_subscription_marketing)
    CheckBox cb_subscription_marketing;

    @BindView(R.id.et_room_name)
    TextView et_room_name;
    private SubscriptionsMeItem item;
    private MyPageListPresenter presenter;

    @BindView(R.id.rv_my_switcher_list)
    RecyclerView rv_my_switcher_list;
    private ArrayList<MyPageItem> switcherItems;

    @BindView(R.id.tv_auto_bluetooth)
    TextView tv_auto_bluetooth;

    @BindView(R.id.tv_io_cash)
    TextView tv_io_cash;

    @Override // kr.switcher.switcherm.ui.mypage.interactor.CreateSubscriptionsInteractor.OnCreateSubscriptionListener
    public void onCreateSubSuccess(String str) {
    }

    public static MypageListFragment newInstance() {
        MypageListFragment mypageListFragment = new MypageListFragment();
        mypageListFragment.setArguments(new Bundle());
        return mypageListFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_mypage_list, viewGroup, false);
        ButterKnife.bind(this, viewInflate);
        this.presenter = new MyPageListPresenter(this, new FindMySwitcherInteractor(), new GetMyWalletInteractor(), new FindMySubscriptionsInteractor(this), new DeleteMySubscriptionsInteractor(this), new CreateSubscriptionsInteractor(this));
        this.tv_auto_bluetooth.setText(Html.fromHtml("<u>블루투스 자동 켜기</u> "));
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        User currentUserFromDB = UserStateManager.getInstance().getCurrentUserFromDB();
        if (currentUserFromDB == null) {
            IOUtil.showToast(IOUtil.getStringResource(R.string.not_found_user));
            getActivity().finish();
        } else {
            this.presenter.onResume(currentUserFromDB);
        }
    }

    @Override // kr.switcher.switcherm.ui.mypage.views.MyPageListView
    public void initRecyclerListView() {
        this.switcherItems = new ArrayList<>();
        this.adapter = new MySwitcherAdapter(this.switcherItems, this.presenter);
        this.rv_my_switcher_list.setLayoutManager(new LinearLayoutManager(getContext()));
        this.rv_my_switcher_list.setAdapter(this.adapter);
    }

    @Override // kr.switcher.switcherm.ui.mypage.views.MyPageListView
    public void setMyPageItems(List<MyPageItem> list) {
        this.switcherItems.addAll(list);
    }

    @Override // kr.switcher.switcherm.ui.mypage.views.MyPageListView
    public void refresh() {
        IOUtil.setListViewSize(this.rv_my_switcher_list, R.dimen.my_switcher_list_item_height, this.switcherItems.size());
        this.adapter.notifyDataSetChanged();
    }

    @Override // kr.switcher.switcherm.ui.mypage.views.MyPageListView
    public void moveSwitcherInfoActivity(int i) {
        Intent intent = new Intent(getContext(), (Class<?>) SwitcherInfoActivity.class);
        intent.putExtra("CONNECTED_MAC_ADDRESS", this.switcherItems.get(i).getMacAddress());
        startActivity(intent);
    }

    @Override // kr.switcher.switcherm.ui.mypage.views.MyPageListView
    public void checkAutoBluetooth() {
        this.cb_auto_bluetooth.setChecked(true);
    }

    @Override // kr.switcher.switcherm.ui.mypage.views.MyPageListView
    public void uncheckAutoBluetooth() {
        this.cb_auto_bluetooth.setChecked(false);
    }

    @Override // kr.switcher.switcherm.ui.mypage.views.MyPageListView
    public void showMessage(String str) {
        IOUtil.showToast(str);
    }

    @Override // kr.switcher.switcherm.ui.mypage.views.MyPageListView
    public void setSub(SubscriptionsMeItem subscriptionsMeItem) {
        this.cb_subscription_marketing.setChecked(subscriptionsMeItem.getMarketing().booleanValue());
        this.cb_subscription_info.setChecked(subscriptionsMeItem.getInfo().booleanValue());
    }

    @Override // kr.switcher.switcherm.ui.mypage.views.MyPageListView
    public void showChangeMarketingToast() {
        IOUtil.showToast("마케팅 알림 수신 동의 정보가 변경 되었습니다.");
    }

    @Override // kr.switcher.switcherm.ui.mypage.views.MyPageListView
    public void showChangeInfoToast() {
        IOUtil.showToast("알림 수신 동의 정보가 변경 되었습니다.");
    }

    @Override // kr.switcher.switcherm.ui.mypage.views.MyPageListView
    public void setUserName(String str) {
        this.et_room_name.setText(str);
    }

    @Override // kr.switcher.switcherm.ui.mypage.views.MyPageListView
    public void setIOCash(String str) {
        this.tv_io_cash.setText(str);
    }

    @OnClick({R.id.cb_auto_bluetooth})
    public void onAuthBluetoothButtonClicked() {
        this.presenter.onAuthBluetoothButtonClicked(this.cb_auto_bluetooth.isChecked());
    }

    @OnClick({R.id.cb_subscription_info})
    public void onInfoSubButtonClicked() {
        this.presenter.onInfoSubButtonClicked(this.cb_subscription_info.isChecked(), this.item);
    }

    @OnClick({R.id.cb_subscription_marketing})
    public void onMarketingSubButtonClicked() {
        this.presenter.onMarketingSubButtonClicked(this.cb_subscription_marketing.isChecked(), this.item);
    }

    @OnClick({R.id.tv_auto_bluetooth})
    public void onAutoBluetoothTextClicked() {
        IODialogController.showConfirmDialog(getContext(), "앱을 실행하면 자동으로 블루투스를 활성화 시키는 기능입니다", null);
    }

    @Override // kr.switcher.switcherm.ui.mypage.interactor.FindMySubscriptionsInteractor.OnFindMySubscriptionListener
    public void onFindMySubscriptionSuccess(SubscriptionsMeItem subscriptionsMeItem) {
        this.item = subscriptionsMeItem;
        this.presenter.onFindMySubscriptionSuccess(subscriptionsMeItem);
    }

    @Override // kr.switcher.switcherm.ui.mypage.interactor.DeleteMySubscriptionsInteractor.OnDeleteMySubscriptionListener
    public void onDeleteSubSuccess() {
        this.presenter.onDeleteSubSuccess();
    }
}
