package kr.switcher.switcherm.ui.questionnaire.fragment;

import android.view.View;
import antistatic.spinnerwheel.AbstractWheel;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import kr.switcher.switcherm.R;

/* JADX INFO: loaded from: classes2.dex */
public class QuestionCard2Fragment_ViewBinding extends CardFragment_ViewBinding {
    private QuestionCard2Fragment target;
    private View view7f090095;

    public QuestionCard2Fragment_ViewBinding(final QuestionCard2Fragment questionCard2Fragment, View view) {
        super(questionCard2Fragment, view);
        this.target = questionCard2Fragment;
        questionCard2Fragment.wv_ampm = (AbstractWheel) Utils.findRequiredViewAsType(view, R.id.wv_ampm, "field 'wv_ampm'", AbstractWheel.class);
        questionCard2Fragment.wv_hour = (AbstractWheel) Utils.findRequiredViewAsType(view, R.id.wv_hour, "field 'wv_hour'", AbstractWheel.class);
        questionCard2Fragment.wv_min = (AbstractWheel) Utils.findRequiredViewAsType(view, R.id.wv_min, "field 'wv_min'", AbstractWheel.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.btn_save, "method 'onSaveButtonClicked'");
        this.view7f090095 = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.questionnaire.fragment.QuestionCard2Fragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                questionCard2Fragment.onSaveButtonClicked();
            }
        });
    }

    @Override // kr.switcher.switcherm.ui.questionnaire.fragment.CardFragment_ViewBinding, butterknife.Unbinder
    public void unbind() {
        QuestionCard2Fragment questionCard2Fragment = this.target;
        if (questionCard2Fragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        questionCard2Fragment.wv_ampm = null;
        questionCard2Fragment.wv_hour = null;
        questionCard2Fragment.wv_min = null;
        this.view7f090095.setOnClickListener(null);
        this.view7f090095 = null;
        super.unbind();
    }
}
