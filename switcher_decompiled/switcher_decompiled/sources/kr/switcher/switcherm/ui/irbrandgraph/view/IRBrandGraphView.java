package kr.switcher.switcherm.ui.irbrandgraph.view;

import java.util.List;
import kr.switcher.switcherm.common.chart.IOChartData;
import kr.switcher.switcherm.common.chart.IOLineChart;
import kr.switcher.switcherm.ui.irbrandgraph.adapter.CommandHistoryItem;
import kr.switcher.switcherm.ui.irbrandgraph.interactor.helper.MinMax;

/* JADX INFO: loaded from: classes2.dex */
public interface IRBrandGraphView {
    void initChart(MinMax minMax, IOLineChart.ChartYUnitKinds chartYUnitKinds);

    void initRecyclerListView();

    void setChartDatas(List<IOChartData> list);

    void setChartPeriodOneDay();

    void setChartPeriodOneHour();

    void setCommandHistoryItems(List<CommandHistoryItem> list);

    void setControllerType(String str);

    void showNotFoundView();
}
