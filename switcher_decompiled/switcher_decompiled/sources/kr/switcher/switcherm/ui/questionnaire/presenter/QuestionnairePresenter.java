package kr.switcher.switcherm.ui.questionnaire.presenter;

import androidx.viewpager.widget.ViewPager;
import kr.switcher.switcherm.ui.questionnaire.views.QuestionnaireView;

/* JADX INFO: loaded from: classes2.dex */
public class QuestionnairePresenter {
    private QuestionnaireView view;

    public QuestionnairePresenter(QuestionnaireView questionnaireView) {
        this.view = questionnaireView;
    }

    public void initialize() {
        this.view.trackQuestionnaireForGA();
        this.view.inactiveSubmit();
        this.view.initViewPager();
        this.view.setPagerListener();
        this.view.startTimer();
    }

    public void onPause() {
        this.view.cancelTimer();
    }

    public ViewPager.OnPageChangeListener onPageChangeListener() {
        return new ViewPager.OnPageChangeListener() { // from class: kr.switcher.switcherm.ui.questionnaire.presenter.QuestionnairePresenter.1
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                QuestionnairePresenter.this.selectItem(i);
            }
        };
    }

    public void selectItem(int i) {
        this.view.setCurrentItem(i);
    }

    public void onSubmitButtonClicked(boolean z) {
        if (z) {
            this.view.finishFragment();
        }
    }

    public void full() {
        this.view.activeSubmit();
    }
}
