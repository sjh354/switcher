package kr.switcher.switcherm.ui.setting.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
import kr.switcher.switcherm.ui.setting.adapter.AirconMaintainingTemperatureAdapter;
import kr.switcher.switcherm.ui.setting.adapter.AirconMaintainingTemperatureItem;
import kr.switcher.switcherm.ui.setting.interactor.DeleteMaintenanceInteractor;
import kr.switcher.switcherm.ui.setting.interactor.FindAirconMaintenanceListInteractor;
import kr.switcher.switcherm.ui.setting.interactor.ModifyAirconMaintenanceInteractor;
import kr.switcher.switcherm.ui.setting.presenter.AirconMaintainingTemperatureListPresenter;
import kr.switcher.switcherm.ui.setting.view.AirconMaintainingTemperatureListView;

/* JADX INFO: loaded from: classes2.dex */
public class AirconMaintainingTemperatureListFragment extends Fragment implements AirconMaintainingTemperatureListView, AirconMaintainingTemperatureAdapter.OnCheckedChangeListener, AirconMaintainingTemperatureAdapter.OnItemClickListener, SwipeRefreshLayout.OnRefreshListener, FindAirconMaintenanceListInteractor.OnFindAirconMaintainaListListener, DeleteMaintenanceInteractor.OnDeleteReservationListener, ModifyAirconMaintenanceInteractor.OnModifyAirconMaintenanceListener {
    private static final String TAG = "AirconMaintainingTemperatureListFragment";
    private static SettingActivity.MovedFragmentListener movedFragmentListener;
    private AirconMaintainingTemperatureAdapter adapter;
    private List<Remocon.RemoconMaintenanceTemperature> arrayList;
    private Remocon connectedRemocon;

    @BindView(R.id.iv_empty_timer)
    ImageView iv_empty_timer;
    private AirconMaintainingTemperatureListPresenter presenter;

    @BindView(R.id.rl_can_not_load)
    RelativeLayout rl_can_not_load;

    @BindView(R.id.rl_empty)
    RelativeLayout rl_empty;

    @BindView(R.id.rv_timer_list)
    RecyclerView rv_timer_list;

    @BindView(R.id.sr_timer_list)
    SwipeRefreshLayout sr_timer_list;

    @Override // kr.switcher.switcherm.ui.setting.view.AirconMaintainingTemperatureListView
    public void hideEmpty() {
    }

    @Override // kr.switcher.switcherm.ui.setting.interactor.DeleteMaintenanceInteractor.OnDeleteReservationListener
    public void onDeleteMaintenanceError(String str) {
    }

    @Override // kr.switcher.switcherm.ui.setting.interactor.DeleteMaintenanceInteractor.OnDeleteReservationListener
    public void onDeleteMaintenanceSuccess() {
    }

    @Override // kr.switcher.switcherm.ui.setting.interactor.FindAirconMaintenanceListInteractor.OnFindAirconMaintainaListListener
    public void onError(String str) {
    }

    @Override // kr.switcher.switcherm.ui.setting.interactor.ModifyAirconMaintenanceInteractor.OnModifyAirconMaintenanceListener
    public void onModifySuccess() {
    }

    @Override // kr.switcher.switcherm.ui.setting.view.AirconMaintainingTemperatureListView
    public void onReservationSize(int i) {
    }

    @Override // kr.switcher.switcherm.ui.setting.view.AirconMaintainingTemperatureListView
    public void showCanNotLoaded() {
    }

    @Override // kr.switcher.switcherm.ui.setting.view.AirconMaintainingTemperatureListView
    public void showReservationList() {
    }

    public static AirconMaintainingTemperatureListFragment newInstance(String str, SettingActivity.MovedFragmentListener movedFragmentListener2) {
        AirconMaintainingTemperatureListFragment airconMaintainingTemperatureListFragment = new AirconMaintainingTemperatureListFragment();
        Bundle bundle = new Bundle();
        bundle.putString("CONNECTED_MAC_ADDRESS", str);
        airconMaintainingTemperatureListFragment.setArguments(bundle);
        movedFragmentListener = movedFragmentListener2;
        return airconMaintainingTemperatureListFragment;
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
        AirconMaintainingTemperatureListPresenter airconMaintainingTemperatureListPresenter = new AirconMaintainingTemperatureListPresenter(this, new FindAirconMaintenanceListInteractor(this), new DeleteMaintenanceInteractor(this), new ModifyAirconMaintenanceInteractor(this));
        this.presenter = airconMaintainingTemperatureListPresenter;
        airconMaintainingTemperatureListPresenter.onCreateView();
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

    @Override // kr.switcher.switcherm.ui.setting.view.AirconMaintainingTemperatureListView
    public void initRecyclerListView() {
        ArrayList arrayList = new ArrayList();
        this.arrayList = arrayList;
        arrayList.clear();
        AirconMaintainingTemperatureAdapter airconMaintainingTemperatureAdapter = new AirconMaintainingTemperatureAdapter(this.arrayList, this, this);
        this.adapter = airconMaintainingTemperatureAdapter;
        airconMaintainingTemperatureAdapter.clear();
        this.sr_timer_list.setOnRefreshListener(this);
        this.rv_timer_list.setLayoutManager(new LinearLayoutManager(getContext()));
        this.rv_timer_list.setItemAnimator(new IOItemAnimator());
        this.rv_timer_list.setAdapter(this.adapter);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.AirconMaintainingTemperatureListView
    public void showProgressbar() {
        this.sr_timer_list.setRefreshing(true);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.AirconMaintainingTemperatureListView
    public void disableProgressbar() {
        this.sr_timer_list.setRefreshing(false);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.AirconMaintainingTemperatureListView
    public void timeoutLoading() {
        new Handler().postDelayed(new Runnable() { // from class: kr.switcher.switcherm.ui.setting.fragment.AirconMaintainingTemperatureListFragment.1
            @Override // java.lang.Runnable
            public void run() {
                AirconMaintainingTemperatureListFragment.this.presenter.timeout(AirconMaintainingTemperatureListFragment.this.sr_timer_list.isRefreshing());
            }
        }, 1000L);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.AirconMaintainingTemperatureListView
    public void showEmpty() {
        this.iv_empty_timer.setBackground(IOUtil.getDrawable(R.drawable.ic_no_airocn_reservation));
        this.rl_empty.setVisibility(0);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.AirconMaintainingTemperatureListView
    public void moveAirconMaintainingTemperatureFragment(int i) {
        FragmentTransaction fragmentTransactionBeginTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        AirconMaintainingTemperatureFragment airconMaintainingTemperatureFragmentNewInstance = AirconMaintainingTemperatureFragment.newInstance(this.connectedRemocon.getMacAddress(), this.adapter.getItem(i));
        fragmentTransactionBeginTransaction.replace(R.id.container, airconMaintainingTemperatureFragmentNewInstance, "AirconMaintainingTemperatureFragment");
        try {
            fragmentTransactionBeginTransaction.commit();
        } catch (Exception e) {
            IOLog.error(TAG, new OAuthToken().getOAuthToken(), "moveMaintenanceFragment", e);
        }
        movedFragmentListener.onFragmentMoved(airconMaintainingTemperatureFragmentNewInstance);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.AirconMaintainingTemperatureListView
    public void setRemoconReservations(List<Remocon.RemoconMaintenanceTemperature> list) {
        this.adapter.clear();
        this.arrayList.clear();
        Iterator<Remocon.RemoconMaintenanceTemperature> it = list.iterator();
        while (it.hasNext()) {
            this.arrayList.add(it.next());
        }
        this.adapter.notifyDataSetChanged();
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
    public void onRefresh() {
        this.presenter.onRefresh(this.connectedRemocon);
    }

    @Override // kr.switcher.switcherm.ui.setting.adapter.AirconMaintainingTemperatureAdapter.OnItemClickListener
    public void onShowProgressbar() {
        showProgressbar();
        timeoutLoading();
    }

    @Override // kr.switcher.switcherm.ui.setting.adapter.AirconMaintainingTemperatureAdapter.OnItemClickListener
    public void onItemClick(int i) {
        this.presenter.onItemClick(this.sr_timer_list.isRefreshing(), i);
    }

    @Override // kr.switcher.switcherm.ui.setting.adapter.AirconMaintainingTemperatureAdapter.OnItemClickListener
    public void onRemoveItemClick(int i) {
        showDeleteDialog(i);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.AirconMaintainingTemperatureListView
    public void convertRemoconMaintainingTemperatureData(List<AirconMaintainingTemperatureItem> list) {
        this.presenter.convertRemoconMaintainingTemperatureData(list);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.AirconMaintainingTemperatureListView
    public void showDeleteDialog(final int i) {
        new MaterialDialog.Builder(getContext()).content("예약을 삭제 하시겠습니까?").positiveText("예").negativeText("아니오").negativeColor(R.color.periwinkle).positiveColor(R.color.periwinkle).onPositive(new MaterialDialog.SingleButtonCallback() { // from class: kr.switcher.switcherm.ui.setting.fragment.AirconMaintainingTemperatureListFragment.3
            @Override // com.afollestad.materialdialogs.MaterialDialog.SingleButtonCallback
            public void onClick(MaterialDialog materialDialog, DialogAction dialogAction) {
                AirconMaintainingTemperatureListFragment.this.presenter.removeMaintenance(AirconMaintainingTemperatureListFragment.this.adapter.getItem(i), i);
                AirconMaintainingTemperatureListFragment.this.showProgressbar();
                AirconMaintainingTemperatureListFragment.this.timeoutLoading();
            }
        }).onNegative(new MaterialDialog.SingleButtonCallback() { // from class: kr.switcher.switcherm.ui.setting.fragment.AirconMaintainingTemperatureListFragment.2
            @Override // com.afollestad.materialdialogs.MaterialDialog.SingleButtonCallback
            public void onClick(MaterialDialog materialDialog, DialogAction dialogAction) {
            }
        }).cancelable(false).show();
    }

    @Override // kr.switcher.switcherm.ui.setting.adapter.AirconMaintainingTemperatureAdapter.OnCheckedChangeListener
    public void onCheckedChange(int i, String str) {
        this.presenter.onCheckedChange(this.adapter.getItem(i), str);
    }

    @Override // kr.switcher.switcherm.ui.setting.interactor.FindAirconMaintenanceListInteractor.OnFindAirconMaintainaListListener
    public void onFindRemoconMaintenance(List<AirconMaintainingTemperatureItem> list) {
        this.presenter.onFindRemoconMaintenance(list);
    }

    @Override // kr.switcher.switcherm.ui.setting.interactor.ModifyAirconMaintenanceInteractor.OnModifyAirconMaintenanceListener
    public void onModifyError(String str) {
        this.presenter.onResume(this.connectedRemocon);
    }

    @Override // kr.switcher.switcherm.ui.setting.interactor.DeleteMaintenanceInteractor.OnDeleteReservationListener
    public void onDeleteMaintenanceSuccess(int i) {
        IOUtil.showToast("삭제 완료");
        onResume();
    }
}
