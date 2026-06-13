package kr.switcher.switcherm.ui.questionnaire.fragment;

import android.view.View;
import androidx.cardview.widget.CardView;
import antistatic.spinnerwheel.AbstractWheel;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import kr.switcher.switcherm.R;

/* JADX INFO: loaded from: classes2.dex */
public class QuestionCard5Fragment_ViewBinding extends CardFragment_ViewBinding {
    private QuestionCard5Fragment target;
    private View view7f090095;

    public QuestionCard5Fragment_ViewBinding(final QuestionCard5Fragment questionCard5Fragment, View view) {
        super(questionCard5Fragment, view);
        this.target = questionCard5Fragment;
        questionCard5Fragment.cardview = (CardView) Utils.findRequiredViewAsType(view, R.id.cardview, "field 'cardview'", CardView.class);
        questionCard5Fragment.wv_ampm = (AbstractWheel) Utils.findRequiredViewAsType(view, R.id.wv_ampm, "field 'wv_ampm'", AbstractWheel.class);
        questionCard5Fragment.wv_hour = (AbstractWheel) Utils.findRequiredViewAsType(view, R.id.wv_hour, "field 'wv_hour'", AbstractWheel.class);
        questionCard5Fragment.wv_min = (AbstractWheel) Utils.findRequiredViewAsType(view, R.id.wv_min, "field 'wv_min'", AbstractWheel.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.btn_save, "method 'onSaveButtonClicked'");
        this.view7f090095 = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.questionnaire.fragment.QuestionCard5Fragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                questionCard5Fragment.onSaveButtonClicked();
            }
        });
    }

    @Override // kr.switcher.switcherm.ui.questionnaire.fragment.CardFragment_ViewBinding, butterknife.Unbinder
    public void unbind() {
        QuestionCard5Fragment questionCard5Fragment = this.target;
        if (questionCard5Fragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        questionCard5Fragment.cardview = null;
        questionCard5Fragment.wv_ampm = null;
        questionCard5Fragment.wv_hour = null;
        questionCard5Fragment.wv_min = null;
        this.view7f090095.setOnClickListener(null);
        this.view7f090095 = null;
        super.unbind();
    }
}
