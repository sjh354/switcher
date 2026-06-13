package kr.switcher.switcherm.common.chart;

import android.content.Context;
import android.util.AttributeSet;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IFillFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.interfaces.dataprovider.LineDataProvider;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class IOLineChart extends LineChart {
    public static final float Y_UNDEFINED_VALUE = -1.0f;
    private List<String> xValues;

    private static int getLineColor(int i) {
        if (i == 0) {
            return -1;
        }
        if (i == 1) {
            return InputDeviceCompat.SOURCE_ANY;
        }
        if (i != 2) {
            return ViewCompat.MEASURED_STATE_MASK;
        }
        return -3355444;
    }

    public enum ChartYUnitKinds {
        PERCENTAGE("%"),
        CELSIUS("°C"),
        DEFAULT("");

        private String unit;

        ChartYUnitKinds(String str) {
            this.unit = str;
        }

        public String getValue() {
            return this.unit;
        }
    }

    public IOLineChart(Context context) {
        super(context);
        this.xValues = new ArrayList();
    }

    public IOLineChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.xValues = new ArrayList();
    }

    public IOLineChart(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.xValues = new ArrayList();
    }

    public void initLineChart(float f, float f2, ChartYUnitKinds chartYUnitKinds) {
        this.xValues.clear();
        setViewPortOffsets(0.0f, 0.0f, 0.0f, 0.0f);
        getDescription().setEnabled(false);
        setTouchEnabled(true);
        setDragEnabled(true);
        setScaleEnabled(false);
        setPinchZoom(false);
        setDrawGridBackground(false);
        setMaxHighlightDistance(500.0f);
        configureX();
        configureY(f, f2, chartYUnitKinds);
        getAxisRight().setEnabled(true);
        getLegend().setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        getLegend().setTextColor(-1);
        getLegend().setEnabled(false);
        animateX(1000);
        setData(new ArrayList());
        invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setData(List<IOChartData> list) {
        if (list.size() > 0) {
            this.xValues = list.get(0).getXValues();
        }
        if (getData() != null && ((LineData) getData()).getDataSetCount() == list.size()) {
            for (int i = 0; i < ((LineData) getData()).getDataSetCount(); i++) {
                ((LineDataSet) ((LineData) getData()).getDataSetByIndex(i)).setValues(list.get(i).getValues());
                ((LineData) getData()).notifyDataChanged();
                notifyDataSetChanged();
            }
            return;
        }
        super.setData(getLineDataSets(list));
    }

    private LineData getLineDataSets(List<IOChartData> list) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            IOChartData iOChartData = list.get(i);
            LineDataSet lineDataSet = new LineDataSet(iOChartData.getValues(), iOChartData.getLabel());
            lineDataSet.setMode(LineDataSet.Mode.CUBIC_BEZIER);
            lineDataSet.setCubicIntensity(0.2f);
            lineDataSet.setDrawFilled(true);
            lineDataSet.setDrawCircles(true);
            lineDataSet.setLineWidth(1.8f);
            lineDataSet.setCircleRadius(4.0f);
            lineDataSet.setCircleColor(getLineColor(i));
            lineDataSet.setHighLightColor(getLineColor(i));
            lineDataSet.setColor(getLineColor(i));
            lineDataSet.setFillColor(getLineColor(i));
            lineDataSet.setFillAlpha(40);
            lineDataSet.setAxisDependency(YAxis.AxisDependency.LEFT);
            lineDataSet.setDrawHorizontalHighlightIndicator(false);
            lineDataSet.setFillFormatter(new IFillFormatter() { // from class: kr.switcher.switcherm.common.chart.IOLineChart.1
                @Override // com.github.mikephil.charting.formatter.IFillFormatter
                public float getFillLinePosition(ILineDataSet iLineDataSet, LineDataProvider lineDataProvider) {
                    return IOLineChart.this.getAxisLeft().getAxisMinimum();
                }
            });
            arrayList.add(lineDataSet);
        }
        LineData lineData = new LineData(arrayList);
        lineData.setValueTextSize(9.0f);
        lineData.setDrawValues(false);
        return lineData;
    }

    private YAxis configureY(float f, float f2, final ChartYUnitKinds chartYUnitKinds) {
        ValueFormatter valueFormatter = new ValueFormatter() { // from class: kr.switcher.switcherm.common.chart.IOLineChart.2
            @Override // com.github.mikephil.charting.formatter.ValueFormatter
            public String getFormattedValue(float f3) {
                return chartYUnitKinds.equals(ChartYUnitKinds.PERCENTAGE) ? String.format("%d%s", Integer.valueOf((int) f3), chartYUnitKinds.getValue()) : String.format("%.1f%s", Float.valueOf(f3), chartYUnitKinds.getValue());
            }
        };
        YAxis axisLeft = getAxisLeft();
        axisLeft.setLabelCount(10, false);
        axisLeft.setTextColor(-1);
        axisLeft.setPosition(YAxis.YAxisLabelPosition.INSIDE_CHART);
        axisLeft.setDrawGridLines(false);
        axisLeft.setAxisLineColor(-1);
        axisLeft.setValueFormatter(valueFormatter);
        axisLeft.setGranularityEnabled(true);
        axisLeft.setGranularity(1.0f);
        if (f > -1.0f) {
            axisLeft.setAxisMinimum(f);
        }
        if (f2 > -1.0f) {
            axisLeft.setAxisMaximum(f2);
        }
        return axisLeft;
    }

    private XAxis configureX() {
        ValueFormatter valueFormatter = new ValueFormatter() { // from class: kr.switcher.switcherm.common.chart.IOLineChart.3
            @Override // com.github.mikephil.charting.formatter.ValueFormatter
            public String getFormattedValue(float f) {
                return f < ((float) IOLineChart.this.xValues.size()) ? (String) IOLineChart.this.xValues.get((int) f) : "--:--";
            }
        };
        XAxis xAxis = getXAxis();
        xAxis.setGranularity(1.0f);
        xAxis.setDrawGridLines(false);
        xAxis.setValueFormatter(valueFormatter);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM_INSIDE);
        xAxis.setTextColor(-1);
        return xAxis;
    }
}
