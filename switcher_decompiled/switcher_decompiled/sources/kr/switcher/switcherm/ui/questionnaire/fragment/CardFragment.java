package kr.switcher.switcherm.ui.questionnaire.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.ui.questionnaire.OnSelectItemListener;
import kr.switcher.switcherm.ui.questionnaire.QuestionnaireData;

/* JADX INFO: loaded from: classes2.dex */
public class CardFragment extends Fragment {
    private static final int NEXT_PAGE_DELAY = 200;
    private static final String PARM_SAVE_DATA = "SAVE_DATA";
    public static final int QUESTION1_POSITION = 0;
    public static final int QUESTION2_POSITION = 1;
    public static final int QUESTION3_POSITION = 2;
    public static final int QUESTION4_POSITION = 3;
    public static final int QUESTION5_POSITION = 4;
    protected static OnSelectItemListener listener;

    @BindView(R.id.cardview)
    CardView cardview;
    protected QuestionnaireData data = new QuestionnaireData();
    protected int layoutResource;

    public static CardFragment newInstance(OnSelectItemListener onSelectItemListener, CardFragment cardFragment) {
        listener = onSelectItemListener;
        cardFragment.setArguments(new Bundle());
        return cardFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(this.layoutResource, viewGroup, false);
        ButterKnife.bind(this, viewInflate);
        CardView cardView = this.cardview;
        cardView.setMaxCardElevation(cardView.getCardElevation() * 3.0f);
        return viewInflate;
    }

    public CardView getCardView() {
        return this.cardview;
    }

    public void moveNextPage(final int i) {
        new Handler().postDelayed(new Runnable() { // from class: kr.switcher.switcherm.ui.questionnaire.fragment.CardFragment.1
            @Override // java.lang.Runnable
            public void run() {
                CardFragment.listener.onSelectItem(i);
            }
        }, 200L);
    }

    public void setQuestion1Data(String str, int i, int i2) {
        this.data.setQuestion1Data(new QuestionnaireData.Question1Data(str, i, i2));
    }

    public void setQuestion2Data(String str, int i, int i2) {
        this.data.setQuestion2Data(new QuestionnaireData.Question2Data(str, i, i2));
    }

    public void setQuestion3Data(int i) {
        this.data.setQuestion3Data(new QuestionnaireData.Question3Data(i));
    }

    public void setQuestion4Data(int i) {
        this.data.setQuestion4Data(new QuestionnaireData.Question4Data(i));
    }

    public void setQuestion5Data(String str, int i, int i2) {
        this.data.setQuestion5Data(new QuestionnaireData.Question5Data(str, i, i2));
    }
}
