package kr.switcher.switcherm.ui.setting.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kr.switcher.device.switcher.Switcher;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.listview.IOItemAnimator;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.device.switcher.handler.SwitcherHandler;
import kr.switcher.switcherm.preference.OAuthToken;
import kr.switcher.switcherm.signal.ReservationSignal;
import kr.switcher.switcherm.ui.dialog.ConfirmCallback;
import kr.switcher.switcherm.ui.dialog.IODialogController;
import kr.switcher.switcherm.ui.setting.SettingActivity;
import kr.switcher.switcherm.ui.setting.adapter.ReservationAdapter;
import kr.switcher.switcherm.ui.setting.adapter.ReservationItem;
import kr.switcher.switcherm.ui.setting.interactor.ReservationInteractor;
import kr.switcher.switcherm.ui.setting.presenter.ReservationListPresenter;
import kr.switcher.switcherm.ui.setting.view.ReservationListView;
import kr.switcher.switcherm.user.UserStateManager;

/* JADX INFO: loaded from: classes2.dex */
public class ReservationListFragment extends Fragment implements ReservationListView, ReservationAdapter.OnItemClickListener, SwipeRefreshLayout.OnRefreshListener {
    private static final String TAG = "ReservationListFragment";
    private static SettingActivity.MovedFragmentListener movedFragmentListener;
    private static SettingActivity.TimerSizeListener timerSizeListener;
    private ReservationAdapter adapter;
    private ArrayList<ReservationItem> arrayList;
    private ReservationListPresenter presenter;

    @BindView(R.id.rl_can_not_load)
    RelativeLayout rl_can_not_load;

    @BindView(R.id.rl_empty)
    RelativeLayout rl_empty;

    @BindView(R.id.rv_timer_list)
    RecyclerView rv_timer_list;

    @BindView(R.id.sr_timer_list)
    SwipeRefreshLayout sr_timer_list;
    private Switcher switcher;

    public static ReservationListFragment newInstance(String str, SettingActivity.MovedFragmentListener movedFragmentListener2, SettingActivity.TimerSizeListener timerSizeListener2) {
        ReservationListFragment reservationListFragment = new ReservationListFragment();
        Bundle bundle = new Bundle();
        bundle.putString("CONNECTED_MAC_ADDRESS", str);
        reservationListFragment.setArguments(bundle);
        movedFragmentListener = movedFragmentListener2;
        timerSizeListener = timerSizeListener2;
        return reservationListFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ReservationListPresenter reservationListPresenter = new ReservationListPresenter(this, new ReservationInteractor());
        this.presenter = reservationListPresenter;
        reservationListPresenter.signal();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String string;
        View viewInflate = layoutInflater.inflate(R.layout.fragment_reservation_list, viewGroup, false);
        ButterKnife.bind(this, viewInflate);
        if (UserStateManager.getInstance().getCurrentUserFromDB() == null) {
            IOUtil.showToast(IOUtil.getStringResource(R.string.not_found_user));
            getActivity().finish();
            return null;
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            string = arguments.getString("CONNECTED_MAC_ADDRESS");
            if (string == null) {
                return null;
            }
        } else {
            string = "";
        }
        Switcher switcher = SwitcherHandler.getInstance().getSwitcher(string);
        this.switcher = switcher;
        if (switcher != null) {
            return viewInflate;
        }
        IOUtil.showToast(IOUtil.getStringResource(R.string.not_found_switcher));
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.presenter.onResume(this.switcher);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.presenter.onPause(this.switcher.getMacAddress(), this.switcher.sResrvs);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.ReservationListView
    public void signal() {
        ReservationSignal.setTimerSize(SwitcherHandler.getInstance().getAllSwitcherReservationSize());
        ReservationSignal.setOnOccurredSignalListener(new ReservationSignal.OnOccurredTimerSignalListener() { // from class: kr.switcher.switcherm.ui.setting.fragment.ReservationListFragment.1
            @Override // kr.switcher.switcherm.signal.ReservationSignal.OnOccurredTimerSignalListener
            public void onOccurredSignal() {
                IODialogController.showSignalDialog3(ReservationListFragment.this.getContext(), new ConfirmCallback() { // from class: kr.switcher.switcherm.ui.setting.fragment.ReservationListFragment.1.1
                    @Override // kr.switcher.switcherm.ui.dialog.ConfirmCallback
                    public void onConfirmResult(boolean z) {
                        if (z) {
                            ReservationListFragment.movedFragmentListener.onFragmentMoved(null);
                        }
                    }
                });
            }
        });
        ReservationSignal.screen();
        ReservationSignal.abort();
    }

    @Override // kr.switcher.switcherm.ui.setting.view.ReservationListView
    public void initRecyclerListView() {
        this.arrayList = new ArrayList<>();
        this.adapter = new ReservationAdapter(this.arrayList, this);
        this.sr_timer_list.setOnRefreshListener(this);
        this.rv_timer_list.setLayoutManager(new LinearLayoutManager(getContext()));
        this.rv_timer_list.setItemAnimator(new IOItemAnimator());
        this.rv_timer_list.setAdapter(this.adapter);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.ReservationListView
    public void setReservations(List<Switcher.SwitcherReservation> list) {
        this.adapter.clear();
        Iterator<Switcher.SwitcherReservation> it = list.iterator();
        while (it.hasNext()) {
            this.adapter.addItem(new ReservationItem(this.switcher.getMacAddress(), it.next()));
        }
        this.adapter.notifyDataSetChanged();
    }

    @Override // kr.switcher.switcherm.ui.setting.view.ReservationListView
    public void showProgressbar() {
        this.sr_timer_list.setRefreshing(true);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.ReservationListView
    public void timeoutLoading() {
        new Handler().postDelayed(new Runnable() { // from class: kr.switcher.switcherm.ui.setting.fragment.ReservationListFragment.2
            @Override // java.lang.Runnable
            public void run() {
                ReservationListFragment.this.presenter.timeout(ReservationListFragment.this.sr_timer_list.isRefreshing());
            }
        }, 10000L);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.ReservationListView
    public void disableProgressbar() {
        this.sr_timer_list.setRefreshing(false);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.ReservationListView
    public void onReservationSize(int i) {
        timerSizeListener.onReservationSize(i);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.ReservationListView
    public void addReservationItems(List<Switcher.SwitcherReservation> list) {
        this.presenter.addReservationItems(this.switcher, list);
        setReservations(this.switcher.getSwitcherReservationList());
        this.presenter.showReservationListView(this.arrayList.size());
    }

    @Override // kr.switcher.switcherm.ui.setting.view.ReservationListView
    public void requestGetReservationList(Switcher switcher) {
        switcher.readReservation(this.presenter);
    }

    @Override // kr.switcher.switcherm.ui.setting.adapter.ReservationAdapter.OnItemClickListener
    public void onShowProgressbar() {
        showProgressbar();
    }

    @Override // kr.switcher.switcherm.ui.setting.adapter.ReservationAdapter.OnItemClickListener
    public void onItemClick(int i) {
        this.presenter.onItemClick(this.sr_timer_list.isRefreshing(), i);
    }

    @Override // kr.switcher.switcherm.ui.setting.adapter.ReservationAdapter.OnItemClickListener
    public void onRemoveItemClick(int i) {
        this.adapter.removeItem(i);
        this.presenter.showReservationListView(this.arrayList.size());
    }

    @Override // kr.switcher.switcherm.ui.setting.view.ReservationListView
    public void moveReservationFragment(int i) {
        FragmentTransaction fragmentTransactionBeginTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        ReservationFragment reservationFragmentNewInstance = ReservationFragment.newInstance(this.switcher.getMacAddress(), this.adapter.getItem(i).getSwitcherReservation());
        fragmentTransactionBeginTransaction.replace(R.id.container, reservationFragmentNewInstance, "ReservationFragment");
        try {
            fragmentTransactionBeginTransaction.commit();
        } catch (Exception e) {
            IOLog.error(TAG, new OAuthToken().getOAuthToken(), "moveReservationFragment", e);
        }
        movedFragmentListener.onFragmentMoved(reservationFragmentNewInstance);
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
    public void onRefresh() {
        this.presenter.onRefresh(this.switcher);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.ReservationListView
    public void showEmpty() {
        this.rl_empty.setVisibility(0);
        this.rl_can_not_load.setVisibility(8);
        IOLog.activity(IOUtil.getStringResource(R.string.screen_title_2_3_1_1));
    }

    @Override // kr.switcher.switcherm.ui.setting.view.ReservationListView
    public void showReservationList() {
        this.rl_empty.setVisibility(8);
        this.rl_can_not_load.setVisibility(8);
        IOLog.activity(IOUtil.getStringResource(R.string.screen_title_2_3_1_2));
    }

    @Override // kr.switcher.switcherm.ui.setting.view.ReservationListView
    public void showCanNotLoaded() {
        this.rl_empty.setVisibility(8);
        this.rl_can_not_load.setVisibility(0);
        IOLog.activity(IOUtil.getStringResource(R.string.screen_title_2_3_1_1_1));
    }
}
