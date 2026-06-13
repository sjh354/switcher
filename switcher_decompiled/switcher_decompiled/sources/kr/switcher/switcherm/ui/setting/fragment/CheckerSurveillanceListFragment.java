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
import kr.switcher.device.checker.Checker;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.listview.IOItemAnimator;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.device.IODeviceHandler;
import kr.switcher.switcherm.preference.OAuthToken;
import kr.switcher.switcherm.ui.setting.SettingActivity;
import kr.switcher.switcherm.ui.setting.adapter.CheckerSurveillanceAdapter;
import kr.switcher.switcherm.ui.setting.adapter.CheckerSurveillanceItem;
import kr.switcher.switcherm.ui.setting.interactor.DeleteSurveillanceInteractor;
import kr.switcher.switcherm.ui.setting.interactor.FindCheckerSurveillanceListInteractor;
import kr.switcher.switcherm.ui.setting.interactor.ModifyCheckerSurveillanceInteractor;
import kr.switcher.switcherm.ui.setting.presenter.CheckerSurveillanceListPresenter;
import kr.switcher.switcherm.ui.setting.view.CheckerSurveillanceListView;

/* JADX INFO: loaded from: classes2.dex */
public class CheckerSurveillanceListFragment extends Fragment implements CheckerSurveillanceListView, CheckerSurveillanceAdapter.OnCheckedChangeListener, CheckerSurveillanceAdapter.OnItemClickListener, SwipeRefreshLayout.OnRefreshListener, FindCheckerSurveillanceListInteractor.OnFindCheckerSurveillanceListListener, ModifyCheckerSurveillanceInteractor.OnModifyCheckerSurveillanceListener, DeleteSurveillanceInteractor.OnDeleteSurveillanceListener {
    private static final String TAG = "CheckerSurveillanceListFragment";
    private static SettingActivity.MovedFragmentListener movedFragmentListener;
    private CheckerSurveillanceAdapter adapter;
    private List<Checker.Surveillance> arrayList;
    private Checker connectedChecker;

    @BindView(R.id.iv_empty_timer)
    ImageView iv_empty_timer;
    private CheckerSurveillanceListPresenter presenter;

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

    @Override // kr.switcher.switcherm.ui.setting.interactor.DeleteSurveillanceInteractor.OnDeleteSurveillanceListener
    public void onDeleteSurveillanceError(String str) {
    }

    @Override // kr.switcher.switcherm.ui.setting.interactor.ModifyCheckerSurveillanceInteractor.OnModifyCheckerSurveillanceListener
    public void onError(String str) {
    }

    @Override // kr.switcher.switcherm.ui.setting.interactor.FindCheckerSurveillanceListInteractor.OnFindCheckerSurveillanceListListener
    public void onFindSurveillanceError(String str) {
    }

    @Override // kr.switcher.switcherm.ui.setting.interactor.ModifyCheckerSurveillanceInteractor.OnModifyCheckerSurveillanceListener
    public void onModifySurveillance() {
    }

    @Override // kr.switcher.switcherm.ui.setting.view.CheckerSurveillanceListView
    public void onReservationSize(int i) {
    }

    @Override // kr.switcher.switcherm.ui.setting.view.CheckerSurveillanceListView
    public void showCanNotLoaded() {
    }

    @Override // kr.switcher.switcherm.ui.setting.view.CheckerSurveillanceListView
    public void showReservationList() {
    }

    public static CheckerSurveillanceListFragment newInstance(String str, SettingActivity.MovedFragmentListener movedFragmentListener2) {
        CheckerSurveillanceListFragment checkerSurveillanceListFragment = new CheckerSurveillanceListFragment();
        Bundle bundle = new Bundle();
        bundle.putString("CONNECTED_MAC_ADDRESS", str);
        checkerSurveillanceListFragment.setArguments(bundle);
        movedFragmentListener = movedFragmentListener2;
        return checkerSurveillanceListFragment;
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
        Checker checker = (Checker) IODeviceHandler.getInstance().getDevice(string);
        this.connectedChecker = checker;
        if (checker == null) {
            IOUtil.showToast(IOUtil.getStringResource(R.string.not_found_device));
            return null;
        }
        CheckerSurveillanceListPresenter checkerSurveillanceListPresenter = new CheckerSurveillanceListPresenter(this, new FindCheckerSurveillanceListInteractor(this), new ModifyCheckerSurveillanceInteractor(this), new DeleteSurveillanceInteractor(this));
        this.presenter = checkerSurveillanceListPresenter;
        checkerSurveillanceListPresenter.onCreateView();
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        this.presenter.onResume(this.connectedChecker.getMacAddress());
        super.onResume();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // kr.switcher.switcherm.ui.setting.view.CheckerSurveillanceListView
    public void initRecyclerListView() {
        ArrayList arrayList = new ArrayList();
        this.arrayList = arrayList;
        arrayList.clear();
        CheckerSurveillanceAdapter checkerSurveillanceAdapter = new CheckerSurveillanceAdapter(this.arrayList, this, this);
        this.adapter = checkerSurveillanceAdapter;
        checkerSurveillanceAdapter.clear();
        this.sr_timer_list.setOnRefreshListener(this);
        this.rv_timer_list.setLayoutManager(new LinearLayoutManager(getContext()));
        this.rv_timer_list.setItemAnimator(new IOItemAnimator());
        this.rv_timer_list.setAdapter(this.adapter);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.CheckerSurveillanceListView
    public void showProgressbar() {
        this.sr_timer_list.setRefreshing(true);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.CheckerSurveillanceListView
    public void disableProgressbar() {
        this.sr_timer_list.setRefreshing(false);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.CheckerSurveillanceListView
    public void timeoutLoading() {
        new Handler().postDelayed(new Runnable() { // from class: kr.switcher.switcherm.ui.setting.fragment.CheckerSurveillanceListFragment.1
            @Override // java.lang.Runnable
            public void run() {
                CheckerSurveillanceListFragment.this.presenter.timeout(CheckerSurveillanceListFragment.this.sr_timer_list.isRefreshing());
            }
        }, 1000L);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.CheckerSurveillanceListView
    public void showEmpty() {
        this.rl_empty.setVisibility(0);
        this.iv_empty_timer.setBackground(IOUtil.getDrawable(R.drawable.ic_surveillance_empty));
        this.tv_empty.setText(R.string.surveillance_list_empty);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.CheckerSurveillanceListView
    public void hideEmpty() {
        this.rl_empty.setVisibility(8);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.CheckerSurveillanceListView
    public void moveCheckerSurveillanceFragment(int i) {
        FragmentTransaction fragmentTransactionBeginTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        CheckerSurveillanceSettingFragment checkerSurveillanceSettingFragmentNewInstance = CheckerSurveillanceSettingFragment.newInstance(this.connectedChecker.getMacAddress(), this.adapter.getItem(i));
        fragmentTransactionBeginTransaction.replace(R.id.container, checkerSurveillanceSettingFragmentNewInstance, "CheckerSurveillanceSettingFragment");
        try {
            fragmentTransactionBeginTransaction.commit();
        } catch (Exception e) {
            IOLog.error(TAG, new OAuthToken().getOAuthToken(), "moveSurveillanceSettingFragment", e);
        }
        movedFragmentListener.onFragmentMoved(checkerSurveillanceSettingFragmentNewInstance);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.CheckerSurveillanceListView
    public void setCheckerSurveillance(List<Checker.Surveillance> list) {
        this.adapter.clear();
        this.arrayList.clear();
        Iterator<Checker.Surveillance> it = list.iterator();
        while (it.hasNext()) {
            this.arrayList.add(it.next());
        }
        this.adapter.notifyDataSetChanged();
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
    public void onRefresh() {
        this.presenter.onRefresh(this.connectedChecker.getMacAddress());
    }

    @Override // kr.switcher.switcherm.ui.setting.adapter.CheckerSurveillanceAdapter.OnItemClickListener
    public void onShowProgressbar() {
        showProgressbar();
        timeoutLoading();
    }

    @Override // kr.switcher.switcherm.ui.setting.adapter.CheckerSurveillanceAdapter.OnItemClickListener
    public void onItemClick(int i) {
        this.presenter.onItemClick(this.sr_timer_list.isRefreshing(), i);
    }

    @Override // kr.switcher.switcherm.ui.setting.adapter.CheckerSurveillanceAdapter.OnItemClickListener
    public void onRemoveItemClick(int i) {
        showDeleteDialog(i);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.CheckerSurveillanceListView
    public void convertCheckerSurveillanceData(List<CheckerSurveillanceItem> list) {
        this.presenter.convertCheckerSurveillanceData(list);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.CheckerSurveillanceListView
    public void showDeleteDialog(final int i) {
        new MaterialDialog.Builder(getContext()).content("예약을 삭제 하시겠습니까?").positiveText("예").negativeText("아니오").negativeColor(R.color.periwinkle).positiveColor(R.color.periwinkle).onPositive(new MaterialDialog.SingleButtonCallback() { // from class: kr.switcher.switcherm.ui.setting.fragment.CheckerSurveillanceListFragment.3
            @Override // com.afollestad.materialdialogs.MaterialDialog.SingleButtonCallback
            public void onClick(MaterialDialog materialDialog, DialogAction dialogAction) {
                CheckerSurveillanceListFragment.this.presenter.deleteButtonClicked(CheckerSurveillanceListFragment.this.connectedChecker.getMacAddress(), CheckerSurveillanceListFragment.this.adapter.getItem(i));
                CheckerSurveillanceListFragment.this.showProgressbar();
                CheckerSurveillanceListFragment.this.timeoutLoading();
            }
        }).onNegative(new MaterialDialog.SingleButtonCallback() { // from class: kr.switcher.switcherm.ui.setting.fragment.CheckerSurveillanceListFragment.2
            @Override // com.afollestad.materialdialogs.MaterialDialog.SingleButtonCallback
            public void onClick(MaterialDialog materialDialog, DialogAction dialogAction) {
            }
        }).cancelable(false).show();
    }

    @Override // kr.switcher.switcherm.ui.setting.adapter.CheckerSurveillanceAdapter.OnCheckedChangeListener
    public void onCheckedChange(int i, String str) {
        this.presenter.onCheckedChange(this.adapter.getItem(i), str);
    }

    @Override // kr.switcher.switcherm.ui.setting.interactor.FindCheckerSurveillanceListInteractor.OnFindCheckerSurveillanceListListener
    public void onFindCheckerSurveillance(List<CheckerSurveillanceItem> list) {
        this.presenter.onFindCheckerSurveillance(list);
    }

    @Override // kr.switcher.switcherm.ui.setting.interactor.DeleteSurveillanceInteractor.OnDeleteSurveillanceListener
    public void onDeleteSurveillanceSuccess() {
        onRefresh();
    }
}
