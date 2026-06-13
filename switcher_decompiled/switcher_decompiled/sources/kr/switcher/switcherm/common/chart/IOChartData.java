package kr.switcher.switcherm.common.chart;

import com.github.mikephil.charting.data.Entry;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class IOChartData {
    private String label;
    private List<Entry> values = new ArrayList();
    private List<String> xValues;
    private List<Float> yValues;

    public IOChartData(String str, List<String> list, List<Float> list2) {
        this.label = str;
        this.xValues = list;
        this.yValues = list2;
        for (int i = 0; i < list.size(); i++) {
            this.values.add(new Entry(i, list2.get(i).floatValue()));
        }
    }

    public String getLabel() {
        return this.label;
    }

    public List<Entry> getValues() {
        return this.values;
    }

    public List<String> getXValues() {
        return this.xValues;
    }

    public List<Float> getYValues() {
        return this.yValues;
    }
}
