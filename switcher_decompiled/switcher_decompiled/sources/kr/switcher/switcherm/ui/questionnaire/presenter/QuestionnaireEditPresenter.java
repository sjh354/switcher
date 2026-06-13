package kr.switcher.switcherm.ui.questionnaire.presenter;

import androidx.viewpager.widget.ViewPager;
import kr.switcher.switcherm.ui.questionnaire.QuestionnaireData;
import kr.switcher.switcherm.ui.questionnaire.fragment.CardFragment;
import kr.switcher.switcherm.ui.questionnaire.fragment.QuestionCard1Fragment;
import kr.switcher.switcherm.ui.questionnaire.fragment.QuestionCard2Fragment;
import kr.switcher.switcherm.ui.questionnaire.fragment.QuestionCard3Fragment;
import kr.switcher.switcherm.ui.questionnaire.fragment.QuestionCard4Fragment;
import kr.switcher.switcherm.ui.questionnaire.fragment.QuestionCard5Fragment;
import kr.switcher.switcherm.ui.questionnaire.views.QuestionnaireEditView;

/* JADX INFO: loaded from: classes2.dex */
public class QuestionnaireEditPresenter {
    private QuestionnaireEditView view;

    public QuestionnaireEditPresenter(QuestionnaireEditView questionnaireEditView) {
        this.view = questionnaireEditView;
    }

    public void initialize(int i) {
        this.view.trackEditForGA();
        setViewPager(i);
        this.view.setPagerListener();
    }

    private void setViewPager(int i) {
        CardFragment questionCard1Fragment;
        if (i == 0) {
            questionCard1Fragment = new QuestionCard1Fragment();
        } else if (i == 1) {
            questionCard1Fragment = new QuestionCard2Fragment();
        } else if (i == 2) {
            questionCard1Fragment = new QuestionCard3Fragment();
        } else if (i == 3) {
            questionCard1Fragment = new QuestionCard4Fragment();
        } else {
            questionCard1Fragment = i != 4 ? null : new QuestionCard5Fragment();
        }
        if (questionCard1Fragment == null) {
            return;
        }
        this.view.initViewPager(questionCard1Fragment);
    }

    public ViewPager.OnPageChangeListener onPageChangeListener() {
        return new ViewPager.OnPageChangeListener() { // from class: kr.switcher.switcherm.ui.questionnaire.presenter.QuestionnaireEditPresenter.1
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                QuestionnaireEditPresenter.this.selectItem(i);
            }
        };
    }

    public void selectItem(int i) {
        if (new QuestionnaireData().isFull()) {
            this.view.finishFragment();
        } else {
            this.view.setCurrentItem(i);
        }
    }
}
