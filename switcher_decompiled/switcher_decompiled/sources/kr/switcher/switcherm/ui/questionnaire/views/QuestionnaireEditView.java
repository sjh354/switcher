package kr.switcher.switcherm.ui.questionnaire.views;

import kr.switcher.switcherm.ui.questionnaire.fragment.CardFragment;

/* JADX INFO: loaded from: classes2.dex */
public interface QuestionnaireEditView {
    void finishFragment();

    void initViewPager(CardFragment cardFragment);

    void setCurrentItem(int i);

    void setPagerListener();

    void trackEditForGA();
}
