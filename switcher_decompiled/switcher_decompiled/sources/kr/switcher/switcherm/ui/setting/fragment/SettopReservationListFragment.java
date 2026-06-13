package kr.switcher.switcherm.ui.setting.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kr.switcher.device.remocon.Remocon;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.listview.IOItemAnimator;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.device.IODeviceHandler;
import kr.switcher.switcherm.preference.OAuthToken;
import kr.switcher.switcherm.ui.setting.SettingActivity;
import kr.switcher.switcherm.ui.setting.adapter.AirconReservationItem;
import kr.switcher.switcherm.ui.setting.adapter.SettopReservationAdapter;
import kr.switcher.switcherm.ui.setting.interactor.AirconReservationListInteractor;
import kr.switcher.switcherm.ui.setting.interactor.DeleteReservationInteractor;
import kr.switcher.switcherm.ui.setting.interactor.SendReservationToServerInteractor;
import kr.switcher.switcherm.ui.setting.presenter.SettopReservationListPresenter;
import kr.switcher.switcherm.ui.setting.view.SettopReservationListView;

/* JADX INFO: loaded from: classes2.dex */
public class SettopReservationListFragment extends Fragment implements SettopReservationListView, SwipeRefreshLayout.OnRefreshListener, AirconReservationListInteractor.OnAirconReservationListListener, DeleteReservationInteractor.OnDeleteReservationListener, DeleteReservationInteractor.OnChangeReservationDataListener, SendReservationToServerInteractor.OnSendReservationToServerListener, SettopReservationAdapter.OnCheckedChangeListener, SettopReservationAdapter.OnItemClickListener {
    private static final String TAG = "SettopReservationListFragment";
    private static SettingActivity.MovedFragmentListener movedFragmentListener;
    private static SettingActivity.TimerSizeListener timerSizeListener;
    private SettopReservationAdapter adapter;
    private List<Remocon.RemoconReservation> arrayList;
    private Remocon connectedRemocon;

    @BindView(R.id.iv_empty_timer)
    ImageView iv_empty_timer;
    private SettopReservationListPresenter presenter;

    @BindView(R.id.rl_can_not_load)
    RelativeLayout rl_can_not_load;

    @BindView(R.id.rl_empty)
    RelativeLayout rl_empty;

    @BindView(R.id.rv_timer_list)
    RecyclerView rv_timer_list;

    @BindView(R.id.sr_timer_list)
    SwipeRefreshLayout sr_timer_list;

    @BindView(R.id.tv_empty)
    TextView tv_empty;

    @Override // kr.switcher.switcherm.ui.setting.interactor.DeleteReservationInteractor.OnChangeReservationDataListener
    public void onChangeReservationDataFailure(String str) {
    }

    @Override // kr.switcher.switcherm.ui.setting.interactor.DeleteReservationInteractor.OnDeleteReservationListener
    public void onDeleteReservationError(String str) {
    }

    @Override // kr.switcher.switcherm.ui.setting.view.SettopReservationListView
    public void onReservationSize(int i) {
    }

    @Override // kr.switcher.switcherm.ui.setting.interactor.SendReservationToServerInteractor.OnSendReservationToServerListener
    public void onSendReservationError(String str) {
    }

    @Override // kr.switcher.switcherm.ui.setting.interactor.SendReservationToServerInteractor.OnSendReservationToServerListener
    public void onSendReservationSuccess() {
    }

    @Override // kr.switcher.switcherm.ui.setting.view.SettopReservationListView
    public void showCanNotLoaded() {
    }

    @Override // kr.switcher.switcherm.ui.setting.view.SettopReservationListView
    public void showReservationList() {
    }

    public static SettopReservationListFragment newInstance(String str, SettingActivity.MovedFragmentListener movedFragmentListener2, SettingActivity.TimerSizeListener timerSizeListener2) {
        SettopReservationListFragment settopReservationListFragment = new SettopReservationListFragment();
        Bundle bundle = new Bundle();
        bundle.putString("CONNECTED_MAC_ADDRESS", str);
        settopReservationListFragment.setArguments(bundle);
        movedFragmentListener = movedFragmentListener2;
        timerSizeListener = timerSizeListener2;
        return settopReservationListFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String string;
        View viewInflate = layoutInflater.inflate(R.layout.fragment_reservation_list, viewGroup, false);
        ButterKnife.bind(this, viewInflate);
        Bundle arguments = getArguments();
        if (arguments != null) {
            string = arguments.getString("CONNECTED_MAC_ADDRESS");
            if (string == null) {
                return null;
            }
        } else {
            string = "";
        }
        Remocon remocon = (Remocon) IODeviceHandler.getInstance().getDevice(string);
        this.connectedRemocon = remocon;
        if (remocon == null) {
            IOUtil.showToast(IOUtil.getStringResource(R.string.not_found_device));
            return null;
        }
        SettopReservationListPresenter settopReservationListPresenter = new SettopReservationListPresenter(this, new AirconReservationListInteractor(this), new DeleteReservationInteractor(this, this), new SendReservationToServerInteractor(this));
        this.presenter = settopReservationListPresenter;
        settopReservationListPresenter.onCreateView();
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        this.presenter.onResume(this.connectedRemocon);
        super.onResume();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // kr.switcher.switcherm.ui.setting.view.SettopReservationListView
    public void initRecyclerListView() {
        ArrayList arrayList = new ArrayList();
        this.arrayList = arrayList;
        arrayList.clear();
        SettopReservationAdapter settopReservationAdapter = new SettopReservationAdapter(this.arrayList, this, this);
        this.adapter = settopReservationAdapter;
        settopReservationAdapter.clear();
        this.sr_timer_list.setOnRefreshListener(this);
        this.rv_timer_list.setLayoutManager(new LinearLayoutManager(getContext()));
        this.rv_timer_list.setItemAnimator(new IOItemAnimator());
        this.rv_timer_list.setAdapter(this.adapter);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.SettopReservationListView
    public void showProgressbar() {
        this.sr_timer_list.setRefreshing(true);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.SettopReservationListView
    public void disableProgressbar() {
        this.sr_timer_list.setRefreshing(false);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.SettopReservationListView
    public void timeoutLoading() {
        new Handler().postDelayed(new Runnable() { // from class: kr.switcher.switcherm.ui.setting.fragment.SettopReservationListFragment.1
            @Override // java.lang.Runnable
            public void run() {
                SettopReservationListFragment.this.presenter.timeout(SettopReservationListFragment.this.sr_timer_list.isRefreshing());
            }
        }, 1000L);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.SettopReservationListView
    public void showEmpty() {
        this.rl_empty.setVisibility(0);
        this.iv_empty_timer.setVisibility(8);
        this.tv_empty.setText(R.string.notice_empty_reservation);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.SettopReservationListView
    public void moveSettopReservationFragment(int i) {
        FragmentTransaction fragmentTransactionBeginTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        SettopReservationFragment settopReservationFragmentNewInstance = SettopReservationFragment.newInstance(this.connectedRemocon.getMacAddress(), this.adapter.getItem(i));
        fragmentTransactionBeginTransaction.replace(R.id.container, settopReservationFragmentNewInstance, "SettopReservationFragment");
        try {
            fragmentTransactionBeginTransaction.commit();
        } catch (Exception e) {
            IOLog.error(TAG, new OAuthToken().getOAuthToken(), "moveSettopReservationFragment", e);
        }
        movedFragmentListener.onFragmentMoved(settopReservationFragmentNewInstance);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.SettopReservationListView
    public void setRemoconReservations(List<Remocon.RemoconReservation> list) {
        this.adapter.clear();
        this.arrayList.clear();
        Iterator<Remocon.RemoconReservation> it = list.iterator();
        while (it.hasNext()) {
            this.arrayList.add(it.next());
        }
        this.adapter.notifyDataSetChanged();
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
    public void onRefresh() {
        this.presenter.onRefresh(this.connectedRemocon);
    }

    @Override // kr.switcher.switcherm.ui.setting.adapter.SettopReservationAdapter.OnItemClickListener
    public void onShowProgressbar() {
        showProgressbar();
        timeoutLoading();
    }

    @Override // kr.switcher.switcherm.ui.setting.adapter.SettopReservationAdapter.OnItemClickListener
    public void onItemClick(int i) {
        this.presenter.onItemClick(this.sr_timer_list.isRefreshing(), i);
    }

    @Override // kr.switcher.switcherm.ui.setting.adapter.SettopReservationAdapter.OnItemClickListener
    public void onRemoveItemClick(int i) {
        showDeleteDialog(i);
    }

    @Override // kr.switcher.switcherm.ui.setting.interactor.AirconReservationListInteractor.OnAirconReservationListListener
    public void onFindRemoconReservation(List<AirconReservationItem> list) {
        this.presenter.onFindRemoconReservation(list);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.SettopReservationListView
    public void convertRemoconReservationData(List<AirconReservationItem> list) {
        this.presenter.convertRemoconReservationData(list);
    }

    @Override // kr.switcher.switcherm.ui.setting.interactor.AirconReservationListInteractor.OnAirconReservationListListener
    public void onError(String str) {
        IOUtil.showToast(str);
    }

    @Override // kr.switcher.switcherm.ui.setting.interactor.DeleteReservationInteractor.OnDeleteReservationListener
    public void onDeleteReservationSuccess() {
        this.presenter.onResume(this.connectedRemocon);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.SettopReservationListView
    public void showDeleteDialog(final int i) {
        new MaterialDialog.Builder(getContext()).content("예약을 삭제 하시겠습니까?").positiveText("예").negativeText("아니오").negativeColor(R.color.periwinkle).positiveColor(R.color.periwinkle).onPositive(new MaterialDialog.SingleButtonCallback() { // from class: kr.switcher.switcherm.ui.setting.fragment.SettopReservationListFragment.3
            @Override // com.afollestad.materialdialogs.MaterialDialog.SingleButtonCallback
            public void onClick(MaterialDialog materialDialog, DialogAction dialogAction) {
                SettopReservationListFragment.this.presenter.removeReservation(SettopReservationListFragment.this.adapter.getItem(i));
                SettopReservationListFragment.this.showProgressbar();
                SettopReservationListFragment.this.timeoutLoading();
            }
        }).onNegative(new MaterialDialog.SingleButtonCallback() { // from class: kr.switcher.switcherm.ui.setting.fragment.SettopReservationListFragment.2
            @Override // com.afollestad.materialdialogs.MaterialDialog.SingleButtonCallback
            public void onClick(MaterialDialog materialDialog, DialogAction dialogAction) {
            }
        }).cancelable(false).show();
    }

    @Override // kr.switcher.switcherm.ui.setting.view.SettopReservationListView
    public void hideEmpty() {
        this.rl_empty.setVisibility(8);
    }

    @Override // kr.switcher.switcherm.ui.setting.adapter.SettopReservationAdapter.OnCheckedChangeListener
    public void onCheckedChange(int i, String str) {
        this.presenter.onCheckedChange(this.adapter.getItem(i), str);
    }

    @Override // kr.switcher.switcherm.ui.setting.interactor.DeleteReservationInteractor.OnChangeReservationDataListener
    public void onChangeReservationDataSuccess(Remocon.RemoconReservation remoconReservation, String str) {
        this.presenter.onChangeReservationDataSuccess(remoconReservation, this.connectedRemocon.getId(), str);
    }
}
