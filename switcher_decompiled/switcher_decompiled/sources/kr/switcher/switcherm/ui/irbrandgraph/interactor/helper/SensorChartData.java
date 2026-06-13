package kr.switcher.switcherm.ui.irbrandgraph.interactor.helper;

import java.util.List;
import kr.switcher.switcherm.common.chart.IOChartData;
import kr.switcher.switcherm.common.chart.IOLineChart;

/* JADX INFO: loaded from: classes2.dex */
public class SensorChartData {
    List<IOChartData> datas;
    IOLineChart.ChartYUnitKinds unitKinds;
    MinMax yMinMax;

    public SensorChartData(List<IOChartData> list, MinMax minMax, IOLineChart.ChartYUnitKinds chartYUnitKinds) {
        this.datas = list;
        this.yMinMax = minMax;
        this.unitKinds = chartYUnitKinds;
    }

    public List<IOChartData> getDatas() {
        return this.datas;
    }

    public MinMax getyMinMax() {
        return this.yMinMax;
    }

    public IOLineChart.ChartYUnitKinds getChartYUnitKinds() {
        return this.unitKinds;
    }
}
