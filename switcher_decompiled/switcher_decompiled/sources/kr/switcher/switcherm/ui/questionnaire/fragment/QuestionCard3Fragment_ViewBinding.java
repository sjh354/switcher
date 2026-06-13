package kr.switcher.switcherm.ui.questionnaire.fragment;

import android.view.View;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import kr.switcher.switcherm.R;

/* JADX INFO: loaded from: classes2.dex */
public class QuestionCard3Fragment_ViewBinding extends CardFragment_ViewBinding {
    private QuestionCard3Fragment target;
    private View view7f09007f;
    private View view7f0900bd;

    public QuestionCard3Fragment_ViewBinding(final QuestionCard3Fragment questionCard3Fragment, View view) {
        super(questionCard3Fragment, view);
        this.target = questionCard3Fragment;
        questionCard3Fragment.cardview = (CardView) Utils.findRequiredViewAsType(view, R.id.cardview, "field 'cardview'", CardView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.btn_yes, "field 'btn_yes' and method 'onYesButtonClicked'");
        questionCard3Fragment.btn_yes = (TextView) Utils.castView(viewFindRequiredView, R.id.btn_yes, "field 'btn_yes'", TextView.class);
        this.view7f0900bd = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.questionnaire.fragment.QuestionCard3Fragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                questionCard3Fragment.onYesButtonClicked();
            }
        });
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.btn_no, "field 'btn_no' and method 'onNoButtonClicked'");
        questionCard3Fragment.btn_no = (TextView) Utils.castView(viewFindRequiredView2, R.id.btn_no, "field 'btn_no'", TextView.class);
        this.view7f09007f = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.questionnaire.fragment.QuestionCard3Fragment_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                questionCard3Fragment.onNoButtonClicked();
            }
        });
    }

    @Override // kr.switcher.switcherm.ui.questionnaire.fragment.CardFragment_ViewBinding, butterknife.Unbinder
    public void unbind() {
        QuestionCard3Fragment questionCard3Fragment = this.target;
        if (questionCard3Fragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        questionCard3Fragment.cardview = null;
        questionCard3Fragment.btn_yes = null;
        questionCard3Fragment.btn_no = null;
        this.view7f0900bd.setOnClickListener(null);
        this.view7f0900bd = null;
        this.view7f09007f.setOnClickListener(null);
        this.view7f09007f = null;
        super.unbind();
    }
}
