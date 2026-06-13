package kr.switcher.switcherm.ui.questionnaire.presenter;

import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.ConverterUtil;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.ui.questionnaire.QuestionnaireData;
import kr.switcher.switcherm.ui.questionnaire.views.SummaryView;

/* JADX INFO: loaded from: classes2.dex */
public class SummaryPresenter {
    private SummaryView view;

    public SummaryPresenter(SummaryView summaryView) {
        this.view = summaryView;
    }

    public void initialize() {
        this.view.trackSummaryForGA();
        setAnswerData();
    }

    private void setAnswerData() {
        QuestionnaireData questionnaireData = new QuestionnaireData();
        QuestionnaireData.Question1Data question1Data = questionnaireData.getQuestion1Data();
        QuestionnaireData.Question2Data question2Data = questionnaireData.getQuestion2Data();
        QuestionnaireData.Question3Data question3Data = questionnaireData.getQuestion3Data();
        QuestionnaireData.Question4Data question4Data = questionnaireData.getQuestion4Data();
        QuestionnaireData.Question5Data question5Data = questionnaireData.getQuestion5Data();
        if (question1Data != null) {
            this.view.setAnswer1Text(ConverterUtil.getTimeKorean(question1Data.getAmpm(), question1Data.getHour(), question1Data.getMin()));
        }
        if (question2Data != null) {
            this.view.setAnswer2Text(ConverterUtil.getTimeKorean(question2Data.getAmpm(), question2Data.getHour(), question2Data.getMin()));
        }
        if (question3Data != null) {
            if (question3Data.getYn() == 1) {
                this.view.setAnswer3Text(IOUtil.getStringResource(R.string.answer3_yes));
            } else if (question3Data.getYn() == 2) {
                this.view.setAnswer3Text(IOUtil.getStringResource(R.string.answer3_no));
            }
        }
        if (question4Data != null) {
            if (question4Data.getYn() == 1) {
                this.view.setAnswer4Text(IOUtil.getStringResource(R.string.answer4_yes));
            } else if (question4Data.getYn() == 2) {
                this.view.setAnswer4Text(IOUtil.getStringResource(R.string.answer4_no));
            }
        }
        if (question5Data != null) {
            this.view.setAnswer5Text(ConverterUtil.getTimeKorean(question5Data.getAmpm(), question5Data.getHour(), question5Data.getMin()));
        }
    }

    public void onAnalysisButtonClicked() {
        this.view.moveAnalysisFragment();
    }

    public void onClickAnswer1ButtonClicked() {
        this.view.moveQuestionEditFragment(0);
    }

    public void onClickAnswer2ButtonClicked() {
        this.view.moveQuestionEditFragment(1);
    }

    public void onClickAnswer3ButtonClicked() {
        this.view.moveQuestionEditFragment(2);
    }

    public void onClickAnswer4ButtonClicked() {
        this.view.moveQuestionEditFragment(3);
    }

    public void onClickAnswer5ButtonClicked() {
        this.view.moveQuestionEditFragment(4);
    }
}
