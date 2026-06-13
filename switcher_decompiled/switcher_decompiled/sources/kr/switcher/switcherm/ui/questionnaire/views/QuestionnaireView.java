package kr.switcher.switcherm.ui.questionnaire.views;

/* JADX INFO: loaded from: classes2.dex */
public interface QuestionnaireView {
    void activeSubmit();

    void cancelTimer();

    void finishFragment();

    void inactiveSubmit();

    void initViewPager();

    void setCurrentItem(int i);

    void setPagerListener();

    void startTimer();

    void trackQuestionnaireForGA();
}
