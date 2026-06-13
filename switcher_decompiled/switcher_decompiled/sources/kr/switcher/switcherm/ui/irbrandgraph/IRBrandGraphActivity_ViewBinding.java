package kr.switcher.switcherm.ui.irbrandgraph;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.chart.IOLineChart;

/* JADX INFO: loaded from: classes2.dex */
public class IRBrandGraphActivity_ViewBinding implements Unbinder {
    private IRBrandGraphActivity target;
    private View view7f090059;
    private View view7f090083;
    private View view7f090084;
    private View view7f09008b;

    public IRBrandGraphActivity_ViewBinding(IRBrandGraphActivity iRBrandGraphActivity) {
        this(iRBrandGraphActivity, iRBrandGraphActivity.getWindow().getDecorView());
    }

    public IRBrandGraphActivity_ViewBinding(final IRBrandGraphActivity iRBrandGraphActivity, View view) {
        this.target = iRBrandGraphActivity;
        iRBrandGraphActivity.lin_top = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.lin_top, "field 'lin_top'", LinearLayout.class);
        iRBrandGraphActivity.chart = (IOLineChart) Utils.findRequiredViewAsType(view, R.id.line_chart, "field 'chart'", IOLineChart.class);
        iRBrandGraphActivity.tv_chart_title = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_chart_title, "field 'tv_chart_title'", TextView.class);
        iRBrandGraphActivity.rv_command_history = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_command_history, "field 'rv_command_history'", RecyclerView.class);
        iRBrandGraphActivity.tv_not_found = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_not_found, "field 'tv_not_found'", TextView.class);
        iRBrandGraphActivity.iv_no_command_list = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_no_command_list, "field 'iv_no_command_list'", ImageView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.btn_one_hour_data, "field 'btn_one_hour_data' and method 'onClickOneHourDataBtn'");
        iRBrandGraphActivity.btn_one_hour_data = (TextView) Utils.castView(viewFindRequiredView, R.id.btn_one_hour_data, "field 'btn_one_hour_data'", TextView.class);
        this.view7f090084 = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.irbrandgraph.IRBrandGraphActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                iRBrandGraphActivity.onClickOneHourDataBtn();
            }
        });
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.btn_one_day_data, "field 'btn_one_day_data' and method 'onClickOneDayDataBtn'");
        iRBrandGraphActivity.btn_one_day_data = (TextView) Utils.castView(viewFindRequiredView2, R.id.btn_one_day_data, "field 'btn_one_day_data'", TextView.class);
        this.view7f090083 = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.irbrandgraph.IRBrandGraphActivity_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                iRBrandGraphActivity.onClickOneDayDataBtn();
            }
        });
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.btn_back, "method 'onBackButtonClicked'");
        this.view7f090059 = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.irbrandgraph.IRBrandGraphActivity_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                iRBrandGraphActivity.onBackButtonClicked();
            }
        });
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.btn_refresh, "method 'onClickRefresh'");
        this.view7f09008b = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.irbrandgraph.IRBrandGraphActivity_ViewBinding.4
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                iRBrandGraphActivity.onClickRefresh();
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        IRBrandGraphActivity iRBrandGraphActivity = this.target;
        if (iRBrandGraphActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        iRBrandGraphActivity.lin_top = null;
        iRBrandGraphActivity.chart = null;
        iRBrandGraphActivity.tv_chart_title = null;
        iRBrandGraphActivity.rv_command_history = null;
        iRBrandGraphActivity.tv_not_found = null;
        iRBrandGraphActivity.iv_no_command_list = null;
        iRBrandGraphActivity.btn_one_hour_data = null;
        iRBrandGraphActivity.btn_one_day_data = null;
        this.view7f090084.setOnClickListener(null);
        this.view7f090084 = null;
        this.view7f090083.setOnClickListener(null);
        this.view7f090083 = null;
        this.view7f090059.setOnClickListener(null);
        this.view7f090059 = null;
        this.view7f09008b.setOnClickListener(null);
        this.view7f09008b = null;
    }
}
