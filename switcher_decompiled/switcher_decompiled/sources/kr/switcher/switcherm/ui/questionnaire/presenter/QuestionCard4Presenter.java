package kr.switcher.switcherm.ui.questionnaire.presenter;

import kr.switcher.switcherm.ui.questionnaire.views.QuestionCard4View;

/* JADX INFO: loaded from: classes2.dex */
public class QuestionCard4Presenter {
    private QuestionCard4View view;

    public QuestionCard4Presenter(QuestionCard4View questionCard4View) {
        this.view = questionCard4View;
    }

    public void initialize() {
        this.view.unSelectAll();
    }

    public void onYesButtonClicked() {
        select(1);
    }

    public void onNoButtonClicked() {
        select(2);
    }

    private void select(int i) {
        if (i == 1) {
            this.view.selectYes();
        } else {
            this.view.selectNo();
        }
        this.view.setQuestion4Data(i);
        this.view.moveNextPage(4);
    }
}
