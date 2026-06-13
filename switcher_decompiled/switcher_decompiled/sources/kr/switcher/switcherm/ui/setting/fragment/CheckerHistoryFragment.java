package kr.switcher.switcherm.ui.setting.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.wang.avi.AVLoadingIndicatorView;
import java.util.ArrayList;
import java.util.List;
import kr.switcher.device.checker.Checker;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.device.IODeviceHandler;
import kr.switcher.switcherm.ui.setting.adapter.CheckerHistoryAdapter;
import kr.switcher.switcherm.ui.setting.adapter.CheckerHistoryItem;
import kr.switcher.switcherm.ui.setting.interactor.FindRecentCheckerHistoryInteractor;
import kr.switcher.switcherm.ui.setting.presenter.CheckerHistoryPresenter;
import kr.switcher.switcherm.ui.setting.view.CheckerHistoryView;

/* JADX INFO: loaded from: classes2.dex */
public class CheckerHistoryFragment extends Fragment implements CheckerHistoryView, FindRecentCheckerHistoryInteractor.OnFindRecentCheckerHistoryListener, CheckerHistoryAdapter.OnBottomReachedListener {
    private static final String PARM_CONNECTED_MAC_ADDRESS = "CONNECTED_ID";
    private static final String TAG = "CheckerHistoryFragment";
    private CheckerHistoryAdapter adapter;
    private Checker connectedChecker;
    private ArrayList<CheckerHistoryItem> historyList;

    @BindView(R.id.ll_no_search_history)
    LinearLayout ll_no_search_history;

    @BindView(R.id.pb_searching)
    AVLoadingIndicatorView pb_searching;
    private CheckerHistoryPresenter presenter;

    @BindView(R.id.rl_half_year)
    RelativeLayout rl_half_year;

    @BindView(R.id.rl_one_month)
    RelativeLayout rl_one_month;

    @BindView(R.id.rl_one_week)
    RelativeLayout rl_one_week;

    @BindView(R.id.rv_checker_history)
    RecyclerView rv_checker_history;

    @BindView(R.id.tv_half_year)
    TextView tv_half_year;

    @BindView(R.id.tv_one_month)
    TextView tv_one_month;

    @BindView(R.id.tv_one_week)
    TextView tv_one_week;

    public static CheckerHistoryFragment newInstance(String str) {
        CheckerHistoryFragment checkerHistoryFragment = new CheckerHistoryFragment();
        Bundle bundle = new Bundle();
        bundle.putString(PARM_CONNECTED_MAC_ADDRESS, str);
        checkerHistoryFragment.setArguments(bundle);
        return checkerHistoryFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_checker_history, viewGroup, false);
        ButterKnife.bind(this, viewInflate);
        Bundle arguments = getArguments();
        Checker checker = (Checker) IODeviceHandler.getInstance().getDevice(arguments != null ? arguments.getString(PARM_CONNECTED_MAC_ADDRESS) : "");
        this.connectedChecker = checker;
        if (checker == null) {
            return null;
        }
        this.presenter = new CheckerHistoryPresenter(this, new FindRecentCheckerHistoryInteractor(this));
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.presenter.onResume(this.connectedChecker);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.CheckerHistoryView
    public void initRecyclerListView() {
        this.historyList = new ArrayList<>();
        this.adapter = new CheckerHistoryAdapter(this.historyList, this);
        this.rv_checker_history.setLayoutManager(new LinearLayoutManager(getContext()));
        this.rv_checker_history.setAdapter(this.adapter);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.CheckerHistoryView
    public void setCheckerHistoryItems(List<CheckerHistoryItem> list) {
        this.ll_no_search_history.setVisibility(8);
        this.historyList.addAll(list);
        this.adapter.notifyDataSetChanged();
    }

    @Override // kr.switcher.switcherm.ui.setting.view.CheckerHistoryView
    public void addNextCheckerHistoryItems(List<CheckerHistoryItem> list) {
        this.historyList.addAll(list);
        this.adapter.notifyDataSetChanged();
    }

    @Override // kr.switcher.switcherm.ui.setting.view.CheckerHistoryView
    public void showNoSearchComment() {
        this.ll_no_search_history.setVisibility(0);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.CheckerHistoryView
    public void oneWeekBtnChange() {
        this.rl_one_week.setBackground(IOUtil.getDrawable(R.drawable.shape_lavenderblue_fill));
        this.tv_one_week.setTextColor(IOUtil.getColorResource(R.color.white));
        this.rl_one_month.setBackground(IOUtil.getDrawable(R.drawable.shape_palegrey));
        this.tv_one_month.setTextColor(IOUtil.getColorResource(R.color.charcoal_grey));
        this.rl_half_year.setBackground(IOUtil.getDrawable(R.drawable.shape_palegrey));
        this.tv_half_year.setTextColor(IOUtil.getColorResource(R.color.charcoal_grey));
    }

    @Override // kr.switcher.switcherm.ui.setting.view.CheckerHistoryView
    public void oneMonthBtnChange() {
        this.rl_one_week.setBackground(IOUtil.getDrawable(R.drawable.shape_palegrey));
        this.tv_one_week.setTextColor(IOUtil.getColorResource(R.color.charcoal_grey));
        this.rl_one_month.setBackground(IOUtil.getDrawable(R.drawable.shape_lavenderblue_fill));
        this.tv_one_month.setTextColor(IOUtil.getColorResource(R.color.white));
        this.rl_half_year.setBackground(IOUtil.getDrawable(R.drawable.shape_palegrey));
        this.tv_half_year.setTextColor(IOUtil.getColorResource(R.color.charcoal_grey));
    }

    @Override // kr.switcher.switcherm.ui.setting.view.CheckerHistoryView
    public void halfYearBtnChange() {
        this.rl_one_week.setBackground(IOUtil.getDrawable(R.drawable.shape_palegrey));
        this.tv_one_week.setTextColor(IOUtil.getColorResource(R.color.charcoal_grey));
        this.rl_one_month.setBackground(IOUtil.getDrawable(R.drawable.shape_palegrey));
        this.tv_one_month.setTextColor(IOUtil.getColorResource(R.color.charcoal_grey));
        this.rl_half_year.setBackground(IOUtil.getDrawable(R.drawable.shape_lavenderblue_fill));
        this.tv_half_year.setTextColor(IOUtil.getColorResource(R.color.white));
    }

    @Override // kr.switcher.switcherm.ui.setting.interactor.FindRecentCheckerHistoryInteractor.OnFindRecentCheckerHistoryListener
    public void onFindHistories(List<CheckerHistoryItem> list) {
        this.presenter.onFindHistories(list);
    }

    @Override // kr.switcher.switcherm.ui.setting.interactor.FindRecentCheckerHistoryInteractor.OnFindRecentCheckerHistoryListener
    public void onFindNextPageHistories(List<CheckerHistoryItem> list) {
        this.presenter.onNextPageHistories(list);
    }

    @OnClick({R.id.rl_one_week})
    public void onOneWeekBtnClicked() {
        this.adapter.clear();
        this.presenter.onOneWeekBtnClicked(this.connectedChecker);
    }

    @OnClick({R.id.rl_one_month})
    public void onOneMonthBtnClicked() {
        this.adapter.clear();
        this.presenter.onOneMonthBtnClicked(this.connectedChecker);
    }

    @OnClick({R.id.rl_half_year})
    public void onHalfYearBtnClicked() {
        this.adapter.clear();
        this.presenter.onHalfYearBtnClicked(this.connectedChecker);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.CheckerHistoryView
    public void hideProgressBar() {
        IOUtil.hideProgressbarDialog(getActivity(), this.pb_searching);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.CheckerHistoryView
    public void showProgressBar(int i) {
        IOUtil.showProgressbarDialog(getActivity(), this.pb_searching, i);
    }

    @Override // kr.switcher.switcherm.ui.setting.adapter.CheckerHistoryAdapter.OnBottomReachedListener
    public void onBottomReached() {
        this.presenter.onBottomReached();
    }
}
