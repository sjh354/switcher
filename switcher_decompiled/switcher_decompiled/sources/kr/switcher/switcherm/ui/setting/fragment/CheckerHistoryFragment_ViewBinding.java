package kr.switcher.switcherm.ui.setting.fragment;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.wang.avi.AVLoadingIndicatorView;
import kr.switcher.switcherm.R;

/* JADX INFO: loaded from: classes2.dex */
public class CheckerHistoryFragment_ViewBinding implements Unbinder {
    private CheckerHistoryFragment target;
    private View view7f0901ea;
    private View view7f0901fd;
    private View view7f0901fe;

    public CheckerHistoryFragment_ViewBinding(final CheckerHistoryFragment checkerHistoryFragment, View view) {
        this.target = checkerHistoryFragment;
        checkerHistoryFragment.rv_checker_history = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_checker_history, "field 'rv_checker_history'", RecyclerView.class);
        checkerHistoryFragment.ll_no_search_history = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_no_search_history, "field 'll_no_search_history'", LinearLayout.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.rl_one_week, "field 'rl_one_week' and method 'onOneWeekBtnClicked'");
        checkerHistoryFragment.rl_one_week = (RelativeLayout) Utils.castView(viewFindRequiredView, R.id.rl_one_week, "field 'rl_one_week'", RelativeLayout.class);
        this.view7f0901fe = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.setting.fragment.CheckerHistoryFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                checkerHistoryFragment.onOneWeekBtnClicked();
            }
        });
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.rl_one_month, "field 'rl_one_month' and method 'onOneMonthBtnClicked'");
        checkerHistoryFragment.rl_one_month = (RelativeLayout) Utils.castView(viewFindRequiredView2, R.id.rl_one_month, "field 'rl_one_month'", RelativeLayout.class);
        this.view7f0901fd = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.setting.fragment.CheckerHistoryFragment_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                checkerHistoryFragment.onOneMonthBtnClicked();
            }
        });
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.rl_half_year, "field 'rl_half_year' and method 'onHalfYearBtnClicked'");
        checkerHistoryFragment.rl_half_year = (RelativeLayout) Utils.castView(viewFindRequiredView3, R.id.rl_half_year, "field 'rl_half_year'", RelativeLayout.class);
        this.view7f0901ea = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.setting.fragment.CheckerHistoryFragment_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                checkerHistoryFragment.onHalfYearBtnClicked();
            }
        });
        checkerHistoryFragment.tv_one_week = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_one_week, "field 'tv_one_week'", TextView.class);
        checkerHistoryFragment.tv_one_month = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_one_month, "field 'tv_one_month'", TextView.class);
        checkerHistoryFragment.tv_half_year = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_half_year, "field 'tv_half_year'", TextView.class);
        checkerHistoryFragment.pb_searching = (AVLoadingIndicatorView) Utils.findRequiredViewAsType(view, R.id.pb_searching, "field 'pb_searching'", AVLoadingIndicatorView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        CheckerHistoryFragment checkerHistoryFragment = this.target;
        if (checkerHistoryFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        checkerHistoryFragment.rv_checker_history = null;
        checkerHistoryFragment.ll_no_search_history = null;
        checkerHistoryFragment.rl_one_week = null;
        checkerHistoryFragment.rl_one_month = null;
        checkerHistoryFragment.rl_half_year = null;
        checkerHistoryFragment.tv_one_week = null;
        checkerHistoryFragment.tv_one_month = null;
        checkerHistoryFragment.tv_half_year = null;
        checkerHistoryFragment.pb_searching = null;
        this.view7f0901fe.setOnClickListener(null);
        this.view7f0901fe = null;
        this.view7f0901fd.setOnClickListener(null);
        this.view7f0901fd = null;
        this.view7f0901ea.setOnClickListener(null);
        this.view7f0901ea = null;
    }
}
