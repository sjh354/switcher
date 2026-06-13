package kr.switcher.switcherm.ui.questionnaire.fragment;

import android.view.View;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.ui.questionnaire.indicator.QuestionnaireIndicator;

/* JADX INFO: loaded from: classes2.dex */
public class QuestionnaireFragment_ViewBinding implements Unbinder {
    private QuestionnaireFragment target;
    private View view7f090099;

    public QuestionnaireFragment_ViewBinding(final QuestionnaireFragment questionnaireFragment, View view) {
        this.target = questionnaireFragment;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.btn_submit, "field 'btn_submit' and method 'onSubmitButtonClicked'");
        questionnaireFragment.btn_submit = (TextView) Utils.castView(viewFindRequiredView, R.id.btn_submit, "field 'btn_submit'", TextView.class);
        this.view7f090099 = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.questionnaire.fragment.QuestionnaireFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                questionnaireFragment.onSubmitButtonClicked();
            }
        });
        questionnaireFragment.indicator = (QuestionnaireIndicator) Utils.findRequiredViewAsType(view, R.id.indicator, "field 'indicator'", QuestionnaireIndicator.class);
        questionnaireFragment.viewpager = (ViewPager) Utils.findRequiredViewAsType(view, R.id.viewpager, "field 'viewpager'", ViewPager.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        QuestionnaireFragment questionnaireFragment = this.target;
        if (questionnaireFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        questionnaireFragment.btn_submit = null;
        questionnaireFragment.indicator = null;
        questionnaireFragment.viewpager = null;
        this.view7f090099.setOnClickListener(null);
        this.view7f090099 = null;
    }
}
