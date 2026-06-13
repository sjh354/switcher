package kr.switcher.switcherm.ui.questionnaire.fragment;

import android.view.View;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import kr.switcher.switcherm.R;

/* JADX INFO: loaded from: classes2.dex */
public class QuestionCard4Fragment_ViewBinding extends CardFragment_ViewBinding {
    private QuestionCard4Fragment target;
    private View view7f09007f;
    private View view7f0900bd;

    public QuestionCard4Fragment_ViewBinding(final QuestionCard4Fragment questionCard4Fragment, View view) {
        super(questionCard4Fragment, view);
        this.target = questionCard4Fragment;
        questionCard4Fragment.cardview = (CardView) Utils.findRequiredViewAsType(view, R.id.cardview, "field 'cardview'", CardView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.btn_yes, "field 'btn_yes' and method 'onYesButtonClicked'");
        questionCard4Fragment.btn_yes = (TextView) Utils.castView(viewFindRequiredView, R.id.btn_yes, "field 'btn_yes'", TextView.class);
        this.view7f0900bd = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.questionnaire.fragment.QuestionCard4Fragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                questionCard4Fragment.onYesButtonClicked();
            }
        });
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.btn_no, "field 'btn_no' and method 'onNoButtonClicked'");
        questionCard4Fragment.btn_no = (TextView) Utils.castView(viewFindRequiredView2, R.id.btn_no, "field 'btn_no'", TextView.class);
        this.view7f09007f = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.questionnaire.fragment.QuestionCard4Fragment_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                questionCard4Fragment.onNoButtonClicked();
            }
        });
    }

    @Override // kr.switcher.switcherm.ui.questionnaire.fragment.CardFragment_ViewBinding, butterknife.Unbinder
    public void unbind() {
        QuestionCard4Fragment questionCard4Fragment = this.target;
        if (questionCard4Fragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        questionCard4Fragment.cardview = null;
        questionCard4Fragment.btn_yes = null;
        questionCard4Fragment.btn_no = null;
        this.view7f0900bd.setOnClickListener(null);
        this.view7f0900bd = null;
        this.view7f09007f.setOnClickListener(null);
        this.view7f09007f = null;
        super.unbind();
    }
}
