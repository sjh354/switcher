package kr.switcher.switcherm.ui.questionnaire.presenter;

import kr.switcher.switcherm.ui.questionnaire.views.QuestionCard3View;

/* JADX INFO: loaded from: classes2.dex */
public class QuestionCard3Presenter {
    private QuestionCard3View view;

    public QuestionCard3Presenter(QuestionCard3View questionCard3View) {
        this.view = questionCard3View;
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
        this.view.setQuestion3Data(i);
        this.view.moveNextPage(3);
    }
}
