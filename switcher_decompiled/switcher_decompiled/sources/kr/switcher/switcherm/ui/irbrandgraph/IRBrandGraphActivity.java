package kr.switcher.switcherm.ui.irbrandgraph;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import java.util.ArrayList;
import java.util.List;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.activity.IOActivity;
import kr.switcher.switcherm.common.chart.IOChartData;
import kr.switcher.switcherm.common.chart.IOLineChart;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.device.IODeviceHandler;
import kr.switcher.switcherm.device.linker.LinkerHandler;
import kr.switcher.switcherm.ui.irbrandgraph.adapter.CommandHistoryItem;
import kr.switcher.switcherm.ui.irbrandgraph.adapter.IRBrandGraphAdapter;
import kr.switcher.switcherm.ui.irbrandgraph.interactor.FindRecentCommandHistoryInteractor;
import kr.switcher.switcherm.ui.irbrandgraph.interactor.helper.MinMax;
import kr.switcher.switcherm.ui.irbrandgraph.presenter.IRBrandGraphPresenter;
import kr.switcher.switcherm.ui.irbrandgraph.view.IRBrandGraphView;

/* JADX INFO: loaded from: classes2.dex */
public class IRBrandGraphActivity extends IOActivity implements IRBrandGraphView, IRBrandGraphAdapter.OnItemClickListener, FindRecentCommandHistoryInteractor.OnFindTitleListener {
    public static final String INTENT_PARM_CONNECTED_DEVICE_MAC_ADDRESS = "PARM_SWITCHER_MAC_ADDRESS";
    public static final String INTENT_PARM_LINKER_MAC_ADDRESS = "PARM_LINKER_MAC_ADDRESS";
    private IRBrandGraphAdapter adapter;
    private List<CommandHistoryItem> brandHistoryItemList;

    @BindView(R.id.btn_one_day_data)
    TextView btn_one_day_data;

    @BindView(R.id.btn_one_hour_data)
    TextView btn_one_hour_data;

    @BindView(R.id.line_chart)
    IOLineChart chart;

    @BindView(R.id.iv_no_command_list)
    ImageView iv_no_command_list;

    @BindView(R.id.lin_top)
    LinearLayout lin_top;
    private IRBrandGraphPresenter presenter;

    @BindView(R.id.rv_command_history)
    RecyclerView rv_command_history;

    @BindView(R.id.tv_chart_title)
    TextView tv_chart_title;

    @BindView(R.id.tv_not_found)
    TextView tv_not_found;

    @Override // kr.switcher.switcherm.ui.irbrandgraph.adapter.IRBrandGraphAdapter.OnItemClickListener
    public void onItemClick(int i) {
    }

    @Override // kr.switcher.switcherm.common.activity.IOActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_ir_brand_graph);
        ButterKnife.bind(this);
        IRBrandGraphPresenter iRBrandGraphPresenter = new IRBrandGraphPresenter(this, new FindRecentCommandHistoryInteractor(LinkerHandler.getInstance().getLinker(getIntent().getStringExtra(INTENT_PARM_LINKER_MAC_ADDRESS)), IODeviceHandler.getInstance().getDevice(getIntent().getStringExtra(INTENT_PARM_CONNECTED_DEVICE_MAC_ADDRESS)), this));
        this.presenter = iRBrandGraphPresenter;
        iRBrandGraphPresenter.onCreate();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.presenter.onResume();
    }

    @Override // kr.switcher.switcherm.ui.irbrandgraph.view.IRBrandGraphView
    public void initChart(MinMax minMax, IOLineChart.ChartYUnitKinds chartYUnitKinds) {
        this.chart.initLineChart(minMax.getMin(), minMax.getMax(), chartYUnitKinds);
        this.lin_top.setBackground(IOUtil.getDrawable(R.drawable.connected_bg));
    }

    @Override // kr.switcher.switcherm.ui.irbrandgraph.view.IRBrandGraphView
    public void setChartDatas(List<IOChartData> list) {
        this.chart.setData(list);
    }

    @Override // kr.switcher.switcherm.ui.irbrandgraph.view.IRBrandGraphView
    public void setControllerType(String str) {
        this.tv_chart_title.setText(str);
    }

    @Override // kr.switcher.switcherm.ui.irbrandgraph.view.IRBrandGraphView
    public void initRecyclerListView() {
        this.brandHistoryItemList = new ArrayList();
        this.adapter = new IRBrandGraphAdapter(this.brandHistoryItemList, this);
        this.rv_command_history.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        this.rv_command_history.setAdapter(this.adapter);
    }

    @Override // kr.switcher.switcherm.ui.irbrandgraph.view.IRBrandGraphView
    public void setCommandHistoryItems(List<CommandHistoryItem> list) {
        this.brandHistoryItemList.addAll(list);
        this.adapter.notifyDataSetChanged();
        this.tv_not_found.setVisibility(8);
        this.iv_no_command_list.setVisibility(8);
    }

    @Override // kr.switcher.switcherm.ui.irbrandgraph.view.IRBrandGraphView
    public void showNotFoundView() {
        this.iv_no_command_list.setVisibility(0);
        this.tv_not_found.setVisibility(0);
    }

    @Override // kr.switcher.switcherm.ui.irbrandgraph.view.IRBrandGraphView
    public void setChartPeriodOneHour() {
        this.btn_one_day_data.setBackground(IOUtil.getDrawable(R.drawable.shape_rectangle_white_border));
        this.btn_one_day_data.setTextColor(IOUtil.getColorResource(R.color.white));
        this.btn_one_hour_data.setBackground(IOUtil.getDrawable(R.drawable.shape_rectangle_white_fill));
        this.btn_one_hour_data.setTextColor(IOUtil.getColorResource(R.color.periwinkle2));
    }

    @Override // kr.switcher.switcherm.ui.irbrandgraph.view.IRBrandGraphView
    public void setChartPeriodOneDay() {
        this.btn_one_day_data.setBackground(IOUtil.getDrawable(R.drawable.shape_rectangle_white_fill));
        this.btn_one_day_data.setTextColor(IOUtil.getColorResource(R.color.periwinkle2));
        this.btn_one_hour_data.setBackground(IOUtil.getDrawable(R.drawable.shape_rectangle_white_border));
        this.btn_one_hour_data.setTextColor(IOUtil.getColorResource(R.color.white));
    }

    @Override // kr.switcher.switcherm.ui.irbrandgraph.interactor.FindRecentCommandHistoryInteractor.OnFindTitleListener
    public void onFindTitle(String str) {
        setControllerType(str);
    }

    @OnClick({R.id.btn_back})
    public void onBackButtonClicked() {
        finish();
    }

    @OnClick({R.id.btn_refresh})
    public void onClickRefresh() {
        this.presenter.onClickRefresh();
    }

    @OnClick({R.id.btn_one_day_data})
    public void onClickOneDayDataBtn() {
        this.presenter.onClickOneDayDataBtn();
    }

    @OnClick({R.id.btn_one_hour_data})
    public void onClickOneHourDataBtn() {
        this.presenter.onClickOneHourDataBtn();
    }
}
