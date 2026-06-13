package kr.switcher.switcherm.ui.questionnaire;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import kr.switcher.switcherm.R;

/* JADX INFO: loaded from: classes2.dex */
public class QuestionnaireActivity_ViewBinding implements Unbinder {
    private QuestionnaireActivity target;
    private View view7f090060;

    public QuestionnaireActivity_ViewBinding(QuestionnaireActivity questionnaireActivity) {
        this(questionnaireActivity, questionnaireActivity.getWindow().getDecorView());
    }

    public QuestionnaireActivity_ViewBinding(final QuestionnaireActivity questionnaireActivity, View view) {
        this.target = questionnaireActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.btn_cancel, "method 'onCancelButtonClicked'");
        this.view7f090060 = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.questionnaire.QuestionnaireActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                questionnaireActivity.onCancelButtonClicked();
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        if (this.target == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        this.view7f090060.setOnClickListener(null);
        this.view7f090060 = null;
    }
}
