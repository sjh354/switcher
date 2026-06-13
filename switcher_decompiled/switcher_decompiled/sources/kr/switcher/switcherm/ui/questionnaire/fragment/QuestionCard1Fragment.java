package kr.switcher.switcherm.ui.questionnaire.fragment;

import android.os.Bundle;
import androidx.cardview.widget.CardView;
import antistatic.spinnerwheel.AbstractWheel;
import butterknife.BindView;
import butterknife.OnClick;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.ui.questionnaire.helper.TimeWheelInitializer;
import kr.switcher.switcherm.ui.questionnaire.pager.QuestionWheelAdapter;
import kr.switcher.switcherm.ui.questionnaire.presenter.QuestionCard1Presenter;
import kr.switcher.switcherm.ui.questionnaire.views.QuestionCard1View;

/* JADX INFO: loaded from: classes2.dex */
public class QuestionCard1Fragment extends CardFragment implements QuestionCard1View {
    private QuestionWheelAdapter ampmAdapter;

    @BindView(R.id.cardview)
    CardView cardview;
    private QuestionWheelAdapter hourAdapter;
    private QuestionWheelAdapter minAdapter;
    private QuestionCard1Presenter presenter;

    @BindView(R.id.wv_ampm)
    AbstractWheel wv_ampm;

    @BindView(R.id.wv_hour)
    AbstractWheel wv_hour;

    @BindView(R.id.wv_min)
    AbstractWheel wv_min;

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.layoutResource = R.layout.fragment_question_card1_adapter;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        QuestionCard1Presenter questionCard1Presenter = new QuestionCard1Presenter(this);
        this.presenter = questionCard1Presenter;
        questionCard1Presenter.initialize();
    }

    @Override // kr.switcher.switcherm.ui.questionnaire.views.QuestionCard1View
    public void initWheel() {
        this.ampmAdapter = TimeWheelInitializer.initAmPm(getContext());
        this.hourAdapter = TimeWheelInitializer.initHour(getContext());
        this.minAdapter = TimeWheelInitializer.initMin(getContext());
        this.wv_ampm.setViewAdapter(this.ampmAdapter);
        this.wv_hour.setViewAdapter(this.hourAdapter);
        this.wv_min.setViewAdapter(this.minAdapter);
        this.presenter.setCurrentPosition(this.data);
    }

    @Override // kr.switcher.switcherm.ui.questionnaire.views.QuestionCard1View
    public void setData(int i, int i2, int i3) {
        this.wv_ampm.setCurrentItem(i);
        this.wv_hour.setCurrentItem(i2);
        this.wv_min.setCurrentItem(i3);
    }

    @Override // kr.switcher.switcherm.ui.questionnaire.views.QuestionCard1View
    public void setDefaultData(int i, int i2, int i3) {
        setData(i, i2, i3);
    }

    @OnClick({R.id.btn_save})
    public void onSaveButtonClicked() {
        this.presenter.onSaveButtonClicked(this.wv_ampm, this.wv_hour, this.wv_min);
    }
}
