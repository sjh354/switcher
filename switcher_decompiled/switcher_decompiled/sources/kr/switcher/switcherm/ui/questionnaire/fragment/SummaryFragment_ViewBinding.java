package kr.switcher.switcherm.ui.questionnaire.fragment;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import kr.switcher.switcherm.R;

/* JADX INFO: loaded from: classes2.dex */
public class SummaryFragment_ViewBinding implements Unbinder {
    private SummaryFragment target;
    private View view7f090052;
    private View view7f090053;
    private View view7f090054;
    private View view7f090055;
    private View view7f090056;
    private View view7f090057;

    public SummaryFragment_ViewBinding(final SummaryFragment summaryFragment, View view) {
        this.target = summaryFragment;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.btn_answer1, "field 'btn_answer1' and method 'onClickAnswer1ButtonClicked'");
        summaryFragment.btn_answer1 = (TextView) Utils.castView(viewFindRequiredView, R.id.btn_answer1, "field 'btn_answer1'", TextView.class);
        this.view7f090053 = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.questionnaire.fragment.SummaryFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                summaryFragment.onClickAnswer1ButtonClicked();
            }
        });
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.btn_answer2, "field 'btn_answer2' and method 'onClickAnswer2ButtonClicked'");
        summaryFragment.btn_answer2 = (TextView) Utils.castView(viewFindRequiredView2, R.id.btn_answer2, "field 'btn_answer2'", TextView.class);
        this.view7f090054 = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.questionnaire.fragment.SummaryFragment_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                summaryFragment.onClickAnswer2ButtonClicked();
            }
        });
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.btn_answer3, "field 'btn_answer3' and method 'onClickAnswer3ButtonClicked'");
        summaryFragment.btn_answer3 = (TextView) Utils.castView(viewFindRequiredView3, R.id.btn_answer3, "field 'btn_answer3'", TextView.class);
        this.view7f090055 = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.questionnaire.fragment.SummaryFragment_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                summaryFragment.onClickAnswer3ButtonClicked();
            }
        });
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.btn_answer4, "field 'btn_answer4' and method 'onClickAnswer4ButtonClicked'");
        summaryFragment.btn_answer4 = (TextView) Utils.castView(viewFindRequiredView4, R.id.btn_answer4, "field 'btn_answer4'", TextView.class);
        this.view7f090056 = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.questionnaire.fragment.SummaryFragment_ViewBinding.4
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                summaryFragment.onClickAnswer4ButtonClicked();
            }
        });
        View viewFindRequiredView5 = Utils.findRequiredView(view, R.id.btn_answer5, "field 'btn_answer5' and method 'onClickAnswer5ButtonClicked'");
        summaryFragment.btn_answer5 = (TextView) Utils.castView(viewFindRequiredView5, R.id.btn_answer5, "field 'btn_answer5'", TextView.class);
        this.view7f090057 = viewFindRequiredView5;
        viewFindRequiredView5.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.questionnaire.fragment.SummaryFragment_ViewBinding.5
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                summaryFragment.onClickAnswer5ButtonClicked();
            }
        });
        View viewFindRequiredView6 = Utils.findRequiredView(view, R.id.btn_analysis, "method 'onAnalysisButtonClicked'");
        this.view7f090052 = viewFindRequiredView6;
        viewFindRequiredView6.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.questionnaire.fragment.SummaryFragment_ViewBinding.6
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                summaryFragment.onAnalysisButtonClicked();
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        SummaryFragment summaryFragment = this.target;
        if (summaryFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        summaryFragment.btn_answer1 = null;
        summaryFragment.btn_answer2 = null;
        summaryFragment.btn_answer3 = null;
        summaryFragment.btn_answer4 = null;
        summaryFragment.btn_answer5 = null;
        this.view7f090053.setOnClickListener(null);
        this.view7f090053 = null;
        this.view7f090054.setOnClickListener(null);
        this.view7f090054 = null;
        this.view7f090055.setOnClickListener(null);
        this.view7f090055 = null;
        this.view7f090056.setOnClickListener(null);
        this.view7f090056 = null;
        this.view7f090057.setOnClickListener(null);
        this.view7f090057 = null;
        this.view7f090052.setOnClickListener(null);
        this.view7f090052 = null;
    }
}
