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
import kr.switcher.switcherm.ui.setting.adapter.AirconReservationAdapter;
import kr.switcher.switcherm.ui.setting.adapter.AirconReservationItem;
import kr.switcher.switcherm.ui.setting.interactor.AirconReservationListInteractor;
import kr.switcher.switcherm.ui.setting.interactor.DeleteReservationInteractor;
import kr.switcher.switcherm.ui.setting.interactor.SendReservationToServerInteractor;
import kr.switcher.switcherm.ui.setting.presenter.AirconReservationListPresenter;
import kr.switcher.switcherm.ui.setting.view.AirconReservationListView;

/* JADX INFO: loaded from: classes2.dex */
public class AirconReservationListFragment extends Fragment implements AirconReservationListView, SwipeRefreshLayout.OnRefreshListener, AirconReservationAdapter.OnItemClickListener, AirconReservationAdapter.OnCheckedChangeListener, AirconReservationListInteractor.OnAirconReservationListListener, DeleteReservationInteractor.OnDeleteReservationListener, DeleteReservationInteractor.OnChangeReservationDataListener, SendReservationToServerInteractor.OnSendReservationToServerListener {
    private static final String TAG = "AirconReservationListFragment";
    private static SettingActivity.MovedFragmentListener movedFragmentListener;
    private static SettingActivity.TimerSizeListener timerSizeListener;
    private AirconReservationAdapter adapter;
    private List<Remocon.RemoconReservation> arrayList;
    private Remocon connectedRemocon;
    private AirconReservationListPresenter presenter;

    @BindView(R.id.rl_can_not_load)
    RelativeLayout rl_can_not_load;

    @BindView(R.id.rl_empty)
    RelativeLayout rl_empty;

    @BindView(R.id.rv_timer_list)
    RecyclerView rv_timer_list;

    @BindView(R.id.sr_timer_list)
    SwipeRefreshLayout sr_timer_list;

    @Override // kr.switcher.switcherm.ui.setting.interactor.DeleteReservationInteractor.OnChangeReservationDataListener
    public void onChangeReservationDataFailure(String str) {
    }

    @Override // kr.switcher.switcherm.ui.setting.interactor.DeleteReservationInteractor.OnDeleteReservationListener
    public void onDeleteReservationError(String str) {
    }

    @Override // kr.switcher.switcherm.ui.setting.view.AirconReservationListView
    public void onReservationSize(int i) {
    }

    @Override // kr.switcher.switcherm.ui.setting.interactor.SendReservationToServerInteractor.OnSendReservationToServerListener
    public void onSendReservationError(String str) {
    }

    @Override // kr.switcher.switcherm.ui.setting.interactor.SendReservationToServerInteractor.OnSendReservationToServerListener
    public void onSendReservationSuccess() {
    }

    @Override // kr.switcher.switcherm.ui.setting.view.AirconReservationListView
    public void showCanNotLoaded() {
    }

    @Override // kr.switcher.switcherm.ui.setting.view.AirconReservationListView
    public void showEmpty() {
    }

    @Override // kr.switcher.switcherm.ui.setting.view.AirconReservationListView
    public void showReservationList() {
    }

    public static AirconReservationListFragment newInstance(String str, SettingActivity.MovedFragmentListener movedFragmentListener2, SettingActivity.TimerSizeListener timerSizeListener2) {
        AirconReservationListFragment airconReservationListFragment = new AirconReservationListFragment();
        Bundle bundle = new Bundle();
        bundle.putString("CONNECTED_MAC_ADDRESS", str);
        airconReservationListFragment.setArguments(bundle);
        movedFragmentListener = movedFragmentListener2;
        timerSizeListener = timerSizeListener2;
        return airconReservationListFragment;
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
        AirconReservationListPresenter airconReservationListPresenter = new AirconReservationListPresenter(this, new AirconReservationListInteractor(this), new DeleteReservationInteractor(this, this), new SendReservationToServerInteractor(this));
        this.presenter = airconReservationListPresenter;
        airconReservationListPresenter.onCreateView();
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

    @Override // kr.switcher.switcherm.ui.setting.view.AirconReservationListView
    public void initRecyclerListView() {
        ArrayList arrayList = new ArrayList();
        this.arrayList = arrayList;
        arrayList.clear();
        AirconReservationAdapter airconReservationAdapter = new AirconReservationAdapter(this.arrayList, this, this);
        this.adapter = airconReservationAdapter;
        airconReservationAdapter.clear();
        this.sr_timer_list.setOnRefreshListener(this);
        this.rv_timer_list.setLayoutManager(new LinearLayoutManager(getContext()));
        this.rv_timer_list.setItemAnimator(new IOItemAnimator());
        this.rv_timer_list.setAdapter(this.adapter);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.AirconReservationListView
    public void showProgressbar() {
        this.sr_timer_list.setRefreshing(true);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.AirconReservationListView
    public void disableProgressbar() {
        this.sr_timer_list.setRefreshing(false);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.AirconReservationListView
    public void timeoutLoading() {
        new Handler().postDelayed(new Runnable() { // from class: kr.switcher.switcherm.ui.setting.fragment.AirconReservationListFragment.1
            @Override // java.lang.Runnable
            public void run() {
                AirconReservationListFragment.this.presenter.timeout(AirconReservationListFragment.this.sr_timer_list.isRefreshing());
            }
        }, 1000L);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.AirconReservationListView
    public void moveAirconReservationFragment(int i) {
        FragmentTransaction fragmentTransactionBeginTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        AirconReservationFragment airconReservationFragmentNewInstance = AirconReservationFragment.newInstance(this.connectedRemocon.getMacAddress(), this.adapter.getItem(i));
        fragmentTransactionBeginTransaction.replace(R.id.container, airconReservationFragmentNewInstance, "AirconReservationFragment");
        try {
            fragmentTransactionBeginTransaction.commit();
        } catch (Exception e) {
            IOLog.error(TAG, new OAuthToken().getOAuthToken(), "moveAirconReservationFragment", e);
        }
        movedFragmentListener.onFragmentMoved(airconReservationFragmentNewInstance);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.AirconReservationListView
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

    @Override // kr.switcher.switcherm.ui.setting.adapter.AirconReservationAdapter.OnItemClickListener
    public void onShowProgressbar() {
        showProgressbar();
        timeoutLoading();
    }

    @Override // kr.switcher.switcherm.ui.setting.adapter.AirconReservationAdapter.OnItemClickListener
    public void onItemClick(int i) {
        this.presenter.onItemClick(this.sr_timer_list.isRefreshing(), i);
    }

    @Override // kr.switcher.switcherm.ui.setting.adapter.AirconReservationAdapter.OnItemClickListener
    public void onRemoveItemClick(int i) {
        showDeleteDialog(i);
    }

    @Override // kr.switcher.switcherm.ui.setting.interactor.AirconReservationListInteractor.OnAirconReservationListListener
    public void onFindRemoconReservation(List<AirconReservationItem> list) {
        this.presenter.onFindRemoconReservation(list);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.AirconReservationListView
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

    @Override // kr.switcher.switcherm.ui.setting.view.AirconReservationListView
    public void showDeleteDialog(final int i) {
        new MaterialDialog.Builder(getContext()).content("예약을 삭제 하시겠습니까?").positiveText("예").negativeText("아니오").negativeColor(R.color.periwinkle).positiveColor(R.color.periwinkle).onPositive(new MaterialDialog.SingleButtonCallback() { // from class: kr.switcher.switcherm.ui.setting.fragment.AirconReservationListFragment.3
            @Override // com.afollestad.materialdialogs.MaterialDialog.SingleButtonCallback
            public void onClick(MaterialDialog materialDialog, DialogAction dialogAction) {
                AirconReservationListFragment.this.presenter.removeReservation(AirconReservationListFragment.this.adapter.getItem(i));
                AirconReservationListFragment.this.showProgressbar();
                AirconReservationListFragment.this.timeoutLoading();
            }
        }).onNegative(new MaterialDialog.SingleButtonCallback() { // from class: kr.switcher.switcherm.ui.setting.fragment.AirconReservationListFragment.2
            @Override // com.afollestad.materialdialogs.MaterialDialog.SingleButtonCallback
            public void onClick(MaterialDialog materialDialog, DialogAction dialogAction) {
            }
        }).cancelable(false).show();
    }

    @Override // kr.switcher.switcherm.ui.setting.adapter.AirconReservationAdapter.OnCheckedChangeListener
    public void onCheckedChange(int i, String str) {
        this.presenter.onCheckedChange(this.adapter.getItem(i), str);
    }

    @Override // kr.switcher.switcherm.ui.setting.interactor.DeleteReservationInteractor.OnChangeReservationDataListener
    public void onChangeReservationDataSuccess(Remocon.RemoconReservation remoconReservation, String str) {
        this.presenter.onChangeReservationDataSuccess(remoconReservation, this.connectedRemocon.getId(), str);
    }
}
