package kr.switcher.switcherm.common.chart;

import android.content.Context;
import android.widget.TextView;
import com.github.mikephil.charting.components.MarkerView;
import com.github.mikephil.charting.data.CandleEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import kr.switcher.switcherm.R;

/* JADX INFO: loaded from: classes2.dex */
public class LinkeChartMarkerView extends MarkerView {
    private final TextView tvContent;

    public LinkeChartMarkerView(Context context, int i) {
        super(context, i);
        this.tvContent = (TextView) findViewById(R.id.tvContent);
    }

    @Override // com.github.mikephil.charting.components.MarkerView, com.github.mikephil.charting.components.IMarker
    public void refreshContent(Entry entry, Highlight highlight) {
        if (entry instanceof CandleEntry) {
            this.tvContent.setText(Utils.formatNumber(((CandleEntry) entry).getHigh(), 0, true));
        } else {
            this.tvContent.setText(Utils.formatNumber(entry.getY(), 0, true));
        }
        super.refreshContent(entry, highlight);
    }

    @Override // com.github.mikephil.charting.components.MarkerView, com.github.mikephil.charting.components.IMarker
    public MPPointF getOffset() {
        return new MPPointF(-(getWidth() / 2), -getHeight());
    }
}
