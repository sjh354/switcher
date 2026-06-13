package kr.switcher.switcherm.ui.irbrandgraph.presenter;

import java.util.List;
import kr.switcher.switcherm.common.chart.IOLineChart;
import kr.switcher.switcherm.ui.irbrandgraph.adapter.CommandHistoryItem;
import kr.switcher.switcherm.ui.irbrandgraph.interactor.FindRecentCommandHistoryInteractor;
import kr.switcher.switcherm.ui.irbrandgraph.interactor.helper.MinMax;
import kr.switcher.switcherm.ui.irbrandgraph.interactor.helper.SensorChartData;
import kr.switcher.switcherm.ui.irbrandgraph.view.IRBrandGraphView;

/* JADX INFO: loaded from: classes2.dex */
public class IRBrandGraphPresenter implements FindRecentCommandHistoryInteractor.OnFindRecentCommandHistoryListener {
    private FindRecentCommandHistoryInteractor interactor;
    private IRBrandGraphView view;

    public IRBrandGraphPresenter(IRBrandGraphView iRBrandGraphView, FindRecentCommandHistoryInteractor findRecentCommandHistoryInteractor) {
        this.view = iRBrandGraphView;
        this.interactor = findRecentCommandHistoryInteractor;
    }

    public void onCreate() {
        this.view.initChart(new MinMax(), IOLineChart.ChartYUnitKinds.DEFAULT);
        this.view.initRecyclerListView();
        this.view.setChartPeriodOneHour();
    }

    public void onClickRefresh() {
        this.interactor.findRecentSensorHistory(this);
        this.interactor.findRecentCommandHistory(this);
        this.view.initChart(new MinMax(), IOLineChart.ChartYUnitKinds.DEFAULT);
        this.view.initRecyclerListView();
    }

    public void onResume() {
        this.interactor.findRecentSensorHistory(this);
        this.interactor.findRecentCommandHistory(this);
    }

    @Override // kr.switcher.switcherm.ui.irbrandgraph.interactor.FindRecentCommandHistoryInteractor.OnFindRecentCommandHistoryListener
    public void onFindCommands(List<CommandHistoryItem> list) {
        if (list.size() > 0) {
            this.view.setCommandHistoryItems(list);
        } else {
            this.view.showNotFoundView();
        }
    }

    @Override // kr.switcher.switcherm.ui.irbrandgraph.interactor.FindRecentCommandHistoryInteractor.OnFindRecentCommandHistoryListener
    public void onFindSensors(SensorChartData sensorChartData) {
        this.view.initChart(sensorChartData.getyMinMax(), sensorChartData.getChartYUnitKinds());
        this.view.setChartDatas(sensorChartData.getDatas());
    }

    public void onClickOneDayDataBtn() {
        this.view.setChartPeriodOneDay();
        getPastOneDaySensorDate();
    }

    public void onClickOneHourDataBtn() {
        this.view.setChartPeriodOneHour();
        getPastOneHourSensorData();
    }

    public void getPastOneHourSensorData() {
        this.interactor.findRecentSensorHistory(this);
        this.interactor.findRecentCommandHistory(this);
        this.view.initChart(new MinMax(), IOLineChart.ChartYUnitKinds.DEFAULT);
        this.view.initRecyclerListView();
    }

    public void getPastOneDaySensorDate() {
        this.interactor.findPastOneDayCommandHistory(this);
        this.interactor.findPastOneDaySensorHistory(this);
        this.view.initChart(new MinMax(), IOLineChart.ChartYUnitKinds.DEFAULT);
        this.view.initRecyclerListView();
    }
}
